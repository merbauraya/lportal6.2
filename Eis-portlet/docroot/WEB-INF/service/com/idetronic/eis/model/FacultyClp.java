/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.eis.model;

import com.idetronic.eis.service.ClpSerializer;
import com.idetronic.eis.service.FacultyLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class FacultyClp extends BaseModelImpl<Faculty> implements Faculty {
	public FacultyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Faculty.class;
	}

	@Override
	public String getModelClassName() {
		return Faculty.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _facultyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacultyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facultyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facultyId", getFacultyId());
		attributes.put("facultyTypeId", getFacultyTypeId());
		attributes.put("facultyName", getFacultyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		Long facultyTypeId = (Long)attributes.get("facultyTypeId");

		if (facultyTypeId != null) {
			setFacultyTypeId(facultyTypeId);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}
	}

	@Override
	public long getFacultyId() {
		return _facultyId;
	}

	@Override
	public void setFacultyId(long facultyId) {
		_facultyId = facultyId;

		if (_facultyRemoteModel != null) {
			try {
				Class<?> clazz = _facultyRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyId", long.class);

				method.invoke(_facultyRemoteModel, facultyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacultyTypeId() {
		return _facultyTypeId;
	}

	@Override
	public void setFacultyTypeId(long facultyTypeId) {
		_facultyTypeId = facultyTypeId;

		if (_facultyRemoteModel != null) {
			try {
				Class<?> clazz = _facultyRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyTypeId", long.class);

				method.invoke(_facultyRemoteModel, facultyTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacultyName() {
		return _facultyName;
	}

	@Override
	public void setFacultyName(String facultyName) {
		_facultyName = facultyName;

		if (_facultyRemoteModel != null) {
			try {
				Class<?> clazz = _facultyRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyName", String.class);

				method.invoke(_facultyRemoteModel, facultyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFacultyRemoteModel() {
		return _facultyRemoteModel;
	}

	public void setFacultyRemoteModel(BaseModel<?> facultyRemoteModel) {
		_facultyRemoteModel = facultyRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _facultyRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_facultyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FacultyLocalServiceUtil.addFaculty(this);
		}
		else {
			FacultyLocalServiceUtil.updateFaculty(this);
		}
	}

	@Override
	public Faculty toEscapedModel() {
		return (Faculty)ProxyUtil.newProxyInstance(Faculty.class.getClassLoader(),
			new Class[] { Faculty.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FacultyClp clone = new FacultyClp();

		clone.setFacultyId(getFacultyId());
		clone.setFacultyTypeId(getFacultyTypeId());
		clone.setFacultyName(getFacultyName());

		return clone;
	}

	@Override
	public int compareTo(Faculty faculty) {
		long primaryKey = faculty.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacultyClp)) {
			return false;
		}

		FacultyClp faculty = (FacultyClp)obj;

		long primaryKey = faculty.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{facultyId=");
		sb.append(getFacultyId());
		sb.append(", facultyTypeId=");
		sb.append(getFacultyTypeId());
		sb.append(", facultyName=");
		sb.append(getFacultyName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Faculty");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>facultyId</column-name><column-value><![CDATA[");
		sb.append(getFacultyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyTypeId</column-name><column-value><![CDATA[");
		sb.append(getFacultyTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyName</column-name><column-value><![CDATA[");
		sb.append(getFacultyName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _facultyId;
	private long _facultyTypeId;
	private String _facultyName;
	private BaseModel<?> _facultyRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
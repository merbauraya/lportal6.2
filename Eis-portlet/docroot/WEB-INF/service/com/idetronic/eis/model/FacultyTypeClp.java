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
import com.idetronic.eis.service.FacultyTypeLocalServiceUtil;

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
public class FacultyTypeClp extends BaseModelImpl<FacultyType>
	implements FacultyType {
	public FacultyTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FacultyType.class;
	}

	@Override
	public String getModelClassName() {
		return FacultyType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _facultyTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacultyTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facultyTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facultyTypeId", getFacultyTypeId());
		attributes.put("facultyTypeName", getFacultyTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facultyTypeId = (Long)attributes.get("facultyTypeId");

		if (facultyTypeId != null) {
			setFacultyTypeId(facultyTypeId);
		}

		String facultyTypeName = (String)attributes.get("facultyTypeName");

		if (facultyTypeName != null) {
			setFacultyTypeName(facultyTypeName);
		}
	}

	@Override
	public long getFacultyTypeId() {
		return _facultyTypeId;
	}

	@Override
	public void setFacultyTypeId(long facultyTypeId) {
		_facultyTypeId = facultyTypeId;

		if (_facultyTypeRemoteModel != null) {
			try {
				Class<?> clazz = _facultyTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyTypeId", long.class);

				method.invoke(_facultyTypeRemoteModel, facultyTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacultyTypeName() {
		return _facultyTypeName;
	}

	@Override
	public void setFacultyTypeName(String facultyTypeName) {
		_facultyTypeName = facultyTypeName;

		if (_facultyTypeRemoteModel != null) {
			try {
				Class<?> clazz = _facultyTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyTypeName",
						String.class);

				method.invoke(_facultyTypeRemoteModel, facultyTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFacultyTypeRemoteModel() {
		return _facultyTypeRemoteModel;
	}

	public void setFacultyTypeRemoteModel(BaseModel<?> facultyTypeRemoteModel) {
		_facultyTypeRemoteModel = facultyTypeRemoteModel;
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

		Class<?> remoteModelClass = _facultyTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_facultyTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FacultyTypeLocalServiceUtil.addFacultyType(this);
		}
		else {
			FacultyTypeLocalServiceUtil.updateFacultyType(this);
		}
	}

	@Override
	public FacultyType toEscapedModel() {
		return (FacultyType)ProxyUtil.newProxyInstance(FacultyType.class.getClassLoader(),
			new Class[] { FacultyType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FacultyTypeClp clone = new FacultyTypeClp();

		clone.setFacultyTypeId(getFacultyTypeId());
		clone.setFacultyTypeName(getFacultyTypeName());

		return clone;
	}

	@Override
	public int compareTo(FacultyType facultyType) {
		long primaryKey = facultyType.getPrimaryKey();

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

		if (!(obj instanceof FacultyTypeClp)) {
			return false;
		}

		FacultyTypeClp facultyType = (FacultyTypeClp)obj;

		long primaryKey = facultyType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{facultyTypeId=");
		sb.append(getFacultyTypeId());
		sb.append(", facultyTypeName=");
		sb.append(getFacultyTypeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FacultyType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>facultyTypeId</column-name><column-value><![CDATA[");
		sb.append(getFacultyTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyTypeName</column-name><column-value><![CDATA[");
		sb.append(getFacultyTypeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _facultyTypeId;
	private String _facultyTypeName;
	private BaseModel<?> _facultyTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
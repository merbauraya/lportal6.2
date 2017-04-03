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
import com.idetronic.eis.service.LibraryTypeLocalServiceUtil;

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
public class LibraryTypeClp extends BaseModelImpl<LibraryType>
	implements LibraryType {
	public LibraryTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LibraryType.class;
	}

	@Override
	public String getModelClassName() {
		return LibraryType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _libraryTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLibraryTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _libraryTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("libraryTypeCode", getLibraryTypeCode());
		attributes.put("libraryTypeName", getLibraryTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String libraryTypeCode = (String)attributes.get("libraryTypeCode");

		if (libraryTypeCode != null) {
			setLibraryTypeCode(libraryTypeCode);
		}

		String libraryTypeName = (String)attributes.get("libraryTypeName");

		if (libraryTypeName != null) {
			setLibraryTypeName(libraryTypeName);
		}
	}

	@Override
	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;

		if (_libraryTypeRemoteModel != null) {
			try {
				Class<?> clazz = _libraryTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_libraryTypeRemoteModel, libraryTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryTypeCode() {
		return _libraryTypeCode;
	}

	@Override
	public void setLibraryTypeCode(String libraryTypeCode) {
		_libraryTypeCode = libraryTypeCode;

		if (_libraryTypeRemoteModel != null) {
			try {
				Class<?> clazz = _libraryTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeCode",
						String.class);

				method.invoke(_libraryTypeRemoteModel, libraryTypeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryTypeName() {
		return _libraryTypeName;
	}

	@Override
	public void setLibraryTypeName(String libraryTypeName) {
		_libraryTypeName = libraryTypeName;

		if (_libraryTypeRemoteModel != null) {
			try {
				Class<?> clazz = _libraryTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeName",
						String.class);

				method.invoke(_libraryTypeRemoteModel, libraryTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLibraryTypeRemoteModel() {
		return _libraryTypeRemoteModel;
	}

	public void setLibraryTypeRemoteModel(BaseModel<?> libraryTypeRemoteModel) {
		_libraryTypeRemoteModel = libraryTypeRemoteModel;
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

		Class<?> remoteModelClass = _libraryTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_libraryTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LibraryTypeLocalServiceUtil.addLibraryType(this);
		}
		else {
			LibraryTypeLocalServiceUtil.updateLibraryType(this);
		}
	}

	@Override
	public LibraryType toEscapedModel() {
		return (LibraryType)ProxyUtil.newProxyInstance(LibraryType.class.getClassLoader(),
			new Class[] { LibraryType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LibraryTypeClp clone = new LibraryTypeClp();

		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setLibraryTypeCode(getLibraryTypeCode());
		clone.setLibraryTypeName(getLibraryTypeName());

		return clone;
	}

	@Override
	public int compareTo(LibraryType libraryType) {
		long primaryKey = libraryType.getPrimaryKey();

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

		if (!(obj instanceof LibraryTypeClp)) {
			return false;
		}

		LibraryTypeClp libraryType = (LibraryTypeClp)obj;

		long primaryKey = libraryType.getPrimaryKey();

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

		sb.append("{libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", libraryTypeCode=");
		sb.append(getLibraryTypeCode());
		sb.append(", libraryTypeName=");
		sb.append(getLibraryTypeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.LibraryType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>libraryTypeId</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryTypeCode</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryTypeName</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _libraryTypeId;
	private String _libraryTypeCode;
	private String _libraryTypeName;
	private BaseModel<?> _libraryTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
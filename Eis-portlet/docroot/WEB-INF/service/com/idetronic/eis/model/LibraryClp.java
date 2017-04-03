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
import com.idetronic.eis.service.LibraryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class LibraryClp extends BaseModelImpl<Library> implements Library {
	public LibraryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Library.class;
	}

	@Override
	public String getModelClassName() {
		return Library.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _libraryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLibraryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _libraryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryId", getLibraryId());
		attributes.put("libraryCode", getLibraryCode());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("stateName", getStateName());
		attributes.put("libraryName", getLibraryName());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String libraryCode = (String)attributes.get("libraryCode");

		if (libraryCode != null) {
			setLibraryCode(libraryCode);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		String libraryName = (String)attributes.get("libraryName");

		if (libraryName != null) {
			setLibraryName(libraryName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_libraryRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryCode() {
		return _libraryCode;
	}

	@Override
	public void setLibraryCode(String libraryCode) {
		_libraryCode = libraryCode;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryCode", String.class);

				method.invoke(_libraryRemoteModel, libraryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_libraryRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_libraryRemoteModel, libraryTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateName() {
		return _stateName;
	}

	@Override
	public void setStateName(String stateName) {
		_stateName = stateName;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setStateName", String.class);

				method.invoke(_libraryRemoteModel, stateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryName() {
		return _libraryName;
	}

	@Override
	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryName", String.class);

				method.invoke(_libraryRemoteModel, libraryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_libraryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_libraryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_libraryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_libraryRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_libraryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_libraryRemoteModel != null) {
			try {
				Class<?> clazz = _libraryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_libraryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLibraryRemoteModel() {
		return _libraryRemoteModel;
	}

	public void setLibraryRemoteModel(BaseModel<?> libraryRemoteModel) {
		_libraryRemoteModel = libraryRemoteModel;
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

		Class<?> remoteModelClass = _libraryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_libraryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LibraryLocalServiceUtil.addLibrary(this);
		}
		else {
			LibraryLocalServiceUtil.updateLibrary(this);
		}
	}

	@Override
	public Library toEscapedModel() {
		return (Library)ProxyUtil.newProxyInstance(Library.class.getClassLoader(),
			new Class[] { Library.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LibraryClp clone = new LibraryClp();

		clone.setLibraryId(getLibraryId());
		clone.setLibraryCode(getLibraryCode());
		clone.setStateId(getStateId());
		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setStateName(getStateName());
		clone.setLibraryName(getLibraryName());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Library library) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), library.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LibraryClp)) {
			return false;
		}

		LibraryClp library = (LibraryClp)obj;

		long primaryKey = library.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{libraryId=");
		sb.append(getLibraryId());
		sb.append(", libraryCode=");
		sb.append(getLibraryCode());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", stateName=");
		sb.append(getStateName());
		sb.append(", libraryName=");
		sb.append(getLibraryName());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Library");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryCode</column-name><column-value><![CDATA[");
		sb.append(getLibraryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryTypeId</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateName</column-name><column-value><![CDATA[");
		sb.append(getStateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryName</column-name><column-value><![CDATA[");
		sb.append(getLibraryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _libraryId;
	private String _libraryCode;
	private long _stateId;
	private long _libraryTypeId;
	private String _stateName;
	private String _libraryName;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _libraryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
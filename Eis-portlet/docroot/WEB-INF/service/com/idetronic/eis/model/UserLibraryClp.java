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
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class UserLibraryClp extends BaseModelImpl<UserLibrary>
	implements UserLibrary {
	public UserLibraryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserLibrary.class;
	}

	@Override
	public String getModelClassName() {
		return UserLibrary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userLibraryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserLibraryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userLibraryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userLibraryId", getUserLibraryId());
		attributes.put("userId", getUserId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userLibraryId = (Long)attributes.get("userLibraryId");

		if (userLibraryId != null) {
			setUserLibraryId(userLibraryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
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
	public long getUserLibraryId() {
		return _userLibraryId;
	}

	@Override
	public void setUserLibraryId(long userLibraryId) {
		_userLibraryId = userLibraryId;

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserLibraryId", long.class);

				method.invoke(_userLibraryRemoteModel, userLibraryId);
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

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userLibraryRemoteModel, userId);
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
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_userLibraryRemoteModel, libraryId);
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

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_userLibraryRemoteModel, companyId);
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

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_userLibraryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_userLibraryRemoteModel, createdByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreatedByUserId(), "uuid",
			_createdByUserUuid);
	}

	@Override
	public void setCreatedByUserUuid(String createdByUserUuid) {
		_createdByUserUuid = createdByUserUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_userLibraryRemoteModel, userName);
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

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_userLibraryRemoteModel, createDate);
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

		if (_userLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _userLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_userLibraryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserLibraryRemoteModel() {
		return _userLibraryRemoteModel;
	}

	public void setUserLibraryRemoteModel(BaseModel<?> userLibraryRemoteModel) {
		_userLibraryRemoteModel = userLibraryRemoteModel;
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

		Class<?> remoteModelClass = _userLibraryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userLibraryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserLibraryLocalServiceUtil.addUserLibrary(this);
		}
		else {
			UserLibraryLocalServiceUtil.updateUserLibrary(this);
		}
	}

	@Override
	public UserLibrary toEscapedModel() {
		return (UserLibrary)ProxyUtil.newProxyInstance(UserLibrary.class.getClassLoader(),
			new Class[] { UserLibrary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserLibraryClp clone = new UserLibraryClp();

		clone.setUserLibraryId(getUserLibraryId());
		clone.setUserId(getUserId());
		clone.setLibraryId(getLibraryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(UserLibrary userLibrary) {
		long primaryKey = userLibrary.getPrimaryKey();

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

		if (!(obj instanceof UserLibraryClp)) {
			return false;
		}

		UserLibraryClp userLibrary = (UserLibraryClp)obj;

		long primaryKey = userLibrary.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{userLibraryId=");
		sb.append(getUserLibraryId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createdByUserId=");
		sb.append(getCreatedByUserId());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.UserLibrary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userLibraryId</column-name><column-value><![CDATA[");
		sb.append(getUserLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
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
			"<column><column-name>createdByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserId());
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

	private long _userLibraryId;
	private long _userId;
	private String _userUuid;
	private long _libraryId;
	private long _companyId;
	private long _groupId;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _userLibraryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
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
import com.idetronic.eis.service.SeatingCategoryLocalServiceUtil;

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
public class SeatingCategoryClp extends BaseModelImpl<SeatingCategory>
	implements SeatingCategory {
	public SeatingCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SeatingCategory.class;
	}

	@Override
	public String getModelClassName() {
		return SeatingCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _seatingCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSeatingCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _seatingCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seatingCategoryId", getSeatingCategoryId());
		attributes.put("seatingCategoryName", getSeatingCategoryName());
		attributes.put("seatingDepartmentId", getSeatingDepartmentId());
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
		Long seatingCategoryId = (Long)attributes.get("seatingCategoryId");

		if (seatingCategoryId != null) {
			setSeatingCategoryId(seatingCategoryId);
		}

		String seatingCategoryName = (String)attributes.get(
				"seatingCategoryName");

		if (seatingCategoryName != null) {
			setSeatingCategoryName(seatingCategoryName);
		}

		Long seatingDepartmentId = (Long)attributes.get("seatingDepartmentId");

		if (seatingDepartmentId != null) {
			setSeatingDepartmentId(seatingDepartmentId);
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
	public long getSeatingCategoryId() {
		return _seatingCategoryId;
	}

	@Override
	public void setSeatingCategoryId(long seatingCategoryId) {
		_seatingCategoryId = seatingCategoryId;

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatingCategoryId",
						long.class);

				method.invoke(_seatingCategoryRemoteModel, seatingCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeatingCategoryName() {
		return _seatingCategoryName;
	}

	@Override
	public void setSeatingCategoryName(String seatingCategoryName) {
		_seatingCategoryName = seatingCategoryName;

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatingCategoryName",
						String.class);

				method.invoke(_seatingCategoryRemoteModel, seatingCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeatingDepartmentId() {
		return _seatingDepartmentId;
	}

	@Override
	public void setSeatingDepartmentId(long seatingDepartmentId) {
		_seatingDepartmentId = seatingDepartmentId;

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatingDepartmentId",
						long.class);

				method.invoke(_seatingCategoryRemoteModel, seatingDepartmentId);
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

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_seatingCategoryRemoteModel, companyId);
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

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_seatingCategoryRemoteModel, groupId);
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

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_seatingCategoryRemoteModel, userId);
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

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_seatingCategoryRemoteModel, userName);
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

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_seatingCategoryRemoteModel, createDate);
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

		if (_seatingCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _seatingCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_seatingCategoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSeatingCategoryRemoteModel() {
		return _seatingCategoryRemoteModel;
	}

	public void setSeatingCategoryRemoteModel(
		BaseModel<?> seatingCategoryRemoteModel) {
		_seatingCategoryRemoteModel = seatingCategoryRemoteModel;
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

		Class<?> remoteModelClass = _seatingCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_seatingCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SeatingCategoryLocalServiceUtil.addSeatingCategory(this);
		}
		else {
			SeatingCategoryLocalServiceUtil.updateSeatingCategory(this);
		}
	}

	@Override
	public SeatingCategory toEscapedModel() {
		return (SeatingCategory)ProxyUtil.newProxyInstance(SeatingCategory.class.getClassLoader(),
			new Class[] { SeatingCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SeatingCategoryClp clone = new SeatingCategoryClp();

		clone.setSeatingCategoryId(getSeatingCategoryId());
		clone.setSeatingCategoryName(getSeatingCategoryName());
		clone.setSeatingDepartmentId(getSeatingDepartmentId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SeatingCategory seatingCategory) {
		long primaryKey = seatingCategory.getPrimaryKey();

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

		if (!(obj instanceof SeatingCategoryClp)) {
			return false;
		}

		SeatingCategoryClp seatingCategory = (SeatingCategoryClp)obj;

		long primaryKey = seatingCategory.getPrimaryKey();

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

		sb.append("{seatingCategoryId=");
		sb.append(getSeatingCategoryId());
		sb.append(", seatingCategoryName=");
		sb.append(getSeatingCategoryName());
		sb.append(", seatingDepartmentId=");
		sb.append(getSeatingDepartmentId());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.SeatingCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>seatingCategoryId</column-name><column-value><![CDATA[");
		sb.append(getSeatingCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seatingCategoryName</column-name><column-value><![CDATA[");
		sb.append(getSeatingCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seatingDepartmentId</column-name><column-value><![CDATA[");
		sb.append(getSeatingDepartmentId());
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

	private long _seatingCategoryId;
	private String _seatingCategoryName;
	private long _seatingDepartmentId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _seatingCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
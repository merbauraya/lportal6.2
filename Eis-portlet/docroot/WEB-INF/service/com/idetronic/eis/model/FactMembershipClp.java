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
import com.idetronic.eis.service.FactMembershipLocalServiceUtil;

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
public class FactMembershipClp extends BaseModelImpl<FactMembership>
	implements FactMembership {
	public FactMembershipClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactMembership.class;
	}

	@Override
	public String getModelClassName() {
		return FactMembership.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factMembershipId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactMembershipId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factMembershipId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factMembershipId", getFactMembershipId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("membershipCategoryId", getMembershipCategoryId());
		attributes.put("activeCount", getActiveCount());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factMembershipId = (Long)attributes.get("factMembershipId");

		if (factMembershipId != null) {
			setFactMembershipId(factMembershipId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Long membershipCategoryId = (Long)attributes.get("membershipCategoryId");

		if (membershipCategoryId != null) {
			setMembershipCategoryId(membershipCategoryId);
		}

		Integer activeCount = (Integer)attributes.get("activeCount");

		if (activeCount != null) {
			setActiveCount(activeCount);
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
	}

	@Override
	public long getFactMembershipId() {
		return _factMembershipId;
	}

	@Override
	public void setFactMembershipId(long factMembershipId) {
		_factMembershipId = factMembershipId;

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setFactMembershipId",
						long.class);

				method.invoke(_factMembershipRemoteModel, factMembershipId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factMembershipRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPeriod() {
		return _period;
	}

	@Override
	public void setPeriod(String period) {
		_period = period;

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factMembershipRemoteModel, period);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_factMembershipRemoteModel, stateId);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_factMembershipRemoteModel, libraryTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMembershipCategoryId() {
		return _membershipCategoryId;
	}

	@Override
	public void setMembershipCategoryId(long membershipCategoryId) {
		_membershipCategoryId = membershipCategoryId;

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setMembershipCategoryId",
						long.class);

				method.invoke(_factMembershipRemoteModel, membershipCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getActiveCount() {
		return _activeCount;
	}

	@Override
	public void setActiveCount(int activeCount) {
		_activeCount = activeCount;

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveCount", int.class);

				method.invoke(_factMembershipRemoteModel, activeCount);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factMembershipRemoteModel, companyId);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factMembershipRemoteModel, groupId);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factMembershipRemoteModel, userId);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factMembershipRemoteModel, userName);
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

		if (_factMembershipRemoteModel != null) {
			try {
				Class<?> clazz = _factMembershipRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factMembershipRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactMembershipRemoteModel() {
		return _factMembershipRemoteModel;
	}

	public void setFactMembershipRemoteModel(
		BaseModel<?> factMembershipRemoteModel) {
		_factMembershipRemoteModel = factMembershipRemoteModel;
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

		Class<?> remoteModelClass = _factMembershipRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factMembershipRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactMembershipLocalServiceUtil.addFactMembership(this);
		}
		else {
			FactMembershipLocalServiceUtil.updateFactMembership(this);
		}
	}

	@Override
	public FactMembership toEscapedModel() {
		return (FactMembership)ProxyUtil.newProxyInstance(FactMembership.class.getClassLoader(),
			new Class[] { FactMembership.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactMembershipClp clone = new FactMembershipClp();

		clone.setFactMembershipId(getFactMembershipId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setStateId(getStateId());
		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setMembershipCategoryId(getMembershipCategoryId());
		clone.setActiveCount(getActiveCount());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactMembership factMembership) {
		long primaryKey = factMembership.getPrimaryKey();

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

		if (!(obj instanceof FactMembershipClp)) {
			return false;
		}

		FactMembershipClp factMembership = (FactMembershipClp)obj;

		long primaryKey = factMembership.getPrimaryKey();

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

		sb.append("{factMembershipId=");
		sb.append(getFactMembershipId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", membershipCategoryId=");
		sb.append(getMembershipCategoryId());
		sb.append(", activeCount=");
		sb.append(getActiveCount());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactMembership");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factMembershipId</column-name><column-value><![CDATA[");
		sb.append(getFactMembershipId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
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
			"<column><column-name>membershipCategoryId</column-name><column-value><![CDATA[");
		sb.append(getMembershipCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeCount</column-name><column-value><![CDATA[");
		sb.append(getActiveCount());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _factMembershipId;
	private long _libraryId;
	private String _period;
	private long _stateId;
	private long _libraryTypeId;
	private long _membershipCategoryId;
	private int _activeCount;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factMembershipRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
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
import com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil;

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
public class FactDatabaseUsageClp extends BaseModelImpl<FactDatabaseUsage>
	implements FactDatabaseUsage {
	public FactDatabaseUsageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactDatabaseUsage.class;
	}

	@Override
	public String getModelClassName() {
		return FactDatabaseUsage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("downloadTotal", getDownloadTotal());
		attributes.put("sessionTotal", getSessionTotal());
		attributes.put("searchTotal", getSearchTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factId = (Long)attributes.get("factId");

		if (factId != null) {
			setFactId(factId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long downloadTotal = (Long)attributes.get("downloadTotal");

		if (downloadTotal != null) {
			setDownloadTotal(downloadTotal);
		}

		Long sessionTotal = (Long)attributes.get("sessionTotal");

		if (sessionTotal != null) {
			setSessionTotal(sessionTotal);
		}

		Long searchTotal = (Long)attributes.get("searchTotal");

		if (searchTotal != null) {
			setSearchTotal(searchTotal);
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
	public long getFactId() {
		return _factId;
	}

	@Override
	public void setFactId(long factId) {
		_factId = factId;

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setFactId", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, factId);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, libraryId);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factDatabaseUsageRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDownloadTotal() {
		return _downloadTotal;
	}

	@Override
	public void setDownloadTotal(long downloadTotal) {
		_downloadTotal = downloadTotal;

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setDownloadTotal", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, downloadTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSessionTotal() {
		return _sessionTotal;
	}

	@Override
	public void setSessionTotal(long sessionTotal) {
		_sessionTotal = sessionTotal;

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setSessionTotal", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, sessionTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSearchTotal() {
		return _searchTotal;
	}

	@Override
	public void setSearchTotal(long searchTotal) {
		_searchTotal = searchTotal;

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchTotal", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, searchTotal);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, companyId);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, groupId);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factDatabaseUsageRemoteModel, userId);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factDatabaseUsageRemoteModel, userName);
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

		if (_factDatabaseUsageRemoteModel != null) {
			try {
				Class<?> clazz = _factDatabaseUsageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factDatabaseUsageRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactDatabaseUsageRemoteModel() {
		return _factDatabaseUsageRemoteModel;
	}

	public void setFactDatabaseUsageRemoteModel(
		BaseModel<?> factDatabaseUsageRemoteModel) {
		_factDatabaseUsageRemoteModel = factDatabaseUsageRemoteModel;
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

		Class<?> remoteModelClass = _factDatabaseUsageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factDatabaseUsageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactDatabaseUsageLocalServiceUtil.addFactDatabaseUsage(this);
		}
		else {
			FactDatabaseUsageLocalServiceUtil.updateFactDatabaseUsage(this);
		}
	}

	@Override
	public FactDatabaseUsage toEscapedModel() {
		return (FactDatabaseUsage)ProxyUtil.newProxyInstance(FactDatabaseUsage.class.getClassLoader(),
			new Class[] { FactDatabaseUsage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactDatabaseUsageClp clone = new FactDatabaseUsageClp();

		clone.setFactId(getFactId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setItemId(getItemId());
		clone.setDownloadTotal(getDownloadTotal());
		clone.setSessionTotal(getSessionTotal());
		clone.setSearchTotal(getSearchTotal());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactDatabaseUsage factDatabaseUsage) {
		long primaryKey = factDatabaseUsage.getPrimaryKey();

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

		if (!(obj instanceof FactDatabaseUsageClp)) {
			return false;
		}

		FactDatabaseUsageClp factDatabaseUsage = (FactDatabaseUsageClp)obj;

		long primaryKey = factDatabaseUsage.getPrimaryKey();

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

		sb.append("{factId=");
		sb.append(getFactId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", downloadTotal=");
		sb.append(getDownloadTotal());
		sb.append(", sessionTotal=");
		sb.append(getSessionTotal());
		sb.append(", searchTotal=");
		sb.append(getSearchTotal());
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
		sb.append("com.idetronic.eis.model.FactDatabaseUsage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factId</column-name><column-value><![CDATA[");
		sb.append(getFactId());
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
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadTotal</column-name><column-value><![CDATA[");
		sb.append(getDownloadTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionTotal</column-name><column-value><![CDATA[");
		sb.append(getSessionTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchTotal</column-name><column-value><![CDATA[");
		sb.append(getSearchTotal());
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

	private long _factId;
	private long _libraryId;
	private String _period;
	private long _itemId;
	private long _downloadTotal;
	private long _sessionTotal;
	private long _searchTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factDatabaseUsageRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
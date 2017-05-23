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
import com.idetronic.eis.service.FactConsultationLocalServiceUtil;

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
public class FactConsultationClp extends BaseModelImpl<FactConsultation>
	implements FactConsultation {
	public FactConsultationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactConsultation.class;
	}

	@Override
	public String getModelClassName() {
		return FactConsultation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factConsultationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactConsultationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factConsultationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factConsultationId", getFactConsultationId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("consultationGroupId", getConsultationGroupId());
		attributes.put("consultationCategoryId", getConsultationCategoryId());
		attributes.put("value", getValue());
		attributes.put("totalSession", getTotalSession());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factConsultationId = (Long)attributes.get("factConsultationId");

		if (factConsultationId != null) {
			setFactConsultationId(factConsultationId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long consultationGroupId = (Long)attributes.get("consultationGroupId");

		if (consultationGroupId != null) {
			setConsultationGroupId(consultationGroupId);
		}

		Long consultationCategoryId = (Long)attributes.get(
				"consultationCategoryId");

		if (consultationCategoryId != null) {
			setConsultationCategoryId(consultationCategoryId);
		}

		Long value = (Long)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Long totalSession = (Long)attributes.get("totalSession");

		if (totalSession != null) {
			setTotalSession(totalSession);
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
	public long getFactConsultationId() {
		return _factConsultationId;
	}

	@Override
	public void setFactConsultationId(long factConsultationId) {
		_factConsultationId = factConsultationId;

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setFactConsultationId",
						long.class);

				method.invoke(_factConsultationRemoteModel, factConsultationId);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factConsultationRemoteModel, libraryId);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factConsultationRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConsultationGroupId() {
		return _consultationGroupId;
	}

	@Override
	public void setConsultationGroupId(long consultationGroupId) {
		_consultationGroupId = consultationGroupId;

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setConsultationGroupId",
						long.class);

				method.invoke(_factConsultationRemoteModel, consultationGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConsultationCategoryId() {
		return _consultationCategoryId;
	}

	@Override
	public void setConsultationCategoryId(long consultationCategoryId) {
		_consultationCategoryId = consultationCategoryId;

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setConsultationCategoryId",
						long.class);

				method.invoke(_factConsultationRemoteModel,
					consultationCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getValue() {
		return _value;
	}

	@Override
	public void setValue(long value) {
		_value = value;

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", long.class);

				method.invoke(_factConsultationRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTotalSession() {
		return _totalSession;
	}

	@Override
	public void setTotalSession(long totalSession) {
		_totalSession = totalSession;

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalSession", long.class);

				method.invoke(_factConsultationRemoteModel, totalSession);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factConsultationRemoteModel, companyId);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factConsultationRemoteModel, groupId);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factConsultationRemoteModel, userId);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factConsultationRemoteModel, userName);
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

		if (_factConsultationRemoteModel != null) {
			try {
				Class<?> clazz = _factConsultationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factConsultationRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactConsultationRemoteModel() {
		return _factConsultationRemoteModel;
	}

	public void setFactConsultationRemoteModel(
		BaseModel<?> factConsultationRemoteModel) {
		_factConsultationRemoteModel = factConsultationRemoteModel;
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

		Class<?> remoteModelClass = _factConsultationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factConsultationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactConsultationLocalServiceUtil.addFactConsultation(this);
		}
		else {
			FactConsultationLocalServiceUtil.updateFactConsultation(this);
		}
	}

	@Override
	public FactConsultation toEscapedModel() {
		return (FactConsultation)ProxyUtil.newProxyInstance(FactConsultation.class.getClassLoader(),
			new Class[] { FactConsultation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactConsultationClp clone = new FactConsultationClp();

		clone.setFactConsultationId(getFactConsultationId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setConsultationGroupId(getConsultationGroupId());
		clone.setConsultationCategoryId(getConsultationCategoryId());
		clone.setValue(getValue());
		clone.setTotalSession(getTotalSession());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactConsultation factConsultation) {
		long primaryKey = factConsultation.getPrimaryKey();

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

		if (!(obj instanceof FactConsultationClp)) {
			return false;
		}

		FactConsultationClp factConsultation = (FactConsultationClp)obj;

		long primaryKey = factConsultation.getPrimaryKey();

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

		sb.append("{factConsultationId=");
		sb.append(getFactConsultationId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", consultationGroupId=");
		sb.append(getConsultationGroupId());
		sb.append(", consultationCategoryId=");
		sb.append(getConsultationCategoryId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", totalSession=");
		sb.append(getTotalSession());
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
		sb.append("com.idetronic.eis.model.FactConsultation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factConsultationId</column-name><column-value><![CDATA[");
		sb.append(getFactConsultationId());
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
			"<column><column-name>consultationGroupId</column-name><column-value><![CDATA[");
		sb.append(getConsultationGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consultationCategoryId</column-name><column-value><![CDATA[");
		sb.append(getConsultationCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalSession</column-name><column-value><![CDATA[");
		sb.append(getTotalSession());
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

	private long _factConsultationId;
	private long _libraryId;
	private String _period;
	private long _consultationGroupId;
	private long _consultationCategoryId;
	private long _value;
	private long _totalSession;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factConsultationRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
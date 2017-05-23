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
import com.idetronic.eis.service.FactExpenseLocalServiceUtil;

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
public class FactExpenseClp extends BaseModelImpl<FactExpense>
	implements FactExpense {
	public FactExpenseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactExpense.class;
	}

	@Override
	public String getModelClassName() {
		return FactExpense.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factExpenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactExpenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factExpenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factExpenseId", getFactExpenseId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("entryType", getEntryType());
		attributes.put("masterFileId", getMasterFileId());
		attributes.put("amount", getAmount());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factExpenseId = (Long)attributes.get("factExpenseId");

		if (factExpenseId != null) {
			setFactExpenseId(factExpenseId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Integer entryType = (Integer)attributes.get("entryType");

		if (entryType != null) {
			setEntryType(entryType);
		}

		Long masterFileId = (Long)attributes.get("masterFileId");

		if (masterFileId != null) {
			setMasterFileId(masterFileId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
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
	public long getFactExpenseId() {
		return _factExpenseId;
	}

	@Override
	public void setFactExpenseId(long factExpenseId) {
		_factExpenseId = factExpenseId;

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setFactExpenseId", long.class);

				method.invoke(_factExpenseRemoteModel, factExpenseId);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factExpenseRemoteModel, libraryId);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factExpenseRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEntryType() {
		return _entryType;
	}

	@Override
	public void setEntryType(int entryType) {
		_entryType = entryType;

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryType", int.class);

				method.invoke(_factExpenseRemoteModel, entryType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMasterFileId() {
		return _masterFileId;
	}

	@Override
	public void setMasterFileId(long masterFileId) {
		_masterFileId = masterFileId;

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterFileId", long.class);

				method.invoke(_factExpenseRemoteModel, masterFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", double.class);

				method.invoke(_factExpenseRemoteModel, amount);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factExpenseRemoteModel, companyId);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factExpenseRemoteModel, groupId);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factExpenseRemoteModel, userId);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factExpenseRemoteModel, userName);
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

		if (_factExpenseRemoteModel != null) {
			try {
				Class<?> clazz = _factExpenseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factExpenseRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactExpenseRemoteModel() {
		return _factExpenseRemoteModel;
	}

	public void setFactExpenseRemoteModel(BaseModel<?> factExpenseRemoteModel) {
		_factExpenseRemoteModel = factExpenseRemoteModel;
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

		Class<?> remoteModelClass = _factExpenseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factExpenseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactExpenseLocalServiceUtil.addFactExpense(this);
		}
		else {
			FactExpenseLocalServiceUtil.updateFactExpense(this);
		}
	}

	@Override
	public FactExpense toEscapedModel() {
		return (FactExpense)ProxyUtil.newProxyInstance(FactExpense.class.getClassLoader(),
			new Class[] { FactExpense.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactExpenseClp clone = new FactExpenseClp();

		clone.setFactExpenseId(getFactExpenseId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setEntryType(getEntryType());
		clone.setMasterFileId(getMasterFileId());
		clone.setAmount(getAmount());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactExpense factExpense) {
		long primaryKey = factExpense.getPrimaryKey();

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

		if (!(obj instanceof FactExpenseClp)) {
			return false;
		}

		FactExpenseClp factExpense = (FactExpenseClp)obj;

		long primaryKey = factExpense.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{factExpenseId=");
		sb.append(getFactExpenseId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", entryType=");
		sb.append(getEntryType());
		sb.append(", masterFileId=");
		sb.append(getMasterFileId());
		sb.append(", amount=");
		sb.append(getAmount());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactExpense");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factExpenseId</column-name><column-value><![CDATA[");
		sb.append(getFactExpenseId());
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
			"<column><column-name>entryType</column-name><column-value><![CDATA[");
		sb.append(getEntryType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterFileId</column-name><column-value><![CDATA[");
		sb.append(getMasterFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
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

	private long _factExpenseId;
	private long _libraryId;
	private String _period;
	private int _entryType;
	private long _masterFileId;
	private double _amount;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factExpenseRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
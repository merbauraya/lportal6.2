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
import com.idetronic.eis.service.LoanLocalServiceUtil;

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
public class LoanClp extends BaseModelImpl<Loan> implements Loan {
	public LoanClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Loan.class;
	}

	@Override
	public String getModelClassName() {
		return Loan.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _loanEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLoanEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loanEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loanEntryId", getLoanEntryId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("period", getPeriod());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("periodYear", getPeriodYear());
		attributes.put("periodMonth", getPeriodMonth());
		attributes.put("createDate", getCreateDate());
		attributes.put("memberCategoryId", getMemberCategoryId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long loanEntryId = (Long)attributes.get("loanEntryId");

		if (loanEntryId != null) {
			setLoanEntryId(loanEntryId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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

		Integer periodYear = (Integer)attributes.get("periodYear");

		if (periodYear != null) {
			setPeriodYear(periodYear);
		}

		Integer periodMonth = (Integer)attributes.get("periodMonth");

		if (periodMonth != null) {
			setPeriodMonth(periodMonth);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long memberCategoryId = (Long)attributes.get("memberCategoryId");

		if (memberCategoryId != null) {
			setMemberCategoryId(memberCategoryId);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getLoanEntryId() {
		return _loanEntryId;
	}

	@Override
	public void setLoanEntryId(long loanEntryId) {
		_loanEntryId = loanEntryId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setLoanEntryId", long.class);

				method.invoke(_loanRemoteModel, loanEntryId);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_loanRemoteModel, libraryId);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_loanRemoteModel, userId);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_loanRemoteModel, userName);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_loanRemoteModel, period);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_loanRemoteModel, stateId);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_loanRemoteModel, libraryTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPeriodYear() {
		return _periodYear;
	}

	@Override
	public void setPeriodYear(int periodYear) {
		_periodYear = periodYear;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodYear", int.class);

				method.invoke(_loanRemoteModel, periodYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPeriodMonth() {
		return _periodMonth;
	}

	@Override
	public void setPeriodMonth(int periodMonth) {
		_periodMonth = periodMonth;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodMonth", int.class);

				method.invoke(_loanRemoteModel, periodMonth);
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

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_loanRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMemberCategoryId() {
		return _memberCategoryId;
	}

	@Override
	public void setMemberCategoryId(long memberCategoryId) {
		_memberCategoryId = memberCategoryId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberCategoryId",
						long.class);

				method.invoke(_loanRemoteModel, memberCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getValue() {
		return _value;
	}

	@Override
	public void setValue(int value) {
		_value = value;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", int.class);

				method.invoke(_loanRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLoanRemoteModel() {
		return _loanRemoteModel;
	}

	public void setLoanRemoteModel(BaseModel<?> loanRemoteModel) {
		_loanRemoteModel = loanRemoteModel;
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

		Class<?> remoteModelClass = _loanRemoteModel.getClass();

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

		Object returnValue = method.invoke(_loanRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LoanLocalServiceUtil.addLoan(this);
		}
		else {
			LoanLocalServiceUtil.updateLoan(this);
		}
	}

	@Override
	public Loan toEscapedModel() {
		return (Loan)ProxyUtil.newProxyInstance(Loan.class.getClassLoader(),
			new Class[] { Loan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LoanClp clone = new LoanClp();

		clone.setLoanEntryId(getLoanEntryId());
		clone.setLibraryId(getLibraryId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setPeriod(getPeriod());
		clone.setStateId(getStateId());
		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setPeriodYear(getPeriodYear());
		clone.setPeriodMonth(getPeriodMonth());
		clone.setCreateDate(getCreateDate());
		clone.setMemberCategoryId(getMemberCategoryId());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(Loan loan) {
		long primaryKey = loan.getPrimaryKey();

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

		if (!(obj instanceof LoanClp)) {
			return false;
		}

		LoanClp loan = (LoanClp)obj;

		long primaryKey = loan.getPrimaryKey();

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

		sb.append("{loanEntryId=");
		sb.append(getLoanEntryId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", periodYear=");
		sb.append(getPeriodYear());
		sb.append(", periodMonth=");
		sb.append(getPeriodMonth());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", memberCategoryId=");
		sb.append(getMemberCategoryId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Loan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>loanEntryId</column-name><column-value><![CDATA[");
		sb.append(getLoanEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
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
			"<column><column-name>periodYear</column-name><column-value><![CDATA[");
		sb.append(getPeriodYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodMonth</column-name><column-value><![CDATA[");
		sb.append(getPeriodMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberCategoryId</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _loanEntryId;
	private long _libraryId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _period;
	private long _stateId;
	private long _libraryTypeId;
	private int _periodYear;
	private int _periodMonth;
	private Date _createDate;
	private long _memberCategoryId;
	private int _value;
	private BaseModel<?> _loanRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
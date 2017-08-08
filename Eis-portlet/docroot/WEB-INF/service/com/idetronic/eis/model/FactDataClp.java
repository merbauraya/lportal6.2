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
import com.idetronic.eis.service.FactDataLocalServiceUtil;

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
public class FactDataClp extends BaseModelImpl<FactData> implements FactData {
	public FactDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactData.class;
	}

	@Override
	public String getModelClassName() {
		return FactData.class.getName();
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
		attributes.put("reportId", getReportId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("dimensionId", getDimensionId());
		attributes.put("measure1", getMeasure1());
		attributes.put("measure2", getMeasure2());
		attributes.put("measure3", getMeasure3());
		attributes.put("measure4", getMeasure4());
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

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long dimensionId = (Long)attributes.get("dimensionId");

		if (dimensionId != null) {
			setDimensionId(dimensionId);
		}

		Double measure1 = (Double)attributes.get("measure1");

		if (measure1 != null) {
			setMeasure1(measure1);
		}

		Double measure2 = (Double)attributes.get("measure2");

		if (measure2 != null) {
			setMeasure2(measure2);
		}

		Double measure3 = (Double)attributes.get("measure3");

		if (measure3 != null) {
			setMeasure3(measure3);
		}

		Double measure4 = (Double)attributes.get("measure4");

		if (measure4 != null) {
			setMeasure4(measure4);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setFactId", long.class);

				method.invoke(_factDataRemoteModel, factId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_reportId = reportId;

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_factDataRemoteModel, reportId);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factDataRemoteModel, libraryId);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factDataRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDimensionId() {
		return _dimensionId;
	}

	@Override
	public void setDimensionId(long dimensionId) {
		_dimensionId = dimensionId;

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setDimensionId", long.class);

				method.invoke(_factDataRemoteModel, dimensionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMeasure1() {
		return _measure1;
	}

	@Override
	public void setMeasure1(double measure1) {
		_measure1 = measure1;

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure1", double.class);

				method.invoke(_factDataRemoteModel, measure1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMeasure2() {
		return _measure2;
	}

	@Override
	public void setMeasure2(double measure2) {
		_measure2 = measure2;

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure2", double.class);

				method.invoke(_factDataRemoteModel, measure2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMeasure3() {
		return _measure3;
	}

	@Override
	public void setMeasure3(double measure3) {
		_measure3 = measure3;

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure3", double.class);

				method.invoke(_factDataRemoteModel, measure3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMeasure4() {
		return _measure4;
	}

	@Override
	public void setMeasure4(double measure4) {
		_measure4 = measure4;

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure4", double.class);

				method.invoke(_factDataRemoteModel, measure4);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factDataRemoteModel, companyId);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factDataRemoteModel, groupId);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factDataRemoteModel, userId);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factDataRemoteModel, userName);
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

		if (_factDataRemoteModel != null) {
			try {
				Class<?> clazz = _factDataRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factDataRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactDataRemoteModel() {
		return _factDataRemoteModel;
	}

	public void setFactDataRemoteModel(BaseModel<?> factDataRemoteModel) {
		_factDataRemoteModel = factDataRemoteModel;
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

		Class<?> remoteModelClass = _factDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactDataLocalServiceUtil.addFactData(this);
		}
		else {
			FactDataLocalServiceUtil.updateFactData(this);
		}
	}

	@Override
	public FactData toEscapedModel() {
		return (FactData)ProxyUtil.newProxyInstance(FactData.class.getClassLoader(),
			new Class[] { FactData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactDataClp clone = new FactDataClp();

		clone.setFactId(getFactId());
		clone.setReportId(getReportId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setDimensionId(getDimensionId());
		clone.setMeasure1(getMeasure1());
		clone.setMeasure2(getMeasure2());
		clone.setMeasure3(getMeasure3());
		clone.setMeasure4(getMeasure4());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactData factData) {
		long primaryKey = factData.getPrimaryKey();

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

		if (!(obj instanceof FactDataClp)) {
			return false;
		}

		FactDataClp factData = (FactDataClp)obj;

		long primaryKey = factData.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{factId=");
		sb.append(getFactId());
		sb.append(", reportId=");
		sb.append(getReportId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", dimensionId=");
		sb.append(getDimensionId());
		sb.append(", measure1=");
		sb.append(getMeasure1());
		sb.append(", measure2=");
		sb.append(getMeasure2());
		sb.append(", measure3=");
		sb.append(getMeasure3());
		sb.append(", measure4=");
		sb.append(getMeasure4());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factId</column-name><column-value><![CDATA[");
		sb.append(getFactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
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
			"<column><column-name>dimensionId</column-name><column-value><![CDATA[");
		sb.append(getDimensionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure1</column-name><column-value><![CDATA[");
		sb.append(getMeasure1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure2</column-name><column-value><![CDATA[");
		sb.append(getMeasure2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure3</column-name><column-value><![CDATA[");
		sb.append(getMeasure3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure4</column-name><column-value><![CDATA[");
		sb.append(getMeasure4());
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
	private long _reportId;
	private long _libraryId;
	private String _period;
	private long _dimensionId;
	private double _measure1;
	private double _measure2;
	private double _measure3;
	private double _measure4;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factDataRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
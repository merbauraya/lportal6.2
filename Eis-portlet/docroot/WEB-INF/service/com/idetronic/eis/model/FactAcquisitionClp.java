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
import com.idetronic.eis.service.FactAcquisitionLocalServiceUtil;

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
public class FactAcquisitionClp extends BaseModelImpl<FactAcquisition>
	implements FactAcquisition {
	public FactAcquisitionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactAcquisition.class;
	}

	@Override
	public String getModelClassName() {
		return FactAcquisition.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factAcquisitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactAcquisitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factAcquisitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factAcquisitionId", getFactAcquisitionId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("approvedTitleTotal", getApprovedTitleTotal());
		attributes.put("approvedVolumeTotal", getApprovedVolumeTotal());
		attributes.put("approvedAmountTotal", getApprovedAmountTotal());
		attributes.put("orderTitleTotal", getOrderTitleTotal());
		attributes.put("orderVolumeTotal", getOrderVolumeTotal());
		attributes.put("orderAmountTotal", getOrderAmountTotal());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("amountTotal", getAmountTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factAcquisitionId = (Long)attributes.get("factAcquisitionId");

		if (factAcquisitionId != null) {
			setFactAcquisitionId(factAcquisitionId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long approvedTitleTotal = (Long)attributes.get("approvedTitleTotal");

		if (approvedTitleTotal != null) {
			setApprovedTitleTotal(approvedTitleTotal);
		}

		Long approvedVolumeTotal = (Long)attributes.get("approvedVolumeTotal");

		if (approvedVolumeTotal != null) {
			setApprovedVolumeTotal(approvedVolumeTotal);
		}

		Double approvedAmountTotal = (Double)attributes.get(
				"approvedAmountTotal");

		if (approvedAmountTotal != null) {
			setApprovedAmountTotal(approvedAmountTotal);
		}

		Long orderTitleTotal = (Long)attributes.get("orderTitleTotal");

		if (orderTitleTotal != null) {
			setOrderTitleTotal(orderTitleTotal);
		}

		Long orderVolumeTotal = (Long)attributes.get("orderVolumeTotal");

		if (orderVolumeTotal != null) {
			setOrderVolumeTotal(orderVolumeTotal);
		}

		Double orderAmountTotal = (Double)attributes.get("orderAmountTotal");

		if (orderAmountTotal != null) {
			setOrderAmountTotal(orderAmountTotal);
		}

		Long volumeTotal = (Long)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
		}

		Long titleTotal = (Long)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Double amountTotal = (Double)attributes.get("amountTotal");

		if (amountTotal != null) {
			setAmountTotal(amountTotal);
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
	public long getFactAcquisitionId() {
		return _factAcquisitionId;
	}

	@Override
	public void setFactAcquisitionId(long factAcquisitionId) {
		_factAcquisitionId = factAcquisitionId;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setFactAcquisitionId",
						long.class);

				method.invoke(_factAcquisitionRemoteModel, factAcquisitionId);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factAcquisitionRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacultyId() {
		return _facultyId;
	}

	@Override
	public void setFacultyId(long facultyId) {
		_facultyId = facultyId;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyId", long.class);

				method.invoke(_factAcquisitionRemoteModel, facultyId);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factAcquisitionRemoteModel, period);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_factAcquisitionRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApprovedTitleTotal() {
		return _approvedTitleTotal;
	}

	@Override
	public void setApprovedTitleTotal(long approvedTitleTotal) {
		_approvedTitleTotal = approvedTitleTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovedTitleTotal",
						long.class);

				method.invoke(_factAcquisitionRemoteModel, approvedTitleTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApprovedVolumeTotal() {
		return _approvedVolumeTotal;
	}

	@Override
	public void setApprovedVolumeTotal(long approvedVolumeTotal) {
		_approvedVolumeTotal = approvedVolumeTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovedVolumeTotal",
						long.class);

				method.invoke(_factAcquisitionRemoteModel, approvedVolumeTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getApprovedAmountTotal() {
		return _approvedAmountTotal;
	}

	@Override
	public void setApprovedAmountTotal(double approvedAmountTotal) {
		_approvedAmountTotal = approvedAmountTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovedAmountTotal",
						double.class);

				method.invoke(_factAcquisitionRemoteModel, approvedAmountTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrderTitleTotal() {
		return _orderTitleTotal;
	}

	@Override
	public void setOrderTitleTotal(long orderTitleTotal) {
		_orderTitleTotal = orderTitleTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderTitleTotal", long.class);

				method.invoke(_factAcquisitionRemoteModel, orderTitleTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrderVolumeTotal() {
		return _orderVolumeTotal;
	}

	@Override
	public void setOrderVolumeTotal(long orderVolumeTotal) {
		_orderVolumeTotal = orderVolumeTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderVolumeTotal",
						long.class);

				method.invoke(_factAcquisitionRemoteModel, orderVolumeTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getOrderAmountTotal() {
		return _orderAmountTotal;
	}

	@Override
	public void setOrderAmountTotal(double orderAmountTotal) {
		_orderAmountTotal = orderAmountTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderAmountTotal",
						double.class);

				method.invoke(_factAcquisitionRemoteModel, orderAmountTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVolumeTotal() {
		return _volumeTotal;
	}

	@Override
	public void setVolumeTotal(long volumeTotal) {
		_volumeTotal = volumeTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setVolumeTotal", long.class);

				method.invoke(_factAcquisitionRemoteModel, volumeTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTitleTotal() {
		return _titleTotal;
	}

	@Override
	public void setTitleTotal(long titleTotal) {
		_titleTotal = titleTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleTotal", long.class);

				method.invoke(_factAcquisitionRemoteModel, titleTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmountTotal() {
		return _amountTotal;
	}

	@Override
	public void setAmountTotal(double amountTotal) {
		_amountTotal = amountTotal;

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setAmountTotal", double.class);

				method.invoke(_factAcquisitionRemoteModel, amountTotal);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factAcquisitionRemoteModel, companyId);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factAcquisitionRemoteModel, groupId);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factAcquisitionRemoteModel, userId);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factAcquisitionRemoteModel, userName);
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

		if (_factAcquisitionRemoteModel != null) {
			try {
				Class<?> clazz = _factAcquisitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factAcquisitionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactAcquisitionRemoteModel() {
		return _factAcquisitionRemoteModel;
	}

	public void setFactAcquisitionRemoteModel(
		BaseModel<?> factAcquisitionRemoteModel) {
		_factAcquisitionRemoteModel = factAcquisitionRemoteModel;
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

		Class<?> remoteModelClass = _factAcquisitionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factAcquisitionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactAcquisitionLocalServiceUtil.addFactAcquisition(this);
		}
		else {
			FactAcquisitionLocalServiceUtil.updateFactAcquisition(this);
		}
	}

	@Override
	public FactAcquisition toEscapedModel() {
		return (FactAcquisition)ProxyUtil.newProxyInstance(FactAcquisition.class.getClassLoader(),
			new Class[] { FactAcquisition.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactAcquisitionClp clone = new FactAcquisitionClp();

		clone.setFactAcquisitionId(getFactAcquisitionId());
		clone.setLibraryId(getLibraryId());
		clone.setFacultyId(getFacultyId());
		clone.setPeriod(getPeriod());
		clone.setItemId(getItemId());
		clone.setApprovedTitleTotal(getApprovedTitleTotal());
		clone.setApprovedVolumeTotal(getApprovedVolumeTotal());
		clone.setApprovedAmountTotal(getApprovedAmountTotal());
		clone.setOrderTitleTotal(getOrderTitleTotal());
		clone.setOrderVolumeTotal(getOrderVolumeTotal());
		clone.setOrderAmountTotal(getOrderAmountTotal());
		clone.setVolumeTotal(getVolumeTotal());
		clone.setTitleTotal(getTitleTotal());
		clone.setAmountTotal(getAmountTotal());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactAcquisition factAcquisition) {
		long primaryKey = factAcquisition.getPrimaryKey();

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

		if (!(obj instanceof FactAcquisitionClp)) {
			return false;
		}

		FactAcquisitionClp factAcquisition = (FactAcquisitionClp)obj;

		long primaryKey = factAcquisition.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{factAcquisitionId=");
		sb.append(getFactAcquisitionId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", facultyId=");
		sb.append(getFacultyId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", approvedTitleTotal=");
		sb.append(getApprovedTitleTotal());
		sb.append(", approvedVolumeTotal=");
		sb.append(getApprovedVolumeTotal());
		sb.append(", approvedAmountTotal=");
		sb.append(getApprovedAmountTotal());
		sb.append(", orderTitleTotal=");
		sb.append(getOrderTitleTotal());
		sb.append(", orderVolumeTotal=");
		sb.append(getOrderVolumeTotal());
		sb.append(", orderAmountTotal=");
		sb.append(getOrderAmountTotal());
		sb.append(", volumeTotal=");
		sb.append(getVolumeTotal());
		sb.append(", titleTotal=");
		sb.append(getTitleTotal());
		sb.append(", amountTotal=");
		sb.append(getAmountTotal());
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
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactAcquisition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factAcquisitionId</column-name><column-value><![CDATA[");
		sb.append(getFactAcquisitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyId</column-name><column-value><![CDATA[");
		sb.append(getFacultyId());
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
			"<column><column-name>approvedTitleTotal</column-name><column-value><![CDATA[");
		sb.append(getApprovedTitleTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedVolumeTotal</column-name><column-value><![CDATA[");
		sb.append(getApprovedVolumeTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedAmountTotal</column-name><column-value><![CDATA[");
		sb.append(getApprovedAmountTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderTitleTotal</column-name><column-value><![CDATA[");
		sb.append(getOrderTitleTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderVolumeTotal</column-name><column-value><![CDATA[");
		sb.append(getOrderVolumeTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderAmountTotal</column-name><column-value><![CDATA[");
		sb.append(getOrderAmountTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>volumeTotal</column-name><column-value><![CDATA[");
		sb.append(getVolumeTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleTotal</column-name><column-value><![CDATA[");
		sb.append(getTitleTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountTotal</column-name><column-value><![CDATA[");
		sb.append(getAmountTotal());
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

	private long _factAcquisitionId;
	private long _libraryId;
	private long _facultyId;
	private String _period;
	private long _itemId;
	private long _approvedTitleTotal;
	private long _approvedVolumeTotal;
	private double _approvedAmountTotal;
	private long _orderTitleTotal;
	private long _orderVolumeTotal;
	private double _orderAmountTotal;
	private long _volumeTotal;
	private long _titleTotal;
	private double _amountTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factAcquisitionRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
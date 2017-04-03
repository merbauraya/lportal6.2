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
import com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil;

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
public class FactPrintedMaterialClp extends BaseModelImpl<FactPrintedMaterial>
	implements FactPrintedMaterial {
	public FactPrintedMaterialClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactPrintedMaterial.class;
	}

	@Override
	public String getModelClassName() {
		return FactPrintedMaterial.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factPrintedMaterialId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactPrintedMaterialId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factPrintedMaterialId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factPrintedMaterialId", getFactPrintedMaterialId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("libraryCode", getLibraryCode());
		attributes.put("stateId", getStateId());
		attributes.put("stateCode", getStateCode());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("period", getPeriod());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("monthVal", getMonthVal());
		attributes.put("yearVal", getYearVal());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("dateCreated", getDateCreated());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdByUserId", getCreatedByUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factPrintedMaterialId = (Long)attributes.get(
				"factPrintedMaterialId");

		if (factPrintedMaterialId != null) {
			setFactPrintedMaterialId(factPrintedMaterialId);
		}

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

		String stateCode = (String)attributes.get("stateCode");

		if (stateCode != null) {
			setStateCode(stateCode);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Integer monthVal = (Integer)attributes.get("monthVal");

		if (monthVal != null) {
			setMonthVal(monthVal);
		}

		Integer yearVal = (Integer)attributes.get("yearVal");

		if (yearVal != null) {
			setYearVal(yearVal);
		}

		Integer titleTotal = (Integer)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Integer volumeTotal = (Integer)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
		}

		Date dateCreated = (Date)attributes.get("dateCreated");

		if (dateCreated != null) {
			setDateCreated(dateCreated);
		}

		String createdByUserName = (String)attributes.get("createdByUserName");

		if (createdByUserName != null) {
			setCreatedByUserName(createdByUserName);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}
	}

	@Override
	public long getFactPrintedMaterialId() {
		return _factPrintedMaterialId;
	}

	@Override
	public void setFactPrintedMaterialId(long factPrintedMaterialId) {
		_factPrintedMaterialId = factPrintedMaterialId;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setFactPrintedMaterialId",
						long.class);

				method.invoke(_factPrintedMaterialRemoteModel,
					factPrintedMaterialId);
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

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factPrintedMaterialRemoteModel, libraryId);
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

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryCode", String.class);

				method.invoke(_factPrintedMaterialRemoteModel, libraryCode);
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

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_factPrintedMaterialRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateCode() {
		return _stateCode;
	}

	@Override
	public void setStateCode(String stateCode) {
		_stateCode = stateCode;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setStateCode", String.class);

				method.invoke(_factPrintedMaterialRemoteModel, stateCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_factPrintedMaterialRemoteModel, itemTypeId);
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

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factPrintedMaterialRemoteModel, period);
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

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_factPrintedMaterialRemoteModel, libraryTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMonthVal() {
		return _monthVal;
	}

	@Override
	public void setMonthVal(int monthVal) {
		_monthVal = monthVal;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setMonthVal", int.class);

				method.invoke(_factPrintedMaterialRemoteModel, monthVal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYearVal() {
		return _yearVal;
	}

	@Override
	public void setYearVal(int yearVal) {
		_yearVal = yearVal;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setYearVal", int.class);

				method.invoke(_factPrintedMaterialRemoteModel, yearVal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTitleTotal() {
		return _titleTotal;
	}

	@Override
	public void setTitleTotal(int titleTotal) {
		_titleTotal = titleTotal;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleTotal", int.class);

				method.invoke(_factPrintedMaterialRemoteModel, titleTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVolumeTotal() {
		return _volumeTotal;
	}

	@Override
	public void setVolumeTotal(int volumeTotal) {
		_volumeTotal = volumeTotal;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setVolumeTotal", int.class);

				method.invoke(_factPrintedMaterialRemoteModel, volumeTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateCreated() {
		return _dateCreated;
	}

	@Override
	public void setDateCreated(Date dateCreated) {
		_dateCreated = dateCreated;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setDateCreated", Date.class);

				method.invoke(_factPrintedMaterialRemoteModel, dateCreated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	@Override
	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserName",
						String.class);

				method.invoke(_factPrintedMaterialRemoteModel, createdByUserName);
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

		if (_factPrintedMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _factPrintedMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_factPrintedMaterialRemoteModel, createdByUserId);
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

	public BaseModel<?> getFactPrintedMaterialRemoteModel() {
		return _factPrintedMaterialRemoteModel;
	}

	public void setFactPrintedMaterialRemoteModel(
		BaseModel<?> factPrintedMaterialRemoteModel) {
		_factPrintedMaterialRemoteModel = factPrintedMaterialRemoteModel;
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

		Class<?> remoteModelClass = _factPrintedMaterialRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factPrintedMaterialRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactPrintedMaterialLocalServiceUtil.addFactPrintedMaterial(this);
		}
		else {
			FactPrintedMaterialLocalServiceUtil.updateFactPrintedMaterial(this);
		}
	}

	@Override
	public FactPrintedMaterial toEscapedModel() {
		return (FactPrintedMaterial)ProxyUtil.newProxyInstance(FactPrintedMaterial.class.getClassLoader(),
			new Class[] { FactPrintedMaterial.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactPrintedMaterialClp clone = new FactPrintedMaterialClp();

		clone.setFactPrintedMaterialId(getFactPrintedMaterialId());
		clone.setLibraryId(getLibraryId());
		clone.setLibraryCode(getLibraryCode());
		clone.setStateId(getStateId());
		clone.setStateCode(getStateCode());
		clone.setItemTypeId(getItemTypeId());
		clone.setPeriod(getPeriod());
		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setMonthVal(getMonthVal());
		clone.setYearVal(getYearVal());
		clone.setTitleTotal(getTitleTotal());
		clone.setVolumeTotal(getVolumeTotal());
		clone.setDateCreated(getDateCreated());
		clone.setCreatedByUserName(getCreatedByUserName());
		clone.setCreatedByUserId(getCreatedByUserId());

		return clone;
	}

	@Override
	public int compareTo(FactPrintedMaterial factPrintedMaterial) {
		long primaryKey = factPrintedMaterial.getPrimaryKey();

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

		if (!(obj instanceof FactPrintedMaterialClp)) {
			return false;
		}

		FactPrintedMaterialClp factPrintedMaterial = (FactPrintedMaterialClp)obj;

		long primaryKey = factPrintedMaterial.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{factPrintedMaterialId=");
		sb.append(getFactPrintedMaterialId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", libraryCode=");
		sb.append(getLibraryCode());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", stateCode=");
		sb.append(getStateCode());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", monthVal=");
		sb.append(getMonthVal());
		sb.append(", yearVal=");
		sb.append(getYearVal());
		sb.append(", titleTotal=");
		sb.append(getTitleTotal());
		sb.append(", volumeTotal=");
		sb.append(getVolumeTotal());
		sb.append(", dateCreated=");
		sb.append(getDateCreated());
		sb.append(", createdByUserName=");
		sb.append(getCreatedByUserName());
		sb.append(", createdByUserId=");
		sb.append(getCreatedByUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactPrintedMaterial");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factPrintedMaterialId</column-name><column-value><![CDATA[");
		sb.append(getFactPrintedMaterialId());
		sb.append("]]></column-value></column>");
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
			"<column><column-name>stateCode</column-name><column-value><![CDATA[");
		sb.append(getStateCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryTypeId</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthVal</column-name><column-value><![CDATA[");
		sb.append(getMonthVal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearVal</column-name><column-value><![CDATA[");
		sb.append(getYearVal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleTotal</column-name><column-value><![CDATA[");
		sb.append(getTitleTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>volumeTotal</column-name><column-value><![CDATA[");
		sb.append(getVolumeTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateCreated</column-name><column-value><![CDATA[");
		sb.append(getDateCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserName</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _factPrintedMaterialId;
	private long _libraryId;
	private String _libraryCode;
	private long _stateId;
	private String _stateCode;
	private long _itemTypeId;
	private String _period;
	private long _libraryTypeId;
	private int _monthVal;
	private int _yearVal;
	private int _titleTotal;
	private int _volumeTotal;
	private Date _dateCreated;
	private String _createdByUserName;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private BaseModel<?> _factPrintedMaterialRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
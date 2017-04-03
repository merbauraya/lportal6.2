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
import com.idetronic.eis.service.FactVisitorLocalServiceUtil;

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
public class FactVisitorClp extends BaseModelImpl<FactVisitor>
	implements FactVisitor {
	public FactVisitorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactVisitor.class;
	}

	@Override
	public String getModelClassName() {
		return FactVisitor.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factVisitorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactVisitorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factVisitorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factVisitorId", getFactVisitorId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("visitorCategoryId", getVisitorCategoryId());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("value", getValue());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factVisitorId = (Long)attributes.get("factVisitorId");

		if (factVisitorId != null) {
			setFactVisitorId(factVisitorId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long visitorCategoryId = (Long)attributes.get("visitorCategoryId");

		if (visitorCategoryId != null) {
			setVisitorCategoryId(visitorCategoryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}

		String createdByUserName = (String)attributes.get("createdByUserName");

		if (createdByUserName != null) {
			setCreatedByUserName(createdByUserName);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getFactVisitorId() {
		return _factVisitorId;
	}

	@Override
	public void setFactVisitorId(long factVisitorId) {
		_factVisitorId = factVisitorId;

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setFactVisitorId", long.class);

				method.invoke(_factVisitorRemoteModel, factVisitorId);
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

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factVisitorRemoteModel, libraryId);
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

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factVisitorRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVisitorCategoryId() {
		return _visitorCategoryId;
	}

	@Override
	public void setVisitorCategoryId(long visitorCategoryId) {
		_visitorCategoryId = visitorCategoryId;

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitorCategoryId",
						long.class);

				method.invoke(_factVisitorRemoteModel, visitorCategoryId);
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

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_factVisitorRemoteModel, stateId);
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

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_factVisitorRemoteModel, libraryTypeId);
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

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", int.class);

				method.invoke(_factVisitorRemoteModel, value);
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

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_factVisitorRemoteModel, createdByUserId);
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
	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	@Override
	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserName",
						String.class);

				method.invoke(_factVisitorRemoteModel, createdByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_factVisitorRemoteModel != null) {
			try {
				Class<?> clazz = _factVisitorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_factVisitorRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactVisitorRemoteModel() {
		return _factVisitorRemoteModel;
	}

	public void setFactVisitorRemoteModel(BaseModel<?> factVisitorRemoteModel) {
		_factVisitorRemoteModel = factVisitorRemoteModel;
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

		Class<?> remoteModelClass = _factVisitorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factVisitorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactVisitorLocalServiceUtil.addFactVisitor(this);
		}
		else {
			FactVisitorLocalServiceUtil.updateFactVisitor(this);
		}
	}

	@Override
	public FactVisitor toEscapedModel() {
		return (FactVisitor)ProxyUtil.newProxyInstance(FactVisitor.class.getClassLoader(),
			new Class[] { FactVisitor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactVisitorClp clone = new FactVisitorClp();

		clone.setFactVisitorId(getFactVisitorId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setVisitorCategoryId(getVisitorCategoryId());
		clone.setStateId(getStateId());
		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setValue(getValue());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setCreatedByUserName(getCreatedByUserName());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(FactVisitor factVisitor) {
		long primaryKey = factVisitor.getPrimaryKey();

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

		if (!(obj instanceof FactVisitorClp)) {
			return false;
		}

		FactVisitorClp factVisitor = (FactVisitorClp)obj;

		long primaryKey = factVisitor.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{factVisitorId=");
		sb.append(getFactVisitorId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", visitorCategoryId=");
		sb.append(getVisitorCategoryId());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", createdByUserId=");
		sb.append(getCreatedByUserId());
		sb.append(", createdByUserName=");
		sb.append(getCreatedByUserName());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactVisitor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factVisitorId</column-name><column-value><![CDATA[");
		sb.append(getFactVisitorId());
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
			"<column><column-name>visitorCategoryId</column-name><column-value><![CDATA[");
		sb.append(getVisitorCategoryId());
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
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserName</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _factVisitorId;
	private long _libraryId;
	private String _period;
	private long _visitorCategoryId;
	private long _stateId;
	private long _libraryTypeId;
	private int _value;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private String _createdByUserName;
	private Date _createdDate;
	private BaseModel<?> _factVisitorRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
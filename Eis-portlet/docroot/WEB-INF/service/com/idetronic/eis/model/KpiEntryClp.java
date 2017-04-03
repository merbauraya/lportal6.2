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
import com.idetronic.eis.service.KpiEntryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class KpiEntryClp extends BaseModelImpl<KpiEntry> implements KpiEntry {
	public KpiEntryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KpiEntry.class;
	}

	@Override
	public String getModelClassName() {
		return KpiEntry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _kpiEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKpiEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kpiEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kpiEntryId", getKpiEntryId());
		attributes.put("kpiTypeId", getKpiTypeId());
		attributes.put("periodYear", getPeriodYear());
		attributes.put("periodType", getPeriodType());
		attributes.put("period", getPeriod());
		attributes.put("value", getValue());
		attributes.put("actual", getActual());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kpiEntryId = (Long)attributes.get("kpiEntryId");

		if (kpiEntryId != null) {
			setKpiEntryId(kpiEntryId);
		}

		Long kpiTypeId = (Long)attributes.get("kpiTypeId");

		if (kpiTypeId != null) {
			setKpiTypeId(kpiTypeId);
		}

		String periodYear = (String)attributes.get("periodYear");

		if (periodYear != null) {
			setPeriodYear(periodYear);
		}

		Integer periodType = (Integer)attributes.get("periodType");

		if (periodType != null) {
			setPeriodType(periodType);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Double actual = (Double)attributes.get("actual");

		if (actual != null) {
			setActual(actual);
		}
	}

	@Override
	public long getKpiEntryId() {
		return _kpiEntryId;
	}

	@Override
	public void setKpiEntryId(long kpiEntryId) {
		_kpiEntryId = kpiEntryId;

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setKpiEntryId", long.class);

				method.invoke(_kpiEntryRemoteModel, kpiEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getKpiTypeId() {
		return _kpiTypeId;
	}

	@Override
	public void setKpiTypeId(long kpiTypeId) {
		_kpiTypeId = kpiTypeId;

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setKpiTypeId", long.class);

				method.invoke(_kpiEntryRemoteModel, kpiTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPeriodYear() {
		return _periodYear;
	}

	@Override
	public void setPeriodYear(String periodYear) {
		_periodYear = periodYear;

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodYear", String.class);

				method.invoke(_kpiEntryRemoteModel, periodYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPeriodType() {
		return _periodType;
	}

	@Override
	public void setPeriodType(int periodType) {
		_periodType = periodType;

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodType", int.class);

				method.invoke(_kpiEntryRemoteModel, periodType);
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

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_kpiEntryRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValue() {
		return _value;
	}

	@Override
	public void setValue(double value) {
		_value = value;

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", double.class);

				method.invoke(_kpiEntryRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getActual() {
		return _actual;
	}

	@Override
	public void setActual(double actual) {
		_actual = actual;

		if (_kpiEntryRemoteModel != null) {
			try {
				Class<?> clazz = _kpiEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setActual", double.class);

				method.invoke(_kpiEntryRemoteModel, actual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKpiEntryRemoteModel() {
		return _kpiEntryRemoteModel;
	}

	public void setKpiEntryRemoteModel(BaseModel<?> kpiEntryRemoteModel) {
		_kpiEntryRemoteModel = kpiEntryRemoteModel;
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

		Class<?> remoteModelClass = _kpiEntryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kpiEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KpiEntryLocalServiceUtil.addKpiEntry(this);
		}
		else {
			KpiEntryLocalServiceUtil.updateKpiEntry(this);
		}
	}

	@Override
	public KpiEntry toEscapedModel() {
		return (KpiEntry)ProxyUtil.newProxyInstance(KpiEntry.class.getClassLoader(),
			new Class[] { KpiEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KpiEntryClp clone = new KpiEntryClp();

		clone.setKpiEntryId(getKpiEntryId());
		clone.setKpiTypeId(getKpiTypeId());
		clone.setPeriodYear(getPeriodYear());
		clone.setPeriodType(getPeriodType());
		clone.setPeriod(getPeriod());
		clone.setValue(getValue());
		clone.setActual(getActual());

		return clone;
	}

	@Override
	public int compareTo(KpiEntry kpiEntry) {
		int value = 0;

		value = getPeriod().compareTo(kpiEntry.getPeriod());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KpiEntryClp)) {
			return false;
		}

		KpiEntryClp kpiEntry = (KpiEntryClp)obj;

		long primaryKey = kpiEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{kpiEntryId=");
		sb.append(getKpiEntryId());
		sb.append(", kpiTypeId=");
		sb.append(getKpiTypeId());
		sb.append(", periodYear=");
		sb.append(getPeriodYear());
		sb.append(", periodType=");
		sb.append(getPeriodType());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", actual=");
		sb.append(getActual());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.KpiEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kpiEntryId</column-name><column-value><![CDATA[");
		sb.append(getKpiEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kpiTypeId</column-name><column-value><![CDATA[");
		sb.append(getKpiTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodYear</column-name><column-value><![CDATA[");
		sb.append(getPeriodYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodType</column-name><column-value><![CDATA[");
		sb.append(getPeriodType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actual</column-name><column-value><![CDATA[");
		sb.append(getActual());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kpiEntryId;
	private long _kpiTypeId;
	private String _periodYear;
	private int _periodType;
	private String _period;
	private double _value;
	private double _actual;
	private BaseModel<?> _kpiEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
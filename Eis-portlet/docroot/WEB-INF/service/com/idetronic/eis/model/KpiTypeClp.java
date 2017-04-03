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
import com.idetronic.eis.service.KpiTypeLocalServiceUtil;

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
public class KpiTypeClp extends BaseModelImpl<KpiType> implements KpiType {
	public KpiTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KpiType.class;
	}

	@Override
	public String getModelClassName() {
		return KpiType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _kpiTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKpiTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kpiTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kpiTypeId", getKpiTypeId());
		attributes.put("kpiTypeKey", getKpiTypeKey());
		attributes.put("kpiName", getKpiName());
		attributes.put("periodMonth", getPeriodMonth());
		attributes.put("periodQuarter", getPeriodQuarter());
		attributes.put("periodSemiAnnual", getPeriodSemiAnnual());
		attributes.put("periodYear", getPeriodYear());
		attributes.put("isDecimal", getIsDecimal());
		attributes.put("manualValue", getManualValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kpiTypeId = (Long)attributes.get("kpiTypeId");

		if (kpiTypeId != null) {
			setKpiTypeId(kpiTypeId);
		}

		String kpiTypeKey = (String)attributes.get("kpiTypeKey");

		if (kpiTypeKey != null) {
			setKpiTypeKey(kpiTypeKey);
		}

		String kpiName = (String)attributes.get("kpiName");

		if (kpiName != null) {
			setKpiName(kpiName);
		}

		Boolean periodMonth = (Boolean)attributes.get("periodMonth");

		if (periodMonth != null) {
			setPeriodMonth(periodMonth);
		}

		Boolean periodQuarter = (Boolean)attributes.get("periodQuarter");

		if (periodQuarter != null) {
			setPeriodQuarter(periodQuarter);
		}

		Boolean periodSemiAnnual = (Boolean)attributes.get("periodSemiAnnual");

		if (periodSemiAnnual != null) {
			setPeriodSemiAnnual(periodSemiAnnual);
		}

		Boolean periodYear = (Boolean)attributes.get("periodYear");

		if (periodYear != null) {
			setPeriodYear(periodYear);
		}

		Boolean isDecimal = (Boolean)attributes.get("isDecimal");

		if (isDecimal != null) {
			setIsDecimal(isDecimal);
		}

		Boolean manualValue = (Boolean)attributes.get("manualValue");

		if (manualValue != null) {
			setManualValue(manualValue);
		}
	}

	@Override
	public long getKpiTypeId() {
		return _kpiTypeId;
	}

	@Override
	public void setKpiTypeId(long kpiTypeId) {
		_kpiTypeId = kpiTypeId;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setKpiTypeId", long.class);

				method.invoke(_kpiTypeRemoteModel, kpiTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKpiTypeKey() {
		return _kpiTypeKey;
	}

	@Override
	public void setKpiTypeKey(String kpiTypeKey) {
		_kpiTypeKey = kpiTypeKey;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setKpiTypeKey", String.class);

				method.invoke(_kpiTypeRemoteModel, kpiTypeKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKpiName() {
		return _kpiName;
	}

	@Override
	public void setKpiName(String kpiName) {
		_kpiName = kpiName;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setKpiName", String.class);

				method.invoke(_kpiTypeRemoteModel, kpiName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPeriodMonth() {
		return _periodMonth;
	}

	@Override
	public boolean isPeriodMonth() {
		return _periodMonth;
	}

	@Override
	public void setPeriodMonth(boolean periodMonth) {
		_periodMonth = periodMonth;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodMonth", boolean.class);

				method.invoke(_kpiTypeRemoteModel, periodMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPeriodQuarter() {
		return _periodQuarter;
	}

	@Override
	public boolean isPeriodQuarter() {
		return _periodQuarter;
	}

	@Override
	public void setPeriodQuarter(boolean periodQuarter) {
		_periodQuarter = periodQuarter;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodQuarter",
						boolean.class);

				method.invoke(_kpiTypeRemoteModel, periodQuarter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPeriodSemiAnnual() {
		return _periodSemiAnnual;
	}

	@Override
	public boolean isPeriodSemiAnnual() {
		return _periodSemiAnnual;
	}

	@Override
	public void setPeriodSemiAnnual(boolean periodSemiAnnual) {
		_periodSemiAnnual = periodSemiAnnual;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodSemiAnnual",
						boolean.class);

				method.invoke(_kpiTypeRemoteModel, periodSemiAnnual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPeriodYear() {
		return _periodYear;
	}

	@Override
	public boolean isPeriodYear() {
		return _periodYear;
	}

	@Override
	public void setPeriodYear(boolean periodYear) {
		_periodYear = periodYear;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriodYear", boolean.class);

				method.invoke(_kpiTypeRemoteModel, periodYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsDecimal() {
		return _isDecimal;
	}

	@Override
	public boolean isIsDecimal() {
		return _isDecimal;
	}

	@Override
	public void setIsDecimal(boolean isDecimal) {
		_isDecimal = isDecimal;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setIsDecimal", boolean.class);

				method.invoke(_kpiTypeRemoteModel, isDecimal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getManualValue() {
		return _manualValue;
	}

	@Override
	public boolean isManualValue() {
		return _manualValue;
	}

	@Override
	public void setManualValue(boolean manualValue) {
		_manualValue = manualValue;

		if (_kpiTypeRemoteModel != null) {
			try {
				Class<?> clazz = _kpiTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setManualValue", boolean.class);

				method.invoke(_kpiTypeRemoteModel, manualValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKpiTypeRemoteModel() {
		return _kpiTypeRemoteModel;
	}

	public void setKpiTypeRemoteModel(BaseModel<?> kpiTypeRemoteModel) {
		_kpiTypeRemoteModel = kpiTypeRemoteModel;
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

		Class<?> remoteModelClass = _kpiTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kpiTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KpiTypeLocalServiceUtil.addKpiType(this);
		}
		else {
			KpiTypeLocalServiceUtil.updateKpiType(this);
		}
	}

	@Override
	public KpiType toEscapedModel() {
		return (KpiType)ProxyUtil.newProxyInstance(KpiType.class.getClassLoader(),
			new Class[] { KpiType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KpiTypeClp clone = new KpiTypeClp();

		clone.setKpiTypeId(getKpiTypeId());
		clone.setKpiTypeKey(getKpiTypeKey());
		clone.setKpiName(getKpiName());
		clone.setPeriodMonth(getPeriodMonth());
		clone.setPeriodQuarter(getPeriodQuarter());
		clone.setPeriodSemiAnnual(getPeriodSemiAnnual());
		clone.setPeriodYear(getPeriodYear());
		clone.setIsDecimal(getIsDecimal());
		clone.setManualValue(getManualValue());

		return clone;
	}

	@Override
	public int compareTo(KpiType kpiType) {
		long primaryKey = kpiType.getPrimaryKey();

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

		if (!(obj instanceof KpiTypeClp)) {
			return false;
		}

		KpiTypeClp kpiType = (KpiTypeClp)obj;

		long primaryKey = kpiType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{kpiTypeId=");
		sb.append(getKpiTypeId());
		sb.append(", kpiTypeKey=");
		sb.append(getKpiTypeKey());
		sb.append(", kpiName=");
		sb.append(getKpiName());
		sb.append(", periodMonth=");
		sb.append(getPeriodMonth());
		sb.append(", periodQuarter=");
		sb.append(getPeriodQuarter());
		sb.append(", periodSemiAnnual=");
		sb.append(getPeriodSemiAnnual());
		sb.append(", periodYear=");
		sb.append(getPeriodYear());
		sb.append(", isDecimal=");
		sb.append(getIsDecimal());
		sb.append(", manualValue=");
		sb.append(getManualValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.KpiType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kpiTypeId</column-name><column-value><![CDATA[");
		sb.append(getKpiTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kpiTypeKey</column-name><column-value><![CDATA[");
		sb.append(getKpiTypeKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kpiName</column-name><column-value><![CDATA[");
		sb.append(getKpiName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodMonth</column-name><column-value><![CDATA[");
		sb.append(getPeriodMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodQuarter</column-name><column-value><![CDATA[");
		sb.append(getPeriodQuarter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodSemiAnnual</column-name><column-value><![CDATA[");
		sb.append(getPeriodSemiAnnual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodYear</column-name><column-value><![CDATA[");
		sb.append(getPeriodYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDecimal</column-name><column-value><![CDATA[");
		sb.append(getIsDecimal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manualValue</column-name><column-value><![CDATA[");
		sb.append(getManualValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kpiTypeId;
	private String _kpiTypeKey;
	private String _kpiName;
	private boolean _periodMonth;
	private boolean _periodQuarter;
	private boolean _periodSemiAnnual;
	private boolean _periodYear;
	private boolean _isDecimal;
	private boolean _manualValue;
	private BaseModel<?> _kpiTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
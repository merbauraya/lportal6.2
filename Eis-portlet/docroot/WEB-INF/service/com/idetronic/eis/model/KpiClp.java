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
import com.idetronic.eis.service.KpiLocalServiceUtil;

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
public class KpiClp extends BaseModelImpl<Kpi> implements Kpi {
	public KpiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Kpi.class;
	}

	@Override
	public String getModelClassName() {
		return Kpi.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("key", getKey());
		attributes.put("kpiType", getKpiType());
		attributes.put("value", getValue());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Integer kpiType = (Integer)attributes.get("kpiType");

		if (kpiType != null) {
			setKpiType(kpiType);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_kpiRemoteModel != null) {
			try {
				Class<?> clazz = _kpiRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_kpiRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public void setKey(String key) {
		_key = key;

		if (_kpiRemoteModel != null) {
			try {
				Class<?> clazz = _kpiRemoteModel.getClass();

				Method method = clazz.getMethod("setKey", String.class);

				method.invoke(_kpiRemoteModel, key);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getKpiType() {
		return _kpiType;
	}

	@Override
	public void setKpiType(int kpiType) {
		_kpiType = kpiType;

		if (_kpiRemoteModel != null) {
			try {
				Class<?> clazz = _kpiRemoteModel.getClass();

				Method method = clazz.getMethod("setKpiType", int.class);

				method.invoke(_kpiRemoteModel, kpiType);
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

		if (_kpiRemoteModel != null) {
			try {
				Class<?> clazz = _kpiRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", int.class);

				method.invoke(_kpiRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_kpiRemoteModel != null) {
			try {
				Class<?> clazz = _kpiRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_kpiRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKpiRemoteModel() {
		return _kpiRemoteModel;
	}

	public void setKpiRemoteModel(BaseModel<?> kpiRemoteModel) {
		_kpiRemoteModel = kpiRemoteModel;
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

		Class<?> remoteModelClass = _kpiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kpiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KpiLocalServiceUtil.addKpi(this);
		}
		else {
			KpiLocalServiceUtil.updateKpi(this);
		}
	}

	@Override
	public Kpi toEscapedModel() {
		return (Kpi)ProxyUtil.newProxyInstance(Kpi.class.getClassLoader(),
			new Class[] { Kpi.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KpiClp clone = new KpiClp();

		clone.setId(getId());
		clone.setKey(getKey());
		clone.setKpiType(getKpiType());
		clone.setValue(getValue());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(Kpi kpi) {
		long primaryKey = kpi.getPrimaryKey();

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

		if (!(obj instanceof KpiClp)) {
			return false;
		}

		KpiClp kpi = (KpiClp)obj;

		long primaryKey = kpi.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", kpiType=");
		sb.append(getKpiType());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Kpi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kpiType</column-name><column-value><![CDATA[");
		sb.append(getKpiType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _key;
	private int _kpiType;
	private int _value;
	private String _description;
	private BaseModel<?> _kpiRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
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
import com.idetronic.eis.service.VisitorCategoryLocalServiceUtil;

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
public class VisitorCategoryClp extends BaseModelImpl<VisitorCategory>
	implements VisitorCategory {
	public VisitorCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VisitorCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VisitorCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _visitorCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVisitorCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _visitorCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visitorCategoryId", getVisitorCategoryId());
		attributes.put("visitorCategoryCode", getVisitorCategoryCode());
		attributes.put("visitorCategoryName", getVisitorCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long visitorCategoryId = (Long)attributes.get("visitorCategoryId");

		if (visitorCategoryId != null) {
			setVisitorCategoryId(visitorCategoryId);
		}

		String visitorCategoryCode = (String)attributes.get(
				"visitorCategoryCode");

		if (visitorCategoryCode != null) {
			setVisitorCategoryCode(visitorCategoryCode);
		}

		String visitorCategoryName = (String)attributes.get(
				"visitorCategoryName");

		if (visitorCategoryName != null) {
			setVisitorCategoryName(visitorCategoryName);
		}
	}

	@Override
	public long getVisitorCategoryId() {
		return _visitorCategoryId;
	}

	@Override
	public void setVisitorCategoryId(long visitorCategoryId) {
		_visitorCategoryId = visitorCategoryId;

		if (_visitorCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _visitorCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitorCategoryId",
						long.class);

				method.invoke(_visitorCategoryRemoteModel, visitorCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVisitorCategoryCode() {
		return _visitorCategoryCode;
	}

	@Override
	public void setVisitorCategoryCode(String visitorCategoryCode) {
		_visitorCategoryCode = visitorCategoryCode;

		if (_visitorCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _visitorCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitorCategoryCode",
						String.class);

				method.invoke(_visitorCategoryRemoteModel, visitorCategoryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVisitorCategoryName() {
		return _visitorCategoryName;
	}

	@Override
	public void setVisitorCategoryName(String visitorCategoryName) {
		_visitorCategoryName = visitorCategoryName;

		if (_visitorCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _visitorCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setVisitorCategoryName",
						String.class);

				method.invoke(_visitorCategoryRemoteModel, visitorCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVisitorCategoryRemoteModel() {
		return _visitorCategoryRemoteModel;
	}

	public void setVisitorCategoryRemoteModel(
		BaseModel<?> visitorCategoryRemoteModel) {
		_visitorCategoryRemoteModel = visitorCategoryRemoteModel;
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

		Class<?> remoteModelClass = _visitorCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_visitorCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitorCategoryLocalServiceUtil.addVisitorCategory(this);
		}
		else {
			VisitorCategoryLocalServiceUtil.updateVisitorCategory(this);
		}
	}

	@Override
	public VisitorCategory toEscapedModel() {
		return (VisitorCategory)ProxyUtil.newProxyInstance(VisitorCategory.class.getClassLoader(),
			new Class[] { VisitorCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisitorCategoryClp clone = new VisitorCategoryClp();

		clone.setVisitorCategoryId(getVisitorCategoryId());
		clone.setVisitorCategoryCode(getVisitorCategoryCode());
		clone.setVisitorCategoryName(getVisitorCategoryName());

		return clone;
	}

	@Override
	public int compareTo(VisitorCategory visitorCategory) {
		long primaryKey = visitorCategory.getPrimaryKey();

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

		if (!(obj instanceof VisitorCategoryClp)) {
			return false;
		}

		VisitorCategoryClp visitorCategory = (VisitorCategoryClp)obj;

		long primaryKey = visitorCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{visitorCategoryId=");
		sb.append(getVisitorCategoryId());
		sb.append(", visitorCategoryCode=");
		sb.append(getVisitorCategoryCode());
		sb.append(", visitorCategoryName=");
		sb.append(getVisitorCategoryName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.VisitorCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>visitorCategoryId</column-name><column-value><![CDATA[");
		sb.append(getVisitorCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorCategoryCode</column-name><column-value><![CDATA[");
		sb.append(getVisitorCategoryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorCategoryName</column-name><column-value><![CDATA[");
		sb.append(getVisitorCategoryName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _visitorCategoryId;
	private String _visitorCategoryCode;
	private String _visitorCategoryName;
	private BaseModel<?> _visitorCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
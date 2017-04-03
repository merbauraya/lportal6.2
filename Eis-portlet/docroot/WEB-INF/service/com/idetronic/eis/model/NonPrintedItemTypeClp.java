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
import com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil;

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
public class NonPrintedItemTypeClp extends BaseModelImpl<NonPrintedItemType>
	implements NonPrintedItemType {
	public NonPrintedItemTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NonPrintedItemType.class;
	}

	@Override
	public String getModelClassName() {
		return NonPrintedItemType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _itemTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("itemTypeName", getItemTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String itemTypeName = (String)attributes.get("itemTypeName");

		if (itemTypeName != null) {
			setItemTypeName(itemTypeName);
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_nonPrintedItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _nonPrintedItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_nonPrintedItemTypeRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemTypeName() {
		return _itemTypeName;
	}

	@Override
	public void setItemTypeName(String itemTypeName) {
		_itemTypeName = itemTypeName;

		if (_nonPrintedItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _nonPrintedItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeName", String.class);

				method.invoke(_nonPrintedItemTypeRemoteModel, itemTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNonPrintedItemTypeRemoteModel() {
		return _nonPrintedItemTypeRemoteModel;
	}

	public void setNonPrintedItemTypeRemoteModel(
		BaseModel<?> nonPrintedItemTypeRemoteModel) {
		_nonPrintedItemTypeRemoteModel = nonPrintedItemTypeRemoteModel;
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

		Class<?> remoteModelClass = _nonPrintedItemTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_nonPrintedItemTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NonPrintedItemTypeLocalServiceUtil.addNonPrintedItemType(this);
		}
		else {
			NonPrintedItemTypeLocalServiceUtil.updateNonPrintedItemType(this);
		}
	}

	@Override
	public NonPrintedItemType toEscapedModel() {
		return (NonPrintedItemType)ProxyUtil.newProxyInstance(NonPrintedItemType.class.getClassLoader(),
			new Class[] { NonPrintedItemType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NonPrintedItemTypeClp clone = new NonPrintedItemTypeClp();

		clone.setItemTypeId(getItemTypeId());
		clone.setItemTypeName(getItemTypeName());

		return clone;
	}

	@Override
	public int compareTo(NonPrintedItemType nonPrintedItemType) {
		long primaryKey = nonPrintedItemType.getPrimaryKey();

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

		if (!(obj instanceof NonPrintedItemTypeClp)) {
			return false;
		}

		NonPrintedItemTypeClp nonPrintedItemType = (NonPrintedItemTypeClp)obj;

		long primaryKey = nonPrintedItemType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", itemTypeName=");
		sb.append(getItemTypeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.NonPrintedItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeName</column-name><column-value><![CDATA[");
		sb.append(getItemTypeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemTypeId;
	private String _itemTypeName;
	private BaseModel<?> _nonPrintedItemTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
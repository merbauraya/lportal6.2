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
import com.idetronic.eis.service.ItemTypeLocalServiceUtil;

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
public class ItemTypeClp extends BaseModelImpl<ItemType> implements ItemType {
	public ItemTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemType.class;
	}

	@Override
	public String getModelClassName() {
		return ItemType.class.getName();
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
		attributes.put("printedType", getPrintedType());
		attributes.put("IRType", getIRType());
		attributes.put("active", getActive());

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

		Integer printedType = (Integer)attributes.get("printedType");

		if (printedType != null) {
			setPrintedType(printedType);
		}

		Boolean IRType = (Boolean)attributes.get("IRType");

		if (IRType != null) {
			setIRType(IRType);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_itemTypeRemoteModel, itemTypeId);
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

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeName", String.class);

				method.invoke(_itemTypeRemoteModel, itemTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrintedType() {
		return _printedType;
	}

	@Override
	public void setPrintedType(int printedType) {
		_printedType = printedType;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPrintedType", int.class);

				method.invoke(_itemTypeRemoteModel, printedType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIRType() {
		return _IRType;
	}

	@Override
	public boolean isIRType() {
		return _IRType;
	}

	@Override
	public void setIRType(boolean IRType) {
		_IRType = IRType;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setIRType", boolean.class);

				method.invoke(_itemTypeRemoteModel, IRType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_itemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_itemTypeRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemTypeRemoteModel() {
		return _itemTypeRemoteModel;
	}

	public void setItemTypeRemoteModel(BaseModel<?> itemTypeRemoteModel) {
		_itemTypeRemoteModel = itemTypeRemoteModel;
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

		Class<?> remoteModelClass = _itemTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemTypeLocalServiceUtil.addItemType(this);
		}
		else {
			ItemTypeLocalServiceUtil.updateItemType(this);
		}
	}

	@Override
	public ItemType toEscapedModel() {
		return (ItemType)ProxyUtil.newProxyInstance(ItemType.class.getClassLoader(),
			new Class[] { ItemType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemTypeClp clone = new ItemTypeClp();

		clone.setItemTypeId(getItemTypeId());
		clone.setItemTypeName(getItemTypeName());
		clone.setPrintedType(getPrintedType());
		clone.setIRType(getIRType());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(ItemType itemType) {
		long primaryKey = itemType.getPrimaryKey();

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

		if (!(obj instanceof ItemTypeClp)) {
			return false;
		}

		ItemTypeClp itemType = (ItemTypeClp)obj;

		long primaryKey = itemType.getPrimaryKey();

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

		sb.append("{itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", itemTypeName=");
		sb.append(getItemTypeName());
		sb.append(", printedType=");
		sb.append(getPrintedType());
		sb.append(", IRType=");
		sb.append(getIRType());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.ItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeName</column-name><column-value><![CDATA[");
		sb.append(getItemTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>printedType</column-name><column-value><![CDATA[");
		sb.append(getPrintedType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IRType</column-name><column-value><![CDATA[");
		sb.append(getIRType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemTypeId;
	private String _itemTypeName;
	private int _printedType;
	private boolean _IRType;
	private boolean _active;
	private BaseModel<?> _itemTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
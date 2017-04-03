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
import com.idetronic.eis.service.ItemMediumLocalServiceUtil;

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
public class ItemMediumClp extends BaseModelImpl<ItemMedium>
	implements ItemMedium {
	public ItemMediumClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemMedium.class;
	}

	@Override
	public String getModelClassName() {
		return ItemMedium.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _itemMediumId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemMediumId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemMediumId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemMediumId", getItemMediumId());
		attributes.put("itemMediumName", getItemMediumName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemMediumId = (Long)attributes.get("itemMediumId");

		if (itemMediumId != null) {
			setItemMediumId(itemMediumId);
		}

		String itemMediumName = (String)attributes.get("itemMediumName");

		if (itemMediumName != null) {
			setItemMediumName(itemMediumName);
		}
	}

	@Override
	public long getItemMediumId() {
		return _itemMediumId;
	}

	@Override
	public void setItemMediumId(long itemMediumId) {
		_itemMediumId = itemMediumId;

		if (_itemMediumRemoteModel != null) {
			try {
				Class<?> clazz = _itemMediumRemoteModel.getClass();

				Method method = clazz.getMethod("setItemMediumId", long.class);

				method.invoke(_itemMediumRemoteModel, itemMediumId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemMediumName() {
		return _itemMediumName;
	}

	@Override
	public void setItemMediumName(String itemMediumName) {
		_itemMediumName = itemMediumName;

		if (_itemMediumRemoteModel != null) {
			try {
				Class<?> clazz = _itemMediumRemoteModel.getClass();

				Method method = clazz.getMethod("setItemMediumName",
						String.class);

				method.invoke(_itemMediumRemoteModel, itemMediumName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemMediumRemoteModel() {
		return _itemMediumRemoteModel;
	}

	public void setItemMediumRemoteModel(BaseModel<?> itemMediumRemoteModel) {
		_itemMediumRemoteModel = itemMediumRemoteModel;
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

		Class<?> remoteModelClass = _itemMediumRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemMediumRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemMediumLocalServiceUtil.addItemMedium(this);
		}
		else {
			ItemMediumLocalServiceUtil.updateItemMedium(this);
		}
	}

	@Override
	public ItemMedium toEscapedModel() {
		return (ItemMedium)ProxyUtil.newProxyInstance(ItemMedium.class.getClassLoader(),
			new Class[] { ItemMedium.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemMediumClp clone = new ItemMediumClp();

		clone.setItemMediumId(getItemMediumId());
		clone.setItemMediumName(getItemMediumName());

		return clone;
	}

	@Override
	public int compareTo(ItemMedium itemMedium) {
		long primaryKey = itemMedium.getPrimaryKey();

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

		if (!(obj instanceof ItemMediumClp)) {
			return false;
		}

		ItemMediumClp itemMedium = (ItemMediumClp)obj;

		long primaryKey = itemMedium.getPrimaryKey();

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

		sb.append("{itemMediumId=");
		sb.append(getItemMediumId());
		sb.append(", itemMediumName=");
		sb.append(getItemMediumName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.ItemMedium");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemMediumId</column-name><column-value><![CDATA[");
		sb.append(getItemMediumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemMediumName</column-name><column-value><![CDATA[");
		sb.append(getItemMediumName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemMediumId;
	private String _itemMediumName;
	private BaseModel<?> _itemMediumRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
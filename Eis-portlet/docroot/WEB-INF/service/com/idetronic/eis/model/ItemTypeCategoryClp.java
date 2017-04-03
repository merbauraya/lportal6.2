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
import com.idetronic.eis.service.ItemTypeCategoryLocalServiceUtil;

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
public class ItemTypeCategoryClp extends BaseModelImpl<ItemTypeCategory>
	implements ItemTypeCategory {
	public ItemTypeCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ItemTypeCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ItemTypeCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _itemTypeCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemTypeCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemTypeCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeCategoryId", getItemTypeCategoryId());
		attributes.put("itemTypeCategoryName", getItemTypeCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeCategoryId = (Long)attributes.get("itemTypeCategoryId");

		if (itemTypeCategoryId != null) {
			setItemTypeCategoryId(itemTypeCategoryId);
		}

		String itemTypeCategoryName = (String)attributes.get(
				"itemTypeCategoryName");

		if (itemTypeCategoryName != null) {
			setItemTypeCategoryName(itemTypeCategoryName);
		}
	}

	@Override
	public long getItemTypeCategoryId() {
		return _itemTypeCategoryId;
	}

	@Override
	public void setItemTypeCategoryId(long itemTypeCategoryId) {
		_itemTypeCategoryId = itemTypeCategoryId;

		if (_itemTypeCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeCategoryId",
						long.class);

				method.invoke(_itemTypeCategoryRemoteModel, itemTypeCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemTypeCategoryName() {
		return _itemTypeCategoryName;
	}

	@Override
	public void setItemTypeCategoryName(String itemTypeCategoryName) {
		_itemTypeCategoryName = itemTypeCategoryName;

		if (_itemTypeCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _itemTypeCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeCategoryName",
						String.class);

				method.invoke(_itemTypeCategoryRemoteModel, itemTypeCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemTypeCategoryRemoteModel() {
		return _itemTypeCategoryRemoteModel;
	}

	public void setItemTypeCategoryRemoteModel(
		BaseModel<?> itemTypeCategoryRemoteModel) {
		_itemTypeCategoryRemoteModel = itemTypeCategoryRemoteModel;
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

		Class<?> remoteModelClass = _itemTypeCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemTypeCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemTypeCategoryLocalServiceUtil.addItemTypeCategory(this);
		}
		else {
			ItemTypeCategoryLocalServiceUtil.updateItemTypeCategory(this);
		}
	}

	@Override
	public ItemTypeCategory toEscapedModel() {
		return (ItemTypeCategory)ProxyUtil.newProxyInstance(ItemTypeCategory.class.getClassLoader(),
			new Class[] { ItemTypeCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemTypeCategoryClp clone = new ItemTypeCategoryClp();

		clone.setItemTypeCategoryId(getItemTypeCategoryId());
		clone.setItemTypeCategoryName(getItemTypeCategoryName());

		return clone;
	}

	@Override
	public int compareTo(ItemTypeCategory itemTypeCategory) {
		long primaryKey = itemTypeCategory.getPrimaryKey();

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

		if (!(obj instanceof ItemTypeCategoryClp)) {
			return false;
		}

		ItemTypeCategoryClp itemTypeCategory = (ItemTypeCategoryClp)obj;

		long primaryKey = itemTypeCategory.getPrimaryKey();

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

		sb.append("{itemTypeCategoryId=");
		sb.append(getItemTypeCategoryId());
		sb.append(", itemTypeCategoryName=");
		sb.append(getItemTypeCategoryName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.ItemTypeCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeCategoryName</column-name><column-value><![CDATA[");
		sb.append(getItemTypeCategoryName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemTypeCategoryId;
	private String _itemTypeCategoryName;
	private BaseModel<?> _itemTypeCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
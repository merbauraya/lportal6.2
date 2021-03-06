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

package com.idetronic.eis.model.impl;

import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.NonPrintedItemTypeModel;
import com.idetronic.eis.model.NonPrintedItemTypeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the NonPrintedItemType service. Represents a row in the &quot;eis_NonPrintedItemType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.NonPrintedItemTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NonPrintedItemTypeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see NonPrintedItemTypeImpl
 * @see com.idetronic.eis.model.NonPrintedItemType
 * @see com.idetronic.eis.model.NonPrintedItemTypeModel
 * @generated
 */
@JSON(strict = true)
public class NonPrintedItemTypeModelImpl extends BaseModelImpl<NonPrintedItemType>
	implements NonPrintedItemTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a non printed item type model instance should use the {@link com.idetronic.eis.model.NonPrintedItemType} interface instead.
	 */
	public static final String TABLE_NAME = "eis_NonPrintedItemType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemTypeId", Types.BIGINT },
			{ "itemTypeName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_NonPrintedItemType (itemTypeId LONG not null primary key,itemTypeName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eis_NonPrintedItemType";
	public static final String ORDER_BY_JPQL = " ORDER BY nonPrintedItemType.itemTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_NonPrintedItemType.itemTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.NonPrintedItemType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.NonPrintedItemType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static NonPrintedItemType toModel(NonPrintedItemTypeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		NonPrintedItemType model = new NonPrintedItemTypeImpl();

		model.setItemTypeId(soapModel.getItemTypeId());
		model.setItemTypeName(soapModel.getItemTypeName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<NonPrintedItemType> toModels(
		NonPrintedItemTypeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<NonPrintedItemType> models = new ArrayList<NonPrintedItemType>(soapModels.length);

		for (NonPrintedItemTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.NonPrintedItemType"));

	public NonPrintedItemTypeModelImpl() {
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
	public Class<?> getModelClass() {
		return NonPrintedItemType.class;
	}

	@Override
	public String getModelClassName() {
		return NonPrintedItemType.class.getName();
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

	@JSON
	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	@JSON
	@Override
	public String getItemTypeName() {
		if (_itemTypeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemTypeName;
		}
	}

	@Override
	public void setItemTypeName(String itemTypeName) {
		_itemTypeName = itemTypeName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NonPrintedItemType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NonPrintedItemType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NonPrintedItemType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NonPrintedItemTypeImpl nonPrintedItemTypeImpl = new NonPrintedItemTypeImpl();

		nonPrintedItemTypeImpl.setItemTypeId(getItemTypeId());
		nonPrintedItemTypeImpl.setItemTypeName(getItemTypeName());

		nonPrintedItemTypeImpl.resetOriginalValues();

		return nonPrintedItemTypeImpl;
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

		if (!(obj instanceof NonPrintedItemType)) {
			return false;
		}

		NonPrintedItemType nonPrintedItemType = (NonPrintedItemType)obj;

		long primaryKey = nonPrintedItemType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<NonPrintedItemType> toCacheModel() {
		NonPrintedItemTypeCacheModel nonPrintedItemTypeCacheModel = new NonPrintedItemTypeCacheModel();

		nonPrintedItemTypeCacheModel.itemTypeId = getItemTypeId();

		nonPrintedItemTypeCacheModel.itemTypeName = getItemTypeName();

		String itemTypeName = nonPrintedItemTypeCacheModel.itemTypeName;

		if ((itemTypeName != null) && (itemTypeName.length() == 0)) {
			nonPrintedItemTypeCacheModel.itemTypeName = null;
		}

		return nonPrintedItemTypeCacheModel;
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

	private static ClassLoader _classLoader = NonPrintedItemType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			NonPrintedItemType.class
		};
	private long _itemTypeId;
	private String _itemTypeName;
	private NonPrintedItemType _escapedModel;
}
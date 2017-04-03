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

import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.model.PrintedItemTypeModel;
import com.idetronic.eis.model.PrintedItemTypeSoap;

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
 * The base model implementation for the PrintedItemType service. Represents a row in the &quot;eis_PrintedItemType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.PrintedItemTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PrintedItemTypeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PrintedItemTypeImpl
 * @see com.idetronic.eis.model.PrintedItemType
 * @see com.idetronic.eis.model.PrintedItemTypeModel
 * @generated
 */
@JSON(strict = true)
public class PrintedItemTypeModelImpl extends BaseModelImpl<PrintedItemType>
	implements PrintedItemTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a printed item type model instance should use the {@link com.idetronic.eis.model.PrintedItemType} interface instead.
	 */
	public static final String TABLE_NAME = "eis_PrintedItemType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemTypeId", Types.BIGINT },
			{ "itemTypeName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_PrintedItemType (itemTypeId LONG not null primary key,itemTypeName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eis_PrintedItemType";
	public static final String ORDER_BY_JPQL = " ORDER BY printedItemType.itemTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_PrintedItemType.itemTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.PrintedItemType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.PrintedItemType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PrintedItemType toModel(PrintedItemTypeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PrintedItemType model = new PrintedItemTypeImpl();

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
	public static List<PrintedItemType> toModels(
		PrintedItemTypeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PrintedItemType> models = new ArrayList<PrintedItemType>(soapModels.length);

		for (PrintedItemTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.PrintedItemType"));

	public PrintedItemTypeModelImpl() {
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
		return PrintedItemType.class;
	}

	@Override
	public String getModelClassName() {
		return PrintedItemType.class.getName();
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
			PrintedItemType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PrintedItemType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PrintedItemType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PrintedItemTypeImpl printedItemTypeImpl = new PrintedItemTypeImpl();

		printedItemTypeImpl.setItemTypeId(getItemTypeId());
		printedItemTypeImpl.setItemTypeName(getItemTypeName());

		printedItemTypeImpl.resetOriginalValues();

		return printedItemTypeImpl;
	}

	@Override
	public int compareTo(PrintedItemType printedItemType) {
		long primaryKey = printedItemType.getPrimaryKey();

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

		if (!(obj instanceof PrintedItemType)) {
			return false;
		}

		PrintedItemType printedItemType = (PrintedItemType)obj;

		long primaryKey = printedItemType.getPrimaryKey();

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
	public CacheModel<PrintedItemType> toCacheModel() {
		PrintedItemTypeCacheModel printedItemTypeCacheModel = new PrintedItemTypeCacheModel();

		printedItemTypeCacheModel.itemTypeId = getItemTypeId();

		printedItemTypeCacheModel.itemTypeName = getItemTypeName();

		String itemTypeName = printedItemTypeCacheModel.itemTypeName;

		if ((itemTypeName != null) && (itemTypeName.length() == 0)) {
			printedItemTypeCacheModel.itemTypeName = null;
		}

		return printedItemTypeCacheModel;
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
		sb.append("com.idetronic.eis.model.PrintedItemType");
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

	private static ClassLoader _classLoader = PrintedItemType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PrintedItemType.class
		};
	private long _itemTypeId;
	private String _itemTypeName;
	private PrintedItemType _escapedModel;
}
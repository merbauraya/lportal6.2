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

import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.model.VisitorCategoryModel;
import com.idetronic.eis.model.VisitorCategorySoap;

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
 * The base model implementation for the VisitorCategory service. Represents a row in the &quot;eis_VisitorCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.VisitorCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VisitorCategoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see VisitorCategoryImpl
 * @see com.idetronic.eis.model.VisitorCategory
 * @see com.idetronic.eis.model.VisitorCategoryModel
 * @generated
 */
@JSON(strict = true)
public class VisitorCategoryModelImpl extends BaseModelImpl<VisitorCategory>
	implements VisitorCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a visitor category model instance should use the {@link com.idetronic.eis.model.VisitorCategory} interface instead.
	 */
	public static final String TABLE_NAME = "eis_VisitorCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "visitorCategoryId", Types.BIGINT },
			{ "visitorCategoryCode", Types.VARCHAR },
			{ "visitorCategoryName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_VisitorCategory (visitorCategoryId LONG not null primary key,visitorCategoryCode VARCHAR(75) null,visitorCategoryName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eis_VisitorCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY visitorCategory.visitorCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_VisitorCategory.visitorCategoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.VisitorCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.VisitorCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eis.model.VisitorCategory"),
			true);
	public static long VISITORCATEGORYCODE_COLUMN_BITMASK = 1L;
	public static long VISITORCATEGORYID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VisitorCategory toModel(VisitorCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VisitorCategory model = new VisitorCategoryImpl();

		model.setVisitorCategoryId(soapModel.getVisitorCategoryId());
		model.setVisitorCategoryCode(soapModel.getVisitorCategoryCode());
		model.setVisitorCategoryName(soapModel.getVisitorCategoryName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VisitorCategory> toModels(
		VisitorCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VisitorCategory> models = new ArrayList<VisitorCategory>(soapModels.length);

		for (VisitorCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.VisitorCategory"));

	public VisitorCategoryModelImpl() {
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
	public Class<?> getModelClass() {
		return VisitorCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VisitorCategory.class.getName();
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

	@JSON
	@Override
	public long getVisitorCategoryId() {
		return _visitorCategoryId;
	}

	@Override
	public void setVisitorCategoryId(long visitorCategoryId) {
		_visitorCategoryId = visitorCategoryId;
	}

	@JSON
	@Override
	public String getVisitorCategoryCode() {
		if (_visitorCategoryCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _visitorCategoryCode;
		}
	}

	@Override
	public void setVisitorCategoryCode(String visitorCategoryCode) {
		_columnBitmask |= VISITORCATEGORYCODE_COLUMN_BITMASK;

		if (_originalVisitorCategoryCode == null) {
			_originalVisitorCategoryCode = _visitorCategoryCode;
		}

		_visitorCategoryCode = visitorCategoryCode;
	}

	public String getOriginalVisitorCategoryCode() {
		return GetterUtil.getString(_originalVisitorCategoryCode);
	}

	@JSON
	@Override
	public String getVisitorCategoryName() {
		if (_visitorCategoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _visitorCategoryName;
		}
	}

	@Override
	public void setVisitorCategoryName(String visitorCategoryName) {
		_visitorCategoryName = visitorCategoryName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			VisitorCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VisitorCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VisitorCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VisitorCategoryImpl visitorCategoryImpl = new VisitorCategoryImpl();

		visitorCategoryImpl.setVisitorCategoryId(getVisitorCategoryId());
		visitorCategoryImpl.setVisitorCategoryCode(getVisitorCategoryCode());
		visitorCategoryImpl.setVisitorCategoryName(getVisitorCategoryName());

		visitorCategoryImpl.resetOriginalValues();

		return visitorCategoryImpl;
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

		if (!(obj instanceof VisitorCategory)) {
			return false;
		}

		VisitorCategory visitorCategory = (VisitorCategory)obj;

		long primaryKey = visitorCategory.getPrimaryKey();

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
		VisitorCategoryModelImpl visitorCategoryModelImpl = this;

		visitorCategoryModelImpl._originalVisitorCategoryCode = visitorCategoryModelImpl._visitorCategoryCode;

		visitorCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VisitorCategory> toCacheModel() {
		VisitorCategoryCacheModel visitorCategoryCacheModel = new VisitorCategoryCacheModel();

		visitorCategoryCacheModel.visitorCategoryId = getVisitorCategoryId();

		visitorCategoryCacheModel.visitorCategoryCode = getVisitorCategoryCode();

		String visitorCategoryCode = visitorCategoryCacheModel.visitorCategoryCode;

		if ((visitorCategoryCode != null) &&
				(visitorCategoryCode.length() == 0)) {
			visitorCategoryCacheModel.visitorCategoryCode = null;
		}

		visitorCategoryCacheModel.visitorCategoryName = getVisitorCategoryName();

		String visitorCategoryName = visitorCategoryCacheModel.visitorCategoryName;

		if ((visitorCategoryName != null) &&
				(visitorCategoryName.length() == 0)) {
			visitorCategoryCacheModel.visitorCategoryName = null;
		}

		return visitorCategoryCacheModel;
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

	private static ClassLoader _classLoader = VisitorCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VisitorCategory.class
		};
	private long _visitorCategoryId;
	private String _visitorCategoryCode;
	private String _originalVisitorCategoryCode;
	private String _visitorCategoryName;
	private long _columnBitmask;
	private VisitorCategory _escapedModel;
}
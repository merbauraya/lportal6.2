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

import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.model.MemberCategoryModel;
import com.idetronic.eis.model.MemberCategorySoap;

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
 * The base model implementation for the MemberCategory service. Represents a row in the &quot;eis_MemberCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.MemberCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MemberCategoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MemberCategoryImpl
 * @see com.idetronic.eis.model.MemberCategory
 * @see com.idetronic.eis.model.MemberCategoryModel
 * @generated
 */
@JSON(strict = true)
public class MemberCategoryModelImpl extends BaseModelImpl<MemberCategory>
	implements MemberCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a member category model instance should use the {@link com.idetronic.eis.model.MemberCategory} interface instead.
	 */
	public static final String TABLE_NAME = "eis_MemberCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "memberCategoryId", Types.BIGINT },
			{ "memberCategoryName", Types.VARCHAR },
			{ "memberCategoryGroupName", Types.VARCHAR },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_MemberCategory (memberCategoryId LONG not null primary key,memberCategoryName VARCHAR(75) null,memberCategoryGroupName VARCHAR(75) null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table eis_MemberCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY memberCategory.memberCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_MemberCategory.memberCategoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.MemberCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.MemberCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MemberCategory toModel(MemberCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MemberCategory model = new MemberCategoryImpl();

		model.setMemberCategoryId(soapModel.getMemberCategoryId());
		model.setMemberCategoryName(soapModel.getMemberCategoryName());
		model.setMemberCategoryGroupName(soapModel.getMemberCategoryGroupName());
		model.setActive(soapModel.getActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MemberCategory> toModels(MemberCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MemberCategory> models = new ArrayList<MemberCategory>(soapModels.length);

		for (MemberCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.MemberCategory"));

	public MemberCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _memberCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMemberCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _memberCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MemberCategory.class;
	}

	@Override
	public String getModelClassName() {
		return MemberCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberCategoryId", getMemberCategoryId());
		attributes.put("memberCategoryName", getMemberCategoryName());
		attributes.put("memberCategoryGroupName", getMemberCategoryGroupName());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberCategoryId = (Long)attributes.get("memberCategoryId");

		if (memberCategoryId != null) {
			setMemberCategoryId(memberCategoryId);
		}

		String memberCategoryName = (String)attributes.get("memberCategoryName");

		if (memberCategoryName != null) {
			setMemberCategoryName(memberCategoryName);
		}

		String memberCategoryGroupName = (String)attributes.get(
				"memberCategoryGroupName");

		if (memberCategoryGroupName != null) {
			setMemberCategoryGroupName(memberCategoryGroupName);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@JSON
	@Override
	public long getMemberCategoryId() {
		return _memberCategoryId;
	}

	@Override
	public void setMemberCategoryId(long memberCategoryId) {
		_memberCategoryId = memberCategoryId;
	}

	@JSON
	@Override
	public String getMemberCategoryName() {
		if (_memberCategoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _memberCategoryName;
		}
	}

	@Override
	public void setMemberCategoryName(String memberCategoryName) {
		_memberCategoryName = memberCategoryName;
	}

	@JSON
	@Override
	public String getMemberCategoryGroupName() {
		if (_memberCategoryGroupName == null) {
			return StringPool.BLANK;
		}
		else {
			return _memberCategoryGroupName;
		}
	}

	@Override
	public void setMemberCategoryGroupName(String memberCategoryGroupName) {
		_memberCategoryGroupName = memberCategoryGroupName;
	}

	@JSON
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
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MemberCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MemberCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MemberCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MemberCategoryImpl memberCategoryImpl = new MemberCategoryImpl();

		memberCategoryImpl.setMemberCategoryId(getMemberCategoryId());
		memberCategoryImpl.setMemberCategoryName(getMemberCategoryName());
		memberCategoryImpl.setMemberCategoryGroupName(getMemberCategoryGroupName());
		memberCategoryImpl.setActive(getActive());

		memberCategoryImpl.resetOriginalValues();

		return memberCategoryImpl;
	}

	@Override
	public int compareTo(MemberCategory memberCategory) {
		long primaryKey = memberCategory.getPrimaryKey();

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

		if (!(obj instanceof MemberCategory)) {
			return false;
		}

		MemberCategory memberCategory = (MemberCategory)obj;

		long primaryKey = memberCategory.getPrimaryKey();

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
	public CacheModel<MemberCategory> toCacheModel() {
		MemberCategoryCacheModel memberCategoryCacheModel = new MemberCategoryCacheModel();

		memberCategoryCacheModel.memberCategoryId = getMemberCategoryId();

		memberCategoryCacheModel.memberCategoryName = getMemberCategoryName();

		String memberCategoryName = memberCategoryCacheModel.memberCategoryName;

		if ((memberCategoryName != null) && (memberCategoryName.length() == 0)) {
			memberCategoryCacheModel.memberCategoryName = null;
		}

		memberCategoryCacheModel.memberCategoryGroupName = getMemberCategoryGroupName();

		String memberCategoryGroupName = memberCategoryCacheModel.memberCategoryGroupName;

		if ((memberCategoryGroupName != null) &&
				(memberCategoryGroupName.length() == 0)) {
			memberCategoryCacheModel.memberCategoryGroupName = null;
		}

		memberCategoryCacheModel.active = getActive();

		return memberCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{memberCategoryId=");
		sb.append(getMemberCategoryId());
		sb.append(", memberCategoryName=");
		sb.append(getMemberCategoryName());
		sb.append(", memberCategoryGroupName=");
		sb.append(getMemberCategoryGroupName());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.MemberCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>memberCategoryId</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberCategoryName</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberCategoryGroupName</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MemberCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MemberCategory.class
		};
	private long _memberCategoryId;
	private String _memberCategoryName;
	private String _memberCategoryGroupName;
	private boolean _active;
	private MemberCategory _escapedModel;
}
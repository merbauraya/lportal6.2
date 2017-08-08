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

import com.idetronic.eis.model.FactLibraryVisitor;
import com.idetronic.eis.model.FactLibraryVisitorModel;
import com.idetronic.eis.model.FactLibraryVisitorSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FactLibraryVisitor service. Represents a row in the &quot;eis_FactLibraryVisitor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.FactLibraryVisitorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FactLibraryVisitorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactLibraryVisitorImpl
 * @see com.idetronic.eis.model.FactLibraryVisitor
 * @see com.idetronic.eis.model.FactLibraryVisitorModel
 * @generated
 */
@JSON(strict = true)
public class FactLibraryVisitorModelImpl extends BaseModelImpl<FactLibraryVisitor>
	implements FactLibraryVisitorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fact library visitor model instance should use the {@link com.idetronic.eis.model.FactLibraryVisitor} interface instead.
	 */
	public static final String TABLE_NAME = "eis_FactLibraryVisitor";
	public static final Object[][] TABLE_COLUMNS = {
			{ "factId", Types.BIGINT },
			{ "libraryId", Types.BIGINT },
			{ "period", Types.VARCHAR },
			{ "visitorCategoryId", Types.BIGINT },
			{ "sessionTotal", Types.BIGINT },
			{ "visitorTotal", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_FactLibraryVisitor (factId LONG not null primary key,libraryId LONG,period VARCHAR(75) null,visitorCategoryId LONG,sessionTotal LONG,visitorTotal LONG,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eis_FactLibraryVisitor";
	public static final String ORDER_BY_JPQL = " ORDER BY factLibraryVisitor.factId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_FactLibraryVisitor.factId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.FactLibraryVisitor"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.FactLibraryVisitor"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FactLibraryVisitor toModel(FactLibraryVisitorSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FactLibraryVisitor model = new FactLibraryVisitorImpl();

		model.setFactId(soapModel.getFactId());
		model.setLibraryId(soapModel.getLibraryId());
		model.setPeriod(soapModel.getPeriod());
		model.setVisitorCategoryId(soapModel.getVisitorCategoryId());
		model.setSessionTotal(soapModel.getSessionTotal());
		model.setVisitorTotal(soapModel.getVisitorTotal());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FactLibraryVisitor> toModels(
		FactLibraryVisitorSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FactLibraryVisitor> models = new ArrayList<FactLibraryVisitor>(soapModels.length);

		for (FactLibraryVisitorSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.FactLibraryVisitor"));

	public FactLibraryVisitorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _factId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FactLibraryVisitor.class;
	}

	@Override
	public String getModelClassName() {
		return FactLibraryVisitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("visitorCategoryId", getVisitorCategoryId());
		attributes.put("sessionTotal", getSessionTotal());
		attributes.put("visitorTotal", getVisitorTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factId = (Long)attributes.get("factId");

		if (factId != null) {
			setFactId(factId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long visitorCategoryId = (Long)attributes.get("visitorCategoryId");

		if (visitorCategoryId != null) {
			setVisitorCategoryId(visitorCategoryId);
		}

		Long sessionTotal = (Long)attributes.get("sessionTotal");

		if (sessionTotal != null) {
			setSessionTotal(sessionTotal);
		}

		Long visitorTotal = (Long)attributes.get("visitorTotal");

		if (visitorTotal != null) {
			setVisitorTotal(visitorTotal);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@JSON
	@Override
	public long getFactId() {
		return _factId;
	}

	@Override
	public void setFactId(long factId) {
		_factId = factId;
	}

	@JSON
	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	@JSON
	@Override
	public String getPeriod() {
		if (_period == null) {
			return StringPool.BLANK;
		}
		else {
			return _period;
		}
	}

	@Override
	public void setPeriod(String period) {
		_period = period;
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
	public long getSessionTotal() {
		return _sessionTotal;
	}

	@Override
	public void setSessionTotal(long sessionTotal) {
		_sessionTotal = sessionTotal;
	}

	@JSON
	@Override
	public long getVisitorTotal() {
		return _visitorTotal;
	}

	@Override
	public void setVisitorTotal(long visitorTotal) {
		_visitorTotal = visitorTotal;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			FactLibraryVisitor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FactLibraryVisitor toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FactLibraryVisitor)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FactLibraryVisitorImpl factLibraryVisitorImpl = new FactLibraryVisitorImpl();

		factLibraryVisitorImpl.setFactId(getFactId());
		factLibraryVisitorImpl.setLibraryId(getLibraryId());
		factLibraryVisitorImpl.setPeriod(getPeriod());
		factLibraryVisitorImpl.setVisitorCategoryId(getVisitorCategoryId());
		factLibraryVisitorImpl.setSessionTotal(getSessionTotal());
		factLibraryVisitorImpl.setVisitorTotal(getVisitorTotal());
		factLibraryVisitorImpl.setCompanyId(getCompanyId());
		factLibraryVisitorImpl.setGroupId(getGroupId());
		factLibraryVisitorImpl.setUserId(getUserId());
		factLibraryVisitorImpl.setUserName(getUserName());
		factLibraryVisitorImpl.setCreateDate(getCreateDate());

		factLibraryVisitorImpl.resetOriginalValues();

		return factLibraryVisitorImpl;
	}

	@Override
	public int compareTo(FactLibraryVisitor factLibraryVisitor) {
		long primaryKey = factLibraryVisitor.getPrimaryKey();

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

		if (!(obj instanceof FactLibraryVisitor)) {
			return false;
		}

		FactLibraryVisitor factLibraryVisitor = (FactLibraryVisitor)obj;

		long primaryKey = factLibraryVisitor.getPrimaryKey();

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
	public CacheModel<FactLibraryVisitor> toCacheModel() {
		FactLibraryVisitorCacheModel factLibraryVisitorCacheModel = new FactLibraryVisitorCacheModel();

		factLibraryVisitorCacheModel.factId = getFactId();

		factLibraryVisitorCacheModel.libraryId = getLibraryId();

		factLibraryVisitorCacheModel.period = getPeriod();

		String period = factLibraryVisitorCacheModel.period;

		if ((period != null) && (period.length() == 0)) {
			factLibraryVisitorCacheModel.period = null;
		}

		factLibraryVisitorCacheModel.visitorCategoryId = getVisitorCategoryId();

		factLibraryVisitorCacheModel.sessionTotal = getSessionTotal();

		factLibraryVisitorCacheModel.visitorTotal = getVisitorTotal();

		factLibraryVisitorCacheModel.companyId = getCompanyId();

		factLibraryVisitorCacheModel.groupId = getGroupId();

		factLibraryVisitorCacheModel.userId = getUserId();

		factLibraryVisitorCacheModel.userName = getUserName();

		String userName = factLibraryVisitorCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			factLibraryVisitorCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			factLibraryVisitorCacheModel.createDate = createDate.getTime();
		}
		else {
			factLibraryVisitorCacheModel.createDate = Long.MIN_VALUE;
		}

		return factLibraryVisitorCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{factId=");
		sb.append(getFactId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", visitorCategoryId=");
		sb.append(getVisitorCategoryId());
		sb.append(", sessionTotal=");
		sb.append(getSessionTotal());
		sb.append(", visitorTotal=");
		sb.append(getVisitorTotal());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactLibraryVisitor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factId</column-name><column-value><![CDATA[");
		sb.append(getFactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorCategoryId</column-name><column-value><![CDATA[");
		sb.append(getVisitorCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionTotal</column-name><column-value><![CDATA[");
		sb.append(getSessionTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitorTotal</column-name><column-value><![CDATA[");
		sb.append(getVisitorTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FactLibraryVisitor.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FactLibraryVisitor.class
		};
	private long _factId;
	private long _libraryId;
	private String _period;
	private long _visitorCategoryId;
	private long _sessionTotal;
	private long _visitorTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private FactLibraryVisitor _escapedModel;
}
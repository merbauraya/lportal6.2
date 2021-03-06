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

import com.idetronic.eis.model.FactConsultation;
import com.idetronic.eis.model.FactConsultationModel;
import com.idetronic.eis.model.FactConsultationSoap;

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
 * The base model implementation for the FactConsultation service. Represents a row in the &quot;eis_FactConsultation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.FactConsultationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FactConsultationImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactConsultationImpl
 * @see com.idetronic.eis.model.FactConsultation
 * @see com.idetronic.eis.model.FactConsultationModel
 * @generated
 */
@JSON(strict = true)
public class FactConsultationModelImpl extends BaseModelImpl<FactConsultation>
	implements FactConsultationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fact consultation model instance should use the {@link com.idetronic.eis.model.FactConsultation} interface instead.
	 */
	public static final String TABLE_NAME = "eis_FactConsultation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "factConsultationId", Types.BIGINT },
			{ "libraryId", Types.BIGINT },
			{ "period", Types.VARCHAR },
			{ "consultationGroupId", Types.BIGINT },
			{ "consultationCategoryId", Types.BIGINT },
			{ "value", Types.BIGINT },
			{ "totalSession", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_FactConsultation (factConsultationId LONG not null primary key,libraryId LONG,period VARCHAR(75) null,consultationGroupId LONG,consultationCategoryId LONG,value LONG,totalSession LONG,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eis_FactConsultation";
	public static final String ORDER_BY_JPQL = " ORDER BY factConsultation.factConsultationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_FactConsultation.factConsultationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.FactConsultation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.FactConsultation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eis.model.FactConsultation"),
			true);
	public static long LIBRARYID_COLUMN_BITMASK = 1L;
	public static long FACTCONSULTATIONID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FactConsultation toModel(FactConsultationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FactConsultation model = new FactConsultationImpl();

		model.setFactConsultationId(soapModel.getFactConsultationId());
		model.setLibraryId(soapModel.getLibraryId());
		model.setPeriod(soapModel.getPeriod());
		model.setConsultationGroupId(soapModel.getConsultationGroupId());
		model.setConsultationCategoryId(soapModel.getConsultationCategoryId());
		model.setValue(soapModel.getValue());
		model.setTotalSession(soapModel.getTotalSession());
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
	public static List<FactConsultation> toModels(
		FactConsultationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FactConsultation> models = new ArrayList<FactConsultation>(soapModels.length);

		for (FactConsultationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.FactConsultation"));

	public FactConsultationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _factConsultationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactConsultationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factConsultationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FactConsultation.class;
	}

	@Override
	public String getModelClassName() {
		return FactConsultation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factConsultationId", getFactConsultationId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("consultationGroupId", getConsultationGroupId());
		attributes.put("consultationCategoryId", getConsultationCategoryId());
		attributes.put("value", getValue());
		attributes.put("totalSession", getTotalSession());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factConsultationId = (Long)attributes.get("factConsultationId");

		if (factConsultationId != null) {
			setFactConsultationId(factConsultationId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long consultationGroupId = (Long)attributes.get("consultationGroupId");

		if (consultationGroupId != null) {
			setConsultationGroupId(consultationGroupId);
		}

		Long consultationCategoryId = (Long)attributes.get(
				"consultationCategoryId");

		if (consultationCategoryId != null) {
			setConsultationCategoryId(consultationCategoryId);
		}

		Long value = (Long)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Long totalSession = (Long)attributes.get("totalSession");

		if (totalSession != null) {
			setTotalSession(totalSession);
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
	public long getFactConsultationId() {
		return _factConsultationId;
	}

	@Override
	public void setFactConsultationId(long factConsultationId) {
		_factConsultationId = factConsultationId;
	}

	@JSON
	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_columnBitmask |= LIBRARYID_COLUMN_BITMASK;

		if (!_setOriginalLibraryId) {
			_setOriginalLibraryId = true;

			_originalLibraryId = _libraryId;
		}

		_libraryId = libraryId;
	}

	public long getOriginalLibraryId() {
		return _originalLibraryId;
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
	public long getConsultationGroupId() {
		return _consultationGroupId;
	}

	@Override
	public void setConsultationGroupId(long consultationGroupId) {
		_consultationGroupId = consultationGroupId;
	}

	@JSON
	@Override
	public long getConsultationCategoryId() {
		return _consultationCategoryId;
	}

	@Override
	public void setConsultationCategoryId(long consultationCategoryId) {
		_consultationCategoryId = consultationCategoryId;
	}

	@JSON
	@Override
	public long getValue() {
		return _value;
	}

	@Override
	public void setValue(long value) {
		_value = value;
	}

	@JSON
	@Override
	public long getTotalSession() {
		return _totalSession;
	}

	@Override
	public void setTotalSession(long totalSession) {
		_totalSession = totalSession;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			FactConsultation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FactConsultation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FactConsultation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FactConsultationImpl factConsultationImpl = new FactConsultationImpl();

		factConsultationImpl.setFactConsultationId(getFactConsultationId());
		factConsultationImpl.setLibraryId(getLibraryId());
		factConsultationImpl.setPeriod(getPeriod());
		factConsultationImpl.setConsultationGroupId(getConsultationGroupId());
		factConsultationImpl.setConsultationCategoryId(getConsultationCategoryId());
		factConsultationImpl.setValue(getValue());
		factConsultationImpl.setTotalSession(getTotalSession());
		factConsultationImpl.setCompanyId(getCompanyId());
		factConsultationImpl.setGroupId(getGroupId());
		factConsultationImpl.setUserId(getUserId());
		factConsultationImpl.setUserName(getUserName());
		factConsultationImpl.setCreateDate(getCreateDate());

		factConsultationImpl.resetOriginalValues();

		return factConsultationImpl;
	}

	@Override
	public int compareTo(FactConsultation factConsultation) {
		long primaryKey = factConsultation.getPrimaryKey();

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

		if (!(obj instanceof FactConsultation)) {
			return false;
		}

		FactConsultation factConsultation = (FactConsultation)obj;

		long primaryKey = factConsultation.getPrimaryKey();

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
		FactConsultationModelImpl factConsultationModelImpl = this;

		factConsultationModelImpl._originalLibraryId = factConsultationModelImpl._libraryId;

		factConsultationModelImpl._setOriginalLibraryId = false;

		factConsultationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FactConsultation> toCacheModel() {
		FactConsultationCacheModel factConsultationCacheModel = new FactConsultationCacheModel();

		factConsultationCacheModel.factConsultationId = getFactConsultationId();

		factConsultationCacheModel.libraryId = getLibraryId();

		factConsultationCacheModel.period = getPeriod();

		String period = factConsultationCacheModel.period;

		if ((period != null) && (period.length() == 0)) {
			factConsultationCacheModel.period = null;
		}

		factConsultationCacheModel.consultationGroupId = getConsultationGroupId();

		factConsultationCacheModel.consultationCategoryId = getConsultationCategoryId();

		factConsultationCacheModel.value = getValue();

		factConsultationCacheModel.totalSession = getTotalSession();

		factConsultationCacheModel.companyId = getCompanyId();

		factConsultationCacheModel.groupId = getGroupId();

		factConsultationCacheModel.userId = getUserId();

		factConsultationCacheModel.userName = getUserName();

		String userName = factConsultationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			factConsultationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			factConsultationCacheModel.createDate = createDate.getTime();
		}
		else {
			factConsultationCacheModel.createDate = Long.MIN_VALUE;
		}

		return factConsultationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{factConsultationId=");
		sb.append(getFactConsultationId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", consultationGroupId=");
		sb.append(getConsultationGroupId());
		sb.append(", consultationCategoryId=");
		sb.append(getConsultationCategoryId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", totalSession=");
		sb.append(getTotalSession());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactConsultation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factConsultationId</column-name><column-value><![CDATA[");
		sb.append(getFactConsultationId());
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
			"<column><column-name>consultationGroupId</column-name><column-value><![CDATA[");
		sb.append(getConsultationGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consultationCategoryId</column-name><column-value><![CDATA[");
		sb.append(getConsultationCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalSession</column-name><column-value><![CDATA[");
		sb.append(getTotalSession());
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

	private static ClassLoader _classLoader = FactConsultation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FactConsultation.class
		};
	private long _factConsultationId;
	private long _libraryId;
	private long _originalLibraryId;
	private boolean _setOriginalLibraryId;
	private String _period;
	private long _consultationGroupId;
	private long _consultationCategoryId;
	private long _value;
	private long _totalSession;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private long _columnBitmask;
	private FactConsultation _escapedModel;
}
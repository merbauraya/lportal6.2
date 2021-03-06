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

import com.idetronic.eis.model.FactSeating;
import com.idetronic.eis.model.FactSeatingModel;
import com.idetronic.eis.model.FactSeatingSoap;

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
 * The base model implementation for the FactSeating service. Represents a row in the &quot;eis_FactSeating&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.FactSeatingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FactSeatingImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactSeatingImpl
 * @see com.idetronic.eis.model.FactSeating
 * @see com.idetronic.eis.model.FactSeatingModel
 * @generated
 */
@JSON(strict = true)
public class FactSeatingModelImpl extends BaseModelImpl<FactSeating>
	implements FactSeatingModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fact seating model instance should use the {@link com.idetronic.eis.model.FactSeating} interface instead.
	 */
	public static final String TABLE_NAME = "eis_FactSeating";
	public static final Object[][] TABLE_COLUMNS = {
			{ "factSeatingId", Types.BIGINT },
			{ "libraryId", Types.BIGINT },
			{ "departmentId", Types.BIGINT },
			{ "seatingCategoryId", Types.BIGINT },
			{ "stateId", Types.BIGINT },
			{ "libraryTypeId", Types.BIGINT },
			{ "period", Types.VARCHAR },
			{ "capacity", Types.INTEGER },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_FactSeating (factSeatingId LONG not null primary key,libraryId LONG,departmentId LONG,seatingCategoryId LONG,stateId LONG,libraryTypeId LONG,period VARCHAR(75) null,capacity INTEGER,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eis_FactSeating";
	public static final String ORDER_BY_JPQL = " ORDER BY factSeating.factSeatingId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_FactSeating.factSeatingId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.FactSeating"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.FactSeating"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eis.model.FactSeating"),
			true);
	public static long DEPARTMENTID_COLUMN_BITMASK = 1L;
	public static long LIBRARYID_COLUMN_BITMASK = 2L;
	public static long PERIOD_COLUMN_BITMASK = 4L;
	public static long SEATINGCATEGORYID_COLUMN_BITMASK = 8L;
	public static long FACTSEATINGID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FactSeating toModel(FactSeatingSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FactSeating model = new FactSeatingImpl();

		model.setFactSeatingId(soapModel.getFactSeatingId());
		model.setLibraryId(soapModel.getLibraryId());
		model.setDepartmentId(soapModel.getDepartmentId());
		model.setSeatingCategoryId(soapModel.getSeatingCategoryId());
		model.setStateId(soapModel.getStateId());
		model.setLibraryTypeId(soapModel.getLibraryTypeId());
		model.setPeriod(soapModel.getPeriod());
		model.setCapacity(soapModel.getCapacity());
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
	public static List<FactSeating> toModels(FactSeatingSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FactSeating> models = new ArrayList<FactSeating>(soapModels.length);

		for (FactSeatingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.FactSeating"));

	public FactSeatingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _factSeatingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactSeatingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factSeatingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FactSeating.class;
	}

	@Override
	public String getModelClassName() {
		return FactSeating.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factSeatingId", getFactSeatingId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("seatingCategoryId", getSeatingCategoryId());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("period", getPeriod());
		attributes.put("capacity", getCapacity());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factSeatingId = (Long)attributes.get("factSeatingId");

		if (factSeatingId != null) {
			setFactSeatingId(factSeatingId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long seatingCategoryId = (Long)attributes.get("seatingCategoryId");

		if (seatingCategoryId != null) {
			setSeatingCategoryId(seatingCategoryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Integer capacity = (Integer)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
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
	public long getFactSeatingId() {
		return _factSeatingId;
	}

	@Override
	public void setFactSeatingId(long factSeatingId) {
		_factSeatingId = factSeatingId;
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
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_columnBitmask |= DEPARTMENTID_COLUMN_BITMASK;

		if (!_setOriginalDepartmentId) {
			_setOriginalDepartmentId = true;

			_originalDepartmentId = _departmentId;
		}

		_departmentId = departmentId;
	}

	public long getOriginalDepartmentId() {
		return _originalDepartmentId;
	}

	@JSON
	@Override
	public long getSeatingCategoryId() {
		return _seatingCategoryId;
	}

	@Override
	public void setSeatingCategoryId(long seatingCategoryId) {
		_columnBitmask |= SEATINGCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalSeatingCategoryId) {
			_setOriginalSeatingCategoryId = true;

			_originalSeatingCategoryId = _seatingCategoryId;
		}

		_seatingCategoryId = seatingCategoryId;
	}

	public long getOriginalSeatingCategoryId() {
		return _originalSeatingCategoryId;
	}

	@JSON
	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	@JSON
	@Override
	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;
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
		_columnBitmask |= PERIOD_COLUMN_BITMASK;

		if (_originalPeriod == null) {
			_originalPeriod = _period;
		}

		_period = period;
	}

	public String getOriginalPeriod() {
		return GetterUtil.getString(_originalPeriod);
	}

	@JSON
	@Override
	public int getCapacity() {
		return _capacity;
	}

	@Override
	public void setCapacity(int capacity) {
		_capacity = capacity;
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
			FactSeating.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FactSeating toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FactSeating)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FactSeatingImpl factSeatingImpl = new FactSeatingImpl();

		factSeatingImpl.setFactSeatingId(getFactSeatingId());
		factSeatingImpl.setLibraryId(getLibraryId());
		factSeatingImpl.setDepartmentId(getDepartmentId());
		factSeatingImpl.setSeatingCategoryId(getSeatingCategoryId());
		factSeatingImpl.setStateId(getStateId());
		factSeatingImpl.setLibraryTypeId(getLibraryTypeId());
		factSeatingImpl.setPeriod(getPeriod());
		factSeatingImpl.setCapacity(getCapacity());
		factSeatingImpl.setCompanyId(getCompanyId());
		factSeatingImpl.setGroupId(getGroupId());
		factSeatingImpl.setUserId(getUserId());
		factSeatingImpl.setUserName(getUserName());
		factSeatingImpl.setCreateDate(getCreateDate());

		factSeatingImpl.resetOriginalValues();

		return factSeatingImpl;
	}

	@Override
	public int compareTo(FactSeating factSeating) {
		long primaryKey = factSeating.getPrimaryKey();

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

		if (!(obj instanceof FactSeating)) {
			return false;
		}

		FactSeating factSeating = (FactSeating)obj;

		long primaryKey = factSeating.getPrimaryKey();

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
		FactSeatingModelImpl factSeatingModelImpl = this;

		factSeatingModelImpl._originalLibraryId = factSeatingModelImpl._libraryId;

		factSeatingModelImpl._setOriginalLibraryId = false;

		factSeatingModelImpl._originalDepartmentId = factSeatingModelImpl._departmentId;

		factSeatingModelImpl._setOriginalDepartmentId = false;

		factSeatingModelImpl._originalSeatingCategoryId = factSeatingModelImpl._seatingCategoryId;

		factSeatingModelImpl._setOriginalSeatingCategoryId = false;

		factSeatingModelImpl._originalPeriod = factSeatingModelImpl._period;

		factSeatingModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FactSeating> toCacheModel() {
		FactSeatingCacheModel factSeatingCacheModel = new FactSeatingCacheModel();

		factSeatingCacheModel.factSeatingId = getFactSeatingId();

		factSeatingCacheModel.libraryId = getLibraryId();

		factSeatingCacheModel.departmentId = getDepartmentId();

		factSeatingCacheModel.seatingCategoryId = getSeatingCategoryId();

		factSeatingCacheModel.stateId = getStateId();

		factSeatingCacheModel.libraryTypeId = getLibraryTypeId();

		factSeatingCacheModel.period = getPeriod();

		String period = factSeatingCacheModel.period;

		if ((period != null) && (period.length() == 0)) {
			factSeatingCacheModel.period = null;
		}

		factSeatingCacheModel.capacity = getCapacity();

		factSeatingCacheModel.companyId = getCompanyId();

		factSeatingCacheModel.groupId = getGroupId();

		factSeatingCacheModel.userId = getUserId();

		factSeatingCacheModel.userName = getUserName();

		String userName = factSeatingCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			factSeatingCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			factSeatingCacheModel.createDate = createDate.getTime();
		}
		else {
			factSeatingCacheModel.createDate = Long.MIN_VALUE;
		}

		return factSeatingCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{factSeatingId=");
		sb.append(getFactSeatingId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", seatingCategoryId=");
		sb.append(getSeatingCategoryId());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", capacity=");
		sb.append(getCapacity());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactSeating");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factSeatingId</column-name><column-value><![CDATA[");
		sb.append(getFactSeatingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seatingCategoryId</column-name><column-value><![CDATA[");
		sb.append(getSeatingCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryTypeId</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
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

	private static ClassLoader _classLoader = FactSeating.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FactSeating.class
		};
	private long _factSeatingId;
	private long _libraryId;
	private long _originalLibraryId;
	private boolean _setOriginalLibraryId;
	private long _departmentId;
	private long _originalDepartmentId;
	private boolean _setOriginalDepartmentId;
	private long _seatingCategoryId;
	private long _originalSeatingCategoryId;
	private boolean _setOriginalSeatingCategoryId;
	private long _stateId;
	private long _libraryTypeId;
	private String _period;
	private String _originalPeriod;
	private int _capacity;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private long _columnBitmask;
	private FactSeating _escapedModel;
}
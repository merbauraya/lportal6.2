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

import com.idetronic.eis.model.FactExpense;
import com.idetronic.eis.model.FactExpenseModel;
import com.idetronic.eis.model.FactExpenseSoap;

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
 * The base model implementation for the FactExpense service. Represents a row in the &quot;eis_FactExpense&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.FactExpenseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FactExpenseImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactExpenseImpl
 * @see com.idetronic.eis.model.FactExpense
 * @see com.idetronic.eis.model.FactExpenseModel
 * @generated
 */
@JSON(strict = true)
public class FactExpenseModelImpl extends BaseModelImpl<FactExpense>
	implements FactExpenseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fact expense model instance should use the {@link com.idetronic.eis.model.FactExpense} interface instead.
	 */
	public static final String TABLE_NAME = "eis_FactExpense";
	public static final Object[][] TABLE_COLUMNS = {
			{ "factExpenseId", Types.BIGINT },
			{ "libraryId", Types.BIGINT },
			{ "period", Types.VARCHAR },
			{ "entryType", Types.INTEGER },
			{ "masterFileId", Types.BIGINT },
			{ "amount", Types.DOUBLE },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_FactExpense (factExpenseId LONG not null primary key,libraryId LONG,period VARCHAR(75) null,entryType INTEGER,masterFileId LONG,amount DOUBLE,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eis_FactExpense";
	public static final String ORDER_BY_JPQL = " ORDER BY factExpense.factExpenseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_FactExpense.factExpenseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.FactExpense"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.FactExpense"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eis.model.FactExpense"),
			true);
	public static long LIBRARYID_COLUMN_BITMASK = 1L;
	public static long FACTEXPENSEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FactExpense toModel(FactExpenseSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FactExpense model = new FactExpenseImpl();

		model.setFactExpenseId(soapModel.getFactExpenseId());
		model.setLibraryId(soapModel.getLibraryId());
		model.setPeriod(soapModel.getPeriod());
		model.setEntryType(soapModel.getEntryType());
		model.setMasterFileId(soapModel.getMasterFileId());
		model.setAmount(soapModel.getAmount());
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
	public static List<FactExpense> toModels(FactExpenseSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FactExpense> models = new ArrayList<FactExpense>(soapModels.length);

		for (FactExpenseSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.FactExpense"));

	public FactExpenseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _factExpenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactExpenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factExpenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FactExpense.class;
	}

	@Override
	public String getModelClassName() {
		return FactExpense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factExpenseId", getFactExpenseId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("entryType", getEntryType());
		attributes.put("masterFileId", getMasterFileId());
		attributes.put("amount", getAmount());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factExpenseId = (Long)attributes.get("factExpenseId");

		if (factExpenseId != null) {
			setFactExpenseId(factExpenseId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Integer entryType = (Integer)attributes.get("entryType");

		if (entryType != null) {
			setEntryType(entryType);
		}

		Long masterFileId = (Long)attributes.get("masterFileId");

		if (masterFileId != null) {
			setMasterFileId(masterFileId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
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
	public long getFactExpenseId() {
		return _factExpenseId;
	}

	@Override
	public void setFactExpenseId(long factExpenseId) {
		_factExpenseId = factExpenseId;
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
	public int getEntryType() {
		return _entryType;
	}

	@Override
	public void setEntryType(int entryType) {
		_entryType = entryType;
	}

	@JSON
	@Override
	public long getMasterFileId() {
		return _masterFileId;
	}

	@Override
	public void setMasterFileId(long masterFileId) {
		_masterFileId = masterFileId;
	}

	@JSON
	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;
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
			FactExpense.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FactExpense toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FactExpense)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FactExpenseImpl factExpenseImpl = new FactExpenseImpl();

		factExpenseImpl.setFactExpenseId(getFactExpenseId());
		factExpenseImpl.setLibraryId(getLibraryId());
		factExpenseImpl.setPeriod(getPeriod());
		factExpenseImpl.setEntryType(getEntryType());
		factExpenseImpl.setMasterFileId(getMasterFileId());
		factExpenseImpl.setAmount(getAmount());
		factExpenseImpl.setCompanyId(getCompanyId());
		factExpenseImpl.setGroupId(getGroupId());
		factExpenseImpl.setUserId(getUserId());
		factExpenseImpl.setUserName(getUserName());
		factExpenseImpl.setCreateDate(getCreateDate());

		factExpenseImpl.resetOriginalValues();

		return factExpenseImpl;
	}

	@Override
	public int compareTo(FactExpense factExpense) {
		long primaryKey = factExpense.getPrimaryKey();

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

		if (!(obj instanceof FactExpense)) {
			return false;
		}

		FactExpense factExpense = (FactExpense)obj;

		long primaryKey = factExpense.getPrimaryKey();

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
		FactExpenseModelImpl factExpenseModelImpl = this;

		factExpenseModelImpl._originalLibraryId = factExpenseModelImpl._libraryId;

		factExpenseModelImpl._setOriginalLibraryId = false;

		factExpenseModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FactExpense> toCacheModel() {
		FactExpenseCacheModel factExpenseCacheModel = new FactExpenseCacheModel();

		factExpenseCacheModel.factExpenseId = getFactExpenseId();

		factExpenseCacheModel.libraryId = getLibraryId();

		factExpenseCacheModel.period = getPeriod();

		String period = factExpenseCacheModel.period;

		if ((period != null) && (period.length() == 0)) {
			factExpenseCacheModel.period = null;
		}

		factExpenseCacheModel.entryType = getEntryType();

		factExpenseCacheModel.masterFileId = getMasterFileId();

		factExpenseCacheModel.amount = getAmount();

		factExpenseCacheModel.companyId = getCompanyId();

		factExpenseCacheModel.groupId = getGroupId();

		factExpenseCacheModel.userId = getUserId();

		factExpenseCacheModel.userName = getUserName();

		String userName = factExpenseCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			factExpenseCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			factExpenseCacheModel.createDate = createDate.getTime();
		}
		else {
			factExpenseCacheModel.createDate = Long.MIN_VALUE;
		}

		return factExpenseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{factExpenseId=");
		sb.append(getFactExpenseId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", entryType=");
		sb.append(getEntryType());
		sb.append(", masterFileId=");
		sb.append(getMasterFileId());
		sb.append(", amount=");
		sb.append(getAmount());
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
		sb.append("com.idetronic.eis.model.FactExpense");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factExpenseId</column-name><column-value><![CDATA[");
		sb.append(getFactExpenseId());
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
			"<column><column-name>entryType</column-name><column-value><![CDATA[");
		sb.append(getEntryType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterFileId</column-name><column-value><![CDATA[");
		sb.append(getMasterFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
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

	private static ClassLoader _classLoader = FactExpense.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FactExpense.class
		};
	private long _factExpenseId;
	private long _libraryId;
	private long _originalLibraryId;
	private boolean _setOriginalLibraryId;
	private String _period;
	private int _entryType;
	private long _masterFileId;
	private double _amount;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private long _columnBitmask;
	private FactExpense _escapedModel;
}
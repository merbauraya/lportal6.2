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

import com.idetronic.eis.model.ProjectStrategy;
import com.idetronic.eis.model.ProjectStrategyModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ProjectStrategy service. Represents a row in the &quot;eis_ProjectStrategy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.ProjectStrategyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectStrategyImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectStrategyImpl
 * @see com.idetronic.eis.model.ProjectStrategy
 * @see com.idetronic.eis.model.ProjectStrategyModel
 * @generated
 */
public class ProjectStrategyModelImpl extends BaseModelImpl<ProjectStrategy>
	implements ProjectStrategyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project strategy model instance should use the {@link com.idetronic.eis.model.ProjectStrategy} interface instead.
	 */
	public static final String TABLE_NAME = "eis_ProjectStrategy";
	public static final Object[][] TABLE_COLUMNS = {
			{ "projectStrategyId", Types.BIGINT },
			{ "strategyName", Types.VARCHAR },
			{ "projectId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "startMonth", Types.INTEGER },
			{ "startYear", Types.INTEGER },
			{ "startMonthName", Types.VARCHAR },
			{ "endMonth", Types.INTEGER },
			{ "endYear", Types.INTEGER },
			{ "endMonthName", Types.VARCHAR },
			{ "completionDate", Types.TIMESTAMP },
			{ "projectStrategyStatus", Types.INTEGER },
			{ "userId", Types.BIGINT },
			{ "progress", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "progressStatus", Types.INTEGER },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "resourceName", Types.VARCHAR },
			{ "resourceType", Types.VARCHAR },
			{ "remark", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_ProjectStrategy (projectStrategyId LONG not null primary key,strategyName VARCHAR(150) null,projectId LONG,userName VARCHAR(75) null,startDate DATE null,endDate DATE null,startMonth INTEGER,startYear INTEGER,startMonthName VARCHAR(20) null,endMonth INTEGER,endYear INTEGER,endMonthName VARCHAR(20) null,completionDate DATE null,projectStrategyStatus INTEGER,userId LONG,progress INTEGER,status INTEGER,progressStatus INTEGER,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,resourceName VARCHAR(75) null,resourceType VARCHAR(75) null,remark TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table eis_ProjectStrategy";
	public static final String ORDER_BY_JPQL = " ORDER BY projectStrategy.startDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_ProjectStrategy.startDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.ProjectStrategy"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.ProjectStrategy"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eis.model.ProjectStrategy"),
			true);
	public static long PROJECTID_COLUMN_BITMASK = 1L;
	public static long STARTDATE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.ProjectStrategy"));

	public ProjectStrategyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectStrategyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectStrategyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectStrategyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectStrategy.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectStrategy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectStrategyId", getProjectStrategyId());
		attributes.put("strategyName", getStrategyName());
		attributes.put("projectId", getProjectId());
		attributes.put("userName", getUserName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startYear", getStartYear());
		attributes.put("startMonthName", getStartMonthName());
		attributes.put("endMonth", getEndMonth());
		attributes.put("endYear", getEndYear());
		attributes.put("endMonthName", getEndMonthName());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("projectStrategyStatus", getProjectStrategyStatus());
		attributes.put("userId", getUserId());
		attributes.put("progress", getProgress());
		attributes.put("status", getStatus());
		attributes.put("progressStatus", getProgressStatus());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("resourceName", getResourceName());
		attributes.put("resourceType", getResourceType());
		attributes.put("remark", getRemark());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectStrategyId = (Long)attributes.get("projectStrategyId");

		if (projectStrategyId != null) {
			setProjectStrategyId(projectStrategyId);
		}

		String strategyName = (String)attributes.get("strategyName");

		if (strategyName != null) {
			setStrategyName(strategyName);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer startMonth = (Integer)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		Integer startYear = (Integer)attributes.get("startYear");

		if (startYear != null) {
			setStartYear(startYear);
		}

		String startMonthName = (String)attributes.get("startMonthName");

		if (startMonthName != null) {
			setStartMonthName(startMonthName);
		}

		Integer endMonth = (Integer)attributes.get("endMonth");

		if (endMonth != null) {
			setEndMonth(endMonth);
		}

		Integer endYear = (Integer)attributes.get("endYear");

		if (endYear != null) {
			setEndYear(endYear);
		}

		String endMonthName = (String)attributes.get("endMonthName");

		if (endMonthName != null) {
			setEndMonthName(endMonthName);
		}

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
		}

		Integer projectStrategyStatus = (Integer)attributes.get(
				"projectStrategyStatus");

		if (projectStrategyStatus != null) {
			setProjectStrategyStatus(projectStrategyStatus);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer progressStatus = (Integer)attributes.get("progressStatus");

		if (progressStatus != null) {
			setProgressStatus(progressStatus);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String resourceName = (String)attributes.get("resourceName");

		if (resourceName != null) {
			setResourceName(resourceName);
		}

		String resourceType = (String)attributes.get("resourceType");

		if (resourceType != null) {
			setResourceType(resourceType);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}
	}

	@Override
	public long getProjectStrategyId() {
		return _projectStrategyId;
	}

	@Override
	public void setProjectStrategyId(long projectStrategyId) {
		_projectStrategyId = projectStrategyId;
	}

	@Override
	public String getStrategyName() {
		if (_strategyName == null) {
			return StringPool.BLANK;
		}
		else {
			return _strategyName;
		}
	}

	@Override
	public void setStrategyName(String strategyName) {
		_strategyName = strategyName;
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_columnBitmask |= PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalProjectId) {
			_setOriginalProjectId = true;

			_originalProjectId = _projectId;
		}

		_projectId = projectId;
	}

	public long getOriginalProjectId() {
		return _originalProjectId;
	}

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

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_columnBitmask = -1L;

		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public int getStartMonth() {
		return _startMonth;
	}

	@Override
	public void setStartMonth(int startMonth) {
		_startMonth = startMonth;
	}

	@Override
	public int getStartYear() {
		return _startYear;
	}

	@Override
	public void setStartYear(int startYear) {
		_startYear = startYear;
	}

	@Override
	public String getStartMonthName() {
		if (_startMonthName == null) {
			return StringPool.BLANK;
		}
		else {
			return _startMonthName;
		}
	}

	@Override
	public void setStartMonthName(String startMonthName) {
		_startMonthName = startMonthName;
	}

	@Override
	public int getEndMonth() {
		return _endMonth;
	}

	@Override
	public void setEndMonth(int endMonth) {
		_endMonth = endMonth;
	}

	@Override
	public int getEndYear() {
		return _endYear;
	}

	@Override
	public void setEndYear(int endYear) {
		_endYear = endYear;
	}

	@Override
	public String getEndMonthName() {
		if (_endMonthName == null) {
			return StringPool.BLANK;
		}
		else {
			return _endMonthName;
		}
	}

	@Override
	public void setEndMonthName(String endMonthName) {
		_endMonthName = endMonthName;
	}

	@Override
	public Date getCompletionDate() {
		return _completionDate;
	}

	@Override
	public void setCompletionDate(Date completionDate) {
		_completionDate = completionDate;
	}

	@Override
	public int getProjectStrategyStatus() {
		return _projectStrategyStatus;
	}

	@Override
	public void setProjectStrategyStatus(int projectStrategyStatus) {
		_projectStrategyStatus = projectStrategyStatus;
	}

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

	@Override
	public int getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(int progress) {
		_progress = progress;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public int getProgressStatus() {
		return _progressStatus;
	}

	@Override
	public void setProgressStatus(int progressStatus) {
		_progressStatus = progressStatus;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getResourceName() {
		if (_resourceName == null) {
			return StringPool.BLANK;
		}
		else {
			return _resourceName;
		}
	}

	@Override
	public void setResourceName(String resourceName) {
		_resourceName = resourceName;
	}

	@Override
	public String getResourceType() {
		if (_resourceType == null) {
			return StringPool.BLANK;
		}
		else {
			return _resourceType;
		}
	}

	@Override
	public void setResourceType(String resourceType) {
		_resourceType = resourceType;
	}

	@Override
	public String getRemark() {
		if (_remark == null) {
			return StringPool.BLANK;
		}
		else {
			return _remark;
		}
	}

	@Override
	public void setRemark(String remark) {
		_remark = remark;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ProjectStrategy.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectStrategy toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProjectStrategy)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectStrategyImpl projectStrategyImpl = new ProjectStrategyImpl();

		projectStrategyImpl.setProjectStrategyId(getProjectStrategyId());
		projectStrategyImpl.setStrategyName(getStrategyName());
		projectStrategyImpl.setProjectId(getProjectId());
		projectStrategyImpl.setUserName(getUserName());
		projectStrategyImpl.setStartDate(getStartDate());
		projectStrategyImpl.setEndDate(getEndDate());
		projectStrategyImpl.setStartMonth(getStartMonth());
		projectStrategyImpl.setStartYear(getStartYear());
		projectStrategyImpl.setStartMonthName(getStartMonthName());
		projectStrategyImpl.setEndMonth(getEndMonth());
		projectStrategyImpl.setEndYear(getEndYear());
		projectStrategyImpl.setEndMonthName(getEndMonthName());
		projectStrategyImpl.setCompletionDate(getCompletionDate());
		projectStrategyImpl.setProjectStrategyStatus(getProjectStrategyStatus());
		projectStrategyImpl.setUserId(getUserId());
		projectStrategyImpl.setProgress(getProgress());
		projectStrategyImpl.setStatus(getStatus());
		projectStrategyImpl.setProgressStatus(getProgressStatus());
		projectStrategyImpl.setGroupId(getGroupId());
		projectStrategyImpl.setCompanyId(getCompanyId());
		projectStrategyImpl.setCreateDate(getCreateDate());
		projectStrategyImpl.setModifiedDate(getModifiedDate());
		projectStrategyImpl.setResourceName(getResourceName());
		projectStrategyImpl.setResourceType(getResourceType());
		projectStrategyImpl.setRemark(getRemark());

		projectStrategyImpl.resetOriginalValues();

		return projectStrategyImpl;
	}

	@Override
	public int compareTo(ProjectStrategy projectStrategy) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(),
				projectStrategy.getStartDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectStrategy)) {
			return false;
		}

		ProjectStrategy projectStrategy = (ProjectStrategy)obj;

		long primaryKey = projectStrategy.getPrimaryKey();

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
		ProjectStrategyModelImpl projectStrategyModelImpl = this;

		projectStrategyModelImpl._originalProjectId = projectStrategyModelImpl._projectId;

		projectStrategyModelImpl._setOriginalProjectId = false;

		projectStrategyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectStrategy> toCacheModel() {
		ProjectStrategyCacheModel projectStrategyCacheModel = new ProjectStrategyCacheModel();

		projectStrategyCacheModel.projectStrategyId = getProjectStrategyId();

		projectStrategyCacheModel.strategyName = getStrategyName();

		String strategyName = projectStrategyCacheModel.strategyName;

		if ((strategyName != null) && (strategyName.length() == 0)) {
			projectStrategyCacheModel.strategyName = null;
		}

		projectStrategyCacheModel.projectId = getProjectId();

		projectStrategyCacheModel.userName = getUserName();

		String userName = projectStrategyCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			projectStrategyCacheModel.userName = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			projectStrategyCacheModel.startDate = startDate.getTime();
		}
		else {
			projectStrategyCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			projectStrategyCacheModel.endDate = endDate.getTime();
		}
		else {
			projectStrategyCacheModel.endDate = Long.MIN_VALUE;
		}

		projectStrategyCacheModel.startMonth = getStartMonth();

		projectStrategyCacheModel.startYear = getStartYear();

		projectStrategyCacheModel.startMonthName = getStartMonthName();

		String startMonthName = projectStrategyCacheModel.startMonthName;

		if ((startMonthName != null) && (startMonthName.length() == 0)) {
			projectStrategyCacheModel.startMonthName = null;
		}

		projectStrategyCacheModel.endMonth = getEndMonth();

		projectStrategyCacheModel.endYear = getEndYear();

		projectStrategyCacheModel.endMonthName = getEndMonthName();

		String endMonthName = projectStrategyCacheModel.endMonthName;

		if ((endMonthName != null) && (endMonthName.length() == 0)) {
			projectStrategyCacheModel.endMonthName = null;
		}

		Date completionDate = getCompletionDate();

		if (completionDate != null) {
			projectStrategyCacheModel.completionDate = completionDate.getTime();
		}
		else {
			projectStrategyCacheModel.completionDate = Long.MIN_VALUE;
		}

		projectStrategyCacheModel.projectStrategyStatus = getProjectStrategyStatus();

		projectStrategyCacheModel.userId = getUserId();

		projectStrategyCacheModel.progress = getProgress();

		projectStrategyCacheModel.status = getStatus();

		projectStrategyCacheModel.progressStatus = getProgressStatus();

		projectStrategyCacheModel.groupId = getGroupId();

		projectStrategyCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			projectStrategyCacheModel.createDate = createDate.getTime();
		}
		else {
			projectStrategyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			projectStrategyCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			projectStrategyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		projectStrategyCacheModel.resourceName = getResourceName();

		String resourceName = projectStrategyCacheModel.resourceName;

		if ((resourceName != null) && (resourceName.length() == 0)) {
			projectStrategyCacheModel.resourceName = null;
		}

		projectStrategyCacheModel.resourceType = getResourceType();

		String resourceType = projectStrategyCacheModel.resourceType;

		if ((resourceType != null) && (resourceType.length() == 0)) {
			projectStrategyCacheModel.resourceType = null;
		}

		projectStrategyCacheModel.remark = getRemark();

		String remark = projectStrategyCacheModel.remark;

		if ((remark != null) && (remark.length() == 0)) {
			projectStrategyCacheModel.remark = null;
		}

		return projectStrategyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{projectStrategyId=");
		sb.append(getProjectStrategyId());
		sb.append(", strategyName=");
		sb.append(getStrategyName());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", startMonth=");
		sb.append(getStartMonth());
		sb.append(", startYear=");
		sb.append(getStartYear());
		sb.append(", startMonthName=");
		sb.append(getStartMonthName());
		sb.append(", endMonth=");
		sb.append(getEndMonth());
		sb.append(", endYear=");
		sb.append(getEndYear());
		sb.append(", endMonthName=");
		sb.append(getEndMonthName());
		sb.append(", completionDate=");
		sb.append(getCompletionDate());
		sb.append(", projectStrategyStatus=");
		sb.append(getProjectStrategyStatus());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", progress=");
		sb.append(getProgress());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", progressStatus=");
		sb.append(getProgressStatus());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", resourceName=");
		sb.append(getResourceName());
		sb.append(", resourceType=");
		sb.append(getResourceType());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.ProjectStrategy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectStrategyId</column-name><column-value><![CDATA[");
		sb.append(getProjectStrategyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>strategyName</column-name><column-value><![CDATA[");
		sb.append(getStrategyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMonth</column-name><column-value><![CDATA[");
		sb.append(getStartMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startYear</column-name><column-value><![CDATA[");
		sb.append(getStartYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMonthName</column-name><column-value><![CDATA[");
		sb.append(getStartMonthName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMonth</column-name><column-value><![CDATA[");
		sb.append(getEndMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endYear</column-name><column-value><![CDATA[");
		sb.append(getEndYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMonthName</column-name><column-value><![CDATA[");
		sb.append(getEndMonthName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionDate</column-name><column-value><![CDATA[");
		sb.append(getCompletionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectStrategyStatus</column-name><column-value><![CDATA[");
		sb.append(getProjectStrategyStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progress</column-name><column-value><![CDATA[");
		sb.append(getProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressStatus</column-name><column-value><![CDATA[");
		sb.append(getProgressStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceName</column-name><column-value><![CDATA[");
		sb.append(getResourceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceType</column-name><column-value><![CDATA[");
		sb.append(getResourceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ProjectStrategy.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ProjectStrategy.class
		};
	private long _projectStrategyId;
	private String _strategyName;
	private long _projectId;
	private long _originalProjectId;
	private boolean _setOriginalProjectId;
	private String _userName;
	private Date _startDate;
	private Date _endDate;
	private int _startMonth;
	private int _startYear;
	private String _startMonthName;
	private int _endMonth;
	private int _endYear;
	private String _endMonthName;
	private Date _completionDate;
	private int _projectStrategyStatus;
	private long _userId;
	private String _userUuid;
	private int _progress;
	private int _status;
	private int _progressStatus;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _resourceName;
	private String _resourceType;
	private String _remark;
	private long _columnBitmask;
	private ProjectStrategy _escapedModel;
}
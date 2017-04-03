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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ProjectActivitySoap implements Serializable {
	public static ProjectActivitySoap toSoapModel(ProjectActivity model) {
		ProjectActivitySoap soapModel = new ProjectActivitySoap();

		soapModel.setProjectActivityId(model.getProjectActivityId());
		soapModel.setStrategyId(model.getStrategyId());
		soapModel.setActivityName(model.getActivityName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartMonth(model.getStartMonth());
		soapModel.setStartYear(model.getStartYear());
		soapModel.setStartMonthName(model.getStartMonthName());
		soapModel.setEndMonth(model.getEndMonth());
		soapModel.setEndYear(model.getEndYear());
		soapModel.setEndMonthName(model.getEndMonthName());
		soapModel.setProgress(model.getProgress());
		soapModel.setStatus(model.getStatus());
		soapModel.setProgressStatus(model.getProgressStatus());
		soapModel.setCompletionDate(model.getCompletionDate());
		soapModel.setResourceName(model.getResourceName());
		soapModel.setResourceType(model.getResourceType());
		soapModel.setRemark(model.getRemark());

		return soapModel;
	}

	public static ProjectActivitySoap[] toSoapModels(ProjectActivity[] models) {
		ProjectActivitySoap[] soapModels = new ProjectActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectActivitySoap[][] toSoapModels(
		ProjectActivity[][] models) {
		ProjectActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectActivitySoap[] toSoapModels(
		List<ProjectActivity> models) {
		List<ProjectActivitySoap> soapModels = new ArrayList<ProjectActivitySoap>(models.size());

		for (ProjectActivity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectActivitySoap[soapModels.size()]);
	}

	public ProjectActivitySoap() {
	}

	public long getPrimaryKey() {
		return _projectActivityId;
	}

	public void setPrimaryKey(long pk) {
		setProjectActivityId(pk);
	}

	public long getProjectActivityId() {
		return _projectActivityId;
	}

	public void setProjectActivityId(long projectActivityId) {
		_projectActivityId = projectActivityId;
	}

	public long getStrategyId() {
		return _strategyId;
	}

	public void setStrategyId(long strategyId) {
		_strategyId = strategyId;
	}

	public String getActivityName() {
		return _activityName;
	}

	public void setActivityName(String activityName) {
		_activityName = activityName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStartMonth() {
		return _startMonth;
	}

	public void setStartMonth(int startMonth) {
		_startMonth = startMonth;
	}

	public int getStartYear() {
		return _startYear;
	}

	public void setStartYear(int startYear) {
		_startYear = startYear;
	}

	public String getStartMonthName() {
		return _startMonthName;
	}

	public void setStartMonthName(String startMonthName) {
		_startMonthName = startMonthName;
	}

	public int getEndMonth() {
		return _endMonth;
	}

	public void setEndMonth(int endMonth) {
		_endMonth = endMonth;
	}

	public int getEndYear() {
		return _endYear;
	}

	public void setEndYear(int endYear) {
		_endYear = endYear;
	}

	public String getEndMonthName() {
		return _endMonthName;
	}

	public void setEndMonthName(String endMonthName) {
		_endMonthName = endMonthName;
	}

	public int getProgress() {
		return _progress;
	}

	public void setProgress(int progress) {
		_progress = progress;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getProgressStatus() {
		return _progressStatus;
	}

	public void setProgressStatus(int progressStatus) {
		_progressStatus = progressStatus;
	}

	public Date getCompletionDate() {
		return _completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		_completionDate = completionDate;
	}

	public String getResourceName() {
		return _resourceName;
	}

	public void setResourceName(String resourceName) {
		_resourceName = resourceName;
	}

	public String getResourceType() {
		return _resourceType;
	}

	public void setResourceType(String resourceType) {
		_resourceType = resourceType;
	}

	public String getRemark() {
		return _remark;
	}

	public void setRemark(String remark) {
		_remark = remark;
	}

	private long _projectActivityId;
	private long _strategyId;
	private String _activityName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _startMonth;
	private int _startYear;
	private String _startMonthName;
	private int _endMonth;
	private int _endYear;
	private String _endMonthName;
	private int _progress;
	private int _status;
	private int _progressStatus;
	private Date _completionDate;
	private String _resourceName;
	private String _resourceType;
	private String _remark;
}
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
public class ProjectStrategySoap implements Serializable {
	public static ProjectStrategySoap toSoapModel(ProjectStrategy model) {
		ProjectStrategySoap soapModel = new ProjectStrategySoap();

		soapModel.setProjectStrategyId(model.getProjectStrategyId());
		soapModel.setStrategyName(model.getStrategyName());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setUserName(model.getUserName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartMonth(model.getStartMonth());
		soapModel.setStartYear(model.getStartYear());
		soapModel.setStartMonthName(model.getStartMonthName());
		soapModel.setEndMonth(model.getEndMonth());
		soapModel.setEndYear(model.getEndYear());
		soapModel.setEndMonthName(model.getEndMonthName());
		soapModel.setCompletionDate(model.getCompletionDate());
		soapModel.setProjectStrategyStatus(model.getProjectStrategyStatus());
		soapModel.setUserId(model.getUserId());
		soapModel.setProgress(model.getProgress());
		soapModel.setStatus(model.getStatus());
		soapModel.setProgressStatus(model.getProgressStatus());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setResourceName(model.getResourceName());
		soapModel.setResourceType(model.getResourceType());
		soapModel.setRemark(model.getRemark());

		return soapModel;
	}

	public static ProjectStrategySoap[] toSoapModels(ProjectStrategy[] models) {
		ProjectStrategySoap[] soapModels = new ProjectStrategySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectStrategySoap[][] toSoapModels(
		ProjectStrategy[][] models) {
		ProjectStrategySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectStrategySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectStrategySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectStrategySoap[] toSoapModels(
		List<ProjectStrategy> models) {
		List<ProjectStrategySoap> soapModels = new ArrayList<ProjectStrategySoap>(models.size());

		for (ProjectStrategy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectStrategySoap[soapModels.size()]);
	}

	public ProjectStrategySoap() {
	}

	public long getPrimaryKey() {
		return _projectStrategyId;
	}

	public void setPrimaryKey(long pk) {
		setProjectStrategyId(pk);
	}

	public long getProjectStrategyId() {
		return _projectStrategyId;
	}

	public void setProjectStrategyId(long projectStrategyId) {
		_projectStrategyId = projectStrategyId;
	}

	public String getStrategyName() {
		return _strategyName;
	}

	public void setStrategyName(String strategyName) {
		_strategyName = strategyName;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
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

	public Date getCompletionDate() {
		return _completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		_completionDate = completionDate;
	}

	public int getProjectStrategyStatus() {
		return _projectStrategyStatus;
	}

	public void setProjectStrategyStatus(int projectStrategyStatus) {
		_projectStrategyStatus = projectStrategyStatus;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	private long _projectStrategyId;
	private String _strategyName;
	private long _projectId;
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
}
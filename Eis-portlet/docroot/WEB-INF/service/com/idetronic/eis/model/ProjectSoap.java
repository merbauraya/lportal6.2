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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ProjectServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ProjectServiceSoap
 * @generated
 */
public class ProjectSoap implements Serializable {
	public static ProjectSoap toSoapModel(Project model) {
		ProjectSoap soapModel = new ProjectSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setProjectName(model.getProjectName());
		soapModel.setProjectStatus(model.getProjectStatus());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartMonth(model.getStartMonth());
		soapModel.setStartYear(model.getStartYear());
		soapModel.setStartMonthName(model.getStartMonthName());
		soapModel.setEndMonth(model.getEndMonth());
		soapModel.setEndYear(model.getEndYear());
		soapModel.setProgressStatus(model.getProgressStatus());
		soapModel.setEndMonthName(model.getEndMonthName());
		soapModel.setCompletionDate(model.getCompletionDate());
		soapModel.setProgress(model.getProgress());
		soapModel.setResourceId(model.getResourceId());
		soapModel.setResourceTypeId(model.getResourceTypeId());
		soapModel.setResourceName(model.getResourceName());
		soapModel.setResourceType(model.getResourceType());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProjectSoap[] toSoapModels(Project[] models) {
		ProjectSoap[] soapModels = new ProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[][] toSoapModels(Project[][] models) {
		ProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[] toSoapModels(List<Project> models) {
		List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

		for (Project model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectSoap[soapModels.size()]);
	}

	public ProjectSoap() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public String getProjectName() {
		return _projectName;
	}

	public void setProjectName(String projectName) {
		_projectName = projectName;
	}

	public int getProjectStatus() {
		return _projectStatus;
	}

	public void setProjectStatus(int projectStatus) {
		_projectStatus = projectStatus;
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

	public int getProgressStatus() {
		return _progressStatus;
	}

	public void setProgressStatus(int progressStatus) {
		_progressStatus = progressStatus;
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

	public int getProgress() {
		return _progress;
	}

	public void setProgress(int progress) {
		_progress = progress;
	}

	public long getResourceId() {
		return _resourceId;
	}

	public void setResourceId(long resourceId) {
		_resourceId = resourceId;
	}

	public long getResourceTypeId() {
		return _resourceTypeId;
	}

	public void setResourceTypeId(long resourceTypeId) {
		_resourceTypeId = resourceTypeId;
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

	private long _projectId;
	private String _projectName;
	private int _projectStatus;
	private Date _startDate;
	private Date _endDate;
	private int _startMonth;
	private int _startYear;
	private String _startMonthName;
	private int _endMonth;
	private int _endYear;
	private int _progressStatus;
	private String _endMonthName;
	private Date _completionDate;
	private int _progress;
	private long _resourceId;
	private long _resourceTypeId;
	private String _resourceName;
	private String _resourceType;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
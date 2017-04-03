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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
	public ProjectWrapper(Project project) {
		_project = project;
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("projectName", getProjectName());
		attributes.put("projectStatus", getProjectStatus());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startYear", getStartYear());
		attributes.put("startMonthName", getStartMonthName());
		attributes.put("endMonth", getEndMonth());
		attributes.put("endYear", getEndYear());
		attributes.put("progressStatus", getProgressStatus());
		attributes.put("endMonthName", getEndMonthName());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("progress", getProgress());
		attributes.put("resourceId", getResourceId());
		attributes.put("resourceTypeId", getResourceTypeId());
		attributes.put("resourceName", getResourceName());
		attributes.put("resourceType", getResourceType());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		Integer projectStatus = (Integer)attributes.get("projectStatus");

		if (projectStatus != null) {
			setProjectStatus(projectStatus);
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

		Integer progressStatus = (Integer)attributes.get("progressStatus");

		if (progressStatus != null) {
			setProgressStatus(progressStatus);
		}

		String endMonthName = (String)attributes.get("endMonthName");

		if (endMonthName != null) {
			setEndMonthName(endMonthName);
		}

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Long resourceId = (Long)attributes.get("resourceId");

		if (resourceId != null) {
			setResourceId(resourceId);
		}

		Long resourceTypeId = (Long)attributes.get("resourceTypeId");

		if (resourceTypeId != null) {
			setResourceTypeId(resourceTypeId);
		}

		String resourceName = (String)attributes.get("resourceName");

		if (resourceName != null) {
			setResourceName(resourceName);
		}

		String resourceType = (String)attributes.get("resourceType");

		if (resourceType != null) {
			setResourceType(resourceType);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this project.
	*
	* @return the primary key of this project
	*/
	@Override
	public long getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project.
	*
	* @param primaryKey the primary key of this project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_project.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project ID of this project.
	*
	* @return the project ID of this project
	*/
	@Override
	public long getProjectId() {
		return _project.getProjectId();
	}

	/**
	* Sets the project ID of this project.
	*
	* @param projectId the project ID of this project
	*/
	@Override
	public void setProjectId(long projectId) {
		_project.setProjectId(projectId);
	}

	/**
	* Returns the project name of this project.
	*
	* @return the project name of this project
	*/
	@Override
	public java.lang.String getProjectName() {
		return _project.getProjectName();
	}

	/**
	* Sets the project name of this project.
	*
	* @param projectName the project name of this project
	*/
	@Override
	public void setProjectName(java.lang.String projectName) {
		_project.setProjectName(projectName);
	}

	/**
	* Returns the project status of this project.
	*
	* @return the project status of this project
	*/
	@Override
	public int getProjectStatus() {
		return _project.getProjectStatus();
	}

	/**
	* Sets the project status of this project.
	*
	* @param projectStatus the project status of this project
	*/
	@Override
	public void setProjectStatus(int projectStatus) {
		_project.setProjectStatus(projectStatus);
	}

	/**
	* Returns the start date of this project.
	*
	* @return the start date of this project
	*/
	@Override
	public java.util.Date getStartDate() {
		return _project.getStartDate();
	}

	/**
	* Sets the start date of this project.
	*
	* @param startDate the start date of this project
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_project.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project.
	*
	* @return the end date of this project
	*/
	@Override
	public java.util.Date getEndDate() {
		return _project.getEndDate();
	}

	/**
	* Sets the end date of this project.
	*
	* @param endDate the end date of this project
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_project.setEndDate(endDate);
	}

	/**
	* Returns the start month of this project.
	*
	* @return the start month of this project
	*/
	@Override
	public int getStartMonth() {
		return _project.getStartMonth();
	}

	/**
	* Sets the start month of this project.
	*
	* @param startMonth the start month of this project
	*/
	@Override
	public void setStartMonth(int startMonth) {
		_project.setStartMonth(startMonth);
	}

	/**
	* Returns the start year of this project.
	*
	* @return the start year of this project
	*/
	@Override
	public int getStartYear() {
		return _project.getStartYear();
	}

	/**
	* Sets the start year of this project.
	*
	* @param startYear the start year of this project
	*/
	@Override
	public void setStartYear(int startYear) {
		_project.setStartYear(startYear);
	}

	/**
	* Returns the start month name of this project.
	*
	* @return the start month name of this project
	*/
	@Override
	public java.lang.String getStartMonthName() {
		return _project.getStartMonthName();
	}

	/**
	* Sets the start month name of this project.
	*
	* @param startMonthName the start month name of this project
	*/
	@Override
	public void setStartMonthName(java.lang.String startMonthName) {
		_project.setStartMonthName(startMonthName);
	}

	/**
	* Returns the end month of this project.
	*
	* @return the end month of this project
	*/
	@Override
	public int getEndMonth() {
		return _project.getEndMonth();
	}

	/**
	* Sets the end month of this project.
	*
	* @param endMonth the end month of this project
	*/
	@Override
	public void setEndMonth(int endMonth) {
		_project.setEndMonth(endMonth);
	}

	/**
	* Returns the end year of this project.
	*
	* @return the end year of this project
	*/
	@Override
	public int getEndYear() {
		return _project.getEndYear();
	}

	/**
	* Sets the end year of this project.
	*
	* @param endYear the end year of this project
	*/
	@Override
	public void setEndYear(int endYear) {
		_project.setEndYear(endYear);
	}

	/**
	* Returns the progress status of this project.
	*
	* @return the progress status of this project
	*/
	@Override
	public int getProgressStatus() {
		return _project.getProgressStatus();
	}

	/**
	* Sets the progress status of this project.
	*
	* @param progressStatus the progress status of this project
	*/
	@Override
	public void setProgressStatus(int progressStatus) {
		_project.setProgressStatus(progressStatus);
	}

	/**
	* Returns the end month name of this project.
	*
	* @return the end month name of this project
	*/
	@Override
	public java.lang.String getEndMonthName() {
		return _project.getEndMonthName();
	}

	/**
	* Sets the end month name of this project.
	*
	* @param endMonthName the end month name of this project
	*/
	@Override
	public void setEndMonthName(java.lang.String endMonthName) {
		_project.setEndMonthName(endMonthName);
	}

	/**
	* Returns the completion date of this project.
	*
	* @return the completion date of this project
	*/
	@Override
	public java.util.Date getCompletionDate() {
		return _project.getCompletionDate();
	}

	/**
	* Sets the completion date of this project.
	*
	* @param completionDate the completion date of this project
	*/
	@Override
	public void setCompletionDate(java.util.Date completionDate) {
		_project.setCompletionDate(completionDate);
	}

	/**
	* Returns the progress of this project.
	*
	* @return the progress of this project
	*/
	@Override
	public int getProgress() {
		return _project.getProgress();
	}

	/**
	* Sets the progress of this project.
	*
	* @param progress the progress of this project
	*/
	@Override
	public void setProgress(int progress) {
		_project.setProgress(progress);
	}

	/**
	* Returns the resource ID of this project.
	*
	* @return the resource ID of this project
	*/
	@Override
	public long getResourceId() {
		return _project.getResourceId();
	}

	/**
	* Sets the resource ID of this project.
	*
	* @param resourceId the resource ID of this project
	*/
	@Override
	public void setResourceId(long resourceId) {
		_project.setResourceId(resourceId);
	}

	/**
	* Returns the resource type ID of this project.
	*
	* @return the resource type ID of this project
	*/
	@Override
	public long getResourceTypeId() {
		return _project.getResourceTypeId();
	}

	/**
	* Sets the resource type ID of this project.
	*
	* @param resourceTypeId the resource type ID of this project
	*/
	@Override
	public void setResourceTypeId(long resourceTypeId) {
		_project.setResourceTypeId(resourceTypeId);
	}

	/**
	* Returns the resource name of this project.
	*
	* @return the resource name of this project
	*/
	@Override
	public java.lang.String getResourceName() {
		return _project.getResourceName();
	}

	/**
	* Sets the resource name of this project.
	*
	* @param resourceName the resource name of this project
	*/
	@Override
	public void setResourceName(java.lang.String resourceName) {
		_project.setResourceName(resourceName);
	}

	/**
	* Returns the resource type of this project.
	*
	* @return the resource type of this project
	*/
	@Override
	public java.lang.String getResourceType() {
		return _project.getResourceType();
	}

	/**
	* Sets the resource type of this project.
	*
	* @param resourceType the resource type of this project
	*/
	@Override
	public void setResourceType(java.lang.String resourceType) {
		_project.setResourceType(resourceType);
	}

	/**
	* Returns the group ID of this project.
	*
	* @return the group ID of this project
	*/
	@Override
	public long getGroupId() {
		return _project.getGroupId();
	}

	/**
	* Sets the group ID of this project.
	*
	* @param groupId the group ID of this project
	*/
	@Override
	public void setGroupId(long groupId) {
		_project.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this project.
	*
	* @return the company ID of this project
	*/
	@Override
	public long getCompanyId() {
		return _project.getCompanyId();
	}

	/**
	* Sets the company ID of this project.
	*
	* @param companyId the company ID of this project
	*/
	@Override
	public void setCompanyId(long companyId) {
		_project.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this project.
	*
	* @return the user ID of this project
	*/
	@Override
	public long getUserId() {
		return _project.getUserId();
	}

	/**
	* Sets the user ID of this project.
	*
	* @param userId the user ID of this project
	*/
	@Override
	public void setUserId(long userId) {
		_project.setUserId(userId);
	}

	/**
	* Returns the user uuid of this project.
	*
	* @return the user uuid of this project
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project.getUserUuid();
	}

	/**
	* Sets the user uuid of this project.
	*
	* @param userUuid the user uuid of this project
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_project.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this project.
	*
	* @return the user name of this project
	*/
	@Override
	public java.lang.String getUserName() {
		return _project.getUserName();
	}

	/**
	* Sets the user name of this project.
	*
	* @param userName the user name of this project
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_project.setUserName(userName);
	}

	/**
	* Returns the create date of this project.
	*
	* @return the create date of this project
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _project.getCreateDate();
	}

	/**
	* Sets the create date of this project.
	*
	* @param createDate the create date of this project
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_project.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this project.
	*
	* @return the modified date of this project
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _project.getModifiedDate();
	}

	/**
	* Sets the modified date of this project.
	*
	* @param modifiedDate the modified date of this project
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_project.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _project.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectWrapper((Project)_project.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.Project project) {
		return _project.compareTo(project);
	}

	@Override
	public int hashCode() {
		return _project.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.Project> toCacheModel() {
		return _project.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.Project toEscapedModel() {
		return new ProjectWrapper(_project.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.Project toUnescapedModel() {
		return new ProjectWrapper(_project.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectWrapper)) {
			return false;
		}

		ProjectWrapper projectWrapper = (ProjectWrapper)obj;

		if (Validator.equals(_project, projectWrapper._project)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project getWrappedProject() {
		return _project;
	}

	@Override
	public Project getWrappedModel() {
		return _project;
	}

	@Override
	public void resetOriginalValues() {
		_project.resetOriginalValues();
	}

	private Project _project;
}
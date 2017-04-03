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
 * This class is a wrapper for {@link ProjectActivity}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectActivity
 * @generated
 */
public class ProjectActivityWrapper implements ProjectActivity,
	ModelWrapper<ProjectActivity> {
	public ProjectActivityWrapper(ProjectActivity projectActivity) {
		_projectActivity = projectActivity;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectActivity.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectActivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectActivityId", getProjectActivityId());
		attributes.put("strategyId", getStrategyId());
		attributes.put("activityName", getActivityName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startYear", getStartYear());
		attributes.put("startMonthName", getStartMonthName());
		attributes.put("endMonth", getEndMonth());
		attributes.put("endYear", getEndYear());
		attributes.put("endMonthName", getEndMonthName());
		attributes.put("progress", getProgress());
		attributes.put("status", getStatus());
		attributes.put("progressStatus", getProgressStatus());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("resourceName", getResourceName());
		attributes.put("resourceType", getResourceType());
		attributes.put("remark", getRemark());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectActivityId = (Long)attributes.get("projectActivityId");

		if (projectActivityId != null) {
			setProjectActivityId(projectActivityId);
		}

		Long strategyId = (Long)attributes.get("strategyId");

		if (strategyId != null) {
			setStrategyId(strategyId);
		}

		String activityName = (String)attributes.get("activityName");

		if (activityName != null) {
			setActivityName(activityName);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
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

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
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

	/**
	* Returns the primary key of this project activity.
	*
	* @return the primary key of this project activity
	*/
	@Override
	public long getPrimaryKey() {
		return _projectActivity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project activity.
	*
	* @param primaryKey the primary key of this project activity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectActivity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project activity ID of this project activity.
	*
	* @return the project activity ID of this project activity
	*/
	@Override
	public long getProjectActivityId() {
		return _projectActivity.getProjectActivityId();
	}

	/**
	* Sets the project activity ID of this project activity.
	*
	* @param projectActivityId the project activity ID of this project activity
	*/
	@Override
	public void setProjectActivityId(long projectActivityId) {
		_projectActivity.setProjectActivityId(projectActivityId);
	}

	/**
	* Returns the strategy ID of this project activity.
	*
	* @return the strategy ID of this project activity
	*/
	@Override
	public long getStrategyId() {
		return _projectActivity.getStrategyId();
	}

	/**
	* Sets the strategy ID of this project activity.
	*
	* @param strategyId the strategy ID of this project activity
	*/
	@Override
	public void setStrategyId(long strategyId) {
		_projectActivity.setStrategyId(strategyId);
	}

	/**
	* Returns the activity name of this project activity.
	*
	* @return the activity name of this project activity
	*/
	@Override
	public java.lang.String getActivityName() {
		return _projectActivity.getActivityName();
	}

	/**
	* Sets the activity name of this project activity.
	*
	* @param activityName the activity name of this project activity
	*/
	@Override
	public void setActivityName(java.lang.String activityName) {
		_projectActivity.setActivityName(activityName);
	}

	/**
	* Returns the group ID of this project activity.
	*
	* @return the group ID of this project activity
	*/
	@Override
	public long getGroupId() {
		return _projectActivity.getGroupId();
	}

	/**
	* Sets the group ID of this project activity.
	*
	* @param groupId the group ID of this project activity
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectActivity.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this project activity.
	*
	* @return the company ID of this project activity
	*/
	@Override
	public long getCompanyId() {
		return _projectActivity.getCompanyId();
	}

	/**
	* Sets the company ID of this project activity.
	*
	* @param companyId the company ID of this project activity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectActivity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this project activity.
	*
	* @return the user ID of this project activity
	*/
	@Override
	public long getUserId() {
		return _projectActivity.getUserId();
	}

	/**
	* Sets the user ID of this project activity.
	*
	* @param userId the user ID of this project activity
	*/
	@Override
	public void setUserId(long userId) {
		_projectActivity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this project activity.
	*
	* @return the user uuid of this project activity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivity.getUserUuid();
	}

	/**
	* Sets the user uuid of this project activity.
	*
	* @param userUuid the user uuid of this project activity
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectActivity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this project activity.
	*
	* @return the user name of this project activity
	*/
	@Override
	public java.lang.String getUserName() {
		return _projectActivity.getUserName();
	}

	/**
	* Sets the user name of this project activity.
	*
	* @param userName the user name of this project activity
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_projectActivity.setUserName(userName);
	}

	/**
	* Returns the start date of this project activity.
	*
	* @return the start date of this project activity
	*/
	@Override
	public java.util.Date getStartDate() {
		return _projectActivity.getStartDate();
	}

	/**
	* Sets the start date of this project activity.
	*
	* @param startDate the start date of this project activity
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_projectActivity.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project activity.
	*
	* @return the end date of this project activity
	*/
	@Override
	public java.util.Date getEndDate() {
		return _projectActivity.getEndDate();
	}

	/**
	* Sets the end date of this project activity.
	*
	* @param endDate the end date of this project activity
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_projectActivity.setEndDate(endDate);
	}

	/**
	* Returns the create date of this project activity.
	*
	* @return the create date of this project activity
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _projectActivity.getCreateDate();
	}

	/**
	* Sets the create date of this project activity.
	*
	* @param createDate the create date of this project activity
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_projectActivity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this project activity.
	*
	* @return the modified date of this project activity
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _projectActivity.getModifiedDate();
	}

	/**
	* Sets the modified date of this project activity.
	*
	* @param modifiedDate the modified date of this project activity
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_projectActivity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the start month of this project activity.
	*
	* @return the start month of this project activity
	*/
	@Override
	public int getStartMonth() {
		return _projectActivity.getStartMonth();
	}

	/**
	* Sets the start month of this project activity.
	*
	* @param startMonth the start month of this project activity
	*/
	@Override
	public void setStartMonth(int startMonth) {
		_projectActivity.setStartMonth(startMonth);
	}

	/**
	* Returns the start year of this project activity.
	*
	* @return the start year of this project activity
	*/
	@Override
	public int getStartYear() {
		return _projectActivity.getStartYear();
	}

	/**
	* Sets the start year of this project activity.
	*
	* @param startYear the start year of this project activity
	*/
	@Override
	public void setStartYear(int startYear) {
		_projectActivity.setStartYear(startYear);
	}

	/**
	* Returns the start month name of this project activity.
	*
	* @return the start month name of this project activity
	*/
	@Override
	public java.lang.String getStartMonthName() {
		return _projectActivity.getStartMonthName();
	}

	/**
	* Sets the start month name of this project activity.
	*
	* @param startMonthName the start month name of this project activity
	*/
	@Override
	public void setStartMonthName(java.lang.String startMonthName) {
		_projectActivity.setStartMonthName(startMonthName);
	}

	/**
	* Returns the end month of this project activity.
	*
	* @return the end month of this project activity
	*/
	@Override
	public int getEndMonth() {
		return _projectActivity.getEndMonth();
	}

	/**
	* Sets the end month of this project activity.
	*
	* @param endMonth the end month of this project activity
	*/
	@Override
	public void setEndMonth(int endMonth) {
		_projectActivity.setEndMonth(endMonth);
	}

	/**
	* Returns the end year of this project activity.
	*
	* @return the end year of this project activity
	*/
	@Override
	public int getEndYear() {
		return _projectActivity.getEndYear();
	}

	/**
	* Sets the end year of this project activity.
	*
	* @param endYear the end year of this project activity
	*/
	@Override
	public void setEndYear(int endYear) {
		_projectActivity.setEndYear(endYear);
	}

	/**
	* Returns the end month name of this project activity.
	*
	* @return the end month name of this project activity
	*/
	@Override
	public java.lang.String getEndMonthName() {
		return _projectActivity.getEndMonthName();
	}

	/**
	* Sets the end month name of this project activity.
	*
	* @param endMonthName the end month name of this project activity
	*/
	@Override
	public void setEndMonthName(java.lang.String endMonthName) {
		_projectActivity.setEndMonthName(endMonthName);
	}

	/**
	* Returns the progress of this project activity.
	*
	* @return the progress of this project activity
	*/
	@Override
	public int getProgress() {
		return _projectActivity.getProgress();
	}

	/**
	* Sets the progress of this project activity.
	*
	* @param progress the progress of this project activity
	*/
	@Override
	public void setProgress(int progress) {
		_projectActivity.setProgress(progress);
	}

	/**
	* Returns the status of this project activity.
	*
	* @return the status of this project activity
	*/
	@Override
	public int getStatus() {
		return _projectActivity.getStatus();
	}

	/**
	* Sets the status of this project activity.
	*
	* @param status the status of this project activity
	*/
	@Override
	public void setStatus(int status) {
		_projectActivity.setStatus(status);
	}

	/**
	* Returns the progress status of this project activity.
	*
	* @return the progress status of this project activity
	*/
	@Override
	public int getProgressStatus() {
		return _projectActivity.getProgressStatus();
	}

	/**
	* Sets the progress status of this project activity.
	*
	* @param progressStatus the progress status of this project activity
	*/
	@Override
	public void setProgressStatus(int progressStatus) {
		_projectActivity.setProgressStatus(progressStatus);
	}

	/**
	* Returns the completion date of this project activity.
	*
	* @return the completion date of this project activity
	*/
	@Override
	public java.util.Date getCompletionDate() {
		return _projectActivity.getCompletionDate();
	}

	/**
	* Sets the completion date of this project activity.
	*
	* @param completionDate the completion date of this project activity
	*/
	@Override
	public void setCompletionDate(java.util.Date completionDate) {
		_projectActivity.setCompletionDate(completionDate);
	}

	/**
	* Returns the resource name of this project activity.
	*
	* @return the resource name of this project activity
	*/
	@Override
	public java.lang.String getResourceName() {
		return _projectActivity.getResourceName();
	}

	/**
	* Sets the resource name of this project activity.
	*
	* @param resourceName the resource name of this project activity
	*/
	@Override
	public void setResourceName(java.lang.String resourceName) {
		_projectActivity.setResourceName(resourceName);
	}

	/**
	* Returns the resource type of this project activity.
	*
	* @return the resource type of this project activity
	*/
	@Override
	public java.lang.String getResourceType() {
		return _projectActivity.getResourceType();
	}

	/**
	* Sets the resource type of this project activity.
	*
	* @param resourceType the resource type of this project activity
	*/
	@Override
	public void setResourceType(java.lang.String resourceType) {
		_projectActivity.setResourceType(resourceType);
	}

	/**
	* Returns the remark of this project activity.
	*
	* @return the remark of this project activity
	*/
	@Override
	public java.lang.String getRemark() {
		return _projectActivity.getRemark();
	}

	/**
	* Sets the remark of this project activity.
	*
	* @param remark the remark of this project activity
	*/
	@Override
	public void setRemark(java.lang.String remark) {
		_projectActivity.setRemark(remark);
	}

	@Override
	public boolean isNew() {
		return _projectActivity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_projectActivity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _projectActivity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectActivity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _projectActivity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _projectActivity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_projectActivity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _projectActivity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_projectActivity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_projectActivity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_projectActivity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectActivityWrapper((ProjectActivity)_projectActivity.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.ProjectActivity projectActivity) {
		return _projectActivity.compareTo(projectActivity);
	}

	@Override
	public int hashCode() {
		return _projectActivity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.ProjectActivity> toCacheModel() {
		return _projectActivity.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.ProjectActivity toEscapedModel() {
		return new ProjectActivityWrapper(_projectActivity.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.ProjectActivity toUnescapedModel() {
		return new ProjectActivityWrapper(_projectActivity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _projectActivity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectActivity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectActivity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectActivityWrapper)) {
			return false;
		}

		ProjectActivityWrapper projectActivityWrapper = (ProjectActivityWrapper)obj;

		if (Validator.equals(_projectActivity,
					projectActivityWrapper._projectActivity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProjectActivity getWrappedProjectActivity() {
		return _projectActivity;
	}

	@Override
	public ProjectActivity getWrappedModel() {
		return _projectActivity;
	}

	@Override
	public void resetOriginalValues() {
		_projectActivity.resetOriginalValues();
	}

	private ProjectActivity _projectActivity;
}
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
 * This class is a wrapper for {@link ProjectStrategy}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectStrategy
 * @generated
 */
public class ProjectStrategyWrapper implements ProjectStrategy,
	ModelWrapper<ProjectStrategy> {
	public ProjectStrategyWrapper(ProjectStrategy projectStrategy) {
		_projectStrategy = projectStrategy;
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

	/**
	* Returns the primary key of this project strategy.
	*
	* @return the primary key of this project strategy
	*/
	@Override
	public long getPrimaryKey() {
		return _projectStrategy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project strategy.
	*
	* @param primaryKey the primary key of this project strategy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectStrategy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project strategy ID of this project strategy.
	*
	* @return the project strategy ID of this project strategy
	*/
	@Override
	public long getProjectStrategyId() {
		return _projectStrategy.getProjectStrategyId();
	}

	/**
	* Sets the project strategy ID of this project strategy.
	*
	* @param projectStrategyId the project strategy ID of this project strategy
	*/
	@Override
	public void setProjectStrategyId(long projectStrategyId) {
		_projectStrategy.setProjectStrategyId(projectStrategyId);
	}

	/**
	* Returns the strategy name of this project strategy.
	*
	* @return the strategy name of this project strategy
	*/
	@Override
	public java.lang.String getStrategyName() {
		return _projectStrategy.getStrategyName();
	}

	/**
	* Sets the strategy name of this project strategy.
	*
	* @param strategyName the strategy name of this project strategy
	*/
	@Override
	public void setStrategyName(java.lang.String strategyName) {
		_projectStrategy.setStrategyName(strategyName);
	}

	/**
	* Returns the project ID of this project strategy.
	*
	* @return the project ID of this project strategy
	*/
	@Override
	public long getProjectId() {
		return _projectStrategy.getProjectId();
	}

	/**
	* Sets the project ID of this project strategy.
	*
	* @param projectId the project ID of this project strategy
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectStrategy.setProjectId(projectId);
	}

	/**
	* Returns the user name of this project strategy.
	*
	* @return the user name of this project strategy
	*/
	@Override
	public java.lang.String getUserName() {
		return _projectStrategy.getUserName();
	}

	/**
	* Sets the user name of this project strategy.
	*
	* @param userName the user name of this project strategy
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_projectStrategy.setUserName(userName);
	}

	/**
	* Returns the start date of this project strategy.
	*
	* @return the start date of this project strategy
	*/
	@Override
	public java.util.Date getStartDate() {
		return _projectStrategy.getStartDate();
	}

	/**
	* Sets the start date of this project strategy.
	*
	* @param startDate the start date of this project strategy
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_projectStrategy.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project strategy.
	*
	* @return the end date of this project strategy
	*/
	@Override
	public java.util.Date getEndDate() {
		return _projectStrategy.getEndDate();
	}

	/**
	* Sets the end date of this project strategy.
	*
	* @param endDate the end date of this project strategy
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_projectStrategy.setEndDate(endDate);
	}

	/**
	* Returns the start month of this project strategy.
	*
	* @return the start month of this project strategy
	*/
	@Override
	public int getStartMonth() {
		return _projectStrategy.getStartMonth();
	}

	/**
	* Sets the start month of this project strategy.
	*
	* @param startMonth the start month of this project strategy
	*/
	@Override
	public void setStartMonth(int startMonth) {
		_projectStrategy.setStartMonth(startMonth);
	}

	/**
	* Returns the start year of this project strategy.
	*
	* @return the start year of this project strategy
	*/
	@Override
	public int getStartYear() {
		return _projectStrategy.getStartYear();
	}

	/**
	* Sets the start year of this project strategy.
	*
	* @param startYear the start year of this project strategy
	*/
	@Override
	public void setStartYear(int startYear) {
		_projectStrategy.setStartYear(startYear);
	}

	/**
	* Returns the start month name of this project strategy.
	*
	* @return the start month name of this project strategy
	*/
	@Override
	public java.lang.String getStartMonthName() {
		return _projectStrategy.getStartMonthName();
	}

	/**
	* Sets the start month name of this project strategy.
	*
	* @param startMonthName the start month name of this project strategy
	*/
	@Override
	public void setStartMonthName(java.lang.String startMonthName) {
		_projectStrategy.setStartMonthName(startMonthName);
	}

	/**
	* Returns the end month of this project strategy.
	*
	* @return the end month of this project strategy
	*/
	@Override
	public int getEndMonth() {
		return _projectStrategy.getEndMonth();
	}

	/**
	* Sets the end month of this project strategy.
	*
	* @param endMonth the end month of this project strategy
	*/
	@Override
	public void setEndMonth(int endMonth) {
		_projectStrategy.setEndMonth(endMonth);
	}

	/**
	* Returns the end year of this project strategy.
	*
	* @return the end year of this project strategy
	*/
	@Override
	public int getEndYear() {
		return _projectStrategy.getEndYear();
	}

	/**
	* Sets the end year of this project strategy.
	*
	* @param endYear the end year of this project strategy
	*/
	@Override
	public void setEndYear(int endYear) {
		_projectStrategy.setEndYear(endYear);
	}

	/**
	* Returns the end month name of this project strategy.
	*
	* @return the end month name of this project strategy
	*/
	@Override
	public java.lang.String getEndMonthName() {
		return _projectStrategy.getEndMonthName();
	}

	/**
	* Sets the end month name of this project strategy.
	*
	* @param endMonthName the end month name of this project strategy
	*/
	@Override
	public void setEndMonthName(java.lang.String endMonthName) {
		_projectStrategy.setEndMonthName(endMonthName);
	}

	/**
	* Returns the completion date of this project strategy.
	*
	* @return the completion date of this project strategy
	*/
	@Override
	public java.util.Date getCompletionDate() {
		return _projectStrategy.getCompletionDate();
	}

	/**
	* Sets the completion date of this project strategy.
	*
	* @param completionDate the completion date of this project strategy
	*/
	@Override
	public void setCompletionDate(java.util.Date completionDate) {
		_projectStrategy.setCompletionDate(completionDate);
	}

	/**
	* Returns the project strategy status of this project strategy.
	*
	* @return the project strategy status of this project strategy
	*/
	@Override
	public int getProjectStrategyStatus() {
		return _projectStrategy.getProjectStrategyStatus();
	}

	/**
	* Sets the project strategy status of this project strategy.
	*
	* @param projectStrategyStatus the project strategy status of this project strategy
	*/
	@Override
	public void setProjectStrategyStatus(int projectStrategyStatus) {
		_projectStrategy.setProjectStrategyStatus(projectStrategyStatus);
	}

	/**
	* Returns the user ID of this project strategy.
	*
	* @return the user ID of this project strategy
	*/
	@Override
	public long getUserId() {
		return _projectStrategy.getUserId();
	}

	/**
	* Sets the user ID of this project strategy.
	*
	* @param userId the user ID of this project strategy
	*/
	@Override
	public void setUserId(long userId) {
		_projectStrategy.setUserId(userId);
	}

	/**
	* Returns the user uuid of this project strategy.
	*
	* @return the user uuid of this project strategy
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategy.getUserUuid();
	}

	/**
	* Sets the user uuid of this project strategy.
	*
	* @param userUuid the user uuid of this project strategy
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectStrategy.setUserUuid(userUuid);
	}

	/**
	* Returns the progress of this project strategy.
	*
	* @return the progress of this project strategy
	*/
	@Override
	public int getProgress() {
		return _projectStrategy.getProgress();
	}

	/**
	* Sets the progress of this project strategy.
	*
	* @param progress the progress of this project strategy
	*/
	@Override
	public void setProgress(int progress) {
		_projectStrategy.setProgress(progress);
	}

	/**
	* Returns the status of this project strategy.
	*
	* @return the status of this project strategy
	*/
	@Override
	public int getStatus() {
		return _projectStrategy.getStatus();
	}

	/**
	* Sets the status of this project strategy.
	*
	* @param status the status of this project strategy
	*/
	@Override
	public void setStatus(int status) {
		_projectStrategy.setStatus(status);
	}

	/**
	* Returns the progress status of this project strategy.
	*
	* @return the progress status of this project strategy
	*/
	@Override
	public int getProgressStatus() {
		return _projectStrategy.getProgressStatus();
	}

	/**
	* Sets the progress status of this project strategy.
	*
	* @param progressStatus the progress status of this project strategy
	*/
	@Override
	public void setProgressStatus(int progressStatus) {
		_projectStrategy.setProgressStatus(progressStatus);
	}

	/**
	* Returns the group ID of this project strategy.
	*
	* @return the group ID of this project strategy
	*/
	@Override
	public long getGroupId() {
		return _projectStrategy.getGroupId();
	}

	/**
	* Sets the group ID of this project strategy.
	*
	* @param groupId the group ID of this project strategy
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectStrategy.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this project strategy.
	*
	* @return the company ID of this project strategy
	*/
	@Override
	public long getCompanyId() {
		return _projectStrategy.getCompanyId();
	}

	/**
	* Sets the company ID of this project strategy.
	*
	* @param companyId the company ID of this project strategy
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectStrategy.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this project strategy.
	*
	* @return the create date of this project strategy
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _projectStrategy.getCreateDate();
	}

	/**
	* Sets the create date of this project strategy.
	*
	* @param createDate the create date of this project strategy
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_projectStrategy.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this project strategy.
	*
	* @return the modified date of this project strategy
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _projectStrategy.getModifiedDate();
	}

	/**
	* Sets the modified date of this project strategy.
	*
	* @param modifiedDate the modified date of this project strategy
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_projectStrategy.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the resource name of this project strategy.
	*
	* @return the resource name of this project strategy
	*/
	@Override
	public java.lang.String getResourceName() {
		return _projectStrategy.getResourceName();
	}

	/**
	* Sets the resource name of this project strategy.
	*
	* @param resourceName the resource name of this project strategy
	*/
	@Override
	public void setResourceName(java.lang.String resourceName) {
		_projectStrategy.setResourceName(resourceName);
	}

	/**
	* Returns the resource type of this project strategy.
	*
	* @return the resource type of this project strategy
	*/
	@Override
	public java.lang.String getResourceType() {
		return _projectStrategy.getResourceType();
	}

	/**
	* Sets the resource type of this project strategy.
	*
	* @param resourceType the resource type of this project strategy
	*/
	@Override
	public void setResourceType(java.lang.String resourceType) {
		_projectStrategy.setResourceType(resourceType);
	}

	/**
	* Returns the remark of this project strategy.
	*
	* @return the remark of this project strategy
	*/
	@Override
	public java.lang.String getRemark() {
		return _projectStrategy.getRemark();
	}

	/**
	* Sets the remark of this project strategy.
	*
	* @param remark the remark of this project strategy
	*/
	@Override
	public void setRemark(java.lang.String remark) {
		_projectStrategy.setRemark(remark);
	}

	@Override
	public boolean isNew() {
		return _projectStrategy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_projectStrategy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _projectStrategy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectStrategy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _projectStrategy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _projectStrategy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_projectStrategy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _projectStrategy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_projectStrategy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_projectStrategy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_projectStrategy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectStrategyWrapper((ProjectStrategy)_projectStrategy.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.ProjectStrategy projectStrategy) {
		return _projectStrategy.compareTo(projectStrategy);
	}

	@Override
	public int hashCode() {
		return _projectStrategy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.ProjectStrategy> toCacheModel() {
		return _projectStrategy.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.ProjectStrategy toEscapedModel() {
		return new ProjectStrategyWrapper(_projectStrategy.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.ProjectStrategy toUnescapedModel() {
		return new ProjectStrategyWrapper(_projectStrategy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _projectStrategy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectStrategy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectStrategy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectStrategyWrapper)) {
			return false;
		}

		ProjectStrategyWrapper projectStrategyWrapper = (ProjectStrategyWrapper)obj;

		if (Validator.equals(_projectStrategy,
					projectStrategyWrapper._projectStrategy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProjectStrategy getWrappedProjectStrategy() {
		return _projectStrategy;
	}

	@Override
	public ProjectStrategy getWrappedModel() {
		return _projectStrategy;
	}

	@Override
	public void resetOriginalValues() {
		_projectStrategy.resetOriginalValues();
	}

	private ProjectStrategy _projectStrategy;
}
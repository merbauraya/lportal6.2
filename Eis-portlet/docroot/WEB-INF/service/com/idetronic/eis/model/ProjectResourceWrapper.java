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
 * This class is a wrapper for {@link ProjectResource}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResource
 * @generated
 */
public class ProjectResourceWrapper implements ProjectResource,
	ModelWrapper<ProjectResource> {
	public ProjectResourceWrapper(ProjectResource projectResource) {
		_projectResource = projectResource;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectResource.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectResource.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectResourceId", getProjectResourceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("resourceName", getResourceName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectResourceId = (Long)attributes.get("projectResourceId");

		if (projectResourceId != null) {
			setProjectResourceId(projectResourceId);
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

		String resourceName = (String)attributes.get("resourceName");

		if (resourceName != null) {
			setResourceName(resourceName);
		}
	}

	/**
	* Returns the primary key of this project resource.
	*
	* @return the primary key of this project resource
	*/
	@Override
	public long getPrimaryKey() {
		return _projectResource.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project resource.
	*
	* @param primaryKey the primary key of this project resource
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectResource.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project resource ID of this project resource.
	*
	* @return the project resource ID of this project resource
	*/
	@Override
	public long getProjectResourceId() {
		return _projectResource.getProjectResourceId();
	}

	/**
	* Sets the project resource ID of this project resource.
	*
	* @param projectResourceId the project resource ID of this project resource
	*/
	@Override
	public void setProjectResourceId(long projectResourceId) {
		_projectResource.setProjectResourceId(projectResourceId);
	}

	/**
	* Returns the group ID of this project resource.
	*
	* @return the group ID of this project resource
	*/
	@Override
	public long getGroupId() {
		return _projectResource.getGroupId();
	}

	/**
	* Sets the group ID of this project resource.
	*
	* @param groupId the group ID of this project resource
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectResource.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this project resource.
	*
	* @return the company ID of this project resource
	*/
	@Override
	public long getCompanyId() {
		return _projectResource.getCompanyId();
	}

	/**
	* Sets the company ID of this project resource.
	*
	* @param companyId the company ID of this project resource
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectResource.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this project resource.
	*
	* @return the user ID of this project resource
	*/
	@Override
	public long getUserId() {
		return _projectResource.getUserId();
	}

	/**
	* Sets the user ID of this project resource.
	*
	* @param userId the user ID of this project resource
	*/
	@Override
	public void setUserId(long userId) {
		_projectResource.setUserId(userId);
	}

	/**
	* Returns the user uuid of this project resource.
	*
	* @return the user uuid of this project resource
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectResource.getUserUuid();
	}

	/**
	* Sets the user uuid of this project resource.
	*
	* @param userUuid the user uuid of this project resource
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectResource.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this project resource.
	*
	* @return the user name of this project resource
	*/
	@Override
	public java.lang.String getUserName() {
		return _projectResource.getUserName();
	}

	/**
	* Sets the user name of this project resource.
	*
	* @param userName the user name of this project resource
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_projectResource.setUserName(userName);
	}

	/**
	* Returns the create date of this project resource.
	*
	* @return the create date of this project resource
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _projectResource.getCreateDate();
	}

	/**
	* Sets the create date of this project resource.
	*
	* @param createDate the create date of this project resource
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_projectResource.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this project resource.
	*
	* @return the modified date of this project resource
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _projectResource.getModifiedDate();
	}

	/**
	* Sets the modified date of this project resource.
	*
	* @param modifiedDate the modified date of this project resource
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_projectResource.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the resource name of this project resource.
	*
	* @return the resource name of this project resource
	*/
	@Override
	public java.lang.String getResourceName() {
		return _projectResource.getResourceName();
	}

	/**
	* Sets the resource name of this project resource.
	*
	* @param resourceName the resource name of this project resource
	*/
	@Override
	public void setResourceName(java.lang.String resourceName) {
		_projectResource.setResourceName(resourceName);
	}

	@Override
	public boolean isNew() {
		return _projectResource.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_projectResource.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _projectResource.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectResource.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _projectResource.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _projectResource.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_projectResource.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _projectResource.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_projectResource.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_projectResource.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_projectResource.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectResourceWrapper((ProjectResource)_projectResource.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.ProjectResource projectResource) {
		return _projectResource.compareTo(projectResource);
	}

	@Override
	public int hashCode() {
		return _projectResource.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.ProjectResource> toCacheModel() {
		return _projectResource.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.ProjectResource toEscapedModel() {
		return new ProjectResourceWrapper(_projectResource.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.ProjectResource toUnescapedModel() {
		return new ProjectResourceWrapper(_projectResource.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _projectResource.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectResource.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectResourceWrapper)) {
			return false;
		}

		ProjectResourceWrapper projectResourceWrapper = (ProjectResourceWrapper)obj;

		if (Validator.equals(_projectResource,
					projectResourceWrapper._projectResource)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProjectResource getWrappedProjectResource() {
		return _projectResource;
	}

	@Override
	public ProjectResource getWrappedModel() {
		return _projectResource;
	}

	@Override
	public void resetOriginalValues() {
		_projectResource.resetOriginalValues();
	}

	private ProjectResource _projectResource;
}
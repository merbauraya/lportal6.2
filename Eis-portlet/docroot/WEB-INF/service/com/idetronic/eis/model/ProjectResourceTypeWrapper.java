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
 * This class is a wrapper for {@link ProjectResourceType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResourceType
 * @generated
 */
public class ProjectResourceTypeWrapper implements ProjectResourceType,
	ModelWrapper<ProjectResourceType> {
	public ProjectResourceTypeWrapper(ProjectResourceType projectResourceType) {
		_projectResourceType = projectResourceType;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectResourceType.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectResourceType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectResourceTypeId", getProjectResourceTypeId());
		attributes.put("resourceTypeName", getResourceTypeName());
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
		Long projectResourceTypeId = (Long)attributes.get(
				"projectResourceTypeId");

		if (projectResourceTypeId != null) {
			setProjectResourceTypeId(projectResourceTypeId);
		}

		String resourceTypeName = (String)attributes.get("resourceTypeName");

		if (resourceTypeName != null) {
			setResourceTypeName(resourceTypeName);
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
	* Returns the primary key of this project resource type.
	*
	* @return the primary key of this project resource type
	*/
	@Override
	public long getPrimaryKey() {
		return _projectResourceType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project resource type.
	*
	* @param primaryKey the primary key of this project resource type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectResourceType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project resource type ID of this project resource type.
	*
	* @return the project resource type ID of this project resource type
	*/
	@Override
	public long getProjectResourceTypeId() {
		return _projectResourceType.getProjectResourceTypeId();
	}

	/**
	* Sets the project resource type ID of this project resource type.
	*
	* @param projectResourceTypeId the project resource type ID of this project resource type
	*/
	@Override
	public void setProjectResourceTypeId(long projectResourceTypeId) {
		_projectResourceType.setProjectResourceTypeId(projectResourceTypeId);
	}

	/**
	* Returns the resource type name of this project resource type.
	*
	* @return the resource type name of this project resource type
	*/
	@Override
	public java.lang.String getResourceTypeName() {
		return _projectResourceType.getResourceTypeName();
	}

	/**
	* Sets the resource type name of this project resource type.
	*
	* @param resourceTypeName the resource type name of this project resource type
	*/
	@Override
	public void setResourceTypeName(java.lang.String resourceTypeName) {
		_projectResourceType.setResourceTypeName(resourceTypeName);
	}

	/**
	* Returns the group ID of this project resource type.
	*
	* @return the group ID of this project resource type
	*/
	@Override
	public long getGroupId() {
		return _projectResourceType.getGroupId();
	}

	/**
	* Sets the group ID of this project resource type.
	*
	* @param groupId the group ID of this project resource type
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectResourceType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this project resource type.
	*
	* @return the company ID of this project resource type
	*/
	@Override
	public long getCompanyId() {
		return _projectResourceType.getCompanyId();
	}

	/**
	* Sets the company ID of this project resource type.
	*
	* @param companyId the company ID of this project resource type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectResourceType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this project resource type.
	*
	* @return the user ID of this project resource type
	*/
	@Override
	public long getUserId() {
		return _projectResourceType.getUserId();
	}

	/**
	* Sets the user ID of this project resource type.
	*
	* @param userId the user ID of this project resource type
	*/
	@Override
	public void setUserId(long userId) {
		_projectResourceType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this project resource type.
	*
	* @return the user uuid of this project resource type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectResourceType.getUserUuid();
	}

	/**
	* Sets the user uuid of this project resource type.
	*
	* @param userUuid the user uuid of this project resource type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectResourceType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this project resource type.
	*
	* @return the user name of this project resource type
	*/
	@Override
	public java.lang.String getUserName() {
		return _projectResourceType.getUserName();
	}

	/**
	* Sets the user name of this project resource type.
	*
	* @param userName the user name of this project resource type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_projectResourceType.setUserName(userName);
	}

	/**
	* Returns the create date of this project resource type.
	*
	* @return the create date of this project resource type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _projectResourceType.getCreateDate();
	}

	/**
	* Sets the create date of this project resource type.
	*
	* @param createDate the create date of this project resource type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_projectResourceType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this project resource type.
	*
	* @return the modified date of this project resource type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _projectResourceType.getModifiedDate();
	}

	/**
	* Sets the modified date of this project resource type.
	*
	* @param modifiedDate the modified date of this project resource type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_projectResourceType.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _projectResourceType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_projectResourceType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _projectResourceType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectResourceType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _projectResourceType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _projectResourceType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_projectResourceType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _projectResourceType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_projectResourceType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_projectResourceType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_projectResourceType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectResourceTypeWrapper((ProjectResourceType)_projectResourceType.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.ProjectResourceType projectResourceType) {
		return _projectResourceType.compareTo(projectResourceType);
	}

	@Override
	public int hashCode() {
		return _projectResourceType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.ProjectResourceType> toCacheModel() {
		return _projectResourceType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.ProjectResourceType toEscapedModel() {
		return new ProjectResourceTypeWrapper(_projectResourceType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.ProjectResourceType toUnescapedModel() {
		return new ProjectResourceTypeWrapper(_projectResourceType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _projectResourceType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectResourceType.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectResourceTypeWrapper)) {
			return false;
		}

		ProjectResourceTypeWrapper projectResourceTypeWrapper = (ProjectResourceTypeWrapper)obj;

		if (Validator.equals(_projectResourceType,
					projectResourceTypeWrapper._projectResourceType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProjectResourceType getWrappedProjectResourceType() {
		return _projectResourceType;
	}

	@Override
	public ProjectResourceType getWrappedModel() {
		return _projectResourceType;
	}

	@Override
	public void resetOriginalValues() {
		_projectResourceType.resetOriginalValues();
	}

	private ProjectResourceType _projectResourceType;
}
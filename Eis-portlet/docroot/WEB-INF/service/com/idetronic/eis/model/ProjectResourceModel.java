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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ProjectResource service. Represents a row in the &quot;eis_ProjectResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.ProjectResourceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.ProjectResourceImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResource
 * @see com.idetronic.eis.model.impl.ProjectResourceImpl
 * @see com.idetronic.eis.model.impl.ProjectResourceModelImpl
 * @generated
 */
public interface ProjectResourceModel extends BaseModel<ProjectResource>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project resource model instance should use the {@link ProjectResource} interface instead.
	 */

	/**
	 * Returns the primary key of this project resource.
	 *
	 * @return the primary key of this project resource
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project resource.
	 *
	 * @param primaryKey the primary key of this project resource
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project resource ID of this project resource.
	 *
	 * @return the project resource ID of this project resource
	 */
	public long getProjectResourceId();

	/**
	 * Sets the project resource ID of this project resource.
	 *
	 * @param projectResourceId the project resource ID of this project resource
	 */
	public void setProjectResourceId(long projectResourceId);

	/**
	 * Returns the group ID of this project resource.
	 *
	 * @return the group ID of this project resource
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this project resource.
	 *
	 * @param groupId the group ID of this project resource
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this project resource.
	 *
	 * @return the company ID of this project resource
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this project resource.
	 *
	 * @param companyId the company ID of this project resource
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this project resource.
	 *
	 * @return the user ID of this project resource
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this project resource.
	 *
	 * @param userId the user ID of this project resource
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this project resource.
	 *
	 * @return the user uuid of this project resource
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this project resource.
	 *
	 * @param userUuid the user uuid of this project resource
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this project resource.
	 *
	 * @return the user name of this project resource
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this project resource.
	 *
	 * @param userName the user name of this project resource
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this project resource.
	 *
	 * @return the create date of this project resource
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this project resource.
	 *
	 * @param createDate the create date of this project resource
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this project resource.
	 *
	 * @return the modified date of this project resource
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this project resource.
	 *
	 * @param modifiedDate the modified date of this project resource
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the resource name of this project resource.
	 *
	 * @return the resource name of this project resource
	 */
	@AutoEscape
	public String getResourceName();

	/**
	 * Sets the resource name of this project resource.
	 *
	 * @param resourceName the resource name of this project resource
	 */
	public void setResourceName(String resourceName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.idetronic.eis.model.ProjectResource projectResource);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.ProjectResource> toCacheModel();

	@Override
	public com.idetronic.eis.model.ProjectResource toEscapedModel();

	@Override
	public com.idetronic.eis.model.ProjectResource toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
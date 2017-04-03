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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ProjectResourceTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ProjectResourceTypeServiceSoap
 * @generated
 */
public class ProjectResourceTypeSoap implements Serializable {
	public static ProjectResourceTypeSoap toSoapModel(ProjectResourceType model) {
		ProjectResourceTypeSoap soapModel = new ProjectResourceTypeSoap();

		soapModel.setProjectResourceTypeId(model.getProjectResourceTypeId());
		soapModel.setResourceTypeName(model.getResourceTypeName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProjectResourceTypeSoap[] toSoapModels(
		ProjectResourceType[] models) {
		ProjectResourceTypeSoap[] soapModels = new ProjectResourceTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectResourceTypeSoap[][] toSoapModels(
		ProjectResourceType[][] models) {
		ProjectResourceTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectResourceTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectResourceTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectResourceTypeSoap[] toSoapModels(
		List<ProjectResourceType> models) {
		List<ProjectResourceTypeSoap> soapModels = new ArrayList<ProjectResourceTypeSoap>(models.size());

		for (ProjectResourceType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectResourceTypeSoap[soapModels.size()]);
	}

	public ProjectResourceTypeSoap() {
	}

	public long getPrimaryKey() {
		return _projectResourceTypeId;
	}

	public void setPrimaryKey(long pk) {
		setProjectResourceTypeId(pk);
	}

	public long getProjectResourceTypeId() {
		return _projectResourceTypeId;
	}

	public void setProjectResourceTypeId(long projectResourceTypeId) {
		_projectResourceTypeId = projectResourceTypeId;
	}

	public String getResourceTypeName() {
		return _resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		_resourceTypeName = resourceTypeName;
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

	private long _projectResourceTypeId;
	private String _resourceTypeName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
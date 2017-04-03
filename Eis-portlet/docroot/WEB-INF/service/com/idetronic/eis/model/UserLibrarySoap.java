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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.UserLibraryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.UserLibraryServiceSoap
 * @generated
 */
public class UserLibrarySoap implements Serializable {
	public static UserLibrarySoap toSoapModel(UserLibrary model) {
		UserLibrarySoap soapModel = new UserLibrarySoap();

		soapModel.setUserLibraryId(model.getUserLibraryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserLibrarySoap[] toSoapModels(UserLibrary[] models) {
		UserLibrarySoap[] soapModels = new UserLibrarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserLibrarySoap[][] toSoapModels(UserLibrary[][] models) {
		UserLibrarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserLibrarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserLibrarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserLibrarySoap[] toSoapModels(List<UserLibrary> models) {
		List<UserLibrarySoap> soapModels = new ArrayList<UserLibrarySoap>(models.size());

		for (UserLibrary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserLibrarySoap[soapModels.size()]);
	}

	public UserLibrarySoap() {
	}

	public long getPrimaryKey() {
		return _userLibraryId;
	}

	public void setPrimaryKey(long pk) {
		setUserLibraryId(pk);
	}

	public long getUserLibraryId() {
		return _userLibraryId;
	}

	public void setUserLibraryId(long userLibraryId) {
		_userLibraryId = userLibraryId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;
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

	private long _userLibraryId;
	private long _userId;
	private long _libraryId;
	private long _companyId;
	private long _groupId;
	private long _createdByUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
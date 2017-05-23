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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.UserDataServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.UserDataServiceSoap
 * @generated
 */
public class UserDataSoap implements Serializable {
	public static UserDataSoap toSoapModel(UserData model) {
		UserDataSoap soapModel = new UserDataSoap();

		soapModel.setUserDataId(model.getUserDataId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setDataId(model.getDataId());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static UserDataSoap[] toSoapModels(UserData[] models) {
		UserDataSoap[] soapModels = new UserDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserDataSoap[][] toSoapModels(UserData[][] models) {
		UserDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserDataSoap[] toSoapModels(List<UserData> models) {
		List<UserDataSoap> soapModels = new ArrayList<UserDataSoap>(models.size());

		for (UserData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserDataSoap[soapModels.size()]);
	}

	public UserDataSoap() {
	}

	public long getPrimaryKey() {
		return _userDataId;
	}

	public void setPrimaryKey(long pk) {
		setUserDataId(pk);
	}

	public long getUserDataId() {
		return _userDataId;
	}

	public void setUserDataId(long userDataId) {
		_userDataId = userDataId;
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

	public long getDataId() {
		return _dataId;
	}

	public void setDataId(long dataId) {
		_dataId = dataId;
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

	private long _userDataId;
	private long _userId;
	private long _libraryId;
	private long _dataId;
	private long _createdByUserId;
	private String _userName;
	private Date _createDate;
}
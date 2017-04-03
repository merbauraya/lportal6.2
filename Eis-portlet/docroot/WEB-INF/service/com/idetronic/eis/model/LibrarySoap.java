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
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class LibrarySoap implements Serializable {
	public static LibrarySoap toSoapModel(Library model) {
		LibrarySoap soapModel = new LibrarySoap();

		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setLibraryCode(model.getLibraryCode());
		soapModel.setStateId(model.getStateId());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setStateName(model.getStateName());
		soapModel.setLibraryName(model.getLibraryName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static LibrarySoap[] toSoapModels(Library[] models) {
		LibrarySoap[] soapModels = new LibrarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[][] toSoapModels(Library[][] models) {
		LibrarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LibrarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LibrarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[] toSoapModels(List<Library> models) {
		List<LibrarySoap> soapModels = new ArrayList<LibrarySoap>(models.size());

		for (Library model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LibrarySoap[soapModels.size()]);
	}

	public LibrarySoap() {
	}

	public long getPrimaryKey() {
		return _libraryId;
	}

	public void setPrimaryKey(long pk) {
		setLibraryId(pk);
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getLibraryCode() {
		return _libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		_libraryCode = libraryCode;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;
	}

	public String getStateName() {
		return _stateName;
	}

	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	public String getLibraryName() {
		return _libraryName;
	}

	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;
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

	private long _libraryId;
	private String _libraryCode;
	private long _stateId;
	private long _libraryTypeId;
	private String _stateName;
	private String _libraryName;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
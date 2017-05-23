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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.UserReportServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.UserReportServiceSoap
 * @generated
 */
public class UserReportSoap implements Serializable {
	public static UserReportSoap toSoapModel(UserReport model) {
		UserReportSoap soapModel = new UserReportSoap();

		soapModel.setUserReportId(model.getUserReportId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setReportId(model.getReportId());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static UserReportSoap[] toSoapModels(UserReport[] models) {
		UserReportSoap[] soapModels = new UserReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserReportSoap[][] toSoapModels(UserReport[][] models) {
		UserReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserReportSoap[] toSoapModels(List<UserReport> models) {
		List<UserReportSoap> soapModels = new ArrayList<UserReportSoap>(models.size());

		for (UserReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserReportSoap[soapModels.size()]);
	}

	public UserReportSoap() {
	}

	public long getPrimaryKey() {
		return _userReportId;
	}

	public void setPrimaryKey(long pk) {
		setUserReportId(pk);
	}

	public long getUserReportId() {
		return _userReportId;
	}

	public void setUserReportId(long userReportId) {
		_userReportId = userReportId;
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

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
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

	private long _userReportId;
	private long _userId;
	private long _libraryId;
	private long _reportId;
	private long _createdByUserId;
	private String _userName;
	private Date _createDate;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.SeatingCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.SeatingCategoryServiceSoap
 * @generated
 */
public class SeatingCategorySoap implements Serializable {
	public static SeatingCategorySoap toSoapModel(SeatingCategory model) {
		SeatingCategorySoap soapModel = new SeatingCategorySoap();

		soapModel.setSeatingCategoryId(model.getSeatingCategoryId());
		soapModel.setSeatingCategoryName(model.getSeatingCategoryName());
		soapModel.setSeatingDepartmentId(model.getSeatingDepartmentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SeatingCategorySoap[] toSoapModels(SeatingCategory[] models) {
		SeatingCategorySoap[] soapModels = new SeatingCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SeatingCategorySoap[][] toSoapModels(
		SeatingCategory[][] models) {
		SeatingCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SeatingCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SeatingCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SeatingCategorySoap[] toSoapModels(
		List<SeatingCategory> models) {
		List<SeatingCategorySoap> soapModels = new ArrayList<SeatingCategorySoap>(models.size());

		for (SeatingCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SeatingCategorySoap[soapModels.size()]);
	}

	public SeatingCategorySoap() {
	}

	public long getPrimaryKey() {
		return _seatingCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setSeatingCategoryId(pk);
	}

	public long getSeatingCategoryId() {
		return _seatingCategoryId;
	}

	public void setSeatingCategoryId(long seatingCategoryId) {
		_seatingCategoryId = seatingCategoryId;
	}

	public String getSeatingCategoryName() {
		return _seatingCategoryName;
	}

	public void setSeatingCategoryName(String seatingCategoryName) {
		_seatingCategoryName = seatingCategoryName;
	}

	public long getSeatingDepartmentId() {
		return _seatingDepartmentId;
	}

	public void setSeatingDepartmentId(long seatingDepartmentId) {
		_seatingDepartmentId = seatingDepartmentId;
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

	private long _seatingCategoryId;
	private String _seatingCategoryName;
	private long _seatingDepartmentId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
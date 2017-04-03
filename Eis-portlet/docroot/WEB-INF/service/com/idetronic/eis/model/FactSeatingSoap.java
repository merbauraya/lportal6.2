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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactSeatingServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactSeatingServiceSoap
 * @generated
 */
public class FactSeatingSoap implements Serializable {
	public static FactSeatingSoap toSoapModel(FactSeating model) {
		FactSeatingSoap soapModel = new FactSeatingSoap();

		soapModel.setFactSeatingId(model.getFactSeatingId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setSeatingCategoryId(model.getSeatingCategoryId());
		soapModel.setStateId(model.getStateId());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setCapacity(model.getCapacity());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactSeatingSoap[] toSoapModels(FactSeating[] models) {
		FactSeatingSoap[] soapModels = new FactSeatingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactSeatingSoap[][] toSoapModels(FactSeating[][] models) {
		FactSeatingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactSeatingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactSeatingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactSeatingSoap[] toSoapModels(List<FactSeating> models) {
		List<FactSeatingSoap> soapModels = new ArrayList<FactSeatingSoap>(models.size());

		for (FactSeating model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactSeatingSoap[soapModels.size()]);
	}

	public FactSeatingSoap() {
	}

	public long getPrimaryKey() {
		return _factSeatingId;
	}

	public void setPrimaryKey(long pk) {
		setFactSeatingId(pk);
	}

	public long getFactSeatingId() {
		return _factSeatingId;
	}

	public void setFactSeatingId(long factSeatingId) {
		_factSeatingId = factSeatingId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getSeatingCategoryId() {
		return _seatingCategoryId;
	}

	public void setSeatingCategoryId(long seatingCategoryId) {
		_seatingCategoryId = seatingCategoryId;
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

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public int getCapacity() {
		return _capacity;
	}

	public void setCapacity(int capacity) {
		_capacity = capacity;
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

	private long _factSeatingId;
	private long _libraryId;
	private long _departmentId;
	private long _seatingCategoryId;
	private long _stateId;
	private long _libraryTypeId;
	private String _period;
	private int _capacity;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
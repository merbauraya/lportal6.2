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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactItManagementServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactItManagementServiceSoap
 * @generated
 */
public class FactItManagementSoap implements Serializable {
	public static FactItManagementSoap toSoapModel(FactItManagement model) {
		FactItManagementSoap soapModel = new FactItManagementSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setItemId(model.getItemId());
		soapModel.setItemTotal(model.getItemTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactItManagementSoap[] toSoapModels(FactItManagement[] models) {
		FactItManagementSoap[] soapModels = new FactItManagementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactItManagementSoap[][] toSoapModels(
		FactItManagement[][] models) {
		FactItManagementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactItManagementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactItManagementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactItManagementSoap[] toSoapModels(
		List<FactItManagement> models) {
		List<FactItManagementSoap> soapModels = new ArrayList<FactItManagementSoap>(models.size());

		for (FactItManagement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactItManagementSoap[soapModels.size()]);
	}

	public FactItManagementSoap() {
	}

	public long getPrimaryKey() {
		return _factId;
	}

	public void setPrimaryKey(long pk) {
		setFactId(pk);
	}

	public long getFactId() {
		return _factId;
	}

	public void setFactId(long factId) {
		_factId = factId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getItemTotal() {
		return _itemTotal;
	}

	public void setItemTotal(long itemTotal) {
		_itemTotal = itemTotal;
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

	private long _factId;
	private long _libraryId;
	private String _period;
	private long _itemId;
	private long _itemTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
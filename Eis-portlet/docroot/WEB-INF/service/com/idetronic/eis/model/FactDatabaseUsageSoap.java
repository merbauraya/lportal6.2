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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactDatabaseUsageServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactDatabaseUsageServiceSoap
 * @generated
 */
public class FactDatabaseUsageSoap implements Serializable {
	public static FactDatabaseUsageSoap toSoapModel(FactDatabaseUsage model) {
		FactDatabaseUsageSoap soapModel = new FactDatabaseUsageSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setItemId(model.getItemId());
		soapModel.setDownloadTotal(model.getDownloadTotal());
		soapModel.setSessionTotal(model.getSessionTotal());
		soapModel.setSearchTotal(model.getSearchTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactDatabaseUsageSoap[] toSoapModels(
		FactDatabaseUsage[] models) {
		FactDatabaseUsageSoap[] soapModels = new FactDatabaseUsageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactDatabaseUsageSoap[][] toSoapModels(
		FactDatabaseUsage[][] models) {
		FactDatabaseUsageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactDatabaseUsageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactDatabaseUsageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactDatabaseUsageSoap[] toSoapModels(
		List<FactDatabaseUsage> models) {
		List<FactDatabaseUsageSoap> soapModels = new ArrayList<FactDatabaseUsageSoap>(models.size());

		for (FactDatabaseUsage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactDatabaseUsageSoap[soapModels.size()]);
	}

	public FactDatabaseUsageSoap() {
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

	public long getDownloadTotal() {
		return _downloadTotal;
	}

	public void setDownloadTotal(long downloadTotal) {
		_downloadTotal = downloadTotal;
	}

	public long getSessionTotal() {
		return _sessionTotal;
	}

	public void setSessionTotal(long sessionTotal) {
		_sessionTotal = sessionTotal;
	}

	public long getSearchTotal() {
		return _searchTotal;
	}

	public void setSearchTotal(long searchTotal) {
		_searchTotal = searchTotal;
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
	private long _downloadTotal;
	private long _sessionTotal;
	private long _searchTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactLibraryVisitorServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactLibraryVisitorServiceSoap
 * @generated
 */
public class FactLibraryVisitorSoap implements Serializable {
	public static FactLibraryVisitorSoap toSoapModel(FactLibraryVisitor model) {
		FactLibraryVisitorSoap soapModel = new FactLibraryVisitorSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setVisitorCategoryId(model.getVisitorCategoryId());
		soapModel.setSessionTotal(model.getSessionTotal());
		soapModel.setVisitorTotal(model.getVisitorTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactLibraryVisitorSoap[] toSoapModels(
		FactLibraryVisitor[] models) {
		FactLibraryVisitorSoap[] soapModels = new FactLibraryVisitorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactLibraryVisitorSoap[][] toSoapModels(
		FactLibraryVisitor[][] models) {
		FactLibraryVisitorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactLibraryVisitorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactLibraryVisitorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactLibraryVisitorSoap[] toSoapModels(
		List<FactLibraryVisitor> models) {
		List<FactLibraryVisitorSoap> soapModels = new ArrayList<FactLibraryVisitorSoap>(models.size());

		for (FactLibraryVisitor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactLibraryVisitorSoap[soapModels.size()]);
	}

	public FactLibraryVisitorSoap() {
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

	public long getVisitorCategoryId() {
		return _visitorCategoryId;
	}

	public void setVisitorCategoryId(long visitorCategoryId) {
		_visitorCategoryId = visitorCategoryId;
	}

	public long getSessionTotal() {
		return _sessionTotal;
	}

	public void setSessionTotal(long sessionTotal) {
		_sessionTotal = sessionTotal;
	}

	public long getVisitorTotal() {
		return _visitorTotal;
	}

	public void setVisitorTotal(long visitorTotal) {
		_visitorTotal = visitorTotal;
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
	private long _visitorCategoryId;
	private long _sessionTotal;
	private long _visitorTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
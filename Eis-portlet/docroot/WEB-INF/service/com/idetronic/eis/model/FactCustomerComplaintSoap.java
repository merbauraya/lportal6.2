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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactCustomerComplaintServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactCustomerComplaintServiceSoap
 * @generated
 */
public class FactCustomerComplaintSoap implements Serializable {
	public static FactCustomerComplaintSoap toSoapModel(
		FactCustomerComplaint model) {
		FactCustomerComplaintSoap soapModel = new FactCustomerComplaintSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setComplaintTotal(model.getComplaintTotal());
		soapModel.setUnsettledTotal(model.getUnsettledTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactCustomerComplaintSoap[] toSoapModels(
		FactCustomerComplaint[] models) {
		FactCustomerComplaintSoap[] soapModels = new FactCustomerComplaintSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactCustomerComplaintSoap[][] toSoapModels(
		FactCustomerComplaint[][] models) {
		FactCustomerComplaintSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactCustomerComplaintSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactCustomerComplaintSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactCustomerComplaintSoap[] toSoapModels(
		List<FactCustomerComplaint> models) {
		List<FactCustomerComplaintSoap> soapModels = new ArrayList<FactCustomerComplaintSoap>(models.size());

		for (FactCustomerComplaint model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactCustomerComplaintSoap[soapModels.size()]);
	}

	public FactCustomerComplaintSoap() {
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

	public long getComplaintTotal() {
		return _complaintTotal;
	}

	public void setComplaintTotal(long complaintTotal) {
		_complaintTotal = complaintTotal;
	}

	public long getUnsettledTotal() {
		return _unsettledTotal;
	}

	public void setUnsettledTotal(long unsettledTotal) {
		_unsettledTotal = unsettledTotal;
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
	private long _complaintTotal;
	private long _unsettledTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
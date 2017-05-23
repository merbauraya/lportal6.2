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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactExpenseServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactExpenseServiceSoap
 * @generated
 */
public class FactExpenseSoap implements Serializable {
	public static FactExpenseSoap toSoapModel(FactExpense model) {
		FactExpenseSoap soapModel = new FactExpenseSoap();

		soapModel.setFactExpenseId(model.getFactExpenseId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setEntryType(model.getEntryType());
		soapModel.setMasterFileId(model.getMasterFileId());
		soapModel.setAmount(model.getAmount());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactExpenseSoap[] toSoapModels(FactExpense[] models) {
		FactExpenseSoap[] soapModels = new FactExpenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactExpenseSoap[][] toSoapModels(FactExpense[][] models) {
		FactExpenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactExpenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactExpenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactExpenseSoap[] toSoapModels(List<FactExpense> models) {
		List<FactExpenseSoap> soapModels = new ArrayList<FactExpenseSoap>(models.size());

		for (FactExpense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactExpenseSoap[soapModels.size()]);
	}

	public FactExpenseSoap() {
	}

	public long getPrimaryKey() {
		return _factExpenseId;
	}

	public void setPrimaryKey(long pk) {
		setFactExpenseId(pk);
	}

	public long getFactExpenseId() {
		return _factExpenseId;
	}

	public void setFactExpenseId(long factExpenseId) {
		_factExpenseId = factExpenseId;
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

	public int getEntryType() {
		return _entryType;
	}

	public void setEntryType(int entryType) {
		_entryType = entryType;
	}

	public long getMasterFileId() {
		return _masterFileId;
	}

	public void setMasterFileId(long masterFileId) {
		_masterFileId = masterFileId;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
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

	private long _factExpenseId;
	private long _libraryId;
	private String _period;
	private int _entryType;
	private long _masterFileId;
	private double _amount;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
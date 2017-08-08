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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactIncomeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactIncomeServiceSoap
 * @generated
 */
public class FactIncomeSoap implements Serializable {
	public static FactIncomeSoap toSoapModel(FactIncome model) {
		FactIncomeSoap soapModel = new FactIncomeSoap();

		soapModel.setFactIncomeId(model.getFactIncomeId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setItemId(model.getItemId());
		soapModel.setTotal(model.getTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactIncomeSoap[] toSoapModels(FactIncome[] models) {
		FactIncomeSoap[] soapModels = new FactIncomeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactIncomeSoap[][] toSoapModels(FactIncome[][] models) {
		FactIncomeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactIncomeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactIncomeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactIncomeSoap[] toSoapModels(List<FactIncome> models) {
		List<FactIncomeSoap> soapModels = new ArrayList<FactIncomeSoap>(models.size());

		for (FactIncome model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactIncomeSoap[soapModels.size()]);
	}

	public FactIncomeSoap() {
	}

	public long getPrimaryKey() {
		return _factIncomeId;
	}

	public void setPrimaryKey(long pk) {
		setFactIncomeId(pk);
	}

	public long getFactIncomeId() {
		return _factIncomeId;
	}

	public void setFactIncomeId(long factIncomeId) {
		_factIncomeId = factIncomeId;
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

	public double getTotal() {
		return _total;
	}

	public void setTotal(double total) {
		_total = total;
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

	private long _factIncomeId;
	private long _libraryId;
	private String _period;
	private long _itemId;
	private double _total;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
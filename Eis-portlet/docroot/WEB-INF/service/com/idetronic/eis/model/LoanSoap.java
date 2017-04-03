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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.LoanServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.LoanServiceSoap
 * @generated
 */
public class LoanSoap implements Serializable {
	public static LoanSoap toSoapModel(Loan model) {
		LoanSoap soapModel = new LoanSoap();

		soapModel.setLoanEntryId(model.getLoanEntryId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setStateId(model.getStateId());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setPeriodYear(model.getPeriodYear());
		soapModel.setPeriodMonth(model.getPeriodMonth());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setMemberCategoryId(model.getMemberCategoryId());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static LoanSoap[] toSoapModels(Loan[] models) {
		LoanSoap[] soapModels = new LoanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoanSoap[][] toSoapModels(Loan[][] models) {
		LoanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoanSoap[] toSoapModels(List<Loan> models) {
		List<LoanSoap> soapModels = new ArrayList<LoanSoap>(models.size());

		for (Loan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoanSoap[soapModels.size()]);
	}

	public LoanSoap() {
	}

	public long getPrimaryKey() {
		return _loanEntryId;
	}

	public void setPrimaryKey(long pk) {
		setLoanEntryId(pk);
	}

	public long getLoanEntryId() {
		return _loanEntryId;
	}

	public void setLoanEntryId(long loanEntryId) {
		_loanEntryId = loanEntryId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
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

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
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

	public int getPeriodYear() {
		return _periodYear;
	}

	public void setPeriodYear(int periodYear) {
		_periodYear = periodYear;
	}

	public int getPeriodMonth() {
		return _periodMonth;
	}

	public void setPeriodMonth(int periodMonth) {
		_periodMonth = periodMonth;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getMemberCategoryId() {
		return _memberCategoryId;
	}

	public void setMemberCategoryId(long memberCategoryId) {
		_memberCategoryId = memberCategoryId;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	private long _loanEntryId;
	private long _libraryId;
	private long _userId;
	private String _userName;
	private String _period;
	private long _stateId;
	private long _libraryTypeId;
	private int _periodYear;
	private int _periodMonth;
	private Date _createDate;
	private long _memberCategoryId;
	private int _value;
}
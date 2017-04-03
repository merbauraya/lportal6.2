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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactMembershipServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactMembershipServiceSoap
 * @generated
 */
public class FactMembershipSoap implements Serializable {
	public static FactMembershipSoap toSoapModel(FactMembership model) {
		FactMembershipSoap soapModel = new FactMembershipSoap();

		soapModel.setFactMembershipId(model.getFactMembershipId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setStateId(model.getStateId());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setMembershipCategoryId(model.getMembershipCategoryId());
		soapModel.setActiveCount(model.getActiveCount());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactMembershipSoap[] toSoapModels(FactMembership[] models) {
		FactMembershipSoap[] soapModels = new FactMembershipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactMembershipSoap[][] toSoapModels(FactMembership[][] models) {
		FactMembershipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactMembershipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactMembershipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactMembershipSoap[] toSoapModels(List<FactMembership> models) {
		List<FactMembershipSoap> soapModels = new ArrayList<FactMembershipSoap>(models.size());

		for (FactMembership model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactMembershipSoap[soapModels.size()]);
	}

	public FactMembershipSoap() {
	}

	public long getPrimaryKey() {
		return _factMembershipId;
	}

	public void setPrimaryKey(long pk) {
		setFactMembershipId(pk);
	}

	public long getFactMembershipId() {
		return _factMembershipId;
	}

	public void setFactMembershipId(long factMembershipId) {
		_factMembershipId = factMembershipId;
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

	public long getMembershipCategoryId() {
		return _membershipCategoryId;
	}

	public void setMembershipCategoryId(long membershipCategoryId) {
		_membershipCategoryId = membershipCategoryId;
	}

	public int getActiveCount() {
		return _activeCount;
	}

	public void setActiveCount(int activeCount) {
		_activeCount = activeCount;
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

	private long _factMembershipId;
	private long _libraryId;
	private String _period;
	private long _stateId;
	private long _libraryTypeId;
	private long _membershipCategoryId;
	private int _activeCount;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactConsultationServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactConsultationServiceSoap
 * @generated
 */
public class FactConsultationSoap implements Serializable {
	public static FactConsultationSoap toSoapModel(FactConsultation model) {
		FactConsultationSoap soapModel = new FactConsultationSoap();

		soapModel.setFactConsultationId(model.getFactConsultationId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setConsultationGroupId(model.getConsultationGroupId());
		soapModel.setConsultationCategoryId(model.getConsultationCategoryId());
		soapModel.setValue(model.getValue());
		soapModel.setTotalSession(model.getTotalSession());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactConsultationSoap[] toSoapModels(FactConsultation[] models) {
		FactConsultationSoap[] soapModels = new FactConsultationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactConsultationSoap[][] toSoapModels(
		FactConsultation[][] models) {
		FactConsultationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactConsultationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactConsultationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactConsultationSoap[] toSoapModels(
		List<FactConsultation> models) {
		List<FactConsultationSoap> soapModels = new ArrayList<FactConsultationSoap>(models.size());

		for (FactConsultation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactConsultationSoap[soapModels.size()]);
	}

	public FactConsultationSoap() {
	}

	public long getPrimaryKey() {
		return _factConsultationId;
	}

	public void setPrimaryKey(long pk) {
		setFactConsultationId(pk);
	}

	public long getFactConsultationId() {
		return _factConsultationId;
	}

	public void setFactConsultationId(long factConsultationId) {
		_factConsultationId = factConsultationId;
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

	public long getConsultationGroupId() {
		return _consultationGroupId;
	}

	public void setConsultationGroupId(long consultationGroupId) {
		_consultationGroupId = consultationGroupId;
	}

	public long getConsultationCategoryId() {
		return _consultationCategoryId;
	}

	public void setConsultationCategoryId(long consultationCategoryId) {
		_consultationCategoryId = consultationCategoryId;
	}

	public long getValue() {
		return _value;
	}

	public void setValue(long value) {
		_value = value;
	}

	public long getTotalSession() {
		return _totalSession;
	}

	public void setTotalSession(long totalSession) {
		_totalSession = totalSession;
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

	private long _factConsultationId;
	private long _libraryId;
	private String _period;
	private long _consultationGroupId;
	private long _consultationCategoryId;
	private long _value;
	private long _totalSession;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
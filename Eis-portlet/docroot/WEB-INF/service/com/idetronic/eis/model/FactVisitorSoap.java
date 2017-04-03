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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactVisitorServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactVisitorServiceSoap
 * @generated
 */
public class FactVisitorSoap implements Serializable {
	public static FactVisitorSoap toSoapModel(FactVisitor model) {
		FactVisitorSoap soapModel = new FactVisitorSoap();

		soapModel.setFactVisitorId(model.getFactVisitorId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setVisitorCategoryId(model.getVisitorCategoryId());
		soapModel.setStateId(model.getStateId());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setValue(model.getValue());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setCreatedByUserName(model.getCreatedByUserName());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static FactVisitorSoap[] toSoapModels(FactVisitor[] models) {
		FactVisitorSoap[] soapModels = new FactVisitorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactVisitorSoap[][] toSoapModels(FactVisitor[][] models) {
		FactVisitorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactVisitorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactVisitorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactVisitorSoap[] toSoapModels(List<FactVisitor> models) {
		List<FactVisitorSoap> soapModels = new ArrayList<FactVisitorSoap>(models.size());

		for (FactVisitor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactVisitorSoap[soapModels.size()]);
	}

	public FactVisitorSoap() {
	}

	public long getPrimaryKey() {
		return _factVisitorId;
	}

	public void setPrimaryKey(long pk) {
		setFactVisitorId(pk);
	}

	public long getFactVisitorId() {
		return _factVisitorId;
	}

	public void setFactVisitorId(long factVisitorId) {
		_factVisitorId = factVisitorId;
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

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;
	}

	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _factVisitorId;
	private long _libraryId;
	private String _period;
	private long _visitorCategoryId;
	private long _stateId;
	private long _libraryTypeId;
	private int _value;
	private long _createdByUserId;
	private String _createdByUserName;
	private Date _createdDate;
}
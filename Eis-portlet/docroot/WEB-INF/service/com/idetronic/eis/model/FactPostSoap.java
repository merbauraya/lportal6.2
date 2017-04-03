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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactPostServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactPostServiceSoap
 * @generated
 */
public class FactPostSoap implements Serializable {
	public static FactPostSoap toSoapModel(FactPost model) {
		FactPostSoap soapModel = new FactPostSoap();

		soapModel.setFactPostId(model.getFactPostId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setPostGradeId(model.getPostGradeId());
		soapModel.setStateId(model.getStateId());
		soapModel.setValue(model.getValue());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setCreatedByUserName(model.getCreatedByUserName());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static FactPostSoap[] toSoapModels(FactPost[] models) {
		FactPostSoap[] soapModels = new FactPostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactPostSoap[][] toSoapModels(FactPost[][] models) {
		FactPostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactPostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactPostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactPostSoap[] toSoapModels(List<FactPost> models) {
		List<FactPostSoap> soapModels = new ArrayList<FactPostSoap>(models.size());

		for (FactPost model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactPostSoap[soapModels.size()]);
	}

	public FactPostSoap() {
	}

	public long getPrimaryKey() {
		return _factPostId;
	}

	public void setPrimaryKey(long pk) {
		setFactPostId(pk);
	}

	public long getFactPostId() {
		return _factPostId;
	}

	public void setFactPostId(long factPostId) {
		_factPostId = factPostId;
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

	public long getPostGradeId() {
		return _postGradeId;
	}

	public void setPostGradeId(long postGradeId) {
		_postGradeId = postGradeId;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
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

	private long _factPostId;
	private long _libraryId;
	private String _period;
	private long _postGradeId;
	private long _stateId;
	private int _value;
	private long _createdByUserId;
	private String _createdByUserName;
	private Date _createdDate;
}
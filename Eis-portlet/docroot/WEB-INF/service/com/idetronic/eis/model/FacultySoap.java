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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FacultyServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FacultyServiceSoap
 * @generated
 */
public class FacultySoap implements Serializable {
	public static FacultySoap toSoapModel(Faculty model) {
		FacultySoap soapModel = new FacultySoap();

		soapModel.setFacultyId(model.getFacultyId());
		soapModel.setFacultyTypeId(model.getFacultyTypeId());
		soapModel.setFacultyName(model.getFacultyName());

		return soapModel;
	}

	public static FacultySoap[] toSoapModels(Faculty[] models) {
		FacultySoap[] soapModels = new FacultySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FacultySoap[][] toSoapModels(Faculty[][] models) {
		FacultySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FacultySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FacultySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FacultySoap[] toSoapModels(List<Faculty> models) {
		List<FacultySoap> soapModels = new ArrayList<FacultySoap>(models.size());

		for (Faculty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FacultySoap[soapModels.size()]);
	}

	public FacultySoap() {
	}

	public long getPrimaryKey() {
		return _facultyId;
	}

	public void setPrimaryKey(long pk) {
		setFacultyId(pk);
	}

	public long getFacultyId() {
		return _facultyId;
	}

	public void setFacultyId(long facultyId) {
		_facultyId = facultyId;
	}

	public long getFacultyTypeId() {
		return _facultyTypeId;
	}

	public void setFacultyTypeId(long facultyTypeId) {
		_facultyTypeId = facultyTypeId;
	}

	public String getFacultyName() {
		return _facultyName;
	}

	public void setFacultyName(String facultyName) {
		_facultyName = facultyName;
	}

	private long _facultyId;
	private long _facultyTypeId;
	private String _facultyName;
}
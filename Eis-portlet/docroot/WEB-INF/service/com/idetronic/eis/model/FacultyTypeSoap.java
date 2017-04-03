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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FacultyTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FacultyTypeServiceSoap
 * @generated
 */
public class FacultyTypeSoap implements Serializable {
	public static FacultyTypeSoap toSoapModel(FacultyType model) {
		FacultyTypeSoap soapModel = new FacultyTypeSoap();

		soapModel.setFacultyTypeId(model.getFacultyTypeId());
		soapModel.setFacultyTypeName(model.getFacultyTypeName());

		return soapModel;
	}

	public static FacultyTypeSoap[] toSoapModels(FacultyType[] models) {
		FacultyTypeSoap[] soapModels = new FacultyTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FacultyTypeSoap[][] toSoapModels(FacultyType[][] models) {
		FacultyTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FacultyTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FacultyTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FacultyTypeSoap[] toSoapModels(List<FacultyType> models) {
		List<FacultyTypeSoap> soapModels = new ArrayList<FacultyTypeSoap>(models.size());

		for (FacultyType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FacultyTypeSoap[soapModels.size()]);
	}

	public FacultyTypeSoap() {
	}

	public long getPrimaryKey() {
		return _facultyTypeId;
	}

	public void setPrimaryKey(long pk) {
		setFacultyTypeId(pk);
	}

	public long getFacultyTypeId() {
		return _facultyTypeId;
	}

	public void setFacultyTypeId(long facultyTypeId) {
		_facultyTypeId = facultyTypeId;
	}

	public String getFacultyTypeName() {
		return _facultyTypeName;
	}

	public void setFacultyTypeName(String facultyTypeName) {
		_facultyTypeName = facultyTypeName;
	}

	private long _facultyTypeId;
	private String _facultyTypeName;
}
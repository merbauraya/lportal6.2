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
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class LibraryTypeSoap implements Serializable {
	public static LibraryTypeSoap toSoapModel(LibraryType model) {
		LibraryTypeSoap soapModel = new LibraryTypeSoap();

		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setLibraryTypeCode(model.getLibraryTypeCode());
		soapModel.setLibraryTypeName(model.getLibraryTypeName());

		return soapModel;
	}

	public static LibraryTypeSoap[] toSoapModels(LibraryType[] models) {
		LibraryTypeSoap[] soapModels = new LibraryTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LibraryTypeSoap[][] toSoapModels(LibraryType[][] models) {
		LibraryTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LibraryTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LibraryTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LibraryTypeSoap[] toSoapModels(List<LibraryType> models) {
		List<LibraryTypeSoap> soapModels = new ArrayList<LibraryTypeSoap>(models.size());

		for (LibraryType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LibraryTypeSoap[soapModels.size()]);
	}

	public LibraryTypeSoap() {
	}

	public long getPrimaryKey() {
		return _libraryTypeId;
	}

	public void setPrimaryKey(long pk) {
		setLibraryTypeId(pk);
	}

	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;
	}

	public String getLibraryTypeCode() {
		return _libraryTypeCode;
	}

	public void setLibraryTypeCode(String libraryTypeCode) {
		_libraryTypeCode = libraryTypeCode;
	}

	public String getLibraryTypeName() {
		return _libraryTypeName;
	}

	public void setLibraryTypeName(String libraryTypeName) {
		_libraryTypeName = libraryTypeName;
	}

	private long _libraryTypeId;
	private String _libraryTypeCode;
	private String _libraryTypeName;
}
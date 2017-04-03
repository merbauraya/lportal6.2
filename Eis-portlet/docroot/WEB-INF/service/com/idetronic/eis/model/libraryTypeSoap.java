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
public class libraryTypeSoap implements Serializable {
	public static libraryTypeSoap toSoapModel(libraryType model) {
		libraryTypeSoap soapModel = new libraryTypeSoap();

		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setLibraryTypeName(model.getLibraryTypeName());

		return soapModel;
	}

	public static libraryTypeSoap[] toSoapModels(libraryType[] models) {
		libraryTypeSoap[] soapModels = new libraryTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static libraryTypeSoap[][] toSoapModels(libraryType[][] models) {
		libraryTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new libraryTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new libraryTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static libraryTypeSoap[] toSoapModels(List<libraryType> models) {
		List<libraryTypeSoap> soapModels = new ArrayList<libraryTypeSoap>(models.size());

		for (libraryType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new libraryTypeSoap[soapModels.size()]);
	}

	public libraryTypeSoap() {
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

	public String getLibraryTypeName() {
		return _libraryTypeName;
	}

	public void setLibraryTypeName(String libraryTypeName) {
		_libraryTypeName = libraryTypeName;
	}

	private long _libraryTypeId;
	private String _libraryTypeName;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.NonPrintedItemTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.NonPrintedItemTypeServiceSoap
 * @generated
 */
public class NonPrintedItemTypeSoap implements Serializable {
	public static NonPrintedItemTypeSoap toSoapModel(NonPrintedItemType model) {
		NonPrintedItemTypeSoap soapModel = new NonPrintedItemTypeSoap();

		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setItemTypeName(model.getItemTypeName());

		return soapModel;
	}

	public static NonPrintedItemTypeSoap[] toSoapModels(
		NonPrintedItemType[] models) {
		NonPrintedItemTypeSoap[] soapModels = new NonPrintedItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NonPrintedItemTypeSoap[][] toSoapModels(
		NonPrintedItemType[][] models) {
		NonPrintedItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NonPrintedItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NonPrintedItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NonPrintedItemTypeSoap[] toSoapModels(
		List<NonPrintedItemType> models) {
		List<NonPrintedItemTypeSoap> soapModels = new ArrayList<NonPrintedItemTypeSoap>(models.size());

		for (NonPrintedItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NonPrintedItemTypeSoap[soapModels.size()]);
	}

	public NonPrintedItemTypeSoap() {
	}

	public long getPrimaryKey() {
		return _itemTypeId;
	}

	public void setPrimaryKey(long pk) {
		setItemTypeId(pk);
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public String getItemTypeName() {
		return _itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		_itemTypeName = itemTypeName;
	}

	private long _itemTypeId;
	private String _itemTypeName;
}
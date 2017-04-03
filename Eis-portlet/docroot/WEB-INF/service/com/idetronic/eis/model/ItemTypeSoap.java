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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ItemTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ItemTypeServiceSoap
 * @generated
 */
public class ItemTypeSoap implements Serializable {
	public static ItemTypeSoap toSoapModel(ItemType model) {
		ItemTypeSoap soapModel = new ItemTypeSoap();

		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setItemTypeName(model.getItemTypeName());
		soapModel.setPrintedType(model.getPrintedType());
		soapModel.setIRType(model.getIRType());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static ItemTypeSoap[] toSoapModels(ItemType[] models) {
		ItemTypeSoap[] soapModels = new ItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[][] toSoapModels(ItemType[][] models) {
		ItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[] toSoapModels(List<ItemType> models) {
		List<ItemTypeSoap> soapModels = new ArrayList<ItemTypeSoap>(models.size());

		for (ItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemTypeSoap[soapModels.size()]);
	}

	public ItemTypeSoap() {
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

	public int getPrintedType() {
		return _printedType;
	}

	public void setPrintedType(int printedType) {
		_printedType = printedType;
	}

	public boolean getIRType() {
		return _IRType;
	}

	public boolean isIRType() {
		return _IRType;
	}

	public void setIRType(boolean IRType) {
		_IRType = IRType;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _itemTypeId;
	private String _itemTypeName;
	private int _printedType;
	private boolean _IRType;
	private boolean _active;
}
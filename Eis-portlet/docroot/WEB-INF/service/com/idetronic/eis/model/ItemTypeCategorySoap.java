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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ItemTypeCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ItemTypeCategoryServiceSoap
 * @generated
 */
public class ItemTypeCategorySoap implements Serializable {
	public static ItemTypeCategorySoap toSoapModel(ItemTypeCategory model) {
		ItemTypeCategorySoap soapModel = new ItemTypeCategorySoap();

		soapModel.setItemTypeCategoryId(model.getItemTypeCategoryId());
		soapModel.setItemTypeCategoryName(model.getItemTypeCategoryName());

		return soapModel;
	}

	public static ItemTypeCategorySoap[] toSoapModels(ItemTypeCategory[] models) {
		ItemTypeCategorySoap[] soapModels = new ItemTypeCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeCategorySoap[][] toSoapModels(
		ItemTypeCategory[][] models) {
		ItemTypeCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemTypeCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemTypeCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeCategorySoap[] toSoapModels(
		List<ItemTypeCategory> models) {
		List<ItemTypeCategorySoap> soapModels = new ArrayList<ItemTypeCategorySoap>(models.size());

		for (ItemTypeCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemTypeCategorySoap[soapModels.size()]);
	}

	public ItemTypeCategorySoap() {
	}

	public long getPrimaryKey() {
		return _itemTypeCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setItemTypeCategoryId(pk);
	}

	public long getItemTypeCategoryId() {
		return _itemTypeCategoryId;
	}

	public void setItemTypeCategoryId(long itemTypeCategoryId) {
		_itemTypeCategoryId = itemTypeCategoryId;
	}

	public String getItemTypeCategoryName() {
		return _itemTypeCategoryName;
	}

	public void setItemTypeCategoryName(String itemTypeCategoryName) {
		_itemTypeCategoryName = itemTypeCategoryName;
	}

	private long _itemTypeCategoryId;
	private String _itemTypeCategoryName;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ItemMediumServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ItemMediumServiceSoap
 * @generated
 */
public class ItemMediumSoap implements Serializable {
	public static ItemMediumSoap toSoapModel(ItemMedium model) {
		ItemMediumSoap soapModel = new ItemMediumSoap();

		soapModel.setItemMediumId(model.getItemMediumId());
		soapModel.setItemMediumName(model.getItemMediumName());

		return soapModel;
	}

	public static ItemMediumSoap[] toSoapModels(ItemMedium[] models) {
		ItemMediumSoap[] soapModels = new ItemMediumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemMediumSoap[][] toSoapModels(ItemMedium[][] models) {
		ItemMediumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemMediumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemMediumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemMediumSoap[] toSoapModels(List<ItemMedium> models) {
		List<ItemMediumSoap> soapModels = new ArrayList<ItemMediumSoap>(models.size());

		for (ItemMedium model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemMediumSoap[soapModels.size()]);
	}

	public ItemMediumSoap() {
	}

	public long getPrimaryKey() {
		return _itemMediumId;
	}

	public void setPrimaryKey(long pk) {
		setItemMediumId(pk);
	}

	public long getItemMediumId() {
		return _itemMediumId;
	}

	public void setItemMediumId(long itemMediumId) {
		_itemMediumId = itemMediumId;
	}

	public String getItemMediumName() {
		return _itemMediumName;
	}

	public void setItemMediumName(String itemMediumName) {
		_itemMediumName = itemMediumName;
	}

	private long _itemMediumId;
	private String _itemMediumName;
}
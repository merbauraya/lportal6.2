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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.BorrowerCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.BorrowerCategoryServiceSoap
 * @generated
 */
public class BorrowerCategorySoap implements Serializable {
	public static BorrowerCategorySoap toSoapModel(BorrowerCategory model) {
		BorrowerCategorySoap soapModel = new BorrowerCategorySoap();

		soapModel.setBorrowerCategoryId(model.getBorrowerCategoryId());
		soapModel.setBorrowerCategoryName(model.getBorrowerCategoryName());

		return soapModel;
	}

	public static BorrowerCategorySoap[] toSoapModels(BorrowerCategory[] models) {
		BorrowerCategorySoap[] soapModels = new BorrowerCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BorrowerCategorySoap[][] toSoapModels(
		BorrowerCategory[][] models) {
		BorrowerCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BorrowerCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BorrowerCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BorrowerCategorySoap[] toSoapModels(
		List<BorrowerCategory> models) {
		List<BorrowerCategorySoap> soapModels = new ArrayList<BorrowerCategorySoap>(models.size());

		for (BorrowerCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BorrowerCategorySoap[soapModels.size()]);
	}

	public BorrowerCategorySoap() {
	}

	public long getPrimaryKey() {
		return _borrowerCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setBorrowerCategoryId(pk);
	}

	public long getBorrowerCategoryId() {
		return _borrowerCategoryId;
	}

	public void setBorrowerCategoryId(long borrowerCategoryId) {
		_borrowerCategoryId = borrowerCategoryId;
	}

	public String getBorrowerCategoryName() {
		return _borrowerCategoryName;
	}

	public void setBorrowerCategoryName(String borrowerCategoryName) {
		_borrowerCategoryName = borrowerCategoryName;
	}

	private long _borrowerCategoryId;
	private String _borrowerCategoryName;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.VisitorCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.VisitorCategoryServiceSoap
 * @generated
 */
public class VisitorCategorySoap implements Serializable {
	public static VisitorCategorySoap toSoapModel(VisitorCategory model) {
		VisitorCategorySoap soapModel = new VisitorCategorySoap();

		soapModel.setVisitorCategoryId(model.getVisitorCategoryId());
		soapModel.setVisitorCategoryCode(model.getVisitorCategoryCode());
		soapModel.setVisitorCategoryName(model.getVisitorCategoryName());

		return soapModel;
	}

	public static VisitorCategorySoap[] toSoapModels(VisitorCategory[] models) {
		VisitorCategorySoap[] soapModels = new VisitorCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VisitorCategorySoap[][] toSoapModels(
		VisitorCategory[][] models) {
		VisitorCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VisitorCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VisitorCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VisitorCategorySoap[] toSoapModels(
		List<VisitorCategory> models) {
		List<VisitorCategorySoap> soapModels = new ArrayList<VisitorCategorySoap>(models.size());

		for (VisitorCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VisitorCategorySoap[soapModels.size()]);
	}

	public VisitorCategorySoap() {
	}

	public long getPrimaryKey() {
		return _visitorCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setVisitorCategoryId(pk);
	}

	public long getVisitorCategoryId() {
		return _visitorCategoryId;
	}

	public void setVisitorCategoryId(long visitorCategoryId) {
		_visitorCategoryId = visitorCategoryId;
	}

	public String getVisitorCategoryCode() {
		return _visitorCategoryCode;
	}

	public void setVisitorCategoryCode(String visitorCategoryCode) {
		_visitorCategoryCode = visitorCategoryCode;
	}

	public String getVisitorCategoryName() {
		return _visitorCategoryName;
	}

	public void setVisitorCategoryName(String visitorCategoryName) {
		_visitorCategoryName = visitorCategoryName;
	}

	private long _visitorCategoryId;
	private String _visitorCategoryCode;
	private String _visitorCategoryName;
}
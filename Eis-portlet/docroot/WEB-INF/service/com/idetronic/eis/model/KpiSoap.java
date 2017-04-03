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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.KpiServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.KpiServiceSoap
 * @generated
 */
public class KpiSoap implements Serializable {
	public static KpiSoap toSoapModel(Kpi model) {
		KpiSoap soapModel = new KpiSoap();

		soapModel.setId(model.getId());
		soapModel.setKey(model.getKey());
		soapModel.setKpiType(model.getKpiType());
		soapModel.setValue(model.getValue());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static KpiSoap[] toSoapModels(Kpi[] models) {
		KpiSoap[] soapModels = new KpiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KpiSoap[][] toSoapModels(Kpi[][] models) {
		KpiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KpiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KpiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KpiSoap[] toSoapModels(List<Kpi> models) {
		List<KpiSoap> soapModels = new ArrayList<KpiSoap>(models.size());

		for (Kpi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KpiSoap[soapModels.size()]);
	}

	public KpiSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public int getKpiType() {
		return _kpiType;
	}

	public void setKpiType(int kpiType) {
		_kpiType = kpiType;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _id;
	private String _key;
	private int _kpiType;
	private int _value;
	private String _description;
}
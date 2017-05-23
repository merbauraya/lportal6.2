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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ConfigServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ConfigServiceSoap
 * @generated
 */
public class ConfigSoap implements Serializable {
	public static ConfigSoap toSoapModel(Config model) {
		ConfigSoap soapModel = new ConfigSoap();

		soapModel.setId(model.getId());
		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static ConfigSoap[] toSoapModels(Config[] models) {
		ConfigSoap[] soapModels = new ConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConfigSoap[][] toSoapModels(Config[][] models) {
		ConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConfigSoap[] toSoapModels(List<Config> models) {
		List<ConfigSoap> soapModels = new ArrayList<ConfigSoap>(models.size());

		for (Config model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConfigSoap[soapModels.size()]);
	}

	public ConfigSoap() {
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

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private long _id;
	private String _key;
	private String _value;
	private String _title;
}
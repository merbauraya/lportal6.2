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
public class stateSoap implements Serializable {
	public static stateSoap toSoapModel(state model) {
		stateSoap soapModel = new stateSoap();

		soapModel.setStateId(model.getStateId());
		soapModel.setStateCode(model.getStateCode());
		soapModel.setStateName(model.getStateName());

		return soapModel;
	}

	public static stateSoap[] toSoapModels(state[] models) {
		stateSoap[] soapModels = new stateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static stateSoap[][] toSoapModels(state[][] models) {
		stateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new stateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new stateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static stateSoap[] toSoapModels(List<state> models) {
		List<stateSoap> soapModels = new ArrayList<stateSoap>(models.size());

		for (state model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new stateSoap[soapModels.size()]);
	}

	public stateSoap() {
	}

	public long getPrimaryKey() {
		return _stateId;
	}

	public void setPrimaryKey(long pk) {
		setStateId(pk);
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public String getStateCode() {
		return _stateCode;
	}

	public void setStateCode(String stateCode) {
		_stateCode = stateCode;
	}

	public String getStateName() {
		return _stateName;
	}

	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	private long _stateId;
	private String _stateCode;
	private String _stateName;
}
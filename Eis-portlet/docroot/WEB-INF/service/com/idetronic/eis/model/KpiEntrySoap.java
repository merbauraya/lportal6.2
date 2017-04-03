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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.KpiEntryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.KpiEntryServiceSoap
 * @generated
 */
public class KpiEntrySoap implements Serializable {
	public static KpiEntrySoap toSoapModel(KpiEntry model) {
		KpiEntrySoap soapModel = new KpiEntrySoap();

		soapModel.setKpiEntryId(model.getKpiEntryId());
		soapModel.setKpiTypeId(model.getKpiTypeId());
		soapModel.setPeriodYear(model.getPeriodYear());
		soapModel.setPeriodType(model.getPeriodType());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setValue(model.getValue());
		soapModel.setActual(model.getActual());

		return soapModel;
	}

	public static KpiEntrySoap[] toSoapModels(KpiEntry[] models) {
		KpiEntrySoap[] soapModels = new KpiEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KpiEntrySoap[][] toSoapModels(KpiEntry[][] models) {
		KpiEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KpiEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new KpiEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KpiEntrySoap[] toSoapModels(List<KpiEntry> models) {
		List<KpiEntrySoap> soapModels = new ArrayList<KpiEntrySoap>(models.size());

		for (KpiEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KpiEntrySoap[soapModels.size()]);
	}

	public KpiEntrySoap() {
	}

	public long getPrimaryKey() {
		return _kpiEntryId;
	}

	public void setPrimaryKey(long pk) {
		setKpiEntryId(pk);
	}

	public long getKpiEntryId() {
		return _kpiEntryId;
	}

	public void setKpiEntryId(long kpiEntryId) {
		_kpiEntryId = kpiEntryId;
	}

	public long getKpiTypeId() {
		return _kpiTypeId;
	}

	public void setKpiTypeId(long kpiTypeId) {
		_kpiTypeId = kpiTypeId;
	}

	public String getPeriodYear() {
		return _periodYear;
	}

	public void setPeriodYear(String periodYear) {
		_periodYear = periodYear;
	}

	public int getPeriodType() {
		return _periodType;
	}

	public void setPeriodType(int periodType) {
		_periodType = periodType;
	}

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	public double getActual() {
		return _actual;
	}

	public void setActual(double actual) {
		_actual = actual;
	}

	private long _kpiEntryId;
	private long _kpiTypeId;
	private String _periodYear;
	private int _periodType;
	private String _period;
	private double _value;
	private double _actual;
}
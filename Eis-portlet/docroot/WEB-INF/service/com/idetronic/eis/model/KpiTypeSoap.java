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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.KpiTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.KpiTypeServiceSoap
 * @generated
 */
public class KpiTypeSoap implements Serializable {
	public static KpiTypeSoap toSoapModel(KpiType model) {
		KpiTypeSoap soapModel = new KpiTypeSoap();

		soapModel.setKpiTypeId(model.getKpiTypeId());
		soapModel.setKpiTypeKey(model.getKpiTypeKey());
		soapModel.setKpiName(model.getKpiName());
		soapModel.setPeriodMonth(model.getPeriodMonth());
		soapModel.setPeriodQuarter(model.getPeriodQuarter());
		soapModel.setPeriodSemiAnnual(model.getPeriodSemiAnnual());
		soapModel.setPeriodYear(model.getPeriodYear());
		soapModel.setIsDecimal(model.getIsDecimal());
		soapModel.setManualValue(model.getManualValue());

		return soapModel;
	}

	public static KpiTypeSoap[] toSoapModels(KpiType[] models) {
		KpiTypeSoap[] soapModels = new KpiTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KpiTypeSoap[][] toSoapModels(KpiType[][] models) {
		KpiTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KpiTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KpiTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KpiTypeSoap[] toSoapModels(List<KpiType> models) {
		List<KpiTypeSoap> soapModels = new ArrayList<KpiTypeSoap>(models.size());

		for (KpiType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KpiTypeSoap[soapModels.size()]);
	}

	public KpiTypeSoap() {
	}

	public long getPrimaryKey() {
		return _kpiTypeId;
	}

	public void setPrimaryKey(long pk) {
		setKpiTypeId(pk);
	}

	public long getKpiTypeId() {
		return _kpiTypeId;
	}

	public void setKpiTypeId(long kpiTypeId) {
		_kpiTypeId = kpiTypeId;
	}

	public String getKpiTypeKey() {
		return _kpiTypeKey;
	}

	public void setKpiTypeKey(String kpiTypeKey) {
		_kpiTypeKey = kpiTypeKey;
	}

	public String getKpiName() {
		return _kpiName;
	}

	public void setKpiName(String kpiName) {
		_kpiName = kpiName;
	}

	public boolean getPeriodMonth() {
		return _periodMonth;
	}

	public boolean isPeriodMonth() {
		return _periodMonth;
	}

	public void setPeriodMonth(boolean periodMonth) {
		_periodMonth = periodMonth;
	}

	public boolean getPeriodQuarter() {
		return _periodQuarter;
	}

	public boolean isPeriodQuarter() {
		return _periodQuarter;
	}

	public void setPeriodQuarter(boolean periodQuarter) {
		_periodQuarter = periodQuarter;
	}

	public boolean getPeriodSemiAnnual() {
		return _periodSemiAnnual;
	}

	public boolean isPeriodSemiAnnual() {
		return _periodSemiAnnual;
	}

	public void setPeriodSemiAnnual(boolean periodSemiAnnual) {
		_periodSemiAnnual = periodSemiAnnual;
	}

	public boolean getPeriodYear() {
		return _periodYear;
	}

	public boolean isPeriodYear() {
		return _periodYear;
	}

	public void setPeriodYear(boolean periodYear) {
		_periodYear = periodYear;
	}

	public boolean getIsDecimal() {
		return _isDecimal;
	}

	public boolean isIsDecimal() {
		return _isDecimal;
	}

	public void setIsDecimal(boolean isDecimal) {
		_isDecimal = isDecimal;
	}

	public boolean getManualValue() {
		return _manualValue;
	}

	public boolean isManualValue() {
		return _manualValue;
	}

	public void setManualValue(boolean manualValue) {
		_manualValue = manualValue;
	}

	private long _kpiTypeId;
	private String _kpiTypeKey;
	private String _kpiName;
	private boolean _periodMonth;
	private boolean _periodQuarter;
	private boolean _periodSemiAnnual;
	private boolean _periodYear;
	private boolean _isDecimal;
	private boolean _manualValue;
}
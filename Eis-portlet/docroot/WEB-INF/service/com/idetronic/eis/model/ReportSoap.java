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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.ReportServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.ReportServiceSoap
 * @generated
 */
public class ReportSoap implements Serializable {
	public static ReportSoap toSoapModel(Report model) {
		ReportSoap soapModel = new ReportSoap();

		soapModel.setReportId(model.getReportId());
		soapModel.setReportKey(model.getReportKey());
		soapModel.setReportName(model.getReportName());
		soapModel.setReportTitle(model.getReportTitle());
		soapModel.setDataEntry(model.getDataEntry());
		soapModel.setHqDataEntry(model.getHqDataEntry());
		soapModel.setDimensionId(model.getDimensionId());
		soapModel.setHasMeasure1(model.getHasMeasure1());
		soapModel.setHasMeasure2(model.getHasMeasure2());
		soapModel.setHasMeasure3(model.getHasMeasure3());
		soapModel.setHasMeasure4(model.getHasMeasure4());
		soapModel.setMeasure1Name(model.getMeasure1Name());
		soapModel.setMeasure2Name(model.getMeasure2Name());
		soapModel.setMeasure3Name(model.getMeasure3Name());
		soapModel.setMeasure4Name(model.getMeasure4Name());
		soapModel.setDataName(model.getDataName());

		return soapModel;
	}

	public static ReportSoap[] toSoapModels(Report[] models) {
		ReportSoap[] soapModels = new ReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReportSoap[][] toSoapModels(Report[][] models) {
		ReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReportSoap[] toSoapModels(List<Report> models) {
		List<ReportSoap> soapModels = new ArrayList<ReportSoap>(models.size());

		for (Report model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReportSoap[soapModels.size()]);
	}

	public ReportSoap() {
	}

	public long getPrimaryKey() {
		return _reportId;
	}

	public void setPrimaryKey(long pk) {
		setReportId(pk);
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
	}

	public String getReportKey() {
		return _reportKey;
	}

	public void setReportKey(String reportKey) {
		_reportKey = reportKey;
	}

	public String getReportName() {
		return _reportName;
	}

	public void setReportName(String reportName) {
		_reportName = reportName;
	}

	public String getReportTitle() {
		return _reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		_reportTitle = reportTitle;
	}

	public boolean getDataEntry() {
		return _dataEntry;
	}

	public boolean isDataEntry() {
		return _dataEntry;
	}

	public void setDataEntry(boolean dataEntry) {
		_dataEntry = dataEntry;
	}

	public boolean getHqDataEntry() {
		return _hqDataEntry;
	}

	public boolean isHqDataEntry() {
		return _hqDataEntry;
	}

	public void setHqDataEntry(boolean hqDataEntry) {
		_hqDataEntry = hqDataEntry;
	}

	public long getDimensionId() {
		return _dimensionId;
	}

	public void setDimensionId(long dimensionId) {
		_dimensionId = dimensionId;
	}

	public boolean getHasMeasure1() {
		return _hasMeasure1;
	}

	public boolean isHasMeasure1() {
		return _hasMeasure1;
	}

	public void setHasMeasure1(boolean hasMeasure1) {
		_hasMeasure1 = hasMeasure1;
	}

	public boolean getHasMeasure2() {
		return _hasMeasure2;
	}

	public boolean isHasMeasure2() {
		return _hasMeasure2;
	}

	public void setHasMeasure2(boolean hasMeasure2) {
		_hasMeasure2 = hasMeasure2;
	}

	public boolean getHasMeasure3() {
		return _hasMeasure3;
	}

	public boolean isHasMeasure3() {
		return _hasMeasure3;
	}

	public void setHasMeasure3(boolean hasMeasure3) {
		_hasMeasure3 = hasMeasure3;
	}

	public boolean getHasMeasure4() {
		return _hasMeasure4;
	}

	public boolean isHasMeasure4() {
		return _hasMeasure4;
	}

	public void setHasMeasure4(boolean hasMeasure4) {
		_hasMeasure4 = hasMeasure4;
	}

	public String getMeasure1Name() {
		return _measure1Name;
	}

	public void setMeasure1Name(String measure1Name) {
		_measure1Name = measure1Name;
	}

	public String getMeasure2Name() {
		return _measure2Name;
	}

	public void setMeasure2Name(String measure2Name) {
		_measure2Name = measure2Name;
	}

	public String getMeasure3Name() {
		return _measure3Name;
	}

	public void setMeasure3Name(String measure3Name) {
		_measure3Name = measure3Name;
	}

	public String getMeasure4Name() {
		return _measure4Name;
	}

	public void setMeasure4Name(String measure4Name) {
		_measure4Name = measure4Name;
	}

	public String getDataName() {
		return _dataName;
	}

	public void setDataName(String dataName) {
		_dataName = dataName;
	}

	private long _reportId;
	private String _reportKey;
	private String _reportName;
	private String _reportTitle;
	private boolean _dataEntry;
	private boolean _hqDataEntry;
	private long _dimensionId;
	private boolean _hasMeasure1;
	private boolean _hasMeasure2;
	private boolean _hasMeasure3;
	private boolean _hasMeasure4;
	private String _measure1Name;
	private String _measure2Name;
	private String _measure3Name;
	private String _measure4Name;
	private String _dataName;
}
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

	private long _reportId;
	private String _reportKey;
	private String _reportName;
	private String _reportTitle;
}
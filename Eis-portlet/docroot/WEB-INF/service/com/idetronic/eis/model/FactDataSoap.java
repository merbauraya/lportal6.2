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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactDataServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactDataServiceSoap
 * @generated
 */
public class FactDataSoap implements Serializable {
	public static FactDataSoap toSoapModel(FactData model) {
		FactDataSoap soapModel = new FactDataSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setReportId(model.getReportId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setDimensionId(model.getDimensionId());
		soapModel.setMeasure1(model.getMeasure1());
		soapModel.setMeasure2(model.getMeasure2());
		soapModel.setMeasure3(model.getMeasure3());
		soapModel.setMeasure4(model.getMeasure4());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactDataSoap[] toSoapModels(FactData[] models) {
		FactDataSoap[] soapModels = new FactDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactDataSoap[][] toSoapModels(FactData[][] models) {
		FactDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactDataSoap[] toSoapModels(List<FactData> models) {
		List<FactDataSoap> soapModels = new ArrayList<FactDataSoap>(models.size());

		for (FactData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactDataSoap[soapModels.size()]);
	}

	public FactDataSoap() {
	}

	public long getPrimaryKey() {
		return _factId;
	}

	public void setPrimaryKey(long pk) {
		setFactId(pk);
	}

	public long getFactId() {
		return _factId;
	}

	public void setFactId(long factId) {
		_factId = factId;
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public long getDimensionId() {
		return _dimensionId;
	}

	public void setDimensionId(long dimensionId) {
		_dimensionId = dimensionId;
	}

	public double getMeasure1() {
		return _measure1;
	}

	public void setMeasure1(double measure1) {
		_measure1 = measure1;
	}

	public double getMeasure2() {
		return _measure2;
	}

	public void setMeasure2(double measure2) {
		_measure2 = measure2;
	}

	public double getMeasure3() {
		return _measure3;
	}

	public void setMeasure3(double measure3) {
		_measure3 = measure3;
	}

	public double getMeasure4() {
		return _measure4;
	}

	public void setMeasure4(double measure4) {
		_measure4 = measure4;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _factId;
	private long _reportId;
	private long _libraryId;
	private String _period;
	private long _dimensionId;
	private double _measure1;
	private double _measure2;
	private double _measure3;
	private double _measure4;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
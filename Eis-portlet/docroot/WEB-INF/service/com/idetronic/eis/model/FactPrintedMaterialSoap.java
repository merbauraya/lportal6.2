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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactPrintedMaterialServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactPrintedMaterialServiceSoap
 * @generated
 */
public class FactPrintedMaterialSoap implements Serializable {
	public static FactPrintedMaterialSoap toSoapModel(FactPrintedMaterial model) {
		FactPrintedMaterialSoap soapModel = new FactPrintedMaterialSoap();

		soapModel.setFactPrintedMaterialId(model.getFactPrintedMaterialId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setLibraryCode(model.getLibraryCode());
		soapModel.setStateId(model.getStateId());
		soapModel.setStateCode(model.getStateCode());
		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setMonthVal(model.getMonthVal());
		soapModel.setYearVal(model.getYearVal());
		soapModel.setTitleTotal(model.getTitleTotal());
		soapModel.setVolumeTotal(model.getVolumeTotal());
		soapModel.setDateCreated(model.getDateCreated());
		soapModel.setCreatedByUserName(model.getCreatedByUserName());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());

		return soapModel;
	}

	public static FactPrintedMaterialSoap[] toSoapModels(
		FactPrintedMaterial[] models) {
		FactPrintedMaterialSoap[] soapModels = new FactPrintedMaterialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactPrintedMaterialSoap[][] toSoapModels(
		FactPrintedMaterial[][] models) {
		FactPrintedMaterialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactPrintedMaterialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactPrintedMaterialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactPrintedMaterialSoap[] toSoapModels(
		List<FactPrintedMaterial> models) {
		List<FactPrintedMaterialSoap> soapModels = new ArrayList<FactPrintedMaterialSoap>(models.size());

		for (FactPrintedMaterial model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactPrintedMaterialSoap[soapModels.size()]);
	}

	public FactPrintedMaterialSoap() {
	}

	public long getPrimaryKey() {
		return _factPrintedMaterialId;
	}

	public void setPrimaryKey(long pk) {
		setFactPrintedMaterialId(pk);
	}

	public long getFactPrintedMaterialId() {
		return _factPrintedMaterialId;
	}

	public void setFactPrintedMaterialId(long factPrintedMaterialId) {
		_factPrintedMaterialId = factPrintedMaterialId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public String getLibraryCode() {
		return _libraryCode;
	}

	public void setLibraryCode(String libraryCode) {
		_libraryCode = libraryCode;
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

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;
	}

	public int getMonthVal() {
		return _monthVal;
	}

	public void setMonthVal(int monthVal) {
		_monthVal = monthVal;
	}

	public int getYearVal() {
		return _yearVal;
	}

	public void setYearVal(int yearVal) {
		_yearVal = yearVal;
	}

	public int getTitleTotal() {
		return _titleTotal;
	}

	public void setTitleTotal(int titleTotal) {
		_titleTotal = titleTotal;
	}

	public int getVolumeTotal() {
		return _volumeTotal;
	}

	public void setVolumeTotal(int volumeTotal) {
		_volumeTotal = volumeTotal;
	}

	public Date getDateCreated() {
		return _dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		_dateCreated = dateCreated;
	}

	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;
	}

	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;
	}

	private long _factPrintedMaterialId;
	private long _libraryId;
	private String _libraryCode;
	private long _stateId;
	private String _stateCode;
	private long _itemTypeId;
	private String _period;
	private long _libraryTypeId;
	private int _monthVal;
	private int _yearVal;
	private int _titleTotal;
	private int _volumeTotal;
	private Date _dateCreated;
	private String _createdByUserName;
	private long _createdByUserId;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactNonPrintedMaterialServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactNonPrintedMaterialServiceSoap
 * @generated
 */
public class FactNonPrintedMaterialSoap implements Serializable {
	public static FactNonPrintedMaterialSoap toSoapModel(
		FactNonPrintedMaterial model) {
		FactNonPrintedMaterialSoap soapModel = new FactNonPrintedMaterialSoap();

		soapModel.setFactNonPrintedMaterialId(model.getFactNonPrintedMaterialId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setLibraryCode(model.getLibraryCode());
		soapModel.setStateId(model.getStateId());
		soapModel.setStateCode(model.getStateCode());
		soapModel.setLibraryTypeId(model.getLibraryTypeId());
		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setMonthVal(model.getMonthVal());
		soapModel.setYearVal(model.getYearVal());
		soapModel.setTitleTotal(model.getTitleTotal());
		soapModel.setVolumeTotal(model.getVolumeTotal());
		soapModel.setDateCreated(model.getDateCreated());
		soapModel.setCreatedByUserName(model.getCreatedByUserName());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());

		return soapModel;
	}

	public static FactNonPrintedMaterialSoap[] toSoapModels(
		FactNonPrintedMaterial[] models) {
		FactNonPrintedMaterialSoap[] soapModels = new FactNonPrintedMaterialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactNonPrintedMaterialSoap[][] toSoapModels(
		FactNonPrintedMaterial[][] models) {
		FactNonPrintedMaterialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactNonPrintedMaterialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactNonPrintedMaterialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactNonPrintedMaterialSoap[] toSoapModels(
		List<FactNonPrintedMaterial> models) {
		List<FactNonPrintedMaterialSoap> soapModels = new ArrayList<FactNonPrintedMaterialSoap>(models.size());

		for (FactNonPrintedMaterial model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactNonPrintedMaterialSoap[soapModels.size()]);
	}

	public FactNonPrintedMaterialSoap() {
	}

	public long getPrimaryKey() {
		return _factNonPrintedMaterialId;
	}

	public void setPrimaryKey(long pk) {
		setFactNonPrintedMaterialId(pk);
	}

	public long getFactNonPrintedMaterialId() {
		return _factNonPrintedMaterialId;
	}

	public void setFactNonPrintedMaterialId(long factNonPrintedMaterialId) {
		_factNonPrintedMaterialId = factNonPrintedMaterialId;
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

	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;
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

	private long _factNonPrintedMaterialId;
	private long _libraryId;
	private String _libraryCode;
	private long _stateId;
	private String _stateCode;
	private long _libraryTypeId;
	private long _itemTypeId;
	private String _period;
	private int _monthVal;
	private int _yearVal;
	private int _titleTotal;
	private int _volumeTotal;
	private Date _dateCreated;
	private String _createdByUserName;
	private long _createdByUserId;
}
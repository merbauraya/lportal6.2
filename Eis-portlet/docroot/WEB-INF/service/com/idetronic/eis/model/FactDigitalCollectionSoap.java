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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactDigitalCollectionServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactDigitalCollectionServiceSoap
 * @generated
 */
public class FactDigitalCollectionSoap implements Serializable {
	public static FactDigitalCollectionSoap toSoapModel(
		FactDigitalCollection model) {
		FactDigitalCollectionSoap soapModel = new FactDigitalCollectionSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setItemId(model.getItemId());
		soapModel.setTitleTotal(model.getTitleTotal());
		soapModel.setVolumeTotal(model.getVolumeTotal());
		soapModel.setImageTotal(model.getImageTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactDigitalCollectionSoap[] toSoapModels(
		FactDigitalCollection[] models) {
		FactDigitalCollectionSoap[] soapModels = new FactDigitalCollectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactDigitalCollectionSoap[][] toSoapModels(
		FactDigitalCollection[][] models) {
		FactDigitalCollectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactDigitalCollectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactDigitalCollectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactDigitalCollectionSoap[] toSoapModels(
		List<FactDigitalCollection> models) {
		List<FactDigitalCollectionSoap> soapModels = new ArrayList<FactDigitalCollectionSoap>(models.size());

		for (FactDigitalCollection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactDigitalCollectionSoap[soapModels.size()]);
	}

	public FactDigitalCollectionSoap() {
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

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public long getTitleTotal() {
		return _titleTotal;
	}

	public void setTitleTotal(long titleTotal) {
		_titleTotal = titleTotal;
	}

	public long getVolumeTotal() {
		return _volumeTotal;
	}

	public void setVolumeTotal(long volumeTotal) {
		_volumeTotal = volumeTotal;
	}

	public long getImageTotal() {
		return _imageTotal;
	}

	public void setImageTotal(long imageTotal) {
		_imageTotal = imageTotal;
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
	private long _libraryId;
	private String _period;
	private long _itemId;
	private long _titleTotal;
	private long _volumeTotal;
	private long _imageTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactAcquisitionServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactAcquisitionServiceSoap
 * @generated
 */
public class FactAcquisitionSoap implements Serializable {
	public static FactAcquisitionSoap toSoapModel(FactAcquisition model) {
		FactAcquisitionSoap soapModel = new FactAcquisitionSoap();

		soapModel.setFactAcquisitionId(model.getFactAcquisitionId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setFacultyId(model.getFacultyId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setItemId(model.getItemId());
		soapModel.setApprovedTitleTotal(model.getApprovedTitleTotal());
		soapModel.setApprovedVolumeTotal(model.getApprovedVolumeTotal());
		soapModel.setApprovedAmountTotal(model.getApprovedAmountTotal());
		soapModel.setOrderTitleTotal(model.getOrderTitleTotal());
		soapModel.setOrderVolumeTotal(model.getOrderVolumeTotal());
		soapModel.setOrderAmountTotal(model.getOrderAmountTotal());
		soapModel.setVolumeTotal(model.getVolumeTotal());
		soapModel.setTitleTotal(model.getTitleTotal());
		soapModel.setAmountTotal(model.getAmountTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactAcquisitionSoap[] toSoapModels(FactAcquisition[] models) {
		FactAcquisitionSoap[] soapModels = new FactAcquisitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactAcquisitionSoap[][] toSoapModels(
		FactAcquisition[][] models) {
		FactAcquisitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactAcquisitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactAcquisitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactAcquisitionSoap[] toSoapModels(
		List<FactAcquisition> models) {
		List<FactAcquisitionSoap> soapModels = new ArrayList<FactAcquisitionSoap>(models.size());

		for (FactAcquisition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactAcquisitionSoap[soapModels.size()]);
	}

	public FactAcquisitionSoap() {
	}

	public long getPrimaryKey() {
		return _factAcquisitionId;
	}

	public void setPrimaryKey(long pk) {
		setFactAcquisitionId(pk);
	}

	public long getFactAcquisitionId() {
		return _factAcquisitionId;
	}

	public void setFactAcquisitionId(long factAcquisitionId) {
		_factAcquisitionId = factAcquisitionId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public long getFacultyId() {
		return _facultyId;
	}

	public void setFacultyId(long facultyId) {
		_facultyId = facultyId;
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

	public long getApprovedTitleTotal() {
		return _approvedTitleTotal;
	}

	public void setApprovedTitleTotal(long approvedTitleTotal) {
		_approvedTitleTotal = approvedTitleTotal;
	}

	public long getApprovedVolumeTotal() {
		return _approvedVolumeTotal;
	}

	public void setApprovedVolumeTotal(long approvedVolumeTotal) {
		_approvedVolumeTotal = approvedVolumeTotal;
	}

	public double getApprovedAmountTotal() {
		return _approvedAmountTotal;
	}

	public void setApprovedAmountTotal(double approvedAmountTotal) {
		_approvedAmountTotal = approvedAmountTotal;
	}

	public long getOrderTitleTotal() {
		return _orderTitleTotal;
	}

	public void setOrderTitleTotal(long orderTitleTotal) {
		_orderTitleTotal = orderTitleTotal;
	}

	public long getOrderVolumeTotal() {
		return _orderVolumeTotal;
	}

	public void setOrderVolumeTotal(long orderVolumeTotal) {
		_orderVolumeTotal = orderVolumeTotal;
	}

	public double getOrderAmountTotal() {
		return _orderAmountTotal;
	}

	public void setOrderAmountTotal(double orderAmountTotal) {
		_orderAmountTotal = orderAmountTotal;
	}

	public long getVolumeTotal() {
		return _volumeTotal;
	}

	public void setVolumeTotal(long volumeTotal) {
		_volumeTotal = volumeTotal;
	}

	public long getTitleTotal() {
		return _titleTotal;
	}

	public void setTitleTotal(long titleTotal) {
		_titleTotal = titleTotal;
	}

	public double getAmountTotal() {
		return _amountTotal;
	}

	public void setAmountTotal(double amountTotal) {
		_amountTotal = amountTotal;
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

	private long _factAcquisitionId;
	private long _libraryId;
	private long _facultyId;
	private String _period;
	private long _itemId;
	private long _approvedTitleTotal;
	private long _approvedVolumeTotal;
	private double _approvedAmountTotal;
	private long _orderTitleTotal;
	private long _orderVolumeTotal;
	private double _orderAmountTotal;
	private long _volumeTotal;
	private long _titleTotal;
	private double _amountTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
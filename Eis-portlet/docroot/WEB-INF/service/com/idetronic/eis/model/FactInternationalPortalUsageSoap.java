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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactInternationalPortalUsageServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactInternationalPortalUsageServiceSoap
 * @generated
 */
public class FactInternationalPortalUsageSoap implements Serializable {
	public static FactInternationalPortalUsageSoap toSoapModel(
		FactInternationalPortalUsage model) {
		FactInternationalPortalUsageSoap soapModel = new FactInternationalPortalUsageSoap();

		soapModel.setFactId(model.getFactId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setPagesTotal(model.getPagesTotal());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FactInternationalPortalUsageSoap[] toSoapModels(
		FactInternationalPortalUsage[] models) {
		FactInternationalPortalUsageSoap[] soapModels = new FactInternationalPortalUsageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactInternationalPortalUsageSoap[][] toSoapModels(
		FactInternationalPortalUsage[][] models) {
		FactInternationalPortalUsageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactInternationalPortalUsageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactInternationalPortalUsageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactInternationalPortalUsageSoap[] toSoapModels(
		List<FactInternationalPortalUsage> models) {
		List<FactInternationalPortalUsageSoap> soapModels = new ArrayList<FactInternationalPortalUsageSoap>(models.size());

		for (FactInternationalPortalUsage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactInternationalPortalUsageSoap[soapModels.size()]);
	}

	public FactInternationalPortalUsageSoap() {
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

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getPagesTotal() {
		return _pagesTotal;
	}

	public void setPagesTotal(long pagesTotal) {
		_pagesTotal = pagesTotal;
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
	private String _period;
	private long _countryId;
	private long _pagesTotal;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
}
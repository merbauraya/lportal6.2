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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FactIncome}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIncome
 * @generated
 */
public class FactIncomeWrapper implements FactIncome, ModelWrapper<FactIncome> {
	public FactIncomeWrapper(FactIncome factIncome) {
		_factIncome = factIncome;
	}

	@Override
	public Class<?> getModelClass() {
		return FactIncome.class;
	}

	@Override
	public String getModelClassName() {
		return FactIncome.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factIncomeId", getFactIncomeId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("total", getTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factIncomeId = (Long)attributes.get("factIncomeId");

		if (factIncomeId != null) {
			setFactIncomeId(factIncomeId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Double total = (Double)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this fact income.
	*
	* @return the primary key of this fact income
	*/
	@Override
	public long getPrimaryKey() {
		return _factIncome.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact income.
	*
	* @param primaryKey the primary key of this fact income
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factIncome.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact income ID of this fact income.
	*
	* @return the fact income ID of this fact income
	*/
	@Override
	public long getFactIncomeId() {
		return _factIncome.getFactIncomeId();
	}

	/**
	* Sets the fact income ID of this fact income.
	*
	* @param factIncomeId the fact income ID of this fact income
	*/
	@Override
	public void setFactIncomeId(long factIncomeId) {
		_factIncome.setFactIncomeId(factIncomeId);
	}

	/**
	* Returns the library ID of this fact income.
	*
	* @return the library ID of this fact income
	*/
	@Override
	public long getLibraryId() {
		return _factIncome.getLibraryId();
	}

	/**
	* Sets the library ID of this fact income.
	*
	* @param libraryId the library ID of this fact income
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factIncome.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact income.
	*
	* @return the period of this fact income
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factIncome.getPeriod();
	}

	/**
	* Sets the period of this fact income.
	*
	* @param period the period of this fact income
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factIncome.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact income.
	*
	* @return the item ID of this fact income
	*/
	@Override
	public long getItemId() {
		return _factIncome.getItemId();
	}

	/**
	* Sets the item ID of this fact income.
	*
	* @param itemId the item ID of this fact income
	*/
	@Override
	public void setItemId(long itemId) {
		_factIncome.setItemId(itemId);
	}

	/**
	* Returns the total of this fact income.
	*
	* @return the total of this fact income
	*/
	@Override
	public double getTotal() {
		return _factIncome.getTotal();
	}

	/**
	* Sets the total of this fact income.
	*
	* @param total the total of this fact income
	*/
	@Override
	public void setTotal(double total) {
		_factIncome.setTotal(total);
	}

	/**
	* Returns the company ID of this fact income.
	*
	* @return the company ID of this fact income
	*/
	@Override
	public long getCompanyId() {
		return _factIncome.getCompanyId();
	}

	/**
	* Sets the company ID of this fact income.
	*
	* @param companyId the company ID of this fact income
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factIncome.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact income.
	*
	* @return the group ID of this fact income
	*/
	@Override
	public long getGroupId() {
		return _factIncome.getGroupId();
	}

	/**
	* Sets the group ID of this fact income.
	*
	* @param groupId the group ID of this fact income
	*/
	@Override
	public void setGroupId(long groupId) {
		_factIncome.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact income.
	*
	* @return the user ID of this fact income
	*/
	@Override
	public long getUserId() {
		return _factIncome.getUserId();
	}

	/**
	* Sets the user ID of this fact income.
	*
	* @param userId the user ID of this fact income
	*/
	@Override
	public void setUserId(long userId) {
		_factIncome.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact income.
	*
	* @return the user uuid of this fact income
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIncome.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact income.
	*
	* @param userUuid the user uuid of this fact income
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factIncome.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact income.
	*
	* @return the user name of this fact income
	*/
	@Override
	public java.lang.String getUserName() {
		return _factIncome.getUserName();
	}

	/**
	* Sets the user name of this fact income.
	*
	* @param userName the user name of this fact income
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factIncome.setUserName(userName);
	}

	/**
	* Returns the create date of this fact income.
	*
	* @return the create date of this fact income
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factIncome.getCreateDate();
	}

	/**
	* Sets the create date of this fact income.
	*
	* @param createDate the create date of this fact income
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factIncome.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factIncome.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factIncome.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factIncome.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factIncome.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factIncome.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factIncome.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factIncome.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factIncome.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factIncome.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factIncome.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factIncome.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactIncomeWrapper((FactIncome)_factIncome.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactIncome factIncome) {
		return _factIncome.compareTo(factIncome);
	}

	@Override
	public int hashCode() {
		return _factIncome.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactIncome> toCacheModel() {
		return _factIncome.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactIncome toEscapedModel() {
		return new FactIncomeWrapper(_factIncome.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactIncome toUnescapedModel() {
		return new FactIncomeWrapper(_factIncome.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factIncome.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factIncome.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factIncome.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactIncomeWrapper)) {
			return false;
		}

		FactIncomeWrapper factIncomeWrapper = (FactIncomeWrapper)obj;

		if (Validator.equals(_factIncome, factIncomeWrapper._factIncome)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactIncome getWrappedFactIncome() {
		return _factIncome;
	}

	@Override
	public FactIncome getWrappedModel() {
		return _factIncome;
	}

	@Override
	public void resetOriginalValues() {
		_factIncome.resetOriginalValues();
	}

	private FactIncome _factIncome;
}
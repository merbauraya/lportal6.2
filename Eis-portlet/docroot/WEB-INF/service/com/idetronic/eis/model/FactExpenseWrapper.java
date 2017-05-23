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
 * This class is a wrapper for {@link FactExpense}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactExpense
 * @generated
 */
public class FactExpenseWrapper implements FactExpense,
	ModelWrapper<FactExpense> {
	public FactExpenseWrapper(FactExpense factExpense) {
		_factExpense = factExpense;
	}

	@Override
	public Class<?> getModelClass() {
		return FactExpense.class;
	}

	@Override
	public String getModelClassName() {
		return FactExpense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factExpenseId", getFactExpenseId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("entryType", getEntryType());
		attributes.put("masterFileId", getMasterFileId());
		attributes.put("amount", getAmount());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factExpenseId = (Long)attributes.get("factExpenseId");

		if (factExpenseId != null) {
			setFactExpenseId(factExpenseId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Integer entryType = (Integer)attributes.get("entryType");

		if (entryType != null) {
			setEntryType(entryType);
		}

		Long masterFileId = (Long)attributes.get("masterFileId");

		if (masterFileId != null) {
			setMasterFileId(masterFileId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
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
	* Returns the primary key of this fact expense.
	*
	* @return the primary key of this fact expense
	*/
	@Override
	public long getPrimaryKey() {
		return _factExpense.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact expense.
	*
	* @param primaryKey the primary key of this fact expense
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factExpense.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact expense ID of this fact expense.
	*
	* @return the fact expense ID of this fact expense
	*/
	@Override
	public long getFactExpenseId() {
		return _factExpense.getFactExpenseId();
	}

	/**
	* Sets the fact expense ID of this fact expense.
	*
	* @param factExpenseId the fact expense ID of this fact expense
	*/
	@Override
	public void setFactExpenseId(long factExpenseId) {
		_factExpense.setFactExpenseId(factExpenseId);
	}

	/**
	* Returns the library ID of this fact expense.
	*
	* @return the library ID of this fact expense
	*/
	@Override
	public long getLibraryId() {
		return _factExpense.getLibraryId();
	}

	/**
	* Sets the library ID of this fact expense.
	*
	* @param libraryId the library ID of this fact expense
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factExpense.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact expense.
	*
	* @return the period of this fact expense
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factExpense.getPeriod();
	}

	/**
	* Sets the period of this fact expense.
	*
	* @param period the period of this fact expense
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factExpense.setPeriod(period);
	}

	/**
	* Returns the entry type of this fact expense.
	*
	* @return the entry type of this fact expense
	*/
	@Override
	public int getEntryType() {
		return _factExpense.getEntryType();
	}

	/**
	* Sets the entry type of this fact expense.
	*
	* @param entryType the entry type of this fact expense
	*/
	@Override
	public void setEntryType(int entryType) {
		_factExpense.setEntryType(entryType);
	}

	/**
	* Returns the master file ID of this fact expense.
	*
	* @return the master file ID of this fact expense
	*/
	@Override
	public long getMasterFileId() {
		return _factExpense.getMasterFileId();
	}

	/**
	* Sets the master file ID of this fact expense.
	*
	* @param masterFileId the master file ID of this fact expense
	*/
	@Override
	public void setMasterFileId(long masterFileId) {
		_factExpense.setMasterFileId(masterFileId);
	}

	/**
	* Returns the amount of this fact expense.
	*
	* @return the amount of this fact expense
	*/
	@Override
	public double getAmount() {
		return _factExpense.getAmount();
	}

	/**
	* Sets the amount of this fact expense.
	*
	* @param amount the amount of this fact expense
	*/
	@Override
	public void setAmount(double amount) {
		_factExpense.setAmount(amount);
	}

	/**
	* Returns the company ID of this fact expense.
	*
	* @return the company ID of this fact expense
	*/
	@Override
	public long getCompanyId() {
		return _factExpense.getCompanyId();
	}

	/**
	* Sets the company ID of this fact expense.
	*
	* @param companyId the company ID of this fact expense
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factExpense.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact expense.
	*
	* @return the group ID of this fact expense
	*/
	@Override
	public long getGroupId() {
		return _factExpense.getGroupId();
	}

	/**
	* Sets the group ID of this fact expense.
	*
	* @param groupId the group ID of this fact expense
	*/
	@Override
	public void setGroupId(long groupId) {
		_factExpense.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact expense.
	*
	* @return the user ID of this fact expense
	*/
	@Override
	public long getUserId() {
		return _factExpense.getUserId();
	}

	/**
	* Sets the user ID of this fact expense.
	*
	* @param userId the user ID of this fact expense
	*/
	@Override
	public void setUserId(long userId) {
		_factExpense.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact expense.
	*
	* @return the user uuid of this fact expense
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpense.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact expense.
	*
	* @param userUuid the user uuid of this fact expense
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factExpense.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact expense.
	*
	* @return the user name of this fact expense
	*/
	@Override
	public java.lang.String getUserName() {
		return _factExpense.getUserName();
	}

	/**
	* Sets the user name of this fact expense.
	*
	* @param userName the user name of this fact expense
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factExpense.setUserName(userName);
	}

	/**
	* Returns the create date of this fact expense.
	*
	* @return the create date of this fact expense
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factExpense.getCreateDate();
	}

	/**
	* Sets the create date of this fact expense.
	*
	* @param createDate the create date of this fact expense
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factExpense.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factExpense.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factExpense.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factExpense.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factExpense.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factExpense.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factExpense.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factExpense.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factExpense.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factExpense.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factExpense.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factExpense.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactExpenseWrapper((FactExpense)_factExpense.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactExpense factExpense) {
		return _factExpense.compareTo(factExpense);
	}

	@Override
	public int hashCode() {
		return _factExpense.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactExpense> toCacheModel() {
		return _factExpense.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactExpense toEscapedModel() {
		return new FactExpenseWrapper(_factExpense.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactExpense toUnescapedModel() {
		return new FactExpenseWrapper(_factExpense.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factExpense.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factExpense.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factExpense.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactExpenseWrapper)) {
			return false;
		}

		FactExpenseWrapper factExpenseWrapper = (FactExpenseWrapper)obj;

		if (Validator.equals(_factExpense, factExpenseWrapper._factExpense)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactExpense getWrappedFactExpense() {
		return _factExpense;
	}

	@Override
	public FactExpense getWrappedModel() {
		return _factExpense;
	}

	@Override
	public void resetOriginalValues() {
		_factExpense.resetOriginalValues();
	}

	private FactExpense _factExpense;
}
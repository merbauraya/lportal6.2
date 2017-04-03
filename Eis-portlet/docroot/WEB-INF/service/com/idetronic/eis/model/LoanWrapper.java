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
 * This class is a wrapper for {@link Loan}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Loan
 * @generated
 */
public class LoanWrapper implements Loan, ModelWrapper<Loan> {
	public LoanWrapper(Loan loan) {
		_loan = loan;
	}

	@Override
	public Class<?> getModelClass() {
		return Loan.class;
	}

	@Override
	public String getModelClassName() {
		return Loan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loanEntryId", getLoanEntryId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("period", getPeriod());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("periodYear", getPeriodYear());
		attributes.put("periodMonth", getPeriodMonth());
		attributes.put("createDate", getCreateDate());
		attributes.put("memberCategoryId", getMemberCategoryId());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long loanEntryId = (Long)attributes.get("loanEntryId");

		if (loanEntryId != null) {
			setLoanEntryId(loanEntryId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Integer periodYear = (Integer)attributes.get("periodYear");

		if (periodYear != null) {
			setPeriodYear(periodYear);
		}

		Integer periodMonth = (Integer)attributes.get("periodMonth");

		if (periodMonth != null) {
			setPeriodMonth(periodMonth);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long memberCategoryId = (Long)attributes.get("memberCategoryId");

		if (memberCategoryId != null) {
			setMemberCategoryId(memberCategoryId);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this loan.
	*
	* @return the primary key of this loan
	*/
	@Override
	public long getPrimaryKey() {
		return _loan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this loan.
	*
	* @param primaryKey the primary key of this loan
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the loan entry ID of this loan.
	*
	* @return the loan entry ID of this loan
	*/
	@Override
	public long getLoanEntryId() {
		return _loan.getLoanEntryId();
	}

	/**
	* Sets the loan entry ID of this loan.
	*
	* @param loanEntryId the loan entry ID of this loan
	*/
	@Override
	public void setLoanEntryId(long loanEntryId) {
		_loan.setLoanEntryId(loanEntryId);
	}

	/**
	* Returns the library ID of this loan.
	*
	* @return the library ID of this loan
	*/
	@Override
	public long getLibraryId() {
		return _loan.getLibraryId();
	}

	/**
	* Sets the library ID of this loan.
	*
	* @param libraryId the library ID of this loan
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_loan.setLibraryId(libraryId);
	}

	/**
	* Returns the user ID of this loan.
	*
	* @return the user ID of this loan
	*/
	@Override
	public long getUserId() {
		return _loan.getUserId();
	}

	/**
	* Sets the user ID of this loan.
	*
	* @param userId the user ID of this loan
	*/
	@Override
	public void setUserId(long userId) {
		_loan.setUserId(userId);
	}

	/**
	* Returns the user uuid of this loan.
	*
	* @return the user uuid of this loan
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loan.getUserUuid();
	}

	/**
	* Sets the user uuid of this loan.
	*
	* @param userUuid the user uuid of this loan
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_loan.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this loan.
	*
	* @return the user name of this loan
	*/
	@Override
	public java.lang.String getUserName() {
		return _loan.getUserName();
	}

	/**
	* Sets the user name of this loan.
	*
	* @param userName the user name of this loan
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_loan.setUserName(userName);
	}

	/**
	* Returns the period of this loan.
	*
	* @return the period of this loan
	*/
	@Override
	public java.lang.String getPeriod() {
		return _loan.getPeriod();
	}

	/**
	* Sets the period of this loan.
	*
	* @param period the period of this loan
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_loan.setPeriod(period);
	}

	/**
	* Returns the state ID of this loan.
	*
	* @return the state ID of this loan
	*/
	@Override
	public long getStateId() {
		return _loan.getStateId();
	}

	/**
	* Sets the state ID of this loan.
	*
	* @param stateId the state ID of this loan
	*/
	@Override
	public void setStateId(long stateId) {
		_loan.setStateId(stateId);
	}

	/**
	* Returns the library type ID of this loan.
	*
	* @return the library type ID of this loan
	*/
	@Override
	public long getLibraryTypeId() {
		return _loan.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this loan.
	*
	* @param libraryTypeId the library type ID of this loan
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_loan.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the period year of this loan.
	*
	* @return the period year of this loan
	*/
	@Override
	public int getPeriodYear() {
		return _loan.getPeriodYear();
	}

	/**
	* Sets the period year of this loan.
	*
	* @param periodYear the period year of this loan
	*/
	@Override
	public void setPeriodYear(int periodYear) {
		_loan.setPeriodYear(periodYear);
	}

	/**
	* Returns the period month of this loan.
	*
	* @return the period month of this loan
	*/
	@Override
	public int getPeriodMonth() {
		return _loan.getPeriodMonth();
	}

	/**
	* Sets the period month of this loan.
	*
	* @param periodMonth the period month of this loan
	*/
	@Override
	public void setPeriodMonth(int periodMonth) {
		_loan.setPeriodMonth(periodMonth);
	}

	/**
	* Returns the create date of this loan.
	*
	* @return the create date of this loan
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _loan.getCreateDate();
	}

	/**
	* Sets the create date of this loan.
	*
	* @param createDate the create date of this loan
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_loan.setCreateDate(createDate);
	}

	/**
	* Returns the member category ID of this loan.
	*
	* @return the member category ID of this loan
	*/
	@Override
	public long getMemberCategoryId() {
		return _loan.getMemberCategoryId();
	}

	/**
	* Sets the member category ID of this loan.
	*
	* @param memberCategoryId the member category ID of this loan
	*/
	@Override
	public void setMemberCategoryId(long memberCategoryId) {
		_loan.setMemberCategoryId(memberCategoryId);
	}

	/**
	* Returns the value of this loan.
	*
	* @return the value of this loan
	*/
	@Override
	public int getValue() {
		return _loan.getValue();
	}

	/**
	* Sets the value of this loan.
	*
	* @param value the value of this loan
	*/
	@Override
	public void setValue(int value) {
		_loan.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _loan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_loan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _loan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _loan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _loan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_loan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _loan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_loan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_loan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_loan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LoanWrapper((Loan)_loan.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.Loan loan) {
		return _loan.compareTo(loan);
	}

	@Override
	public int hashCode() {
		return _loan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.Loan> toCacheModel() {
		return _loan.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.Loan toEscapedModel() {
		return new LoanWrapper(_loan.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.Loan toUnescapedModel() {
		return new LoanWrapper(_loan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _loan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_loan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanWrapper)) {
			return false;
		}

		LoanWrapper loanWrapper = (LoanWrapper)obj;

		if (Validator.equals(_loan, loanWrapper._loan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Loan getWrappedLoan() {
		return _loan;
	}

	@Override
	public Loan getWrappedModel() {
		return _loan;
	}

	@Override
	public void resetOriginalValues() {
		_loan.resetOriginalValues();
	}

	private Loan _loan;
}
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
 * This class is a wrapper for {@link FactInterLibLoan}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactInterLibLoan
 * @generated
 */
public class FactInterLibLoanWrapper implements FactInterLibLoan,
	ModelWrapper<FactInterLibLoan> {
	public FactInterLibLoanWrapper(FactInterLibLoan factInterLibLoan) {
		_factInterLibLoan = factInterLibLoan;
	}

	@Override
	public Class<?> getModelClass() {
		return FactInterLibLoan.class;
	}

	@Override
	public String getModelClassName() {
		return FactInterLibLoan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("ptjId", getPtjId());
		attributes.put("applyTotal", getApplyTotal());
		attributes.put("approvedTotal", getApprovedTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factId = (Long)attributes.get("factId");

		if (factId != null) {
			setFactId(factId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long ptjId = (Long)attributes.get("ptjId");

		if (ptjId != null) {
			setPtjId(ptjId);
		}

		Long applyTotal = (Long)attributes.get("applyTotal");

		if (applyTotal != null) {
			setApplyTotal(applyTotal);
		}

		Long approvedTotal = (Long)attributes.get("approvedTotal");

		if (approvedTotal != null) {
			setApprovedTotal(approvedTotal);
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
	* Returns the primary key of this fact inter lib loan.
	*
	* @return the primary key of this fact inter lib loan
	*/
	@Override
	public long getPrimaryKey() {
		return _factInterLibLoan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact inter lib loan.
	*
	* @param primaryKey the primary key of this fact inter lib loan
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factInterLibLoan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact inter lib loan.
	*
	* @return the fact ID of this fact inter lib loan
	*/
	@Override
	public long getFactId() {
		return _factInterLibLoan.getFactId();
	}

	/**
	* Sets the fact ID of this fact inter lib loan.
	*
	* @param factId the fact ID of this fact inter lib loan
	*/
	@Override
	public void setFactId(long factId) {
		_factInterLibLoan.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact inter lib loan.
	*
	* @return the library ID of this fact inter lib loan
	*/
	@Override
	public long getLibraryId() {
		return _factInterLibLoan.getLibraryId();
	}

	/**
	* Sets the library ID of this fact inter lib loan.
	*
	* @param libraryId the library ID of this fact inter lib loan
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factInterLibLoan.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact inter lib loan.
	*
	* @return the period of this fact inter lib loan
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factInterLibLoan.getPeriod();
	}

	/**
	* Sets the period of this fact inter lib loan.
	*
	* @param period the period of this fact inter lib loan
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factInterLibLoan.setPeriod(period);
	}

	/**
	* Returns the ptj ID of this fact inter lib loan.
	*
	* @return the ptj ID of this fact inter lib loan
	*/
	@Override
	public long getPtjId() {
		return _factInterLibLoan.getPtjId();
	}

	/**
	* Sets the ptj ID of this fact inter lib loan.
	*
	* @param ptjId the ptj ID of this fact inter lib loan
	*/
	@Override
	public void setPtjId(long ptjId) {
		_factInterLibLoan.setPtjId(ptjId);
	}

	/**
	* Returns the apply total of this fact inter lib loan.
	*
	* @return the apply total of this fact inter lib loan
	*/
	@Override
	public long getApplyTotal() {
		return _factInterLibLoan.getApplyTotal();
	}

	/**
	* Sets the apply total of this fact inter lib loan.
	*
	* @param applyTotal the apply total of this fact inter lib loan
	*/
	@Override
	public void setApplyTotal(long applyTotal) {
		_factInterLibLoan.setApplyTotal(applyTotal);
	}

	/**
	* Returns the approved total of this fact inter lib loan.
	*
	* @return the approved total of this fact inter lib loan
	*/
	@Override
	public long getApprovedTotal() {
		return _factInterLibLoan.getApprovedTotal();
	}

	/**
	* Sets the approved total of this fact inter lib loan.
	*
	* @param approvedTotal the approved total of this fact inter lib loan
	*/
	@Override
	public void setApprovedTotal(long approvedTotal) {
		_factInterLibLoan.setApprovedTotal(approvedTotal);
	}

	/**
	* Returns the company ID of this fact inter lib loan.
	*
	* @return the company ID of this fact inter lib loan
	*/
	@Override
	public long getCompanyId() {
		return _factInterLibLoan.getCompanyId();
	}

	/**
	* Sets the company ID of this fact inter lib loan.
	*
	* @param companyId the company ID of this fact inter lib loan
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factInterLibLoan.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact inter lib loan.
	*
	* @return the group ID of this fact inter lib loan
	*/
	@Override
	public long getGroupId() {
		return _factInterLibLoan.getGroupId();
	}

	/**
	* Sets the group ID of this fact inter lib loan.
	*
	* @param groupId the group ID of this fact inter lib loan
	*/
	@Override
	public void setGroupId(long groupId) {
		_factInterLibLoan.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact inter lib loan.
	*
	* @return the user ID of this fact inter lib loan
	*/
	@Override
	public long getUserId() {
		return _factInterLibLoan.getUserId();
	}

	/**
	* Sets the user ID of this fact inter lib loan.
	*
	* @param userId the user ID of this fact inter lib loan
	*/
	@Override
	public void setUserId(long userId) {
		_factInterLibLoan.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact inter lib loan.
	*
	* @return the user uuid of this fact inter lib loan
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoan.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact inter lib loan.
	*
	* @param userUuid the user uuid of this fact inter lib loan
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factInterLibLoan.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact inter lib loan.
	*
	* @return the user name of this fact inter lib loan
	*/
	@Override
	public java.lang.String getUserName() {
		return _factInterLibLoan.getUserName();
	}

	/**
	* Sets the user name of this fact inter lib loan.
	*
	* @param userName the user name of this fact inter lib loan
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factInterLibLoan.setUserName(userName);
	}

	/**
	* Returns the create date of this fact inter lib loan.
	*
	* @return the create date of this fact inter lib loan
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factInterLibLoan.getCreateDate();
	}

	/**
	* Sets the create date of this fact inter lib loan.
	*
	* @param createDate the create date of this fact inter lib loan
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factInterLibLoan.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factInterLibLoan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factInterLibLoan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factInterLibLoan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factInterLibLoan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factInterLibLoan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factInterLibLoan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factInterLibLoan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factInterLibLoan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factInterLibLoan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factInterLibLoan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factInterLibLoan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactInterLibLoanWrapper((FactInterLibLoan)_factInterLibLoan.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan) {
		return _factInterLibLoan.compareTo(factInterLibLoan);
	}

	@Override
	public int hashCode() {
		return _factInterLibLoan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactInterLibLoan> toCacheModel() {
		return _factInterLibLoan.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactInterLibLoan toEscapedModel() {
		return new FactInterLibLoanWrapper(_factInterLibLoan.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactInterLibLoan toUnescapedModel() {
		return new FactInterLibLoanWrapper(_factInterLibLoan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factInterLibLoan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factInterLibLoan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factInterLibLoan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactInterLibLoanWrapper)) {
			return false;
		}

		FactInterLibLoanWrapper factInterLibLoanWrapper = (FactInterLibLoanWrapper)obj;

		if (Validator.equals(_factInterLibLoan,
					factInterLibLoanWrapper._factInterLibLoan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactInterLibLoan getWrappedFactInterLibLoan() {
		return _factInterLibLoan;
	}

	@Override
	public FactInterLibLoan getWrappedModel() {
		return _factInterLibLoan;
	}

	@Override
	public void resetOriginalValues() {
		_factInterLibLoan.resetOriginalValues();
	}

	private FactInterLibLoan _factInterLibLoan;
}
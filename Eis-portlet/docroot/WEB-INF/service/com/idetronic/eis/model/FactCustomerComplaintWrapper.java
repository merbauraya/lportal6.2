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
 * This class is a wrapper for {@link FactCustomerComplaint}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactCustomerComplaint
 * @generated
 */
public class FactCustomerComplaintWrapper implements FactCustomerComplaint,
	ModelWrapper<FactCustomerComplaint> {
	public FactCustomerComplaintWrapper(
		FactCustomerComplaint factCustomerComplaint) {
		_factCustomerComplaint = factCustomerComplaint;
	}

	@Override
	public Class<?> getModelClass() {
		return FactCustomerComplaint.class;
	}

	@Override
	public String getModelClassName() {
		return FactCustomerComplaint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("complaintTotal", getComplaintTotal());
		attributes.put("unsettledTotal", getUnsettledTotal());
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

		Long complaintTotal = (Long)attributes.get("complaintTotal");

		if (complaintTotal != null) {
			setComplaintTotal(complaintTotal);
		}

		Long unsettledTotal = (Long)attributes.get("unsettledTotal");

		if (unsettledTotal != null) {
			setUnsettledTotal(unsettledTotal);
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
	* Returns the primary key of this fact customer complaint.
	*
	* @return the primary key of this fact customer complaint
	*/
	@Override
	public long getPrimaryKey() {
		return _factCustomerComplaint.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact customer complaint.
	*
	* @param primaryKey the primary key of this fact customer complaint
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factCustomerComplaint.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact customer complaint.
	*
	* @return the fact ID of this fact customer complaint
	*/
	@Override
	public long getFactId() {
		return _factCustomerComplaint.getFactId();
	}

	/**
	* Sets the fact ID of this fact customer complaint.
	*
	* @param factId the fact ID of this fact customer complaint
	*/
	@Override
	public void setFactId(long factId) {
		_factCustomerComplaint.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact customer complaint.
	*
	* @return the library ID of this fact customer complaint
	*/
	@Override
	public long getLibraryId() {
		return _factCustomerComplaint.getLibraryId();
	}

	/**
	* Sets the library ID of this fact customer complaint.
	*
	* @param libraryId the library ID of this fact customer complaint
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factCustomerComplaint.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact customer complaint.
	*
	* @return the period of this fact customer complaint
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factCustomerComplaint.getPeriod();
	}

	/**
	* Sets the period of this fact customer complaint.
	*
	* @param period the period of this fact customer complaint
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factCustomerComplaint.setPeriod(period);
	}

	/**
	* Returns the complaint total of this fact customer complaint.
	*
	* @return the complaint total of this fact customer complaint
	*/
	@Override
	public long getComplaintTotal() {
		return _factCustomerComplaint.getComplaintTotal();
	}

	/**
	* Sets the complaint total of this fact customer complaint.
	*
	* @param complaintTotal the complaint total of this fact customer complaint
	*/
	@Override
	public void setComplaintTotal(long complaintTotal) {
		_factCustomerComplaint.setComplaintTotal(complaintTotal);
	}

	/**
	* Returns the unsettled total of this fact customer complaint.
	*
	* @return the unsettled total of this fact customer complaint
	*/
	@Override
	public long getUnsettledTotal() {
		return _factCustomerComplaint.getUnsettledTotal();
	}

	/**
	* Sets the unsettled total of this fact customer complaint.
	*
	* @param unsettledTotal the unsettled total of this fact customer complaint
	*/
	@Override
	public void setUnsettledTotal(long unsettledTotal) {
		_factCustomerComplaint.setUnsettledTotal(unsettledTotal);
	}

	/**
	* Returns the company ID of this fact customer complaint.
	*
	* @return the company ID of this fact customer complaint
	*/
	@Override
	public long getCompanyId() {
		return _factCustomerComplaint.getCompanyId();
	}

	/**
	* Sets the company ID of this fact customer complaint.
	*
	* @param companyId the company ID of this fact customer complaint
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factCustomerComplaint.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact customer complaint.
	*
	* @return the group ID of this fact customer complaint
	*/
	@Override
	public long getGroupId() {
		return _factCustomerComplaint.getGroupId();
	}

	/**
	* Sets the group ID of this fact customer complaint.
	*
	* @param groupId the group ID of this fact customer complaint
	*/
	@Override
	public void setGroupId(long groupId) {
		_factCustomerComplaint.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact customer complaint.
	*
	* @return the user ID of this fact customer complaint
	*/
	@Override
	public long getUserId() {
		return _factCustomerComplaint.getUserId();
	}

	/**
	* Sets the user ID of this fact customer complaint.
	*
	* @param userId the user ID of this fact customer complaint
	*/
	@Override
	public void setUserId(long userId) {
		_factCustomerComplaint.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact customer complaint.
	*
	* @return the user uuid of this fact customer complaint
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaint.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact customer complaint.
	*
	* @param userUuid the user uuid of this fact customer complaint
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factCustomerComplaint.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact customer complaint.
	*
	* @return the user name of this fact customer complaint
	*/
	@Override
	public java.lang.String getUserName() {
		return _factCustomerComplaint.getUserName();
	}

	/**
	* Sets the user name of this fact customer complaint.
	*
	* @param userName the user name of this fact customer complaint
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factCustomerComplaint.setUserName(userName);
	}

	/**
	* Returns the create date of this fact customer complaint.
	*
	* @return the create date of this fact customer complaint
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factCustomerComplaint.getCreateDate();
	}

	/**
	* Sets the create date of this fact customer complaint.
	*
	* @param createDate the create date of this fact customer complaint
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factCustomerComplaint.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factCustomerComplaint.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factCustomerComplaint.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factCustomerComplaint.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factCustomerComplaint.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factCustomerComplaint.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factCustomerComplaint.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factCustomerComplaint.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factCustomerComplaint.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factCustomerComplaint.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factCustomerComplaint.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factCustomerComplaint.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactCustomerComplaintWrapper((FactCustomerComplaint)_factCustomerComplaint.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactCustomerComplaint factCustomerComplaint) {
		return _factCustomerComplaint.compareTo(factCustomerComplaint);
	}

	@Override
	public int hashCode() {
		return _factCustomerComplaint.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactCustomerComplaint> toCacheModel() {
		return _factCustomerComplaint.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactCustomerComplaint toEscapedModel() {
		return new FactCustomerComplaintWrapper(_factCustomerComplaint.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactCustomerComplaint toUnescapedModel() {
		return new FactCustomerComplaintWrapper(_factCustomerComplaint.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factCustomerComplaint.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factCustomerComplaint.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factCustomerComplaint.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactCustomerComplaintWrapper)) {
			return false;
		}

		FactCustomerComplaintWrapper factCustomerComplaintWrapper = (FactCustomerComplaintWrapper)obj;

		if (Validator.equals(_factCustomerComplaint,
					factCustomerComplaintWrapper._factCustomerComplaint)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactCustomerComplaint getWrappedFactCustomerComplaint() {
		return _factCustomerComplaint;
	}

	@Override
	public FactCustomerComplaint getWrappedModel() {
		return _factCustomerComplaint;
	}

	@Override
	public void resetOriginalValues() {
		_factCustomerComplaint.resetOriginalValues();
	}

	private FactCustomerComplaint _factCustomerComplaint;
}
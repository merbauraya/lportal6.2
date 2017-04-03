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
 * This class is a wrapper for {@link FactSeating}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactSeating
 * @generated
 */
public class FactSeatingWrapper implements FactSeating,
	ModelWrapper<FactSeating> {
	public FactSeatingWrapper(FactSeating factSeating) {
		_factSeating = factSeating;
	}

	@Override
	public Class<?> getModelClass() {
		return FactSeating.class;
	}

	@Override
	public String getModelClassName() {
		return FactSeating.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factSeatingId", getFactSeatingId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("seatingCategoryId", getSeatingCategoryId());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("period", getPeriod());
		attributes.put("capacity", getCapacity());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factSeatingId = (Long)attributes.get("factSeatingId");

		if (factSeatingId != null) {
			setFactSeatingId(factSeatingId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long seatingCategoryId = (Long)attributes.get("seatingCategoryId");

		if (seatingCategoryId != null) {
			setSeatingCategoryId(seatingCategoryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Integer capacity = (Integer)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
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
	* Returns the primary key of this fact seating.
	*
	* @return the primary key of this fact seating
	*/
	@Override
	public long getPrimaryKey() {
		return _factSeating.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact seating.
	*
	* @param primaryKey the primary key of this fact seating
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factSeating.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact seating ID of this fact seating.
	*
	* @return the fact seating ID of this fact seating
	*/
	@Override
	public long getFactSeatingId() {
		return _factSeating.getFactSeatingId();
	}

	/**
	* Sets the fact seating ID of this fact seating.
	*
	* @param factSeatingId the fact seating ID of this fact seating
	*/
	@Override
	public void setFactSeatingId(long factSeatingId) {
		_factSeating.setFactSeatingId(factSeatingId);
	}

	/**
	* Returns the library ID of this fact seating.
	*
	* @return the library ID of this fact seating
	*/
	@Override
	public long getLibraryId() {
		return _factSeating.getLibraryId();
	}

	/**
	* Sets the library ID of this fact seating.
	*
	* @param libraryId the library ID of this fact seating
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factSeating.setLibraryId(libraryId);
	}

	/**
	* Returns the department ID of this fact seating.
	*
	* @return the department ID of this fact seating
	*/
	@Override
	public long getDepartmentId() {
		return _factSeating.getDepartmentId();
	}

	/**
	* Sets the department ID of this fact seating.
	*
	* @param departmentId the department ID of this fact seating
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_factSeating.setDepartmentId(departmentId);
	}

	/**
	* Returns the seating category ID of this fact seating.
	*
	* @return the seating category ID of this fact seating
	*/
	@Override
	public long getSeatingCategoryId() {
		return _factSeating.getSeatingCategoryId();
	}

	/**
	* Sets the seating category ID of this fact seating.
	*
	* @param seatingCategoryId the seating category ID of this fact seating
	*/
	@Override
	public void setSeatingCategoryId(long seatingCategoryId) {
		_factSeating.setSeatingCategoryId(seatingCategoryId);
	}

	/**
	* Returns the state ID of this fact seating.
	*
	* @return the state ID of this fact seating
	*/
	@Override
	public long getStateId() {
		return _factSeating.getStateId();
	}

	/**
	* Sets the state ID of this fact seating.
	*
	* @param stateId the state ID of this fact seating
	*/
	@Override
	public void setStateId(long stateId) {
		_factSeating.setStateId(stateId);
	}

	/**
	* Returns the library type ID of this fact seating.
	*
	* @return the library type ID of this fact seating
	*/
	@Override
	public long getLibraryTypeId() {
		return _factSeating.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this fact seating.
	*
	* @param libraryTypeId the library type ID of this fact seating
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_factSeating.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the period of this fact seating.
	*
	* @return the period of this fact seating
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factSeating.getPeriod();
	}

	/**
	* Sets the period of this fact seating.
	*
	* @param period the period of this fact seating
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factSeating.setPeriod(period);
	}

	/**
	* Returns the capacity of this fact seating.
	*
	* @return the capacity of this fact seating
	*/
	@Override
	public int getCapacity() {
		return _factSeating.getCapacity();
	}

	/**
	* Sets the capacity of this fact seating.
	*
	* @param capacity the capacity of this fact seating
	*/
	@Override
	public void setCapacity(int capacity) {
		_factSeating.setCapacity(capacity);
	}

	/**
	* Returns the company ID of this fact seating.
	*
	* @return the company ID of this fact seating
	*/
	@Override
	public long getCompanyId() {
		return _factSeating.getCompanyId();
	}

	/**
	* Sets the company ID of this fact seating.
	*
	* @param companyId the company ID of this fact seating
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factSeating.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact seating.
	*
	* @return the group ID of this fact seating
	*/
	@Override
	public long getGroupId() {
		return _factSeating.getGroupId();
	}

	/**
	* Sets the group ID of this fact seating.
	*
	* @param groupId the group ID of this fact seating
	*/
	@Override
	public void setGroupId(long groupId) {
		_factSeating.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact seating.
	*
	* @return the user ID of this fact seating
	*/
	@Override
	public long getUserId() {
		return _factSeating.getUserId();
	}

	/**
	* Sets the user ID of this fact seating.
	*
	* @param userId the user ID of this fact seating
	*/
	@Override
	public void setUserId(long userId) {
		_factSeating.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact seating.
	*
	* @return the user uuid of this fact seating
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeating.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact seating.
	*
	* @param userUuid the user uuid of this fact seating
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factSeating.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact seating.
	*
	* @return the user name of this fact seating
	*/
	@Override
	public java.lang.String getUserName() {
		return _factSeating.getUserName();
	}

	/**
	* Sets the user name of this fact seating.
	*
	* @param userName the user name of this fact seating
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factSeating.setUserName(userName);
	}

	/**
	* Returns the create date of this fact seating.
	*
	* @return the create date of this fact seating
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factSeating.getCreateDate();
	}

	/**
	* Sets the create date of this fact seating.
	*
	* @param createDate the create date of this fact seating
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factSeating.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factSeating.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factSeating.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factSeating.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factSeating.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factSeating.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factSeating.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factSeating.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factSeating.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factSeating.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factSeating.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factSeating.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactSeatingWrapper((FactSeating)_factSeating.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactSeating factSeating) {
		return _factSeating.compareTo(factSeating);
	}

	@Override
	public int hashCode() {
		return _factSeating.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactSeating> toCacheModel() {
		return _factSeating.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactSeating toEscapedModel() {
		return new FactSeatingWrapper(_factSeating.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactSeating toUnescapedModel() {
		return new FactSeatingWrapper(_factSeating.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factSeating.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factSeating.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factSeating.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactSeatingWrapper)) {
			return false;
		}

		FactSeatingWrapper factSeatingWrapper = (FactSeatingWrapper)obj;

		if (Validator.equals(_factSeating, factSeatingWrapper._factSeating)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactSeating getWrappedFactSeating() {
		return _factSeating;
	}

	@Override
	public FactSeating getWrappedModel() {
		return _factSeating;
	}

	@Override
	public void resetOriginalValues() {
		_factSeating.resetOriginalValues();
	}

	private FactSeating _factSeating;
}
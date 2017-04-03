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
 * This class is a wrapper for {@link SeatingDepartment}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingDepartment
 * @generated
 */
public class SeatingDepartmentWrapper implements SeatingDepartment,
	ModelWrapper<SeatingDepartment> {
	public SeatingDepartmentWrapper(SeatingDepartment seatingDepartment) {
		_seatingDepartment = seatingDepartment;
	}

	@Override
	public Class<?> getModelClass() {
		return SeatingDepartment.class;
	}

	@Override
	public String getModelClassName() {
		return SeatingDepartment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this seating department.
	*
	* @return the primary key of this seating department
	*/
	@Override
	public long getPrimaryKey() {
		return _seatingDepartment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this seating department.
	*
	* @param primaryKey the primary key of this seating department
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_seatingDepartment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the department ID of this seating department.
	*
	* @return the department ID of this seating department
	*/
	@Override
	public long getDepartmentId() {
		return _seatingDepartment.getDepartmentId();
	}

	/**
	* Sets the department ID of this seating department.
	*
	* @param departmentId the department ID of this seating department
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_seatingDepartment.setDepartmentId(departmentId);
	}

	/**
	* Returns the department name of this seating department.
	*
	* @return the department name of this seating department
	*/
	@Override
	public java.lang.String getDepartmentName() {
		return _seatingDepartment.getDepartmentName();
	}

	/**
	* Sets the department name of this seating department.
	*
	* @param departmentName the department name of this seating department
	*/
	@Override
	public void setDepartmentName(java.lang.String departmentName) {
		_seatingDepartment.setDepartmentName(departmentName);
	}

	/**
	* Returns the company ID of this seating department.
	*
	* @return the company ID of this seating department
	*/
	@Override
	public long getCompanyId() {
		return _seatingDepartment.getCompanyId();
	}

	/**
	* Sets the company ID of this seating department.
	*
	* @param companyId the company ID of this seating department
	*/
	@Override
	public void setCompanyId(long companyId) {
		_seatingDepartment.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this seating department.
	*
	* @return the group ID of this seating department
	*/
	@Override
	public long getGroupId() {
		return _seatingDepartment.getGroupId();
	}

	/**
	* Sets the group ID of this seating department.
	*
	* @param groupId the group ID of this seating department
	*/
	@Override
	public void setGroupId(long groupId) {
		_seatingDepartment.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this seating department.
	*
	* @return the user ID of this seating department
	*/
	@Override
	public long getUserId() {
		return _seatingDepartment.getUserId();
	}

	/**
	* Sets the user ID of this seating department.
	*
	* @param userId the user ID of this seating department
	*/
	@Override
	public void setUserId(long userId) {
		_seatingDepartment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this seating department.
	*
	* @return the user uuid of this seating department
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartment.getUserUuid();
	}

	/**
	* Sets the user uuid of this seating department.
	*
	* @param userUuid the user uuid of this seating department
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_seatingDepartment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this seating department.
	*
	* @return the user name of this seating department
	*/
	@Override
	public java.lang.String getUserName() {
		return _seatingDepartment.getUserName();
	}

	/**
	* Sets the user name of this seating department.
	*
	* @param userName the user name of this seating department
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_seatingDepartment.setUserName(userName);
	}

	/**
	* Returns the create date of this seating department.
	*
	* @return the create date of this seating department
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _seatingDepartment.getCreateDate();
	}

	/**
	* Sets the create date of this seating department.
	*
	* @param createDate the create date of this seating department
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_seatingDepartment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this seating department.
	*
	* @return the modified date of this seating department
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _seatingDepartment.getModifiedDate();
	}

	/**
	* Sets the modified date of this seating department.
	*
	* @param modifiedDate the modified date of this seating department
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_seatingDepartment.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _seatingDepartment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_seatingDepartment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _seatingDepartment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_seatingDepartment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _seatingDepartment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _seatingDepartment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_seatingDepartment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _seatingDepartment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_seatingDepartment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_seatingDepartment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_seatingDepartment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SeatingDepartmentWrapper((SeatingDepartment)_seatingDepartment.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment) {
		return _seatingDepartment.compareTo(seatingDepartment);
	}

	@Override
	public int hashCode() {
		return _seatingDepartment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.SeatingDepartment> toCacheModel() {
		return _seatingDepartment.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.SeatingDepartment toEscapedModel() {
		return new SeatingDepartmentWrapper(_seatingDepartment.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.SeatingDepartment toUnescapedModel() {
		return new SeatingDepartmentWrapper(_seatingDepartment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _seatingDepartment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _seatingDepartment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_seatingDepartment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SeatingDepartmentWrapper)) {
			return false;
		}

		SeatingDepartmentWrapper seatingDepartmentWrapper = (SeatingDepartmentWrapper)obj;

		if (Validator.equals(_seatingDepartment,
					seatingDepartmentWrapper._seatingDepartment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SeatingDepartment getWrappedSeatingDepartment() {
		return _seatingDepartment;
	}

	@Override
	public SeatingDepartment getWrappedModel() {
		return _seatingDepartment;
	}

	@Override
	public void resetOriginalValues() {
		_seatingDepartment.resetOriginalValues();
	}

	private SeatingDepartment _seatingDepartment;
}
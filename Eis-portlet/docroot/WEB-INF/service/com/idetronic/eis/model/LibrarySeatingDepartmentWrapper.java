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
 * This class is a wrapper for {@link LibrarySeatingDepartment}.
 * </p>
 *
 * @author Mazlan Mat
 * @see LibrarySeatingDepartment
 * @generated
 */
public class LibrarySeatingDepartmentWrapper implements LibrarySeatingDepartment,
	ModelWrapper<LibrarySeatingDepartment> {
	public LibrarySeatingDepartmentWrapper(
		LibrarySeatingDepartment librarySeatingDepartment) {
		_librarySeatingDepartment = librarySeatingDepartment;
	}

	@Override
	public Class<?> getModelClass() {
		return LibrarySeatingDepartment.class;
	}

	@Override
	public String getModelClassName() {
		return LibrarySeatingDepartment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryDepartmentId", getLibraryDepartmentId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("departmentId", getDepartmentId());
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
		Long libraryDepartmentId = (Long)attributes.get("libraryDepartmentId");

		if (libraryDepartmentId != null) {
			setLibraryDepartmentId(libraryDepartmentId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
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
	* Returns the primary key of this library seating department.
	*
	* @return the primary key of this library seating department
	*/
	@Override
	public long getPrimaryKey() {
		return _librarySeatingDepartment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this library seating department.
	*
	* @param primaryKey the primary key of this library seating department
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_librarySeatingDepartment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the library department ID of this library seating department.
	*
	* @return the library department ID of this library seating department
	*/
	@Override
	public long getLibraryDepartmentId() {
		return _librarySeatingDepartment.getLibraryDepartmentId();
	}

	/**
	* Sets the library department ID of this library seating department.
	*
	* @param libraryDepartmentId the library department ID of this library seating department
	*/
	@Override
	public void setLibraryDepartmentId(long libraryDepartmentId) {
		_librarySeatingDepartment.setLibraryDepartmentId(libraryDepartmentId);
	}

	/**
	* Returns the library ID of this library seating department.
	*
	* @return the library ID of this library seating department
	*/
	@Override
	public long getLibraryId() {
		return _librarySeatingDepartment.getLibraryId();
	}

	/**
	* Sets the library ID of this library seating department.
	*
	* @param libraryId the library ID of this library seating department
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_librarySeatingDepartment.setLibraryId(libraryId);
	}

	/**
	* Returns the department ID of this library seating department.
	*
	* @return the department ID of this library seating department
	*/
	@Override
	public long getDepartmentId() {
		return _librarySeatingDepartment.getDepartmentId();
	}

	/**
	* Sets the department ID of this library seating department.
	*
	* @param departmentId the department ID of this library seating department
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_librarySeatingDepartment.setDepartmentId(departmentId);
	}

	/**
	* Returns the company ID of this library seating department.
	*
	* @return the company ID of this library seating department
	*/
	@Override
	public long getCompanyId() {
		return _librarySeatingDepartment.getCompanyId();
	}

	/**
	* Sets the company ID of this library seating department.
	*
	* @param companyId the company ID of this library seating department
	*/
	@Override
	public void setCompanyId(long companyId) {
		_librarySeatingDepartment.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this library seating department.
	*
	* @return the group ID of this library seating department
	*/
	@Override
	public long getGroupId() {
		return _librarySeatingDepartment.getGroupId();
	}

	/**
	* Sets the group ID of this library seating department.
	*
	* @param groupId the group ID of this library seating department
	*/
	@Override
	public void setGroupId(long groupId) {
		_librarySeatingDepartment.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this library seating department.
	*
	* @return the user ID of this library seating department
	*/
	@Override
	public long getUserId() {
		return _librarySeatingDepartment.getUserId();
	}

	/**
	* Sets the user ID of this library seating department.
	*
	* @param userId the user ID of this library seating department
	*/
	@Override
	public void setUserId(long userId) {
		_librarySeatingDepartment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this library seating department.
	*
	* @return the user uuid of this library seating department
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartment.getUserUuid();
	}

	/**
	* Sets the user uuid of this library seating department.
	*
	* @param userUuid the user uuid of this library seating department
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_librarySeatingDepartment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this library seating department.
	*
	* @return the user name of this library seating department
	*/
	@Override
	public java.lang.String getUserName() {
		return _librarySeatingDepartment.getUserName();
	}

	/**
	* Sets the user name of this library seating department.
	*
	* @param userName the user name of this library seating department
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_librarySeatingDepartment.setUserName(userName);
	}

	/**
	* Returns the create date of this library seating department.
	*
	* @return the create date of this library seating department
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _librarySeatingDepartment.getCreateDate();
	}

	/**
	* Sets the create date of this library seating department.
	*
	* @param createDate the create date of this library seating department
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_librarySeatingDepartment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this library seating department.
	*
	* @return the modified date of this library seating department
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _librarySeatingDepartment.getModifiedDate();
	}

	/**
	* Sets the modified date of this library seating department.
	*
	* @param modifiedDate the modified date of this library seating department
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_librarySeatingDepartment.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _librarySeatingDepartment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_librarySeatingDepartment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _librarySeatingDepartment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_librarySeatingDepartment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _librarySeatingDepartment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _librarySeatingDepartment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_librarySeatingDepartment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _librarySeatingDepartment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_librarySeatingDepartment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_librarySeatingDepartment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_librarySeatingDepartment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LibrarySeatingDepartmentWrapper((LibrarySeatingDepartment)_librarySeatingDepartment.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment) {
		return _librarySeatingDepartment.compareTo(librarySeatingDepartment);
	}

	@Override
	public int hashCode() {
		return _librarySeatingDepartment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.LibrarySeatingDepartment> toCacheModel() {
		return _librarySeatingDepartment.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment toEscapedModel() {
		return new LibrarySeatingDepartmentWrapper(_librarySeatingDepartment.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment toUnescapedModel() {
		return new LibrarySeatingDepartmentWrapper(_librarySeatingDepartment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _librarySeatingDepartment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _librarySeatingDepartment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_librarySeatingDepartment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LibrarySeatingDepartmentWrapper)) {
			return false;
		}

		LibrarySeatingDepartmentWrapper librarySeatingDepartmentWrapper = (LibrarySeatingDepartmentWrapper)obj;

		if (Validator.equals(_librarySeatingDepartment,
					librarySeatingDepartmentWrapper._librarySeatingDepartment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LibrarySeatingDepartment getWrappedLibrarySeatingDepartment() {
		return _librarySeatingDepartment;
	}

	@Override
	public LibrarySeatingDepartment getWrappedModel() {
		return _librarySeatingDepartment;
	}

	@Override
	public void resetOriginalValues() {
		_librarySeatingDepartment.resetOriginalValues();
	}

	private LibrarySeatingDepartment _librarySeatingDepartment;
}
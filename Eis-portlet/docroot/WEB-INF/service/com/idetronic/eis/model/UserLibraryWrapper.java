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
 * This class is a wrapper for {@link UserLibrary}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserLibrary
 * @generated
 */
public class UserLibraryWrapper implements UserLibrary,
	ModelWrapper<UserLibrary> {
	public UserLibraryWrapper(UserLibrary userLibrary) {
		_userLibrary = userLibrary;
	}

	@Override
	public Class<?> getModelClass() {
		return UserLibrary.class;
	}

	@Override
	public String getModelClassName() {
		return UserLibrary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userLibraryId", getUserLibraryId());
		attributes.put("userId", getUserId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userLibraryId = (Long)attributes.get("userLibraryId");

		if (userLibraryId != null) {
			setUserLibraryId(userLibraryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
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
	* Returns the primary key of this user library.
	*
	* @return the primary key of this user library
	*/
	@Override
	public long getPrimaryKey() {
		return _userLibrary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user library.
	*
	* @param primaryKey the primary key of this user library
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userLibrary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user library ID of this user library.
	*
	* @return the user library ID of this user library
	*/
	@Override
	public long getUserLibraryId() {
		return _userLibrary.getUserLibraryId();
	}

	/**
	* Sets the user library ID of this user library.
	*
	* @param userLibraryId the user library ID of this user library
	*/
	@Override
	public void setUserLibraryId(long userLibraryId) {
		_userLibrary.setUserLibraryId(userLibraryId);
	}

	/**
	* Returns the user ID of this user library.
	*
	* @return the user ID of this user library
	*/
	@Override
	public long getUserId() {
		return _userLibrary.getUserId();
	}

	/**
	* Sets the user ID of this user library.
	*
	* @param userId the user ID of this user library
	*/
	@Override
	public void setUserId(long userId) {
		_userLibrary.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user library.
	*
	* @return the user uuid of this user library
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibrary.getUserUuid();
	}

	/**
	* Sets the user uuid of this user library.
	*
	* @param userUuid the user uuid of this user library
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userLibrary.setUserUuid(userUuid);
	}

	/**
	* Returns the library ID of this user library.
	*
	* @return the library ID of this user library
	*/
	@Override
	public long getLibraryId() {
		return _userLibrary.getLibraryId();
	}

	/**
	* Sets the library ID of this user library.
	*
	* @param libraryId the library ID of this user library
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_userLibrary.setLibraryId(libraryId);
	}

	/**
	* Returns the company ID of this user library.
	*
	* @return the company ID of this user library
	*/
	@Override
	public long getCompanyId() {
		return _userLibrary.getCompanyId();
	}

	/**
	* Sets the company ID of this user library.
	*
	* @param companyId the company ID of this user library
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userLibrary.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this user library.
	*
	* @return the group ID of this user library
	*/
	@Override
	public long getGroupId() {
		return _userLibrary.getGroupId();
	}

	/**
	* Sets the group ID of this user library.
	*
	* @param groupId the group ID of this user library
	*/
	@Override
	public void setGroupId(long groupId) {
		_userLibrary.setGroupId(groupId);
	}

	/**
	* Returns the created by user ID of this user library.
	*
	* @return the created by user ID of this user library
	*/
	@Override
	public long getCreatedByUserId() {
		return _userLibrary.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this user library.
	*
	* @param createdByUserId the created by user ID of this user library
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_userLibrary.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this user library.
	*
	* @return the created by user uuid of this user library
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibrary.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this user library.
	*
	* @param createdByUserUuid the created by user uuid of this user library
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_userLibrary.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the user name of this user library.
	*
	* @return the user name of this user library
	*/
	@Override
	public java.lang.String getUserName() {
		return _userLibrary.getUserName();
	}

	/**
	* Sets the user name of this user library.
	*
	* @param userName the user name of this user library
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userLibrary.setUserName(userName);
	}

	/**
	* Returns the create date of this user library.
	*
	* @return the create date of this user library
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userLibrary.getCreateDate();
	}

	/**
	* Sets the create date of this user library.
	*
	* @param createDate the create date of this user library
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userLibrary.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this user library.
	*
	* @return the modified date of this user library
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _userLibrary.getModifiedDate();
	}

	/**
	* Sets the modified date of this user library.
	*
	* @param modifiedDate the modified date of this user library
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userLibrary.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _userLibrary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userLibrary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userLibrary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userLibrary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userLibrary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userLibrary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userLibrary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userLibrary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userLibrary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userLibrary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userLibrary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserLibraryWrapper((UserLibrary)_userLibrary.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.UserLibrary userLibrary) {
		return _userLibrary.compareTo(userLibrary);
	}

	@Override
	public int hashCode() {
		return _userLibrary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.UserLibrary> toCacheModel() {
		return _userLibrary.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.UserLibrary toEscapedModel() {
		return new UserLibraryWrapper(_userLibrary.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.UserLibrary toUnescapedModel() {
		return new UserLibraryWrapper(_userLibrary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userLibrary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userLibrary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userLibrary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserLibraryWrapper)) {
			return false;
		}

		UserLibraryWrapper userLibraryWrapper = (UserLibraryWrapper)obj;

		if (Validator.equals(_userLibrary, userLibraryWrapper._userLibrary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserLibrary getWrappedUserLibrary() {
		return _userLibrary;
	}

	@Override
	public UserLibrary getWrappedModel() {
		return _userLibrary;
	}

	@Override
	public void resetOriginalValues() {
		_userLibrary.resetOriginalValues();
	}

	private UserLibrary _userLibrary;
}
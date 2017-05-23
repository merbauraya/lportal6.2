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
 * This class is a wrapper for {@link UserData}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserData
 * @generated
 */
public class UserDataWrapper implements UserData, ModelWrapper<UserData> {
	public UserDataWrapper(UserData userData) {
		_userData = userData;
	}

	@Override
	public Class<?> getModelClass() {
		return UserData.class;
	}

	@Override
	public String getModelClassName() {
		return UserData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userDataId", getUserDataId());
		attributes.put("userId", getUserId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("dataId", getDataId());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userDataId = (Long)attributes.get("userDataId");

		if (userDataId != null) {
			setUserDataId(userDataId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long dataId = (Long)attributes.get("dataId");

		if (dataId != null) {
			setDataId(dataId);
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
	}

	/**
	* Returns the primary key of this user data.
	*
	* @return the primary key of this user data
	*/
	@Override
	public long getPrimaryKey() {
		return _userData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user data.
	*
	* @param primaryKey the primary key of this user data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user data ID of this user data.
	*
	* @return the user data ID of this user data
	*/
	@Override
	public long getUserDataId() {
		return _userData.getUserDataId();
	}

	/**
	* Sets the user data ID of this user data.
	*
	* @param userDataId the user data ID of this user data
	*/
	@Override
	public void setUserDataId(long userDataId) {
		_userData.setUserDataId(userDataId);
	}

	/**
	* Returns the user ID of this user data.
	*
	* @return the user ID of this user data
	*/
	@Override
	public long getUserId() {
		return _userData.getUserId();
	}

	/**
	* Sets the user ID of this user data.
	*
	* @param userId the user ID of this user data
	*/
	@Override
	public void setUserId(long userId) {
		_userData.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user data.
	*
	* @return the user uuid of this user data
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userData.getUserUuid();
	}

	/**
	* Sets the user uuid of this user data.
	*
	* @param userUuid the user uuid of this user data
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userData.setUserUuid(userUuid);
	}

	/**
	* Returns the library ID of this user data.
	*
	* @return the library ID of this user data
	*/
	@Override
	public long getLibraryId() {
		return _userData.getLibraryId();
	}

	/**
	* Sets the library ID of this user data.
	*
	* @param libraryId the library ID of this user data
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_userData.setLibraryId(libraryId);
	}

	/**
	* Returns the data ID of this user data.
	*
	* @return the data ID of this user data
	*/
	@Override
	public long getDataId() {
		return _userData.getDataId();
	}

	/**
	* Sets the data ID of this user data.
	*
	* @param dataId the data ID of this user data
	*/
	@Override
	public void setDataId(long dataId) {
		_userData.setDataId(dataId);
	}

	/**
	* Returns the created by user ID of this user data.
	*
	* @return the created by user ID of this user data
	*/
	@Override
	public long getCreatedByUserId() {
		return _userData.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this user data.
	*
	* @param createdByUserId the created by user ID of this user data
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_userData.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this user data.
	*
	* @return the created by user uuid of this user data
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userData.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this user data.
	*
	* @param createdByUserUuid the created by user uuid of this user data
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_userData.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the user name of this user data.
	*
	* @return the user name of this user data
	*/
	@Override
	public java.lang.String getUserName() {
		return _userData.getUserName();
	}

	/**
	* Sets the user name of this user data.
	*
	* @param userName the user name of this user data
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userData.setUserName(userName);
	}

	/**
	* Returns the create date of this user data.
	*
	* @return the create date of this user data
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userData.getCreateDate();
	}

	/**
	* Sets the create date of this user data.
	*
	* @param createDate the create date of this user data
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userData.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _userData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserDataWrapper((UserData)_userData.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.UserData userData) {
		return _userData.compareTo(userData);
	}

	@Override
	public int hashCode() {
		return _userData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.UserData> toCacheModel() {
		return _userData.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.UserData toEscapedModel() {
		return new UserDataWrapper(_userData.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.UserData toUnescapedModel() {
		return new UserDataWrapper(_userData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDataWrapper)) {
			return false;
		}

		UserDataWrapper userDataWrapper = (UserDataWrapper)obj;

		if (Validator.equals(_userData, userDataWrapper._userData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserData getWrappedUserData() {
		return _userData;
	}

	@Override
	public UserData getWrappedModel() {
		return _userData;
	}

	@Override
	public void resetOriginalValues() {
		_userData.resetOriginalValues();
	}

	private UserData _userData;
}
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
 * This class is a wrapper for {@link library}.
 * </p>
 *
 * @author Mazlan Mat
 * @see library
 * @generated
 */
public class libraryWrapper implements library, ModelWrapper<library> {
	public libraryWrapper(library library) {
		_library = library;
	}

	@Override
	public Class<?> getModelClass() {
		return library.class;
	}

	@Override
	public String getModelClassName() {
		return library.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryId", getLibraryId());
		attributes.put("libraryCode", getLibraryCode());
		attributes.put("stateCode", getStateCode());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("stateName", getStateName());
		attributes.put("libraryName", getLibraryName());
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
		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String libraryCode = (String)attributes.get("libraryCode");

		if (libraryCode != null) {
			setLibraryCode(libraryCode);
		}

		String stateCode = (String)attributes.get("stateCode");

		if (stateCode != null) {
			setStateCode(stateCode);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		String libraryName = (String)attributes.get("libraryName");

		if (libraryName != null) {
			setLibraryName(libraryName);
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
	* Returns the primary key of this library.
	*
	* @return the primary key of this library
	*/
	@Override
	public long getPrimaryKey() {
		return _library.getPrimaryKey();
	}

	/**
	* Sets the primary key of this library.
	*
	* @param primaryKey the primary key of this library
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_library.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the library ID of this library.
	*
	* @return the library ID of this library
	*/
	@Override
	public long getLibraryId() {
		return _library.getLibraryId();
	}

	/**
	* Sets the library ID of this library.
	*
	* @param libraryId the library ID of this library
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_library.setLibraryId(libraryId);
	}

	/**
	* Returns the library code of this library.
	*
	* @return the library code of this library
	*/
	@Override
	public java.lang.String getLibraryCode() {
		return _library.getLibraryCode();
	}

	/**
	* Sets the library code of this library.
	*
	* @param libraryCode the library code of this library
	*/
	@Override
	public void setLibraryCode(java.lang.String libraryCode) {
		_library.setLibraryCode(libraryCode);
	}

	/**
	* Returns the state code of this library.
	*
	* @return the state code of this library
	*/
	@Override
	public java.lang.String getStateCode() {
		return _library.getStateCode();
	}

	/**
	* Sets the state code of this library.
	*
	* @param stateCode the state code of this library
	*/
	@Override
	public void setStateCode(java.lang.String stateCode) {
		_library.setStateCode(stateCode);
	}

	/**
	* Returns the library type ID of this library.
	*
	* @return the library type ID of this library
	*/
	@Override
	public long getLibraryTypeId() {
		return _library.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this library.
	*
	* @param libraryTypeId the library type ID of this library
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_library.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the state name of this library.
	*
	* @return the state name of this library
	*/
	@Override
	public java.lang.String getStateName() {
		return _library.getStateName();
	}

	/**
	* Sets the state name of this library.
	*
	* @param stateName the state name of this library
	*/
	@Override
	public void setStateName(java.lang.String stateName) {
		_library.setStateName(stateName);
	}

	/**
	* Returns the library name of this library.
	*
	* @return the library name of this library
	*/
	@Override
	public java.lang.String getLibraryName() {
		return _library.getLibraryName();
	}

	/**
	* Sets the library name of this library.
	*
	* @param libraryName the library name of this library
	*/
	@Override
	public void setLibraryName(java.lang.String libraryName) {
		_library.setLibraryName(libraryName);
	}

	/**
	* Returns the company ID of this library.
	*
	* @return the company ID of this library
	*/
	@Override
	public long getCompanyId() {
		return _library.getCompanyId();
	}

	/**
	* Sets the company ID of this library.
	*
	* @param companyId the company ID of this library
	*/
	@Override
	public void setCompanyId(long companyId) {
		_library.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this library.
	*
	* @return the group ID of this library
	*/
	@Override
	public long getGroupId() {
		return _library.getGroupId();
	}

	/**
	* Sets the group ID of this library.
	*
	* @param groupId the group ID of this library
	*/
	@Override
	public void setGroupId(long groupId) {
		_library.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this library.
	*
	* @return the user ID of this library
	*/
	@Override
	public long getUserId() {
		return _library.getUserId();
	}

	/**
	* Sets the user ID of this library.
	*
	* @param userId the user ID of this library
	*/
	@Override
	public void setUserId(long userId) {
		_library.setUserId(userId);
	}

	/**
	* Returns the user uuid of this library.
	*
	* @return the user uuid of this library
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _library.getUserUuid();
	}

	/**
	* Sets the user uuid of this library.
	*
	* @param userUuid the user uuid of this library
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_library.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this library.
	*
	* @return the user name of this library
	*/
	@Override
	public java.lang.String getUserName() {
		return _library.getUserName();
	}

	/**
	* Sets the user name of this library.
	*
	* @param userName the user name of this library
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_library.setUserName(userName);
	}

	/**
	* Returns the create date of this library.
	*
	* @return the create date of this library
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _library.getCreateDate();
	}

	/**
	* Sets the create date of this library.
	*
	* @param createDate the create date of this library
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_library.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this library.
	*
	* @return the modified date of this library
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _library.getModifiedDate();
	}

	/**
	* Sets the modified date of this library.
	*
	* @param modifiedDate the modified date of this library
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_library.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _library.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_library.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _library.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_library.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _library.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _library.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_library.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _library.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_library.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_library.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_library.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new libraryWrapper((library)_library.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.library library) {
		return _library.compareTo(library);
	}

	@Override
	public int hashCode() {
		return _library.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.library> toCacheModel() {
		return _library.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.library toEscapedModel() {
		return new libraryWrapper(_library.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.library toUnescapedModel() {
		return new libraryWrapper(_library.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _library.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _library.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_library.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof libraryWrapper)) {
			return false;
		}

		libraryWrapper libraryWrapper = (libraryWrapper)obj;

		if (Validator.equals(_library, libraryWrapper._library)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public library getWrappedlibrary() {
		return _library;
	}

	@Override
	public library getWrappedModel() {
		return _library;
	}

	@Override
	public void resetOriginalValues() {
		_library.resetOriginalValues();
	}

	private library _library;
}
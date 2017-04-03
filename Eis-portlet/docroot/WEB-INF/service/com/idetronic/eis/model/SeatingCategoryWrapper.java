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
 * This class is a wrapper for {@link SeatingCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingCategory
 * @generated
 */
public class SeatingCategoryWrapper implements SeatingCategory,
	ModelWrapper<SeatingCategory> {
	public SeatingCategoryWrapper(SeatingCategory seatingCategory) {
		_seatingCategory = seatingCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return SeatingCategory.class;
	}

	@Override
	public String getModelClassName() {
		return SeatingCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seatingCategoryId", getSeatingCategoryId());
		attributes.put("seatingCategoryName", getSeatingCategoryName());
		attributes.put("seatingDepartmentId", getSeatingDepartmentId());
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
		Long seatingCategoryId = (Long)attributes.get("seatingCategoryId");

		if (seatingCategoryId != null) {
			setSeatingCategoryId(seatingCategoryId);
		}

		String seatingCategoryName = (String)attributes.get(
				"seatingCategoryName");

		if (seatingCategoryName != null) {
			setSeatingCategoryName(seatingCategoryName);
		}

		Long seatingDepartmentId = (Long)attributes.get("seatingDepartmentId");

		if (seatingDepartmentId != null) {
			setSeatingDepartmentId(seatingDepartmentId);
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
	* Returns the primary key of this seating category.
	*
	* @return the primary key of this seating category
	*/
	@Override
	public long getPrimaryKey() {
		return _seatingCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this seating category.
	*
	* @param primaryKey the primary key of this seating category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_seatingCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the seating category ID of this seating category.
	*
	* @return the seating category ID of this seating category
	*/
	@Override
	public long getSeatingCategoryId() {
		return _seatingCategory.getSeatingCategoryId();
	}

	/**
	* Sets the seating category ID of this seating category.
	*
	* @param seatingCategoryId the seating category ID of this seating category
	*/
	@Override
	public void setSeatingCategoryId(long seatingCategoryId) {
		_seatingCategory.setSeatingCategoryId(seatingCategoryId);
	}

	/**
	* Returns the seating category name of this seating category.
	*
	* @return the seating category name of this seating category
	*/
	@Override
	public java.lang.String getSeatingCategoryName() {
		return _seatingCategory.getSeatingCategoryName();
	}

	/**
	* Sets the seating category name of this seating category.
	*
	* @param seatingCategoryName the seating category name of this seating category
	*/
	@Override
	public void setSeatingCategoryName(java.lang.String seatingCategoryName) {
		_seatingCategory.setSeatingCategoryName(seatingCategoryName);
	}

	/**
	* Returns the seating department ID of this seating category.
	*
	* @return the seating department ID of this seating category
	*/
	@Override
	public long getSeatingDepartmentId() {
		return _seatingCategory.getSeatingDepartmentId();
	}

	/**
	* Sets the seating department ID of this seating category.
	*
	* @param seatingDepartmentId the seating department ID of this seating category
	*/
	@Override
	public void setSeatingDepartmentId(long seatingDepartmentId) {
		_seatingCategory.setSeatingDepartmentId(seatingDepartmentId);
	}

	/**
	* Returns the company ID of this seating category.
	*
	* @return the company ID of this seating category
	*/
	@Override
	public long getCompanyId() {
		return _seatingCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this seating category.
	*
	* @param companyId the company ID of this seating category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_seatingCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this seating category.
	*
	* @return the group ID of this seating category
	*/
	@Override
	public long getGroupId() {
		return _seatingCategory.getGroupId();
	}

	/**
	* Sets the group ID of this seating category.
	*
	* @param groupId the group ID of this seating category
	*/
	@Override
	public void setGroupId(long groupId) {
		_seatingCategory.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this seating category.
	*
	* @return the user ID of this seating category
	*/
	@Override
	public long getUserId() {
		return _seatingCategory.getUserId();
	}

	/**
	* Sets the user ID of this seating category.
	*
	* @param userId the user ID of this seating category
	*/
	@Override
	public void setUserId(long userId) {
		_seatingCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this seating category.
	*
	* @return the user uuid of this seating category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this seating category.
	*
	* @param userUuid the user uuid of this seating category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_seatingCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this seating category.
	*
	* @return the user name of this seating category
	*/
	@Override
	public java.lang.String getUserName() {
		return _seatingCategory.getUserName();
	}

	/**
	* Sets the user name of this seating category.
	*
	* @param userName the user name of this seating category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_seatingCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this seating category.
	*
	* @return the create date of this seating category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _seatingCategory.getCreateDate();
	}

	/**
	* Sets the create date of this seating category.
	*
	* @param createDate the create date of this seating category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_seatingCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this seating category.
	*
	* @return the modified date of this seating category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _seatingCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this seating category.
	*
	* @param modifiedDate the modified date of this seating category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_seatingCategory.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _seatingCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_seatingCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _seatingCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_seatingCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _seatingCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _seatingCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_seatingCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _seatingCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_seatingCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_seatingCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_seatingCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SeatingCategoryWrapper((SeatingCategory)_seatingCategory.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.SeatingCategory seatingCategory) {
		return _seatingCategory.compareTo(seatingCategory);
	}

	@Override
	public int hashCode() {
		return _seatingCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.SeatingCategory> toCacheModel() {
		return _seatingCategory.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.SeatingCategory toEscapedModel() {
		return new SeatingCategoryWrapper(_seatingCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.SeatingCategory toUnescapedModel() {
		return new SeatingCategoryWrapper(_seatingCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _seatingCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _seatingCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_seatingCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SeatingCategoryWrapper)) {
			return false;
		}

		SeatingCategoryWrapper seatingCategoryWrapper = (SeatingCategoryWrapper)obj;

		if (Validator.equals(_seatingCategory,
					seatingCategoryWrapper._seatingCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SeatingCategory getWrappedSeatingCategory() {
		return _seatingCategory;
	}

	@Override
	public SeatingCategory getWrappedModel() {
		return _seatingCategory;
	}

	@Override
	public void resetOriginalValues() {
		_seatingCategory.resetOriginalValues();
	}

	private SeatingCategory _seatingCategory;
}
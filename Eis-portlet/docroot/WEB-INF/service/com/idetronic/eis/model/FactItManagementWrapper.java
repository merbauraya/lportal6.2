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
 * This class is a wrapper for {@link FactItManagement}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactItManagement
 * @generated
 */
public class FactItManagementWrapper implements FactItManagement,
	ModelWrapper<FactItManagement> {
	public FactItManagementWrapper(FactItManagement factItManagement) {
		_factItManagement = factItManagement;
	}

	@Override
	public Class<?> getModelClass() {
		return FactItManagement.class;
	}

	@Override
	public String getModelClassName() {
		return FactItManagement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("itemTotal", getItemTotal());
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

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long itemTotal = (Long)attributes.get("itemTotal");

		if (itemTotal != null) {
			setItemTotal(itemTotal);
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
	* Returns the primary key of this fact it management.
	*
	* @return the primary key of this fact it management
	*/
	@Override
	public long getPrimaryKey() {
		return _factItManagement.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact it management.
	*
	* @param primaryKey the primary key of this fact it management
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factItManagement.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact it management.
	*
	* @return the fact ID of this fact it management
	*/
	@Override
	public long getFactId() {
		return _factItManagement.getFactId();
	}

	/**
	* Sets the fact ID of this fact it management.
	*
	* @param factId the fact ID of this fact it management
	*/
	@Override
	public void setFactId(long factId) {
		_factItManagement.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact it management.
	*
	* @return the library ID of this fact it management
	*/
	@Override
	public long getLibraryId() {
		return _factItManagement.getLibraryId();
	}

	/**
	* Sets the library ID of this fact it management.
	*
	* @param libraryId the library ID of this fact it management
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factItManagement.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact it management.
	*
	* @return the period of this fact it management
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factItManagement.getPeriod();
	}

	/**
	* Sets the period of this fact it management.
	*
	* @param period the period of this fact it management
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factItManagement.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact it management.
	*
	* @return the item ID of this fact it management
	*/
	@Override
	public long getItemId() {
		return _factItManagement.getItemId();
	}

	/**
	* Sets the item ID of this fact it management.
	*
	* @param itemId the item ID of this fact it management
	*/
	@Override
	public void setItemId(long itemId) {
		_factItManagement.setItemId(itemId);
	}

	/**
	* Returns the item total of this fact it management.
	*
	* @return the item total of this fact it management
	*/
	@Override
	public long getItemTotal() {
		return _factItManagement.getItemTotal();
	}

	/**
	* Sets the item total of this fact it management.
	*
	* @param itemTotal the item total of this fact it management
	*/
	@Override
	public void setItemTotal(long itemTotal) {
		_factItManagement.setItemTotal(itemTotal);
	}

	/**
	* Returns the company ID of this fact it management.
	*
	* @return the company ID of this fact it management
	*/
	@Override
	public long getCompanyId() {
		return _factItManagement.getCompanyId();
	}

	/**
	* Sets the company ID of this fact it management.
	*
	* @param companyId the company ID of this fact it management
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factItManagement.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact it management.
	*
	* @return the group ID of this fact it management
	*/
	@Override
	public long getGroupId() {
		return _factItManagement.getGroupId();
	}

	/**
	* Sets the group ID of this fact it management.
	*
	* @param groupId the group ID of this fact it management
	*/
	@Override
	public void setGroupId(long groupId) {
		_factItManagement.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact it management.
	*
	* @return the user ID of this fact it management
	*/
	@Override
	public long getUserId() {
		return _factItManagement.getUserId();
	}

	/**
	* Sets the user ID of this fact it management.
	*
	* @param userId the user ID of this fact it management
	*/
	@Override
	public void setUserId(long userId) {
		_factItManagement.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact it management.
	*
	* @return the user uuid of this fact it management
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagement.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact it management.
	*
	* @param userUuid the user uuid of this fact it management
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factItManagement.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact it management.
	*
	* @return the user name of this fact it management
	*/
	@Override
	public java.lang.String getUserName() {
		return _factItManagement.getUserName();
	}

	/**
	* Sets the user name of this fact it management.
	*
	* @param userName the user name of this fact it management
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factItManagement.setUserName(userName);
	}

	/**
	* Returns the create date of this fact it management.
	*
	* @return the create date of this fact it management
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factItManagement.getCreateDate();
	}

	/**
	* Sets the create date of this fact it management.
	*
	* @param createDate the create date of this fact it management
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factItManagement.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factItManagement.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factItManagement.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factItManagement.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factItManagement.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factItManagement.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factItManagement.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factItManagement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factItManagement.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factItManagement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factItManagement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factItManagement.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactItManagementWrapper((FactItManagement)_factItManagement.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactItManagement factItManagement) {
		return _factItManagement.compareTo(factItManagement);
	}

	@Override
	public int hashCode() {
		return _factItManagement.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactItManagement> toCacheModel() {
		return _factItManagement.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactItManagement toEscapedModel() {
		return new FactItManagementWrapper(_factItManagement.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactItManagement toUnescapedModel() {
		return new FactItManagementWrapper(_factItManagement.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factItManagement.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factItManagement.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factItManagement.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactItManagementWrapper)) {
			return false;
		}

		FactItManagementWrapper factItManagementWrapper = (FactItManagementWrapper)obj;

		if (Validator.equals(_factItManagement,
					factItManagementWrapper._factItManagement)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactItManagement getWrappedFactItManagement() {
		return _factItManagement;
	}

	@Override
	public FactItManagement getWrappedModel() {
		return _factItManagement;
	}

	@Override
	public void resetOriginalValues() {
		_factItManagement.resetOriginalValues();
	}

	private FactItManagement _factItManagement;
}
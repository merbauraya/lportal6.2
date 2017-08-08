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
 * This class is a wrapper for {@link FactDatabaseUsage}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDatabaseUsage
 * @generated
 */
public class FactDatabaseUsageWrapper implements FactDatabaseUsage,
	ModelWrapper<FactDatabaseUsage> {
	public FactDatabaseUsageWrapper(FactDatabaseUsage factDatabaseUsage) {
		_factDatabaseUsage = factDatabaseUsage;
	}

	@Override
	public Class<?> getModelClass() {
		return FactDatabaseUsage.class;
	}

	@Override
	public String getModelClassName() {
		return FactDatabaseUsage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("downloadTotal", getDownloadTotal());
		attributes.put("sessionTotal", getSessionTotal());
		attributes.put("searchTotal", getSearchTotal());
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

		Long downloadTotal = (Long)attributes.get("downloadTotal");

		if (downloadTotal != null) {
			setDownloadTotal(downloadTotal);
		}

		Long sessionTotal = (Long)attributes.get("sessionTotal");

		if (sessionTotal != null) {
			setSessionTotal(sessionTotal);
		}

		Long searchTotal = (Long)attributes.get("searchTotal");

		if (searchTotal != null) {
			setSearchTotal(searchTotal);
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
	* Returns the primary key of this fact database usage.
	*
	* @return the primary key of this fact database usage
	*/
	@Override
	public long getPrimaryKey() {
		return _factDatabaseUsage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact database usage.
	*
	* @param primaryKey the primary key of this fact database usage
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factDatabaseUsage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact database usage.
	*
	* @return the fact ID of this fact database usage
	*/
	@Override
	public long getFactId() {
		return _factDatabaseUsage.getFactId();
	}

	/**
	* Sets the fact ID of this fact database usage.
	*
	* @param factId the fact ID of this fact database usage
	*/
	@Override
	public void setFactId(long factId) {
		_factDatabaseUsage.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact database usage.
	*
	* @return the library ID of this fact database usage
	*/
	@Override
	public long getLibraryId() {
		return _factDatabaseUsage.getLibraryId();
	}

	/**
	* Sets the library ID of this fact database usage.
	*
	* @param libraryId the library ID of this fact database usage
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factDatabaseUsage.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact database usage.
	*
	* @return the period of this fact database usage
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factDatabaseUsage.getPeriod();
	}

	/**
	* Sets the period of this fact database usage.
	*
	* @param period the period of this fact database usage
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factDatabaseUsage.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact database usage.
	*
	* @return the item ID of this fact database usage
	*/
	@Override
	public long getItemId() {
		return _factDatabaseUsage.getItemId();
	}

	/**
	* Sets the item ID of this fact database usage.
	*
	* @param itemId the item ID of this fact database usage
	*/
	@Override
	public void setItemId(long itemId) {
		_factDatabaseUsage.setItemId(itemId);
	}

	/**
	* Returns the download total of this fact database usage.
	*
	* @return the download total of this fact database usage
	*/
	@Override
	public long getDownloadTotal() {
		return _factDatabaseUsage.getDownloadTotal();
	}

	/**
	* Sets the download total of this fact database usage.
	*
	* @param downloadTotal the download total of this fact database usage
	*/
	@Override
	public void setDownloadTotal(long downloadTotal) {
		_factDatabaseUsage.setDownloadTotal(downloadTotal);
	}

	/**
	* Returns the session total of this fact database usage.
	*
	* @return the session total of this fact database usage
	*/
	@Override
	public long getSessionTotal() {
		return _factDatabaseUsage.getSessionTotal();
	}

	/**
	* Sets the session total of this fact database usage.
	*
	* @param sessionTotal the session total of this fact database usage
	*/
	@Override
	public void setSessionTotal(long sessionTotal) {
		_factDatabaseUsage.setSessionTotal(sessionTotal);
	}

	/**
	* Returns the search total of this fact database usage.
	*
	* @return the search total of this fact database usage
	*/
	@Override
	public long getSearchTotal() {
		return _factDatabaseUsage.getSearchTotal();
	}

	/**
	* Sets the search total of this fact database usage.
	*
	* @param searchTotal the search total of this fact database usage
	*/
	@Override
	public void setSearchTotal(long searchTotal) {
		_factDatabaseUsage.setSearchTotal(searchTotal);
	}

	/**
	* Returns the company ID of this fact database usage.
	*
	* @return the company ID of this fact database usage
	*/
	@Override
	public long getCompanyId() {
		return _factDatabaseUsage.getCompanyId();
	}

	/**
	* Sets the company ID of this fact database usage.
	*
	* @param companyId the company ID of this fact database usage
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factDatabaseUsage.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact database usage.
	*
	* @return the group ID of this fact database usage
	*/
	@Override
	public long getGroupId() {
		return _factDatabaseUsage.getGroupId();
	}

	/**
	* Sets the group ID of this fact database usage.
	*
	* @param groupId the group ID of this fact database usage
	*/
	@Override
	public void setGroupId(long groupId) {
		_factDatabaseUsage.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact database usage.
	*
	* @return the user ID of this fact database usage
	*/
	@Override
	public long getUserId() {
		return _factDatabaseUsage.getUserId();
	}

	/**
	* Sets the user ID of this fact database usage.
	*
	* @param userId the user ID of this fact database usage
	*/
	@Override
	public void setUserId(long userId) {
		_factDatabaseUsage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact database usage.
	*
	* @return the user uuid of this fact database usage
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsage.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact database usage.
	*
	* @param userUuid the user uuid of this fact database usage
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factDatabaseUsage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact database usage.
	*
	* @return the user name of this fact database usage
	*/
	@Override
	public java.lang.String getUserName() {
		return _factDatabaseUsage.getUserName();
	}

	/**
	* Sets the user name of this fact database usage.
	*
	* @param userName the user name of this fact database usage
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factDatabaseUsage.setUserName(userName);
	}

	/**
	* Returns the create date of this fact database usage.
	*
	* @return the create date of this fact database usage
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factDatabaseUsage.getCreateDate();
	}

	/**
	* Sets the create date of this fact database usage.
	*
	* @param createDate the create date of this fact database usage
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factDatabaseUsage.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factDatabaseUsage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factDatabaseUsage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factDatabaseUsage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factDatabaseUsage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factDatabaseUsage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factDatabaseUsage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factDatabaseUsage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factDatabaseUsage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factDatabaseUsage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factDatabaseUsage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factDatabaseUsage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactDatabaseUsageWrapper((FactDatabaseUsage)_factDatabaseUsage.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactDatabaseUsage factDatabaseUsage) {
		return _factDatabaseUsage.compareTo(factDatabaseUsage);
	}

	@Override
	public int hashCode() {
		return _factDatabaseUsage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactDatabaseUsage> toCacheModel() {
		return _factDatabaseUsage.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactDatabaseUsage toEscapedModel() {
		return new FactDatabaseUsageWrapper(_factDatabaseUsage.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactDatabaseUsage toUnescapedModel() {
		return new FactDatabaseUsageWrapper(_factDatabaseUsage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factDatabaseUsage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factDatabaseUsage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factDatabaseUsage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactDatabaseUsageWrapper)) {
			return false;
		}

		FactDatabaseUsageWrapper factDatabaseUsageWrapper = (FactDatabaseUsageWrapper)obj;

		if (Validator.equals(_factDatabaseUsage,
					factDatabaseUsageWrapper._factDatabaseUsage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactDatabaseUsage getWrappedFactDatabaseUsage() {
		return _factDatabaseUsage;
	}

	@Override
	public FactDatabaseUsage getWrappedModel() {
		return _factDatabaseUsage;
	}

	@Override
	public void resetOriginalValues() {
		_factDatabaseUsage.resetOriginalValues();
	}

	private FactDatabaseUsage _factDatabaseUsage;
}
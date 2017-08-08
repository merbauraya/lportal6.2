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
 * This class is a wrapper for {@link FactArticleIndexing}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactArticleIndexing
 * @generated
 */
public class FactArticleIndexingWrapper implements FactArticleIndexing,
	ModelWrapper<FactArticleIndexing> {
	public FactArticleIndexingWrapper(FactArticleIndexing factArticleIndexing) {
		_factArticleIndexing = factArticleIndexing;
	}

	@Override
	public Class<?> getModelClass() {
		return FactArticleIndexing.class;
	}

	@Override
	public String getModelClassName() {
		return FactArticleIndexing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("indexTotal", getIndexTotal());
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

		Long indexTotal = (Long)attributes.get("indexTotal");

		if (indexTotal != null) {
			setIndexTotal(indexTotal);
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
	* Returns the primary key of this fact article indexing.
	*
	* @return the primary key of this fact article indexing
	*/
	@Override
	public long getPrimaryKey() {
		return _factArticleIndexing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact article indexing.
	*
	* @param primaryKey the primary key of this fact article indexing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factArticleIndexing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact article indexing.
	*
	* @return the fact ID of this fact article indexing
	*/
	@Override
	public long getFactId() {
		return _factArticleIndexing.getFactId();
	}

	/**
	* Sets the fact ID of this fact article indexing.
	*
	* @param factId the fact ID of this fact article indexing
	*/
	@Override
	public void setFactId(long factId) {
		_factArticleIndexing.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact article indexing.
	*
	* @return the library ID of this fact article indexing
	*/
	@Override
	public long getLibraryId() {
		return _factArticleIndexing.getLibraryId();
	}

	/**
	* Sets the library ID of this fact article indexing.
	*
	* @param libraryId the library ID of this fact article indexing
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factArticleIndexing.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact article indexing.
	*
	* @return the period of this fact article indexing
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factArticleIndexing.getPeriod();
	}

	/**
	* Sets the period of this fact article indexing.
	*
	* @param period the period of this fact article indexing
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factArticleIndexing.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact article indexing.
	*
	* @return the item ID of this fact article indexing
	*/
	@Override
	public long getItemId() {
		return _factArticleIndexing.getItemId();
	}

	/**
	* Sets the item ID of this fact article indexing.
	*
	* @param itemId the item ID of this fact article indexing
	*/
	@Override
	public void setItemId(long itemId) {
		_factArticleIndexing.setItemId(itemId);
	}

	/**
	* Returns the index total of this fact article indexing.
	*
	* @return the index total of this fact article indexing
	*/
	@Override
	public long getIndexTotal() {
		return _factArticleIndexing.getIndexTotal();
	}

	/**
	* Sets the index total of this fact article indexing.
	*
	* @param indexTotal the index total of this fact article indexing
	*/
	@Override
	public void setIndexTotal(long indexTotal) {
		_factArticleIndexing.setIndexTotal(indexTotal);
	}

	/**
	* Returns the company ID of this fact article indexing.
	*
	* @return the company ID of this fact article indexing
	*/
	@Override
	public long getCompanyId() {
		return _factArticleIndexing.getCompanyId();
	}

	/**
	* Sets the company ID of this fact article indexing.
	*
	* @param companyId the company ID of this fact article indexing
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factArticleIndexing.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact article indexing.
	*
	* @return the group ID of this fact article indexing
	*/
	@Override
	public long getGroupId() {
		return _factArticleIndexing.getGroupId();
	}

	/**
	* Sets the group ID of this fact article indexing.
	*
	* @param groupId the group ID of this fact article indexing
	*/
	@Override
	public void setGroupId(long groupId) {
		_factArticleIndexing.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact article indexing.
	*
	* @return the user ID of this fact article indexing
	*/
	@Override
	public long getUserId() {
		return _factArticleIndexing.getUserId();
	}

	/**
	* Sets the user ID of this fact article indexing.
	*
	* @param userId the user ID of this fact article indexing
	*/
	@Override
	public void setUserId(long userId) {
		_factArticleIndexing.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact article indexing.
	*
	* @return the user uuid of this fact article indexing
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexing.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact article indexing.
	*
	* @param userUuid the user uuid of this fact article indexing
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factArticleIndexing.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact article indexing.
	*
	* @return the user name of this fact article indexing
	*/
	@Override
	public java.lang.String getUserName() {
		return _factArticleIndexing.getUserName();
	}

	/**
	* Sets the user name of this fact article indexing.
	*
	* @param userName the user name of this fact article indexing
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factArticleIndexing.setUserName(userName);
	}

	/**
	* Returns the create date of this fact article indexing.
	*
	* @return the create date of this fact article indexing
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factArticleIndexing.getCreateDate();
	}

	/**
	* Sets the create date of this fact article indexing.
	*
	* @param createDate the create date of this fact article indexing
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factArticleIndexing.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factArticleIndexing.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factArticleIndexing.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factArticleIndexing.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factArticleIndexing.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factArticleIndexing.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factArticleIndexing.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factArticleIndexing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factArticleIndexing.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factArticleIndexing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factArticleIndexing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factArticleIndexing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactArticleIndexingWrapper((FactArticleIndexing)_factArticleIndexing.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing) {
		return _factArticleIndexing.compareTo(factArticleIndexing);
	}

	@Override
	public int hashCode() {
		return _factArticleIndexing.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactArticleIndexing> toCacheModel() {
		return _factArticleIndexing.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactArticleIndexing toEscapedModel() {
		return new FactArticleIndexingWrapper(_factArticleIndexing.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactArticleIndexing toUnescapedModel() {
		return new FactArticleIndexingWrapper(_factArticleIndexing.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factArticleIndexing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factArticleIndexing.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factArticleIndexing.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactArticleIndexingWrapper)) {
			return false;
		}

		FactArticleIndexingWrapper factArticleIndexingWrapper = (FactArticleIndexingWrapper)obj;

		if (Validator.equals(_factArticleIndexing,
					factArticleIndexingWrapper._factArticleIndexing)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactArticleIndexing getWrappedFactArticleIndexing() {
		return _factArticleIndexing;
	}

	@Override
	public FactArticleIndexing getWrappedModel() {
		return _factArticleIndexing;
	}

	@Override
	public void resetOriginalValues() {
		_factArticleIndexing.resetOriginalValues();
	}

	private FactArticleIndexing _factArticleIndexing;
}
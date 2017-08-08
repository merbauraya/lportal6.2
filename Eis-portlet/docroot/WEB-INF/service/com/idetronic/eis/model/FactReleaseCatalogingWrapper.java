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
 * This class is a wrapper for {@link FactReleaseCataloging}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactReleaseCataloging
 * @generated
 */
public class FactReleaseCatalogingWrapper implements FactReleaseCataloging,
	ModelWrapper<FactReleaseCataloging> {
	public FactReleaseCatalogingWrapper(
		FactReleaseCataloging factReleaseCataloging) {
		_factReleaseCataloging = factReleaseCataloging;
	}

	@Override
	public Class<?> getModelClass() {
		return FactReleaseCataloging.class;
	}

	@Override
	public String getModelClassName() {
		return FactReleaseCataloging.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
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

		Long titleTotal = (Long)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Long volumeTotal = (Long)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
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
	* Returns the primary key of this fact release cataloging.
	*
	* @return the primary key of this fact release cataloging
	*/
	@Override
	public long getPrimaryKey() {
		return _factReleaseCataloging.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact release cataloging.
	*
	* @param primaryKey the primary key of this fact release cataloging
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factReleaseCataloging.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact release cataloging.
	*
	* @return the fact ID of this fact release cataloging
	*/
	@Override
	public long getFactId() {
		return _factReleaseCataloging.getFactId();
	}

	/**
	* Sets the fact ID of this fact release cataloging.
	*
	* @param factId the fact ID of this fact release cataloging
	*/
	@Override
	public void setFactId(long factId) {
		_factReleaseCataloging.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact release cataloging.
	*
	* @return the library ID of this fact release cataloging
	*/
	@Override
	public long getLibraryId() {
		return _factReleaseCataloging.getLibraryId();
	}

	/**
	* Sets the library ID of this fact release cataloging.
	*
	* @param libraryId the library ID of this fact release cataloging
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factReleaseCataloging.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact release cataloging.
	*
	* @return the period of this fact release cataloging
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factReleaseCataloging.getPeriod();
	}

	/**
	* Sets the period of this fact release cataloging.
	*
	* @param period the period of this fact release cataloging
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factReleaseCataloging.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact release cataloging.
	*
	* @return the item ID of this fact release cataloging
	*/
	@Override
	public long getItemId() {
		return _factReleaseCataloging.getItemId();
	}

	/**
	* Sets the item ID of this fact release cataloging.
	*
	* @param itemId the item ID of this fact release cataloging
	*/
	@Override
	public void setItemId(long itemId) {
		_factReleaseCataloging.setItemId(itemId);
	}

	/**
	* Returns the title total of this fact release cataloging.
	*
	* @return the title total of this fact release cataloging
	*/
	@Override
	public long getTitleTotal() {
		return _factReleaseCataloging.getTitleTotal();
	}

	/**
	* Sets the title total of this fact release cataloging.
	*
	* @param titleTotal the title total of this fact release cataloging
	*/
	@Override
	public void setTitleTotal(long titleTotal) {
		_factReleaseCataloging.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact release cataloging.
	*
	* @return the volume total of this fact release cataloging
	*/
	@Override
	public long getVolumeTotal() {
		return _factReleaseCataloging.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact release cataloging.
	*
	* @param volumeTotal the volume total of this fact release cataloging
	*/
	@Override
	public void setVolumeTotal(long volumeTotal) {
		_factReleaseCataloging.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the company ID of this fact release cataloging.
	*
	* @return the company ID of this fact release cataloging
	*/
	@Override
	public long getCompanyId() {
		return _factReleaseCataloging.getCompanyId();
	}

	/**
	* Sets the company ID of this fact release cataloging.
	*
	* @param companyId the company ID of this fact release cataloging
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factReleaseCataloging.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact release cataloging.
	*
	* @return the group ID of this fact release cataloging
	*/
	@Override
	public long getGroupId() {
		return _factReleaseCataloging.getGroupId();
	}

	/**
	* Sets the group ID of this fact release cataloging.
	*
	* @param groupId the group ID of this fact release cataloging
	*/
	@Override
	public void setGroupId(long groupId) {
		_factReleaseCataloging.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact release cataloging.
	*
	* @return the user ID of this fact release cataloging
	*/
	@Override
	public long getUserId() {
		return _factReleaseCataloging.getUserId();
	}

	/**
	* Sets the user ID of this fact release cataloging.
	*
	* @param userId the user ID of this fact release cataloging
	*/
	@Override
	public void setUserId(long userId) {
		_factReleaseCataloging.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact release cataloging.
	*
	* @return the user uuid of this fact release cataloging
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factReleaseCataloging.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact release cataloging.
	*
	* @param userUuid the user uuid of this fact release cataloging
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factReleaseCataloging.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact release cataloging.
	*
	* @return the user name of this fact release cataloging
	*/
	@Override
	public java.lang.String getUserName() {
		return _factReleaseCataloging.getUserName();
	}

	/**
	* Sets the user name of this fact release cataloging.
	*
	* @param userName the user name of this fact release cataloging
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factReleaseCataloging.setUserName(userName);
	}

	/**
	* Returns the create date of this fact release cataloging.
	*
	* @return the create date of this fact release cataloging
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factReleaseCataloging.getCreateDate();
	}

	/**
	* Sets the create date of this fact release cataloging.
	*
	* @param createDate the create date of this fact release cataloging
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factReleaseCataloging.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factReleaseCataloging.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factReleaseCataloging.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factReleaseCataloging.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factReleaseCataloging.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factReleaseCataloging.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factReleaseCataloging.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factReleaseCataloging.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factReleaseCataloging.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factReleaseCataloging.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factReleaseCataloging.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factReleaseCataloging.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactReleaseCatalogingWrapper((FactReleaseCataloging)_factReleaseCataloging.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactReleaseCataloging factReleaseCataloging) {
		return _factReleaseCataloging.compareTo(factReleaseCataloging);
	}

	@Override
	public int hashCode() {
		return _factReleaseCataloging.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactReleaseCataloging> toCacheModel() {
		return _factReleaseCataloging.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactReleaseCataloging toEscapedModel() {
		return new FactReleaseCatalogingWrapper(_factReleaseCataloging.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactReleaseCataloging toUnescapedModel() {
		return new FactReleaseCatalogingWrapper(_factReleaseCataloging.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factReleaseCataloging.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factReleaseCataloging.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factReleaseCataloging.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactReleaseCatalogingWrapper)) {
			return false;
		}

		FactReleaseCatalogingWrapper factReleaseCatalogingWrapper = (FactReleaseCatalogingWrapper)obj;

		if (Validator.equals(_factReleaseCataloging,
					factReleaseCatalogingWrapper._factReleaseCataloging)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactReleaseCataloging getWrappedFactReleaseCataloging() {
		return _factReleaseCataloging;
	}

	@Override
	public FactReleaseCataloging getWrappedModel() {
		return _factReleaseCataloging;
	}

	@Override
	public void resetOriginalValues() {
		_factReleaseCataloging.resetOriginalValues();
	}

	private FactReleaseCataloging _factReleaseCataloging;
}
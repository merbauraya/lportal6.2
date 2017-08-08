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
 * This class is a wrapper for {@link FactDigitalCollection}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDigitalCollection
 * @generated
 */
public class FactDigitalCollectionWrapper implements FactDigitalCollection,
	ModelWrapper<FactDigitalCollection> {
	public FactDigitalCollectionWrapper(
		FactDigitalCollection factDigitalCollection) {
		_factDigitalCollection = factDigitalCollection;
	}

	@Override
	public Class<?> getModelClass() {
		return FactDigitalCollection.class;
	}

	@Override
	public String getModelClassName() {
		return FactDigitalCollection.class.getName();
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
		attributes.put("imageTotal", getImageTotal());
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

		Long imageTotal = (Long)attributes.get("imageTotal");

		if (imageTotal != null) {
			setImageTotal(imageTotal);
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
	* Returns the primary key of this fact digital collection.
	*
	* @return the primary key of this fact digital collection
	*/
	@Override
	public long getPrimaryKey() {
		return _factDigitalCollection.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact digital collection.
	*
	* @param primaryKey the primary key of this fact digital collection
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factDigitalCollection.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact digital collection.
	*
	* @return the fact ID of this fact digital collection
	*/
	@Override
	public long getFactId() {
		return _factDigitalCollection.getFactId();
	}

	/**
	* Sets the fact ID of this fact digital collection.
	*
	* @param factId the fact ID of this fact digital collection
	*/
	@Override
	public void setFactId(long factId) {
		_factDigitalCollection.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact digital collection.
	*
	* @return the library ID of this fact digital collection
	*/
	@Override
	public long getLibraryId() {
		return _factDigitalCollection.getLibraryId();
	}

	/**
	* Sets the library ID of this fact digital collection.
	*
	* @param libraryId the library ID of this fact digital collection
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factDigitalCollection.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact digital collection.
	*
	* @return the period of this fact digital collection
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factDigitalCollection.getPeriod();
	}

	/**
	* Sets the period of this fact digital collection.
	*
	* @param period the period of this fact digital collection
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factDigitalCollection.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact digital collection.
	*
	* @return the item ID of this fact digital collection
	*/
	@Override
	public long getItemId() {
		return _factDigitalCollection.getItemId();
	}

	/**
	* Sets the item ID of this fact digital collection.
	*
	* @param itemId the item ID of this fact digital collection
	*/
	@Override
	public void setItemId(long itemId) {
		_factDigitalCollection.setItemId(itemId);
	}

	/**
	* Returns the title total of this fact digital collection.
	*
	* @return the title total of this fact digital collection
	*/
	@Override
	public long getTitleTotal() {
		return _factDigitalCollection.getTitleTotal();
	}

	/**
	* Sets the title total of this fact digital collection.
	*
	* @param titleTotal the title total of this fact digital collection
	*/
	@Override
	public void setTitleTotal(long titleTotal) {
		_factDigitalCollection.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact digital collection.
	*
	* @return the volume total of this fact digital collection
	*/
	@Override
	public long getVolumeTotal() {
		return _factDigitalCollection.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact digital collection.
	*
	* @param volumeTotal the volume total of this fact digital collection
	*/
	@Override
	public void setVolumeTotal(long volumeTotal) {
		_factDigitalCollection.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the image total of this fact digital collection.
	*
	* @return the image total of this fact digital collection
	*/
	@Override
	public long getImageTotal() {
		return _factDigitalCollection.getImageTotal();
	}

	/**
	* Sets the image total of this fact digital collection.
	*
	* @param imageTotal the image total of this fact digital collection
	*/
	@Override
	public void setImageTotal(long imageTotal) {
		_factDigitalCollection.setImageTotal(imageTotal);
	}

	/**
	* Returns the company ID of this fact digital collection.
	*
	* @return the company ID of this fact digital collection
	*/
	@Override
	public long getCompanyId() {
		return _factDigitalCollection.getCompanyId();
	}

	/**
	* Sets the company ID of this fact digital collection.
	*
	* @param companyId the company ID of this fact digital collection
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factDigitalCollection.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact digital collection.
	*
	* @return the group ID of this fact digital collection
	*/
	@Override
	public long getGroupId() {
		return _factDigitalCollection.getGroupId();
	}

	/**
	* Sets the group ID of this fact digital collection.
	*
	* @param groupId the group ID of this fact digital collection
	*/
	@Override
	public void setGroupId(long groupId) {
		_factDigitalCollection.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact digital collection.
	*
	* @return the user ID of this fact digital collection
	*/
	@Override
	public long getUserId() {
		return _factDigitalCollection.getUserId();
	}

	/**
	* Sets the user ID of this fact digital collection.
	*
	* @param userId the user ID of this fact digital collection
	*/
	@Override
	public void setUserId(long userId) {
		_factDigitalCollection.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact digital collection.
	*
	* @return the user uuid of this fact digital collection
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDigitalCollection.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact digital collection.
	*
	* @param userUuid the user uuid of this fact digital collection
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factDigitalCollection.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact digital collection.
	*
	* @return the user name of this fact digital collection
	*/
	@Override
	public java.lang.String getUserName() {
		return _factDigitalCollection.getUserName();
	}

	/**
	* Sets the user name of this fact digital collection.
	*
	* @param userName the user name of this fact digital collection
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factDigitalCollection.setUserName(userName);
	}

	/**
	* Returns the create date of this fact digital collection.
	*
	* @return the create date of this fact digital collection
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factDigitalCollection.getCreateDate();
	}

	/**
	* Sets the create date of this fact digital collection.
	*
	* @param createDate the create date of this fact digital collection
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factDigitalCollection.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factDigitalCollection.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factDigitalCollection.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factDigitalCollection.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factDigitalCollection.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factDigitalCollection.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factDigitalCollection.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factDigitalCollection.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factDigitalCollection.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factDigitalCollection.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factDigitalCollection.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factDigitalCollection.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactDigitalCollectionWrapper((FactDigitalCollection)_factDigitalCollection.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactDigitalCollection factDigitalCollection) {
		return _factDigitalCollection.compareTo(factDigitalCollection);
	}

	@Override
	public int hashCode() {
		return _factDigitalCollection.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactDigitalCollection> toCacheModel() {
		return _factDigitalCollection.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactDigitalCollection toEscapedModel() {
		return new FactDigitalCollectionWrapper(_factDigitalCollection.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactDigitalCollection toUnescapedModel() {
		return new FactDigitalCollectionWrapper(_factDigitalCollection.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factDigitalCollection.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factDigitalCollection.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factDigitalCollection.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactDigitalCollectionWrapper)) {
			return false;
		}

		FactDigitalCollectionWrapper factDigitalCollectionWrapper = (FactDigitalCollectionWrapper)obj;

		if (Validator.equals(_factDigitalCollection,
					factDigitalCollectionWrapper._factDigitalCollection)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactDigitalCollection getWrappedFactDigitalCollection() {
		return _factDigitalCollection;
	}

	@Override
	public FactDigitalCollection getWrappedModel() {
		return _factDigitalCollection;
	}

	@Override
	public void resetOriginalValues() {
		_factDigitalCollection.resetOriginalValues();
	}

	private FactDigitalCollection _factDigitalCollection;
}
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
 * This class is a wrapper for {@link FactIrItem}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrItem
 * @generated
 */
public class FactIrItemWrapper implements FactIrItem, ModelWrapper<FactIrItem> {
	public FactIrItemWrapper(FactIrItem factIrItem) {
		_factIrItem = factIrItem;
	}

	@Override
	public Class<?> getModelClass() {
		return FactIrItem.class;
	}

	@Override
	public String getModelClassName() {
		return FactIrItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factIrItemId", getFactIrItemId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("period", getPeriod());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("itemMediumId", getItemMediumId());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factIrItemId = (Long)attributes.get("factIrItemId");

		if (factIrItemId != null) {
			setFactIrItemId(factIrItemId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Long itemMediumId = (Long)attributes.get("itemMediumId");

		if (itemMediumId != null) {
			setItemMediumId(itemMediumId);
		}

		Integer titleTotal = (Integer)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Integer volumeTotal = (Integer)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}

		String createdByUserName = (String)attributes.get("createdByUserName");

		if (createdByUserName != null) {
			setCreatedByUserName(createdByUserName);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this fact ir item.
	*
	* @return the primary key of this fact ir item
	*/
	@Override
	public long getPrimaryKey() {
		return _factIrItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact ir item.
	*
	* @param primaryKey the primary key of this fact ir item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factIrItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ir item ID of this fact ir item.
	*
	* @return the fact ir item ID of this fact ir item
	*/
	@Override
	public long getFactIrItemId() {
		return _factIrItem.getFactIrItemId();
	}

	/**
	* Sets the fact ir item ID of this fact ir item.
	*
	* @param factIrItemId the fact ir item ID of this fact ir item
	*/
	@Override
	public void setFactIrItemId(long factIrItemId) {
		_factIrItem.setFactIrItemId(factIrItemId);
	}

	/**
	* Returns the library ID of this fact ir item.
	*
	* @return the library ID of this fact ir item
	*/
	@Override
	public long getLibraryId() {
		return _factIrItem.getLibraryId();
	}

	/**
	* Sets the library ID of this fact ir item.
	*
	* @param libraryId the library ID of this fact ir item
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factIrItem.setLibraryId(libraryId);
	}

	/**
	* Returns the faculty ID of this fact ir item.
	*
	* @return the faculty ID of this fact ir item
	*/
	@Override
	public long getFacultyId() {
		return _factIrItem.getFacultyId();
	}

	/**
	* Sets the faculty ID of this fact ir item.
	*
	* @param facultyId the faculty ID of this fact ir item
	*/
	@Override
	public void setFacultyId(long facultyId) {
		_factIrItem.setFacultyId(facultyId);
	}

	/**
	* Returns the period of this fact ir item.
	*
	* @return the period of this fact ir item
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factIrItem.getPeriod();
	}

	/**
	* Sets the period of this fact ir item.
	*
	* @param period the period of this fact ir item
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factIrItem.setPeriod(period);
	}

	/**
	* Returns the item type ID of this fact ir item.
	*
	* @return the item type ID of this fact ir item
	*/
	@Override
	public long getItemTypeId() {
		return _factIrItem.getItemTypeId();
	}

	/**
	* Sets the item type ID of this fact ir item.
	*
	* @param itemTypeId the item type ID of this fact ir item
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_factIrItem.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the item medium ID of this fact ir item.
	*
	* @return the item medium ID of this fact ir item
	*/
	@Override
	public long getItemMediumId() {
		return _factIrItem.getItemMediumId();
	}

	/**
	* Sets the item medium ID of this fact ir item.
	*
	* @param itemMediumId the item medium ID of this fact ir item
	*/
	@Override
	public void setItemMediumId(long itemMediumId) {
		_factIrItem.setItemMediumId(itemMediumId);
	}

	/**
	* Returns the title total of this fact ir item.
	*
	* @return the title total of this fact ir item
	*/
	@Override
	public int getTitleTotal() {
		return _factIrItem.getTitleTotal();
	}

	/**
	* Sets the title total of this fact ir item.
	*
	* @param titleTotal the title total of this fact ir item
	*/
	@Override
	public void setTitleTotal(int titleTotal) {
		_factIrItem.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact ir item.
	*
	* @return the volume total of this fact ir item
	*/
	@Override
	public int getVolumeTotal() {
		return _factIrItem.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact ir item.
	*
	* @param volumeTotal the volume total of this fact ir item
	*/
	@Override
	public void setVolumeTotal(int volumeTotal) {
		_factIrItem.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the created by user ID of this fact ir item.
	*
	* @return the created by user ID of this fact ir item
	*/
	@Override
	public long getCreatedByUserId() {
		return _factIrItem.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this fact ir item.
	*
	* @param createdByUserId the created by user ID of this fact ir item
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_factIrItem.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this fact ir item.
	*
	* @return the created by user uuid of this fact ir item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItem.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this fact ir item.
	*
	* @param createdByUserUuid the created by user uuid of this fact ir item
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_factIrItem.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the created by user name of this fact ir item.
	*
	* @return the created by user name of this fact ir item
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _factIrItem.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this fact ir item.
	*
	* @param createdByUserName the created by user name of this fact ir item
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_factIrItem.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the created date of this fact ir item.
	*
	* @return the created date of this fact ir item
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _factIrItem.getCreatedDate();
	}

	/**
	* Sets the created date of this fact ir item.
	*
	* @param createdDate the created date of this fact ir item
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_factIrItem.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _factIrItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factIrItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factIrItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factIrItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factIrItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factIrItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factIrItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factIrItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factIrItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factIrItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factIrItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactIrItemWrapper((FactIrItem)_factIrItem.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactIrItem factIrItem) {
		return _factIrItem.compareTo(factIrItem);
	}

	@Override
	public int hashCode() {
		return _factIrItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactIrItem> toCacheModel() {
		return _factIrItem.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactIrItem toEscapedModel() {
		return new FactIrItemWrapper(_factIrItem.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactIrItem toUnescapedModel() {
		return new FactIrItemWrapper(_factIrItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factIrItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factIrItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factIrItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactIrItemWrapper)) {
			return false;
		}

		FactIrItemWrapper factIrItemWrapper = (FactIrItemWrapper)obj;

		if (Validator.equals(_factIrItem, factIrItemWrapper._factIrItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactIrItem getWrappedFactIrItem() {
		return _factIrItem;
	}

	@Override
	public FactIrItem getWrappedModel() {
		return _factIrItem;
	}

	@Override
	public void resetOriginalValues() {
		_factIrItem.resetOriginalValues();
	}

	private FactIrItem _factIrItem;
}
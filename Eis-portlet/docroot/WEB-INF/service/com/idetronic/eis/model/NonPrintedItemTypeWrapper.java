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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NonPrintedItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see NonPrintedItemType
 * @generated
 */
public class NonPrintedItemTypeWrapper implements NonPrintedItemType,
	ModelWrapper<NonPrintedItemType> {
	public NonPrintedItemTypeWrapper(NonPrintedItemType nonPrintedItemType) {
		_nonPrintedItemType = nonPrintedItemType;
	}

	@Override
	public Class<?> getModelClass() {
		return NonPrintedItemType.class;
	}

	@Override
	public String getModelClassName() {
		return NonPrintedItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("itemTypeName", getItemTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String itemTypeName = (String)attributes.get("itemTypeName");

		if (itemTypeName != null) {
			setItemTypeName(itemTypeName);
		}
	}

	/**
	* Returns the primary key of this non printed item type.
	*
	* @return the primary key of this non printed item type
	*/
	@Override
	public long getPrimaryKey() {
		return _nonPrintedItemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this non printed item type.
	*
	* @param primaryKey the primary key of this non printed item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nonPrintedItemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item type ID of this non printed item type.
	*
	* @return the item type ID of this non printed item type
	*/
	@Override
	public long getItemTypeId() {
		return _nonPrintedItemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this non printed item type.
	*
	* @param itemTypeId the item type ID of this non printed item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_nonPrintedItemType.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the item type name of this non printed item type.
	*
	* @return the item type name of this non printed item type
	*/
	@Override
	public java.lang.String getItemTypeName() {
		return _nonPrintedItemType.getItemTypeName();
	}

	/**
	* Sets the item type name of this non printed item type.
	*
	* @param itemTypeName the item type name of this non printed item type
	*/
	@Override
	public void setItemTypeName(java.lang.String itemTypeName) {
		_nonPrintedItemType.setItemTypeName(itemTypeName);
	}

	@Override
	public boolean isNew() {
		return _nonPrintedItemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_nonPrintedItemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _nonPrintedItemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nonPrintedItemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _nonPrintedItemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _nonPrintedItemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nonPrintedItemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nonPrintedItemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_nonPrintedItemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_nonPrintedItemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nonPrintedItemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NonPrintedItemTypeWrapper((NonPrintedItemType)_nonPrintedItemType.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.NonPrintedItemType nonPrintedItemType) {
		return _nonPrintedItemType.compareTo(nonPrintedItemType);
	}

	@Override
	public int hashCode() {
		return _nonPrintedItemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.NonPrintedItemType> toCacheModel() {
		return _nonPrintedItemType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.NonPrintedItemType toEscapedModel() {
		return new NonPrintedItemTypeWrapper(_nonPrintedItemType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.NonPrintedItemType toUnescapedModel() {
		return new NonPrintedItemTypeWrapper(_nonPrintedItemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nonPrintedItemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _nonPrintedItemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nonPrintedItemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NonPrintedItemTypeWrapper)) {
			return false;
		}

		NonPrintedItemTypeWrapper nonPrintedItemTypeWrapper = (NonPrintedItemTypeWrapper)obj;

		if (Validator.equals(_nonPrintedItemType,
					nonPrintedItemTypeWrapper._nonPrintedItemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NonPrintedItemType getWrappedNonPrintedItemType() {
		return _nonPrintedItemType;
	}

	@Override
	public NonPrintedItemType getWrappedModel() {
		return _nonPrintedItemType;
	}

	@Override
	public void resetOriginalValues() {
		_nonPrintedItemType.resetOriginalValues();
	}

	private NonPrintedItemType _nonPrintedItemType;
}
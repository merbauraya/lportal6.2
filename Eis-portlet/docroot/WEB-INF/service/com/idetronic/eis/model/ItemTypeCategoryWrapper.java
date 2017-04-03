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
 * This class is a wrapper for {@link ItemTypeCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeCategory
 * @generated
 */
public class ItemTypeCategoryWrapper implements ItemTypeCategory,
	ModelWrapper<ItemTypeCategory> {
	public ItemTypeCategoryWrapper(ItemTypeCategory itemTypeCategory) {
		_itemTypeCategory = itemTypeCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemTypeCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ItemTypeCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemTypeCategoryId", getItemTypeCategoryId());
		attributes.put("itemTypeCategoryName", getItemTypeCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemTypeCategoryId = (Long)attributes.get("itemTypeCategoryId");

		if (itemTypeCategoryId != null) {
			setItemTypeCategoryId(itemTypeCategoryId);
		}

		String itemTypeCategoryName = (String)attributes.get(
				"itemTypeCategoryName");

		if (itemTypeCategoryName != null) {
			setItemTypeCategoryName(itemTypeCategoryName);
		}
	}

	/**
	* Returns the primary key of this item type category.
	*
	* @return the primary key of this item type category
	*/
	@Override
	public long getPrimaryKey() {
		return _itemTypeCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item type category.
	*
	* @param primaryKey the primary key of this item type category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemTypeCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item type category ID of this item type category.
	*
	* @return the item type category ID of this item type category
	*/
	@Override
	public long getItemTypeCategoryId() {
		return _itemTypeCategory.getItemTypeCategoryId();
	}

	/**
	* Sets the item type category ID of this item type category.
	*
	* @param itemTypeCategoryId the item type category ID of this item type category
	*/
	@Override
	public void setItemTypeCategoryId(long itemTypeCategoryId) {
		_itemTypeCategory.setItemTypeCategoryId(itemTypeCategoryId);
	}

	/**
	* Returns the item type category name of this item type category.
	*
	* @return the item type category name of this item type category
	*/
	@Override
	public java.lang.String getItemTypeCategoryName() {
		return _itemTypeCategory.getItemTypeCategoryName();
	}

	/**
	* Sets the item type category name of this item type category.
	*
	* @param itemTypeCategoryName the item type category name of this item type category
	*/
	@Override
	public void setItemTypeCategoryName(java.lang.String itemTypeCategoryName) {
		_itemTypeCategory.setItemTypeCategoryName(itemTypeCategoryName);
	}

	@Override
	public boolean isNew() {
		return _itemTypeCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemTypeCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemTypeCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemTypeCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemTypeCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemTypeCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemTypeCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemTypeCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemTypeCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemTypeCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemTypeCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemTypeCategoryWrapper((ItemTypeCategory)_itemTypeCategory.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.ItemTypeCategory itemTypeCategory) {
		return _itemTypeCategory.compareTo(itemTypeCategory);
	}

	@Override
	public int hashCode() {
		return _itemTypeCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.ItemTypeCategory> toCacheModel() {
		return _itemTypeCategory.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.ItemTypeCategory toEscapedModel() {
		return new ItemTypeCategoryWrapper(_itemTypeCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.ItemTypeCategory toUnescapedModel() {
		return new ItemTypeCategoryWrapper(_itemTypeCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemTypeCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemTypeCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemTypeCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemTypeCategoryWrapper)) {
			return false;
		}

		ItemTypeCategoryWrapper itemTypeCategoryWrapper = (ItemTypeCategoryWrapper)obj;

		if (Validator.equals(_itemTypeCategory,
					itemTypeCategoryWrapper._itemTypeCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemTypeCategory getWrappedItemTypeCategory() {
		return _itemTypeCategory;
	}

	@Override
	public ItemTypeCategory getWrappedModel() {
		return _itemTypeCategory;
	}

	@Override
	public void resetOriginalValues() {
		_itemTypeCategory.resetOriginalValues();
	}

	private ItemTypeCategory _itemTypeCategory;
}
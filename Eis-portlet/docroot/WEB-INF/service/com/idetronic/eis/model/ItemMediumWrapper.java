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
 * This class is a wrapper for {@link ItemMedium}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemMedium
 * @generated
 */
public class ItemMediumWrapper implements ItemMedium, ModelWrapper<ItemMedium> {
	public ItemMediumWrapper(ItemMedium itemMedium) {
		_itemMedium = itemMedium;
	}

	@Override
	public Class<?> getModelClass() {
		return ItemMedium.class;
	}

	@Override
	public String getModelClassName() {
		return ItemMedium.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemMediumId", getItemMediumId());
		attributes.put("itemMediumName", getItemMediumName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemMediumId = (Long)attributes.get("itemMediumId");

		if (itemMediumId != null) {
			setItemMediumId(itemMediumId);
		}

		String itemMediumName = (String)attributes.get("itemMediumName");

		if (itemMediumName != null) {
			setItemMediumName(itemMediumName);
		}
	}

	/**
	* Returns the primary key of this item medium.
	*
	* @return the primary key of this item medium
	*/
	@Override
	public long getPrimaryKey() {
		return _itemMedium.getPrimaryKey();
	}

	/**
	* Sets the primary key of this item medium.
	*
	* @param primaryKey the primary key of this item medium
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemMedium.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item medium ID of this item medium.
	*
	* @return the item medium ID of this item medium
	*/
	@Override
	public long getItemMediumId() {
		return _itemMedium.getItemMediumId();
	}

	/**
	* Sets the item medium ID of this item medium.
	*
	* @param itemMediumId the item medium ID of this item medium
	*/
	@Override
	public void setItemMediumId(long itemMediumId) {
		_itemMedium.setItemMediumId(itemMediumId);
	}

	/**
	* Returns the item medium name of this item medium.
	*
	* @return the item medium name of this item medium
	*/
	@Override
	public java.lang.String getItemMediumName() {
		return _itemMedium.getItemMediumName();
	}

	/**
	* Sets the item medium name of this item medium.
	*
	* @param itemMediumName the item medium name of this item medium
	*/
	@Override
	public void setItemMediumName(java.lang.String itemMediumName) {
		_itemMedium.setItemMediumName(itemMediumName);
	}

	@Override
	public boolean isNew() {
		return _itemMedium.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_itemMedium.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _itemMedium.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemMedium.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _itemMedium.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _itemMedium.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_itemMedium.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _itemMedium.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_itemMedium.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_itemMedium.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_itemMedium.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ItemMediumWrapper((ItemMedium)_itemMedium.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.ItemMedium itemMedium) {
		return _itemMedium.compareTo(itemMedium);
	}

	@Override
	public int hashCode() {
		return _itemMedium.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.ItemMedium> toCacheModel() {
		return _itemMedium.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.ItemMedium toEscapedModel() {
		return new ItemMediumWrapper(_itemMedium.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.ItemMedium toUnescapedModel() {
		return new ItemMediumWrapper(_itemMedium.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _itemMedium.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemMedium.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemMedium.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemMediumWrapper)) {
			return false;
		}

		ItemMediumWrapper itemMediumWrapper = (ItemMediumWrapper)obj;

		if (Validator.equals(_itemMedium, itemMediumWrapper._itemMedium)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ItemMedium getWrappedItemMedium() {
		return _itemMedium;
	}

	@Override
	public ItemMedium getWrappedModel() {
		return _itemMedium;
	}

	@Override
	public void resetOriginalValues() {
		_itemMedium.resetOriginalValues();
	}

	private ItemMedium _itemMedium;
}
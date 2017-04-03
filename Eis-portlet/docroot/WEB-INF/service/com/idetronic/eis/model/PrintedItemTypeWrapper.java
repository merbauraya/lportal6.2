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
 * This class is a wrapper for {@link PrintedItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PrintedItemType
 * @generated
 */
public class PrintedItemTypeWrapper implements PrintedItemType,
	ModelWrapper<PrintedItemType> {
	public PrintedItemTypeWrapper(PrintedItemType printedItemType) {
		_printedItemType = printedItemType;
	}

	@Override
	public Class<?> getModelClass() {
		return PrintedItemType.class;
	}

	@Override
	public String getModelClassName() {
		return PrintedItemType.class.getName();
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
	* Returns the primary key of this printed item type.
	*
	* @return the primary key of this printed item type
	*/
	@Override
	public long getPrimaryKey() {
		return _printedItemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this printed item type.
	*
	* @param primaryKey the primary key of this printed item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_printedItemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item type ID of this printed item type.
	*
	* @return the item type ID of this printed item type
	*/
	@Override
	public long getItemTypeId() {
		return _printedItemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this printed item type.
	*
	* @param itemTypeId the item type ID of this printed item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_printedItemType.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the item type name of this printed item type.
	*
	* @return the item type name of this printed item type
	*/
	@Override
	public java.lang.String getItemTypeName() {
		return _printedItemType.getItemTypeName();
	}

	/**
	* Sets the item type name of this printed item type.
	*
	* @param itemTypeName the item type name of this printed item type
	*/
	@Override
	public void setItemTypeName(java.lang.String itemTypeName) {
		_printedItemType.setItemTypeName(itemTypeName);
	}

	@Override
	public boolean isNew() {
		return _printedItemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_printedItemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _printedItemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_printedItemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _printedItemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _printedItemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_printedItemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _printedItemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_printedItemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_printedItemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_printedItemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PrintedItemTypeWrapper((PrintedItemType)_printedItemType.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.PrintedItemType printedItemType) {
		return _printedItemType.compareTo(printedItemType);
	}

	@Override
	public int hashCode() {
		return _printedItemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.PrintedItemType> toCacheModel() {
		return _printedItemType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.PrintedItemType toEscapedModel() {
		return new PrintedItemTypeWrapper(_printedItemType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.PrintedItemType toUnescapedModel() {
		return new PrintedItemTypeWrapper(_printedItemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _printedItemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _printedItemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_printedItemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PrintedItemTypeWrapper)) {
			return false;
		}

		PrintedItemTypeWrapper printedItemTypeWrapper = (PrintedItemTypeWrapper)obj;

		if (Validator.equals(_printedItemType,
					printedItemTypeWrapper._printedItemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PrintedItemType getWrappedPrintedItemType() {
		return _printedItemType;
	}

	@Override
	public PrintedItemType getWrappedModel() {
		return _printedItemType;
	}

	@Override
	public void resetOriginalValues() {
		_printedItemType.resetOriginalValues();
	}

	private PrintedItemType _printedItemType;
}
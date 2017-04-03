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
 * This class is a wrapper for {@link libraryType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see libraryType
 * @generated
 */
public class libraryTypeWrapper implements libraryType,
	ModelWrapper<libraryType> {
	public libraryTypeWrapper(libraryType libraryType) {
		_libraryType = libraryType;
	}

	@Override
	public Class<?> getModelClass() {
		return libraryType.class;
	}

	@Override
	public String getModelClassName() {
		return libraryType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("libraryTypeName", getLibraryTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String libraryTypeName = (String)attributes.get("libraryTypeName");

		if (libraryTypeName != null) {
			setLibraryTypeName(libraryTypeName);
		}
	}

	/**
	* Returns the primary key of this library type.
	*
	* @return the primary key of this library type
	*/
	@Override
	public long getPrimaryKey() {
		return _libraryType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this library type.
	*
	* @param primaryKey the primary key of this library type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_libraryType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the library type ID of this library type.
	*
	* @return the library type ID of this library type
	*/
	@Override
	public long getLibraryTypeId() {
		return _libraryType.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this library type.
	*
	* @param libraryTypeId the library type ID of this library type
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_libraryType.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the library type name of this library type.
	*
	* @return the library type name of this library type
	*/
	@Override
	public java.lang.String getLibraryTypeName() {
		return _libraryType.getLibraryTypeName();
	}

	/**
	* Sets the library type name of this library type.
	*
	* @param libraryTypeName the library type name of this library type
	*/
	@Override
	public void setLibraryTypeName(java.lang.String libraryTypeName) {
		_libraryType.setLibraryTypeName(libraryTypeName);
	}

	@Override
	public boolean isNew() {
		return _libraryType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_libraryType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _libraryType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_libraryType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _libraryType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _libraryType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_libraryType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _libraryType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_libraryType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_libraryType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_libraryType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new libraryTypeWrapper((libraryType)_libraryType.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.libraryType libraryType) {
		return _libraryType.compareTo(libraryType);
	}

	@Override
	public int hashCode() {
		return _libraryType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.libraryType> toCacheModel() {
		return _libraryType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.libraryType toEscapedModel() {
		return new libraryTypeWrapper(_libraryType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.libraryType toUnescapedModel() {
		return new libraryTypeWrapper(_libraryType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _libraryType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _libraryType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_libraryType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof libraryTypeWrapper)) {
			return false;
		}

		libraryTypeWrapper libraryTypeWrapper = (libraryTypeWrapper)obj;

		if (Validator.equals(_libraryType, libraryTypeWrapper._libraryType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public libraryType getWrappedlibraryType() {
		return _libraryType;
	}

	@Override
	public libraryType getWrappedModel() {
		return _libraryType;
	}

	@Override
	public void resetOriginalValues() {
		_libraryType.resetOriginalValues();
	}

	private libraryType _libraryType;
}
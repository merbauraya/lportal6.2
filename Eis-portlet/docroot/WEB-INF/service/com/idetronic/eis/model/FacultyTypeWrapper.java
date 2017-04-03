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
 * This class is a wrapper for {@link FacultyType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FacultyType
 * @generated
 */
public class FacultyTypeWrapper implements FacultyType,
	ModelWrapper<FacultyType> {
	public FacultyTypeWrapper(FacultyType facultyType) {
		_facultyType = facultyType;
	}

	@Override
	public Class<?> getModelClass() {
		return FacultyType.class;
	}

	@Override
	public String getModelClassName() {
		return FacultyType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facultyTypeId", getFacultyTypeId());
		attributes.put("facultyTypeName", getFacultyTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facultyTypeId = (Long)attributes.get("facultyTypeId");

		if (facultyTypeId != null) {
			setFacultyTypeId(facultyTypeId);
		}

		String facultyTypeName = (String)attributes.get("facultyTypeName");

		if (facultyTypeName != null) {
			setFacultyTypeName(facultyTypeName);
		}
	}

	/**
	* Returns the primary key of this faculty type.
	*
	* @return the primary key of this faculty type
	*/
	@Override
	public long getPrimaryKey() {
		return _facultyType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this faculty type.
	*
	* @param primaryKey the primary key of this faculty type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_facultyType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the faculty type ID of this faculty type.
	*
	* @return the faculty type ID of this faculty type
	*/
	@Override
	public long getFacultyTypeId() {
		return _facultyType.getFacultyTypeId();
	}

	/**
	* Sets the faculty type ID of this faculty type.
	*
	* @param facultyTypeId the faculty type ID of this faculty type
	*/
	@Override
	public void setFacultyTypeId(long facultyTypeId) {
		_facultyType.setFacultyTypeId(facultyTypeId);
	}

	/**
	* Returns the faculty type name of this faculty type.
	*
	* @return the faculty type name of this faculty type
	*/
	@Override
	public java.lang.String getFacultyTypeName() {
		return _facultyType.getFacultyTypeName();
	}

	/**
	* Sets the faculty type name of this faculty type.
	*
	* @param facultyTypeName the faculty type name of this faculty type
	*/
	@Override
	public void setFacultyTypeName(java.lang.String facultyTypeName) {
		_facultyType.setFacultyTypeName(facultyTypeName);
	}

	@Override
	public boolean isNew() {
		return _facultyType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_facultyType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _facultyType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_facultyType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _facultyType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _facultyType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_facultyType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _facultyType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_facultyType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_facultyType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_facultyType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FacultyTypeWrapper((FacultyType)_facultyType.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FacultyType facultyType) {
		return _facultyType.compareTo(facultyType);
	}

	@Override
	public int hashCode() {
		return _facultyType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FacultyType> toCacheModel() {
		return _facultyType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FacultyType toEscapedModel() {
		return new FacultyTypeWrapper(_facultyType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FacultyType toUnescapedModel() {
		return new FacultyTypeWrapper(_facultyType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _facultyType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _facultyType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_facultyType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacultyTypeWrapper)) {
			return false;
		}

		FacultyTypeWrapper facultyTypeWrapper = (FacultyTypeWrapper)obj;

		if (Validator.equals(_facultyType, facultyTypeWrapper._facultyType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FacultyType getWrappedFacultyType() {
		return _facultyType;
	}

	@Override
	public FacultyType getWrappedModel() {
		return _facultyType;
	}

	@Override
	public void resetOriginalValues() {
		_facultyType.resetOriginalValues();
	}

	private FacultyType _facultyType;
}
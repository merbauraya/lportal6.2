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
 * This class is a wrapper for {@link Faculty}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Faculty
 * @generated
 */
public class FacultyWrapper implements Faculty, ModelWrapper<Faculty> {
	public FacultyWrapper(Faculty faculty) {
		_faculty = faculty;
	}

	@Override
	public Class<?> getModelClass() {
		return Faculty.class;
	}

	@Override
	public String getModelClassName() {
		return Faculty.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facultyId", getFacultyId());
		attributes.put("facultyTypeId", getFacultyTypeId());
		attributes.put("facultyName", getFacultyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		Long facultyTypeId = (Long)attributes.get("facultyTypeId");

		if (facultyTypeId != null) {
			setFacultyTypeId(facultyTypeId);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}
	}

	/**
	* Returns the primary key of this faculty.
	*
	* @return the primary key of this faculty
	*/
	@Override
	public long getPrimaryKey() {
		return _faculty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this faculty.
	*
	* @param primaryKey the primary key of this faculty
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_faculty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the faculty ID of this faculty.
	*
	* @return the faculty ID of this faculty
	*/
	@Override
	public long getFacultyId() {
		return _faculty.getFacultyId();
	}

	/**
	* Sets the faculty ID of this faculty.
	*
	* @param facultyId the faculty ID of this faculty
	*/
	@Override
	public void setFacultyId(long facultyId) {
		_faculty.setFacultyId(facultyId);
	}

	/**
	* Returns the faculty type ID of this faculty.
	*
	* @return the faculty type ID of this faculty
	*/
	@Override
	public long getFacultyTypeId() {
		return _faculty.getFacultyTypeId();
	}

	/**
	* Sets the faculty type ID of this faculty.
	*
	* @param facultyTypeId the faculty type ID of this faculty
	*/
	@Override
	public void setFacultyTypeId(long facultyTypeId) {
		_faculty.setFacultyTypeId(facultyTypeId);
	}

	/**
	* Returns the faculty name of this faculty.
	*
	* @return the faculty name of this faculty
	*/
	@Override
	public java.lang.String getFacultyName() {
		return _faculty.getFacultyName();
	}

	/**
	* Sets the faculty name of this faculty.
	*
	* @param facultyName the faculty name of this faculty
	*/
	@Override
	public void setFacultyName(java.lang.String facultyName) {
		_faculty.setFacultyName(facultyName);
	}

	@Override
	public boolean isNew() {
		return _faculty.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_faculty.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _faculty.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_faculty.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _faculty.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _faculty.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_faculty.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _faculty.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_faculty.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_faculty.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_faculty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FacultyWrapper((Faculty)_faculty.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.Faculty faculty) {
		return _faculty.compareTo(faculty);
	}

	@Override
	public int hashCode() {
		return _faculty.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.Faculty> toCacheModel() {
		return _faculty.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.Faculty toEscapedModel() {
		return new FacultyWrapper(_faculty.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.Faculty toUnescapedModel() {
		return new FacultyWrapper(_faculty.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _faculty.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _faculty.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_faculty.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FacultyWrapper)) {
			return false;
		}

		FacultyWrapper facultyWrapper = (FacultyWrapper)obj;

		if (Validator.equals(_faculty, facultyWrapper._faculty)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Faculty getWrappedFaculty() {
		return _faculty;
	}

	@Override
	public Faculty getWrappedModel() {
		return _faculty;
	}

	@Override
	public void resetOriginalValues() {
		_faculty.resetOriginalValues();
	}

	private Faculty _faculty;
}
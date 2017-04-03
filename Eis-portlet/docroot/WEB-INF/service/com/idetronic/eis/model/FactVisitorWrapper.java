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
 * This class is a wrapper for {@link FactVisitor}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactVisitor
 * @generated
 */
public class FactVisitorWrapper implements FactVisitor,
	ModelWrapper<FactVisitor> {
	public FactVisitorWrapper(FactVisitor factVisitor) {
		_factVisitor = factVisitor;
	}

	@Override
	public Class<?> getModelClass() {
		return FactVisitor.class;
	}

	@Override
	public String getModelClassName() {
		return FactVisitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factVisitorId", getFactVisitorId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("visitorCategoryId", getVisitorCategoryId());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("value", getValue());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factVisitorId = (Long)attributes.get("factVisitorId");

		if (factVisitorId != null) {
			setFactVisitorId(factVisitorId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long visitorCategoryId = (Long)attributes.get("visitorCategoryId");

		if (visitorCategoryId != null) {
			setVisitorCategoryId(visitorCategoryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
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
	* Returns the primary key of this fact visitor.
	*
	* @return the primary key of this fact visitor
	*/
	@Override
	public long getPrimaryKey() {
		return _factVisitor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact visitor.
	*
	* @param primaryKey the primary key of this fact visitor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factVisitor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact visitor ID of this fact visitor.
	*
	* @return the fact visitor ID of this fact visitor
	*/
	@Override
	public long getFactVisitorId() {
		return _factVisitor.getFactVisitorId();
	}

	/**
	* Sets the fact visitor ID of this fact visitor.
	*
	* @param factVisitorId the fact visitor ID of this fact visitor
	*/
	@Override
	public void setFactVisitorId(long factVisitorId) {
		_factVisitor.setFactVisitorId(factVisitorId);
	}

	/**
	* Returns the library ID of this fact visitor.
	*
	* @return the library ID of this fact visitor
	*/
	@Override
	public long getLibraryId() {
		return _factVisitor.getLibraryId();
	}

	/**
	* Sets the library ID of this fact visitor.
	*
	* @param libraryId the library ID of this fact visitor
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factVisitor.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact visitor.
	*
	* @return the period of this fact visitor
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factVisitor.getPeriod();
	}

	/**
	* Sets the period of this fact visitor.
	*
	* @param period the period of this fact visitor
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factVisitor.setPeriod(period);
	}

	/**
	* Returns the visitor category ID of this fact visitor.
	*
	* @return the visitor category ID of this fact visitor
	*/
	@Override
	public long getVisitorCategoryId() {
		return _factVisitor.getVisitorCategoryId();
	}

	/**
	* Sets the visitor category ID of this fact visitor.
	*
	* @param visitorCategoryId the visitor category ID of this fact visitor
	*/
	@Override
	public void setVisitorCategoryId(long visitorCategoryId) {
		_factVisitor.setVisitorCategoryId(visitorCategoryId);
	}

	/**
	* Returns the state ID of this fact visitor.
	*
	* @return the state ID of this fact visitor
	*/
	@Override
	public long getStateId() {
		return _factVisitor.getStateId();
	}

	/**
	* Sets the state ID of this fact visitor.
	*
	* @param stateId the state ID of this fact visitor
	*/
	@Override
	public void setStateId(long stateId) {
		_factVisitor.setStateId(stateId);
	}

	/**
	* Returns the library type ID of this fact visitor.
	*
	* @return the library type ID of this fact visitor
	*/
	@Override
	public long getLibraryTypeId() {
		return _factVisitor.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this fact visitor.
	*
	* @param libraryTypeId the library type ID of this fact visitor
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_factVisitor.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the value of this fact visitor.
	*
	* @return the value of this fact visitor
	*/
	@Override
	public int getValue() {
		return _factVisitor.getValue();
	}

	/**
	* Sets the value of this fact visitor.
	*
	* @param value the value of this fact visitor
	*/
	@Override
	public void setValue(int value) {
		_factVisitor.setValue(value);
	}

	/**
	* Returns the created by user ID of this fact visitor.
	*
	* @return the created by user ID of this fact visitor
	*/
	@Override
	public long getCreatedByUserId() {
		return _factVisitor.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this fact visitor.
	*
	* @param createdByUserId the created by user ID of this fact visitor
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_factVisitor.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this fact visitor.
	*
	* @return the created by user uuid of this fact visitor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitor.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this fact visitor.
	*
	* @param createdByUserUuid the created by user uuid of this fact visitor
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_factVisitor.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the created by user name of this fact visitor.
	*
	* @return the created by user name of this fact visitor
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _factVisitor.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this fact visitor.
	*
	* @param createdByUserName the created by user name of this fact visitor
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_factVisitor.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the created date of this fact visitor.
	*
	* @return the created date of this fact visitor
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _factVisitor.getCreatedDate();
	}

	/**
	* Sets the created date of this fact visitor.
	*
	* @param createdDate the created date of this fact visitor
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_factVisitor.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _factVisitor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factVisitor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factVisitor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factVisitor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factVisitor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factVisitor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factVisitor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factVisitor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factVisitor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factVisitor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factVisitor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactVisitorWrapper((FactVisitor)_factVisitor.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactVisitor factVisitor) {
		return _factVisitor.compareTo(factVisitor);
	}

	@Override
	public int hashCode() {
		return _factVisitor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactVisitor> toCacheModel() {
		return _factVisitor.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactVisitor toEscapedModel() {
		return new FactVisitorWrapper(_factVisitor.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactVisitor toUnescapedModel() {
		return new FactVisitorWrapper(_factVisitor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factVisitor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factVisitor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factVisitor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactVisitorWrapper)) {
			return false;
		}

		FactVisitorWrapper factVisitorWrapper = (FactVisitorWrapper)obj;

		if (Validator.equals(_factVisitor, factVisitorWrapper._factVisitor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactVisitor getWrappedFactVisitor() {
		return _factVisitor;
	}

	@Override
	public FactVisitor getWrappedModel() {
		return _factVisitor;
	}

	@Override
	public void resetOriginalValues() {
		_factVisitor.resetOriginalValues();
	}

	private FactVisitor _factVisitor;
}
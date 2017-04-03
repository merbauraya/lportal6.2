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
 * This class is a wrapper for {@link VisitorCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see VisitorCategory
 * @generated
 */
public class VisitorCategoryWrapper implements VisitorCategory,
	ModelWrapper<VisitorCategory> {
	public VisitorCategoryWrapper(VisitorCategory visitorCategory) {
		_visitorCategory = visitorCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return VisitorCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VisitorCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visitorCategoryId", getVisitorCategoryId());
		attributes.put("visitorCategoryCode", getVisitorCategoryCode());
		attributes.put("visitorCategoryName", getVisitorCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long visitorCategoryId = (Long)attributes.get("visitorCategoryId");

		if (visitorCategoryId != null) {
			setVisitorCategoryId(visitorCategoryId);
		}

		String visitorCategoryCode = (String)attributes.get(
				"visitorCategoryCode");

		if (visitorCategoryCode != null) {
			setVisitorCategoryCode(visitorCategoryCode);
		}

		String visitorCategoryName = (String)attributes.get(
				"visitorCategoryName");

		if (visitorCategoryName != null) {
			setVisitorCategoryName(visitorCategoryName);
		}
	}

	/**
	* Returns the primary key of this visitor category.
	*
	* @return the primary key of this visitor category
	*/
	@Override
	public long getPrimaryKey() {
		return _visitorCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this visitor category.
	*
	* @param primaryKey the primary key of this visitor category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_visitorCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the visitor category ID of this visitor category.
	*
	* @return the visitor category ID of this visitor category
	*/
	@Override
	public long getVisitorCategoryId() {
		return _visitorCategory.getVisitorCategoryId();
	}

	/**
	* Sets the visitor category ID of this visitor category.
	*
	* @param visitorCategoryId the visitor category ID of this visitor category
	*/
	@Override
	public void setVisitorCategoryId(long visitorCategoryId) {
		_visitorCategory.setVisitorCategoryId(visitorCategoryId);
	}

	/**
	* Returns the visitor category code of this visitor category.
	*
	* @return the visitor category code of this visitor category
	*/
	@Override
	public java.lang.String getVisitorCategoryCode() {
		return _visitorCategory.getVisitorCategoryCode();
	}

	/**
	* Sets the visitor category code of this visitor category.
	*
	* @param visitorCategoryCode the visitor category code of this visitor category
	*/
	@Override
	public void setVisitorCategoryCode(java.lang.String visitorCategoryCode) {
		_visitorCategory.setVisitorCategoryCode(visitorCategoryCode);
	}

	/**
	* Returns the visitor category name of this visitor category.
	*
	* @return the visitor category name of this visitor category
	*/
	@Override
	public java.lang.String getVisitorCategoryName() {
		return _visitorCategory.getVisitorCategoryName();
	}

	/**
	* Sets the visitor category name of this visitor category.
	*
	* @param visitorCategoryName the visitor category name of this visitor category
	*/
	@Override
	public void setVisitorCategoryName(java.lang.String visitorCategoryName) {
		_visitorCategory.setVisitorCategoryName(visitorCategoryName);
	}

	@Override
	public boolean isNew() {
		return _visitorCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_visitorCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _visitorCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_visitorCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _visitorCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _visitorCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_visitorCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _visitorCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_visitorCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_visitorCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_visitorCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VisitorCategoryWrapper((VisitorCategory)_visitorCategory.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.VisitorCategory visitorCategory) {
		return _visitorCategory.compareTo(visitorCategory);
	}

	@Override
	public int hashCode() {
		return _visitorCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.VisitorCategory> toCacheModel() {
		return _visitorCategory.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.VisitorCategory toEscapedModel() {
		return new VisitorCategoryWrapper(_visitorCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.VisitorCategory toUnescapedModel() {
		return new VisitorCategoryWrapper(_visitorCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _visitorCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _visitorCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitorCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VisitorCategoryWrapper)) {
			return false;
		}

		VisitorCategoryWrapper visitorCategoryWrapper = (VisitorCategoryWrapper)obj;

		if (Validator.equals(_visitorCategory,
					visitorCategoryWrapper._visitorCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VisitorCategory getWrappedVisitorCategory() {
		return _visitorCategory;
	}

	@Override
	public VisitorCategory getWrappedModel() {
		return _visitorCategory;
	}

	@Override
	public void resetOriginalValues() {
		_visitorCategory.resetOriginalValues();
	}

	private VisitorCategory _visitorCategory;
}
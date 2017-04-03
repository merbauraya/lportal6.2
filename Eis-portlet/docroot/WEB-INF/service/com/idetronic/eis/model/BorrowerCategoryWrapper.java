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
 * This class is a wrapper for {@link BorrowerCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see BorrowerCategory
 * @generated
 */
public class BorrowerCategoryWrapper implements BorrowerCategory,
	ModelWrapper<BorrowerCategory> {
	public BorrowerCategoryWrapper(BorrowerCategory borrowerCategory) {
		_borrowerCategory = borrowerCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return BorrowerCategory.class;
	}

	@Override
	public String getModelClassName() {
		return BorrowerCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("borrowerCategoryId", getBorrowerCategoryId());
		attributes.put("borrowerCategoryName", getBorrowerCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long borrowerCategoryId = (Long)attributes.get("borrowerCategoryId");

		if (borrowerCategoryId != null) {
			setBorrowerCategoryId(borrowerCategoryId);
		}

		String borrowerCategoryName = (String)attributes.get(
				"borrowerCategoryName");

		if (borrowerCategoryName != null) {
			setBorrowerCategoryName(borrowerCategoryName);
		}
	}

	/**
	* Returns the primary key of this borrower category.
	*
	* @return the primary key of this borrower category
	*/
	@Override
	public long getPrimaryKey() {
		return _borrowerCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this borrower category.
	*
	* @param primaryKey the primary key of this borrower category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_borrowerCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the borrower category ID of this borrower category.
	*
	* @return the borrower category ID of this borrower category
	*/
	@Override
	public long getBorrowerCategoryId() {
		return _borrowerCategory.getBorrowerCategoryId();
	}

	/**
	* Sets the borrower category ID of this borrower category.
	*
	* @param borrowerCategoryId the borrower category ID of this borrower category
	*/
	@Override
	public void setBorrowerCategoryId(long borrowerCategoryId) {
		_borrowerCategory.setBorrowerCategoryId(borrowerCategoryId);
	}

	/**
	* Returns the borrower category name of this borrower category.
	*
	* @return the borrower category name of this borrower category
	*/
	@Override
	public java.lang.String getBorrowerCategoryName() {
		return _borrowerCategory.getBorrowerCategoryName();
	}

	/**
	* Sets the borrower category name of this borrower category.
	*
	* @param borrowerCategoryName the borrower category name of this borrower category
	*/
	@Override
	public void setBorrowerCategoryName(java.lang.String borrowerCategoryName) {
		_borrowerCategory.setBorrowerCategoryName(borrowerCategoryName);
	}

	@Override
	public boolean isNew() {
		return _borrowerCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_borrowerCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _borrowerCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_borrowerCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _borrowerCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _borrowerCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_borrowerCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _borrowerCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_borrowerCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_borrowerCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_borrowerCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BorrowerCategoryWrapper((BorrowerCategory)_borrowerCategory.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.BorrowerCategory borrowerCategory) {
		return _borrowerCategory.compareTo(borrowerCategory);
	}

	@Override
	public int hashCode() {
		return _borrowerCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.BorrowerCategory> toCacheModel() {
		return _borrowerCategory.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.BorrowerCategory toEscapedModel() {
		return new BorrowerCategoryWrapper(_borrowerCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.BorrowerCategory toUnescapedModel() {
		return new BorrowerCategoryWrapper(_borrowerCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _borrowerCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _borrowerCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_borrowerCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BorrowerCategoryWrapper)) {
			return false;
		}

		BorrowerCategoryWrapper borrowerCategoryWrapper = (BorrowerCategoryWrapper)obj;

		if (Validator.equals(_borrowerCategory,
					borrowerCategoryWrapper._borrowerCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BorrowerCategory getWrappedBorrowerCategory() {
		return _borrowerCategory;
	}

	@Override
	public BorrowerCategory getWrappedModel() {
		return _borrowerCategory;
	}

	@Override
	public void resetOriginalValues() {
		_borrowerCategory.resetOriginalValues();
	}

	private BorrowerCategory _borrowerCategory;
}
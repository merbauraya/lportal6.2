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
 * This class is a wrapper for {@link MemberCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MemberCategory
 * @generated
 */
public class MemberCategoryWrapper implements MemberCategory,
	ModelWrapper<MemberCategory> {
	public MemberCategoryWrapper(MemberCategory memberCategory) {
		_memberCategory = memberCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return MemberCategory.class;
	}

	@Override
	public String getModelClassName() {
		return MemberCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberCategoryId", getMemberCategoryId());
		attributes.put("memberCategoryName", getMemberCategoryName());
		attributes.put("memberCategoryGroupName", getMemberCategoryGroupName());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberCategoryId = (Long)attributes.get("memberCategoryId");

		if (memberCategoryId != null) {
			setMemberCategoryId(memberCategoryId);
		}

		String memberCategoryName = (String)attributes.get("memberCategoryName");

		if (memberCategoryName != null) {
			setMemberCategoryName(memberCategoryName);
		}

		String memberCategoryGroupName = (String)attributes.get(
				"memberCategoryGroupName");

		if (memberCategoryGroupName != null) {
			setMemberCategoryGroupName(memberCategoryGroupName);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this member category.
	*
	* @return the primary key of this member category
	*/
	@Override
	public long getPrimaryKey() {
		return _memberCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member category.
	*
	* @param primaryKey the primary key of this member category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_memberCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the member category ID of this member category.
	*
	* @return the member category ID of this member category
	*/
	@Override
	public long getMemberCategoryId() {
		return _memberCategory.getMemberCategoryId();
	}

	/**
	* Sets the member category ID of this member category.
	*
	* @param memberCategoryId the member category ID of this member category
	*/
	@Override
	public void setMemberCategoryId(long memberCategoryId) {
		_memberCategory.setMemberCategoryId(memberCategoryId);
	}

	/**
	* Returns the member category name of this member category.
	*
	* @return the member category name of this member category
	*/
	@Override
	public java.lang.String getMemberCategoryName() {
		return _memberCategory.getMemberCategoryName();
	}

	/**
	* Sets the member category name of this member category.
	*
	* @param memberCategoryName the member category name of this member category
	*/
	@Override
	public void setMemberCategoryName(java.lang.String memberCategoryName) {
		_memberCategory.setMemberCategoryName(memberCategoryName);
	}

	/**
	* Returns the member category group name of this member category.
	*
	* @return the member category group name of this member category
	*/
	@Override
	public java.lang.String getMemberCategoryGroupName() {
		return _memberCategory.getMemberCategoryGroupName();
	}

	/**
	* Sets the member category group name of this member category.
	*
	* @param memberCategoryGroupName the member category group name of this member category
	*/
	@Override
	public void setMemberCategoryGroupName(
		java.lang.String memberCategoryGroupName) {
		_memberCategory.setMemberCategoryGroupName(memberCategoryGroupName);
	}

	/**
	* Returns the active of this member category.
	*
	* @return the active of this member category
	*/
	@Override
	public boolean getActive() {
		return _memberCategory.getActive();
	}

	/**
	* Returns <code>true</code> if this member category is active.
	*
	* @return <code>true</code> if this member category is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _memberCategory.isActive();
	}

	/**
	* Sets whether this member category is active.
	*
	* @param active the active of this member category
	*/
	@Override
	public void setActive(boolean active) {
		_memberCategory.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _memberCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_memberCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _memberCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_memberCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _memberCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _memberCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_memberCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _memberCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_memberCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_memberCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_memberCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MemberCategoryWrapper((MemberCategory)_memberCategory.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.MemberCategory memberCategory) {
		return _memberCategory.compareTo(memberCategory);
	}

	@Override
	public int hashCode() {
		return _memberCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.MemberCategory> toCacheModel() {
		return _memberCategory.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.MemberCategory toEscapedModel() {
		return new MemberCategoryWrapper(_memberCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.MemberCategory toUnescapedModel() {
		return new MemberCategoryWrapper(_memberCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _memberCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _memberCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_memberCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MemberCategoryWrapper)) {
			return false;
		}

		MemberCategoryWrapper memberCategoryWrapper = (MemberCategoryWrapper)obj;

		if (Validator.equals(_memberCategory,
					memberCategoryWrapper._memberCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MemberCategory getWrappedMemberCategory() {
		return _memberCategory;
	}

	@Override
	public MemberCategory getWrappedModel() {
		return _memberCategory;
	}

	@Override
	public void resetOriginalValues() {
		_memberCategory.resetOriginalValues();
	}

	private MemberCategory _memberCategory;
}
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
 * This class is a wrapper for {@link PostCategory}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PostCategory
 * @generated
 */
public class PostCategoryWrapper implements PostCategory,
	ModelWrapper<PostCategory> {
	public PostCategoryWrapper(PostCategory postCategory) {
		_postCategory = postCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return PostCategory.class;
	}

	@Override
	public String getModelClassName() {
		return PostCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postCategoryId", getPostCategoryId());
		attributes.put("postCategoryCode", getPostCategoryCode());
		attributes.put("postCategoryName", getPostCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postCategoryId = (Long)attributes.get("postCategoryId");

		if (postCategoryId != null) {
			setPostCategoryId(postCategoryId);
		}

		String postCategoryCode = (String)attributes.get("postCategoryCode");

		if (postCategoryCode != null) {
			setPostCategoryCode(postCategoryCode);
		}

		String postCategoryName = (String)attributes.get("postCategoryName");

		if (postCategoryName != null) {
			setPostCategoryName(postCategoryName);
		}
	}

	/**
	* Returns the primary key of this post category.
	*
	* @return the primary key of this post category
	*/
	@Override
	public long getPrimaryKey() {
		return _postCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this post category.
	*
	* @param primaryKey the primary key of this post category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_postCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the post category ID of this post category.
	*
	* @return the post category ID of this post category
	*/
	@Override
	public long getPostCategoryId() {
		return _postCategory.getPostCategoryId();
	}

	/**
	* Sets the post category ID of this post category.
	*
	* @param postCategoryId the post category ID of this post category
	*/
	@Override
	public void setPostCategoryId(long postCategoryId) {
		_postCategory.setPostCategoryId(postCategoryId);
	}

	/**
	* Returns the post category code of this post category.
	*
	* @return the post category code of this post category
	*/
	@Override
	public java.lang.String getPostCategoryCode() {
		return _postCategory.getPostCategoryCode();
	}

	/**
	* Sets the post category code of this post category.
	*
	* @param postCategoryCode the post category code of this post category
	*/
	@Override
	public void setPostCategoryCode(java.lang.String postCategoryCode) {
		_postCategory.setPostCategoryCode(postCategoryCode);
	}

	/**
	* Returns the post category name of this post category.
	*
	* @return the post category name of this post category
	*/
	@Override
	public java.lang.String getPostCategoryName() {
		return _postCategory.getPostCategoryName();
	}

	/**
	* Sets the post category name of this post category.
	*
	* @param postCategoryName the post category name of this post category
	*/
	@Override
	public void setPostCategoryName(java.lang.String postCategoryName) {
		_postCategory.setPostCategoryName(postCategoryName);
	}

	@Override
	public boolean isNew() {
		return _postCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_postCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _postCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_postCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _postCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _postCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_postCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _postCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_postCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_postCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_postCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PostCategoryWrapper((PostCategory)_postCategory.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.PostCategory postCategory) {
		return _postCategory.compareTo(postCategory);
	}

	@Override
	public int hashCode() {
		return _postCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.PostCategory> toCacheModel() {
		return _postCategory.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.PostCategory toEscapedModel() {
		return new PostCategoryWrapper(_postCategory.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.PostCategory toUnescapedModel() {
		return new PostCategoryWrapper(_postCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _postCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _postCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_postCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PostCategoryWrapper)) {
			return false;
		}

		PostCategoryWrapper postCategoryWrapper = (PostCategoryWrapper)obj;

		if (Validator.equals(_postCategory, postCategoryWrapper._postCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PostCategory getWrappedPostCategory() {
		return _postCategory;
	}

	@Override
	public PostCategory getWrappedModel() {
		return _postCategory;
	}

	@Override
	public void resetOriginalValues() {
		_postCategory.resetOriginalValues();
	}

	private PostCategory _postCategory;
}
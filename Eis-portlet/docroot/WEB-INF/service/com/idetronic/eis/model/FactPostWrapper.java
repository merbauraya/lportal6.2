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
 * This class is a wrapper for {@link FactPost}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPost
 * @generated
 */
public class FactPostWrapper implements FactPost, ModelWrapper<FactPost> {
	public FactPostWrapper(FactPost factPost) {
		_factPost = factPost;
	}

	@Override
	public Class<?> getModelClass() {
		return FactPost.class;
	}

	@Override
	public String getModelClassName() {
		return FactPost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factPostId", getFactPostId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("postGradeId", getPostGradeId());
		attributes.put("stateId", getStateId());
		attributes.put("value", getValue());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factPostId = (Long)attributes.get("factPostId");

		if (factPostId != null) {
			setFactPostId(factPostId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long postGradeId = (Long)attributes.get("postGradeId");

		if (postGradeId != null) {
			setPostGradeId(postGradeId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
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
	* Returns the primary key of this fact post.
	*
	* @return the primary key of this fact post
	*/
	@Override
	public long getPrimaryKey() {
		return _factPost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact post.
	*
	* @param primaryKey the primary key of this fact post
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factPost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact post ID of this fact post.
	*
	* @return the fact post ID of this fact post
	*/
	@Override
	public long getFactPostId() {
		return _factPost.getFactPostId();
	}

	/**
	* Sets the fact post ID of this fact post.
	*
	* @param factPostId the fact post ID of this fact post
	*/
	@Override
	public void setFactPostId(long factPostId) {
		_factPost.setFactPostId(factPostId);
	}

	/**
	* Returns the library ID of this fact post.
	*
	* @return the library ID of this fact post
	*/
	@Override
	public long getLibraryId() {
		return _factPost.getLibraryId();
	}

	/**
	* Sets the library ID of this fact post.
	*
	* @param libraryId the library ID of this fact post
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factPost.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact post.
	*
	* @return the period of this fact post
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factPost.getPeriod();
	}

	/**
	* Sets the period of this fact post.
	*
	* @param period the period of this fact post
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factPost.setPeriod(period);
	}

	/**
	* Returns the post grade ID of this fact post.
	*
	* @return the post grade ID of this fact post
	*/
	@Override
	public long getPostGradeId() {
		return _factPost.getPostGradeId();
	}

	/**
	* Sets the post grade ID of this fact post.
	*
	* @param postGradeId the post grade ID of this fact post
	*/
	@Override
	public void setPostGradeId(long postGradeId) {
		_factPost.setPostGradeId(postGradeId);
	}

	/**
	* Returns the state ID of this fact post.
	*
	* @return the state ID of this fact post
	*/
	@Override
	public long getStateId() {
		return _factPost.getStateId();
	}

	/**
	* Sets the state ID of this fact post.
	*
	* @param stateId the state ID of this fact post
	*/
	@Override
	public void setStateId(long stateId) {
		_factPost.setStateId(stateId);
	}

	/**
	* Returns the value of this fact post.
	*
	* @return the value of this fact post
	*/
	@Override
	public int getValue() {
		return _factPost.getValue();
	}

	/**
	* Sets the value of this fact post.
	*
	* @param value the value of this fact post
	*/
	@Override
	public void setValue(int value) {
		_factPost.setValue(value);
	}

	/**
	* Returns the created by user ID of this fact post.
	*
	* @return the created by user ID of this fact post
	*/
	@Override
	public long getCreatedByUserId() {
		return _factPost.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this fact post.
	*
	* @param createdByUserId the created by user ID of this fact post
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_factPost.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this fact post.
	*
	* @return the created by user uuid of this fact post
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factPost.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this fact post.
	*
	* @param createdByUserUuid the created by user uuid of this fact post
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_factPost.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the created by user name of this fact post.
	*
	* @return the created by user name of this fact post
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _factPost.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this fact post.
	*
	* @param createdByUserName the created by user name of this fact post
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_factPost.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the created date of this fact post.
	*
	* @return the created date of this fact post
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _factPost.getCreatedDate();
	}

	/**
	* Sets the created date of this fact post.
	*
	* @param createdDate the created date of this fact post
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_factPost.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _factPost.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factPost.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factPost.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factPost.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factPost.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factPost.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factPost.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factPost.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factPost.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factPost.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factPost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactPostWrapper((FactPost)_factPost.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactPost factPost) {
		return _factPost.compareTo(factPost);
	}

	@Override
	public int hashCode() {
		return _factPost.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactPost> toCacheModel() {
		return _factPost.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactPost toEscapedModel() {
		return new FactPostWrapper(_factPost.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactPost toUnescapedModel() {
		return new FactPostWrapper(_factPost.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factPost.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factPost.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factPost.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactPostWrapper)) {
			return false;
		}

		FactPostWrapper factPostWrapper = (FactPostWrapper)obj;

		if (Validator.equals(_factPost, factPostWrapper._factPost)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactPost getWrappedFactPost() {
		return _factPost;
	}

	@Override
	public FactPost getWrappedModel() {
		return _factPost;
	}

	@Override
	public void resetOriginalValues() {
		_factPost.resetOriginalValues();
	}

	private FactPost _factPost;
}
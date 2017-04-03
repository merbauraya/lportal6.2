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
 * This class is a wrapper for {@link PostGrade}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PostGrade
 * @generated
 */
public class PostGradeWrapper implements PostGrade, ModelWrapper<PostGrade> {
	public PostGradeWrapper(PostGrade postGrade) {
		_postGrade = postGrade;
	}

	@Override
	public Class<?> getModelClass() {
		return PostGrade.class;
	}

	@Override
	public String getModelClassName() {
		return PostGrade.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postGradeId", getPostGradeId());
		attributes.put("postCategoryId", getPostCategoryId());
		attributes.put("postGradeCode", getPostGradeCode());
		attributes.put("postGradeScheme", getPostGradeScheme());
		attributes.put("postGradeName", getPostGradeName());
		attributes.put("postGradeDesc", getPostGradeDesc());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postGradeId = (Long)attributes.get("postGradeId");

		if (postGradeId != null) {
			setPostGradeId(postGradeId);
		}

		Long postCategoryId = (Long)attributes.get("postCategoryId");

		if (postCategoryId != null) {
			setPostCategoryId(postCategoryId);
		}

		String postGradeCode = (String)attributes.get("postGradeCode");

		if (postGradeCode != null) {
			setPostGradeCode(postGradeCode);
		}

		String postGradeScheme = (String)attributes.get("postGradeScheme");

		if (postGradeScheme != null) {
			setPostGradeScheme(postGradeScheme);
		}

		String postGradeName = (String)attributes.get("postGradeName");

		if (postGradeName != null) {
			setPostGradeName(postGradeName);
		}

		String postGradeDesc = (String)attributes.get("postGradeDesc");

		if (postGradeDesc != null) {
			setPostGradeDesc(postGradeDesc);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this post grade.
	*
	* @return the primary key of this post grade
	*/
	@Override
	public long getPrimaryKey() {
		return _postGrade.getPrimaryKey();
	}

	/**
	* Sets the primary key of this post grade.
	*
	* @param primaryKey the primary key of this post grade
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_postGrade.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the post grade ID of this post grade.
	*
	* @return the post grade ID of this post grade
	*/
	@Override
	public long getPostGradeId() {
		return _postGrade.getPostGradeId();
	}

	/**
	* Sets the post grade ID of this post grade.
	*
	* @param postGradeId the post grade ID of this post grade
	*/
	@Override
	public void setPostGradeId(long postGradeId) {
		_postGrade.setPostGradeId(postGradeId);
	}

	/**
	* Returns the post category ID of this post grade.
	*
	* @return the post category ID of this post grade
	*/
	@Override
	public long getPostCategoryId() {
		return _postGrade.getPostCategoryId();
	}

	/**
	* Sets the post category ID of this post grade.
	*
	* @param postCategoryId the post category ID of this post grade
	*/
	@Override
	public void setPostCategoryId(long postCategoryId) {
		_postGrade.setPostCategoryId(postCategoryId);
	}

	/**
	* Returns the post grade code of this post grade.
	*
	* @return the post grade code of this post grade
	*/
	@Override
	public java.lang.String getPostGradeCode() {
		return _postGrade.getPostGradeCode();
	}

	/**
	* Sets the post grade code of this post grade.
	*
	* @param postGradeCode the post grade code of this post grade
	*/
	@Override
	public void setPostGradeCode(java.lang.String postGradeCode) {
		_postGrade.setPostGradeCode(postGradeCode);
	}

	/**
	* Returns the post grade scheme of this post grade.
	*
	* @return the post grade scheme of this post grade
	*/
	@Override
	public java.lang.String getPostGradeScheme() {
		return _postGrade.getPostGradeScheme();
	}

	/**
	* Sets the post grade scheme of this post grade.
	*
	* @param postGradeScheme the post grade scheme of this post grade
	*/
	@Override
	public void setPostGradeScheme(java.lang.String postGradeScheme) {
		_postGrade.setPostGradeScheme(postGradeScheme);
	}

	/**
	* Returns the post grade name of this post grade.
	*
	* @return the post grade name of this post grade
	*/
	@Override
	public java.lang.String getPostGradeName() {
		return _postGrade.getPostGradeName();
	}

	/**
	* Sets the post grade name of this post grade.
	*
	* @param postGradeName the post grade name of this post grade
	*/
	@Override
	public void setPostGradeName(java.lang.String postGradeName) {
		_postGrade.setPostGradeName(postGradeName);
	}

	/**
	* Returns the post grade desc of this post grade.
	*
	* @return the post grade desc of this post grade
	*/
	@Override
	public java.lang.String getPostGradeDesc() {
		return _postGrade.getPostGradeDesc();
	}

	/**
	* Sets the post grade desc of this post grade.
	*
	* @param postGradeDesc the post grade desc of this post grade
	*/
	@Override
	public void setPostGradeDesc(java.lang.String postGradeDesc) {
		_postGrade.setPostGradeDesc(postGradeDesc);
	}

	/**
	* Returns the company ID of this post grade.
	*
	* @return the company ID of this post grade
	*/
	@Override
	public long getCompanyId() {
		return _postGrade.getCompanyId();
	}

	/**
	* Sets the company ID of this post grade.
	*
	* @param companyId the company ID of this post grade
	*/
	@Override
	public void setCompanyId(long companyId) {
		_postGrade.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this post grade.
	*
	* @return the group ID of this post grade
	*/
	@Override
	public long getGroupId() {
		return _postGrade.getGroupId();
	}

	/**
	* Sets the group ID of this post grade.
	*
	* @param groupId the group ID of this post grade
	*/
	@Override
	public void setGroupId(long groupId) {
		_postGrade.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this post grade.
	*
	* @return the user ID of this post grade
	*/
	@Override
	public long getUserId() {
		return _postGrade.getUserId();
	}

	/**
	* Sets the user ID of this post grade.
	*
	* @param userId the user ID of this post grade
	*/
	@Override
	public void setUserId(long userId) {
		_postGrade.setUserId(userId);
	}

	/**
	* Returns the user uuid of this post grade.
	*
	* @return the user uuid of this post grade
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGrade.getUserUuid();
	}

	/**
	* Sets the user uuid of this post grade.
	*
	* @param userUuid the user uuid of this post grade
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_postGrade.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this post grade.
	*
	* @return the user name of this post grade
	*/
	@Override
	public java.lang.String getUserName() {
		return _postGrade.getUserName();
	}

	/**
	* Sets the user name of this post grade.
	*
	* @param userName the user name of this post grade
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_postGrade.setUserName(userName);
	}

	/**
	* Returns the create date of this post grade.
	*
	* @return the create date of this post grade
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _postGrade.getCreateDate();
	}

	/**
	* Sets the create date of this post grade.
	*
	* @param createDate the create date of this post grade
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_postGrade.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this post grade.
	*
	* @return the modified date of this post grade
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _postGrade.getModifiedDate();
	}

	/**
	* Sets the modified date of this post grade.
	*
	* @param modifiedDate the modified date of this post grade
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_postGrade.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _postGrade.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_postGrade.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _postGrade.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_postGrade.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _postGrade.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _postGrade.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_postGrade.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _postGrade.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_postGrade.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_postGrade.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_postGrade.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PostGradeWrapper((PostGrade)_postGrade.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.PostGrade postGrade) {
		return _postGrade.compareTo(postGrade);
	}

	@Override
	public int hashCode() {
		return _postGrade.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.PostGrade> toCacheModel() {
		return _postGrade.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.PostGrade toEscapedModel() {
		return new PostGradeWrapper(_postGrade.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.PostGrade toUnescapedModel() {
		return new PostGradeWrapper(_postGrade.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _postGrade.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _postGrade.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_postGrade.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PostGradeWrapper)) {
			return false;
		}

		PostGradeWrapper postGradeWrapper = (PostGradeWrapper)obj;

		if (Validator.equals(_postGrade, postGradeWrapper._postGrade)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PostGrade getWrappedPostGrade() {
		return _postGrade;
	}

	@Override
	public PostGrade getWrappedModel() {
		return _postGrade;
	}

	@Override
	public void resetOriginalValues() {
		_postGrade.resetOriginalValues();
	}

	private PostGrade _postGrade;
}
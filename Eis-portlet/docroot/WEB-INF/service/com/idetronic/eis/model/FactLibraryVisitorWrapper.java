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
 * This class is a wrapper for {@link FactLibraryVisitor}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactLibraryVisitor
 * @generated
 */
public class FactLibraryVisitorWrapper implements FactLibraryVisitor,
	ModelWrapper<FactLibraryVisitor> {
	public FactLibraryVisitorWrapper(FactLibraryVisitor factLibraryVisitor) {
		_factLibraryVisitor = factLibraryVisitor;
	}

	@Override
	public Class<?> getModelClass() {
		return FactLibraryVisitor.class;
	}

	@Override
	public String getModelClassName() {
		return FactLibraryVisitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("visitorCategoryId", getVisitorCategoryId());
		attributes.put("sessionTotal", getSessionTotal());
		attributes.put("visitorTotal", getVisitorTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factId = (Long)attributes.get("factId");

		if (factId != null) {
			setFactId(factId);
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

		Long sessionTotal = (Long)attributes.get("sessionTotal");

		if (sessionTotal != null) {
			setSessionTotal(sessionTotal);
		}

		Long visitorTotal = (Long)attributes.get("visitorTotal");

		if (visitorTotal != null) {
			setVisitorTotal(visitorTotal);
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
	}

	/**
	* Returns the primary key of this fact library visitor.
	*
	* @return the primary key of this fact library visitor
	*/
	@Override
	public long getPrimaryKey() {
		return _factLibraryVisitor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact library visitor.
	*
	* @param primaryKey the primary key of this fact library visitor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factLibraryVisitor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact library visitor.
	*
	* @return the fact ID of this fact library visitor
	*/
	@Override
	public long getFactId() {
		return _factLibraryVisitor.getFactId();
	}

	/**
	* Sets the fact ID of this fact library visitor.
	*
	* @param factId the fact ID of this fact library visitor
	*/
	@Override
	public void setFactId(long factId) {
		_factLibraryVisitor.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact library visitor.
	*
	* @return the library ID of this fact library visitor
	*/
	@Override
	public long getLibraryId() {
		return _factLibraryVisitor.getLibraryId();
	}

	/**
	* Sets the library ID of this fact library visitor.
	*
	* @param libraryId the library ID of this fact library visitor
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factLibraryVisitor.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact library visitor.
	*
	* @return the period of this fact library visitor
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factLibraryVisitor.getPeriod();
	}

	/**
	* Sets the period of this fact library visitor.
	*
	* @param period the period of this fact library visitor
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factLibraryVisitor.setPeriod(period);
	}

	/**
	* Returns the visitor category ID of this fact library visitor.
	*
	* @return the visitor category ID of this fact library visitor
	*/
	@Override
	public long getVisitorCategoryId() {
		return _factLibraryVisitor.getVisitorCategoryId();
	}

	/**
	* Sets the visitor category ID of this fact library visitor.
	*
	* @param visitorCategoryId the visitor category ID of this fact library visitor
	*/
	@Override
	public void setVisitorCategoryId(long visitorCategoryId) {
		_factLibraryVisitor.setVisitorCategoryId(visitorCategoryId);
	}

	/**
	* Returns the session total of this fact library visitor.
	*
	* @return the session total of this fact library visitor
	*/
	@Override
	public long getSessionTotal() {
		return _factLibraryVisitor.getSessionTotal();
	}

	/**
	* Sets the session total of this fact library visitor.
	*
	* @param sessionTotal the session total of this fact library visitor
	*/
	@Override
	public void setSessionTotal(long sessionTotal) {
		_factLibraryVisitor.setSessionTotal(sessionTotal);
	}

	/**
	* Returns the visitor total of this fact library visitor.
	*
	* @return the visitor total of this fact library visitor
	*/
	@Override
	public long getVisitorTotal() {
		return _factLibraryVisitor.getVisitorTotal();
	}

	/**
	* Sets the visitor total of this fact library visitor.
	*
	* @param visitorTotal the visitor total of this fact library visitor
	*/
	@Override
	public void setVisitorTotal(long visitorTotal) {
		_factLibraryVisitor.setVisitorTotal(visitorTotal);
	}

	/**
	* Returns the company ID of this fact library visitor.
	*
	* @return the company ID of this fact library visitor
	*/
	@Override
	public long getCompanyId() {
		return _factLibraryVisitor.getCompanyId();
	}

	/**
	* Sets the company ID of this fact library visitor.
	*
	* @param companyId the company ID of this fact library visitor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factLibraryVisitor.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact library visitor.
	*
	* @return the group ID of this fact library visitor
	*/
	@Override
	public long getGroupId() {
		return _factLibraryVisitor.getGroupId();
	}

	/**
	* Sets the group ID of this fact library visitor.
	*
	* @param groupId the group ID of this fact library visitor
	*/
	@Override
	public void setGroupId(long groupId) {
		_factLibraryVisitor.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact library visitor.
	*
	* @return the user ID of this fact library visitor
	*/
	@Override
	public long getUserId() {
		return _factLibraryVisitor.getUserId();
	}

	/**
	* Sets the user ID of this fact library visitor.
	*
	* @param userId the user ID of this fact library visitor
	*/
	@Override
	public void setUserId(long userId) {
		_factLibraryVisitor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact library visitor.
	*
	* @return the user uuid of this fact library visitor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factLibraryVisitor.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact library visitor.
	*
	* @param userUuid the user uuid of this fact library visitor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factLibraryVisitor.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact library visitor.
	*
	* @return the user name of this fact library visitor
	*/
	@Override
	public java.lang.String getUserName() {
		return _factLibraryVisitor.getUserName();
	}

	/**
	* Sets the user name of this fact library visitor.
	*
	* @param userName the user name of this fact library visitor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factLibraryVisitor.setUserName(userName);
	}

	/**
	* Returns the create date of this fact library visitor.
	*
	* @return the create date of this fact library visitor
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factLibraryVisitor.getCreateDate();
	}

	/**
	* Sets the create date of this fact library visitor.
	*
	* @param createDate the create date of this fact library visitor
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factLibraryVisitor.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factLibraryVisitor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factLibraryVisitor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factLibraryVisitor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factLibraryVisitor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factLibraryVisitor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factLibraryVisitor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factLibraryVisitor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factLibraryVisitor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factLibraryVisitor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factLibraryVisitor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factLibraryVisitor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactLibraryVisitorWrapper((FactLibraryVisitor)_factLibraryVisitor.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactLibraryVisitor factLibraryVisitor) {
		return _factLibraryVisitor.compareTo(factLibraryVisitor);
	}

	@Override
	public int hashCode() {
		return _factLibraryVisitor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactLibraryVisitor> toCacheModel() {
		return _factLibraryVisitor.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactLibraryVisitor toEscapedModel() {
		return new FactLibraryVisitorWrapper(_factLibraryVisitor.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactLibraryVisitor toUnescapedModel() {
		return new FactLibraryVisitorWrapper(_factLibraryVisitor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factLibraryVisitor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factLibraryVisitor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factLibraryVisitor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactLibraryVisitorWrapper)) {
			return false;
		}

		FactLibraryVisitorWrapper factLibraryVisitorWrapper = (FactLibraryVisitorWrapper)obj;

		if (Validator.equals(_factLibraryVisitor,
					factLibraryVisitorWrapper._factLibraryVisitor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactLibraryVisitor getWrappedFactLibraryVisitor() {
		return _factLibraryVisitor;
	}

	@Override
	public FactLibraryVisitor getWrappedModel() {
		return _factLibraryVisitor;
	}

	@Override
	public void resetOriginalValues() {
		_factLibraryVisitor.resetOriginalValues();
	}

	private FactLibraryVisitor _factLibraryVisitor;
}
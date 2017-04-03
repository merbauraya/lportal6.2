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
 * This class is a wrapper for {@link FactMembership}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactMembership
 * @generated
 */
public class FactMembershipWrapper implements FactMembership,
	ModelWrapper<FactMembership> {
	public FactMembershipWrapper(FactMembership factMembership) {
		_factMembership = factMembership;
	}

	@Override
	public Class<?> getModelClass() {
		return FactMembership.class;
	}

	@Override
	public String getModelClassName() {
		return FactMembership.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factMembershipId", getFactMembershipId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("membershipCategoryId", getMembershipCategoryId());
		attributes.put("activeCount", getActiveCount());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factMembershipId = (Long)attributes.get("factMembershipId");

		if (factMembershipId != null) {
			setFactMembershipId(factMembershipId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Long membershipCategoryId = (Long)attributes.get("membershipCategoryId");

		if (membershipCategoryId != null) {
			setMembershipCategoryId(membershipCategoryId);
		}

		Integer activeCount = (Integer)attributes.get("activeCount");

		if (activeCount != null) {
			setActiveCount(activeCount);
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
	* Returns the primary key of this fact membership.
	*
	* @return the primary key of this fact membership
	*/
	@Override
	public long getPrimaryKey() {
		return _factMembership.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact membership.
	*
	* @param primaryKey the primary key of this fact membership
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factMembership.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact membership ID of this fact membership.
	*
	* @return the fact membership ID of this fact membership
	*/
	@Override
	public long getFactMembershipId() {
		return _factMembership.getFactMembershipId();
	}

	/**
	* Sets the fact membership ID of this fact membership.
	*
	* @param factMembershipId the fact membership ID of this fact membership
	*/
	@Override
	public void setFactMembershipId(long factMembershipId) {
		_factMembership.setFactMembershipId(factMembershipId);
	}

	/**
	* Returns the library ID of this fact membership.
	*
	* @return the library ID of this fact membership
	*/
	@Override
	public long getLibraryId() {
		return _factMembership.getLibraryId();
	}

	/**
	* Sets the library ID of this fact membership.
	*
	* @param libraryId the library ID of this fact membership
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factMembership.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact membership.
	*
	* @return the period of this fact membership
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factMembership.getPeriod();
	}

	/**
	* Sets the period of this fact membership.
	*
	* @param period the period of this fact membership
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factMembership.setPeriod(period);
	}

	/**
	* Returns the state ID of this fact membership.
	*
	* @return the state ID of this fact membership
	*/
	@Override
	public long getStateId() {
		return _factMembership.getStateId();
	}

	/**
	* Sets the state ID of this fact membership.
	*
	* @param stateId the state ID of this fact membership
	*/
	@Override
	public void setStateId(long stateId) {
		_factMembership.setStateId(stateId);
	}

	/**
	* Returns the library type ID of this fact membership.
	*
	* @return the library type ID of this fact membership
	*/
	@Override
	public long getLibraryTypeId() {
		return _factMembership.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this fact membership.
	*
	* @param libraryTypeId the library type ID of this fact membership
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_factMembership.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the membership category ID of this fact membership.
	*
	* @return the membership category ID of this fact membership
	*/
	@Override
	public long getMembershipCategoryId() {
		return _factMembership.getMembershipCategoryId();
	}

	/**
	* Sets the membership category ID of this fact membership.
	*
	* @param membershipCategoryId the membership category ID of this fact membership
	*/
	@Override
	public void setMembershipCategoryId(long membershipCategoryId) {
		_factMembership.setMembershipCategoryId(membershipCategoryId);
	}

	/**
	* Returns the active count of this fact membership.
	*
	* @return the active count of this fact membership
	*/
	@Override
	public int getActiveCount() {
		return _factMembership.getActiveCount();
	}

	/**
	* Sets the active count of this fact membership.
	*
	* @param activeCount the active count of this fact membership
	*/
	@Override
	public void setActiveCount(int activeCount) {
		_factMembership.setActiveCount(activeCount);
	}

	/**
	* Returns the company ID of this fact membership.
	*
	* @return the company ID of this fact membership
	*/
	@Override
	public long getCompanyId() {
		return _factMembership.getCompanyId();
	}

	/**
	* Sets the company ID of this fact membership.
	*
	* @param companyId the company ID of this fact membership
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factMembership.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact membership.
	*
	* @return the group ID of this fact membership
	*/
	@Override
	public long getGroupId() {
		return _factMembership.getGroupId();
	}

	/**
	* Sets the group ID of this fact membership.
	*
	* @param groupId the group ID of this fact membership
	*/
	@Override
	public void setGroupId(long groupId) {
		_factMembership.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact membership.
	*
	* @return the user ID of this fact membership
	*/
	@Override
	public long getUserId() {
		return _factMembership.getUserId();
	}

	/**
	* Sets the user ID of this fact membership.
	*
	* @param userId the user ID of this fact membership
	*/
	@Override
	public void setUserId(long userId) {
		_factMembership.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact membership.
	*
	* @return the user uuid of this fact membership
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factMembership.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact membership.
	*
	* @param userUuid the user uuid of this fact membership
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factMembership.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact membership.
	*
	* @return the user name of this fact membership
	*/
	@Override
	public java.lang.String getUserName() {
		return _factMembership.getUserName();
	}

	/**
	* Sets the user name of this fact membership.
	*
	* @param userName the user name of this fact membership
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factMembership.setUserName(userName);
	}

	/**
	* Returns the create date of this fact membership.
	*
	* @return the create date of this fact membership
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factMembership.getCreateDate();
	}

	/**
	* Sets the create date of this fact membership.
	*
	* @param createDate the create date of this fact membership
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factMembership.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factMembership.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factMembership.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factMembership.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factMembership.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factMembership.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factMembership.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factMembership.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factMembership.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factMembership.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factMembership.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factMembership.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactMembershipWrapper((FactMembership)_factMembership.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactMembership factMembership) {
		return _factMembership.compareTo(factMembership);
	}

	@Override
	public int hashCode() {
		return _factMembership.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactMembership> toCacheModel() {
		return _factMembership.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactMembership toEscapedModel() {
		return new FactMembershipWrapper(_factMembership.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactMembership toUnescapedModel() {
		return new FactMembershipWrapper(_factMembership.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factMembership.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factMembership.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factMembership.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactMembershipWrapper)) {
			return false;
		}

		FactMembershipWrapper factMembershipWrapper = (FactMembershipWrapper)obj;

		if (Validator.equals(_factMembership,
					factMembershipWrapper._factMembership)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactMembership getWrappedFactMembership() {
		return _factMembership;
	}

	@Override
	public FactMembership getWrappedModel() {
		return _factMembership;
	}

	@Override
	public void resetOriginalValues() {
		_factMembership.resetOriginalValues();
	}

	private FactMembership _factMembership;
}
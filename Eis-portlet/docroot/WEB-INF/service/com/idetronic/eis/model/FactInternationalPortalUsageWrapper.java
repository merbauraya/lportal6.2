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
 * This class is a wrapper for {@link FactInternationalPortalUsage}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactInternationalPortalUsage
 * @generated
 */
public class FactInternationalPortalUsageWrapper
	implements FactInternationalPortalUsage,
		ModelWrapper<FactInternationalPortalUsage> {
	public FactInternationalPortalUsageWrapper(
		FactInternationalPortalUsage factInternationalPortalUsage) {
		_factInternationalPortalUsage = factInternationalPortalUsage;
	}

	@Override
	public Class<?> getModelClass() {
		return FactInternationalPortalUsage.class;
	}

	@Override
	public String getModelClassName() {
		return FactInternationalPortalUsage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("period", getPeriod());
		attributes.put("countryId", getCountryId());
		attributes.put("pagesTotal", getPagesTotal());
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

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long pagesTotal = (Long)attributes.get("pagesTotal");

		if (pagesTotal != null) {
			setPagesTotal(pagesTotal);
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
	* Returns the primary key of this fact international portal usage.
	*
	* @return the primary key of this fact international portal usage
	*/
	@Override
	public long getPrimaryKey() {
		return _factInternationalPortalUsage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact international portal usage.
	*
	* @param primaryKey the primary key of this fact international portal usage
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factInternationalPortalUsage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact international portal usage.
	*
	* @return the fact ID of this fact international portal usage
	*/
	@Override
	public long getFactId() {
		return _factInternationalPortalUsage.getFactId();
	}

	/**
	* Sets the fact ID of this fact international portal usage.
	*
	* @param factId the fact ID of this fact international portal usage
	*/
	@Override
	public void setFactId(long factId) {
		_factInternationalPortalUsage.setFactId(factId);
	}

	/**
	* Returns the period of this fact international portal usage.
	*
	* @return the period of this fact international portal usage
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factInternationalPortalUsage.getPeriod();
	}

	/**
	* Sets the period of this fact international portal usage.
	*
	* @param period the period of this fact international portal usage
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factInternationalPortalUsage.setPeriod(period);
	}

	/**
	* Returns the country ID of this fact international portal usage.
	*
	* @return the country ID of this fact international portal usage
	*/
	@Override
	public long getCountryId() {
		return _factInternationalPortalUsage.getCountryId();
	}

	/**
	* Sets the country ID of this fact international portal usage.
	*
	* @param countryId the country ID of this fact international portal usage
	*/
	@Override
	public void setCountryId(long countryId) {
		_factInternationalPortalUsage.setCountryId(countryId);
	}

	/**
	* Returns the pages total of this fact international portal usage.
	*
	* @return the pages total of this fact international portal usage
	*/
	@Override
	public long getPagesTotal() {
		return _factInternationalPortalUsage.getPagesTotal();
	}

	/**
	* Sets the pages total of this fact international portal usage.
	*
	* @param pagesTotal the pages total of this fact international portal usage
	*/
	@Override
	public void setPagesTotal(long pagesTotal) {
		_factInternationalPortalUsage.setPagesTotal(pagesTotal);
	}

	/**
	* Returns the company ID of this fact international portal usage.
	*
	* @return the company ID of this fact international portal usage
	*/
	@Override
	public long getCompanyId() {
		return _factInternationalPortalUsage.getCompanyId();
	}

	/**
	* Sets the company ID of this fact international portal usage.
	*
	* @param companyId the company ID of this fact international portal usage
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factInternationalPortalUsage.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact international portal usage.
	*
	* @return the group ID of this fact international portal usage
	*/
	@Override
	public long getGroupId() {
		return _factInternationalPortalUsage.getGroupId();
	}

	/**
	* Sets the group ID of this fact international portal usage.
	*
	* @param groupId the group ID of this fact international portal usage
	*/
	@Override
	public void setGroupId(long groupId) {
		_factInternationalPortalUsage.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact international portal usage.
	*
	* @return the user ID of this fact international portal usage
	*/
	@Override
	public long getUserId() {
		return _factInternationalPortalUsage.getUserId();
	}

	/**
	* Sets the user ID of this fact international portal usage.
	*
	* @param userId the user ID of this fact international portal usage
	*/
	@Override
	public void setUserId(long userId) {
		_factInternationalPortalUsage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact international portal usage.
	*
	* @return the user uuid of this fact international portal usage
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInternationalPortalUsage.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact international portal usage.
	*
	* @param userUuid the user uuid of this fact international portal usage
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factInternationalPortalUsage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact international portal usage.
	*
	* @return the user name of this fact international portal usage
	*/
	@Override
	public java.lang.String getUserName() {
		return _factInternationalPortalUsage.getUserName();
	}

	/**
	* Sets the user name of this fact international portal usage.
	*
	* @param userName the user name of this fact international portal usage
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factInternationalPortalUsage.setUserName(userName);
	}

	/**
	* Returns the create date of this fact international portal usage.
	*
	* @return the create date of this fact international portal usage
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factInternationalPortalUsage.getCreateDate();
	}

	/**
	* Sets the create date of this fact international portal usage.
	*
	* @param createDate the create date of this fact international portal usage
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factInternationalPortalUsage.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factInternationalPortalUsage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factInternationalPortalUsage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factInternationalPortalUsage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factInternationalPortalUsage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factInternationalPortalUsage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factInternationalPortalUsage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factInternationalPortalUsage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factInternationalPortalUsage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factInternationalPortalUsage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factInternationalPortalUsage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factInternationalPortalUsage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactInternationalPortalUsageWrapper((FactInternationalPortalUsage)_factInternationalPortalUsage.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactInternationalPortalUsage factInternationalPortalUsage) {
		return _factInternationalPortalUsage.compareTo(factInternationalPortalUsage);
	}

	@Override
	public int hashCode() {
		return _factInternationalPortalUsage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactInternationalPortalUsage> toCacheModel() {
		return _factInternationalPortalUsage.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactInternationalPortalUsage toEscapedModel() {
		return new FactInternationalPortalUsageWrapper(_factInternationalPortalUsage.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactInternationalPortalUsage toUnescapedModel() {
		return new FactInternationalPortalUsageWrapper(_factInternationalPortalUsage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factInternationalPortalUsage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factInternationalPortalUsage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factInternationalPortalUsage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactInternationalPortalUsageWrapper)) {
			return false;
		}

		FactInternationalPortalUsageWrapper factInternationalPortalUsageWrapper = (FactInternationalPortalUsageWrapper)obj;

		if (Validator.equals(_factInternationalPortalUsage,
					factInternationalPortalUsageWrapper._factInternationalPortalUsage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactInternationalPortalUsage getWrappedFactInternationalPortalUsage() {
		return _factInternationalPortalUsage;
	}

	@Override
	public FactInternationalPortalUsage getWrappedModel() {
		return _factInternationalPortalUsage;
	}

	@Override
	public void resetOriginalValues() {
		_factInternationalPortalUsage.resetOriginalValues();
	}

	private FactInternationalPortalUsage _factInternationalPortalUsage;
}
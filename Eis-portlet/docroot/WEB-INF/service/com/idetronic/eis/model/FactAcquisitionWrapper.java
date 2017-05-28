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
 * This class is a wrapper for {@link FactAcquisition}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactAcquisition
 * @generated
 */
public class FactAcquisitionWrapper implements FactAcquisition,
	ModelWrapper<FactAcquisition> {
	public FactAcquisitionWrapper(FactAcquisition factAcquisition) {
		_factAcquisition = factAcquisition;
	}

	@Override
	public Class<?> getModelClass() {
		return FactAcquisition.class;
	}

	@Override
	public String getModelClassName() {
		return FactAcquisition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factAcquisitionId", getFactAcquisitionId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factAcquisitionId = (Long)attributes.get("factAcquisitionId");

		if (factAcquisitionId != null) {
			setFactAcquisitionId(factAcquisitionId);
		}

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long volumeTotal = (Long)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
		}

		Long titleTotal = (Long)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
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
	* Returns the primary key of this fact acquisition.
	*
	* @return the primary key of this fact acquisition
	*/
	@Override
	public long getPrimaryKey() {
		return _factAcquisition.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact acquisition.
	*
	* @param primaryKey the primary key of this fact acquisition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factAcquisition.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact acquisition ID of this fact acquisition.
	*
	* @return the fact acquisition ID of this fact acquisition
	*/
	@Override
	public long getFactAcquisitionId() {
		return _factAcquisition.getFactAcquisitionId();
	}

	/**
	* Sets the fact acquisition ID of this fact acquisition.
	*
	* @param factAcquisitionId the fact acquisition ID of this fact acquisition
	*/
	@Override
	public void setFactAcquisitionId(long factAcquisitionId) {
		_factAcquisition.setFactAcquisitionId(factAcquisitionId);
	}

	/**
	* Returns the faculty ID of this fact acquisition.
	*
	* @return the faculty ID of this fact acquisition
	*/
	@Override
	public long getFacultyId() {
		return _factAcquisition.getFacultyId();
	}

	/**
	* Sets the faculty ID of this fact acquisition.
	*
	* @param facultyId the faculty ID of this fact acquisition
	*/
	@Override
	public void setFacultyId(long facultyId) {
		_factAcquisition.setFacultyId(facultyId);
	}

	/**
	* Returns the period of this fact acquisition.
	*
	* @return the period of this fact acquisition
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factAcquisition.getPeriod();
	}

	/**
	* Sets the period of this fact acquisition.
	*
	* @param period the period of this fact acquisition
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factAcquisition.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact acquisition.
	*
	* @return the item ID of this fact acquisition
	*/
	@Override
	public long getItemId() {
		return _factAcquisition.getItemId();
	}

	/**
	* Sets the item ID of this fact acquisition.
	*
	* @param itemId the item ID of this fact acquisition
	*/
	@Override
	public void setItemId(long itemId) {
		_factAcquisition.setItemId(itemId);
	}

	/**
	* Returns the volume total of this fact acquisition.
	*
	* @return the volume total of this fact acquisition
	*/
	@Override
	public long getVolumeTotal() {
		return _factAcquisition.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact acquisition.
	*
	* @param volumeTotal the volume total of this fact acquisition
	*/
	@Override
	public void setVolumeTotal(long volumeTotal) {
		_factAcquisition.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the title total of this fact acquisition.
	*
	* @return the title total of this fact acquisition
	*/
	@Override
	public long getTitleTotal() {
		return _factAcquisition.getTitleTotal();
	}

	/**
	* Sets the title total of this fact acquisition.
	*
	* @param titleTotal the title total of this fact acquisition
	*/
	@Override
	public void setTitleTotal(long titleTotal) {
		_factAcquisition.setTitleTotal(titleTotal);
	}

	/**
	* Returns the company ID of this fact acquisition.
	*
	* @return the company ID of this fact acquisition
	*/
	@Override
	public long getCompanyId() {
		return _factAcquisition.getCompanyId();
	}

	/**
	* Sets the company ID of this fact acquisition.
	*
	* @param companyId the company ID of this fact acquisition
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factAcquisition.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact acquisition.
	*
	* @return the group ID of this fact acquisition
	*/
	@Override
	public long getGroupId() {
		return _factAcquisition.getGroupId();
	}

	/**
	* Sets the group ID of this fact acquisition.
	*
	* @param groupId the group ID of this fact acquisition
	*/
	@Override
	public void setGroupId(long groupId) {
		_factAcquisition.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact acquisition.
	*
	* @return the user ID of this fact acquisition
	*/
	@Override
	public long getUserId() {
		return _factAcquisition.getUserId();
	}

	/**
	* Sets the user ID of this fact acquisition.
	*
	* @param userId the user ID of this fact acquisition
	*/
	@Override
	public void setUserId(long userId) {
		_factAcquisition.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact acquisition.
	*
	* @return the user uuid of this fact acquisition
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisition.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact acquisition.
	*
	* @param userUuid the user uuid of this fact acquisition
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factAcquisition.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact acquisition.
	*
	* @return the user name of this fact acquisition
	*/
	@Override
	public java.lang.String getUserName() {
		return _factAcquisition.getUserName();
	}

	/**
	* Sets the user name of this fact acquisition.
	*
	* @param userName the user name of this fact acquisition
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factAcquisition.setUserName(userName);
	}

	/**
	* Returns the create date of this fact acquisition.
	*
	* @return the create date of this fact acquisition
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factAcquisition.getCreateDate();
	}

	/**
	* Sets the create date of this fact acquisition.
	*
	* @param createDate the create date of this fact acquisition
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factAcquisition.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factAcquisition.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factAcquisition.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factAcquisition.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factAcquisition.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factAcquisition.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factAcquisition.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factAcquisition.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factAcquisition.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factAcquisition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factAcquisition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factAcquisition.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactAcquisitionWrapper((FactAcquisition)_factAcquisition.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactAcquisition factAcquisition) {
		return _factAcquisition.compareTo(factAcquisition);
	}

	@Override
	public int hashCode() {
		return _factAcquisition.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactAcquisition> toCacheModel() {
		return _factAcquisition.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactAcquisition toEscapedModel() {
		return new FactAcquisitionWrapper(_factAcquisition.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactAcquisition toUnescapedModel() {
		return new FactAcquisitionWrapper(_factAcquisition.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factAcquisition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factAcquisition.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factAcquisition.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactAcquisitionWrapper)) {
			return false;
		}

		FactAcquisitionWrapper factAcquisitionWrapper = (FactAcquisitionWrapper)obj;

		if (Validator.equals(_factAcquisition,
					factAcquisitionWrapper._factAcquisition)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactAcquisition getWrappedFactAcquisition() {
		return _factAcquisition;
	}

	@Override
	public FactAcquisition getWrappedModel() {
		return _factAcquisition;
	}

	@Override
	public void resetOriginalValues() {
		_factAcquisition.resetOriginalValues();
	}

	private FactAcquisition _factAcquisition;
}
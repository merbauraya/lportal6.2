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
 * This class is a wrapper for {@link FactGiftReceived}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactGiftReceived
 * @generated
 */
public class FactGiftReceivedWrapper implements FactGiftReceived,
	ModelWrapper<FactGiftReceived> {
	public FactGiftReceivedWrapper(FactGiftReceived factGiftReceived) {
		_factGiftReceived = factGiftReceived;
	}

	@Override
	public Class<?> getModelClass() {
		return FactGiftReceived.class;
	}

	@Override
	public String getModelClassName() {
		return FactGiftReceived.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("itemId", getItemId());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
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

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long titleTotal = (Long)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Long volumeTotal = (Long)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
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
	* Returns the primary key of this fact gift received.
	*
	* @return the primary key of this fact gift received
	*/
	@Override
	public long getPrimaryKey() {
		return _factGiftReceived.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact gift received.
	*
	* @param primaryKey the primary key of this fact gift received
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factGiftReceived.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact gift received.
	*
	* @return the fact ID of this fact gift received
	*/
	@Override
	public long getFactId() {
		return _factGiftReceived.getFactId();
	}

	/**
	* Sets the fact ID of this fact gift received.
	*
	* @param factId the fact ID of this fact gift received
	*/
	@Override
	public void setFactId(long factId) {
		_factGiftReceived.setFactId(factId);
	}

	/**
	* Returns the library ID of this fact gift received.
	*
	* @return the library ID of this fact gift received
	*/
	@Override
	public long getLibraryId() {
		return _factGiftReceived.getLibraryId();
	}

	/**
	* Sets the library ID of this fact gift received.
	*
	* @param libraryId the library ID of this fact gift received
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factGiftReceived.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact gift received.
	*
	* @return the period of this fact gift received
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factGiftReceived.getPeriod();
	}

	/**
	* Sets the period of this fact gift received.
	*
	* @param period the period of this fact gift received
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factGiftReceived.setPeriod(period);
	}

	/**
	* Returns the item ID of this fact gift received.
	*
	* @return the item ID of this fact gift received
	*/
	@Override
	public long getItemId() {
		return _factGiftReceived.getItemId();
	}

	/**
	* Sets the item ID of this fact gift received.
	*
	* @param itemId the item ID of this fact gift received
	*/
	@Override
	public void setItemId(long itemId) {
		_factGiftReceived.setItemId(itemId);
	}

	/**
	* Returns the title total of this fact gift received.
	*
	* @return the title total of this fact gift received
	*/
	@Override
	public long getTitleTotal() {
		return _factGiftReceived.getTitleTotal();
	}

	/**
	* Sets the title total of this fact gift received.
	*
	* @param titleTotal the title total of this fact gift received
	*/
	@Override
	public void setTitleTotal(long titleTotal) {
		_factGiftReceived.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact gift received.
	*
	* @return the volume total of this fact gift received
	*/
	@Override
	public long getVolumeTotal() {
		return _factGiftReceived.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact gift received.
	*
	* @param volumeTotal the volume total of this fact gift received
	*/
	@Override
	public void setVolumeTotal(long volumeTotal) {
		_factGiftReceived.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the company ID of this fact gift received.
	*
	* @return the company ID of this fact gift received
	*/
	@Override
	public long getCompanyId() {
		return _factGiftReceived.getCompanyId();
	}

	/**
	* Sets the company ID of this fact gift received.
	*
	* @param companyId the company ID of this fact gift received
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factGiftReceived.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact gift received.
	*
	* @return the group ID of this fact gift received
	*/
	@Override
	public long getGroupId() {
		return _factGiftReceived.getGroupId();
	}

	/**
	* Sets the group ID of this fact gift received.
	*
	* @param groupId the group ID of this fact gift received
	*/
	@Override
	public void setGroupId(long groupId) {
		_factGiftReceived.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact gift received.
	*
	* @return the user ID of this fact gift received
	*/
	@Override
	public long getUserId() {
		return _factGiftReceived.getUserId();
	}

	/**
	* Sets the user ID of this fact gift received.
	*
	* @param userId the user ID of this fact gift received
	*/
	@Override
	public void setUserId(long userId) {
		_factGiftReceived.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact gift received.
	*
	* @return the user uuid of this fact gift received
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceived.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact gift received.
	*
	* @param userUuid the user uuid of this fact gift received
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factGiftReceived.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact gift received.
	*
	* @return the user name of this fact gift received
	*/
	@Override
	public java.lang.String getUserName() {
		return _factGiftReceived.getUserName();
	}

	/**
	* Sets the user name of this fact gift received.
	*
	* @param userName the user name of this fact gift received
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factGiftReceived.setUserName(userName);
	}

	/**
	* Returns the create date of this fact gift received.
	*
	* @return the create date of this fact gift received
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factGiftReceived.getCreateDate();
	}

	/**
	* Sets the create date of this fact gift received.
	*
	* @param createDate the create date of this fact gift received
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factGiftReceived.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factGiftReceived.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factGiftReceived.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factGiftReceived.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factGiftReceived.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factGiftReceived.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factGiftReceived.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factGiftReceived.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factGiftReceived.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factGiftReceived.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factGiftReceived.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factGiftReceived.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactGiftReceivedWrapper((FactGiftReceived)_factGiftReceived.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactGiftReceived factGiftReceived) {
		return _factGiftReceived.compareTo(factGiftReceived);
	}

	@Override
	public int hashCode() {
		return _factGiftReceived.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactGiftReceived> toCacheModel() {
		return _factGiftReceived.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactGiftReceived toEscapedModel() {
		return new FactGiftReceivedWrapper(_factGiftReceived.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactGiftReceived toUnescapedModel() {
		return new FactGiftReceivedWrapper(_factGiftReceived.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factGiftReceived.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factGiftReceived.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factGiftReceived.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactGiftReceivedWrapper)) {
			return false;
		}

		FactGiftReceivedWrapper factGiftReceivedWrapper = (FactGiftReceivedWrapper)obj;

		if (Validator.equals(_factGiftReceived,
					factGiftReceivedWrapper._factGiftReceived)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactGiftReceived getWrappedFactGiftReceived() {
		return _factGiftReceived;
	}

	@Override
	public FactGiftReceived getWrappedModel() {
		return _factGiftReceived;
	}

	@Override
	public void resetOriginalValues() {
		_factGiftReceived.resetOriginalValues();
	}

	private FactGiftReceived _factGiftReceived;
}
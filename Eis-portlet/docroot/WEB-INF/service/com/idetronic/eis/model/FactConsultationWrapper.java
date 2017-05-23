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
 * This class is a wrapper for {@link FactConsultation}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactConsultation
 * @generated
 */
public class FactConsultationWrapper implements FactConsultation,
	ModelWrapper<FactConsultation> {
	public FactConsultationWrapper(FactConsultation factConsultation) {
		_factConsultation = factConsultation;
	}

	@Override
	public Class<?> getModelClass() {
		return FactConsultation.class;
	}

	@Override
	public String getModelClassName() {
		return FactConsultation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factConsultationId", getFactConsultationId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("consultationGroupId", getConsultationGroupId());
		attributes.put("consultationCategoryId", getConsultationCategoryId());
		attributes.put("value", getValue());
		attributes.put("totalSession", getTotalSession());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factConsultationId = (Long)attributes.get("factConsultationId");

		if (factConsultationId != null) {
			setFactConsultationId(factConsultationId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long consultationGroupId = (Long)attributes.get("consultationGroupId");

		if (consultationGroupId != null) {
			setConsultationGroupId(consultationGroupId);
		}

		Long consultationCategoryId = (Long)attributes.get(
				"consultationCategoryId");

		if (consultationCategoryId != null) {
			setConsultationCategoryId(consultationCategoryId);
		}

		Long value = (Long)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Long totalSession = (Long)attributes.get("totalSession");

		if (totalSession != null) {
			setTotalSession(totalSession);
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
	* Returns the primary key of this fact consultation.
	*
	* @return the primary key of this fact consultation
	*/
	@Override
	public long getPrimaryKey() {
		return _factConsultation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact consultation.
	*
	* @param primaryKey the primary key of this fact consultation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factConsultation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact consultation ID of this fact consultation.
	*
	* @return the fact consultation ID of this fact consultation
	*/
	@Override
	public long getFactConsultationId() {
		return _factConsultation.getFactConsultationId();
	}

	/**
	* Sets the fact consultation ID of this fact consultation.
	*
	* @param factConsultationId the fact consultation ID of this fact consultation
	*/
	@Override
	public void setFactConsultationId(long factConsultationId) {
		_factConsultation.setFactConsultationId(factConsultationId);
	}

	/**
	* Returns the library ID of this fact consultation.
	*
	* @return the library ID of this fact consultation
	*/
	@Override
	public long getLibraryId() {
		return _factConsultation.getLibraryId();
	}

	/**
	* Sets the library ID of this fact consultation.
	*
	* @param libraryId the library ID of this fact consultation
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factConsultation.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact consultation.
	*
	* @return the period of this fact consultation
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factConsultation.getPeriod();
	}

	/**
	* Sets the period of this fact consultation.
	*
	* @param period the period of this fact consultation
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factConsultation.setPeriod(period);
	}

	/**
	* Returns the consultation group ID of this fact consultation.
	*
	* @return the consultation group ID of this fact consultation
	*/
	@Override
	public long getConsultationGroupId() {
		return _factConsultation.getConsultationGroupId();
	}

	/**
	* Sets the consultation group ID of this fact consultation.
	*
	* @param consultationGroupId the consultation group ID of this fact consultation
	*/
	@Override
	public void setConsultationGroupId(long consultationGroupId) {
		_factConsultation.setConsultationGroupId(consultationGroupId);
	}

	/**
	* Returns the consultation category ID of this fact consultation.
	*
	* @return the consultation category ID of this fact consultation
	*/
	@Override
	public long getConsultationCategoryId() {
		return _factConsultation.getConsultationCategoryId();
	}

	/**
	* Sets the consultation category ID of this fact consultation.
	*
	* @param consultationCategoryId the consultation category ID of this fact consultation
	*/
	@Override
	public void setConsultationCategoryId(long consultationCategoryId) {
		_factConsultation.setConsultationCategoryId(consultationCategoryId);
	}

	/**
	* Returns the value of this fact consultation.
	*
	* @return the value of this fact consultation
	*/
	@Override
	public long getValue() {
		return _factConsultation.getValue();
	}

	/**
	* Sets the value of this fact consultation.
	*
	* @param value the value of this fact consultation
	*/
	@Override
	public void setValue(long value) {
		_factConsultation.setValue(value);
	}

	/**
	* Returns the total session of this fact consultation.
	*
	* @return the total session of this fact consultation
	*/
	@Override
	public long getTotalSession() {
		return _factConsultation.getTotalSession();
	}

	/**
	* Sets the total session of this fact consultation.
	*
	* @param totalSession the total session of this fact consultation
	*/
	@Override
	public void setTotalSession(long totalSession) {
		_factConsultation.setTotalSession(totalSession);
	}

	/**
	* Returns the company ID of this fact consultation.
	*
	* @return the company ID of this fact consultation
	*/
	@Override
	public long getCompanyId() {
		return _factConsultation.getCompanyId();
	}

	/**
	* Sets the company ID of this fact consultation.
	*
	* @param companyId the company ID of this fact consultation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factConsultation.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact consultation.
	*
	* @return the group ID of this fact consultation
	*/
	@Override
	public long getGroupId() {
		return _factConsultation.getGroupId();
	}

	/**
	* Sets the group ID of this fact consultation.
	*
	* @param groupId the group ID of this fact consultation
	*/
	@Override
	public void setGroupId(long groupId) {
		_factConsultation.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact consultation.
	*
	* @return the user ID of this fact consultation
	*/
	@Override
	public long getUserId() {
		return _factConsultation.getUserId();
	}

	/**
	* Sets the user ID of this fact consultation.
	*
	* @param userId the user ID of this fact consultation
	*/
	@Override
	public void setUserId(long userId) {
		_factConsultation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact consultation.
	*
	* @return the user uuid of this fact consultation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultation.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact consultation.
	*
	* @param userUuid the user uuid of this fact consultation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factConsultation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact consultation.
	*
	* @return the user name of this fact consultation
	*/
	@Override
	public java.lang.String getUserName() {
		return _factConsultation.getUserName();
	}

	/**
	* Sets the user name of this fact consultation.
	*
	* @param userName the user name of this fact consultation
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factConsultation.setUserName(userName);
	}

	/**
	* Returns the create date of this fact consultation.
	*
	* @return the create date of this fact consultation
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factConsultation.getCreateDate();
	}

	/**
	* Sets the create date of this fact consultation.
	*
	* @param createDate the create date of this fact consultation
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factConsultation.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factConsultation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factConsultation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factConsultation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factConsultation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factConsultation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factConsultation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factConsultation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factConsultation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factConsultation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factConsultation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factConsultation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactConsultationWrapper((FactConsultation)_factConsultation.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactConsultation factConsultation) {
		return _factConsultation.compareTo(factConsultation);
	}

	@Override
	public int hashCode() {
		return _factConsultation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactConsultation> toCacheModel() {
		return _factConsultation.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactConsultation toEscapedModel() {
		return new FactConsultationWrapper(_factConsultation.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactConsultation toUnescapedModel() {
		return new FactConsultationWrapper(_factConsultation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factConsultation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factConsultation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factConsultation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactConsultationWrapper)) {
			return false;
		}

		FactConsultationWrapper factConsultationWrapper = (FactConsultationWrapper)obj;

		if (Validator.equals(_factConsultation,
					factConsultationWrapper._factConsultation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactConsultation getWrappedFactConsultation() {
		return _factConsultation;
	}

	@Override
	public FactConsultation getWrappedModel() {
		return _factConsultation;
	}

	@Override
	public void resetOriginalValues() {
		_factConsultation.resetOriginalValues();
	}

	private FactConsultation _factConsultation;
}
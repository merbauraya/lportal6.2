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
 * This class is a wrapper for {@link UserReport}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserReport
 * @generated
 */
public class UserReportWrapper implements UserReport, ModelWrapper<UserReport> {
	public UserReportWrapper(UserReport userReport) {
		_userReport = userReport;
	}

	@Override
	public Class<?> getModelClass() {
		return UserReport.class;
	}

	@Override
	public String getModelClassName() {
		return UserReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userReportId", getUserReportId());
		attributes.put("userId", getUserId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("reportId", getReportId());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userReportId = (Long)attributes.get("userReportId");

		if (userReportId != null) {
			setUserReportId(userReportId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
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
	* Returns the primary key of this user report.
	*
	* @return the primary key of this user report
	*/
	@Override
	public long getPrimaryKey() {
		return _userReport.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user report.
	*
	* @param primaryKey the primary key of this user report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userReport.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user report ID of this user report.
	*
	* @return the user report ID of this user report
	*/
	@Override
	public long getUserReportId() {
		return _userReport.getUserReportId();
	}

	/**
	* Sets the user report ID of this user report.
	*
	* @param userReportId the user report ID of this user report
	*/
	@Override
	public void setUserReportId(long userReportId) {
		_userReport.setUserReportId(userReportId);
	}

	/**
	* Returns the user ID of this user report.
	*
	* @return the user ID of this user report
	*/
	@Override
	public long getUserId() {
		return _userReport.getUserId();
	}

	/**
	* Sets the user ID of this user report.
	*
	* @param userId the user ID of this user report
	*/
	@Override
	public void setUserId(long userId) {
		_userReport.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user report.
	*
	* @return the user uuid of this user report
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userReport.getUserUuid();
	}

	/**
	* Sets the user uuid of this user report.
	*
	* @param userUuid the user uuid of this user report
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userReport.setUserUuid(userUuid);
	}

	/**
	* Returns the library ID of this user report.
	*
	* @return the library ID of this user report
	*/
	@Override
	public long getLibraryId() {
		return _userReport.getLibraryId();
	}

	/**
	* Sets the library ID of this user report.
	*
	* @param libraryId the library ID of this user report
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_userReport.setLibraryId(libraryId);
	}

	/**
	* Returns the report ID of this user report.
	*
	* @return the report ID of this user report
	*/
	@Override
	public long getReportId() {
		return _userReport.getReportId();
	}

	/**
	* Sets the report ID of this user report.
	*
	* @param reportId the report ID of this user report
	*/
	@Override
	public void setReportId(long reportId) {
		_userReport.setReportId(reportId);
	}

	/**
	* Returns the created by user ID of this user report.
	*
	* @return the created by user ID of this user report
	*/
	@Override
	public long getCreatedByUserId() {
		return _userReport.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this user report.
	*
	* @param createdByUserId the created by user ID of this user report
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_userReport.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this user report.
	*
	* @return the created by user uuid of this user report
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userReport.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this user report.
	*
	* @param createdByUserUuid the created by user uuid of this user report
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_userReport.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the user name of this user report.
	*
	* @return the user name of this user report
	*/
	@Override
	public java.lang.String getUserName() {
		return _userReport.getUserName();
	}

	/**
	* Sets the user name of this user report.
	*
	* @param userName the user name of this user report
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userReport.setUserName(userName);
	}

	/**
	* Returns the create date of this user report.
	*
	* @return the create date of this user report
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userReport.getCreateDate();
	}

	/**
	* Sets the create date of this user report.
	*
	* @param createDate the create date of this user report
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userReport.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _userReport.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userReport.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userReport.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userReport.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userReport.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userReport.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userReport.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userReport.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userReport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userReport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userReport.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserReportWrapper((UserReport)_userReport.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.UserReport userReport) {
		return _userReport.compareTo(userReport);
	}

	@Override
	public int hashCode() {
		return _userReport.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.UserReport> toCacheModel() {
		return _userReport.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.UserReport toEscapedModel() {
		return new UserReportWrapper(_userReport.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.UserReport toUnescapedModel() {
		return new UserReportWrapper(_userReport.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userReport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userReport.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userReport.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserReportWrapper)) {
			return false;
		}

		UserReportWrapper userReportWrapper = (UserReportWrapper)obj;

		if (Validator.equals(_userReport, userReportWrapper._userReport)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserReport getWrappedUserReport() {
		return _userReport;
	}

	@Override
	public UserReport getWrappedModel() {
		return _userReport;
	}

	@Override
	public void resetOriginalValues() {
		_userReport.resetOriginalValues();
	}

	private UserReport _userReport;
}
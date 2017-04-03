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
 * This class is a wrapper for {@link FactIrSubmission}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrSubmission
 * @generated
 */
public class FactIrSubmissionWrapper implements FactIrSubmission,
	ModelWrapper<FactIrSubmission> {
	public FactIrSubmissionWrapper(FactIrSubmission factIrSubmission) {
		_factIrSubmission = factIrSubmission;
	}

	@Override
	public Class<?> getModelClass() {
		return FactIrSubmission.class;
	}

	@Override
	public String getModelClassName() {
		return FactIrSubmission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionId", getSubmissionId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("period", getPeriod());
		attributes.put("itemMediumId", getItemMediumId());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long submissionId = (Long)attributes.get("submissionId");

		if (submissionId != null) {
			setSubmissionId(submissionId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemMediumId = (Long)attributes.get("itemMediumId");

		if (itemMediumId != null) {
			setItemMediumId(itemMediumId);
		}

		Integer titleTotal = (Integer)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Integer volumeTotal = (Integer)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
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
	* Returns the primary key of this fact ir submission.
	*
	* @return the primary key of this fact ir submission
	*/
	@Override
	public long getPrimaryKey() {
		return _factIrSubmission.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact ir submission.
	*
	* @param primaryKey the primary key of this fact ir submission
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factIrSubmission.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the submission ID of this fact ir submission.
	*
	* @return the submission ID of this fact ir submission
	*/
	@Override
	public long getSubmissionId() {
		return _factIrSubmission.getSubmissionId();
	}

	/**
	* Sets the submission ID of this fact ir submission.
	*
	* @param submissionId the submission ID of this fact ir submission
	*/
	@Override
	public void setSubmissionId(long submissionId) {
		_factIrSubmission.setSubmissionId(submissionId);
	}

	/**
	* Returns the library ID of this fact ir submission.
	*
	* @return the library ID of this fact ir submission
	*/
	@Override
	public long getLibraryId() {
		return _factIrSubmission.getLibraryId();
	}

	/**
	* Sets the library ID of this fact ir submission.
	*
	* @param libraryId the library ID of this fact ir submission
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factIrSubmission.setLibraryId(libraryId);
	}

	/**
	* Returns the faculty ID of this fact ir submission.
	*
	* @return the faculty ID of this fact ir submission
	*/
	@Override
	public long getFacultyId() {
		return _factIrSubmission.getFacultyId();
	}

	/**
	* Sets the faculty ID of this fact ir submission.
	*
	* @param facultyId the faculty ID of this fact ir submission
	*/
	@Override
	public void setFacultyId(long facultyId) {
		_factIrSubmission.setFacultyId(facultyId);
	}

	/**
	* Returns the period of this fact ir submission.
	*
	* @return the period of this fact ir submission
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factIrSubmission.getPeriod();
	}

	/**
	* Sets the period of this fact ir submission.
	*
	* @param period the period of this fact ir submission
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factIrSubmission.setPeriod(period);
	}

	/**
	* Returns the item medium ID of this fact ir submission.
	*
	* @return the item medium ID of this fact ir submission
	*/
	@Override
	public long getItemMediumId() {
		return _factIrSubmission.getItemMediumId();
	}

	/**
	* Sets the item medium ID of this fact ir submission.
	*
	* @param itemMediumId the item medium ID of this fact ir submission
	*/
	@Override
	public void setItemMediumId(long itemMediumId) {
		_factIrSubmission.setItemMediumId(itemMediumId);
	}

	/**
	* Returns the title total of this fact ir submission.
	*
	* @return the title total of this fact ir submission
	*/
	@Override
	public int getTitleTotal() {
		return _factIrSubmission.getTitleTotal();
	}

	/**
	* Sets the title total of this fact ir submission.
	*
	* @param titleTotal the title total of this fact ir submission
	*/
	@Override
	public void setTitleTotal(int titleTotal) {
		_factIrSubmission.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact ir submission.
	*
	* @return the volume total of this fact ir submission
	*/
	@Override
	public int getVolumeTotal() {
		return _factIrSubmission.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact ir submission.
	*
	* @param volumeTotal the volume total of this fact ir submission
	*/
	@Override
	public void setVolumeTotal(int volumeTotal) {
		_factIrSubmission.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the created by user ID of this fact ir submission.
	*
	* @return the created by user ID of this fact ir submission
	*/
	@Override
	public long getCreatedByUserId() {
		return _factIrSubmission.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this fact ir submission.
	*
	* @param createdByUserId the created by user ID of this fact ir submission
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_factIrSubmission.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this fact ir submission.
	*
	* @return the created by user uuid of this fact ir submission
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrSubmission.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this fact ir submission.
	*
	* @param createdByUserUuid the created by user uuid of this fact ir submission
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_factIrSubmission.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the created by user name of this fact ir submission.
	*
	* @return the created by user name of this fact ir submission
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _factIrSubmission.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this fact ir submission.
	*
	* @param createdByUserName the created by user name of this fact ir submission
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_factIrSubmission.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the created date of this fact ir submission.
	*
	* @return the created date of this fact ir submission
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _factIrSubmission.getCreatedDate();
	}

	/**
	* Sets the created date of this fact ir submission.
	*
	* @param createdDate the created date of this fact ir submission
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_factIrSubmission.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _factIrSubmission.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factIrSubmission.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factIrSubmission.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factIrSubmission.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factIrSubmission.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factIrSubmission.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factIrSubmission.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factIrSubmission.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factIrSubmission.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factIrSubmission.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factIrSubmission.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactIrSubmissionWrapper((FactIrSubmission)_factIrSubmission.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission) {
		return _factIrSubmission.compareTo(factIrSubmission);
	}

	@Override
	public int hashCode() {
		return _factIrSubmission.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactIrSubmission> toCacheModel() {
		return _factIrSubmission.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactIrSubmission toEscapedModel() {
		return new FactIrSubmissionWrapper(_factIrSubmission.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactIrSubmission toUnescapedModel() {
		return new FactIrSubmissionWrapper(_factIrSubmission.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factIrSubmission.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factIrSubmission.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factIrSubmission.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactIrSubmissionWrapper)) {
			return false;
		}

		FactIrSubmissionWrapper factIrSubmissionWrapper = (FactIrSubmissionWrapper)obj;

		if (Validator.equals(_factIrSubmission,
					factIrSubmissionWrapper._factIrSubmission)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactIrSubmission getWrappedFactIrSubmission() {
		return _factIrSubmission;
	}

	@Override
	public FactIrSubmission getWrappedModel() {
		return _factIrSubmission;
	}

	@Override
	public void resetOriginalValues() {
		_factIrSubmission.resetOriginalValues();
	}

	private FactIrSubmission _factIrSubmission;
}
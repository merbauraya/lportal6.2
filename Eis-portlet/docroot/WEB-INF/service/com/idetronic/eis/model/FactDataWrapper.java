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
 * This class is a wrapper for {@link FactData}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactData
 * @generated
 */
public class FactDataWrapper implements FactData, ModelWrapper<FactData> {
	public FactDataWrapper(FactData factData) {
		_factData = factData;
	}

	@Override
	public Class<?> getModelClass() {
		return FactData.class;
	}

	@Override
	public String getModelClassName() {
		return FactData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factId", getFactId());
		attributes.put("reportId", getReportId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("dimensionId", getDimensionId());
		attributes.put("measure1", getMeasure1());
		attributes.put("measure2", getMeasure2());
		attributes.put("measure3", getMeasure3());
		attributes.put("measure4", getMeasure4());
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

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long dimensionId = (Long)attributes.get("dimensionId");

		if (dimensionId != null) {
			setDimensionId(dimensionId);
		}

		Double measure1 = (Double)attributes.get("measure1");

		if (measure1 != null) {
			setMeasure1(measure1);
		}

		Double measure2 = (Double)attributes.get("measure2");

		if (measure2 != null) {
			setMeasure2(measure2);
		}

		Double measure3 = (Double)attributes.get("measure3");

		if (measure3 != null) {
			setMeasure3(measure3);
		}

		Double measure4 = (Double)attributes.get("measure4");

		if (measure4 != null) {
			setMeasure4(measure4);
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
	* Returns the primary key of this fact data.
	*
	* @return the primary key of this fact data
	*/
	@Override
	public long getPrimaryKey() {
		return _factData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact data.
	*
	* @param primaryKey the primary key of this fact data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact ID of this fact data.
	*
	* @return the fact ID of this fact data
	*/
	@Override
	public long getFactId() {
		return _factData.getFactId();
	}

	/**
	* Sets the fact ID of this fact data.
	*
	* @param factId the fact ID of this fact data
	*/
	@Override
	public void setFactId(long factId) {
		_factData.setFactId(factId);
	}

	/**
	* Returns the report ID of this fact data.
	*
	* @return the report ID of this fact data
	*/
	@Override
	public long getReportId() {
		return _factData.getReportId();
	}

	/**
	* Sets the report ID of this fact data.
	*
	* @param reportId the report ID of this fact data
	*/
	@Override
	public void setReportId(long reportId) {
		_factData.setReportId(reportId);
	}

	/**
	* Returns the library ID of this fact data.
	*
	* @return the library ID of this fact data
	*/
	@Override
	public long getLibraryId() {
		return _factData.getLibraryId();
	}

	/**
	* Sets the library ID of this fact data.
	*
	* @param libraryId the library ID of this fact data
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factData.setLibraryId(libraryId);
	}

	/**
	* Returns the period of this fact data.
	*
	* @return the period of this fact data
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factData.getPeriod();
	}

	/**
	* Sets the period of this fact data.
	*
	* @param period the period of this fact data
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factData.setPeriod(period);
	}

	/**
	* Returns the dimension ID of this fact data.
	*
	* @return the dimension ID of this fact data
	*/
	@Override
	public long getDimensionId() {
		return _factData.getDimensionId();
	}

	/**
	* Sets the dimension ID of this fact data.
	*
	* @param dimensionId the dimension ID of this fact data
	*/
	@Override
	public void setDimensionId(long dimensionId) {
		_factData.setDimensionId(dimensionId);
	}

	/**
	* Returns the measure1 of this fact data.
	*
	* @return the measure1 of this fact data
	*/
	@Override
	public double getMeasure1() {
		return _factData.getMeasure1();
	}

	/**
	* Sets the measure1 of this fact data.
	*
	* @param measure1 the measure1 of this fact data
	*/
	@Override
	public void setMeasure1(double measure1) {
		_factData.setMeasure1(measure1);
	}

	/**
	* Returns the measure2 of this fact data.
	*
	* @return the measure2 of this fact data
	*/
	@Override
	public double getMeasure2() {
		return _factData.getMeasure2();
	}

	/**
	* Sets the measure2 of this fact data.
	*
	* @param measure2 the measure2 of this fact data
	*/
	@Override
	public void setMeasure2(double measure2) {
		_factData.setMeasure2(measure2);
	}

	/**
	* Returns the measure3 of this fact data.
	*
	* @return the measure3 of this fact data
	*/
	@Override
	public double getMeasure3() {
		return _factData.getMeasure3();
	}

	/**
	* Sets the measure3 of this fact data.
	*
	* @param measure3 the measure3 of this fact data
	*/
	@Override
	public void setMeasure3(double measure3) {
		_factData.setMeasure3(measure3);
	}

	/**
	* Returns the measure4 of this fact data.
	*
	* @return the measure4 of this fact data
	*/
	@Override
	public double getMeasure4() {
		return _factData.getMeasure4();
	}

	/**
	* Sets the measure4 of this fact data.
	*
	* @param measure4 the measure4 of this fact data
	*/
	@Override
	public void setMeasure4(double measure4) {
		_factData.setMeasure4(measure4);
	}

	/**
	* Returns the company ID of this fact data.
	*
	* @return the company ID of this fact data
	*/
	@Override
	public long getCompanyId() {
		return _factData.getCompanyId();
	}

	/**
	* Sets the company ID of this fact data.
	*
	* @param companyId the company ID of this fact data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_factData.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this fact data.
	*
	* @return the group ID of this fact data
	*/
	@Override
	public long getGroupId() {
		return _factData.getGroupId();
	}

	/**
	* Sets the group ID of this fact data.
	*
	* @param groupId the group ID of this fact data
	*/
	@Override
	public void setGroupId(long groupId) {
		_factData.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this fact data.
	*
	* @return the user ID of this fact data
	*/
	@Override
	public long getUserId() {
		return _factData.getUserId();
	}

	/**
	* Sets the user ID of this fact data.
	*
	* @param userId the user ID of this fact data
	*/
	@Override
	public void setUserId(long userId) {
		_factData.setUserId(userId);
	}

	/**
	* Returns the user uuid of this fact data.
	*
	* @return the user uuid of this fact data
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factData.getUserUuid();
	}

	/**
	* Sets the user uuid of this fact data.
	*
	* @param userUuid the user uuid of this fact data
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_factData.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this fact data.
	*
	* @return the user name of this fact data
	*/
	@Override
	public java.lang.String getUserName() {
		return _factData.getUserName();
	}

	/**
	* Sets the user name of this fact data.
	*
	* @param userName the user name of this fact data
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_factData.setUserName(userName);
	}

	/**
	* Returns the create date of this fact data.
	*
	* @return the create date of this fact data
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _factData.getCreateDate();
	}

	/**
	* Sets the create date of this fact data.
	*
	* @param createDate the create date of this fact data
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_factData.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _factData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactDataWrapper((FactData)_factData.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.FactData factData) {
		return _factData.compareTo(factData);
	}

	@Override
	public int hashCode() {
		return _factData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactData> toCacheModel() {
		return _factData.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactData toEscapedModel() {
		return new FactDataWrapper(_factData.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactData toUnescapedModel() {
		return new FactDataWrapper(_factData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactDataWrapper)) {
			return false;
		}

		FactDataWrapper factDataWrapper = (FactDataWrapper)obj;

		if (Validator.equals(_factData, factDataWrapper._factData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactData getWrappedFactData() {
		return _factData;
	}

	@Override
	public FactData getWrappedModel() {
		return _factData;
	}

	@Override
	public void resetOriginalValues() {
		_factData.resetOriginalValues();
	}

	private FactData _factData;
}
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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KpiType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiType
 * @generated
 */
public class KpiTypeWrapper implements KpiType, ModelWrapper<KpiType> {
	public KpiTypeWrapper(KpiType kpiType) {
		_kpiType = kpiType;
	}

	@Override
	public Class<?> getModelClass() {
		return KpiType.class;
	}

	@Override
	public String getModelClassName() {
		return KpiType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kpiTypeId", getKpiTypeId());
		attributes.put("kpiTypeKey", getKpiTypeKey());
		attributes.put("kpiName", getKpiName());
		attributes.put("periodMonth", getPeriodMonth());
		attributes.put("periodQuarter", getPeriodQuarter());
		attributes.put("periodSemiAnnual", getPeriodSemiAnnual());
		attributes.put("periodYear", getPeriodYear());
		attributes.put("isDecimal", getIsDecimal());
		attributes.put("manualValue", getManualValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kpiTypeId = (Long)attributes.get("kpiTypeId");

		if (kpiTypeId != null) {
			setKpiTypeId(kpiTypeId);
		}

		String kpiTypeKey = (String)attributes.get("kpiTypeKey");

		if (kpiTypeKey != null) {
			setKpiTypeKey(kpiTypeKey);
		}

		String kpiName = (String)attributes.get("kpiName");

		if (kpiName != null) {
			setKpiName(kpiName);
		}

		Boolean periodMonth = (Boolean)attributes.get("periodMonth");

		if (periodMonth != null) {
			setPeriodMonth(periodMonth);
		}

		Boolean periodQuarter = (Boolean)attributes.get("periodQuarter");

		if (periodQuarter != null) {
			setPeriodQuarter(periodQuarter);
		}

		Boolean periodSemiAnnual = (Boolean)attributes.get("periodSemiAnnual");

		if (periodSemiAnnual != null) {
			setPeriodSemiAnnual(periodSemiAnnual);
		}

		Boolean periodYear = (Boolean)attributes.get("periodYear");

		if (periodYear != null) {
			setPeriodYear(periodYear);
		}

		Boolean isDecimal = (Boolean)attributes.get("isDecimal");

		if (isDecimal != null) {
			setIsDecimal(isDecimal);
		}

		Boolean manualValue = (Boolean)attributes.get("manualValue");

		if (manualValue != null) {
			setManualValue(manualValue);
		}
	}

	/**
	* Returns the primary key of this kpi type.
	*
	* @return the primary key of this kpi type
	*/
	@Override
	public long getPrimaryKey() {
		return _kpiType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kpi type.
	*
	* @param primaryKey the primary key of this kpi type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kpiType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the kpi type ID of this kpi type.
	*
	* @return the kpi type ID of this kpi type
	*/
	@Override
	public long getKpiTypeId() {
		return _kpiType.getKpiTypeId();
	}

	/**
	* Sets the kpi type ID of this kpi type.
	*
	* @param kpiTypeId the kpi type ID of this kpi type
	*/
	@Override
	public void setKpiTypeId(long kpiTypeId) {
		_kpiType.setKpiTypeId(kpiTypeId);
	}

	/**
	* Returns the kpi type key of this kpi type.
	*
	* @return the kpi type key of this kpi type
	*/
	@Override
	public java.lang.String getKpiTypeKey() {
		return _kpiType.getKpiTypeKey();
	}

	/**
	* Sets the kpi type key of this kpi type.
	*
	* @param kpiTypeKey the kpi type key of this kpi type
	*/
	@Override
	public void setKpiTypeKey(java.lang.String kpiTypeKey) {
		_kpiType.setKpiTypeKey(kpiTypeKey);
	}

	/**
	* Returns the kpi name of this kpi type.
	*
	* @return the kpi name of this kpi type
	*/
	@Override
	public java.lang.String getKpiName() {
		return _kpiType.getKpiName();
	}

	/**
	* Sets the kpi name of this kpi type.
	*
	* @param kpiName the kpi name of this kpi type
	*/
	@Override
	public void setKpiName(java.lang.String kpiName) {
		_kpiType.setKpiName(kpiName);
	}

	/**
	* Returns the period month of this kpi type.
	*
	* @return the period month of this kpi type
	*/
	@Override
	public boolean getPeriodMonth() {
		return _kpiType.getPeriodMonth();
	}

	/**
	* Returns <code>true</code> if this kpi type is period month.
	*
	* @return <code>true</code> if this kpi type is period month; <code>false</code> otherwise
	*/
	@Override
	public boolean isPeriodMonth() {
		return _kpiType.isPeriodMonth();
	}

	/**
	* Sets whether this kpi type is period month.
	*
	* @param periodMonth the period month of this kpi type
	*/
	@Override
	public void setPeriodMonth(boolean periodMonth) {
		_kpiType.setPeriodMonth(periodMonth);
	}

	/**
	* Returns the period quarter of this kpi type.
	*
	* @return the period quarter of this kpi type
	*/
	@Override
	public boolean getPeriodQuarter() {
		return _kpiType.getPeriodQuarter();
	}

	/**
	* Returns <code>true</code> if this kpi type is period quarter.
	*
	* @return <code>true</code> if this kpi type is period quarter; <code>false</code> otherwise
	*/
	@Override
	public boolean isPeriodQuarter() {
		return _kpiType.isPeriodQuarter();
	}

	/**
	* Sets whether this kpi type is period quarter.
	*
	* @param periodQuarter the period quarter of this kpi type
	*/
	@Override
	public void setPeriodQuarter(boolean periodQuarter) {
		_kpiType.setPeriodQuarter(periodQuarter);
	}

	/**
	* Returns the period semi annual of this kpi type.
	*
	* @return the period semi annual of this kpi type
	*/
	@Override
	public boolean getPeriodSemiAnnual() {
		return _kpiType.getPeriodSemiAnnual();
	}

	/**
	* Returns <code>true</code> if this kpi type is period semi annual.
	*
	* @return <code>true</code> if this kpi type is period semi annual; <code>false</code> otherwise
	*/
	@Override
	public boolean isPeriodSemiAnnual() {
		return _kpiType.isPeriodSemiAnnual();
	}

	/**
	* Sets whether this kpi type is period semi annual.
	*
	* @param periodSemiAnnual the period semi annual of this kpi type
	*/
	@Override
	public void setPeriodSemiAnnual(boolean periodSemiAnnual) {
		_kpiType.setPeriodSemiAnnual(periodSemiAnnual);
	}

	/**
	* Returns the period year of this kpi type.
	*
	* @return the period year of this kpi type
	*/
	@Override
	public boolean getPeriodYear() {
		return _kpiType.getPeriodYear();
	}

	/**
	* Returns <code>true</code> if this kpi type is period year.
	*
	* @return <code>true</code> if this kpi type is period year; <code>false</code> otherwise
	*/
	@Override
	public boolean isPeriodYear() {
		return _kpiType.isPeriodYear();
	}

	/**
	* Sets whether this kpi type is period year.
	*
	* @param periodYear the period year of this kpi type
	*/
	@Override
	public void setPeriodYear(boolean periodYear) {
		_kpiType.setPeriodYear(periodYear);
	}

	/**
	* Returns the is decimal of this kpi type.
	*
	* @return the is decimal of this kpi type
	*/
	@Override
	public boolean getIsDecimal() {
		return _kpiType.getIsDecimal();
	}

	/**
	* Returns <code>true</code> if this kpi type is is decimal.
	*
	* @return <code>true</code> if this kpi type is is decimal; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsDecimal() {
		return _kpiType.isIsDecimal();
	}

	/**
	* Sets whether this kpi type is is decimal.
	*
	* @param isDecimal the is decimal of this kpi type
	*/
	@Override
	public void setIsDecimal(boolean isDecimal) {
		_kpiType.setIsDecimal(isDecimal);
	}

	/**
	* Returns the manual value of this kpi type.
	*
	* @return the manual value of this kpi type
	*/
	@Override
	public boolean getManualValue() {
		return _kpiType.getManualValue();
	}

	/**
	* Returns <code>true</code> if this kpi type is manual value.
	*
	* @return <code>true</code> if this kpi type is manual value; <code>false</code> otherwise
	*/
	@Override
	public boolean isManualValue() {
		return _kpiType.isManualValue();
	}

	/**
	* Sets whether this kpi type is manual value.
	*
	* @param manualValue the manual value of this kpi type
	*/
	@Override
	public void setManualValue(boolean manualValue) {
		_kpiType.setManualValue(manualValue);
	}

	@Override
	public boolean isNew() {
		return _kpiType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kpiType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kpiType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kpiType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kpiType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kpiType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kpiType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kpiType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kpiType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kpiType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kpiType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KpiTypeWrapper((KpiType)_kpiType.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.KpiType kpiType) {
		return _kpiType.compareTo(kpiType);
	}

	@Override
	public int hashCode() {
		return _kpiType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.KpiType> toCacheModel() {
		return _kpiType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.KpiType toEscapedModel() {
		return new KpiTypeWrapper(_kpiType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.KpiType toUnescapedModel() {
		return new KpiTypeWrapper(_kpiType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kpiType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kpiType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kpiType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KpiTypeWrapper)) {
			return false;
		}

		KpiTypeWrapper kpiTypeWrapper = (KpiTypeWrapper)obj;

		if (Validator.equals(_kpiType, kpiTypeWrapper._kpiType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KpiType getWrappedKpiType() {
		return _kpiType;
	}

	@Override
	public KpiType getWrappedModel() {
		return _kpiType;
	}

	@Override
	public void resetOriginalValues() {
		_kpiType.resetOriginalValues();
	}

	private KpiType _kpiType;
}
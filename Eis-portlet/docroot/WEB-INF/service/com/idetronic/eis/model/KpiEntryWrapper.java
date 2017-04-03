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
 * This class is a wrapper for {@link KpiEntry}.
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiEntry
 * @generated
 */
public class KpiEntryWrapper implements KpiEntry, ModelWrapper<KpiEntry> {
	public KpiEntryWrapper(KpiEntry kpiEntry) {
		_kpiEntry = kpiEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return KpiEntry.class;
	}

	@Override
	public String getModelClassName() {
		return KpiEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kpiEntryId", getKpiEntryId());
		attributes.put("kpiTypeId", getKpiTypeId());
		attributes.put("periodYear", getPeriodYear());
		attributes.put("periodType", getPeriodType());
		attributes.put("period", getPeriod());
		attributes.put("value", getValue());
		attributes.put("actual", getActual());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kpiEntryId = (Long)attributes.get("kpiEntryId");

		if (kpiEntryId != null) {
			setKpiEntryId(kpiEntryId);
		}

		Long kpiTypeId = (Long)attributes.get("kpiTypeId");

		if (kpiTypeId != null) {
			setKpiTypeId(kpiTypeId);
		}

		String periodYear = (String)attributes.get("periodYear");

		if (periodYear != null) {
			setPeriodYear(periodYear);
		}

		Integer periodType = (Integer)attributes.get("periodType");

		if (periodType != null) {
			setPeriodType(periodType);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Double actual = (Double)attributes.get("actual");

		if (actual != null) {
			setActual(actual);
		}
	}

	/**
	* Returns the primary key of this kpi entry.
	*
	* @return the primary key of this kpi entry
	*/
	@Override
	public long getPrimaryKey() {
		return _kpiEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kpi entry.
	*
	* @param primaryKey the primary key of this kpi entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kpiEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the kpi entry ID of this kpi entry.
	*
	* @return the kpi entry ID of this kpi entry
	*/
	@Override
	public long getKpiEntryId() {
		return _kpiEntry.getKpiEntryId();
	}

	/**
	* Sets the kpi entry ID of this kpi entry.
	*
	* @param kpiEntryId the kpi entry ID of this kpi entry
	*/
	@Override
	public void setKpiEntryId(long kpiEntryId) {
		_kpiEntry.setKpiEntryId(kpiEntryId);
	}

	/**
	* Returns the kpi type ID of this kpi entry.
	*
	* @return the kpi type ID of this kpi entry
	*/
	@Override
	public long getKpiTypeId() {
		return _kpiEntry.getKpiTypeId();
	}

	/**
	* Sets the kpi type ID of this kpi entry.
	*
	* @param kpiTypeId the kpi type ID of this kpi entry
	*/
	@Override
	public void setKpiTypeId(long kpiTypeId) {
		_kpiEntry.setKpiTypeId(kpiTypeId);
	}

	/**
	* Returns the period year of this kpi entry.
	*
	* @return the period year of this kpi entry
	*/
	@Override
	public java.lang.String getPeriodYear() {
		return _kpiEntry.getPeriodYear();
	}

	/**
	* Sets the period year of this kpi entry.
	*
	* @param periodYear the period year of this kpi entry
	*/
	@Override
	public void setPeriodYear(java.lang.String periodYear) {
		_kpiEntry.setPeriodYear(periodYear);
	}

	/**
	* Returns the period type of this kpi entry.
	*
	* @return the period type of this kpi entry
	*/
	@Override
	public int getPeriodType() {
		return _kpiEntry.getPeriodType();
	}

	/**
	* Sets the period type of this kpi entry.
	*
	* @param periodType the period type of this kpi entry
	*/
	@Override
	public void setPeriodType(int periodType) {
		_kpiEntry.setPeriodType(periodType);
	}

	/**
	* Returns the period of this kpi entry.
	*
	* @return the period of this kpi entry
	*/
	@Override
	public java.lang.String getPeriod() {
		return _kpiEntry.getPeriod();
	}

	/**
	* Sets the period of this kpi entry.
	*
	* @param period the period of this kpi entry
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_kpiEntry.setPeriod(period);
	}

	/**
	* Returns the value of this kpi entry.
	*
	* @return the value of this kpi entry
	*/
	@Override
	public double getValue() {
		return _kpiEntry.getValue();
	}

	/**
	* Sets the value of this kpi entry.
	*
	* @param value the value of this kpi entry
	*/
	@Override
	public void setValue(double value) {
		_kpiEntry.setValue(value);
	}

	/**
	* Returns the actual of this kpi entry.
	*
	* @return the actual of this kpi entry
	*/
	@Override
	public double getActual() {
		return _kpiEntry.getActual();
	}

	/**
	* Sets the actual of this kpi entry.
	*
	* @param actual the actual of this kpi entry
	*/
	@Override
	public void setActual(double actual) {
		_kpiEntry.setActual(actual);
	}

	@Override
	public boolean isNew() {
		return _kpiEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kpiEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kpiEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kpiEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kpiEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kpiEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kpiEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kpiEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kpiEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kpiEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kpiEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KpiEntryWrapper((KpiEntry)_kpiEntry.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.KpiEntry kpiEntry) {
		return _kpiEntry.compareTo(kpiEntry);
	}

	@Override
	public int hashCode() {
		return _kpiEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.KpiEntry> toCacheModel() {
		return _kpiEntry.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.KpiEntry toEscapedModel() {
		return new KpiEntryWrapper(_kpiEntry.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.KpiEntry toUnescapedModel() {
		return new KpiEntryWrapper(_kpiEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kpiEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kpiEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kpiEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KpiEntryWrapper)) {
			return false;
		}

		KpiEntryWrapper kpiEntryWrapper = (KpiEntryWrapper)obj;

		if (Validator.equals(_kpiEntry, kpiEntryWrapper._kpiEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KpiEntry getWrappedKpiEntry() {
		return _kpiEntry;
	}

	@Override
	public KpiEntry getWrappedModel() {
		return _kpiEntry;
	}

	@Override
	public void resetOriginalValues() {
		_kpiEntry.resetOriginalValues();
	}

	private KpiEntry _kpiEntry;
}
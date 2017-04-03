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
 * This class is a wrapper for {@link Kpi}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Kpi
 * @generated
 */
public class KpiWrapper implements Kpi, ModelWrapper<Kpi> {
	public KpiWrapper(Kpi kpi) {
		_kpi = kpi;
	}

	@Override
	public Class<?> getModelClass() {
		return Kpi.class;
	}

	@Override
	public String getModelClassName() {
		return Kpi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("key", getKey());
		attributes.put("kpiType", getKpiType());
		attributes.put("value", getValue());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Integer kpiType = (Integer)attributes.get("kpiType");

		if (kpiType != null) {
			setKpiType(kpiType);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this kpi.
	*
	* @return the primary key of this kpi
	*/
	@Override
	public long getPrimaryKey() {
		return _kpi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kpi.
	*
	* @param primaryKey the primary key of this kpi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kpi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this kpi.
	*
	* @return the ID of this kpi
	*/
	@Override
	public long getId() {
		return _kpi.getId();
	}

	/**
	* Sets the ID of this kpi.
	*
	* @param id the ID of this kpi
	*/
	@Override
	public void setId(long id) {
		_kpi.setId(id);
	}

	/**
	* Returns the key of this kpi.
	*
	* @return the key of this kpi
	*/
	@Override
	public java.lang.String getKey() {
		return _kpi.getKey();
	}

	/**
	* Sets the key of this kpi.
	*
	* @param key the key of this kpi
	*/
	@Override
	public void setKey(java.lang.String key) {
		_kpi.setKey(key);
	}

	/**
	* Returns the kpi type of this kpi.
	*
	* @return the kpi type of this kpi
	*/
	@Override
	public int getKpiType() {
		return _kpi.getKpiType();
	}

	/**
	* Sets the kpi type of this kpi.
	*
	* @param kpiType the kpi type of this kpi
	*/
	@Override
	public void setKpiType(int kpiType) {
		_kpi.setKpiType(kpiType);
	}

	/**
	* Returns the value of this kpi.
	*
	* @return the value of this kpi
	*/
	@Override
	public int getValue() {
		return _kpi.getValue();
	}

	/**
	* Sets the value of this kpi.
	*
	* @param value the value of this kpi
	*/
	@Override
	public void setValue(int value) {
		_kpi.setValue(value);
	}

	/**
	* Returns the description of this kpi.
	*
	* @return the description of this kpi
	*/
	@Override
	public java.lang.String getDescription() {
		return _kpi.getDescription();
	}

	/**
	* Sets the description of this kpi.
	*
	* @param description the description of this kpi
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_kpi.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _kpi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kpi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kpi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kpi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kpi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kpi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kpi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kpi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kpi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kpi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kpi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KpiWrapper((Kpi)_kpi.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.Kpi kpi) {
		return _kpi.compareTo(kpi);
	}

	@Override
	public int hashCode() {
		return _kpi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.Kpi> toCacheModel() {
		return _kpi.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.Kpi toEscapedModel() {
		return new KpiWrapper(_kpi.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.Kpi toUnescapedModel() {
		return new KpiWrapper(_kpi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kpi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kpi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kpi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KpiWrapper)) {
			return false;
		}

		KpiWrapper kpiWrapper = (KpiWrapper)obj;

		if (Validator.equals(_kpi, kpiWrapper._kpi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Kpi getWrappedKpi() {
		return _kpi;
	}

	@Override
	public Kpi getWrappedModel() {
		return _kpi;
	}

	@Override
	public void resetOriginalValues() {
		_kpi.resetOriginalValues();
	}

	private Kpi _kpi;
}
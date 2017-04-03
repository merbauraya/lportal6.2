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
 * This class is a wrapper for {@link FactPrintedMaterial}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPrintedMaterial
 * @generated
 */
public class FactPrintedMaterialWrapper implements FactPrintedMaterial,
	ModelWrapper<FactPrintedMaterial> {
	public FactPrintedMaterialWrapper(FactPrintedMaterial factPrintedMaterial) {
		_factPrintedMaterial = factPrintedMaterial;
	}

	@Override
	public Class<?> getModelClass() {
		return FactPrintedMaterial.class;
	}

	@Override
	public String getModelClassName() {
		return FactPrintedMaterial.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factPrintedMaterialId", getFactPrintedMaterialId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("libraryCode", getLibraryCode());
		attributes.put("stateId", getStateId());
		attributes.put("stateCode", getStateCode());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("period", getPeriod());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("monthVal", getMonthVal());
		attributes.put("yearVal", getYearVal());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("dateCreated", getDateCreated());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdByUserId", getCreatedByUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factPrintedMaterialId = (Long)attributes.get(
				"factPrintedMaterialId");

		if (factPrintedMaterialId != null) {
			setFactPrintedMaterialId(factPrintedMaterialId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String libraryCode = (String)attributes.get("libraryCode");

		if (libraryCode != null) {
			setLibraryCode(libraryCode);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String stateCode = (String)attributes.get("stateCode");

		if (stateCode != null) {
			setStateCode(stateCode);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Integer monthVal = (Integer)attributes.get("monthVal");

		if (monthVal != null) {
			setMonthVal(monthVal);
		}

		Integer yearVal = (Integer)attributes.get("yearVal");

		if (yearVal != null) {
			setYearVal(yearVal);
		}

		Integer titleTotal = (Integer)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Integer volumeTotal = (Integer)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
		}

		Date dateCreated = (Date)attributes.get("dateCreated");

		if (dateCreated != null) {
			setDateCreated(dateCreated);
		}

		String createdByUserName = (String)attributes.get("createdByUserName");

		if (createdByUserName != null) {
			setCreatedByUserName(createdByUserName);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}
	}

	/**
	* Returns the primary key of this fact printed material.
	*
	* @return the primary key of this fact printed material
	*/
	@Override
	public long getPrimaryKey() {
		return _factPrintedMaterial.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact printed material.
	*
	* @param primaryKey the primary key of this fact printed material
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factPrintedMaterial.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact printed material ID of this fact printed material.
	*
	* @return the fact printed material ID of this fact printed material
	*/
	@Override
	public long getFactPrintedMaterialId() {
		return _factPrintedMaterial.getFactPrintedMaterialId();
	}

	/**
	* Sets the fact printed material ID of this fact printed material.
	*
	* @param factPrintedMaterialId the fact printed material ID of this fact printed material
	*/
	@Override
	public void setFactPrintedMaterialId(long factPrintedMaterialId) {
		_factPrintedMaterial.setFactPrintedMaterialId(factPrintedMaterialId);
	}

	/**
	* Returns the library ID of this fact printed material.
	*
	* @return the library ID of this fact printed material
	*/
	@Override
	public long getLibraryId() {
		return _factPrintedMaterial.getLibraryId();
	}

	/**
	* Sets the library ID of this fact printed material.
	*
	* @param libraryId the library ID of this fact printed material
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factPrintedMaterial.setLibraryId(libraryId);
	}

	/**
	* Returns the library code of this fact printed material.
	*
	* @return the library code of this fact printed material
	*/
	@Override
	public java.lang.String getLibraryCode() {
		return _factPrintedMaterial.getLibraryCode();
	}

	/**
	* Sets the library code of this fact printed material.
	*
	* @param libraryCode the library code of this fact printed material
	*/
	@Override
	public void setLibraryCode(java.lang.String libraryCode) {
		_factPrintedMaterial.setLibraryCode(libraryCode);
	}

	/**
	* Returns the state ID of this fact printed material.
	*
	* @return the state ID of this fact printed material
	*/
	@Override
	public long getStateId() {
		return _factPrintedMaterial.getStateId();
	}

	/**
	* Sets the state ID of this fact printed material.
	*
	* @param stateId the state ID of this fact printed material
	*/
	@Override
	public void setStateId(long stateId) {
		_factPrintedMaterial.setStateId(stateId);
	}

	/**
	* Returns the state code of this fact printed material.
	*
	* @return the state code of this fact printed material
	*/
	@Override
	public java.lang.String getStateCode() {
		return _factPrintedMaterial.getStateCode();
	}

	/**
	* Sets the state code of this fact printed material.
	*
	* @param stateCode the state code of this fact printed material
	*/
	@Override
	public void setStateCode(java.lang.String stateCode) {
		_factPrintedMaterial.setStateCode(stateCode);
	}

	/**
	* Returns the item type ID of this fact printed material.
	*
	* @return the item type ID of this fact printed material
	*/
	@Override
	public long getItemTypeId() {
		return _factPrintedMaterial.getItemTypeId();
	}

	/**
	* Sets the item type ID of this fact printed material.
	*
	* @param itemTypeId the item type ID of this fact printed material
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_factPrintedMaterial.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the period of this fact printed material.
	*
	* @return the period of this fact printed material
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factPrintedMaterial.getPeriod();
	}

	/**
	* Sets the period of this fact printed material.
	*
	* @param period the period of this fact printed material
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factPrintedMaterial.setPeriod(period);
	}

	/**
	* Returns the library type ID of this fact printed material.
	*
	* @return the library type ID of this fact printed material
	*/
	@Override
	public long getLibraryTypeId() {
		return _factPrintedMaterial.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this fact printed material.
	*
	* @param libraryTypeId the library type ID of this fact printed material
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_factPrintedMaterial.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the month val of this fact printed material.
	*
	* @return the month val of this fact printed material
	*/
	@Override
	public int getMonthVal() {
		return _factPrintedMaterial.getMonthVal();
	}

	/**
	* Sets the month val of this fact printed material.
	*
	* @param monthVal the month val of this fact printed material
	*/
	@Override
	public void setMonthVal(int monthVal) {
		_factPrintedMaterial.setMonthVal(monthVal);
	}

	/**
	* Returns the year val of this fact printed material.
	*
	* @return the year val of this fact printed material
	*/
	@Override
	public int getYearVal() {
		return _factPrintedMaterial.getYearVal();
	}

	/**
	* Sets the year val of this fact printed material.
	*
	* @param yearVal the year val of this fact printed material
	*/
	@Override
	public void setYearVal(int yearVal) {
		_factPrintedMaterial.setYearVal(yearVal);
	}

	/**
	* Returns the title total of this fact printed material.
	*
	* @return the title total of this fact printed material
	*/
	@Override
	public int getTitleTotal() {
		return _factPrintedMaterial.getTitleTotal();
	}

	/**
	* Sets the title total of this fact printed material.
	*
	* @param titleTotal the title total of this fact printed material
	*/
	@Override
	public void setTitleTotal(int titleTotal) {
		_factPrintedMaterial.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact printed material.
	*
	* @return the volume total of this fact printed material
	*/
	@Override
	public int getVolumeTotal() {
		return _factPrintedMaterial.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact printed material.
	*
	* @param volumeTotal the volume total of this fact printed material
	*/
	@Override
	public void setVolumeTotal(int volumeTotal) {
		_factPrintedMaterial.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the date created of this fact printed material.
	*
	* @return the date created of this fact printed material
	*/
	@Override
	public java.util.Date getDateCreated() {
		return _factPrintedMaterial.getDateCreated();
	}

	/**
	* Sets the date created of this fact printed material.
	*
	* @param dateCreated the date created of this fact printed material
	*/
	@Override
	public void setDateCreated(java.util.Date dateCreated) {
		_factPrintedMaterial.setDateCreated(dateCreated);
	}

	/**
	* Returns the created by user name of this fact printed material.
	*
	* @return the created by user name of this fact printed material
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _factPrintedMaterial.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this fact printed material.
	*
	* @param createdByUserName the created by user name of this fact printed material
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_factPrintedMaterial.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the created by user ID of this fact printed material.
	*
	* @return the created by user ID of this fact printed material
	*/
	@Override
	public long getCreatedByUserId() {
		return _factPrintedMaterial.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this fact printed material.
	*
	* @param createdByUserId the created by user ID of this fact printed material
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_factPrintedMaterial.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this fact printed material.
	*
	* @return the created by user uuid of this fact printed material
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factPrintedMaterial.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this fact printed material.
	*
	* @param createdByUserUuid the created by user uuid of this fact printed material
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_factPrintedMaterial.setCreatedByUserUuid(createdByUserUuid);
	}

	@Override
	public boolean isNew() {
		return _factPrintedMaterial.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factPrintedMaterial.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factPrintedMaterial.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factPrintedMaterial.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factPrintedMaterial.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factPrintedMaterial.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factPrintedMaterial.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factPrintedMaterial.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factPrintedMaterial.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factPrintedMaterial.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factPrintedMaterial.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactPrintedMaterialWrapper((FactPrintedMaterial)_factPrintedMaterial.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactPrintedMaterial factPrintedMaterial) {
		return _factPrintedMaterial.compareTo(factPrintedMaterial);
	}

	@Override
	public int hashCode() {
		return _factPrintedMaterial.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactPrintedMaterial> toCacheModel() {
		return _factPrintedMaterial.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactPrintedMaterial toEscapedModel() {
		return new FactPrintedMaterialWrapper(_factPrintedMaterial.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactPrintedMaterial toUnescapedModel() {
		return new FactPrintedMaterialWrapper(_factPrintedMaterial.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factPrintedMaterial.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factPrintedMaterial.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factPrintedMaterial.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactPrintedMaterialWrapper)) {
			return false;
		}

		FactPrintedMaterialWrapper factPrintedMaterialWrapper = (FactPrintedMaterialWrapper)obj;

		if (Validator.equals(_factPrintedMaterial,
					factPrintedMaterialWrapper._factPrintedMaterial)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactPrintedMaterial getWrappedFactPrintedMaterial() {
		return _factPrintedMaterial;
	}

	@Override
	public FactPrintedMaterial getWrappedModel() {
		return _factPrintedMaterial;
	}

	@Override
	public void resetOriginalValues() {
		_factPrintedMaterial.resetOriginalValues();
	}

	private FactPrintedMaterial _factPrintedMaterial;
}
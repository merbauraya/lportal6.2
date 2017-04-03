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
 * This class is a wrapper for {@link FactNonPrintedMaterial}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactNonPrintedMaterial
 * @generated
 */
public class FactNonPrintedMaterialWrapper implements FactNonPrintedMaterial,
	ModelWrapper<FactNonPrintedMaterial> {
	public FactNonPrintedMaterialWrapper(
		FactNonPrintedMaterial factNonPrintedMaterial) {
		_factNonPrintedMaterial = factNonPrintedMaterial;
	}

	@Override
	public Class<?> getModelClass() {
		return FactNonPrintedMaterial.class;
	}

	@Override
	public String getModelClassName() {
		return FactNonPrintedMaterial.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factNonPrintedMaterialId", getFactNonPrintedMaterialId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("libraryCode", getLibraryCode());
		attributes.put("stateId", getStateId());
		attributes.put("stateCode", getStateCode());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("period", getPeriod());
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
		Long factNonPrintedMaterialId = (Long)attributes.get(
				"factNonPrintedMaterialId");

		if (factNonPrintedMaterialId != null) {
			setFactNonPrintedMaterialId(factNonPrintedMaterialId);
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

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
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
	* Returns the primary key of this fact non printed material.
	*
	* @return the primary key of this fact non printed material
	*/
	@Override
	public long getPrimaryKey() {
		return _factNonPrintedMaterial.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fact non printed material.
	*
	* @param primaryKey the primary key of this fact non printed material
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_factNonPrintedMaterial.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fact non printed material ID of this fact non printed material.
	*
	* @return the fact non printed material ID of this fact non printed material
	*/
	@Override
	public long getFactNonPrintedMaterialId() {
		return _factNonPrintedMaterial.getFactNonPrintedMaterialId();
	}

	/**
	* Sets the fact non printed material ID of this fact non printed material.
	*
	* @param factNonPrintedMaterialId the fact non printed material ID of this fact non printed material
	*/
	@Override
	public void setFactNonPrintedMaterialId(long factNonPrintedMaterialId) {
		_factNonPrintedMaterial.setFactNonPrintedMaterialId(factNonPrintedMaterialId);
	}

	/**
	* Returns the library ID of this fact non printed material.
	*
	* @return the library ID of this fact non printed material
	*/
	@Override
	public long getLibraryId() {
		return _factNonPrintedMaterial.getLibraryId();
	}

	/**
	* Sets the library ID of this fact non printed material.
	*
	* @param libraryId the library ID of this fact non printed material
	*/
	@Override
	public void setLibraryId(long libraryId) {
		_factNonPrintedMaterial.setLibraryId(libraryId);
	}

	/**
	* Returns the library code of this fact non printed material.
	*
	* @return the library code of this fact non printed material
	*/
	@Override
	public java.lang.String getLibraryCode() {
		return _factNonPrintedMaterial.getLibraryCode();
	}

	/**
	* Sets the library code of this fact non printed material.
	*
	* @param libraryCode the library code of this fact non printed material
	*/
	@Override
	public void setLibraryCode(java.lang.String libraryCode) {
		_factNonPrintedMaterial.setLibraryCode(libraryCode);
	}

	/**
	* Returns the state ID of this fact non printed material.
	*
	* @return the state ID of this fact non printed material
	*/
	@Override
	public long getStateId() {
		return _factNonPrintedMaterial.getStateId();
	}

	/**
	* Sets the state ID of this fact non printed material.
	*
	* @param stateId the state ID of this fact non printed material
	*/
	@Override
	public void setStateId(long stateId) {
		_factNonPrintedMaterial.setStateId(stateId);
	}

	/**
	* Returns the state code of this fact non printed material.
	*
	* @return the state code of this fact non printed material
	*/
	@Override
	public java.lang.String getStateCode() {
		return _factNonPrintedMaterial.getStateCode();
	}

	/**
	* Sets the state code of this fact non printed material.
	*
	* @param stateCode the state code of this fact non printed material
	*/
	@Override
	public void setStateCode(java.lang.String stateCode) {
		_factNonPrintedMaterial.setStateCode(stateCode);
	}

	/**
	* Returns the library type ID of this fact non printed material.
	*
	* @return the library type ID of this fact non printed material
	*/
	@Override
	public long getLibraryTypeId() {
		return _factNonPrintedMaterial.getLibraryTypeId();
	}

	/**
	* Sets the library type ID of this fact non printed material.
	*
	* @param libraryTypeId the library type ID of this fact non printed material
	*/
	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_factNonPrintedMaterial.setLibraryTypeId(libraryTypeId);
	}

	/**
	* Returns the item type ID of this fact non printed material.
	*
	* @return the item type ID of this fact non printed material
	*/
	@Override
	public long getItemTypeId() {
		return _factNonPrintedMaterial.getItemTypeId();
	}

	/**
	* Sets the item type ID of this fact non printed material.
	*
	* @param itemTypeId the item type ID of this fact non printed material
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_factNonPrintedMaterial.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the period of this fact non printed material.
	*
	* @return the period of this fact non printed material
	*/
	@Override
	public java.lang.String getPeriod() {
		return _factNonPrintedMaterial.getPeriod();
	}

	/**
	* Sets the period of this fact non printed material.
	*
	* @param period the period of this fact non printed material
	*/
	@Override
	public void setPeriod(java.lang.String period) {
		_factNonPrintedMaterial.setPeriod(period);
	}

	/**
	* Returns the month val of this fact non printed material.
	*
	* @return the month val of this fact non printed material
	*/
	@Override
	public int getMonthVal() {
		return _factNonPrintedMaterial.getMonthVal();
	}

	/**
	* Sets the month val of this fact non printed material.
	*
	* @param monthVal the month val of this fact non printed material
	*/
	@Override
	public void setMonthVal(int monthVal) {
		_factNonPrintedMaterial.setMonthVal(monthVal);
	}

	/**
	* Returns the year val of this fact non printed material.
	*
	* @return the year val of this fact non printed material
	*/
	@Override
	public int getYearVal() {
		return _factNonPrintedMaterial.getYearVal();
	}

	/**
	* Sets the year val of this fact non printed material.
	*
	* @param yearVal the year val of this fact non printed material
	*/
	@Override
	public void setYearVal(int yearVal) {
		_factNonPrintedMaterial.setYearVal(yearVal);
	}

	/**
	* Returns the title total of this fact non printed material.
	*
	* @return the title total of this fact non printed material
	*/
	@Override
	public int getTitleTotal() {
		return _factNonPrintedMaterial.getTitleTotal();
	}

	/**
	* Sets the title total of this fact non printed material.
	*
	* @param titleTotal the title total of this fact non printed material
	*/
	@Override
	public void setTitleTotal(int titleTotal) {
		_factNonPrintedMaterial.setTitleTotal(titleTotal);
	}

	/**
	* Returns the volume total of this fact non printed material.
	*
	* @return the volume total of this fact non printed material
	*/
	@Override
	public int getVolumeTotal() {
		return _factNonPrintedMaterial.getVolumeTotal();
	}

	/**
	* Sets the volume total of this fact non printed material.
	*
	* @param volumeTotal the volume total of this fact non printed material
	*/
	@Override
	public void setVolumeTotal(int volumeTotal) {
		_factNonPrintedMaterial.setVolumeTotal(volumeTotal);
	}

	/**
	* Returns the date created of this fact non printed material.
	*
	* @return the date created of this fact non printed material
	*/
	@Override
	public java.util.Date getDateCreated() {
		return _factNonPrintedMaterial.getDateCreated();
	}

	/**
	* Sets the date created of this fact non printed material.
	*
	* @param dateCreated the date created of this fact non printed material
	*/
	@Override
	public void setDateCreated(java.util.Date dateCreated) {
		_factNonPrintedMaterial.setDateCreated(dateCreated);
	}

	/**
	* Returns the created by user name of this fact non printed material.
	*
	* @return the created by user name of this fact non printed material
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _factNonPrintedMaterial.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this fact non printed material.
	*
	* @param createdByUserName the created by user name of this fact non printed material
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_factNonPrintedMaterial.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the created by user ID of this fact non printed material.
	*
	* @return the created by user ID of this fact non printed material
	*/
	@Override
	public long getCreatedByUserId() {
		return _factNonPrintedMaterial.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this fact non printed material.
	*
	* @param createdByUserId the created by user ID of this fact non printed material
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_factNonPrintedMaterial.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this fact non printed material.
	*
	* @return the created by user uuid of this fact non printed material
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterial.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this fact non printed material.
	*
	* @param createdByUserUuid the created by user uuid of this fact non printed material
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_factNonPrintedMaterial.setCreatedByUserUuid(createdByUserUuid);
	}

	@Override
	public boolean isNew() {
		return _factNonPrintedMaterial.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_factNonPrintedMaterial.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _factNonPrintedMaterial.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_factNonPrintedMaterial.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _factNonPrintedMaterial.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _factNonPrintedMaterial.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_factNonPrintedMaterial.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _factNonPrintedMaterial.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_factNonPrintedMaterial.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_factNonPrintedMaterial.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_factNonPrintedMaterial.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FactNonPrintedMaterialWrapper((FactNonPrintedMaterial)_factNonPrintedMaterial.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.eis.model.FactNonPrintedMaterial factNonPrintedMaterial) {
		return _factNonPrintedMaterial.compareTo(factNonPrintedMaterial);
	}

	@Override
	public int hashCode() {
		return _factNonPrintedMaterial.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.FactNonPrintedMaterial> toCacheModel() {
		return _factNonPrintedMaterial.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial toEscapedModel() {
		return new FactNonPrintedMaterialWrapper(_factNonPrintedMaterial.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial toUnescapedModel() {
		return new FactNonPrintedMaterialWrapper(_factNonPrintedMaterial.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _factNonPrintedMaterial.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _factNonPrintedMaterial.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_factNonPrintedMaterial.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FactNonPrintedMaterialWrapper)) {
			return false;
		}

		FactNonPrintedMaterialWrapper factNonPrintedMaterialWrapper = (FactNonPrintedMaterialWrapper)obj;

		if (Validator.equals(_factNonPrintedMaterial,
					factNonPrintedMaterialWrapper._factNonPrintedMaterial)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FactNonPrintedMaterial getWrappedFactNonPrintedMaterial() {
		return _factNonPrintedMaterial;
	}

	@Override
	public FactNonPrintedMaterial getWrappedModel() {
		return _factNonPrintedMaterial;
	}

	@Override
	public void resetOriginalValues() {
		_factNonPrintedMaterial.resetOriginalValues();
	}

	private FactNonPrintedMaterial _factNonPrintedMaterial;
}
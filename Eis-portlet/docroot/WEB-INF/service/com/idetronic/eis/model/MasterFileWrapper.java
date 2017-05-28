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
 * This class is a wrapper for {@link MasterFile}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterFile
 * @generated
 */
public class MasterFileWrapper implements MasterFile, ModelWrapper<MasterFile> {
	public MasterFileWrapper(MasterFile masterFile) {
		_masterFile = masterFile;
	}

	@Override
	public Class<?> getModelClass() {
		return MasterFile.class;
	}

	@Override
	public String getModelClassName() {
		return MasterFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterFileId", getMasterFileId());
		attributes.put("masterTypeId", getMasterTypeId());
		attributes.put("parentId1", getParentId1());
		attributes.put("parentId2", getParentId2());
		attributes.put("masterFileName", getMasterFileName());
		attributes.put("status1", getStatus1());
		attributes.put("status2", getStatus2());
		attributes.put("status3", getStatus3());
		attributes.put("status4", getStatus4());
		attributes.put("status5", getStatus5());
		attributes.put("masterCode", getMasterCode());
		attributes.put("oldId", getOldId());
		attributes.put("note", getNote());
		attributes.put("inActive", getInActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterFileId = (Long)attributes.get("masterFileId");

		if (masterFileId != null) {
			setMasterFileId(masterFileId);
		}

		Long masterTypeId = (Long)attributes.get("masterTypeId");

		if (masterTypeId != null) {
			setMasterTypeId(masterTypeId);
		}

		Long parentId1 = (Long)attributes.get("parentId1");

		if (parentId1 != null) {
			setParentId1(parentId1);
		}

		Long parentId2 = (Long)attributes.get("parentId2");

		if (parentId2 != null) {
			setParentId2(parentId2);
		}

		String masterFileName = (String)attributes.get("masterFileName");

		if (masterFileName != null) {
			setMasterFileName(masterFileName);
		}

		Boolean status1 = (Boolean)attributes.get("status1");

		if (status1 != null) {
			setStatus1(status1);
		}

		Boolean status2 = (Boolean)attributes.get("status2");

		if (status2 != null) {
			setStatus2(status2);
		}

		Boolean status3 = (Boolean)attributes.get("status3");

		if (status3 != null) {
			setStatus3(status3);
		}

		Boolean status4 = (Boolean)attributes.get("status4");

		if (status4 != null) {
			setStatus4(status4);
		}

		Boolean status5 = (Boolean)attributes.get("status5");

		if (status5 != null) {
			setStatus5(status5);
		}

		String masterCode = (String)attributes.get("masterCode");

		if (masterCode != null) {
			setMasterCode(masterCode);
		}

		Long oldId = (Long)attributes.get("oldId");

		if (oldId != null) {
			setOldId(oldId);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Boolean inActive = (Boolean)attributes.get("inActive");

		if (inActive != null) {
			setInActive(inActive);
		}
	}

	/**
	* Returns the primary key of this master file.
	*
	* @return the primary key of this master file
	*/
	@Override
	public long getPrimaryKey() {
		return _masterFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this master file.
	*
	* @param primaryKey the primary key of this master file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_masterFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the master file ID of this master file.
	*
	* @return the master file ID of this master file
	*/
	@Override
	public long getMasterFileId() {
		return _masterFile.getMasterFileId();
	}

	/**
	* Sets the master file ID of this master file.
	*
	* @param masterFileId the master file ID of this master file
	*/
	@Override
	public void setMasterFileId(long masterFileId) {
		_masterFile.setMasterFileId(masterFileId);
	}

	/**
	* Returns the master type ID of this master file.
	*
	* @return the master type ID of this master file
	*/
	@Override
	public long getMasterTypeId() {
		return _masterFile.getMasterTypeId();
	}

	/**
	* Sets the master type ID of this master file.
	*
	* @param masterTypeId the master type ID of this master file
	*/
	@Override
	public void setMasterTypeId(long masterTypeId) {
		_masterFile.setMasterTypeId(masterTypeId);
	}

	/**
	* Returns the parent id1 of this master file.
	*
	* @return the parent id1 of this master file
	*/
	@Override
	public long getParentId1() {
		return _masterFile.getParentId1();
	}

	/**
	* Sets the parent id1 of this master file.
	*
	* @param parentId1 the parent id1 of this master file
	*/
	@Override
	public void setParentId1(long parentId1) {
		_masterFile.setParentId1(parentId1);
	}

	/**
	* Returns the parent id2 of this master file.
	*
	* @return the parent id2 of this master file
	*/
	@Override
	public long getParentId2() {
		return _masterFile.getParentId2();
	}

	/**
	* Sets the parent id2 of this master file.
	*
	* @param parentId2 the parent id2 of this master file
	*/
	@Override
	public void setParentId2(long parentId2) {
		_masterFile.setParentId2(parentId2);
	}

	/**
	* Returns the master file name of this master file.
	*
	* @return the master file name of this master file
	*/
	@Override
	public java.lang.String getMasterFileName() {
		return _masterFile.getMasterFileName();
	}

	/**
	* Sets the master file name of this master file.
	*
	* @param masterFileName the master file name of this master file
	*/
	@Override
	public void setMasterFileName(java.lang.String masterFileName) {
		_masterFile.setMasterFileName(masterFileName);
	}

	/**
	* Returns the status1 of this master file.
	*
	* @return the status1 of this master file
	*/
	@Override
	public boolean getStatus1() {
		return _masterFile.getStatus1();
	}

	/**
	* Returns <code>true</code> if this master file is status1.
	*
	* @return <code>true</code> if this master file is status1; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus1() {
		return _masterFile.isStatus1();
	}

	/**
	* Sets whether this master file is status1.
	*
	* @param status1 the status1 of this master file
	*/
	@Override
	public void setStatus1(boolean status1) {
		_masterFile.setStatus1(status1);
	}

	/**
	* Returns the status2 of this master file.
	*
	* @return the status2 of this master file
	*/
	@Override
	public boolean getStatus2() {
		return _masterFile.getStatus2();
	}

	/**
	* Returns <code>true</code> if this master file is status2.
	*
	* @return <code>true</code> if this master file is status2; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus2() {
		return _masterFile.isStatus2();
	}

	/**
	* Sets whether this master file is status2.
	*
	* @param status2 the status2 of this master file
	*/
	@Override
	public void setStatus2(boolean status2) {
		_masterFile.setStatus2(status2);
	}

	/**
	* Returns the status3 of this master file.
	*
	* @return the status3 of this master file
	*/
	@Override
	public boolean getStatus3() {
		return _masterFile.getStatus3();
	}

	/**
	* Returns <code>true</code> if this master file is status3.
	*
	* @return <code>true</code> if this master file is status3; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus3() {
		return _masterFile.isStatus3();
	}

	/**
	* Sets whether this master file is status3.
	*
	* @param status3 the status3 of this master file
	*/
	@Override
	public void setStatus3(boolean status3) {
		_masterFile.setStatus3(status3);
	}

	/**
	* Returns the status4 of this master file.
	*
	* @return the status4 of this master file
	*/
	@Override
	public boolean getStatus4() {
		return _masterFile.getStatus4();
	}

	/**
	* Returns <code>true</code> if this master file is status4.
	*
	* @return <code>true</code> if this master file is status4; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus4() {
		return _masterFile.isStatus4();
	}

	/**
	* Sets whether this master file is status4.
	*
	* @param status4 the status4 of this master file
	*/
	@Override
	public void setStatus4(boolean status4) {
		_masterFile.setStatus4(status4);
	}

	/**
	* Returns the status5 of this master file.
	*
	* @return the status5 of this master file
	*/
	@Override
	public boolean getStatus5() {
		return _masterFile.getStatus5();
	}

	/**
	* Returns <code>true</code> if this master file is status5.
	*
	* @return <code>true</code> if this master file is status5; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus5() {
		return _masterFile.isStatus5();
	}

	/**
	* Sets whether this master file is status5.
	*
	* @param status5 the status5 of this master file
	*/
	@Override
	public void setStatus5(boolean status5) {
		_masterFile.setStatus5(status5);
	}

	/**
	* Returns the master code of this master file.
	*
	* @return the master code of this master file
	*/
	@Override
	public java.lang.String getMasterCode() {
		return _masterFile.getMasterCode();
	}

	/**
	* Sets the master code of this master file.
	*
	* @param masterCode the master code of this master file
	*/
	@Override
	public void setMasterCode(java.lang.String masterCode) {
		_masterFile.setMasterCode(masterCode);
	}

	/**
	* Returns the old ID of this master file.
	*
	* @return the old ID of this master file
	*/
	@Override
	public long getOldId() {
		return _masterFile.getOldId();
	}

	/**
	* Sets the old ID of this master file.
	*
	* @param oldId the old ID of this master file
	*/
	@Override
	public void setOldId(long oldId) {
		_masterFile.setOldId(oldId);
	}

	/**
	* Returns the note of this master file.
	*
	* @return the note of this master file
	*/
	@Override
	public java.lang.String getNote() {
		return _masterFile.getNote();
	}

	/**
	* Sets the note of this master file.
	*
	* @param note the note of this master file
	*/
	@Override
	public void setNote(java.lang.String note) {
		_masterFile.setNote(note);
	}

	/**
	* Returns the in active of this master file.
	*
	* @return the in active of this master file
	*/
	@Override
	public boolean getInActive() {
		return _masterFile.getInActive();
	}

	/**
	* Returns <code>true</code> if this master file is in active.
	*
	* @return <code>true</code> if this master file is in active; <code>false</code> otherwise
	*/
	@Override
	public boolean isInActive() {
		return _masterFile.isInActive();
	}

	/**
	* Sets whether this master file is in active.
	*
	* @param inActive the in active of this master file
	*/
	@Override
	public void setInActive(boolean inActive) {
		_masterFile.setInActive(inActive);
	}

	@Override
	public boolean isNew() {
		return _masterFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_masterFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _masterFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_masterFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _masterFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _masterFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_masterFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _masterFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_masterFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_masterFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_masterFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MasterFileWrapper((MasterFile)_masterFile.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.MasterFile masterFile) {
		return _masterFile.compareTo(masterFile);
	}

	@Override
	public int hashCode() {
		return _masterFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.MasterFile> toCacheModel() {
		return _masterFile.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.MasterFile toEscapedModel() {
		return new MasterFileWrapper(_masterFile.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.MasterFile toUnescapedModel() {
		return new MasterFileWrapper(_masterFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _masterFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _masterFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_masterFile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MasterFileWrapper)) {
			return false;
		}

		MasterFileWrapper masterFileWrapper = (MasterFileWrapper)obj;

		if (Validator.equals(_masterFile, masterFileWrapper._masterFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MasterFile getWrappedMasterFile() {
		return _masterFile;
	}

	@Override
	public MasterFile getWrappedModel() {
		return _masterFile;
	}

	@Override
	public void resetOriginalValues() {
		_masterFile.resetOriginalValues();
	}

	private MasterFile _masterFile;
}
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
 * This class is a wrapper for {@link MasterType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterType
 * @generated
 */
public class MasterTypeWrapper implements MasterType, ModelWrapper<MasterType> {
	public MasterTypeWrapper(MasterType masterType) {
		_masterType = masterType;
	}

	@Override
	public Class<?> getModelClass() {
		return MasterType.class;
	}

	@Override
	public String getModelClassName() {
		return MasterType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterTypeId", getMasterTypeId());
		attributes.put("masterTypeName", getMasterTypeName());
		attributes.put("status", getStatus());
		attributes.put("parentType", getParentType());
		attributes.put("pageLabel", getPageLabel());
		attributes.put("nameLabel", getNameLabel());
		attributes.put("hasParent1", getHasParent1());
		attributes.put("parentId1", getParentId1());
		attributes.put("parentId2", getParentId2());
		attributes.put("hasParent2", getHasParent2());
		attributes.put("parent1Label", getParent1Label());
		attributes.put("parent2Label", getParent2Label());
		attributes.put("hasStatus1", getHasStatus1());
		attributes.put("hasStatus2", getHasStatus2());
		attributes.put("hasStatus3", getHasStatus3());
		attributes.put("hasStatus4", getHasStatus4());
		attributes.put("hasStatus5", getHasStatus5());
		attributes.put("status1Label", getStatus1Label());
		attributes.put("status2Label", getStatus2Label());
		attributes.put("status3Label", getStatus3Label());
		attributes.put("status4Label", getStatus4Label());
		attributes.put("status5Label", getStatus5Label());
		attributes.put("hasCode", getHasCode());
		attributes.put("codeLabel", getCodeLabel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterTypeId = (Long)attributes.get("masterTypeId");

		if (masterTypeId != null) {
			setMasterTypeId(masterTypeId);
		}

		String masterTypeName = (String)attributes.get("masterTypeName");

		if (masterTypeName != null) {
			setMasterTypeName(masterTypeName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean parentType = (Boolean)attributes.get("parentType");

		if (parentType != null) {
			setParentType(parentType);
		}

		String pageLabel = (String)attributes.get("pageLabel");

		if (pageLabel != null) {
			setPageLabel(pageLabel);
		}

		String nameLabel = (String)attributes.get("nameLabel");

		if (nameLabel != null) {
			setNameLabel(nameLabel);
		}

		Boolean hasParent1 = (Boolean)attributes.get("hasParent1");

		if (hasParent1 != null) {
			setHasParent1(hasParent1);
		}

		Long parentId1 = (Long)attributes.get("parentId1");

		if (parentId1 != null) {
			setParentId1(parentId1);
		}

		Long parentId2 = (Long)attributes.get("parentId2");

		if (parentId2 != null) {
			setParentId2(parentId2);
		}

		Boolean hasParent2 = (Boolean)attributes.get("hasParent2");

		if (hasParent2 != null) {
			setHasParent2(hasParent2);
		}

		String parent1Label = (String)attributes.get("parent1Label");

		if (parent1Label != null) {
			setParent1Label(parent1Label);
		}

		String parent2Label = (String)attributes.get("parent2Label");

		if (parent2Label != null) {
			setParent2Label(parent2Label);
		}

		Boolean hasStatus1 = (Boolean)attributes.get("hasStatus1");

		if (hasStatus1 != null) {
			setHasStatus1(hasStatus1);
		}

		Boolean hasStatus2 = (Boolean)attributes.get("hasStatus2");

		if (hasStatus2 != null) {
			setHasStatus2(hasStatus2);
		}

		Boolean hasStatus3 = (Boolean)attributes.get("hasStatus3");

		if (hasStatus3 != null) {
			setHasStatus3(hasStatus3);
		}

		Boolean hasStatus4 = (Boolean)attributes.get("hasStatus4");

		if (hasStatus4 != null) {
			setHasStatus4(hasStatus4);
		}

		Boolean hasStatus5 = (Boolean)attributes.get("hasStatus5");

		if (hasStatus5 != null) {
			setHasStatus5(hasStatus5);
		}

		String status1Label = (String)attributes.get("status1Label");

		if (status1Label != null) {
			setStatus1Label(status1Label);
		}

		String status2Label = (String)attributes.get("status2Label");

		if (status2Label != null) {
			setStatus2Label(status2Label);
		}

		String status3Label = (String)attributes.get("status3Label");

		if (status3Label != null) {
			setStatus3Label(status3Label);
		}

		String status4Label = (String)attributes.get("status4Label");

		if (status4Label != null) {
			setStatus4Label(status4Label);
		}

		String status5Label = (String)attributes.get("status5Label");

		if (status5Label != null) {
			setStatus5Label(status5Label);
		}

		Boolean hasCode = (Boolean)attributes.get("hasCode");

		if (hasCode != null) {
			setHasCode(hasCode);
		}

		String codeLabel = (String)attributes.get("codeLabel");

		if (codeLabel != null) {
			setCodeLabel(codeLabel);
		}
	}

	/**
	* Returns the primary key of this master type.
	*
	* @return the primary key of this master type
	*/
	@Override
	public long getPrimaryKey() {
		return _masterType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this master type.
	*
	* @param primaryKey the primary key of this master type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_masterType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the master type ID of this master type.
	*
	* @return the master type ID of this master type
	*/
	@Override
	public long getMasterTypeId() {
		return _masterType.getMasterTypeId();
	}

	/**
	* Sets the master type ID of this master type.
	*
	* @param masterTypeId the master type ID of this master type
	*/
	@Override
	public void setMasterTypeId(long masterTypeId) {
		_masterType.setMasterTypeId(masterTypeId);
	}

	/**
	* Returns the master type name of this master type.
	*
	* @return the master type name of this master type
	*/
	@Override
	public java.lang.String getMasterTypeName() {
		return _masterType.getMasterTypeName();
	}

	/**
	* Sets the master type name of this master type.
	*
	* @param masterTypeName the master type name of this master type
	*/
	@Override
	public void setMasterTypeName(java.lang.String masterTypeName) {
		_masterType.setMasterTypeName(masterTypeName);
	}

	/**
	* Returns the status of this master type.
	*
	* @return the status of this master type
	*/
	@Override
	public int getStatus() {
		return _masterType.getStatus();
	}

	/**
	* Sets the status of this master type.
	*
	* @param status the status of this master type
	*/
	@Override
	public void setStatus(int status) {
		_masterType.setStatus(status);
	}

	/**
	* Returns the parent type of this master type.
	*
	* @return the parent type of this master type
	*/
	@Override
	public boolean getParentType() {
		return _masterType.getParentType();
	}

	/**
	* Returns <code>true</code> if this master type is parent type.
	*
	* @return <code>true</code> if this master type is parent type; <code>false</code> otherwise
	*/
	@Override
	public boolean isParentType() {
		return _masterType.isParentType();
	}

	/**
	* Sets whether this master type is parent type.
	*
	* @param parentType the parent type of this master type
	*/
	@Override
	public void setParentType(boolean parentType) {
		_masterType.setParentType(parentType);
	}

	/**
	* Returns the page label of this master type.
	*
	* @return the page label of this master type
	*/
	@Override
	public java.lang.String getPageLabel() {
		return _masterType.getPageLabel();
	}

	/**
	* Sets the page label of this master type.
	*
	* @param pageLabel the page label of this master type
	*/
	@Override
	public void setPageLabel(java.lang.String pageLabel) {
		_masterType.setPageLabel(pageLabel);
	}

	/**
	* Returns the name label of this master type.
	*
	* @return the name label of this master type
	*/
	@Override
	public java.lang.String getNameLabel() {
		return _masterType.getNameLabel();
	}

	/**
	* Sets the name label of this master type.
	*
	* @param nameLabel the name label of this master type
	*/
	@Override
	public void setNameLabel(java.lang.String nameLabel) {
		_masterType.setNameLabel(nameLabel);
	}

	/**
	* Returns the has parent1 of this master type.
	*
	* @return the has parent1 of this master type
	*/
	@Override
	public boolean getHasParent1() {
		return _masterType.getHasParent1();
	}

	/**
	* Returns <code>true</code> if this master type is has parent1.
	*
	* @return <code>true</code> if this master type is has parent1; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasParent1() {
		return _masterType.isHasParent1();
	}

	/**
	* Sets whether this master type is has parent1.
	*
	* @param hasParent1 the has parent1 of this master type
	*/
	@Override
	public void setHasParent1(boolean hasParent1) {
		_masterType.setHasParent1(hasParent1);
	}

	/**
	* Returns the parent id1 of this master type.
	*
	* @return the parent id1 of this master type
	*/
	@Override
	public long getParentId1() {
		return _masterType.getParentId1();
	}

	/**
	* Sets the parent id1 of this master type.
	*
	* @param parentId1 the parent id1 of this master type
	*/
	@Override
	public void setParentId1(long parentId1) {
		_masterType.setParentId1(parentId1);
	}

	/**
	* Returns the parent id2 of this master type.
	*
	* @return the parent id2 of this master type
	*/
	@Override
	public long getParentId2() {
		return _masterType.getParentId2();
	}

	/**
	* Sets the parent id2 of this master type.
	*
	* @param parentId2 the parent id2 of this master type
	*/
	@Override
	public void setParentId2(long parentId2) {
		_masterType.setParentId2(parentId2);
	}

	/**
	* Returns the has parent2 of this master type.
	*
	* @return the has parent2 of this master type
	*/
	@Override
	public boolean getHasParent2() {
		return _masterType.getHasParent2();
	}

	/**
	* Returns <code>true</code> if this master type is has parent2.
	*
	* @return <code>true</code> if this master type is has parent2; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasParent2() {
		return _masterType.isHasParent2();
	}

	/**
	* Sets whether this master type is has parent2.
	*
	* @param hasParent2 the has parent2 of this master type
	*/
	@Override
	public void setHasParent2(boolean hasParent2) {
		_masterType.setHasParent2(hasParent2);
	}

	/**
	* Returns the parent1 label of this master type.
	*
	* @return the parent1 label of this master type
	*/
	@Override
	public java.lang.String getParent1Label() {
		return _masterType.getParent1Label();
	}

	/**
	* Sets the parent1 label of this master type.
	*
	* @param parent1Label the parent1 label of this master type
	*/
	@Override
	public void setParent1Label(java.lang.String parent1Label) {
		_masterType.setParent1Label(parent1Label);
	}

	/**
	* Returns the parent2 label of this master type.
	*
	* @return the parent2 label of this master type
	*/
	@Override
	public java.lang.String getParent2Label() {
		return _masterType.getParent2Label();
	}

	/**
	* Sets the parent2 label of this master type.
	*
	* @param parent2Label the parent2 label of this master type
	*/
	@Override
	public void setParent2Label(java.lang.String parent2Label) {
		_masterType.setParent2Label(parent2Label);
	}

	/**
	* Returns the has status1 of this master type.
	*
	* @return the has status1 of this master type
	*/
	@Override
	public boolean getHasStatus1() {
		return _masterType.getHasStatus1();
	}

	/**
	* Returns <code>true</code> if this master type is has status1.
	*
	* @return <code>true</code> if this master type is has status1; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasStatus1() {
		return _masterType.isHasStatus1();
	}

	/**
	* Sets whether this master type is has status1.
	*
	* @param hasStatus1 the has status1 of this master type
	*/
	@Override
	public void setHasStatus1(boolean hasStatus1) {
		_masterType.setHasStatus1(hasStatus1);
	}

	/**
	* Returns the has status2 of this master type.
	*
	* @return the has status2 of this master type
	*/
	@Override
	public boolean getHasStatus2() {
		return _masterType.getHasStatus2();
	}

	/**
	* Returns <code>true</code> if this master type is has status2.
	*
	* @return <code>true</code> if this master type is has status2; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasStatus2() {
		return _masterType.isHasStatus2();
	}

	/**
	* Sets whether this master type is has status2.
	*
	* @param hasStatus2 the has status2 of this master type
	*/
	@Override
	public void setHasStatus2(boolean hasStatus2) {
		_masterType.setHasStatus2(hasStatus2);
	}

	/**
	* Returns the has status3 of this master type.
	*
	* @return the has status3 of this master type
	*/
	@Override
	public boolean getHasStatus3() {
		return _masterType.getHasStatus3();
	}

	/**
	* Returns <code>true</code> if this master type is has status3.
	*
	* @return <code>true</code> if this master type is has status3; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasStatus3() {
		return _masterType.isHasStatus3();
	}

	/**
	* Sets whether this master type is has status3.
	*
	* @param hasStatus3 the has status3 of this master type
	*/
	@Override
	public void setHasStatus3(boolean hasStatus3) {
		_masterType.setHasStatus3(hasStatus3);
	}

	/**
	* Returns the has status4 of this master type.
	*
	* @return the has status4 of this master type
	*/
	@Override
	public boolean getHasStatus4() {
		return _masterType.getHasStatus4();
	}

	/**
	* Returns <code>true</code> if this master type is has status4.
	*
	* @return <code>true</code> if this master type is has status4; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasStatus4() {
		return _masterType.isHasStatus4();
	}

	/**
	* Sets whether this master type is has status4.
	*
	* @param hasStatus4 the has status4 of this master type
	*/
	@Override
	public void setHasStatus4(boolean hasStatus4) {
		_masterType.setHasStatus4(hasStatus4);
	}

	/**
	* Returns the has status5 of this master type.
	*
	* @return the has status5 of this master type
	*/
	@Override
	public boolean getHasStatus5() {
		return _masterType.getHasStatus5();
	}

	/**
	* Returns <code>true</code> if this master type is has status5.
	*
	* @return <code>true</code> if this master type is has status5; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasStatus5() {
		return _masterType.isHasStatus5();
	}

	/**
	* Sets whether this master type is has status5.
	*
	* @param hasStatus5 the has status5 of this master type
	*/
	@Override
	public void setHasStatus5(boolean hasStatus5) {
		_masterType.setHasStatus5(hasStatus5);
	}

	/**
	* Returns the status1 label of this master type.
	*
	* @return the status1 label of this master type
	*/
	@Override
	public java.lang.String getStatus1Label() {
		return _masterType.getStatus1Label();
	}

	/**
	* Sets the status1 label of this master type.
	*
	* @param status1Label the status1 label of this master type
	*/
	@Override
	public void setStatus1Label(java.lang.String status1Label) {
		_masterType.setStatus1Label(status1Label);
	}

	/**
	* Returns the status2 label of this master type.
	*
	* @return the status2 label of this master type
	*/
	@Override
	public java.lang.String getStatus2Label() {
		return _masterType.getStatus2Label();
	}

	/**
	* Sets the status2 label of this master type.
	*
	* @param status2Label the status2 label of this master type
	*/
	@Override
	public void setStatus2Label(java.lang.String status2Label) {
		_masterType.setStatus2Label(status2Label);
	}

	/**
	* Returns the status3 label of this master type.
	*
	* @return the status3 label of this master type
	*/
	@Override
	public java.lang.String getStatus3Label() {
		return _masterType.getStatus3Label();
	}

	/**
	* Sets the status3 label of this master type.
	*
	* @param status3Label the status3 label of this master type
	*/
	@Override
	public void setStatus3Label(java.lang.String status3Label) {
		_masterType.setStatus3Label(status3Label);
	}

	/**
	* Returns the status4 label of this master type.
	*
	* @return the status4 label of this master type
	*/
	@Override
	public java.lang.String getStatus4Label() {
		return _masterType.getStatus4Label();
	}

	/**
	* Sets the status4 label of this master type.
	*
	* @param status4Label the status4 label of this master type
	*/
	@Override
	public void setStatus4Label(java.lang.String status4Label) {
		_masterType.setStatus4Label(status4Label);
	}

	/**
	* Returns the status5 label of this master type.
	*
	* @return the status5 label of this master type
	*/
	@Override
	public java.lang.String getStatus5Label() {
		return _masterType.getStatus5Label();
	}

	/**
	* Sets the status5 label of this master type.
	*
	* @param status5Label the status5 label of this master type
	*/
	@Override
	public void setStatus5Label(java.lang.String status5Label) {
		_masterType.setStatus5Label(status5Label);
	}

	/**
	* Returns the has code of this master type.
	*
	* @return the has code of this master type
	*/
	@Override
	public boolean getHasCode() {
		return _masterType.getHasCode();
	}

	/**
	* Returns <code>true</code> if this master type is has code.
	*
	* @return <code>true</code> if this master type is has code; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasCode() {
		return _masterType.isHasCode();
	}

	/**
	* Sets whether this master type is has code.
	*
	* @param hasCode the has code of this master type
	*/
	@Override
	public void setHasCode(boolean hasCode) {
		_masterType.setHasCode(hasCode);
	}

	/**
	* Returns the code label of this master type.
	*
	* @return the code label of this master type
	*/
	@Override
	public java.lang.String getCodeLabel() {
		return _masterType.getCodeLabel();
	}

	/**
	* Sets the code label of this master type.
	*
	* @param codeLabel the code label of this master type
	*/
	@Override
	public void setCodeLabel(java.lang.String codeLabel) {
		_masterType.setCodeLabel(codeLabel);
	}

	@Override
	public boolean isNew() {
		return _masterType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_masterType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _masterType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_masterType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _masterType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _masterType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_masterType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _masterType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_masterType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_masterType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_masterType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MasterTypeWrapper((MasterType)_masterType.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.MasterType masterType) {
		return _masterType.compareTo(masterType);
	}

	@Override
	public int hashCode() {
		return _masterType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.MasterType> toCacheModel() {
		return _masterType.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.MasterType toEscapedModel() {
		return new MasterTypeWrapper(_masterType.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.MasterType toUnescapedModel() {
		return new MasterTypeWrapper(_masterType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _masterType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _masterType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_masterType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MasterTypeWrapper)) {
			return false;
		}

		MasterTypeWrapper masterTypeWrapper = (MasterTypeWrapper)obj;

		if (Validator.equals(_masterType, masterTypeWrapper._masterType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MasterType getWrappedMasterType() {
		return _masterType;
	}

	@Override
	public MasterType getWrappedModel() {
		return _masterType;
	}

	@Override
	public void resetOriginalValues() {
		_masterType.resetOriginalValues();
	}

	private MasterType _masterType;
}
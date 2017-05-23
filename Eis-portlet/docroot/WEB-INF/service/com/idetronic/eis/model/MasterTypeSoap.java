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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.MasterTypeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.MasterTypeServiceSoap
 * @generated
 */
public class MasterTypeSoap implements Serializable {
	public static MasterTypeSoap toSoapModel(MasterType model) {
		MasterTypeSoap soapModel = new MasterTypeSoap();

		soapModel.setMasterTypeId(model.getMasterTypeId());
		soapModel.setMasterTypeName(model.getMasterTypeName());
		soapModel.setStatus(model.getStatus());
		soapModel.setParentType(model.getParentType());
		soapModel.setPageLabel(model.getPageLabel());
		soapModel.setNameLabel(model.getNameLabel());
		soapModel.setHasParent1(model.getHasParent1());
		soapModel.setParentId1(model.getParentId1());
		soapModel.setParentId2(model.getParentId2());
		soapModel.setHasParent2(model.getHasParent2());
		soapModel.setParent1Label(model.getParent1Label());
		soapModel.setParent2Label(model.getParent2Label());
		soapModel.setHasStatus1(model.getHasStatus1());
		soapModel.setHasStatus2(model.getHasStatus2());
		soapModel.setHasStatus3(model.getHasStatus3());
		soapModel.setHasStatus4(model.getHasStatus4());
		soapModel.setStatus1Label(model.getStatus1Label());
		soapModel.setStatus2Label(model.getStatus2Label());
		soapModel.setStatus3Label(model.getStatus3Label());
		soapModel.setStatus4Label(model.getStatus4Label());
		soapModel.setHasCode(model.getHasCode());
		soapModel.setCodeLabel(model.getCodeLabel());

		return soapModel;
	}

	public static MasterTypeSoap[] toSoapModels(MasterType[] models) {
		MasterTypeSoap[] soapModels = new MasterTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterTypeSoap[][] toSoapModels(MasterType[][] models) {
		MasterTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterTypeSoap[] toSoapModels(List<MasterType> models) {
		List<MasterTypeSoap> soapModels = new ArrayList<MasterTypeSoap>(models.size());

		for (MasterType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterTypeSoap[soapModels.size()]);
	}

	public MasterTypeSoap() {
	}

	public long getPrimaryKey() {
		return _masterTypeId;
	}

	public void setPrimaryKey(long pk) {
		setMasterTypeId(pk);
	}

	public long getMasterTypeId() {
		return _masterTypeId;
	}

	public void setMasterTypeId(long masterTypeId) {
		_masterTypeId = masterTypeId;
	}

	public String getMasterTypeName() {
		return _masterTypeName;
	}

	public void setMasterTypeName(String masterTypeName) {
		_masterTypeName = masterTypeName;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public boolean getParentType() {
		return _parentType;
	}

	public boolean isParentType() {
		return _parentType;
	}

	public void setParentType(boolean parentType) {
		_parentType = parentType;
	}

	public String getPageLabel() {
		return _pageLabel;
	}

	public void setPageLabel(String pageLabel) {
		_pageLabel = pageLabel;
	}

	public String getNameLabel() {
		return _nameLabel;
	}

	public void setNameLabel(String nameLabel) {
		_nameLabel = nameLabel;
	}

	public boolean getHasParent1() {
		return _hasParent1;
	}

	public boolean isHasParent1() {
		return _hasParent1;
	}

	public void setHasParent1(boolean hasParent1) {
		_hasParent1 = hasParent1;
	}

	public long getParentId1() {
		return _parentId1;
	}

	public void setParentId1(long parentId1) {
		_parentId1 = parentId1;
	}

	public long getParentId2() {
		return _parentId2;
	}

	public void setParentId2(long parentId2) {
		_parentId2 = parentId2;
	}

	public boolean getHasParent2() {
		return _hasParent2;
	}

	public boolean isHasParent2() {
		return _hasParent2;
	}

	public void setHasParent2(boolean hasParent2) {
		_hasParent2 = hasParent2;
	}

	public String getParent1Label() {
		return _parent1Label;
	}

	public void setParent1Label(String parent1Label) {
		_parent1Label = parent1Label;
	}

	public String getParent2Label() {
		return _parent2Label;
	}

	public void setParent2Label(String parent2Label) {
		_parent2Label = parent2Label;
	}

	public boolean getHasStatus1() {
		return _hasStatus1;
	}

	public boolean isHasStatus1() {
		return _hasStatus1;
	}

	public void setHasStatus1(boolean hasStatus1) {
		_hasStatus1 = hasStatus1;
	}

	public boolean getHasStatus2() {
		return _hasStatus2;
	}

	public boolean isHasStatus2() {
		return _hasStatus2;
	}

	public void setHasStatus2(boolean hasStatus2) {
		_hasStatus2 = hasStatus2;
	}

	public boolean getHasStatus3() {
		return _hasStatus3;
	}

	public boolean isHasStatus3() {
		return _hasStatus3;
	}

	public void setHasStatus3(boolean hasStatus3) {
		_hasStatus3 = hasStatus3;
	}

	public boolean getHasStatus4() {
		return _hasStatus4;
	}

	public boolean isHasStatus4() {
		return _hasStatus4;
	}

	public void setHasStatus4(boolean hasStatus4) {
		_hasStatus4 = hasStatus4;
	}

	public String getStatus1Label() {
		return _status1Label;
	}

	public void setStatus1Label(String status1Label) {
		_status1Label = status1Label;
	}

	public String getStatus2Label() {
		return _status2Label;
	}

	public void setStatus2Label(String status2Label) {
		_status2Label = status2Label;
	}

	public String getStatus3Label() {
		return _status3Label;
	}

	public void setStatus3Label(String status3Label) {
		_status3Label = status3Label;
	}

	public String getStatus4Label() {
		return _status4Label;
	}

	public void setStatus4Label(String status4Label) {
		_status4Label = status4Label;
	}

	public boolean getHasCode() {
		return _hasCode;
	}

	public boolean isHasCode() {
		return _hasCode;
	}

	public void setHasCode(boolean hasCode) {
		_hasCode = hasCode;
	}

	public String getCodeLabel() {
		return _codeLabel;
	}

	public void setCodeLabel(String codeLabel) {
		_codeLabel = codeLabel;
	}

	private long _masterTypeId;
	private String _masterTypeName;
	private int _status;
	private boolean _parentType;
	private String _pageLabel;
	private String _nameLabel;
	private boolean _hasParent1;
	private long _parentId1;
	private long _parentId2;
	private boolean _hasParent2;
	private String _parent1Label;
	private String _parent2Label;
	private boolean _hasStatus1;
	private boolean _hasStatus2;
	private boolean _hasStatus3;
	private boolean _hasStatus4;
	private String _status1Label;
	private String _status2Label;
	private String _status3Label;
	private String _status4Label;
	private boolean _hasCode;
	private String _codeLabel;
}
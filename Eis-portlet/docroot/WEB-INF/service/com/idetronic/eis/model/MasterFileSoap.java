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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.MasterFileServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.MasterFileServiceSoap
 * @generated
 */
public class MasterFileSoap implements Serializable {
	public static MasterFileSoap toSoapModel(MasterFile model) {
		MasterFileSoap soapModel = new MasterFileSoap();

		soapModel.setMasterFileId(model.getMasterFileId());
		soapModel.setMasterTypeId(model.getMasterTypeId());
		soapModel.setParentId1(model.getParentId1());
		soapModel.setParentId2(model.getParentId2());
		soapModel.setMasterFileName(model.getMasterFileName());
		soapModel.setStatus1(model.getStatus1());
		soapModel.setStatus2(model.getStatus2());
		soapModel.setStatus3(model.getStatus3());
		soapModel.setStatus4(model.getStatus4());
		soapModel.setMasterCode(model.getMasterCode());
		soapModel.setOldId(model.getOldId());
		soapModel.setNote(model.getNote());
		soapModel.setInActive(model.getInActive());

		return soapModel;
	}

	public static MasterFileSoap[] toSoapModels(MasterFile[] models) {
		MasterFileSoap[] soapModels = new MasterFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterFileSoap[][] toSoapModels(MasterFile[][] models) {
		MasterFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterFileSoap[] toSoapModels(List<MasterFile> models) {
		List<MasterFileSoap> soapModels = new ArrayList<MasterFileSoap>(models.size());

		for (MasterFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterFileSoap[soapModels.size()]);
	}

	public MasterFileSoap() {
	}

	public long getPrimaryKey() {
		return _masterFileId;
	}

	public void setPrimaryKey(long pk) {
		setMasterFileId(pk);
	}

	public long getMasterFileId() {
		return _masterFileId;
	}

	public void setMasterFileId(long masterFileId) {
		_masterFileId = masterFileId;
	}

	public long getMasterTypeId() {
		return _masterTypeId;
	}

	public void setMasterTypeId(long masterTypeId) {
		_masterTypeId = masterTypeId;
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

	public String getMasterFileName() {
		return _masterFileName;
	}

	public void setMasterFileName(String masterFileName) {
		_masterFileName = masterFileName;
	}

	public boolean getStatus1() {
		return _status1;
	}

	public boolean isStatus1() {
		return _status1;
	}

	public void setStatus1(boolean status1) {
		_status1 = status1;
	}

	public boolean getStatus2() {
		return _status2;
	}

	public boolean isStatus2() {
		return _status2;
	}

	public void setStatus2(boolean status2) {
		_status2 = status2;
	}

	public boolean getStatus3() {
		return _status3;
	}

	public boolean isStatus3() {
		return _status3;
	}

	public void setStatus3(boolean status3) {
		_status3 = status3;
	}

	public boolean getStatus4() {
		return _status4;
	}

	public boolean isStatus4() {
		return _status4;
	}

	public void setStatus4(boolean status4) {
		_status4 = status4;
	}

	public String getMasterCode() {
		return _masterCode;
	}

	public void setMasterCode(String masterCode) {
		_masterCode = masterCode;
	}

	public long getOldId() {
		return _oldId;
	}

	public void setOldId(long oldId) {
		_oldId = oldId;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public boolean getInActive() {
		return _inActive;
	}

	public boolean isInActive() {
		return _inActive;
	}

	public void setInActive(boolean inActive) {
		_inActive = inActive;
	}

	private long _masterFileId;
	private long _masterTypeId;
	private long _parentId1;
	private long _parentId2;
	private String _masterFileName;
	private boolean _status1;
	private boolean _status2;
	private boolean _status3;
	private boolean _status4;
	private String _masterCode;
	private long _oldId;
	private String _note;
	private boolean _inActive;
}
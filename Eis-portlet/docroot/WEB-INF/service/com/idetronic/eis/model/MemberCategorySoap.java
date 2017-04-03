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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.MemberCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.MemberCategoryServiceSoap
 * @generated
 */
public class MemberCategorySoap implements Serializable {
	public static MemberCategorySoap toSoapModel(MemberCategory model) {
		MemberCategorySoap soapModel = new MemberCategorySoap();

		soapModel.setMemberCategoryId(model.getMemberCategoryId());
		soapModel.setMemberCategoryName(model.getMemberCategoryName());
		soapModel.setMemberCategoryGroupName(model.getMemberCategoryGroupName());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static MemberCategorySoap[] toSoapModels(MemberCategory[] models) {
		MemberCategorySoap[] soapModels = new MemberCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberCategorySoap[][] toSoapModels(MemberCategory[][] models) {
		MemberCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberCategorySoap[] toSoapModels(List<MemberCategory> models) {
		List<MemberCategorySoap> soapModels = new ArrayList<MemberCategorySoap>(models.size());

		for (MemberCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberCategorySoap[soapModels.size()]);
	}

	public MemberCategorySoap() {
	}

	public long getPrimaryKey() {
		return _memberCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setMemberCategoryId(pk);
	}

	public long getMemberCategoryId() {
		return _memberCategoryId;
	}

	public void setMemberCategoryId(long memberCategoryId) {
		_memberCategoryId = memberCategoryId;
	}

	public String getMemberCategoryName() {
		return _memberCategoryName;
	}

	public void setMemberCategoryName(String memberCategoryName) {
		_memberCategoryName = memberCategoryName;
	}

	public String getMemberCategoryGroupName() {
		return _memberCategoryGroupName;
	}

	public void setMemberCategoryGroupName(String memberCategoryGroupName) {
		_memberCategoryGroupName = memberCategoryGroupName;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _memberCategoryId;
	private String _memberCategoryName;
	private String _memberCategoryGroupName;
	private boolean _active;
}
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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.PostGradeServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.PostGradeServiceSoap
 * @generated
 */
public class PostGradeSoap implements Serializable {
	public static PostGradeSoap toSoapModel(PostGrade model) {
		PostGradeSoap soapModel = new PostGradeSoap();

		soapModel.setPostGradeId(model.getPostGradeId());
		soapModel.setPostCategoryId(model.getPostCategoryId());
		soapModel.setPostGradeCode(model.getPostGradeCode());
		soapModel.setPostGradeScheme(model.getPostGradeScheme());
		soapModel.setPostGradeName(model.getPostGradeName());
		soapModel.setPostGradeDesc(model.getPostGradeDesc());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PostGradeSoap[] toSoapModels(PostGrade[] models) {
		PostGradeSoap[] soapModels = new PostGradeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostGradeSoap[][] toSoapModels(PostGrade[][] models) {
		PostGradeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PostGradeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostGradeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostGradeSoap[] toSoapModels(List<PostGrade> models) {
		List<PostGradeSoap> soapModels = new ArrayList<PostGradeSoap>(models.size());

		for (PostGrade model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostGradeSoap[soapModels.size()]);
	}

	public PostGradeSoap() {
	}

	public long getPrimaryKey() {
		return _postGradeId;
	}

	public void setPrimaryKey(long pk) {
		setPostGradeId(pk);
	}

	public long getPostGradeId() {
		return _postGradeId;
	}

	public void setPostGradeId(long postGradeId) {
		_postGradeId = postGradeId;
	}

	public long getPostCategoryId() {
		return _postCategoryId;
	}

	public void setPostCategoryId(long postCategoryId) {
		_postCategoryId = postCategoryId;
	}

	public String getPostGradeCode() {
		return _postGradeCode;
	}

	public void setPostGradeCode(String postGradeCode) {
		_postGradeCode = postGradeCode;
	}

	public String getPostGradeScheme() {
		return _postGradeScheme;
	}

	public void setPostGradeScheme(String postGradeScheme) {
		_postGradeScheme = postGradeScheme;
	}

	public String getPostGradeName() {
		return _postGradeName;
	}

	public void setPostGradeName(String postGradeName) {
		_postGradeName = postGradeName;
	}

	public String getPostGradeDesc() {
		return _postGradeDesc;
	}

	public void setPostGradeDesc(String postGradeDesc) {
		_postGradeDesc = postGradeDesc;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _postGradeId;
	private long _postCategoryId;
	private String _postGradeCode;
	private String _postGradeScheme;
	private String _postGradeName;
	private String _postGradeDesc;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
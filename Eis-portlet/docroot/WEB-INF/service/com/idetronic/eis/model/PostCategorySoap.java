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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.PostCategoryServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.PostCategoryServiceSoap
 * @generated
 */
public class PostCategorySoap implements Serializable {
	public static PostCategorySoap toSoapModel(PostCategory model) {
		PostCategorySoap soapModel = new PostCategorySoap();

		soapModel.setPostCategoryId(model.getPostCategoryId());
		soapModel.setPostCategoryCode(model.getPostCategoryCode());
		soapModel.setPostCategoryName(model.getPostCategoryName());

		return soapModel;
	}

	public static PostCategorySoap[] toSoapModels(PostCategory[] models) {
		PostCategorySoap[] soapModels = new PostCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostCategorySoap[][] toSoapModels(PostCategory[][] models) {
		PostCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PostCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostCategorySoap[] toSoapModels(List<PostCategory> models) {
		List<PostCategorySoap> soapModels = new ArrayList<PostCategorySoap>(models.size());

		for (PostCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostCategorySoap[soapModels.size()]);
	}

	public PostCategorySoap() {
	}

	public long getPrimaryKey() {
		return _postCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setPostCategoryId(pk);
	}

	public long getPostCategoryId() {
		return _postCategoryId;
	}

	public void setPostCategoryId(long postCategoryId) {
		_postCategoryId = postCategoryId;
	}

	public String getPostCategoryCode() {
		return _postCategoryCode;
	}

	public void setPostCategoryCode(String postCategoryCode) {
		_postCategoryCode = postCategoryCode;
	}

	public String getPostCategoryName() {
		return _postCategoryName;
	}

	public void setPostCategoryName(String postCategoryName) {
		_postCategoryName = postCategoryName;
	}

	private long _postCategoryId;
	private String _postCategoryCode;
	private String _postCategoryName;
}
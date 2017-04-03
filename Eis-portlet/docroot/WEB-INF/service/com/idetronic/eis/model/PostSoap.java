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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.PostServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.PostServiceSoap
 * @generated
 */
public class PostSoap implements Serializable {
	public static PostSoap toSoapModel(Post model) {
		PostSoap soapModel = new PostSoap();

		soapModel.setPostId(model.getPostId());
		soapModel.setPostCategoryId(model.getPostCategoryId());
		soapModel.setPostName(model.getPostName());

		return soapModel;
	}

	public static PostSoap[] toSoapModels(Post[] models) {
		PostSoap[] soapModels = new PostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostSoap[][] toSoapModels(Post[][] models) {
		PostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostSoap[] toSoapModels(List<Post> models) {
		List<PostSoap> soapModels = new ArrayList<PostSoap>(models.size());

		for (Post model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostSoap[soapModels.size()]);
	}

	public PostSoap() {
	}

	public long getPrimaryKey() {
		return _postId;
	}

	public void setPrimaryKey(long pk) {
		setPostId(pk);
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getPostCategoryId() {
		return _postCategoryId;
	}

	public void setPostCategoryId(long postCategoryId) {
		_postCategoryId = postCategoryId;
	}

	public String getPostName() {
		return _postName;
	}

	public void setPostName(String postName) {
		_postName = postName;
	}

	private long _postId;
	private long _postCategoryId;
	private String _postName;
}
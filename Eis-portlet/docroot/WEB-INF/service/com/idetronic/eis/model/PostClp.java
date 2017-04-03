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

import com.idetronic.eis.service.ClpSerializer;
import com.idetronic.eis.service.PostLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class PostClp extends BaseModelImpl<Post> implements Post {
	public PostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Post.class;
	}

	@Override
	public String getModelClassName() {
		return Post.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _postId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _postId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postId", getPostId());
		attributes.put("postCategoryId", getPostCategoryId());
		attributes.put("postName", getPostName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long postCategoryId = (Long)attributes.get("postCategoryId");

		if (postCategoryId != null) {
			setPostCategoryId(postCategoryId);
		}

		String postName = (String)attributes.get("postName");

		if (postName != null) {
			setPostName(postName);
		}
	}

	@Override
	public long getPostId() {
		return _postId;
	}

	@Override
	public void setPostId(long postId) {
		_postId = postId;

		if (_postRemoteModel != null) {
			try {
				Class<?> clazz = _postRemoteModel.getClass();

				Method method = clazz.getMethod("setPostId", long.class);

				method.invoke(_postRemoteModel, postId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPostCategoryId() {
		return _postCategoryId;
	}

	@Override
	public void setPostCategoryId(long postCategoryId) {
		_postCategoryId = postCategoryId;

		if (_postRemoteModel != null) {
			try {
				Class<?> clazz = _postRemoteModel.getClass();

				Method method = clazz.getMethod("setPostCategoryId", long.class);

				method.invoke(_postRemoteModel, postCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostName() {
		return _postName;
	}

	@Override
	public void setPostName(String postName) {
		_postName = postName;

		if (_postRemoteModel != null) {
			try {
				Class<?> clazz = _postRemoteModel.getClass();

				Method method = clazz.getMethod("setPostName", String.class);

				method.invoke(_postRemoteModel, postName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPostRemoteModel() {
		return _postRemoteModel;
	}

	public void setPostRemoteModel(BaseModel<?> postRemoteModel) {
		_postRemoteModel = postRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _postRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_postRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PostLocalServiceUtil.addPost(this);
		}
		else {
			PostLocalServiceUtil.updatePost(this);
		}
	}

	@Override
	public Post toEscapedModel() {
		return (Post)ProxyUtil.newProxyInstance(Post.class.getClassLoader(),
			new Class[] { Post.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PostClp clone = new PostClp();

		clone.setPostId(getPostId());
		clone.setPostCategoryId(getPostCategoryId());
		clone.setPostName(getPostName());

		return clone;
	}

	@Override
	public int compareTo(Post post) {
		long primaryKey = post.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PostClp)) {
			return false;
		}

		PostClp post = (PostClp)obj;

		long primaryKey = post.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{postId=");
		sb.append(getPostId());
		sb.append(", postCategoryId=");
		sb.append(getPostCategoryId());
		sb.append(", postName=");
		sb.append(getPostName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Post");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>postId</column-name><column-value><![CDATA[");
		sb.append(getPostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postCategoryId</column-name><column-value><![CDATA[");
		sb.append(getPostCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postName</column-name><column-value><![CDATA[");
		sb.append(getPostName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _postId;
	private long _postCategoryId;
	private String _postName;
	private BaseModel<?> _postRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
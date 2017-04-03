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
import com.idetronic.eis.service.PostCategoryLocalServiceUtil;

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
public class PostCategoryClp extends BaseModelImpl<PostCategory>
	implements PostCategory {
	public PostCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PostCategory.class;
	}

	@Override
	public String getModelClassName() {
		return PostCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _postCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPostCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _postCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postCategoryId", getPostCategoryId());
		attributes.put("postCategoryCode", getPostCategoryCode());
		attributes.put("postCategoryName", getPostCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postCategoryId = (Long)attributes.get("postCategoryId");

		if (postCategoryId != null) {
			setPostCategoryId(postCategoryId);
		}

		String postCategoryCode = (String)attributes.get("postCategoryCode");

		if (postCategoryCode != null) {
			setPostCategoryCode(postCategoryCode);
		}

		String postCategoryName = (String)attributes.get("postCategoryName");

		if (postCategoryName != null) {
			setPostCategoryName(postCategoryName);
		}
	}

	@Override
	public long getPostCategoryId() {
		return _postCategoryId;
	}

	@Override
	public void setPostCategoryId(long postCategoryId) {
		_postCategoryId = postCategoryId;

		if (_postCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _postCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPostCategoryId", long.class);

				method.invoke(_postCategoryRemoteModel, postCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostCategoryCode() {
		return _postCategoryCode;
	}

	@Override
	public void setPostCategoryCode(String postCategoryCode) {
		_postCategoryCode = postCategoryCode;

		if (_postCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _postCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPostCategoryCode",
						String.class);

				method.invoke(_postCategoryRemoteModel, postCategoryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostCategoryName() {
		return _postCategoryName;
	}

	@Override
	public void setPostCategoryName(String postCategoryName) {
		_postCategoryName = postCategoryName;

		if (_postCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _postCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPostCategoryName",
						String.class);

				method.invoke(_postCategoryRemoteModel, postCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPostCategoryRemoteModel() {
		return _postCategoryRemoteModel;
	}

	public void setPostCategoryRemoteModel(BaseModel<?> postCategoryRemoteModel) {
		_postCategoryRemoteModel = postCategoryRemoteModel;
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

		Class<?> remoteModelClass = _postCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_postCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PostCategoryLocalServiceUtil.addPostCategory(this);
		}
		else {
			PostCategoryLocalServiceUtil.updatePostCategory(this);
		}
	}

	@Override
	public PostCategory toEscapedModel() {
		return (PostCategory)ProxyUtil.newProxyInstance(PostCategory.class.getClassLoader(),
			new Class[] { PostCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PostCategoryClp clone = new PostCategoryClp();

		clone.setPostCategoryId(getPostCategoryId());
		clone.setPostCategoryCode(getPostCategoryCode());
		clone.setPostCategoryName(getPostCategoryName());

		return clone;
	}

	@Override
	public int compareTo(PostCategory postCategory) {
		long primaryKey = postCategory.getPrimaryKey();

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

		if (!(obj instanceof PostCategoryClp)) {
			return false;
		}

		PostCategoryClp postCategory = (PostCategoryClp)obj;

		long primaryKey = postCategory.getPrimaryKey();

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

		sb.append("{postCategoryId=");
		sb.append(getPostCategoryId());
		sb.append(", postCategoryCode=");
		sb.append(getPostCategoryCode());
		sb.append(", postCategoryName=");
		sb.append(getPostCategoryName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.PostCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>postCategoryId</column-name><column-value><![CDATA[");
		sb.append(getPostCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postCategoryCode</column-name><column-value><![CDATA[");
		sb.append(getPostCategoryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postCategoryName</column-name><column-value><![CDATA[");
		sb.append(getPostCategoryName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _postCategoryId;
	private String _postCategoryCode;
	private String _postCategoryName;
	private BaseModel<?> _postCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
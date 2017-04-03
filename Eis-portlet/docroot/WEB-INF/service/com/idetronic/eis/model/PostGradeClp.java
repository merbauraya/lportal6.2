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
import com.idetronic.eis.service.PostGradeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class PostGradeClp extends BaseModelImpl<PostGrade> implements PostGrade {
	public PostGradeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PostGrade.class;
	}

	@Override
	public String getModelClassName() {
		return PostGrade.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _postGradeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPostGradeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _postGradeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postGradeId", getPostGradeId());
		attributes.put("postCategoryId", getPostCategoryId());
		attributes.put("postGradeCode", getPostGradeCode());
		attributes.put("postGradeScheme", getPostGradeScheme());
		attributes.put("postGradeName", getPostGradeName());
		attributes.put("postGradeDesc", getPostGradeDesc());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long postGradeId = (Long)attributes.get("postGradeId");

		if (postGradeId != null) {
			setPostGradeId(postGradeId);
		}

		Long postCategoryId = (Long)attributes.get("postCategoryId");

		if (postCategoryId != null) {
			setPostCategoryId(postCategoryId);
		}

		String postGradeCode = (String)attributes.get("postGradeCode");

		if (postGradeCode != null) {
			setPostGradeCode(postGradeCode);
		}

		String postGradeScheme = (String)attributes.get("postGradeScheme");

		if (postGradeScheme != null) {
			setPostGradeScheme(postGradeScheme);
		}

		String postGradeName = (String)attributes.get("postGradeName");

		if (postGradeName != null) {
			setPostGradeName(postGradeName);
		}

		String postGradeDesc = (String)attributes.get("postGradeDesc");

		if (postGradeDesc != null) {
			setPostGradeDesc(postGradeDesc);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getPostGradeId() {
		return _postGradeId;
	}

	@Override
	public void setPostGradeId(long postGradeId) {
		_postGradeId = postGradeId;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setPostGradeId", long.class);

				method.invoke(_postGradeRemoteModel, postGradeId);
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

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setPostCategoryId", long.class);

				method.invoke(_postGradeRemoteModel, postCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostGradeCode() {
		return _postGradeCode;
	}

	@Override
	public void setPostGradeCode(String postGradeCode) {
		_postGradeCode = postGradeCode;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setPostGradeCode", String.class);

				method.invoke(_postGradeRemoteModel, postGradeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostGradeScheme() {
		return _postGradeScheme;
	}

	@Override
	public void setPostGradeScheme(String postGradeScheme) {
		_postGradeScheme = postGradeScheme;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setPostGradeScheme",
						String.class);

				method.invoke(_postGradeRemoteModel, postGradeScheme);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostGradeName() {
		return _postGradeName;
	}

	@Override
	public void setPostGradeName(String postGradeName) {
		_postGradeName = postGradeName;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setPostGradeName", String.class);

				method.invoke(_postGradeRemoteModel, postGradeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostGradeDesc() {
		return _postGradeDesc;
	}

	@Override
	public void setPostGradeDesc(String postGradeDesc) {
		_postGradeDesc = postGradeDesc;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setPostGradeDesc", String.class);

				method.invoke(_postGradeRemoteModel, postGradeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_postGradeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_postGradeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_postGradeRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_postGradeRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_postGradeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_postGradeRemoteModel != null) {
			try {
				Class<?> clazz = _postGradeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_postGradeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPostGradeRemoteModel() {
		return _postGradeRemoteModel;
	}

	public void setPostGradeRemoteModel(BaseModel<?> postGradeRemoteModel) {
		_postGradeRemoteModel = postGradeRemoteModel;
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

		Class<?> remoteModelClass = _postGradeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_postGradeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PostGradeLocalServiceUtil.addPostGrade(this);
		}
		else {
			PostGradeLocalServiceUtil.updatePostGrade(this);
		}
	}

	@Override
	public PostGrade toEscapedModel() {
		return (PostGrade)ProxyUtil.newProxyInstance(PostGrade.class.getClassLoader(),
			new Class[] { PostGrade.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PostGradeClp clone = new PostGradeClp();

		clone.setPostGradeId(getPostGradeId());
		clone.setPostCategoryId(getPostCategoryId());
		clone.setPostGradeCode(getPostGradeCode());
		clone.setPostGradeScheme(getPostGradeScheme());
		clone.setPostGradeName(getPostGradeName());
		clone.setPostGradeDesc(getPostGradeDesc());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(PostGrade postGrade) {
		long primaryKey = postGrade.getPrimaryKey();

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

		if (!(obj instanceof PostGradeClp)) {
			return false;
		}

		PostGradeClp postGrade = (PostGradeClp)obj;

		long primaryKey = postGrade.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{postGradeId=");
		sb.append(getPostGradeId());
		sb.append(", postCategoryId=");
		sb.append(getPostCategoryId());
		sb.append(", postGradeCode=");
		sb.append(getPostGradeCode());
		sb.append(", postGradeScheme=");
		sb.append(getPostGradeScheme());
		sb.append(", postGradeName=");
		sb.append(getPostGradeName());
		sb.append(", postGradeDesc=");
		sb.append(getPostGradeDesc());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.PostGrade");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>postGradeId</column-name><column-value><![CDATA[");
		sb.append(getPostGradeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postCategoryId</column-name><column-value><![CDATA[");
		sb.append(getPostCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postGradeCode</column-name><column-value><![CDATA[");
		sb.append(getPostGradeCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postGradeScheme</column-name><column-value><![CDATA[");
		sb.append(getPostGradeScheme());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postGradeName</column-name><column-value><![CDATA[");
		sb.append(getPostGradeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postGradeDesc</column-name><column-value><![CDATA[");
		sb.append(getPostGradeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _postGradeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
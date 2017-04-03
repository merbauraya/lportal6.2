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

package com.idetronic.eis.model.impl;

import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.model.PostGradeModel;
import com.idetronic.eis.model.PostGradeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PostGrade service. Represents a row in the &quot;eis_PostGrade&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.PostGradeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PostGradeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see PostGradeImpl
 * @see com.idetronic.eis.model.PostGrade
 * @see com.idetronic.eis.model.PostGradeModel
 * @generated
 */
@JSON(strict = true)
public class PostGradeModelImpl extends BaseModelImpl<PostGrade>
	implements PostGradeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a post grade model instance should use the {@link com.idetronic.eis.model.PostGrade} interface instead.
	 */
	public static final String TABLE_NAME = "eis_PostGrade";
	public static final Object[][] TABLE_COLUMNS = {
			{ "postGradeId", Types.BIGINT },
			{ "postCategoryId", Types.BIGINT },
			{ "postGradeCode", Types.VARCHAR },
			{ "postGradeScheme", Types.VARCHAR },
			{ "postGradeName", Types.VARCHAR },
			{ "postGradeDesc", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_PostGrade (postGradeId LONG not null primary key,postCategoryId LONG,postGradeCode VARCHAR(10) null,postGradeScheme VARCHAR(10) null,postGradeName VARCHAR(75) null,postGradeDesc VARCHAR(75) null,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eis_PostGrade";
	public static final String ORDER_BY_JPQL = " ORDER BY postGrade.postGradeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_PostGrade.postGradeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.PostGrade"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.PostGrade"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.eis.model.PostGrade"),
			true);
	public static long POSTGRADECODE_COLUMN_BITMASK = 1L;
	public static long POSTGRADEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PostGrade toModel(PostGradeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PostGrade model = new PostGradeImpl();

		model.setPostGradeId(soapModel.getPostGradeId());
		model.setPostCategoryId(soapModel.getPostCategoryId());
		model.setPostGradeCode(soapModel.getPostGradeCode());
		model.setPostGradeScheme(soapModel.getPostGradeScheme());
		model.setPostGradeName(soapModel.getPostGradeName());
		model.setPostGradeDesc(soapModel.getPostGradeDesc());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PostGrade> toModels(PostGradeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PostGrade> models = new ArrayList<PostGrade>(soapModels.length);

		for (PostGradeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.PostGrade"));

	public PostGradeModelImpl() {
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
	public Class<?> getModelClass() {
		return PostGrade.class;
	}

	@Override
	public String getModelClassName() {
		return PostGrade.class.getName();
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

	@JSON
	@Override
	public long getPostGradeId() {
		return _postGradeId;
	}

	@Override
	public void setPostGradeId(long postGradeId) {
		_postGradeId = postGradeId;
	}

	@JSON
	@Override
	public long getPostCategoryId() {
		return _postCategoryId;
	}

	@Override
	public void setPostCategoryId(long postCategoryId) {
		_postCategoryId = postCategoryId;
	}

	@JSON
	@Override
	public String getPostGradeCode() {
		if (_postGradeCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _postGradeCode;
		}
	}

	@Override
	public void setPostGradeCode(String postGradeCode) {
		_columnBitmask |= POSTGRADECODE_COLUMN_BITMASK;

		if (_originalPostGradeCode == null) {
			_originalPostGradeCode = _postGradeCode;
		}

		_postGradeCode = postGradeCode;
	}

	public String getOriginalPostGradeCode() {
		return GetterUtil.getString(_originalPostGradeCode);
	}

	@JSON
	@Override
	public String getPostGradeScheme() {
		if (_postGradeScheme == null) {
			return StringPool.BLANK;
		}
		else {
			return _postGradeScheme;
		}
	}

	@Override
	public void setPostGradeScheme(String postGradeScheme) {
		_postGradeScheme = postGradeScheme;
	}

	@JSON
	@Override
	public String getPostGradeName() {
		if (_postGradeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _postGradeName;
		}
	}

	@Override
	public void setPostGradeName(String postGradeName) {
		_postGradeName = postGradeName;
	}

	@JSON
	@Override
	public String getPostGradeDesc() {
		if (_postGradeDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _postGradeDesc;
		}
	}

	@Override
	public void setPostGradeDesc(String postGradeDesc) {
		_postGradeDesc = postGradeDesc;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PostGrade.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PostGrade toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PostGrade)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PostGradeImpl postGradeImpl = new PostGradeImpl();

		postGradeImpl.setPostGradeId(getPostGradeId());
		postGradeImpl.setPostCategoryId(getPostCategoryId());
		postGradeImpl.setPostGradeCode(getPostGradeCode());
		postGradeImpl.setPostGradeScheme(getPostGradeScheme());
		postGradeImpl.setPostGradeName(getPostGradeName());
		postGradeImpl.setPostGradeDesc(getPostGradeDesc());
		postGradeImpl.setCompanyId(getCompanyId());
		postGradeImpl.setGroupId(getGroupId());
		postGradeImpl.setUserId(getUserId());
		postGradeImpl.setUserName(getUserName());
		postGradeImpl.setCreateDate(getCreateDate());
		postGradeImpl.setModifiedDate(getModifiedDate());

		postGradeImpl.resetOriginalValues();

		return postGradeImpl;
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

		if (!(obj instanceof PostGrade)) {
			return false;
		}

		PostGrade postGrade = (PostGrade)obj;

		long primaryKey = postGrade.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		PostGradeModelImpl postGradeModelImpl = this;

		postGradeModelImpl._originalPostGradeCode = postGradeModelImpl._postGradeCode;

		postGradeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PostGrade> toCacheModel() {
		PostGradeCacheModel postGradeCacheModel = new PostGradeCacheModel();

		postGradeCacheModel.postGradeId = getPostGradeId();

		postGradeCacheModel.postCategoryId = getPostCategoryId();

		postGradeCacheModel.postGradeCode = getPostGradeCode();

		String postGradeCode = postGradeCacheModel.postGradeCode;

		if ((postGradeCode != null) && (postGradeCode.length() == 0)) {
			postGradeCacheModel.postGradeCode = null;
		}

		postGradeCacheModel.postGradeScheme = getPostGradeScheme();

		String postGradeScheme = postGradeCacheModel.postGradeScheme;

		if ((postGradeScheme != null) && (postGradeScheme.length() == 0)) {
			postGradeCacheModel.postGradeScheme = null;
		}

		postGradeCacheModel.postGradeName = getPostGradeName();

		String postGradeName = postGradeCacheModel.postGradeName;

		if ((postGradeName != null) && (postGradeName.length() == 0)) {
			postGradeCacheModel.postGradeName = null;
		}

		postGradeCacheModel.postGradeDesc = getPostGradeDesc();

		String postGradeDesc = postGradeCacheModel.postGradeDesc;

		if ((postGradeDesc != null) && (postGradeDesc.length() == 0)) {
			postGradeCacheModel.postGradeDesc = null;
		}

		postGradeCacheModel.companyId = getCompanyId();

		postGradeCacheModel.groupId = getGroupId();

		postGradeCacheModel.userId = getUserId();

		postGradeCacheModel.userName = getUserName();

		String userName = postGradeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			postGradeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			postGradeCacheModel.createDate = createDate.getTime();
		}
		else {
			postGradeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			postGradeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			postGradeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return postGradeCacheModel;
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

	private static ClassLoader _classLoader = PostGrade.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PostGrade.class
		};
	private long _postGradeId;
	private long _postCategoryId;
	private String _postGradeCode;
	private String _originalPostGradeCode;
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
	private long _columnBitmask;
	private PostGrade _escapedModel;
}
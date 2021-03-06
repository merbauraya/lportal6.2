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

package com.idetronic.eprint.model.impl;

import com.idetronic.eprint.model.EprintStaticContent;
import com.idetronic.eprint.model.EprintStaticContentModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the EprintStaticContent service. Represents a row in the &quot;Eprints_EprintStaticContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eprint.model.EprintStaticContentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EprintStaticContentImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintStaticContentImpl
 * @see com.idetronic.eprint.model.EprintStaticContent
 * @see com.idetronic.eprint.model.EprintStaticContentModel
 * @generated
 */
public class EprintStaticContentModelImpl extends BaseModelImpl<EprintStaticContent>
	implements EprintStaticContentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a eprint static content model instance should use the {@link com.idetronic.eprint.model.EprintStaticContent} interface instead.
	 */
	public static final String TABLE_NAME = "Eprints_EprintStaticContent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contentId", Types.BIGINT },
			{ "content", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table Eprints_EprintStaticContent (contentId LONG not null primary key,content TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table Eprints_EprintStaticContent";
	public static final String ORDER_BY_JPQL = " ORDER BY eprintStaticContent.contentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Eprints_EprintStaticContent.contentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eprint.model.EprintStaticContent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eprint.model.EprintStaticContent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eprint.model.EprintStaticContent"));

	public EprintStaticContentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _contentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EprintStaticContent.class;
	}

	@Override
	public String getModelClassName() {
		return EprintStaticContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			EprintStaticContent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EprintStaticContent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EprintStaticContent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EprintStaticContentImpl eprintStaticContentImpl = new EprintStaticContentImpl();

		eprintStaticContentImpl.setContentId(getContentId());
		eprintStaticContentImpl.setContent(getContent());

		eprintStaticContentImpl.resetOriginalValues();

		return eprintStaticContentImpl;
	}

	@Override
	public int compareTo(EprintStaticContent eprintStaticContent) {
		long primaryKey = eprintStaticContent.getPrimaryKey();

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

		if (!(obj instanceof EprintStaticContent)) {
			return false;
		}

		EprintStaticContent eprintStaticContent = (EprintStaticContent)obj;

		long primaryKey = eprintStaticContent.getPrimaryKey();

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
	}

	@Override
	public CacheModel<EprintStaticContent> toCacheModel() {
		EprintStaticContentCacheModel eprintStaticContentCacheModel = new EprintStaticContentCacheModel();

		eprintStaticContentCacheModel.contentId = getContentId();

		eprintStaticContentCacheModel.content = getContent();

		String content = eprintStaticContentCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			eprintStaticContentCacheModel.content = null;
		}

		return eprintStaticContentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contentId=");
		sb.append(getContentId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.EprintStaticContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentId</column-name><column-value><![CDATA[");
		sb.append(getContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EprintStaticContent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EprintStaticContent.class
		};
	private long _contentId;
	private String _content;
	private EprintStaticContent _escapedModel;
}
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

import com.idetronic.eprint.model.EprintSubject;
import com.idetronic.eprint.model.EprintSubjectModel;
import com.idetronic.eprint.service.persistence.EprintSubjectPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the EprintSubject service. Represents a row in the &quot;Eprints_EprintSubject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eprint.model.EprintSubjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EprintSubjectImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintSubjectImpl
 * @see com.idetronic.eprint.model.EprintSubject
 * @see com.idetronic.eprint.model.EprintSubjectModel
 * @generated
 */
public class EprintSubjectModelImpl extends BaseModelImpl<EprintSubject>
	implements EprintSubjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a eprint subject model instance should use the {@link com.idetronic.eprint.model.EprintSubject} interface instead.
	 */
	public static final String TABLE_NAME = "Eprints_EprintSubject";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eprintId", Types.BIGINT },
			{ "subjectId", Types.VARCHAR },
			{ "subjectName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Eprints_EprintSubject (eprintId LONG not null,subjectId VARCHAR(75) not null,subjectName VARCHAR(75) null,primary key (eprintId, subjectId))";
	public static final String TABLE_SQL_DROP = "drop table Eprints_EprintSubject";
	public static final String ORDER_BY_JPQL = " ORDER BY eprintSubject.id.eprintId ASC, eprintSubject.id.subjectId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Eprints_EprintSubject.eprintId ASC, Eprints_EprintSubject.subjectId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eprint.model.EprintSubject"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eprint.model.EprintSubject"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eprint.model.EprintSubject"));

	public EprintSubjectModelImpl() {
	}

	@Override
	public EprintSubjectPK getPrimaryKey() {
		return new EprintSubjectPK(_eprintId, _subjectId);
	}

	@Override
	public void setPrimaryKey(EprintSubjectPK primaryKey) {
		setEprintId(primaryKey.eprintId);
		setSubjectId(primaryKey.subjectId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new EprintSubjectPK(_eprintId, _subjectId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((EprintSubjectPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return EprintSubject.class;
	}

	@Override
	public String getModelClassName() {
		return EprintSubject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eprintId", getEprintId());
		attributes.put("subjectId", getSubjectId());
		attributes.put("subjectName", getSubjectName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eprintId = (Long)attributes.get("eprintId");

		if (eprintId != null) {
			setEprintId(eprintId);
		}

		String subjectId = (String)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}
	}

	@Override
	public long getEprintId() {
		return _eprintId;
	}

	@Override
	public void setEprintId(long eprintId) {
		_eprintId = eprintId;
	}

	@Override
	public String getSubjectId() {
		if (_subjectId == null) {
			return StringPool.BLANK;
		}
		else {
			return _subjectId;
		}
	}

	@Override
	public void setSubjectId(String subjectId) {
		_subjectId = subjectId;
	}

	@Override
	public String getSubjectName() {
		if (_subjectName == null) {
			return StringPool.BLANK;
		}
		else {
			return _subjectName;
		}
	}

	@Override
	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;
	}

	@Override
	public EprintSubject toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EprintSubject)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EprintSubjectImpl eprintSubjectImpl = new EprintSubjectImpl();

		eprintSubjectImpl.setEprintId(getEprintId());
		eprintSubjectImpl.setSubjectId(getSubjectId());
		eprintSubjectImpl.setSubjectName(getSubjectName());

		eprintSubjectImpl.resetOriginalValues();

		return eprintSubjectImpl;
	}

	@Override
	public int compareTo(EprintSubject eprintSubject) {
		EprintSubjectPK primaryKey = eprintSubject.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprintSubject)) {
			return false;
		}

		EprintSubject eprintSubject = (EprintSubject)obj;

		EprintSubjectPK primaryKey = eprintSubject.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<EprintSubject> toCacheModel() {
		EprintSubjectCacheModel eprintSubjectCacheModel = new EprintSubjectCacheModel();

		eprintSubjectCacheModel.eprintId = getEprintId();

		eprintSubjectCacheModel.subjectId = getSubjectId();

		String subjectId = eprintSubjectCacheModel.subjectId;

		if ((subjectId != null) && (subjectId.length() == 0)) {
			eprintSubjectCacheModel.subjectId = null;
		}

		eprintSubjectCacheModel.subjectName = getSubjectName();

		String subjectName = eprintSubjectCacheModel.subjectName;

		if ((subjectName != null) && (subjectName.length() == 0)) {
			eprintSubjectCacheModel.subjectName = null;
		}

		return eprintSubjectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eprintId=");
		sb.append(getEprintId());
		sb.append(", subjectId=");
		sb.append(getSubjectId());
		sb.append(", subjectName=");
		sb.append(getSubjectName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eprint.model.EprintSubject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eprintId</column-name><column-value><![CDATA[");
		sb.append(getEprintId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectName</column-name><column-value><![CDATA[");
		sb.append(getSubjectName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EprintSubject.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EprintSubject.class
		};
	private long _eprintId;
	private String _subjectId;
	private String _subjectName;
	private EprintSubject _escapedModel;
}
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

import com.idetronic.eis.model.FacultyType;
import com.idetronic.eis.model.FacultyTypeModel;
import com.idetronic.eis.model.FacultyTypeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FacultyType service. Represents a row in the &quot;eis_FacultyType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.eis.model.FacultyTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FacultyTypeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FacultyTypeImpl
 * @see com.idetronic.eis.model.FacultyType
 * @see com.idetronic.eis.model.FacultyTypeModel
 * @generated
 */
@JSON(strict = true)
public class FacultyTypeModelImpl extends BaseModelImpl<FacultyType>
	implements FacultyTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a faculty type model instance should use the {@link com.idetronic.eis.model.FacultyType} interface instead.
	 */
	public static final String TABLE_NAME = "eis_FacultyType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "facultyTypeId", Types.BIGINT },
			{ "facultyTypeName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eis_FacultyType (facultyTypeId LONG not null primary key,facultyTypeName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eis_FacultyType";
	public static final String ORDER_BY_JPQL = " ORDER BY facultyType.facultyTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eis_FacultyType.facultyTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.eis.model.FacultyType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.eis.model.FacultyType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FacultyType toModel(FacultyTypeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FacultyType model = new FacultyTypeImpl();

		model.setFacultyTypeId(soapModel.getFacultyTypeId());
		model.setFacultyTypeName(soapModel.getFacultyTypeName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FacultyType> toModels(FacultyTypeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FacultyType> models = new ArrayList<FacultyType>(soapModels.length);

		for (FacultyTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.eis.model.FacultyType"));

	public FacultyTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _facultyTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFacultyTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _facultyTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FacultyType.class;
	}

	@Override
	public String getModelClassName() {
		return FacultyType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("facultyTypeId", getFacultyTypeId());
		attributes.put("facultyTypeName", getFacultyTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long facultyTypeId = (Long)attributes.get("facultyTypeId");

		if (facultyTypeId != null) {
			setFacultyTypeId(facultyTypeId);
		}

		String facultyTypeName = (String)attributes.get("facultyTypeName");

		if (facultyTypeName != null) {
			setFacultyTypeName(facultyTypeName);
		}
	}

	@JSON
	@Override
	public long getFacultyTypeId() {
		return _facultyTypeId;
	}

	@Override
	public void setFacultyTypeId(long facultyTypeId) {
		_facultyTypeId = facultyTypeId;
	}

	@JSON
	@Override
	public String getFacultyTypeName() {
		if (_facultyTypeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _facultyTypeName;
		}
	}

	@Override
	public void setFacultyTypeName(String facultyTypeName) {
		_facultyTypeName = facultyTypeName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FacultyType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FacultyType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FacultyType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FacultyTypeImpl facultyTypeImpl = new FacultyTypeImpl();

		facultyTypeImpl.setFacultyTypeId(getFacultyTypeId());
		facultyTypeImpl.setFacultyTypeName(getFacultyTypeName());

		facultyTypeImpl.resetOriginalValues();

		return facultyTypeImpl;
	}

	@Override
	public int compareTo(FacultyType facultyType) {
		long primaryKey = facultyType.getPrimaryKey();

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

		if (!(obj instanceof FacultyType)) {
			return false;
		}

		FacultyType facultyType = (FacultyType)obj;

		long primaryKey = facultyType.getPrimaryKey();

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
	public CacheModel<FacultyType> toCacheModel() {
		FacultyTypeCacheModel facultyTypeCacheModel = new FacultyTypeCacheModel();

		facultyTypeCacheModel.facultyTypeId = getFacultyTypeId();

		facultyTypeCacheModel.facultyTypeName = getFacultyTypeName();

		String facultyTypeName = facultyTypeCacheModel.facultyTypeName;

		if ((facultyTypeName != null) && (facultyTypeName.length() == 0)) {
			facultyTypeCacheModel.facultyTypeName = null;
		}

		return facultyTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{facultyTypeId=");
		sb.append(getFacultyTypeId());
		sb.append(", facultyTypeName=");
		sb.append(getFacultyTypeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FacultyType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>facultyTypeId</column-name><column-value><![CDATA[");
		sb.append(getFacultyTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyTypeName</column-name><column-value><![CDATA[");
		sb.append(getFacultyTypeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FacultyType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FacultyType.class
		};
	private long _facultyTypeId;
	private String _facultyTypeName;
	private FacultyType _escapedModel;
}
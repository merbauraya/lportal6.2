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
import com.idetronic.eis.service.FactPostLocalServiceUtil;

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
public class FactPostClp extends BaseModelImpl<FactPost> implements FactPost {
	public FactPostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactPost.class;
	}

	@Override
	public String getModelClassName() {
		return FactPost.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factPostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactPostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factPostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factPostId", getFactPostId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("period", getPeriod());
		attributes.put("postGradeId", getPostGradeId());
		attributes.put("stateId", getStateId());
		attributes.put("value", getValue());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factPostId = (Long)attributes.get("factPostId");

		if (factPostId != null) {
			setFactPostId(factPostId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long postGradeId = (Long)attributes.get("postGradeId");

		if (postGradeId != null) {
			setPostGradeId(postGradeId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}

		String createdByUserName = (String)attributes.get("createdByUserName");

		if (createdByUserName != null) {
			setCreatedByUserName(createdByUserName);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getFactPostId() {
		return _factPostId;
	}

	@Override
	public void setFactPostId(long factPostId) {
		_factPostId = factPostId;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setFactPostId", long.class);

				method.invoke(_factPostRemoteModel, factPostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLibraryId() {
		return _libraryId;
	}

	@Override
	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factPostRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPeriod() {
		return _period;
	}

	@Override
	public void setPeriod(String period) {
		_period = period;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factPostRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPostGradeId() {
		return _postGradeId;
	}

	@Override
	public void setPostGradeId(long postGradeId) {
		_postGradeId = postGradeId;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setPostGradeId", long.class);

				method.invoke(_factPostRemoteModel, postGradeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_factPostRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getValue() {
		return _value;
	}

	@Override
	public void setValue(int value) {
		_value = value;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", int.class);

				method.invoke(_factPostRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_factPostRemoteModel, createdByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreatedByUserId(), "uuid",
			_createdByUserUuid);
	}

	@Override
	public void setCreatedByUserUuid(String createdByUserUuid) {
		_createdByUserUuid = createdByUserUuid;
	}

	@Override
	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	@Override
	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserName",
						String.class);

				method.invoke(_factPostRemoteModel, createdByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_factPostRemoteModel != null) {
			try {
				Class<?> clazz = _factPostRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_factPostRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactPostRemoteModel() {
		return _factPostRemoteModel;
	}

	public void setFactPostRemoteModel(BaseModel<?> factPostRemoteModel) {
		_factPostRemoteModel = factPostRemoteModel;
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

		Class<?> remoteModelClass = _factPostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factPostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactPostLocalServiceUtil.addFactPost(this);
		}
		else {
			FactPostLocalServiceUtil.updateFactPost(this);
		}
	}

	@Override
	public FactPost toEscapedModel() {
		return (FactPost)ProxyUtil.newProxyInstance(FactPost.class.getClassLoader(),
			new Class[] { FactPost.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactPostClp clone = new FactPostClp();

		clone.setFactPostId(getFactPostId());
		clone.setLibraryId(getLibraryId());
		clone.setPeriod(getPeriod());
		clone.setPostGradeId(getPostGradeId());
		clone.setStateId(getStateId());
		clone.setValue(getValue());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setCreatedByUserName(getCreatedByUserName());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(FactPost factPost) {
		long primaryKey = factPost.getPrimaryKey();

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

		if (!(obj instanceof FactPostClp)) {
			return false;
		}

		FactPostClp factPost = (FactPostClp)obj;

		long primaryKey = factPost.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{factPostId=");
		sb.append(getFactPostId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", postGradeId=");
		sb.append(getPostGradeId());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", createdByUserId=");
		sb.append(getCreatedByUserId());
		sb.append(", createdByUserName=");
		sb.append(getCreatedByUserName());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactPost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factPostId</column-name><column-value><![CDATA[");
		sb.append(getFactPostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postGradeId</column-name><column-value><![CDATA[");
		sb.append(getPostGradeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserName</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _factPostId;
	private long _libraryId;
	private String _period;
	private long _postGradeId;
	private long _stateId;
	private int _value;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private String _createdByUserName;
	private Date _createdDate;
	private BaseModel<?> _factPostRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
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
import com.idetronic.eis.service.FactSeatingLocalServiceUtil;

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
public class FactSeatingClp extends BaseModelImpl<FactSeating>
	implements FactSeating {
	public FactSeatingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactSeating.class;
	}

	@Override
	public String getModelClassName() {
		return FactSeating.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factSeatingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactSeatingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factSeatingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factSeatingId", getFactSeatingId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("seatingCategoryId", getSeatingCategoryId());
		attributes.put("stateId", getStateId());
		attributes.put("libraryTypeId", getLibraryTypeId());
		attributes.put("period", getPeriod());
		attributes.put("capacity", getCapacity());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factSeatingId = (Long)attributes.get("factSeatingId");

		if (factSeatingId != null) {
			setFactSeatingId(factSeatingId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long seatingCategoryId = (Long)attributes.get("seatingCategoryId");

		if (seatingCategoryId != null) {
			setSeatingCategoryId(seatingCategoryId);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long libraryTypeId = (Long)attributes.get("libraryTypeId");

		if (libraryTypeId != null) {
			setLibraryTypeId(libraryTypeId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Integer capacity = (Integer)attributes.get("capacity");

		if (capacity != null) {
			setCapacity(capacity);
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
	}

	@Override
	public long getFactSeatingId() {
		return _factSeatingId;
	}

	@Override
	public void setFactSeatingId(long factSeatingId) {
		_factSeatingId = factSeatingId;

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setFactSeatingId", long.class);

				method.invoke(_factSeatingRemoteModel, factSeatingId);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factSeatingRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_factSeatingRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeatingCategoryId() {
		return _seatingCategoryId;
	}

	@Override
	public void setSeatingCategoryId(long seatingCategoryId) {
		_seatingCategoryId = seatingCategoryId;

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setSeatingCategoryId",
						long.class);

				method.invoke(_factSeatingRemoteModel, seatingCategoryId);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_factSeatingRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLibraryTypeId() {
		return _libraryTypeId;
	}

	@Override
	public void setLibraryTypeId(long libraryTypeId) {
		_libraryTypeId = libraryTypeId;

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryTypeId", long.class);

				method.invoke(_factSeatingRemoteModel, libraryTypeId);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factSeatingRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCapacity() {
		return _capacity;
	}

	@Override
	public void setCapacity(int capacity) {
		_capacity = capacity;

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setCapacity", int.class);

				method.invoke(_factSeatingRemoteModel, capacity);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_factSeatingRemoteModel, companyId);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_factSeatingRemoteModel, groupId);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_factSeatingRemoteModel, userId);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_factSeatingRemoteModel, userName);
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

		if (_factSeatingRemoteModel != null) {
			try {
				Class<?> clazz = _factSeatingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_factSeatingRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactSeatingRemoteModel() {
		return _factSeatingRemoteModel;
	}

	public void setFactSeatingRemoteModel(BaseModel<?> factSeatingRemoteModel) {
		_factSeatingRemoteModel = factSeatingRemoteModel;
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

		Class<?> remoteModelClass = _factSeatingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factSeatingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactSeatingLocalServiceUtil.addFactSeating(this);
		}
		else {
			FactSeatingLocalServiceUtil.updateFactSeating(this);
		}
	}

	@Override
	public FactSeating toEscapedModel() {
		return (FactSeating)ProxyUtil.newProxyInstance(FactSeating.class.getClassLoader(),
			new Class[] { FactSeating.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactSeatingClp clone = new FactSeatingClp();

		clone.setFactSeatingId(getFactSeatingId());
		clone.setLibraryId(getLibraryId());
		clone.setDepartmentId(getDepartmentId());
		clone.setSeatingCategoryId(getSeatingCategoryId());
		clone.setStateId(getStateId());
		clone.setLibraryTypeId(getLibraryTypeId());
		clone.setPeriod(getPeriod());
		clone.setCapacity(getCapacity());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(FactSeating factSeating) {
		long primaryKey = factSeating.getPrimaryKey();

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

		if (!(obj instanceof FactSeatingClp)) {
			return false;
		}

		FactSeatingClp factSeating = (FactSeatingClp)obj;

		long primaryKey = factSeating.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{factSeatingId=");
		sb.append(getFactSeatingId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", seatingCategoryId=");
		sb.append(getSeatingCategoryId());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", libraryTypeId=");
		sb.append(getLibraryTypeId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", capacity=");
		sb.append(getCapacity());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactSeating");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factSeatingId</column-name><column-value><![CDATA[");
		sb.append(getFactSeatingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seatingCategoryId</column-name><column-value><![CDATA[");
		sb.append(getSeatingCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryTypeId</column-name><column-value><![CDATA[");
		sb.append(getLibraryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _factSeatingId;
	private long _libraryId;
	private long _departmentId;
	private long _seatingCategoryId;
	private long _stateId;
	private long _libraryTypeId;
	private String _period;
	private int _capacity;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private BaseModel<?> _factSeatingRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
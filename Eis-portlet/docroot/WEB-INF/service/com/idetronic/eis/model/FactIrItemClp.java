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
import com.idetronic.eis.service.FactIrItemLocalServiceUtil;

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
public class FactIrItemClp extends BaseModelImpl<FactIrItem>
	implements FactIrItem {
	public FactIrItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactIrItem.class;
	}

	@Override
	public String getModelClassName() {
		return FactIrItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _factIrItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFactIrItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _factIrItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("factIrItemId", getFactIrItemId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("period", getPeriod());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("itemMediumId", getItemMediumId());
		attributes.put("titleTotal", getTitleTotal());
		attributes.put("volumeTotal", getVolumeTotal());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long factIrItemId = (Long)attributes.get("factIrItemId");

		if (factIrItemId != null) {
			setFactIrItemId(factIrItemId);
		}

		Long libraryId = (Long)attributes.get("libraryId");

		if (libraryId != null) {
			setLibraryId(libraryId);
		}

		Long facultyId = (Long)attributes.get("facultyId");

		if (facultyId != null) {
			setFacultyId(facultyId);
		}

		String period = (String)attributes.get("period");

		if (period != null) {
			setPeriod(period);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Long itemMediumId = (Long)attributes.get("itemMediumId");

		if (itemMediumId != null) {
			setItemMediumId(itemMediumId);
		}

		Integer titleTotal = (Integer)attributes.get("titleTotal");

		if (titleTotal != null) {
			setTitleTotal(titleTotal);
		}

		Integer volumeTotal = (Integer)attributes.get("volumeTotal");

		if (volumeTotal != null) {
			setVolumeTotal(volumeTotal);
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
	public long getFactIrItemId() {
		return _factIrItemId;
	}

	@Override
	public void setFactIrItemId(long factIrItemId) {
		_factIrItemId = factIrItemId;

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFactIrItemId", long.class);

				method.invoke(_factIrItemRemoteModel, factIrItemId);
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

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factIrItemRemoteModel, libraryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacultyId() {
		return _facultyId;
	}

	@Override
	public void setFacultyId(long facultyId) {
		_facultyId = facultyId;

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyId", long.class);

				method.invoke(_factIrItemRemoteModel, facultyId);
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

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factIrItemRemoteModel, period);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_factIrItemRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemMediumId() {
		return _itemMediumId;
	}

	@Override
	public void setItemMediumId(long itemMediumId) {
		_itemMediumId = itemMediumId;

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemMediumId", long.class);

				method.invoke(_factIrItemRemoteModel, itemMediumId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTitleTotal() {
		return _titleTotal;
	}

	@Override
	public void setTitleTotal(int titleTotal) {
		_titleTotal = titleTotal;

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleTotal", int.class);

				method.invoke(_factIrItemRemoteModel, titleTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVolumeTotal() {
		return _volumeTotal;
	}

	@Override
	public void setVolumeTotal(int volumeTotal) {
		_volumeTotal = volumeTotal;

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setVolumeTotal", int.class);

				method.invoke(_factIrItemRemoteModel, volumeTotal);
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

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_factIrItemRemoteModel, createdByUserId);
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

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserName",
						String.class);

				method.invoke(_factIrItemRemoteModel, createdByUserName);
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

		if (_factIrItemRemoteModel != null) {
			try {
				Class<?> clazz = _factIrItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_factIrItemRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactIrItemRemoteModel() {
		return _factIrItemRemoteModel;
	}

	public void setFactIrItemRemoteModel(BaseModel<?> factIrItemRemoteModel) {
		_factIrItemRemoteModel = factIrItemRemoteModel;
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

		Class<?> remoteModelClass = _factIrItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factIrItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactIrItemLocalServiceUtil.addFactIrItem(this);
		}
		else {
			FactIrItemLocalServiceUtil.updateFactIrItem(this);
		}
	}

	@Override
	public FactIrItem toEscapedModel() {
		return (FactIrItem)ProxyUtil.newProxyInstance(FactIrItem.class.getClassLoader(),
			new Class[] { FactIrItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactIrItemClp clone = new FactIrItemClp();

		clone.setFactIrItemId(getFactIrItemId());
		clone.setLibraryId(getLibraryId());
		clone.setFacultyId(getFacultyId());
		clone.setPeriod(getPeriod());
		clone.setItemTypeId(getItemTypeId());
		clone.setItemMediumId(getItemMediumId());
		clone.setTitleTotal(getTitleTotal());
		clone.setVolumeTotal(getVolumeTotal());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setCreatedByUserName(getCreatedByUserName());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(FactIrItem factIrItem) {
		long primaryKey = factIrItem.getPrimaryKey();

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

		if (!(obj instanceof FactIrItemClp)) {
			return false;
		}

		FactIrItemClp factIrItem = (FactIrItemClp)obj;

		long primaryKey = factIrItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{factIrItemId=");
		sb.append(getFactIrItemId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", facultyId=");
		sb.append(getFacultyId());
		sb.append(", period=");
		sb.append(getPeriod());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", itemMediumId=");
		sb.append(getItemMediumId());
		sb.append(", titleTotal=");
		sb.append(getTitleTotal());
		sb.append(", volumeTotal=");
		sb.append(getVolumeTotal());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactIrItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>factIrItemId</column-name><column-value><![CDATA[");
		sb.append(getFactIrItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryId</column-name><column-value><![CDATA[");
		sb.append(getLibraryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyId</column-name><column-value><![CDATA[");
		sb.append(getFacultyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>period</column-name><column-value><![CDATA[");
		sb.append(getPeriod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemMediumId</column-name><column-value><![CDATA[");
		sb.append(getItemMediumId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleTotal</column-name><column-value><![CDATA[");
		sb.append(getTitleTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>volumeTotal</column-name><column-value><![CDATA[");
		sb.append(getVolumeTotal());
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

	private long _factIrItemId;
	private long _libraryId;
	private long _facultyId;
	private String _period;
	private long _itemTypeId;
	private long _itemMediumId;
	private int _titleTotal;
	private int _volumeTotal;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private String _createdByUserName;
	private Date _createdDate;
	private BaseModel<?> _factIrItemRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
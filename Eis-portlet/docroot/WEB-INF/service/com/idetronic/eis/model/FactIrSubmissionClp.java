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
import com.idetronic.eis.service.FactIrSubmissionLocalServiceUtil;

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
public class FactIrSubmissionClp extends BaseModelImpl<FactIrSubmission>
	implements FactIrSubmission {
	public FactIrSubmissionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FactIrSubmission.class;
	}

	@Override
	public String getModelClassName() {
		return FactIrSubmission.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _submissionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubmissionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _submissionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionId", getSubmissionId());
		attributes.put("libraryId", getLibraryId());
		attributes.put("facultyId", getFacultyId());
		attributes.put("period", getPeriod());
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
		Long submissionId = (Long)attributes.get("submissionId");

		if (submissionId != null) {
			setSubmissionId(submissionId);
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
	public long getSubmissionId() {
		return _submissionId;
	}

	@Override
	public void setSubmissionId(long submissionId) {
		_submissionId = submissionId;

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubmissionId", long.class);

				method.invoke(_factIrSubmissionRemoteModel, submissionId);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryId", long.class);

				method.invoke(_factIrSubmissionRemoteModel, libraryId);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyId", long.class);

				method.invoke(_factIrSubmissionRemoteModel, facultyId);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setPeriod", String.class);

				method.invoke(_factIrSubmissionRemoteModel, period);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setItemMediumId", long.class);

				method.invoke(_factIrSubmissionRemoteModel, itemMediumId);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleTotal", int.class);

				method.invoke(_factIrSubmissionRemoteModel, titleTotal);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setVolumeTotal", int.class);

				method.invoke(_factIrSubmissionRemoteModel, volumeTotal);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_factIrSubmissionRemoteModel, createdByUserId);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserName",
						String.class);

				method.invoke(_factIrSubmissionRemoteModel, createdByUserName);
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

		if (_factIrSubmissionRemoteModel != null) {
			try {
				Class<?> clazz = _factIrSubmissionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_factIrSubmissionRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFactIrSubmissionRemoteModel() {
		return _factIrSubmissionRemoteModel;
	}

	public void setFactIrSubmissionRemoteModel(
		BaseModel<?> factIrSubmissionRemoteModel) {
		_factIrSubmissionRemoteModel = factIrSubmissionRemoteModel;
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

		Class<?> remoteModelClass = _factIrSubmissionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_factIrSubmissionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactIrSubmissionLocalServiceUtil.addFactIrSubmission(this);
		}
		else {
			FactIrSubmissionLocalServiceUtil.updateFactIrSubmission(this);
		}
	}

	@Override
	public FactIrSubmission toEscapedModel() {
		return (FactIrSubmission)ProxyUtil.newProxyInstance(FactIrSubmission.class.getClassLoader(),
			new Class[] { FactIrSubmission.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FactIrSubmissionClp clone = new FactIrSubmissionClp();

		clone.setSubmissionId(getSubmissionId());
		clone.setLibraryId(getLibraryId());
		clone.setFacultyId(getFacultyId());
		clone.setPeriod(getPeriod());
		clone.setItemMediumId(getItemMediumId());
		clone.setTitleTotal(getTitleTotal());
		clone.setVolumeTotal(getVolumeTotal());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setCreatedByUserName(getCreatedByUserName());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(FactIrSubmission factIrSubmission) {
		long primaryKey = factIrSubmission.getPrimaryKey();

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

		if (!(obj instanceof FactIrSubmissionClp)) {
			return false;
		}

		FactIrSubmissionClp factIrSubmission = (FactIrSubmissionClp)obj;

		long primaryKey = factIrSubmission.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{submissionId=");
		sb.append(getSubmissionId());
		sb.append(", libraryId=");
		sb.append(getLibraryId());
		sb.append(", facultyId=");
		sb.append(getFacultyId());
		sb.append(", period=");
		sb.append(getPeriod());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.FactIrSubmission");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>submissionId</column-name><column-value><![CDATA[");
		sb.append(getSubmissionId());
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

	private long _submissionId;
	private long _libraryId;
	private long _facultyId;
	private String _period;
	private long _itemMediumId;
	private int _titleTotal;
	private int _volumeTotal;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private String _createdByUserName;
	private Date _createdDate;
	private BaseModel<?> _factIrSubmissionRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
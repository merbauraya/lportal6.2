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
import com.idetronic.eis.service.MasterFileLocalServiceUtil;

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
public class MasterFileClp extends BaseModelImpl<MasterFile>
	implements MasterFile {
	public MasterFileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MasterFile.class;
	}

	@Override
	public String getModelClassName() {
		return MasterFile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _masterFileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMasterFileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _masterFileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterFileId", getMasterFileId());
		attributes.put("masterTypeId", getMasterTypeId());
		attributes.put("parentId1", getParentId1());
		attributes.put("parentId2", getParentId2());
		attributes.put("masterFileName", getMasterFileName());
		attributes.put("status1", getStatus1());
		attributes.put("status2", getStatus2());
		attributes.put("status3", getStatus3());
		attributes.put("status4", getStatus4());
		attributes.put("status5", getStatus5());
		attributes.put("masterCode", getMasterCode());
		attributes.put("oldId", getOldId());
		attributes.put("note", getNote());
		attributes.put("inActive", getInActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterFileId = (Long)attributes.get("masterFileId");

		if (masterFileId != null) {
			setMasterFileId(masterFileId);
		}

		Long masterTypeId = (Long)attributes.get("masterTypeId");

		if (masterTypeId != null) {
			setMasterTypeId(masterTypeId);
		}

		Long parentId1 = (Long)attributes.get("parentId1");

		if (parentId1 != null) {
			setParentId1(parentId1);
		}

		Long parentId2 = (Long)attributes.get("parentId2");

		if (parentId2 != null) {
			setParentId2(parentId2);
		}

		String masterFileName = (String)attributes.get("masterFileName");

		if (masterFileName != null) {
			setMasterFileName(masterFileName);
		}

		Boolean status1 = (Boolean)attributes.get("status1");

		if (status1 != null) {
			setStatus1(status1);
		}

		Boolean status2 = (Boolean)attributes.get("status2");

		if (status2 != null) {
			setStatus2(status2);
		}

		Boolean status3 = (Boolean)attributes.get("status3");

		if (status3 != null) {
			setStatus3(status3);
		}

		Boolean status4 = (Boolean)attributes.get("status4");

		if (status4 != null) {
			setStatus4(status4);
		}

		Boolean status5 = (Boolean)attributes.get("status5");

		if (status5 != null) {
			setStatus5(status5);
		}

		String masterCode = (String)attributes.get("masterCode");

		if (masterCode != null) {
			setMasterCode(masterCode);
		}

		Long oldId = (Long)attributes.get("oldId");

		if (oldId != null) {
			setOldId(oldId);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Boolean inActive = (Boolean)attributes.get("inActive");

		if (inActive != null) {
			setInActive(inActive);
		}
	}

	@Override
	public long getMasterFileId() {
		return _masterFileId;
	}

	@Override
	public void setMasterFileId(long masterFileId) {
		_masterFileId = masterFileId;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterFileId", long.class);

				method.invoke(_masterFileRemoteModel, masterFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMasterTypeId() {
		return _masterTypeId;
	}

	@Override
	public void setMasterTypeId(long masterTypeId) {
		_masterTypeId = masterTypeId;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterTypeId", long.class);

				method.invoke(_masterFileRemoteModel, masterTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId1() {
		return _parentId1;
	}

	@Override
	public void setParentId1(long parentId1) {
		_parentId1 = parentId1;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId1", long.class);

				method.invoke(_masterFileRemoteModel, parentId1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId2() {
		return _parentId2;
	}

	@Override
	public void setParentId2(long parentId2) {
		_parentId2 = parentId2;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId2", long.class);

				method.invoke(_masterFileRemoteModel, parentId2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMasterFileName() {
		return _masterFileName;
	}

	@Override
	public void setMasterFileName(String masterFileName) {
		_masterFileName = masterFileName;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterFileName",
						String.class);

				method.invoke(_masterFileRemoteModel, masterFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus1() {
		return _status1;
	}

	@Override
	public boolean isStatus1() {
		return _status1;
	}

	@Override
	public void setStatus1(boolean status1) {
		_status1 = status1;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus1", boolean.class);

				method.invoke(_masterFileRemoteModel, status1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus2() {
		return _status2;
	}

	@Override
	public boolean isStatus2() {
		return _status2;
	}

	@Override
	public void setStatus2(boolean status2) {
		_status2 = status2;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus2", boolean.class);

				method.invoke(_masterFileRemoteModel, status2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus3() {
		return _status3;
	}

	@Override
	public boolean isStatus3() {
		return _status3;
	}

	@Override
	public void setStatus3(boolean status3) {
		_status3 = status3;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus3", boolean.class);

				method.invoke(_masterFileRemoteModel, status3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus4() {
		return _status4;
	}

	@Override
	public boolean isStatus4() {
		return _status4;
	}

	@Override
	public void setStatus4(boolean status4) {
		_status4 = status4;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus4", boolean.class);

				method.invoke(_masterFileRemoteModel, status4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus5() {
		return _status5;
	}

	@Override
	public boolean isStatus5() {
		return _status5;
	}

	@Override
	public void setStatus5(boolean status5) {
		_status5 = status5;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus5", boolean.class);

				method.invoke(_masterFileRemoteModel, status5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMasterCode() {
		return _masterCode;
	}

	@Override
	public void setMasterCode(String masterCode) {
		_masterCode = masterCode;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterCode", String.class);

				method.invoke(_masterFileRemoteModel, masterCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOldId() {
		return _oldId;
	}

	@Override
	public void setOldId(long oldId) {
		_oldId = oldId;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setOldId", long.class);

				method.invoke(_masterFileRemoteModel, oldId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_masterFileRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getInActive() {
		return _inActive;
	}

	@Override
	public boolean isInActive() {
		return _inActive;
	}

	@Override
	public void setInActive(boolean inActive) {
		_inActive = inActive;

		if (_masterFileRemoteModel != null) {
			try {
				Class<?> clazz = _masterFileRemoteModel.getClass();

				Method method = clazz.getMethod("setInActive", boolean.class);

				method.invoke(_masterFileRemoteModel, inActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMasterFileRemoteModel() {
		return _masterFileRemoteModel;
	}

	public void setMasterFileRemoteModel(BaseModel<?> masterFileRemoteModel) {
		_masterFileRemoteModel = masterFileRemoteModel;
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

		Class<?> remoteModelClass = _masterFileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_masterFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MasterFileLocalServiceUtil.addMasterFile(this);
		}
		else {
			MasterFileLocalServiceUtil.updateMasterFile(this);
		}
	}

	@Override
	public MasterFile toEscapedModel() {
		return (MasterFile)ProxyUtil.newProxyInstance(MasterFile.class.getClassLoader(),
			new Class[] { MasterFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MasterFileClp clone = new MasterFileClp();

		clone.setMasterFileId(getMasterFileId());
		clone.setMasterTypeId(getMasterTypeId());
		clone.setParentId1(getParentId1());
		clone.setParentId2(getParentId2());
		clone.setMasterFileName(getMasterFileName());
		clone.setStatus1(getStatus1());
		clone.setStatus2(getStatus2());
		clone.setStatus3(getStatus3());
		clone.setStatus4(getStatus4());
		clone.setStatus5(getStatus5());
		clone.setMasterCode(getMasterCode());
		clone.setOldId(getOldId());
		clone.setNote(getNote());
		clone.setInActive(getInActive());

		return clone;
	}

	@Override
	public int compareTo(MasterFile masterFile) {
		long primaryKey = masterFile.getPrimaryKey();

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

		if (!(obj instanceof MasterFileClp)) {
			return false;
		}

		MasterFileClp masterFile = (MasterFileClp)obj;

		long primaryKey = masterFile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{masterFileId=");
		sb.append(getMasterFileId());
		sb.append(", masterTypeId=");
		sb.append(getMasterTypeId());
		sb.append(", parentId1=");
		sb.append(getParentId1());
		sb.append(", parentId2=");
		sb.append(getParentId2());
		sb.append(", masterFileName=");
		sb.append(getMasterFileName());
		sb.append(", status1=");
		sb.append(getStatus1());
		sb.append(", status2=");
		sb.append(getStatus2());
		sb.append(", status3=");
		sb.append(getStatus3());
		sb.append(", status4=");
		sb.append(getStatus4());
		sb.append(", status5=");
		sb.append(getStatus5());
		sb.append(", masterCode=");
		sb.append(getMasterCode());
		sb.append(", oldId=");
		sb.append(getOldId());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", inActive=");
		sb.append(getInActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.MasterFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>masterFileId</column-name><column-value><![CDATA[");
		sb.append(getMasterFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterTypeId</column-name><column-value><![CDATA[");
		sb.append(getMasterTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId1</column-name><column-value><![CDATA[");
		sb.append(getParentId1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId2</column-name><column-value><![CDATA[");
		sb.append(getParentId2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterFileName</column-name><column-value><![CDATA[");
		sb.append(getMasterFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status1</column-name><column-value><![CDATA[");
		sb.append(getStatus1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status2</column-name><column-value><![CDATA[");
		sb.append(getStatus2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status3</column-name><column-value><![CDATA[");
		sb.append(getStatus3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status4</column-name><column-value><![CDATA[");
		sb.append(getStatus4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status5</column-name><column-value><![CDATA[");
		sb.append(getStatus5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterCode</column-name><column-value><![CDATA[");
		sb.append(getMasterCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oldId</column-name><column-value><![CDATA[");
		sb.append(getOldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inActive</column-name><column-value><![CDATA[");
		sb.append(getInActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _masterFileId;
	private long _masterTypeId;
	private long _parentId1;
	private long _parentId2;
	private String _masterFileName;
	private boolean _status1;
	private boolean _status2;
	private boolean _status3;
	private boolean _status4;
	private boolean _status5;
	private String _masterCode;
	private long _oldId;
	private String _note;
	private boolean _inActive;
	private BaseModel<?> _masterFileRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
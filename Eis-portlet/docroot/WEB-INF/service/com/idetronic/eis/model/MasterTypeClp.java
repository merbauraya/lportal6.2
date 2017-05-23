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
import com.idetronic.eis.service.MasterTypeLocalServiceUtil;

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
public class MasterTypeClp extends BaseModelImpl<MasterType>
	implements MasterType {
	public MasterTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MasterType.class;
	}

	@Override
	public String getModelClassName() {
		return MasterType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _masterTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMasterTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _masterTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("masterTypeId", getMasterTypeId());
		attributes.put("masterTypeName", getMasterTypeName());
		attributes.put("status", getStatus());
		attributes.put("parentType", getParentType());
		attributes.put("pageLabel", getPageLabel());
		attributes.put("nameLabel", getNameLabel());
		attributes.put("hasParent1", getHasParent1());
		attributes.put("parentId1", getParentId1());
		attributes.put("parentId2", getParentId2());
		attributes.put("hasParent2", getHasParent2());
		attributes.put("parent1Label", getParent1Label());
		attributes.put("parent2Label", getParent2Label());
		attributes.put("hasStatus1", getHasStatus1());
		attributes.put("hasStatus2", getHasStatus2());
		attributes.put("hasStatus3", getHasStatus3());
		attributes.put("hasStatus4", getHasStatus4());
		attributes.put("status1Label", getStatus1Label());
		attributes.put("status2Label", getStatus2Label());
		attributes.put("status3Label", getStatus3Label());
		attributes.put("status4Label", getStatus4Label());
		attributes.put("hasCode", getHasCode());
		attributes.put("codeLabel", getCodeLabel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long masterTypeId = (Long)attributes.get("masterTypeId");

		if (masterTypeId != null) {
			setMasterTypeId(masterTypeId);
		}

		String masterTypeName = (String)attributes.get("masterTypeName");

		if (masterTypeName != null) {
			setMasterTypeName(masterTypeName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean parentType = (Boolean)attributes.get("parentType");

		if (parentType != null) {
			setParentType(parentType);
		}

		String pageLabel = (String)attributes.get("pageLabel");

		if (pageLabel != null) {
			setPageLabel(pageLabel);
		}

		String nameLabel = (String)attributes.get("nameLabel");

		if (nameLabel != null) {
			setNameLabel(nameLabel);
		}

		Boolean hasParent1 = (Boolean)attributes.get("hasParent1");

		if (hasParent1 != null) {
			setHasParent1(hasParent1);
		}

		Long parentId1 = (Long)attributes.get("parentId1");

		if (parentId1 != null) {
			setParentId1(parentId1);
		}

		Long parentId2 = (Long)attributes.get("parentId2");

		if (parentId2 != null) {
			setParentId2(parentId2);
		}

		Boolean hasParent2 = (Boolean)attributes.get("hasParent2");

		if (hasParent2 != null) {
			setHasParent2(hasParent2);
		}

		String parent1Label = (String)attributes.get("parent1Label");

		if (parent1Label != null) {
			setParent1Label(parent1Label);
		}

		String parent2Label = (String)attributes.get("parent2Label");

		if (parent2Label != null) {
			setParent2Label(parent2Label);
		}

		Boolean hasStatus1 = (Boolean)attributes.get("hasStatus1");

		if (hasStatus1 != null) {
			setHasStatus1(hasStatus1);
		}

		Boolean hasStatus2 = (Boolean)attributes.get("hasStatus2");

		if (hasStatus2 != null) {
			setHasStatus2(hasStatus2);
		}

		Boolean hasStatus3 = (Boolean)attributes.get("hasStatus3");

		if (hasStatus3 != null) {
			setHasStatus3(hasStatus3);
		}

		Boolean hasStatus4 = (Boolean)attributes.get("hasStatus4");

		if (hasStatus4 != null) {
			setHasStatus4(hasStatus4);
		}

		String status1Label = (String)attributes.get("status1Label");

		if (status1Label != null) {
			setStatus1Label(status1Label);
		}

		String status2Label = (String)attributes.get("status2Label");

		if (status2Label != null) {
			setStatus2Label(status2Label);
		}

		String status3Label = (String)attributes.get("status3Label");

		if (status3Label != null) {
			setStatus3Label(status3Label);
		}

		String status4Label = (String)attributes.get("status4Label");

		if (status4Label != null) {
			setStatus4Label(status4Label);
		}

		Boolean hasCode = (Boolean)attributes.get("hasCode");

		if (hasCode != null) {
			setHasCode(hasCode);
		}

		String codeLabel = (String)attributes.get("codeLabel");

		if (codeLabel != null) {
			setCodeLabel(codeLabel);
		}
	}

	@Override
	public long getMasterTypeId() {
		return _masterTypeId;
	}

	@Override
	public void setMasterTypeId(long masterTypeId) {
		_masterTypeId = masterTypeId;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterTypeId", long.class);

				method.invoke(_masterTypeRemoteModel, masterTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMasterTypeName() {
		return _masterTypeName;
	}

	@Override
	public void setMasterTypeName(String masterTypeName) {
		_masterTypeName = masterTypeName;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterTypeName",
						String.class);

				method.invoke(_masterTypeRemoteModel, masterTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_masterTypeRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getParentType() {
		return _parentType;
	}

	@Override
	public boolean isParentType() {
		return _parentType;
	}

	@Override
	public void setParentType(boolean parentType) {
		_parentType = parentType;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setParentType", boolean.class);

				method.invoke(_masterTypeRemoteModel, parentType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPageLabel() {
		return _pageLabel;
	}

	@Override
	public void setPageLabel(String pageLabel) {
		_pageLabel = pageLabel;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPageLabel", String.class);

				method.invoke(_masterTypeRemoteModel, pageLabel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNameLabel() {
		return _nameLabel;
	}

	@Override
	public void setNameLabel(String nameLabel) {
		_nameLabel = nameLabel;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setNameLabel", String.class);

				method.invoke(_masterTypeRemoteModel, nameLabel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasParent1() {
		return _hasParent1;
	}

	@Override
	public boolean isHasParent1() {
		return _hasParent1;
	}

	@Override
	public void setHasParent1(boolean hasParent1) {
		_hasParent1 = hasParent1;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasParent1", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasParent1);
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

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId1", long.class);

				method.invoke(_masterTypeRemoteModel, parentId1);
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

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId2", long.class);

				method.invoke(_masterTypeRemoteModel, parentId2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasParent2() {
		return _hasParent2;
	}

	@Override
	public boolean isHasParent2() {
		return _hasParent2;
	}

	@Override
	public void setHasParent2(boolean hasParent2) {
		_hasParent2 = hasParent2;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasParent2", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasParent2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParent1Label() {
		return _parent1Label;
	}

	@Override
	public void setParent1Label(String parent1Label) {
		_parent1Label = parent1Label;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setParent1Label", String.class);

				method.invoke(_masterTypeRemoteModel, parent1Label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParent2Label() {
		return _parent2Label;
	}

	@Override
	public void setParent2Label(String parent2Label) {
		_parent2Label = parent2Label;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setParent2Label", String.class);

				method.invoke(_masterTypeRemoteModel, parent2Label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasStatus1() {
		return _hasStatus1;
	}

	@Override
	public boolean isHasStatus1() {
		return _hasStatus1;
	}

	@Override
	public void setHasStatus1(boolean hasStatus1) {
		_hasStatus1 = hasStatus1;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasStatus1", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasStatus1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasStatus2() {
		return _hasStatus2;
	}

	@Override
	public boolean isHasStatus2() {
		return _hasStatus2;
	}

	@Override
	public void setHasStatus2(boolean hasStatus2) {
		_hasStatus2 = hasStatus2;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasStatus2", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasStatus2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasStatus3() {
		return _hasStatus3;
	}

	@Override
	public boolean isHasStatus3() {
		return _hasStatus3;
	}

	@Override
	public void setHasStatus3(boolean hasStatus3) {
		_hasStatus3 = hasStatus3;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasStatus3", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasStatus3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasStatus4() {
		return _hasStatus4;
	}

	@Override
	public boolean isHasStatus4() {
		return _hasStatus4;
	}

	@Override
	public void setHasStatus4(boolean hasStatus4) {
		_hasStatus4 = hasStatus4;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasStatus4", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasStatus4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus1Label() {
		return _status1Label;
	}

	@Override
	public void setStatus1Label(String status1Label) {
		_status1Label = status1Label;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus1Label", String.class);

				method.invoke(_masterTypeRemoteModel, status1Label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus2Label() {
		return _status2Label;
	}

	@Override
	public void setStatus2Label(String status2Label) {
		_status2Label = status2Label;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus2Label", String.class);

				method.invoke(_masterTypeRemoteModel, status2Label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus3Label() {
		return _status3Label;
	}

	@Override
	public void setStatus3Label(String status3Label) {
		_status3Label = status3Label;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus3Label", String.class);

				method.invoke(_masterTypeRemoteModel, status3Label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus4Label() {
		return _status4Label;
	}

	@Override
	public void setStatus4Label(String status4Label) {
		_status4Label = status4Label;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus4Label", String.class);

				method.invoke(_masterTypeRemoteModel, status4Label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasCode() {
		return _hasCode;
	}

	@Override
	public boolean isHasCode() {
		return _hasCode;
	}

	@Override
	public void setHasCode(boolean hasCode) {
		_hasCode = hasCode;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setHasCode", boolean.class);

				method.invoke(_masterTypeRemoteModel, hasCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodeLabel() {
		return _codeLabel;
	}

	@Override
	public void setCodeLabel(String codeLabel) {
		_codeLabel = codeLabel;

		if (_masterTypeRemoteModel != null) {
			try {
				Class<?> clazz = _masterTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeLabel", String.class);

				method.invoke(_masterTypeRemoteModel, codeLabel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMasterTypeRemoteModel() {
		return _masterTypeRemoteModel;
	}

	public void setMasterTypeRemoteModel(BaseModel<?> masterTypeRemoteModel) {
		_masterTypeRemoteModel = masterTypeRemoteModel;
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

		Class<?> remoteModelClass = _masterTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_masterTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MasterTypeLocalServiceUtil.addMasterType(this);
		}
		else {
			MasterTypeLocalServiceUtil.updateMasterType(this);
		}
	}

	@Override
	public MasterType toEscapedModel() {
		return (MasterType)ProxyUtil.newProxyInstance(MasterType.class.getClassLoader(),
			new Class[] { MasterType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MasterTypeClp clone = new MasterTypeClp();

		clone.setMasterTypeId(getMasterTypeId());
		clone.setMasterTypeName(getMasterTypeName());
		clone.setStatus(getStatus());
		clone.setParentType(getParentType());
		clone.setPageLabel(getPageLabel());
		clone.setNameLabel(getNameLabel());
		clone.setHasParent1(getHasParent1());
		clone.setParentId1(getParentId1());
		clone.setParentId2(getParentId2());
		clone.setHasParent2(getHasParent2());
		clone.setParent1Label(getParent1Label());
		clone.setParent2Label(getParent2Label());
		clone.setHasStatus1(getHasStatus1());
		clone.setHasStatus2(getHasStatus2());
		clone.setHasStatus3(getHasStatus3());
		clone.setHasStatus4(getHasStatus4());
		clone.setStatus1Label(getStatus1Label());
		clone.setStatus2Label(getStatus2Label());
		clone.setStatus3Label(getStatus3Label());
		clone.setStatus4Label(getStatus4Label());
		clone.setHasCode(getHasCode());
		clone.setCodeLabel(getCodeLabel());

		return clone;
	}

	@Override
	public int compareTo(MasterType masterType) {
		long primaryKey = masterType.getPrimaryKey();

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

		if (!(obj instanceof MasterTypeClp)) {
			return false;
		}

		MasterTypeClp masterType = (MasterTypeClp)obj;

		long primaryKey = masterType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{masterTypeId=");
		sb.append(getMasterTypeId());
		sb.append(", masterTypeName=");
		sb.append(getMasterTypeName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", parentType=");
		sb.append(getParentType());
		sb.append(", pageLabel=");
		sb.append(getPageLabel());
		sb.append(", nameLabel=");
		sb.append(getNameLabel());
		sb.append(", hasParent1=");
		sb.append(getHasParent1());
		sb.append(", parentId1=");
		sb.append(getParentId1());
		sb.append(", parentId2=");
		sb.append(getParentId2());
		sb.append(", hasParent2=");
		sb.append(getHasParent2());
		sb.append(", parent1Label=");
		sb.append(getParent1Label());
		sb.append(", parent2Label=");
		sb.append(getParent2Label());
		sb.append(", hasStatus1=");
		sb.append(getHasStatus1());
		sb.append(", hasStatus2=");
		sb.append(getHasStatus2());
		sb.append(", hasStatus3=");
		sb.append(getHasStatus3());
		sb.append(", hasStatus4=");
		sb.append(getHasStatus4());
		sb.append(", status1Label=");
		sb.append(getStatus1Label());
		sb.append(", status2Label=");
		sb.append(getStatus2Label());
		sb.append(", status3Label=");
		sb.append(getStatus3Label());
		sb.append(", status4Label=");
		sb.append(getStatus4Label());
		sb.append(", hasCode=");
		sb.append(getHasCode());
		sb.append(", codeLabel=");
		sb.append(getCodeLabel());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.MasterType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>masterTypeId</column-name><column-value><![CDATA[");
		sb.append(getMasterTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterTypeName</column-name><column-value><![CDATA[");
		sb.append(getMasterTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentType</column-name><column-value><![CDATA[");
		sb.append(getParentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageLabel</column-name><column-value><![CDATA[");
		sb.append(getPageLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameLabel</column-name><column-value><![CDATA[");
		sb.append(getNameLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasParent1</column-name><column-value><![CDATA[");
		sb.append(getHasParent1());
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
			"<column><column-name>hasParent2</column-name><column-value><![CDATA[");
		sb.append(getHasParent2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parent1Label</column-name><column-value><![CDATA[");
		sb.append(getParent1Label());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parent2Label</column-name><column-value><![CDATA[");
		sb.append(getParent2Label());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasStatus1</column-name><column-value><![CDATA[");
		sb.append(getHasStatus1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasStatus2</column-name><column-value><![CDATA[");
		sb.append(getHasStatus2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasStatus3</column-name><column-value><![CDATA[");
		sb.append(getHasStatus3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasStatus4</column-name><column-value><![CDATA[");
		sb.append(getHasStatus4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status1Label</column-name><column-value><![CDATA[");
		sb.append(getStatus1Label());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status2Label</column-name><column-value><![CDATA[");
		sb.append(getStatus2Label());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status3Label</column-name><column-value><![CDATA[");
		sb.append(getStatus3Label());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status4Label</column-name><column-value><![CDATA[");
		sb.append(getStatus4Label());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasCode</column-name><column-value><![CDATA[");
		sb.append(getHasCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeLabel</column-name><column-value><![CDATA[");
		sb.append(getCodeLabel());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _masterTypeId;
	private String _masterTypeName;
	private int _status;
	private boolean _parentType;
	private String _pageLabel;
	private String _nameLabel;
	private boolean _hasParent1;
	private long _parentId1;
	private long _parentId2;
	private boolean _hasParent2;
	private String _parent1Label;
	private String _parent2Label;
	private boolean _hasStatus1;
	private boolean _hasStatus2;
	private boolean _hasStatus3;
	private boolean _hasStatus4;
	private String _status1Label;
	private String _status2Label;
	private String _status3Label;
	private String _status4Label;
	private boolean _hasCode;
	private String _codeLabel;
	private BaseModel<?> _masterTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
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
import com.idetronic.eis.service.MemberCategoryLocalServiceUtil;

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
public class MemberCategoryClp extends BaseModelImpl<MemberCategory>
	implements MemberCategory {
	public MemberCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MemberCategory.class;
	}

	@Override
	public String getModelClassName() {
		return MemberCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _memberCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMemberCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _memberCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberCategoryId", getMemberCategoryId());
		attributes.put("memberCategoryName", getMemberCategoryName());
		attributes.put("memberCategoryGroupName", getMemberCategoryGroupName());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberCategoryId = (Long)attributes.get("memberCategoryId");

		if (memberCategoryId != null) {
			setMemberCategoryId(memberCategoryId);
		}

		String memberCategoryName = (String)attributes.get("memberCategoryName");

		if (memberCategoryName != null) {
			setMemberCategoryName(memberCategoryName);
		}

		String memberCategoryGroupName = (String)attributes.get(
				"memberCategoryGroupName");

		if (memberCategoryGroupName != null) {
			setMemberCategoryGroupName(memberCategoryGroupName);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getMemberCategoryId() {
		return _memberCategoryId;
	}

	@Override
	public void setMemberCategoryId(long memberCategoryId) {
		_memberCategoryId = memberCategoryId;

		if (_memberCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _memberCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberCategoryId",
						long.class);

				method.invoke(_memberCategoryRemoteModel, memberCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMemberCategoryName() {
		return _memberCategoryName;
	}

	@Override
	public void setMemberCategoryName(String memberCategoryName) {
		_memberCategoryName = memberCategoryName;

		if (_memberCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _memberCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberCategoryName",
						String.class);

				method.invoke(_memberCategoryRemoteModel, memberCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMemberCategoryGroupName() {
		return _memberCategoryGroupName;
	}

	@Override
	public void setMemberCategoryGroupName(String memberCategoryGroupName) {
		_memberCategoryGroupName = memberCategoryGroupName;

		if (_memberCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _memberCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberCategoryGroupName",
						String.class);

				method.invoke(_memberCategoryRemoteModel,
					memberCategoryGroupName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_memberCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _memberCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_memberCategoryRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMemberCategoryRemoteModel() {
		return _memberCategoryRemoteModel;
	}

	public void setMemberCategoryRemoteModel(
		BaseModel<?> memberCategoryRemoteModel) {
		_memberCategoryRemoteModel = memberCategoryRemoteModel;
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

		Class<?> remoteModelClass = _memberCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_memberCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MemberCategoryLocalServiceUtil.addMemberCategory(this);
		}
		else {
			MemberCategoryLocalServiceUtil.updateMemberCategory(this);
		}
	}

	@Override
	public MemberCategory toEscapedModel() {
		return (MemberCategory)ProxyUtil.newProxyInstance(MemberCategory.class.getClassLoader(),
			new Class[] { MemberCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MemberCategoryClp clone = new MemberCategoryClp();

		clone.setMemberCategoryId(getMemberCategoryId());
		clone.setMemberCategoryName(getMemberCategoryName());
		clone.setMemberCategoryGroupName(getMemberCategoryGroupName());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(MemberCategory memberCategory) {
		long primaryKey = memberCategory.getPrimaryKey();

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

		if (!(obj instanceof MemberCategoryClp)) {
			return false;
		}

		MemberCategoryClp memberCategory = (MemberCategoryClp)obj;

		long primaryKey = memberCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{memberCategoryId=");
		sb.append(getMemberCategoryId());
		sb.append(", memberCategoryName=");
		sb.append(getMemberCategoryName());
		sb.append(", memberCategoryGroupName=");
		sb.append(getMemberCategoryGroupName());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.MemberCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>memberCategoryId</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberCategoryName</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberCategoryGroupName</column-name><column-value><![CDATA[");
		sb.append(getMemberCategoryGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _memberCategoryId;
	private String _memberCategoryName;
	private String _memberCategoryGroupName;
	private boolean _active;
	private BaseModel<?> _memberCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
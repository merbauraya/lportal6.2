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

import com.idetronic.eis.service.BorrowerCategoryLocalServiceUtil;
import com.idetronic.eis.service.ClpSerializer;

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
public class BorrowerCategoryClp extends BaseModelImpl<BorrowerCategory>
	implements BorrowerCategory {
	public BorrowerCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BorrowerCategory.class;
	}

	@Override
	public String getModelClassName() {
		return BorrowerCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _borrowerCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBorrowerCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _borrowerCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("borrowerCategoryId", getBorrowerCategoryId());
		attributes.put("borrowerCategoryName", getBorrowerCategoryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long borrowerCategoryId = (Long)attributes.get("borrowerCategoryId");

		if (borrowerCategoryId != null) {
			setBorrowerCategoryId(borrowerCategoryId);
		}

		String borrowerCategoryName = (String)attributes.get(
				"borrowerCategoryName");

		if (borrowerCategoryName != null) {
			setBorrowerCategoryName(borrowerCategoryName);
		}
	}

	@Override
	public long getBorrowerCategoryId() {
		return _borrowerCategoryId;
	}

	@Override
	public void setBorrowerCategoryId(long borrowerCategoryId) {
		_borrowerCategoryId = borrowerCategoryId;

		if (_borrowerCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _borrowerCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setBorrowerCategoryId",
						long.class);

				method.invoke(_borrowerCategoryRemoteModel, borrowerCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBorrowerCategoryName() {
		return _borrowerCategoryName;
	}

	@Override
	public void setBorrowerCategoryName(String borrowerCategoryName) {
		_borrowerCategoryName = borrowerCategoryName;

		if (_borrowerCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _borrowerCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setBorrowerCategoryName",
						String.class);

				method.invoke(_borrowerCategoryRemoteModel, borrowerCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBorrowerCategoryRemoteModel() {
		return _borrowerCategoryRemoteModel;
	}

	public void setBorrowerCategoryRemoteModel(
		BaseModel<?> borrowerCategoryRemoteModel) {
		_borrowerCategoryRemoteModel = borrowerCategoryRemoteModel;
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

		Class<?> remoteModelClass = _borrowerCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_borrowerCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BorrowerCategoryLocalServiceUtil.addBorrowerCategory(this);
		}
		else {
			BorrowerCategoryLocalServiceUtil.updateBorrowerCategory(this);
		}
	}

	@Override
	public BorrowerCategory toEscapedModel() {
		return (BorrowerCategory)ProxyUtil.newProxyInstance(BorrowerCategory.class.getClassLoader(),
			new Class[] { BorrowerCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BorrowerCategoryClp clone = new BorrowerCategoryClp();

		clone.setBorrowerCategoryId(getBorrowerCategoryId());
		clone.setBorrowerCategoryName(getBorrowerCategoryName());

		return clone;
	}

	@Override
	public int compareTo(BorrowerCategory borrowerCategory) {
		long primaryKey = borrowerCategory.getPrimaryKey();

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

		if (!(obj instanceof BorrowerCategoryClp)) {
			return false;
		}

		BorrowerCategoryClp borrowerCategory = (BorrowerCategoryClp)obj;

		long primaryKey = borrowerCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{borrowerCategoryId=");
		sb.append(getBorrowerCategoryId());
		sb.append(", borrowerCategoryName=");
		sb.append(getBorrowerCategoryName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.BorrowerCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>borrowerCategoryId</column-name><column-value><![CDATA[");
		sb.append(getBorrowerCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>borrowerCategoryName</column-name><column-value><![CDATA[");
		sb.append(getBorrowerCategoryName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _borrowerCategoryId;
	private String _borrowerCategoryName;
	private BaseModel<?> _borrowerCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
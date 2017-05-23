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
import com.idetronic.eis.service.ReportLocalServiceUtil;

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
public class ReportClp extends BaseModelImpl<Report> implements Report {
	public ReportClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Report.class;
	}

	@Override
	public String getModelClassName() {
		return Report.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _reportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("reportKey", getReportKey());
		attributes.put("reportName", getReportName());
		attributes.put("reportTitle", getReportTitle());
		attributes.put("dataEntry", getDataEntry());
		attributes.put("dataName", getDataName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		String reportKey = (String)attributes.get("reportKey");

		if (reportKey != null) {
			setReportKey(reportKey);
		}

		String reportName = (String)attributes.get("reportName");

		if (reportName != null) {
			setReportName(reportName);
		}

		String reportTitle = (String)attributes.get("reportTitle");

		if (reportTitle != null) {
			setReportTitle(reportTitle);
		}

		Boolean dataEntry = (Boolean)attributes.get("dataEntry");

		if (dataEntry != null) {
			setDataEntry(dataEntry);
		}

		String dataName = (String)attributes.get("dataName");

		if (dataName != null) {
			setDataName(dataName);
		}
	}

	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_reportId = reportId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_reportRemoteModel, reportId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportKey() {
		return _reportKey;
	}

	@Override
	public void setReportKey(String reportKey) {
		_reportKey = reportKey;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportKey", String.class);

				method.invoke(_reportRemoteModel, reportKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportName() {
		return _reportName;
	}

	@Override
	public void setReportName(String reportName) {
		_reportName = reportName;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportName", String.class);

				method.invoke(_reportRemoteModel, reportName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportTitle() {
		return _reportTitle;
	}

	@Override
	public void setReportTitle(String reportTitle) {
		_reportTitle = reportTitle;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportTitle", String.class);

				method.invoke(_reportRemoteModel, reportTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDataEntry() {
		return _dataEntry;
	}

	@Override
	public boolean isDataEntry() {
		return _dataEntry;
	}

	@Override
	public void setDataEntry(boolean dataEntry) {
		_dataEntry = dataEntry;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setDataEntry", boolean.class);

				method.invoke(_reportRemoteModel, dataEntry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataName() {
		return _dataName;
	}

	@Override
	public void setDataName(String dataName) {
		_dataName = dataName;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setDataName", String.class);

				method.invoke(_reportRemoteModel, dataName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getReportRemoteModel() {
		return _reportRemoteModel;
	}

	public void setReportRemoteModel(BaseModel<?> reportRemoteModel) {
		_reportRemoteModel = reportRemoteModel;
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

		Class<?> remoteModelClass = _reportRemoteModel.getClass();

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

		Object returnValue = method.invoke(_reportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReportLocalServiceUtil.addReport(this);
		}
		else {
			ReportLocalServiceUtil.updateReport(this);
		}
	}

	@Override
	public Report toEscapedModel() {
		return (Report)ProxyUtil.newProxyInstance(Report.class.getClassLoader(),
			new Class[] { Report.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReportClp clone = new ReportClp();

		clone.setReportId(getReportId());
		clone.setReportKey(getReportKey());
		clone.setReportName(getReportName());
		clone.setReportTitle(getReportTitle());
		clone.setDataEntry(getDataEntry());
		clone.setDataName(getDataName());

		return clone;
	}

	@Override
	public int compareTo(Report report) {
		long primaryKey = report.getPrimaryKey();

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

		if (!(obj instanceof ReportClp)) {
			return false;
		}

		ReportClp report = (ReportClp)obj;

		long primaryKey = report.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{reportId=");
		sb.append(getReportId());
		sb.append(", reportKey=");
		sb.append(getReportKey());
		sb.append(", reportName=");
		sb.append(getReportName());
		sb.append(", reportTitle=");
		sb.append(getReportTitle());
		sb.append(", dataEntry=");
		sb.append(getDataEntry());
		sb.append(", dataName=");
		sb.append(getDataName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Report");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportKey</column-name><column-value><![CDATA[");
		sb.append(getReportKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportName</column-name><column-value><![CDATA[");
		sb.append(getReportName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportTitle</column-name><column-value><![CDATA[");
		sb.append(getReportTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataEntry</column-name><column-value><![CDATA[");
		sb.append(getDataEntry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataName</column-name><column-value><![CDATA[");
		sb.append(getDataName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _reportId;
	private String _reportKey;
	private String _reportName;
	private String _reportTitle;
	private boolean _dataEntry;
	private String _dataName;
	private BaseModel<?> _reportRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
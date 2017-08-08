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
		attributes.put("hqDataEntry", getHqDataEntry());
		attributes.put("dimensionId", getDimensionId());
		attributes.put("hasMeasure1", getHasMeasure1());
		attributes.put("hasMeasure2", getHasMeasure2());
		attributes.put("hasMeasure3", getHasMeasure3());
		attributes.put("hasMeasure4", getHasMeasure4());
		attributes.put("measure1Name", getMeasure1Name());
		attributes.put("measure2Name", getMeasure2Name());
		attributes.put("measure3Name", getMeasure3Name());
		attributes.put("measure4Name", getMeasure4Name());
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

		Boolean hqDataEntry = (Boolean)attributes.get("hqDataEntry");

		if (hqDataEntry != null) {
			setHqDataEntry(hqDataEntry);
		}

		Long dimensionId = (Long)attributes.get("dimensionId");

		if (dimensionId != null) {
			setDimensionId(dimensionId);
		}

		Boolean hasMeasure1 = (Boolean)attributes.get("hasMeasure1");

		if (hasMeasure1 != null) {
			setHasMeasure1(hasMeasure1);
		}

		Boolean hasMeasure2 = (Boolean)attributes.get("hasMeasure2");

		if (hasMeasure2 != null) {
			setHasMeasure2(hasMeasure2);
		}

		Boolean hasMeasure3 = (Boolean)attributes.get("hasMeasure3");

		if (hasMeasure3 != null) {
			setHasMeasure3(hasMeasure3);
		}

		Boolean hasMeasure4 = (Boolean)attributes.get("hasMeasure4");

		if (hasMeasure4 != null) {
			setHasMeasure4(hasMeasure4);
		}

		String measure1Name = (String)attributes.get("measure1Name");

		if (measure1Name != null) {
			setMeasure1Name(measure1Name);
		}

		String measure2Name = (String)attributes.get("measure2Name");

		if (measure2Name != null) {
			setMeasure2Name(measure2Name);
		}

		String measure3Name = (String)attributes.get("measure3Name");

		if (measure3Name != null) {
			setMeasure3Name(measure3Name);
		}

		String measure4Name = (String)attributes.get("measure4Name");

		if (measure4Name != null) {
			setMeasure4Name(measure4Name);
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
	public boolean getHqDataEntry() {
		return _hqDataEntry;
	}

	@Override
	public boolean isHqDataEntry() {
		return _hqDataEntry;
	}

	@Override
	public void setHqDataEntry(boolean hqDataEntry) {
		_hqDataEntry = hqDataEntry;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setHqDataEntry", boolean.class);

				method.invoke(_reportRemoteModel, hqDataEntry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDimensionId() {
		return _dimensionId;
	}

	@Override
	public void setDimensionId(long dimensionId) {
		_dimensionId = dimensionId;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setDimensionId", long.class);

				method.invoke(_reportRemoteModel, dimensionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasMeasure1() {
		return _hasMeasure1;
	}

	@Override
	public boolean isHasMeasure1() {
		return _hasMeasure1;
	}

	@Override
	public void setHasMeasure1(boolean hasMeasure1) {
		_hasMeasure1 = hasMeasure1;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setHasMeasure1", boolean.class);

				method.invoke(_reportRemoteModel, hasMeasure1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasMeasure2() {
		return _hasMeasure2;
	}

	@Override
	public boolean isHasMeasure2() {
		return _hasMeasure2;
	}

	@Override
	public void setHasMeasure2(boolean hasMeasure2) {
		_hasMeasure2 = hasMeasure2;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setHasMeasure2", boolean.class);

				method.invoke(_reportRemoteModel, hasMeasure2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasMeasure3() {
		return _hasMeasure3;
	}

	@Override
	public boolean isHasMeasure3() {
		return _hasMeasure3;
	}

	@Override
	public void setHasMeasure3(boolean hasMeasure3) {
		_hasMeasure3 = hasMeasure3;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setHasMeasure3", boolean.class);

				method.invoke(_reportRemoteModel, hasMeasure3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasMeasure4() {
		return _hasMeasure4;
	}

	@Override
	public boolean isHasMeasure4() {
		return _hasMeasure4;
	}

	@Override
	public void setHasMeasure4(boolean hasMeasure4) {
		_hasMeasure4 = hasMeasure4;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setHasMeasure4", boolean.class);

				method.invoke(_reportRemoteModel, hasMeasure4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasure1Name() {
		return _measure1Name;
	}

	@Override
	public void setMeasure1Name(String measure1Name) {
		_measure1Name = measure1Name;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure1Name", String.class);

				method.invoke(_reportRemoteModel, measure1Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasure2Name() {
		return _measure2Name;
	}

	@Override
	public void setMeasure2Name(String measure2Name) {
		_measure2Name = measure2Name;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure2Name", String.class);

				method.invoke(_reportRemoteModel, measure2Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasure3Name() {
		return _measure3Name;
	}

	@Override
	public void setMeasure3Name(String measure3Name) {
		_measure3Name = measure3Name;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure3Name", String.class);

				method.invoke(_reportRemoteModel, measure3Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasure4Name() {
		return _measure4Name;
	}

	@Override
	public void setMeasure4Name(String measure4Name) {
		_measure4Name = measure4Name;

		if (_reportRemoteModel != null) {
			try {
				Class<?> clazz = _reportRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasure4Name", String.class);

				method.invoke(_reportRemoteModel, measure4Name);
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
		clone.setHqDataEntry(getHqDataEntry());
		clone.setDimensionId(getDimensionId());
		clone.setHasMeasure1(getHasMeasure1());
		clone.setHasMeasure2(getHasMeasure2());
		clone.setHasMeasure3(getHasMeasure3());
		clone.setHasMeasure4(getHasMeasure4());
		clone.setMeasure1Name(getMeasure1Name());
		clone.setMeasure2Name(getMeasure2Name());
		clone.setMeasure3Name(getMeasure3Name());
		clone.setMeasure4Name(getMeasure4Name());
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
		StringBundler sb = new StringBundler(33);

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
		sb.append(", hqDataEntry=");
		sb.append(getHqDataEntry());
		sb.append(", dimensionId=");
		sb.append(getDimensionId());
		sb.append(", hasMeasure1=");
		sb.append(getHasMeasure1());
		sb.append(", hasMeasure2=");
		sb.append(getHasMeasure2());
		sb.append(", hasMeasure3=");
		sb.append(getHasMeasure3());
		sb.append(", hasMeasure4=");
		sb.append(getHasMeasure4());
		sb.append(", measure1Name=");
		sb.append(getMeasure1Name());
		sb.append(", measure2Name=");
		sb.append(getMeasure2Name());
		sb.append(", measure3Name=");
		sb.append(getMeasure3Name());
		sb.append(", measure4Name=");
		sb.append(getMeasure4Name());
		sb.append(", dataName=");
		sb.append(getDataName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

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
			"<column><column-name>hqDataEntry</column-name><column-value><![CDATA[");
		sb.append(getHqDataEntry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dimensionId</column-name><column-value><![CDATA[");
		sb.append(getDimensionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasMeasure1</column-name><column-value><![CDATA[");
		sb.append(getHasMeasure1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasMeasure2</column-name><column-value><![CDATA[");
		sb.append(getHasMeasure2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasMeasure3</column-name><column-value><![CDATA[");
		sb.append(getHasMeasure3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasMeasure4</column-name><column-value><![CDATA[");
		sb.append(getHasMeasure4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure1Name</column-name><column-value><![CDATA[");
		sb.append(getMeasure1Name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure2Name</column-name><column-value><![CDATA[");
		sb.append(getMeasure2Name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure3Name</column-name><column-value><![CDATA[");
		sb.append(getMeasure3Name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measure4Name</column-name><column-value><![CDATA[");
		sb.append(getMeasure4Name());
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
	private boolean _hqDataEntry;
	private long _dimensionId;
	private boolean _hasMeasure1;
	private boolean _hasMeasure2;
	private boolean _hasMeasure3;
	private boolean _hasMeasure4;
	private String _measure1Name;
	private String _measure2Name;
	private String _measure3Name;
	private String _measure4Name;
	private String _dataName;
	private BaseModel<?> _reportRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
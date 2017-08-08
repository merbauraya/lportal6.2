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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Report}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Report
 * @generated
 */
public class ReportWrapper implements Report, ModelWrapper<Report> {
	public ReportWrapper(Report report) {
		_report = report;
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

	/**
	* Returns the primary key of this report.
	*
	* @return the primary key of this report
	*/
	@Override
	public long getPrimaryKey() {
		return _report.getPrimaryKey();
	}

	/**
	* Sets the primary key of this report.
	*
	* @param primaryKey the primary key of this report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_report.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the report ID of this report.
	*
	* @return the report ID of this report
	*/
	@Override
	public long getReportId() {
		return _report.getReportId();
	}

	/**
	* Sets the report ID of this report.
	*
	* @param reportId the report ID of this report
	*/
	@Override
	public void setReportId(long reportId) {
		_report.setReportId(reportId);
	}

	/**
	* Returns the report key of this report.
	*
	* @return the report key of this report
	*/
	@Override
	public java.lang.String getReportKey() {
		return _report.getReportKey();
	}

	/**
	* Sets the report key of this report.
	*
	* @param reportKey the report key of this report
	*/
	@Override
	public void setReportKey(java.lang.String reportKey) {
		_report.setReportKey(reportKey);
	}

	/**
	* Returns the report name of this report.
	*
	* @return the report name of this report
	*/
	@Override
	public java.lang.String getReportName() {
		return _report.getReportName();
	}

	/**
	* Sets the report name of this report.
	*
	* @param reportName the report name of this report
	*/
	@Override
	public void setReportName(java.lang.String reportName) {
		_report.setReportName(reportName);
	}

	/**
	* Returns the report title of this report.
	*
	* @return the report title of this report
	*/
	@Override
	public java.lang.String getReportTitle() {
		return _report.getReportTitle();
	}

	/**
	* Sets the report title of this report.
	*
	* @param reportTitle the report title of this report
	*/
	@Override
	public void setReportTitle(java.lang.String reportTitle) {
		_report.setReportTitle(reportTitle);
	}

	/**
	* Returns the data entry of this report.
	*
	* @return the data entry of this report
	*/
	@Override
	public boolean getDataEntry() {
		return _report.getDataEntry();
	}

	/**
	* Returns <code>true</code> if this report is data entry.
	*
	* @return <code>true</code> if this report is data entry; <code>false</code> otherwise
	*/
	@Override
	public boolean isDataEntry() {
		return _report.isDataEntry();
	}

	/**
	* Sets whether this report is data entry.
	*
	* @param dataEntry the data entry of this report
	*/
	@Override
	public void setDataEntry(boolean dataEntry) {
		_report.setDataEntry(dataEntry);
	}

	/**
	* Returns the hq data entry of this report.
	*
	* @return the hq data entry of this report
	*/
	@Override
	public boolean getHqDataEntry() {
		return _report.getHqDataEntry();
	}

	/**
	* Returns <code>true</code> if this report is hq data entry.
	*
	* @return <code>true</code> if this report is hq data entry; <code>false</code> otherwise
	*/
	@Override
	public boolean isHqDataEntry() {
		return _report.isHqDataEntry();
	}

	/**
	* Sets whether this report is hq data entry.
	*
	* @param hqDataEntry the hq data entry of this report
	*/
	@Override
	public void setHqDataEntry(boolean hqDataEntry) {
		_report.setHqDataEntry(hqDataEntry);
	}

	/**
	* Returns the dimension ID of this report.
	*
	* @return the dimension ID of this report
	*/
	@Override
	public long getDimensionId() {
		return _report.getDimensionId();
	}

	/**
	* Sets the dimension ID of this report.
	*
	* @param dimensionId the dimension ID of this report
	*/
	@Override
	public void setDimensionId(long dimensionId) {
		_report.setDimensionId(dimensionId);
	}

	/**
	* Returns the has measure1 of this report.
	*
	* @return the has measure1 of this report
	*/
	@Override
	public boolean getHasMeasure1() {
		return _report.getHasMeasure1();
	}

	/**
	* Returns <code>true</code> if this report is has measure1.
	*
	* @return <code>true</code> if this report is has measure1; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasMeasure1() {
		return _report.isHasMeasure1();
	}

	/**
	* Sets whether this report is has measure1.
	*
	* @param hasMeasure1 the has measure1 of this report
	*/
	@Override
	public void setHasMeasure1(boolean hasMeasure1) {
		_report.setHasMeasure1(hasMeasure1);
	}

	/**
	* Returns the has measure2 of this report.
	*
	* @return the has measure2 of this report
	*/
	@Override
	public boolean getHasMeasure2() {
		return _report.getHasMeasure2();
	}

	/**
	* Returns <code>true</code> if this report is has measure2.
	*
	* @return <code>true</code> if this report is has measure2; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasMeasure2() {
		return _report.isHasMeasure2();
	}

	/**
	* Sets whether this report is has measure2.
	*
	* @param hasMeasure2 the has measure2 of this report
	*/
	@Override
	public void setHasMeasure2(boolean hasMeasure2) {
		_report.setHasMeasure2(hasMeasure2);
	}

	/**
	* Returns the has measure3 of this report.
	*
	* @return the has measure3 of this report
	*/
	@Override
	public boolean getHasMeasure3() {
		return _report.getHasMeasure3();
	}

	/**
	* Returns <code>true</code> if this report is has measure3.
	*
	* @return <code>true</code> if this report is has measure3; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasMeasure3() {
		return _report.isHasMeasure3();
	}

	/**
	* Sets whether this report is has measure3.
	*
	* @param hasMeasure3 the has measure3 of this report
	*/
	@Override
	public void setHasMeasure3(boolean hasMeasure3) {
		_report.setHasMeasure3(hasMeasure3);
	}

	/**
	* Returns the has measure4 of this report.
	*
	* @return the has measure4 of this report
	*/
	@Override
	public boolean getHasMeasure4() {
		return _report.getHasMeasure4();
	}

	/**
	* Returns <code>true</code> if this report is has measure4.
	*
	* @return <code>true</code> if this report is has measure4; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasMeasure4() {
		return _report.isHasMeasure4();
	}

	/**
	* Sets whether this report is has measure4.
	*
	* @param hasMeasure4 the has measure4 of this report
	*/
	@Override
	public void setHasMeasure4(boolean hasMeasure4) {
		_report.setHasMeasure4(hasMeasure4);
	}

	/**
	* Returns the measure1 name of this report.
	*
	* @return the measure1 name of this report
	*/
	@Override
	public java.lang.String getMeasure1Name() {
		return _report.getMeasure1Name();
	}

	/**
	* Sets the measure1 name of this report.
	*
	* @param measure1Name the measure1 name of this report
	*/
	@Override
	public void setMeasure1Name(java.lang.String measure1Name) {
		_report.setMeasure1Name(measure1Name);
	}

	/**
	* Returns the measure2 name of this report.
	*
	* @return the measure2 name of this report
	*/
	@Override
	public java.lang.String getMeasure2Name() {
		return _report.getMeasure2Name();
	}

	/**
	* Sets the measure2 name of this report.
	*
	* @param measure2Name the measure2 name of this report
	*/
	@Override
	public void setMeasure2Name(java.lang.String measure2Name) {
		_report.setMeasure2Name(measure2Name);
	}

	/**
	* Returns the measure3 name of this report.
	*
	* @return the measure3 name of this report
	*/
	@Override
	public java.lang.String getMeasure3Name() {
		return _report.getMeasure3Name();
	}

	/**
	* Sets the measure3 name of this report.
	*
	* @param measure3Name the measure3 name of this report
	*/
	@Override
	public void setMeasure3Name(java.lang.String measure3Name) {
		_report.setMeasure3Name(measure3Name);
	}

	/**
	* Returns the measure4 name of this report.
	*
	* @return the measure4 name of this report
	*/
	@Override
	public java.lang.String getMeasure4Name() {
		return _report.getMeasure4Name();
	}

	/**
	* Sets the measure4 name of this report.
	*
	* @param measure4Name the measure4 name of this report
	*/
	@Override
	public void setMeasure4Name(java.lang.String measure4Name) {
		_report.setMeasure4Name(measure4Name);
	}

	/**
	* Returns the data name of this report.
	*
	* @return the data name of this report
	*/
	@Override
	public java.lang.String getDataName() {
		return _report.getDataName();
	}

	/**
	* Sets the data name of this report.
	*
	* @param dataName the data name of this report
	*/
	@Override
	public void setDataName(java.lang.String dataName) {
		_report.setDataName(dataName);
	}

	@Override
	public boolean isNew() {
		return _report.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_report.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _report.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_report.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _report.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _report.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_report.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _report.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_report.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_report.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_report.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReportWrapper((Report)_report.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.Report report) {
		return _report.compareTo(report);
	}

	@Override
	public int hashCode() {
		return _report.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.Report> toCacheModel() {
		return _report.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.Report toEscapedModel() {
		return new ReportWrapper(_report.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.Report toUnescapedModel() {
		return new ReportWrapper(_report.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _report.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _report.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_report.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReportWrapper)) {
			return false;
		}

		ReportWrapper reportWrapper = (ReportWrapper)obj;

		if (Validator.equals(_report, reportWrapper._report)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Report getWrappedReport() {
		return _report;
	}

	@Override
	public Report getWrappedModel() {
		return _report;
	}

	@Override
	public void resetOriginalValues() {
		_report.resetOriginalValues();
	}

	private Report _report;
}
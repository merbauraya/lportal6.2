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
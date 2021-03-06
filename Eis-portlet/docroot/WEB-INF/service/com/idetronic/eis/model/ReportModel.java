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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Report service. Represents a row in the &quot;eis_Report&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.ReportModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.ReportImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Report
 * @see com.idetronic.eis.model.impl.ReportImpl
 * @see com.idetronic.eis.model.impl.ReportModelImpl
 * @generated
 */
public interface ReportModel extends BaseModel<Report> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a report model instance should use the {@link Report} interface instead.
	 */

	/**
	 * Returns the primary key of this report.
	 *
	 * @return the primary key of this report
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this report.
	 *
	 * @param primaryKey the primary key of this report
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the report ID of this report.
	 *
	 * @return the report ID of this report
	 */
	public long getReportId();

	/**
	 * Sets the report ID of this report.
	 *
	 * @param reportId the report ID of this report
	 */
	public void setReportId(long reportId);

	/**
	 * Returns the report key of this report.
	 *
	 * @return the report key of this report
	 */
	@AutoEscape
	public String getReportKey();

	/**
	 * Sets the report key of this report.
	 *
	 * @param reportKey the report key of this report
	 */
	public void setReportKey(String reportKey);

	/**
	 * Returns the report name of this report.
	 *
	 * @return the report name of this report
	 */
	@AutoEscape
	public String getReportName();

	/**
	 * Sets the report name of this report.
	 *
	 * @param reportName the report name of this report
	 */
	public void setReportName(String reportName);

	/**
	 * Returns the report title of this report.
	 *
	 * @return the report title of this report
	 */
	@AutoEscape
	public String getReportTitle();

	/**
	 * Sets the report title of this report.
	 *
	 * @param reportTitle the report title of this report
	 */
	public void setReportTitle(String reportTitle);

	/**
	 * Returns the data entry of this report.
	 *
	 * @return the data entry of this report
	 */
	public boolean getDataEntry();

	/**
	 * Returns <code>true</code> if this report is data entry.
	 *
	 * @return <code>true</code> if this report is data entry; <code>false</code> otherwise
	 */
	public boolean isDataEntry();

	/**
	 * Sets whether this report is data entry.
	 *
	 * @param dataEntry the data entry of this report
	 */
	public void setDataEntry(boolean dataEntry);

	/**
	 * Returns the hq data entry of this report.
	 *
	 * @return the hq data entry of this report
	 */
	public boolean getHqDataEntry();

	/**
	 * Returns <code>true</code> if this report is hq data entry.
	 *
	 * @return <code>true</code> if this report is hq data entry; <code>false</code> otherwise
	 */
	public boolean isHqDataEntry();

	/**
	 * Sets whether this report is hq data entry.
	 *
	 * @param hqDataEntry the hq data entry of this report
	 */
	public void setHqDataEntry(boolean hqDataEntry);

	/**
	 * Returns the dimension ID of this report.
	 *
	 * @return the dimension ID of this report
	 */
	public long getDimensionId();

	/**
	 * Sets the dimension ID of this report.
	 *
	 * @param dimensionId the dimension ID of this report
	 */
	public void setDimensionId(long dimensionId);

	/**
	 * Returns the has measure1 of this report.
	 *
	 * @return the has measure1 of this report
	 */
	public boolean getHasMeasure1();

	/**
	 * Returns <code>true</code> if this report is has measure1.
	 *
	 * @return <code>true</code> if this report is has measure1; <code>false</code> otherwise
	 */
	public boolean isHasMeasure1();

	/**
	 * Sets whether this report is has measure1.
	 *
	 * @param hasMeasure1 the has measure1 of this report
	 */
	public void setHasMeasure1(boolean hasMeasure1);

	/**
	 * Returns the has measure2 of this report.
	 *
	 * @return the has measure2 of this report
	 */
	public boolean getHasMeasure2();

	/**
	 * Returns <code>true</code> if this report is has measure2.
	 *
	 * @return <code>true</code> if this report is has measure2; <code>false</code> otherwise
	 */
	public boolean isHasMeasure2();

	/**
	 * Sets whether this report is has measure2.
	 *
	 * @param hasMeasure2 the has measure2 of this report
	 */
	public void setHasMeasure2(boolean hasMeasure2);

	/**
	 * Returns the has measure3 of this report.
	 *
	 * @return the has measure3 of this report
	 */
	public boolean getHasMeasure3();

	/**
	 * Returns <code>true</code> if this report is has measure3.
	 *
	 * @return <code>true</code> if this report is has measure3; <code>false</code> otherwise
	 */
	public boolean isHasMeasure3();

	/**
	 * Sets whether this report is has measure3.
	 *
	 * @param hasMeasure3 the has measure3 of this report
	 */
	public void setHasMeasure3(boolean hasMeasure3);

	/**
	 * Returns the has measure4 of this report.
	 *
	 * @return the has measure4 of this report
	 */
	public boolean getHasMeasure4();

	/**
	 * Returns <code>true</code> if this report is has measure4.
	 *
	 * @return <code>true</code> if this report is has measure4; <code>false</code> otherwise
	 */
	public boolean isHasMeasure4();

	/**
	 * Sets whether this report is has measure4.
	 *
	 * @param hasMeasure4 the has measure4 of this report
	 */
	public void setHasMeasure4(boolean hasMeasure4);

	/**
	 * Returns the measure1 name of this report.
	 *
	 * @return the measure1 name of this report
	 */
	@AutoEscape
	public String getMeasure1Name();

	/**
	 * Sets the measure1 name of this report.
	 *
	 * @param measure1Name the measure1 name of this report
	 */
	public void setMeasure1Name(String measure1Name);

	/**
	 * Returns the measure2 name of this report.
	 *
	 * @return the measure2 name of this report
	 */
	@AutoEscape
	public String getMeasure2Name();

	/**
	 * Sets the measure2 name of this report.
	 *
	 * @param measure2Name the measure2 name of this report
	 */
	public void setMeasure2Name(String measure2Name);

	/**
	 * Returns the measure3 name of this report.
	 *
	 * @return the measure3 name of this report
	 */
	@AutoEscape
	public String getMeasure3Name();

	/**
	 * Sets the measure3 name of this report.
	 *
	 * @param measure3Name the measure3 name of this report
	 */
	public void setMeasure3Name(String measure3Name);

	/**
	 * Returns the measure4 name of this report.
	 *
	 * @return the measure4 name of this report
	 */
	@AutoEscape
	public String getMeasure4Name();

	/**
	 * Sets the measure4 name of this report.
	 *
	 * @param measure4Name the measure4 name of this report
	 */
	public void setMeasure4Name(String measure4Name);

	/**
	 * Returns the data name of this report.
	 *
	 * @return the data name of this report
	 */
	@AutoEscape
	public String getDataName();

	/**
	 * Sets the data name of this report.
	 *
	 * @param dataName the data name of this report
	 */
	public void setDataName(String dataName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.idetronic.eis.model.Report report);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.Report> toCacheModel();

	@Override
	public com.idetronic.eis.model.Report toEscapedModel();

	@Override
	public com.idetronic.eis.model.Report toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
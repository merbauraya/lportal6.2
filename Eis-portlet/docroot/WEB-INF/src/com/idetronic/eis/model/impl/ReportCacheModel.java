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

package com.idetronic.eis.model.impl;

import com.idetronic.eis.model.Report;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Report in entity cache.
 *
 * @author Mazlan Mat
 * @see Report
 * @generated
 */
public class ReportCacheModel implements CacheModel<Report>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{reportId=");
		sb.append(reportId);
		sb.append(", reportKey=");
		sb.append(reportKey);
		sb.append(", reportName=");
		sb.append(reportName);
		sb.append(", reportTitle=");
		sb.append(reportTitle);
		sb.append(", dataEntry=");
		sb.append(dataEntry);
		sb.append(", hqDataEntry=");
		sb.append(hqDataEntry);
		sb.append(", dimensionId=");
		sb.append(dimensionId);
		sb.append(", hasMeasure1=");
		sb.append(hasMeasure1);
		sb.append(", hasMeasure2=");
		sb.append(hasMeasure2);
		sb.append(", hasMeasure3=");
		sb.append(hasMeasure3);
		sb.append(", hasMeasure4=");
		sb.append(hasMeasure4);
		sb.append(", measure1Name=");
		sb.append(measure1Name);
		sb.append(", measure2Name=");
		sb.append(measure2Name);
		sb.append(", measure3Name=");
		sb.append(measure3Name);
		sb.append(", measure4Name=");
		sb.append(measure4Name);
		sb.append(", dataName=");
		sb.append(dataName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Report toEntityModel() {
		ReportImpl reportImpl = new ReportImpl();

		reportImpl.setReportId(reportId);

		if (reportKey == null) {
			reportImpl.setReportKey(StringPool.BLANK);
		}
		else {
			reportImpl.setReportKey(reportKey);
		}

		if (reportName == null) {
			reportImpl.setReportName(StringPool.BLANK);
		}
		else {
			reportImpl.setReportName(reportName);
		}

		if (reportTitle == null) {
			reportImpl.setReportTitle(StringPool.BLANK);
		}
		else {
			reportImpl.setReportTitle(reportTitle);
		}

		reportImpl.setDataEntry(dataEntry);
		reportImpl.setHqDataEntry(hqDataEntry);
		reportImpl.setDimensionId(dimensionId);
		reportImpl.setHasMeasure1(hasMeasure1);
		reportImpl.setHasMeasure2(hasMeasure2);
		reportImpl.setHasMeasure3(hasMeasure3);
		reportImpl.setHasMeasure4(hasMeasure4);

		if (measure1Name == null) {
			reportImpl.setMeasure1Name(StringPool.BLANK);
		}
		else {
			reportImpl.setMeasure1Name(measure1Name);
		}

		if (measure2Name == null) {
			reportImpl.setMeasure2Name(StringPool.BLANK);
		}
		else {
			reportImpl.setMeasure2Name(measure2Name);
		}

		if (measure3Name == null) {
			reportImpl.setMeasure3Name(StringPool.BLANK);
		}
		else {
			reportImpl.setMeasure3Name(measure3Name);
		}

		if (measure4Name == null) {
			reportImpl.setMeasure4Name(StringPool.BLANK);
		}
		else {
			reportImpl.setMeasure4Name(measure4Name);
		}

		if (dataName == null) {
			reportImpl.setDataName(StringPool.BLANK);
		}
		else {
			reportImpl.setDataName(dataName);
		}

		reportImpl.resetOriginalValues();

		return reportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportId = objectInput.readLong();
		reportKey = objectInput.readUTF();
		reportName = objectInput.readUTF();
		reportTitle = objectInput.readUTF();
		dataEntry = objectInput.readBoolean();
		hqDataEntry = objectInput.readBoolean();
		dimensionId = objectInput.readLong();
		hasMeasure1 = objectInput.readBoolean();
		hasMeasure2 = objectInput.readBoolean();
		hasMeasure3 = objectInput.readBoolean();
		hasMeasure4 = objectInput.readBoolean();
		measure1Name = objectInput.readUTF();
		measure2Name = objectInput.readUTF();
		measure3Name = objectInput.readUTF();
		measure4Name = objectInput.readUTF();
		dataName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportId);

		if (reportKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportKey);
		}

		if (reportName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportName);
		}

		if (reportTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportTitle);
		}

		objectOutput.writeBoolean(dataEntry);
		objectOutput.writeBoolean(hqDataEntry);
		objectOutput.writeLong(dimensionId);
		objectOutput.writeBoolean(hasMeasure1);
		objectOutput.writeBoolean(hasMeasure2);
		objectOutput.writeBoolean(hasMeasure3);
		objectOutput.writeBoolean(hasMeasure4);

		if (measure1Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measure1Name);
		}

		if (measure2Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measure2Name);
		}

		if (measure3Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measure3Name);
		}

		if (measure4Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measure4Name);
		}

		if (dataName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataName);
		}
	}

	public long reportId;
	public String reportKey;
	public String reportName;
	public String reportTitle;
	public boolean dataEntry;
	public boolean hqDataEntry;
	public long dimensionId;
	public boolean hasMeasure1;
	public boolean hasMeasure2;
	public boolean hasMeasure3;
	public boolean hasMeasure4;
	public String measure1Name;
	public String measure2Name;
	public String measure3Name;
	public String measure4Name;
	public String dataName;
}
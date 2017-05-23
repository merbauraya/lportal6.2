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
		StringBundler sb = new StringBundler(13);

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
	public String dataName;
}
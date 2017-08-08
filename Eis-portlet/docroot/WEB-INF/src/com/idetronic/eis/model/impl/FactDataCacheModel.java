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

import com.idetronic.eis.model.FactData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactData in entity cache.
 *
 * @author Mazlan Mat
 * @see FactData
 * @generated
 */
public class FactDataCacheModel implements CacheModel<FactData>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{factId=");
		sb.append(factId);
		sb.append(", reportId=");
		sb.append(reportId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", dimensionId=");
		sb.append(dimensionId);
		sb.append(", measure1=");
		sb.append(measure1);
		sb.append(", measure2=");
		sb.append(measure2);
		sb.append(", measure3=");
		sb.append(measure3);
		sb.append(", measure4=");
		sb.append(measure4);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FactData toEntityModel() {
		FactDataImpl factDataImpl = new FactDataImpl();

		factDataImpl.setFactId(factId);
		factDataImpl.setReportId(reportId);
		factDataImpl.setLibraryId(libraryId);

		if (period == null) {
			factDataImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factDataImpl.setPeriod(period);
		}

		factDataImpl.setDimensionId(dimensionId);
		factDataImpl.setMeasure1(measure1);
		factDataImpl.setMeasure2(measure2);
		factDataImpl.setMeasure3(measure3);
		factDataImpl.setMeasure4(measure4);
		factDataImpl.setCompanyId(companyId);
		factDataImpl.setGroupId(groupId);
		factDataImpl.setUserId(userId);

		if (userName == null) {
			factDataImpl.setUserName(StringPool.BLANK);
		}
		else {
			factDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factDataImpl.setCreateDate(null);
		}
		else {
			factDataImpl.setCreateDate(new Date(createDate));
		}

		factDataImpl.resetOriginalValues();

		return factDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		reportId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		dimensionId = objectInput.readLong();
		measure1 = objectInput.readDouble();
		measure2 = objectInput.readDouble();
		measure3 = objectInput.readDouble();
		measure4 = objectInput.readDouble();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factId);
		objectOutput.writeLong(reportId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(dimensionId);
		objectOutput.writeDouble(measure1);
		objectOutput.writeDouble(measure2);
		objectOutput.writeDouble(measure3);
		objectOutput.writeDouble(measure4);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
	}

	public long factId;
	public long reportId;
	public long libraryId;
	public String period;
	public long dimensionId;
	public double measure1;
	public double measure2;
	public double measure3;
	public double measure4;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
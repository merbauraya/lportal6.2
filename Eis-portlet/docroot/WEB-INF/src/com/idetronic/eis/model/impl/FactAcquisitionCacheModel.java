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

import com.idetronic.eis.model.FactAcquisition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactAcquisition in entity cache.
 *
 * @author Mazlan Mat
 * @see FactAcquisition
 * @generated
 */
public class FactAcquisitionCacheModel implements CacheModel<FactAcquisition>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{factAcquisitionId=");
		sb.append(factAcquisitionId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", facultyId=");
		sb.append(facultyId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", approvedTitleTotal=");
		sb.append(approvedTitleTotal);
		sb.append(", approvedVolumeTotal=");
		sb.append(approvedVolumeTotal);
		sb.append(", approvedAmountTotal=");
		sb.append(approvedAmountTotal);
		sb.append(", orderTitleTotal=");
		sb.append(orderTitleTotal);
		sb.append(", orderVolumeTotal=");
		sb.append(orderVolumeTotal);
		sb.append(", orderAmountTotal=");
		sb.append(orderAmountTotal);
		sb.append(", volumeTotal=");
		sb.append(volumeTotal);
		sb.append(", titleTotal=");
		sb.append(titleTotal);
		sb.append(", amountTotal=");
		sb.append(amountTotal);
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
	public FactAcquisition toEntityModel() {
		FactAcquisitionImpl factAcquisitionImpl = new FactAcquisitionImpl();

		factAcquisitionImpl.setFactAcquisitionId(factAcquisitionId);
		factAcquisitionImpl.setLibraryId(libraryId);
		factAcquisitionImpl.setFacultyId(facultyId);

		if (period == null) {
			factAcquisitionImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factAcquisitionImpl.setPeriod(period);
		}

		factAcquisitionImpl.setItemId(itemId);
		factAcquisitionImpl.setApprovedTitleTotal(approvedTitleTotal);
		factAcquisitionImpl.setApprovedVolumeTotal(approvedVolumeTotal);
		factAcquisitionImpl.setApprovedAmountTotal(approvedAmountTotal);
		factAcquisitionImpl.setOrderTitleTotal(orderTitleTotal);
		factAcquisitionImpl.setOrderVolumeTotal(orderVolumeTotal);
		factAcquisitionImpl.setOrderAmountTotal(orderAmountTotal);
		factAcquisitionImpl.setVolumeTotal(volumeTotal);
		factAcquisitionImpl.setTitleTotal(titleTotal);
		factAcquisitionImpl.setAmountTotal(amountTotal);
		factAcquisitionImpl.setCompanyId(companyId);
		factAcquisitionImpl.setGroupId(groupId);
		factAcquisitionImpl.setUserId(userId);

		if (userName == null) {
			factAcquisitionImpl.setUserName(StringPool.BLANK);
		}
		else {
			factAcquisitionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factAcquisitionImpl.setCreateDate(null);
		}
		else {
			factAcquisitionImpl.setCreateDate(new Date(createDate));
		}

		factAcquisitionImpl.resetOriginalValues();

		return factAcquisitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factAcquisitionId = objectInput.readLong();
		libraryId = objectInput.readLong();
		facultyId = objectInput.readLong();
		period = objectInput.readUTF();
		itemId = objectInput.readLong();
		approvedTitleTotal = objectInput.readLong();
		approvedVolumeTotal = objectInput.readLong();
		approvedAmountTotal = objectInput.readDouble();
		orderTitleTotal = objectInput.readLong();
		orderVolumeTotal = objectInput.readLong();
		orderAmountTotal = objectInput.readDouble();
		volumeTotal = objectInput.readLong();
		titleTotal = objectInput.readLong();
		amountTotal = objectInput.readDouble();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factAcquisitionId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(facultyId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(itemId);
		objectOutput.writeLong(approvedTitleTotal);
		objectOutput.writeLong(approvedVolumeTotal);
		objectOutput.writeDouble(approvedAmountTotal);
		objectOutput.writeLong(orderTitleTotal);
		objectOutput.writeLong(orderVolumeTotal);
		objectOutput.writeDouble(orderAmountTotal);
		objectOutput.writeLong(volumeTotal);
		objectOutput.writeLong(titleTotal);
		objectOutput.writeDouble(amountTotal);
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

	public long factAcquisitionId;
	public long libraryId;
	public long facultyId;
	public String period;
	public long itemId;
	public long approvedTitleTotal;
	public long approvedVolumeTotal;
	public double approvedAmountTotal;
	public long orderTitleTotal;
	public long orderVolumeTotal;
	public double orderAmountTotal;
	public long volumeTotal;
	public long titleTotal;
	public double amountTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
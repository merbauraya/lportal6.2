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

import com.idetronic.eis.model.FactIrItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactIrItem in entity cache.
 *
 * @author Mazlan Mat
 * @see FactIrItem
 * @generated
 */
public class FactIrItemCacheModel implements CacheModel<FactIrItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{factIrItemId=");
		sb.append(factIrItemId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", facultyId=");
		sb.append(facultyId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", itemMediumId=");
		sb.append(itemMediumId);
		sb.append(", titleTotal=");
		sb.append(titleTotal);
		sb.append(", volumeTotal=");
		sb.append(volumeTotal);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append(", createdByUserName=");
		sb.append(createdByUserName);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FactIrItem toEntityModel() {
		FactIrItemImpl factIrItemImpl = new FactIrItemImpl();

		factIrItemImpl.setFactIrItemId(factIrItemId);
		factIrItemImpl.setLibraryId(libraryId);
		factIrItemImpl.setFacultyId(facultyId);

		if (period == null) {
			factIrItemImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factIrItemImpl.setPeriod(period);
		}

		factIrItemImpl.setItemTypeId(itemTypeId);
		factIrItemImpl.setItemMediumId(itemMediumId);
		factIrItemImpl.setTitleTotal(titleTotal);
		factIrItemImpl.setVolumeTotal(volumeTotal);
		factIrItemImpl.setCreatedByUserId(createdByUserId);

		if (createdByUserName == null) {
			factIrItemImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			factIrItemImpl.setCreatedByUserName(createdByUserName);
		}

		if (createdDate == Long.MIN_VALUE) {
			factIrItemImpl.setCreatedDate(null);
		}
		else {
			factIrItemImpl.setCreatedDate(new Date(createdDate));
		}

		factIrItemImpl.resetOriginalValues();

		return factIrItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factIrItemId = objectInput.readLong();
		libraryId = objectInput.readLong();
		facultyId = objectInput.readLong();
		period = objectInput.readUTF();
		itemTypeId = objectInput.readLong();
		itemMediumId = objectInput.readLong();
		titleTotal = objectInput.readInt();
		volumeTotal = objectInput.readInt();
		createdByUserId = objectInput.readLong();
		createdByUserName = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factIrItemId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(facultyId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(itemTypeId);
		objectOutput.writeLong(itemMediumId);
		objectOutput.writeInt(titleTotal);
		objectOutput.writeInt(volumeTotal);
		objectOutput.writeLong(createdByUserId);

		if (createdByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdByUserName);
		}

		objectOutput.writeLong(createdDate);
	}

	public long factIrItemId;
	public long libraryId;
	public long facultyId;
	public String period;
	public long itemTypeId;
	public long itemMediumId;
	public int titleTotal;
	public int volumeTotal;
	public long createdByUserId;
	public String createdByUserName;
	public long createdDate;
}
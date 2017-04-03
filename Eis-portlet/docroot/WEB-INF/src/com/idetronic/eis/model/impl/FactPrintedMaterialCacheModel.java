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

import com.idetronic.eis.model.FactPrintedMaterial;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactPrintedMaterial in entity cache.
 *
 * @author Mazlan Mat
 * @see FactPrintedMaterial
 * @generated
 */
public class FactPrintedMaterialCacheModel implements CacheModel<FactPrintedMaterial>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{factPrintedMaterialId=");
		sb.append(factPrintedMaterialId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", libraryCode=");
		sb.append(libraryCode);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", stateCode=");
		sb.append(stateCode);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", monthVal=");
		sb.append(monthVal);
		sb.append(", yearVal=");
		sb.append(yearVal);
		sb.append(", titleTotal=");
		sb.append(titleTotal);
		sb.append(", volumeTotal=");
		sb.append(volumeTotal);
		sb.append(", dateCreated=");
		sb.append(dateCreated);
		sb.append(", createdByUserName=");
		sb.append(createdByUserName);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FactPrintedMaterial toEntityModel() {
		FactPrintedMaterialImpl factPrintedMaterialImpl = new FactPrintedMaterialImpl();

		factPrintedMaterialImpl.setFactPrintedMaterialId(factPrintedMaterialId);
		factPrintedMaterialImpl.setLibraryId(libraryId);

		if (libraryCode == null) {
			factPrintedMaterialImpl.setLibraryCode(StringPool.BLANK);
		}
		else {
			factPrintedMaterialImpl.setLibraryCode(libraryCode);
		}

		factPrintedMaterialImpl.setStateId(stateId);

		if (stateCode == null) {
			factPrintedMaterialImpl.setStateCode(StringPool.BLANK);
		}
		else {
			factPrintedMaterialImpl.setStateCode(stateCode);
		}

		factPrintedMaterialImpl.setItemTypeId(itemTypeId);

		if (period == null) {
			factPrintedMaterialImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factPrintedMaterialImpl.setPeriod(period);
		}

		factPrintedMaterialImpl.setLibraryTypeId(libraryTypeId);
		factPrintedMaterialImpl.setMonthVal(monthVal);
		factPrintedMaterialImpl.setYearVal(yearVal);
		factPrintedMaterialImpl.setTitleTotal(titleTotal);
		factPrintedMaterialImpl.setVolumeTotal(volumeTotal);

		if (dateCreated == Long.MIN_VALUE) {
			factPrintedMaterialImpl.setDateCreated(null);
		}
		else {
			factPrintedMaterialImpl.setDateCreated(new Date(dateCreated));
		}

		if (createdByUserName == null) {
			factPrintedMaterialImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			factPrintedMaterialImpl.setCreatedByUserName(createdByUserName);
		}

		factPrintedMaterialImpl.setCreatedByUserId(createdByUserId);

		factPrintedMaterialImpl.resetOriginalValues();

		return factPrintedMaterialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factPrintedMaterialId = objectInput.readLong();
		libraryId = objectInput.readLong();
		libraryCode = objectInput.readUTF();
		stateId = objectInput.readLong();
		stateCode = objectInput.readUTF();
		itemTypeId = objectInput.readLong();
		period = objectInput.readUTF();
		libraryTypeId = objectInput.readLong();
		monthVal = objectInput.readInt();
		yearVal = objectInput.readInt();
		titleTotal = objectInput.readInt();
		volumeTotal = objectInput.readInt();
		dateCreated = objectInput.readLong();
		createdByUserName = objectInput.readUTF();
		createdByUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factPrintedMaterialId);
		objectOutput.writeLong(libraryId);

		if (libraryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryCode);
		}

		objectOutput.writeLong(stateId);

		if (stateCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateCode);
		}

		objectOutput.writeLong(itemTypeId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(libraryTypeId);
		objectOutput.writeInt(monthVal);
		objectOutput.writeInt(yearVal);
		objectOutput.writeInt(titleTotal);
		objectOutput.writeInt(volumeTotal);
		objectOutput.writeLong(dateCreated);

		if (createdByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdByUserName);
		}

		objectOutput.writeLong(createdByUserId);
	}

	public long factPrintedMaterialId;
	public long libraryId;
	public String libraryCode;
	public long stateId;
	public String stateCode;
	public long itemTypeId;
	public String period;
	public long libraryTypeId;
	public int monthVal;
	public int yearVal;
	public int titleTotal;
	public int volumeTotal;
	public long dateCreated;
	public String createdByUserName;
	public long createdByUserId;
}
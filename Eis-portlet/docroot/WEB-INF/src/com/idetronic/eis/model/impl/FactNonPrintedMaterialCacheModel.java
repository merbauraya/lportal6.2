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

import com.idetronic.eis.model.FactNonPrintedMaterial;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactNonPrintedMaterial in entity cache.
 *
 * @author Mazlan Mat
 * @see FactNonPrintedMaterial
 * @generated
 */
public class FactNonPrintedMaterialCacheModel implements CacheModel<FactNonPrintedMaterial>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{factNonPrintedMaterialId=");
		sb.append(factNonPrintedMaterialId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", libraryCode=");
		sb.append(libraryCode);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", stateCode=");
		sb.append(stateCode);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", period=");
		sb.append(period);
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
	public FactNonPrintedMaterial toEntityModel() {
		FactNonPrintedMaterialImpl factNonPrintedMaterialImpl = new FactNonPrintedMaterialImpl();

		factNonPrintedMaterialImpl.setFactNonPrintedMaterialId(factNonPrintedMaterialId);
		factNonPrintedMaterialImpl.setLibraryId(libraryId);

		if (libraryCode == null) {
			factNonPrintedMaterialImpl.setLibraryCode(StringPool.BLANK);
		}
		else {
			factNonPrintedMaterialImpl.setLibraryCode(libraryCode);
		}

		factNonPrintedMaterialImpl.setStateId(stateId);

		if (stateCode == null) {
			factNonPrintedMaterialImpl.setStateCode(StringPool.BLANK);
		}
		else {
			factNonPrintedMaterialImpl.setStateCode(stateCode);
		}

		factNonPrintedMaterialImpl.setLibraryTypeId(libraryTypeId);
		factNonPrintedMaterialImpl.setItemTypeId(itemTypeId);

		if (period == null) {
			factNonPrintedMaterialImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factNonPrintedMaterialImpl.setPeriod(period);
		}

		factNonPrintedMaterialImpl.setMonthVal(monthVal);
		factNonPrintedMaterialImpl.setYearVal(yearVal);
		factNonPrintedMaterialImpl.setTitleTotal(titleTotal);
		factNonPrintedMaterialImpl.setVolumeTotal(volumeTotal);

		if (dateCreated == Long.MIN_VALUE) {
			factNonPrintedMaterialImpl.setDateCreated(null);
		}
		else {
			factNonPrintedMaterialImpl.setDateCreated(new Date(dateCreated));
		}

		if (createdByUserName == null) {
			factNonPrintedMaterialImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			factNonPrintedMaterialImpl.setCreatedByUserName(createdByUserName);
		}

		factNonPrintedMaterialImpl.setCreatedByUserId(createdByUserId);

		factNonPrintedMaterialImpl.resetOriginalValues();

		return factNonPrintedMaterialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factNonPrintedMaterialId = objectInput.readLong();
		libraryId = objectInput.readLong();
		libraryCode = objectInput.readUTF();
		stateId = objectInput.readLong();
		stateCode = objectInput.readUTF();
		libraryTypeId = objectInput.readLong();
		itemTypeId = objectInput.readLong();
		period = objectInput.readUTF();
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
		objectOutput.writeLong(factNonPrintedMaterialId);
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

		objectOutput.writeLong(libraryTypeId);
		objectOutput.writeLong(itemTypeId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

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

	public long factNonPrintedMaterialId;
	public long libraryId;
	public String libraryCode;
	public long stateId;
	public String stateCode;
	public long libraryTypeId;
	public long itemTypeId;
	public String period;
	public int monthVal;
	public int yearVal;
	public int titleTotal;
	public int volumeTotal;
	public long dateCreated;
	public String createdByUserName;
	public long createdByUserId;
}
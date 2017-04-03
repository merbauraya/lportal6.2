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

import com.idetronic.eis.model.FactSeating;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactSeating in entity cache.
 *
 * @author Mazlan Mat
 * @see FactSeating
 * @generated
 */
public class FactSeatingCacheModel implements CacheModel<FactSeating>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{factSeatingId=");
		sb.append(factSeatingId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", seatingCategoryId=");
		sb.append(seatingCategoryId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", capacity=");
		sb.append(capacity);
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
	public FactSeating toEntityModel() {
		FactSeatingImpl factSeatingImpl = new FactSeatingImpl();

		factSeatingImpl.setFactSeatingId(factSeatingId);
		factSeatingImpl.setLibraryId(libraryId);
		factSeatingImpl.setDepartmentId(departmentId);
		factSeatingImpl.setSeatingCategoryId(seatingCategoryId);
		factSeatingImpl.setStateId(stateId);
		factSeatingImpl.setLibraryTypeId(libraryTypeId);

		if (period == null) {
			factSeatingImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factSeatingImpl.setPeriod(period);
		}

		factSeatingImpl.setCapacity(capacity);
		factSeatingImpl.setCompanyId(companyId);
		factSeatingImpl.setGroupId(groupId);
		factSeatingImpl.setUserId(userId);

		if (userName == null) {
			factSeatingImpl.setUserName(StringPool.BLANK);
		}
		else {
			factSeatingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factSeatingImpl.setCreateDate(null);
		}
		else {
			factSeatingImpl.setCreateDate(new Date(createDate));
		}

		factSeatingImpl.resetOriginalValues();

		return factSeatingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factSeatingId = objectInput.readLong();
		libraryId = objectInput.readLong();
		departmentId = objectInput.readLong();
		seatingCategoryId = objectInput.readLong();
		stateId = objectInput.readLong();
		libraryTypeId = objectInput.readLong();
		period = objectInput.readUTF();
		capacity = objectInput.readInt();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factSeatingId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(departmentId);
		objectOutput.writeLong(seatingCategoryId);
		objectOutput.writeLong(stateId);
		objectOutput.writeLong(libraryTypeId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeInt(capacity);
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

	public long factSeatingId;
	public long libraryId;
	public long departmentId;
	public long seatingCategoryId;
	public long stateId;
	public long libraryTypeId;
	public String period;
	public int capacity;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
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

import com.idetronic.eis.model.SeatingCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SeatingCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see SeatingCategory
 * @generated
 */
public class SeatingCategoryCacheModel implements CacheModel<SeatingCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{seatingCategoryId=");
		sb.append(seatingCategoryId);
		sb.append(", seatingCategoryName=");
		sb.append(seatingCategoryName);
		sb.append(", seatingDepartmentId=");
		sb.append(seatingDepartmentId);
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
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SeatingCategory toEntityModel() {
		SeatingCategoryImpl seatingCategoryImpl = new SeatingCategoryImpl();

		seatingCategoryImpl.setSeatingCategoryId(seatingCategoryId);

		if (seatingCategoryName == null) {
			seatingCategoryImpl.setSeatingCategoryName(StringPool.BLANK);
		}
		else {
			seatingCategoryImpl.setSeatingCategoryName(seatingCategoryName);
		}

		seatingCategoryImpl.setSeatingDepartmentId(seatingDepartmentId);
		seatingCategoryImpl.setCompanyId(companyId);
		seatingCategoryImpl.setGroupId(groupId);
		seatingCategoryImpl.setUserId(userId);

		if (userName == null) {
			seatingCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			seatingCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			seatingCategoryImpl.setCreateDate(null);
		}
		else {
			seatingCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			seatingCategoryImpl.setModifiedDate(null);
		}
		else {
			seatingCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		seatingCategoryImpl.resetOriginalValues();

		return seatingCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		seatingCategoryId = objectInput.readLong();
		seatingCategoryName = objectInput.readUTF();
		seatingDepartmentId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(seatingCategoryId);

		if (seatingCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(seatingCategoryName);
		}

		objectOutput.writeLong(seatingDepartmentId);
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
		objectOutput.writeLong(modifiedDate);
	}

	public long seatingCategoryId;
	public String seatingCategoryName;
	public long seatingDepartmentId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
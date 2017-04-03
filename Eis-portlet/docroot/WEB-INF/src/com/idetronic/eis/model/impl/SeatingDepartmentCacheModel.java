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

import com.idetronic.eis.model.SeatingDepartment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SeatingDepartment in entity cache.
 *
 * @author Mazlan Mat
 * @see SeatingDepartment
 * @generated
 */
public class SeatingDepartmentCacheModel implements CacheModel<SeatingDepartment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{departmentId=");
		sb.append(departmentId);
		sb.append(", departmentName=");
		sb.append(departmentName);
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
	public SeatingDepartment toEntityModel() {
		SeatingDepartmentImpl seatingDepartmentImpl = new SeatingDepartmentImpl();

		seatingDepartmentImpl.setDepartmentId(departmentId);

		if (departmentName == null) {
			seatingDepartmentImpl.setDepartmentName(StringPool.BLANK);
		}
		else {
			seatingDepartmentImpl.setDepartmentName(departmentName);
		}

		seatingDepartmentImpl.setCompanyId(companyId);
		seatingDepartmentImpl.setGroupId(groupId);
		seatingDepartmentImpl.setUserId(userId);

		if (userName == null) {
			seatingDepartmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			seatingDepartmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			seatingDepartmentImpl.setCreateDate(null);
		}
		else {
			seatingDepartmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			seatingDepartmentImpl.setModifiedDate(null);
		}
		else {
			seatingDepartmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		seatingDepartmentImpl.resetOriginalValues();

		return seatingDepartmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		departmentId = objectInput.readLong();
		departmentName = objectInput.readUTF();
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
		objectOutput.writeLong(departmentId);

		if (departmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentName);
		}

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

	public long departmentId;
	public String departmentName;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
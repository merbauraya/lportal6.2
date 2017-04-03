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

import com.idetronic.eis.model.LibrarySeatingDepartment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LibrarySeatingDepartment in entity cache.
 *
 * @author Mazlan Mat
 * @see LibrarySeatingDepartment
 * @generated
 */
public class LibrarySeatingDepartmentCacheModel implements CacheModel<LibrarySeatingDepartment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{libraryDepartmentId=");
		sb.append(libraryDepartmentId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", departmentId=");
		sb.append(departmentId);
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
	public LibrarySeatingDepartment toEntityModel() {
		LibrarySeatingDepartmentImpl librarySeatingDepartmentImpl = new LibrarySeatingDepartmentImpl();

		librarySeatingDepartmentImpl.setLibraryDepartmentId(libraryDepartmentId);
		librarySeatingDepartmentImpl.setLibraryId(libraryId);
		librarySeatingDepartmentImpl.setDepartmentId(departmentId);
		librarySeatingDepartmentImpl.setCompanyId(companyId);
		librarySeatingDepartmentImpl.setGroupId(groupId);
		librarySeatingDepartmentImpl.setUserId(userId);

		if (userName == null) {
			librarySeatingDepartmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			librarySeatingDepartmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			librarySeatingDepartmentImpl.setCreateDate(null);
		}
		else {
			librarySeatingDepartmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			librarySeatingDepartmentImpl.setModifiedDate(null);
		}
		else {
			librarySeatingDepartmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		librarySeatingDepartmentImpl.resetOriginalValues();

		return librarySeatingDepartmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		libraryDepartmentId = objectInput.readLong();
		libraryId = objectInput.readLong();
		departmentId = objectInput.readLong();
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
		objectOutput.writeLong(libraryDepartmentId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(departmentId);
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

	public long libraryDepartmentId;
	public long libraryId;
	public long departmentId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
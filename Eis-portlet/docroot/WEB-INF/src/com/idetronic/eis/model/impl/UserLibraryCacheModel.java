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

import com.idetronic.eis.model.UserLibrary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserLibrary in entity cache.
 *
 * @author Mazlan Mat
 * @see UserLibrary
 * @generated
 */
public class UserLibraryCacheModel implements CacheModel<UserLibrary>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{userLibraryId=");
		sb.append(userLibraryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
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
	public UserLibrary toEntityModel() {
		UserLibraryImpl userLibraryImpl = new UserLibraryImpl();

		userLibraryImpl.setUserLibraryId(userLibraryId);
		userLibraryImpl.setUserId(userId);
		userLibraryImpl.setLibraryId(libraryId);
		userLibraryImpl.setCompanyId(companyId);
		userLibraryImpl.setGroupId(groupId);
		userLibraryImpl.setCreatedByUserId(createdByUserId);

		if (userName == null) {
			userLibraryImpl.setUserName(StringPool.BLANK);
		}
		else {
			userLibraryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userLibraryImpl.setCreateDate(null);
		}
		else {
			userLibraryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userLibraryImpl.setModifiedDate(null);
		}
		else {
			userLibraryImpl.setModifiedDate(new Date(modifiedDate));
		}

		userLibraryImpl.resetOriginalValues();

		return userLibraryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userLibraryId = objectInput.readLong();
		userId = objectInput.readLong();
		libraryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createdByUserId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userLibraryId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdByUserId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long userLibraryId;
	public long userId;
	public long libraryId;
	public long companyId;
	public long groupId;
	public long createdByUserId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
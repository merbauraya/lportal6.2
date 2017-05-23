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

import com.idetronic.eis.model.UserData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserData in entity cache.
 *
 * @author Mazlan Mat
 * @see UserData
 * @generated
 */
public class UserDataCacheModel implements CacheModel<UserData>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userDataId=");
		sb.append(userDataId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", dataId=");
		sb.append(dataId);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserData toEntityModel() {
		UserDataImpl userDataImpl = new UserDataImpl();

		userDataImpl.setUserDataId(userDataId);
		userDataImpl.setUserId(userId);
		userDataImpl.setLibraryId(libraryId);
		userDataImpl.setDataId(dataId);
		userDataImpl.setCreatedByUserId(createdByUserId);

		if (userName == null) {
			userDataImpl.setUserName(StringPool.BLANK);
		}
		else {
			userDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userDataImpl.setCreateDate(null);
		}
		else {
			userDataImpl.setCreateDate(new Date(createDate));
		}

		userDataImpl.resetOriginalValues();

		return userDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userDataId = objectInput.readLong();
		userId = objectInput.readLong();
		libraryId = objectInput.readLong();
		dataId = objectInput.readLong();
		createdByUserId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userDataId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(dataId);
		objectOutput.writeLong(createdByUserId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
	}

	public long userDataId;
	public long userId;
	public long libraryId;
	public long dataId;
	public long createdByUserId;
	public String userName;
	public long createDate;
}
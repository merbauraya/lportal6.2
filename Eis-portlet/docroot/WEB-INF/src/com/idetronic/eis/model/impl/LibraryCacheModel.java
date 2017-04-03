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

import com.idetronic.eis.model.Library;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Library in entity cache.
 *
 * @author Mazlan Mat
 * @see Library
 * @generated
 */
public class LibraryCacheModel implements CacheModel<Library>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{libraryId=");
		sb.append(libraryId);
		sb.append(", libraryCode=");
		sb.append(libraryCode);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", libraryName=");
		sb.append(libraryName);
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
	public Library toEntityModel() {
		LibraryImpl libraryImpl = new LibraryImpl();

		libraryImpl.setLibraryId(libraryId);

		if (libraryCode == null) {
			libraryImpl.setLibraryCode(StringPool.BLANK);
		}
		else {
			libraryImpl.setLibraryCode(libraryCode);
		}

		libraryImpl.setStateId(stateId);
		libraryImpl.setLibraryTypeId(libraryTypeId);

		if (stateName == null) {
			libraryImpl.setStateName(StringPool.BLANK);
		}
		else {
			libraryImpl.setStateName(stateName);
		}

		if (libraryName == null) {
			libraryImpl.setLibraryName(StringPool.BLANK);
		}
		else {
			libraryImpl.setLibraryName(libraryName);
		}

		libraryImpl.setCompanyId(companyId);
		libraryImpl.setGroupId(groupId);
		libraryImpl.setUserId(userId);

		if (userName == null) {
			libraryImpl.setUserName(StringPool.BLANK);
		}
		else {
			libraryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			libraryImpl.setCreateDate(null);
		}
		else {
			libraryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			libraryImpl.setModifiedDate(null);
		}
		else {
			libraryImpl.setModifiedDate(new Date(modifiedDate));
		}

		libraryImpl.resetOriginalValues();

		return libraryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		libraryId = objectInput.readLong();
		libraryCode = objectInput.readUTF();
		stateId = objectInput.readLong();
		libraryTypeId = objectInput.readLong();
		stateName = objectInput.readUTF();
		libraryName = objectInput.readUTF();
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
		objectOutput.writeLong(libraryId);

		if (libraryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryCode);
		}

		objectOutput.writeLong(stateId);
		objectOutput.writeLong(libraryTypeId);

		if (stateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateName);
		}

		if (libraryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryName);
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

	public long libraryId;
	public String libraryCode;
	public long stateId;
	public long libraryTypeId;
	public String stateName;
	public String libraryName;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
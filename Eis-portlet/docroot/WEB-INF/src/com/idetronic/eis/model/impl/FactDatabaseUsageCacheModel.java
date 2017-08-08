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

import com.idetronic.eis.model.FactDatabaseUsage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactDatabaseUsage in entity cache.
 *
 * @author Mazlan Mat
 * @see FactDatabaseUsage
 * @generated
 */
public class FactDatabaseUsageCacheModel implements CacheModel<FactDatabaseUsage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{factId=");
		sb.append(factId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", downloadTotal=");
		sb.append(downloadTotal);
		sb.append(", sessionTotal=");
		sb.append(sessionTotal);
		sb.append(", searchTotal=");
		sb.append(searchTotal);
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
	public FactDatabaseUsage toEntityModel() {
		FactDatabaseUsageImpl factDatabaseUsageImpl = new FactDatabaseUsageImpl();

		factDatabaseUsageImpl.setFactId(factId);
		factDatabaseUsageImpl.setLibraryId(libraryId);

		if (period == null) {
			factDatabaseUsageImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factDatabaseUsageImpl.setPeriod(period);
		}

		factDatabaseUsageImpl.setItemId(itemId);
		factDatabaseUsageImpl.setDownloadTotal(downloadTotal);
		factDatabaseUsageImpl.setSessionTotal(sessionTotal);
		factDatabaseUsageImpl.setSearchTotal(searchTotal);
		factDatabaseUsageImpl.setCompanyId(companyId);
		factDatabaseUsageImpl.setGroupId(groupId);
		factDatabaseUsageImpl.setUserId(userId);

		if (userName == null) {
			factDatabaseUsageImpl.setUserName(StringPool.BLANK);
		}
		else {
			factDatabaseUsageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factDatabaseUsageImpl.setCreateDate(null);
		}
		else {
			factDatabaseUsageImpl.setCreateDate(new Date(createDate));
		}

		factDatabaseUsageImpl.resetOriginalValues();

		return factDatabaseUsageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		itemId = objectInput.readLong();
		downloadTotal = objectInput.readLong();
		sessionTotal = objectInput.readLong();
		searchTotal = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(itemId);
		objectOutput.writeLong(downloadTotal);
		objectOutput.writeLong(sessionTotal);
		objectOutput.writeLong(searchTotal);
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

	public long factId;
	public long libraryId;
	public String period;
	public long itemId;
	public long downloadTotal;
	public long sessionTotal;
	public long searchTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
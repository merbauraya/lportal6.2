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

import com.idetronic.eis.model.FactItManagement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactItManagement in entity cache.
 *
 * @author Mazlan Mat
 * @see FactItManagement
 * @generated
 */
public class FactItManagementCacheModel implements CacheModel<FactItManagement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{factId=");
		sb.append(factId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", itemTotal=");
		sb.append(itemTotal);
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
	public FactItManagement toEntityModel() {
		FactItManagementImpl factItManagementImpl = new FactItManagementImpl();

		factItManagementImpl.setFactId(factId);
		factItManagementImpl.setLibraryId(libraryId);

		if (period == null) {
			factItManagementImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factItManagementImpl.setPeriod(period);
		}

		factItManagementImpl.setItemId(itemId);
		factItManagementImpl.setItemTotal(itemTotal);
		factItManagementImpl.setCompanyId(companyId);
		factItManagementImpl.setGroupId(groupId);
		factItManagementImpl.setUserId(userId);

		if (userName == null) {
			factItManagementImpl.setUserName(StringPool.BLANK);
		}
		else {
			factItManagementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factItManagementImpl.setCreateDate(null);
		}
		else {
			factItManagementImpl.setCreateDate(new Date(createDate));
		}

		factItManagementImpl.resetOriginalValues();

		return factItManagementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		itemId = objectInput.readLong();
		itemTotal = objectInput.readLong();
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
		objectOutput.writeLong(itemTotal);
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
	public long itemTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
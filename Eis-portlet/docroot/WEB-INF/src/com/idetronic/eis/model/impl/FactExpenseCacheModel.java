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

import com.idetronic.eis.model.FactExpense;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactExpense in entity cache.
 *
 * @author Mazlan Mat
 * @see FactExpense
 * @generated
 */
public class FactExpenseCacheModel implements CacheModel<FactExpense>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{factExpenseId=");
		sb.append(factExpenseId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", entryType=");
		sb.append(entryType);
		sb.append(", masterFileId=");
		sb.append(masterFileId);
		sb.append(", amount=");
		sb.append(amount);
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
	public FactExpense toEntityModel() {
		FactExpenseImpl factExpenseImpl = new FactExpenseImpl();

		factExpenseImpl.setFactExpenseId(factExpenseId);
		factExpenseImpl.setLibraryId(libraryId);

		if (period == null) {
			factExpenseImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factExpenseImpl.setPeriod(period);
		}

		factExpenseImpl.setEntryType(entryType);
		factExpenseImpl.setMasterFileId(masterFileId);
		factExpenseImpl.setAmount(amount);
		factExpenseImpl.setCompanyId(companyId);
		factExpenseImpl.setGroupId(groupId);
		factExpenseImpl.setUserId(userId);

		if (userName == null) {
			factExpenseImpl.setUserName(StringPool.BLANK);
		}
		else {
			factExpenseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factExpenseImpl.setCreateDate(null);
		}
		else {
			factExpenseImpl.setCreateDate(new Date(createDate));
		}

		factExpenseImpl.resetOriginalValues();

		return factExpenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factExpenseId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		entryType = objectInput.readInt();
		masterFileId = objectInput.readLong();
		amount = objectInput.readDouble();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factExpenseId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeInt(entryType);
		objectOutput.writeLong(masterFileId);
		objectOutput.writeDouble(amount);
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

	public long factExpenseId;
	public long libraryId;
	public String period;
	public int entryType;
	public long masterFileId;
	public double amount;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
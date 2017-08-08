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

import com.idetronic.eis.model.FactIncome;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactIncome in entity cache.
 *
 * @author Mazlan Mat
 * @see FactIncome
 * @generated
 */
public class FactIncomeCacheModel implements CacheModel<FactIncome>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{factIncomeId=");
		sb.append(factIncomeId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", total=");
		sb.append(total);
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
	public FactIncome toEntityModel() {
		FactIncomeImpl factIncomeImpl = new FactIncomeImpl();

		factIncomeImpl.setFactIncomeId(factIncomeId);
		factIncomeImpl.setLibraryId(libraryId);

		if (period == null) {
			factIncomeImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factIncomeImpl.setPeriod(period);
		}

		factIncomeImpl.setItemId(itemId);
		factIncomeImpl.setTotal(total);
		factIncomeImpl.setCompanyId(companyId);
		factIncomeImpl.setGroupId(groupId);
		factIncomeImpl.setUserId(userId);

		if (userName == null) {
			factIncomeImpl.setUserName(StringPool.BLANK);
		}
		else {
			factIncomeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factIncomeImpl.setCreateDate(null);
		}
		else {
			factIncomeImpl.setCreateDate(new Date(createDate));
		}

		factIncomeImpl.resetOriginalValues();

		return factIncomeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factIncomeId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		itemId = objectInput.readLong();
		total = objectInput.readDouble();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factIncomeId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(itemId);
		objectOutput.writeDouble(total);
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

	public long factIncomeId;
	public long libraryId;
	public String period;
	public long itemId;
	public double total;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
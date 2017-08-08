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

import com.idetronic.eis.model.FactInterLibLoan;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactInterLibLoan in entity cache.
 *
 * @author Mazlan Mat
 * @see FactInterLibLoan
 * @generated
 */
public class FactInterLibLoanCacheModel implements CacheModel<FactInterLibLoan>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{factId=");
		sb.append(factId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", ptjId=");
		sb.append(ptjId);
		sb.append(", applyTotal=");
		sb.append(applyTotal);
		sb.append(", approvedTotal=");
		sb.append(approvedTotal);
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
	public FactInterLibLoan toEntityModel() {
		FactInterLibLoanImpl factInterLibLoanImpl = new FactInterLibLoanImpl();

		factInterLibLoanImpl.setFactId(factId);
		factInterLibLoanImpl.setLibraryId(libraryId);

		if (period == null) {
			factInterLibLoanImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factInterLibLoanImpl.setPeriod(period);
		}

		factInterLibLoanImpl.setPtjId(ptjId);
		factInterLibLoanImpl.setApplyTotal(applyTotal);
		factInterLibLoanImpl.setApprovedTotal(approvedTotal);
		factInterLibLoanImpl.setCompanyId(companyId);
		factInterLibLoanImpl.setGroupId(groupId);
		factInterLibLoanImpl.setUserId(userId);

		if (userName == null) {
			factInterLibLoanImpl.setUserName(StringPool.BLANK);
		}
		else {
			factInterLibLoanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factInterLibLoanImpl.setCreateDate(null);
		}
		else {
			factInterLibLoanImpl.setCreateDate(new Date(createDate));
		}

		factInterLibLoanImpl.resetOriginalValues();

		return factInterLibLoanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		ptjId = objectInput.readLong();
		applyTotal = objectInput.readLong();
		approvedTotal = objectInput.readLong();
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

		objectOutput.writeLong(ptjId);
		objectOutput.writeLong(applyTotal);
		objectOutput.writeLong(approvedTotal);
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
	public long ptjId;
	public long applyTotal;
	public long approvedTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
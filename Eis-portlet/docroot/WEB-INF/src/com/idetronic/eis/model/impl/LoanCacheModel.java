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

import com.idetronic.eis.model.Loan;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Loan in entity cache.
 *
 * @author Mazlan Mat
 * @see Loan
 * @generated
 */
public class LoanCacheModel implements CacheModel<Loan>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{loanEntryId=");
		sb.append(loanEntryId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", period=");
		sb.append(period);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", periodYear=");
		sb.append(periodYear);
		sb.append(", periodMonth=");
		sb.append(periodMonth);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", memberCategoryId=");
		sb.append(memberCategoryId);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Loan toEntityModel() {
		LoanImpl loanImpl = new LoanImpl();

		loanImpl.setLoanEntryId(loanEntryId);
		loanImpl.setLibraryId(libraryId);
		loanImpl.setUserId(userId);

		if (userName == null) {
			loanImpl.setUserName(StringPool.BLANK);
		}
		else {
			loanImpl.setUserName(userName);
		}

		if (period == null) {
			loanImpl.setPeriod(StringPool.BLANK);
		}
		else {
			loanImpl.setPeriod(period);
		}

		loanImpl.setStateId(stateId);
		loanImpl.setLibraryTypeId(libraryTypeId);
		loanImpl.setPeriodYear(periodYear);
		loanImpl.setPeriodMonth(periodMonth);

		if (createDate == Long.MIN_VALUE) {
			loanImpl.setCreateDate(null);
		}
		else {
			loanImpl.setCreateDate(new Date(createDate));
		}

		loanImpl.setMemberCategoryId(memberCategoryId);
		loanImpl.setValue(value);

		loanImpl.resetOriginalValues();

		return loanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loanEntryId = objectInput.readLong();
		libraryId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		period = objectInput.readUTF();
		stateId = objectInput.readLong();
		libraryTypeId = objectInput.readLong();
		periodYear = objectInput.readInt();
		periodMonth = objectInput.readInt();
		createDate = objectInput.readLong();
		memberCategoryId = objectInput.readLong();
		value = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(loanEntryId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(stateId);
		objectOutput.writeLong(libraryTypeId);
		objectOutput.writeInt(periodYear);
		objectOutput.writeInt(periodMonth);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(memberCategoryId);
		objectOutput.writeInt(value);
	}

	public long loanEntryId;
	public long libraryId;
	public long userId;
	public String userName;
	public String period;
	public long stateId;
	public long libraryTypeId;
	public int periodYear;
	public int periodMonth;
	public long createDate;
	public long memberCategoryId;
	public int value;
}
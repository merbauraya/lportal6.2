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

import com.idetronic.eis.model.FactCustomerComplaint;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactCustomerComplaint in entity cache.
 *
 * @author Mazlan Mat
 * @see FactCustomerComplaint
 * @generated
 */
public class FactCustomerComplaintCacheModel implements CacheModel<FactCustomerComplaint>,
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
		sb.append(", complaintTotal=");
		sb.append(complaintTotal);
		sb.append(", unsettledTotal=");
		sb.append(unsettledTotal);
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
	public FactCustomerComplaint toEntityModel() {
		FactCustomerComplaintImpl factCustomerComplaintImpl = new FactCustomerComplaintImpl();

		factCustomerComplaintImpl.setFactId(factId);
		factCustomerComplaintImpl.setLibraryId(libraryId);

		if (period == null) {
			factCustomerComplaintImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factCustomerComplaintImpl.setPeriod(period);
		}

		factCustomerComplaintImpl.setComplaintTotal(complaintTotal);
		factCustomerComplaintImpl.setUnsettledTotal(unsettledTotal);
		factCustomerComplaintImpl.setCompanyId(companyId);
		factCustomerComplaintImpl.setGroupId(groupId);
		factCustomerComplaintImpl.setUserId(userId);

		if (userName == null) {
			factCustomerComplaintImpl.setUserName(StringPool.BLANK);
		}
		else {
			factCustomerComplaintImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factCustomerComplaintImpl.setCreateDate(null);
		}
		else {
			factCustomerComplaintImpl.setCreateDate(new Date(createDate));
		}

		factCustomerComplaintImpl.resetOriginalValues();

		return factCustomerComplaintImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		complaintTotal = objectInput.readLong();
		unsettledTotal = objectInput.readLong();
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

		objectOutput.writeLong(complaintTotal);
		objectOutput.writeLong(unsettledTotal);
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
	public long complaintTotal;
	public long unsettledTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
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

import com.idetronic.eis.model.FactMembership;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactMembership in entity cache.
 *
 * @author Mazlan Mat
 * @see FactMembership
 * @generated
 */
public class FactMembershipCacheModel implements CacheModel<FactMembership>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{factMembershipId=");
		sb.append(factMembershipId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", membershipCategoryId=");
		sb.append(membershipCategoryId);
		sb.append(", activeCount=");
		sb.append(activeCount);
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
	public FactMembership toEntityModel() {
		FactMembershipImpl factMembershipImpl = new FactMembershipImpl();

		factMembershipImpl.setFactMembershipId(factMembershipId);
		factMembershipImpl.setLibraryId(libraryId);

		if (period == null) {
			factMembershipImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factMembershipImpl.setPeriod(period);
		}

		factMembershipImpl.setStateId(stateId);
		factMembershipImpl.setLibraryTypeId(libraryTypeId);
		factMembershipImpl.setMembershipCategoryId(membershipCategoryId);
		factMembershipImpl.setActiveCount(activeCount);
		factMembershipImpl.setCompanyId(companyId);
		factMembershipImpl.setGroupId(groupId);
		factMembershipImpl.setUserId(userId);

		if (userName == null) {
			factMembershipImpl.setUserName(StringPool.BLANK);
		}
		else {
			factMembershipImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factMembershipImpl.setCreateDate(null);
		}
		else {
			factMembershipImpl.setCreateDate(new Date(createDate));
		}

		factMembershipImpl.resetOriginalValues();

		return factMembershipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factMembershipId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		stateId = objectInput.readLong();
		libraryTypeId = objectInput.readLong();
		membershipCategoryId = objectInput.readLong();
		activeCount = objectInput.readInt();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factMembershipId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(stateId);
		objectOutput.writeLong(libraryTypeId);
		objectOutput.writeLong(membershipCategoryId);
		objectOutput.writeInt(activeCount);
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

	public long factMembershipId;
	public long libraryId;
	public String period;
	public long stateId;
	public long libraryTypeId;
	public long membershipCategoryId;
	public int activeCount;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
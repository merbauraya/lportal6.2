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

import com.idetronic.eis.model.FactLibraryVisitor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactLibraryVisitor in entity cache.
 *
 * @author Mazlan Mat
 * @see FactLibraryVisitor
 * @generated
 */
public class FactLibraryVisitorCacheModel implements CacheModel<FactLibraryVisitor>,
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
		sb.append(", visitorCategoryId=");
		sb.append(visitorCategoryId);
		sb.append(", sessionTotal=");
		sb.append(sessionTotal);
		sb.append(", visitorTotal=");
		sb.append(visitorTotal);
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
	public FactLibraryVisitor toEntityModel() {
		FactLibraryVisitorImpl factLibraryVisitorImpl = new FactLibraryVisitorImpl();

		factLibraryVisitorImpl.setFactId(factId);
		factLibraryVisitorImpl.setLibraryId(libraryId);

		if (period == null) {
			factLibraryVisitorImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factLibraryVisitorImpl.setPeriod(period);
		}

		factLibraryVisitorImpl.setVisitorCategoryId(visitorCategoryId);
		factLibraryVisitorImpl.setSessionTotal(sessionTotal);
		factLibraryVisitorImpl.setVisitorTotal(visitorTotal);
		factLibraryVisitorImpl.setCompanyId(companyId);
		factLibraryVisitorImpl.setGroupId(groupId);
		factLibraryVisitorImpl.setUserId(userId);

		if (userName == null) {
			factLibraryVisitorImpl.setUserName(StringPool.BLANK);
		}
		else {
			factLibraryVisitorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factLibraryVisitorImpl.setCreateDate(null);
		}
		else {
			factLibraryVisitorImpl.setCreateDate(new Date(createDate));
		}

		factLibraryVisitorImpl.resetOriginalValues();

		return factLibraryVisitorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		visitorCategoryId = objectInput.readLong();
		sessionTotal = objectInput.readLong();
		visitorTotal = objectInput.readLong();
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

		objectOutput.writeLong(visitorCategoryId);
		objectOutput.writeLong(sessionTotal);
		objectOutput.writeLong(visitorTotal);
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
	public long visitorCategoryId;
	public long sessionTotal;
	public long visitorTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
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

import com.idetronic.eis.model.FactVisitor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactVisitor in entity cache.
 *
 * @author Mazlan Mat
 * @see FactVisitor
 * @generated
 */
public class FactVisitorCacheModel implements CacheModel<FactVisitor>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{factVisitorId=");
		sb.append(factVisitorId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", visitorCategoryId=");
		sb.append(visitorCategoryId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", value=");
		sb.append(value);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append(", createdByUserName=");
		sb.append(createdByUserName);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FactVisitor toEntityModel() {
		FactVisitorImpl factVisitorImpl = new FactVisitorImpl();

		factVisitorImpl.setFactVisitorId(factVisitorId);
		factVisitorImpl.setLibraryId(libraryId);

		if (period == null) {
			factVisitorImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factVisitorImpl.setPeriod(period);
		}

		factVisitorImpl.setVisitorCategoryId(visitorCategoryId);
		factVisitorImpl.setStateId(stateId);
		factVisitorImpl.setLibraryTypeId(libraryTypeId);
		factVisitorImpl.setValue(value);
		factVisitorImpl.setCreatedByUserId(createdByUserId);

		if (createdByUserName == null) {
			factVisitorImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			factVisitorImpl.setCreatedByUserName(createdByUserName);
		}

		if (createdDate == Long.MIN_VALUE) {
			factVisitorImpl.setCreatedDate(null);
		}
		else {
			factVisitorImpl.setCreatedDate(new Date(createdDate));
		}

		factVisitorImpl.resetOriginalValues();

		return factVisitorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factVisitorId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		visitorCategoryId = objectInput.readLong();
		stateId = objectInput.readLong();
		libraryTypeId = objectInput.readLong();
		value = objectInput.readInt();
		createdByUserId = objectInput.readLong();
		createdByUserName = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factVisitorId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(visitorCategoryId);
		objectOutput.writeLong(stateId);
		objectOutput.writeLong(libraryTypeId);
		objectOutput.writeInt(value);
		objectOutput.writeLong(createdByUserId);

		if (createdByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdByUserName);
		}

		objectOutput.writeLong(createdDate);
	}

	public long factVisitorId;
	public long libraryId;
	public String period;
	public long visitorCategoryId;
	public long stateId;
	public long libraryTypeId;
	public int value;
	public long createdByUserId;
	public String createdByUserName;
	public long createdDate;
}
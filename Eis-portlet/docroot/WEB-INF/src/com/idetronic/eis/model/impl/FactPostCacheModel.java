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

import com.idetronic.eis.model.FactPost;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactPost in entity cache.
 *
 * @author Mazlan Mat
 * @see FactPost
 * @generated
 */
public class FactPostCacheModel implements CacheModel<FactPost>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{factPostId=");
		sb.append(factPostId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", postGradeId=");
		sb.append(postGradeId);
		sb.append(", stateId=");
		sb.append(stateId);
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
	public FactPost toEntityModel() {
		FactPostImpl factPostImpl = new FactPostImpl();

		factPostImpl.setFactPostId(factPostId);
		factPostImpl.setLibraryId(libraryId);

		if (period == null) {
			factPostImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factPostImpl.setPeriod(period);
		}

		factPostImpl.setPostGradeId(postGradeId);
		factPostImpl.setStateId(stateId);
		factPostImpl.setValue(value);
		factPostImpl.setCreatedByUserId(createdByUserId);

		if (createdByUserName == null) {
			factPostImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			factPostImpl.setCreatedByUserName(createdByUserName);
		}

		if (createdDate == Long.MIN_VALUE) {
			factPostImpl.setCreatedDate(null);
		}
		else {
			factPostImpl.setCreatedDate(new Date(createdDate));
		}

		factPostImpl.resetOriginalValues();

		return factPostImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factPostId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		postGradeId = objectInput.readLong();
		stateId = objectInput.readLong();
		value = objectInput.readInt();
		createdByUserId = objectInput.readLong();
		createdByUserName = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factPostId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(postGradeId);
		objectOutput.writeLong(stateId);
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

	public long factPostId;
	public long libraryId;
	public String period;
	public long postGradeId;
	public long stateId;
	public int value;
	public long createdByUserId;
	public String createdByUserName;
	public long createdDate;
}
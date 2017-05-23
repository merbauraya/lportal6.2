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

import com.idetronic.eis.model.UserReport;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserReport in entity cache.
 *
 * @author Mazlan Mat
 * @see UserReport
 * @generated
 */
public class UserReportCacheModel implements CacheModel<UserReport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userReportId=");
		sb.append(userReportId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", reportId=");
		sb.append(reportId);
		sb.append(", createdByUserId=");
		sb.append(createdByUserId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserReport toEntityModel() {
		UserReportImpl userReportImpl = new UserReportImpl();

		userReportImpl.setUserReportId(userReportId);
		userReportImpl.setUserId(userId);
		userReportImpl.setLibraryId(libraryId);
		userReportImpl.setReportId(reportId);
		userReportImpl.setCreatedByUserId(createdByUserId);

		if (userName == null) {
			userReportImpl.setUserName(StringPool.BLANK);
		}
		else {
			userReportImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userReportImpl.setCreateDate(null);
		}
		else {
			userReportImpl.setCreateDate(new Date(createDate));
		}

		userReportImpl.resetOriginalValues();

		return userReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userReportId = objectInput.readLong();
		userId = objectInput.readLong();
		libraryId = objectInput.readLong();
		reportId = objectInput.readLong();
		createdByUserId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userReportId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(reportId);
		objectOutput.writeLong(createdByUserId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
	}

	public long userReportId;
	public long userId;
	public long libraryId;
	public long reportId;
	public long createdByUserId;
	public String userName;
	public long createDate;
}
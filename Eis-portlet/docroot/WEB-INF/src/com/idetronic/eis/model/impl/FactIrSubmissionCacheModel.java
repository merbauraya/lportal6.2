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

import com.idetronic.eis.model.FactIrSubmission;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactIrSubmission in entity cache.
 *
 * @author Mazlan Mat
 * @see FactIrSubmission
 * @generated
 */
public class FactIrSubmissionCacheModel implements CacheModel<FactIrSubmission>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{submissionId=");
		sb.append(submissionId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", facultyId=");
		sb.append(facultyId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemMediumId=");
		sb.append(itemMediumId);
		sb.append(", titleTotal=");
		sb.append(titleTotal);
		sb.append(", volumeTotal=");
		sb.append(volumeTotal);
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
	public FactIrSubmission toEntityModel() {
		FactIrSubmissionImpl factIrSubmissionImpl = new FactIrSubmissionImpl();

		factIrSubmissionImpl.setSubmissionId(submissionId);
		factIrSubmissionImpl.setLibraryId(libraryId);
		factIrSubmissionImpl.setFacultyId(facultyId);

		if (period == null) {
			factIrSubmissionImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factIrSubmissionImpl.setPeriod(period);
		}

		factIrSubmissionImpl.setItemMediumId(itemMediumId);
		factIrSubmissionImpl.setTitleTotal(titleTotal);
		factIrSubmissionImpl.setVolumeTotal(volumeTotal);
		factIrSubmissionImpl.setCreatedByUserId(createdByUserId);

		if (createdByUserName == null) {
			factIrSubmissionImpl.setCreatedByUserName(StringPool.BLANK);
		}
		else {
			factIrSubmissionImpl.setCreatedByUserName(createdByUserName);
		}

		if (createdDate == Long.MIN_VALUE) {
			factIrSubmissionImpl.setCreatedDate(null);
		}
		else {
			factIrSubmissionImpl.setCreatedDate(new Date(createdDate));
		}

		factIrSubmissionImpl.resetOriginalValues();

		return factIrSubmissionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		submissionId = objectInput.readLong();
		libraryId = objectInput.readLong();
		facultyId = objectInput.readLong();
		period = objectInput.readUTF();
		itemMediumId = objectInput.readLong();
		titleTotal = objectInput.readInt();
		volumeTotal = objectInput.readInt();
		createdByUserId = objectInput.readLong();
		createdByUserName = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(submissionId);
		objectOutput.writeLong(libraryId);
		objectOutput.writeLong(facultyId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(itemMediumId);
		objectOutput.writeInt(titleTotal);
		objectOutput.writeInt(volumeTotal);
		objectOutput.writeLong(createdByUserId);

		if (createdByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdByUserName);
		}

		objectOutput.writeLong(createdDate);
	}

	public long submissionId;
	public long libraryId;
	public long facultyId;
	public String period;
	public long itemMediumId;
	public int titleTotal;
	public int volumeTotal;
	public long createdByUserId;
	public String createdByUserName;
	public long createdDate;
}
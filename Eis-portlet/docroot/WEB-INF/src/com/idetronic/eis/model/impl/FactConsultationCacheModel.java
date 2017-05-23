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

import com.idetronic.eis.model.FactConsultation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactConsultation in entity cache.
 *
 * @author Mazlan Mat
 * @see FactConsultation
 * @generated
 */
public class FactConsultationCacheModel implements CacheModel<FactConsultation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{factConsultationId=");
		sb.append(factConsultationId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", consultationGroupId=");
		sb.append(consultationGroupId);
		sb.append(", consultationCategoryId=");
		sb.append(consultationCategoryId);
		sb.append(", value=");
		sb.append(value);
		sb.append(", totalSession=");
		sb.append(totalSession);
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
	public FactConsultation toEntityModel() {
		FactConsultationImpl factConsultationImpl = new FactConsultationImpl();

		factConsultationImpl.setFactConsultationId(factConsultationId);
		factConsultationImpl.setLibraryId(libraryId);

		if (period == null) {
			factConsultationImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factConsultationImpl.setPeriod(period);
		}

		factConsultationImpl.setConsultationGroupId(consultationGroupId);
		factConsultationImpl.setConsultationCategoryId(consultationCategoryId);
		factConsultationImpl.setValue(value);
		factConsultationImpl.setTotalSession(totalSession);
		factConsultationImpl.setCompanyId(companyId);
		factConsultationImpl.setGroupId(groupId);
		factConsultationImpl.setUserId(userId);

		if (userName == null) {
			factConsultationImpl.setUserName(StringPool.BLANK);
		}
		else {
			factConsultationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factConsultationImpl.setCreateDate(null);
		}
		else {
			factConsultationImpl.setCreateDate(new Date(createDate));
		}

		factConsultationImpl.resetOriginalValues();

		return factConsultationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factConsultationId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		consultationGroupId = objectInput.readLong();
		consultationCategoryId = objectInput.readLong();
		value = objectInput.readLong();
		totalSession = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(factConsultationId);
		objectOutput.writeLong(libraryId);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(consultationGroupId);
		objectOutput.writeLong(consultationCategoryId);
		objectOutput.writeLong(value);
		objectOutput.writeLong(totalSession);
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

	public long factConsultationId;
	public long libraryId;
	public String period;
	public long consultationGroupId;
	public long consultationCategoryId;
	public long value;
	public long totalSession;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
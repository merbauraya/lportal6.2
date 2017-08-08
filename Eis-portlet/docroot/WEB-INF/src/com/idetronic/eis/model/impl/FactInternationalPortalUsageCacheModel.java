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

import com.idetronic.eis.model.FactInternationalPortalUsage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactInternationalPortalUsage in entity cache.
 *
 * @author Mazlan Mat
 * @see FactInternationalPortalUsage
 * @generated
 */
public class FactInternationalPortalUsageCacheModel implements CacheModel<FactInternationalPortalUsage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{factId=");
		sb.append(factId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", pagesTotal=");
		sb.append(pagesTotal);
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
	public FactInternationalPortalUsage toEntityModel() {
		FactInternationalPortalUsageImpl factInternationalPortalUsageImpl = new FactInternationalPortalUsageImpl();

		factInternationalPortalUsageImpl.setFactId(factId);

		if (period == null) {
			factInternationalPortalUsageImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factInternationalPortalUsageImpl.setPeriod(period);
		}

		factInternationalPortalUsageImpl.setCountryId(countryId);
		factInternationalPortalUsageImpl.setPagesTotal(pagesTotal);
		factInternationalPortalUsageImpl.setCompanyId(companyId);
		factInternationalPortalUsageImpl.setGroupId(groupId);
		factInternationalPortalUsageImpl.setUserId(userId);

		if (userName == null) {
			factInternationalPortalUsageImpl.setUserName(StringPool.BLANK);
		}
		else {
			factInternationalPortalUsageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factInternationalPortalUsageImpl.setCreateDate(null);
		}
		else {
			factInternationalPortalUsageImpl.setCreateDate(new Date(createDate));
		}

		factInternationalPortalUsageImpl.resetOriginalValues();

		return factInternationalPortalUsageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		period = objectInput.readUTF();
		countryId = objectInput.readLong();
		pagesTotal = objectInput.readLong();
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

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeLong(countryId);
		objectOutput.writeLong(pagesTotal);
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
	public String period;
	public long countryId;
	public long pagesTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
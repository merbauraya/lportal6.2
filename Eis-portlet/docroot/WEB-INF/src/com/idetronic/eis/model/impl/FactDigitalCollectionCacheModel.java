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

import com.idetronic.eis.model.FactDigitalCollection;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactDigitalCollection in entity cache.
 *
 * @author Mazlan Mat
 * @see FactDigitalCollection
 * @generated
 */
public class FactDigitalCollectionCacheModel implements CacheModel<FactDigitalCollection>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{factId=");
		sb.append(factId);
		sb.append(", libraryId=");
		sb.append(libraryId);
		sb.append(", period=");
		sb.append(period);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", titleTotal=");
		sb.append(titleTotal);
		sb.append(", volumeTotal=");
		sb.append(volumeTotal);
		sb.append(", imageTotal=");
		sb.append(imageTotal);
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
	public FactDigitalCollection toEntityModel() {
		FactDigitalCollectionImpl factDigitalCollectionImpl = new FactDigitalCollectionImpl();

		factDigitalCollectionImpl.setFactId(factId);
		factDigitalCollectionImpl.setLibraryId(libraryId);

		if (period == null) {
			factDigitalCollectionImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factDigitalCollectionImpl.setPeriod(period);
		}

		factDigitalCollectionImpl.setItemId(itemId);
		factDigitalCollectionImpl.setTitleTotal(titleTotal);
		factDigitalCollectionImpl.setVolumeTotal(volumeTotal);
		factDigitalCollectionImpl.setImageTotal(imageTotal);
		factDigitalCollectionImpl.setCompanyId(companyId);
		factDigitalCollectionImpl.setGroupId(groupId);
		factDigitalCollectionImpl.setUserId(userId);

		if (userName == null) {
			factDigitalCollectionImpl.setUserName(StringPool.BLANK);
		}
		else {
			factDigitalCollectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factDigitalCollectionImpl.setCreateDate(null);
		}
		else {
			factDigitalCollectionImpl.setCreateDate(new Date(createDate));
		}

		factDigitalCollectionImpl.resetOriginalValues();

		return factDigitalCollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		itemId = objectInput.readLong();
		titleTotal = objectInput.readLong();
		volumeTotal = objectInput.readLong();
		imageTotal = objectInput.readLong();
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

		objectOutput.writeLong(itemId);
		objectOutput.writeLong(titleTotal);
		objectOutput.writeLong(volumeTotal);
		objectOutput.writeLong(imageTotal);
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
	public long itemId;
	public long titleTotal;
	public long volumeTotal;
	public long imageTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
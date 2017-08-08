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

import com.idetronic.eis.model.FactArticleIndexing;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FactArticleIndexing in entity cache.
 *
 * @author Mazlan Mat
 * @see FactArticleIndexing
 * @generated
 */
public class FactArticleIndexingCacheModel implements CacheModel<FactArticleIndexing>,
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
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", indexTotal=");
		sb.append(indexTotal);
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
	public FactArticleIndexing toEntityModel() {
		FactArticleIndexingImpl factArticleIndexingImpl = new FactArticleIndexingImpl();

		factArticleIndexingImpl.setFactId(factId);
		factArticleIndexingImpl.setLibraryId(libraryId);

		if (period == null) {
			factArticleIndexingImpl.setPeriod(StringPool.BLANK);
		}
		else {
			factArticleIndexingImpl.setPeriod(period);
		}

		factArticleIndexingImpl.setItemId(itemId);
		factArticleIndexingImpl.setIndexTotal(indexTotal);
		factArticleIndexingImpl.setCompanyId(companyId);
		factArticleIndexingImpl.setGroupId(groupId);
		factArticleIndexingImpl.setUserId(userId);

		if (userName == null) {
			factArticleIndexingImpl.setUserName(StringPool.BLANK);
		}
		else {
			factArticleIndexingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			factArticleIndexingImpl.setCreateDate(null);
		}
		else {
			factArticleIndexingImpl.setCreateDate(new Date(createDate));
		}

		factArticleIndexingImpl.resetOriginalValues();

		return factArticleIndexingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		factId = objectInput.readLong();
		libraryId = objectInput.readLong();
		period = objectInput.readUTF();
		itemId = objectInput.readLong();
		indexTotal = objectInput.readLong();
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
		objectOutput.writeLong(indexTotal);
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
	public long indexTotal;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
}
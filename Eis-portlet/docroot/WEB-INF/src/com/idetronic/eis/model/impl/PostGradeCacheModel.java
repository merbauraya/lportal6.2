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

import com.idetronic.eis.model.PostGrade;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PostGrade in entity cache.
 *
 * @author Mazlan Mat
 * @see PostGrade
 * @generated
 */
public class PostGradeCacheModel implements CacheModel<PostGrade>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{postGradeId=");
		sb.append(postGradeId);
		sb.append(", postCategoryId=");
		sb.append(postCategoryId);
		sb.append(", postGradeCode=");
		sb.append(postGradeCode);
		sb.append(", postGradeScheme=");
		sb.append(postGradeScheme);
		sb.append(", postGradeName=");
		sb.append(postGradeName);
		sb.append(", postGradeDesc=");
		sb.append(postGradeDesc);
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
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostGrade toEntityModel() {
		PostGradeImpl postGradeImpl = new PostGradeImpl();

		postGradeImpl.setPostGradeId(postGradeId);
		postGradeImpl.setPostCategoryId(postCategoryId);

		if (postGradeCode == null) {
			postGradeImpl.setPostGradeCode(StringPool.BLANK);
		}
		else {
			postGradeImpl.setPostGradeCode(postGradeCode);
		}

		if (postGradeScheme == null) {
			postGradeImpl.setPostGradeScheme(StringPool.BLANK);
		}
		else {
			postGradeImpl.setPostGradeScheme(postGradeScheme);
		}

		if (postGradeName == null) {
			postGradeImpl.setPostGradeName(StringPool.BLANK);
		}
		else {
			postGradeImpl.setPostGradeName(postGradeName);
		}

		if (postGradeDesc == null) {
			postGradeImpl.setPostGradeDesc(StringPool.BLANK);
		}
		else {
			postGradeImpl.setPostGradeDesc(postGradeDesc);
		}

		postGradeImpl.setCompanyId(companyId);
		postGradeImpl.setGroupId(groupId);
		postGradeImpl.setUserId(userId);

		if (userName == null) {
			postGradeImpl.setUserName(StringPool.BLANK);
		}
		else {
			postGradeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postGradeImpl.setCreateDate(null);
		}
		else {
			postGradeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postGradeImpl.setModifiedDate(null);
		}
		else {
			postGradeImpl.setModifiedDate(new Date(modifiedDate));
		}

		postGradeImpl.resetOriginalValues();

		return postGradeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postGradeId = objectInput.readLong();
		postCategoryId = objectInput.readLong();
		postGradeCode = objectInput.readUTF();
		postGradeScheme = objectInput.readUTF();
		postGradeName = objectInput.readUTF();
		postGradeDesc = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(postGradeId);
		objectOutput.writeLong(postCategoryId);

		if (postGradeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postGradeCode);
		}

		if (postGradeScheme == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postGradeScheme);
		}

		if (postGradeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postGradeName);
		}

		if (postGradeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postGradeDesc);
		}

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
		objectOutput.writeLong(modifiedDate);
	}

	public long postGradeId;
	public long postCategoryId;
	public String postGradeCode;
	public String postGradeScheme;
	public String postGradeName;
	public String postGradeDesc;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
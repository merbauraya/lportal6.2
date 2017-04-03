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

import com.idetronic.eis.model.ProjectResourceType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectResourceType in entity cache.
 *
 * @author Mazlan Mat
 * @see ProjectResourceType
 * @generated
 */
public class ProjectResourceTypeCacheModel implements CacheModel<ProjectResourceType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{projectResourceTypeId=");
		sb.append(projectResourceTypeId);
		sb.append(", resourceTypeName=");
		sb.append(resourceTypeName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
	public ProjectResourceType toEntityModel() {
		ProjectResourceTypeImpl projectResourceTypeImpl = new ProjectResourceTypeImpl();

		projectResourceTypeImpl.setProjectResourceTypeId(projectResourceTypeId);

		if (resourceTypeName == null) {
			projectResourceTypeImpl.setResourceTypeName(StringPool.BLANK);
		}
		else {
			projectResourceTypeImpl.setResourceTypeName(resourceTypeName);
		}

		projectResourceTypeImpl.setGroupId(groupId);
		projectResourceTypeImpl.setCompanyId(companyId);
		projectResourceTypeImpl.setUserId(userId);

		if (userName == null) {
			projectResourceTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectResourceTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectResourceTypeImpl.setCreateDate(null);
		}
		else {
			projectResourceTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectResourceTypeImpl.setModifiedDate(null);
		}
		else {
			projectResourceTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectResourceTypeImpl.resetOriginalValues();

		return projectResourceTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectResourceTypeId = objectInput.readLong();
		resourceTypeName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectResourceTypeId);

		if (resourceTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resourceTypeName);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
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

	public long projectResourceTypeId;
	public String resourceTypeName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
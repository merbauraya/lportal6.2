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

import com.idetronic.eis.model.ProjectResource;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectResource in entity cache.
 *
 * @author Mazlan Mat
 * @see ProjectResource
 * @generated
 */
public class ProjectResourceCacheModel implements CacheModel<ProjectResource>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{projectResourceId=");
		sb.append(projectResourceId);
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
		sb.append(", resourceName=");
		sb.append(resourceName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectResource toEntityModel() {
		ProjectResourceImpl projectResourceImpl = new ProjectResourceImpl();

		projectResourceImpl.setProjectResourceId(projectResourceId);
		projectResourceImpl.setGroupId(groupId);
		projectResourceImpl.setCompanyId(companyId);
		projectResourceImpl.setUserId(userId);

		if (userName == null) {
			projectResourceImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectResourceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectResourceImpl.setCreateDate(null);
		}
		else {
			projectResourceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectResourceImpl.setModifiedDate(null);
		}
		else {
			projectResourceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (resourceName == null) {
			projectResourceImpl.setResourceName(StringPool.BLANK);
		}
		else {
			projectResourceImpl.setResourceName(resourceName);
		}

		projectResourceImpl.resetOriginalValues();

		return projectResourceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectResourceId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		resourceName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectResourceId);
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

		if (resourceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resourceName);
		}
	}

	public long projectResourceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String resourceName;
}
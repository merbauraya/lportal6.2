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

import com.idetronic.eis.model.Project;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Mazlan Mat
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{projectId=");
		sb.append(projectId);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", projectStatus=");
		sb.append(projectStatus);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startMonth=");
		sb.append(startMonth);
		sb.append(", startYear=");
		sb.append(startYear);
		sb.append(", startMonthName=");
		sb.append(startMonthName);
		sb.append(", endMonth=");
		sb.append(endMonth);
		sb.append(", endYear=");
		sb.append(endYear);
		sb.append(", progressStatus=");
		sb.append(progressStatus);
		sb.append(", endMonthName=");
		sb.append(endMonthName);
		sb.append(", completionDate=");
		sb.append(completionDate);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", resourceId=");
		sb.append(resourceId);
		sb.append(", resourceTypeId=");
		sb.append(resourceTypeId);
		sb.append(", resourceName=");
		sb.append(resourceName);
		sb.append(", resourceType=");
		sb.append(resourceType);
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
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setProjectId(projectId);

		if (projectName == null) {
			projectImpl.setProjectName(StringPool.BLANK);
		}
		else {
			projectImpl.setProjectName(projectName);
		}

		projectImpl.setProjectStatus(projectStatus);

		if (startDate == Long.MIN_VALUE) {
			projectImpl.setStartDate(null);
		}
		else {
			projectImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectImpl.setEndDate(null);
		}
		else {
			projectImpl.setEndDate(new Date(endDate));
		}

		projectImpl.setStartMonth(startMonth);
		projectImpl.setStartYear(startYear);

		if (startMonthName == null) {
			projectImpl.setStartMonthName(StringPool.BLANK);
		}
		else {
			projectImpl.setStartMonthName(startMonthName);
		}

		projectImpl.setEndMonth(endMonth);
		projectImpl.setEndYear(endYear);
		projectImpl.setProgressStatus(progressStatus);

		if (endMonthName == null) {
			projectImpl.setEndMonthName(StringPool.BLANK);
		}
		else {
			projectImpl.setEndMonthName(endMonthName);
		}

		if (completionDate == Long.MIN_VALUE) {
			projectImpl.setCompletionDate(null);
		}
		else {
			projectImpl.setCompletionDate(new Date(completionDate));
		}

		projectImpl.setProgress(progress);
		projectImpl.setResourceId(resourceId);
		projectImpl.setResourceTypeId(resourceTypeId);

		if (resourceName == null) {
			projectImpl.setResourceName(StringPool.BLANK);
		}
		else {
			projectImpl.setResourceName(resourceName);
		}

		if (resourceType == null) {
			projectImpl.setResourceType(StringPool.BLANK);
		}
		else {
			projectImpl.setResourceType(resourceType);
		}

		projectImpl.setGroupId(groupId);
		projectImpl.setCompanyId(companyId);
		projectImpl.setUserId(userId);

		if (userName == null) {
			projectImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectImpl.setCreateDate(null);
		}
		else {
			projectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectImpl.setModifiedDate(null);
		}
		else {
			projectImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectId = objectInput.readLong();
		projectName = objectInput.readUTF();
		projectStatus = objectInput.readInt();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		startMonth = objectInput.readInt();
		startYear = objectInput.readInt();
		startMonthName = objectInput.readUTF();
		endMonth = objectInput.readInt();
		endYear = objectInput.readInt();
		progressStatus = objectInput.readInt();
		endMonthName = objectInput.readUTF();
		completionDate = objectInput.readLong();
		progress = objectInput.readInt();
		resourceId = objectInput.readLong();
		resourceTypeId = objectInput.readLong();
		resourceName = objectInput.readUTF();
		resourceType = objectInput.readUTF();
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
		objectOutput.writeLong(projectId);

		if (projectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		objectOutput.writeInt(projectStatus);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeInt(startMonth);
		objectOutput.writeInt(startYear);

		if (startMonthName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startMonthName);
		}

		objectOutput.writeInt(endMonth);
		objectOutput.writeInt(endYear);
		objectOutput.writeInt(progressStatus);

		if (endMonthName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endMonthName);
		}

		objectOutput.writeLong(completionDate);
		objectOutput.writeInt(progress);
		objectOutput.writeLong(resourceId);
		objectOutput.writeLong(resourceTypeId);

		if (resourceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resourceName);
		}

		if (resourceType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resourceType);
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

	public long projectId;
	public String projectName;
	public int projectStatus;
	public long startDate;
	public long endDate;
	public int startMonth;
	public int startYear;
	public String startMonthName;
	public int endMonth;
	public int endYear;
	public int progressStatus;
	public String endMonthName;
	public long completionDate;
	public int progress;
	public long resourceId;
	public long resourceTypeId;
	public String resourceName;
	public String resourceType;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
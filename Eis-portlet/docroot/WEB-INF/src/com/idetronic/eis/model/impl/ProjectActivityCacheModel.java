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

import com.idetronic.eis.model.ProjectActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectActivity in entity cache.
 *
 * @author Mazlan Mat
 * @see ProjectActivity
 * @generated
 */
public class ProjectActivityCacheModel implements CacheModel<ProjectActivity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{projectActivityId=");
		sb.append(projectActivityId);
		sb.append(", strategyId=");
		sb.append(strategyId);
		sb.append(", activityName=");
		sb.append(activityName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
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
		sb.append(", endMonthName=");
		sb.append(endMonthName);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", status=");
		sb.append(status);
		sb.append(", progressStatus=");
		sb.append(progressStatus);
		sb.append(", completionDate=");
		sb.append(completionDate);
		sb.append(", resourceName=");
		sb.append(resourceName);
		sb.append(", resourceType=");
		sb.append(resourceType);
		sb.append(", remark=");
		sb.append(remark);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectActivity toEntityModel() {
		ProjectActivityImpl projectActivityImpl = new ProjectActivityImpl();

		projectActivityImpl.setProjectActivityId(projectActivityId);
		projectActivityImpl.setStrategyId(strategyId);

		if (activityName == null) {
			projectActivityImpl.setActivityName(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setActivityName(activityName);
		}

		projectActivityImpl.setGroupId(groupId);
		projectActivityImpl.setCompanyId(companyId);
		projectActivityImpl.setUserId(userId);

		if (userName == null) {
			projectActivityImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setUserName(userName);
		}

		if (startDate == Long.MIN_VALUE) {
			projectActivityImpl.setStartDate(null);
		}
		else {
			projectActivityImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectActivityImpl.setEndDate(null);
		}
		else {
			projectActivityImpl.setEndDate(new Date(endDate));
		}

		if (createDate == Long.MIN_VALUE) {
			projectActivityImpl.setCreateDate(null);
		}
		else {
			projectActivityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectActivityImpl.setModifiedDate(null);
		}
		else {
			projectActivityImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectActivityImpl.setStartMonth(startMonth);
		projectActivityImpl.setStartYear(startYear);

		if (startMonthName == null) {
			projectActivityImpl.setStartMonthName(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setStartMonthName(startMonthName);
		}

		projectActivityImpl.setEndMonth(endMonth);
		projectActivityImpl.setEndYear(endYear);

		if (endMonthName == null) {
			projectActivityImpl.setEndMonthName(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setEndMonthName(endMonthName);
		}

		projectActivityImpl.setProgress(progress);
		projectActivityImpl.setStatus(status);
		projectActivityImpl.setProgressStatus(progressStatus);

		if (completionDate == Long.MIN_VALUE) {
			projectActivityImpl.setCompletionDate(null);
		}
		else {
			projectActivityImpl.setCompletionDate(new Date(completionDate));
		}

		if (resourceName == null) {
			projectActivityImpl.setResourceName(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setResourceName(resourceName);
		}

		if (resourceType == null) {
			projectActivityImpl.setResourceType(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setResourceType(resourceType);
		}

		if (remark == null) {
			projectActivityImpl.setRemark(StringPool.BLANK);
		}
		else {
			projectActivityImpl.setRemark(remark);
		}

		projectActivityImpl.resetOriginalValues();

		return projectActivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectActivityId = objectInput.readLong();
		strategyId = objectInput.readLong();
		activityName = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		startMonth = objectInput.readInt();
		startYear = objectInput.readInt();
		startMonthName = objectInput.readUTF();
		endMonth = objectInput.readInt();
		endYear = objectInput.readInt();
		endMonthName = objectInput.readUTF();
		progress = objectInput.readInt();
		status = objectInput.readInt();
		progressStatus = objectInput.readInt();
		completionDate = objectInput.readLong();
		resourceName = objectInput.readUTF();
		resourceType = objectInput.readUTF();
		remark = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectActivityId);
		objectOutput.writeLong(strategyId);

		if (activityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityName);
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

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
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

		if (endMonthName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endMonthName);
		}

		objectOutput.writeInt(progress);
		objectOutput.writeInt(status);
		objectOutput.writeInt(progressStatus);
		objectOutput.writeLong(completionDate);

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

		if (remark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remark);
		}
	}

	public long projectActivityId;
	public long strategyId;
	public String activityName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long startDate;
	public long endDate;
	public long createDate;
	public long modifiedDate;
	public int startMonth;
	public int startYear;
	public String startMonthName;
	public int endMonth;
	public int endYear;
	public String endMonthName;
	public int progress;
	public int status;
	public int progressStatus;
	public long completionDate;
	public String resourceName;
	public String resourceType;
	public String remark;
}
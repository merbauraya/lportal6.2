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

import com.idetronic.eis.model.ProjectStrategy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectStrategy in entity cache.
 *
 * @author Mazlan Mat
 * @see ProjectStrategy
 * @generated
 */
public class ProjectStrategyCacheModel implements CacheModel<ProjectStrategy>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{projectStrategyId=");
		sb.append(projectStrategyId);
		sb.append(", strategyName=");
		sb.append(strategyName);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", userName=");
		sb.append(userName);
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
		sb.append(", endMonthName=");
		sb.append(endMonthName);
		sb.append(", completionDate=");
		sb.append(completionDate);
		sb.append(", projectStrategyStatus=");
		sb.append(projectStrategyStatus);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", progress=");
		sb.append(progress);
		sb.append(", status=");
		sb.append(status);
		sb.append(", progressStatus=");
		sb.append(progressStatus);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
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
	public ProjectStrategy toEntityModel() {
		ProjectStrategyImpl projectStrategyImpl = new ProjectStrategyImpl();

		projectStrategyImpl.setProjectStrategyId(projectStrategyId);

		if (strategyName == null) {
			projectStrategyImpl.setStrategyName(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setStrategyName(strategyName);
		}

		projectStrategyImpl.setProjectId(projectId);

		if (userName == null) {
			projectStrategyImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setUserName(userName);
		}

		if (startDate == Long.MIN_VALUE) {
			projectStrategyImpl.setStartDate(null);
		}
		else {
			projectStrategyImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectStrategyImpl.setEndDate(null);
		}
		else {
			projectStrategyImpl.setEndDate(new Date(endDate));
		}

		projectStrategyImpl.setStartMonth(startMonth);
		projectStrategyImpl.setStartYear(startYear);

		if (startMonthName == null) {
			projectStrategyImpl.setStartMonthName(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setStartMonthName(startMonthName);
		}

		projectStrategyImpl.setEndMonth(endMonth);
		projectStrategyImpl.setEndYear(endYear);

		if (endMonthName == null) {
			projectStrategyImpl.setEndMonthName(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setEndMonthName(endMonthName);
		}

		if (completionDate == Long.MIN_VALUE) {
			projectStrategyImpl.setCompletionDate(null);
		}
		else {
			projectStrategyImpl.setCompletionDate(new Date(completionDate));
		}

		projectStrategyImpl.setProjectStrategyStatus(projectStrategyStatus);
		projectStrategyImpl.setUserId(userId);
		projectStrategyImpl.setProgress(progress);
		projectStrategyImpl.setStatus(status);
		projectStrategyImpl.setProgressStatus(progressStatus);
		projectStrategyImpl.setGroupId(groupId);
		projectStrategyImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			projectStrategyImpl.setCreateDate(null);
		}
		else {
			projectStrategyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectStrategyImpl.setModifiedDate(null);
		}
		else {
			projectStrategyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (resourceName == null) {
			projectStrategyImpl.setResourceName(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setResourceName(resourceName);
		}

		if (resourceType == null) {
			projectStrategyImpl.setResourceType(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setResourceType(resourceType);
		}

		if (remark == null) {
			projectStrategyImpl.setRemark(StringPool.BLANK);
		}
		else {
			projectStrategyImpl.setRemark(remark);
		}

		projectStrategyImpl.resetOriginalValues();

		return projectStrategyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectStrategyId = objectInput.readLong();
		strategyName = objectInput.readUTF();
		projectId = objectInput.readLong();
		userName = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		startMonth = objectInput.readInt();
		startYear = objectInput.readInt();
		startMonthName = objectInput.readUTF();
		endMonth = objectInput.readInt();
		endYear = objectInput.readInt();
		endMonthName = objectInput.readUTF();
		completionDate = objectInput.readLong();
		projectStrategyStatus = objectInput.readInt();
		userId = objectInput.readLong();
		progress = objectInput.readInt();
		status = objectInput.readInt();
		progressStatus = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		resourceName = objectInput.readUTF();
		resourceType = objectInput.readUTF();
		remark = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectStrategyId);

		if (strategyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(strategyName);
		}

		objectOutput.writeLong(projectId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

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

		if (endMonthName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endMonthName);
		}

		objectOutput.writeLong(completionDate);
		objectOutput.writeInt(projectStrategyStatus);
		objectOutput.writeLong(userId);
		objectOutput.writeInt(progress);
		objectOutput.writeInt(status);
		objectOutput.writeInt(progressStatus);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

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

	public long projectStrategyId;
	public String strategyName;
	public long projectId;
	public String userName;
	public long startDate;
	public long endDate;
	public int startMonth;
	public int startYear;
	public String startMonthName;
	public int endMonth;
	public int endYear;
	public String endMonthName;
	public long completionDate;
	public int projectStrategyStatus;
	public long userId;
	public int progress;
	public int status;
	public int progressStatus;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String resourceName;
	public String resourceType;
	public String remark;
}
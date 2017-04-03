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

package com.idetronic.eis.model;

import com.idetronic.eis.service.ClpSerializer;
import com.idetronic.eis.service.ProjectActivityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class ProjectActivityClp extends BaseModelImpl<ProjectActivity>
	implements ProjectActivity {
	public ProjectActivityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectActivity.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectActivity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _projectActivityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectActivityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectActivityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectActivityId", getProjectActivityId());
		attributes.put("strategyId", getStrategyId());
		attributes.put("activityName", getActivityName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startYear", getStartYear());
		attributes.put("startMonthName", getStartMonthName());
		attributes.put("endMonth", getEndMonth());
		attributes.put("endYear", getEndYear());
		attributes.put("endMonthName", getEndMonthName());
		attributes.put("progress", getProgress());
		attributes.put("status", getStatus());
		attributes.put("progressStatus", getProgressStatus());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("resourceName", getResourceName());
		attributes.put("resourceType", getResourceType());
		attributes.put("remark", getRemark());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectActivityId = (Long)attributes.get("projectActivityId");

		if (projectActivityId != null) {
			setProjectActivityId(projectActivityId);
		}

		Long strategyId = (Long)attributes.get("strategyId");

		if (strategyId != null) {
			setStrategyId(strategyId);
		}

		String activityName = (String)attributes.get("activityName");

		if (activityName != null) {
			setActivityName(activityName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer startMonth = (Integer)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		Integer startYear = (Integer)attributes.get("startYear");

		if (startYear != null) {
			setStartYear(startYear);
		}

		String startMonthName = (String)attributes.get("startMonthName");

		if (startMonthName != null) {
			setStartMonthName(startMonthName);
		}

		Integer endMonth = (Integer)attributes.get("endMonth");

		if (endMonth != null) {
			setEndMonth(endMonth);
		}

		Integer endYear = (Integer)attributes.get("endYear");

		if (endYear != null) {
			setEndYear(endYear);
		}

		String endMonthName = (String)attributes.get("endMonthName");

		if (endMonthName != null) {
			setEndMonthName(endMonthName);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer progressStatus = (Integer)attributes.get("progressStatus");

		if (progressStatus != null) {
			setProgressStatus(progressStatus);
		}

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
		}

		String resourceName = (String)attributes.get("resourceName");

		if (resourceName != null) {
			setResourceName(resourceName);
		}

		String resourceType = (String)attributes.get("resourceType");

		if (resourceType != null) {
			setResourceType(resourceType);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
		}
	}

	@Override
	public long getProjectActivityId() {
		return _projectActivityId;
	}

	@Override
	public void setProjectActivityId(long projectActivityId) {
		_projectActivityId = projectActivityId;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectActivityId",
						long.class);

				method.invoke(_projectActivityRemoteModel, projectActivityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStrategyId() {
		return _strategyId;
	}

	@Override
	public void setStrategyId(long strategyId) {
		_strategyId = strategyId;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStrategyId", long.class);

				method.invoke(_projectActivityRemoteModel, strategyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityName() {
		return _activityName;
	}

	@Override
	public void setActivityName(String activityName) {
		_activityName = activityName;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityName", String.class);

				method.invoke(_projectActivityRemoteModel, activityName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_projectActivityRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_projectActivityRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_projectActivityRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_projectActivityRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_projectActivityRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_projectActivityRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_projectActivityRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_projectActivityRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartMonth() {
		return _startMonth;
	}

	@Override
	public void setStartMonth(int startMonth) {
		_startMonth = startMonth;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMonth", int.class);

				method.invoke(_projectActivityRemoteModel, startMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartYear() {
		return _startYear;
	}

	@Override
	public void setStartYear(int startYear) {
		_startYear = startYear;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStartYear", int.class);

				method.invoke(_projectActivityRemoteModel, startYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartMonthName() {
		return _startMonthName;
	}

	@Override
	public void setStartMonthName(String startMonthName) {
		_startMonthName = startMonthName;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMonthName",
						String.class);

				method.invoke(_projectActivityRemoteModel, startMonthName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndMonth() {
		return _endMonth;
	}

	@Override
	public void setEndMonth(int endMonth) {
		_endMonth = endMonth;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEndMonth", int.class);

				method.invoke(_projectActivityRemoteModel, endMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndYear() {
		return _endYear;
	}

	@Override
	public void setEndYear(int endYear) {
		_endYear = endYear;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEndYear", int.class);

				method.invoke(_projectActivityRemoteModel, endYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndMonthName() {
		return _endMonthName;
	}

	@Override
	public void setEndMonthName(String endMonthName) {
		_endMonthName = endMonthName;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEndMonthName", String.class);

				method.invoke(_projectActivityRemoteModel, endMonthName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(int progress) {
		_progress = progress;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setProgress", int.class);

				method.invoke(_projectActivityRemoteModel, progress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_projectActivityRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProgressStatus() {
		return _progressStatus;
	}

	@Override
	public void setProgressStatus(int progressStatus) {
		_progressStatus = progressStatus;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressStatus", int.class);

				method.invoke(_projectActivityRemoteModel, progressStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCompletionDate() {
		return _completionDate;
	}

	@Override
	public void setCompletionDate(Date completionDate) {
		_completionDate = completionDate;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setCompletionDate", Date.class);

				method.invoke(_projectActivityRemoteModel, completionDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResourceName() {
		return _resourceName;
	}

	@Override
	public void setResourceName(String resourceName) {
		_resourceName = resourceName;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setResourceName", String.class);

				method.invoke(_projectActivityRemoteModel, resourceName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResourceType() {
		return _resourceType;
	}

	@Override
	public void setResourceType(String resourceType) {
		_resourceType = resourceType;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setResourceType", String.class);

				method.invoke(_projectActivityRemoteModel, resourceType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemark() {
		return _remark;
	}

	@Override
	public void setRemark(String remark) {
		_remark = remark;

		if (_projectActivityRemoteModel != null) {
			try {
				Class<?> clazz = _projectActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setRemark", String.class);

				method.invoke(_projectActivityRemoteModel, remark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectActivityRemoteModel() {
		return _projectActivityRemoteModel;
	}

	public void setProjectActivityRemoteModel(
		BaseModel<?> projectActivityRemoteModel) {
		_projectActivityRemoteModel = projectActivityRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _projectActivityRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_projectActivityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectActivityLocalServiceUtil.addProjectActivity(this);
		}
		else {
			ProjectActivityLocalServiceUtil.updateProjectActivity(this);
		}
	}

	@Override
	public ProjectActivity toEscapedModel() {
		return (ProjectActivity)ProxyUtil.newProxyInstance(ProjectActivity.class.getClassLoader(),
			new Class[] { ProjectActivity.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectActivityClp clone = new ProjectActivityClp();

		clone.setProjectActivityId(getProjectActivityId());
		clone.setStrategyId(getStrategyId());
		clone.setActivityName(getActivityName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStartMonth(getStartMonth());
		clone.setStartYear(getStartYear());
		clone.setStartMonthName(getStartMonthName());
		clone.setEndMonth(getEndMonth());
		clone.setEndYear(getEndYear());
		clone.setEndMonthName(getEndMonthName());
		clone.setProgress(getProgress());
		clone.setStatus(getStatus());
		clone.setProgressStatus(getProgressStatus());
		clone.setCompletionDate(getCompletionDate());
		clone.setResourceName(getResourceName());
		clone.setResourceType(getResourceType());
		clone.setRemark(getRemark());

		return clone;
	}

	@Override
	public int compareTo(ProjectActivity projectActivity) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(),
				projectActivity.getStartDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectActivityClp)) {
			return false;
		}

		ProjectActivityClp projectActivity = (ProjectActivityClp)obj;

		long primaryKey = projectActivity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{projectActivityId=");
		sb.append(getProjectActivityId());
		sb.append(", strategyId=");
		sb.append(getStrategyId());
		sb.append(", activityName=");
		sb.append(getActivityName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", startMonth=");
		sb.append(getStartMonth());
		sb.append(", startYear=");
		sb.append(getStartYear());
		sb.append(", startMonthName=");
		sb.append(getStartMonthName());
		sb.append(", endMonth=");
		sb.append(getEndMonth());
		sb.append(", endYear=");
		sb.append(getEndYear());
		sb.append(", endMonthName=");
		sb.append(getEndMonthName());
		sb.append(", progress=");
		sb.append(getProgress());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", progressStatus=");
		sb.append(getProgressStatus());
		sb.append(", completionDate=");
		sb.append(getCompletionDate());
		sb.append(", resourceName=");
		sb.append(getResourceName());
		sb.append(", resourceType=");
		sb.append(getResourceType());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.ProjectActivity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectActivityId</column-name><column-value><![CDATA[");
		sb.append(getProjectActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>strategyId</column-name><column-value><![CDATA[");
		sb.append(getStrategyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityName</column-name><column-value><![CDATA[");
		sb.append(getActivityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMonth</column-name><column-value><![CDATA[");
		sb.append(getStartMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startYear</column-name><column-value><![CDATA[");
		sb.append(getStartYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMonthName</column-name><column-value><![CDATA[");
		sb.append(getStartMonthName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMonth</column-name><column-value><![CDATA[");
		sb.append(getEndMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endYear</column-name><column-value><![CDATA[");
		sb.append(getEndYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMonthName</column-name><column-value><![CDATA[");
		sb.append(getEndMonthName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progress</column-name><column-value><![CDATA[");
		sb.append(getProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressStatus</column-name><column-value><![CDATA[");
		sb.append(getProgressStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionDate</column-name><column-value><![CDATA[");
		sb.append(getCompletionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceName</column-name><column-value><![CDATA[");
		sb.append(getResourceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceType</column-name><column-value><![CDATA[");
		sb.append(getResourceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectActivityId;
	private long _strategyId;
	private String _activityName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _startMonth;
	private int _startYear;
	private String _startMonthName;
	private int _endMonth;
	private int _endYear;
	private String _endMonthName;
	private int _progress;
	private int _status;
	private int _progressStatus;
	private Date _completionDate;
	private String _resourceName;
	private String _resourceType;
	private String _remark;
	private BaseModel<?> _projectActivityRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
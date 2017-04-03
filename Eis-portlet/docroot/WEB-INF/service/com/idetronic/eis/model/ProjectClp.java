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
import com.idetronic.eis.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class ProjectClp extends BaseModelImpl<Project> implements Project {
	public ProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _projectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("projectName", getProjectName());
		attributes.put("projectStatus", getProjectStatus());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("startMonth", getStartMonth());
		attributes.put("startYear", getStartYear());
		attributes.put("startMonthName", getStartMonthName());
		attributes.put("endMonth", getEndMonth());
		attributes.put("endYear", getEndYear());
		attributes.put("progressStatus", getProgressStatus());
		attributes.put("endMonthName", getEndMonthName());
		attributes.put("completionDate", getCompletionDate());
		attributes.put("progress", getProgress());
		attributes.put("resourceId", getResourceId());
		attributes.put("resourceTypeId", getResourceTypeId());
		attributes.put("resourceName", getResourceName());
		attributes.put("resourceType", getResourceType());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		Integer projectStatus = (Integer)attributes.get("projectStatus");

		if (projectStatus != null) {
			setProjectStatus(projectStatus);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
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

		Integer progressStatus = (Integer)attributes.get("progressStatus");

		if (progressStatus != null) {
			setProgressStatus(progressStatus);
		}

		String endMonthName = (String)attributes.get("endMonthName");

		if (endMonthName != null) {
			setEndMonthName(endMonthName);
		}

		Date completionDate = (Date)attributes.get("completionDate");

		if (completionDate != null) {
			setCompletionDate(completionDate);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		Long resourceId = (Long)attributes.get("resourceId");

		if (resourceId != null) {
			setResourceId(resourceId);
		}

		Long resourceTypeId = (Long)attributes.get("resourceTypeId");

		if (resourceTypeId != null) {
			setResourceTypeId(resourceTypeId);
		}

		String resourceName = (String)attributes.get("resourceName");

		if (resourceName != null) {
			setResourceName(resourceName);
		}

		String resourceType = (String)attributes.get("resourceType");

		if (resourceType != null) {
			setResourceType(resourceType);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_projectRemoteModel, projectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectName() {
		return _projectName;
	}

	@Override
	public void setProjectName(String projectName) {
		_projectName = projectName;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectName", String.class);

				method.invoke(_projectRemoteModel, projectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProjectStatus() {
		return _projectStatus;
	}

	@Override
	public void setProjectStatus(int projectStatus) {
		_projectStatus = projectStatus;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectStatus", int.class);

				method.invoke(_projectRemoteModel, projectStatus);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_projectRemoteModel, startDate);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_projectRemoteModel, endDate);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMonth", int.class);

				method.invoke(_projectRemoteModel, startMonth);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setStartYear", int.class);

				method.invoke(_projectRemoteModel, startYear);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMonthName",
						String.class);

				method.invoke(_projectRemoteModel, startMonthName);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setEndMonth", int.class);

				method.invoke(_projectRemoteModel, endMonth);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setEndYear", int.class);

				method.invoke(_projectRemoteModel, endYear);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressStatus", int.class);

				method.invoke(_projectRemoteModel, progressStatus);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setEndMonthName", String.class);

				method.invoke(_projectRemoteModel, endMonthName);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCompletionDate", Date.class);

				method.invoke(_projectRemoteModel, completionDate);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProgress", int.class);

				method.invoke(_projectRemoteModel, progress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResourceId() {
		return _resourceId;
	}

	@Override
	public void setResourceId(long resourceId) {
		_resourceId = resourceId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setResourceId", long.class);

				method.invoke(_projectRemoteModel, resourceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResourceTypeId() {
		return _resourceTypeId;
	}

	@Override
	public void setResourceTypeId(long resourceTypeId) {
		_resourceTypeId = resourceTypeId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setResourceTypeId", long.class);

				method.invoke(_projectRemoteModel, resourceTypeId);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setResourceName", String.class);

				method.invoke(_projectRemoteModel, resourceName);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setResourceType", String.class);

				method.invoke(_projectRemoteModel, resourceType);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_projectRemoteModel, groupId);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_projectRemoteModel, companyId);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_projectRemoteModel, userId);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_projectRemoteModel, userName);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_projectRemoteModel, createDate);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_projectRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectRemoteModel() {
		return _projectRemoteModel;
	}

	public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
		_projectRemoteModel = projectRemoteModel;
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

		Class<?> remoteModelClass = _projectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_projectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectLocalServiceUtil.addProject(this);
		}
		else {
			ProjectLocalServiceUtil.updateProject(this);
		}
	}

	@Override
	public Project toEscapedModel() {
		return (Project)ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
			new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectClp clone = new ProjectClp();

		clone.setProjectId(getProjectId());
		clone.setProjectName(getProjectName());
		clone.setProjectStatus(getProjectStatus());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setStartMonth(getStartMonth());
		clone.setStartYear(getStartYear());
		clone.setStartMonthName(getStartMonthName());
		clone.setEndMonth(getEndMonth());
		clone.setEndYear(getEndYear());
		clone.setProgressStatus(getProgressStatus());
		clone.setEndMonthName(getEndMonthName());
		clone.setCompletionDate(getCompletionDate());
		clone.setProgress(getProgress());
		clone.setResourceId(getResourceId());
		clone.setResourceTypeId(getResourceTypeId());
		clone.setResourceName(getResourceName());
		clone.setResourceType(getResourceType());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Project project) {
		long primaryKey = project.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectClp)) {
			return false;
		}

		ProjectClp project = (ProjectClp)obj;

		long primaryKey = project.getPrimaryKey();

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

		sb.append("{projectId=");
		sb.append(getProjectId());
		sb.append(", projectName=");
		sb.append(getProjectName());
		sb.append(", projectStatus=");
		sb.append(getProjectStatus());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
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
		sb.append(", progressStatus=");
		sb.append(getProgressStatus());
		sb.append(", endMonthName=");
		sb.append(getEndMonthName());
		sb.append(", completionDate=");
		sb.append(getCompletionDate());
		sb.append(", progress=");
		sb.append(getProgress());
		sb.append(", resourceId=");
		sb.append(getResourceId());
		sb.append(", resourceTypeId=");
		sb.append(getResourceTypeId());
		sb.append(", resourceName=");
		sb.append(getResourceName());
		sb.append(", resourceType=");
		sb.append(getResourceType());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.eis.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectName</column-name><column-value><![CDATA[");
		sb.append(getProjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectStatus</column-name><column-value><![CDATA[");
		sb.append(getProjectStatus());
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
			"<column><column-name>progressStatus</column-name><column-value><![CDATA[");
		sb.append(getProgressStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMonthName</column-name><column-value><![CDATA[");
		sb.append(getEndMonthName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionDate</column-name><column-value><![CDATA[");
		sb.append(getCompletionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progress</column-name><column-value><![CDATA[");
		sb.append(getProgress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceId</column-name><column-value><![CDATA[");
		sb.append(getResourceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceTypeId</column-name><column-value><![CDATA[");
		sb.append(getResourceTypeId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectId;
	private String _projectName;
	private int _projectStatus;
	private Date _startDate;
	private Date _endDate;
	private int _startMonth;
	private int _startYear;
	private String _startMonthName;
	private int _endMonth;
	private int _endYear;
	private int _progressStatus;
	private String _endMonthName;
	private Date _completionDate;
	private int _progress;
	private long _resourceId;
	private long _resourceTypeId;
	private String _resourceName;
	private String _resourceType;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _projectRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.eis.service.ClpSerializer.class;
}
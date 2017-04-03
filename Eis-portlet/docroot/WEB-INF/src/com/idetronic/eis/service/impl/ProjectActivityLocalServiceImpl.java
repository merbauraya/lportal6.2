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

package com.idetronic.eis.service.impl;

import java.util.Date;
import java.util.List;

import com.idetronic.eis.model.ProjectActivity;
import com.idetronic.eis.service.base.ProjectActivityLocalServiceBaseImpl;
import com.idetronic.eis.util.EisUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the project activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.ProjectActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.ProjectActivityLocalServiceBaseImpl
 * @see com.idetronic.eis.service.ProjectActivityLocalServiceUtil
 */
public class ProjectActivityLocalServiceImpl
	extends ProjectActivityLocalServiceBaseImpl {
	
	
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.ProjectActivityLocalServiceUtil} to access the project activity local service.
	 */
	public ProjectActivity add(long strategyId,String activityName,Date startDate,Date endDate,int progressStatus,
			int status,int progress,String resourceName,String resourceType,
			Date completionDate, String remark,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(ProjectActivity.class.getName());
		
		ProjectActivity activity = projectActivityPersistence.create(id);
		
		activity.setStrategyId(strategyId);
		activity.setActivityName(activityName);
		activity.setStatus(status);
		activity.setStartDate(startDate);
		activity.setEndDate(endDate);
		activity.setProgressStatus(progressStatus);
		
		
		
		activity.setResourceName(resourceName);
		activity.setResourceType(resourceType);
		activity.setCompanyId(serviceContext.getCompanyId());
		activity.setGroupId(serviceContext.getScopeGroupId());
		activity.setCreateDate(new Date());
		activity.setCompletionDate(completionDate);
		activity.setRemark(remark);
		
		return projectActivityPersistence.update(activity);
	}
	public List<ProjectActivity> getByStrategy(long strategyId) throws SystemException
	{
		return projectActivityPersistence.findByStrategy(strategyId);
		
	}
	
	public void deleteByStrategy(long strategyId) throws SystemException
	{
		projectActivityPersistence.removeByStrategy(strategyId);
	}
}
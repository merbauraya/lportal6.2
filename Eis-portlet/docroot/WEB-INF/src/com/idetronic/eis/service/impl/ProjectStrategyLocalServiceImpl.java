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

import com.idetronic.eis.NoSuchProjectStrategyException;
import com.idetronic.eis.model.Project;
import com.idetronic.eis.model.ProjectStrategy;
import com.idetronic.eis.service.ProjectActivityLocalServiceUtil;
import com.idetronic.eis.service.base.ProjectStrategyLocalServiceBaseImpl;
import com.idetronic.eis.util.EisUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the project strategy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.ProjectStrategyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.ProjectStrategyLocalServiceBaseImpl
 * @see com.idetronic.eis.service.ProjectStrategyLocalServiceUtil
 */
public class ProjectStrategyLocalServiceImpl
	extends ProjectStrategyLocalServiceBaseImpl {

	@Override
	public List<ProjectStrategy> getByProject(long projectId,int start,int end) 
	{
		try {
			return projectStrategyPersistence.findByProject(projectId, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ProjectStrategy add(long projectId,String strategyName,Date startDate,Date endDate,
			int progressStatus,int status,
			int progress,String resourceName,String resourceType,
			Date completionDate,String remark,
			ServiceContext serviceContext) throws SystemException
	{
		
		long strategyId = CounterLocalServiceUtil.increment(ProjectStrategy.class.getName());
		
		ProjectStrategy strategy = projectStrategyPersistence.create(strategyId);
		
		strategy.setStrategyName(strategyName);
		strategy.setProjectId(projectId);
		strategy.setStartDate(startDate);
		strategy.setEndDate(endDate);
		strategy.setProgressStatus(progressStatus);
		
		strategy.setCompanyId(serviceContext.getCompanyId());
		strategy.setCompletionDate(completionDate);
		
		strategy.setResourceName(resourceName);
		strategy.setResourceType(resourceType);
		strategy.setStatus(status);
		
		strategy.setCreateDate(new Date());
		strategy.setRemark(remark);
		
		
		return projectStrategyPersistence.update(strategy);
	}
	
	/**
	 * Delete strategy and all activities under it
	 * @param strategyId
	 */
	public void deleteStrategyAll(long strategyId) throws SystemException
	{
		ProjectActivityLocalServiceUtil.deleteByStrategy(strategyId);
		try {
			projectStrategyPersistence.remove(strategyId);
		} catch (NoSuchProjectStrategyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Remove all strategy by project
	 * @param projectId
	 * @throws SystemException
	 */
	public void deleteByProject(long projectId) throws SystemException
	{
		projectStrategyPersistence.removeByProject(projectId);
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.ProjectStrategyLocalServiceUtil} to access the project strategy local service.
	 */
	
	
}
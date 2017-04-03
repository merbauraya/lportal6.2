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

import com.idetronic.eis.NoSuchProjectException;
import com.idetronic.eis.model.Project;
import com.idetronic.eis.model.ProjectStrategy;
import com.idetronic.eis.service.ProjectActivityLocalServiceUtil;
import com.idetronic.eis.service.ProjectStrategyLocalServiceUtil;
import com.idetronic.eis.service.base.ProjectLocalServiceBaseImpl;
import com.idetronic.eis.util.EisUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.ProjectLocalServiceBaseImpl
 * @see com.idetronic.eis.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.ProjectLocalServiceUtil} to access the project local service.
	 */
	public Project addProject(String projectName,int projectStatus,Date startDate,Date endDate,int progressStatus,
			int progress,String resourceName,String resourceType,
			Date completionDate,ServiceContext serviceContext) throws SystemException
	{
		long projectId = CounterLocalServiceUtil.increment(Project.class.getName());
		
		Project project = projectPersistence.create(projectId);
		
		project.setProjectName(projectName);
		project.setProgressStatus(progressStatus);
		project.setProjectStatus(projectStatus);
		/*
		project.setStartMonth(startMonth);
		project.setStartYear(startYear);
		project.setEndMonth(endMonth);
		project.setEndYear(endYear);
		*/
		project.setStartDate(startDate);
		project.setProgress(progress);
		project.setCreateDate(new Date());
		project.setCompletionDate(completionDate);
		
		//project.setStartMonthName(EisUtil.getMonthName(startMonth));
		//project.setEndMonthName(EisUtil.getMonthName(endMonth));
		project.setEndDate(endDate);
		project.setResourceName(resourceName);
		project.setResourceType(resourceType);
		project.setCompanyId(serviceContext.getCompanyId());
		project.setGroupId(serviceContext.getScopeGroupId());
		
		
		
		return projectPersistence.update(project);
		

	}
	/**
	 * Delete project and all strategy and activities
	 * @param projectId
	 */
	public void deleteProjectAll(long projectId) throws SystemException
	{
		List<ProjectStrategy> strategies  = ProjectStrategyLocalServiceUtil.getByProject(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (ProjectStrategy strategy : strategies)
		{
			ProjectActivityLocalServiceUtil.deleteByStrategy(strategy.getProjectStrategyId());
			
			
		}
		ProjectStrategyLocalServiceUtil.deleteByProject(projectId);
		
		try {
			projectPersistence.remove(projectId);
		} catch (NoSuchProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
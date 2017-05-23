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

import com.idetronic.eis.NoSuchUserReportException;
import com.idetronic.eis.model.UserData;
import com.idetronic.eis.model.UserReport;
import com.idetronic.eis.service.base.UserReportLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the user report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.UserReportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.UserReportLocalServiceBaseImpl
 * @see com.idetronic.eis.service.UserReportLocalServiceUtil
 */
public class UserReportLocalServiceImpl extends UserReportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.UserReportLocalServiceUtil} to access the user report local service.
	 */
	public UserReport add(long userId,long libraryId,long dataId,ServiceContext serviceContext) throws SystemException 
	{
		UserReport userData;
		try {
			userData = userReportPersistence.findByUserDataLibrary(userId, libraryId,dataId);
			
		} catch (NoSuchUserReportException e) {
			long id = CounterLocalServiceUtil.increment(UserData.class.getName());
			
			userData = userReportPersistence.create(id);
			userData.setUserId(userId);
			userData.setLibraryId(libraryId);
			userData.setReportId(dataId);
			userData.setCreatedByUserId(serviceContext.getUserId());
			userData.setCreateDate(new Date());
			
			userReportPersistence.update(userData);
		} 
		
		return userData;
		
	}
	
	public void add(long userId, long libraryId,long[] dataIds,ServiceContext serviceContext) throws SystemException
	{
		for (long dataId : dataIds)
		{
			add(userId, libraryId,dataId,serviceContext);
		}
	}
	public UserReport findyUserData(long userId, long libraryId,long dataId) throws SystemException, NoSuchUserReportException
	{
		return userReportPersistence.findByUserDataLibrary(userId, libraryId,dataId);
	}
	public void updateAssociationByUser(long userId,long libraryId,long[] addDataIds,long[] removeDataIds,ServiceContext serviceContext)  
	{
		for (long dataId: addDataIds)
		{
			try {
				add(userId,libraryId,dataId,serviceContext);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
		}
		
		for (long dataId : removeDataIds)
		{
			
				
			try {
				userReportPersistence.removeByUserDataLibrary(userId,libraryId, dataId);
			} catch (NoSuchUserReportException e) {
				
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
				
			
			
		}
	}
	public List<UserReport> findByUserLibrary(long userId,long libraryId) throws SystemException
	{
		return userReportPersistence.findByUserAndLibrary(userId,libraryId); 
		
	}
}
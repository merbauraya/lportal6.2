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

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.idetronic.eis.NoSuchUserLibraryException;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.model.UserLibrary;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.MasterFileLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.idetronic.eis.service.base.UserLibraryLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the user library local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.UserLibraryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.UserLibraryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.UserLibraryLocalServiceUtil
 */
public class UserLibraryLocalServiceImpl extends UserLibraryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.UserLibraryLocalServiceUtil} to access the user library local service.
	 */
	
	public UserLibrary add(long userId,long libraryId,ServiceContext serviceContext) throws SystemException 
	{
		UserLibrary userLibrary;
		try {
			userLibrary = userLibraryPersistence.findByuserLibrary(userId, libraryId);
		} catch (NoSuchUserLibraryException e) {
			long id = CounterLocalServiceUtil.increment(UserLibrary.class.getName());
			
			userLibrary = userLibraryPersistence.create(id);
			
			userLibrary.setLibraryId(libraryId);
			userLibrary.setUserId(userId);
			userLibrary.setCreatedByUserId(serviceContext.getUserId());
			userLibrary.setCreateDate(new Date());
			userLibrary.setCompanyId(serviceContext.getCompanyId());
			userLibrary.setGroupId(serviceContext.getScopeGroupId());
			userLibraryPersistence.update(userLibrary);
		}
		return userLibrary;
		
		
		
		
		
		
	}
	
	public void add(long libraryId,long[] userIds,ServiceContext serviceContext) throws SystemException
	{
		userLibraryPersistence.removeBylibrary(libraryId);
		
		for (long userId: userIds)
		{
			add(userId,libraryId,serviceContext);
		}
		
	}
	public void remove(long userId,long libraryId) throws SystemException
	{
		try {
			userLibraryPersistence.removeByuserLibrary(userId, libraryId);
		} catch (NoSuchUserLibraryException e) {
			
		}
	}
	
	public List<UserLibrary> findByLibrary(long libraryId,int start,int end) throws SystemException
	{
		return userLibraryPersistence.findBylibrary(libraryId, start, end);
	}
	public List<UserLibrary> findByUser(long userId,int start,int end) throws SystemException
	{
		return userLibraryPersistence.findByuser(userId, start, end);
	}
	
	public boolean hasAssociation(long libraryId,long userId) throws SystemException
	{
		UserLibrary userLibrary = null;
		userLibrary = userLibraryPersistence.fetchByuserLibrary(userId, libraryId);
		
		return (userLibrary != null);
	}
	
	public void updateAssociationByUser(long userId,long[] addLibraryIds,long[] removeLibraryIds,ServiceContext serviceContext)
	{
		for (long libraryId: addLibraryIds)
		{
			try {
				add(userId,libraryId,serviceContext);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (long libraryId : removeLibraryIds)
		{
			try {
				remove(userId, libraryId);
			
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 */
	public void updateAssociation(long libraryId,long[] addUserIds,long[] removeUserId,ServiceContext serviceContext) 
	{
		for (long userId : addUserIds)
		{
			try {
				add(userId,libraryId,serviceContext);
			} catch (SystemException e) {
				continue;
			}
		}
		
		for (long userId: removeUserId)
		{
			try {
				remove(userId, libraryId);
			}  catch (SystemException se)
			{
				continue;
			}
		}
		
	}
	
	public int countByLibrary(long libraryId) throws SystemException
	{
		return userLibraryPersistence.countBylibrary(libraryId);
	}
	public List<MasterFile> getLibraryByUser2(long userId) throws SystemException
	{
		List<UserLibrary> userLibraries = userLibraryPersistence.findByuser(userId);
		List<MasterFile> libraries = new ArrayList<MasterFile>(userLibraries.size());
		
		for (UserLibrary userLibrary : userLibraries)
		{
			MasterFile library =  MasterFileLocalServiceUtil.fetchMasterFile(userLibrary.getLibraryId());
			if (!library.isInActive())
			{
				libraries.add(library);
			}
		}
		
		
		
		return libraries;

	}
	
	public List<MasterFile> getLibraryByUser(long userId) throws SystemException
	{
		return getLibraryByUser2(userId);
		/*
		
		List<UserLibrary> userLibraries = userLibraryPersistence.findByuser(userId);
		List<MasterFile> libraries = new ArrayList<MasterFile>(userLibraries.size());
		
		for (UserLibrary userLibrary : userLibraries)
		{
			MasterFile library = LibraryLocalServiceUtil.fetchLibrary(userLibrary.getLibraryId());
			libraries.add(library);
		}
		
		
		
		return libraries;
		*/
	}
	
	public List<User> findByLibrary (long libraryId) throws SystemException
	{
		List<UserLibrary> userLibraries = userLibraryPersistence.findBylibrary(libraryId);
		
		List<User> users = new ArrayList<User>(userLibraries.size());
		
		for (UserLibrary userLibrary : userLibraries)
		{
			User user = UserLocalServiceUtil.fetchUser(userLibrary.getUserId());
			users.add(user);
		}
		
		return users;
	}
	
	public List<Object> getDistinctUser() throws SystemException
	{
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserLibrary.class);//, PortalClassLoaderUtil.getClassLoader());
		Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("userId"));
		dynamicQuery.setProjection(projection);
		List<Object> userList = userLibraryPersistence.findWithDynamicQuery(dynamicQuery);
		return userList;

	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(UserLibraryLocalServiceUtil.class.getName());
}
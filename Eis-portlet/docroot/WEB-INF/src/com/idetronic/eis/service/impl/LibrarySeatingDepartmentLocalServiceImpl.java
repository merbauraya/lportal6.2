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

import com.idetronic.eis.model.LibrarySeatingDepartment;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.service.base.LibrarySeatingDepartmentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the library seating department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.LibrarySeatingDepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.LibrarySeatingDepartmentLocalServiceBaseImpl
 * @see com.idetronic.eis.service.LibrarySeatingDepartmentLocalServiceUtil
 */
public class LibrarySeatingDepartmentLocalServiceImpl
	extends LibrarySeatingDepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.LibrarySeatingDepartmentLocalServiceUtil} to access the library seating department local service.
	 */
	
	public LibrarySeatingDepartment add(long libraryId,long departmentId,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(LibrarySeatingDepartment.class.getName());
		
		LibrarySeatingDepartment libraryDepartment = librarySeatingDepartmentPersistence.create(id);
		libraryDepartment.setLibraryId(libraryId);
		libraryDepartment.setDepartmentId(departmentId);
		libraryDepartment.setCreateDate(new Date());
		libraryDepartment.setCompanyId(serviceContext.getCompanyId());
		libraryDepartment.setGroupId(serviceContext.getScopeGroupId());
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		libraryDepartment.setUserId(serviceContext.getUserId());
		libraryDepartment.setUserName(user.getFullName());
		
		return librarySeatingDepartmentPersistence.update(libraryDepartment);
	}
}
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

import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.service.base.SeatingDepartmentLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the seating department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.SeatingDepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.SeatingDepartmentLocalServiceBaseImpl
 * @see com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil
 */
public class SeatingDepartmentLocalServiceImpl
	extends SeatingDepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil} to access the seating department local service.
	 */
	public SeatingDepartment add(String name,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(SeatingDepartment.class.getName());
		
		SeatingDepartment seatingDepartment = seatingDepartmentPersistence.create(id);
		seatingDepartment.setDepartmentName(name);
		seatingDepartment.setCreateDate(new Date());
		seatingDepartment.setCompanyId(serviceContext.getCompanyId());
		seatingDepartment.setGroupId(serviceContext.getScopeGroupId());
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		seatingDepartment.setUserId(serviceContext.getUserId());
		seatingDepartment.setUserName(user.getFullName());
		
		return seatingDepartmentPersistence.update(seatingDepartment);
		
		
		
	}
}
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

import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.service.base.SeatingCategoryLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the seating category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.SeatingCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.SeatingCategoryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.SeatingCategoryLocalServiceUtil
 */
public class SeatingCategoryLocalServiceImpl
	extends SeatingCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.SeatingCategoryLocalServiceUtil} to access the seating category local service.
	 */
	
	public SeatingCategory add(long departmentId, String name,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(SeatingCategory.class.getName());
		
		SeatingCategory seatingCategory = seatingCategoryPersistence.create(id);
		seatingCategory.setSeatingCategoryName(name);
		seatingCategory.setCreateDate(new Date());
		seatingCategory.setCompanyId(serviceContext.getCompanyId());
		seatingCategory.setGroupId(serviceContext.getScopeGroupId());
		seatingCategory.setSeatingDepartmentId(departmentId);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		seatingCategory.setUserId(serviceContext.getUserId());
		seatingCategory.setUserName(user.getFullName());
		
		return seatingCategoryPersistence.update(seatingCategory);
	}
}
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

import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.service.base.PostGradeLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the post grade local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.PostGradeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.PostGradeLocalServiceBaseImpl
 * @see com.idetronic.eis.service.PostGradeLocalServiceUtil
 */
public class PostGradeLocalServiceImpl extends PostGradeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.PostGradeLocalServiceUtil} to access the post grade local service.
	 */
	
	public PostGrade add(String code,String name,String scheme,long postCategoryId,String desc,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(PostGrade.class.getName());
		
		PostGrade postGrade = postGradePersistence.create(id);
		
		postGrade.setPostGradeCode(code);
		postGrade.setPostGradeName(name);
		postGrade.setPostGradeScheme(scheme);
		postGrade.setPostGradeDesc(desc);
		postGrade.setPostCategoryId(postCategoryId);
		postGrade.setCreateDate(new Date());
		postGrade.setGroupId(serviceContext.getScopeGroupId());
		postGrade.setCompanyId(serviceContext.getCompanyId());
		postGrade.setUserId(serviceContext.getUserId());
		
		return postGradePersistence.update(postGrade);
		
		
		
	}
	public List<PostGrade> findAll(int start,int end,OrderByComparator ord) throws SystemException
	{
		return postGradePersistence.findAll(start, end, ord);
	}
	
	
}
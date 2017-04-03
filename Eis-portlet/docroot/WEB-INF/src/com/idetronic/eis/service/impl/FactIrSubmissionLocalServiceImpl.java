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

import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.service.base.FactIrSubmissionLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactIrSubmissionFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact ir submission local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactIrSubmissionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactIrSubmissionLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactIrSubmissionLocalServiceUtil
 */
public class FactIrSubmissionLocalServiceImpl
	extends FactIrSubmissionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactIrSubmissionLocalServiceUtil} to access the fact ir submission local service.
	 */
	
	public FactIrSubmission add(long libraryId, long facultyId,String period,long itemMediumId,int titleTotal,int volumeTotal,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactIrSubmission.class.getName());
		
		FactIrSubmission submission = factIrSubmissionPersistence.create(id);
		
		submission.setLibraryId(libraryId);
		submission.setFacultyId(facultyId);
		submission.setItemMediumId(itemMediumId);
		submission.setTitleTotal(titleTotal);
		submission.setVolumeTotal(volumeTotal);
		submission.setPeriod(period);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		submission.setCreatedByUserId(user.getUserId());
		submission.setCreatedByUserName(user.getFullName());
		submission.setCreatedDate(new Date());
		
		return factIrSubmissionPersistence.update(submission);
		
		
	}
	public void batchInsert(long libraryId,long facultyId,String period,JSONArray datas,ServiceContext serviceContext) throws SystemException
	{
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long mediumId = data.getLong("itemMediumId");
			int titleTotal = data.getInt("titleTotal");
			int volumeTotal = data.getInt("volumeTotal");
			add(libraryId,facultyId,period,mediumId,titleTotal,volumeTotal,serviceContext);
		}
	}
	public List<FactIrSubmission> findLatestEntry(long libraryId,long facultyId,String period)
	{
		return FactIrSubmissionFinderUtil.findLatestEntry(libraryId, period, facultyId);
	}
}
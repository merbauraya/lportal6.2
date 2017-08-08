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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.idetronic.eis.model.FactData;
import com.idetronic.eis.model.FactItManagement;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactDataLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactDataFinderUtil;
import com.idetronic.eis.service.persistence.FactItManagementFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactDataLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactDataLocalServiceUtil
 */
public class FactDataLocalServiceImpl extends FactDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactDataLocalServiceUtil} to access the fact data local service.
	 */
	public List<FactData> getLatestEntry(long reportId,long libraryId, String period)
	{
		return FactDataFinderUtil.getLatestEntry(reportId,libraryId,period);
		
	}
	public void batchInsert(long reportId,long libraryId,String period,JSONArray datas,
			ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long dimensionId = data.getLong("dimensionId");
			String measure1 = data.getString("measure1");
			String measure2 = data.getString("measure2");
			String measure3 = data.getString("measure3");
			String measure4 = data.getString("measure4");
			
			if (Validator.isBlank(measure2))
				measure2 = "0";
			
			if (Validator.isBlank(measure3))
				measure3 = "0";
			
			if (Validator.isBlank(measure4))
				measure4 = "0";
			
			if (!Validator.isBlank(measure1) )
			{
				add(reportId,libraryId,period,dimensionId,Double.parseDouble(measure1),
						Double.parseDouble(measure2),Double.parseDouble(measure3),
						Double.parseDouble(measure4), serviceContext);
			}
		}
		
		
		
		
		
		
	}
	
	public FactData add(long reportId,long libraryId, String period,long dimensionId,
			double measure1,double measure2,double measure3,double measure4,
			ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactData.class.getName());
		
		FactData fact = factDataPersistence.create(id);
		
		fact.setReportId(reportId);
		fact.setLibraryId(libraryId);
		fact.setPeriod(period);
		fact.setDimensionId(dimensionId);
		fact.setMeasure1(measure1);
		fact.setMeasure2(measure2);
		fact.setMeasure3(measure3);
		fact.setMeasure4(measure4);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		fact.setUserId(user.getUserId());
		fact.setUserName(user.getFullName());
		fact.setCreateDate(new Date());
		
		return factDataPersistence.update(fact);
		
		
	}
	public JSONArray getEntries(long reportId,long libraryId, String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactDataFinderUtil.getHistory(reportId,libraryId, period);
		
		FactData fact = null;
		MasterFile dimension = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactData)arrayobject[0];
			dimension = (MasterFile)arrayobject[1];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			
			jsonObject.put("Dimension", dimension.getMasterFileName());
			jsonObject.put("measure1", fact.getMeasure1());
			jsonObject.put("measure2", fact.getMeasure2());
			jsonObject.put("measure3", fact.getMeasure3());
			jsonObject.put("measure4", fact.getMeasure4());
			
			jsonObject.put("Pengguna", fact.getUserName());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

		
		}
		return jsonData;
		
		
	}
	private static Log LOGGER = LogFactoryUtil.getLog(FactDataLocalServiceImpl.class);
}
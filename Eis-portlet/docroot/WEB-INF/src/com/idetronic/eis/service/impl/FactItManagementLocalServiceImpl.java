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

import com.idetronic.eis.model.FactItManagement;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactItManagementLocalServiceBaseImpl;
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
 * The implementation of the fact it management local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactItManagementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactItManagementLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactItManagementLocalServiceUtil
 */
public class FactItManagementLocalServiceImpl
	extends FactItManagementLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactItManagementLocalServiceUtil} to access the fact it management local service.
	 */
	
	
	public List<FactItManagement> getLatestEntry(long libraryId, String period)
	{
		return FactItManagementFinderUtil.getLatestEntry(libraryId,period);
		
	}
	public void batchInsert(long libraryId,String period,JSONArray datas,
			ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long itemId = data.getLong("itemId");
			String total = data.getString("total");
		
			if (!Validator.isBlank(total) )
			{
				add(libraryId,period,itemId,Long.parseLong(total),
						 serviceContext);
			}
		}
		
		
		
		
		
		
	}
	
	public FactItManagement add(long libraryId, String period,long itemId,
			long total,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactItManagement.class.getName());
		
		FactItManagement fact = factItManagementPersistence.create(id);
		
		
		fact.setLibraryId(libraryId);
		fact.setPeriod(period);
		fact.setItemId(itemId);
		fact.setItemTotal(total);
		
		
		
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		fact.setUserId(user.getUserId());
		fact.setUserName(user.getFullName());
		fact.setCreateDate(new Date());
		
		return factItManagementPersistence.update(fact);
		
		
	}
	public JSONArray getEntries(long libraryId, String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactItManagementFinderUtil.getHistory(libraryId, period);
		
		FactItManagement fact = null;
		MasterFile category = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		LOGGER.info("size="+ list.size());
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactItManagement)arrayobject[0];
			category = (MasterFile)arrayobject[1];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Jumlah", fact.getItemTotal());
			jsonObject.put("Kategori", category.getMasterFileName());
			jsonObject.put("Pengguna", fact.getUserName());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			//out.println(employee.getEmployeeName());
			//out.println(address.getCity());
		}
		return jsonData;
		
		
	}
	private static Log LOGGER = LogFactoryUtil.getLog(FactItManagementLocalServiceImpl.class);
	
}
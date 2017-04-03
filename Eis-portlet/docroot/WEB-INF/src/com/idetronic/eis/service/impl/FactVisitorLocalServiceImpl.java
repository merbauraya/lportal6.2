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

import com.idetronic.eis.model.FactVisitor;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.base.FactVisitorLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactVisitorFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact visitor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactVisitorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactVisitorLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactVisitorLocalServiceUtil
 */
public class FactVisitorLocalServiceImpl extends FactVisitorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactVisitorLocalServiceUtil} to access the fact visitor local service.
	 */
	public FactVisitor add(long libraryId,String period,long visitorCategoryId,int value,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactVisitor.class.getName());
		
		FactVisitor factVisitor = factVisitorPersistence.create(id);
		
		factVisitor.setLibraryId(libraryId);
		factVisitor.setPeriod(period);
		factVisitor.setValue(value);
		factVisitor.setVisitorCategoryId(visitorCategoryId);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		factVisitor.setCreatedByUserId(user.getUserId());
		factVisitor.setCreatedByUserName(user.getFullName());
		factVisitor.setCreatedDate(new Date());
		
		Library library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
		factVisitor.setStateId(library.getStateId());
		factVisitor.setLibraryTypeId(library.getLibraryTypeId());
		
		return factVisitorPersistence.update(factVisitor);
		
	}
	public void bacthInsert(long libraryId,String period,JSONArray datas, ServiceContext serviceContext) throws SystemException
	{
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			
			long visitorCategoryId = data.getLong("visitorCategoryId");
			
			
			try
			{
				int value = Integer.parseInt(data.getString("value"));
				add(libraryId,period,visitorCategoryId,value,serviceContext);
				
			} catch (NumberFormatException ex){}
			
		
			
		}
	}
	
	public List<FactVisitor> getLatestEntry(long libraryId,String period)
	{
		return FactVisitorFinderUtil.findLatestEntry(libraryId, period);
	}
	public JSONArray getEntries(long libraryId, String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactVisitorFinderUtil.getHistory(libraryId, period);
		
		FactVisitor fact = null;
		VisitorCategory category = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactVisitor)arrayobject[0];
			category = (VisitorCategory)arrayobject[1];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Nilai", fact.getValue());
			jsonObject.put("Kategori", category.getVisitorCategoryName());
			jsonObject.put("Pengguna", fact.getCreatedByUserName());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreatedDate()));
			jsonData.put(jsonObject);

			
			//out.println(employee.getEmployeeName());
			//out.println(address.getCity());
		}
		return jsonData;
		
		
	}
}
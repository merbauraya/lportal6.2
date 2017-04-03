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

import com.idetronic.eis.model.FactSeating;
import com.idetronic.eis.model.FactVisitor;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.base.FactSeatingLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactSeatingFinderUtil;
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
 * The implementation of the fact seating local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactSeatingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactSeatingLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactSeatingLocalServiceUtil
 */
public class FactSeatingLocalServiceImpl extends FactSeatingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactSeatingLocalServiceUtil} to access the fact seating local service.
	 */
	
	public FactSeating add(long libraryId,long departmentId,long seatingCategoryId, String period,int capacity,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactSeating.class.getName());
		FactSeating factSeating = factSeatingPersistence.create(id);
		
		factSeating.setLibraryId(libraryId);
		factSeating.setDepartmentId(departmentId);
		factSeating.setSeatingCategoryId(seatingCategoryId);
		factSeating.setPeriod(period);
		factSeating.setCapacity(capacity);
		factSeating.setCreateDate(new Date());
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		factSeating.setUserId(serviceContext.getUserId());
		factSeating.setUserName(user.getFullName());
		factSeating.setCompanyId(serviceContext.getCompanyId());
		factSeating.setGroupId(serviceContext.getScopeGroupId());
		
		Library library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
		factSeating.setStateId(library.getStateId());
		factSeating.setLibraryTypeId(library.getLibraryTypeId());
		
		
		
		return factSeatingPersistence.update(factSeating);
		
		
	}
	
	public void bacthInsert(long libraryId,String period,JSONArray datas, ServiceContext serviceContext) throws SystemException
	{
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			
			long departmentId = data.getLong("departmentId");
			long categoryId = data.getLong("categoryId");
			
			
			
			try
			{
				int value = Integer.parseInt(data.getString("capacity"));
				add(libraryId,departmentId,categoryId,period,value,serviceContext);
			} catch (NumberFormatException ex){}
			
		
			
		}
	}
	
	
	/**
	 * 
	 * @param libraryId
	 * @param period
	 * @return
	 */
	public List<FactSeating> getLatestEntry(long libraryId,String period)
	{
		return FactSeatingFinderUtil.findLatestEntry(libraryId, period);
	}
	
	public JSONArray getEntries(long libraryId, String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactSeatingFinderUtil.getHistory(libraryId, period);
		
		FactSeating fact = null;
		SeatingCategory category = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactSeating)arrayobject[0];
			category = (SeatingCategory)arrayobject[1];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Kategori", category.getSeatingCategoryName());
			jsonObject.put("Kapasiti", fact.getCapacity());
			
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
}
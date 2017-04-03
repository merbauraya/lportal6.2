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

import com.idetronic.eis.model.FactMembership;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.Loan;
import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.base.FactMembershipLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactMembershipFinderUtil;
import com.idetronic.eis.service.persistence.LoanFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact membership local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactMembershipLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactMembershipLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactMembershipLocalServiceUtil
 */
public class FactMembershipLocalServiceImpl
	extends FactMembershipLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactMembershipLocalServiceUtil} to access the fact membership local service.
	 */
	
	public FactMembership add(long libraryId,String period, long categoryId,int value,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactMembership.class.getName());
		
		FactMembership fact = factMembershipPersistence.create(id);
		
		fact.setActiveCount(value);
		fact.setLibraryId(libraryId);
		fact.setPeriod(period);
		fact.setMembershipCategoryId(categoryId);
		fact.setCreateDate(new Date());
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		fact.setCompanyId(serviceContext.getCompanyId());
		fact.setGroupId(serviceContext.getScopeGroupId());
		fact.setUserName(user.getFullName());
		
		
		Library library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
		
		fact.setStateId(library.getStateId());
		fact.setLibraryTypeId(library.getLibraryTypeId());
		
		
		return factMembershipPersistence.update(fact);
	}
	
	public void batchInsert(long libraryId,String period,JSONArray datas,ServiceContext serviceContext) throws SystemException
	{
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			
			long memberCategoryId = data.getLong("categoryId");
			
			try
			{
				int value = Integer.parseInt(data.getString("value"));
				add(libraryId,period,memberCategoryId,value,serviceContext);
			} catch (NumberFormatException ex){} 
			
			
		
			
		}
	}
	
	public List<FactMembership> getLatestEntry(long libraryId, String period)
	{
		return FactMembershipFinderUtil.getLatestEntry(libraryId,period);
		
	}
	
	public JSONArray getEntries(long libraryId, String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactMembershipFinderUtil.getHistory(libraryId, period);
		
		FactMembership fact = null;
		MemberCategory category = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactMembership)arrayobject[0];
			category = (MemberCategory)arrayobject[1];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Nilai", fact.getActiveCount());
			jsonObject.put("Kategori", category.getMemberCategoryName());
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
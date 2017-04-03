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

import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactPost;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.PostCategory;
import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.base.FactPostLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactIrItemFinderUtil;
import com.idetronic.eis.service.persistence.FactPostFinder;
import com.idetronic.eis.service.persistence.FactPostFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact post local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactPostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactPostLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactPostLocalServiceUtil
 */
public class FactPostLocalServiceImpl extends FactPostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactPostLocalServiceUtil} to access the fact post local service.
	 */
	
	public FactPost add(long libraryId,String period,long postGradeId, int value,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactPost.class.getName());
		
		FactPost factPost = factPostPersistence.create(id);
		factPost.setLibraryId(libraryId);
		factPost.setPeriod(period);
		factPost.setPostGradeId(postGradeId);
		factPost.setValue(value);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		factPost.setCreatedByUserId(user.getUserId());
		factPost.setCreatedByUserName(user.getFullName());
		factPost.setCreatedDate(new Date());
		
		
		Library library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
		factPost.setStateId(library.getStateId());
		
		
		return factPostPersistence.update(factPost);
		
	}
	public void batchInsert(long libraryId,String period,JSONArray datas,ServiceContext serviceContext) throws SystemException 
	{
		for (int i = 0; i < datas.length(); i ++)
		{
			JSONObject data = datas.getJSONObject(i);
			String valueString = data.getString("value");
			try
			{
				int value = Integer.parseInt(valueString);
				add(libraryId,period,data.getLong("postGradeId"),value,serviceContext);
				
			
			}catch (NumberFormatException ex){}
			
			
		}
	}
	public List<FactPost> getLatestEntry(long libraryId,String period)
	{
		return FactPostFinderUtil.findLatestEntry(libraryId, period);
	}
	
	public JSONArray getEntries(long libraryId, String period) throws SystemException
	{
		
		List list = FactPostFinderUtil.getHistory(libraryId, period);
		
		FactPost fact = null;
		PostGrade grade = null;
		PostCategory category = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactPost)arrayobject[0];
			grade = (PostGrade)arrayobject[1];
			category = (PostCategory)arrayobject[2];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Jumlah", fact.getValue());
			jsonObject.put("Gred", grade.getPostGradeCode());
			jsonObject.put("Jawatan", grade.getPostGradeName());
			jsonObject.put("Pengguna", fact.getCreatedByUserName());
			jsonObject.put("Kategori", category.getPostCategoryName());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreatedDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
		
		
	}
}
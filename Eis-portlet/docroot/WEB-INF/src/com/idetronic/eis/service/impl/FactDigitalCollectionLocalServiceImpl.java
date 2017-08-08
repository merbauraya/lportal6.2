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

import com.idetronic.eis.model.FactDatabaseUsage;
import com.idetronic.eis.model.FactDigitalCollection;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactDigitalCollectionLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactDatabaseUsageFinderUtil;
import com.idetronic.eis.service.persistence.FactDigitalCollectionFinderUtil;
import com.idetronic.eis.service.persistence.FactIncomeFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact digital collection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactDigitalCollectionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactDigitalCollectionLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactDigitalCollectionLocalServiceUtil
 */
public class FactDigitalCollectionLocalServiceImpl
	extends FactDigitalCollectionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactDigitalCollectionLocalServiceUtil} to access the fact digital collection local service.
	 */
	public void batchInsert(long libraryId,String period,JSONArray datas,
			ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long itemId = data.getLong("itemId");
			String title = data.getString("title");
			String volume = data.getString("volume");
			String image = data.getString("image");
			if (!Validator.isBlank(title) && !Validator.isBlank(volume) && !Validator.isBlank(image))
			{
				add(libraryId,period,itemId,Long.parseLong(title),
						Long.parseLong(volume),Long.parseLong(image), serviceContext);
			}
		}
		
		
		
		
		
		
	}
	
	public FactDigitalCollection add(long libraryId, String period,long itemId,
			long title,long volume,long image,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactDigitalCollection.class.getName());
		
		FactDigitalCollection fact = factDigitalCollectionPersistence.create(id);
		
		
		fact.setLibraryId(libraryId);
		fact.setPeriod(period);
		fact.setItemId(itemId);
		
		fact.setTitleTotal(title);
		fact.setVolumeTotal(volume);
		fact.setImageTotal(image);
		
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		fact.setUserId(user.getUserId());
		fact.setUserName(user.getFullName());
		fact.setCreateDate(new Date());
		
		return factDigitalCollectionPersistence.update(fact);
		
		
	}
	public List<FactDigitalCollection> getLatestEntry(long libraryId,String period)
	{
		return FactDigitalCollectionFinderUtil.getLatestEntry(libraryId,period);
	}
	
	public JSONArray getEntries(long libraryId, String period)
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactDigitalCollectionFinderUtil.getHistory(libraryId, period);
		
		FactDigitalCollection fact = null;
		MasterFile mst = null;
		
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactDigitalCollection)arrayobject[0];
			mst = (MasterFile)arrayobject[1];
			
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
		
			
			jsonObject.put("Pengguna", fact.getUserName());
			jsonObject.put("id", mst.getMasterFileId());
			
			jsonObject.put("Jenis", mst.getMasterFileName());
			jsonObject.put("Judul", fact.getTitleTotal());
			jsonObject.put("Naskah", fact.getVolumeTotal());
			jsonObject.put("Imej", fact.getImageTotal());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
				
	}
	
	/**
	 * 
	 */
	public boolean isMissingData(long libraryId, String period)
	{
		return FactDigitalCollectionFinderUtil.getDataCount(libraryId,period) == 0;
	}
}
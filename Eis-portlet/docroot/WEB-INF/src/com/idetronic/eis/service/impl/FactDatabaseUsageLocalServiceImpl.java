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
import com.idetronic.eis.model.FactIncome;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil;
import com.idetronic.eis.service.base.FactDatabaseUsageLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactDatabaseUsageFinderUtil;
import com.idetronic.eis.service.persistence.FactDigitalCollectionFinderUtil;
import com.idetronic.eis.service.persistence.FactIncomeFinderUtil;
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
 * The implementation of the fact database usage local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactDatabaseUsageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactDatabaseUsageLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil
 */
public class FactDatabaseUsageLocalServiceImpl
	extends FactDatabaseUsageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil} to access the fact database usage local service.
	 */
	
	public void batchInsert(long libraryId,String period,JSONArray datas,
			ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long itemId = data.getLong("itemId");
			String download = data.getString("download");
			String session = data.getString("session");
			String search = data.getString("search");
			if (!Validator.isBlank(download) && !Validator.isBlank(session) && !Validator.isBlank(search))
			{
				add(libraryId,period,itemId,Long.parseLong(download),
						Long.parseLong(session),Long.parseLong(search), serviceContext);
				
			}
		}
		
		
		
		
		
		
	}
	
	public FactDatabaseUsage add(long libraryId, String period,long itemId,
			long download,long session,long search,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactDatabaseUsage.class.getName());
		
		
		
		FactDatabaseUsage fact = factDatabaseUsagePersistence.create(id);
		
		
		fact.setLibraryId(libraryId);
		fact.setPeriod(period);
		fact.setItemId(itemId);
		
		fact.setDownloadTotal(download);
		fact.setSessionTotal(session);
		fact.setSearchTotal(search);
		
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		fact.setUserId(user.getUserId());
		fact.setUserName(user.getFullName());
		fact.setCreateDate(new Date());
		
		
		return factDatabaseUsagePersistence.update(fact);
		
		
	}
	public List<FactDatabaseUsage> getLatestEntry(long libraryId,String period)
	{
		return FactDatabaseUsageFinderUtil.getLatestEntry(libraryId,period);
	}
	
	public JSONArray getEntries(long libraryId, String period)
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactDatabaseUsageFinderUtil.getHistory(libraryId, period);
		
		FactDatabaseUsage fact = null;
		MasterFile mst = null;
		
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactDatabaseUsage)arrayobject[0];
			mst = (MasterFile)arrayobject[1];
			
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			String entryType = "Perbelanjaan";
			String nameTitle = "Jenis Bahan";
			
			jsonObject.put("Pengguna", fact.getUserName());
			jsonObject.put("JenisText", entryType);
			jsonObject.put("id", mst.getMasterFileId());
			
			jsonObject.put("Jenis", mst.getMasterFileName());
			jsonObject.put("Download", fact.getDownloadTotal());
			jsonObject.put("Sessi", fact.getSessionTotal());
			jsonObject.put("Carian", fact.getSearchTotal());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
				
	}
	
	public boolean isMissingData(long libraryId, String period)
	{
		return FactDatabaseUsageFinderUtil.getDataCount(libraryId,period) == 0;
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(FactDatabaseUsageLocalServiceUtil.class);
}
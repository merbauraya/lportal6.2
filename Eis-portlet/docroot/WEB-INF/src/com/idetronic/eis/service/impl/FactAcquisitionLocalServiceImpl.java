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

import com.idetronic.eis.model.FactAcquisition;
import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactAcquisitionLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactAcquisitionFinderUtil;
import com.idetronic.eis.service.persistence.FactIrItemFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact acquisition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactAcquisitionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactAcquisitionLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactAcquisitionLocalServiceUtil
 */
public class FactAcquisitionLocalServiceImpl
	extends FactAcquisitionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactAcquisitionLocalServiceUtil} to access the fact acquisition local service.
	 */
	public FactAcquisition add(long facultyId,String period,long itemId, int titleTotal,int volumeTotal,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactAcquisition.class.getName());
		
		
		FactAcquisition factItem = factAcquisitionPersistence.create(id);
		
		
		factItem.setFacultyId(facultyId);
		factItem.setItemId(itemId);
		
		factItem.setPeriod(period);
		factItem.setTitleTotal(titleTotal);
		factItem.setVolumeTotal(volumeTotal);
		
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		factItem.setUserId(user.getUserId());
		factItem.setUserName(user.getFullName());
		factItem.setCreateDate(new Date());
		
		return factAcquisitionPersistence.update(factItem);
	}
	
	public void batchInsert(long facultyId,String period,
			JSONArray datas, ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long itemId = data.getLong("itemId");
			
			try
			{
				int titleTotal = Integer.parseInt(data.getString("titleTotal"));
				int volumeTotal = Integer.parseInt(data.getString("volumeTotal"));
			
				add(facultyId,period,itemId,titleTotal,volumeTotal,serviceContext);
			} catch (NumberFormatException ex){}
		}
	}
	
	public List<FactAcquisition> getLatestEntry(long facultyId,String period)
	{
		return FactAcquisitionFinderUtil.getLatestEntry(facultyId,period);
	}
	
	public JSONArray getEntries(long facultyId,String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactAcquisitionFinderUtil.getHistory(facultyId,period);
		
		FactAcquisition fact = null;
		MasterFile category = null;
		
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactAcquisition)arrayobject[0];
			category = (MasterFile)arrayobject[1];
			
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Judul", fact.getTitleTotal());
			jsonObject.put("Naskah", fact.getVolumeTotal());
			jsonObject.put("Jenis Bahan", category.getMasterFileName());
			jsonObject.put("Pengguna", fact.getUserName());
			
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
		
		
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(FactAcquisition.class);
}
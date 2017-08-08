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
import com.idetronic.eis.model.FactNonPrintedMaterial;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactIrItemLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactIrItemFinderUtil;
import com.idetronic.eis.service.persistence.FactIrSubmissionFinderImpl;
import com.idetronic.eis.service.persistence.FactNonPrintedMaterialFinderUtil;
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
 * The implementation of the fact ir item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactIrItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactIrItemLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactIrItemLocalServiceUtil
 */
public class FactIrItemLocalServiceImpl extends FactIrItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactIrItemLocalServiceUtil} to access the fact ir item local service.
	 */
	public FactIrItem add(long libraryId,long facultyId,String period,long itemTypeId, long itemMediumId,int titleTotal,int volumeTotal,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactIrItem.class.getName());
		
		
		FactIrItem factItem = factIrItemPersistence.create(id);
		
		factItem.setLibraryId(libraryId);
		factItem.setFacultyId(facultyId);
		factItem.setItemTypeId(itemTypeId);
		factItem.setItemMediumId(itemMediumId);
		factItem.setPeriod(period);
		factItem.setTitleTotal(titleTotal);
		factItem.setVolumeTotal(volumeTotal);
		
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		factItem.setCreatedByUserId(user.getUserId());
		factItem.setCreatedByUserName(user.getFullName());
		factItem.setCreatedDate(new Date());
		
		return factIrItemPersistence.update(factItem);
	}
	
	public void batchInsert(long libraryId,long facultyId,String period,
			JSONArray datas, ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long itemTypeId = data.getLong("itemTypeId");
			long itemMediumId = data.getLong("itemMediumId");
			try
			{
				int titleTotal = Integer.parseInt(data.getString("titleTotal"));
				int volumeTotal = Integer.parseInt(data.getString("volumeTotal"));
			
				add(libraryId,facultyId,period,itemTypeId,itemMediumId,titleTotal,volumeTotal,serviceContext);
			} catch (NumberFormatException ex){}
		}
	}
	
	public List<FactIrItem> getLatestEntry(long libraryId,long facultyId,String period)
	{
		return FactIrItemFinderUtil.getLatestEntry(libraryId,facultyId,period);
	}
	
	public JSONArray getEntries(long libraryId, String period,long facultyId) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactIrItemFinderUtil.getHistory(libraryId, period,facultyId);
		
		FactIrItem fact = null;
		MasterFile category = null;
		MasterFile medium = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			
			
			fact=(FactIrItem)arrayobject[0];
			category = (MasterFile)arrayobject[1];
			//medium = (MasterFile)arrayobject[2];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Judul", fact.getTitleTotal());
			jsonObject.put("Naskah", fact.getVolumeTotal());
			jsonObject.put("Jenis Bahan", category.getMasterFileName());
			jsonObject.put("Pengguna", fact.getCreatedByUserName());
			//jsonObject.put("Medium", medium.getMasterFileName());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreatedDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
		
		
	}
	
	public boolean isMissingData(long libraryId,String period) throws SystemException
	{
		List<FactIrItem> items = factIrItemPersistence.findByLibraryPeriod(libraryId, period);
		return (items.size() == 0);
		
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(FactIrItemLocalServiceImpl.class);

}
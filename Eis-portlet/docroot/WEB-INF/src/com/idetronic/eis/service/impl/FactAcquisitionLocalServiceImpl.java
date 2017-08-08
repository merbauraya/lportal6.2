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
import com.idetronic.eis.service.persistence.LibraryFinderUtil;
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
	public FactAcquisition add(long libraryId,long facultyId,String period,long itemId, 
			long titleTotal,long volumeTotal,double amountTotal,
			long approvedTitleTotal,long approvedVolumeTotal,double approvedAmountTotal,
			long orderTitleTotal,long orderVolumeTotal,double orderAmountTotal,
			ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactAcquisition.class.getName());
		
		
		FactAcquisition factItem = factAcquisitionPersistence.create(id);
		
		factItem.setLibraryId(libraryId);
		factItem.setFacultyId(facultyId);
		factItem.setItemId(itemId);
		
		factItem.setPeriod(period);
		
		//approved
		factItem.setApprovedTitleTotal(approvedTitleTotal);
		factItem.setApprovedAmountTotal(approvedAmountTotal);
		factItem.setApprovedVolumeTotal(approvedVolumeTotal);
		
		
		//ordered
		factItem.setOrderTitleTotal(orderTitleTotal);
		factItem.setOrderVolumeTotal(orderVolumeTotal);
		factItem.setOrderAmountTotal(orderAmountTotal);
		
		//received
		factItem.setTitleTotal(titleTotal);
		factItem.setVolumeTotal(volumeTotal);
		factItem.setAmountTotal(amountTotal);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		factItem.setUserId(user.getUserId());
		factItem.setUserName(user.getFullName());
		factItem.setCreateDate(new Date());
		
		return factAcquisitionPersistence.update(factItem);
	}
	
	public void batchInsert(long libraryId,long facultyId,String period,
			JSONArray datas, ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long itemId = data.getLong("itemId");
			
			try
			{
				long titleTotal = 0,volumeTotal = 0,approvedTitleTotal=0,approvedVolumeTotal=0,orderTitleTotal=0,orderVolumeTotal=0;
				double amountTotal = 0, approvedAmountTotal=0, orderAmountTotal=0;
				
				if (Validator.isNotNull(data.getString("titleTotal")))
				{
					titleTotal = data.getLong("titleTotal");
				}
				if (Validator.isNotNull(data.getString("volumeTotal")))
				{
					volumeTotal = data.getLong("volumeTotal");
				}
				if (Validator.isNotNull(data.getString("amountTotal")))
				{
					amountTotal = data.getDouble("amountTotal");
				}
				//
				if (Validator.isNotNull(data.getString("approvedTitleTotal")))
				{
					approvedTitleTotal = data.getLong("approvedTitleTotal");
				}
				if (Validator.isNotNull(data.getString("approvedVolumeTotal")))
				{
					approvedVolumeTotal = data.getLong("approvedVolumeTotal");
				}
				if (Validator.isNotNull(data.getString("approvedAmountTotal")))
				{
					approvedAmountTotal = data.getDouble("approvedAmountTotal");
				}
				if (Validator.isNotNull(data.getString("orderTitleTotal")))
				{
					orderTitleTotal = data.getLong("orderTitleTotal");
				}
				if (Validator.isNotNull(data.getString("orderVolumeTotal")))
				{
					orderVolumeTotal = data.getLong("orderVolumeTotal");
				}
				if (Validator.isNotNull(data.getString("orderAmountTotal")))
				{
					orderAmountTotal = data.getDouble("orderAmountTotal");
				}
				
				add(libraryId,facultyId,period,itemId,titleTotal,volumeTotal,amountTotal,
						approvedTitleTotal,approvedVolumeTotal, approvedAmountTotal,
						orderTitleTotal,orderVolumeTotal, orderAmountTotal,					
						serviceContext);
				
			} catch (NumberFormatException ex){}
		}
	}
	
	
	
	public List<FactAcquisition> getLatestEntry(long libraryId,long facultyId,String period)
	{
		return FactAcquisitionFinderUtil.getLatestEntry(libraryId,facultyId,period);
	}
	
	public JSONArray getEntries(long libraryId,long facultyId,String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactAcquisitionFinderUtil.getHistory(libraryId,facultyId,period);
		
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
			jsonObject.put("Penerimaan Judul", fact.getTitleTotal());
			jsonObject.put("Penerimaan Naskah", fact.getVolumeTotal());
			jsonObject.put("Penerimaan Amaun", fact.getAmountTotal());
			
			jsonObject.put("Kelulusan Cadangan Judul", fact.getApprovedTitleTotal());
			jsonObject.put("Kelulusan Cadangan Naskah", fact.getApprovedVolumeTotal());
			jsonObject.put("Kelulusan Cadangan Amaun", fact.getApprovedAmountTotal());
			
			jsonObject.put("Pesanan Pembelian Judul", fact.getOrderTitleTotal());
			jsonObject.put("Pesanan Pembelian Naskah", fact.getOrderVolumeTotal());
			jsonObject.put("Pesanan Pembelian Amaun", fact.getOrderAmountTotal());
			
			
			jsonObject.put("Jenis Bahan", category.getMasterFileName());
			jsonObject.put("Pengguna", fact.getUserName());
			
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
		
		
	}
	public boolean isMissingData(long libraryId, String period)
	{
		return FactAcquisitionFinderUtil.getItemCountByLibraryPeriod(libraryId,period) == 0;
	}
	
	public boolean isMissingData(String period)
	{
		//return LibraryFinderUtil.getPrintedItemCountByLibraryPeriod(libraryId,period) == 0;
		return FactAcquisitionFinderUtil.getItemCountByPeriod(period) == 0;
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(FactAcquisitionLocalServiceImpl.class);
}
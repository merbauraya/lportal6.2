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

import com.idetronic.eis.model.FactConsultation;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactConsultationLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactConsultationFinderUtil;
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
 * The implementation of the fact consultation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactConsultationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactConsultationLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactConsultationLocalServiceUtil
 */
public class FactConsultationLocalServiceImpl
	extends FactConsultationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactConsultationLocalServiceUtil} to access the fact consultation local service.
	 */
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactExpenseLocalServiceUtil} to access the fact expense local service.
	 */
	
	public void batchInsert(long libraryId,String period,JSONArray consultationCategoryIds,
			ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < consultationCategoryIds.length(); i++)
		{
			JSONObject data = consultationCategoryIds.getJSONObject(i);
			long categoryId = data.getLong("categoryId");
			String value = data.getString("value");
			String totalSession = data.getString("session");
			if (!Validator.isBlank(value))
			{
				if (Validator.isNull(totalSession))
				{
					totalSession = "0";
				}
				add(libraryId,period,categoryId,Long.parseLong(value),Long.parseLong(totalSession),serviceContext);
			}
		}
		
		
		
		
		
		
	}
	
	public FactConsultation add(long libraryId, String period,long categoryId,long value,long totalSession,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactConsultation.class.getName());
		
		FactConsultation consultation = factConsultationPersistence.create(id);
		
		
		consultation.setLibraryId(libraryId);
		
		consultation.setConsultationCategoryId(categoryId);
		consultation.setValue(value);
		consultation.setTotalSession(totalSession);
		consultation.setPeriod(period);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		consultation.setUserId(user.getUserId());
		consultation.setUserName(user.getFullName());
		consultation.setCreateDate(new Date());
		
		return factConsultationPersistence.update(consultation);
		
		
	}
	public List<FactConsultation> getLatestEntry(long libraryId,String period)
	{
		return FactConsultationFinderUtil.getLatestEntry(libraryId,period);
	}
	
	public JSONArray getEntries(long libraryId, String period)
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactConsultationFinderUtil.getHistory(libraryId, period);
		
		FactConsultation fact = null;
		MasterFile mst = null;
		
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactConsultation)arrayobject[0];
			mst = (MasterFile)arrayobject[1];
			
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
						
			jsonObject.put("Pengguna", fact.getUserName());
			jsonObject.put("Kategori", mst.getMasterFileName());
			jsonObject.put("KategoriId", mst.getMasterFileId());
			
			
			jsonObject.put("Jumlah Pengguna", fact.getValue());
			jsonObject.put("Jumlah Sessi", fact.getTotalSession());
			
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
				
	}
	public boolean isMissingData(long libraryId,String period)
	{
		return FactConsultationFinderUtil.getDataCount(libraryId,period) == 0;
	}
}
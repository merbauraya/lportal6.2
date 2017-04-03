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
import com.idetronic.eis.model.FactPrintedMaterial;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.model.State;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.StateLocalServiceUtil;
import com.idetronic.eis.service.stateLocalServiceUtil;
import com.idetronic.eis.service.base.FactPrintedMaterialLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactMembershipFinderUtil;
import com.idetronic.eis.service.persistence.FactPrintedMaterialFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the fact printed material local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactPrintedMaterialLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactPrintedMaterialLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil
 */
public class FactPrintedMaterialLocalServiceImpl
	extends FactPrintedMaterialLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil} to access the fact printed material local service.
	 */
	
	public void multiUpdate(long libraryId,String period,JSONArray jsonArray,ServiceContext serviceContext) throws SystemException, PortalException
	{
		for (int i = 0; i < jsonArray.length(); i++)
		{
			JSONObject data = jsonArray.getJSONObject(i);
			
			long itemTypeId = data.getLong("id");
			
			try
			{
				int volume = Integer.parseInt(data.getString("volume"));
				int title = Integer.parseInt(data.getString("title"));
				add (libraryId,period,itemTypeId,title,volume,serviceContext);
			} catch (NumberFormatException ex){}
			
			
			
		}
	}
	
	
	public List<FactPrintedMaterial> findByLibraryPeriod(long libraryId,String period,int start,int end) throws SystemException
	{
		if (Validator.isNull(period))
		{
			return factPrintedMaterialPersistence.findByLibrary(libraryId, start, end);
		}else
		{
			return factPrintedMaterialPersistence.findByLibraryPeriod(libraryId, period, start, end);
		}
	}
	
	public FactPrintedMaterial add(long libraryId,String period,long itemTypeId,int titleTotal,int volumeTotal,ServiceContext serviceContext) throws SystemException,PortalException
	{
		long id = CounterLocalServiceUtil.increment(FactPrintedMaterial.class.getName());
		
		Library library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
		State state = StateLocalServiceUtil.fetchState(library.getStateId());
		FactPrintedMaterial fact = factPrintedMaterialPersistence.create(id);
		
		fact.setLibraryId(libraryId);
		fact.setItemTypeId(itemTypeId);
		fact.setLibraryCode(library.getLibraryCode());
		fact.setStateId(library.getStateId());
		fact.setStateCode(state.getStateCode());
		fact.setPeriod(period);
		fact.setTitleTotal(titleTotal);
		fact.setVolumeTotal(volumeTotal);
		
		fact.setLibraryTypeId(library.getLibraryTypeId());
		
		int year = Integer.valueOf(period.substring(0,4));
		int month = Integer.valueOf(period.substring(4, 6));
		
		fact.setYearVal(year);
		fact.setMonthVal(month);
		
		User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
		
		fact.setCreatedByUserId(serviceContext.getUserId());
		fact.setCreatedByUserName(user.getFullName());
		fact.setDateCreated(new Date());
		
		return factPrintedMaterialPersistence.update(fact);
		
	}
	public FactPrintedMaterial getLatestEntry(long libraryId,String period,long itemTypeId)
	{
		return FactPrintedMaterialFinderUtil.getLatestEntry(libraryId, period, itemTypeId);
	}
	public List<FactPrintedMaterial> getLatestEntry(long libraryId,String period)
	{
		return FactPrintedMaterialFinderUtil.getLatestEntry(libraryId, period);
	}
	public JSONArray getEntries(long libraryId, String period) throws SystemException
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactPrintedMaterialFinderUtil.getHistory(libraryId, period);
		
		FactPrintedMaterial fact = null;
		ItemType category = null;
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactPrintedMaterial)arrayobject[0];
			category = (ItemType)arrayobject[1];
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			jsonObject.put("Judul", fact.getTitleTotal());
			jsonObject.put("Naskah", fact.getVolumeTotal());
			jsonObject.put("Jenis Bahan", category.getItemTypeName());
			jsonObject.put("Pengguna", fact.getCreatedByUserName());
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getDateCreated()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
		
		
	}
}
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

import com.idetronic.eis.model.FactExpense;
import com.idetronic.eis.model.FactIncome;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactIncomeLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactExpenseFinderUtil;
import com.idetronic.eis.service.persistence.FactIncomeFinderUtil;
import com.idetronic.eis.util.EisUtil;
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
 * The implementation of the fact income local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactIncomeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactIncomeLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactIncomeLocalServiceUtil
 */
public class FactIncomeLocalServiceImpl extends FactIncomeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactIncomeLocalServiceUtil} to access the fact income local service.
	 */
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactExpenseLocalServiceUtil} to access the fact expense local service.
	 */
	
	public void batchInsert(long libraryId,String period,JSONArray datas,
			ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < datas.length(); i++)
		{
			JSONObject data = datas.getJSONObject(i);
			long incomeTypeId = data.getLong("incomeId");
			String amount = data.getString("amount");
			if (!Validator.isBlank(amount))
			{
				add(libraryId,period,incomeTypeId,Double.parseDouble(amount),serviceContext);
			}
		}
		
		
		
		
		
		
	}
	
	public FactIncome add(long libraryId, String period,long incomeTypeId,double amount,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactIncome.class.getName());
		
		FactIncome income = factIncomePersistence.create(id);
		
		
		income.setLibraryId(libraryId);
		
		income.setItemId(incomeTypeId);
		income.setTotal(amount);
		
		income.setPeriod(period);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		income.setUserId(user.getUserId());
		income.setUserName(user.getFullName());
		income.setCreateDate(new Date());
		
		return factIncomePersistence.update(income);
		
		
	}
	public List<FactIncome> getLatestEntry(long libraryId,String period)
	{
		return FactIncomeFinderUtil.getLatestEntry(libraryId,period);
	}
	
	public JSONArray getEntries(long libraryId, String period)
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactIncomeFinderUtil.getHistory(libraryId, period);
		
		FactIncome fact = null;
		MasterFile mst = null;
		
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactIncome)arrayobject[0];
			mst = (MasterFile)arrayobject[1];
			
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			String entryType = "Perbelanjaan";
			String nameTitle = "Jenis Bahan";
			
			jsonObject.put("Pengguna", fact.getUserName());
			
			
			jsonObject.put("Jenis", mst.getMasterFileName());
			jsonObject.put("Jumlah", fact.getTotal());
			
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
				
	}
	public boolean isMissingData(long libraryId, String period)
	{
		return FactIncomeFinderUtil.getDataCount(libraryId,period) == 0;
	}
}
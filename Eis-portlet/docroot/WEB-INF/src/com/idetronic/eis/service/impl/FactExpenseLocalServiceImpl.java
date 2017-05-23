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
import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.base.FactExpenseLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.FactExpenseFinderUtil;
import com.idetronic.eis.service.persistence.FactIrItemFinderUtil;
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
 * The implementation of the fact expense local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.FactExpenseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.FactExpenseLocalServiceBaseImpl
 * @see com.idetronic.eis.service.FactExpenseLocalServiceUtil
 */
public class FactExpenseLocalServiceImpl extends FactExpenseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.FactExpenseLocalServiceUtil} to access the fact expense local service.
	 */
	
	public void batchInsert(long libraryId,String period,JSONArray allocationArray,
			JSONArray expenseArray,ServiceContext serviceContext) throws SystemException
	{
		
		for (int i = 0; i < allocationArray.length(); i++)
		{
			JSONObject data = allocationArray.getJSONObject(i);
			long allocationId = data.getLong("allocationId");
			String amount = data.getString("amount");
			if (!Validator.isBlank(amount))
			{
				add(libraryId,period,EisUtil.EXPENSE_TYPE_ALLOCATION,allocationId,Double.parseDouble(amount),serviceContext);
			}
		}
		
		for (int i = 0; i < expenseArray.length(); i++)
		{
			JSONObject data = expenseArray.getJSONObject(i);
			long itemId = data.getLong("itemId");
			String amount = data.getString("amount");
			if (!Validator.isBlank(amount))
			{
				add(libraryId,period,EisUtil.EXPENSE_TYPE_EXPENSE,itemId,Double.parseDouble(amount),serviceContext);
			}
			
		}
		
		
		
		
	}
	
	public FactExpense add(long libraryId, String period,int expenseType,long masterFileId,double amount,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(FactExpense.class.getName());
		
		FactExpense expense = factExpensePersistence.create(id);
		
		
		expense.setLibraryId(libraryId);
		
		expense.setMasterFileId(masterFileId);
		expense.setAmount(amount);
		expense.setEntryType(expenseType);
		expense.setPeriod(period);
		
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		expense.setUserId(user.getUserId());
		expense.setUserName(user.getFullName());
		expense.setCreateDate(new Date());
		
		return factExpensePersistence.update(expense);
		
		
	}
	public List<FactExpense> getLatestEntry(long libraryId,String period)
	{
		return FactExpenseFinderUtil.getLatestEntry(libraryId,period);
	}
	
	public JSONArray getEntries(long libraryId, String period)
	{
		//return factVisitorPersistence.findByLibraryPeriod(libraryId, period);
		List list = FactExpenseFinderUtil.getHistory(libraryId, period);
		
		FactExpense fact = null;
		MasterFile mst = null;
		
		
		JSONArray jsonData =   JSONFactoryUtil.createJSONArray();
		
		int i = 0;
		
		for(Object object:list)
		{
			Object[] arrayobject=(Object[])object;
			fact=(FactExpense)arrayobject[0];
			mst = (MasterFile)arrayobject[1];
			
			
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			i++;
			
			
			
			
			jsonObject.put("Bil", i);
			String entryType = "Perbelanjaan";
			String nameTitle = "Jenis Bahan";
			if (fact.getEntryType() == EisUtil.EXPENSE_TYPE_ALLOCATION)
			{
				entryType="Peruntukan";
				nameTitle = "Sumber";
			}
			jsonObject.put("Pengguna", fact.getUserName());
			jsonObject.put("JenisText", entryType);
			jsonObject.put("id", mst.getMasterFileId());
			jsonObject.put("Jenis", fact.getEntryType());
			jsonObject.put("Sumber/Bahan", mst.getMasterFileName());
			jsonObject.put("Jumlah", fact.getAmount());
			
			
			String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
			
			jsonObject.put("Tarikh", format.format(fact.getCreateDate()));
			jsonData.put(jsonObject);

			
			
		}
		return jsonData;
				
	}
}
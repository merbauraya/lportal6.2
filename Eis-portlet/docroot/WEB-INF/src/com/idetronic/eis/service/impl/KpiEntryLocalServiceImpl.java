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

import java.util.List;

import com.idetronic.eis.NoSuchKpiEntryException;
import com.idetronic.eis.model.KpiEntry;
import com.idetronic.eis.model.KpiType;

import com.idetronic.eis.service.KpiTypeLocalServiceUtil;
import com.idetronic.eis.service.base.KpiEntryLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the kpi entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.KpiEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.KpiEntryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.KpiEntryLocalServiceUtil
 */
public class KpiEntryLocalServiceImpl extends KpiEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.KpiEntryLocalServiceUtil} to access the kpi entry local service.
	 */
	
	public KpiEntry add(long kpiTypeId,String year,int periodType,String period,double value,double actual) throws SystemException
	{
		KpiEntry kpiEntry = null;
		try {
			kpiEntry = kpiEntryPersistence.findByTypePeriod(kpiTypeId, periodType, period);
		} catch (NoSuchKpiEntryException e) {
			
		}
		
		if (Validator.isNull(kpiEntry))
		{
			long id = CounterLocalServiceUtil.increment(KpiEntry.class.getName());
			
			kpiEntry = kpiEntryPersistence.create(id);
		}
			
			
		kpiEntry.setKpiTypeId(kpiTypeId);
		kpiEntry.setPeriodType(periodType);
		kpiEntry.setPeriod(period);
		kpiEntry.setValue(value);
		kpiEntry.setActual(actual);
		
		kpiEntry.setPeriodYear(year);
		
		
		return kpiEntryPersistence.update(kpiEntry);
	}
	public void batchInsert(long kpiTypeId,String year,JSONArray datas,ServiceContext serviceContext) throws SystemException
	{
		//KpiType kpiType = KpiTypeLocalServiceUtil.getKpiType(kpiTypeId);
		KpiType kpiType = KpiTypeLocalServiceUtil.fetchKpiType(kpiTypeId);
		
		
		
		for (int i = 0; i < datas.length(); i ++)
		{
			double manualValue = 0;
			JSONObject data = datas.getJSONObject(i);
			int periodType = data.getInt("periodType");
			if (kpiType.getManualValue())
			{
				if (Validator.isNotNull(data.getString("actual")))
				{
					manualValue = data.getDouble("actual");
					LOGGER.info("manuval="+manualValue);
				}else
				{
					LOGGER.info("not number manuval="+data.getString("actual"));
				}
			}
			
			add(kpiTypeId,year,periodType,data.getString("period"),data.getDouble("value"),manualValue);
			
		}
	}
	public List<KpiEntry> findByYearPeriodType(long kpiTypeId,String year,int periodType) throws SystemException
	{
		return kpiEntryPersistence.findByYearType(kpiTypeId, year, periodType);
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(KpiEntryLocalServiceImpl.class);

}
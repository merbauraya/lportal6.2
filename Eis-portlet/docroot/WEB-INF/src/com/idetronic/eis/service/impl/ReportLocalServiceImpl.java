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

import com.idetronic.eis.NoSuchReportException;
import com.idetronic.eis.model.Report;
import com.idetronic.eis.service.base.ReportLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.ReportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.ReportLocalServiceBaseImpl
 * @see com.idetronic.eis.service.ReportLocalServiceUtil
 */
public class ReportLocalServiceImpl extends ReportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.ReportLocalServiceUtil} to access the report local service.
	 */
	
	public Report addReport(String reportKey,String reportName,String reportTitle,boolean hasDataEntry,boolean hqDataEntry) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(Report.class.getName());
		Report report = createReport(id);
		
		report.setReportKey(reportKey);
		report.setReportName(reportName);
		report.setReportTitle(reportTitle);
		report.setDataEntry(hasDataEntry);
		report.setHqDataEntry(hqDataEntry);
		return updateReport(report);
		
	}
	public List<Report> findByDataEntry(boolean dataEntry,boolean hqDataEntry) throws SystemException
	{
		return reportPersistence.findBydataEntry(dataEntry,hqDataEntry);
	}
	
	public List<Report> findMainReport() throws SystemException
	{
		return reportPersistence.findBymainReport(true);
	}
	public Report findByKey(String reportKey) throws NoSuchReportException, SystemException
	{
		return reportPersistence.findByKey(reportKey);
	}
	
}
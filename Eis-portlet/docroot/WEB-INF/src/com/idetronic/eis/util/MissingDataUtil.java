package com.idetronic.eis.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.model.Report;
import com.idetronic.eis.model.UserLibrary;
import com.idetronic.eis.model.UserReport;
import com.idetronic.eis.service.FactAcquisitionLocalServiceUtil;
import com.idetronic.eis.service.FactConsultationLocalServiceUtil;
import com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil;
import com.idetronic.eis.service.FactDigitalCollectionLocalServiceUtil;
import com.idetronic.eis.service.FactIncomeLocalServiceUtil;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.MasterFileLocalServiceUtil;
import com.idetronic.eis.service.ReportLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.idetronic.eis.service.UserReportLocalServiceUtil;
import com.idetronic.eis.service.persistence.FactConsultationFinderUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sun.istack.internal.logging.Logger;

public class MissingDataUtil {
	
	
	/**
	 * Returns a map consist of user and their missing data. This is normally called from notification service.
	 * @param period
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static Map getUserMissingData(String period) throws SystemException, PortalException
	{
		//List<UserLibrary> userLibraries = UserLibraryLocalServiceUtil.getUserLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		Map userMap = new HashMap();
		
		List<Object> userIds = UserLibraryLocalServiceUtil.getDistinctUser();
		for (Object userIdObj : userIds)
		{
			long userId = (long)userIdObj;
			User user = UserLocalServiceUtil.getUser(userId);
			
			if (!userMap.containsKey(userId))
			{
				
				//we check for all libraries
				ArrayList missingData = getMissingUserData(user.getUserId(), period, user.getLocale(),0,false,false);
				if (missingData.size()>0)
				{
					userMap.put(userId, missingData);
				}
			}
		}
		
		
		
		return userMap;
	}
	
	public static ArrayList getUserMissingData(long userId,String period,Locale locale,long libraryId,boolean isAdmin,boolean adminAllowAllLibrary) throws SystemException, PortalException 
	{
		if (isAdmin && adminAllowAllLibrary)
		{
			return getMissingUserData(userId, period, locale,libraryId,true,true);
			
		}else
		{
			return getMissingUserData(userId, period, locale,libraryId,false,false);
		}
		
	}
	public static ArrayList getUserMissingData(long userId,String period,Locale locale,long libraryId) throws SystemException, PortalException
	{
		//List<UserLibrary> userLibraries = UserLibraryLocalServiceUtil.getUserLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		Map userMap = new HashMap();
		
		
				
		ArrayList missingData = getMissingUserData(userId, period, locale,libraryId,false,false);
		return missingData;
		
		
		
	}
	private static ArrayList getMissingUserData(long userId,String period,Locale locale,long libraryId,boolean isAdmin,boolean adminAllowAllLibrary) throws SystemException, PortalException
	{
		ArrayList list = new ArrayList();
		
		List<MasterFile> libraries = null;
		
		
		if (isAdmin && adminAllowAllLibrary)
		{
			if (Validator.isNull(libraryId))
			{
				libraries = MasterFileLocalServiceUtil.getAllLibraries();
			}else
			{
				MasterFile library = MasterFileLocalServiceUtil.getMasterFile(libraryId);
				libraries = new ArrayList<MasterFile>();
				libraries.add(library);
			}
			
		}else //normal user
		{
			if (Validator.isNull(libraryId)) //if library is not specified, we retrieve all library for that user
			{
				libraries = UserLibraryLocalServiceUtil.getLibraryByUser2(userId);
			}else 
			{
				MasterFile library = MasterFileLocalServiceUtil.getMasterFile(libraryId);
				libraries = new ArrayList<MasterFile>();
				libraries.add(library);
				
			}
		}
		
		
		for (MasterFile library : libraries)
		{
			
			
			if (isAdmin && adminAllowAllLibrary)
			{
				List<Report> reports = ReportLocalServiceUtil.getReports(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				for (Report report : reports)
				{
					if (!report.getHqDataEntry()) //only check for non hq report
					{
						Map missingData = checkReportForMissingData(report,library.getMasterFileId(),period,locale,library.getMasterFileName());
						if (Validator.isNotNull(missingData))
						{
							list.add(missingData);
						}
					}
				}
			}else
			{
				//get user data for the library
				List<UserReport> userReports = UserReportLocalServiceUtil.findByUserLibrary(userId, library.getMasterFileId());
				
				for (UserReport userReport : userReports)
				{
					Report report = ReportLocalServiceUtil.fetchReport(userReport.getReportId());
					
					if (!report.getHqDataEntry()) //only check for non hq report
					{
						Map missingData = checkReportForMissingData(report,library.getMasterFileId(),period,locale,library.getMasterFileName());
						if (Validator.isNotNull(missingData))
						{
							list.add(missingData);
						}
					}
					
					
			
				}
			} //end normal user
			
		}
		
		//check for user with HQ report (no library assignment,libraryId = 0)
		List<UserReport> userReports = UserReportLocalServiceUtil.findByUserLibrary(userId, 0);
		for (UserReport userReport : userReports)
		{
			Report report = ReportLocalServiceUtil.getReport(userReport.getReportId());
			Map missingData = checkHqReportForMissingData(report,period,locale);
			if (Validator.isNotNull(missingData))
			{
				list.add(missingData);
			}
		}
		
		return list;
	} 
	
	/**
	 * Check missing data for HQ report.
	 * @param report - Report Type (HQ Type only)
	 * @param period - Period to check
	 * @param locale - Locale 
	 * @return
	 */
	private static Map checkHqReportForMissingData(Report report,String period,Locale locale)
	{
		Map data = null;
		String libraryName = LanguageUtil.get(locale, "hq-library");
		long libraryId = 0;
		
		
		if (report.getReportKey().equals(EisUtil.REPORT_DATABASE_USAGE))
		{
			data  = getMissingDatabaseUsage(libraryId,period,locale,libraryName);
		}
		if (report.getReportKey().equals(EisUtil.REPORT_DIGITAL_COLLECTION))
		{
			data  = getMissingDigitalCollection(libraryId,period,locale,libraryName);
		}
		if (report.getReportKey().equals(EisUtil.REPORT_IR))
		{
			
			data = getMIssingIRItem(libraryId,period,locale,libraryName);
			
		}
		return data;
	}
	
	/**
	 * Check non HQ Report for Missing Data
	 * @param report
	 * @param libraryId
	 * @param period
	 * @param locale
	 * @param libraryName
	 * @return
	 */
	private static Map checkReportForMissingData(Report report,long libraryId,String period,Locale locale,String libraryName)
	{
		//LOGGER.info(report.getReportKey() +" :library :" + library.getMasterFileId() + " : " + library.getMasterFileName() + ":"+ report.getReportTitle());
		
		Map data = null;
		
		if (report.getReportKey().equals(EisUtil.REPORT_EXPENSE))
		{
			data  = getMissingExpense(libraryId,period,locale,libraryName);
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_IR))
		{
			data = getMIssingIRItem(libraryId,period,locale,libraryName);
	
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_LOAN))
		{
			data  = getMissingLoan(libraryId,period,locale,libraryName);
		
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_MEMBERSHIP))
		{
			data  = getMissingMembership(libraryId,period,locale,libraryName);
		
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_NON_PRINTED_ITEM))
		{

			data = getMissingNonPrintedItem(libraryId,period,locale,libraryName);
			
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_POSITION))
		{
			data = getMissingPosition(libraryId,period,locale,libraryName);
			
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_PRINTED_ITEM))
		{
			data = getMissingPrintedItem(libraryId,period,locale,libraryName);
			
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_SEATING))
		{
			data = getMissingSeating(libraryId,period,locale,libraryName);
			
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_VISITOR))
		{
			data  = getMissingVisitor(libraryId,period,locale,libraryName);
			
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_ACADEMIC_CONSULTATION))
		{
			data  = getMissingAcademicConsultation(libraryId,period,locale,libraryName);
			
			
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_ACQUISITION))
		{
			data  = getMissingAcquisition(libraryId,period,locale,libraryName);
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_INCOME))
		{
			data  = getMissingIncome(libraryId,period,locale,libraryName);
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_DATABASE_USAGE))
		{
			data  = getMissingDatabaseUsage(libraryId,period,locale,libraryName);
		}
		
		if (report.getReportKey().equals(EisUtil.REPORT_DIGITAL_COLLECTION))
		{
			data  = getMissingDigitalCollection(libraryId,period,locale,libraryName);
		}
		
		return data;
	}
	
	public static Map getMissingDigitalCollection(long libraryId,String period,Locale locale,String libraryName)
	{
		if (FactDigitalCollectionLocalServiceUtil.isMissingData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_DIGITAL_COLLECTION,libraryId, 
					period,LanguageUtil.get(locale, "digital-collection"),
					libraryName);
			
			
		}else
		{
			return null;
		}
					
		
	}
	
	public static Map getMissingDatabaseUsage(long libraryId,String period,Locale locale,String libraryName)
	{
		if (FactDatabaseUsageLocalServiceUtil.isMissingData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_DATABASE_USAGE,libraryId, 
					period,LanguageUtil.get(locale, "database-usage"),
					libraryName);
			
			
		}else
		{
			return null;
		}
					
		
	}
	
	public static Map getMissingIncome(long libraryId,String period,Locale locale,String libraryName)
	{
		if (FactIncomeLocalServiceUtil.isMissingData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_INCOME,libraryId, 
					period,LanguageUtil.get(locale, "income"),
					libraryName);
			
			
		}else
		{
			return null;
		}
					
		
	}
	
	public static Map getMissingAcquisition(long libraryId,String period,Locale locale,String libraryName)
	{
		if (FactAcquisitionLocalServiceUtil.isMissingData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_ACQUISITION,libraryId, 
					period,LanguageUtil.get(locale, "acquisition"),
					libraryName);
			
			
		}else
		{
			return null;
		}
					
		
	}
	
	public static Map getMissingAcademicConsultation(long libraryId,String period,Locale locale,String libraryName)
	{
		if (FactConsultationLocalServiceUtil.isMissingData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_ACADEMIC_CONSULTATION,libraryId, 
					period,LanguageUtil.get(locale, "consultation"),
					libraryName);
			
			
		}else
		{
			return null;
		}
					
		
	}
	
	public static Map getMIssingIRItem(long libraryId,String period,Locale locale,String libraryName)
	{
		if (LibraryLocalServiceUtil.isMissingIRItemData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_IR,libraryId,
					period,LanguageUtil.get(locale, "ir-item"),
					libraryName);
			
			
		}else
		{
			return null;
		}
					
		
	}
	
	public static Map getMissingPrintedItem(long libraryId,String period,Locale locale,String libraryName)
	{
		if (LibraryLocalServiceUtil.isMissingPrintedItemData(libraryId,period))
		{
			
			return createMissingDataMap(EisUtil.DATA_PRINTED_MATERIAL,libraryId,
					period,LanguageUtil.get(locale, "printed-item"),
					libraryName);
			
			
		}else
		{
			return null;
		}
		
		
		
		
	}
	public static Map getMissingNonPrintedItem(long libraryId,String period,Locale locale,String libraryName)
	{
		
		if (LibraryLocalServiceUtil.isMissingNonPrintedItemData(libraryId, period))
		{
			
			
			return createMissingDataMap(EisUtil.DATA_NON_PRINTED_MATERIAL,libraryId,
					period,LanguageUtil.get(locale, "rpt-non-printed-item-type"),
					libraryName);
			
		}else
		{
			return null;
		}
	}
	
	public static Map getMissingPosition(long libraryId,String period,Locale locale,String libraryName)
	{
		
		if (LibraryLocalServiceUtil.isMissingPositionData(libraryId, period))
		{
			return createMissingDataMap(EisUtil.DATA_POSITION,libraryId,
					period,LanguageUtil.get(locale, "job-post"),
					libraryName);
			
		}else
		{
			return null;
		}
	}
	
	public static Map getMissingExpense(long libraryId,String period,Locale locale,String libraryName)
	{
		if (LibraryLocalServiceUtil.isMissingExpenseData(libraryId, period))
		{
			return createMissingDataMap(EisUtil.DATA_EXPENSE,libraryId,
					period,LanguageUtil.get(locale, "expense"),
					libraryName);
			
		}else
		{
			return null;
		}
	}
	
	public static Map getMissingLoan(long libraryId,String period,Locale locale,String libraryName)
	{
		
		if (LibraryLocalServiceUtil.isMissingLoanData(libraryId, period))
		{
			return createMissingDataMap(EisUtil.DATA_LOAN,libraryId,
					period,LanguageUtil.get(locale, "loan"),
					libraryName);
			
		}else
		{
			return null;
		}
	}
	public static Map getMissingVisitor(long libraryId,String period,Locale locale,String libraryName)
	{
		
		if (LibraryLocalServiceUtil.isMissingVisitorData(libraryId, period))
		{
			return createMissingDataMap(EisUtil.DATA_VISITOR,libraryId,
					period,LanguageUtil.get(locale, "visitor"), 
					libraryName);
			
		}else
		{
			return null;
		}
	}
	public static Map getMissingMembership(long libraryId,String period,Locale locale,String libraryName)
	{
		
		if (LibraryLocalServiceUtil.isMissingMembershipData(libraryId, period))
		{
			return createMissingDataMap(EisUtil.DATA_MEMBERSHIP,libraryId,
					period,LanguageUtil.get(locale, "membership"),
					libraryName);
			
		}else
		{
			return null;
		}
	}
	public static Map getMissingSeating(long libraryId,String period,Locale locale,String libraryName)
	{
		
		if (LibraryLocalServiceUtil.isMissingSeatingData(libraryId, period))
		{
			return createMissingDataMap(EisUtil.DATA_SEATING,libraryId,
					period,LanguageUtil.get(locale, "seating"),
					libraryName);
			
		}else
		{
			return null;
		}
	}
	
	private static Map createMissingDataMap(int dataId,long libraryId,String period,String dataName,String libraryName)
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("dataId", String.valueOf(dataId));
		map.put("libraryId", String.valueOf(libraryId));
		map.put("period", String.valueOf(period));
		map.put("dataName", dataName);
		map.put("libraryName", libraryName);
		return map;
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(MissingDataUtil.class);
}

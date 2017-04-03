package com.idetronic.eis.util;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import com.idetronic.eis.NoSuchLibraryException;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.portlet.EisPortlet;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.idetronic.eis.service.persistence.LibraryFinderUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;


public class EisUtil {
	
	public static final String RESOURCE_PRINTED_MATERIAL_DATA_LIST = "printedMaterialDataList";
	public static final String RESOURCE_STRATEGY_LIST_JSON = "projectStrategyListJson";
	public static final String RESOURCE_ACTIVITY_LIST= "activityList";
	public static final String RESOURCE_NON_PRINTED_ITEM_DATA = "nonPrintedItemData";
	public static final String RESOURCE_LOAN_DATA = "loanData";
	public static final String RESOURCE_POST_DATA = "postData"; 
	public static final String RESOURCE_VISITOR_DATA = "visitorData"; 
	public static final String RESOURCE_VISITOR_DATA_HISTORY = "visitorDataHistory"; 
	public static final String RESOURCE_IR_SUBMISSION_DATA = "IRSubmissionData";
	public static final String RESOURCE_IR_ITEM = "irItem";
	public static final String RESOURCE_SEATING_DATA_LIST ="seatingData";
	public static final String RESOURCE_MEMBERSHIP_DATA = "membershipData";
	
	public static final String RESOURCE_KPI_ENTRY_DATA = "kpientryData";
	/*
	 * month range 1 to 12
	 */
	
	/* status */
	public static final int STATUS_RED=1;
	public static final int STATUS_YELLOW=2;
	public static final int STATUS_GREEN = 3;
	public static final int STATUS_ARCHIVE = 4;
	
	
	/* printed non printed type */
	public static final int ITEM_TYPE_NOT_APPLICABLE = 0;
	public static final int ITEM_TYPE_PRINTED = 1;
	public static final int ITEM_TYPE_NON_PRINTED = 2;
	
	/* Config */
	public static final String KEY_CONFIG= "EisConfig";
	public static final String KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_SUBJECT = "firstNotificationSubject";
	public static final String KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_BODY = "firstNotificationBody";
	public static final String KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_SUBJECT = "secondNotificationSubject";
	public static final String KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_BODY = "secondNotificationBody";
	public static final String KEY_CONFIG_EMAIL_FROM_ADDRESS = "emailFromAddress";
	public static final String KEY_CONFIG_EMAIL_FROM_NAME = "emailFromName";
	public static final String KEY_CONFIG_REMINDER_1ST_SEND_CONTINUOUSLY = "reminder.first.continuous";
	public static final String KEY_CONFIG_REMINDER_2ND_SEND_CONTINUOUSLY = "reminder.second.continuous";
	public static final String KEY_CONFIG_ENABLE_EMAIL_NOTIFICATION = "reminder.email.enabled";
	public static final String KEY_DATA_LATEST_PERIOD = "data.latest.period";
	public static final String KEY_KPI_SETTING_RANGE = "kpi.setting.range";
	
	
	public static final String CONFIG_EMAIL_TEMPLATE = "email.template";
	public static final String CONFIG_PERIOD_ALLOW_PREVIOUS = "period.allow.previous";
	public static final String CONFIG_PERIOD_MIN_YEAR = "period.min.year";
	public static final String CONFIG_PERIOD_MAX_YEAR = "period.max.year";
	public static final String CONFIG_PERIOD_USE_YEAR_RANGE= "period.year.range";
	public static final String CONFIG_PERIOD_NUM_YEAR_BACK = "period.num.year.back";
	public static final String CONFIG_PERIOD_NUM_YEAR_FWD = "period.num.year.fwd";
	public static final String CONFIG_PERIOD_USE_MONTH_NAME = "period.use.month.name";
	public static final String CONFIG_LIBRARY_ADMIN_ALLOW_ALL = "library.admin.allow.all";
	public static final String CONFIG_MEMBERSHIP_GROUP = "membershipGroup";
	public static final String CONFIG_ALLOW_FUTURE_PERIOD = "period.allow.future";

	
	public static final String KEY_CONFIG_REMINDER = "reminder";
	public static final String CONFIG_DATA_DUE_DAY = "data.due.day";
	public static final String CONFIG_REMINDER_DAY_1ST = "reminder.day.first";
	public static final String CONFIG_REMINDER_DAY_1ST_UNTIL = "reminder.day.first.until";
	public static final String CONFIG_REMINDER_DAY_2ND = "reminder.day.second";
	public static final String CONFIG_REMINDER_DAY_2ND_UNTIL = "reminder.day.second.until";
	public static final String CONFIG_REMINDER_OPTION = "reminder.option";
	public static final String CONFIG_MONTH_DATA_CUT_OFF_DAY = "month.data.cut.off.day";

	
	public static final int DATA_ALL_DATA = -1;
	public static final int DATA_IR = 10;
	public static final int DATA_PRINTED_MATERIAL = 11;
	public static final int DATA_NON_PRINTED_MATERIAL = 12;
	public static final int DATA_POSITION = 13;
	public static final int DATA_SEATING = 14;
	public static final int DATA_VISITOR = 15;
	public static final int DATA_LOAN = 16;
	public static final int DATA_MEMBERSHIP =17;
	
	
	public static final int KPI_MONTHLY = 1;
	
	public static final int KPI_QUARTERLY = 2;
	public static final int KPI_SEMI_ANUALLY = 3;
	public static final int KPI_YEARLY = 4;
	
	public static final String getKPIType(int kpi,Locale locale)
	{
		String text = StringPool.BLANK;
		switch (kpi)
		{
		case KPI_MONTHLY:
			text=LanguageUtil.get(locale, "monthly");
			break;
			
		case KPI_YEARLY:
			text=LanguageUtil.get(locale, "yearly");
			break;
			
		case KPI_QUARTERLY:
			text = LanguageUtil.get(locale, "quarterly");
			break;
		
		case KPI_SEMI_ANUALLY:
			text = LanguageUtil.get(locale, "semi-anually");
			break;
		}
		
		return text;
	}
	
	public static String getMonthName(int month)
	{
		String name = StringPool.BLANK;
		month--;
		DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (month >= 0 && month <= 11 ) {
            name = months[month];
        }
        return name;
	}
	
	public static String getPeriodString(String periodYear)
	{
		int year = Integer.parseInt(periodYear.substring(0, 4));
		int month = Integer.parseInt(periodYear.substring(4));
		
		
		return getMonthName (month) + " " + year;
	}
	
	public static JSONArray getLibraryByState(long stateId) throws SystemException
	{
		List<Library> libraries = LibraryLocalServiceUtil.findByState(stateId,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (Library library : libraries)
		{
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();  
			jsonObject.put("libraryId",library.getLibraryId() ); 
            jsonObject.put("libraryName", library.getLibraryName());
            jsonArray.put(jsonObject);
		}
		
		return  jsonArray;
	
	}
	
	public static String getProgressStatusText(int value)
	{
		String ret = "<span class='badge'>Belum Bermula</span>";
		switch (value)
		{
			case 1: ret = "<span class='badge'>Belum Bermula</span>";
				break;
			
			case 2: ret = "<span class='badge status-ongoing'>Bermula</span>";
				break;
			
			case 3: ret = "<span class='badge status-end'>Tamat</span>";
				break;
				
		
		}
		
		return ret;
		
	}
	
	public static String dateDisplay(Date value)
	{
		if (Validator.isNull(value))
			return StringPool.BLANK;
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(value);
		

	}
	
	public static String getCurrentPeriod()
	{
		Calendar cal = CalendarFactoryUtil.getCalendar();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) ; //0 based
		
		
		month = month +1;
		
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append(String.format("%02d", month));
		return sb.toString();
		
		
		
	}
	
	
	public static String getPreviousPeriod()
	{
		Calendar cal = CalendarFactoryUtil.getCalendar();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) ; //0 based
		
		if (month == 0) // january
		{
			return String.valueOf(year-1) +"12";
		}else
		{
			StringBuilder sb = new StringBuilder();
			sb.append(year);
			sb.append(String.format("%02d", month));
			return sb.toString();
		}
		
		
	}
	
	
	
	public static List<User> missingData()
	{
		String period = getPreviousPeriod();
		
		
		
		return null;
	}
	public static List<Library> getMissingPrintedMaterial(String period)
	{
		List<Library> libraries = LibraryFinderUtil.findMissingPrintedMaterialDataByPeriod(period);
		
		
		return libraries;
	}
	public static ArrayList getMissingData(long userId,String period,Locale locale,boolean isAdmin,long libraryId,long dataType) throws SystemException, NoSuchLibraryException
	{
		List<Library> libraries = null;
		if (Validator.isNull(libraryId))
		{
			if (isAdmin)
			{
				libraries = LibraryLocalServiceUtil.getLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}else
			{
				libraries = UserLibraryLocalServiceUtil.getLibraryByUser(userId);
			}
		}else
		{
			libraries = new ArrayList();
			Library library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
			libraries.add(library);
		}
		List<String> messages = new ArrayList<String>();
		
		ArrayList list = new ArrayList();
		
		
		int counter = 0;
		
		for (Library library : libraries)
		{
			String libraryName = library.getLibraryName();
			
			
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_IR)
			{
				Map irItem = getMIssingIRItem(library.getLibraryId(),period,locale,libraryName);
				
				if (Validator.isNotNull(irItem))
				{
					list.add(irItem);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_PRINTED_MATERIAL)
			{
				Map printedItem = getMissingPrintedItem(library.getLibraryId(),period,locale,library.getLibraryName());
				if (Validator.isNotNull(printedItem))
				{
					list.add(printedItem);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_NON_PRINTED_MATERIAL)
			{

				Map nonPrintedItem = getMissingNonPrintedItem(library.getLibraryId(),period,locale,libraryName);
				if (Validator.isNotNull(nonPrintedItem))
				{
					list.add(nonPrintedItem);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_POSITION)
			{

				Map position  = getMissingPosition(library.getLibraryId(),period,locale,libraryName);
				if (Validator.isNotNull(position))
				{
					list.add(position);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_VISITOR)
			{

				Map visitor  = getMissingVisitor(library.getLibraryId(),period,locale,libraryName);
				if (Validator.isNotNull(visitor))
				{
					list.add(visitor);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_SEATING)
			{
	
				Map seating  = getMissingSeating(library.getLibraryId(),period,locale,libraryName);
				if (Validator.isNotNull(seating))
				{
					list.add(seating);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_MEMBERSHIP)
			{

				Map membership  = getMissingMembership(library.getLibraryId(),period,locale,libraryName);
				if (Validator.isNotNull(membership))
				{
					list.add(membership);
				}
			}
			if (dataType == DATA_ALL_DATA || dataType == EisUtil.DATA_LOAN)
			{	
				Map loan  = getMissingLoan(library.getLibraryId(),period,locale,libraryName);
				if (Validator.isNotNull(loan))
				{
					list.add(loan);
				}
			}
			
			
			
		}
		
		
		
		
		
		return list;
	}
	
	public static ArrayList getMissingData(long userId,String period,ThemeDisplay themeDisplay,boolean isAdmin,long libraryId,long dataType) throws SystemException, NoSuchLibraryException
	{
		return getMissingData(userId,period,themeDisplay.getLocale(),isAdmin,libraryId,dataType);
	}

	public static Map getMIssingIRItem(long libraryId,String period,Locale locale,String libraryName)
	{
		if (LibraryLocalServiceUtil.isMissingIRItemData(libraryId, period))
		{
			
			
			return createMissingDataMap(DATA_IR,libraryId,
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
			
			return createMissingDataMap(DATA_PRINTED_MATERIAL,libraryId,
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
			
			
			return createMissingDataMap(DATA_NON_PRINTED_MATERIAL,libraryId,
					period,LanguageUtil.get(locale, "non-printed-item-type"),
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
			return createMissingDataMap(DATA_POSITION,libraryId,
					period,LanguageUtil.get(locale, "job-post"),
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
			return createMissingDataMap(DATA_LOAN,libraryId,
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
			return createMissingDataMap(DATA_VISITOR,libraryId,
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
			return createMissingDataMap(DATA_MEMBERSHIP,libraryId,
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
			return createMissingDataMap(DATA_SEATING,libraryId,
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
	/**
	 * Update latest data period based on data cut off date
	 * example: data cut off date = 10
	 * today is jun 11 2017
	 * latest period = May 2017 
	 * if today is 9 jun 2017
	 * latest period = april 2017
	 * 
	 */
	public static void updateDataLatestPeriod()
	{
		
		int dataCutOffDay = 0;
		
		Calendar now = Calendar.getInstance(); 
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; //zero based
		int day = now.get(Calendar.DAY_OF_MONTH);
		StringBuilder sb = new StringBuilder();
		
		try {
			dataCutOffDay = Integer.parseInt(ConfigLocalServiceUtil.getByKeyAsString(CONFIG_MONTH_DATA_CUT_OFF_DAY));
			
			
			
			if (day >= dataCutOffDay)
			{
				month = month - 1;
			}else
			{
				month = month -2;
			}
			//value
			
			if (month <= 0 ) 
			{
				month = month + 12;
				year = year - 1;
			}
			
			sb.append(year);
			sb.append(String.format("%02d", month));
			
				
			
			
			ConfigLocalServiceUtil.addByStringValue(KEY_DATA_LATEST_PERIOD, sb.toString());
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(EisUtil.class);


}

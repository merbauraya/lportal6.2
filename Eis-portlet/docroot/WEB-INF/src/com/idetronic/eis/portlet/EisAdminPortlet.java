package com.idetronic.eis.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import com.idetronic.eis.model.BorrowerCategory;
import com.idetronic.eis.model.Faculty;
import com.idetronic.eis.model.FacultyType;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.ItemTypeCategory;
import com.idetronic.eis.model.Kpi;
import com.idetronic.eis.model.KpiType;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.LibraryType;
import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.PostCategory;
import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.model.Report;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.model.State;
import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.service.BorrowerCategoryLocalServiceUtil;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.FacultyLocalServiceUtil;
import com.idetronic.eis.service.FacultyTypeLocalServiceUtil;
import com.idetronic.eis.service.ItemMediumLocalServiceUtil;
import com.idetronic.eis.service.ItemTypeCategoryLocalServiceUtil;
import com.idetronic.eis.service.ItemTypeLocalServiceUtil;
import com.idetronic.eis.service.KpiEntryLocalServiceUtil;
import com.idetronic.eis.service.KpiLocalServiceUtil;
import com.idetronic.eis.service.KpiTypeLocalServiceUtil;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.LibraryTypeLocalServiceUtil;
import com.idetronic.eis.service.MemberCategoryLocalServiceUtil;
import com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.PostCategoryLocalServiceUtil;
import com.idetronic.eis.service.PostGradeLocalServiceUtil;
import com.idetronic.eis.service.PrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.ReportLocalServiceUtil;
import com.idetronic.eis.service.SeatingCategoryLocalServiceUtil;
import com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil;
import com.idetronic.eis.service.StateLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.idetronic.eis.service.VisitorCategoryLocalServiceUtil;
import com.idetronic.eis.util.EisUtil;
import com.idetronic.eis.util.Tester;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EisAdminPortlet
 */
public class EisAdminPortlet extends MVCPortlet { 
	
	
	
	public void editKpiType(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long kpiTypeId = ParamUtil.getLong(actionRequest, "kpiTypeId");
		String kpiTypeKey = ParamUtil.getString(actionRequest, "kpiTypeKey");
		String kpiName = ParamUtil.getString(actionRequest, "kpiName");
		boolean periodMonth = ParamUtil.getBoolean(actionRequest, "periodMonth");
		boolean periodQuarter = ParamUtil.getBoolean(actionRequest, "periodQuarter");
		boolean periodSemiAnnual= ParamUtil.getBoolean(actionRequest, "periodSemiAnnual");
		boolean periodYear = ParamUtil.getBoolean(actionRequest, "periodYear");
		boolean isDecimal = ParamUtil.getBoolean(actionRequest, "isDecimal"); 
		boolean manualValue = ParamUtil.getBoolean(actionRequest, "manualValue");
		
		if (Validator.isNull(kpiTypeId))
		{
			KpiTypeLocalServiceUtil.add(kpiTypeKey,kpiName,periodMonth,periodQuarter,periodSemiAnnual,periodYear,isDecimal,manualValue);
			
		}else
		{
			KpiType kpiType = KpiTypeLocalServiceUtil.fetchKpiType(kpiTypeId);
			kpiType.setKpiTypeKey(kpiTypeKey);
			kpiType.setKpiName(kpiName);
			kpiType.setPeriodMonth(periodMonth);
			kpiType.setPeriodQuarter(periodQuarter);
			kpiType.setPeriodSemiAnnual(periodSemiAnnual);
			kpiType.setPeriodYear(periodYear);
			kpiType.setIsDecimal(isDecimal);
			kpiType.setManualValue(manualValue);
			
			KpiTypeLocalServiceUtil.updateKpiType(kpiType);
		}
		
		
	}
	
	
	/**
	 * Save email notification template for first & second notification
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void editEmailNotification(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		String enableEmailNotification = ParamUtil.getString(actionRequest, "enableEmailNotification");
		String firstNotificationSubject = ParamUtil.getString(actionRequest, "firstNotificationSubject");
		String firstNotificationBody = ParamUtil.getString(actionRequest, "firstNotificationTemplate");
		
		
		String secondNotificationSubject = ParamUtil.getString(actionRequest, "secondNotificationSubject");
		String secondNotificationBody = ParamUtil.getString(actionRequest, "secondNotificationTemplate");
		
		String fromAddress = ParamUtil.getString(actionRequest, "fromAddress");
		String fromName = ParamUtil.getString(actionRequest, "fromName");
		
		String firstReminderDay = ParamUtil.getString(actionRequest, "firstReminderDay");
		String firstReminderSendContinuous = ParamUtil.getString(actionRequest, "firstReminderSendContinuous");
		String secondReminderSendContinuous = ParamUtil.getString(actionRequest, "secondReminderSendContinuous");
		String secondReminderDay = ParamUtil.getString(actionRequest, "secondReminderDay");
		String firstReminderDayUntil = ParamUtil.getString(actionRequest, "firstReminderDayUntil");
		String secondReminderDayUntil = ParamUtil.getString(actionRequest, "secondReminderDayUntil");
		
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_SUBJECT, firstNotificationSubject);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_BODY, firstNotificationBody);
		
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_SUBJECT, secondNotificationSubject);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_BODY, secondNotificationBody);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_EMAIL_FROM_ADDRESS, fromAddress);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_EMAIL_FROM_NAME, fromName);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_REMINDER_1ST_SEND_CONTINUOUSLY, firstReminderSendContinuous);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_REMINDER_2ND_SEND_CONTINUOUSLY, secondReminderSendContinuous);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.KEY_CONFIG_ENABLE_EMAIL_NOTIFICATION, enableEmailNotification);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.CONFIG_REMINDER_DAY_1ST, firstReminderDay);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.CONFIG_REMINDER_DAY_1ST_UNTIL, firstReminderDayUntil);
		
		ConfigLocalServiceUtil.addByStringValue(EisUtil.CONFIG_REMINDER_DAY_2ND, secondReminderDay);
		ConfigLocalServiceUtil.addByStringValue(EisUtil.CONFIG_REMINDER_DAY_2ND_UNTIL, secondReminderDayUntil);


	
		//Tester.testNotification();
		
		
	} 
	
	public void deleteSeatingDepartment(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException
	{
		long departmentId = ParamUtil.getLong(actionRequest, "departmentId");
		SeatingDepartmentLocalServiceUtil.deleteSeatingDepartment(departmentId);
		
	}
	public void deleteSeatingCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException
	{
		long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
		SeatingCategoryLocalServiceUtil.deleteSeatingCategory(categoryId); 
		
	}
	
	public void editSeatingCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException
	{
		long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
		long departmentId = ParamUtil.getLong(actionRequest, "departmentId");
		
		String name = ParamUtil.getString(actionRequest, "seatingCategoryName");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		
		SeatingCategory category = null;
		
		if (Validator.isNull(categoryId))
		{
			category = SeatingCategoryLocalServiceUtil.add(departmentId,name, serviceContext);
		}else
		{
			category = SeatingCategoryLocalServiceUtil.fetchSeatingCategory(categoryId);
			category.setSeatingCategoryName(name);
			category.setModifiedDate(new Date());
			category.setSeatingDepartmentId(departmentId);
			SeatingCategoryLocalServiceUtil.updateSeatingCategory(category);
			
		}
		
	}
	
	public void editSeatingDepartment(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException
	{
		long departmentId = ParamUtil.getLong(actionRequest, "departmentId");
		String name = ParamUtil.getString(actionRequest, "departmentName");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		
		SeatingDepartment department = null;
		
		if (Validator.isNull(departmentId))
		{
			department = SeatingDepartmentLocalServiceUtil.add(name, serviceContext);
		}else
		{
			department = SeatingDepartmentLocalServiceUtil.fetchSeatingDepartment(departmentId);
			department.setDepartmentName(name);
			department.setModifiedDate(new Date());
			
			SeatingDepartmentLocalServiceUtil.updateSeatingDepartment(department);
			
		}
		
	}
	
	public void editConfig(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		boolean allowPreviousYear = ParamUtil.getBoolean(actionRequest, "allowPreviousYear");
		boolean periodYearRange = ParamUtil.getBoolean(actionRequest, "periodYearRange");
		boolean useMonthName = ParamUtil.getBoolean(actionRequest, "useMonthName");
		boolean allowFuturePeriod = ParamUtil.getBoolean(actionRequest, "allowFuturePeriod");
		boolean libraryAdminAllowAll = ParamUtil.getBoolean(actionRequest, "libraryAdminAllowAll");
		String membershipGroup = ParamUtil.getString(actionRequest, "membershipGroup");
		
		
		int minYear = ParamUtil.getInteger(actionRequest, "minYear");
		int maxYear = ParamUtil.getInteger(actionRequest, "maxYear");
		
		int minYearPrevious = ParamUtil.getInteger(actionRequest, "minYearPrevious");
		int maxYearForward = ParamUtil.getInteger(actionRequest, "maxYearForward");
		
		int firstReminder = ParamUtil.getInteger(actionRequest, "firstReminder");
		int secondReminder = ParamUtil.getInteger(actionRequest, "secondReminder");
		int reminderOption = ParamUtil.getInteger(actionRequest, "reminderOption");
		int dataDueDay = ParamUtil.getInteger(actionRequest, "dataDueDay");
		
		int dataCutOffDay = ParamUtil.getInteger(actionRequest, "dataCutOffDay");
		Properties prop = new Properties();
		StringBuilder sb = new StringBuilder();
		
		
		prop.setProperty(EisUtil.CONFIG_MEMBERSHIP_GROUP, membershipGroup);
		prop.setProperty(EisUtil.CONFIG_PERIOD_ALLOW_PREVIOUS, String.valueOf(allowPreviousYear));
		prop.setProperty(EisUtil.CONFIG_ALLOW_FUTURE_PERIOD, String.valueOf(allowFuturePeriod));
		prop.setProperty(EisUtil.CONFIG_PERIOD_USE_YEAR_RANGE, String.valueOf(periodYearRange));
		prop.setProperty(EisUtil.CONFIG_PERIOD_MAX_YEAR, String.valueOf(maxYear));
		prop.setProperty(EisUtil.CONFIG_PERIOD_MIN_YEAR, String.valueOf(minYear));
		
		prop.setProperty(EisUtil.CONFIG_PERIOD_NUM_YEAR_BACK, String.valueOf(minYearPrevious));
		prop.setProperty(EisUtil.CONFIG_PERIOD_NUM_YEAR_FWD, String.valueOf(maxYearForward));
		prop.setProperty(EisUtil.CONFIG_MONTH_DATA_CUT_OFF_DAY, String.valueOf(dataCutOffDay));
		
		ConfigLocalServiceUtil.addByStringValue(EisUtil.CONFIG_MONTH_DATA_CUT_OFF_DAY, String.valueOf(dataCutOffDay));
		
		prop.setProperty(EisUtil.CONFIG_DATA_DUE_DAY, String.valueOf(dataDueDay));

		prop.setProperty(EisUtil.CONFIG_REMINDER_DAY_1ST, String.valueOf(firstReminder));
		prop.setProperty(EisUtil.CONFIG_REMINDER_DAY_2ND, String.valueOf(secondReminder));
		prop.setProperty(EisUtil.CONFIG_REMINDER_OPTION, String.valueOf(reminderOption));
		prop.setProperty(EisUtil.CONFIG_PERIOD_USE_MONTH_NAME, String.valueOf(useMonthName));
		prop.setProperty(EisUtil.CONFIG_LIBRARY_ADMIN_ALLOW_ALL, String.valueOf(libraryAdminAllowAll));
		
		
		ConfigLocalServiceUtil.add(EisUtil.KEY_CONFIG, prop);
		
		
		
		
			
		
	}
	
	public void editKpiSetting(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		String rowIndexes = actionRequest.getParameter("rowIndexes");
		String[] indexOfRows = rowIndexes.split(",");
		int n = 1;
		
		ConfigLocalServiceUtil.deleteByKeyWildcard(EisUtil.KEY_KPI_SETTING_RANGE);
		
		for (int i = 0; i < indexOfRows.length; i++) {
			String index =  indexOfRows[i];
            String lowRange = (actionRequest.getParameter("lowRange"+index)).trim();
 
            String highRange = (actionRequest.getParameter("highRange"+ index)).trim();
 
            String color = actionRequest.getParameter("kpiColor"+ index);
          
            
            String key = EisUtil.KEY_KPI_SETTING_RANGE + ".low" + n;
            ConfigLocalServiceUtil.addByStringValue(key, lowRange);
            key =  EisUtil.KEY_KPI_SETTING_RANGE + ".high" + n;
            ConfigLocalServiceUtil.addByStringValue(key, highRange);
            
            key =  EisUtil.KEY_KPI_SETTING_RANGE + ".color" + n;
            switch (color)
            {
            case "kpiRed":
            	color = "#FF0000";
            	break;
            case "kpiYellow":
            	color = "#FFFF00";
            	break;
            case "kpiGreen":
            	color = "#006400";
            	break;
            case "kpiBlue":
            	color = "#00008B";
            	break;
            }
            
            ConfigLocalServiceUtil.addByStringValue(key, color);
            
            
            n++;
           
        }
	
	}
	
	public void editItemType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long itemTypeId = ParamUtil.getLong(actionRequest, "itemTypeId");
		String itemTypeName = ParamUtil.getString(actionRequest, "itemTypeName");
		int printedType = ParamUtil.getInteger(actionRequest, "printedType");
		
		boolean isIRType = ParamUtil.getBoolean(actionRequest, "IRType");
		boolean isActive = ParamUtil.getBoolean(actionRequest, "active");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

		
		ItemType itemType = null;
		
		if (Validator.isNull(itemTypeId))
		{
			itemType = ItemTypeLocalServiceUtil.add(itemTypeName, printedType,isIRType, isActive,serviceContext);
		}else
		{
			itemType = ItemTypeLocalServiceUtil.fetchItemType(itemTypeId);
			itemType.setItemTypeName(itemTypeName);
			itemType.setIRType(isIRType);
			itemType.setPrintedType(printedType);
			itemType.setActive(isActive);
			
			ItemTypeLocalServiceUtil.updateItemType(itemType);
		}
		
	}
	
	public void editState(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long stateId = ParamUtil.getLong(actionRequest, "stateId");
		String stateCode = ParamUtil.getString(actionRequest, "stateCode");
		String stateName = ParamUtil.getString(actionRequest, "stateName");
		
		State state = null;
		
		if (Validator.isNull(stateId))
		{
			state = StateLocalServiceUtil.add(stateCode, stateName);
			
		}else
		{
			state = StateLocalServiceUtil.fetchState(stateId);
			state.setStateCode(stateCode);
			state.setStateName(stateName);
			state = StateLocalServiceUtil.updateState(state);
		}
		
	}
	
	public void editLibraryType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long libraryTypeId = ParamUtil.getLong(actionRequest, "libraryTypeId");
		String libraryTypeCode = ParamUtil.getString(actionRequest, "libraryTypeCode");
		String libraryTypeName = ParamUtil.getString(actionRequest, "libraryTypeName");
		
		
		LibraryType libraryType = null;
		
		if (Validator.isNull(libraryTypeId))
		{
			libraryType = LibraryTypeLocalServiceUtil.add(libraryTypeName,libraryTypeCode);
			
		}else
		{
			libraryType = LibraryTypeLocalServiceUtil.fetchLibraryType(libraryTypeId);
			libraryType.setLibraryTypeName(libraryTypeName);
			libraryType.setLibraryTypeCode(libraryTypeCode);
			libraryType = LibraryTypeLocalServiceUtil.updateLibraryType(libraryType);
		}
		
	}
	
	public void editLibrary(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		String libraryCode = ParamUtil.getString(actionRequest, "libraryCode");
		String libraryName = ParamUtil.getString(actionRequest, "libraryName");
		long libraryTypeId = ParamUtil.getLong(actionRequest, "libraryTypeId");
		long stateId = ParamUtil.getLong(actionRequest, "stateId");
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		
		Library library = null;
		
		if (Validator.isNull(libraryId))
		{
			library = LibraryLocalServiceUtil.add(libraryTypeId, libraryCode, libraryName, stateId, serviceContext);
			
		}else
		{
			library = LibraryLocalServiceUtil.fetchLibrary(libraryId);
			library.setLibraryName(libraryName);
			library.setLibraryTypeId(libraryTypeId);
			library.setStateId(stateId);
			library.setLibraryCode(libraryCode);
			
			library = LibraryLocalServiceUtil.updateLibrary(library);
		}
		
	}
	public void editFacultyType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long facultyTypeId = ParamUtil.getLong(actionRequest, "facultyTypeId");
		
		String name = ParamUtil.getString(actionRequest, "facultyTypeName");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		
		FacultyType facultyType = null;
		
		if (Validator.isNull(facultyTypeId))
		{
			facultyType = FacultyTypeLocalServiceUtil.add(name);
			
		}else
		{
			facultyType = FacultyTypeLocalServiceUtil.fetchFacultyType(facultyTypeId);
			facultyType.setFacultyTypeName(name);
			
			
			facultyType = FacultyTypeLocalServiceUtil.updateFacultyType(facultyType);
		}
		
	}
	public void editFaculty(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long facultyId = ParamUtil.getLong(actionRequest, "facultyId");
		long facultyTypeId = ParamUtil.getLong(actionRequest, "facultyTypeId"); 
		String name = ParamUtil.getString(actionRequest, "facultyName");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		Faculty faculty = null;
		
		if (Validator.isNull(facultyId))
		{
			faculty = FacultyLocalServiceUtil.add(facultyTypeId, name);
			
		}else
		{
			faculty = FacultyLocalServiceUtil.fetchFaculty(facultyId);
			faculty.setFacultyTypeId(facultyTypeId);
			faculty.setFacultyName(name);
			
			
			faculty = FacultyLocalServiceUtil.updateFaculty(faculty);
		}
		
	}
	
	public void editPrintedItemType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long itemTypeId = ParamUtil.getLong(actionRequest, "itemTypeId");
		
		String name = ParamUtil.getString(actionRequest, "itemTypeName");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		PrintedItemType itemType = null;
		
		if (Validator.isNull(itemTypeId))
		{
			itemType = PrintedItemTypeLocalServiceUtil.add(name);
			
		}else
		{
			itemType = PrintedItemTypeLocalServiceUtil.fetchPrintedItemType(itemTypeId);
			itemType.setItemTypeName(name);
			
			
			
			itemType = PrintedItemTypeLocalServiceUtil.updatePrintedItemType(itemType);
		}
		
	}
	public void editNonPrintedItemType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long itemTypeId = ParamUtil.getLong(actionRequest, "itemTypeId");
		
		String name = ParamUtil.getString(actionRequest, "itemTypeName");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		NonPrintedItemType itemType = null;
		
		if (Validator.isNull(itemTypeId))
		{
			itemType = NonPrintedItemTypeLocalServiceUtil.add(name); 
			
		}else
		{
			itemType = NonPrintedItemTypeLocalServiceUtil.fetchNonPrintedItemType(itemTypeId);
			itemType.setItemTypeName(name);
			
			
			
			itemType = NonPrintedItemTypeLocalServiceUtil.updateNonPrintedItemType(itemType);
		}
		
	}
	public void editItemTypeCategory(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long itemTypeCategoryId = ParamUtil.getLong(actionRequest, "itemTypeCategoryId");
		
		String name = ParamUtil.getString(actionRequest, "itemTypeCategoryName");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		ItemTypeCategory itemTypecategory = null;
		
		if (Validator.isNull(itemTypeCategoryId))
		{
			itemTypecategory= ItemTypeCategoryLocalServiceUtil.add(name); 
			
		}else
		{
			itemTypecategory = ItemTypeCategoryLocalServiceUtil.fetchItemTypeCategory(itemTypeCategoryId);
			itemTypecategory.setItemTypeCategoryName(name);
			
			
			
			itemTypecategory = ItemTypeCategoryLocalServiceUtil.updateItemTypeCategory(itemTypecategory);
			
		}
		
	}
	
	
	public void editItemMedium(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long itemMediumId = ParamUtil.getLong(actionRequest, "itemMediumId");
		
		String name = ParamUtil.getString(actionRequest, "itemMediumName");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		ItemMedium itemMedium = null;
		
		if (Validator.isNull(itemMediumId))
		{
			itemMedium = ItemMediumLocalServiceUtil.add(name);
			
		}else
		{
			itemMedium = ItemMediumLocalServiceUtil.fetchItemMedium(itemMediumId);
			itemMedium.setItemMediumName(name);
			
			
			
			itemMedium = ItemMediumLocalServiceUtil.updateItemMedium(itemMedium);
			
		}
		
	}
	public void editVisitorCategory(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long visitorCategoryId = ParamUtil.getLong(actionRequest, "visitorCategoryId");
		
		String name = ParamUtil.getString(actionRequest, "visitorCategoryName");
		String categoryCode = ParamUtil.getString(actionRequest, "visitorCategoryCode");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);  
		
		VisitorCategory visitorCategory = null;
		
		if (Validator.isNull(visitorCategoryId))
		{
			visitorCategory= VisitorCategoryLocalServiceUtil.add(name,categoryCode);
			
		}else
		{
			visitorCategory = VisitorCategoryLocalServiceUtil.fetchVisitorCategory(visitorCategoryId);
			visitorCategory.setVisitorCategoryName(name);
			visitorCategory.setVisitorCategoryCode(categoryCode);
		
			
			
			
			
			visitorCategory = VisitorCategoryLocalServiceUtil.updateVisitorCategory(visitorCategory);
			
		}
	}
	
	public void deleteKpiType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long kpiTypeId = ParamUtil.getLong(actionRequest, "kpiTypeId");
		KpiTypeLocalServiceUtil.deleteKpiType(kpiTypeId);
		
	}
	
	public void deleteReport(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long reportId = ParamUtil.getLong(actionRequest, "reportId");
		ReportLocalServiceUtil.deleteReport(reportId);
		
	}
	
	
	public void editMemberCategory(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long memberCategoryId = ParamUtil.getLong(actionRequest, "memberCategoryId");
		
		String name = ParamUtil.getString(actionRequest, "memberCategoryName");
		String groupName = ParamUtil.getString(actionRequest, "group");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);  
		
		MemberCategory memberCategory = null; 
		
		if (Validator.isNull(memberCategoryId)) 
		{
			memberCategory = MemberCategoryLocalServiceUtil.add(name,groupName,true);
			
		}else
		{
			memberCategory = MemberCategoryLocalServiceUtil.fetchMemberCategory(memberCategoryId);
			memberCategory.setMemberCategoryName(name);
			memberCategory.setActive(true);
			memberCategory.setMemberCategoryGroupName(groupName);
			
			
			memberCategory = MemberCategoryLocalServiceUtil.updateMemberCategory(memberCategory);
		}
	}
	
	
	public void editPostCategory(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long postCategoryId = ParamUtil.getLong(actionRequest, "postCategoryId");
		
		String name = ParamUtil.getString(actionRequest, "postCategoryName");
		String code = ParamUtil.getString(actionRequest, "postCategoryCode");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);  
		
		PostCategory postCategory = null;
		
		if (Validator.isNull(postCategoryId))
		{
			postCategory= PostCategoryLocalServiceUtil.add(code, name);
			
		}else
		{
			postCategory = PostCategoryLocalServiceUtil.fetchPostCategory(postCategoryId);
			postCategory.setPostCategoryCode(code);
			postCategory.setPostCategoryName(name);
			
			
			
			
			postCategory = PostCategoryLocalServiceUtil.updatePostCategory(postCategory);
			
		}
		
	} 
	public void editPostGrade(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long postGradeId = ParamUtil.getLong(actionRequest, "postGradeId");
		long postCategoryId = ParamUtil.getLong(actionRequest,"postCategoryId");
		String postGradeScheme = ParamUtil.getString(actionRequest, "postGradeScheme");
		String postGradeDesc = ParamUtil.getString(actionRequest, "postGradeDesc");
		
		String name = ParamUtil.getString(actionRequest, "postGradeName");
		String code = ParamUtil.getString(actionRequest, "postGradeCode");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		PostGrade postGrade = null;
		 
		if (Validator.isNull(postGradeId))
		{
			postGrade= PostGradeLocalServiceUtil.add(code, name, postGradeScheme, postCategoryId,postGradeDesc, serviceContext);
			
		}else
		{
			postGrade = PostGradeLocalServiceUtil.fetchPostGrade(postGradeId);
			postGrade.setPostGradeId(postGradeId);
			postGrade.setPostGradeCode(code);
			postGrade.setPostGradeName(name);
			postGrade.setPostGradeDesc(postGradeDesc);
			postGrade.setPostGradeScheme(postGradeScheme);
			
			postGrade.setUserId(serviceContext.getUserId());
			postGrade.setModifiedDate(new Date());
			
			
			
			
			
			postGrade = PostGradeLocalServiceUtil.updatePostGrade(postGrade);
			
		}
		
	}
	public void removeUserLibrary(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long userLibraryId = ParamUtil.getShort(actionRequest, "userLibraryId");
		UserLibraryLocalServiceUtil.deleteUserLibrary(userLibraryId);
		
		
	}
	
	public void editKpiEntry(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException
	{
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		
		long kpiTypeId = ParamUtil.getLong(actionRequest, "kpiType");
		String year = ParamUtil.getString(actionRequest, "year");
		
		KpiType kpiType = KpiTypeLocalServiceUtil.fetchKpiType(kpiTypeId);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		
		//yearly KPI
		if (kpiType.getPeriodYear())
		{
			JSONObject data =  JSONFactoryUtil.createJSONObject();
			double value = ParamUtil.getDouble(actionRequest, "periodYear");
			data.put("periodType", EisUtil.KPI_YEARLY);
			data.put("period", year);
			data.put("value", value);
			if (kpiType.getManualValue())
			{
				double manualValue = ParamUtil.getDouble(actionRequest, "periodYearValue");
				data.put("actual", manualValue);
				
			}
			jsonArray.put(data);
		}
		//semi annual KPI
		if (kpiType.getPeriodSemiAnnual())
		{
			
			for (int i = 1; i < 3; i++)
			{
				double value = ParamUtil.getDouble(actionRequest, "sa"+i);
				JSONObject data =  JSONFactoryUtil.createJSONObject();
				data.put("periodType", EisUtil.KPI_SEMI_ANUALLY);
				data.put("period", year+"SA"+i);
				data.put("value", value);
				if (kpiType.getManualValue())
				{
					
					String name = "sa" + i + "value";
					
					double saValue = ParamUtil.getDouble(actionRequest, name);
					
					data.put("actual", saValue );
					
				}
				
				jsonArray.put(data);
				
				
			}
		}
		//quarterly kpi
		if (kpiType.getPeriodQuarter())
		{
			
			for (int i = 1; i < 5; i++)
			{
				double value = ParamUtil.getDouble(actionRequest, "q"+i);
				JSONObject data =  JSONFactoryUtil.createJSONObject();
				data.put("periodType", EisUtil.KPI_QUARTERLY);
				data.put("period", year+"Q"+i);
				data.put("value", value);
				if (kpiType.getManualValue())
				{
					
					String name = "q" + i + "value";
					
					double actual = ParamUtil.getDouble(actionRequest, name);
					
					data.put("actual", actual );
					
				}
				
				
				jsonArray.put(data);
				
				
			}
		}
		
		//monthly kpi
		if (kpiType.getPeriodMonth())
		{
			
			for (int i = 1; i < 13; i++)
			{
				double value = ParamUtil.getDouble(actionRequest, "month"+i);
				JSONObject data =  JSONFactoryUtil.createJSONObject();
				String period = year + String.format("%02d", i);
				data.put("period", period);		
				data.put("periodType", EisUtil.KPI_MONTHLY);
				data.put("value", value);
				if (kpiType.getManualValue())
				{
					
					String name = "month" + i + "value";
					
					double actual = ParamUtil.getDouble(actionRequest, name);
					
					data.put("actual", actual );
					
				}
				
				jsonArray.put(data);
				
				
			}
		}
		
		KpiEntryLocalServiceUtil.batchInsert(kpiTypeId, year, jsonArray, serviceContext);
		
		
		
		
	}
	
	public void editUserLibrary(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		
		long[] addUserIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "addUserIds"), 0L);
		
		addUserIds = filterAddUserIds(libraryId, addUserIds); 
		
		
		long[] removeUserIds = StringUtil.split(
							ParamUtil.getString(actionRequest, "removeUserIds"), 0L);
		
		removeUserIds = filterRemoveUserIds(libraryId, removeUserIds);
		
		if (cmd.equals("userLibrary"))
		{
			
			UserLibraryLocalServiceUtil.updateAssociation(libraryId, addUserIds, removeUserIds, serviceContext);
		} else //user search
		{
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
		actionResponse.sendRedirect(redirect);
		
		
	}
	public void deleteMaster (ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException
	{
		String masterType = ParamUtil.getString(actionRequest, "masterType");
		long masterId = ParamUtil.getLong(actionRequest, "masterId");
		
		if (masterType.equalsIgnoreCase("state"))
		{
			StateLocalServiceUtil.deleteState(masterId);
		}
		if (masterType.equalsIgnoreCase("library-type"))
		{
			LibraryTypeLocalServiceUtil.deleteLibraryType(masterId);
		}
		if (masterType.equalsIgnoreCase("library"))
		{
			LibraryLocalServiceUtil.deleteLibrary(masterId);
		}
		if (masterType.equalsIgnoreCase("ptj-type"))
		{
			FacultyTypeLocalServiceUtil.deleteFacultyType(masterId);
		}
		if (masterType.equalsIgnoreCase("ptj"))
		{
			FacultyLocalServiceUtil.deleteFaculty(masterId);
		}
		if (masterType.equalsIgnoreCase("item-type"))
		{
			ItemTypeLocalServiceUtil.deleteItemType(masterId);
		}
		if (masterType.equalsIgnoreCase("item-medium"))
		{
			ItemMediumLocalServiceUtil.deleteItemMedium(masterId);
		}
		if (masterType.equalsIgnoreCase("post-category"))
		{
			PostCategoryLocalServiceUtil.deletePostCategory(masterId);
		}
		if (masterType.equalsIgnoreCase("post-grade"))
		{
			PostGradeLocalServiceUtil.deletePostGrade(masterId);
		}
		if (masterType.equalsIgnoreCase("visitor-category"))
		{
			VisitorCategoryLocalServiceUtil.deleteVisitorCategory(masterId);
		}
		if (masterType.equalsIgnoreCase("member-category"))
		{
			MemberCategoryLocalServiceUtil.deleteMemberCategory(masterId);
		}
		if (masterType.equalsIgnoreCase("seating-department"))
		{
			SeatingDepartmentLocalServiceUtil.deleteSeatingDepartment(masterId);
		}
		if (masterType.equalsIgnoreCase("seating-category"))
		{
			SeatingCategoryLocalServiceUtil.deleteSeatingCategory(masterId);
		}
		
		
		
	}
	public void editReport(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long reportId = ParamUtil.getLong(actionRequest, "reportId"); 
		
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		String reportKey = ParamUtil.getString(actionRequest, "reportKey");
		String reportTitle = ParamUtil.getString(actionRequest, "reportTitle");
		String reportName = ParamUtil.getString(actionRequest, "reportName");
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		Report report = null;
		
		if (Validator.isNull(reportId))
		{
			report = ReportLocalServiceUtil.addReport(reportKey, reportName, reportTitle);
		}else
		{
			report = ReportLocalServiceUtil.fetchReport(reportId);
			report.setReportKey(reportKey);
			report.setReportTitle(reportTitle);
			
			ReportLocalServiceUtil.updateReport(report);
			
		}
		
		
		
		//actionResponse.sendRedirect(redirect);
		
		
	}
	
	protected long[] filterRemoveUserIds(long libraryId,long[] userIds) throws SystemException
	{
		Set<Long> filteredUserIds = new HashSet<>(userIds.length);

		for (long userId : userIds) {
			if (UserLibraryLocalServiceUtil.hasAssociation(libraryId, userId)) 
			{
				filteredUserIds.add(userId);
			}
		}

		return ArrayUtil.toArray(
			filteredUserIds.toArray(new Long[filteredUserIds.size()]));
	}
	
	protected long[] filterAddUserIds(long libraryId,long[] userIds) throws SystemException
	{
		Set<Long> filteredUserIds = new HashSet<>(userIds.length);

		for (long userId : userIds) {
			if (!UserLibraryLocalServiceUtil.hasAssociation(libraryId, userId)) 
			{
				filteredUserIds.add(userId);
			}
		}

		return ArrayUtil.toArray(
			filteredUserIds.toArray(new Long[filteredUserIds.size()]));
	}
	
	public void serveResource(ResourceRequest request, ResourceResponse response)
            throws PortletException, IOException {
        
		String resourceID = request.getResourceID();
		
		PrintWriter writer = response.getWriter();
		
        if (resourceID.equals("libraryList")) 
        {
            long stateId = ParamUtil.getLong(request, "stateId");
            
            try {
            	libraryList(request,response);
				//JSONArray libraries = EisUtil.getLibraryByState(stateId);
				 //writer.write(libraries.toString());
			} catch (SystemException e) {
				
				e.printStackTrace();
			} 
            
        }
        if (resourceID.equals(EisUtil.RESOURCE_PRINTED_MATERIAL_DATA_LIST))
        {
        	try {
				loadPrintedMaterialDataList(request, response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_KPI_ENTRY_DATA)) 
        {
        	try {
				serveKpiEntry(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	private void serveKpiEntry(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, SystemException
	{
		long kpiTypeId = ParamUtil.getLong(request, "kpiTypeId");
		String year = ParamUtil.getString(request, "year");
		
		KpiType kpiType = KpiTypeLocalServiceUtil.fetchKpiType(kpiTypeId);
		
		request.setAttribute("kpiType", kpiType);
		request.setAttribute("year", year);
		
		include("/html/admin/_kpiform.jsp",request,response); 
	}
	
	private void loadPrintedMaterialDataList(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, SystemException
	{
		PortletURL iteratorURL = response.createRenderURL();
        iteratorURL.setWindowState(LiferayWindowState.NORMAL);
        
        long libraryId = ParamUtil.getLong(request, "libraryId");
        String period = ParamUtil.getString(request, "period");
        
        LOGGER.info(libraryId +"xxx");
       
		
        List<PrintedItemType> datas = PrintedItemTypeLocalServiceUtil.getPrintedItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS) ;// FactPrintedMaterialLocalServiceUtil.findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        
        request.setAttribute("libraryId", libraryId);
        request.setAttribute("period", period);
        request.setAttribute("printedItemList", datas);
        
		include("/html/fact/dataPrintedMaterialList.jsp",request,response); 
	}
	private void libraryList(ResourceRequest request, ResourceResponse response) throws IOException,PortletException,WindowStateException, SystemException
	{
		PortletURL iteratorURL = response.createRenderURL();
        iteratorURL.setWindowState(LiferayWindowState.NORMAL);
        
        long stateId = ParamUtil.getLong(request, "stateId");
         
        SearchContainer<Library> libraryListSearchContainer = new SearchContainer<Library>(
        		request, null, null, "cur", 1, 20,
                iteratorURL, null, "No Library found.");
        
        List<Library> libraries = LibraryLocalServiceUtil.findByState(stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        int total = libraries.size();
        
        libraryListSearchContainer.setResults(libraries);
        libraryListSearchContainer.setTotal(total);
        request.setAttribute("libraryListSearchContainer", libraryListSearchContainer);
        include("/html/admin/libraryList.jsp",request,response); 
        
	}
	
	
	
	private static Log LOGGER = LogFactoryUtil.getLog(EisAdminPortlet.class);
}

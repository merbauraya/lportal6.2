package com.idetronic.eis.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import com.idetronic.eis.NoSuchMasterFileException;
import com.idetronic.eis.model.BorrowerCategory;
import com.idetronic.eis.model.Config;
import com.idetronic.eis.model.Faculty;
import com.idetronic.eis.model.FacultyType;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.ItemTypeCategory;
import com.idetronic.eis.model.Kpi;
import com.idetronic.eis.model.KpiType;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.LibraryType;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.model.MasterType;
import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.PostCategory;
import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.model.Report;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.model.State;
import com.idetronic.eis.model.UserLibrary;
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
import com.idetronic.eis.service.MasterFileLocalServiceUtil;
import com.idetronic.eis.service.MasterTypeLocalServiceUtil;
import com.idetronic.eis.service.MemberCategoryLocalServiceUtil;
import com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.PostCategoryLocalServiceUtil;
import com.idetronic.eis.service.PostGradeLocalServiceUtil;
import com.idetronic.eis.service.PrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.ReportLocalServiceUtil;
import com.idetronic.eis.service.SeatingCategoryLocalServiceUtil;
import com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil;
import com.idetronic.eis.service.StateLocalServiceUtil;
import com.idetronic.eis.service.UserDataLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.idetronic.eis.service.UserReportLocalServiceUtil;
import com.idetronic.eis.service.VisitorCategoryLocalServiceUtil;
import com.idetronic.eis.util.EisUtil;
import com.idetronic.eis.util.ReminderNotification;
import com.idetronic.eis.util.Tester;
import com.liferay.counter.service.CounterLocalServiceUtil;
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
import com.liferay.portal.kernel.util.StringPool;
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
	public void runTest(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException 
	{
		Tester.testNotification();
	}
	
	public void editInfoBox(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException 
	{
		long id = ParamUtil.getLong(actionRequest, "id");
		String key = StringPool.BLANK;
		String title = ParamUtil.getString(actionRequest, "title");
		
		String body = ParamUtil.getString(actionRequest, "boxBodyTemplate");
		
		Config infoBox = null;
		
		if (Validator.isNull(id))
		{
			id = CounterLocalServiceUtil.increment(Config.class.getName());
			key = EisUtil.EIS_INFO_BOX + "." + id;
			infoBox = ConfigLocalServiceUtil.createConfig(id);
			infoBox.setKey(key);
		}else
		{
			infoBox = ConfigLocalServiceUtil.getConfig(id);
		}
		
		infoBox.setTitle(title);
		infoBox.setValue(body);
		
		ConfigLocalServiceUtil.updateConfig(infoBox);
	}
	public void editDashboard(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, IOException
	{
		String layoutSetting  = ParamUtil.getString(actionRequest, "layoutSetting");
		Config config = ConfigLocalServiceUtil.getConfigByKey(EisUtil.EIS_DASHBOARD_LAYOUT);
		if (Validator.isNull(config))
		{
			config = ConfigLocalServiceUtil.createConfig(CounterLocalServiceUtil.increment(Config.class.getName()));
			config.setKey(EisUtil.EIS_DASHBOARD_LAYOUT);
		}
		
		config.setValue(layoutSetting);
		ConfigLocalServiceUtil.updateConfig(config);
		
				
		
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
          
            
            String key = EisUtil.KEY_KPI_SETTING_RANGE +  n;
            
            
            /*
            
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
            */
            
            String value = lowRange + "," + highRange + "," + color;
            ConfigLocalServiceUtil.addByStringValue(key, value);
            
             
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
	
	public void editUserData(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long userId =  ParamUtil.getLong(actionRequest, "userId");
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		long[] addDataIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "addDataIds"), 0L);
		
		long[] removeDataIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "removeDataIds"), 0L);
		
		UserReportLocalServiceUtil.updateAssociationByUser(userId, libraryId,addDataIds, removeDataIds, serviceContext);
		actionResponse.sendRedirect(redirect);


		
	}
	
	public void editUserLibrary(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "libraryId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		
		long[] addUserIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "addUserIds"), 0L);
		
		long[] addLibraryIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "addLibraryIds"), 0L);
		
		long[] removeLibraryIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "removeLibraryIds"), 0L);
		
		
		addUserIds = filterAddUserIds(libraryId, addUserIds); 
		
		
		long[] removeUserIds = StringUtil.split(
							ParamUtil.getString(actionRequest, "removeUserIds"), 0L);
		
		removeUserIds = filterRemoveUserIds(libraryId, removeUserIds);
		
		
		
		if (cmd.equals("userLibrary"))
		{
			UserLibraryLocalServiceUtil.updateAssociationByUser(userId, addLibraryIds, removeLibraryIds, serviceContext);
			//UserLibraryLocalServiceUtil.updateAssociation(libraryId, addUserIds, removeUserIds, serviceContext);
		} else //user search
		{
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
		actionResponse.sendRedirect(redirect);
		
		
	}
	
	public void deleteMasterFile (ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException 
	{
		long masterFileId = ParamUtil.getLong(actionRequest, "masterFileId");
		MasterFile masterFile = MasterFileLocalServiceUtil.fetchMasterFile(masterFileId);
		
		
		MasterFileLocalServiceUtil.deleteMasterFile(masterFileId);
		
		long chkItemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		if (chkItemType == masterFile.getMasterTypeId())
		{
			ItemTypeLocalServiceUtil.deleteItemType(masterFile.getOldId());
		}
		
		
		//ConfigLocalServiceUtil.getByKey(key)
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
	
	public void editProperty(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long id = ParamUtil.getLong(actionRequest, "propertyId");
		String key = ParamUtil.getString(actionRequest, "key");
		String value = ParamUtil.getString(actionRequest, "value");
		
		Config property = null;
		
		if (Validator.isNull(id))
		{
			property = ConfigLocalServiceUtil.createConfig(CounterLocalServiceUtil.increment(Config.class.getName()));
		} else
		{
			property = ConfigLocalServiceUtil.fetchConfig(id);
		}
		
		property.setKey(key);
		property.setValue(value);
		ConfigLocalServiceUtil.updateConfig(property);
		
		
	}
	
	
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void editMasterFile(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long masterFileId =ParamUtil.getLong(actionRequest, "masterFileId");
		long masterTypeId = ParamUtil.getLong(actionRequest, "masterTypeId");
		String masterFileName = ParamUtil.getString(actionRequest, "masterFileName");
		
		long parent1 = ParamUtil.getLong(actionRequest, "parent1");
		long parent2 = ParamUtil.getLong(actionRequest, "parent2");
		
		
		boolean status1 = ParamUtil.getBoolean(actionRequest, "status1");
		boolean status2 = ParamUtil.getBoolean(actionRequest, "status2");
		boolean status3 = ParamUtil.getBoolean(actionRequest, "status3");
		boolean status4 = ParamUtil.getBoolean(actionRequest, "status4"); 
		boolean status5 = ParamUtil.getBoolean(actionRequest, "status5"); 
		boolean inActive = ParamUtil.getBoolean(actionRequest, "inActive"); 
		
		MasterFile masterFile = null;
		
		if (Validator.isNotNull(masterFileId))
		{
			masterFile = MasterFileLocalServiceUtil.fetchMasterFile(masterFileId);
		} else
		{
			masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
			
		}
		
		masterFile.setMasterFileName(masterFileName);
		masterFile.setMasterTypeId(masterTypeId);
		masterFile.setParentId1(parent1);
		masterFile.setParentId2(parent2);
		masterFile.setStatus1(status1); 
		masterFile.setStatus2(status2);
		masterFile.setStatus3(status3);
		masterFile.setStatus4(status4);
		masterFile.setStatus5(status5);
		masterFile.setInActive(inActive);
		
		
		MasterFileLocalServiceUtil.updateMasterFile(masterFile);
		//syncOldMaster(masterFile);
		
		
		
		
		
		
	}
	/**
	 * This is to ensure old master file is updated when adding/editing new master File
	 * for backward compatibility
	 * @param masterFile
	 * @throws SystemException
	 */
	
	private void syncOldMaster(MasterFile masterFile) throws SystemException 
	{
		long chkItemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		if (chkItemTypeId == masterFile.getMasterTypeId())
		{
			ItemType itemType = checkOldItemType(masterFile);
			if (Validator.isNull(masterFile.getOldId()))
			{
				masterFile.setOldId(itemType.getItemTypeId());
				
			}
		}
		
		//library Type
		chkItemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		if (chkItemTypeId == masterFile.getMasterTypeId())
		{
			
			
			LibraryType libType;
			try {
				libType = LibraryTypeLocalServiceUtil.getLibraryType(masterFile.getOldId());
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				libType = LibraryTypeLocalServiceUtil.createLibraryType(CounterLocalServiceUtil.increment(LibraryType.class.getName()));
				masterFile.setOldId(libType.getLibraryTypeId());
			}
			libType.setLibraryTypeName(masterFile.getMasterFileName());
			
			LibraryTypeLocalServiceUtil.updateLibraryType(libType);	
			
		}
		//state
		chkItemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
		if (chkItemTypeId == masterFile.getMasterTypeId())
		{
			
			
			State state;
			try {
				state = StateLocalServiceUtil.getState(masterFile.getOldId());
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				state = StateLocalServiceUtil.createState(CounterLocalServiceUtil.increment(State.class.getName()));
				masterFile.setOldId(state.getStateId());
			}
			state.setStateName(masterFile.getMasterFileName());
			state.setStateCode(masterFile.getMasterCode());
			StateLocalServiceUtil.updateState(state);	
				
			
		}
		//library
		chkItemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
		if (chkItemTypeId == masterFile.getMasterTypeId())
		{
			
			
			Library library;
			try {
				library = LibraryLocalServiceUtil.getLibrary(masterFile.getOldId());
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				library = LibraryLocalServiceUtil.createLibrary(CounterLocalServiceUtil.increment(Library.class.getName()));
				masterFile.setOldId(library.getLibraryId());
			}
			library.setLibraryName(masterFile.getMasterFileName());
			library.setLibraryCode(masterFile.getMasterCode());
			library.setStateId(masterFile.getParentId1());
			library.setLibraryTypeId(masterFile.getParentId2());
			
			LibraryLocalServiceUtil.updateLibrary(library);	
				
			
		}
		
		
		
		
		
		
		
		MasterFileLocalServiceUtil.updateMasterFile(masterFile);
	}
	
	private ItemType checkOldItemType(MasterFile masterFile) throws SystemException
	{
		ItemType itemType = null;
		
		if (Validator.isNotNull(masterFile.getOldId()))
		{
			itemType = ItemTypeLocalServiceUtil.fetchItemType(masterFile.getOldId());
		}else
		{
			itemType = ItemTypeLocalServiceUtil.createItemType(CounterLocalServiceUtil.increment(ItemType.class.getName()));
		}
		itemType.setItemTypeName(masterFile.getMasterFileName());
		if (masterFile.getStatus1())
			itemType.setPrintedType(1);
		
		if (masterFile.getStatus2())
			itemType.setPrintedType(2);
		
		itemType.setIRType(masterFile.getStatus3());
		return ItemTypeLocalServiceUtil.updateItemType(itemType);
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	public void editMasterType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long masterTypeId = ParamUtil.getLong(actionRequest, "masterTypeId");
		String name = ParamUtil.getString(actionRequest, "masterTypeName");
		String pageLabel = ParamUtil.getString(actionRequest, "pageLabel");
		String nameLabel = ParamUtil.getString(actionRequest, "nameLabel");
		
		boolean parentType = ParamUtil.getBoolean(actionRequest, "parentType");
		boolean hasParent1 = ParamUtil.getBoolean(actionRequest, "hasParent1");
		long parentId1 = ParamUtil.getLong(actionRequest, "parent1");
		String parent1Label = ParamUtil.getString(actionRequest, "parent1Label");
		
		
		boolean hasParent2 = ParamUtil.getBoolean(actionRequest, "hasParent2");
		long parentId2 = ParamUtil.getLong(actionRequest, "parent2");
		String parent2Label = ParamUtil.getString(actionRequest, "parent2Label");
		
		
		boolean hasStatus1 = ParamUtil.getBoolean(actionRequest, "hasStatus1");
		
		
		String status1Label = ParamUtil.getString(actionRequest, "status1Label");
		
		boolean hasStatus2 = ParamUtil.getBoolean(actionRequest, "hasStatus2");
		String status2Label = ParamUtil.getString(actionRequest, "status2Label");
		
		boolean hasStatus3 = ParamUtil.getBoolean(actionRequest, "hasStatus3");
		String status3Label = ParamUtil.getString(actionRequest, "status3Label");
		
		
		boolean hasStatus4 = ParamUtil.getBoolean(actionRequest, "hasStatus4");
		String status4Label = ParamUtil.getString(actionRequest, "status4Label");
		
		boolean hasStatus5 = ParamUtil.getBoolean(actionRequest, "hasStatus5");
		String status5Label = ParamUtil.getString(actionRequest, "status5Label");
		
		boolean hasCode = ParamUtil.getBoolean(actionRequest, "hasCode");
		String codeLabel = ParamUtil.getString(actionRequest, "codeLabel");
		
		
		MasterType masterType = null;
		if (Validator.isNull(masterTypeId))
		{
			masterTypeId = CounterLocalServiceUtil.increment(MasterType.class.getName());
			masterType = MasterTypeLocalServiceUtil.createMasterType(masterTypeId);
		}else
		{
			masterType = MasterTypeLocalServiceUtil.fetchMasterType(masterTypeId);
		}
		masterType.setMasterTypeName(name);
		masterType.setHasParent1(hasParent1);
		masterType.setHasParent2(hasParent2);
		masterType.setHasStatus1(hasStatus1);
		masterType.setHasStatus2(hasStatus2);
		masterType.setHasStatus3(hasStatus3);
		masterType.setHasStatus4(hasStatus4);
		masterType.setHasStatus5(hasStatus5);
		masterType.setNameLabel(nameLabel);
		masterType.setPageLabel(pageLabel);
		masterType.setStatus1Label(status1Label);
		masterType.setStatus2Label(status2Label);
		masterType.setStatus3Label(status3Label);
		masterType.setStatus4Label(status4Label);
		masterType.setStatus5Label(status5Label);
		
		masterType.setParentId1(parentId1);
		masterType.setParentId2(parentId2);
		masterType.setParent1Label(parent1Label);
		masterType.setParent2Label(parent2Label);
		masterType.setParentType(parentType);
		
		masterType.setHasCode(hasCode);
		masterType.setCodeLabel(codeLabel);
		
		
		MasterTypeLocalServiceUtil.updateMasterType(masterType);
		
	}
	public void editDbBoxTitle(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		String boxTitle = ParamUtil.getString(actionRequest, "boxTitle");
		String boxId = ParamUtil.getString(actionRequest, "boxId");
		
		LOGGER.info("nbox="+boxId + ":" + boxTitle);
		String key = "dashboard.box.title." + boxId;
		ConfigLocalServiceUtil.addByStringValue(key, boxTitle);
	}
	
	public void deleteMasterType(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long masterTypeId = ParamUtil.getLong(actionRequest, "masterId");
		MasterTypeLocalServiceUtil.deleteMasterType(masterTypeId);
		
	}
	
	public void editReport(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long reportId = ParamUtil.getLong(actionRequest, "reportId"); 
		
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		String reportKey = ParamUtil.getString(actionRequest, "reportKey");
		String reportTitle = ParamUtil.getString(actionRequest, "reportTitle");
		String reportName = ParamUtil.getString(actionRequest, "reportName");
		boolean dataEntry = ParamUtil.getBoolean(actionRequest, "dataEntry");
		
		
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		Report report = null;
		
		if (Validator.isNull(reportId))
		{
			report = ReportLocalServiceUtil.addReport(reportKey, reportName, reportTitle,dataEntry);
		}else
		{
			report = ReportLocalServiceUtil.fetchReport(reportId);
			report.setReportKey(reportKey);
			report.setReportTitle(reportTitle);
			report.setDataEntry(dataEntry);
			
			ReportLocalServiceUtil.updateReport(report);
			
		}
		
		
		
		//actionResponse.sendRedirect(redirect);
		
		
	}
	
	public void importMaster(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		
		
		try {
			importState();
			importLibraryType();
			importLibrary();
			importPTJType();
			importPTJ();
			importItemType();
			importItemMedium();
			importPostCategory();
			importPostGrade();
			importVisitorCategory();
			importMembershipCategory();
			importSeatingDepartment();
			importSeatingCategory();
			importUserLibrary();
	
			
			
			
			
			
		} catch (NoSuchMasterFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void importUserLibrary() throws SystemException
	{
		List<UserLibrary> userLibraries = UserLibraryLocalServiceUtil.getUserLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		long libraryType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
		for (UserLibrary ul : userLibraries)
		{
			try {
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryType, ul.getLibraryId());
				ul.setLibraryId(library.getMasterFileId());
				UserLibraryLocalServiceUtil.updateUserLibrary(ul);
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	private void importSeatingCategory() throws SystemException
	{
		List<SeatingCategory> seatingCategories = SeatingCategoryLocalServiceUtil.getSeatingCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long seatingCategoryId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_CATEGORY);
		
		for (SeatingCategory category : seatingCategories)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(seatingCategoryId, category.getSeatingCategoryName());
				
			} catch (NoSuchMasterFileException e) {
				
				//FacultyType parent = FacultyTypeLocalServiceUtil.fetchFacultyType(ptj.getFacultyTypeId());
				//long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, parent.getFacultyTypeName()).getMasterFileId();
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(seatingCategoryId);
				masterFile.setMasterFileName(category.getSeatingCategoryName());
				
				long seatingDeptId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_DEPARTMENT);
				try
				{
					MasterFile parent = MasterFileLocalServiceUtil.findByTypeOldId(seatingDeptId, category.getSeatingDepartmentId());
					masterFile.setParentId1(parent.getMasterFileId());
				}  catch (NoSuchMasterFileException ex) {}
				//masterFile.setMasterCode(postGrade.getPostGradeCode());
				
				masterFile.setOldId(category.getSeatingCategoryId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
		
	}
	
	
	private void importSeatingDepartment() throws SystemException
	{
		List<SeatingDepartment> seatingDepartments = SeatingDepartmentLocalServiceUtil.getSeatingDepartments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long seatingDepartmentId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_DEPARTMENT);
		
		for (SeatingDepartment dept : seatingDepartments)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(seatingDepartmentId, dept.getDepartmentName());
				
			} catch (NoSuchMasterFileException e) {
				
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(seatingDepartmentId);
				masterFile.setMasterFileName(dept.getDepartmentName());
				
				
				
				masterFile.setOldId(dept.getDepartmentId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
	}
	
	private void importMembershipCategory() throws SystemException
	{
		List<MemberCategory> memberCategories = MemberCategoryLocalServiceUtil.getMemberCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long memberCategoryId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEMBERSHIP_CATEGORY);
		
		for (MemberCategory memberCategory : memberCategories)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(memberCategoryId, memberCategory.getMemberCategoryName());
				
			} catch (NoSuchMasterFileException e) {
				
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(memberCategoryId);
				masterFile.setMasterFileName(memberCategory.getMemberCategoryName());
				
				
				
				masterFile.setOldId(memberCategory.getMemberCategoryId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
	}
	
	
	private void importVisitorCategory() throws SystemException
	{
		List<VisitorCategory> visitorCategories = VisitorCategoryLocalServiceUtil.getVisitorCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long visitorCategoryId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_VISITOR_CATEGORY);
		
		for (VisitorCategory visitorCategory : visitorCategories)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(visitorCategoryId, visitorCategory.getVisitorCategoryName());
				
			} catch (NoSuchMasterFileException e) {
				
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(visitorCategoryId);
				masterFile.setMasterFileName(visitorCategory.getVisitorCategoryName());
				
				
				
				masterFile.setOldId(visitorCategory.getVisitorCategoryId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
	}
	
	private void importPostGrade() throws SystemException
	{
		List<PostGrade> postGrades = PostGradeLocalServiceUtil.getPostGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long postGradeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_POST_GRADE);
		
		for (PostGrade postGrade : postGrades)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(postGradeId, postGrade.getPostGradeName());
				
			} catch (NoSuchMasterFileException e) {
				
				//FacultyType parent = FacultyTypeLocalServiceUtil.fetchFacultyType(ptj.getFacultyTypeId());
				//long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, parent.getFacultyTypeName()).getMasterFileId();
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(postGradeId);
				masterFile.setMasterFileName(postGrade.getPostGradeName());

				long postCategoryId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_POST_GRADE_CATEGORY);
				try
				{
					MasterFile parent = MasterFileLocalServiceUtil.findByTypeOldId(postCategoryId, postGrade.getPostCategoryId());
					masterFile.setParentId1(parent.getMasterFileId());
				}  catch (NoSuchMasterFileException ex) {}
				//masterFile.setMasterCode(postGrade.getPostGradeCode());
				
				//masterFile.setParentId1(postGrade.getPostCategoryId());
				masterFile.setMasterCode(postGrade.getPostGradeCode());
				
				masterFile.setOldId(postGrade.getPostGradeId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
		
	}
	
	private void importPostCategory() throws SystemException
	{
		List<PostCategory> postCategories = PostCategoryLocalServiceUtil.getPostCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long postCategoryId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_POST_GRADE_CATEGORY);
		
		for (PostCategory postCategory : postCategories)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(postCategoryId, postCategory.getPostCategoryName());
				
			} catch (NoSuchMasterFileException e) {
				
				//FacultyType parent = FacultyTypeLocalServiceUtil.fetchFacultyType(ptj.getFacultyTypeId());
				//long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, parent.getFacultyTypeName()).getMasterFileId();
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(postCategoryId);
				masterFile.setMasterFileName(postCategory.getPostCategoryName());
				
				
				
				masterFile.setOldId(postCategory.getPostCategoryId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
		
	}
	
	private void importItemMedium() throws SystemException
	{
		List<ItemMedium> itemMediums = ItemMediumLocalServiceUtil.getItemMediums(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long itemMediumId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEDIUM_TYPE);
		
		for (ItemMedium itemMedium : itemMediums)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(itemMediumId, itemMedium.getItemMediumName());
				
			} catch (NoSuchMasterFileException e) {
				
				//FacultyType parent = FacultyTypeLocalServiceUtil.fetchFacultyType(ptj.getFacultyTypeId());
				//long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, parent.getFacultyTypeName()).getMasterFileId();
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(itemMediumId);
				masterFile.setMasterFileName(itemMedium.getItemMediumName());
				
				
				
				masterFile.setOldId(itemMedium.getItemMediumId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
		
	}
	
	private void importItemType() throws SystemException
	{
		List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		
		for (ItemType itemType : itemTypes)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(itemTypeId, itemType.getItemTypeName());
				
			} catch (NoSuchMasterFileException e) {
				
				//FacultyType parent = FacultyTypeLocalServiceUtil.fetchFacultyType(ptj.getFacultyTypeId());
				//long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, parent.getFacultyTypeName()).getMasterFileId();
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(itemTypeId);
				masterFile.setMasterFileName(itemType.getItemTypeName());
				
				boolean printedType = itemType.getPrintedType() == 1;
				boolean nonPrintedType = itemType.getPrintedType() == 2;
				boolean irType = itemType.getIRType() ;
				//masterFile.setParentId1(parentId1);
				masterFile.setStatus1(printedType);
				masterFile.setStatus2(nonPrintedType);
				masterFile.setStatus3(irType);
				masterFile.setStatus4(true);
				
				masterFile.setOldId(itemType.getItemTypeId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
		
		
	}
	
	private void importPTJ() throws SystemException, NoSuchMasterFileException
	{
		List<Faculty> faculties = FacultyLocalServiceUtil.getFaculties(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long ptjTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ_TYPE);
		long ptjId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ);
		
		

		
		for (Faculty ptj : faculties)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(ptjId, ptj.getFacultyName());
				
			} catch (NoSuchMasterFileException e) {
				
				FacultyType parent = FacultyTypeLocalServiceUtil.fetchFacultyType(ptj.getFacultyTypeId());
				long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, parent.getFacultyTypeName()).getMasterFileId();
					
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(ptjId);
				masterFile.setMasterFileName(ptj.getFacultyName());
				masterFile.setParentId1(parentId1);
				
				masterFile.setOldId(ptj.getFacultyId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
		}
		
		
	}
	
	private void importPTJType() throws SystemException
	{
		long ptjTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ_TYPE);
		List<FacultyType> ptjTypes = FacultyTypeLocalServiceUtil.getFacultyTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (FacultyType ptjType : ptjTypes)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(ptjTypeId, ptjType.getFacultyTypeName());
			} catch (NoSuchMasterFileException e) {
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(ptjTypeId);
				masterFile.setMasterFileName(ptjType.getFacultyTypeName());
				masterFile.setOldId(ptjType.getFacultyTypeId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
		}

	}
	
	private void importLibraryType() throws SystemException
	{
		long libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		List<LibraryType> libraryTypes = LibraryTypeLocalServiceUtil.getLibraryTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		for (LibraryType libType : libraryTypes)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(libraryTypeId, libType.getLibraryTypeName());
			} catch (NoSuchMasterFileException e) {
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(libraryTypeId);
				masterFile.setMasterFileName(libType.getLibraryTypeName());
				masterFile.setOldId(libType.getLibraryTypeId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
	}
	
	private void importLibrary() throws SystemException, NoSuchMasterFileException
	{
		List<Library> libraries = LibraryLocalServiceUtil.getLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long libraryType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
		long libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		long stateType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
		

		
		for (Library library : libraries)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(libraryType, library.getLibraryName());
				
			} catch (NoSuchMasterFileException e) {
				
				long parentId1 = MasterFileLocalServiceUtil.findByTypeAndName(stateType, library.getStateName()).getMasterFileId();
				
				LibraryType libType = LibraryTypeLocalServiceUtil.fetchLibraryType(library.getLibraryTypeId());
				long parentId2 = MasterFileLocalServiceUtil.findByTypeAndName(libraryTypeId, libType.getLibraryTypeName()).getMasterFileId();
				
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(libraryType);
				masterFile.setMasterFileName(library.getLibraryName());
				masterFile.setParentId1(parentId1);
				masterFile.setParentId2(parentId2);
				masterFile.setOldId(library.getLibraryId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
		}
		
	}
	
	private void importState() throws SystemException
	{
		List<State> states = StateLocalServiceUtil.getStates(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long stateType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
		
		for (State state : states)
		{
			MasterFile masterFile = null;
			try {
				masterFile = MasterFileLocalServiceUtil.findByTypeAndName(stateType, state.getStateName());
			} catch (NoSuchMasterFileException e) {
				masterFile = MasterFileLocalServiceUtil.createMasterFile(CounterLocalServiceUtil.increment(MasterFile.class.getName()));
				masterFile.setMasterTypeId(stateType);
				masterFile.setMasterFileName(state.getStateName());
				masterFile.setOldId(state.getStateId());
				MasterFileLocalServiceUtil.updateMasterFile(masterFile);
			}
			
		}
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
        
        if (resourceID.equals(EisUtil.RESOURCE_EIS_INFO_BOX_TEMPLATE)) 
        {
        	try {
				serveInfoBoxTemplate(request,response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	private void serveInfoBoxTemplate(ResourceRequest request, ResourceResponse response) throws IOException, PortalException, SystemException
	{
		long templateId = ParamUtil.getLong(request, "templateId");
		Config template = ConfigLocalServiceUtil.getConfig(templateId);
		if (Validator.isNotNull(template))
		{

			PrintWriter out = response.getWriter();
			//out.print(jsonArray.toString());
			out.print(template.getValue());
			
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
         
        SearchContainer<MasterFile> libraryListSearchContainer = new SearchContainer<MasterFile>(
        		request, null, null, "cur", 1, 20,
                iteratorURL, null, "No Library found.");
        
        long libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
        
        List<MasterFile> libraries = MasterFileLocalServiceUtil.findByParent1(libraryTypeId,stateId);//, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        int total = libraries.size();
        
        libraryListSearchContainer.setResults(libraries);
        libraryListSearchContainer.setTotal(total);
        request.setAttribute("libraryListSearchContainer", libraryListSearchContainer);
        include("/html/admin/libraryList.jsp",request,response); 
        
	}
	
	public void runTester(ActionRequest actionRequest,ActionResponse actionResponse)
	{
		Tester.testNotification();
	}
	
	
	private static Log LOGGER = LogFactoryUtil.getLog(EisAdminPortlet.class);
}

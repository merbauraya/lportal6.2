package com.idetronic.eis.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import com.idetronic.eis.model.BorrowerCategory;
import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.FactMembership;
import com.idetronic.eis.model.FactNonPrintedMaterial;
import com.idetronic.eis.model.FactPost;
import com.idetronic.eis.model.FactPrintedMaterial;
import com.idetronic.eis.model.FactSeating;
import com.idetronic.eis.model.FactVisitor;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.Loan;
import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.model.Project;
import com.idetronic.eis.model.ProjectActivity;
import com.idetronic.eis.model.ProjectStrategy;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.service.BorrowerCategoryLocalServiceUtil;
import com.idetronic.eis.service.FactIrItemLocalServiceUtil;
import com.idetronic.eis.service.FactIrSubmissionLocalServiceUtil;
import com.idetronic.eis.service.FactMembershipLocalServiceUtil;
import com.idetronic.eis.service.FactNonPrintedMaterialLocalServiceUtil;
import com.idetronic.eis.service.FactPostLocalServiceUtil;
import com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil;
import com.idetronic.eis.service.FactSeatingLocalServiceUtil;
import com.idetronic.eis.service.FactVisitorLocalServiceUtil;
import com.idetronic.eis.service.ItemMediumLocalServiceUtil;
import com.idetronic.eis.service.ItemTypeLocalServiceUtil;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.LoanLocalServiceUtil;
import com.idetronic.eis.service.MemberCategoryLocalServiceUtil;
import com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.PostGradeLocalServiceUtil;
import com.idetronic.eis.service.PrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.ProjectActivityLocalServiceUtil;
import com.idetronic.eis.service.ProjectLocalServiceUtil;
import com.idetronic.eis.service.ProjectStrategyLocalServiceUtil;
import com.idetronic.eis.service.SeatingCategoryLocalServiceUtil;
import com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil;
import com.idetronic.eis.service.VisitorCategoryLocalServiceUtil;
import com.idetronic.eis.util.EisUtil;
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
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class EisPortlet extends MVCPortlet  
{
	
	public void editSeating(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		String period = ParamUtil.getString(actionRequest, "period");
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		List<SeatingDepartment> departments = SeatingDepartmentLocalServiceUtil.getSeatingDepartments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<SeatingCategory> categories = SeatingCategoryLocalServiceUtil.getSeatingCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (SeatingDepartment department : departments)
		{
			for (SeatingCategory category : categories)
			{
				String inputName = department.getDepartmentId() + "-" + category.getSeatingCategoryId();
				String capacity = ParamUtil.getString(actionRequest, inputName);
				
					JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
					jsonObject.put("categoryId", category.getSeatingCategoryId());
					jsonObject.put("departmentId", department.getDepartmentId());
					jsonObject.put("capacity", capacity);
					jsonArray.put(jsonObject);
				
				
				
			}
		}
		
		FactSeatingLocalServiceUtil.bacthInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);

		
	}
	
	public void editIrItem(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		long facultyId = ParamUtil.getLong(actionRequest, "faculty");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		List<ItemType> irItems = ItemTypeLocalServiceUtil.getIRType(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		List<ItemMedium> mediums = ItemMediumLocalServiceUtil.getItemMediums(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (ItemType itemType : irItems)
		{

			for (ItemMedium medium: mediums)
			{
				
				String label = itemType.getItemTypeId() + "-" + medium.getItemMediumId();
				String titleTotal = ParamUtil.getString(actionRequest, label + "-title");
				String volumeTotal = ParamUtil.getString(actionRequest, label + "-volume");
				
				
				
				
				
				//if (titleTotal > 0 || volumeTotal > 0)
				//{
					JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
					jsonObject.put("itemTypeId", itemType.getItemTypeId());
					jsonObject.put("itemMediumId", medium.getItemMediumId());
					
					// our naming format: x-y-title : x-item type, y=medium
					
					
					jsonObject.put("titleTotal", titleTotal);
					jsonObject.put("volumeTotal", volumeTotal);
					
					jsonArray.put(jsonObject);
				//}
				
			}
		}
		
		FactIrItemLocalServiceUtil.batchInsert(libraryId,facultyId,period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);

	}
	
	public void editExpense(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		
		
	}
	
	public void editIrSubmission(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		long facultyId = ParamUtil.getLong(actionRequest, "faculty");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");

		List<ItemMedium> mediums = ItemMediumLocalServiceUtil.getItemMediums(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ItemMedium medium : mediums)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			long mediumId = medium.getItemMediumId();
			jsonObject.put("itemMediumId", mediumId);
			
			int titleTotal = ParamUtil.getInteger(actionRequest, mediumId + "-title");
			int volumeTotal = ParamUtil.getInteger(actionRequest, mediumId + "-volume");
			
			jsonObject.put("titleTotal", titleTotal);
			jsonObject.put("volumeTotal", volumeTotal);
			
			
			jsonArray.put(jsonObject);

		}
		
		FactIrSubmissionLocalServiceUtil.batchInsert(libraryId, facultyId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);

	}
	
	public void editVisitor(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		List<VisitorCategory> categories = VisitorCategoryLocalServiceUtil.getVisitorCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (VisitorCategory category : categories)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			jsonObject.put("visitorCategoryId", category.getVisitorCategoryId());
			String value = ParamUtil.getString(actionRequest, category.getVisitorCategoryId() + "-value");
			
			jsonObject.put("value", value);
			
			
			jsonArray.put(jsonObject);
		}
		FactVisitorLocalServiceUtil.bacthInsert(libraryId, period, jsonArray, serviceContext); 
		actionResponse.sendRedirect(redirect);

	}
	
	
	
	public void editFactPost(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		List<PostGrade> postGrades = PostGradeLocalServiceUtil.getPostGrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (PostGrade postGrade : postGrades)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			jsonObject.put("postGradeId", postGrade.getPostGradeId());
			String value = ParamUtil.getString(actionRequest, postGrade.getPostGradeId() + "-value");
			
			jsonObject.put("value", value);
			
			
			jsonArray.put(jsonObject);
		}
		FactPostLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);

	}
	
	public void editMembership(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		List<MemberCategory> categories = MemberCategoryLocalServiceUtil.getMemberCategories(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MemberCategory category : categories)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			jsonObject.put("categoryId", category.getMemberCategoryId());
			String value = ParamUtil.getString(actionRequest, category.getMemberCategoryId() + "-value");
			
			
			jsonObject.put("value", value);
			
			
			jsonArray.put(jsonObject);
		}
		FactMembershipLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
	}
	
	
	public void editLoan(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		List<MemberCategory> categories = MemberCategoryLocalServiceUtil.getMemberCategories(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MemberCategory category : categories)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			jsonObject.put("categoryId", category.getMemberCategoryId());
			String value = ParamUtil.getString(actionRequest, category.getMemberCategoryId() + "-value");
			
			
			jsonObject.put("value", value);
			
			
			jsonArray.put(jsonObject);
		}
		LoanLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
	}
	
	
	public void editNonPrintedItem(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		
		
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getNonPrintedType(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (ItemType itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			jsonObject.put("id", itemType.getItemTypeId());
			String volume = ParamUtil.getString(actionRequest, itemType.getItemTypeId() + "-volume");
			String title = ParamUtil.getString(actionRequest, itemType.getItemTypeId() +"-title");
			
			jsonObject.put("volume", volume);
			jsonObject.put("title", title);
			
			jsonArray.put(jsonObject);
			
		}
		FactNonPrintedMaterialLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
	}
	
	public void editPrintedItem(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException 
	{
		List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getPrintedType(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (ItemType itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			jsonObject.put("id", itemType.getItemTypeId());
			String volume = ParamUtil.getString(actionRequest, itemType.getItemTypeId() + "-volume");
			String title = ParamUtil.getString(actionRequest, itemType.getItemTypeId() +"-title");
			
			jsonObject.put("volume", volume);
			jsonObject.put("title", title);
			
			jsonArray.put(jsonObject);
			
		}
		FactPrintedMaterialLocalServiceUtil.multiUpdate(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
	}
	
	public void deleteActivity(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		long activityId = ParamUtil.getLong(actionRequest, "activityId");
		
		ProjectActivityLocalServiceUtil.deleteProjectActivity(activityId);
		
	}
	
	
	/**
	 * Delete strategy and all associated activities
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException 
	 */
	public void deleteStrategy(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		long strategyId =  ParamUtil.getLong(actionRequest, "strategyId");
		ProjectStrategyLocalServiceUtil.deleteStrategyAll(strategyId);
		
	}
	
	/**
	 * Delete project and all associated strategy/activity
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException 
	 */
	public void deleteProject(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
	{
		 long projectId = ParamUtil.getLong(actionRequest, "projectId");
		 
		 
		 //to delete project we need to delete
		 //add strategy and activity
		 ProjectLocalServiceUtil.deleteProjectAll(projectId);
		 
	}
	
	public void editProject(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		 long projectId = ParamUtil.getLong(actionRequest, "projectId");
		 String projectName = ParamUtil.getString(actionRequest, "projectName");
		
		 
		 
		 int projectStatus = ParamUtil.getInteger(actionRequest, "projectStatus");
		 int progress = ParamUtil.getInteger(actionRequest, "progress");
		 String resourceName = ParamUtil.getString(actionRequest, "resourceName");
		 String resourceType = ParamUtil.getString(actionRequest, "resourceType");
		 
		 int completionDay = ParamUtil.getInteger(actionRequest, "completionDay");
		 int completionMonth = ParamUtil.getInteger(actionRequest, "completionMonth");
		 int completionYear = ParamUtil.getInteger(actionRequest, "completionYear");
		 String completionDateString = ParamUtil.getString(actionRequest, "completionDate");
		 
		 int dayStartDay = ParamUtil.getInteger(actionRequest, "dateStartDay");
		 int dayStartMonth = ParamUtil.getInteger(actionRequest, "dateStartMonth");
		 int dayStartYear = ParamUtil.getInteger(actionRequest, "dateStartYear");
		 String startDateString = ParamUtil.getString(actionRequest, "startDate");
		 
		 int dayEndDay = ParamUtil.getInteger(actionRequest, "dateEndDay");
		 int dayEndMonth = ParamUtil.getInteger(actionRequest, "dateEndMonth");
		 int dayEndYear = ParamUtil.getInteger(actionRequest, "dateEndYear");
		 String endDateString = ParamUtil.getString(actionRequest, "endDate");
		 
		 int progressStatus = ParamUtil.getInteger(actionRequest, "progressStatus");
		 
		 //Date startDate = ParamUtil.getDate(actionRequest, "startDate", dateFormat);
		 
		 ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Project.class.getName(), actionRequest);
		 
		 Date completionDate  = null;
		 
		 if (Validator.isNotNull(completionYear) && Validator.isNotNull(completionDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(completionYear, completionMonth, completionDay);//, hour, minute, second);
			 completionDate = cal.getTime(); // get back a Date object
		 }
		 Date startDate  = null;
		 if (Validator.isNotNull(dayStartYear) && Validator.isNotNull(startDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(dayStartYear, dayStartMonth, dayStartDay);//, hour, minute, second);
			 startDate = cal.getTime(); // get back a Date object
		 }
		 
		 Date endDate  = null;
		 if (Validator.isNotNull(dayEndYear) && Validator.isNotNull(endDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(dayEndYear, dayEndMonth, dayEndDay);//, hour, minute, second);
			 endDate = cal.getTime(); // get back a Date object
		 }
		
		 
		 
		 Project project = null;
		 if (Validator.isNull(projectId))
		 {
			 project = ProjectLocalServiceUtil.addProject(projectName, projectStatus, startDate, endDate, progressStatus,
					 progress, resourceName, resourceType, completionDate,serviceContext);
		 }else
		 {
			 project = ProjectLocalServiceUtil.getProject(projectId);
			 project.setProjectName(projectName);
			 project.setModifiedDate(new Date());
		
			 project.setStartDate(startDate);
			 project.setEndDate(endDate);
			 project.setProgress(progress);
			 project.setProjectStatus(projectStatus);
			 project.setResourceName(resourceName);
			 project.setResourceType(resourceType);
			 //project.setStartMonthName(EisUtil.getMonthName(startMonth));
			 //project.setEndMonthName(EisUtil.getMonthName(endMonth));
			 project.setCompletionDate(completionDate);
			 project.setProgressStatus(progressStatus);
			 
			 ProjectLocalServiceUtil.updateProject(project);
			 
		 }
		 
		 
	}
	public void editStrategy(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		 long projectId = ParamUtil.getLong(actionRequest, "projectId");
		 long strategyId = ParamUtil.getLong(actionRequest, "projectStrategyId");
		 
		 String strategyName = ParamUtil.getString(actionRequest, "strategyName");
		 int startYear = ParamUtil.getInteger(actionRequest, "startYear");
		 int startMonth = ParamUtil.getInteger(actionRequest, "startMonth");
		 
		 int endYear = ParamUtil.getInteger(actionRequest, "endYear"); 
		 int endMonth = ParamUtil.getInteger(actionRequest, "endMonth");
		 
		 int status = ParamUtil.getInteger(actionRequest, "strategyStatus");
		 int progress = ParamUtil.getInteger(actionRequest, "progress");
		 
		 int completionDay = ParamUtil.getInteger(actionRequest, "completionDay");
		 int completionMonth = ParamUtil.getInteger(actionRequest, "completionMonth");
		 int completionYear = ParamUtil.getInteger(actionRequest, "completionYear");
		 
		 String completionDateString = ParamUtil.getString(actionRequest, "completionDate");
		 
		 int dayStartDay = ParamUtil.getInteger(actionRequest, "dateStartDay");
		 int dayStartMonth = ParamUtil.getInteger(actionRequest, "dateStartMonth");
		 int dayStartYear = ParamUtil.getInteger(actionRequest, "dateStartYear");
		 String startDateString = ParamUtil.getString(actionRequest, "startDate");
		 
		 int dayEndDay = ParamUtil.getInteger(actionRequest, "dateEndDay");
		 int dayEndMonth = ParamUtil.getInteger(actionRequest, "dateEndMonth");
		 int dayEndYear = ParamUtil.getInteger(actionRequest, "dateEndYear");
		 String endDateString = ParamUtil.getString(actionRequest, "endDate");
		 
		 int progressStatus = ParamUtil.getInteger(actionRequest, "progressStatus");
		 
		 String remark = ParamUtil.getString(actionRequest, "remark");
		 
		 ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         ProjectStrategy.class.getName(), actionRequest);
		 
		 Date completionDate  = null;
		 
		 if (Validator.isNotNull(completionYear) && Validator.isNotNull(completionDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 		 
			 
			 cal.setTimeInMillis(0);
			 cal.set(completionYear, completionMonth, completionDay);//, hour, minute, second);
			 completionDate = cal.getTime(); // get back a Date object
		 }
		 
		 Date startDate  = null;
		 if (Validator.isNotNull(dayStartYear) && Validator.isNotNull(startDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(dayStartYear, dayStartMonth, dayStartDay);//, hour, minute, second);
			 startDate = cal.getTime(); // get back a Date object
		 }
		 
		 Date endDate  = null;
		 if (Validator.isNotNull(dayEndYear) && Validator.isNotNull(endDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(dayEndYear, dayEndMonth, dayEndDay);//, hour, minute, second);
			 endDate = cal.getTime(); // get back a Date object
		 }
		 
		 String resourceName = ParamUtil.getString(actionRequest, "resourceName");
		 String resourceType = ParamUtil.getString(actionRequest, "resourceType");
	
		 
		 ProjectStrategy strategy = null;
		 if (Validator.isNull(strategyId))
		 {
			 strategy = ProjectStrategyLocalServiceUtil.add(projectId, strategyName, startDate, endDate, 
					 progressStatus, status, progress, 
					 resourceName, resourceType, completionDate,remark, serviceContext);
		 }else
		 {
			 strategy = ProjectStrategyLocalServiceUtil.fetchProjectStrategy(strategyId);
			 
			 strategy.setStrategyName(strategyName);
			 strategy.setModifiedDate(new Date());
			 strategy.setStartDate(startDate);
			 strategy.setEndDate(endDate);
			 strategy.setProgressStatus(progressStatus);
			 strategy.setProgress(progress);
			 strategy.setStatus(status);
			 strategy.setResourceName(resourceName);
			 strategy.setResourceType(resourceType);
			 strategy.setStartMonthName(EisUtil.getMonthName(startMonth));
			 strategy.setEndMonthName(EisUtil.getMonthName(endMonth));
			 strategy.setCompletionDate(completionDate);
			 strategy.setRemark(remark);
			 ProjectStrategyLocalServiceUtil.updateProjectStrategy(strategy);
			 
		 }
		 
		 
	}
	/**
	 * Edit Project Activity Action
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	
	public void editActivity(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
	{
		 
		 long strategyId = ParamUtil.getLong(actionRequest, "strategyId");
		 long activityId = ParamUtil.getLong(actionRequest, "activityId");
		 
		 String activityName = ParamUtil.getString(actionRequest, "activityName");
		 int startYear = ParamUtil.getInteger(actionRequest, "startYear");
		 int startMonth = ParamUtil.getInteger(actionRequest, "startMonth");
		 
		 int endYear = ParamUtil.getInteger(actionRequest, "endYear");
		 int endMonth = ParamUtil.getInteger(actionRequest, "endMonth");
		 
		 int status = ParamUtil.getInteger(actionRequest, "strategyStatus");
		 int progress = ParamUtil.getInteger(actionRequest, "progress");
		 
		 String completionDateStr = ParamUtil.getString(actionRequest, "completionDate");
		 int completionDay = ParamUtil.getInteger(actionRequest, "completionDay");
		 int completionMonth = ParamUtil.getInteger(actionRequest, "completionMonth");
		 int completionYear = ParamUtil.getInteger(actionRequest, "completionYear");
		 String completionDateString = ParamUtil.getString(actionRequest, "completionDate");
		 
		 int dayStartDay = ParamUtil.getInteger(actionRequest, "dateStartDay");
		 int dayStartMonth = ParamUtil.getInteger(actionRequest, "dateStartMonth");
		 int dayStartYear = ParamUtil.getInteger(actionRequest, "dateStartYear");
		 String startDateString = ParamUtil.getString(actionRequest, "startDate");
		 
		 int dayEndDay = ParamUtil.getInteger(actionRequest, "dateEndDay");
		 int dayEndMonth = ParamUtil.getInteger(actionRequest, "dateEndMonth");
		 int dayEndYear = ParamUtil.getInteger(actionRequest, "dateEndYear");
		 String endDateString = ParamUtil.getString(actionRequest, "endDate");
		 
		 int progressStatus = ParamUtil.getInteger(actionRequest, "progressStatus");
		 
		 
		 String remark = ParamUtil.getString(actionRequest, "remark");

		 ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         ProjectStrategy.class.getName(), actionRequest);
		 
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 
		 Date completionDate  = null;
		 if (Validator.isNotNull(completionYear) && Validator.isNotNull(completionDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 		 
			 
			 cal.setTimeInMillis(0);
			 cal.set(completionYear, completionMonth, completionDay);//, hour, minute, second);
			 completionDate = cal.getTime(); // get back a Date object
		 }
		 
		 Date startDate  = null;
		 if (Validator.isNotNull(dayStartYear) && Validator.isNotNull(startDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(dayStartYear, dayStartMonth, dayStartDay);//, hour, minute, second);
			 startDate = cal.getTime(); // get back a Date object
		 }
		 
		 Date endDate  = null;
		 if (Validator.isNotNull(dayEndYear) && Validator.isNotNull(endDateString))
		 {
			 Calendar cal = CalendarFactoryUtil.getCalendar(); 
			 cal.set(dayEndYear, dayEndMonth, dayEndDay);//, hour, minute, second);
			 endDate = cal.getTime(); // get back a Date object
		 }
		 
		 String resourceName = ParamUtil.getString(actionRequest, "resourceName");
		 String resourceType = ParamUtil.getString(actionRequest, "resourceType");
		 
	
		 
		 ProjectActivity activity = null;
		 if (Validator.isNull(activityId))
		 {
			 activity = ProjectActivityLocalServiceUtil.add(strategyId, activityName, startDate,endDate,progressStatus,
					 status, progress, resourceName, resourceType, 
					 completionDate,remark,serviceContext);
					 
					 
					 
		 }else
		 {
			 activity = ProjectActivityLocalServiceUtil.fetchProjectActivity(activityId);
			 
	
			 activity.setActivityName(activityName);
			 activity.setModifiedDate(new Date());
			 activity.setStartDate(startDate);
			 activity.setEndDate(endDate);
			 activity.setProgressStatus(progressStatus);
			 activity.setStartMonth(startMonth);
			 activity.setStartYear(startYear);
			 activity.setEndMonth(endMonth);
			 activity.setEndYear(endYear);
			 activity.setProgress(progress);
			 activity.setStatus(status);
			 activity.setResourceName(resourceName);
			 activity.setResourceType(resourceType);
			 activity.setStartMonthName(EisUtil.getMonthName(startMonth));
			 activity.setEndMonthName(EisUtil.getMonthName(endMonth));
			 activity.setCompletionDate(completionDate);
			 activity.setRemark(remark);
			 ProjectActivityLocalServiceUtil.updateProjectActivity(activity);
			 
		 }
		 
		 
	}
	public void serveResource(ResourceRequest request, ResourceResponse response)
            throws PortletException, IOException {
        
		String resourceID = request.getResourceID();
		
		
		
		
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
        if (resourceID.equals(EisUtil.RESOURCE_STRATEGY_LIST_JSON))
        {
        	
        	loadStrategyListJson(request,response);
        }
        if (resourceID.equals(EisUtil.RESOURCE_ACTIVITY_LIST))
        {
        	loadActivityList(request,response);
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_NON_PRINTED_ITEM_DATA))
        {
        	try {
				loadNonPrintedItemData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_LOAN_DATA))
        {
        	try {
				loadLoanData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if (resourceID.equals(EisUtil.RESOURCE_POST_DATA))
        {
        	try {
				loadPostData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_VISITOR_DATA))
        {
        	try {
				loadVisitorData(request,response);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
       
        
        if (resourceID.equals(EisUtil.RESOURCE_IR_SUBMISSION_DATA))
        {
        	loadResourceSubmissionData(request, response);
        }
        if(resourceID.equals(EisUtil.RESOURCE_IR_ITEM))
        {
        	try {
				loadIrItem(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if (resourceID.equals(EisUtil.RESOURCE_SEATING_DATA_LIST))
        {
        	try {
				lodSeatingData(request, response);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
        }
        if (resourceID.equals(EisUtil.RESOURCE_MEMBERSHIP_DATA))
        {
        	try {
				loadMembershipData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	protected void lodSeatingData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		boolean admin = isAdmin(request);
		
		List<FactSeating> datas = FactSeatingLocalServiceUtil.getLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
		
			for (FactSeating data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("categoryId", data.getSeatingCategoryId());
				jsonObject.put("departmentId", data.getDepartmentId());
				jsonObject.put("capacity", data.getCapacity());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactSeatingLocalServiceUtil.getEntries(libraryId, period));

			}
			
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	protected void loadIrItem (ResourceRequest request, ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "library");
		long facultyId = ParamUtil.getLong(request, "faculty");
		List<FactIrItem> datas = FactIrItemLocalServiceUtil.getLatestEntry(libraryId,facultyId,period);
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		

		try
		{
		
			for (FactIrItem data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("itemMediumId", data.getItemMediumId());
				jsonObject.put("itemTypeId", data.getItemTypeId());
				jsonObject.put("titleTotal", data.getTitleTotal());
				jsonObject.put("volumeTotal", data.getVolumeTotal());
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (isAdmin(request))
			{
				
				jsonData.put("history", FactIrItemLocalServiceUtil.getEntries(libraryId, period,facultyId));

			}
			
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	protected void loadResourceSubmissionData (ResourceRequest request, ResourceResponse response)
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		long facultyId = ParamUtil.getLong(request, "facultyId");
		
		List<FactIrSubmission> datas = FactIrSubmissionLocalServiceUtil.findLatestEntry(libraryId, facultyId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		try
		{
		
			for (FactIrSubmission data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", data.getItemMediumId());
				jsonObject.put("titleTotal", data.getTitleTotal());
				jsonObject.put("volumeTotal", data.getVolumeTotal());
				
				jsonArray.put(jsonObject);
			}
			PrintWriter out = response.getWriter();
			out.print(jsonArray.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	/**
	 * Check whether logged user is Omni admin or site admin
	 * @param request Resource Request
	 * @return
	 */
	protected boolean isAdmin(ResourceRequest request)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		
		return themeDisplay.getPermissionChecker().isOmniadmin() || themeDisplay.getPermissionChecker().isGroupAdmin(themeDisplay.getScopeGroupId());

	}
	
	protected void loadVisitorData(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		
		boolean admin = isAdmin(request);
		
		
		List<FactVisitor> datas = FactVisitorLocalServiceUtil.getLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();

		
		try
		{
		
			for (FactVisitor data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", data.getVisitorCategoryId());
				jsonObject.put("value", data.getValue());
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			
			if (admin)
			{
				
				jsonData.put("history", FactVisitorLocalServiceUtil.getEntries(libraryId, period));

			}
			
			
			
			PrintWriter out = response.getWriter();
			//out.print(jsonArray.toString());
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	
	
	protected void loadPostData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		
		List<FactPost> datas = FactPostLocalServiceUtil.getLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
		
			for (FactPost data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", data.getPostGradeId());
				jsonObject.put("value", data.getValue());
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			
			if (isAdmin(request))
			{
				
				jsonData.put("history", FactPostLocalServiceUtil.getEntries(libraryId, period));

			}
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadMembershipData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		
		
		
		List<FactMembership> memberships = FactMembershipLocalServiceUtil.getLatestEntry(libraryId, period);
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		
		try
		{
		
			for (FactMembership membership : memberships)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", membership.getMembershipCategoryId());
				jsonObject.put("value", membership.getActiveCount());
				jsonArray.put(jsonObject);
			}
			
			jsonData.put("data", jsonArray);
			if (isAdmin(request))
			{
				
				jsonData.put("history", FactMembershipLocalServiceUtil.getEntries(libraryId, period));

			}
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	
	protected void loadLoanData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		
		
		
		List<Loan> loans = LoanLocalServiceUtil.getLatestEntry(libraryId, period);
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
		
			for (Loan loan : loans)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", loan.getMemberCategoryId());
				jsonObject.put("value", loan.getValue());
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (isAdmin(request))
			{
				
				jsonData.put("history", LoanLocalServiceUtil.getEntries(libraryId, period));

			}
			
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadNonPrintedItemData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		
		List<FactNonPrintedMaterial> items = FactNonPrintedMaterialLocalServiceUtil.getAllItemLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
			for (FactNonPrintedMaterial item : items)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", item.getItemTypeId());
				jsonObject.put("period", period);
				jsonObject.put("volume", item.getVolumeTotal());
				jsonObject.put("title", item.getTitleTotal());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (isAdmin(request))
			{
				
				jsonData.put("history", FactNonPrintedMaterialLocalServiceUtil.getEntries(libraryId, period));

			}
			
			
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		
		} catch (IOException e) 
		{
				
				e.printStackTrace();
		}
			LOGGER.info(jsonArray.length());
			
			
	}
		
	 	
	protected void loadActivityList(ResourceRequest request, ResourceResponse response) throws IOException, PortletException 
	{
		long strategyId = ParamUtil.getLong(request, "strategyId");
		
		request.setAttribute("strategyId", strategyId);
	    include("/html/project/activityList.jsp",request,response); 
		
	    
	    /*
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		
		
		try
		{
			
			List<ProjectActivity> activities = ProjectActivityLocalServiceUtil.getByStrategy(strategyId) ;
			
			for (ProjectActivity activity : activities)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", activity.getProjectActivityId());
				jsonObject.put("name", activity.getActivityName());
				jsonObject.put("progress", activity.getProgress());
				jsonObject.put("completionDate", activity.getCompletionDate());
				jsonObject.put("resourceName", activity.getResourceName());
				jsonObject.put("resourceType", activity.getResourceType());
				jsonObject.put("status", activity.getStatus());
				jsonObject.put("startYear", activity.getStartYear());
				jsonObject.put("endYear", activity.getEndYear());
				jsonObject.put("startMonth", activity.getStartMonthName());
				jsonObject.put("endMonth", activity.getEndMonthName());
				
				jsonArray.put(jsonObject);
				
			}
			PrintWriter out = response.getWriter();
			
			out.print(jsonArray.toString());
		}
		 catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
		*/
	}
	
	protected void loadStrategyListJson(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
	{
		long projectId = ParamUtil.getLong(request, "projectId");
		
		
		List<ProjectStrategy> strategies = ProjectStrategyLocalServiceUtil.getByProject(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		request.setAttribute("projectId", projectId);
        include("/html/project/strategyList.jsp",request,response,PortletRequest.RESOURCE_PHASE); 

		/* 
		
		try
		{
			
			
			for (ProjectStrategy strategy : strategies)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", strategy.getProjectStrategyId());
				jsonObject.put("name", strategy.getStrategyName());
				jsonObject.put("progress", strategy.getProgress());
				jsonObject.put("completionDate", strategy.getCompletionDate());
				jsonObject.put("resourceName", strategy.getResourceName());
				jsonObject.put("resourceType", strategy.getResourceType());
				jsonObject.put("status", strategy.getStatus());
				jsonObject.put("startYear", strategy.getStartYear());
				jsonObject.put("endYear", strategy.getEndYear());
				
				jsonArray.put(jsonObject);
				
			}
			PrintWriter out = response.getWriter();
			
			out.print(jsonArray.toString());
		}
		 catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
          
        */  
		
		
	}
	protected void loadPrintedMaterialDataList(ResourceRequest request, ResourceResponse response) throws SystemException 
	{
		long libraryId = ParamUtil.getLong(request, "libraryId");
		String period = ParamUtil.getString(request, "period");
		
		List<FactPrintedMaterial> items = FactPrintedMaterialLocalServiceUtil.getLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
			for (FactPrintedMaterial item : items)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("id", item.getItemTypeId());
				jsonObject.put("period", period);
				jsonObject.put("volume", item.getVolumeTotal());
				jsonObject.put("title", item.getTitleTotal());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			
			if (isAdmin(request))
			{
				
				jsonData.put("history", FactPrintedMaterialLocalServiceUtil.getEntries(libraryId, period));

			}
			PrintWriter out = response.getWriter();
			out.print(jsonData.toString());
		
		} catch (IOException e) 
		{
				
				e.printStackTrace();
		}
			
        
		
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

	private static Log LOGGER = LogFactoryUtil.getLog(EisPortlet.class);

}

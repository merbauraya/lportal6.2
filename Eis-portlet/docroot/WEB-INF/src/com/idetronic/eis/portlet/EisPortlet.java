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

import com.idetronic.eis.NoSuchMasterFileException;
import com.idetronic.eis.model.BorrowerCategory;
import com.idetronic.eis.model.FactAcquisition;
import com.idetronic.eis.model.FactConsultation;
import com.idetronic.eis.model.FactData;
import com.idetronic.eis.model.FactDatabaseUsage;
import com.idetronic.eis.model.FactDigitalCollection;
import com.idetronic.eis.model.FactExpense;
import com.idetronic.eis.model.FactGiftReceived;
import com.idetronic.eis.model.FactIncome;
import com.idetronic.eis.model.FactInterLibLoan;
import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.FactItManagement;
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
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.model.MemberCategory;
import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.model.Project;
import com.idetronic.eis.model.ProjectActivity;
import com.idetronic.eis.model.ProjectStrategy;
import com.idetronic.eis.model.Report;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.service.BorrowerCategoryLocalServiceUtil;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.FactAcquisitionLocalServiceUtil;
import com.idetronic.eis.service.FactConsultationLocalServiceUtil;
import com.idetronic.eis.service.FactDataLocalServiceUtil;
import com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil;
import com.idetronic.eis.service.FactDigitalCollectionLocalServiceUtil;
import com.idetronic.eis.service.FactExpenseLocalServiceUtil;
import com.idetronic.eis.service.FactGiftReceivedLocalServiceUtil;
import com.idetronic.eis.service.FactIncomeLocalServiceUtil;
import com.idetronic.eis.service.FactInterLibLoanLocalServiceUtil;
import com.idetronic.eis.service.FactIrItemLocalServiceUtil;
import com.idetronic.eis.service.FactIrSubmissionLocalServiceUtil;
import com.idetronic.eis.service.FactItManagementLocalServiceUtil;
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
import com.idetronic.eis.service.MasterFileLocalServiceUtil;
import com.idetronic.eis.service.MemberCategoryLocalServiceUtil;
import com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.PostGradeLocalServiceUtil;
import com.idetronic.eis.service.PrintedItemTypeLocalServiceUtil;
import com.idetronic.eis.service.ProjectActivityLocalServiceUtil;
import com.idetronic.eis.service.ProjectLocalServiceUtil;
import com.idetronic.eis.service.ProjectStrategyLocalServiceUtil;
import com.idetronic.eis.service.ReportLocalServiceUtil;
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
	
	public void editConsultation(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		String period = ParamUtil.getString(actionRequest, "period");
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		long categoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_CONSULTATION_CATEGORY);
		List<MasterFile> categories = MasterFileLocalServiceUtil.findByMasterType(categoryTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (MasterFile category : categories)
		{
			String inputName = category.getMasterFileId() + "-value";
			String value = ParamUtil.getString(actionRequest, inputName);
			String totalSessionName = category.getMasterFileId() + "-sessionTotal";
			String totalSession = ParamUtil.getString(actionRequest, totalSessionName);
			if (Validator.isNotNull(value)) 
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("categoryId", category.getMasterFileId());
				jsonObject.put("value", value);
				jsonObject.put("session", totalSession);
				jsonArray.put(jsonObject);
		
			}
		}
		
		FactConsultationLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
	}
	
	public void editSeating(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		String period = ParamUtil.getString(actionRequest, "period");
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		//List<SeatingDepartment> departments = SeatingDepartmentLocalServiceUtil.getSeatingDepartments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		//List<SeatingCategory> categories = SeatingCategoryLocalServiceUtil.getSeatingCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		long seatingDeptTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_DEPARTMENT);
		List<MasterFile> departments = MasterFileLocalServiceUtil.findByMasterType(seatingDeptTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		//List<SeatingDepartment> departments = SeatingDepartmentLocalServiceUtil.getSeatingDepartments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long seatingCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_CATEGORY);
		//List<MasterFile> categories = SeatingCategoryLocalServiceUtil.getSeatingCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<MasterFile> categories = MasterFileLocalServiceUtil.findByMasterType(seatingCategoryTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (MasterFile department : departments)
		{
			for (MasterFile category : categories)
			{
				String inputName = department.getMasterFileId() + "-" + category.getMasterFileId();
				String capacity = ParamUtil.getString(actionRequest, inputName);
					if (Validator.isNotNull(capacity)) 
					{
						JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
						jsonObject.put("categoryId", category.getMasterFileId());
						jsonObject.put("departmentId", department.getMasterFileId());
						jsonObject.put("capacity", capacity);
						jsonArray.put(jsonObject);
				
					}
				
			}
		} 
		
		FactSeatingLocalServiceUtil.bacthInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);

		
	}
	
	public void editItemAcquisition(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		long facultyId = ParamUtil.getLong(actionRequest, "faculty");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		
		List<MasterFile> items = MasterFileLocalServiceUtil.findByTypeAndStatus5(itemTypeId, true);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		
		for (MasterFile item : items)
		{
			String titleTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-title");
			String volumeTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-volume");
			String amountTotal =  ParamUtil.getString(actionRequest, item.getMasterFileId() + "-amount");
			

			String approvedTitleTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-approvedTitleTotal");
			String approvedVolumeTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() +"-approvedVolumeTotal");
			String approvedAmountTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-approvedAmountTotal");
			
			String orderTitleTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-orderTitleTotal");
			String orderVolumeTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-orderVolumeTotal");
			String orderAmountTotal = ParamUtil.getString(actionRequest, item.getMasterFileId() + "-orderAmountTotal");
			
			
			
			//ensure at least one entry is filled
			if (Validator.isNotNull(titleTotal) || Validator.isNotNull(volumeTotal) || Validator.isNotNull(amountTotal)
					|| Validator.isNotNull(approvedTitleTotal) || Validator.isNotNull(approvedVolumeTotal)
					|| Validator.isNotNull(approvedAmountTotal) || Validator.isNotNull(orderTitleTotal)
					|| Validator.isNotNull(orderVolumeTotal) || Validator.isNotNull(orderAmountTotal))		
			{
			
				
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", item.getMasterFileId());
				
				
				// our naming format: x-y-title : x-item type, y=medium
				
				
				jsonObject.put("titleTotal", titleTotal);
				jsonObject.put("volumeTotal", volumeTotal);
				jsonObject.put("amountTotal", amountTotal);
				
				jsonObject.put("approvedTitleTotal", approvedTitleTotal);
				jsonObject.put("approvedVolumeTotal", approvedVolumeTotal);
				jsonObject.put("approvedAmountTotal", approvedAmountTotal);
				
				jsonObject.put("orderTitleTotal", orderTitleTotal);
				jsonObject.put("orderVolumeTotal", orderVolumeTotal);
				jsonObject.put("orderAmountTotal", orderAmountTotal);
				
				jsonArray.put(jsonObject);
			}
		}
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		FactAcquisitionLocalServiceUtil.batchInsert(libraryId,facultyId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
	}
	
	public void editIrItem(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		long facultyId = ParamUtil.getLong(actionRequest, "faculty");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		long itemMediumType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEDIUM_TYPE);
		
		List<MasterFile> irItems = MasterFileLocalServiceUtil.findByTypeAndStatus3(itemTypeId, true);// .getIRType(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		List<MasterFile> mediums = MasterFileLocalServiceUtil.findByMasterType(itemMediumType, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (MasterFile itemType : irItems)
		{

			for (MasterFile medium: mediums)
			{
				
				String label = itemType.getMasterFileId() + "-" + medium.getMasterFileId();
				String titleTotal = ParamUtil.getString(actionRequest, label + "-title");
				String volumeTotal = ParamUtil.getString(actionRequest, label + "-volume");
				
				
				if (Validator.isNotNull(titleTotal) && Validator.isNotNull(volumeTotal))
				{
				
					
					JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
					jsonObject.put("itemTypeId", itemType.getMasterFileId());
					jsonObject.put("itemMediumId", medium.getMasterFileId());
					
					// our naming format: x-y-title : x-item type, y=medium
					
					
					jsonObject.put("titleTotal", titleTotal);
					jsonObject.put("volumeTotal", volumeTotal);
					
					jsonArray.put(jsonObject);
				}
				
				
			}
		}
		
		FactIrItemLocalServiceUtil.batchInsert(libraryId,facultyId,period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);

	}
	
	public void editExpense(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 

		
	
		
		long allocationTypeId =  ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_EXPENSE_ALLOCATION_TYPE);
		long itemTypeId =  ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		
		List<MasterFile> allocationTypes = MasterFileLocalServiceUtil.findByMasterType(allocationTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByMasterType(itemTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray allocationArray = JSONFactoryUtil.createJSONArray();
		JSONArray expenseArray = JSONFactoryUtil.createJSONArray();
		
		//allocation
		for (MasterFile allocation : allocationTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			long allocationId = allocation.getMasterFileId();
			jsonObject.put("allocationId",allocationId);
			
			String amount = ParamUtil.getString(actionRequest, EisUtil.EXPENSE_TYPE_ALLOCATION+ "-" + allocationId + "-value");
			jsonObject.put("amount",amount);
			
			allocationArray.put(jsonObject);
			
			
		}
		
		//expense
		
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			long itemId = itemType.getMasterFileId();
			jsonObject.put("itemId",itemId);
			
			String amount = ParamUtil.getString(actionRequest, EisUtil.EXPENSE_TYPE_EXPENSE + "-" + itemId + "-value");
			jsonObject.put("amount",amount);
			
			expenseArray.put(jsonObject);
			
			
		}
		FactExpenseLocalServiceUtil.batchInsert(libraryId, period, allocationArray, expenseArray, serviceContext);
		
		
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
		
		//List<VisitorCategory> categories = VisitorCategoryLocalServiceUtil.getVisitorCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		long visitorCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong("master.visitor.category");
		List<MasterFile> categories =  MasterFileLocalServiceUtil.findByMasterType(visitorCategoryTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		
		
		for (MasterFile category : categories)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			String value = ParamUtil.getString(actionRequest, category.getMasterFileId() + "-value");
			if (Validator.isNotNull(value))
			{
			
				jsonObject.put("visitorCategoryId", category.getMasterFileId());
				
				
				jsonObject.put("value", value);
				
				
				jsonArray.put(jsonObject);
			}
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
		long postGradeType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_POST_GRADE);
		
		List<MasterFile> postGrades = MasterFileLocalServiceUtil.findByMasterType(postGradeType, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (MasterFile postGrade : postGrades)
		{
			String value = ParamUtil.getString(actionRequest, postGrade.getMasterFileId() + "-value");
			if (Validator.isNotNull(value))
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				
				jsonObject.put("postGradeId", postGrade.getMasterFileId());
				
				
				jsonObject.put("value", value);
				
				
				jsonArray.put(jsonObject);
			}
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
		
		long memberTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEMBERSHIP_CATEGORY);
		List<MasterFile> categories = MasterFileLocalServiceUtil.findByMasterType(memberTypeId,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile category : categories)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String value = ParamUtil.getString(actionRequest, category.getMasterFileId() + "-value");
			if (Validator.isNotNull(value))
			{
				jsonObject.put("categoryId", category.getMasterFileId());
				
				jsonObject.put("value", value);
				
				
				jsonArray.put(jsonObject);
			}
		}
		FactMembershipLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
	}
	

	public void editIncome(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		long incomeTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_INCOME_TYPE);
		List<MasterFile> incomes = MasterFileLocalServiceUtil.findByMasterType(incomeTypeId,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile income : incomes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			String value = ParamUtil.getString(actionRequest, income.getMasterFileId() + "-value");
			if (Validator.isNotNull(value))
			{
				
			
			
			
				jsonObject.put("incomeId", income.getMasterFileId());
				jsonObject.put("amount", value);
				jsonArray.put(jsonObject);
			
			}
		}
		
		FactIncomeLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
		
	}
	
	public void editDigitalCollection(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_DIGITAL_COLLECTION);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByMasterType(itemTypeId,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			String title = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-title");
			String volume = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-volume");
			String image = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-image");
			if (Validator.isNotNull(title))
			{
			
				jsonObject.put("itemId", itemType.getMasterFileId());
				jsonObject.put("title", title);
				jsonObject.put("volume", volume);
				jsonObject.put("image", image);
				jsonArray.put(jsonObject);
			}
		}
		FactDigitalCollectionLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext); 
		actionResponse.sendRedirect(redirect);
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws IOException 
	 */
	public void editDatabaseUsage(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_DATABASE_USAGE);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByMasterType(itemTypeId,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			String download = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-download");
			String session = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-session");
			String search = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-search");
			if (Validator.isNotNull(download))
			{
			
				jsonObject.put("itemId", itemType.getMasterFileId());
				jsonObject.put("download", download);
				jsonObject.put("session", session);
				jsonObject.put("search", search);
				jsonArray.put(jsonObject);
			}
		}
		FactDatabaseUsageLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext); 
		actionResponse.sendRedirect(redirect);
	}
	
	public void editLoan(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		long memberCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEMBERSHIP_CATEGORY);
		List<MasterFile> categories = MasterFileLocalServiceUtil.findByMasterType(memberCategoryTypeId,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile category : categories)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			String value = ParamUtil.getString(actionRequest, category.getMasterFileId() + "-value");
			if (Validator.isNotNull(value))
			{
			
				jsonObject.put("categoryId", category.getMasterFileId());
				jsonObject.put("value", value);
				jsonArray.put(jsonObject);
			}
		}
		LoanLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
	}
	
	public void editGiftReceived(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String titleTotal = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-title");
			String volumeTotal = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-volume");
			
			if (Validator.isNotNull(titleTotal) && !Validator.isBlank(volumeTotal))
			{
				jsonObject.put("itemId", itemType.getMasterFileId());
				jsonObject.put("title", titleTotal);
				jsonObject.put("volume", volumeTotal);
				
				jsonArray.put(jsonObject);
			}
			
		}
		
		FactGiftReceivedLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
		
	}
	
	public void editFactData(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		long reportId = ParamUtil.getLong(actionRequest, "reportId");
		
		Report report = ReportLocalServiceUtil.fetchReport(reportId);
		
		long itemTypeId =  report.getDimensionId();//ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ_INTER_LIB_LOAN);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByTypeAndStatus1(itemTypeId, false);// .findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String measure1 = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-measure1");
			String measure2 = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-measure2");
			String measure3 = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-measure3");
			String measure4 = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-measure4");
			
			
			if (Validator.isNotNull(measure1))
			{
				jsonObject.put("dimensionId", itemType.getMasterFileId());
				jsonObject.put("measure1", measure1);
				jsonObject.put("measure2", measure2);
				jsonObject.put("measure3", measure3);
				jsonObject.put("measure4", measure4);
				
				
				jsonArray.put(jsonObject);
			}
			
		}
		
		FactDataLocalServiceUtil.batchInsert(reportId,libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
		
	}
	
	
	public void editInterLibLoan(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ_INTER_LIB_LOAN);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByTypeAndStatus1(itemTypeId, false);// .findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String applyTotal = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-applyTotal");
			String approvedTotal = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-approvedTotal");
			
			if (Validator.isNotNull(applyTotal) && !Validator.isBlank(approvedTotal))
			{
				jsonObject.put("ptjId", itemType.getMasterFileId());
				jsonObject.put("applyTotal", applyTotal);
				jsonObject.put("approvedTotal", approvedTotal);
				
				jsonArray.put(jsonObject);
			}
			
		}
		
		FactInterLibLoanLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
		
	}
	
	
	
	public void editItManagement(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_IT_MANAGEMENT);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByTypeAndStatus1(itemTypeId, false);// .findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String total = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-total");
			
			
			if (Validator.isNotNull(total))
			{
				jsonObject.put("itemId", itemType.getMasterFileId());
				jsonObject.put("total", total);
				
				
				jsonArray.put(jsonObject);
			}
			
		}
		
		FactItManagementLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
		
		
	}
	
	public void editNonPrintedItem(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
		
		
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByTypeAndStatus2(itemTypeId, true);// .findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String volume = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-volume");
			String title = ParamUtil.getString(actionRequest, itemType.getMasterFileId() +"-title");
			
			if (Validator.isNotNull(volume) && Validator.isNotNull(title))
			{
				jsonObject.put("id", itemType.getMasterFileId());
				jsonObject.put("volume", volume);
				jsonObject.put("title", title);
				
				jsonArray.put(jsonObject);
			}
			
		}
		FactNonPrintedMaterialLocalServiceUtil.batchInsert(libraryId, period, jsonArray, serviceContext);
		actionResponse.sendRedirect(redirect);
	}
	
	public void editPrintedItem(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, PortalException, IOException 
	{
		long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		List<MasterFile> itemTypes = MasterFileLocalServiceUtil.findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		
		long libraryId = ParamUtil.getLong(actionRequest, "library");
		String period = ParamUtil.getString(actionRequest, "period");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest); 
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for (MasterFile itemType : itemTypes)
		{
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
			
			
			String volume = ParamUtil.getString(actionRequest, itemType.getMasterFileId() + "-volume");
			String title = ParamUtil.getString(actionRequest, itemType.getMasterFileId() +"-title");
			
			if (Validator.isNotNull(volume) && Validator.isNotNull(title))
			{
				jsonObject.put("id", itemType.getMasterFileId());
				jsonObject.put("volume", volume);
				jsonObject.put("title", title);
				
				jsonArray.put(jsonObject);
			}
			
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
        if (resourceID.equals(EisUtil.RESOURCE_EXPENSE_DATA))
        {
        	try {
				
        		loadExpenseData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_CONSULTATION_DATA))
        {
        	try {
				
        		loadConsultationData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if (resourceID.equals(EisUtil.RESOURCE_ACQUISTION_DATA))
        {
        	try {
				
        		loadAcquistionData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if (resourceID.equals(EisUtil.RESOURCE_INCOME_DATA))
        {
        	try {
				
        		loadIncomeData(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if (resourceID.equals(EisUtil.RESOURCE_DATABASE_USAGE))
        {
        	try {
				
        		loadDatabaseUsage(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_DIGITAL_COLLECTION))
        {
        	try {
				
        		loadDigitalCollection(request,response);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_PTJ_BY_TYPE))
        {
        	try {
				loadPtjByPtjType(request,response);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_IT_MANAGEMENT))
        {
        	try {
				loadItManagement(request,response);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_INTER_LIB_LOAN))
        {
        	try {
        		loadInterLibLoan(request,response);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
        	
        }
        
        if (resourceID.equals(EisUtil.RESOURCE_GIFT_RECEIVED))
        {
        	try {
        		loadGiftReceived(request,response);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
        	
        }
        if (resourceID.equals(EisUtil.RESOURCE_FACT_DATA))
        {
        	try {
        		loadFactData(request,response);
			} catch (SystemException e) {
				
				e.printStackTrace();
			}
        	
        }
        
        
    }
	
	protected void loadFactData(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		long reportId = ParamUtil.getLong(request, "reportId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactData> datas = FactDataLocalServiceUtil.getLatestEntry(reportId,libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactData data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("dimensionId", data.getDimensionId());
				jsonObject.put("measure1", data.getMeasure1());
				jsonObject.put("measure2", data.getMeasure2());
				jsonObject.put("measure3", data.getMeasure3());
				jsonObject.put("measure4", data.getMeasure4());
				
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				JSONArray history = FactDataLocalServiceUtil.getEntries(reportId,libraryId,period);
				
				jsonData.put("history", history);

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadGiftReceived(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactGiftReceived> datas = FactGiftReceivedLocalServiceUtil.getLatestEntry(libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactGiftReceived data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", data.getItemId());
				jsonObject.put("title", data.getTitleTotal());
				jsonObject.put("volume", data.getVolumeTotal());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				JSONArray history = FactGiftReceivedLocalServiceUtil.getEntries(libraryId,period);
				
				jsonData.put("history", history);

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	protected void loadInterLibLoan(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactInterLibLoan> datas = FactInterLibLoanLocalServiceUtil.getLatestEntry(libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactInterLibLoan data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("ptjId", data.getPtjId());
				jsonObject.put("applyTotal", data.getApplyTotal());
				jsonObject.put("approvedTotal", data.getApprovedTotal());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				JSONArray history = FactInterLibLoanLocalServiceUtil.getEntries(libraryId,period);
				
				jsonData.put("history", history);

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadItManagement(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactItManagement> datas = FactItManagementLocalServiceUtil.getLatestEntry(libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		LOGGER.info("admin="+admin);
		try
		{
		
			for (FactItManagement data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", data.getItemId());
				jsonObject.put("total", data.getItemTotal());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				JSONArray history = FactItManagementLocalServiceUtil.getEntries(libraryId,period);
				LOGGER.info(history);
				jsonData.put("history", history);

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadPtjByPtjType(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		long ptjTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ);
		long ptjType = ParamUtil.getLong(request, "ptjTypeId");
		
		List<MasterFile> ptjs = MasterFileLocalServiceUtil.findByParent1(ptjTypeId, ptjType);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		try
		{
			for (MasterFile ptj : ptjs)
			{
				JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
				
				jsonData.put("masterFileId", ptj.getMasterFileId());
				jsonData.put("masterFileName", ptj.getMasterFileName());
				jsonArray.put(jsonData);
			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonArray.toString());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	protected void loadDigitalCollection(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactDigitalCollection> datas = FactDigitalCollectionLocalServiceUtil.getLatestEntry(libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactDigitalCollection data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", data.getItemId());
				jsonObject.put("title", data.getTitleTotal());
				jsonObject.put("volume", data.getVolumeTotal());
				jsonObject.put("image", data.getImageTotal());
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactDigitalCollectionLocalServiceUtil.getEntries(libraryId,period));

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadIncomeData(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactIncome> datas = FactIncomeLocalServiceUtil.getLatestEntry(libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactIncome data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", data.getItemId());
				jsonObject.put("total", data.getTotal());
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactIncomeLocalServiceUtil.getEntries(libraryId,period));

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadDatabaseUsage(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactDatabaseUsage> datas = FactDatabaseUsageLocalServiceUtil.getLatestEntry(libraryId,period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactDatabaseUsage data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", data.getItemId());
				jsonObject.put("download", data.getDownloadTotal());
				jsonObject.put("session", data.getSessionTotal());
				jsonObject.put("search", data.getSearchTotal());
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactDatabaseUsageLocalServiceUtil.getEntries(libraryId,period));

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadAcquistionData(ResourceRequest request,ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long facultyId = ParamUtil.getLong(request, "facultyId");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		//LOGGER.info("period="+ period + "faculty=" + facultyId);
		
		List<FactAcquisition> datas = FactAcquisitionLocalServiceUtil.getLatestEntry(libraryId,facultyId, period);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		boolean admin = isAdmin(request);

		
		try
		{
		
			for (FactAcquisition data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("itemId", data.getItemId());
				jsonObject.put("titleTotal", data.getTitleTotal());
				jsonObject.put("volumeTotal", data.getVolumeTotal());
				jsonObject.put("amountTotal", data.getAmountTotal());
				
				jsonObject.put("approvedTitleTotal", data.getApprovedTitleTotal());
				jsonObject.put("approvedVolumeTotal", data.getApprovedVolumeTotal());
				jsonObject.put("approvedAmountTotal", data.getApprovedAmountTotal());
				
				jsonObject.put("orderTitleTotal", data.getOrderTitleTotal());
				jsonObject.put("orderVolumeTotal", data.getOrderVolumeTotal());
				jsonObject.put("orderAmountTotal", data.getOrderAmountTotal());
				
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactAcquisitionLocalServiceUtil.getEntries(libraryId,facultyId, period));

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	protected void loadConsultationData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		boolean admin = isAdmin(request);
		
		
		List<FactConsultation> datas = FactConsultationLocalServiceUtil.getLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
		
			for (FactConsultation data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("categoryId", data.getConsultationCategoryId());
				
				
				jsonObject.put("value", data.getValue());
				jsonObject.put("totalSession", data.getTotalSession());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactConsultationLocalServiceUtil.getEntries(libraryId, period));

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	protected void loadExpenseData(ResourceRequest request, ResourceResponse response) throws SystemException
	{
		String period = ParamUtil.getString(request, "period");
		long libraryId = ParamUtil.getLong(request, "libraryId");
		boolean admin = isAdmin(request);
		
		List<FactExpense> datas = FactExpenseLocalServiceUtil.getLatestEntry(libraryId, period);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData =  JSONFactoryUtil.createJSONObject();
		
		try
		{
		
			for (FactExpense data : datas)
			{
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				jsonObject.put("entryType", data.getEntryType());
				jsonObject.put("MasterId", data.getMasterFileId());
				jsonObject.put("Jenis", data.getEntryType());
				
				
				jsonObject.put("value", data.getAmount());
				
				
				jsonArray.put(jsonObject);
			}
			jsonData.put("data", jsonArray);
			if (admin)
			{
				
				jsonData.put("history", FactExpenseLocalServiceUtil.getEntries(libraryId, period));

			}
			
			PrintWriter out = response.getWriter();
			
			out.print(jsonData.toString());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
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
        LOGGER.info("state="+stateId); 
        SearchContainer<MasterFile> libraryListSearchContainer = new SearchContainer<MasterFile>(
        		request, null, null, "cur", 1, 20,
                iteratorURL, null, "No Library found.");
        
        long libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
        List<MasterFile> libraries =  MasterFileLocalServiceUtil.findByParent1(libraryTypeId,stateId); //LibraryLocalServiceUtil.findByState(stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        int total = libraries.size();
        
        libraryListSearchContainer.setResults(libraries); 
        libraryListSearchContainer.setTotal(total);
        request.setAttribute("libraryListSearchContainer", libraryListSearchContainer);
        include("/html/admin/libraryList.jsp",request,response); 
        
	}
	
	private void converData() throws SystemException
	{
		convertVisitorData();
	}
	private void convertVisitorData() throws SystemException
	{
		long masterTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
		long visitorCategoryId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_VISITOR_CATEGORY);
		List<MasterFile> libraries = MasterFileLocalServiceUtil.findByMasterType(masterTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		
		List<FactVisitor> facts = FactVisitorLocalServiceUtil.getFactVisitors(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (FactVisitor fact : facts )
		{
			try {
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(masterTypeId, fact.getLibraryId());
				MasterFile visitorCategory = MasterFileLocalServiceUtil.findByTypeOldId(visitorCategoryId, fact.getVisitorCategoryId());
				fact.setLibraryId(library.getMasterFileId());
				fact.setStateId(library.getParentId1());
				fact.setLibraryTypeId(library.getParentId2());
				fact.setVisitorCategoryId(visitorCategory.getMasterFileId());
				FactVisitorLocalServiceUtil.updateFactVisitor(fact);
				
				
			} catch (NoSuchMasterFileException e) {
				LOGGER.warn("Visitor conversion: masterfile not found, id="+fact.getFactVisitorId() );
			}
		}
	}

	private static Log LOGGER = LogFactoryUtil.getLog(EisPortlet.class);

}

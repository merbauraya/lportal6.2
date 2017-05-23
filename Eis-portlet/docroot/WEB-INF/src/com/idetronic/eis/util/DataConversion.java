package com.idetronic.eis.util;

import java.util.List;

import com.idetronic.eis.NoSuchMasterFileException;
import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactMembership;
import com.idetronic.eis.model.FactNonPrintedMaterial;
import com.idetronic.eis.model.FactPost;
import com.idetronic.eis.model.FactPrintedMaterial;
import com.idetronic.eis.model.FactSeating;
import com.idetronic.eis.model.FactVisitor;
import com.idetronic.eis.model.Loan;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.model.UserLibrary;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.FactIrItemLocalServiceUtil;
import com.idetronic.eis.service.FactMembershipLocalServiceUtil;
import com.idetronic.eis.service.FactNonPrintedMaterialLocalServiceUtil;
import com.idetronic.eis.service.FactPostLocalServiceUtil;
import com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil;
import com.idetronic.eis.service.FactSeatingLocalServiceUtil;
import com.idetronic.eis.service.FactVisitorLocalServiceUtil;
import com.idetronic.eis.service.LoanLocalServiceUtil;
import com.idetronic.eis.service.MasterFileLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DataConversion {
	
	
	public static void converDataV1() throws SystemException
	{
		convertUserLibraryV1();
		convertVisitorDataV1();
		convertSeatingDataV1();
		convertLoanDataV1();
		convertMembershipDataV1();
		convertPrintedMaterialV1();
		convertNonPrintedMaterialV1();
		converIrItemV1();
		convertPostV1();
		
		
	}
	
	private static void convertPostV1() throws SystemException
	{
		long libraryTypeId,postGradeTypeId,stateTypeId;
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			postGradeTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_POST_GRADE);
			stateTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 
		} catch (SystemException e) {
			LOGGER.warn("Position Data Conversion: Master not found. Data not converted");
			return;
		}
		
		List<FactPost> facts = null;
		try {
			facts = FactPostLocalServiceUtil.getFactPosts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.warn("Position  Data Conversion: Error getting data. Data not converted");
			LOGGER.error(e);
			return;
		}
		
		for(FactPost fact : facts)
		{
			try {
				
				MasterFile postGrade = MasterFileLocalServiceUtil.findByTypeOldId(postGradeTypeId,fact.getPostGradeId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateTypeId,fact.getStateId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setPostGradeId(postGrade.getMasterFileId()); 
				fact.setStateId(state.getMasterFileId());
				
				FactPostLocalServiceUtil.updateFactPost(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Loan data conversion : master not found, id=" + fact.getFactPostId());
			}
		}
		
		
	}
	
	private static void converIrItemV1() throws SystemException
	{
		long libraryTypeId,facultyTypeId,itemTypeId,itemMediumTypeId;
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			facultyTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ);
			 itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
			 itemMediumTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEDIUM_TYPE);
		} catch (SystemException e) {
			LOGGER.warn("PrintedMaterial Data Conversion: Master not found. Data not converted");
			return;
		}
		
		List<FactIrItem> facts = null;
		try {
			facts = FactIrItemLocalServiceUtil.getFactIrItems(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.warn("IrItem  Data Conversion: Error getting data. Data not converted");
			LOGGER.error(e);
			return;
		}
		
		for(FactIrItem fact : facts)
		{
			try {
				MasterFile faculty = MasterFileLocalServiceUtil.findByTypeOldId(facultyTypeId,fact.getFacultyId());
				MasterFile itemType = MasterFileLocalServiceUtil.findByTypeOldId(itemTypeId,fact.getItemTypeId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile medium = MasterFileLocalServiceUtil.findByTypeOldId(itemMediumTypeId,fact.getItemMediumId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setItemTypeId(itemType.getMasterFileId());
				
				fact.setItemMediumId(medium.getMasterFileId());
				fact.setFacultyId(faculty.getMasterFileId());
				FactIrItemLocalServiceUtil.updateFactIrItem(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Loan data conversion : master not found, id=" + fact.getFactIrItemId());
			}
		}
		
		
	}
	
	private static void convertNonPrintedMaterialV1() throws SystemException
	{
		long libraryTypeId,stateTypeid,itemTypeId,libraryGroupTypeId;
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			 stateTypeid = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
			 libraryGroupTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		} catch (SystemException e) {
			LOGGER.warn("PrintedMaterial Data Conversion: Master not found. Data not converted");
			return;
		}
		
		List<FactNonPrintedMaterial> facts = null;
		
		try {
			facts = FactNonPrintedMaterialLocalServiceUtil.getFactNonPrintedMaterials(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.warn("NonPrintedMaterial  Data Conversion: Error getting data. Data not converted");
			LOGGER.error(e);
			return;
		}
		
		for(FactNonPrintedMaterial fact : facts)
		{
			try {
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateTypeid,fact.getStateId());
				MasterFile itemType = MasterFileLocalServiceUtil.findByTypeOldId(itemTypeId,fact.getItemTypeId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile libraryType = MasterFileLocalServiceUtil.findByTypeOldId(libraryGroupTypeId,fact.getLibraryTypeId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setItemTypeId(itemType.getMasterFileId());
				
				fact.setLibraryTypeId(libraryType.getMasterFileId());
				fact.setStateId(state.getMasterFileId());
				FactNonPrintedMaterialLocalServiceUtil.updateFactNonPrintedMaterial(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Loan data conversion : master not found, id=" + fact.getFactNonPrintedMaterialId());
			}
		}
		
		
	}
	
	
	private static void convertPrintedMaterialV1() throws SystemException
	{
		long libraryTypeId,stateTypeid,itemTypeId,libraryGroupTypeId;
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			 stateTypeid = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
			 libraryGroupTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		} catch (SystemException e) {
			LOGGER.warn("PrintedMaterial Data Conversion: Master not found. Data not converted");
			return;
		}
		
		List<FactPrintedMaterial> facts = null;
		
		try {
			facts = FactPrintedMaterialLocalServiceUtil.getFactPrintedMaterials(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.warn("PrintedMaterial  Data Conversion: Error getting data. Data not converted");
			LOGGER.error(e);
			return;
		}
		
		for(FactPrintedMaterial fact : facts)
		{
			try {
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateTypeid,fact.getStateId());
				MasterFile itemType = MasterFileLocalServiceUtil.findByTypeOldId(itemTypeId,fact.getItemTypeId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile libraryType = MasterFileLocalServiceUtil.findByTypeOldId(libraryGroupTypeId,fact.getLibraryTypeId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setItemTypeId(itemType.getMasterFileId());
				
				fact.setLibraryTypeId(libraryType.getMasterFileId());
				fact.setStateId(state.getMasterFileId());
				FactPrintedMaterialLocalServiceUtil.updateFactPrintedMaterial(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Loan data conversion : master not found, id=" + fact.getFactPrintedMaterialId());
			}
		}
		
		
	}
	
	private static void convertMembershipDataV1() throws SystemException
	{
		long libraryTypeId,stateTypeid,memberCategoryTypeId,libraryGroupTypeId;
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			 stateTypeid = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 memberCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEMBERSHIP_CATEGORY);
			 libraryGroupTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		} catch (SystemException e) {
			LOGGER.warn("Membership Data Conversion: Master not found. Data not converted");
			return;
		}
		
		List<FactMembership> facts = null;
		try {
			facts = FactMembershipLocalServiceUtil.getFactMemberships(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.warn("Membership data Conversion: Error getting Membership data. Data not converted");
			LOGGER.error(e);
			return;
		}
		
		for(FactMembership fact : facts)
		{
			try {
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateTypeid,fact.getStateId());
				MasterFile memberCategory = MasterFileLocalServiceUtil.findByTypeOldId(memberCategoryTypeId,fact.getMembershipCategoryId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile libraryType = MasterFileLocalServiceUtil.findByTypeOldId(libraryGroupTypeId,fact.getLibraryTypeId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setMembershipCategoryId(memberCategory.getMasterFileId());
				
				fact.setLibraryTypeId(libraryType.getMasterFileId());
				fact.setStateId(state.getMasterFileId());
				FactMembershipLocalServiceUtil.updateFactMembership(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Loan data conversion : master not found, id=" + fact.getFactMembershipId());
			}
		}
		
		
	}
	
	
	private static void convertLoanDataV1() throws SystemException
	{
		long libraryTypeId,stateTypeid,memberCategoryTypeId,libraryGroupTypeId;
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			 stateTypeid = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 memberCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEMBERSHIP_CATEGORY);
			 libraryGroupTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		} catch (SystemException e) {
			LOGGER.warn("Loan Data Conversion: Master not found. Data not converted");
			return;
		}
		List<Loan> loans = null;
		try {
			loans = LoanLocalServiceUtil.getLoans(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.warn("Loan data Conversion: Error getting loan data. Data not converted");
			LOGGER.error(e);
			return;
		}
		
		for (Loan fact : loans)
		{
			try {
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateTypeid,fact.getStateId());
				MasterFile memberCategory = MasterFileLocalServiceUtil.findByTypeOldId(memberCategoryTypeId,fact.getMemberCategoryId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile libraryType = MasterFileLocalServiceUtil.findByTypeOldId(libraryGroupTypeId,fact.getLibraryTypeId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setMemberCategoryId(memberCategory.getMasterFileId());
				
				fact.setLibraryTypeId(libraryType.getMasterFileId());
				fact.setStateId(state.getMasterFileId());
				LoanLocalServiceUtil.updateLoan(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Loan data conversion : master not found, id=" + fact.getLoanEntryId());
			}
			
		}
		
		
	}
	
	private static void convertSeatingDataV1() throws SystemException
	{
		long libraryTypeId,stateTypeid,seatingDeptTypeId,seatingCategoryTypeId,libraryGroupTypeId;
		
		try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			 stateTypeid = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 seatingDeptTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_DEPARTMENT);
			 seatingCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_SEATING_CATEGORY);
			 libraryGroupTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY_TYPE);
		} catch (SystemException e) {
			LOGGER.warn("Seating Data Conversion: Master not found. Data not converted");
			return;
		}
		
		List<FactSeating> factSeatings = FactSeatingLocalServiceUtil.getFactSeatings(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (FactSeating fact : factSeatings)
		{
			
			try {
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateTypeid,fact.getStateId());
				MasterFile seatingDept = MasterFileLocalServiceUtil.findByTypeOldId(seatingDeptTypeId,fact.getSeatingCategoryId());
				MasterFile seatingCategory = MasterFileLocalServiceUtil.findByTypeOldId(seatingCategoryTypeId,fact.getSeatingCategoryId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile libraryType = MasterFileLocalServiceUtil.findByTypeOldId(libraryGroupTypeId,fact.getLibraryTypeId());
				
				fact.setLibraryId(library.getMasterFileId());
				fact.setSeatingCategoryId(seatingCategory.getMasterFileId());
				fact.setDepartmentId(seatingDept.getMasterFileId());
				fact.setLibraryTypeId(libraryType.getMasterFileId());
				fact.setStateId(state.getMasterFileId());
				FactSeatingLocalServiceUtil.updateFactSeating(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Seating data conversion : master not found, id=" + fact.getFactSeatingId());
			}
			
		}
		
		
		
	}
	
	private static void convertUserLibraryV1() throws SystemException
	{
		List<UserLibrary> userLibraries = UserLibraryLocalServiceUtil.getUserLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		long libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
		
		
		for (UserLibrary userLibrary : userLibraries)
		{
			try {
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId, userLibrary.getLibraryId());
				userLibrary.setLibraryId(library.getMasterFileId());
				UserLibraryLocalServiceUtil.updateUserLibrary(userLibrary);
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("User library conversion : library not found, id=" + userLibrary.getUserLibraryId());
			}
			
		}
	}
	
	private static void convertVisitorDataV1() throws SystemException 
	{
		long libraryTypeId,stateTypeid,visitorCategoryTypeId,stateType;
		
		
		 try {
			libraryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
			 stateTypeid = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
			 visitorCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_VISITOR_CATEGORY);
			 stateType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
		} catch (SystemException e1) {
			LOGGER.error("Visitor Data, error getting master.Data not converted");
			LOGGER.error(e1);
			return;
		}
		
		
		
		List<FactVisitor> factVisitors = null;
		
		
		try {
			factVisitors = FactVisitorLocalServiceUtil.getFactVisitors(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.error("Error getting visitor data.Data not converted");
			LOGGER.error(e);
			return;
		}
		
		
		for (FactVisitor fact : factVisitors)
		{
			
			try {
				MasterFile visitorCategory = MasterFileLocalServiceUtil.findByTypeOldId(visitorCategoryTypeId,fact.getVisitorCategoryId());
				MasterFile library = MasterFileLocalServiceUtil.findByTypeOldId(libraryTypeId,fact.getLibraryId());
				MasterFile state = MasterFileLocalServiceUtil.findByTypeOldId(stateType,fact.getLibraryId());
				fact.setVisitorCategoryId(visitorCategory.getMasterFileId());
				fact.setLibraryId(library.getMasterFileId());
				fact.setStateId(state.getMasterFileId());
				
				FactVisitorLocalServiceUtil.updateFactVisitor(fact);
				
			} catch (NoSuchMasterFileException e) {
				// TODO Auto-generated catch block
				LOGGER.warn("Visitor data conversion : master not found, id=" + fact.getFactVisitorId());
			}
		}
		
		
	}
	
	
	private static Log LOGGER = LogFactoryUtil.getLog(DataConversion.class);
}

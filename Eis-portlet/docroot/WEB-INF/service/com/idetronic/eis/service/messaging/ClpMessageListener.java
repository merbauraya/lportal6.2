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

package com.idetronic.eis.service.messaging;

import com.idetronic.eis.service.ClpSerializer;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.ConfigServiceUtil;
import com.idetronic.eis.service.FactAcquisitionLocalServiceUtil;
import com.idetronic.eis.service.FactAcquisitionServiceUtil;
import com.idetronic.eis.service.FactArticleIndexingLocalServiceUtil;
import com.idetronic.eis.service.FactArticleIndexingServiceUtil;
import com.idetronic.eis.service.FactConsultationLocalServiceUtil;
import com.idetronic.eis.service.FactConsultationServiceUtil;
import com.idetronic.eis.service.FactCustomerComplaintLocalServiceUtil;
import com.idetronic.eis.service.FactCustomerComplaintServiceUtil;
import com.idetronic.eis.service.FactDataLocalServiceUtil;
import com.idetronic.eis.service.FactDataServiceUtil;
import com.idetronic.eis.service.FactDatabaseUsageLocalServiceUtil;
import com.idetronic.eis.service.FactDatabaseUsageServiceUtil;
import com.idetronic.eis.service.FactDigitalCollectionLocalServiceUtil;
import com.idetronic.eis.service.FactDigitalCollectionServiceUtil;
import com.idetronic.eis.service.FactExpenseLocalServiceUtil;
import com.idetronic.eis.service.FactExpenseServiceUtil;
import com.idetronic.eis.service.FactGiftReceivedLocalServiceUtil;
import com.idetronic.eis.service.FactGiftReceivedServiceUtil;
import com.idetronic.eis.service.FactIncomeLocalServiceUtil;
import com.idetronic.eis.service.FactIncomeServiceUtil;
import com.idetronic.eis.service.FactInterLibLoanLocalServiceUtil;
import com.idetronic.eis.service.FactInterLibLoanServiceUtil;
import com.idetronic.eis.service.FactInternationalPortalUsageLocalServiceUtil;
import com.idetronic.eis.service.FactInternationalPortalUsageServiceUtil;
import com.idetronic.eis.service.FactIrItemLocalServiceUtil;
import com.idetronic.eis.service.FactIrItemServiceUtil;
import com.idetronic.eis.service.FactIrSubmissionLocalServiceUtil;
import com.idetronic.eis.service.FactIrSubmissionServiceUtil;
import com.idetronic.eis.service.FactItManagementLocalServiceUtil;
import com.idetronic.eis.service.FactItManagementServiceUtil;
import com.idetronic.eis.service.FactLibraryVisitorLocalServiceUtil;
import com.idetronic.eis.service.FactLibraryVisitorServiceUtil;
import com.idetronic.eis.service.FactMembershipLocalServiceUtil;
import com.idetronic.eis.service.FactMembershipServiceUtil;
import com.idetronic.eis.service.FactNonPrintedMaterialLocalServiceUtil;
import com.idetronic.eis.service.FactNonPrintedMaterialServiceUtil;
import com.idetronic.eis.service.FactPostLocalServiceUtil;
import com.idetronic.eis.service.FactPostServiceUtil;
import com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil;
import com.idetronic.eis.service.FactPrintedMaterialServiceUtil;
import com.idetronic.eis.service.FactReleaseCatalogingLocalServiceUtil;
import com.idetronic.eis.service.FactReleaseCatalogingServiceUtil;
import com.idetronic.eis.service.FactSeatingLocalServiceUtil;
import com.idetronic.eis.service.FactSeatingServiceUtil;
import com.idetronic.eis.service.FactVisitorLocalServiceUtil;
import com.idetronic.eis.service.FactVisitorServiceUtil;
import com.idetronic.eis.service.FacultyLocalServiceUtil;
import com.idetronic.eis.service.FacultyServiceUtil;
import com.idetronic.eis.service.FacultyTypeLocalServiceUtil;
import com.idetronic.eis.service.FacultyTypeServiceUtil;
import com.idetronic.eis.service.ItemMediumLocalServiceUtil;
import com.idetronic.eis.service.ItemMediumServiceUtil;
import com.idetronic.eis.service.ItemTypeCategoryLocalServiceUtil;
import com.idetronic.eis.service.ItemTypeCategoryServiceUtil;
import com.idetronic.eis.service.ItemTypeLocalServiceUtil;
import com.idetronic.eis.service.ItemTypeServiceUtil;
import com.idetronic.eis.service.KpiEntryLocalServiceUtil;
import com.idetronic.eis.service.KpiEntryServiceUtil;
import com.idetronic.eis.service.KpiTypeLocalServiceUtil;
import com.idetronic.eis.service.KpiTypeServiceUtil;
import com.idetronic.eis.service.LibraryLocalServiceUtil;
import com.idetronic.eis.service.LibrarySeatingDepartmentLocalServiceUtil;
import com.idetronic.eis.service.LibrarySeatingDepartmentServiceUtil;
import com.idetronic.eis.service.LibraryTypeLocalServiceUtil;
import com.idetronic.eis.service.LoanLocalServiceUtil;
import com.idetronic.eis.service.LoanServiceUtil;
import com.idetronic.eis.service.MasterFileLocalServiceUtil;
import com.idetronic.eis.service.MasterFileServiceUtil;
import com.idetronic.eis.service.MasterTypeLocalServiceUtil;
import com.idetronic.eis.service.MasterTypeServiceUtil;
import com.idetronic.eis.service.MemberCategoryLocalServiceUtil;
import com.idetronic.eis.service.MemberCategoryServiceUtil;
import com.idetronic.eis.service.PostCategoryLocalServiceUtil;
import com.idetronic.eis.service.PostCategoryServiceUtil;
import com.idetronic.eis.service.PostGradeLocalServiceUtil;
import com.idetronic.eis.service.PostGradeServiceUtil;
import com.idetronic.eis.service.ProjectActivityLocalServiceUtil;
import com.idetronic.eis.service.ProjectLocalServiceUtil;
import com.idetronic.eis.service.ProjectResourceServiceUtil;
import com.idetronic.eis.service.ProjectResourceTypeServiceUtil;
import com.idetronic.eis.service.ProjectServiceUtil;
import com.idetronic.eis.service.ProjectStrategyLocalServiceUtil;
import com.idetronic.eis.service.ReportLocalServiceUtil;
import com.idetronic.eis.service.ReportServiceUtil;
import com.idetronic.eis.service.SeatingCategoryLocalServiceUtil;
import com.idetronic.eis.service.SeatingCategoryServiceUtil;
import com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil;
import com.idetronic.eis.service.SeatingDepartmentServiceUtil;
import com.idetronic.eis.service.StateLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryServiceUtil;
import com.idetronic.eis.service.UserReportLocalServiceUtil;
import com.idetronic.eis.service.UserReportServiceUtil;
import com.idetronic.eis.service.VisitorCategoryLocalServiceUtil;
import com.idetronic.eis.service.VisitorCategoryServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Mazlan Mat
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ConfigLocalServiceUtil.clearService();

			ConfigServiceUtil.clearService();
			FactAcquisitionLocalServiceUtil.clearService();

			FactAcquisitionServiceUtil.clearService();
			FactArticleIndexingLocalServiceUtil.clearService();

			FactArticleIndexingServiceUtil.clearService();
			FactConsultationLocalServiceUtil.clearService();

			FactConsultationServiceUtil.clearService();
			FactCustomerComplaintLocalServiceUtil.clearService();

			FactCustomerComplaintServiceUtil.clearService();
			FactDataLocalServiceUtil.clearService();

			FactDataServiceUtil.clearService();
			FactDatabaseUsageLocalServiceUtil.clearService();

			FactDatabaseUsageServiceUtil.clearService();
			FactDigitalCollectionLocalServiceUtil.clearService();

			FactDigitalCollectionServiceUtil.clearService();
			FactExpenseLocalServiceUtil.clearService();

			FactExpenseServiceUtil.clearService();
			FactGiftReceivedLocalServiceUtil.clearService();

			FactGiftReceivedServiceUtil.clearService();
			FactIncomeLocalServiceUtil.clearService();

			FactIncomeServiceUtil.clearService();
			FactInterLibLoanLocalServiceUtil.clearService();

			FactInterLibLoanServiceUtil.clearService();
			FactInternationalPortalUsageLocalServiceUtil.clearService();

			FactInternationalPortalUsageServiceUtil.clearService();
			FactIrItemLocalServiceUtil.clearService();

			FactIrItemServiceUtil.clearService();
			FactIrSubmissionLocalServiceUtil.clearService();

			FactIrSubmissionServiceUtil.clearService();
			FactItManagementLocalServiceUtil.clearService();

			FactItManagementServiceUtil.clearService();
			FactLibraryVisitorLocalServiceUtil.clearService();

			FactLibraryVisitorServiceUtil.clearService();
			FactMembershipLocalServiceUtil.clearService();

			FactMembershipServiceUtil.clearService();
			FactNonPrintedMaterialLocalServiceUtil.clearService();

			FactNonPrintedMaterialServiceUtil.clearService();
			FactPostLocalServiceUtil.clearService();

			FactPostServiceUtil.clearService();
			FactPrintedMaterialLocalServiceUtil.clearService();

			FactPrintedMaterialServiceUtil.clearService();
			FactReleaseCatalogingLocalServiceUtil.clearService();

			FactReleaseCatalogingServiceUtil.clearService();
			FactSeatingLocalServiceUtil.clearService();

			FactSeatingServiceUtil.clearService();
			FactVisitorLocalServiceUtil.clearService();

			FactVisitorServiceUtil.clearService();
			FacultyLocalServiceUtil.clearService();

			FacultyServiceUtil.clearService();
			FacultyTypeLocalServiceUtil.clearService();

			FacultyTypeServiceUtil.clearService();
			ItemMediumLocalServiceUtil.clearService();

			ItemMediumServiceUtil.clearService();
			ItemTypeLocalServiceUtil.clearService();

			ItemTypeServiceUtil.clearService();
			ItemTypeCategoryLocalServiceUtil.clearService();

			ItemTypeCategoryServiceUtil.clearService();
			KpiEntryLocalServiceUtil.clearService();

			KpiEntryServiceUtil.clearService();
			KpiTypeLocalServiceUtil.clearService();

			KpiTypeServiceUtil.clearService();
			LibraryLocalServiceUtil.clearService();

			LibrarySeatingDepartmentLocalServiceUtil.clearService();

			LibrarySeatingDepartmentServiceUtil.clearService();
			LibraryTypeLocalServiceUtil.clearService();

			LoanLocalServiceUtil.clearService();

			LoanServiceUtil.clearService();
			MasterFileLocalServiceUtil.clearService();

			MasterFileServiceUtil.clearService();
			MasterTypeLocalServiceUtil.clearService();

			MasterTypeServiceUtil.clearService();
			MemberCategoryLocalServiceUtil.clearService();

			MemberCategoryServiceUtil.clearService();
			PostCategoryLocalServiceUtil.clearService();

			PostCategoryServiceUtil.clearService();
			PostGradeLocalServiceUtil.clearService();

			PostGradeServiceUtil.clearService();
			ProjectLocalServiceUtil.clearService();

			ProjectServiceUtil.clearService();
			ProjectActivityLocalServiceUtil.clearService();

			ProjectResourceServiceUtil.clearService();

			ProjectResourceTypeServiceUtil.clearService();
			ProjectStrategyLocalServiceUtil.clearService();

			ReportLocalServiceUtil.clearService();

			ReportServiceUtil.clearService();
			SeatingCategoryLocalServiceUtil.clearService();

			SeatingCategoryServiceUtil.clearService();
			SeatingDepartmentLocalServiceUtil.clearService();

			SeatingDepartmentServiceUtil.clearService();
			StateLocalServiceUtil.clearService();

			UserLibraryLocalServiceUtil.clearService();

			UserLibraryServiceUtil.clearService();
			UserReportLocalServiceUtil.clearService();

			UserReportServiceUtil.clearService();
			VisitorCategoryLocalServiceUtil.clearService();

			VisitorCategoryServiceUtil.clearService();
		}
	}
}
create unique index IX_4FA2646C on eis_Config (key_);

create index IX_DE5CBD38 on eis_FactAcquisition (facultyId);
create index IX_1F37703A on eis_FactAcquisition (ptjId);

create index IX_FACCC4DB on eis_FactConsultation (libraryId);

create index IX_175C9B24 on eis_FactExpense (libraryId);

create index IX_AC0F6A1C on eis_FactIrItem (libraryId, facultyId, period);
create index IX_35E6965D on eis_FactIrItem (libraryId, period);
create index IX_E6F89DA6 on eis_FactIrItem (period, itemTypeId, itemMediumId);

create index IX_FBBAEBAD on eis_FactIrSubmission (facultyId, period);

create index IX_A7543DAE on eis_FactMembership (libraryId);
create index IX_7BCC5CA3 on eis_FactMembership (libraryId, period);

create index IX_8EB328BE on eis_FactNonPrintedMaterial (libraryId);
create index IX_3B5737B3 on eis_FactNonPrintedMaterial (libraryId, period);

create index IX_2DE90024 on eis_FactPost (libraryId);
create index IX_620A4919 on eis_FactPost (libraryId, period);
create index IX_35498980 on eis_FactPost (postGradeId);

create index IX_A4687209 on eis_FactPrintedMaterial (libraryId);
create index IX_BFC005FE on eis_FactPrintedMaterial (libraryId, period);

create index IX_4E91FFDF on eis_FactSeating (libraryId);
create index IX_ECB5A860 on eis_FactSeating (libraryId, departmentId);
create index IX_DE61D11B on eis_FactSeating (libraryId, departmentId, seatingCategoryId, period);

create index IX_56BE02CE on eis_FactVisitor (libraryId);
create index IX_E42F01C3 on eis_FactVisitor (libraryId, period);
create index IX_33DCF1F on eis_FactVisitor (visitorCategoryId);

create index IX_48A7B73A on eis_ItemType (IRType);
create index IX_AF4A5D24 on eis_ItemType (isIRType);
create index IX_2622F1A9 on eis_ItemType (isPrintedType);
create index IX_68F94573 on eis_ItemType (printedType);

create unique index IX_630164AE on eis_Kpi (key_);

create unique index IX_A9B545E9 on eis_KpiEntry (kpiTypeId, periodType, period);
create index IX_CF891F06 on eis_KpiEntry (kpiTypeId, periodYear, periodType);

create unique index IX_8C8A8DE9 on eis_KpiType (kpiTypeKey);

create unique index IX_FE89567 on eis_Library (libraryCode);
create unique index IX_21ECB285 on eis_Library (libraryName);
create index IX_26048F2B on eis_Library (stateId);

create unique index IX_5E869C9D on eis_LibrarySeatingDepartment (libraryId, departmentId);

create unique index IX_2DACF127 on eis_LibraryType (libraryTypeCode);

create index IX_94A3EE0 on eis_Loan (libraryId);
create index IX_C18F0BD5 on eis_Loan (libraryId, period);

create index IX_3849D97F on eis_MasterFile (masterTypeId);
create index IX_D5A6B37E on eis_MasterFile (masterTypeId, inActive);
create index IX_50BB1C58 on eis_MasterFile (masterTypeId, masterFilaName);
create index IX_2454095C on eis_MasterFile (masterTypeId, masterFileName);
create index IX_7125C973 on eis_MasterFile (masterTypeId, oldId);
create index IX_8D76EB3D on eis_MasterFile (masterTypeId, parentId1);
create index IX_8D76EEFE on eis_MasterFile (masterTypeId, parentId2);
create index IX_FAB31F50 on eis_MasterFile (masterTypeId, status1);
create index IX_5A0F9341 on eis_MasterFile (masterTypeId, status1, status2, status3, status4);
create index IX_FAB32311 on eis_MasterFile (masterTypeId, status2);
create index IX_FAB326D2 on eis_MasterFile (masterTypeId, status3);
create index IX_FAB32A93 on eis_MasterFile (masterTypeId, status4);
create index IX_FAB32E54 on eis_MasterFile (masterTypeId, status5);
create index IX_B1F64048 on eis_MasterFile (parentId1);
create index IX_B1F64409 on eis_MasterFile (parentId2);

create index IX_F1BC3D0A on eis_MasterType (parentType);

create index IX_EE967523 on eis_Post (postCategoryId);

create unique index IX_2484D213 on eis_PostCategory (postCategoryCode);

create unique index IX_568F98A7 on eis_PostGrade (postGradeCode);

create index IX_E698A4E0 on eis_ProjectActivity (strategyId);

create index IX_B091A522 on eis_ProjectStrategy (projectId);

create index IX_4012544E on eis_Report (dataEntry);
create index IX_B6FF2EC1 on eis_Report (dataEntry, hqDataEntry);
create unique index IX_E7666931 on eis_Report (reportKey);

create index IX_B86E03E9 on eis_SeatingCategory (seatingDepartmentId);

create unique index IX_617563E7 on eis_State (stateCode);

create index IX_84A07044 on eis_UserData (dataId);
create index IX_A1B73E5 on eis_UserData (userId);
create unique index IX_C272137E on eis_UserData (userId, dataId);
create index IX_ADA83861 on eis_UserData (userId, libraryId);
create unique index IX_50209BFA on eis_UserData (userId, libraryId, dataId);

create index IX_7EF16780 on eis_UserLibrary (libraryId);
create index IX_F01C5460 on eis_UserLibrary (userId);
create unique index IX_2AB5CD06 on eis_UserLibrary (userId, libraryId);

create index IX_C05E8D58 on eis_UserReport (reportId);
create index IX_341B322F on eis_UserReport (userId);
create index IX_B05F87D7 on eis_UserReport (userId, libraryId);
create unique index IX_820443BA on eis_UserReport (userId, libraryId, reportId);

create unique index IX_337C8C87 on eis_VisitorCategory (visitorCategoryCode);
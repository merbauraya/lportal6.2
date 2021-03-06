create table eis_BorrowerCategory (
	borrowerCategoryId LONG not null primary key,
	borrowerCategoryName VARCHAR(75) null
);

create table eis_Config (
	id_ LONG not null primary key,
	key_ VARCHAR(75) null,
	value TEXT null,
	title VARCHAR(150) null
);

create table eis_FactAcquisition (
	factAcquisitionId LONG not null primary key,
	libraryId LONG,
	facultyId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	approvedTitleTotal LONG,
	approvedVolumeTotal LONG,
	approvedAmountTotal DOUBLE,
	orderTitleTotal LONG,
	orderVolumeTotal LONG,
	orderAmountTotal DOUBLE,
	volumeTotal LONG,
	titleTotal LONG,
	amountTotal DOUBLE,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactArticleIndexing (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	indexTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactConsultation (
	factConsultationId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	consultationGroupId LONG,
	consultationCategoryId LONG,
	value LONG,
	totalSession LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactCustomerComplaint (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	complaintTotal LONG,
	unsettledTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactData (
	factId LONG not null primary key,
	reportId LONG,
	libraryId LONG,
	period VARCHAR(75) null,
	dimensionId LONG,
	measure1 DOUBLE,
	measure2 DOUBLE,
	measure3 DOUBLE,
	measure4 DOUBLE,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactDatabaseUsage (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	downloadTotal LONG,
	sessionTotal LONG,
	searchTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactDigitalCollection (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	titleTotal LONG,
	volumeTotal LONG,
	imageTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactExpense (
	factExpenseId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	entryType INTEGER,
	masterFileId LONG,
	amount DOUBLE,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactGiftReceived (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	titleTotal LONG,
	volumeTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactIncome (
	factIncomeId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	total DOUBLE,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactInterLibLoan (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	ptjId LONG,
	applyTotal LONG,
	approvedTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactInternationalPortalUsage (
	factId LONG not null primary key,
	period VARCHAR(75) null,
	countryId LONG,
	pagesTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactIrItem (
	factIrItemId LONG not null primary key,
	libraryId LONG,
	facultyId LONG,
	period VARCHAR(10) null,
	itemTypeId LONG,
	itemMediumId LONG,
	titleTotal INTEGER,
	volumeTotal INTEGER,
	createdByUserId LONG,
	createdByUserName VARCHAR(75) null,
	createdDate DATE null
);

create table eis_FactIrSubmission (
	submissionId LONG not null primary key,
	libraryId LONG,
	facultyId LONG,
	period VARCHAR(10) null,
	itemMediumId LONG,
	titleTotal INTEGER,
	volumeTotal INTEGER,
	createdByUserId LONG,
	createdByUserName VARCHAR(75) null,
	createdDate DATE null
);

create table eis_FactItManagement (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	itemTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactLibraryVisitor (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	visitorCategoryId LONG,
	sessionTotal LONG,
	visitorTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactMembership (
	factMembershipId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	stateId LONG,
	libraryTypeId LONG,
	membershipCategoryId LONG,
	activeCount INTEGER,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactNonPrintedMaterial (
	factNonPrintedMaterialId LONG not null primary key,
	libraryId LONG,
	libraryCode VARCHAR(10) null,
	stateId LONG,
	stateCode VARCHAR(10) null,
	libraryTypeId LONG,
	itemTypeId LONG,
	period VARCHAR(10) null,
	monthVal INTEGER,
	yearVal INTEGER,
	titleTotal INTEGER,
	volumeTotal INTEGER,
	dateCreated DATE null,
	createdByUserName VARCHAR(75) null,
	createdByUserId LONG
);

create table eis_FactPost (
	factPostId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(10) null,
	postGradeId LONG,
	stateId LONG,
	value INTEGER,
	createdByUserId LONG,
	createdByUserName VARCHAR(75) null,
	createdDate DATE null
);

create table eis_FactPrintedMaterial (
	factPrintedMaterialId LONG not null primary key,
	libraryId LONG,
	libraryCode VARCHAR(10) null,
	stateId LONG,
	stateCode VARCHAR(10) null,
	itemTypeId LONG,
	period VARCHAR(10) null,
	libraryTypeId LONG,
	monthVal INTEGER,
	yearVal INTEGER,
	titleTotal INTEGER,
	volumeTotal INTEGER,
	dateCreated DATE null,
	createdByUserName VARCHAR(75) null,
	createdByUserId LONG
);

create table eis_FactReleaseCataloging (
	factId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(75) null,
	itemId LONG,
	titleTotal LONG,
	volumeTotal LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactSeating (
	factSeatingId LONG not null primary key,
	libraryId LONG,
	departmentId LONG,
	seatingCategoryId LONG,
	stateId LONG,
	libraryTypeId LONG,
	period VARCHAR(75) null,
	capacity INTEGER,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_FactVisitor (
	factVisitorId LONG not null primary key,
	libraryId LONG,
	period VARCHAR(10) null,
	visitorCategoryId LONG,
	stateId LONG,
	libraryTypeId LONG,
	value INTEGER,
	createdByUserId LONG,
	createdByUserName VARCHAR(75) null,
	createdDate DATE null
);

create table eis_Faculty (
	facultyId LONG not null primary key,
	facultyTypeId LONG,
	facultyName VARCHAR(75) null
);

create table eis_FacultyType (
	facultyTypeId LONG not null primary key,
	facultyTypeName VARCHAR(75) null
);

create table eis_ItemMedium (
	itemMediumId LONG not null primary key,
	itemMediumName VARCHAR(75) null
);

create table eis_ItemType (
	itemTypeId LONG not null primary key,
	itemTypeName VARCHAR(75) null,
	printedType INTEGER,
	IRType BOOLEAN,
	active_ BOOLEAN
);

create table eis_ItemTypeCategory (
	itemTypeCategoryId LONG not null primary key,
	itemTypeCategoryName VARCHAR(75) null
);

create table eis_Kpi (
	id_ LONG not null primary key,
	key_ VARCHAR(30) null,
	kpiType INTEGER,
	value INTEGER,
	description VARCHAR(75) null
);

create table eis_KpiEntry (
	kpiEntryId LONG not null primary key,
	kpiTypeId LONG,
	periodYear VARCHAR(75) null,
	periodType INTEGER,
	period VARCHAR(75) null,
	value DOUBLE,
	actual DOUBLE
);

create table eis_KpiType (
	kpiTypeId LONG not null primary key,
	kpiTypeKey VARCHAR(30) null,
	kpiName VARCHAR(250) null,
	periodMonth BOOLEAN,
	periodQuarter BOOLEAN,
	periodSemiAnnual BOOLEAN,
	periodYear BOOLEAN,
	isDecimal BOOLEAN,
	manualValue BOOLEAN
);

create table eis_Library (
	libraryId LONG not null primary key,
	libraryCode VARCHAR(10) null,
	stateId LONG,
	libraryTypeId LONG,
	stateName VARCHAR(75) null,
	libraryName VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_LibrarySeatingDepartment (
	libraryDepartmentId LONG not null primary key,
	libraryId LONG,
	departmentId LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_LibraryType (
	libraryTypeId LONG not null primary key,
	libraryTypeCode VARCHAR(10) null,
	libraryTypeName VARCHAR(75) null
);

create table eis_Loan (
	loanEntryId LONG not null primary key,
	libraryId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	period VARCHAR(10) null,
	stateId LONG,
	libraryTypeId LONG,
	periodYear INTEGER,
	periodMonth INTEGER,
	createDate DATE null,
	memberCategoryId LONG,
	value INTEGER
);

create table eis_MasterFile (
	masterFileId LONG not null primary key,
	masterTypeId LONG,
	parentId1 LONG,
	parentId2 LONG,
	masterFileName VARCHAR(75) null,
	status1 BOOLEAN,
	status2 BOOLEAN,
	status3 BOOLEAN,
	status4 BOOLEAN,
	status5 BOOLEAN,
	masterCode VARCHAR(75) null,
	oldId LONG,
	note VARCHAR(75) null,
	inActive BOOLEAN
);

create table eis_MasterType (
	masterTypeId LONG not null primary key,
	masterTypeName VARCHAR(75) null,
	status INTEGER,
	parentType BOOLEAN,
	pageLabel VARCHAR(75) null,
	nameLabel VARCHAR(75) null,
	hasParent1 BOOLEAN,
	parentId1 LONG,
	parentId2 LONG,
	hasParent2 BOOLEAN,
	parent1Label VARCHAR(75) null,
	parent2Label VARCHAR(75) null,
	hasStatus1 BOOLEAN,
	hasStatus2 BOOLEAN,
	hasStatus3 BOOLEAN,
	hasStatus4 BOOLEAN,
	hasStatus5 BOOLEAN,
	status1Label VARCHAR(75) null,
	status2Label VARCHAR(75) null,
	status3Label VARCHAR(75) null,
	status4Label VARCHAR(75) null,
	status5Label VARCHAR(75) null,
	hasCode BOOLEAN,
	codeLabel VARCHAR(75) null
);

create table eis_MemberCategory (
	memberCategoryId LONG not null primary key,
	memberCategoryName VARCHAR(75) null,
	memberCategoryGroupName VARCHAR(75) null,
	active_ BOOLEAN
);

create table eis_NonPrintedItemType (
	itemTypeId LONG not null primary key,
	itemTypeName VARCHAR(75) null
);

create table eis_Post (
	postId LONG not null primary key,
	postCategoryId LONG,
	postName VARCHAR(75) null
);

create table eis_PostCategory (
	postCategoryId LONG not null primary key,
	postCategoryCode VARCHAR(15) null,
	postCategoryName VARCHAR(75) null
);

create table eis_PostGrade (
	postGradeId LONG not null primary key,
	postCategoryId LONG,
	postGradeCode VARCHAR(10) null,
	postGradeScheme VARCHAR(10) null,
	postGradeName VARCHAR(75) null,
	postGradeDesc VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_PrintedItemType (
	itemTypeId LONG not null primary key,
	itemTypeName VARCHAR(75) null
);

create table eis_Project (
	projectId LONG not null primary key,
	projectName VARCHAR(150) null,
	projectStatus INTEGER,
	startDate DATE null,
	endDate DATE null,
	startMonth INTEGER,
	startYear INTEGER,
	startMonthName VARCHAR(20) null,
	endMonth INTEGER,
	endYear INTEGER,
	progressStatus INTEGER,
	endMonthName VARCHAR(20) null,
	completionDate DATE null,
	progress INTEGER,
	resourceId LONG,
	resourceTypeId LONG,
	resourceName VARCHAR(75) null,
	resourceType VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_ProjectActivity (
	projectActivityId LONG not null primary key,
	strategyId LONG,
	activityName VARCHAR(150) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	createDate DATE null,
	modifiedDate DATE null,
	startMonth INTEGER,
	startYear INTEGER,
	startMonthName VARCHAR(20) null,
	endMonth INTEGER,
	endYear INTEGER,
	endMonthName VARCHAR(20) null,
	progress INTEGER,
	status INTEGER,
	progressStatus INTEGER,
	completionDate DATE null,
	resourceName VARCHAR(75) null,
	resourceType VARCHAR(75) null,
	remark TEXT null
);

create table eis_ProjectResource (
	projectResourceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	resourceName VARCHAR(75) null
);

create table eis_ProjectResourceType (
	projectResourceTypeId LONG not null primary key,
	resourceTypeName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_ProjectStrategy (
	projectStrategyId LONG not null primary key,
	strategyName VARCHAR(150) null,
	projectId LONG,
	userName VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	startMonth INTEGER,
	startYear INTEGER,
	startMonthName VARCHAR(20) null,
	endMonth INTEGER,
	endYear INTEGER,
	endMonthName VARCHAR(20) null,
	completionDate DATE null,
	projectStrategyStatus INTEGER,
	userId LONG,
	progress INTEGER,
	status INTEGER,
	progressStatus INTEGER,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	resourceName VARCHAR(75) null,
	resourceType VARCHAR(75) null,
	remark TEXT null
);

create table eis_Report (
	reportId LONG not null primary key,
	reportKey VARCHAR(75) null,
	reportName VARCHAR(75) null,
	reportTitle VARCHAR(150) null,
	dataEntry BOOLEAN,
	hqDataEntry BOOLEAN,
	dimensionId LONG,
	hasMeasure1 BOOLEAN,
	hasMeasure2 BOOLEAN,
	hasMeasure3 BOOLEAN,
	hasMeasure4 BOOLEAN,
	measure1Name VARCHAR(75) null,
	measure2Name VARCHAR(75) null,
	measure3Name VARCHAR(75) null,
	measure4Name VARCHAR(75) null,
	dataName VARCHAR(75) null
);

create table eis_SeatingCategory (
	seatingCategoryId LONG not null primary key,
	seatingCategoryName VARCHAR(75) null,
	seatingDepartmentId LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_SeatingDepartment (
	departmentId LONG not null primary key,
	departmentName VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_State (
	stateId LONG not null primary key,
	stateName VARCHAR(75) null,
	stateCode VARCHAR(10) null
);

create table eis_UserData (
	userDataId LONG not null primary key,
	userId LONG,
	libraryId LONG,
	dataId LONG,
	createdByUserId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_UserLibrary (
	userLibraryId LONG not null primary key,
	userId LONG,
	libraryId LONG,
	companyId LONG,
	groupId LONG,
	createdByUserId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table eis_UserReport (
	userReportId LONG not null primary key,
	userId LONG,
	libraryId LONG,
	reportId LONG,
	createdByUserId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table eis_VisitorCategory (
	visitorCategoryId LONG not null primary key,
	visitorCategoryCode VARCHAR(75) null,
	visitorCategoryName VARCHAR(75) null
);
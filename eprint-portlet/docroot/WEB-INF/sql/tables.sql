create table Eprints_Eprint (
	eprintId LONG not null primary key,
	groupId LONG,
	userId LONG,
	title VARCHAR(255) null,
	urlTitle VARCHAR(255) null,
	eprintType VARCHAR(75) null,
	eprintStatus VARCHAR(75) null,
	metadataVisibility VARCHAR(75) null,
	eprintAbstract TEXT null,
	eprintKeywords TEXT null,
	isPublished VARCHAR(75) null,
	dateYear VARCHAR(75) null,
	fullTextStatus VARCHAR(75) null,
	companyId LONG,
	modifiedDate DATE null,
	createdDate DATE null
);

create table Eprints_EprintStaticContent (
	contentId LONG not null primary key,
	content TEXT null
);

create table Eprints_EprintSubject (
	eprintId LONG not null,
	subjectId VARCHAR(75) not null,
	subjectName VARCHAR(75) null,
	primary key (eprintId, subjectId)
);
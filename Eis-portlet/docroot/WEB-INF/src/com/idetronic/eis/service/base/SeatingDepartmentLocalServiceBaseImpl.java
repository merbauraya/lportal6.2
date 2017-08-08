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

package com.idetronic.eis.service.base;

import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.service.SeatingDepartmentLocalService;
import com.idetronic.eis.service.persistence.ConfigPersistence;
import com.idetronic.eis.service.persistence.FactAcquisitionFinder;
import com.idetronic.eis.service.persistence.FactAcquisitionPersistence;
import com.idetronic.eis.service.persistence.FactArticleIndexingPersistence;
import com.idetronic.eis.service.persistence.FactConsultationFinder;
import com.idetronic.eis.service.persistence.FactConsultationPersistence;
import com.idetronic.eis.service.persistence.FactCustomerComplaintPersistence;
import com.idetronic.eis.service.persistence.FactDataFinder;
import com.idetronic.eis.service.persistence.FactDataPersistence;
import com.idetronic.eis.service.persistence.FactDatabaseUsageFinder;
import com.idetronic.eis.service.persistence.FactDatabaseUsagePersistence;
import com.idetronic.eis.service.persistence.FactDigitalCollectionFinder;
import com.idetronic.eis.service.persistence.FactDigitalCollectionPersistence;
import com.idetronic.eis.service.persistence.FactExpenseFinder;
import com.idetronic.eis.service.persistence.FactExpensePersistence;
import com.idetronic.eis.service.persistence.FactGiftReceivedFinder;
import com.idetronic.eis.service.persistence.FactGiftReceivedPersistence;
import com.idetronic.eis.service.persistence.FactIncomeFinder;
import com.idetronic.eis.service.persistence.FactIncomePersistence;
import com.idetronic.eis.service.persistence.FactInterLibLoanFinder;
import com.idetronic.eis.service.persistence.FactInterLibLoanPersistence;
import com.idetronic.eis.service.persistence.FactInternationalPortalUsagePersistence;
import com.idetronic.eis.service.persistence.FactIrItemFinder;
import com.idetronic.eis.service.persistence.FactIrItemPersistence;
import com.idetronic.eis.service.persistence.FactIrSubmissionFinder;
import com.idetronic.eis.service.persistence.FactIrSubmissionPersistence;
import com.idetronic.eis.service.persistence.FactItManagementFinder;
import com.idetronic.eis.service.persistence.FactItManagementPersistence;
import com.idetronic.eis.service.persistence.FactLibraryVisitorPersistence;
import com.idetronic.eis.service.persistence.FactMembershipFinder;
import com.idetronic.eis.service.persistence.FactMembershipPersistence;
import com.idetronic.eis.service.persistence.FactNonPrintedMaterialFinder;
import com.idetronic.eis.service.persistence.FactNonPrintedMaterialPersistence;
import com.idetronic.eis.service.persistence.FactPostFinder;
import com.idetronic.eis.service.persistence.FactPostPersistence;
import com.idetronic.eis.service.persistence.FactPrintedMaterialFinder;
import com.idetronic.eis.service.persistence.FactPrintedMaterialPersistence;
import com.idetronic.eis.service.persistence.FactReleaseCatalogingPersistence;
import com.idetronic.eis.service.persistence.FactSeatingFinder;
import com.idetronic.eis.service.persistence.FactSeatingPersistence;
import com.idetronic.eis.service.persistence.FactVisitorFinder;
import com.idetronic.eis.service.persistence.FactVisitorPersistence;
import com.idetronic.eis.service.persistence.FacultyPersistence;
import com.idetronic.eis.service.persistence.FacultyTypePersistence;
import com.idetronic.eis.service.persistence.ItemMediumPersistence;
import com.idetronic.eis.service.persistence.ItemTypeCategoryPersistence;
import com.idetronic.eis.service.persistence.ItemTypePersistence;
import com.idetronic.eis.service.persistence.KpiEntryPersistence;
import com.idetronic.eis.service.persistence.KpiTypePersistence;
import com.idetronic.eis.service.persistence.LibraryFinder;
import com.idetronic.eis.service.persistence.LibraryPersistence;
import com.idetronic.eis.service.persistence.LibrarySeatingDepartmentPersistence;
import com.idetronic.eis.service.persistence.LibraryTypePersistence;
import com.idetronic.eis.service.persistence.LoanFinder;
import com.idetronic.eis.service.persistence.LoanPersistence;
import com.idetronic.eis.service.persistence.MasterFilePersistence;
import com.idetronic.eis.service.persistence.MasterTypePersistence;
import com.idetronic.eis.service.persistence.MemberCategoryPersistence;
import com.idetronic.eis.service.persistence.PostCategoryPersistence;
import com.idetronic.eis.service.persistence.PostGradePersistence;
import com.idetronic.eis.service.persistence.ProjectActivityPersistence;
import com.idetronic.eis.service.persistence.ProjectPersistence;
import com.idetronic.eis.service.persistence.ProjectResourcePersistence;
import com.idetronic.eis.service.persistence.ProjectResourceTypePersistence;
import com.idetronic.eis.service.persistence.ProjectStrategyPersistence;
import com.idetronic.eis.service.persistence.ReportPersistence;
import com.idetronic.eis.service.persistence.SeatingCategoryPersistence;
import com.idetronic.eis.service.persistence.SeatingDepartmentPersistence;
import com.idetronic.eis.service.persistence.StatePersistence;
import com.idetronic.eis.service.persistence.UserLibraryPersistence;
import com.idetronic.eis.service.persistence.UserReportPersistence;
import com.idetronic.eis.service.persistence.VisitorCategoryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the seating department local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.idetronic.eis.service.impl.SeatingDepartmentLocalServiceImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.impl.SeatingDepartmentLocalServiceImpl
 * @see com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil
 * @generated
 */
public abstract class SeatingDepartmentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SeatingDepartmentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil} to access the seating department local service.
	 */

	/**
	 * Adds the seating department to the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatingDepartment the seating department
	 * @return the seating department that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SeatingDepartment addSeatingDepartment(
		SeatingDepartment seatingDepartment) throws SystemException {
		seatingDepartment.setNew(true);

		return seatingDepartmentPersistence.update(seatingDepartment);
	}

	/**
	 * Creates a new seating department with the primary key. Does not add the seating department to the database.
	 *
	 * @param departmentId the primary key for the new seating department
	 * @return the new seating department
	 */
	@Override
	public SeatingDepartment createSeatingDepartment(long departmentId) {
		return seatingDepartmentPersistence.create(departmentId);
	}

	/**
	 * Deletes the seating department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the seating department
	 * @return the seating department that was removed
	 * @throws PortalException if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SeatingDepartment deleteSeatingDepartment(long departmentId)
		throws PortalException, SystemException {
		return seatingDepartmentPersistence.remove(departmentId);
	}

	/**
	 * Deletes the seating department from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatingDepartment the seating department
	 * @return the seating department that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SeatingDepartment deleteSeatingDepartment(
		SeatingDepartment seatingDepartment) throws SystemException {
		return seatingDepartmentPersistence.remove(seatingDepartment);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SeatingDepartment.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return seatingDepartmentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return seatingDepartmentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return seatingDepartmentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return seatingDepartmentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return seatingDepartmentPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SeatingDepartment fetchSeatingDepartment(long departmentId)
		throws SystemException {
		return seatingDepartmentPersistence.fetchByPrimaryKey(departmentId);
	}

	/**
	 * Returns the seating department with the primary key.
	 *
	 * @param departmentId the primary key of the seating department
	 * @return the seating department
	 * @throws PortalException if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment getSeatingDepartment(long departmentId)
		throws PortalException, SystemException {
		return seatingDepartmentPersistence.findByPrimaryKey(departmentId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return seatingDepartmentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the seating departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seating departments
	 * @param end the upper bound of the range of seating departments (not inclusive)
	 * @return the range of seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingDepartment> getSeatingDepartments(int start, int end)
		throws SystemException {
		return seatingDepartmentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of seating departments.
	 *
	 * @return the number of seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSeatingDepartmentsCount() throws SystemException {
		return seatingDepartmentPersistence.countAll();
	}

	/**
	 * Updates the seating department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param seatingDepartment the seating department
	 * @return the seating department that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SeatingDepartment updateSeatingDepartment(
		SeatingDepartment seatingDepartment) throws SystemException {
		return seatingDepartmentPersistence.update(seatingDepartment);
	}

	/**
	 * Returns the config local service.
	 *
	 * @return the config local service
	 */
	public com.idetronic.eis.service.ConfigLocalService getConfigLocalService() {
		return configLocalService;
	}

	/**
	 * Sets the config local service.
	 *
	 * @param configLocalService the config local service
	 */
	public void setConfigLocalService(
		com.idetronic.eis.service.ConfigLocalService configLocalService) {
		this.configLocalService = configLocalService;
	}

	/**
	 * Returns the config remote service.
	 *
	 * @return the config remote service
	 */
	public com.idetronic.eis.service.ConfigService getConfigService() {
		return configService;
	}

	/**
	 * Sets the config remote service.
	 *
	 * @param configService the config remote service
	 */
	public void setConfigService(
		com.idetronic.eis.service.ConfigService configService) {
		this.configService = configService;
	}

	/**
	 * Returns the config persistence.
	 *
	 * @return the config persistence
	 */
	public ConfigPersistence getConfigPersistence() {
		return configPersistence;
	}

	/**
	 * Sets the config persistence.
	 *
	 * @param configPersistence the config persistence
	 */
	public void setConfigPersistence(ConfigPersistence configPersistence) {
		this.configPersistence = configPersistence;
	}

	/**
	 * Returns the fact acquisition local service.
	 *
	 * @return the fact acquisition local service
	 */
	public com.idetronic.eis.service.FactAcquisitionLocalService getFactAcquisitionLocalService() {
		return factAcquisitionLocalService;
	}

	/**
	 * Sets the fact acquisition local service.
	 *
	 * @param factAcquisitionLocalService the fact acquisition local service
	 */
	public void setFactAcquisitionLocalService(
		com.idetronic.eis.service.FactAcquisitionLocalService factAcquisitionLocalService) {
		this.factAcquisitionLocalService = factAcquisitionLocalService;
	}

	/**
	 * Returns the fact acquisition remote service.
	 *
	 * @return the fact acquisition remote service
	 */
	public com.idetronic.eis.service.FactAcquisitionService getFactAcquisitionService() {
		return factAcquisitionService;
	}

	/**
	 * Sets the fact acquisition remote service.
	 *
	 * @param factAcquisitionService the fact acquisition remote service
	 */
	public void setFactAcquisitionService(
		com.idetronic.eis.service.FactAcquisitionService factAcquisitionService) {
		this.factAcquisitionService = factAcquisitionService;
	}

	/**
	 * Returns the fact acquisition persistence.
	 *
	 * @return the fact acquisition persistence
	 */
	public FactAcquisitionPersistence getFactAcquisitionPersistence() {
		return factAcquisitionPersistence;
	}

	/**
	 * Sets the fact acquisition persistence.
	 *
	 * @param factAcquisitionPersistence the fact acquisition persistence
	 */
	public void setFactAcquisitionPersistence(
		FactAcquisitionPersistence factAcquisitionPersistence) {
		this.factAcquisitionPersistence = factAcquisitionPersistence;
	}

	/**
	 * Returns the fact acquisition finder.
	 *
	 * @return the fact acquisition finder
	 */
	public FactAcquisitionFinder getFactAcquisitionFinder() {
		return factAcquisitionFinder;
	}

	/**
	 * Sets the fact acquisition finder.
	 *
	 * @param factAcquisitionFinder the fact acquisition finder
	 */
	public void setFactAcquisitionFinder(
		FactAcquisitionFinder factAcquisitionFinder) {
		this.factAcquisitionFinder = factAcquisitionFinder;
	}

	/**
	 * Returns the fact article indexing local service.
	 *
	 * @return the fact article indexing local service
	 */
	public com.idetronic.eis.service.FactArticleIndexingLocalService getFactArticleIndexingLocalService() {
		return factArticleIndexingLocalService;
	}

	/**
	 * Sets the fact article indexing local service.
	 *
	 * @param factArticleIndexingLocalService the fact article indexing local service
	 */
	public void setFactArticleIndexingLocalService(
		com.idetronic.eis.service.FactArticleIndexingLocalService factArticleIndexingLocalService) {
		this.factArticleIndexingLocalService = factArticleIndexingLocalService;
	}

	/**
	 * Returns the fact article indexing remote service.
	 *
	 * @return the fact article indexing remote service
	 */
	public com.idetronic.eis.service.FactArticleIndexingService getFactArticleIndexingService() {
		return factArticleIndexingService;
	}

	/**
	 * Sets the fact article indexing remote service.
	 *
	 * @param factArticleIndexingService the fact article indexing remote service
	 */
	public void setFactArticleIndexingService(
		com.idetronic.eis.service.FactArticleIndexingService factArticleIndexingService) {
		this.factArticleIndexingService = factArticleIndexingService;
	}

	/**
	 * Returns the fact article indexing persistence.
	 *
	 * @return the fact article indexing persistence
	 */
	public FactArticleIndexingPersistence getFactArticleIndexingPersistence() {
		return factArticleIndexingPersistence;
	}

	/**
	 * Sets the fact article indexing persistence.
	 *
	 * @param factArticleIndexingPersistence the fact article indexing persistence
	 */
	public void setFactArticleIndexingPersistence(
		FactArticleIndexingPersistence factArticleIndexingPersistence) {
		this.factArticleIndexingPersistence = factArticleIndexingPersistence;
	}

	/**
	 * Returns the fact consultation local service.
	 *
	 * @return the fact consultation local service
	 */
	public com.idetronic.eis.service.FactConsultationLocalService getFactConsultationLocalService() {
		return factConsultationLocalService;
	}

	/**
	 * Sets the fact consultation local service.
	 *
	 * @param factConsultationLocalService the fact consultation local service
	 */
	public void setFactConsultationLocalService(
		com.idetronic.eis.service.FactConsultationLocalService factConsultationLocalService) {
		this.factConsultationLocalService = factConsultationLocalService;
	}

	/**
	 * Returns the fact consultation remote service.
	 *
	 * @return the fact consultation remote service
	 */
	public com.idetronic.eis.service.FactConsultationService getFactConsultationService() {
		return factConsultationService;
	}

	/**
	 * Sets the fact consultation remote service.
	 *
	 * @param factConsultationService the fact consultation remote service
	 */
	public void setFactConsultationService(
		com.idetronic.eis.service.FactConsultationService factConsultationService) {
		this.factConsultationService = factConsultationService;
	}

	/**
	 * Returns the fact consultation persistence.
	 *
	 * @return the fact consultation persistence
	 */
	public FactConsultationPersistence getFactConsultationPersistence() {
		return factConsultationPersistence;
	}

	/**
	 * Sets the fact consultation persistence.
	 *
	 * @param factConsultationPersistence the fact consultation persistence
	 */
	public void setFactConsultationPersistence(
		FactConsultationPersistence factConsultationPersistence) {
		this.factConsultationPersistence = factConsultationPersistence;
	}

	/**
	 * Returns the fact consultation finder.
	 *
	 * @return the fact consultation finder
	 */
	public FactConsultationFinder getFactConsultationFinder() {
		return factConsultationFinder;
	}

	/**
	 * Sets the fact consultation finder.
	 *
	 * @param factConsultationFinder the fact consultation finder
	 */
	public void setFactConsultationFinder(
		FactConsultationFinder factConsultationFinder) {
		this.factConsultationFinder = factConsultationFinder;
	}

	/**
	 * Returns the fact customer complaint local service.
	 *
	 * @return the fact customer complaint local service
	 */
	public com.idetronic.eis.service.FactCustomerComplaintLocalService getFactCustomerComplaintLocalService() {
		return factCustomerComplaintLocalService;
	}

	/**
	 * Sets the fact customer complaint local service.
	 *
	 * @param factCustomerComplaintLocalService the fact customer complaint local service
	 */
	public void setFactCustomerComplaintLocalService(
		com.idetronic.eis.service.FactCustomerComplaintLocalService factCustomerComplaintLocalService) {
		this.factCustomerComplaintLocalService = factCustomerComplaintLocalService;
	}

	/**
	 * Returns the fact customer complaint remote service.
	 *
	 * @return the fact customer complaint remote service
	 */
	public com.idetronic.eis.service.FactCustomerComplaintService getFactCustomerComplaintService() {
		return factCustomerComplaintService;
	}

	/**
	 * Sets the fact customer complaint remote service.
	 *
	 * @param factCustomerComplaintService the fact customer complaint remote service
	 */
	public void setFactCustomerComplaintService(
		com.idetronic.eis.service.FactCustomerComplaintService factCustomerComplaintService) {
		this.factCustomerComplaintService = factCustomerComplaintService;
	}

	/**
	 * Returns the fact customer complaint persistence.
	 *
	 * @return the fact customer complaint persistence
	 */
	public FactCustomerComplaintPersistence getFactCustomerComplaintPersistence() {
		return factCustomerComplaintPersistence;
	}

	/**
	 * Sets the fact customer complaint persistence.
	 *
	 * @param factCustomerComplaintPersistence the fact customer complaint persistence
	 */
	public void setFactCustomerComplaintPersistence(
		FactCustomerComplaintPersistence factCustomerComplaintPersistence) {
		this.factCustomerComplaintPersistence = factCustomerComplaintPersistence;
	}

	/**
	 * Returns the fact data local service.
	 *
	 * @return the fact data local service
	 */
	public com.idetronic.eis.service.FactDataLocalService getFactDataLocalService() {
		return factDataLocalService;
	}

	/**
	 * Sets the fact data local service.
	 *
	 * @param factDataLocalService the fact data local service
	 */
	public void setFactDataLocalService(
		com.idetronic.eis.service.FactDataLocalService factDataLocalService) {
		this.factDataLocalService = factDataLocalService;
	}

	/**
	 * Returns the fact data remote service.
	 *
	 * @return the fact data remote service
	 */
	public com.idetronic.eis.service.FactDataService getFactDataService() {
		return factDataService;
	}

	/**
	 * Sets the fact data remote service.
	 *
	 * @param factDataService the fact data remote service
	 */
	public void setFactDataService(
		com.idetronic.eis.service.FactDataService factDataService) {
		this.factDataService = factDataService;
	}

	/**
	 * Returns the fact data persistence.
	 *
	 * @return the fact data persistence
	 */
	public FactDataPersistence getFactDataPersistence() {
		return factDataPersistence;
	}

	/**
	 * Sets the fact data persistence.
	 *
	 * @param factDataPersistence the fact data persistence
	 */
	public void setFactDataPersistence(FactDataPersistence factDataPersistence) {
		this.factDataPersistence = factDataPersistence;
	}

	/**
	 * Returns the fact data finder.
	 *
	 * @return the fact data finder
	 */
	public FactDataFinder getFactDataFinder() {
		return factDataFinder;
	}

	/**
	 * Sets the fact data finder.
	 *
	 * @param factDataFinder the fact data finder
	 */
	public void setFactDataFinder(FactDataFinder factDataFinder) {
		this.factDataFinder = factDataFinder;
	}

	/**
	 * Returns the fact database usage local service.
	 *
	 * @return the fact database usage local service
	 */
	public com.idetronic.eis.service.FactDatabaseUsageLocalService getFactDatabaseUsageLocalService() {
		return factDatabaseUsageLocalService;
	}

	/**
	 * Sets the fact database usage local service.
	 *
	 * @param factDatabaseUsageLocalService the fact database usage local service
	 */
	public void setFactDatabaseUsageLocalService(
		com.idetronic.eis.service.FactDatabaseUsageLocalService factDatabaseUsageLocalService) {
		this.factDatabaseUsageLocalService = factDatabaseUsageLocalService;
	}

	/**
	 * Returns the fact database usage remote service.
	 *
	 * @return the fact database usage remote service
	 */
	public com.idetronic.eis.service.FactDatabaseUsageService getFactDatabaseUsageService() {
		return factDatabaseUsageService;
	}

	/**
	 * Sets the fact database usage remote service.
	 *
	 * @param factDatabaseUsageService the fact database usage remote service
	 */
	public void setFactDatabaseUsageService(
		com.idetronic.eis.service.FactDatabaseUsageService factDatabaseUsageService) {
		this.factDatabaseUsageService = factDatabaseUsageService;
	}

	/**
	 * Returns the fact database usage persistence.
	 *
	 * @return the fact database usage persistence
	 */
	public FactDatabaseUsagePersistence getFactDatabaseUsagePersistence() {
		return factDatabaseUsagePersistence;
	}

	/**
	 * Sets the fact database usage persistence.
	 *
	 * @param factDatabaseUsagePersistence the fact database usage persistence
	 */
	public void setFactDatabaseUsagePersistence(
		FactDatabaseUsagePersistence factDatabaseUsagePersistence) {
		this.factDatabaseUsagePersistence = factDatabaseUsagePersistence;
	}

	/**
	 * Returns the fact database usage finder.
	 *
	 * @return the fact database usage finder
	 */
	public FactDatabaseUsageFinder getFactDatabaseUsageFinder() {
		return factDatabaseUsageFinder;
	}

	/**
	 * Sets the fact database usage finder.
	 *
	 * @param factDatabaseUsageFinder the fact database usage finder
	 */
	public void setFactDatabaseUsageFinder(
		FactDatabaseUsageFinder factDatabaseUsageFinder) {
		this.factDatabaseUsageFinder = factDatabaseUsageFinder;
	}

	/**
	 * Returns the fact digital collection local service.
	 *
	 * @return the fact digital collection local service
	 */
	public com.idetronic.eis.service.FactDigitalCollectionLocalService getFactDigitalCollectionLocalService() {
		return factDigitalCollectionLocalService;
	}

	/**
	 * Sets the fact digital collection local service.
	 *
	 * @param factDigitalCollectionLocalService the fact digital collection local service
	 */
	public void setFactDigitalCollectionLocalService(
		com.idetronic.eis.service.FactDigitalCollectionLocalService factDigitalCollectionLocalService) {
		this.factDigitalCollectionLocalService = factDigitalCollectionLocalService;
	}

	/**
	 * Returns the fact digital collection remote service.
	 *
	 * @return the fact digital collection remote service
	 */
	public com.idetronic.eis.service.FactDigitalCollectionService getFactDigitalCollectionService() {
		return factDigitalCollectionService;
	}

	/**
	 * Sets the fact digital collection remote service.
	 *
	 * @param factDigitalCollectionService the fact digital collection remote service
	 */
	public void setFactDigitalCollectionService(
		com.idetronic.eis.service.FactDigitalCollectionService factDigitalCollectionService) {
		this.factDigitalCollectionService = factDigitalCollectionService;
	}

	/**
	 * Returns the fact digital collection persistence.
	 *
	 * @return the fact digital collection persistence
	 */
	public FactDigitalCollectionPersistence getFactDigitalCollectionPersistence() {
		return factDigitalCollectionPersistence;
	}

	/**
	 * Sets the fact digital collection persistence.
	 *
	 * @param factDigitalCollectionPersistence the fact digital collection persistence
	 */
	public void setFactDigitalCollectionPersistence(
		FactDigitalCollectionPersistence factDigitalCollectionPersistence) {
		this.factDigitalCollectionPersistence = factDigitalCollectionPersistence;
	}

	/**
	 * Returns the fact digital collection finder.
	 *
	 * @return the fact digital collection finder
	 */
	public FactDigitalCollectionFinder getFactDigitalCollectionFinder() {
		return factDigitalCollectionFinder;
	}

	/**
	 * Sets the fact digital collection finder.
	 *
	 * @param factDigitalCollectionFinder the fact digital collection finder
	 */
	public void setFactDigitalCollectionFinder(
		FactDigitalCollectionFinder factDigitalCollectionFinder) {
		this.factDigitalCollectionFinder = factDigitalCollectionFinder;
	}

	/**
	 * Returns the fact expense local service.
	 *
	 * @return the fact expense local service
	 */
	public com.idetronic.eis.service.FactExpenseLocalService getFactExpenseLocalService() {
		return factExpenseLocalService;
	}

	/**
	 * Sets the fact expense local service.
	 *
	 * @param factExpenseLocalService the fact expense local service
	 */
	public void setFactExpenseLocalService(
		com.idetronic.eis.service.FactExpenseLocalService factExpenseLocalService) {
		this.factExpenseLocalService = factExpenseLocalService;
	}

	/**
	 * Returns the fact expense remote service.
	 *
	 * @return the fact expense remote service
	 */
	public com.idetronic.eis.service.FactExpenseService getFactExpenseService() {
		return factExpenseService;
	}

	/**
	 * Sets the fact expense remote service.
	 *
	 * @param factExpenseService the fact expense remote service
	 */
	public void setFactExpenseService(
		com.idetronic.eis.service.FactExpenseService factExpenseService) {
		this.factExpenseService = factExpenseService;
	}

	/**
	 * Returns the fact expense persistence.
	 *
	 * @return the fact expense persistence
	 */
	public FactExpensePersistence getFactExpensePersistence() {
		return factExpensePersistence;
	}

	/**
	 * Sets the fact expense persistence.
	 *
	 * @param factExpensePersistence the fact expense persistence
	 */
	public void setFactExpensePersistence(
		FactExpensePersistence factExpensePersistence) {
		this.factExpensePersistence = factExpensePersistence;
	}

	/**
	 * Returns the fact expense finder.
	 *
	 * @return the fact expense finder
	 */
	public FactExpenseFinder getFactExpenseFinder() {
		return factExpenseFinder;
	}

	/**
	 * Sets the fact expense finder.
	 *
	 * @param factExpenseFinder the fact expense finder
	 */
	public void setFactExpenseFinder(FactExpenseFinder factExpenseFinder) {
		this.factExpenseFinder = factExpenseFinder;
	}

	/**
	 * Returns the fact gift received local service.
	 *
	 * @return the fact gift received local service
	 */
	public com.idetronic.eis.service.FactGiftReceivedLocalService getFactGiftReceivedLocalService() {
		return factGiftReceivedLocalService;
	}

	/**
	 * Sets the fact gift received local service.
	 *
	 * @param factGiftReceivedLocalService the fact gift received local service
	 */
	public void setFactGiftReceivedLocalService(
		com.idetronic.eis.service.FactGiftReceivedLocalService factGiftReceivedLocalService) {
		this.factGiftReceivedLocalService = factGiftReceivedLocalService;
	}

	/**
	 * Returns the fact gift received remote service.
	 *
	 * @return the fact gift received remote service
	 */
	public com.idetronic.eis.service.FactGiftReceivedService getFactGiftReceivedService() {
		return factGiftReceivedService;
	}

	/**
	 * Sets the fact gift received remote service.
	 *
	 * @param factGiftReceivedService the fact gift received remote service
	 */
	public void setFactGiftReceivedService(
		com.idetronic.eis.service.FactGiftReceivedService factGiftReceivedService) {
		this.factGiftReceivedService = factGiftReceivedService;
	}

	/**
	 * Returns the fact gift received persistence.
	 *
	 * @return the fact gift received persistence
	 */
	public FactGiftReceivedPersistence getFactGiftReceivedPersistence() {
		return factGiftReceivedPersistence;
	}

	/**
	 * Sets the fact gift received persistence.
	 *
	 * @param factGiftReceivedPersistence the fact gift received persistence
	 */
	public void setFactGiftReceivedPersistence(
		FactGiftReceivedPersistence factGiftReceivedPersistence) {
		this.factGiftReceivedPersistence = factGiftReceivedPersistence;
	}

	/**
	 * Returns the fact gift received finder.
	 *
	 * @return the fact gift received finder
	 */
	public FactGiftReceivedFinder getFactGiftReceivedFinder() {
		return factGiftReceivedFinder;
	}

	/**
	 * Sets the fact gift received finder.
	 *
	 * @param factGiftReceivedFinder the fact gift received finder
	 */
	public void setFactGiftReceivedFinder(
		FactGiftReceivedFinder factGiftReceivedFinder) {
		this.factGiftReceivedFinder = factGiftReceivedFinder;
	}

	/**
	 * Returns the fact income local service.
	 *
	 * @return the fact income local service
	 */
	public com.idetronic.eis.service.FactIncomeLocalService getFactIncomeLocalService() {
		return factIncomeLocalService;
	}

	/**
	 * Sets the fact income local service.
	 *
	 * @param factIncomeLocalService the fact income local service
	 */
	public void setFactIncomeLocalService(
		com.idetronic.eis.service.FactIncomeLocalService factIncomeLocalService) {
		this.factIncomeLocalService = factIncomeLocalService;
	}

	/**
	 * Returns the fact income remote service.
	 *
	 * @return the fact income remote service
	 */
	public com.idetronic.eis.service.FactIncomeService getFactIncomeService() {
		return factIncomeService;
	}

	/**
	 * Sets the fact income remote service.
	 *
	 * @param factIncomeService the fact income remote service
	 */
	public void setFactIncomeService(
		com.idetronic.eis.service.FactIncomeService factIncomeService) {
		this.factIncomeService = factIncomeService;
	}

	/**
	 * Returns the fact income persistence.
	 *
	 * @return the fact income persistence
	 */
	public FactIncomePersistence getFactIncomePersistence() {
		return factIncomePersistence;
	}

	/**
	 * Sets the fact income persistence.
	 *
	 * @param factIncomePersistence the fact income persistence
	 */
	public void setFactIncomePersistence(
		FactIncomePersistence factIncomePersistence) {
		this.factIncomePersistence = factIncomePersistence;
	}

	/**
	 * Returns the fact income finder.
	 *
	 * @return the fact income finder
	 */
	public FactIncomeFinder getFactIncomeFinder() {
		return factIncomeFinder;
	}

	/**
	 * Sets the fact income finder.
	 *
	 * @param factIncomeFinder the fact income finder
	 */
	public void setFactIncomeFinder(FactIncomeFinder factIncomeFinder) {
		this.factIncomeFinder = factIncomeFinder;
	}

	/**
	 * Returns the fact inter lib loan local service.
	 *
	 * @return the fact inter lib loan local service
	 */
	public com.idetronic.eis.service.FactInterLibLoanLocalService getFactInterLibLoanLocalService() {
		return factInterLibLoanLocalService;
	}

	/**
	 * Sets the fact inter lib loan local service.
	 *
	 * @param factInterLibLoanLocalService the fact inter lib loan local service
	 */
	public void setFactInterLibLoanLocalService(
		com.idetronic.eis.service.FactInterLibLoanLocalService factInterLibLoanLocalService) {
		this.factInterLibLoanLocalService = factInterLibLoanLocalService;
	}

	/**
	 * Returns the fact inter lib loan remote service.
	 *
	 * @return the fact inter lib loan remote service
	 */
	public com.idetronic.eis.service.FactInterLibLoanService getFactInterLibLoanService() {
		return factInterLibLoanService;
	}

	/**
	 * Sets the fact inter lib loan remote service.
	 *
	 * @param factInterLibLoanService the fact inter lib loan remote service
	 */
	public void setFactInterLibLoanService(
		com.idetronic.eis.service.FactInterLibLoanService factInterLibLoanService) {
		this.factInterLibLoanService = factInterLibLoanService;
	}

	/**
	 * Returns the fact inter lib loan persistence.
	 *
	 * @return the fact inter lib loan persistence
	 */
	public FactInterLibLoanPersistence getFactInterLibLoanPersistence() {
		return factInterLibLoanPersistence;
	}

	/**
	 * Sets the fact inter lib loan persistence.
	 *
	 * @param factInterLibLoanPersistence the fact inter lib loan persistence
	 */
	public void setFactInterLibLoanPersistence(
		FactInterLibLoanPersistence factInterLibLoanPersistence) {
		this.factInterLibLoanPersistence = factInterLibLoanPersistence;
	}

	/**
	 * Returns the fact inter lib loan finder.
	 *
	 * @return the fact inter lib loan finder
	 */
	public FactInterLibLoanFinder getFactInterLibLoanFinder() {
		return factInterLibLoanFinder;
	}

	/**
	 * Sets the fact inter lib loan finder.
	 *
	 * @param factInterLibLoanFinder the fact inter lib loan finder
	 */
	public void setFactInterLibLoanFinder(
		FactInterLibLoanFinder factInterLibLoanFinder) {
		this.factInterLibLoanFinder = factInterLibLoanFinder;
	}

	/**
	 * Returns the fact international portal usage local service.
	 *
	 * @return the fact international portal usage local service
	 */
	public com.idetronic.eis.service.FactInternationalPortalUsageLocalService getFactInternationalPortalUsageLocalService() {
		return factInternationalPortalUsageLocalService;
	}

	/**
	 * Sets the fact international portal usage local service.
	 *
	 * @param factInternationalPortalUsageLocalService the fact international portal usage local service
	 */
	public void setFactInternationalPortalUsageLocalService(
		com.idetronic.eis.service.FactInternationalPortalUsageLocalService factInternationalPortalUsageLocalService) {
		this.factInternationalPortalUsageLocalService = factInternationalPortalUsageLocalService;
	}

	/**
	 * Returns the fact international portal usage remote service.
	 *
	 * @return the fact international portal usage remote service
	 */
	public com.idetronic.eis.service.FactInternationalPortalUsageService getFactInternationalPortalUsageService() {
		return factInternationalPortalUsageService;
	}

	/**
	 * Sets the fact international portal usage remote service.
	 *
	 * @param factInternationalPortalUsageService the fact international portal usage remote service
	 */
	public void setFactInternationalPortalUsageService(
		com.idetronic.eis.service.FactInternationalPortalUsageService factInternationalPortalUsageService) {
		this.factInternationalPortalUsageService = factInternationalPortalUsageService;
	}

	/**
	 * Returns the fact international portal usage persistence.
	 *
	 * @return the fact international portal usage persistence
	 */
	public FactInternationalPortalUsagePersistence getFactInternationalPortalUsagePersistence() {
		return factInternationalPortalUsagePersistence;
	}

	/**
	 * Sets the fact international portal usage persistence.
	 *
	 * @param factInternationalPortalUsagePersistence the fact international portal usage persistence
	 */
	public void setFactInternationalPortalUsagePersistence(
		FactInternationalPortalUsagePersistence factInternationalPortalUsagePersistence) {
		this.factInternationalPortalUsagePersistence = factInternationalPortalUsagePersistence;
	}

	/**
	 * Returns the fact ir item local service.
	 *
	 * @return the fact ir item local service
	 */
	public com.idetronic.eis.service.FactIrItemLocalService getFactIrItemLocalService() {
		return factIrItemLocalService;
	}

	/**
	 * Sets the fact ir item local service.
	 *
	 * @param factIrItemLocalService the fact ir item local service
	 */
	public void setFactIrItemLocalService(
		com.idetronic.eis.service.FactIrItemLocalService factIrItemLocalService) {
		this.factIrItemLocalService = factIrItemLocalService;
	}

	/**
	 * Returns the fact ir item remote service.
	 *
	 * @return the fact ir item remote service
	 */
	public com.idetronic.eis.service.FactIrItemService getFactIrItemService() {
		return factIrItemService;
	}

	/**
	 * Sets the fact ir item remote service.
	 *
	 * @param factIrItemService the fact ir item remote service
	 */
	public void setFactIrItemService(
		com.idetronic.eis.service.FactIrItemService factIrItemService) {
		this.factIrItemService = factIrItemService;
	}

	/**
	 * Returns the fact ir item persistence.
	 *
	 * @return the fact ir item persistence
	 */
	public FactIrItemPersistence getFactIrItemPersistence() {
		return factIrItemPersistence;
	}

	/**
	 * Sets the fact ir item persistence.
	 *
	 * @param factIrItemPersistence the fact ir item persistence
	 */
	public void setFactIrItemPersistence(
		FactIrItemPersistence factIrItemPersistence) {
		this.factIrItemPersistence = factIrItemPersistence;
	}

	/**
	 * Returns the fact ir item finder.
	 *
	 * @return the fact ir item finder
	 */
	public FactIrItemFinder getFactIrItemFinder() {
		return factIrItemFinder;
	}

	/**
	 * Sets the fact ir item finder.
	 *
	 * @param factIrItemFinder the fact ir item finder
	 */
	public void setFactIrItemFinder(FactIrItemFinder factIrItemFinder) {
		this.factIrItemFinder = factIrItemFinder;
	}

	/**
	 * Returns the fact ir submission local service.
	 *
	 * @return the fact ir submission local service
	 */
	public com.idetronic.eis.service.FactIrSubmissionLocalService getFactIrSubmissionLocalService() {
		return factIrSubmissionLocalService;
	}

	/**
	 * Sets the fact ir submission local service.
	 *
	 * @param factIrSubmissionLocalService the fact ir submission local service
	 */
	public void setFactIrSubmissionLocalService(
		com.idetronic.eis.service.FactIrSubmissionLocalService factIrSubmissionLocalService) {
		this.factIrSubmissionLocalService = factIrSubmissionLocalService;
	}

	/**
	 * Returns the fact ir submission remote service.
	 *
	 * @return the fact ir submission remote service
	 */
	public com.idetronic.eis.service.FactIrSubmissionService getFactIrSubmissionService() {
		return factIrSubmissionService;
	}

	/**
	 * Sets the fact ir submission remote service.
	 *
	 * @param factIrSubmissionService the fact ir submission remote service
	 */
	public void setFactIrSubmissionService(
		com.idetronic.eis.service.FactIrSubmissionService factIrSubmissionService) {
		this.factIrSubmissionService = factIrSubmissionService;
	}

	/**
	 * Returns the fact ir submission persistence.
	 *
	 * @return the fact ir submission persistence
	 */
	public FactIrSubmissionPersistence getFactIrSubmissionPersistence() {
		return factIrSubmissionPersistence;
	}

	/**
	 * Sets the fact ir submission persistence.
	 *
	 * @param factIrSubmissionPersistence the fact ir submission persistence
	 */
	public void setFactIrSubmissionPersistence(
		FactIrSubmissionPersistence factIrSubmissionPersistence) {
		this.factIrSubmissionPersistence = factIrSubmissionPersistence;
	}

	/**
	 * Returns the fact ir submission finder.
	 *
	 * @return the fact ir submission finder
	 */
	public FactIrSubmissionFinder getFactIrSubmissionFinder() {
		return factIrSubmissionFinder;
	}

	/**
	 * Sets the fact ir submission finder.
	 *
	 * @param factIrSubmissionFinder the fact ir submission finder
	 */
	public void setFactIrSubmissionFinder(
		FactIrSubmissionFinder factIrSubmissionFinder) {
		this.factIrSubmissionFinder = factIrSubmissionFinder;
	}

	/**
	 * Returns the fact it management local service.
	 *
	 * @return the fact it management local service
	 */
	public com.idetronic.eis.service.FactItManagementLocalService getFactItManagementLocalService() {
		return factItManagementLocalService;
	}

	/**
	 * Sets the fact it management local service.
	 *
	 * @param factItManagementLocalService the fact it management local service
	 */
	public void setFactItManagementLocalService(
		com.idetronic.eis.service.FactItManagementLocalService factItManagementLocalService) {
		this.factItManagementLocalService = factItManagementLocalService;
	}

	/**
	 * Returns the fact it management remote service.
	 *
	 * @return the fact it management remote service
	 */
	public com.idetronic.eis.service.FactItManagementService getFactItManagementService() {
		return factItManagementService;
	}

	/**
	 * Sets the fact it management remote service.
	 *
	 * @param factItManagementService the fact it management remote service
	 */
	public void setFactItManagementService(
		com.idetronic.eis.service.FactItManagementService factItManagementService) {
		this.factItManagementService = factItManagementService;
	}

	/**
	 * Returns the fact it management persistence.
	 *
	 * @return the fact it management persistence
	 */
	public FactItManagementPersistence getFactItManagementPersistence() {
		return factItManagementPersistence;
	}

	/**
	 * Sets the fact it management persistence.
	 *
	 * @param factItManagementPersistence the fact it management persistence
	 */
	public void setFactItManagementPersistence(
		FactItManagementPersistence factItManagementPersistence) {
		this.factItManagementPersistence = factItManagementPersistence;
	}

	/**
	 * Returns the fact it management finder.
	 *
	 * @return the fact it management finder
	 */
	public FactItManagementFinder getFactItManagementFinder() {
		return factItManagementFinder;
	}

	/**
	 * Sets the fact it management finder.
	 *
	 * @param factItManagementFinder the fact it management finder
	 */
	public void setFactItManagementFinder(
		FactItManagementFinder factItManagementFinder) {
		this.factItManagementFinder = factItManagementFinder;
	}

	/**
	 * Returns the fact library visitor local service.
	 *
	 * @return the fact library visitor local service
	 */
	public com.idetronic.eis.service.FactLibraryVisitorLocalService getFactLibraryVisitorLocalService() {
		return factLibraryVisitorLocalService;
	}

	/**
	 * Sets the fact library visitor local service.
	 *
	 * @param factLibraryVisitorLocalService the fact library visitor local service
	 */
	public void setFactLibraryVisitorLocalService(
		com.idetronic.eis.service.FactLibraryVisitorLocalService factLibraryVisitorLocalService) {
		this.factLibraryVisitorLocalService = factLibraryVisitorLocalService;
	}

	/**
	 * Returns the fact library visitor remote service.
	 *
	 * @return the fact library visitor remote service
	 */
	public com.idetronic.eis.service.FactLibraryVisitorService getFactLibraryVisitorService() {
		return factLibraryVisitorService;
	}

	/**
	 * Sets the fact library visitor remote service.
	 *
	 * @param factLibraryVisitorService the fact library visitor remote service
	 */
	public void setFactLibraryVisitorService(
		com.idetronic.eis.service.FactLibraryVisitorService factLibraryVisitorService) {
		this.factLibraryVisitorService = factLibraryVisitorService;
	}

	/**
	 * Returns the fact library visitor persistence.
	 *
	 * @return the fact library visitor persistence
	 */
	public FactLibraryVisitorPersistence getFactLibraryVisitorPersistence() {
		return factLibraryVisitorPersistence;
	}

	/**
	 * Sets the fact library visitor persistence.
	 *
	 * @param factLibraryVisitorPersistence the fact library visitor persistence
	 */
	public void setFactLibraryVisitorPersistence(
		FactLibraryVisitorPersistence factLibraryVisitorPersistence) {
		this.factLibraryVisitorPersistence = factLibraryVisitorPersistence;
	}

	/**
	 * Returns the fact membership local service.
	 *
	 * @return the fact membership local service
	 */
	public com.idetronic.eis.service.FactMembershipLocalService getFactMembershipLocalService() {
		return factMembershipLocalService;
	}

	/**
	 * Sets the fact membership local service.
	 *
	 * @param factMembershipLocalService the fact membership local service
	 */
	public void setFactMembershipLocalService(
		com.idetronic.eis.service.FactMembershipLocalService factMembershipLocalService) {
		this.factMembershipLocalService = factMembershipLocalService;
	}

	/**
	 * Returns the fact membership remote service.
	 *
	 * @return the fact membership remote service
	 */
	public com.idetronic.eis.service.FactMembershipService getFactMembershipService() {
		return factMembershipService;
	}

	/**
	 * Sets the fact membership remote service.
	 *
	 * @param factMembershipService the fact membership remote service
	 */
	public void setFactMembershipService(
		com.idetronic.eis.service.FactMembershipService factMembershipService) {
		this.factMembershipService = factMembershipService;
	}

	/**
	 * Returns the fact membership persistence.
	 *
	 * @return the fact membership persistence
	 */
	public FactMembershipPersistence getFactMembershipPersistence() {
		return factMembershipPersistence;
	}

	/**
	 * Sets the fact membership persistence.
	 *
	 * @param factMembershipPersistence the fact membership persistence
	 */
	public void setFactMembershipPersistence(
		FactMembershipPersistence factMembershipPersistence) {
		this.factMembershipPersistence = factMembershipPersistence;
	}

	/**
	 * Returns the fact membership finder.
	 *
	 * @return the fact membership finder
	 */
	public FactMembershipFinder getFactMembershipFinder() {
		return factMembershipFinder;
	}

	/**
	 * Sets the fact membership finder.
	 *
	 * @param factMembershipFinder the fact membership finder
	 */
	public void setFactMembershipFinder(
		FactMembershipFinder factMembershipFinder) {
		this.factMembershipFinder = factMembershipFinder;
	}

	/**
	 * Returns the fact non printed material local service.
	 *
	 * @return the fact non printed material local service
	 */
	public com.idetronic.eis.service.FactNonPrintedMaterialLocalService getFactNonPrintedMaterialLocalService() {
		return factNonPrintedMaterialLocalService;
	}

	/**
	 * Sets the fact non printed material local service.
	 *
	 * @param factNonPrintedMaterialLocalService the fact non printed material local service
	 */
	public void setFactNonPrintedMaterialLocalService(
		com.idetronic.eis.service.FactNonPrintedMaterialLocalService factNonPrintedMaterialLocalService) {
		this.factNonPrintedMaterialLocalService = factNonPrintedMaterialLocalService;
	}

	/**
	 * Returns the fact non printed material remote service.
	 *
	 * @return the fact non printed material remote service
	 */
	public com.idetronic.eis.service.FactNonPrintedMaterialService getFactNonPrintedMaterialService() {
		return factNonPrintedMaterialService;
	}

	/**
	 * Sets the fact non printed material remote service.
	 *
	 * @param factNonPrintedMaterialService the fact non printed material remote service
	 */
	public void setFactNonPrintedMaterialService(
		com.idetronic.eis.service.FactNonPrintedMaterialService factNonPrintedMaterialService) {
		this.factNonPrintedMaterialService = factNonPrintedMaterialService;
	}

	/**
	 * Returns the fact non printed material persistence.
	 *
	 * @return the fact non printed material persistence
	 */
	public FactNonPrintedMaterialPersistence getFactNonPrintedMaterialPersistence() {
		return factNonPrintedMaterialPersistence;
	}

	/**
	 * Sets the fact non printed material persistence.
	 *
	 * @param factNonPrintedMaterialPersistence the fact non printed material persistence
	 */
	public void setFactNonPrintedMaterialPersistence(
		FactNonPrintedMaterialPersistence factNonPrintedMaterialPersistence) {
		this.factNonPrintedMaterialPersistence = factNonPrintedMaterialPersistence;
	}

	/**
	 * Returns the fact non printed material finder.
	 *
	 * @return the fact non printed material finder
	 */
	public FactNonPrintedMaterialFinder getFactNonPrintedMaterialFinder() {
		return factNonPrintedMaterialFinder;
	}

	/**
	 * Sets the fact non printed material finder.
	 *
	 * @param factNonPrintedMaterialFinder the fact non printed material finder
	 */
	public void setFactNonPrintedMaterialFinder(
		FactNonPrintedMaterialFinder factNonPrintedMaterialFinder) {
		this.factNonPrintedMaterialFinder = factNonPrintedMaterialFinder;
	}

	/**
	 * Returns the fact post local service.
	 *
	 * @return the fact post local service
	 */
	public com.idetronic.eis.service.FactPostLocalService getFactPostLocalService() {
		return factPostLocalService;
	}

	/**
	 * Sets the fact post local service.
	 *
	 * @param factPostLocalService the fact post local service
	 */
	public void setFactPostLocalService(
		com.idetronic.eis.service.FactPostLocalService factPostLocalService) {
		this.factPostLocalService = factPostLocalService;
	}

	/**
	 * Returns the fact post remote service.
	 *
	 * @return the fact post remote service
	 */
	public com.idetronic.eis.service.FactPostService getFactPostService() {
		return factPostService;
	}

	/**
	 * Sets the fact post remote service.
	 *
	 * @param factPostService the fact post remote service
	 */
	public void setFactPostService(
		com.idetronic.eis.service.FactPostService factPostService) {
		this.factPostService = factPostService;
	}

	/**
	 * Returns the fact post persistence.
	 *
	 * @return the fact post persistence
	 */
	public FactPostPersistence getFactPostPersistence() {
		return factPostPersistence;
	}

	/**
	 * Sets the fact post persistence.
	 *
	 * @param factPostPersistence the fact post persistence
	 */
	public void setFactPostPersistence(FactPostPersistence factPostPersistence) {
		this.factPostPersistence = factPostPersistence;
	}

	/**
	 * Returns the fact post finder.
	 *
	 * @return the fact post finder
	 */
	public FactPostFinder getFactPostFinder() {
		return factPostFinder;
	}

	/**
	 * Sets the fact post finder.
	 *
	 * @param factPostFinder the fact post finder
	 */
	public void setFactPostFinder(FactPostFinder factPostFinder) {
		this.factPostFinder = factPostFinder;
	}

	/**
	 * Returns the fact printed material local service.
	 *
	 * @return the fact printed material local service
	 */
	public com.idetronic.eis.service.FactPrintedMaterialLocalService getFactPrintedMaterialLocalService() {
		return factPrintedMaterialLocalService;
	}

	/**
	 * Sets the fact printed material local service.
	 *
	 * @param factPrintedMaterialLocalService the fact printed material local service
	 */
	public void setFactPrintedMaterialLocalService(
		com.idetronic.eis.service.FactPrintedMaterialLocalService factPrintedMaterialLocalService) {
		this.factPrintedMaterialLocalService = factPrintedMaterialLocalService;
	}

	/**
	 * Returns the fact printed material remote service.
	 *
	 * @return the fact printed material remote service
	 */
	public com.idetronic.eis.service.FactPrintedMaterialService getFactPrintedMaterialService() {
		return factPrintedMaterialService;
	}

	/**
	 * Sets the fact printed material remote service.
	 *
	 * @param factPrintedMaterialService the fact printed material remote service
	 */
	public void setFactPrintedMaterialService(
		com.idetronic.eis.service.FactPrintedMaterialService factPrintedMaterialService) {
		this.factPrintedMaterialService = factPrintedMaterialService;
	}

	/**
	 * Returns the fact printed material persistence.
	 *
	 * @return the fact printed material persistence
	 */
	public FactPrintedMaterialPersistence getFactPrintedMaterialPersistence() {
		return factPrintedMaterialPersistence;
	}

	/**
	 * Sets the fact printed material persistence.
	 *
	 * @param factPrintedMaterialPersistence the fact printed material persistence
	 */
	public void setFactPrintedMaterialPersistence(
		FactPrintedMaterialPersistence factPrintedMaterialPersistence) {
		this.factPrintedMaterialPersistence = factPrintedMaterialPersistence;
	}

	/**
	 * Returns the fact printed material finder.
	 *
	 * @return the fact printed material finder
	 */
	public FactPrintedMaterialFinder getFactPrintedMaterialFinder() {
		return factPrintedMaterialFinder;
	}

	/**
	 * Sets the fact printed material finder.
	 *
	 * @param factPrintedMaterialFinder the fact printed material finder
	 */
	public void setFactPrintedMaterialFinder(
		FactPrintedMaterialFinder factPrintedMaterialFinder) {
		this.factPrintedMaterialFinder = factPrintedMaterialFinder;
	}

	/**
	 * Returns the fact release cataloging local service.
	 *
	 * @return the fact release cataloging local service
	 */
	public com.idetronic.eis.service.FactReleaseCatalogingLocalService getFactReleaseCatalogingLocalService() {
		return factReleaseCatalogingLocalService;
	}

	/**
	 * Sets the fact release cataloging local service.
	 *
	 * @param factReleaseCatalogingLocalService the fact release cataloging local service
	 */
	public void setFactReleaseCatalogingLocalService(
		com.idetronic.eis.service.FactReleaseCatalogingLocalService factReleaseCatalogingLocalService) {
		this.factReleaseCatalogingLocalService = factReleaseCatalogingLocalService;
	}

	/**
	 * Returns the fact release cataloging remote service.
	 *
	 * @return the fact release cataloging remote service
	 */
	public com.idetronic.eis.service.FactReleaseCatalogingService getFactReleaseCatalogingService() {
		return factReleaseCatalogingService;
	}

	/**
	 * Sets the fact release cataloging remote service.
	 *
	 * @param factReleaseCatalogingService the fact release cataloging remote service
	 */
	public void setFactReleaseCatalogingService(
		com.idetronic.eis.service.FactReleaseCatalogingService factReleaseCatalogingService) {
		this.factReleaseCatalogingService = factReleaseCatalogingService;
	}

	/**
	 * Returns the fact release cataloging persistence.
	 *
	 * @return the fact release cataloging persistence
	 */
	public FactReleaseCatalogingPersistence getFactReleaseCatalogingPersistence() {
		return factReleaseCatalogingPersistence;
	}

	/**
	 * Sets the fact release cataloging persistence.
	 *
	 * @param factReleaseCatalogingPersistence the fact release cataloging persistence
	 */
	public void setFactReleaseCatalogingPersistence(
		FactReleaseCatalogingPersistence factReleaseCatalogingPersistence) {
		this.factReleaseCatalogingPersistence = factReleaseCatalogingPersistence;
	}

	/**
	 * Returns the fact seating local service.
	 *
	 * @return the fact seating local service
	 */
	public com.idetronic.eis.service.FactSeatingLocalService getFactSeatingLocalService() {
		return factSeatingLocalService;
	}

	/**
	 * Sets the fact seating local service.
	 *
	 * @param factSeatingLocalService the fact seating local service
	 */
	public void setFactSeatingLocalService(
		com.idetronic.eis.service.FactSeatingLocalService factSeatingLocalService) {
		this.factSeatingLocalService = factSeatingLocalService;
	}

	/**
	 * Returns the fact seating remote service.
	 *
	 * @return the fact seating remote service
	 */
	public com.idetronic.eis.service.FactSeatingService getFactSeatingService() {
		return factSeatingService;
	}

	/**
	 * Sets the fact seating remote service.
	 *
	 * @param factSeatingService the fact seating remote service
	 */
	public void setFactSeatingService(
		com.idetronic.eis.service.FactSeatingService factSeatingService) {
		this.factSeatingService = factSeatingService;
	}

	/**
	 * Returns the fact seating persistence.
	 *
	 * @return the fact seating persistence
	 */
	public FactSeatingPersistence getFactSeatingPersistence() {
		return factSeatingPersistence;
	}

	/**
	 * Sets the fact seating persistence.
	 *
	 * @param factSeatingPersistence the fact seating persistence
	 */
	public void setFactSeatingPersistence(
		FactSeatingPersistence factSeatingPersistence) {
		this.factSeatingPersistence = factSeatingPersistence;
	}

	/**
	 * Returns the fact seating finder.
	 *
	 * @return the fact seating finder
	 */
	public FactSeatingFinder getFactSeatingFinder() {
		return factSeatingFinder;
	}

	/**
	 * Sets the fact seating finder.
	 *
	 * @param factSeatingFinder the fact seating finder
	 */
	public void setFactSeatingFinder(FactSeatingFinder factSeatingFinder) {
		this.factSeatingFinder = factSeatingFinder;
	}

	/**
	 * Returns the fact visitor local service.
	 *
	 * @return the fact visitor local service
	 */
	public com.idetronic.eis.service.FactVisitorLocalService getFactVisitorLocalService() {
		return factVisitorLocalService;
	}

	/**
	 * Sets the fact visitor local service.
	 *
	 * @param factVisitorLocalService the fact visitor local service
	 */
	public void setFactVisitorLocalService(
		com.idetronic.eis.service.FactVisitorLocalService factVisitorLocalService) {
		this.factVisitorLocalService = factVisitorLocalService;
	}

	/**
	 * Returns the fact visitor remote service.
	 *
	 * @return the fact visitor remote service
	 */
	public com.idetronic.eis.service.FactVisitorService getFactVisitorService() {
		return factVisitorService;
	}

	/**
	 * Sets the fact visitor remote service.
	 *
	 * @param factVisitorService the fact visitor remote service
	 */
	public void setFactVisitorService(
		com.idetronic.eis.service.FactVisitorService factVisitorService) {
		this.factVisitorService = factVisitorService;
	}

	/**
	 * Returns the fact visitor persistence.
	 *
	 * @return the fact visitor persistence
	 */
	public FactVisitorPersistence getFactVisitorPersistence() {
		return factVisitorPersistence;
	}

	/**
	 * Sets the fact visitor persistence.
	 *
	 * @param factVisitorPersistence the fact visitor persistence
	 */
	public void setFactVisitorPersistence(
		FactVisitorPersistence factVisitorPersistence) {
		this.factVisitorPersistence = factVisitorPersistence;
	}

	/**
	 * Returns the fact visitor finder.
	 *
	 * @return the fact visitor finder
	 */
	public FactVisitorFinder getFactVisitorFinder() {
		return factVisitorFinder;
	}

	/**
	 * Sets the fact visitor finder.
	 *
	 * @param factVisitorFinder the fact visitor finder
	 */
	public void setFactVisitorFinder(FactVisitorFinder factVisitorFinder) {
		this.factVisitorFinder = factVisitorFinder;
	}

	/**
	 * Returns the faculty local service.
	 *
	 * @return the faculty local service
	 */
	public com.idetronic.eis.service.FacultyLocalService getFacultyLocalService() {
		return facultyLocalService;
	}

	/**
	 * Sets the faculty local service.
	 *
	 * @param facultyLocalService the faculty local service
	 */
	public void setFacultyLocalService(
		com.idetronic.eis.service.FacultyLocalService facultyLocalService) {
		this.facultyLocalService = facultyLocalService;
	}

	/**
	 * Returns the faculty remote service.
	 *
	 * @return the faculty remote service
	 */
	public com.idetronic.eis.service.FacultyService getFacultyService() {
		return facultyService;
	}

	/**
	 * Sets the faculty remote service.
	 *
	 * @param facultyService the faculty remote service
	 */
	public void setFacultyService(
		com.idetronic.eis.service.FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	/**
	 * Returns the faculty persistence.
	 *
	 * @return the faculty persistence
	 */
	public FacultyPersistence getFacultyPersistence() {
		return facultyPersistence;
	}

	/**
	 * Sets the faculty persistence.
	 *
	 * @param facultyPersistence the faculty persistence
	 */
	public void setFacultyPersistence(FacultyPersistence facultyPersistence) {
		this.facultyPersistence = facultyPersistence;
	}

	/**
	 * Returns the faculty type local service.
	 *
	 * @return the faculty type local service
	 */
	public com.idetronic.eis.service.FacultyTypeLocalService getFacultyTypeLocalService() {
		return facultyTypeLocalService;
	}

	/**
	 * Sets the faculty type local service.
	 *
	 * @param facultyTypeLocalService the faculty type local service
	 */
	public void setFacultyTypeLocalService(
		com.idetronic.eis.service.FacultyTypeLocalService facultyTypeLocalService) {
		this.facultyTypeLocalService = facultyTypeLocalService;
	}

	/**
	 * Returns the faculty type remote service.
	 *
	 * @return the faculty type remote service
	 */
	public com.idetronic.eis.service.FacultyTypeService getFacultyTypeService() {
		return facultyTypeService;
	}

	/**
	 * Sets the faculty type remote service.
	 *
	 * @param facultyTypeService the faculty type remote service
	 */
	public void setFacultyTypeService(
		com.idetronic.eis.service.FacultyTypeService facultyTypeService) {
		this.facultyTypeService = facultyTypeService;
	}

	/**
	 * Returns the faculty type persistence.
	 *
	 * @return the faculty type persistence
	 */
	public FacultyTypePersistence getFacultyTypePersistence() {
		return facultyTypePersistence;
	}

	/**
	 * Sets the faculty type persistence.
	 *
	 * @param facultyTypePersistence the faculty type persistence
	 */
	public void setFacultyTypePersistence(
		FacultyTypePersistence facultyTypePersistence) {
		this.facultyTypePersistence = facultyTypePersistence;
	}

	/**
	 * Returns the item medium local service.
	 *
	 * @return the item medium local service
	 */
	public com.idetronic.eis.service.ItemMediumLocalService getItemMediumLocalService() {
		return itemMediumLocalService;
	}

	/**
	 * Sets the item medium local service.
	 *
	 * @param itemMediumLocalService the item medium local service
	 */
	public void setItemMediumLocalService(
		com.idetronic.eis.service.ItemMediumLocalService itemMediumLocalService) {
		this.itemMediumLocalService = itemMediumLocalService;
	}

	/**
	 * Returns the item medium remote service.
	 *
	 * @return the item medium remote service
	 */
	public com.idetronic.eis.service.ItemMediumService getItemMediumService() {
		return itemMediumService;
	}

	/**
	 * Sets the item medium remote service.
	 *
	 * @param itemMediumService the item medium remote service
	 */
	public void setItemMediumService(
		com.idetronic.eis.service.ItemMediumService itemMediumService) {
		this.itemMediumService = itemMediumService;
	}

	/**
	 * Returns the item medium persistence.
	 *
	 * @return the item medium persistence
	 */
	public ItemMediumPersistence getItemMediumPersistence() {
		return itemMediumPersistence;
	}

	/**
	 * Sets the item medium persistence.
	 *
	 * @param itemMediumPersistence the item medium persistence
	 */
	public void setItemMediumPersistence(
		ItemMediumPersistence itemMediumPersistence) {
		this.itemMediumPersistence = itemMediumPersistence;
	}

	/**
	 * Returns the item type local service.
	 *
	 * @return the item type local service
	 */
	public com.idetronic.eis.service.ItemTypeLocalService getItemTypeLocalService() {
		return itemTypeLocalService;
	}

	/**
	 * Sets the item type local service.
	 *
	 * @param itemTypeLocalService the item type local service
	 */
	public void setItemTypeLocalService(
		com.idetronic.eis.service.ItemTypeLocalService itemTypeLocalService) {
		this.itemTypeLocalService = itemTypeLocalService;
	}

	/**
	 * Returns the item type remote service.
	 *
	 * @return the item type remote service
	 */
	public com.idetronic.eis.service.ItemTypeService getItemTypeService() {
		return itemTypeService;
	}

	/**
	 * Sets the item type remote service.
	 *
	 * @param itemTypeService the item type remote service
	 */
	public void setItemTypeService(
		com.idetronic.eis.service.ItemTypeService itemTypeService) {
		this.itemTypeService = itemTypeService;
	}

	/**
	 * Returns the item type persistence.
	 *
	 * @return the item type persistence
	 */
	public ItemTypePersistence getItemTypePersistence() {
		return itemTypePersistence;
	}

	/**
	 * Sets the item type persistence.
	 *
	 * @param itemTypePersistence the item type persistence
	 */
	public void setItemTypePersistence(ItemTypePersistence itemTypePersistence) {
		this.itemTypePersistence = itemTypePersistence;
	}

	/**
	 * Returns the item type category local service.
	 *
	 * @return the item type category local service
	 */
	public com.idetronic.eis.service.ItemTypeCategoryLocalService getItemTypeCategoryLocalService() {
		return itemTypeCategoryLocalService;
	}

	/**
	 * Sets the item type category local service.
	 *
	 * @param itemTypeCategoryLocalService the item type category local service
	 */
	public void setItemTypeCategoryLocalService(
		com.idetronic.eis.service.ItemTypeCategoryLocalService itemTypeCategoryLocalService) {
		this.itemTypeCategoryLocalService = itemTypeCategoryLocalService;
	}

	/**
	 * Returns the item type category remote service.
	 *
	 * @return the item type category remote service
	 */
	public com.idetronic.eis.service.ItemTypeCategoryService getItemTypeCategoryService() {
		return itemTypeCategoryService;
	}

	/**
	 * Sets the item type category remote service.
	 *
	 * @param itemTypeCategoryService the item type category remote service
	 */
	public void setItemTypeCategoryService(
		com.idetronic.eis.service.ItemTypeCategoryService itemTypeCategoryService) {
		this.itemTypeCategoryService = itemTypeCategoryService;
	}

	/**
	 * Returns the item type category persistence.
	 *
	 * @return the item type category persistence
	 */
	public ItemTypeCategoryPersistence getItemTypeCategoryPersistence() {
		return itemTypeCategoryPersistence;
	}

	/**
	 * Sets the item type category persistence.
	 *
	 * @param itemTypeCategoryPersistence the item type category persistence
	 */
	public void setItemTypeCategoryPersistence(
		ItemTypeCategoryPersistence itemTypeCategoryPersistence) {
		this.itemTypeCategoryPersistence = itemTypeCategoryPersistence;
	}

	/**
	 * Returns the kpi entry local service.
	 *
	 * @return the kpi entry local service
	 */
	public com.idetronic.eis.service.KpiEntryLocalService getKpiEntryLocalService() {
		return kpiEntryLocalService;
	}

	/**
	 * Sets the kpi entry local service.
	 *
	 * @param kpiEntryLocalService the kpi entry local service
	 */
	public void setKpiEntryLocalService(
		com.idetronic.eis.service.KpiEntryLocalService kpiEntryLocalService) {
		this.kpiEntryLocalService = kpiEntryLocalService;
	}

	/**
	 * Returns the kpi entry remote service.
	 *
	 * @return the kpi entry remote service
	 */
	public com.idetronic.eis.service.KpiEntryService getKpiEntryService() {
		return kpiEntryService;
	}

	/**
	 * Sets the kpi entry remote service.
	 *
	 * @param kpiEntryService the kpi entry remote service
	 */
	public void setKpiEntryService(
		com.idetronic.eis.service.KpiEntryService kpiEntryService) {
		this.kpiEntryService = kpiEntryService;
	}

	/**
	 * Returns the kpi entry persistence.
	 *
	 * @return the kpi entry persistence
	 */
	public KpiEntryPersistence getKpiEntryPersistence() {
		return kpiEntryPersistence;
	}

	/**
	 * Sets the kpi entry persistence.
	 *
	 * @param kpiEntryPersistence the kpi entry persistence
	 */
	public void setKpiEntryPersistence(KpiEntryPersistence kpiEntryPersistence) {
		this.kpiEntryPersistence = kpiEntryPersistence;
	}

	/**
	 * Returns the kpi type local service.
	 *
	 * @return the kpi type local service
	 */
	public com.idetronic.eis.service.KpiTypeLocalService getKpiTypeLocalService() {
		return kpiTypeLocalService;
	}

	/**
	 * Sets the kpi type local service.
	 *
	 * @param kpiTypeLocalService the kpi type local service
	 */
	public void setKpiTypeLocalService(
		com.idetronic.eis.service.KpiTypeLocalService kpiTypeLocalService) {
		this.kpiTypeLocalService = kpiTypeLocalService;
	}

	/**
	 * Returns the kpi type remote service.
	 *
	 * @return the kpi type remote service
	 */
	public com.idetronic.eis.service.KpiTypeService getKpiTypeService() {
		return kpiTypeService;
	}

	/**
	 * Sets the kpi type remote service.
	 *
	 * @param kpiTypeService the kpi type remote service
	 */
	public void setKpiTypeService(
		com.idetronic.eis.service.KpiTypeService kpiTypeService) {
		this.kpiTypeService = kpiTypeService;
	}

	/**
	 * Returns the kpi type persistence.
	 *
	 * @return the kpi type persistence
	 */
	public KpiTypePersistence getKpiTypePersistence() {
		return kpiTypePersistence;
	}

	/**
	 * Sets the kpi type persistence.
	 *
	 * @param kpiTypePersistence the kpi type persistence
	 */
	public void setKpiTypePersistence(KpiTypePersistence kpiTypePersistence) {
		this.kpiTypePersistence = kpiTypePersistence;
	}

	/**
	 * Returns the library local service.
	 *
	 * @return the library local service
	 */
	public com.idetronic.eis.service.LibraryLocalService getLibraryLocalService() {
		return libraryLocalService;
	}

	/**
	 * Sets the library local service.
	 *
	 * @param libraryLocalService the library local service
	 */
	public void setLibraryLocalService(
		com.idetronic.eis.service.LibraryLocalService libraryLocalService) {
		this.libraryLocalService = libraryLocalService;
	}

	/**
	 * Returns the library persistence.
	 *
	 * @return the library persistence
	 */
	public LibraryPersistence getLibraryPersistence() {
		return libraryPersistence;
	}

	/**
	 * Sets the library persistence.
	 *
	 * @param libraryPersistence the library persistence
	 */
	public void setLibraryPersistence(LibraryPersistence libraryPersistence) {
		this.libraryPersistence = libraryPersistence;
	}

	/**
	 * Returns the library finder.
	 *
	 * @return the library finder
	 */
	public LibraryFinder getLibraryFinder() {
		return libraryFinder;
	}

	/**
	 * Sets the library finder.
	 *
	 * @param libraryFinder the library finder
	 */
	public void setLibraryFinder(LibraryFinder libraryFinder) {
		this.libraryFinder = libraryFinder;
	}

	/**
	 * Returns the library seating department local service.
	 *
	 * @return the library seating department local service
	 */
	public com.idetronic.eis.service.LibrarySeatingDepartmentLocalService getLibrarySeatingDepartmentLocalService() {
		return librarySeatingDepartmentLocalService;
	}

	/**
	 * Sets the library seating department local service.
	 *
	 * @param librarySeatingDepartmentLocalService the library seating department local service
	 */
	public void setLibrarySeatingDepartmentLocalService(
		com.idetronic.eis.service.LibrarySeatingDepartmentLocalService librarySeatingDepartmentLocalService) {
		this.librarySeatingDepartmentLocalService = librarySeatingDepartmentLocalService;
	}

	/**
	 * Returns the library seating department remote service.
	 *
	 * @return the library seating department remote service
	 */
	public com.idetronic.eis.service.LibrarySeatingDepartmentService getLibrarySeatingDepartmentService() {
		return librarySeatingDepartmentService;
	}

	/**
	 * Sets the library seating department remote service.
	 *
	 * @param librarySeatingDepartmentService the library seating department remote service
	 */
	public void setLibrarySeatingDepartmentService(
		com.idetronic.eis.service.LibrarySeatingDepartmentService librarySeatingDepartmentService) {
		this.librarySeatingDepartmentService = librarySeatingDepartmentService;
	}

	/**
	 * Returns the library seating department persistence.
	 *
	 * @return the library seating department persistence
	 */
	public LibrarySeatingDepartmentPersistence getLibrarySeatingDepartmentPersistence() {
		return librarySeatingDepartmentPersistence;
	}

	/**
	 * Sets the library seating department persistence.
	 *
	 * @param librarySeatingDepartmentPersistence the library seating department persistence
	 */
	public void setLibrarySeatingDepartmentPersistence(
		LibrarySeatingDepartmentPersistence librarySeatingDepartmentPersistence) {
		this.librarySeatingDepartmentPersistence = librarySeatingDepartmentPersistence;
	}

	/**
	 * Returns the library type local service.
	 *
	 * @return the library type local service
	 */
	public com.idetronic.eis.service.LibraryTypeLocalService getLibraryTypeLocalService() {
		return libraryTypeLocalService;
	}

	/**
	 * Sets the library type local service.
	 *
	 * @param libraryTypeLocalService the library type local service
	 */
	public void setLibraryTypeLocalService(
		com.idetronic.eis.service.LibraryTypeLocalService libraryTypeLocalService) {
		this.libraryTypeLocalService = libraryTypeLocalService;
	}

	/**
	 * Returns the library type persistence.
	 *
	 * @return the library type persistence
	 */
	public LibraryTypePersistence getLibraryTypePersistence() {
		return libraryTypePersistence;
	}

	/**
	 * Sets the library type persistence.
	 *
	 * @param libraryTypePersistence the library type persistence
	 */
	public void setLibraryTypePersistence(
		LibraryTypePersistence libraryTypePersistence) {
		this.libraryTypePersistence = libraryTypePersistence;
	}

	/**
	 * Returns the loan local service.
	 *
	 * @return the loan local service
	 */
	public com.idetronic.eis.service.LoanLocalService getLoanLocalService() {
		return loanLocalService;
	}

	/**
	 * Sets the loan local service.
	 *
	 * @param loanLocalService the loan local service
	 */
	public void setLoanLocalService(
		com.idetronic.eis.service.LoanLocalService loanLocalService) {
		this.loanLocalService = loanLocalService;
	}

	/**
	 * Returns the loan remote service.
	 *
	 * @return the loan remote service
	 */
	public com.idetronic.eis.service.LoanService getLoanService() {
		return loanService;
	}

	/**
	 * Sets the loan remote service.
	 *
	 * @param loanService the loan remote service
	 */
	public void setLoanService(
		com.idetronic.eis.service.LoanService loanService) {
		this.loanService = loanService;
	}

	/**
	 * Returns the loan persistence.
	 *
	 * @return the loan persistence
	 */
	public LoanPersistence getLoanPersistence() {
		return loanPersistence;
	}

	/**
	 * Sets the loan persistence.
	 *
	 * @param loanPersistence the loan persistence
	 */
	public void setLoanPersistence(LoanPersistence loanPersistence) {
		this.loanPersistence = loanPersistence;
	}

	/**
	 * Returns the loan finder.
	 *
	 * @return the loan finder
	 */
	public LoanFinder getLoanFinder() {
		return loanFinder;
	}

	/**
	 * Sets the loan finder.
	 *
	 * @param loanFinder the loan finder
	 */
	public void setLoanFinder(LoanFinder loanFinder) {
		this.loanFinder = loanFinder;
	}

	/**
	 * Returns the master file local service.
	 *
	 * @return the master file local service
	 */
	public com.idetronic.eis.service.MasterFileLocalService getMasterFileLocalService() {
		return masterFileLocalService;
	}

	/**
	 * Sets the master file local service.
	 *
	 * @param masterFileLocalService the master file local service
	 */
	public void setMasterFileLocalService(
		com.idetronic.eis.service.MasterFileLocalService masterFileLocalService) {
		this.masterFileLocalService = masterFileLocalService;
	}

	/**
	 * Returns the master file remote service.
	 *
	 * @return the master file remote service
	 */
	public com.idetronic.eis.service.MasterFileService getMasterFileService() {
		return masterFileService;
	}

	/**
	 * Sets the master file remote service.
	 *
	 * @param masterFileService the master file remote service
	 */
	public void setMasterFileService(
		com.idetronic.eis.service.MasterFileService masterFileService) {
		this.masterFileService = masterFileService;
	}

	/**
	 * Returns the master file persistence.
	 *
	 * @return the master file persistence
	 */
	public MasterFilePersistence getMasterFilePersistence() {
		return masterFilePersistence;
	}

	/**
	 * Sets the master file persistence.
	 *
	 * @param masterFilePersistence the master file persistence
	 */
	public void setMasterFilePersistence(
		MasterFilePersistence masterFilePersistence) {
		this.masterFilePersistence = masterFilePersistence;
	}

	/**
	 * Returns the master type local service.
	 *
	 * @return the master type local service
	 */
	public com.idetronic.eis.service.MasterTypeLocalService getMasterTypeLocalService() {
		return masterTypeLocalService;
	}

	/**
	 * Sets the master type local service.
	 *
	 * @param masterTypeLocalService the master type local service
	 */
	public void setMasterTypeLocalService(
		com.idetronic.eis.service.MasterTypeLocalService masterTypeLocalService) {
		this.masterTypeLocalService = masterTypeLocalService;
	}

	/**
	 * Returns the master type remote service.
	 *
	 * @return the master type remote service
	 */
	public com.idetronic.eis.service.MasterTypeService getMasterTypeService() {
		return masterTypeService;
	}

	/**
	 * Sets the master type remote service.
	 *
	 * @param masterTypeService the master type remote service
	 */
	public void setMasterTypeService(
		com.idetronic.eis.service.MasterTypeService masterTypeService) {
		this.masterTypeService = masterTypeService;
	}

	/**
	 * Returns the master type persistence.
	 *
	 * @return the master type persistence
	 */
	public MasterTypePersistence getMasterTypePersistence() {
		return masterTypePersistence;
	}

	/**
	 * Sets the master type persistence.
	 *
	 * @param masterTypePersistence the master type persistence
	 */
	public void setMasterTypePersistence(
		MasterTypePersistence masterTypePersistence) {
		this.masterTypePersistence = masterTypePersistence;
	}

	/**
	 * Returns the member category local service.
	 *
	 * @return the member category local service
	 */
	public com.idetronic.eis.service.MemberCategoryLocalService getMemberCategoryLocalService() {
		return memberCategoryLocalService;
	}

	/**
	 * Sets the member category local service.
	 *
	 * @param memberCategoryLocalService the member category local service
	 */
	public void setMemberCategoryLocalService(
		com.idetronic.eis.service.MemberCategoryLocalService memberCategoryLocalService) {
		this.memberCategoryLocalService = memberCategoryLocalService;
	}

	/**
	 * Returns the member category remote service.
	 *
	 * @return the member category remote service
	 */
	public com.idetronic.eis.service.MemberCategoryService getMemberCategoryService() {
		return memberCategoryService;
	}

	/**
	 * Sets the member category remote service.
	 *
	 * @param memberCategoryService the member category remote service
	 */
	public void setMemberCategoryService(
		com.idetronic.eis.service.MemberCategoryService memberCategoryService) {
		this.memberCategoryService = memberCategoryService;
	}

	/**
	 * Returns the member category persistence.
	 *
	 * @return the member category persistence
	 */
	public MemberCategoryPersistence getMemberCategoryPersistence() {
		return memberCategoryPersistence;
	}

	/**
	 * Sets the member category persistence.
	 *
	 * @param memberCategoryPersistence the member category persistence
	 */
	public void setMemberCategoryPersistence(
		MemberCategoryPersistence memberCategoryPersistence) {
		this.memberCategoryPersistence = memberCategoryPersistence;
	}

	/**
	 * Returns the post category local service.
	 *
	 * @return the post category local service
	 */
	public com.idetronic.eis.service.PostCategoryLocalService getPostCategoryLocalService() {
		return postCategoryLocalService;
	}

	/**
	 * Sets the post category local service.
	 *
	 * @param postCategoryLocalService the post category local service
	 */
	public void setPostCategoryLocalService(
		com.idetronic.eis.service.PostCategoryLocalService postCategoryLocalService) {
		this.postCategoryLocalService = postCategoryLocalService;
	}

	/**
	 * Returns the post category remote service.
	 *
	 * @return the post category remote service
	 */
	public com.idetronic.eis.service.PostCategoryService getPostCategoryService() {
		return postCategoryService;
	}

	/**
	 * Sets the post category remote service.
	 *
	 * @param postCategoryService the post category remote service
	 */
	public void setPostCategoryService(
		com.idetronic.eis.service.PostCategoryService postCategoryService) {
		this.postCategoryService = postCategoryService;
	}

	/**
	 * Returns the post category persistence.
	 *
	 * @return the post category persistence
	 */
	public PostCategoryPersistence getPostCategoryPersistence() {
		return postCategoryPersistence;
	}

	/**
	 * Sets the post category persistence.
	 *
	 * @param postCategoryPersistence the post category persistence
	 */
	public void setPostCategoryPersistence(
		PostCategoryPersistence postCategoryPersistence) {
		this.postCategoryPersistence = postCategoryPersistence;
	}

	/**
	 * Returns the post grade local service.
	 *
	 * @return the post grade local service
	 */
	public com.idetronic.eis.service.PostGradeLocalService getPostGradeLocalService() {
		return postGradeLocalService;
	}

	/**
	 * Sets the post grade local service.
	 *
	 * @param postGradeLocalService the post grade local service
	 */
	public void setPostGradeLocalService(
		com.idetronic.eis.service.PostGradeLocalService postGradeLocalService) {
		this.postGradeLocalService = postGradeLocalService;
	}

	/**
	 * Returns the post grade remote service.
	 *
	 * @return the post grade remote service
	 */
	public com.idetronic.eis.service.PostGradeService getPostGradeService() {
		return postGradeService;
	}

	/**
	 * Sets the post grade remote service.
	 *
	 * @param postGradeService the post grade remote service
	 */
	public void setPostGradeService(
		com.idetronic.eis.service.PostGradeService postGradeService) {
		this.postGradeService = postGradeService;
	}

	/**
	 * Returns the post grade persistence.
	 *
	 * @return the post grade persistence
	 */
	public PostGradePersistence getPostGradePersistence() {
		return postGradePersistence;
	}

	/**
	 * Sets the post grade persistence.
	 *
	 * @param postGradePersistence the post grade persistence
	 */
	public void setPostGradePersistence(
		PostGradePersistence postGradePersistence) {
		this.postGradePersistence = postGradePersistence;
	}

	/**
	 * Returns the project local service.
	 *
	 * @return the project local service
	 */
	public com.idetronic.eis.service.ProjectLocalService getProjectLocalService() {
		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(
		com.idetronic.eis.service.ProjectLocalService projectLocalService) {
		this.projectLocalService = projectLocalService;
	}

	/**
	 * Returns the project remote service.
	 *
	 * @return the project remote service
	 */
	public com.idetronic.eis.service.ProjectService getProjectService() {
		return projectService;
	}

	/**
	 * Sets the project remote service.
	 *
	 * @param projectService the project remote service
	 */
	public void setProjectService(
		com.idetronic.eis.service.ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * Returns the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
	}

	/**
	 * Returns the project activity local service.
	 *
	 * @return the project activity local service
	 */
	public com.idetronic.eis.service.ProjectActivityLocalService getProjectActivityLocalService() {
		return projectActivityLocalService;
	}

	/**
	 * Sets the project activity local service.
	 *
	 * @param projectActivityLocalService the project activity local service
	 */
	public void setProjectActivityLocalService(
		com.idetronic.eis.service.ProjectActivityLocalService projectActivityLocalService) {
		this.projectActivityLocalService = projectActivityLocalService;
	}

	/**
	 * Returns the project activity persistence.
	 *
	 * @return the project activity persistence
	 */
	public ProjectActivityPersistence getProjectActivityPersistence() {
		return projectActivityPersistence;
	}

	/**
	 * Sets the project activity persistence.
	 *
	 * @param projectActivityPersistence the project activity persistence
	 */
	public void setProjectActivityPersistence(
		ProjectActivityPersistence projectActivityPersistence) {
		this.projectActivityPersistence = projectActivityPersistence;
	}

	/**
	 * Returns the project resource remote service.
	 *
	 * @return the project resource remote service
	 */
	public com.idetronic.eis.service.ProjectResourceService getProjectResourceService() {
		return projectResourceService;
	}

	/**
	 * Sets the project resource remote service.
	 *
	 * @param projectResourceService the project resource remote service
	 */
	public void setProjectResourceService(
		com.idetronic.eis.service.ProjectResourceService projectResourceService) {
		this.projectResourceService = projectResourceService;
	}

	/**
	 * Returns the project resource persistence.
	 *
	 * @return the project resource persistence
	 */
	public ProjectResourcePersistence getProjectResourcePersistence() {
		return projectResourcePersistence;
	}

	/**
	 * Sets the project resource persistence.
	 *
	 * @param projectResourcePersistence the project resource persistence
	 */
	public void setProjectResourcePersistence(
		ProjectResourcePersistence projectResourcePersistence) {
		this.projectResourcePersistence = projectResourcePersistence;
	}

	/**
	 * Returns the project resource type remote service.
	 *
	 * @return the project resource type remote service
	 */
	public com.idetronic.eis.service.ProjectResourceTypeService getProjectResourceTypeService() {
		return projectResourceTypeService;
	}

	/**
	 * Sets the project resource type remote service.
	 *
	 * @param projectResourceTypeService the project resource type remote service
	 */
	public void setProjectResourceTypeService(
		com.idetronic.eis.service.ProjectResourceTypeService projectResourceTypeService) {
		this.projectResourceTypeService = projectResourceTypeService;
	}

	/**
	 * Returns the project resource type persistence.
	 *
	 * @return the project resource type persistence
	 */
	public ProjectResourceTypePersistence getProjectResourceTypePersistence() {
		return projectResourceTypePersistence;
	}

	/**
	 * Sets the project resource type persistence.
	 *
	 * @param projectResourceTypePersistence the project resource type persistence
	 */
	public void setProjectResourceTypePersistence(
		ProjectResourceTypePersistence projectResourceTypePersistence) {
		this.projectResourceTypePersistence = projectResourceTypePersistence;
	}

	/**
	 * Returns the project strategy local service.
	 *
	 * @return the project strategy local service
	 */
	public com.idetronic.eis.service.ProjectStrategyLocalService getProjectStrategyLocalService() {
		return projectStrategyLocalService;
	}

	/**
	 * Sets the project strategy local service.
	 *
	 * @param projectStrategyLocalService the project strategy local service
	 */
	public void setProjectStrategyLocalService(
		com.idetronic.eis.service.ProjectStrategyLocalService projectStrategyLocalService) {
		this.projectStrategyLocalService = projectStrategyLocalService;
	}

	/**
	 * Returns the project strategy persistence.
	 *
	 * @return the project strategy persistence
	 */
	public ProjectStrategyPersistence getProjectStrategyPersistence() {
		return projectStrategyPersistence;
	}

	/**
	 * Sets the project strategy persistence.
	 *
	 * @param projectStrategyPersistence the project strategy persistence
	 */
	public void setProjectStrategyPersistence(
		ProjectStrategyPersistence projectStrategyPersistence) {
		this.projectStrategyPersistence = projectStrategyPersistence;
	}

	/**
	 * Returns the report local service.
	 *
	 * @return the report local service
	 */
	public com.idetronic.eis.service.ReportLocalService getReportLocalService() {
		return reportLocalService;
	}

	/**
	 * Sets the report local service.
	 *
	 * @param reportLocalService the report local service
	 */
	public void setReportLocalService(
		com.idetronic.eis.service.ReportLocalService reportLocalService) {
		this.reportLocalService = reportLocalService;
	}

	/**
	 * Returns the report remote service.
	 *
	 * @return the report remote service
	 */
	public com.idetronic.eis.service.ReportService getReportService() {
		return reportService;
	}

	/**
	 * Sets the report remote service.
	 *
	 * @param reportService the report remote service
	 */
	public void setReportService(
		com.idetronic.eis.service.ReportService reportService) {
		this.reportService = reportService;
	}

	/**
	 * Returns the report persistence.
	 *
	 * @return the report persistence
	 */
	public ReportPersistence getReportPersistence() {
		return reportPersistence;
	}

	/**
	 * Sets the report persistence.
	 *
	 * @param reportPersistence the report persistence
	 */
	public void setReportPersistence(ReportPersistence reportPersistence) {
		this.reportPersistence = reportPersistence;
	}

	/**
	 * Returns the seating category local service.
	 *
	 * @return the seating category local service
	 */
	public com.idetronic.eis.service.SeatingCategoryLocalService getSeatingCategoryLocalService() {
		return seatingCategoryLocalService;
	}

	/**
	 * Sets the seating category local service.
	 *
	 * @param seatingCategoryLocalService the seating category local service
	 */
	public void setSeatingCategoryLocalService(
		com.idetronic.eis.service.SeatingCategoryLocalService seatingCategoryLocalService) {
		this.seatingCategoryLocalService = seatingCategoryLocalService;
	}

	/**
	 * Returns the seating category remote service.
	 *
	 * @return the seating category remote service
	 */
	public com.idetronic.eis.service.SeatingCategoryService getSeatingCategoryService() {
		return seatingCategoryService;
	}

	/**
	 * Sets the seating category remote service.
	 *
	 * @param seatingCategoryService the seating category remote service
	 */
	public void setSeatingCategoryService(
		com.idetronic.eis.service.SeatingCategoryService seatingCategoryService) {
		this.seatingCategoryService = seatingCategoryService;
	}

	/**
	 * Returns the seating category persistence.
	 *
	 * @return the seating category persistence
	 */
	public SeatingCategoryPersistence getSeatingCategoryPersistence() {
		return seatingCategoryPersistence;
	}

	/**
	 * Sets the seating category persistence.
	 *
	 * @param seatingCategoryPersistence the seating category persistence
	 */
	public void setSeatingCategoryPersistence(
		SeatingCategoryPersistence seatingCategoryPersistence) {
		this.seatingCategoryPersistence = seatingCategoryPersistence;
	}

	/**
	 * Returns the seating department local service.
	 *
	 * @return the seating department local service
	 */
	public com.idetronic.eis.service.SeatingDepartmentLocalService getSeatingDepartmentLocalService() {
		return seatingDepartmentLocalService;
	}

	/**
	 * Sets the seating department local service.
	 *
	 * @param seatingDepartmentLocalService the seating department local service
	 */
	public void setSeatingDepartmentLocalService(
		com.idetronic.eis.service.SeatingDepartmentLocalService seatingDepartmentLocalService) {
		this.seatingDepartmentLocalService = seatingDepartmentLocalService;
	}

	/**
	 * Returns the seating department remote service.
	 *
	 * @return the seating department remote service
	 */
	public com.idetronic.eis.service.SeatingDepartmentService getSeatingDepartmentService() {
		return seatingDepartmentService;
	}

	/**
	 * Sets the seating department remote service.
	 *
	 * @param seatingDepartmentService the seating department remote service
	 */
	public void setSeatingDepartmentService(
		com.idetronic.eis.service.SeatingDepartmentService seatingDepartmentService) {
		this.seatingDepartmentService = seatingDepartmentService;
	}

	/**
	 * Returns the seating department persistence.
	 *
	 * @return the seating department persistence
	 */
	public SeatingDepartmentPersistence getSeatingDepartmentPersistence() {
		return seatingDepartmentPersistence;
	}

	/**
	 * Sets the seating department persistence.
	 *
	 * @param seatingDepartmentPersistence the seating department persistence
	 */
	public void setSeatingDepartmentPersistence(
		SeatingDepartmentPersistence seatingDepartmentPersistence) {
		this.seatingDepartmentPersistence = seatingDepartmentPersistence;
	}

	/**
	 * Returns the state local service.
	 *
	 * @return the state local service
	 */
	public com.idetronic.eis.service.StateLocalService getStateLocalService() {
		return stateLocalService;
	}

	/**
	 * Sets the state local service.
	 *
	 * @param stateLocalService the state local service
	 */
	public void setStateLocalService(
		com.idetronic.eis.service.StateLocalService stateLocalService) {
		this.stateLocalService = stateLocalService;
	}

	/**
	 * Returns the state persistence.
	 *
	 * @return the state persistence
	 */
	public StatePersistence getStatePersistence() {
		return statePersistence;
	}

	/**
	 * Sets the state persistence.
	 *
	 * @param statePersistence the state persistence
	 */
	public void setStatePersistence(StatePersistence statePersistence) {
		this.statePersistence = statePersistence;
	}

	/**
	 * Returns the user library local service.
	 *
	 * @return the user library local service
	 */
	public com.idetronic.eis.service.UserLibraryLocalService getUserLibraryLocalService() {
		return userLibraryLocalService;
	}

	/**
	 * Sets the user library local service.
	 *
	 * @param userLibraryLocalService the user library local service
	 */
	public void setUserLibraryLocalService(
		com.idetronic.eis.service.UserLibraryLocalService userLibraryLocalService) {
		this.userLibraryLocalService = userLibraryLocalService;
	}

	/**
	 * Returns the user library remote service.
	 *
	 * @return the user library remote service
	 */
	public com.idetronic.eis.service.UserLibraryService getUserLibraryService() {
		return userLibraryService;
	}

	/**
	 * Sets the user library remote service.
	 *
	 * @param userLibraryService the user library remote service
	 */
	public void setUserLibraryService(
		com.idetronic.eis.service.UserLibraryService userLibraryService) {
		this.userLibraryService = userLibraryService;
	}

	/**
	 * Returns the user library persistence.
	 *
	 * @return the user library persistence
	 */
	public UserLibraryPersistence getUserLibraryPersistence() {
		return userLibraryPersistence;
	}

	/**
	 * Sets the user library persistence.
	 *
	 * @param userLibraryPersistence the user library persistence
	 */
	public void setUserLibraryPersistence(
		UserLibraryPersistence userLibraryPersistence) {
		this.userLibraryPersistence = userLibraryPersistence;
	}

	/**
	 * Returns the user report local service.
	 *
	 * @return the user report local service
	 */
	public com.idetronic.eis.service.UserReportLocalService getUserReportLocalService() {
		return userReportLocalService;
	}

	/**
	 * Sets the user report local service.
	 *
	 * @param userReportLocalService the user report local service
	 */
	public void setUserReportLocalService(
		com.idetronic.eis.service.UserReportLocalService userReportLocalService) {
		this.userReportLocalService = userReportLocalService;
	}

	/**
	 * Returns the user report remote service.
	 *
	 * @return the user report remote service
	 */
	public com.idetronic.eis.service.UserReportService getUserReportService() {
		return userReportService;
	}

	/**
	 * Sets the user report remote service.
	 *
	 * @param userReportService the user report remote service
	 */
	public void setUserReportService(
		com.idetronic.eis.service.UserReportService userReportService) {
		this.userReportService = userReportService;
	}

	/**
	 * Returns the user report persistence.
	 *
	 * @return the user report persistence
	 */
	public UserReportPersistence getUserReportPersistence() {
		return userReportPersistence;
	}

	/**
	 * Sets the user report persistence.
	 *
	 * @param userReportPersistence the user report persistence
	 */
	public void setUserReportPersistence(
		UserReportPersistence userReportPersistence) {
		this.userReportPersistence = userReportPersistence;
	}

	/**
	 * Returns the visitor category local service.
	 *
	 * @return the visitor category local service
	 */
	public com.idetronic.eis.service.VisitorCategoryLocalService getVisitorCategoryLocalService() {
		return visitorCategoryLocalService;
	}

	/**
	 * Sets the visitor category local service.
	 *
	 * @param visitorCategoryLocalService the visitor category local service
	 */
	public void setVisitorCategoryLocalService(
		com.idetronic.eis.service.VisitorCategoryLocalService visitorCategoryLocalService) {
		this.visitorCategoryLocalService = visitorCategoryLocalService;
	}

	/**
	 * Returns the visitor category remote service.
	 *
	 * @return the visitor category remote service
	 */
	public com.idetronic.eis.service.VisitorCategoryService getVisitorCategoryService() {
		return visitorCategoryService;
	}

	/**
	 * Sets the visitor category remote service.
	 *
	 * @param visitorCategoryService the visitor category remote service
	 */
	public void setVisitorCategoryService(
		com.idetronic.eis.service.VisitorCategoryService visitorCategoryService) {
		this.visitorCategoryService = visitorCategoryService;
	}

	/**
	 * Returns the visitor category persistence.
	 *
	 * @return the visitor category persistence
	 */
	public VisitorCategoryPersistence getVisitorCategoryPersistence() {
		return visitorCategoryPersistence;
	}

	/**
	 * Sets the visitor category persistence.
	 *
	 * @param visitorCategoryPersistence the visitor category persistence
	 */
	public void setVisitorCategoryPersistence(
		VisitorCategoryPersistence visitorCategoryPersistence) {
		this.visitorCategoryPersistence = visitorCategoryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.idetronic.eis.model.SeatingDepartment",
			seatingDepartmentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.idetronic.eis.model.SeatingDepartment");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SeatingDepartment.class;
	}

	protected String getModelClassName() {
		return SeatingDepartment.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = seatingDepartmentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.idetronic.eis.service.ConfigLocalService.class)
	protected com.idetronic.eis.service.ConfigLocalService configLocalService;
	@BeanReference(type = com.idetronic.eis.service.ConfigService.class)
	protected com.idetronic.eis.service.ConfigService configService;
	@BeanReference(type = ConfigPersistence.class)
	protected ConfigPersistence configPersistence;
	@BeanReference(type = com.idetronic.eis.service.FactAcquisitionLocalService.class)
	protected com.idetronic.eis.service.FactAcquisitionLocalService factAcquisitionLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactAcquisitionService.class)
	protected com.idetronic.eis.service.FactAcquisitionService factAcquisitionService;
	@BeanReference(type = FactAcquisitionPersistence.class)
	protected FactAcquisitionPersistence factAcquisitionPersistence;
	@BeanReference(type = FactAcquisitionFinder.class)
	protected FactAcquisitionFinder factAcquisitionFinder;
	@BeanReference(type = com.idetronic.eis.service.FactArticleIndexingLocalService.class)
	protected com.idetronic.eis.service.FactArticleIndexingLocalService factArticleIndexingLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactArticleIndexingService.class)
	protected com.idetronic.eis.service.FactArticleIndexingService factArticleIndexingService;
	@BeanReference(type = FactArticleIndexingPersistence.class)
	protected FactArticleIndexingPersistence factArticleIndexingPersistence;
	@BeanReference(type = com.idetronic.eis.service.FactConsultationLocalService.class)
	protected com.idetronic.eis.service.FactConsultationLocalService factConsultationLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactConsultationService.class)
	protected com.idetronic.eis.service.FactConsultationService factConsultationService;
	@BeanReference(type = FactConsultationPersistence.class)
	protected FactConsultationPersistence factConsultationPersistence;
	@BeanReference(type = FactConsultationFinder.class)
	protected FactConsultationFinder factConsultationFinder;
	@BeanReference(type = com.idetronic.eis.service.FactCustomerComplaintLocalService.class)
	protected com.idetronic.eis.service.FactCustomerComplaintLocalService factCustomerComplaintLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactCustomerComplaintService.class)
	protected com.idetronic.eis.service.FactCustomerComplaintService factCustomerComplaintService;
	@BeanReference(type = FactCustomerComplaintPersistence.class)
	protected FactCustomerComplaintPersistence factCustomerComplaintPersistence;
	@BeanReference(type = com.idetronic.eis.service.FactDataLocalService.class)
	protected com.idetronic.eis.service.FactDataLocalService factDataLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactDataService.class)
	protected com.idetronic.eis.service.FactDataService factDataService;
	@BeanReference(type = FactDataPersistence.class)
	protected FactDataPersistence factDataPersistence;
	@BeanReference(type = FactDataFinder.class)
	protected FactDataFinder factDataFinder;
	@BeanReference(type = com.idetronic.eis.service.FactDatabaseUsageLocalService.class)
	protected com.idetronic.eis.service.FactDatabaseUsageLocalService factDatabaseUsageLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactDatabaseUsageService.class)
	protected com.idetronic.eis.service.FactDatabaseUsageService factDatabaseUsageService;
	@BeanReference(type = FactDatabaseUsagePersistence.class)
	protected FactDatabaseUsagePersistence factDatabaseUsagePersistence;
	@BeanReference(type = FactDatabaseUsageFinder.class)
	protected FactDatabaseUsageFinder factDatabaseUsageFinder;
	@BeanReference(type = com.idetronic.eis.service.FactDigitalCollectionLocalService.class)
	protected com.idetronic.eis.service.FactDigitalCollectionLocalService factDigitalCollectionLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactDigitalCollectionService.class)
	protected com.idetronic.eis.service.FactDigitalCollectionService factDigitalCollectionService;
	@BeanReference(type = FactDigitalCollectionPersistence.class)
	protected FactDigitalCollectionPersistence factDigitalCollectionPersistence;
	@BeanReference(type = FactDigitalCollectionFinder.class)
	protected FactDigitalCollectionFinder factDigitalCollectionFinder;
	@BeanReference(type = com.idetronic.eis.service.FactExpenseLocalService.class)
	protected com.idetronic.eis.service.FactExpenseLocalService factExpenseLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactExpenseService.class)
	protected com.idetronic.eis.service.FactExpenseService factExpenseService;
	@BeanReference(type = FactExpensePersistence.class)
	protected FactExpensePersistence factExpensePersistence;
	@BeanReference(type = FactExpenseFinder.class)
	protected FactExpenseFinder factExpenseFinder;
	@BeanReference(type = com.idetronic.eis.service.FactGiftReceivedLocalService.class)
	protected com.idetronic.eis.service.FactGiftReceivedLocalService factGiftReceivedLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactGiftReceivedService.class)
	protected com.idetronic.eis.service.FactGiftReceivedService factGiftReceivedService;
	@BeanReference(type = FactGiftReceivedPersistence.class)
	protected FactGiftReceivedPersistence factGiftReceivedPersistence;
	@BeanReference(type = FactGiftReceivedFinder.class)
	protected FactGiftReceivedFinder factGiftReceivedFinder;
	@BeanReference(type = com.idetronic.eis.service.FactIncomeLocalService.class)
	protected com.idetronic.eis.service.FactIncomeLocalService factIncomeLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactIncomeService.class)
	protected com.idetronic.eis.service.FactIncomeService factIncomeService;
	@BeanReference(type = FactIncomePersistence.class)
	protected FactIncomePersistence factIncomePersistence;
	@BeanReference(type = FactIncomeFinder.class)
	protected FactIncomeFinder factIncomeFinder;
	@BeanReference(type = com.idetronic.eis.service.FactInterLibLoanLocalService.class)
	protected com.idetronic.eis.service.FactInterLibLoanLocalService factInterLibLoanLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactInterLibLoanService.class)
	protected com.idetronic.eis.service.FactInterLibLoanService factInterLibLoanService;
	@BeanReference(type = FactInterLibLoanPersistence.class)
	protected FactInterLibLoanPersistence factInterLibLoanPersistence;
	@BeanReference(type = FactInterLibLoanFinder.class)
	protected FactInterLibLoanFinder factInterLibLoanFinder;
	@BeanReference(type = com.idetronic.eis.service.FactInternationalPortalUsageLocalService.class)
	protected com.idetronic.eis.service.FactInternationalPortalUsageLocalService factInternationalPortalUsageLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactInternationalPortalUsageService.class)
	protected com.idetronic.eis.service.FactInternationalPortalUsageService factInternationalPortalUsageService;
	@BeanReference(type = FactInternationalPortalUsagePersistence.class)
	protected FactInternationalPortalUsagePersistence factInternationalPortalUsagePersistence;
	@BeanReference(type = com.idetronic.eis.service.FactIrItemLocalService.class)
	protected com.idetronic.eis.service.FactIrItemLocalService factIrItemLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactIrItemService.class)
	protected com.idetronic.eis.service.FactIrItemService factIrItemService;
	@BeanReference(type = FactIrItemPersistence.class)
	protected FactIrItemPersistence factIrItemPersistence;
	@BeanReference(type = FactIrItemFinder.class)
	protected FactIrItemFinder factIrItemFinder;
	@BeanReference(type = com.idetronic.eis.service.FactIrSubmissionLocalService.class)
	protected com.idetronic.eis.service.FactIrSubmissionLocalService factIrSubmissionLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactIrSubmissionService.class)
	protected com.idetronic.eis.service.FactIrSubmissionService factIrSubmissionService;
	@BeanReference(type = FactIrSubmissionPersistence.class)
	protected FactIrSubmissionPersistence factIrSubmissionPersistence;
	@BeanReference(type = FactIrSubmissionFinder.class)
	protected FactIrSubmissionFinder factIrSubmissionFinder;
	@BeanReference(type = com.idetronic.eis.service.FactItManagementLocalService.class)
	protected com.idetronic.eis.service.FactItManagementLocalService factItManagementLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactItManagementService.class)
	protected com.idetronic.eis.service.FactItManagementService factItManagementService;
	@BeanReference(type = FactItManagementPersistence.class)
	protected FactItManagementPersistence factItManagementPersistence;
	@BeanReference(type = FactItManagementFinder.class)
	protected FactItManagementFinder factItManagementFinder;
	@BeanReference(type = com.idetronic.eis.service.FactLibraryVisitorLocalService.class)
	protected com.idetronic.eis.service.FactLibraryVisitorLocalService factLibraryVisitorLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactLibraryVisitorService.class)
	protected com.idetronic.eis.service.FactLibraryVisitorService factLibraryVisitorService;
	@BeanReference(type = FactLibraryVisitorPersistence.class)
	protected FactLibraryVisitorPersistence factLibraryVisitorPersistence;
	@BeanReference(type = com.idetronic.eis.service.FactMembershipLocalService.class)
	protected com.idetronic.eis.service.FactMembershipLocalService factMembershipLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactMembershipService.class)
	protected com.idetronic.eis.service.FactMembershipService factMembershipService;
	@BeanReference(type = FactMembershipPersistence.class)
	protected FactMembershipPersistence factMembershipPersistence;
	@BeanReference(type = FactMembershipFinder.class)
	protected FactMembershipFinder factMembershipFinder;
	@BeanReference(type = com.idetronic.eis.service.FactNonPrintedMaterialLocalService.class)
	protected com.idetronic.eis.service.FactNonPrintedMaterialLocalService factNonPrintedMaterialLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactNonPrintedMaterialService.class)
	protected com.idetronic.eis.service.FactNonPrintedMaterialService factNonPrintedMaterialService;
	@BeanReference(type = FactNonPrintedMaterialPersistence.class)
	protected FactNonPrintedMaterialPersistence factNonPrintedMaterialPersistence;
	@BeanReference(type = FactNonPrintedMaterialFinder.class)
	protected FactNonPrintedMaterialFinder factNonPrintedMaterialFinder;
	@BeanReference(type = com.idetronic.eis.service.FactPostLocalService.class)
	protected com.idetronic.eis.service.FactPostLocalService factPostLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactPostService.class)
	protected com.idetronic.eis.service.FactPostService factPostService;
	@BeanReference(type = FactPostPersistence.class)
	protected FactPostPersistence factPostPersistence;
	@BeanReference(type = FactPostFinder.class)
	protected FactPostFinder factPostFinder;
	@BeanReference(type = com.idetronic.eis.service.FactPrintedMaterialLocalService.class)
	protected com.idetronic.eis.service.FactPrintedMaterialLocalService factPrintedMaterialLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactPrintedMaterialService.class)
	protected com.idetronic.eis.service.FactPrintedMaterialService factPrintedMaterialService;
	@BeanReference(type = FactPrintedMaterialPersistence.class)
	protected FactPrintedMaterialPersistence factPrintedMaterialPersistence;
	@BeanReference(type = FactPrintedMaterialFinder.class)
	protected FactPrintedMaterialFinder factPrintedMaterialFinder;
	@BeanReference(type = com.idetronic.eis.service.FactReleaseCatalogingLocalService.class)
	protected com.idetronic.eis.service.FactReleaseCatalogingLocalService factReleaseCatalogingLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactReleaseCatalogingService.class)
	protected com.idetronic.eis.service.FactReleaseCatalogingService factReleaseCatalogingService;
	@BeanReference(type = FactReleaseCatalogingPersistence.class)
	protected FactReleaseCatalogingPersistence factReleaseCatalogingPersistence;
	@BeanReference(type = com.idetronic.eis.service.FactSeatingLocalService.class)
	protected com.idetronic.eis.service.FactSeatingLocalService factSeatingLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactSeatingService.class)
	protected com.idetronic.eis.service.FactSeatingService factSeatingService;
	@BeanReference(type = FactSeatingPersistence.class)
	protected FactSeatingPersistence factSeatingPersistence;
	@BeanReference(type = FactSeatingFinder.class)
	protected FactSeatingFinder factSeatingFinder;
	@BeanReference(type = com.idetronic.eis.service.FactVisitorLocalService.class)
	protected com.idetronic.eis.service.FactVisitorLocalService factVisitorLocalService;
	@BeanReference(type = com.idetronic.eis.service.FactVisitorService.class)
	protected com.idetronic.eis.service.FactVisitorService factVisitorService;
	@BeanReference(type = FactVisitorPersistence.class)
	protected FactVisitorPersistence factVisitorPersistence;
	@BeanReference(type = FactVisitorFinder.class)
	protected FactVisitorFinder factVisitorFinder;
	@BeanReference(type = com.idetronic.eis.service.FacultyLocalService.class)
	protected com.idetronic.eis.service.FacultyLocalService facultyLocalService;
	@BeanReference(type = com.idetronic.eis.service.FacultyService.class)
	protected com.idetronic.eis.service.FacultyService facultyService;
	@BeanReference(type = FacultyPersistence.class)
	protected FacultyPersistence facultyPersistence;
	@BeanReference(type = com.idetronic.eis.service.FacultyTypeLocalService.class)
	protected com.idetronic.eis.service.FacultyTypeLocalService facultyTypeLocalService;
	@BeanReference(type = com.idetronic.eis.service.FacultyTypeService.class)
	protected com.idetronic.eis.service.FacultyTypeService facultyTypeService;
	@BeanReference(type = FacultyTypePersistence.class)
	protected FacultyTypePersistence facultyTypePersistence;
	@BeanReference(type = com.idetronic.eis.service.ItemMediumLocalService.class)
	protected com.idetronic.eis.service.ItemMediumLocalService itemMediumLocalService;
	@BeanReference(type = com.idetronic.eis.service.ItemMediumService.class)
	protected com.idetronic.eis.service.ItemMediumService itemMediumService;
	@BeanReference(type = ItemMediumPersistence.class)
	protected ItemMediumPersistence itemMediumPersistence;
	@BeanReference(type = com.idetronic.eis.service.ItemTypeLocalService.class)
	protected com.idetronic.eis.service.ItemTypeLocalService itemTypeLocalService;
	@BeanReference(type = com.idetronic.eis.service.ItemTypeService.class)
	protected com.idetronic.eis.service.ItemTypeService itemTypeService;
	@BeanReference(type = ItemTypePersistence.class)
	protected ItemTypePersistence itemTypePersistence;
	@BeanReference(type = com.idetronic.eis.service.ItemTypeCategoryLocalService.class)
	protected com.idetronic.eis.service.ItemTypeCategoryLocalService itemTypeCategoryLocalService;
	@BeanReference(type = com.idetronic.eis.service.ItemTypeCategoryService.class)
	protected com.idetronic.eis.service.ItemTypeCategoryService itemTypeCategoryService;
	@BeanReference(type = ItemTypeCategoryPersistence.class)
	protected ItemTypeCategoryPersistence itemTypeCategoryPersistence;
	@BeanReference(type = com.idetronic.eis.service.KpiEntryLocalService.class)
	protected com.idetronic.eis.service.KpiEntryLocalService kpiEntryLocalService;
	@BeanReference(type = com.idetronic.eis.service.KpiEntryService.class)
	protected com.idetronic.eis.service.KpiEntryService kpiEntryService;
	@BeanReference(type = KpiEntryPersistence.class)
	protected KpiEntryPersistence kpiEntryPersistence;
	@BeanReference(type = com.idetronic.eis.service.KpiTypeLocalService.class)
	protected com.idetronic.eis.service.KpiTypeLocalService kpiTypeLocalService;
	@BeanReference(type = com.idetronic.eis.service.KpiTypeService.class)
	protected com.idetronic.eis.service.KpiTypeService kpiTypeService;
	@BeanReference(type = KpiTypePersistence.class)
	protected KpiTypePersistence kpiTypePersistence;
	@BeanReference(type = com.idetronic.eis.service.LibraryLocalService.class)
	protected com.idetronic.eis.service.LibraryLocalService libraryLocalService;
	@BeanReference(type = LibraryPersistence.class)
	protected LibraryPersistence libraryPersistence;
	@BeanReference(type = LibraryFinder.class)
	protected LibraryFinder libraryFinder;
	@BeanReference(type = com.idetronic.eis.service.LibrarySeatingDepartmentLocalService.class)
	protected com.idetronic.eis.service.LibrarySeatingDepartmentLocalService librarySeatingDepartmentLocalService;
	@BeanReference(type = com.idetronic.eis.service.LibrarySeatingDepartmentService.class)
	protected com.idetronic.eis.service.LibrarySeatingDepartmentService librarySeatingDepartmentService;
	@BeanReference(type = LibrarySeatingDepartmentPersistence.class)
	protected LibrarySeatingDepartmentPersistence librarySeatingDepartmentPersistence;
	@BeanReference(type = com.idetronic.eis.service.LibraryTypeLocalService.class)
	protected com.idetronic.eis.service.LibraryTypeLocalService libraryTypeLocalService;
	@BeanReference(type = LibraryTypePersistence.class)
	protected LibraryTypePersistence libraryTypePersistence;
	@BeanReference(type = com.idetronic.eis.service.LoanLocalService.class)
	protected com.idetronic.eis.service.LoanLocalService loanLocalService;
	@BeanReference(type = com.idetronic.eis.service.LoanService.class)
	protected com.idetronic.eis.service.LoanService loanService;
	@BeanReference(type = LoanPersistence.class)
	protected LoanPersistence loanPersistence;
	@BeanReference(type = LoanFinder.class)
	protected LoanFinder loanFinder;
	@BeanReference(type = com.idetronic.eis.service.MasterFileLocalService.class)
	protected com.idetronic.eis.service.MasterFileLocalService masterFileLocalService;
	@BeanReference(type = com.idetronic.eis.service.MasterFileService.class)
	protected com.idetronic.eis.service.MasterFileService masterFileService;
	@BeanReference(type = MasterFilePersistence.class)
	protected MasterFilePersistence masterFilePersistence;
	@BeanReference(type = com.idetronic.eis.service.MasterTypeLocalService.class)
	protected com.idetronic.eis.service.MasterTypeLocalService masterTypeLocalService;
	@BeanReference(type = com.idetronic.eis.service.MasterTypeService.class)
	protected com.idetronic.eis.service.MasterTypeService masterTypeService;
	@BeanReference(type = MasterTypePersistence.class)
	protected MasterTypePersistence masterTypePersistence;
	@BeanReference(type = com.idetronic.eis.service.MemberCategoryLocalService.class)
	protected com.idetronic.eis.service.MemberCategoryLocalService memberCategoryLocalService;
	@BeanReference(type = com.idetronic.eis.service.MemberCategoryService.class)
	protected com.idetronic.eis.service.MemberCategoryService memberCategoryService;
	@BeanReference(type = MemberCategoryPersistence.class)
	protected MemberCategoryPersistence memberCategoryPersistence;
	@BeanReference(type = com.idetronic.eis.service.PostCategoryLocalService.class)
	protected com.idetronic.eis.service.PostCategoryLocalService postCategoryLocalService;
	@BeanReference(type = com.idetronic.eis.service.PostCategoryService.class)
	protected com.idetronic.eis.service.PostCategoryService postCategoryService;
	@BeanReference(type = PostCategoryPersistence.class)
	protected PostCategoryPersistence postCategoryPersistence;
	@BeanReference(type = com.idetronic.eis.service.PostGradeLocalService.class)
	protected com.idetronic.eis.service.PostGradeLocalService postGradeLocalService;
	@BeanReference(type = com.idetronic.eis.service.PostGradeService.class)
	protected com.idetronic.eis.service.PostGradeService postGradeService;
	@BeanReference(type = PostGradePersistence.class)
	protected PostGradePersistence postGradePersistence;
	@BeanReference(type = com.idetronic.eis.service.ProjectLocalService.class)
	protected com.idetronic.eis.service.ProjectLocalService projectLocalService;
	@BeanReference(type = com.idetronic.eis.service.ProjectService.class)
	protected com.idetronic.eis.service.ProjectService projectService;
	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;
	@BeanReference(type = com.idetronic.eis.service.ProjectActivityLocalService.class)
	protected com.idetronic.eis.service.ProjectActivityLocalService projectActivityLocalService;
	@BeanReference(type = ProjectActivityPersistence.class)
	protected ProjectActivityPersistence projectActivityPersistence;
	@BeanReference(type = com.idetronic.eis.service.ProjectResourceService.class)
	protected com.idetronic.eis.service.ProjectResourceService projectResourceService;
	@BeanReference(type = ProjectResourcePersistence.class)
	protected ProjectResourcePersistence projectResourcePersistence;
	@BeanReference(type = com.idetronic.eis.service.ProjectResourceTypeService.class)
	protected com.idetronic.eis.service.ProjectResourceTypeService projectResourceTypeService;
	@BeanReference(type = ProjectResourceTypePersistence.class)
	protected ProjectResourceTypePersistence projectResourceTypePersistence;
	@BeanReference(type = com.idetronic.eis.service.ProjectStrategyLocalService.class)
	protected com.idetronic.eis.service.ProjectStrategyLocalService projectStrategyLocalService;
	@BeanReference(type = ProjectStrategyPersistence.class)
	protected ProjectStrategyPersistence projectStrategyPersistence;
	@BeanReference(type = com.idetronic.eis.service.ReportLocalService.class)
	protected com.idetronic.eis.service.ReportLocalService reportLocalService;
	@BeanReference(type = com.idetronic.eis.service.ReportService.class)
	protected com.idetronic.eis.service.ReportService reportService;
	@BeanReference(type = ReportPersistence.class)
	protected ReportPersistence reportPersistence;
	@BeanReference(type = com.idetronic.eis.service.SeatingCategoryLocalService.class)
	protected com.idetronic.eis.service.SeatingCategoryLocalService seatingCategoryLocalService;
	@BeanReference(type = com.idetronic.eis.service.SeatingCategoryService.class)
	protected com.idetronic.eis.service.SeatingCategoryService seatingCategoryService;
	@BeanReference(type = SeatingCategoryPersistence.class)
	protected SeatingCategoryPersistence seatingCategoryPersistence;
	@BeanReference(type = com.idetronic.eis.service.SeatingDepartmentLocalService.class)
	protected com.idetronic.eis.service.SeatingDepartmentLocalService seatingDepartmentLocalService;
	@BeanReference(type = com.idetronic.eis.service.SeatingDepartmentService.class)
	protected com.idetronic.eis.service.SeatingDepartmentService seatingDepartmentService;
	@BeanReference(type = SeatingDepartmentPersistence.class)
	protected SeatingDepartmentPersistence seatingDepartmentPersistence;
	@BeanReference(type = com.idetronic.eis.service.StateLocalService.class)
	protected com.idetronic.eis.service.StateLocalService stateLocalService;
	@BeanReference(type = StatePersistence.class)
	protected StatePersistence statePersistence;
	@BeanReference(type = com.idetronic.eis.service.UserLibraryLocalService.class)
	protected com.idetronic.eis.service.UserLibraryLocalService userLibraryLocalService;
	@BeanReference(type = com.idetronic.eis.service.UserLibraryService.class)
	protected com.idetronic.eis.service.UserLibraryService userLibraryService;
	@BeanReference(type = UserLibraryPersistence.class)
	protected UserLibraryPersistence userLibraryPersistence;
	@BeanReference(type = com.idetronic.eis.service.UserReportLocalService.class)
	protected com.idetronic.eis.service.UserReportLocalService userReportLocalService;
	@BeanReference(type = com.idetronic.eis.service.UserReportService.class)
	protected com.idetronic.eis.service.UserReportService userReportService;
	@BeanReference(type = UserReportPersistence.class)
	protected UserReportPersistence userReportPersistence;
	@BeanReference(type = com.idetronic.eis.service.VisitorCategoryLocalService.class)
	protected com.idetronic.eis.service.VisitorCategoryLocalService visitorCategoryLocalService;
	@BeanReference(type = com.idetronic.eis.service.VisitorCategoryService.class)
	protected com.idetronic.eis.service.VisitorCategoryService visitorCategoryService;
	@BeanReference(type = VisitorCategoryPersistence.class)
	protected VisitorCategoryPersistence visitorCategoryPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SeatingDepartmentLocalServiceClpInvoker _clpInvoker = new SeatingDepartmentLocalServiceClpInvoker();
}
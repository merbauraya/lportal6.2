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

package com.idetronic.eis.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SeatingDepartmentLocalService}.
 *
 * @author Mazlan Mat
 * @see SeatingDepartmentLocalService
 * @generated
 */
public class SeatingDepartmentLocalServiceWrapper
	implements SeatingDepartmentLocalService,
		ServiceWrapper<SeatingDepartmentLocalService> {
	public SeatingDepartmentLocalServiceWrapper(
		SeatingDepartmentLocalService seatingDepartmentLocalService) {
		_seatingDepartmentLocalService = seatingDepartmentLocalService;
	}

	/**
	* Adds the seating department to the database. Also notifies the appropriate model listeners.
	*
	* @param seatingDepartment the seating department
	* @return the seating department that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingDepartment addSeatingDepartment(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.addSeatingDepartment(seatingDepartment);
	}

	/**
	* Creates a new seating department with the primary key. Does not add the seating department to the database.
	*
	* @param departmentId the primary key for the new seating department
	* @return the new seating department
	*/
	@Override
	public com.idetronic.eis.model.SeatingDepartment createSeatingDepartment(
		long departmentId) {
		return _seatingDepartmentLocalService.createSeatingDepartment(departmentId);
	}

	/**
	* Deletes the seating department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department that was removed
	* @throws PortalException if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingDepartment deleteSeatingDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.deleteSeatingDepartment(departmentId);
	}

	/**
	* Deletes the seating department from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingDepartment the seating department
	* @return the seating department that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingDepartment deleteSeatingDepartment(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.deleteSeatingDepartment(seatingDepartment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _seatingDepartmentLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.SeatingDepartment fetchSeatingDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.fetchSeatingDepartment(departmentId);
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
	public com.idetronic.eis.model.SeatingDepartment getSeatingDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.getSeatingDepartment(departmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.idetronic.eis.model.SeatingDepartment> getSeatingDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.getSeatingDepartments(start, end);
	}

	/**
	* Returns the number of seating departments.
	*
	* @return the number of seating departments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSeatingDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.getSeatingDepartmentsCount();
	}

	/**
	* Updates the seating department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param seatingDepartment the seating department
	* @return the seating department that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingDepartment updateSeatingDepartment(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.updateSeatingDepartment(seatingDepartment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _seatingDepartmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_seatingDepartmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _seatingDepartmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.idetronic.eis.model.SeatingDepartment add(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingDepartmentLocalService.add(name, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SeatingDepartmentLocalService getWrappedSeatingDepartmentLocalService() {
		return _seatingDepartmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSeatingDepartmentLocalService(
		SeatingDepartmentLocalService seatingDepartmentLocalService) {
		_seatingDepartmentLocalService = seatingDepartmentLocalService;
	}

	@Override
	public SeatingDepartmentLocalService getWrappedService() {
		return _seatingDepartmentLocalService;
	}

	@Override
	public void setWrappedService(
		SeatingDepartmentLocalService seatingDepartmentLocalService) {
		_seatingDepartmentLocalService = seatingDepartmentLocalService;
	}

	private SeatingDepartmentLocalService _seatingDepartmentLocalService;
}
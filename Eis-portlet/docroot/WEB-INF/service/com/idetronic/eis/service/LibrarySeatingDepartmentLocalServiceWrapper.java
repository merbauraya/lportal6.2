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
 * Provides a wrapper for {@link LibrarySeatingDepartmentLocalService}.
 *
 * @author Mazlan Mat
 * @see LibrarySeatingDepartmentLocalService
 * @generated
 */
public class LibrarySeatingDepartmentLocalServiceWrapper
	implements LibrarySeatingDepartmentLocalService,
		ServiceWrapper<LibrarySeatingDepartmentLocalService> {
	public LibrarySeatingDepartmentLocalServiceWrapper(
		LibrarySeatingDepartmentLocalService librarySeatingDepartmentLocalService) {
		_librarySeatingDepartmentLocalService = librarySeatingDepartmentLocalService;
	}

	/**
	* Adds the library seating department to the database. Also notifies the appropriate model listeners.
	*
	* @param librarySeatingDepartment the library seating department
	* @return the library seating department that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment addLibrarySeatingDepartment(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.addLibrarySeatingDepartment(librarySeatingDepartment);
	}

	/**
	* Creates a new library seating department with the primary key. Does not add the library seating department to the database.
	*
	* @param libraryDepartmentId the primary key for the new library seating department
	* @return the new library seating department
	*/
	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment createLibrarySeatingDepartment(
		long libraryDepartmentId) {
		return _librarySeatingDepartmentLocalService.createLibrarySeatingDepartment(libraryDepartmentId);
	}

	/**
	* Deletes the library seating department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryDepartmentId the primary key of the library seating department
	* @return the library seating department that was removed
	* @throws PortalException if a library seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment deleteLibrarySeatingDepartment(
		long libraryDepartmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.deleteLibrarySeatingDepartment(libraryDepartmentId);
	}

	/**
	* Deletes the library seating department from the database. Also notifies the appropriate model listeners.
	*
	* @param librarySeatingDepartment the library seating department
	* @return the library seating department that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment deleteLibrarySeatingDepartment(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.deleteLibrarySeatingDepartment(librarySeatingDepartment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _librarySeatingDepartmentLocalService.dynamicQuery();
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
		return _librarySeatingDepartmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _librarySeatingDepartmentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _librarySeatingDepartmentLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _librarySeatingDepartmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment fetchLibrarySeatingDepartment(
		long libraryDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.fetchLibrarySeatingDepartment(libraryDepartmentId);
	}

	/**
	* Returns the library seating department with the primary key.
	*
	* @param libraryDepartmentId the primary key of the library seating department
	* @return the library seating department
	* @throws PortalException if a library seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment getLibrarySeatingDepartment(
		long libraryDepartmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.getLibrarySeatingDepartment(libraryDepartmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the library seating departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library seating departments
	* @param end the upper bound of the range of library seating departments (not inclusive)
	* @return the range of library seating departments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.LibrarySeatingDepartment> getLibrarySeatingDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.getLibrarySeatingDepartments(start,
			end);
	}

	/**
	* Returns the number of library seating departments.
	*
	* @return the number of library seating departments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLibrarySeatingDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.getLibrarySeatingDepartmentsCount();
	}

	/**
	* Updates the library seating department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param librarySeatingDepartment the library seating department
	* @return the library seating department that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment updateLibrarySeatingDepartment(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.updateLibrarySeatingDepartment(librarySeatingDepartment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _librarySeatingDepartmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_librarySeatingDepartmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _librarySeatingDepartmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.idetronic.eis.model.LibrarySeatingDepartment add(
		long libraryId, long departmentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _librarySeatingDepartmentLocalService.add(libraryId,
			departmentId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LibrarySeatingDepartmentLocalService getWrappedLibrarySeatingDepartmentLocalService() {
		return _librarySeatingDepartmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLibrarySeatingDepartmentLocalService(
		LibrarySeatingDepartmentLocalService librarySeatingDepartmentLocalService) {
		_librarySeatingDepartmentLocalService = librarySeatingDepartmentLocalService;
	}

	@Override
	public LibrarySeatingDepartmentLocalService getWrappedService() {
		return _librarySeatingDepartmentLocalService;
	}

	@Override
	public void setWrappedService(
		LibrarySeatingDepartmentLocalService librarySeatingDepartmentLocalService) {
		_librarySeatingDepartmentLocalService = librarySeatingDepartmentLocalService;
	}

	private LibrarySeatingDepartmentLocalService _librarySeatingDepartmentLocalService;
}
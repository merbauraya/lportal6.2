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

package com.idetronic.eis.service.persistence;

import com.idetronic.eis.model.LibrarySeatingDepartment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the library seating department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibrarySeatingDepartmentPersistenceImpl
 * @see LibrarySeatingDepartmentUtil
 * @generated
 */
public interface LibrarySeatingDepartmentPersistence extends BasePersistence<LibrarySeatingDepartment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibrarySeatingDepartmentUtil} to access the library seating department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the library seating department where libraryId = &#63; and departmentId = &#63; or throws a {@link com.idetronic.eis.NoSuchLibrarySeatingDepartmentException} if it could not be found.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @return the matching library seating department
	* @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a matching library seating department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment findByLibraryDepartment(
		long libraryId, long departmentId)
		throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library seating department where libraryId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @return the matching library seating department, or <code>null</code> if a matching library seating department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment fetchByLibraryDepartment(
		long libraryId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library seating department where libraryId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching library seating department, or <code>null</code> if a matching library seating department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment fetchByLibraryDepartment(
		long libraryId, long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the library seating department where libraryId = &#63; and departmentId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @return the library seating department that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment removeByLibraryDepartment(
		long libraryId, long departmentId)
		throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of library seating departments where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @return the number of matching library seating departments
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryDepartment(long libraryId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the library seating department in the entity cache if it is enabled.
	*
	* @param librarySeatingDepartment the library seating department
	*/
	public void cacheResult(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment);

	/**
	* Caches the library seating departments in the entity cache if it is enabled.
	*
	* @param librarySeatingDepartments the library seating departments
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.LibrarySeatingDepartment> librarySeatingDepartments);

	/**
	* Creates a new library seating department with the primary key. Does not add the library seating department to the database.
	*
	* @param libraryDepartmentId the primary key for the new library seating department
	* @return the new library seating department
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment create(
		long libraryDepartmentId);

	/**
	* Removes the library seating department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryDepartmentId the primary key of the library seating department
	* @return the library seating department that was removed
	* @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a library seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment remove(
		long libraryDepartmentId)
		throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.LibrarySeatingDepartment updateImpl(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library seating department with the primary key or throws a {@link com.idetronic.eis.NoSuchLibrarySeatingDepartmentException} if it could not be found.
	*
	* @param libraryDepartmentId the primary key of the library seating department
	* @return the library seating department
	* @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a library seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment findByPrimaryKey(
		long libraryDepartmentId)
		throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library seating department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryDepartmentId the primary key of the library seating department
	* @return the library seating department, or <code>null</code> if a library seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibrarySeatingDepartment fetchByPrimaryKey(
		long libraryDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the library seating departments.
	*
	* @return the library seating departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.LibrarySeatingDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.LibrarySeatingDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the library seating departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library seating departments
	* @param end the upper bound of the range of library seating departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of library seating departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.LibrarySeatingDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the library seating departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of library seating departments.
	*
	* @return the number of library seating departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
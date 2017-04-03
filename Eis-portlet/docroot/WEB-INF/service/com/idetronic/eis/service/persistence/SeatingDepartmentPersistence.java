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

import com.idetronic.eis.model.SeatingDepartment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the seating department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingDepartmentPersistenceImpl
 * @see SeatingDepartmentUtil
 * @generated
 */
public interface SeatingDepartmentPersistence extends BasePersistence<SeatingDepartment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SeatingDepartmentUtil} to access the seating department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the seating department in the entity cache if it is enabled.
	*
	* @param seatingDepartment the seating department
	*/
	public void cacheResult(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment);

	/**
	* Caches the seating departments in the entity cache if it is enabled.
	*
	* @param seatingDepartments the seating departments
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.SeatingDepartment> seatingDepartments);

	/**
	* Creates a new seating department with the primary key. Does not add the seating department to the database.
	*
	* @param departmentId the primary key for the new seating department
	* @return the new seating department
	*/
	public com.idetronic.eis.model.SeatingDepartment create(long departmentId);

	/**
	* Removes the seating department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department that was removed
	* @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingDepartment remove(long departmentId)
		throws com.idetronic.eis.NoSuchSeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.SeatingDepartment updateImpl(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the seating department with the primary key or throws a {@link com.idetronic.eis.NoSuchSeatingDepartmentException} if it could not be found.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department
	* @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingDepartment findByPrimaryKey(
		long departmentId)
		throws com.idetronic.eis.NoSuchSeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the seating department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department, or <code>null</code> if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingDepartment fetchByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the seating departments.
	*
	* @return the seating departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.SeatingDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the seating departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating departments
	* @param end the upper bound of the range of seating departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of seating departments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the seating departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of seating departments.
	*
	* @return the number of seating departments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
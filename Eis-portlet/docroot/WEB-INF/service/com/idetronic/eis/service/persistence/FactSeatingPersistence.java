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

import com.idetronic.eis.model.FactSeating;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact seating service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactSeatingPersistenceImpl
 * @see FactSeatingUtil
 * @generated
 */
public interface FactSeatingPersistence extends BasePersistence<FactSeating> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactSeatingUtil} to access the fact seating persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact seatings where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @return the matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibraryDepartment(
		long libraryId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact seatings where libraryId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @return the range of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibraryDepartment(
		long libraryId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact seatings where libraryId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibraryDepartment(
		long libraryId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByLibraryDepartment_First(
		long libraryId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact seating, or <code>null</code> if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByLibraryDepartment_First(
		long libraryId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByLibraryDepartment_Last(
		long libraryId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact seating, or <code>null</code> if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByLibraryDepartment_Last(
		long libraryId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact seatings before and after the current fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	*
	* @param factSeatingId the primary key of the current fact seating
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating[] findByLibraryDepartment_PrevAndNext(
		long factSeatingId, long libraryId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact seatings where libraryId = &#63; and departmentId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryDepartment(long libraryId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact seatings where libraryId = &#63; and departmentId = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @return the number of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryDepartment(long libraryId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @return the matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibDeptCatPeriod(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @return the range of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibDeptCatPeriod(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibDeptCatPeriod(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByLibDeptCatPeriod_First(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact seating, or <code>null</code> if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByLibDeptCatPeriod_First(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByLibDeptCatPeriod_Last(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact seating, or <code>null</code> if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByLibDeptCatPeriod_Last(
		long libraryId, long departmentId, long seatingCategoryId,
		java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact seatings before and after the current fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param factSeatingId the primary key of the current fact seating
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating[] findByLibDeptCatPeriod_PrevAndNext(
		long factSeatingId, long libraryId, long departmentId,
		long seatingCategoryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibDeptCatPeriod(long libraryId, long departmentId,
		long seatingCategoryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param departmentId the department ID
	* @param seatingCategoryId the seating category ID
	* @param period the period
	* @return the number of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibDeptCatPeriod(long libraryId, long departmentId,
		long seatingCategoryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact seatings where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact seatings where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @return the range of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact seatings where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact seating in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact seating in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact seating, or <code>null</code> if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact seating in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact seating in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact seating, or <code>null</code> if a matching fact seating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact seatings before and after the current fact seating in the ordered set where libraryId = &#63;.
	*
	* @param factSeatingId the primary key of the current fact seating
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating[] findByLibrary_PrevAndNext(
		long factSeatingId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact seatings where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact seatings where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact seating in the entity cache if it is enabled.
	*
	* @param factSeating the fact seating
	*/
	public void cacheResult(com.idetronic.eis.model.FactSeating factSeating);

	/**
	* Caches the fact seatings in the entity cache if it is enabled.
	*
	* @param factSeatings the fact seatings
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactSeating> factSeatings);

	/**
	* Creates a new fact seating with the primary key. Does not add the fact seating to the database.
	*
	* @param factSeatingId the primary key for the new fact seating
	* @return the new fact seating
	*/
	public com.idetronic.eis.model.FactSeating create(long factSeatingId);

	/**
	* Removes the fact seating with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factSeatingId the primary key of the fact seating
	* @return the fact seating that was removed
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating remove(long factSeatingId)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactSeating updateImpl(
		com.idetronic.eis.model.FactSeating factSeating)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact seating with the primary key or throws a {@link com.idetronic.eis.NoSuchFactSeatingException} if it could not be found.
	*
	* @param factSeatingId the primary key of the fact seating
	* @return the fact seating
	* @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating findByPrimaryKey(
		long factSeatingId)
		throws com.idetronic.eis.NoSuchFactSeatingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact seating with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factSeatingId the primary key of the fact seating
	* @return the fact seating, or <code>null</code> if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactSeating fetchByPrimaryKey(
		long factSeatingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact seatings.
	*
	* @return the fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact seatings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @return the range of fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact seatings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactSeating> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact seatings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact seatings.
	*
	* @return the number of fact seatings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
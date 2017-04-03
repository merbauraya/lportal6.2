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

import com.idetronic.eis.model.SeatingCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the seating category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingCategoryPersistenceImpl
 * @see SeatingCategoryUtil
 * @generated
 */
public interface SeatingCategoryPersistence extends BasePersistence<SeatingCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SeatingCategoryUtil} to access the seating category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the seating categories where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @return the matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingCategory> findByDepartment(
		long seatingDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the seating categories where seatingDepartmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param seatingDepartmentId the seating department ID
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @return the range of matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingCategory> findByDepartment(
		long seatingDepartmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the seating categories where seatingDepartmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param seatingDepartmentId the seating department ID
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingCategory> findByDepartment(
		long seatingDepartmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory findByDepartment_First(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching seating category, or <code>null</code> if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory fetchByDepartment_First(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory findByDepartment_Last(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching seating category, or <code>null</code> if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory fetchByDepartment_Last(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the seating categories before and after the current seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingCategoryId the primary key of the current seating category
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory[] findByDepartment_PrevAndNext(
		long seatingCategoryId, long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the seating categories where seatingDepartmentId = &#63; from the database.
	*
	* @param seatingDepartmentId the seating department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartment(long seatingDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of seating categories where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @return the number of matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartment(long seatingDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the seating category in the entity cache if it is enabled.
	*
	* @param seatingCategory the seating category
	*/
	public void cacheResult(
		com.idetronic.eis.model.SeatingCategory seatingCategory);

	/**
	* Caches the seating categories in the entity cache if it is enabled.
	*
	* @param seatingCategories the seating categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.SeatingCategory> seatingCategories);

	/**
	* Creates a new seating category with the primary key. Does not add the seating category to the database.
	*
	* @param seatingCategoryId the primary key for the new seating category
	* @return the new seating category
	*/
	public com.idetronic.eis.model.SeatingCategory create(
		long seatingCategoryId);

	/**
	* Removes the seating category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category that was removed
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory remove(
		long seatingCategoryId)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.SeatingCategory updateImpl(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the seating category with the primary key or throws a {@link com.idetronic.eis.NoSuchSeatingCategoryException} if it could not be found.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory findByPrimaryKey(
		long seatingCategoryId)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the seating category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category, or <code>null</code> if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.SeatingCategory fetchByPrimaryKey(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the seating categories.
	*
	* @return the seating categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the seating categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @return the range of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the seating categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.SeatingCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the seating categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of seating categories.
	*
	* @return the number of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
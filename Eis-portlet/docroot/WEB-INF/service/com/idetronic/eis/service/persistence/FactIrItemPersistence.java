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

import com.idetronic.eis.model.FactIrItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact ir item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrItemPersistenceImpl
 * @see FactIrItemUtil
 * @generated
 */
public interface FactIrItemPersistence extends BasePersistence<FactIrItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactIrItemUtil} to access the fact ir item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @return the matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByPeriodItemTypeMedium(
		java.lang.String period, long itemTypeId, long itemMediumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @return the range of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByPeriodItemTypeMedium(
		java.lang.String period, long itemTypeId, long itemMediumId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByPeriodItemTypeMedium(
		java.lang.String period, long itemTypeId, long itemMediumId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByPeriodItemTypeMedium_First(
		java.lang.String period, long itemTypeId, long itemMediumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByPeriodItemTypeMedium_First(
		java.lang.String period, long itemTypeId, long itemMediumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByPeriodItemTypeMedium_Last(
		java.lang.String period, long itemTypeId, long itemMediumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByPeriodItemTypeMedium_Last(
		java.lang.String period, long itemTypeId, long itemMediumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir items before and after the current fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param factIrItemId the primary key of the current fact ir item
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem[] findByPeriodItemTypeMedium_PrevAndNext(
		long factIrItemId, java.lang.String period, long itemTypeId,
		long itemMediumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63; from the database.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPeriodItemTypeMedium(java.lang.String period,
		long itemTypeId, long itemMediumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	*
	* @param period the period
	* @param itemTypeId the item type ID
	* @param itemMediumId the item medium ID
	* @return the number of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public int countByPeriodItemTypeMedium(java.lang.String period,
		long itemTypeId, long itemMediumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @return the matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByLibraryFacultyPeriod(
		long libraryId, long facultyId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @return the range of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByLibraryFacultyPeriod(
		long libraryId, long facultyId, java.lang.String period, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByLibraryFacultyPeriod(
		long libraryId, long facultyId, java.lang.String period, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByLibraryFacultyPeriod_First(
		long libraryId, long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByLibraryFacultyPeriod_First(
		long libraryId, long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByLibraryFacultyPeriod_Last(
		long libraryId, long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByLibraryFacultyPeriod_Last(
		long libraryId, long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir items before and after the current fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param factIrItemId the primary key of the current fact ir item
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem[] findByLibraryFacultyPeriod_PrevAndNext(
		long factIrItemId, long libraryId, long facultyId,
		java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryFacultyPeriod(long libraryId, long facultyId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param facultyId the faculty ID
	* @param period the period
	* @return the number of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryFacultyPeriod(long libraryId, long facultyId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact ir items where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact ir items where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @return the range of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact ir items where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir items before and after the current fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param factIrItemId the primary key of the current fact ir item
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem[] findByLibraryPeriod_PrevAndNext(
		long factIrItemId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact ir items where libraryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact ir items where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact ir item in the entity cache if it is enabled.
	*
	* @param factIrItem the fact ir item
	*/
	public void cacheResult(com.idetronic.eis.model.FactIrItem factIrItem);

	/**
	* Caches the fact ir items in the entity cache if it is enabled.
	*
	* @param factIrItems the fact ir items
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactIrItem> factIrItems);

	/**
	* Creates a new fact ir item with the primary key. Does not add the fact ir item to the database.
	*
	* @param factIrItemId the primary key for the new fact ir item
	* @return the new fact ir item
	*/
	public com.idetronic.eis.model.FactIrItem create(long factIrItemId);

	/**
	* Removes the fact ir item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factIrItemId the primary key of the fact ir item
	* @return the fact ir item that was removed
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem remove(long factIrItemId)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactIrItem updateImpl(
		com.idetronic.eis.model.FactIrItem factIrItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir item with the primary key or throws a {@link com.idetronic.eis.NoSuchFactIrItemException} if it could not be found.
	*
	* @param factIrItemId the primary key of the fact ir item
	* @return the fact ir item
	* @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem findByPrimaryKey(
		long factIrItemId)
		throws com.idetronic.eis.NoSuchFactIrItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factIrItemId the primary key of the fact ir item
	* @return the fact ir item, or <code>null</code> if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrItem fetchByPrimaryKey(
		long factIrItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact ir items.
	*
	* @return the fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact ir items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @return the range of fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact ir items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact ir items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact ir items.
	*
	* @return the number of fact ir items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
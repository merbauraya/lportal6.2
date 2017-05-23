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

import com.idetronic.eis.model.FactExpense;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactExpensePersistenceImpl
 * @see FactExpenseUtil
 * @generated
 */
public interface FactExpensePersistence extends BasePersistence<FactExpense> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactExpenseUtil} to access the fact expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact expenses where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactExpense> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact expenses where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact expenses
	* @param end the upper bound of the range of fact expenses (not inclusive)
	* @return the range of matching fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactExpense> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact expenses where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact expenses
	* @param end the upper bound of the range of fact expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactExpense> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact expense in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact expense
	* @throws com.idetronic.eis.NoSuchFactExpenseException if a matching fact expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactExpenseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact expense in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact expense, or <code>null</code> if a matching fact expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact expense in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact expense
	* @throws com.idetronic.eis.NoSuchFactExpenseException if a matching fact expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactExpenseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact expense in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact expense, or <code>null</code> if a matching fact expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact expenses before and after the current fact expense in the ordered set where libraryId = &#63;.
	*
	* @param factExpenseId the primary key of the current fact expense
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact expense
	* @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense[] findByLibrary_PrevAndNext(
		long factExpenseId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactExpenseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact expenses where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact expenses where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact expense in the entity cache if it is enabled.
	*
	* @param factExpense the fact expense
	*/
	public void cacheResult(com.idetronic.eis.model.FactExpense factExpense);

	/**
	* Caches the fact expenses in the entity cache if it is enabled.
	*
	* @param factExpenses the fact expenses
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactExpense> factExpenses);

	/**
	* Creates a new fact expense with the primary key. Does not add the fact expense to the database.
	*
	* @param factExpenseId the primary key for the new fact expense
	* @return the new fact expense
	*/
	public com.idetronic.eis.model.FactExpense create(long factExpenseId);

	/**
	* Removes the fact expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factExpenseId the primary key of the fact expense
	* @return the fact expense that was removed
	* @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense remove(long factExpenseId)
		throws com.idetronic.eis.NoSuchFactExpenseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactExpense updateImpl(
		com.idetronic.eis.model.FactExpense factExpense)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact expense with the primary key or throws a {@link com.idetronic.eis.NoSuchFactExpenseException} if it could not be found.
	*
	* @param factExpenseId the primary key of the fact expense
	* @return the fact expense
	* @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense findByPrimaryKey(
		long factExpenseId)
		throws com.idetronic.eis.NoSuchFactExpenseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact expense with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factExpenseId the primary key of the fact expense
	* @return the fact expense, or <code>null</code> if a fact expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactExpense fetchByPrimaryKey(
		long factExpenseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact expenses.
	*
	* @return the fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactExpense> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact expenses
	* @param end the upper bound of the range of fact expenses (not inclusive)
	* @return the range of fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactExpense> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact expenses
	* @param end the upper bound of the range of fact expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactExpense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact expenses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact expenses.
	*
	* @return the number of fact expenses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
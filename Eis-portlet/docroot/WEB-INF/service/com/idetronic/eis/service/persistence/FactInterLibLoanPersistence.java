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

import com.idetronic.eis.model.FactInterLibLoan;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact inter lib loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactInterLibLoanPersistenceImpl
 * @see FactInterLibLoanUtil
 * @generated
 */
public interface FactInterLibLoanPersistence extends BasePersistence<FactInterLibLoan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactInterLibLoanUtil} to access the fact inter lib loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fact inter lib loan in the entity cache if it is enabled.
	*
	* @param factInterLibLoan the fact inter lib loan
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan);

	/**
	* Caches the fact inter lib loans in the entity cache if it is enabled.
	*
	* @param factInterLibLoans the fact inter lib loans
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactInterLibLoan> factInterLibLoans);

	/**
	* Creates a new fact inter lib loan with the primary key. Does not add the fact inter lib loan to the database.
	*
	* @param factId the primary key for the new fact inter lib loan
	* @return the new fact inter lib loan
	*/
	public com.idetronic.eis.model.FactInterLibLoan create(long factId);

	/**
	* Removes the fact inter lib loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact inter lib loan
	* @return the fact inter lib loan that was removed
	* @throws com.idetronic.eis.NoSuchFactInterLibLoanException if a fact inter lib loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactInterLibLoan remove(long factId)
		throws com.idetronic.eis.NoSuchFactInterLibLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactInterLibLoan updateImpl(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact inter lib loan with the primary key or throws a {@link com.idetronic.eis.NoSuchFactInterLibLoanException} if it could not be found.
	*
	* @param factId the primary key of the fact inter lib loan
	* @return the fact inter lib loan
	* @throws com.idetronic.eis.NoSuchFactInterLibLoanException if a fact inter lib loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactInterLibLoan findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactInterLibLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact inter lib loan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact inter lib loan
	* @return the fact inter lib loan, or <code>null</code> if a fact inter lib loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactInterLibLoan fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact inter lib loans.
	*
	* @return the fact inter lib loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactInterLibLoan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact inter lib loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact inter lib loans
	* @param end the upper bound of the range of fact inter lib loans (not inclusive)
	* @return the range of fact inter lib loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactInterLibLoan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact inter lib loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact inter lib loans
	* @param end the upper bound of the range of fact inter lib loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact inter lib loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactInterLibLoan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact inter lib loans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact inter lib loans.
	*
	* @return the number of fact inter lib loans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.idetronic.eis.model.Loan;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LoanPersistenceImpl
 * @see LoanUtil
 * @generated
 */
public interface LoanPersistence extends BasePersistence<Loan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the loans where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan findByLibrary_First(long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan fetchByLibrary_First(long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan findByLibrary_Last(long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan fetchByLibrary_Last(long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where libraryId = &#63;.
	*
	* @param loanEntryId the primary key of the current loan
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan[] findByLibrary_PrevAndNext(
		long loanEntryId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param loanEntryId the primary key of the current loan
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan[] findByLibraryPeriod_PrevAndNext(
		long loanEntryId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where libraryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the loan in the entity cache if it is enabled.
	*
	* @param loan the loan
	*/
	public void cacheResult(com.idetronic.eis.model.Loan loan);

	/**
	* Caches the loans in the entity cache if it is enabled.
	*
	* @param loans the loans
	*/
	public void cacheResult(java.util.List<com.idetronic.eis.model.Loan> loans);

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanEntryId the primary key for the new loan
	* @return the new loan
	*/
	public com.idetronic.eis.model.Loan create(long loanEntryId);

	/**
	* Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanEntryId the primary key of the loan
	* @return the loan that was removed
	* @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan remove(long loanEntryId)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.Loan updateImpl(
		com.idetronic.eis.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan with the primary key or throws a {@link com.idetronic.eis.NoSuchLoanException} if it could not be found.
	*
	* @param loanEntryId the primary key of the loan
	* @return the loan
	* @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan findByPrimaryKey(long loanEntryId)
		throws com.idetronic.eis.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanEntryId the primary key of the loan
	* @return the loan, or <code>null</code> if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Loan fetchByPrimaryKey(long loanEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans.
	*
	* @return the loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Loan> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
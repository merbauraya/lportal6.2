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

import com.idetronic.eis.model.UserReport;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserReportPersistenceImpl
 * @see UserReportUtil
 * @generated
 */
public interface UserReportPersistence extends BasePersistence<UserReport> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserReportUtil} to access the user report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByUserDataLibrary(
		long userId, long libraryId, long reportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUserDataLibrary(
		long userId, long libraryId, long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUserDataLibrary(
		long userId, long libraryId, long reportId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the user report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport removeByUserDataLibrary(
		long userId, long libraryId, long reportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user reports where userId = &#63; and libraryId = &#63; and reportId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserDataLibrary(long userId, long libraryId, long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user reports where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user reports where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @return the range of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user reports where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user reports before and after the current user report in the ordered set where userId = &#63;.
	*
	* @param userReportId the primary key of the current user report
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport[] findByUser_PrevAndNext(
		long userReportId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user reports where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user reports where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user reports where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user reports where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @return the range of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByReport(
		long reportId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user reports where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByReport(
		long reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByReport_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByReport_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByReport_Last(long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByReport_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user reports before and after the current user report in the ordered set where reportId = &#63;.
	*
	* @param userReportId the primary key of the current user report
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport[] findByReport_PrevAndNext(
		long userReportId, long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user reports where reportId = &#63; from the database.
	*
	* @param reportId the report ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user reports where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user reports where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByUserAndLibrary(
		long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user reports where userId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @return the range of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByUserAndLibrary(
		long userId, long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user reports where userId = &#63; and libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findByUserAndLibrary(
		long userId, long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByUserAndLibrary_First(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUserAndLibrary_First(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByUserAndLibrary_Last(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUserAndLibrary_Last(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user reports before and after the current user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userReportId the primary key of the current user report
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport[] findByUserAndLibrary_PrevAndNext(
		long userReportId, long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user reports where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserAndLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user reports where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserAndLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByUserLibrary(long userId,
		long libraryId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUserLibrary(long userId,
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByUserLibrary(long userId,
		long libraryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user report where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the user report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport removeByUserLibrary(long userId,
		long libraryId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user reports where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user report in the entity cache if it is enabled.
	*
	* @param userReport the user report
	*/
	public void cacheResult(com.idetronic.eis.model.UserReport userReport);

	/**
	* Caches the user reports in the entity cache if it is enabled.
	*
	* @param userReports the user reports
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.UserReport> userReports);

	/**
	* Creates a new user report with the primary key. Does not add the user report to the database.
	*
	* @param userReportId the primary key for the new user report
	* @return the new user report
	*/
	public com.idetronic.eis.model.UserReport create(long userReportId);

	/**
	* Removes the user report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userReportId the primary key of the user report
	* @return the user report that was removed
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport remove(long userReportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.UserReport updateImpl(
		com.idetronic.eis.model.UserReport userReport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report with the primary key or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	*
	* @param userReportId the primary key of the user report
	* @return the user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport findByPrimaryKey(
		long userReportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userReportId the primary key of the user report
	* @return the user report, or <code>null</code> if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserReport fetchByPrimaryKey(
		long userReportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user reports.
	*
	* @return the user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @return the range of user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user reports.
	*
	* @return the number of user reports
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user report service. This utility wraps {@link UserReportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserReportPersistence
 * @see UserReportPersistenceImpl
 * @generated
 */
public class UserReportUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserReport userReport) {
		getPersistence().clearCache(userReport);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserReport update(UserReport userReport)
		throws SystemException {
		return getPersistence().update(userReport);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserReport update(UserReport userReport,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userReport, serviceContext);
	}

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
	public static com.idetronic.eis.model.UserReport findByUserDataLibrary(
		long userId, long libraryId, long reportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserDataLibrary(userId, libraryId, reportId);
	}

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUserDataLibrary(
		long userId, long libraryId, long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserDataLibrary(userId, libraryId, reportId);
	}

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
	public static com.idetronic.eis.model.UserReport fetchByUserDataLibrary(
		long userId, long libraryId, long reportId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserDataLibrary(userId, libraryId, reportId,
			retrieveFromCache);
	}

	/**
	* Removes the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the user report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport removeByUserDataLibrary(
		long userId, long libraryId, long reportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByUserDataLibrary(userId, libraryId, reportId);
	}

	/**
	* Returns the number of user reports where userId = &#63; and libraryId = &#63; and reportId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param reportId the report ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserDataLibrary(long userId, long libraryId,
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserDataLibrary(userId, libraryId, reportId);
	}

	/**
	* Returns all the user reports where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserReport> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user report in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserReport[] findByUser_PrevAndNext(
		long userReportId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(userReportId, userId,
			orderByComparator);
	}

	/**
	* Removes all the user reports where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of user reports where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the user reports where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserReport> findByReport(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReport(reportId);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findByReport(
		long reportId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReport(reportId, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findByReport(
		long reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReport(reportId, start, end, orderByComparator);
	}

	/**
	* Returns the first user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport findByReport_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReport_First(reportId, orderByComparator);
	}

	/**
	* Returns the first user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByReport_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByReport_First(reportId, orderByComparator);
	}

	/**
	* Returns the last user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport findByReport_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReport_Last(reportId, orderByComparator);
	}

	/**
	* Returns the last user report in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByReport_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByReport_Last(reportId, orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserReport[] findByReport_PrevAndNext(
		long userReportId, long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReport_PrevAndNext(userReportId, reportId,
			orderByComparator);
	}

	/**
	* Removes all the user reports where reportId = &#63; from the database.
	*
	* @param reportId the report ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByReport(reportId);
	}

	/**
	* Returns the number of user reports where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReport(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByReport(reportId);
	}

	/**
	* Returns all the user reports where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserReport> findByUserAndLibrary(
		long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserAndLibrary(userId, libraryId);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findByUserAndLibrary(
		long userId, long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndLibrary(userId, libraryId, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findByUserAndLibrary(
		long userId, long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndLibrary(userId, libraryId, start, end,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserReport findByUserAndLibrary_First(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndLibrary_First(userId, libraryId,
			orderByComparator);
	}

	/**
	* Returns the first user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUserAndLibrary_First(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndLibrary_First(userId, libraryId,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserReport findByUserAndLibrary_Last(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndLibrary_Last(userId, libraryId,
			orderByComparator);
	}

	/**
	* Returns the last user report in the ordered set where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUserAndLibrary_Last(
		long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndLibrary_Last(userId, libraryId,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserReport[] findByUserAndLibrary_PrevAndNext(
		long userReportId, long userId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndLibrary_PrevAndNext(userReportId, userId,
			libraryId, orderByComparator);
	}

	/**
	* Removes all the user reports where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserAndLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserAndLibrary(userId, libraryId);
	}

	/**
	* Returns the number of user reports where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserAndLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserAndLibrary(userId, libraryId);
	}

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport findByUserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserLibrary(userId, libraryId);
	}

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUserLibrary(
		long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserLibrary(userId, libraryId);
	}

	/**
	* Returns the user report where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user report, or <code>null</code> if a matching user report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByUserLibrary(
		long userId, long libraryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserLibrary(userId, libraryId, retrieveFromCache);
	}

	/**
	* Removes the user report where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the user report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport removeByUserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUserLibrary(userId, libraryId);
	}

	/**
	* Returns the number of user reports where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserLibrary(userId, libraryId);
	}

	/**
	* Caches the user report in the entity cache if it is enabled.
	*
	* @param userReport the user report
	*/
	public static void cacheResult(
		com.idetronic.eis.model.UserReport userReport) {
		getPersistence().cacheResult(userReport);
	}

	/**
	* Caches the user reports in the entity cache if it is enabled.
	*
	* @param userReports the user reports
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.UserReport> userReports) {
		getPersistence().cacheResult(userReports);
	}

	/**
	* Creates a new user report with the primary key. Does not add the user report to the database.
	*
	* @param userReportId the primary key for the new user report
	* @return the new user report
	*/
	public static com.idetronic.eis.model.UserReport create(long userReportId) {
		return getPersistence().create(userReportId);
	}

	/**
	* Removes the user report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userReportId the primary key of the user report
	* @return the user report that was removed
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport remove(long userReportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userReportId);
	}

	public static com.idetronic.eis.model.UserReport updateImpl(
		com.idetronic.eis.model.UserReport userReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userReport);
	}

	/**
	* Returns the user report with the primary key or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	*
	* @param userReportId the primary key of the user report
	* @return the user report
	* @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport findByPrimaryKey(
		long userReportId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userReportId);
	}

	/**
	* Returns the user report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userReportId the primary key of the user report
	* @return the user report, or <code>null</code> if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport fetchByPrimaryKey(
		long userReportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userReportId);
	}

	/**
	* Returns all the user reports.
	*
	* @return the user reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user reports.
	*
	* @return the number of user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserReportPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserReportPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					UserReportPersistence.class.getName());

			ReferenceRegistry.registerReference(UserReportUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserReportPersistence persistence) {
	}

	private static UserReportPersistence _persistence;
}
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

import com.idetronic.eis.model.FactPost;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact post service. This utility wraps {@link FactPostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPostPersistence
 * @see FactPostPersistenceImpl
 * @generated
 */
public class FactPostUtil {
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
	public static void clearCache(FactPost factPost) {
		getPersistence().clearCache(factPost);
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
	public static List<FactPost> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactPost update(FactPost factPost) throws SystemException {
		return getPersistence().update(factPost);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactPost update(FactPost factPost,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(factPost, serviceContext);
	}

	/**
	* Returns all the fact posts where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns a range of all the fact posts where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod(libraryId, period, start, end);
	}

	/**
	* Returns an ordered range of all the fact posts where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod(libraryId, period, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_First(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibraryPeriod_First(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_Last(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibraryPeriod_Last(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the fact posts before and after the current fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param factPostId the primary key of the current fact post
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost[] findByLibraryPeriod_PrevAndNext(
		long factPostId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_PrevAndNext(factPostId, libraryId,
			period, orderByComparator);
	}

	/**
	* Removes all the fact posts where libraryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibraryPeriod(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns the number of fact posts where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibraryPeriod(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns all the fact posts where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @return the matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByPostGrade(
		long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPostGrade(postGradeId);
	}

	/**
	* Returns a range of all the fact posts where postGradeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param postGradeId the post grade ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByPostGrade(
		long postGradeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPostGrade(postGradeId, start, end);
	}

	/**
	* Returns an ordered range of all the fact posts where postGradeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param postGradeId the post grade ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByPostGrade(
		long postGradeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostGrade(postGradeId, start, end, orderByComparator);
	}

	/**
	* Returns the first fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByPostGrade_First(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostGrade_First(postGradeId, orderByComparator);
	}

	/**
	* Returns the first fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByPostGrade_First(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPostGrade_First(postGradeId, orderByComparator);
	}

	/**
	* Returns the last fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByPostGrade_Last(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostGrade_Last(postGradeId, orderByComparator);
	}

	/**
	* Returns the last fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByPostGrade_Last(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPostGrade_Last(postGradeId, orderByComparator);
	}

	/**
	* Returns the fact posts before and after the current fact post in the ordered set where postGradeId = &#63;.
	*
	* @param factPostId the primary key of the current fact post
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost[] findByPostGrade_PrevAndNext(
		long factPostId, long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostGrade_PrevAndNext(factPostId, postGradeId,
			orderByComparator);
	}

	/**
	* Removes all the fact posts where postGradeId = &#63; from the database.
	*
	* @param postGradeId the post grade ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPostGrade(postGradeId);
	}

	/**
	* Returns the number of fact posts where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @return the number of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPostGrade(postGradeId);
	}

	/**
	* Returns all the fact posts where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary(libraryId);
	}

	/**
	* Returns a range of all the fact posts where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary(libraryId, start, end);
	}

	/**
	* Returns an ordered range of all the fact posts where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibrary(libraryId, start, end, orderByComparator);
	}

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the fact posts before and after the current fact post in the ordered set where libraryId = &#63;.
	*
	* @param factPostId the primary key of the current fact post
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost[] findByLibrary_PrevAndNext(
		long factPostId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibrary_PrevAndNext(factPostId, libraryId,
			orderByComparator);
	}

	/**
	* Removes all the fact posts where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibrary(libraryId);
	}

	/**
	* Returns the number of fact posts where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibrary(libraryId);
	}

	/**
	* Caches the fact post in the entity cache if it is enabled.
	*
	* @param factPost the fact post
	*/
	public static void cacheResult(com.idetronic.eis.model.FactPost factPost) {
		getPersistence().cacheResult(factPost);
	}

	/**
	* Caches the fact posts in the entity cache if it is enabled.
	*
	* @param factPosts the fact posts
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactPost> factPosts) {
		getPersistence().cacheResult(factPosts);
	}

	/**
	* Creates a new fact post with the primary key. Does not add the fact post to the database.
	*
	* @param factPostId the primary key for the new fact post
	* @return the new fact post
	*/
	public static com.idetronic.eis.model.FactPost create(long factPostId) {
		return getPersistence().create(factPostId);
	}

	/**
	* Removes the fact post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factPostId the primary key of the fact post
	* @return the fact post that was removed
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost remove(long factPostId)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(factPostId);
	}

	public static com.idetronic.eis.model.FactPost updateImpl(
		com.idetronic.eis.model.FactPost factPost)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factPost);
	}

	/**
	* Returns the fact post with the primary key or throws a {@link com.idetronic.eis.NoSuchFactPostException} if it could not be found.
	*
	* @param factPostId the primary key of the fact post
	* @return the fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost findByPrimaryKey(
		long factPostId)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(factPostId);
	}

	/**
	* Returns the fact post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factPostId the primary key of the fact post
	* @return the fact post, or <code>null</code> if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPost fetchByPrimaryKey(
		long factPostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(factPostId);
	}

	/**
	* Returns all the fact posts.
	*
	* @return the fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact posts.
	*
	* @return the number of fact posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactPostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactPostPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactPostPersistence.class.getName());

			ReferenceRegistry.registerReference(FactPostUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactPostPersistence persistence) {
	}

	private static FactPostPersistence _persistence;
}
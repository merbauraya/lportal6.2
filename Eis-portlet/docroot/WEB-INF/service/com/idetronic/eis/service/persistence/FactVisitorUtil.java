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

import com.idetronic.eis.model.FactVisitor;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact visitor service. This utility wraps {@link FactVisitorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactVisitorPersistence
 * @see FactVisitorPersistenceImpl
 * @generated
 */
public class FactVisitorUtil {
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
	public static void clearCache(FactVisitor factVisitor) {
		getPersistence().clearCache(factVisitor);
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
	public static List<FactVisitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactVisitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactVisitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactVisitor update(FactVisitor factVisitor)
		throws SystemException {
		return getPersistence().update(factVisitor);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactVisitor update(FactVisitor factVisitor,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(factVisitor, serviceContext);
	}

	/**
	* Returns all the fact visitors where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns a range of all the fact visitors where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @return the range of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod(libraryId, period, start, end);
	}

	/**
	* Returns an ordered range of all the fact visitors where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod(libraryId, period, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_First(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the first fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibraryPeriod_First(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_Last(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibraryPeriod_Last(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the fact visitors before and after the current fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param factVisitorId the primary key of the current fact visitor
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor[] findByLibraryPeriod_PrevAndNext(
		long factVisitorId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_PrevAndNext(factVisitorId, libraryId,
			period, orderByComparator);
	}

	/**
	* Removes all the fact visitors where libraryId = &#63; and period = &#63; from the database.
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
	* Returns the number of fact visitors where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibraryPeriod(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns all the fact visitors where visitorCategoryId = &#63;.
	*
	* @param visitorCategoryId the visitor category ID
	* @return the matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByVisitorCategory(
		long visitorCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVisitorCategory(visitorCategoryId);
	}

	/**
	* Returns a range of all the fact visitors where visitorCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param visitorCategoryId the visitor category ID
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @return the range of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByVisitorCategory(
		long visitorCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVisitorCategory(visitorCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the fact visitors where visitorCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param visitorCategoryId the visitor category ID
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByVisitorCategory(
		long visitorCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVisitorCategory(visitorCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fact visitor in the ordered set where visitorCategoryId = &#63;.
	*
	* @param visitorCategoryId the visitor category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByVisitorCategory_First(
		long visitorCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVisitorCategory_First(visitorCategoryId,
			orderByComparator);
	}

	/**
	* Returns the first fact visitor in the ordered set where visitorCategoryId = &#63;.
	*
	* @param visitorCategoryId the visitor category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByVisitorCategory_First(
		long visitorCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVisitorCategory_First(visitorCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last fact visitor in the ordered set where visitorCategoryId = &#63;.
	*
	* @param visitorCategoryId the visitor category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByVisitorCategory_Last(
		long visitorCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVisitorCategory_Last(visitorCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last fact visitor in the ordered set where visitorCategoryId = &#63;.
	*
	* @param visitorCategoryId the visitor category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByVisitorCategory_Last(
		long visitorCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVisitorCategory_Last(visitorCategoryId,
			orderByComparator);
	}

	/**
	* Returns the fact visitors before and after the current fact visitor in the ordered set where visitorCategoryId = &#63;.
	*
	* @param factVisitorId the primary key of the current fact visitor
	* @param visitorCategoryId the visitor category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor[] findByVisitorCategory_PrevAndNext(
		long factVisitorId, long visitorCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVisitorCategory_PrevAndNext(factVisitorId,
			visitorCategoryId, orderByComparator);
	}

	/**
	* Removes all the fact visitors where visitorCategoryId = &#63; from the database.
	*
	* @param visitorCategoryId the visitor category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVisitorCategory(long visitorCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVisitorCategory(visitorCategoryId);
	}

	/**
	* Returns the number of fact visitors where visitorCategoryId = &#63;.
	*
	* @param visitorCategoryId the visitor category ID
	* @return the number of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVisitorCategory(long visitorCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVisitorCategory(visitorCategoryId);
	}

	/**
	* Returns all the fact visitors where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary(libraryId);
	}

	/**
	* Returns a range of all the fact visitors where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @return the range of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary(libraryId, start, end);
	}

	/**
	* Returns an ordered range of all the fact visitors where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibrary(libraryId, start, end, orderByComparator);
	}

	/**
	* Returns the first fact visitor in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the first fact visitor in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the last fact visitor in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the last fact visitor in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the fact visitors before and after the current fact visitor in the ordered set where libraryId = &#63;.
	*
	* @param factVisitorId the primary key of the current fact visitor
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor[] findByLibrary_PrevAndNext(
		long factVisitorId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibrary_PrevAndNext(factVisitorId, libraryId,
			orderByComparator);
	}

	/**
	* Removes all the fact visitors where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibrary(libraryId);
	}

	/**
	* Returns the number of fact visitors where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibrary(libraryId);
	}

	/**
	* Caches the fact visitor in the entity cache if it is enabled.
	*
	* @param factVisitor the fact visitor
	*/
	public static void cacheResult(
		com.idetronic.eis.model.FactVisitor factVisitor) {
		getPersistence().cacheResult(factVisitor);
	}

	/**
	* Caches the fact visitors in the entity cache if it is enabled.
	*
	* @param factVisitors the fact visitors
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactVisitor> factVisitors) {
		getPersistence().cacheResult(factVisitors);
	}

	/**
	* Creates a new fact visitor with the primary key. Does not add the fact visitor to the database.
	*
	* @param factVisitorId the primary key for the new fact visitor
	* @return the new fact visitor
	*/
	public static com.idetronic.eis.model.FactVisitor create(long factVisitorId) {
		return getPersistence().create(factVisitorId);
	}

	/**
	* Removes the fact visitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factVisitorId the primary key of the fact visitor
	* @return the fact visitor that was removed
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor remove(long factVisitorId)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(factVisitorId);
	}

	public static com.idetronic.eis.model.FactVisitor updateImpl(
		com.idetronic.eis.model.FactVisitor factVisitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factVisitor);
	}

	/**
	* Returns the fact visitor with the primary key or throws a {@link com.idetronic.eis.NoSuchFactVisitorException} if it could not be found.
	*
	* @param factVisitorId the primary key of the fact visitor
	* @return the fact visitor
	* @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor findByPrimaryKey(
		long factVisitorId)
		throws com.idetronic.eis.NoSuchFactVisitorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(factVisitorId);
	}

	/**
	* Returns the fact visitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factVisitorId the primary key of the fact visitor
	* @return the fact visitor, or <code>null</code> if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactVisitor fetchByPrimaryKey(
		long factVisitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(factVisitorId);
	}

	/**
	* Returns all the fact visitors.
	*
	* @return the fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact visitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @return the range of fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact visitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactVisitor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact visitors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact visitors.
	*
	* @return the number of fact visitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactVisitorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactVisitorPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactVisitorPersistence.class.getName());

			ReferenceRegistry.registerReference(FactVisitorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactVisitorPersistence persistence) {
	}

	private static FactVisitorPersistence _persistence;
}
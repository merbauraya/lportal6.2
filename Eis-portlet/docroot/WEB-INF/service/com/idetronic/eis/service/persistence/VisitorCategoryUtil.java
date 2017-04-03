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

import com.idetronic.eis.model.VisitorCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the visitor category service. This utility wraps {@link VisitorCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see VisitorCategoryPersistence
 * @see VisitorCategoryPersistenceImpl
 * @generated
 */
public class VisitorCategoryUtil {
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
	public static void clearCache(VisitorCategory visitorCategory) {
		getPersistence().clearCache(visitorCategory);
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
	public static List<VisitorCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisitorCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisitorCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VisitorCategory update(VisitorCategory visitorCategory)
		throws SystemException {
		return getPersistence().update(visitorCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VisitorCategory update(VisitorCategory visitorCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(visitorCategory, serviceContext);
	}

	/**
	* Returns the visitor category where visitorCategoryCode = &#63; or throws a {@link com.idetronic.eis.NoSuchVisitorCategoryException} if it could not be found.
	*
	* @param visitorCategoryCode the visitor category code
	* @return the matching visitor category
	* @throws com.idetronic.eis.NoSuchVisitorCategoryException if a matching visitor category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory findByCategory(
		java.lang.String visitorCategoryCode)
		throws com.idetronic.eis.NoSuchVisitorCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(visitorCategoryCode);
	}

	/**
	* Returns the visitor category where visitorCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param visitorCategoryCode the visitor category code
	* @return the matching visitor category, or <code>null</code> if a matching visitor category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory fetchByCategory(
		java.lang.String visitorCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCategory(visitorCategoryCode);
	}

	/**
	* Returns the visitor category where visitorCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param visitorCategoryCode the visitor category code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching visitor category, or <code>null</code> if a matching visitor category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory fetchByCategory(
		java.lang.String visitorCategoryCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory(visitorCategoryCode, retrieveFromCache);
	}

	/**
	* Removes the visitor category where visitorCategoryCode = &#63; from the database.
	*
	* @param visitorCategoryCode the visitor category code
	* @return the visitor category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory removeByCategory(
		java.lang.String visitorCategoryCode)
		throws com.idetronic.eis.NoSuchVisitorCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCategory(visitorCategoryCode);
	}

	/**
	* Returns the number of visitor categories where visitorCategoryCode = &#63;.
	*
	* @param visitorCategoryCode the visitor category code
	* @return the number of matching visitor categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(java.lang.String visitorCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(visitorCategoryCode);
	}

	/**
	* Caches the visitor category in the entity cache if it is enabled.
	*
	* @param visitorCategory the visitor category
	*/
	public static void cacheResult(
		com.idetronic.eis.model.VisitorCategory visitorCategory) {
		getPersistence().cacheResult(visitorCategory);
	}

	/**
	* Caches the visitor categories in the entity cache if it is enabled.
	*
	* @param visitorCategories the visitor categories
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.VisitorCategory> visitorCategories) {
		getPersistence().cacheResult(visitorCategories);
	}

	/**
	* Creates a new visitor category with the primary key. Does not add the visitor category to the database.
	*
	* @param visitorCategoryId the primary key for the new visitor category
	* @return the new visitor category
	*/
	public static com.idetronic.eis.model.VisitorCategory create(
		long visitorCategoryId) {
		return getPersistence().create(visitorCategoryId);
	}

	/**
	* Removes the visitor category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param visitorCategoryId the primary key of the visitor category
	* @return the visitor category that was removed
	* @throws com.idetronic.eis.NoSuchVisitorCategoryException if a visitor category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory remove(
		long visitorCategoryId)
		throws com.idetronic.eis.NoSuchVisitorCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(visitorCategoryId);
	}

	public static com.idetronic.eis.model.VisitorCategory updateImpl(
		com.idetronic.eis.model.VisitorCategory visitorCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(visitorCategory);
	}

	/**
	* Returns the visitor category with the primary key or throws a {@link com.idetronic.eis.NoSuchVisitorCategoryException} if it could not be found.
	*
	* @param visitorCategoryId the primary key of the visitor category
	* @return the visitor category
	* @throws com.idetronic.eis.NoSuchVisitorCategoryException if a visitor category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory findByPrimaryKey(
		long visitorCategoryId)
		throws com.idetronic.eis.NoSuchVisitorCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(visitorCategoryId);
	}

	/**
	* Returns the visitor category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param visitorCategoryId the primary key of the visitor category
	* @return the visitor category, or <code>null</code> if a visitor category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.VisitorCategory fetchByPrimaryKey(
		long visitorCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(visitorCategoryId);
	}

	/**
	* Returns all the visitor categories.
	*
	* @return the visitor categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.VisitorCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the visitor categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.VisitorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visitor categories
	* @param end the upper bound of the range of visitor categories (not inclusive)
	* @return the range of visitor categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.VisitorCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the visitor categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.VisitorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of visitor categories
	* @param end the upper bound of the range of visitor categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of visitor categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.VisitorCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the visitor categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of visitor categories.
	*
	* @return the number of visitor categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VisitorCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VisitorCategoryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					VisitorCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(VisitorCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VisitorCategoryPersistence persistence) {
	}

	private static VisitorCategoryPersistence _persistence;
}
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

import com.idetronic.eis.model.BorrowerCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the borrower category service. This utility wraps {@link BorrowerCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see BorrowerCategoryPersistence
 * @see BorrowerCategoryPersistenceImpl
 * @generated
 */
public class BorrowerCategoryUtil {
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
	public static void clearCache(BorrowerCategory borrowerCategory) {
		getPersistence().clearCache(borrowerCategory);
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
	public static List<BorrowerCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BorrowerCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BorrowerCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BorrowerCategory update(BorrowerCategory borrowerCategory)
		throws SystemException {
		return getPersistence().update(borrowerCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BorrowerCategory update(BorrowerCategory borrowerCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(borrowerCategory, serviceContext);
	}

	/**
	* Caches the borrower category in the entity cache if it is enabled.
	*
	* @param borrowerCategory the borrower category
	*/
	public static void cacheResult(
		com.idetronic.eis.model.BorrowerCategory borrowerCategory) {
		getPersistence().cacheResult(borrowerCategory);
	}

	/**
	* Caches the borrower categories in the entity cache if it is enabled.
	*
	* @param borrowerCategories the borrower categories
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.BorrowerCategory> borrowerCategories) {
		getPersistence().cacheResult(borrowerCategories);
	}

	/**
	* Creates a new borrower category with the primary key. Does not add the borrower category to the database.
	*
	* @param borrowerCategoryId the primary key for the new borrower category
	* @return the new borrower category
	*/
	public static com.idetronic.eis.model.BorrowerCategory create(
		long borrowerCategoryId) {
		return getPersistence().create(borrowerCategoryId);
	}

	/**
	* Removes the borrower category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param borrowerCategoryId the primary key of the borrower category
	* @return the borrower category that was removed
	* @throws com.idetronic.eis.NoSuchBorrowerCategoryException if a borrower category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.BorrowerCategory remove(
		long borrowerCategoryId)
		throws com.idetronic.eis.NoSuchBorrowerCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(borrowerCategoryId);
	}

	public static com.idetronic.eis.model.BorrowerCategory updateImpl(
		com.idetronic.eis.model.BorrowerCategory borrowerCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(borrowerCategory);
	}

	/**
	* Returns the borrower category with the primary key or throws a {@link com.idetronic.eis.NoSuchBorrowerCategoryException} if it could not be found.
	*
	* @param borrowerCategoryId the primary key of the borrower category
	* @return the borrower category
	* @throws com.idetronic.eis.NoSuchBorrowerCategoryException if a borrower category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.BorrowerCategory findByPrimaryKey(
		long borrowerCategoryId)
		throws com.idetronic.eis.NoSuchBorrowerCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(borrowerCategoryId);
	}

	/**
	* Returns the borrower category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param borrowerCategoryId the primary key of the borrower category
	* @return the borrower category, or <code>null</code> if a borrower category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.BorrowerCategory fetchByPrimaryKey(
		long borrowerCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(borrowerCategoryId);
	}

	/**
	* Returns all the borrower categories.
	*
	* @return the borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.BorrowerCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the borrower categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.BorrowerCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of borrower categories
	* @param end the upper bound of the range of borrower categories (not inclusive)
	* @return the range of borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.BorrowerCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the borrower categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.BorrowerCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of borrower categories
	* @param end the upper bound of the range of borrower categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.BorrowerCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the borrower categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of borrower categories.
	*
	* @return the number of borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BorrowerCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BorrowerCategoryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					BorrowerCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(BorrowerCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BorrowerCategoryPersistence persistence) {
	}

	private static BorrowerCategoryPersistence _persistence;
}
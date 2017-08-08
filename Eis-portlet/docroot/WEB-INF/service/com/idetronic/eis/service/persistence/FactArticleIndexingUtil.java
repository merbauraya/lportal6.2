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

import com.idetronic.eis.model.FactArticleIndexing;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact article indexing service. This utility wraps {@link FactArticleIndexingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactArticleIndexingPersistence
 * @see FactArticleIndexingPersistenceImpl
 * @generated
 */
public class FactArticleIndexingUtil {
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
	public static void clearCache(FactArticleIndexing factArticleIndexing) {
		getPersistence().clearCache(factArticleIndexing);
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
	public static List<FactArticleIndexing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactArticleIndexing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactArticleIndexing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactArticleIndexing update(
		FactArticleIndexing factArticleIndexing) throws SystemException {
		return getPersistence().update(factArticleIndexing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactArticleIndexing update(
		FactArticleIndexing factArticleIndexing, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(factArticleIndexing, serviceContext);
	}

	/**
	* Caches the fact article indexing in the entity cache if it is enabled.
	*
	* @param factArticleIndexing the fact article indexing
	*/
	public static void cacheResult(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing) {
		getPersistence().cacheResult(factArticleIndexing);
	}

	/**
	* Caches the fact article indexings in the entity cache if it is enabled.
	*
	* @param factArticleIndexings the fact article indexings
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactArticleIndexing> factArticleIndexings) {
		getPersistence().cacheResult(factArticleIndexings);
	}

	/**
	* Creates a new fact article indexing with the primary key. Does not add the fact article indexing to the database.
	*
	* @param factId the primary key for the new fact article indexing
	* @return the new fact article indexing
	*/
	public static com.idetronic.eis.model.FactArticleIndexing create(
		long factId) {
		return getPersistence().create(factId);
	}

	/**
	* Removes the fact article indexing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact article indexing
	* @return the fact article indexing that was removed
	* @throws com.idetronic.eis.NoSuchFactArticleIndexingException if a fact article indexing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactArticleIndexing remove(
		long factId)
		throws com.idetronic.eis.NoSuchFactArticleIndexingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(factId);
	}

	public static com.idetronic.eis.model.FactArticleIndexing updateImpl(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factArticleIndexing);
	}

	/**
	* Returns the fact article indexing with the primary key or throws a {@link com.idetronic.eis.NoSuchFactArticleIndexingException} if it could not be found.
	*
	* @param factId the primary key of the fact article indexing
	* @return the fact article indexing
	* @throws com.idetronic.eis.NoSuchFactArticleIndexingException if a fact article indexing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactArticleIndexing findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactArticleIndexingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(factId);
	}

	/**
	* Returns the fact article indexing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact article indexing
	* @return the fact article indexing, or <code>null</code> if a fact article indexing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactArticleIndexing fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(factId);
	}

	/**
	* Returns all the fact article indexings.
	*
	* @return the fact article indexings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactArticleIndexing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact article indexings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact article indexings
	* @param end the upper bound of the range of fact article indexings (not inclusive)
	* @return the range of fact article indexings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactArticleIndexing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact article indexings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact article indexings
	* @param end the upper bound of the range of fact article indexings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact article indexings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactArticleIndexing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact article indexings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact article indexings.
	*
	* @return the number of fact article indexings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactArticleIndexingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactArticleIndexingPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactArticleIndexingPersistence.class.getName());

			ReferenceRegistry.registerReference(FactArticleIndexingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactArticleIndexingPersistence persistence) {
	}

	private static FactArticleIndexingPersistence _persistence;
}
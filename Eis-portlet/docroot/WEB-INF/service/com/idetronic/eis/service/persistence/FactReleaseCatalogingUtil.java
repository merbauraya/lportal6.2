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

import com.idetronic.eis.model.FactReleaseCataloging;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact release cataloging service. This utility wraps {@link FactReleaseCatalogingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactReleaseCatalogingPersistence
 * @see FactReleaseCatalogingPersistenceImpl
 * @generated
 */
public class FactReleaseCatalogingUtil {
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
	public static void clearCache(FactReleaseCataloging factReleaseCataloging) {
		getPersistence().clearCache(factReleaseCataloging);
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
	public static List<FactReleaseCataloging> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactReleaseCataloging> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactReleaseCataloging> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactReleaseCataloging update(
		FactReleaseCataloging factReleaseCataloging) throws SystemException {
		return getPersistence().update(factReleaseCataloging);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactReleaseCataloging update(
		FactReleaseCataloging factReleaseCataloging,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(factReleaseCataloging, serviceContext);
	}

	/**
	* Caches the fact release cataloging in the entity cache if it is enabled.
	*
	* @param factReleaseCataloging the fact release cataloging
	*/
	public static void cacheResult(
		com.idetronic.eis.model.FactReleaseCataloging factReleaseCataloging) {
		getPersistence().cacheResult(factReleaseCataloging);
	}

	/**
	* Caches the fact release catalogings in the entity cache if it is enabled.
	*
	* @param factReleaseCatalogings the fact release catalogings
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactReleaseCataloging> factReleaseCatalogings) {
		getPersistence().cacheResult(factReleaseCatalogings);
	}

	/**
	* Creates a new fact release cataloging with the primary key. Does not add the fact release cataloging to the database.
	*
	* @param factId the primary key for the new fact release cataloging
	* @return the new fact release cataloging
	*/
	public static com.idetronic.eis.model.FactReleaseCataloging create(
		long factId) {
		return getPersistence().create(factId);
	}

	/**
	* Removes the fact release cataloging with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact release cataloging
	* @return the fact release cataloging that was removed
	* @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactReleaseCataloging remove(
		long factId)
		throws com.idetronic.eis.NoSuchFactReleaseCatalogingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(factId);
	}

	public static com.idetronic.eis.model.FactReleaseCataloging updateImpl(
		com.idetronic.eis.model.FactReleaseCataloging factReleaseCataloging)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factReleaseCataloging);
	}

	/**
	* Returns the fact release cataloging with the primary key or throws a {@link com.idetronic.eis.NoSuchFactReleaseCatalogingException} if it could not be found.
	*
	* @param factId the primary key of the fact release cataloging
	* @return the fact release cataloging
	* @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactReleaseCataloging findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactReleaseCatalogingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(factId);
	}

	/**
	* Returns the fact release cataloging with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact release cataloging
	* @return the fact release cataloging, or <code>null</code> if a fact release cataloging with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactReleaseCataloging fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(factId);
	}

	/**
	* Returns all the fact release catalogings.
	*
	* @return the fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactReleaseCataloging> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact release catalogings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact release catalogings
	* @param end the upper bound of the range of fact release catalogings (not inclusive)
	* @return the range of fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactReleaseCataloging> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact release catalogings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact release catalogings
	* @param end the upper bound of the range of fact release catalogings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactReleaseCataloging> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact release catalogings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact release catalogings.
	*
	* @return the number of fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactReleaseCatalogingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactReleaseCatalogingPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactReleaseCatalogingPersistence.class.getName());

			ReferenceRegistry.registerReference(FactReleaseCatalogingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactReleaseCatalogingPersistence persistence) {
	}

	private static FactReleaseCatalogingPersistence _persistence;
}
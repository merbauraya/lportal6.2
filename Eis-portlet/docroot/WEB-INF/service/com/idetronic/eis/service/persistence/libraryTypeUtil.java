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

import com.idetronic.eis.model.libraryType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the library type service. This utility wraps {@link libraryTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see libraryTypePersistence
 * @see libraryTypePersistenceImpl
 * @generated
 */
public class libraryTypeUtil {
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
	public static void clearCache(libraryType libraryType) {
		getPersistence().clearCache(libraryType);
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
	public static List<libraryType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<libraryType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<libraryType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static libraryType update(libraryType libraryType)
		throws SystemException {
		return getPersistence().update(libraryType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static libraryType update(libraryType libraryType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(libraryType, serviceContext);
	}

	/**
	* Caches the library type in the entity cache if it is enabled.
	*
	* @param libraryType the library type
	*/
	public static void cacheResult(
		com.idetronic.eis.model.libraryType libraryType) {
		getPersistence().cacheResult(libraryType);
	}

	/**
	* Caches the library types in the entity cache if it is enabled.
	*
	* @param libraryTypes the library types
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.libraryType> libraryTypes) {
		getPersistence().cacheResult(libraryTypes);
	}

	/**
	* Creates a new library type with the primary key. Does not add the library type to the database.
	*
	* @param libraryTypeId the primary key for the new library type
	* @return the new library type
	*/
	public static com.idetronic.eis.model.libraryType create(long libraryTypeId) {
		return getPersistence().create(libraryTypeId);
	}

	/**
	* Removes the library type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type that was removed
	* @throws com.idetronic.eis.NoSuchlibraryTypeException if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.libraryType remove(long libraryTypeId)
		throws com.idetronic.eis.NoSuchlibraryTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(libraryTypeId);
	}

	public static com.idetronic.eis.model.libraryType updateImpl(
		com.idetronic.eis.model.libraryType libraryType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(libraryType);
	}

	/**
	* Returns the library type with the primary key or throws a {@link com.idetronic.eis.NoSuchlibraryTypeException} if it could not be found.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type
	* @throws com.idetronic.eis.NoSuchlibraryTypeException if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.libraryType findByPrimaryKey(
		long libraryTypeId)
		throws com.idetronic.eis.NoSuchlibraryTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(libraryTypeId);
	}

	/**
	* Returns the library type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type, or <code>null</code> if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.libraryType fetchByPrimaryKey(
		long libraryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(libraryTypeId);
	}

	/**
	* Returns all the library types.
	*
	* @return the library types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.libraryType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the library types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.libraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library types
	* @param end the upper bound of the range of library types (not inclusive)
	* @return the range of library types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.libraryType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the library types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.libraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library types
	* @param end the upper bound of the range of library types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of library types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.libraryType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the library types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of library types.
	*
	* @return the number of library types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static libraryTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (libraryTypePersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					libraryTypePersistence.class.getName());

			ReferenceRegistry.registerReference(libraryTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(libraryTypePersistence persistence) {
	}

	private static libraryTypePersistence _persistence;
}
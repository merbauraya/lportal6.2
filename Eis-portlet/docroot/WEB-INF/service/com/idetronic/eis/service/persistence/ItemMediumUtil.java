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

import com.idetronic.eis.model.ItemMedium;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item medium service. This utility wraps {@link ItemMediumPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemMediumPersistence
 * @see ItemMediumPersistenceImpl
 * @generated
 */
public class ItemMediumUtil {
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
	public static void clearCache(ItemMedium itemMedium) {
		getPersistence().clearCache(itemMedium);
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
	public static List<ItemMedium> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemMedium> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemMedium> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemMedium update(ItemMedium itemMedium)
		throws SystemException {
		return getPersistence().update(itemMedium);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemMedium update(ItemMedium itemMedium,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemMedium, serviceContext);
	}

	/**
	* Caches the item medium in the entity cache if it is enabled.
	*
	* @param itemMedium the item medium
	*/
	public static void cacheResult(
		com.idetronic.eis.model.ItemMedium itemMedium) {
		getPersistence().cacheResult(itemMedium);
	}

	/**
	* Caches the item mediums in the entity cache if it is enabled.
	*
	* @param itemMediums the item mediums
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.ItemMedium> itemMediums) {
		getPersistence().cacheResult(itemMediums);
	}

	/**
	* Creates a new item medium with the primary key. Does not add the item medium to the database.
	*
	* @param itemMediumId the primary key for the new item medium
	* @return the new item medium
	*/
	public static com.idetronic.eis.model.ItemMedium create(long itemMediumId) {
		return getPersistence().create(itemMediumId);
	}

	/**
	* Removes the item medium with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium that was removed
	* @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemMedium remove(long itemMediumId)
		throws com.idetronic.eis.NoSuchItemMediumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemMediumId);
	}

	public static com.idetronic.eis.model.ItemMedium updateImpl(
		com.idetronic.eis.model.ItemMedium itemMedium)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemMedium);
	}

	/**
	* Returns the item medium with the primary key or throws a {@link com.idetronic.eis.NoSuchItemMediumException} if it could not be found.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium
	* @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemMedium findByPrimaryKey(
		long itemMediumId)
		throws com.idetronic.eis.NoSuchItemMediumException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemMediumId);
	}

	/**
	* Returns the item medium with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium, or <code>null</code> if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemMedium fetchByPrimaryKey(
		long itemMediumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemMediumId);
	}

	/**
	* Returns all the item mediums.
	*
	* @return the item mediums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.ItemMedium> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item mediums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemMediumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item mediums
	* @param end the upper bound of the range of item mediums (not inclusive)
	* @return the range of item mediums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.ItemMedium> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item mediums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemMediumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item mediums
	* @param end the upper bound of the range of item mediums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item mediums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.ItemMedium> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item mediums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item mediums.
	*
	* @return the number of item mediums
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemMediumPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemMediumPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					ItemMediumPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemMediumUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemMediumPersistence persistence) {
	}

	private static ItemMediumPersistence _persistence;
}
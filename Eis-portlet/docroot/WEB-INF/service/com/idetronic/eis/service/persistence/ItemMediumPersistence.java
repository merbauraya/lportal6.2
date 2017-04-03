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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item medium service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemMediumPersistenceImpl
 * @see ItemMediumUtil
 * @generated
 */
public interface ItemMediumPersistence extends BasePersistence<ItemMedium> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemMediumUtil} to access the item medium persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the item medium in the entity cache if it is enabled.
	*
	* @param itemMedium the item medium
	*/
	public void cacheResult(com.idetronic.eis.model.ItemMedium itemMedium);

	/**
	* Caches the item mediums in the entity cache if it is enabled.
	*
	* @param itemMediums the item mediums
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ItemMedium> itemMediums);

	/**
	* Creates a new item medium with the primary key. Does not add the item medium to the database.
	*
	* @param itemMediumId the primary key for the new item medium
	* @return the new item medium
	*/
	public com.idetronic.eis.model.ItemMedium create(long itemMediumId);

	/**
	* Removes the item medium with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium that was removed
	* @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemMedium remove(long itemMediumId)
		throws com.idetronic.eis.NoSuchItemMediumException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ItemMedium updateImpl(
		com.idetronic.eis.model.ItemMedium itemMedium)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item medium with the primary key or throws a {@link com.idetronic.eis.NoSuchItemMediumException} if it could not be found.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium
	* @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemMedium findByPrimaryKey(
		long itemMediumId)
		throws com.idetronic.eis.NoSuchItemMediumException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item medium with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium, or <code>null</code> if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemMedium fetchByPrimaryKey(
		long itemMediumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item mediums.
	*
	* @return the item mediums
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemMedium> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.ItemMedium> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.ItemMedium> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item mediums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item mediums.
	*
	* @return the number of item mediums
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.idetronic.eis.model.NonPrintedItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the non printed item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see NonPrintedItemTypePersistenceImpl
 * @see NonPrintedItemTypeUtil
 * @generated
 */
public interface NonPrintedItemTypePersistence extends BasePersistence<NonPrintedItemType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NonPrintedItemTypeUtil} to access the non printed item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the non printed item type in the entity cache if it is enabled.
	*
	* @param nonPrintedItemType the non printed item type
	*/
	public void cacheResult(
		com.idetronic.eis.model.NonPrintedItemType nonPrintedItemType);

	/**
	* Caches the non printed item types in the entity cache if it is enabled.
	*
	* @param nonPrintedItemTypes the non printed item types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.NonPrintedItemType> nonPrintedItemTypes);

	/**
	* Creates a new non printed item type with the primary key. Does not add the non printed item type to the database.
	*
	* @param itemTypeId the primary key for the new non printed item type
	* @return the new non printed item type
	*/
	public com.idetronic.eis.model.NonPrintedItemType create(long itemTypeId);

	/**
	* Removes the non printed item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeId the primary key of the non printed item type
	* @return the non printed item type that was removed
	* @throws com.idetronic.eis.NoSuchNonPrintedItemTypeException if a non printed item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.NonPrintedItemType remove(long itemTypeId)
		throws com.idetronic.eis.NoSuchNonPrintedItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.NonPrintedItemType updateImpl(
		com.idetronic.eis.model.NonPrintedItemType nonPrintedItemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the non printed item type with the primary key or throws a {@link com.idetronic.eis.NoSuchNonPrintedItemTypeException} if it could not be found.
	*
	* @param itemTypeId the primary key of the non printed item type
	* @return the non printed item type
	* @throws com.idetronic.eis.NoSuchNonPrintedItemTypeException if a non printed item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.NonPrintedItemType findByPrimaryKey(
		long itemTypeId)
		throws com.idetronic.eis.NoSuchNonPrintedItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the non printed item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeId the primary key of the non printed item type
	* @return the non printed item type, or <code>null</code> if a non printed item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.NonPrintedItemType fetchByPrimaryKey(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the non printed item types.
	*
	* @return the non printed item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.NonPrintedItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the non printed item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.NonPrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of non printed item types
	* @param end the upper bound of the range of non printed item types (not inclusive)
	* @return the range of non printed item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.NonPrintedItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the non printed item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.NonPrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of non printed item types
	* @param end the upper bound of the range of non printed item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of non printed item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.NonPrintedItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the non printed item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of non printed item types.
	*
	* @return the number of non printed item types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
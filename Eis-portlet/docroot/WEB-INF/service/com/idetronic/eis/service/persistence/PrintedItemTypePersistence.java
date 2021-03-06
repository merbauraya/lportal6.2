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

import com.idetronic.eis.model.PrintedItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the printed item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PrintedItemTypePersistenceImpl
 * @see PrintedItemTypeUtil
 * @generated
 */
public interface PrintedItemTypePersistence extends BasePersistence<PrintedItemType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrintedItemTypeUtil} to access the printed item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the printed item type in the entity cache if it is enabled.
	*
	* @param printedItemType the printed item type
	*/
	public void cacheResult(
		com.idetronic.eis.model.PrintedItemType printedItemType);

	/**
	* Caches the printed item types in the entity cache if it is enabled.
	*
	* @param printedItemTypes the printed item types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.PrintedItemType> printedItemTypes);

	/**
	* Creates a new printed item type with the primary key. Does not add the printed item type to the database.
	*
	* @param itemTypeId the primary key for the new printed item type
	* @return the new printed item type
	*/
	public com.idetronic.eis.model.PrintedItemType create(long itemTypeId);

	/**
	* Removes the printed item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeId the primary key of the printed item type
	* @return the printed item type that was removed
	* @throws com.idetronic.eis.NoSuchPrintedItemTypeException if a printed item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PrintedItemType remove(long itemTypeId)
		throws com.idetronic.eis.NoSuchPrintedItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.PrintedItemType updateImpl(
		com.idetronic.eis.model.PrintedItemType printedItemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the printed item type with the primary key or throws a {@link com.idetronic.eis.NoSuchPrintedItemTypeException} if it could not be found.
	*
	* @param itemTypeId the primary key of the printed item type
	* @return the printed item type
	* @throws com.idetronic.eis.NoSuchPrintedItemTypeException if a printed item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PrintedItemType findByPrimaryKey(
		long itemTypeId)
		throws com.idetronic.eis.NoSuchPrintedItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the printed item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeId the primary key of the printed item type
	* @return the printed item type, or <code>null</code> if a printed item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PrintedItemType fetchByPrimaryKey(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the printed item types.
	*
	* @return the printed item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.PrintedItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the printed item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of printed item types
	* @param end the upper bound of the range of printed item types (not inclusive)
	* @return the range of printed item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.PrintedItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the printed item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of printed item types
	* @param end the upper bound of the range of printed item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of printed item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.PrintedItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the printed item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of printed item types.
	*
	* @return the number of printed item types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
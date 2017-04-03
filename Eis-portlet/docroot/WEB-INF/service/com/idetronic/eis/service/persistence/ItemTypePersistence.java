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

import com.idetronic.eis.model.ItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypePersistenceImpl
 * @see ItemTypeUtil
 * @generated
 */
public interface ItemTypePersistence extends BasePersistence<ItemType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemTypeUtil} to access the item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the item types where printedType = &#63;.
	*
	* @param printedType the printed type
	* @return the matching item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findByPrintedType(
		int printedType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item types where printedType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param printedType the printed type
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @return the range of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findByPrintedType(
		int printedType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item types where printedType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param printedType the printed type
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findByPrintedType(
		int printedType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType findByPrintedType_First(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType fetchByPrintedType_First(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType findByPrintedType_Last(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType fetchByPrintedType_Last(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item types before and after the current item type in the ordered set where printedType = &#63;.
	*
	* @param itemTypeId the primary key of the current item type
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType[] findByPrintedType_PrevAndNext(
		long itemTypeId, int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item types where printedType = &#63; from the database.
	*
	* @param printedType the printed type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPrintedType(int printedType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item types where printedType = &#63;.
	*
	* @param printedType the printed type
	* @return the number of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public int countByPrintedType(int printedType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item types where IRType = &#63;.
	*
	* @param IRType the i r type
	* @return the matching item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findByIRType(
		boolean IRType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item types where IRType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param IRType the i r type
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @return the range of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findByIRType(
		boolean IRType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item types where IRType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param IRType the i r type
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findByIRType(
		boolean IRType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType findByIRType_First(boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType fetchByIRType_First(
		boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType findByIRType_Last(boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType fetchByIRType_Last(boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item types before and after the current item type in the ordered set where IRType = &#63;.
	*
	* @param itemTypeId the primary key of the current item type
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType[] findByIRType_PrevAndNext(
		long itemTypeId, boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item types where IRType = &#63; from the database.
	*
	* @param IRType the i r type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIRType(boolean IRType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item types where IRType = &#63;.
	*
	* @param IRType the i r type
	* @return the number of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public int countByIRType(boolean IRType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the item type in the entity cache if it is enabled.
	*
	* @param itemType the item type
	*/
	public void cacheResult(com.idetronic.eis.model.ItemType itemType);

	/**
	* Caches the item types in the entity cache if it is enabled.
	*
	* @param itemTypes the item types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ItemType> itemTypes);

	/**
	* Creates a new item type with the primary key. Does not add the item type to the database.
	*
	* @param itemTypeId the primary key for the new item type
	* @return the new item type
	*/
	public com.idetronic.eis.model.ItemType create(long itemTypeId);

	/**
	* Removes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type that was removed
	* @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType remove(long itemTypeId)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ItemType updateImpl(
		com.idetronic.eis.model.ItemType itemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item type with the primary key or throws a {@link com.idetronic.eis.NoSuchItemTypeException} if it could not be found.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType findByPrimaryKey(long itemTypeId)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type, or <code>null</code> if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemType fetchByPrimaryKey(long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item types.
	*
	* @return the item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @return the range of item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item types
	* @param end the upper bound of the range of item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemType> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item types.
	*
	* @return the number of item types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
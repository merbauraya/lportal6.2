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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the item type service. This utility wraps {@link ItemTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypePersistence
 * @see ItemTypePersistenceImpl
 * @generated
 */
public class ItemTypeUtil {
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
	public static void clearCache(ItemType itemType) {
		getPersistence().clearCache(itemType);
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
	public static List<ItemType> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ItemType update(ItemType itemType) throws SystemException {
		return getPersistence().update(itemType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ItemType update(ItemType itemType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(itemType, serviceContext);
	}

	/**
	* Returns all the item types where printedType = &#63;.
	*
	* @param printedType the printed type
	* @return the matching item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.ItemType> findByPrintedType(
		int printedType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrintedType(printedType);
	}

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
	public static java.util.List<com.idetronic.eis.model.ItemType> findByPrintedType(
		int printedType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrintedType(printedType, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.ItemType> findByPrintedType(
		int printedType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrintedType(printedType, start, end, orderByComparator);
	}

	/**
	* Returns the first item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType findByPrintedType_First(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrintedType_First(printedType, orderByComparator);
	}

	/**
	* Returns the first item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType fetchByPrintedType_First(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrintedType_First(printedType, orderByComparator);
	}

	/**
	* Returns the last item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType findByPrintedType_Last(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrintedType_Last(printedType, orderByComparator);
	}

	/**
	* Returns the last item type in the ordered set where printedType = &#63;.
	*
	* @param printedType the printed type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType fetchByPrintedType_Last(
		int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrintedType_Last(printedType, orderByComparator);
	}

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
	public static com.idetronic.eis.model.ItemType[] findByPrintedType_PrevAndNext(
		long itemTypeId, int printedType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrintedType_PrevAndNext(itemTypeId, printedType,
			orderByComparator);
	}

	/**
	* Removes all the item types where printedType = &#63; from the database.
	*
	* @param printedType the printed type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPrintedType(int printedType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPrintedType(printedType);
	}

	/**
	* Returns the number of item types where printedType = &#63;.
	*
	* @param printedType the printed type
	* @return the number of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPrintedType(int printedType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPrintedType(printedType);
	}

	/**
	* Returns all the item types where IRType = &#63;.
	*
	* @param IRType the i r type
	* @return the matching item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.ItemType> findByIRType(
		boolean IRType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIRType(IRType);
	}

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
	public static java.util.List<com.idetronic.eis.model.ItemType> findByIRType(
		boolean IRType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIRType(IRType, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.ItemType> findByIRType(
		boolean IRType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIRType(IRType, start, end, orderByComparator);
	}

	/**
	* Returns the first item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType findByIRType_First(
		boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIRType_First(IRType, orderByComparator);
	}

	/**
	* Returns the first item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType fetchByIRType_First(
		boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIRType_First(IRType, orderByComparator);
	}

	/**
	* Returns the last item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType findByIRType_Last(
		boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIRType_Last(IRType, orderByComparator);
	}

	/**
	* Returns the last item type in the ordered set where IRType = &#63;.
	*
	* @param IRType the i r type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item type, or <code>null</code> if a matching item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType fetchByIRType_Last(
		boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIRType_Last(IRType, orderByComparator);
	}

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
	public static com.idetronic.eis.model.ItemType[] findByIRType_PrevAndNext(
		long itemTypeId, boolean IRType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIRType_PrevAndNext(itemTypeId, IRType,
			orderByComparator);
	}

	/**
	* Removes all the item types where IRType = &#63; from the database.
	*
	* @param IRType the i r type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIRType(boolean IRType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIRType(IRType);
	}

	/**
	* Returns the number of item types where IRType = &#63;.
	*
	* @param IRType the i r type
	* @return the number of matching item types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIRType(boolean IRType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIRType(IRType);
	}

	/**
	* Caches the item type in the entity cache if it is enabled.
	*
	* @param itemType the item type
	*/
	public static void cacheResult(com.idetronic.eis.model.ItemType itemType) {
		getPersistence().cacheResult(itemType);
	}

	/**
	* Caches the item types in the entity cache if it is enabled.
	*
	* @param itemTypes the item types
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.ItemType> itemTypes) {
		getPersistence().cacheResult(itemTypes);
	}

	/**
	* Creates a new item type with the primary key. Does not add the item type to the database.
	*
	* @param itemTypeId the primary key for the new item type
	* @return the new item type
	*/
	public static com.idetronic.eis.model.ItemType create(long itemTypeId) {
		return getPersistence().create(itemTypeId);
	}

	/**
	* Removes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type that was removed
	* @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType remove(long itemTypeId)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemTypeId);
	}

	public static com.idetronic.eis.model.ItemType updateImpl(
		com.idetronic.eis.model.ItemType itemType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(itemType);
	}

	/**
	* Returns the item type with the primary key or throws a {@link com.idetronic.eis.NoSuchItemTypeException} if it could not be found.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type
	* @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType findByPrimaryKey(
		long itemTypeId)
		throws com.idetronic.eis.NoSuchItemTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemTypeId);
	}

	/**
	* Returns the item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeId the primary key of the item type
	* @return the item type, or <code>null</code> if a item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ItemType fetchByPrimaryKey(
		long itemTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemTypeId);
	}

	/**
	* Returns all the item types.
	*
	* @return the item types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.ItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eis.model.ItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.ItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item types.
	*
	* @return the number of item types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ItemTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemTypePersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					ItemTypePersistence.class.getName());

			ReferenceRegistry.registerReference(ItemTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ItemTypePersistence persistence) {
	}

	private static ItemTypePersistence _persistence;
}
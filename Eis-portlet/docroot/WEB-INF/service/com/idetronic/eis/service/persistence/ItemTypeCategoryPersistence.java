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

import com.idetronic.eis.model.ItemTypeCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the item type category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeCategoryPersistenceImpl
 * @see ItemTypeCategoryUtil
 * @generated
 */
public interface ItemTypeCategoryPersistence extends BasePersistence<ItemTypeCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ItemTypeCategoryUtil} to access the item type category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the item type category in the entity cache if it is enabled.
	*
	* @param itemTypeCategory the item type category
	*/
	public void cacheResult(
		com.idetronic.eis.model.ItemTypeCategory itemTypeCategory);

	/**
	* Caches the item type categories in the entity cache if it is enabled.
	*
	* @param itemTypeCategories the item type categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ItemTypeCategory> itemTypeCategories);

	/**
	* Creates a new item type category with the primary key. Does not add the item type category to the database.
	*
	* @param itemTypeCategoryId the primary key for the new item type category
	* @return the new item type category
	*/
	public com.idetronic.eis.model.ItemTypeCategory create(
		long itemTypeCategoryId);

	/**
	* Removes the item type category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeCategoryId the primary key of the item type category
	* @return the item type category that was removed
	* @throws com.idetronic.eis.NoSuchItemTypeCategoryException if a item type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemTypeCategory remove(
		long itemTypeCategoryId)
		throws com.idetronic.eis.NoSuchItemTypeCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ItemTypeCategory updateImpl(
		com.idetronic.eis.model.ItemTypeCategory itemTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item type category with the primary key or throws a {@link com.idetronic.eis.NoSuchItemTypeCategoryException} if it could not be found.
	*
	* @param itemTypeCategoryId the primary key of the item type category
	* @return the item type category
	* @throws com.idetronic.eis.NoSuchItemTypeCategoryException if a item type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemTypeCategory findByPrimaryKey(
		long itemTypeCategoryId)
		throws com.idetronic.eis.NoSuchItemTypeCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the item type category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemTypeCategoryId the primary key of the item type category
	* @return the item type category, or <code>null</code> if a item type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ItemTypeCategory fetchByPrimaryKey(
		long itemTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the item type categories.
	*
	* @return the item type categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemTypeCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the item type categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item type categories
	* @param end the upper bound of the range of item type categories (not inclusive)
	* @return the range of item type categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemTypeCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the item type categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item type categories
	* @param end the upper bound of the range of item type categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item type categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ItemTypeCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the item type categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of item type categories.
	*
	* @return the number of item type categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
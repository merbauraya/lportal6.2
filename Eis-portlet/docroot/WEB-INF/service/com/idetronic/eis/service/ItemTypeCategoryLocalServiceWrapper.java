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

package com.idetronic.eis.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ItemTypeCategoryLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemTypeCategoryLocalService
 * @generated
 */
public class ItemTypeCategoryLocalServiceWrapper
	implements ItemTypeCategoryLocalService,
		ServiceWrapper<ItemTypeCategoryLocalService> {
	public ItemTypeCategoryLocalServiceWrapper(
		ItemTypeCategoryLocalService itemTypeCategoryLocalService) {
		_itemTypeCategoryLocalService = itemTypeCategoryLocalService;
	}

	/**
	* Adds the item type category to the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeCategory the item type category
	* @return the item type category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemTypeCategory addItemTypeCategory(
		com.idetronic.eis.model.ItemTypeCategory itemTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.addItemTypeCategory(itemTypeCategory);
	}

	/**
	* Creates a new item type category with the primary key. Does not add the item type category to the database.
	*
	* @param itemTypeCategoryId the primary key for the new item type category
	* @return the new item type category
	*/
	@Override
	public com.idetronic.eis.model.ItemTypeCategory createItemTypeCategory(
		long itemTypeCategoryId) {
		return _itemTypeCategoryLocalService.createItemTypeCategory(itemTypeCategoryId);
	}

	/**
	* Deletes the item type category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeCategoryId the primary key of the item type category
	* @return the item type category that was removed
	* @throws PortalException if a item type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemTypeCategory deleteItemTypeCategory(
		long itemTypeCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.deleteItemTypeCategory(itemTypeCategoryId);
	}

	/**
	* Deletes the item type category from the database. Also notifies the appropriate model listeners.
	*
	* @param itemTypeCategory the item type category
	* @return the item type category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemTypeCategory deleteItemTypeCategory(
		com.idetronic.eis.model.ItemTypeCategory itemTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.deleteItemTypeCategory(itemTypeCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemTypeCategoryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.ItemTypeCategory fetchItemTypeCategory(
		long itemTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.fetchItemTypeCategory(itemTypeCategoryId);
	}

	/**
	* Returns the item type category with the primary key.
	*
	* @param itemTypeCategoryId the primary key of the item type category
	* @return the item type category
	* @throws PortalException if a item type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemTypeCategory getItemTypeCategory(
		long itemTypeCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.getItemTypeCategory(itemTypeCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.idetronic.eis.model.ItemTypeCategory> getItemTypeCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.getItemTypeCategories(start, end);
	}

	/**
	* Returns the number of item type categories.
	*
	* @return the number of item type categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemTypeCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.getItemTypeCategoriesCount();
	}

	/**
	* Updates the item type category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemTypeCategory the item type category
	* @return the item type category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemTypeCategory updateItemTypeCategory(
		com.idetronic.eis.model.ItemTypeCategory itemTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.updateItemTypeCategory(itemTypeCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemTypeCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemTypeCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemTypeCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.ItemTypeCategory add(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemTypeCategoryLocalService.add(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemTypeCategoryLocalService getWrappedItemTypeCategoryLocalService() {
		return _itemTypeCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemTypeCategoryLocalService(
		ItemTypeCategoryLocalService itemTypeCategoryLocalService) {
		_itemTypeCategoryLocalService = itemTypeCategoryLocalService;
	}

	@Override
	public ItemTypeCategoryLocalService getWrappedService() {
		return _itemTypeCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ItemTypeCategoryLocalService itemTypeCategoryLocalService) {
		_itemTypeCategoryLocalService = itemTypeCategoryLocalService;
	}

	private ItemTypeCategoryLocalService _itemTypeCategoryLocalService;
}
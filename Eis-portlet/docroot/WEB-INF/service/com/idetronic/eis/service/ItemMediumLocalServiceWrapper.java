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
 * Provides a wrapper for {@link ItemMediumLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemMediumLocalService
 * @generated
 */
public class ItemMediumLocalServiceWrapper implements ItemMediumLocalService,
	ServiceWrapper<ItemMediumLocalService> {
	public ItemMediumLocalServiceWrapper(
		ItemMediumLocalService itemMediumLocalService) {
		_itemMediumLocalService = itemMediumLocalService;
	}

	/**
	* Adds the item medium to the database. Also notifies the appropriate model listeners.
	*
	* @param itemMedium the item medium
	* @return the item medium that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemMedium addItemMedium(
		com.idetronic.eis.model.ItemMedium itemMedium)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.addItemMedium(itemMedium);
	}

	/**
	* Creates a new item medium with the primary key. Does not add the item medium to the database.
	*
	* @param itemMediumId the primary key for the new item medium
	* @return the new item medium
	*/
	@Override
	public com.idetronic.eis.model.ItemMedium createItemMedium(
		long itemMediumId) {
		return _itemMediumLocalService.createItemMedium(itemMediumId);
	}

	/**
	* Deletes the item medium with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium that was removed
	* @throws PortalException if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemMedium deleteItemMedium(
		long itemMediumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.deleteItemMedium(itemMediumId);
	}

	/**
	* Deletes the item medium from the database. Also notifies the appropriate model listeners.
	*
	* @param itemMedium the item medium
	* @return the item medium that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemMedium deleteItemMedium(
		com.idetronic.eis.model.ItemMedium itemMedium)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.deleteItemMedium(itemMedium);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemMediumLocalService.dynamicQuery();
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
		return _itemMediumLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemMediumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemMediumLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemMediumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemMediumLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _itemMediumLocalService.dynamicQueryCount(dynamicQuery);
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
		return _itemMediumLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.ItemMedium fetchItemMedium(long itemMediumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.fetchItemMedium(itemMediumId);
	}

	/**
	* Returns the item medium with the primary key.
	*
	* @param itemMediumId the primary key of the item medium
	* @return the item medium
	* @throws PortalException if a item medium with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemMedium getItemMedium(long itemMediumId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.getItemMedium(itemMediumId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.idetronic.eis.model.ItemMedium> getItemMediums(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.getItemMediums(start, end);
	}

	/**
	* Returns the number of item mediums.
	*
	* @return the number of item mediums
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemMediumsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.getItemMediumsCount();
	}

	/**
	* Updates the item medium in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemMedium the item medium
	* @return the item medium that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ItemMedium updateItemMedium(
		com.idetronic.eis.model.ItemMedium itemMedium)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.updateItemMedium(itemMedium);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemMediumLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemMediumLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemMediumLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.ItemMedium add(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemMediumLocalService.add(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemMediumLocalService getWrappedItemMediumLocalService() {
		return _itemMediumLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemMediumLocalService(
		ItemMediumLocalService itemMediumLocalService) {
		_itemMediumLocalService = itemMediumLocalService;
	}

	@Override
	public ItemMediumLocalService getWrappedService() {
		return _itemMediumLocalService;
	}

	@Override
	public void setWrappedService(ItemMediumLocalService itemMediumLocalService) {
		_itemMediumLocalService = itemMediumLocalService;
	}

	private ItemMediumLocalService _itemMediumLocalService;
}
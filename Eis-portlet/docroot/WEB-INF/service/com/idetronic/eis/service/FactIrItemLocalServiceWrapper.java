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
 * Provides a wrapper for {@link FactIrItemLocalService}.
 *
 * @author Mazlan Mat
 * @see FactIrItemLocalService
 * @generated
 */
public class FactIrItemLocalServiceWrapper implements FactIrItemLocalService,
	ServiceWrapper<FactIrItemLocalService> {
	public FactIrItemLocalServiceWrapper(
		FactIrItemLocalService factIrItemLocalService) {
		_factIrItemLocalService = factIrItemLocalService;
	}

	/**
	* Adds the fact ir item to the database. Also notifies the appropriate model listeners.
	*
	* @param factIrItem the fact ir item
	* @return the fact ir item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactIrItem addFactIrItem(
		com.idetronic.eis.model.FactIrItem factIrItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.addFactIrItem(factIrItem);
	}

	/**
	* Creates a new fact ir item with the primary key. Does not add the fact ir item to the database.
	*
	* @param factIrItemId the primary key for the new fact ir item
	* @return the new fact ir item
	*/
	@Override
	public com.idetronic.eis.model.FactIrItem createFactIrItem(
		long factIrItemId) {
		return _factIrItemLocalService.createFactIrItem(factIrItemId);
	}

	/**
	* Deletes the fact ir item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factIrItemId the primary key of the fact ir item
	* @return the fact ir item that was removed
	* @throws PortalException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactIrItem deleteFactIrItem(
		long factIrItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.deleteFactIrItem(factIrItemId);
	}

	/**
	* Deletes the fact ir item from the database. Also notifies the appropriate model listeners.
	*
	* @param factIrItem the fact ir item
	* @return the fact ir item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactIrItem deleteFactIrItem(
		com.idetronic.eis.model.FactIrItem factIrItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.deleteFactIrItem(factIrItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factIrItemLocalService.dynamicQuery();
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
		return _factIrItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factIrItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factIrItemLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _factIrItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factIrItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactIrItem fetchFactIrItem(long factIrItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.fetchFactIrItem(factIrItemId);
	}

	/**
	* Returns the fact ir item with the primary key.
	*
	* @param factIrItemId the primary key of the fact ir item
	* @return the fact ir item
	* @throws PortalException if a fact ir item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactIrItem getFactIrItem(long factIrItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.getFactIrItem(factIrItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact ir items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact ir items
	* @param end the upper bound of the range of fact ir items (not inclusive)
	* @return the range of fact ir items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactIrItem> getFactIrItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.getFactIrItems(start, end);
	}

	/**
	* Returns the number of fact ir items.
	*
	* @return the number of fact ir items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactIrItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.getFactIrItemsCount();
	}

	/**
	* Updates the fact ir item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factIrItem the fact ir item
	* @return the fact ir item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactIrItem updateFactIrItem(
		com.idetronic.eis.model.FactIrItem factIrItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.updateFactIrItem(factIrItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factIrItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factIrItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factIrItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.FactIrItem add(long libraryId,
		long facultyId, java.lang.String period, long itemTypeId,
		long itemMediumId, int titleTotal, int volumeTotal,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.add(libraryId, facultyId, period,
			itemTypeId, itemMediumId, titleTotal, volumeTotal, serviceContext);
	}

	@Override
	public void batchInsert(long libraryId, long facultyId,
		java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factIrItemLocalService.batchInsert(libraryId, facultyId, period,
			datas, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactIrItem> getLatestEntry(
		long libraryId, long facultyId, java.lang.String period) {
		return _factIrItemLocalService.getLatestEntry(libraryId, facultyId,
			period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period, long facultyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.getEntries(libraryId, period, facultyId);
	}

	@Override
	public boolean isMissingData(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factIrItemLocalService.isMissingData(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactIrItemLocalService getWrappedFactIrItemLocalService() {
		return _factIrItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactIrItemLocalService(
		FactIrItemLocalService factIrItemLocalService) {
		_factIrItemLocalService = factIrItemLocalService;
	}

	@Override
	public FactIrItemLocalService getWrappedService() {
		return _factIrItemLocalService;
	}

	@Override
	public void setWrappedService(FactIrItemLocalService factIrItemLocalService) {
		_factIrItemLocalService = factIrItemLocalService;
	}

	private FactIrItemLocalService _factIrItemLocalService;
}
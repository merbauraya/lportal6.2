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
 * Provides a wrapper for {@link FactGiftReceivedLocalService}.
 *
 * @author Mazlan Mat
 * @see FactGiftReceivedLocalService
 * @generated
 */
public class FactGiftReceivedLocalServiceWrapper
	implements FactGiftReceivedLocalService,
		ServiceWrapper<FactGiftReceivedLocalService> {
	public FactGiftReceivedLocalServiceWrapper(
		FactGiftReceivedLocalService factGiftReceivedLocalService) {
		_factGiftReceivedLocalService = factGiftReceivedLocalService;
	}

	/**
	* Adds the fact gift received to the database. Also notifies the appropriate model listeners.
	*
	* @param factGiftReceived the fact gift received
	* @return the fact gift received that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactGiftReceived addFactGiftReceived(
		com.idetronic.eis.model.FactGiftReceived factGiftReceived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.addFactGiftReceived(factGiftReceived);
	}

	/**
	* Creates a new fact gift received with the primary key. Does not add the fact gift received to the database.
	*
	* @param factId the primary key for the new fact gift received
	* @return the new fact gift received
	*/
	@Override
	public com.idetronic.eis.model.FactGiftReceived createFactGiftReceived(
		long factId) {
		return _factGiftReceivedLocalService.createFactGiftReceived(factId);
	}

	/**
	* Deletes the fact gift received with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact gift received
	* @return the fact gift received that was removed
	* @throws PortalException if a fact gift received with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactGiftReceived deleteFactGiftReceived(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.deleteFactGiftReceived(factId);
	}

	/**
	* Deletes the fact gift received from the database. Also notifies the appropriate model listeners.
	*
	* @param factGiftReceived the fact gift received
	* @return the fact gift received that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactGiftReceived deleteFactGiftReceived(
		com.idetronic.eis.model.FactGiftReceived factGiftReceived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.deleteFactGiftReceived(factGiftReceived);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factGiftReceivedLocalService.dynamicQuery();
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
		return _factGiftReceivedLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactGiftReceivedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factGiftReceivedLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactGiftReceivedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factGiftReceivedLocalService.dynamicQuery(dynamicQuery, start,
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
		return _factGiftReceivedLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factGiftReceivedLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactGiftReceived fetchFactGiftReceived(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.fetchFactGiftReceived(factId);
	}

	/**
	* Returns the fact gift received with the primary key.
	*
	* @param factId the primary key of the fact gift received
	* @return the fact gift received
	* @throws PortalException if a fact gift received with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactGiftReceived getFactGiftReceived(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.getFactGiftReceived(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact gift receiveds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactGiftReceivedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact gift receiveds
	* @param end the upper bound of the range of fact gift receiveds (not inclusive)
	* @return the range of fact gift receiveds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactGiftReceived> getFactGiftReceiveds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.getFactGiftReceiveds(start, end);
	}

	/**
	* Returns the number of fact gift receiveds.
	*
	* @return the number of fact gift receiveds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactGiftReceivedsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.getFactGiftReceivedsCount();
	}

	/**
	* Updates the fact gift received in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factGiftReceived the fact gift received
	* @return the fact gift received that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactGiftReceived updateFactGiftReceived(
		com.idetronic.eis.model.FactGiftReceived factGiftReceived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.updateFactGiftReceived(factGiftReceived);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factGiftReceivedLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factGiftReceivedLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factGiftReceivedLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactGiftReceived> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factGiftReceivedLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factGiftReceivedLocalService.batchInsert(libraryId, period, datas,
			serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactGiftReceived add(long libraryId,
		java.lang.String period, long itemId, long titleTotal,
		long volumeTotal,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.add(libraryId, period, itemId,
			titleTotal, volumeTotal, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factGiftReceivedLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactGiftReceivedLocalService getWrappedFactGiftReceivedLocalService() {
		return _factGiftReceivedLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactGiftReceivedLocalService(
		FactGiftReceivedLocalService factGiftReceivedLocalService) {
		_factGiftReceivedLocalService = factGiftReceivedLocalService;
	}

	@Override
	public FactGiftReceivedLocalService getWrappedService() {
		return _factGiftReceivedLocalService;
	}

	@Override
	public void setWrappedService(
		FactGiftReceivedLocalService factGiftReceivedLocalService) {
		_factGiftReceivedLocalService = factGiftReceivedLocalService;
	}

	private FactGiftReceivedLocalService _factGiftReceivedLocalService;
}
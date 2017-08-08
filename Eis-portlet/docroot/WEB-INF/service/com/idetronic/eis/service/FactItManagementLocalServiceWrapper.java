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
 * Provides a wrapper for {@link FactItManagementLocalService}.
 *
 * @author Mazlan Mat
 * @see FactItManagementLocalService
 * @generated
 */
public class FactItManagementLocalServiceWrapper
	implements FactItManagementLocalService,
		ServiceWrapper<FactItManagementLocalService> {
	public FactItManagementLocalServiceWrapper(
		FactItManagementLocalService factItManagementLocalService) {
		_factItManagementLocalService = factItManagementLocalService;
	}

	/**
	* Adds the fact it management to the database. Also notifies the appropriate model listeners.
	*
	* @param factItManagement the fact it management
	* @return the fact it management that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactItManagement addFactItManagement(
		com.idetronic.eis.model.FactItManagement factItManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.addFactItManagement(factItManagement);
	}

	/**
	* Creates a new fact it management with the primary key. Does not add the fact it management to the database.
	*
	* @param factId the primary key for the new fact it management
	* @return the new fact it management
	*/
	@Override
	public com.idetronic.eis.model.FactItManagement createFactItManagement(
		long factId) {
		return _factItManagementLocalService.createFactItManagement(factId);
	}

	/**
	* Deletes the fact it management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact it management
	* @return the fact it management that was removed
	* @throws PortalException if a fact it management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactItManagement deleteFactItManagement(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.deleteFactItManagement(factId);
	}

	/**
	* Deletes the fact it management from the database. Also notifies the appropriate model listeners.
	*
	* @param factItManagement the fact it management
	* @return the fact it management that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactItManagement deleteFactItManagement(
		com.idetronic.eis.model.FactItManagement factItManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.deleteFactItManagement(factItManagement);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factItManagementLocalService.dynamicQuery();
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
		return _factItManagementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factItManagementLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factItManagementLocalService.dynamicQuery(dynamicQuery, start,
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
		return _factItManagementLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factItManagementLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactItManagement fetchFactItManagement(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.fetchFactItManagement(factId);
	}

	/**
	* Returns the fact it management with the primary key.
	*
	* @param factId the primary key of the fact it management
	* @return the fact it management
	* @throws PortalException if a fact it management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactItManagement getFactItManagement(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.getFactItManagement(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact it managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact it managements
	* @param end the upper bound of the range of fact it managements (not inclusive)
	* @return the range of fact it managements
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactItManagement> getFactItManagements(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.getFactItManagements(start, end);
	}

	/**
	* Returns the number of fact it managements.
	*
	* @return the number of fact it managements
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactItManagementsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.getFactItManagementsCount();
	}

	/**
	* Updates the fact it management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factItManagement the fact it management
	* @return the fact it management that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactItManagement updateFactItManagement(
		com.idetronic.eis.model.FactItManagement factItManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.updateFactItManagement(factItManagement);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factItManagementLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factItManagementLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factItManagementLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactItManagement> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factItManagementLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factItManagementLocalService.batchInsert(libraryId, period, datas,
			serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactItManagement add(long libraryId,
		java.lang.String period, long itemId, long total,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.add(libraryId, period, itemId,
			total, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factItManagementLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactItManagementLocalService getWrappedFactItManagementLocalService() {
		return _factItManagementLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactItManagementLocalService(
		FactItManagementLocalService factItManagementLocalService) {
		_factItManagementLocalService = factItManagementLocalService;
	}

	@Override
	public FactItManagementLocalService getWrappedService() {
		return _factItManagementLocalService;
	}

	@Override
	public void setWrappedService(
		FactItManagementLocalService factItManagementLocalService) {
		_factItManagementLocalService = factItManagementLocalService;
	}

	private FactItManagementLocalService _factItManagementLocalService;
}
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
 * Provides a wrapper for {@link FactDatabaseUsageLocalService}.
 *
 * @author Mazlan Mat
 * @see FactDatabaseUsageLocalService
 * @generated
 */
public class FactDatabaseUsageLocalServiceWrapper
	implements FactDatabaseUsageLocalService,
		ServiceWrapper<FactDatabaseUsageLocalService> {
	public FactDatabaseUsageLocalServiceWrapper(
		FactDatabaseUsageLocalService factDatabaseUsageLocalService) {
		_factDatabaseUsageLocalService = factDatabaseUsageLocalService;
	}

	/**
	* Adds the fact database usage to the database. Also notifies the appropriate model listeners.
	*
	* @param factDatabaseUsage the fact database usage
	* @return the fact database usage that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactDatabaseUsage addFactDatabaseUsage(
		com.idetronic.eis.model.FactDatabaseUsage factDatabaseUsage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.addFactDatabaseUsage(factDatabaseUsage);
	}

	/**
	* Creates a new fact database usage with the primary key. Does not add the fact database usage to the database.
	*
	* @param factId the primary key for the new fact database usage
	* @return the new fact database usage
	*/
	@Override
	public com.idetronic.eis.model.FactDatabaseUsage createFactDatabaseUsage(
		long factId) {
		return _factDatabaseUsageLocalService.createFactDatabaseUsage(factId);
	}

	/**
	* Deletes the fact database usage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact database usage
	* @return the fact database usage that was removed
	* @throws PortalException if a fact database usage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactDatabaseUsage deleteFactDatabaseUsage(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.deleteFactDatabaseUsage(factId);
	}

	/**
	* Deletes the fact database usage from the database. Also notifies the appropriate model listeners.
	*
	* @param factDatabaseUsage the fact database usage
	* @return the fact database usage that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactDatabaseUsage deleteFactDatabaseUsage(
		com.idetronic.eis.model.FactDatabaseUsage factDatabaseUsage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.deleteFactDatabaseUsage(factDatabaseUsage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factDatabaseUsageLocalService.dynamicQuery();
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
		return _factDatabaseUsageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDatabaseUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factDatabaseUsageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDatabaseUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factDatabaseUsageLocalService.dynamicQuery(dynamicQuery, start,
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
		return _factDatabaseUsageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factDatabaseUsageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactDatabaseUsage fetchFactDatabaseUsage(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.fetchFactDatabaseUsage(factId);
	}

	/**
	* Returns the fact database usage with the primary key.
	*
	* @param factId the primary key of the fact database usage
	* @return the fact database usage
	* @throws PortalException if a fact database usage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactDatabaseUsage getFactDatabaseUsage(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.getFactDatabaseUsage(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact database usages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDatabaseUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact database usages
	* @param end the upper bound of the range of fact database usages (not inclusive)
	* @return the range of fact database usages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactDatabaseUsage> getFactDatabaseUsages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.getFactDatabaseUsages(start, end);
	}

	/**
	* Returns the number of fact database usages.
	*
	* @return the number of fact database usages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactDatabaseUsagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.getFactDatabaseUsagesCount();
	}

	/**
	* Updates the fact database usage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factDatabaseUsage the fact database usage
	* @return the fact database usage that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactDatabaseUsage updateFactDatabaseUsage(
		com.idetronic.eis.model.FactDatabaseUsage factDatabaseUsage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.updateFactDatabaseUsage(factDatabaseUsage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factDatabaseUsageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factDatabaseUsageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factDatabaseUsageLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factDatabaseUsageLocalService.batchInsert(libraryId, period, datas,
			serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactDatabaseUsage add(long libraryId,
		java.lang.String period, long itemId, long download, long session,
		long search, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDatabaseUsageLocalService.add(libraryId, period, itemId,
			download, session, search, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactDatabaseUsage> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factDatabaseUsageLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period) {
		return _factDatabaseUsageLocalService.getEntries(libraryId, period);
	}

	@Override
	public boolean isMissingData(long libraryId, java.lang.String period) {
		return _factDatabaseUsageLocalService.isMissingData(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactDatabaseUsageLocalService getWrappedFactDatabaseUsageLocalService() {
		return _factDatabaseUsageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactDatabaseUsageLocalService(
		FactDatabaseUsageLocalService factDatabaseUsageLocalService) {
		_factDatabaseUsageLocalService = factDatabaseUsageLocalService;
	}

	@Override
	public FactDatabaseUsageLocalService getWrappedService() {
		return _factDatabaseUsageLocalService;
	}

	@Override
	public void setWrappedService(
		FactDatabaseUsageLocalService factDatabaseUsageLocalService) {
		_factDatabaseUsageLocalService = factDatabaseUsageLocalService;
	}

	private FactDatabaseUsageLocalService _factDatabaseUsageLocalService;
}
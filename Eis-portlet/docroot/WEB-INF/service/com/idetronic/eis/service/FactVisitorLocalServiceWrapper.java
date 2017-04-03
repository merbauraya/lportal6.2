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
 * Provides a wrapper for {@link FactVisitorLocalService}.
 *
 * @author Mazlan Mat
 * @see FactVisitorLocalService
 * @generated
 */
public class FactVisitorLocalServiceWrapper implements FactVisitorLocalService,
	ServiceWrapper<FactVisitorLocalService> {
	public FactVisitorLocalServiceWrapper(
		FactVisitorLocalService factVisitorLocalService) {
		_factVisitorLocalService = factVisitorLocalService;
	}

	/**
	* Adds the fact visitor to the database. Also notifies the appropriate model listeners.
	*
	* @param factVisitor the fact visitor
	* @return the fact visitor that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactVisitor addFactVisitor(
		com.idetronic.eis.model.FactVisitor factVisitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.addFactVisitor(factVisitor);
	}

	/**
	* Creates a new fact visitor with the primary key. Does not add the fact visitor to the database.
	*
	* @param factVisitorId the primary key for the new fact visitor
	* @return the new fact visitor
	*/
	@Override
	public com.idetronic.eis.model.FactVisitor createFactVisitor(
		long factVisitorId) {
		return _factVisitorLocalService.createFactVisitor(factVisitorId);
	}

	/**
	* Deletes the fact visitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factVisitorId the primary key of the fact visitor
	* @return the fact visitor that was removed
	* @throws PortalException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactVisitor deleteFactVisitor(
		long factVisitorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.deleteFactVisitor(factVisitorId);
	}

	/**
	* Deletes the fact visitor from the database. Also notifies the appropriate model listeners.
	*
	* @param factVisitor the fact visitor
	* @return the fact visitor that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactVisitor deleteFactVisitor(
		com.idetronic.eis.model.FactVisitor factVisitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.deleteFactVisitor(factVisitor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factVisitorLocalService.dynamicQuery();
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
		return _factVisitorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factVisitorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factVisitorLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _factVisitorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factVisitorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactVisitor fetchFactVisitor(
		long factVisitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.fetchFactVisitor(factVisitorId);
	}

	/**
	* Returns the fact visitor with the primary key.
	*
	* @param factVisitorId the primary key of the fact visitor
	* @return the fact visitor
	* @throws PortalException if a fact visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactVisitor getFactVisitor(
		long factVisitorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.getFactVisitor(factVisitorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact visitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact visitors
	* @param end the upper bound of the range of fact visitors (not inclusive)
	* @return the range of fact visitors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactVisitor> getFactVisitors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.getFactVisitors(start, end);
	}

	/**
	* Returns the number of fact visitors.
	*
	* @return the number of fact visitors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactVisitorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.getFactVisitorsCount();
	}

	/**
	* Updates the fact visitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factVisitor the fact visitor
	* @return the fact visitor that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactVisitor updateFactVisitor(
		com.idetronic.eis.model.FactVisitor factVisitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.updateFactVisitor(factVisitor);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factVisitorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factVisitorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factVisitorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.FactVisitor add(long libraryId,
		java.lang.String period, long visitorCategoryId, int value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.add(libraryId, period,
			visitorCategoryId, value, serviceContext);
	}

	@Override
	public void bacthInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factVisitorLocalService.bacthInsert(libraryId, period, datas,
			serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactVisitor> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factVisitorLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factVisitorLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactVisitorLocalService getWrappedFactVisitorLocalService() {
		return _factVisitorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactVisitorLocalService(
		FactVisitorLocalService factVisitorLocalService) {
		_factVisitorLocalService = factVisitorLocalService;
	}

	@Override
	public FactVisitorLocalService getWrappedService() {
		return _factVisitorLocalService;
	}

	@Override
	public void setWrappedService(
		FactVisitorLocalService factVisitorLocalService) {
		_factVisitorLocalService = factVisitorLocalService;
	}

	private FactVisitorLocalService _factVisitorLocalService;
}
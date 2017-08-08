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
 * Provides a wrapper for {@link FactDataLocalService}.
 *
 * @author Mazlan Mat
 * @see FactDataLocalService
 * @generated
 */
public class FactDataLocalServiceWrapper implements FactDataLocalService,
	ServiceWrapper<FactDataLocalService> {
	public FactDataLocalServiceWrapper(
		FactDataLocalService factDataLocalService) {
		_factDataLocalService = factDataLocalService;
	}

	/**
	* Adds the fact data to the database. Also notifies the appropriate model listeners.
	*
	* @param factData the fact data
	* @return the fact data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactData addFactData(
		com.idetronic.eis.model.FactData factData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.addFactData(factData);
	}

	/**
	* Creates a new fact data with the primary key. Does not add the fact data to the database.
	*
	* @param factId the primary key for the new fact data
	* @return the new fact data
	*/
	@Override
	public com.idetronic.eis.model.FactData createFactData(long factId) {
		return _factDataLocalService.createFactData(factId);
	}

	/**
	* Deletes the fact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact data
	* @return the fact data that was removed
	* @throws PortalException if a fact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactData deleteFactData(long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.deleteFactData(factId);
	}

	/**
	* Deletes the fact data from the database. Also notifies the appropriate model listeners.
	*
	* @param factData the fact data
	* @return the fact data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactData deleteFactData(
		com.idetronic.eis.model.FactData factData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.deleteFactData(factData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factDataLocalService.dynamicQuery();
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
		return _factDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _factDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factDataLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.eis.model.FactData fetchFactData(long factId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.fetchFactData(factId);
	}

	/**
	* Returns the fact data with the primary key.
	*
	* @param factId the primary key of the fact data
	* @return the fact data
	* @throws PortalException if a fact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactData getFactData(long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.getFactData(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact datas
	* @param end the upper bound of the range of fact datas (not inclusive)
	* @return the range of fact datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactData> getFactDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.getFactDatas(start, end);
	}

	/**
	* Returns the number of fact datas.
	*
	* @return the number of fact datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.getFactDatasCount();
	}

	/**
	* Updates the fact data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factData the fact data
	* @return the fact data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactData updateFactData(
		com.idetronic.eis.model.FactData factData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.updateFactData(factData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactData> getLatestEntry(
		long reportId, long libraryId, java.lang.String period) {
		return _factDataLocalService.getLatestEntry(reportId, libraryId, period);
	}

	@Override
	public void batchInsert(long reportId, long libraryId,
		java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factDataLocalService.batchInsert(reportId, libraryId, period, datas,
			serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactData add(long reportId, long libraryId,
		java.lang.String period, long dimensionId, double measure1,
		double measure2, double measure3, double measure4,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.add(reportId, libraryId, period,
			dimensionId, measure1, measure2, measure3, measure4, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long reportId,
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factDataLocalService.getEntries(reportId, libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactDataLocalService getWrappedFactDataLocalService() {
		return _factDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactDataLocalService(
		FactDataLocalService factDataLocalService) {
		_factDataLocalService = factDataLocalService;
	}

	@Override
	public FactDataLocalService getWrappedService() {
		return _factDataLocalService;
	}

	@Override
	public void setWrappedService(FactDataLocalService factDataLocalService) {
		_factDataLocalService = factDataLocalService;
	}

	private FactDataLocalService _factDataLocalService;
}
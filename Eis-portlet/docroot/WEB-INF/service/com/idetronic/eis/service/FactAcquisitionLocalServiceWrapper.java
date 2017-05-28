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
 * Provides a wrapper for {@link FactAcquisitionLocalService}.
 *
 * @author Mazlan Mat
 * @see FactAcquisitionLocalService
 * @generated
 */
public class FactAcquisitionLocalServiceWrapper
	implements FactAcquisitionLocalService,
		ServiceWrapper<FactAcquisitionLocalService> {
	public FactAcquisitionLocalServiceWrapper(
		FactAcquisitionLocalService factAcquisitionLocalService) {
		_factAcquisitionLocalService = factAcquisitionLocalService;
	}

	/**
	* Adds the fact acquisition to the database. Also notifies the appropriate model listeners.
	*
	* @param factAcquisition the fact acquisition
	* @return the fact acquisition that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactAcquisition addFactAcquisition(
		com.idetronic.eis.model.FactAcquisition factAcquisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.addFactAcquisition(factAcquisition);
	}

	/**
	* Creates a new fact acquisition with the primary key. Does not add the fact acquisition to the database.
	*
	* @param factAcquisitionId the primary key for the new fact acquisition
	* @return the new fact acquisition
	*/
	@Override
	public com.idetronic.eis.model.FactAcquisition createFactAcquisition(
		long factAcquisitionId) {
		return _factAcquisitionLocalService.createFactAcquisition(factAcquisitionId);
	}

	/**
	* Deletes the fact acquisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factAcquisitionId the primary key of the fact acquisition
	* @return the fact acquisition that was removed
	* @throws PortalException if a fact acquisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactAcquisition deleteFactAcquisition(
		long factAcquisitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.deleteFactAcquisition(factAcquisitionId);
	}

	/**
	* Deletes the fact acquisition from the database. Also notifies the appropriate model listeners.
	*
	* @param factAcquisition the fact acquisition
	* @return the fact acquisition that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactAcquisition deleteFactAcquisition(
		com.idetronic.eis.model.FactAcquisition factAcquisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.deleteFactAcquisition(factAcquisition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factAcquisitionLocalService.dynamicQuery();
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
		return _factAcquisitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factAcquisitionLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factAcquisitionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _factAcquisitionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factAcquisitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactAcquisition fetchFactAcquisition(
		long factAcquisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.fetchFactAcquisition(factAcquisitionId);
	}

	/**
	* Returns the fact acquisition with the primary key.
	*
	* @param factAcquisitionId the primary key of the fact acquisition
	* @return the fact acquisition
	* @throws PortalException if a fact acquisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactAcquisition getFactAcquisition(
		long factAcquisitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.getFactAcquisition(factAcquisitionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact acquisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact acquisitions
	* @param end the upper bound of the range of fact acquisitions (not inclusive)
	* @return the range of fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactAcquisition> getFactAcquisitions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.getFactAcquisitions(start, end);
	}

	/**
	* Returns the number of fact acquisitions.
	*
	* @return the number of fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactAcquisitionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.getFactAcquisitionsCount();
	}

	/**
	* Updates the fact acquisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factAcquisition the fact acquisition
	* @return the fact acquisition that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactAcquisition updateFactAcquisition(
		com.idetronic.eis.model.FactAcquisition factAcquisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.updateFactAcquisition(factAcquisition);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factAcquisitionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factAcquisitionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factAcquisitionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.FactAcquisition add(long facultyId,
		java.lang.String period, long itemId, int titleTotal, int volumeTotal,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.add(facultyId, period, itemId,
			titleTotal, volumeTotal, serviceContext);
	}

	@Override
	public void batchInsert(long facultyId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factAcquisitionLocalService.batchInsert(facultyId, period, datas,
			serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactAcquisition> getLatestEntry(
		long facultyId, java.lang.String period) {
		return _factAcquisitionLocalService.getLatestEntry(facultyId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long facultyId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factAcquisitionLocalService.getEntries(facultyId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactAcquisitionLocalService getWrappedFactAcquisitionLocalService() {
		return _factAcquisitionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactAcquisitionLocalService(
		FactAcquisitionLocalService factAcquisitionLocalService) {
		_factAcquisitionLocalService = factAcquisitionLocalService;
	}

	@Override
	public FactAcquisitionLocalService getWrappedService() {
		return _factAcquisitionLocalService;
	}

	@Override
	public void setWrappedService(
		FactAcquisitionLocalService factAcquisitionLocalService) {
		_factAcquisitionLocalService = factAcquisitionLocalService;
	}

	private FactAcquisitionLocalService _factAcquisitionLocalService;
}
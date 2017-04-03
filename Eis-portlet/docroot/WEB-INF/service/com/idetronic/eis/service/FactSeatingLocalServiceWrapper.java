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
 * Provides a wrapper for {@link FactSeatingLocalService}.
 *
 * @author Mazlan Mat
 * @see FactSeatingLocalService
 * @generated
 */
public class FactSeatingLocalServiceWrapper implements FactSeatingLocalService,
	ServiceWrapper<FactSeatingLocalService> {
	public FactSeatingLocalServiceWrapper(
		FactSeatingLocalService factSeatingLocalService) {
		_factSeatingLocalService = factSeatingLocalService;
	}

	/**
	* Adds the fact seating to the database. Also notifies the appropriate model listeners.
	*
	* @param factSeating the fact seating
	* @return the fact seating that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactSeating addFactSeating(
		com.idetronic.eis.model.FactSeating factSeating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.addFactSeating(factSeating);
	}

	/**
	* Creates a new fact seating with the primary key. Does not add the fact seating to the database.
	*
	* @param factSeatingId the primary key for the new fact seating
	* @return the new fact seating
	*/
	@Override
	public com.idetronic.eis.model.FactSeating createFactSeating(
		long factSeatingId) {
		return _factSeatingLocalService.createFactSeating(factSeatingId);
	}

	/**
	* Deletes the fact seating with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factSeatingId the primary key of the fact seating
	* @return the fact seating that was removed
	* @throws PortalException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactSeating deleteFactSeating(
		long factSeatingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.deleteFactSeating(factSeatingId);
	}

	/**
	* Deletes the fact seating from the database. Also notifies the appropriate model listeners.
	*
	* @param factSeating the fact seating
	* @return the fact seating that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactSeating deleteFactSeating(
		com.idetronic.eis.model.FactSeating factSeating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.deleteFactSeating(factSeating);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factSeatingLocalService.dynamicQuery();
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
		return _factSeatingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factSeatingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factSeatingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _factSeatingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factSeatingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactSeating fetchFactSeating(
		long factSeatingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.fetchFactSeating(factSeatingId);
	}

	/**
	* Returns the fact seating with the primary key.
	*
	* @param factSeatingId the primary key of the fact seating
	* @return the fact seating
	* @throws PortalException if a fact seating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactSeating getFactSeating(
		long factSeatingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.getFactSeating(factSeatingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact seatings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact seatings
	* @param end the upper bound of the range of fact seatings (not inclusive)
	* @return the range of fact seatings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactSeating> getFactSeatings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.getFactSeatings(start, end);
	}

	/**
	* Returns the number of fact seatings.
	*
	* @return the number of fact seatings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactSeatingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.getFactSeatingsCount();
	}

	/**
	* Updates the fact seating in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factSeating the fact seating
	* @return the fact seating that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactSeating updateFactSeating(
		com.idetronic.eis.model.FactSeating factSeating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.updateFactSeating(factSeating);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factSeatingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factSeatingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factSeatingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.FactSeating add(long libraryId,
		long departmentId, long seatingCategoryId, java.lang.String period,
		int capacity, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.add(libraryId, departmentId,
			seatingCategoryId, period, capacity, serviceContext);
	}

	@Override
	public void bacthInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factSeatingLocalService.bacthInsert(libraryId, period, datas,
			serviceContext);
	}

	/**
	* @param libraryId
	* @param period
	* @return
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactSeating> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factSeatingLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factSeatingLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactSeatingLocalService getWrappedFactSeatingLocalService() {
		return _factSeatingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactSeatingLocalService(
		FactSeatingLocalService factSeatingLocalService) {
		_factSeatingLocalService = factSeatingLocalService;
	}

	@Override
	public FactSeatingLocalService getWrappedService() {
		return _factSeatingLocalService;
	}

	@Override
	public void setWrappedService(
		FactSeatingLocalService factSeatingLocalService) {
		_factSeatingLocalService = factSeatingLocalService;
	}

	private FactSeatingLocalService _factSeatingLocalService;
}
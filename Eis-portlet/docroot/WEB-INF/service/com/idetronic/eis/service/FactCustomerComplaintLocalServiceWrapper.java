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
 * Provides a wrapper for {@link FactCustomerComplaintLocalService}.
 *
 * @author Mazlan Mat
 * @see FactCustomerComplaintLocalService
 * @generated
 */
public class FactCustomerComplaintLocalServiceWrapper
	implements FactCustomerComplaintLocalService,
		ServiceWrapper<FactCustomerComplaintLocalService> {
	public FactCustomerComplaintLocalServiceWrapper(
		FactCustomerComplaintLocalService factCustomerComplaintLocalService) {
		_factCustomerComplaintLocalService = factCustomerComplaintLocalService;
	}

	/**
	* Adds the fact customer complaint to the database. Also notifies the appropriate model listeners.
	*
	* @param factCustomerComplaint the fact customer complaint
	* @return the fact customer complaint that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactCustomerComplaint addFactCustomerComplaint(
		com.idetronic.eis.model.FactCustomerComplaint factCustomerComplaint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.addFactCustomerComplaint(factCustomerComplaint);
	}

	/**
	* Creates a new fact customer complaint with the primary key. Does not add the fact customer complaint to the database.
	*
	* @param factId the primary key for the new fact customer complaint
	* @return the new fact customer complaint
	*/
	@Override
	public com.idetronic.eis.model.FactCustomerComplaint createFactCustomerComplaint(
		long factId) {
		return _factCustomerComplaintLocalService.createFactCustomerComplaint(factId);
	}

	/**
	* Deletes the fact customer complaint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact customer complaint
	* @return the fact customer complaint that was removed
	* @throws PortalException if a fact customer complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactCustomerComplaint deleteFactCustomerComplaint(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.deleteFactCustomerComplaint(factId);
	}

	/**
	* Deletes the fact customer complaint from the database. Also notifies the appropriate model listeners.
	*
	* @param factCustomerComplaint the fact customer complaint
	* @return the fact customer complaint that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactCustomerComplaint deleteFactCustomerComplaint(
		com.idetronic.eis.model.FactCustomerComplaint factCustomerComplaint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.deleteFactCustomerComplaint(factCustomerComplaint);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factCustomerComplaintLocalService.dynamicQuery();
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
		return _factCustomerComplaintLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactCustomerComplaintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factCustomerComplaintLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactCustomerComplaintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factCustomerComplaintLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _factCustomerComplaintLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factCustomerComplaintLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactCustomerComplaint fetchFactCustomerComplaint(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.fetchFactCustomerComplaint(factId);
	}

	/**
	* Returns the fact customer complaint with the primary key.
	*
	* @param factId the primary key of the fact customer complaint
	* @return the fact customer complaint
	* @throws PortalException if a fact customer complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactCustomerComplaint getFactCustomerComplaint(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.getFactCustomerComplaint(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact customer complaints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactCustomerComplaintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact customer complaints
	* @param end the upper bound of the range of fact customer complaints (not inclusive)
	* @return the range of fact customer complaints
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactCustomerComplaint> getFactCustomerComplaints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.getFactCustomerComplaints(start,
			end);
	}

	/**
	* Returns the number of fact customer complaints.
	*
	* @return the number of fact customer complaints
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactCustomerComplaintsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.getFactCustomerComplaintsCount();
	}

	/**
	* Updates the fact customer complaint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factCustomerComplaint the fact customer complaint
	* @return the fact customer complaint that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactCustomerComplaint updateFactCustomerComplaint(
		com.idetronic.eis.model.FactCustomerComplaint factCustomerComplaint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factCustomerComplaintLocalService.updateFactCustomerComplaint(factCustomerComplaint);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factCustomerComplaintLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factCustomerComplaintLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factCustomerComplaintLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactCustomerComplaintLocalService getWrappedFactCustomerComplaintLocalService() {
		return _factCustomerComplaintLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactCustomerComplaintLocalService(
		FactCustomerComplaintLocalService factCustomerComplaintLocalService) {
		_factCustomerComplaintLocalService = factCustomerComplaintLocalService;
	}

	@Override
	public FactCustomerComplaintLocalService getWrappedService() {
		return _factCustomerComplaintLocalService;
	}

	@Override
	public void setWrappedService(
		FactCustomerComplaintLocalService factCustomerComplaintLocalService) {
		_factCustomerComplaintLocalService = factCustomerComplaintLocalService;
	}

	private FactCustomerComplaintLocalService _factCustomerComplaintLocalService;
}
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
 * Provides a wrapper for {@link FactConsultationLocalService}.
 *
 * @author Mazlan Mat
 * @see FactConsultationLocalService
 * @generated
 */
public class FactConsultationLocalServiceWrapper
	implements FactConsultationLocalService,
		ServiceWrapper<FactConsultationLocalService> {
	public FactConsultationLocalServiceWrapper(
		FactConsultationLocalService factConsultationLocalService) {
		_factConsultationLocalService = factConsultationLocalService;
	}

	/**
	* Adds the fact consultation to the database. Also notifies the appropriate model listeners.
	*
	* @param factConsultation the fact consultation
	* @return the fact consultation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactConsultation addFactConsultation(
		com.idetronic.eis.model.FactConsultation factConsultation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.addFactConsultation(factConsultation);
	}

	/**
	* Creates a new fact consultation with the primary key. Does not add the fact consultation to the database.
	*
	* @param factConsultationId the primary key for the new fact consultation
	* @return the new fact consultation
	*/
	@Override
	public com.idetronic.eis.model.FactConsultation createFactConsultation(
		long factConsultationId) {
		return _factConsultationLocalService.createFactConsultation(factConsultationId);
	}

	/**
	* Deletes the fact consultation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factConsultationId the primary key of the fact consultation
	* @return the fact consultation that was removed
	* @throws PortalException if a fact consultation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactConsultation deleteFactConsultation(
		long factConsultationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.deleteFactConsultation(factConsultationId);
	}

	/**
	* Deletes the fact consultation from the database. Also notifies the appropriate model listeners.
	*
	* @param factConsultation the fact consultation
	* @return the fact consultation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactConsultation deleteFactConsultation(
		com.idetronic.eis.model.FactConsultation factConsultation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.deleteFactConsultation(factConsultation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factConsultationLocalService.dynamicQuery();
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
		return _factConsultationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factConsultationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factConsultationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _factConsultationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factConsultationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactConsultation fetchFactConsultation(
		long factConsultationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.fetchFactConsultation(factConsultationId);
	}

	/**
	* Returns the fact consultation with the primary key.
	*
	* @param factConsultationId the primary key of the fact consultation
	* @return the fact consultation
	* @throws PortalException if a fact consultation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactConsultation getFactConsultation(
		long factConsultationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.getFactConsultation(factConsultationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact consultations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact consultations
	* @param end the upper bound of the range of fact consultations (not inclusive)
	* @return the range of fact consultations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactConsultation> getFactConsultations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.getFactConsultations(start, end);
	}

	/**
	* Returns the number of fact consultations.
	*
	* @return the number of fact consultations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactConsultationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.getFactConsultationsCount();
	}

	/**
	* Updates the fact consultation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factConsultation the fact consultation
	* @return the fact consultation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactConsultation updateFactConsultation(
		com.idetronic.eis.model.FactConsultation factConsultation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.updateFactConsultation(factConsultation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factConsultationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factConsultationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factConsultationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray consultationCategoryIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factConsultationLocalService.batchInsert(libraryId, period,
			consultationCategoryIds, serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactConsultation add(long libraryId,
		java.lang.String period, long categoryId, long value,
		long totalSession,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factConsultationLocalService.add(libraryId, period, categoryId,
			value, totalSession, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactConsultation> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factConsultationLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period) {
		return _factConsultationLocalService.getEntries(libraryId, period);
	}

	@Override
	public boolean isMissingData(long libraryId, java.lang.String period) {
		return _factConsultationLocalService.isMissingData(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactConsultationLocalService getWrappedFactConsultationLocalService() {
		return _factConsultationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactConsultationLocalService(
		FactConsultationLocalService factConsultationLocalService) {
		_factConsultationLocalService = factConsultationLocalService;
	}

	@Override
	public FactConsultationLocalService getWrappedService() {
		return _factConsultationLocalService;
	}

	@Override
	public void setWrappedService(
		FactConsultationLocalService factConsultationLocalService) {
		_factConsultationLocalService = factConsultationLocalService;
	}

	private FactConsultationLocalService _factConsultationLocalService;
}
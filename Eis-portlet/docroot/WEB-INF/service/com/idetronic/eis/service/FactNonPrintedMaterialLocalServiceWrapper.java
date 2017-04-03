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
 * Provides a wrapper for {@link FactNonPrintedMaterialLocalService}.
 *
 * @author Mazlan Mat
 * @see FactNonPrintedMaterialLocalService
 * @generated
 */
public class FactNonPrintedMaterialLocalServiceWrapper
	implements FactNonPrintedMaterialLocalService,
		ServiceWrapper<FactNonPrintedMaterialLocalService> {
	public FactNonPrintedMaterialLocalServiceWrapper(
		FactNonPrintedMaterialLocalService factNonPrintedMaterialLocalService) {
		_factNonPrintedMaterialLocalService = factNonPrintedMaterialLocalService;
	}

	/**
	* Adds the fact non printed material to the database. Also notifies the appropriate model listeners.
	*
	* @param factNonPrintedMaterial the fact non printed material
	* @return the fact non printed material that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial addFactNonPrintedMaterial(
		com.idetronic.eis.model.FactNonPrintedMaterial factNonPrintedMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.addFactNonPrintedMaterial(factNonPrintedMaterial);
	}

	/**
	* Creates a new fact non printed material with the primary key. Does not add the fact non printed material to the database.
	*
	* @param factNonPrintedMaterialId the primary key for the new fact non printed material
	* @return the new fact non printed material
	*/
	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial createFactNonPrintedMaterial(
		long factNonPrintedMaterialId) {
		return _factNonPrintedMaterialLocalService.createFactNonPrintedMaterial(factNonPrintedMaterialId);
	}

	/**
	* Deletes the fact non printed material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factNonPrintedMaterialId the primary key of the fact non printed material
	* @return the fact non printed material that was removed
	* @throws PortalException if a fact non printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial deleteFactNonPrintedMaterial(
		long factNonPrintedMaterialId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.deleteFactNonPrintedMaterial(factNonPrintedMaterialId);
	}

	/**
	* Deletes the fact non printed material from the database. Also notifies the appropriate model listeners.
	*
	* @param factNonPrintedMaterial the fact non printed material
	* @return the fact non printed material that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial deleteFactNonPrintedMaterial(
		com.idetronic.eis.model.FactNonPrintedMaterial factNonPrintedMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.deleteFactNonPrintedMaterial(factNonPrintedMaterial);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factNonPrintedMaterialLocalService.dynamicQuery();
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
		return _factNonPrintedMaterialLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factNonPrintedMaterialLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factNonPrintedMaterialLocalService.dynamicQuery(dynamicQuery,
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
		return _factNonPrintedMaterialLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factNonPrintedMaterialLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial fetchFactNonPrintedMaterial(
		long factNonPrintedMaterialId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.fetchFactNonPrintedMaterial(factNonPrintedMaterialId);
	}

	/**
	* Returns the fact non printed material with the primary key.
	*
	* @param factNonPrintedMaterialId the primary key of the fact non printed material
	* @return the fact non printed material
	* @throws PortalException if a fact non printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial getFactNonPrintedMaterial(
		long factNonPrintedMaterialId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.getFactNonPrintedMaterial(factNonPrintedMaterialId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact non printed materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact non printed materials
	* @param end the upper bound of the range of fact non printed materials (not inclusive)
	* @return the range of fact non printed materials
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactNonPrintedMaterial> getFactNonPrintedMaterials(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.getFactNonPrintedMaterials(start,
			end);
	}

	/**
	* Returns the number of fact non printed materials.
	*
	* @return the number of fact non printed materials
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactNonPrintedMaterialsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.getFactNonPrintedMaterialsCount();
	}

	/**
	* Updates the fact non printed material in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factNonPrintedMaterial the fact non printed material
	* @return the fact non printed material that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial updateFactNonPrintedMaterial(
		com.idetronic.eis.model.FactNonPrintedMaterial factNonPrintedMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.updateFactNonPrintedMaterial(factNonPrintedMaterial);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factNonPrintedMaterialLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factNonPrintedMaterialLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factNonPrintedMaterialLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray jsonArray,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_factNonPrintedMaterialLocalService.batchInsert(libraryId, period,
			jsonArray, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactNonPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.findByLibraryPeriod(libraryId,
			period, start, end);
	}

	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial add(long libraryId,
		java.lang.String period, long itemTypeId, int titleTotal,
		int volumeTotal,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.add(libraryId, period,
			itemTypeId, titleTotal, volumeTotal, serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactNonPrintedMaterial getItemLatestEntry(
		long libraryId, java.lang.String period, long itemTypeId) {
		return _factNonPrintedMaterialLocalService.getItemLatestEntry(libraryId,
			period, itemTypeId);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactNonPrintedMaterial> getAllItemLatestEntry(
		long libraryId, java.lang.String period) {
		return _factNonPrintedMaterialLocalService.getAllItemLatestEntry(libraryId,
			period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factNonPrintedMaterialLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactNonPrintedMaterialLocalService getWrappedFactNonPrintedMaterialLocalService() {
		return _factNonPrintedMaterialLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactNonPrintedMaterialLocalService(
		FactNonPrintedMaterialLocalService factNonPrintedMaterialLocalService) {
		_factNonPrintedMaterialLocalService = factNonPrintedMaterialLocalService;
	}

	@Override
	public FactNonPrintedMaterialLocalService getWrappedService() {
		return _factNonPrintedMaterialLocalService;
	}

	@Override
	public void setWrappedService(
		FactNonPrintedMaterialLocalService factNonPrintedMaterialLocalService) {
		_factNonPrintedMaterialLocalService = factNonPrintedMaterialLocalService;
	}

	private FactNonPrintedMaterialLocalService _factNonPrintedMaterialLocalService;
}
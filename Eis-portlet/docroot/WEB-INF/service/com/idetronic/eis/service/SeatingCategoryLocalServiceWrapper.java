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
 * Provides a wrapper for {@link SeatingCategoryLocalService}.
 *
 * @author Mazlan Mat
 * @see SeatingCategoryLocalService
 * @generated
 */
public class SeatingCategoryLocalServiceWrapper
	implements SeatingCategoryLocalService,
		ServiceWrapper<SeatingCategoryLocalService> {
	public SeatingCategoryLocalServiceWrapper(
		SeatingCategoryLocalService seatingCategoryLocalService) {
		_seatingCategoryLocalService = seatingCategoryLocalService;
	}

	/**
	* Adds the seating category to the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategory the seating category
	* @return the seating category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingCategory addSeatingCategory(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.addSeatingCategory(seatingCategory);
	}

	/**
	* Creates a new seating category with the primary key. Does not add the seating category to the database.
	*
	* @param seatingCategoryId the primary key for the new seating category
	* @return the new seating category
	*/
	@Override
	public com.idetronic.eis.model.SeatingCategory createSeatingCategory(
		long seatingCategoryId) {
		return _seatingCategoryLocalService.createSeatingCategory(seatingCategoryId);
	}

	/**
	* Deletes the seating category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category that was removed
	* @throws PortalException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingCategory deleteSeatingCategory(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.deleteSeatingCategory(seatingCategoryId);
	}

	/**
	* Deletes the seating category from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategory the seating category
	* @return the seating category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingCategory deleteSeatingCategory(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.deleteSeatingCategory(seatingCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _seatingCategoryLocalService.dynamicQuery();
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
		return _seatingCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _seatingCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _seatingCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _seatingCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _seatingCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.SeatingCategory fetchSeatingCategory(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.fetchSeatingCategory(seatingCategoryId);
	}

	/**
	* Returns the seating category with the primary key.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category
	* @throws PortalException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingCategory getSeatingCategory(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.getSeatingCategory(seatingCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the seating categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @return the range of seating categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.SeatingCategory> getSeatingCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.getSeatingCategories(start, end);
	}

	/**
	* Returns the number of seating categories.
	*
	* @return the number of seating categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSeatingCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.getSeatingCategoriesCount();
	}

	/**
	* Updates the seating category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param seatingCategory the seating category
	* @return the seating category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.SeatingCategory updateSeatingCategory(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.updateSeatingCategory(seatingCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _seatingCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_seatingCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _seatingCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.SeatingCategory add(long departmentId,
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatingCategoryLocalService.add(departmentId, name,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SeatingCategoryLocalService getWrappedSeatingCategoryLocalService() {
		return _seatingCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSeatingCategoryLocalService(
		SeatingCategoryLocalService seatingCategoryLocalService) {
		_seatingCategoryLocalService = seatingCategoryLocalService;
	}

	@Override
	public SeatingCategoryLocalService getWrappedService() {
		return _seatingCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		SeatingCategoryLocalService seatingCategoryLocalService) {
		_seatingCategoryLocalService = seatingCategoryLocalService;
	}

	private SeatingCategoryLocalService _seatingCategoryLocalService;
}
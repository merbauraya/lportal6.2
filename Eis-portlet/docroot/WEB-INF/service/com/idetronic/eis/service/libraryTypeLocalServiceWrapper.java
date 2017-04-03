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
 * Provides a wrapper for {@link libraryTypeLocalService}.
 *
 * @author Mazlan Mat
 * @see libraryTypeLocalService
 * @generated
 */
public class libraryTypeLocalServiceWrapper implements libraryTypeLocalService,
	ServiceWrapper<libraryTypeLocalService> {
	public libraryTypeLocalServiceWrapper(
		libraryTypeLocalService libraryTypeLocalService) {
		_libraryTypeLocalService = libraryTypeLocalService;
	}

	/**
	* Adds the library type to the database. Also notifies the appropriate model listeners.
	*
	* @param libraryType the library type
	* @return the library type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.libraryType addlibraryType(
		com.idetronic.eis.model.libraryType libraryType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.addlibraryType(libraryType);
	}

	/**
	* Creates a new library type with the primary key. Does not add the library type to the database.
	*
	* @param libraryTypeId the primary key for the new library type
	* @return the new library type
	*/
	@Override
	public com.idetronic.eis.model.libraryType createlibraryType(
		long libraryTypeId) {
		return _libraryTypeLocalService.createlibraryType(libraryTypeId);
	}

	/**
	* Deletes the library type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type that was removed
	* @throws PortalException if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.libraryType deletelibraryType(
		long libraryTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.deletelibraryType(libraryTypeId);
	}

	/**
	* Deletes the library type from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryType the library type
	* @return the library type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.libraryType deletelibraryType(
		com.idetronic.eis.model.libraryType libraryType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.deletelibraryType(libraryType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _libraryTypeLocalService.dynamicQuery();
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
		return _libraryTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.libraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _libraryTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.libraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _libraryTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _libraryTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _libraryTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.libraryType fetchlibraryType(
		long libraryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.fetchlibraryType(libraryTypeId);
	}

	/**
	* Returns the library type with the primary key.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type
	* @throws PortalException if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.libraryType getlibraryType(
		long libraryTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.getlibraryType(libraryTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the library types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.libraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library types
	* @param end the upper bound of the range of library types (not inclusive)
	* @return the range of library types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.libraryType> getlibraryTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.getlibraryTypes(start, end);
	}

	/**
	* Returns the number of library types.
	*
	* @return the number of library types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getlibraryTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.getlibraryTypesCount();
	}

	/**
	* Updates the library type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param libraryType the library type
	* @return the library type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.libraryType updatelibraryType(
		com.idetronic.eis.model.libraryType libraryType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _libraryTypeLocalService.updatelibraryType(libraryType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _libraryTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_libraryTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _libraryTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public libraryTypeLocalService getWrappedlibraryTypeLocalService() {
		return _libraryTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedlibraryTypeLocalService(
		libraryTypeLocalService libraryTypeLocalService) {
		_libraryTypeLocalService = libraryTypeLocalService;
	}

	@Override
	public libraryTypeLocalService getWrappedService() {
		return _libraryTypeLocalService;
	}

	@Override
	public void setWrappedService(
		libraryTypeLocalService libraryTypeLocalService) {
		_libraryTypeLocalService = libraryTypeLocalService;
	}

	private libraryTypeLocalService _libraryTypeLocalService;
}
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
 * Provides a wrapper for {@link FacultyTypeLocalService}.
 *
 * @author Mazlan Mat
 * @see FacultyTypeLocalService
 * @generated
 */
public class FacultyTypeLocalServiceWrapper implements FacultyTypeLocalService,
	ServiceWrapper<FacultyTypeLocalService> {
	public FacultyTypeLocalServiceWrapper(
		FacultyTypeLocalService facultyTypeLocalService) {
		_facultyTypeLocalService = facultyTypeLocalService;
	}

	/**
	* Adds the faculty type to the database. Also notifies the appropriate model listeners.
	*
	* @param facultyType the faculty type
	* @return the faculty type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FacultyType addFacultyType(
		com.idetronic.eis.model.FacultyType facultyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.addFacultyType(facultyType);
	}

	/**
	* Creates a new faculty type with the primary key. Does not add the faculty type to the database.
	*
	* @param facultyTypeId the primary key for the new faculty type
	* @return the new faculty type
	*/
	@Override
	public com.idetronic.eis.model.FacultyType createFacultyType(
		long facultyTypeId) {
		return _facultyTypeLocalService.createFacultyType(facultyTypeId);
	}

	/**
	* Deletes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facultyTypeId the primary key of the faculty type
	* @return the faculty type that was removed
	* @throws PortalException if a faculty type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FacultyType deleteFacultyType(
		long facultyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.deleteFacultyType(facultyTypeId);
	}

	/**
	* Deletes the faculty type from the database. Also notifies the appropriate model listeners.
	*
	* @param facultyType the faculty type
	* @return the faculty type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FacultyType deleteFacultyType(
		com.idetronic.eis.model.FacultyType facultyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.deleteFacultyType(facultyType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyTypeLocalService.dynamicQuery();
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
		return _facultyTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _facultyTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _facultyTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _facultyTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _facultyTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FacultyType fetchFacultyType(
		long facultyTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.fetchFacultyType(facultyTypeId);
	}

	/**
	* Returns the faculty type with the primary key.
	*
	* @param facultyTypeId the primary key of the faculty type
	* @return the faculty type
	* @throws PortalException if a faculty type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FacultyType getFacultyType(
		long facultyTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.getFacultyType(facultyTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the faculty types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faculty types
	* @param end the upper bound of the range of faculty types (not inclusive)
	* @return the range of faculty types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FacultyType> getFacultyTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.getFacultyTypes(start, end);
	}

	/**
	* Returns the number of faculty types.
	*
	* @return the number of faculty types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFacultyTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.getFacultyTypesCount();
	}

	/**
	* Updates the faculty type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param facultyType the faculty type
	* @return the faculty type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FacultyType updateFacultyType(
		com.idetronic.eis.model.FacultyType facultyType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.updateFacultyType(facultyType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _facultyTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_facultyTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _facultyTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.FacultyType add(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyTypeLocalService.add(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FacultyTypeLocalService getWrappedFacultyTypeLocalService() {
		return _facultyTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFacultyTypeLocalService(
		FacultyTypeLocalService facultyTypeLocalService) {
		_facultyTypeLocalService = facultyTypeLocalService;
	}

	@Override
	public FacultyTypeLocalService getWrappedService() {
		return _facultyTypeLocalService;
	}

	@Override
	public void setWrappedService(
		FacultyTypeLocalService facultyTypeLocalService) {
		_facultyTypeLocalService = facultyTypeLocalService;
	}

	private FacultyTypeLocalService _facultyTypeLocalService;
}
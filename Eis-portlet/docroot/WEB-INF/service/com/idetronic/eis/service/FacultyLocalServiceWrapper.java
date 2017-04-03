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
 * Provides a wrapper for {@link FacultyLocalService}.
 *
 * @author Mazlan Mat
 * @see FacultyLocalService
 * @generated
 */
public class FacultyLocalServiceWrapper implements FacultyLocalService,
	ServiceWrapper<FacultyLocalService> {
	public FacultyLocalServiceWrapper(FacultyLocalService facultyLocalService) {
		_facultyLocalService = facultyLocalService;
	}

	/**
	* Adds the faculty to the database. Also notifies the appropriate model listeners.
	*
	* @param faculty the faculty
	* @return the faculty that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Faculty addFaculty(
		com.idetronic.eis.model.Faculty faculty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.addFaculty(faculty);
	}

	/**
	* Creates a new faculty with the primary key. Does not add the faculty to the database.
	*
	* @param facultyId the primary key for the new faculty
	* @return the new faculty
	*/
	@Override
	public com.idetronic.eis.model.Faculty createFaculty(long facultyId) {
		return _facultyLocalService.createFaculty(facultyId);
	}

	/**
	* Deletes the faculty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facultyId the primary key of the faculty
	* @return the faculty that was removed
	* @throws PortalException if a faculty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Faculty deleteFaculty(long facultyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.deleteFaculty(facultyId);
	}

	/**
	* Deletes the faculty from the database. Also notifies the appropriate model listeners.
	*
	* @param faculty the faculty
	* @return the faculty that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Faculty deleteFaculty(
		com.idetronic.eis.model.Faculty faculty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.deleteFaculty(faculty);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facultyLocalService.dynamicQuery();
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
		return _facultyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _facultyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _facultyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _facultyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _facultyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.eis.model.Faculty fetchFaculty(long facultyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.fetchFaculty(facultyId);
	}

	/**
	* Returns the faculty with the primary key.
	*
	* @param facultyId the primary key of the faculty
	* @return the faculty
	* @throws PortalException if a faculty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Faculty getFaculty(long facultyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.getFaculty(facultyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the faculties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faculties
	* @param end the upper bound of the range of faculties (not inclusive)
	* @return the range of faculties
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.Faculty> getFaculties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.getFaculties(start, end);
	}

	/**
	* Returns the number of faculties.
	*
	* @return the number of faculties
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFacultiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.getFacultiesCount();
	}

	/**
	* Updates the faculty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faculty the faculty
	* @return the faculty that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Faculty updateFaculty(
		com.idetronic.eis.model.Faculty faculty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.updateFaculty(faculty);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _facultyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_facultyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _facultyLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.idetronic.eis.model.Faculty add(long facultyTypeId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facultyLocalService.add(facultyTypeId, name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FacultyLocalService getWrappedFacultyLocalService() {
		return _facultyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFacultyLocalService(
		FacultyLocalService facultyLocalService) {
		_facultyLocalService = facultyLocalService;
	}

	@Override
	public FacultyLocalService getWrappedService() {
		return _facultyLocalService;
	}

	@Override
	public void setWrappedService(FacultyLocalService facultyLocalService) {
		_facultyLocalService = facultyLocalService;
	}

	private FacultyLocalService _facultyLocalService;
}
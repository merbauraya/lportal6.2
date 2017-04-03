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

package com.idetronic.eis.service.persistence;

import com.idetronic.eis.model.Faculty;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the faculty service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FacultyPersistenceImpl
 * @see FacultyUtil
 * @generated
 */
public interface FacultyPersistence extends BasePersistence<Faculty> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FacultyUtil} to access the faculty persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the faculty in the entity cache if it is enabled.
	*
	* @param faculty the faculty
	*/
	public void cacheResult(com.idetronic.eis.model.Faculty faculty);

	/**
	* Caches the faculties in the entity cache if it is enabled.
	*
	* @param faculties the faculties
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.Faculty> faculties);

	/**
	* Creates a new faculty with the primary key. Does not add the faculty to the database.
	*
	* @param facultyId the primary key for the new faculty
	* @return the new faculty
	*/
	public com.idetronic.eis.model.Faculty create(long facultyId);

	/**
	* Removes the faculty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param facultyId the primary key of the faculty
	* @return the faculty that was removed
	* @throws com.idetronic.eis.NoSuchFacultyException if a faculty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Faculty remove(long facultyId)
		throws com.idetronic.eis.NoSuchFacultyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.Faculty updateImpl(
		com.idetronic.eis.model.Faculty faculty)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the faculty with the primary key or throws a {@link com.idetronic.eis.NoSuchFacultyException} if it could not be found.
	*
	* @param facultyId the primary key of the faculty
	* @return the faculty
	* @throws com.idetronic.eis.NoSuchFacultyException if a faculty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Faculty findByPrimaryKey(long facultyId)
		throws com.idetronic.eis.NoSuchFacultyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the faculty with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param facultyId the primary key of the faculty
	* @return the faculty, or <code>null</code> if a faculty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Faculty fetchByPrimaryKey(long facultyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the faculties.
	*
	* @return the faculties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Faculty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.Faculty> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the faculties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of faculties
	* @param end the upper bound of the range of faculties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of faculties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Faculty> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the faculties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of faculties.
	*
	* @return the number of faculties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
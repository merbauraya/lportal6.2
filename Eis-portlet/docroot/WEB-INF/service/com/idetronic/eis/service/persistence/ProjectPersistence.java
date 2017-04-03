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

import com.idetronic.eis.model.Project;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectPersistenceImpl
 * @see ProjectUtil
 * @generated
 */
public interface ProjectPersistence extends BasePersistence<Project> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project in the entity cache if it is enabled.
	*
	* @param project the project
	*/
	public void cacheResult(com.idetronic.eis.model.Project project);

	/**
	* Caches the projects in the entity cache if it is enabled.
	*
	* @param projects the projects
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.Project> projects);

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectId the primary key for the new project
	* @return the new project
	*/
	public com.idetronic.eis.model.Project create(long projectId);

	/**
	* Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the project
	* @return the project that was removed
	* @throws com.idetronic.eis.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Project remove(long projectId)
		throws com.idetronic.eis.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.Project updateImpl(
		com.idetronic.eis.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectException} if it could not be found.
	*
	* @param projectId the primary key of the project
	* @return the project
	* @throws com.idetronic.eis.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Project findByPrimaryKey(long projectId)
		throws com.idetronic.eis.NoSuchProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the project
	* @return the project, or <code>null</code> if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Project fetchByPrimaryKey(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the projects.
	*
	* @return the projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Project> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @return the range of projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Project> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Project> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
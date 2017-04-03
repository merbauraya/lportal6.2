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

import com.idetronic.eis.model.ProjectResource;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResourcePersistenceImpl
 * @see ProjectResourceUtil
 * @generated
 */
public interface ProjectResourcePersistence extends BasePersistence<ProjectResource> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectResourceUtil} to access the project resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project resource in the entity cache if it is enabled.
	*
	* @param projectResource the project resource
	*/
	public void cacheResult(
		com.idetronic.eis.model.ProjectResource projectResource);

	/**
	* Caches the project resources in the entity cache if it is enabled.
	*
	* @param projectResources the project resources
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ProjectResource> projectResources);

	/**
	* Creates a new project resource with the primary key. Does not add the project resource to the database.
	*
	* @param projectResourceId the primary key for the new project resource
	* @return the new project resource
	*/
	public com.idetronic.eis.model.ProjectResource create(
		long projectResourceId);

	/**
	* Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectResourceId the primary key of the project resource
	* @return the project resource that was removed
	* @throws com.idetronic.eis.NoSuchProjectResourceException if a project resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectResource remove(
		long projectResourceId)
		throws com.idetronic.eis.NoSuchProjectResourceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ProjectResource updateImpl(
		com.idetronic.eis.model.ProjectResource projectResource)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project resource with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectResourceException} if it could not be found.
	*
	* @param projectResourceId the primary key of the project resource
	* @return the project resource
	* @throws com.idetronic.eis.NoSuchProjectResourceException if a project resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectResource findByPrimaryKey(
		long projectResourceId)
		throws com.idetronic.eis.NoSuchProjectResourceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project resource with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectResourceId the primary key of the project resource
	* @return the project resource, or <code>null</code> if a project resource with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectResource fetchByPrimaryKey(
		long projectResourceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project resources.
	*
	* @return the project resources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectResource> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project resources
	* @param end the upper bound of the range of project resources (not inclusive)
	* @return the range of project resources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectResource> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project resources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project resources
	* @param end the upper bound of the range of project resources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project resources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectResource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project resources from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project resources.
	*
	* @return the number of project resources
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
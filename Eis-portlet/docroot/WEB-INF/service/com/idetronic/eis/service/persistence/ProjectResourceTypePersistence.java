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

import com.idetronic.eis.model.ProjectResourceType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project resource type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResourceTypePersistenceImpl
 * @see ProjectResourceTypeUtil
 * @generated
 */
public interface ProjectResourceTypePersistence extends BasePersistence<ProjectResourceType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectResourceTypeUtil} to access the project resource type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project resource type in the entity cache if it is enabled.
	*
	* @param projectResourceType the project resource type
	*/
	public void cacheResult(
		com.idetronic.eis.model.ProjectResourceType projectResourceType);

	/**
	* Caches the project resource types in the entity cache if it is enabled.
	*
	* @param projectResourceTypes the project resource types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ProjectResourceType> projectResourceTypes);

	/**
	* Creates a new project resource type with the primary key. Does not add the project resource type to the database.
	*
	* @param projectResourceTypeId the primary key for the new project resource type
	* @return the new project resource type
	*/
	public com.idetronic.eis.model.ProjectResourceType create(
		long projectResourceTypeId);

	/**
	* Removes the project resource type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectResourceTypeId the primary key of the project resource type
	* @return the project resource type that was removed
	* @throws com.idetronic.eis.NoSuchProjectResourceTypeException if a project resource type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectResourceType remove(
		long projectResourceTypeId)
		throws com.idetronic.eis.NoSuchProjectResourceTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ProjectResourceType updateImpl(
		com.idetronic.eis.model.ProjectResourceType projectResourceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project resource type with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectResourceTypeException} if it could not be found.
	*
	* @param projectResourceTypeId the primary key of the project resource type
	* @return the project resource type
	* @throws com.idetronic.eis.NoSuchProjectResourceTypeException if a project resource type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectResourceType findByPrimaryKey(
		long projectResourceTypeId)
		throws com.idetronic.eis.NoSuchProjectResourceTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project resource type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectResourceTypeId the primary key of the project resource type
	* @return the project resource type, or <code>null</code> if a project resource type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectResourceType fetchByPrimaryKey(
		long projectResourceTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project resource types.
	*
	* @return the project resource types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectResourceType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project resource types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project resource types
	* @param end the upper bound of the range of project resource types (not inclusive)
	* @return the range of project resource types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectResourceType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project resource types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project resource types
	* @param end the upper bound of the range of project resource types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project resource types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectResourceType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project resource types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project resource types.
	*
	* @return the number of project resource types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
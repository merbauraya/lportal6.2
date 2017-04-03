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

import com.idetronic.eis.model.ProjectStrategy;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project strategy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectStrategyPersistenceImpl
 * @see ProjectStrategyUtil
 * @generated
 */
public interface ProjectStrategyPersistence extends BasePersistence<ProjectStrategy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectStrategyUtil} to access the project strategy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project strategies where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching project strategies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> findByProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project strategies where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project strategies
	* @param end the upper bound of the range of project strategies (not inclusive)
	* @return the range of matching project strategies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> findByProject(
		long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project strategies where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project strategies
	* @param end the upper bound of the range of project strategies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project strategies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> findByProject(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project strategy in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project strategy
	* @throws com.idetronic.eis.NoSuchProjectStrategyException if a matching project strategy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy findByProject_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchProjectStrategyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project strategy in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project strategy, or <code>null</code> if a matching project strategy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy fetchByProject_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project strategy in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project strategy
	* @throws com.idetronic.eis.NoSuchProjectStrategyException if a matching project strategy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy findByProject_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchProjectStrategyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project strategy in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project strategy, or <code>null</code> if a matching project strategy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy fetchByProject_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project strategies before and after the current project strategy in the ordered set where projectId = &#63;.
	*
	* @param projectStrategyId the primary key of the current project strategy
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project strategy
	* @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy[] findByProject_PrevAndNext(
		long projectStrategyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchProjectStrategyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project strategies where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project strategies where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching project strategies
	* @throws SystemException if a system exception occurred
	*/
	public int countByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the project strategy in the entity cache if it is enabled.
	*
	* @param projectStrategy the project strategy
	*/
	public void cacheResult(
		com.idetronic.eis.model.ProjectStrategy projectStrategy);

	/**
	* Caches the project strategies in the entity cache if it is enabled.
	*
	* @param projectStrategies the project strategies
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ProjectStrategy> projectStrategies);

	/**
	* Creates a new project strategy with the primary key. Does not add the project strategy to the database.
	*
	* @param projectStrategyId the primary key for the new project strategy
	* @return the new project strategy
	*/
	public com.idetronic.eis.model.ProjectStrategy create(
		long projectStrategyId);

	/**
	* Removes the project strategy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectStrategyId the primary key of the project strategy
	* @return the project strategy that was removed
	* @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy remove(
		long projectStrategyId)
		throws com.idetronic.eis.NoSuchProjectStrategyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ProjectStrategy updateImpl(
		com.idetronic.eis.model.ProjectStrategy projectStrategy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project strategy with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectStrategyException} if it could not be found.
	*
	* @param projectStrategyId the primary key of the project strategy
	* @return the project strategy
	* @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy findByPrimaryKey(
		long projectStrategyId)
		throws com.idetronic.eis.NoSuchProjectStrategyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project strategy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectStrategyId the primary key of the project strategy
	* @return the project strategy, or <code>null</code> if a project strategy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectStrategy fetchByPrimaryKey(
		long projectStrategyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project strategies.
	*
	* @return the project strategies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project strategies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project strategies
	* @param end the upper bound of the range of project strategies (not inclusive)
	* @return the range of project strategies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project strategies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project strategies
	* @param end the upper bound of the range of project strategies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project strategies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project strategies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project strategies.
	*
	* @return the number of project strategies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
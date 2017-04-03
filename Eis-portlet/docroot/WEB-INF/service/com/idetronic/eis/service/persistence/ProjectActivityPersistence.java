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

import com.idetronic.eis.model.ProjectActivity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectActivityPersistenceImpl
 * @see ProjectActivityUtil
 * @generated
 */
public interface ProjectActivityPersistence extends BasePersistence<ProjectActivity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectActivityUtil} to access the project activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project activities where strategyId = &#63;.
	*
	* @param strategyId the strategy ID
	* @return the matching project activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectActivity> findByStrategy(
		long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project activities where strategyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param strategyId the strategy ID
	* @param start the lower bound of the range of project activities
	* @param end the upper bound of the range of project activities (not inclusive)
	* @return the range of matching project activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectActivity> findByStrategy(
		long strategyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project activities where strategyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param strategyId the strategy ID
	* @param start the lower bound of the range of project activities
	* @param end the upper bound of the range of project activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectActivity> findByStrategy(
		long strategyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project activity in the ordered set where strategyId = &#63;.
	*
	* @param strategyId the strategy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project activity
	* @throws com.idetronic.eis.NoSuchProjectActivityException if a matching project activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity findByStrategy_First(
		long strategyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchProjectActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project activity in the ordered set where strategyId = &#63;.
	*
	* @param strategyId the strategy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project activity, or <code>null</code> if a matching project activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity fetchByStrategy_First(
		long strategyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project activity in the ordered set where strategyId = &#63;.
	*
	* @param strategyId the strategy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project activity
	* @throws com.idetronic.eis.NoSuchProjectActivityException if a matching project activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity findByStrategy_Last(
		long strategyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchProjectActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project activity in the ordered set where strategyId = &#63;.
	*
	* @param strategyId the strategy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project activity, or <code>null</code> if a matching project activity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity fetchByStrategy_Last(
		long strategyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project activities before and after the current project activity in the ordered set where strategyId = &#63;.
	*
	* @param projectActivityId the primary key of the current project activity
	* @param strategyId the strategy ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project activity
	* @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity[] findByStrategy_PrevAndNext(
		long projectActivityId, long strategyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchProjectActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project activities where strategyId = &#63; from the database.
	*
	* @param strategyId the strategy ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStrategy(long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project activities where strategyId = &#63;.
	*
	* @param strategyId the strategy ID
	* @return the number of matching project activities
	* @throws SystemException if a system exception occurred
	*/
	public int countByStrategy(long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the project activity in the entity cache if it is enabled.
	*
	* @param projectActivity the project activity
	*/
	public void cacheResult(
		com.idetronic.eis.model.ProjectActivity projectActivity);

	/**
	* Caches the project activities in the entity cache if it is enabled.
	*
	* @param projectActivities the project activities
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.ProjectActivity> projectActivities);

	/**
	* Creates a new project activity with the primary key. Does not add the project activity to the database.
	*
	* @param projectActivityId the primary key for the new project activity
	* @return the new project activity
	*/
	public com.idetronic.eis.model.ProjectActivity create(
		long projectActivityId);

	/**
	* Removes the project activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity that was removed
	* @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity remove(
		long projectActivityId)
		throws com.idetronic.eis.NoSuchProjectActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.ProjectActivity updateImpl(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project activity with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectActivityException} if it could not be found.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity
	* @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity findByPrimaryKey(
		long projectActivityId)
		throws com.idetronic.eis.NoSuchProjectActivityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project activity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity, or <code>null</code> if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.ProjectActivity fetchByPrimaryKey(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project activities.
	*
	* @return the project activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectActivity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project activities
	* @param end the upper bound of the range of project activities (not inclusive)
	* @return the range of project activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectActivity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project activities
	* @param end the upper bound of the range of project activities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project activities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.ProjectActivity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project activities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project activities.
	*
	* @return the number of project activities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
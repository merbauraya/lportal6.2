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

import com.idetronic.eis.model.FactItManagement;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact it management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactItManagementPersistenceImpl
 * @see FactItManagementUtil
 * @generated
 */
public interface FactItManagementPersistence extends BasePersistence<FactItManagement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactItManagementUtil} to access the fact it management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fact it management in the entity cache if it is enabled.
	*
	* @param factItManagement the fact it management
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactItManagement factItManagement);

	/**
	* Caches the fact it managements in the entity cache if it is enabled.
	*
	* @param factItManagements the fact it managements
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactItManagement> factItManagements);

	/**
	* Creates a new fact it management with the primary key. Does not add the fact it management to the database.
	*
	* @param factId the primary key for the new fact it management
	* @return the new fact it management
	*/
	public com.idetronic.eis.model.FactItManagement create(long factId);

	/**
	* Removes the fact it management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact it management
	* @return the fact it management that was removed
	* @throws com.idetronic.eis.NoSuchFactItManagementException if a fact it management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactItManagement remove(long factId)
		throws com.idetronic.eis.NoSuchFactItManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactItManagement updateImpl(
		com.idetronic.eis.model.FactItManagement factItManagement)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact it management with the primary key or throws a {@link com.idetronic.eis.NoSuchFactItManagementException} if it could not be found.
	*
	* @param factId the primary key of the fact it management
	* @return the fact it management
	* @throws com.idetronic.eis.NoSuchFactItManagementException if a fact it management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactItManagement findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactItManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact it management with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact it management
	* @return the fact it management, or <code>null</code> if a fact it management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactItManagement fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact it managements.
	*
	* @return the fact it managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactItManagement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact it managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact it managements
	* @param end the upper bound of the range of fact it managements (not inclusive)
	* @return the range of fact it managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactItManagement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact it managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact it managements
	* @param end the upper bound of the range of fact it managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact it managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactItManagement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact it managements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact it managements.
	*
	* @return the number of fact it managements
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
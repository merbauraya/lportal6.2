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

import com.idetronic.eis.model.FactData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDataPersistenceImpl
 * @see FactDataUtil
 * @generated
 */
public interface FactDataPersistence extends BasePersistence<FactData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactDataUtil} to access the fact data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fact data in the entity cache if it is enabled.
	*
	* @param factData the fact data
	*/
	public void cacheResult(com.idetronic.eis.model.FactData factData);

	/**
	* Caches the fact datas in the entity cache if it is enabled.
	*
	* @param factDatas the fact datas
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactData> factDatas);

	/**
	* Creates a new fact data with the primary key. Does not add the fact data to the database.
	*
	* @param factId the primary key for the new fact data
	* @return the new fact data
	*/
	public com.idetronic.eis.model.FactData create(long factId);

	/**
	* Removes the fact data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact data
	* @return the fact data that was removed
	* @throws com.idetronic.eis.NoSuchFactDataException if a fact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactData remove(long factId)
		throws com.idetronic.eis.NoSuchFactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactData updateImpl(
		com.idetronic.eis.model.FactData factData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact data with the primary key or throws a {@link com.idetronic.eis.NoSuchFactDataException} if it could not be found.
	*
	* @param factId the primary key of the fact data
	* @return the fact data
	* @throws com.idetronic.eis.NoSuchFactDataException if a fact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactData findByPrimaryKey(long factId)
		throws com.idetronic.eis.NoSuchFactDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact data
	* @return the fact data, or <code>null</code> if a fact data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactData fetchByPrimaryKey(long factId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact datas.
	*
	* @return the fact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact datas
	* @param end the upper bound of the range of fact datas (not inclusive)
	* @return the range of fact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactData> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact datas
	* @param end the upper bound of the range of fact datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactData> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact datas.
	*
	* @return the number of fact datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
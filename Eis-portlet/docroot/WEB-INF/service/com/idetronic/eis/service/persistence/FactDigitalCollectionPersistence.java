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

import com.idetronic.eis.model.FactDigitalCollection;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact digital collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDigitalCollectionPersistenceImpl
 * @see FactDigitalCollectionUtil
 * @generated
 */
public interface FactDigitalCollectionPersistence extends BasePersistence<FactDigitalCollection> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactDigitalCollectionUtil} to access the fact digital collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fact digital collection in the entity cache if it is enabled.
	*
	* @param factDigitalCollection the fact digital collection
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactDigitalCollection factDigitalCollection);

	/**
	* Caches the fact digital collections in the entity cache if it is enabled.
	*
	* @param factDigitalCollections the fact digital collections
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactDigitalCollection> factDigitalCollections);

	/**
	* Creates a new fact digital collection with the primary key. Does not add the fact digital collection to the database.
	*
	* @param factId the primary key for the new fact digital collection
	* @return the new fact digital collection
	*/
	public com.idetronic.eis.model.FactDigitalCollection create(long factId);

	/**
	* Removes the fact digital collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact digital collection
	* @return the fact digital collection that was removed
	* @throws com.idetronic.eis.NoSuchFactDigitalCollectionException if a fact digital collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactDigitalCollection remove(long factId)
		throws com.idetronic.eis.NoSuchFactDigitalCollectionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactDigitalCollection updateImpl(
		com.idetronic.eis.model.FactDigitalCollection factDigitalCollection)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact digital collection with the primary key or throws a {@link com.idetronic.eis.NoSuchFactDigitalCollectionException} if it could not be found.
	*
	* @param factId the primary key of the fact digital collection
	* @return the fact digital collection
	* @throws com.idetronic.eis.NoSuchFactDigitalCollectionException if a fact digital collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactDigitalCollection findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactDigitalCollectionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact digital collection with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact digital collection
	* @return the fact digital collection, or <code>null</code> if a fact digital collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactDigitalCollection fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact digital collections.
	*
	* @return the fact digital collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactDigitalCollection> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact digital collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDigitalCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact digital collections
	* @param end the upper bound of the range of fact digital collections (not inclusive)
	* @return the range of fact digital collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactDigitalCollection> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact digital collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDigitalCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact digital collections
	* @param end the upper bound of the range of fact digital collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact digital collections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactDigitalCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact digital collections from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact digital collections.
	*
	* @return the number of fact digital collections
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
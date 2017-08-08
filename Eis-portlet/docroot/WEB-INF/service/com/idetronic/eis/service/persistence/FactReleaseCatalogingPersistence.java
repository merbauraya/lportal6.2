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

import com.idetronic.eis.model.FactReleaseCataloging;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact release cataloging service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactReleaseCatalogingPersistenceImpl
 * @see FactReleaseCatalogingUtil
 * @generated
 */
public interface FactReleaseCatalogingPersistence extends BasePersistence<FactReleaseCataloging> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactReleaseCatalogingUtil} to access the fact release cataloging persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fact release cataloging in the entity cache if it is enabled.
	*
	* @param factReleaseCataloging the fact release cataloging
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactReleaseCataloging factReleaseCataloging);

	/**
	* Caches the fact release catalogings in the entity cache if it is enabled.
	*
	* @param factReleaseCatalogings the fact release catalogings
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactReleaseCataloging> factReleaseCatalogings);

	/**
	* Creates a new fact release cataloging with the primary key. Does not add the fact release cataloging to the database.
	*
	* @param factId the primary key for the new fact release cataloging
	* @return the new fact release cataloging
	*/
	public com.idetronic.eis.model.FactReleaseCataloging create(long factId);

	/**
	* Removes the fact release cataloging with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact release cataloging
	* @return the fact release cataloging that was removed
	* @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactReleaseCataloging remove(long factId)
		throws com.idetronic.eis.NoSuchFactReleaseCatalogingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactReleaseCataloging updateImpl(
		com.idetronic.eis.model.FactReleaseCataloging factReleaseCataloging)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact release cataloging with the primary key or throws a {@link com.idetronic.eis.NoSuchFactReleaseCatalogingException} if it could not be found.
	*
	* @param factId the primary key of the fact release cataloging
	* @return the fact release cataloging
	* @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactReleaseCataloging findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactReleaseCatalogingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact release cataloging with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact release cataloging
	* @return the fact release cataloging, or <code>null</code> if a fact release cataloging with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactReleaseCataloging fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact release catalogings.
	*
	* @return the fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactReleaseCataloging> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact release catalogings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact release catalogings
	* @param end the upper bound of the range of fact release catalogings (not inclusive)
	* @return the range of fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactReleaseCataloging> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact release catalogings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact release catalogings
	* @param end the upper bound of the range of fact release catalogings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactReleaseCataloging> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact release catalogings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact release catalogings.
	*
	* @return the number of fact release catalogings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
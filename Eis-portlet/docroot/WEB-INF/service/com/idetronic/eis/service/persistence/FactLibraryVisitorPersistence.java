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

import com.idetronic.eis.model.FactLibraryVisitor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact library visitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactLibraryVisitorPersistenceImpl
 * @see FactLibraryVisitorUtil
 * @generated
 */
public interface FactLibraryVisitorPersistence extends BasePersistence<FactLibraryVisitor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactLibraryVisitorUtil} to access the fact library visitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fact library visitor in the entity cache if it is enabled.
	*
	* @param factLibraryVisitor the fact library visitor
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactLibraryVisitor factLibraryVisitor);

	/**
	* Caches the fact library visitors in the entity cache if it is enabled.
	*
	* @param factLibraryVisitors the fact library visitors
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactLibraryVisitor> factLibraryVisitors);

	/**
	* Creates a new fact library visitor with the primary key. Does not add the fact library visitor to the database.
	*
	* @param factId the primary key for the new fact library visitor
	* @return the new fact library visitor
	*/
	public com.idetronic.eis.model.FactLibraryVisitor create(long factId);

	/**
	* Removes the fact library visitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact library visitor
	* @return the fact library visitor that was removed
	* @throws com.idetronic.eis.NoSuchFactLibraryVisitorException if a fact library visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactLibraryVisitor remove(long factId)
		throws com.idetronic.eis.NoSuchFactLibraryVisitorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactLibraryVisitor updateImpl(
		com.idetronic.eis.model.FactLibraryVisitor factLibraryVisitor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact library visitor with the primary key or throws a {@link com.idetronic.eis.NoSuchFactLibraryVisitorException} if it could not be found.
	*
	* @param factId the primary key of the fact library visitor
	* @return the fact library visitor
	* @throws com.idetronic.eis.NoSuchFactLibraryVisitorException if a fact library visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactLibraryVisitor findByPrimaryKey(
		long factId)
		throws com.idetronic.eis.NoSuchFactLibraryVisitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact library visitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factId the primary key of the fact library visitor
	* @return the fact library visitor, or <code>null</code> if a fact library visitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactLibraryVisitor fetchByPrimaryKey(
		long factId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact library visitors.
	*
	* @return the fact library visitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactLibraryVisitor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact library visitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact library visitors
	* @param end the upper bound of the range of fact library visitors (not inclusive)
	* @return the range of fact library visitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactLibraryVisitor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact library visitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact library visitors
	* @param end the upper bound of the range of fact library visitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact library visitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactLibraryVisitor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact library visitors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact library visitors.
	*
	* @return the number of fact library visitors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
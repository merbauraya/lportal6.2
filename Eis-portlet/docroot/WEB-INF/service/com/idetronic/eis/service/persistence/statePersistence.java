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

import com.idetronic.eis.model.state;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see statePersistenceImpl
 * @see stateUtil
 * @generated
 */
public interface statePersistence extends BasePersistence<state> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link stateUtil} to access the state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the state where stateCode = &#63; or throws a {@link com.idetronic.eis.NoSuchstateException} if it could not be found.
	*
	* @param stateCode the state code
	* @return the matching state
	* @throws com.idetronic.eis.NoSuchstateException if a matching state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state findBystateCode(
		java.lang.String stateCode)
		throws com.idetronic.eis.NoSuchstateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the state where stateCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stateCode the state code
	* @return the matching state, or <code>null</code> if a matching state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state fetchBystateCode(
		java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the state where stateCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stateCode the state code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching state, or <code>null</code> if a matching state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state fetchBystateCode(
		java.lang.String stateCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the state where stateCode = &#63; from the database.
	*
	* @param stateCode the state code
	* @return the state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state removeBystateCode(
		java.lang.String stateCode)
		throws com.idetronic.eis.NoSuchstateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of states where stateCode = &#63;.
	*
	* @param stateCode the state code
	* @return the number of matching states
	* @throws SystemException if a system exception occurred
	*/
	public int countBystateCode(java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the state in the entity cache if it is enabled.
	*
	* @param state the state
	*/
	public void cacheResult(com.idetronic.eis.model.state state);

	/**
	* Caches the states in the entity cache if it is enabled.
	*
	* @param states the states
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.state> states);

	/**
	* Creates a new state with the primary key. Does not add the state to the database.
	*
	* @param stateId the primary key for the new state
	* @return the new state
	*/
	public com.idetronic.eis.model.state create(long stateId);

	/**
	* Removes the state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stateId the primary key of the state
	* @return the state that was removed
	* @throws com.idetronic.eis.NoSuchstateException if a state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state remove(long stateId)
		throws com.idetronic.eis.NoSuchstateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.state updateImpl(
		com.idetronic.eis.model.state state)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the state with the primary key or throws a {@link com.idetronic.eis.NoSuchstateException} if it could not be found.
	*
	* @param stateId the primary key of the state
	* @return the state
	* @throws com.idetronic.eis.NoSuchstateException if a state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state findByPrimaryKey(long stateId)
		throws com.idetronic.eis.NoSuchstateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stateId the primary key of the state
	* @return the state, or <code>null</code> if a state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.state fetchByPrimaryKey(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the states.
	*
	* @return the states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.state> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.stateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of states
	* @param end the upper bound of the range of states (not inclusive)
	* @return the range of states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.state> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.stateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of states
	* @param end the upper bound of the range of states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of states
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.state> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of states.
	*
	* @return the number of states
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
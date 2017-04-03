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

import com.idetronic.eis.model.State;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the state service. This utility wraps {@link StatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatePersistence
 * @see StatePersistenceImpl
 * @generated
 */
public class StateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(State state) {
		getPersistence().clearCache(state);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<State> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<State> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<State> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static State update(State state) throws SystemException {
		return getPersistence().update(state);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static State update(State state, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(state, serviceContext);
	}

	/**
	* Returns the state where stateCode = &#63; or throws a {@link com.idetronic.eis.NoSuchStateException} if it could not be found.
	*
	* @param stateCode the state code
	* @return the matching state
	* @throws com.idetronic.eis.NoSuchStateException if a matching state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State findBystateCode(
		java.lang.String stateCode)
		throws com.idetronic.eis.NoSuchStateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystateCode(stateCode);
	}

	/**
	* Returns the state where stateCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stateCode the state code
	* @return the matching state, or <code>null</code> if a matching state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State fetchBystateCode(
		java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystateCode(stateCode);
	}

	/**
	* Returns the state where stateCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stateCode the state code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching state, or <code>null</code> if a matching state could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State fetchBystateCode(
		java.lang.String stateCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystateCode(stateCode, retrieveFromCache);
	}

	/**
	* Removes the state where stateCode = &#63; from the database.
	*
	* @param stateCode the state code
	* @return the state that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State removeBystateCode(
		java.lang.String stateCode)
		throws com.idetronic.eis.NoSuchStateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBystateCode(stateCode);
	}

	/**
	* Returns the number of states where stateCode = &#63;.
	*
	* @param stateCode the state code
	* @return the number of matching states
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystateCode(java.lang.String stateCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystateCode(stateCode);
	}

	/**
	* Caches the state in the entity cache if it is enabled.
	*
	* @param state the state
	*/
	public static void cacheResult(com.idetronic.eis.model.State state) {
		getPersistence().cacheResult(state);
	}

	/**
	* Caches the states in the entity cache if it is enabled.
	*
	* @param states the states
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.State> states) {
		getPersistence().cacheResult(states);
	}

	/**
	* Creates a new state with the primary key. Does not add the state to the database.
	*
	* @param stateId the primary key for the new state
	* @return the new state
	*/
	public static com.idetronic.eis.model.State create(long stateId) {
		return getPersistence().create(stateId);
	}

	/**
	* Removes the state with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stateId the primary key of the state
	* @return the state that was removed
	* @throws com.idetronic.eis.NoSuchStateException if a state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State remove(long stateId)
		throws com.idetronic.eis.NoSuchStateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stateId);
	}

	public static com.idetronic.eis.model.State updateImpl(
		com.idetronic.eis.model.State state)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(state);
	}

	/**
	* Returns the state with the primary key or throws a {@link com.idetronic.eis.NoSuchStateException} if it could not be found.
	*
	* @param stateId the primary key of the state
	* @return the state
	* @throws com.idetronic.eis.NoSuchStateException if a state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State findByPrimaryKey(long stateId)
		throws com.idetronic.eis.NoSuchStateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stateId);
	}

	/**
	* Returns the state with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stateId the primary key of the state
	* @return the state, or <code>null</code> if a state with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.State fetchByPrimaryKey(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stateId);
	}

	/**
	* Returns all the states.
	*
	* @return the states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.State> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.StateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of states
	* @param end the upper bound of the range of states (not inclusive)
	* @return the range of states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.State> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the states.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.StateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of states
	* @param end the upper bound of the range of states (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of states
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.State> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the states from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of states.
	*
	* @return the number of states
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StatePersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					StatePersistence.class.getName());

			ReferenceRegistry.registerReference(StateUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StatePersistence persistence) {
	}

	private static StatePersistence _persistence;
}
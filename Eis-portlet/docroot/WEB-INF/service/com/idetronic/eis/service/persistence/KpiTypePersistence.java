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

import com.idetronic.eis.model.KpiType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the kpi type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiTypePersistenceImpl
 * @see KpiTypeUtil
 * @generated
 */
public interface KpiTypePersistence extends BasePersistence<KpiType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KpiTypeUtil} to access the kpi type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the kpi type where kpiTypeKey = &#63; or throws a {@link com.idetronic.eis.NoSuchKpiTypeException} if it could not be found.
	*
	* @param kpiTypeKey the kpi type key
	* @return the matching kpi type
	* @throws com.idetronic.eis.NoSuchKpiTypeException if a matching kpi type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType findByKey(
		java.lang.String kpiTypeKey)
		throws com.idetronic.eis.NoSuchKpiTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi type where kpiTypeKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param kpiTypeKey the kpi type key
	* @return the matching kpi type, or <code>null</code> if a matching kpi type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType fetchByKey(
		java.lang.String kpiTypeKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi type where kpiTypeKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param kpiTypeKey the kpi type key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching kpi type, or <code>null</code> if a matching kpi type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType fetchByKey(
		java.lang.String kpiTypeKey, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the kpi type where kpiTypeKey = &#63; from the database.
	*
	* @param kpiTypeKey the kpi type key
	* @return the kpi type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType removeByKey(
		java.lang.String kpiTypeKey)
		throws com.idetronic.eis.NoSuchKpiTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kpi types where kpiTypeKey = &#63;.
	*
	* @param kpiTypeKey the kpi type key
	* @return the number of matching kpi types
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(java.lang.String kpiTypeKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the kpi type in the entity cache if it is enabled.
	*
	* @param kpiType the kpi type
	*/
	public void cacheResult(com.idetronic.eis.model.KpiType kpiType);

	/**
	* Caches the kpi types in the entity cache if it is enabled.
	*
	* @param kpiTypes the kpi types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.KpiType> kpiTypes);

	/**
	* Creates a new kpi type with the primary key. Does not add the kpi type to the database.
	*
	* @param kpiTypeId the primary key for the new kpi type
	* @return the new kpi type
	*/
	public com.idetronic.eis.model.KpiType create(long kpiTypeId);

	/**
	* Removes the kpi type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiTypeId the primary key of the kpi type
	* @return the kpi type that was removed
	* @throws com.idetronic.eis.NoSuchKpiTypeException if a kpi type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType remove(long kpiTypeId)
		throws com.idetronic.eis.NoSuchKpiTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.KpiType updateImpl(
		com.idetronic.eis.model.KpiType kpiType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi type with the primary key or throws a {@link com.idetronic.eis.NoSuchKpiTypeException} if it could not be found.
	*
	* @param kpiTypeId the primary key of the kpi type
	* @return the kpi type
	* @throws com.idetronic.eis.NoSuchKpiTypeException if a kpi type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType findByPrimaryKey(long kpiTypeId)
		throws com.idetronic.eis.NoSuchKpiTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kpiTypeId the primary key of the kpi type
	* @return the kpi type, or <code>null</code> if a kpi type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiType fetchByPrimaryKey(long kpiTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kpi types.
	*
	* @return the kpi types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kpi types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpi types
	* @param end the upper bound of the range of kpi types (not inclusive)
	* @return the range of kpi types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiType> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kpi types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpi types
	* @param end the upper bound of the range of kpi types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kpi types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiType> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kpi types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kpi types.
	*
	* @return the number of kpi types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
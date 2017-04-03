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

import com.idetronic.eis.model.KpiEntry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the kpi entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiEntryPersistenceImpl
 * @see KpiEntryUtil
 * @generated
 */
public interface KpiEntryPersistence extends BasePersistence<KpiEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KpiEntryUtil} to access the kpi entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or throws a {@link com.idetronic.eis.NoSuchKpiEntryException} if it could not be found.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the matching kpi entry
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry findByTypePeriod(long kpiTypeId,
		int periodType, java.lang.String period)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry fetchByTypePeriod(long kpiTypeId,
		int periodType, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry fetchByTypePeriod(long kpiTypeId,
		int periodType, java.lang.String period, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; from the database.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the kpi entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry removeByTypePeriod(long kpiTypeId,
		int periodType, java.lang.String period)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kpi entries where kpiTypeId = &#63; and periodType = &#63; and period = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the number of matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypePeriod(long kpiTypeId, int periodType,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @return the matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiEntry> findByYearType(
		long kpiTypeId, java.lang.String periodYear, int periodType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param start the lower bound of the range of kpi entries
	* @param end the upper bound of the range of kpi entries (not inclusive)
	* @return the range of matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiEntry> findByYearType(
		long kpiTypeId, java.lang.String periodYear, int periodType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param start the lower bound of the range of kpi entries
	* @param end the upper bound of the range of kpi entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiEntry> findByYearType(
		long kpiTypeId, java.lang.String periodYear, int periodType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kpi entry
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry findByYearType_First(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry fetchByYearType_First(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kpi entry
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry findByYearType_Last(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry fetchByYearType_Last(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi entries before and after the current kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiEntryId the primary key of the current kpi entry
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kpi entry
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry[] findByYearType_PrevAndNext(
		long kpiEntryId, long kpiTypeId, java.lang.String periodYear,
		int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63; from the database.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByYearType(long kpiTypeId, java.lang.String periodYear,
		int periodType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @return the number of matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByYearType(long kpiTypeId, java.lang.String periodYear,
		int periodType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the kpi entry in the entity cache if it is enabled.
	*
	* @param kpiEntry the kpi entry
	*/
	public void cacheResult(com.idetronic.eis.model.KpiEntry kpiEntry);

	/**
	* Caches the kpi entries in the entity cache if it is enabled.
	*
	* @param kpiEntries the kpi entries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.KpiEntry> kpiEntries);

	/**
	* Creates a new kpi entry with the primary key. Does not add the kpi entry to the database.
	*
	* @param kpiEntryId the primary key for the new kpi entry
	* @return the new kpi entry
	*/
	public com.idetronic.eis.model.KpiEntry create(long kpiEntryId);

	/**
	* Removes the kpi entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry that was removed
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry remove(long kpiEntryId)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.KpiEntry updateImpl(
		com.idetronic.eis.model.KpiEntry kpiEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi entry with the primary key or throws a {@link com.idetronic.eis.NoSuchKpiEntryException} if it could not be found.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry findByPrimaryKey(long kpiEntryId)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kpi entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry, or <code>null</code> if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.KpiEntry fetchByPrimaryKey(long kpiEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kpi entries.
	*
	* @return the kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kpi entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpi entries
	* @param end the upper bound of the range of kpi entries (not inclusive)
	* @return the range of kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiEntry> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kpi entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpi entries
	* @param end the upper bound of the range of kpi entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.KpiEntry> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kpi entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kpi entries.
	*
	* @return the number of kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
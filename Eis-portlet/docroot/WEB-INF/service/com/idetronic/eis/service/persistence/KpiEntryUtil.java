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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the kpi entry service. This utility wraps {@link KpiEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiEntryPersistence
 * @see KpiEntryPersistenceImpl
 * @generated
 */
public class KpiEntryUtil {
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
	public static void clearCache(KpiEntry kpiEntry) {
		getPersistence().clearCache(kpiEntry);
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
	public static List<KpiEntry> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KpiEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KpiEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static KpiEntry update(KpiEntry kpiEntry) throws SystemException {
		return getPersistence().update(kpiEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static KpiEntry update(KpiEntry kpiEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(kpiEntry, serviceContext);
	}

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
	public static com.idetronic.eis.model.KpiEntry findByTypePeriod(
		long kpiTypeId, int periodType, java.lang.String period)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypePeriod(kpiTypeId, periodType, period);
	}

	/**
	* Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiEntry fetchByTypePeriod(
		long kpiTypeId, int periodType, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTypePeriod(kpiTypeId, periodType, period);
	}

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
	public static com.idetronic.eis.model.KpiEntry fetchByTypePeriod(
		long kpiTypeId, int periodType, java.lang.String period,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypePeriod(kpiTypeId, periodType, period,
			retrieveFromCache);
	}

	/**
	* Removes the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; from the database.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the kpi entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiEntry removeByTypePeriod(
		long kpiTypeId, int periodType, java.lang.String period)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByTypePeriod(kpiTypeId, periodType, period);
	}

	/**
	* Returns the number of kpi entries where kpiTypeId = &#63; and periodType = &#63; and period = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodType the period type
	* @param period the period
	* @return the number of matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypePeriod(long kpiTypeId, int periodType,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypePeriod(kpiTypeId, periodType, period);
	}

	/**
	* Returns all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @return the matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.KpiEntry> findByYearType(
		long kpiTypeId, java.lang.String periodYear, int periodType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYearType(kpiTypeId, periodYear, periodType);
	}

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
	public static java.util.List<com.idetronic.eis.model.KpiEntry> findByYearType(
		long kpiTypeId, java.lang.String periodYear, int periodType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearType(kpiTypeId, periodYear, periodType, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.KpiEntry> findByYearType(
		long kpiTypeId, java.lang.String periodYear, int periodType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearType(kpiTypeId, periodYear, periodType, start,
			end, orderByComparator);
	}

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
	public static com.idetronic.eis.model.KpiEntry findByYearType_First(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearType_First(kpiTypeId, periodYear, periodType,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.KpiEntry fetchByYearType_First(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYearType_First(kpiTypeId, periodYear, periodType,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.KpiEntry findByYearType_Last(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearType_Last(kpiTypeId, periodYear, periodType,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.KpiEntry fetchByYearType_Last(
		long kpiTypeId, java.lang.String periodYear, int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYearType_Last(kpiTypeId, periodYear, periodType,
			orderByComparator);
	}

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
	public static com.idetronic.eis.model.KpiEntry[] findByYearType_PrevAndNext(
		long kpiEntryId, long kpiTypeId, java.lang.String periodYear,
		int periodType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYearType_PrevAndNext(kpiEntryId, kpiTypeId,
			periodYear, periodType, orderByComparator);
	}

	/**
	* Removes all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63; from the database.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYearType(long kpiTypeId,
		java.lang.String periodYear, int periodType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYearType(kpiTypeId, periodYear, periodType);
	}

	/**
	* Returns the number of kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	*
	* @param kpiTypeId the kpi type ID
	* @param periodYear the period year
	* @param periodType the period type
	* @return the number of matching kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYearType(long kpiTypeId,
		java.lang.String periodYear, int periodType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByYearType(kpiTypeId, periodYear, periodType);
	}

	/**
	* Caches the kpi entry in the entity cache if it is enabled.
	*
	* @param kpiEntry the kpi entry
	*/
	public static void cacheResult(com.idetronic.eis.model.KpiEntry kpiEntry) {
		getPersistence().cacheResult(kpiEntry);
	}

	/**
	* Caches the kpi entries in the entity cache if it is enabled.
	*
	* @param kpiEntries the kpi entries
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.KpiEntry> kpiEntries) {
		getPersistence().cacheResult(kpiEntries);
	}

	/**
	* Creates a new kpi entry with the primary key. Does not add the kpi entry to the database.
	*
	* @param kpiEntryId the primary key for the new kpi entry
	* @return the new kpi entry
	*/
	public static com.idetronic.eis.model.KpiEntry create(long kpiEntryId) {
		return getPersistence().create(kpiEntryId);
	}

	/**
	* Removes the kpi entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry that was removed
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiEntry remove(long kpiEntryId)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(kpiEntryId);
	}

	public static com.idetronic.eis.model.KpiEntry updateImpl(
		com.idetronic.eis.model.KpiEntry kpiEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(kpiEntry);
	}

	/**
	* Returns the kpi entry with the primary key or throws a {@link com.idetronic.eis.NoSuchKpiEntryException} if it could not be found.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry
	* @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiEntry findByPrimaryKey(
		long kpiEntryId)
		throws com.idetronic.eis.NoSuchKpiEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(kpiEntryId);
	}

	/**
	* Returns the kpi entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry, or <code>null</code> if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiEntry fetchByPrimaryKey(
		long kpiEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(kpiEntryId);
	}

	/**
	* Returns all the kpi entries.
	*
	* @return the kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.KpiEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eis.model.KpiEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.KpiEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the kpi entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of kpi entries.
	*
	* @return the number of kpi entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KpiEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KpiEntryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					KpiEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(KpiEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(KpiEntryPersistence persistence) {
	}

	private static KpiEntryPersistence _persistence;
}
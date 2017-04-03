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

import com.idetronic.eis.model.Report;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the report service. This utility wraps {@link ReportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ReportPersistence
 * @see ReportPersistenceImpl
 * @generated
 */
public class ReportUtil {
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
	public static void clearCache(Report report) {
		getPersistence().clearCache(report);
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
	public static List<Report> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Report> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Report> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Report update(Report report) throws SystemException {
		return getPersistence().update(report);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Report update(Report report, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(report, serviceContext);
	}

	/**
	* Returns the report where reportKey = &#63; or throws a {@link com.idetronic.eis.NoSuchReportException} if it could not be found.
	*
	* @param reportKey the report key
	* @return the matching report
	* @throws com.idetronic.eis.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report findByKey(
		java.lang.String reportKey)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKey(reportKey);
	}

	/**
	* Returns the report where reportKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param reportKey the report key
	* @return the matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report fetchByKey(
		java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey(reportKey);
	}

	/**
	* Returns the report where reportKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param reportKey the report key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report fetchByKey(
		java.lang.String reportKey, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey(reportKey, retrieveFromCache);
	}

	/**
	* Removes the report where reportKey = &#63; from the database.
	*
	* @param reportKey the report key
	* @return the report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report removeByKey(
		java.lang.String reportKey)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByKey(reportKey);
	}

	/**
	* Returns the number of reports where reportKey = &#63;.
	*
	* @param reportKey the report key
	* @return the number of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKey(java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKey(reportKey);
	}

	/**
	* Caches the report in the entity cache if it is enabled.
	*
	* @param report the report
	*/
	public static void cacheResult(com.idetronic.eis.model.Report report) {
		getPersistence().cacheResult(report);
	}

	/**
	* Caches the reports in the entity cache if it is enabled.
	*
	* @param reports the reports
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.Report> reports) {
		getPersistence().cacheResult(reports);
	}

	/**
	* Creates a new report with the primary key. Does not add the report to the database.
	*
	* @param reportId the primary key for the new report
	* @return the new report
	*/
	public static com.idetronic.eis.model.Report create(long reportId) {
		return getPersistence().create(reportId);
	}

	/**
	* Removes the report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the report
	* @return the report that was removed
	* @throws com.idetronic.eis.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report remove(long reportId)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(reportId);
	}

	public static com.idetronic.eis.model.Report updateImpl(
		com.idetronic.eis.model.Report report)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(report);
	}

	/**
	* Returns the report with the primary key or throws a {@link com.idetronic.eis.NoSuchReportException} if it could not be found.
	*
	* @param reportId the primary key of the report
	* @return the report
	* @throws com.idetronic.eis.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report findByPrimaryKey(long reportId)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(reportId);
	}

	/**
	* Returns the report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportId the primary key of the report
	* @return the report, or <code>null</code> if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Report fetchByPrimaryKey(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reportId);
	}

	/**
	* Returns all the reports.
	*
	* @return the reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Report> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @return the range of reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Report> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of reports
	* @param end the upper bound of the range of reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Report> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of reports.
	*
	* @return the number of reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReportPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReportPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					ReportPersistence.class.getName());

			ReferenceRegistry.registerReference(ReportUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ReportPersistence persistence) {
	}

	private static ReportPersistence _persistence;
}
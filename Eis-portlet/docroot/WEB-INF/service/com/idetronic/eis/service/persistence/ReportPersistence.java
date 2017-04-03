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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ReportPersistenceImpl
 * @see ReportUtil
 * @generated
 */
public interface ReportPersistence extends BasePersistence<Report> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportUtil} to access the report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the report where reportKey = &#63; or throws a {@link com.idetronic.eis.NoSuchReportException} if it could not be found.
	*
	* @param reportKey the report key
	* @return the matching report
	* @throws com.idetronic.eis.NoSuchReportException if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report findByKey(java.lang.String reportKey)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report where reportKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param reportKey the report key
	* @return the matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report fetchByKey(java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report where reportKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param reportKey the report key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching report, or <code>null</code> if a matching report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report fetchByKey(
		java.lang.String reportKey, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the report where reportKey = &#63; from the database.
	*
	* @param reportKey the report key
	* @return the report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report removeByKey(
		java.lang.String reportKey)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reports where reportKey = &#63;.
	*
	* @param reportKey the report key
	* @return the number of matching reports
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the report in the entity cache if it is enabled.
	*
	* @param report the report
	*/
	public void cacheResult(com.idetronic.eis.model.Report report);

	/**
	* Caches the reports in the entity cache if it is enabled.
	*
	* @param reports the reports
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.Report> reports);

	/**
	* Creates a new report with the primary key. Does not add the report to the database.
	*
	* @param reportId the primary key for the new report
	* @return the new report
	*/
	public com.idetronic.eis.model.Report create(long reportId);

	/**
	* Removes the report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the report
	* @return the report that was removed
	* @throws com.idetronic.eis.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report remove(long reportId)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.Report updateImpl(
		com.idetronic.eis.model.Report report)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report with the primary key or throws a {@link com.idetronic.eis.NoSuchReportException} if it could not be found.
	*
	* @param reportId the primary key of the report
	* @return the report
	* @throws com.idetronic.eis.NoSuchReportException if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report findByPrimaryKey(long reportId)
		throws com.idetronic.eis.NoSuchReportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportId the primary key of the report
	* @return the report, or <code>null</code> if a report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Report fetchByPrimaryKey(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reports.
	*
	* @return the reports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Report> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.Report> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.Report> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reports.
	*
	* @return the number of reports
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
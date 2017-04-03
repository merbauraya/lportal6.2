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

import com.idetronic.eis.model.FactIrSubmission;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact ir submission service. This utility wraps {@link FactIrSubmissionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrSubmissionPersistence
 * @see FactIrSubmissionPersistenceImpl
 * @generated
 */
public class FactIrSubmissionUtil {
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
	public static void clearCache(FactIrSubmission factIrSubmission) {
		getPersistence().clearCache(factIrSubmission);
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
	public static List<FactIrSubmission> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactIrSubmission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactIrSubmission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactIrSubmission update(FactIrSubmission factIrSubmission)
		throws SystemException {
		return getPersistence().update(factIrSubmission);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactIrSubmission update(FactIrSubmission factIrSubmission,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(factIrSubmission, serviceContext);
	}

	/**
	* Returns all the fact ir submissions where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @return the matching fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findByFacultyPeriod(
		long facultyId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFacultyPeriod(facultyId, period);
	}

	/**
	* Returns a range of all the fact ir submissions where facultyId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param start the lower bound of the range of fact ir submissions
	* @param end the upper bound of the range of fact ir submissions (not inclusive)
	* @return the range of matching fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findByFacultyPeriod(
		long facultyId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacultyPeriod(facultyId, period, start, end);
	}

	/**
	* Returns an ordered range of all the fact ir submissions where facultyId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param start the lower bound of the range of fact ir submissions
	* @param end the upper bound of the range of fact ir submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findByFacultyPeriod(
		long facultyId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacultyPeriod(facultyId, period, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir submission
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a matching fact ir submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission findByFacultyPeriod_First(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacultyPeriod_First(facultyId, period,
			orderByComparator);
	}

	/**
	* Returns the first fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir submission, or <code>null</code> if a matching fact ir submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission fetchByFacultyPeriod_First(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacultyPeriod_First(facultyId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir submission
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a matching fact ir submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission findByFacultyPeriod_Last(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacultyPeriod_Last(facultyId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir submission, or <code>null</code> if a matching fact ir submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission fetchByFacultyPeriod_Last(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFacultyPeriod_Last(facultyId, period,
			orderByComparator);
	}

	/**
	* Returns the fact ir submissions before and after the current fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param submissionId the primary key of the current fact ir submission
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact ir submission
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission[] findByFacultyPeriod_PrevAndNext(
		long submissionId, long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFacultyPeriod_PrevAndNext(submissionId, facultyId,
			period, orderByComparator);
	}

	/**
	* Removes all the fact ir submissions where facultyId = &#63; and period = &#63; from the database.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFacultyPeriod(long facultyId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFacultyPeriod(facultyId, period);
	}

	/**
	* Returns the number of fact ir submissions where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @return the number of matching fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFacultyPeriod(long facultyId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFacultyPeriod(facultyId, period);
	}

	/**
	* Caches the fact ir submission in the entity cache if it is enabled.
	*
	* @param factIrSubmission the fact ir submission
	*/
	public static void cacheResult(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission) {
		getPersistence().cacheResult(factIrSubmission);
	}

	/**
	* Caches the fact ir submissions in the entity cache if it is enabled.
	*
	* @param factIrSubmissions the fact ir submissions
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactIrSubmission> factIrSubmissions) {
		getPersistence().cacheResult(factIrSubmissions);
	}

	/**
	* Creates a new fact ir submission with the primary key. Does not add the fact ir submission to the database.
	*
	* @param submissionId the primary key for the new fact ir submission
	* @return the new fact ir submission
	*/
	public static com.idetronic.eis.model.FactIrSubmission create(
		long submissionId) {
		return getPersistence().create(submissionId);
	}

	/**
	* Removes the fact ir submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission that was removed
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission remove(
		long submissionId)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(submissionId);
	}

	public static com.idetronic.eis.model.FactIrSubmission updateImpl(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factIrSubmission);
	}

	/**
	* Returns the fact ir submission with the primary key or throws a {@link com.idetronic.eis.NoSuchFactIrSubmissionException} if it could not be found.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission findByPrimaryKey(
		long submissionId)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(submissionId);
	}

	/**
	* Returns the fact ir submission with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission, or <code>null</code> if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission fetchByPrimaryKey(
		long submissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(submissionId);
	}

	/**
	* Returns all the fact ir submissions.
	*
	* @return the fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact ir submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact ir submissions
	* @param end the upper bound of the range of fact ir submissions (not inclusive)
	* @return the range of fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact ir submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact ir submissions
	* @param end the upper bound of the range of fact ir submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact ir submissions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact ir submissions.
	*
	* @return the number of fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactIrSubmissionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactIrSubmissionPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactIrSubmissionPersistence.class.getName());

			ReferenceRegistry.registerReference(FactIrSubmissionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactIrSubmissionPersistence persistence) {
	}

	private static FactIrSubmissionPersistence _persistence;
}
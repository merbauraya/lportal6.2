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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact ir submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrSubmissionPersistenceImpl
 * @see FactIrSubmissionUtil
 * @generated
 */
public interface FactIrSubmissionPersistence extends BasePersistence<FactIrSubmission> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactIrSubmissionUtil} to access the fact ir submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact ir submissions where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @return the matching fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrSubmission> findByFacultyPeriod(
		long facultyId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactIrSubmission> findByFacultyPeriod(
		long facultyId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactIrSubmission> findByFacultyPeriod(
		long facultyId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactIrSubmission findByFacultyPeriod_First(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact ir submission, or <code>null</code> if a matching fact ir submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrSubmission fetchByFacultyPeriod_First(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactIrSubmission findByFacultyPeriod_Last(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact ir submission, or <code>null</code> if a matching fact ir submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrSubmission fetchByFacultyPeriod_Last(
		long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactIrSubmission[] findByFacultyPeriod_PrevAndNext(
		long submissionId, long facultyId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact ir submissions where facultyId = &#63; and period = &#63; from the database.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFacultyPeriod(long facultyId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact ir submissions where facultyId = &#63; and period = &#63;.
	*
	* @param facultyId the faculty ID
	* @param period the period
	* @return the number of matching fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByFacultyPeriod(long facultyId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact ir submission in the entity cache if it is enabled.
	*
	* @param factIrSubmission the fact ir submission
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission);

	/**
	* Caches the fact ir submissions in the entity cache if it is enabled.
	*
	* @param factIrSubmissions the fact ir submissions
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactIrSubmission> factIrSubmissions);

	/**
	* Creates a new fact ir submission with the primary key. Does not add the fact ir submission to the database.
	*
	* @param submissionId the primary key for the new fact ir submission
	* @return the new fact ir submission
	*/
	public com.idetronic.eis.model.FactIrSubmission create(long submissionId);

	/**
	* Removes the fact ir submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission that was removed
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrSubmission remove(long submissionId)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactIrSubmission updateImpl(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir submission with the primary key or throws a {@link com.idetronic.eis.NoSuchFactIrSubmissionException} if it could not be found.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission
	* @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrSubmission findByPrimaryKey(
		long submissionId)
		throws com.idetronic.eis.NoSuchFactIrSubmissionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact ir submission with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission, or <code>null</code> if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactIrSubmission fetchByPrimaryKey(
		long submissionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact ir submissions.
	*
	* @return the fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactIrSubmission> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactIrSubmission> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactIrSubmission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact ir submissions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact ir submissions.
	*
	* @return the number of fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.idetronic.eis.model.FactPost;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPostPersistenceImpl
 * @see FactPostUtil
 * @generated
 */
public interface FactPostPersistence extends BasePersistence<FactPost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactPostUtil} to access the fact post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact posts where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact posts where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact posts where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact posts before and after the current fact post in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param factPostId the primary key of the current fact post
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost[] findByLibraryPeriod_PrevAndNext(
		long factPostId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact posts where libraryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact posts where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact posts where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @return the matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByPostGrade(
		long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact posts where postGradeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param postGradeId the post grade ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByPostGrade(
		long postGradeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact posts where postGradeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param postGradeId the post grade ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByPostGrade(
		long postGradeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByPostGrade_First(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByPostGrade_First(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByPostGrade_Last(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact post in the ordered set where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByPostGrade_Last(
		long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact posts before and after the current fact post in the ordered set where postGradeId = &#63;.
	*
	* @param factPostId the primary key of the current fact post
	* @param postGradeId the post grade ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost[] findByPostGrade_PrevAndNext(
		long factPostId, long postGradeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact posts where postGradeId = &#63; from the database.
	*
	* @param postGradeId the post grade ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact posts where postGradeId = &#63;.
	*
	* @param postGradeId the post grade ID
	* @return the number of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByPostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact posts where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact posts where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact posts where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByLibrary_Last(long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact post in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact posts before and after the current fact post in the ordered set where libraryId = &#63;.
	*
	* @param factPostId the primary key of the current fact post
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost[] findByLibrary_PrevAndNext(
		long factPostId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact posts where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact posts where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact post in the entity cache if it is enabled.
	*
	* @param factPost the fact post
	*/
	public void cacheResult(com.idetronic.eis.model.FactPost factPost);

	/**
	* Caches the fact posts in the entity cache if it is enabled.
	*
	* @param factPosts the fact posts
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactPost> factPosts);

	/**
	* Creates a new fact post with the primary key. Does not add the fact post to the database.
	*
	* @param factPostId the primary key for the new fact post
	* @return the new fact post
	*/
	public com.idetronic.eis.model.FactPost create(long factPostId);

	/**
	* Removes the fact post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factPostId the primary key of the fact post
	* @return the fact post that was removed
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost remove(long factPostId)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactPost updateImpl(
		com.idetronic.eis.model.FactPost factPost)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact post with the primary key or throws a {@link com.idetronic.eis.NoSuchFactPostException} if it could not be found.
	*
	* @param factPostId the primary key of the fact post
	* @return the fact post
	* @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost findByPrimaryKey(long factPostId)
		throws com.idetronic.eis.NoSuchFactPostException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factPostId the primary key of the fact post
	* @return the fact post, or <code>null</code> if a fact post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPost fetchByPrimaryKey(long factPostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact posts.
	*
	* @return the fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @return the range of fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact posts
	* @param end the upper bound of the range of fact posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPost> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact posts.
	*
	* @return the number of fact posts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
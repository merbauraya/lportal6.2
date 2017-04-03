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

import com.idetronic.eis.model.UserLibrary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserLibraryPersistenceImpl
 * @see UserLibraryUtil
 * @generated
 */
public interface UserLibraryPersistence extends BasePersistence<UserLibrary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserLibraryUtil} to access the user library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user library where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserLibraryException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary findByuserLibrary(long userId,
		long libraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user library where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchByuserLibrary(long userId,
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user library where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchByuserLibrary(long userId,
		long libraryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user library where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the user library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary removeByuserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user libraries where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user libraries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findByuser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user libraries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user libraries
	* @param end the upper bound of the range of user libraries (not inclusive)
	* @return the range of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findByuser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user libraries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user libraries
	* @param end the upper bound of the range of user libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findByuser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary findByuser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchByuser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary findByuser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchByuser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user libraries before and after the current user library in the ordered set where userId = &#63;.
	*
	* @param userLibraryId the primary key of the current user library
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary[] findByuser_PrevAndNext(
		long userLibraryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user libraries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user libraries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countByuser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user libraries where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findBylibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user libraries where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of user libraries
	* @param end the upper bound of the range of user libraries (not inclusive)
	* @return the range of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findBylibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user libraries where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of user libraries
	* @param end the upper bound of the range of user libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findBylibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary findBylibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchBylibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary findBylibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchBylibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user libraries before and after the current user library in the ordered set where libraryId = &#63;.
	*
	* @param userLibraryId the primary key of the current user library
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary[] findBylibrary_PrevAndNext(
		long userLibraryId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user libraries where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBylibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user libraries where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countBylibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user library in the entity cache if it is enabled.
	*
	* @param userLibrary the user library
	*/
	public void cacheResult(com.idetronic.eis.model.UserLibrary userLibrary);

	/**
	* Caches the user libraries in the entity cache if it is enabled.
	*
	* @param userLibraries the user libraries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.UserLibrary> userLibraries);

	/**
	* Creates a new user library with the primary key. Does not add the user library to the database.
	*
	* @param userLibraryId the primary key for the new user library
	* @return the new user library
	*/
	public com.idetronic.eis.model.UserLibrary create(long userLibraryId);

	/**
	* Removes the user library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library that was removed
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary remove(long userLibraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.UserLibrary updateImpl(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user library with the primary key or throws a {@link com.idetronic.eis.NoSuchUserLibraryException} if it could not be found.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary findByPrimaryKey(
		long userLibraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library, or <code>null</code> if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserLibrary fetchByPrimaryKey(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user libraries.
	*
	* @return the user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user libraries
	* @param end the upper bound of the range of user libraries (not inclusive)
	* @return the range of user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user libraries
	* @param end the upper bound of the range of user libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserLibrary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user libraries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user libraries.
	*
	* @return the number of user libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
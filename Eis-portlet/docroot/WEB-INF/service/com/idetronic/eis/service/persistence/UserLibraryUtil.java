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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user library service. This utility wraps {@link UserLibraryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserLibraryPersistence
 * @see UserLibraryPersistenceImpl
 * @generated
 */
public class UserLibraryUtil {
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
	public static void clearCache(UserLibrary userLibrary) {
		getPersistence().clearCache(userLibrary);
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
	public static List<UserLibrary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserLibrary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserLibrary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserLibrary update(UserLibrary userLibrary)
		throws SystemException {
		return getPersistence().update(userLibrary);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserLibrary update(UserLibrary userLibrary,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userLibrary, serviceContext);
	}

	/**
	* Returns the user library where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserLibraryException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary findByuserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserLibrary(userId, libraryId);
	}

	/**
	* Returns the user library where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchByuserLibrary(
		long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserLibrary(userId, libraryId);
	}

	/**
	* Returns the user library where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchByuserLibrary(
		long userId, long libraryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserLibrary(userId, libraryId, retrieveFromCache);
	}

	/**
	* Removes the user library where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the user library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary removeByuserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByuserLibrary(userId, libraryId);
	}

	/**
	* Returns the number of user libraries where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserLibrary(userId, libraryId);
	}

	/**
	* Returns all the user libraries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findByuser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuser(userId);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findByuser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuser(userId, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findByuser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary findByuser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuser_First(userId, orderByComparator);
	}

	/**
	* Returns the first user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchByuser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuser_First(userId, orderByComparator);
	}

	/**
	* Returns the last user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary findByuser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user library in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchByuser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuser_Last(userId, orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserLibrary[] findByuser_PrevAndNext(
		long userLibraryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuser_PrevAndNext(userLibraryId, userId,
			orderByComparator);
	}

	/**
	* Removes all the user libraries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuser(userId);
	}

	/**
	* Returns the number of user libraries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuser(userId);
	}

	/**
	* Returns all the user libraries where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findBylibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylibrary(libraryId);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findBylibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylibrary(libraryId, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findBylibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylibrary(libraryId, start, end, orderByComparator);
	}

	/**
	* Returns the first user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary findBylibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the first user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchBylibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the last user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary findBylibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the last user library in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user library, or <code>null</code> if a matching user library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchBylibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylibrary_Last(libraryId, orderByComparator);
	}

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
	public static com.idetronic.eis.model.UserLibrary[] findBylibrary_PrevAndNext(
		long userLibraryId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylibrary_PrevAndNext(userLibraryId, libraryId,
			orderByComparator);
	}

	/**
	* Removes all the user libraries where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylibrary(libraryId);
	}

	/**
	* Returns the number of user libraries where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylibrary(libraryId);
	}

	/**
	* Caches the user library in the entity cache if it is enabled.
	*
	* @param userLibrary the user library
	*/
	public static void cacheResult(
		com.idetronic.eis.model.UserLibrary userLibrary) {
		getPersistence().cacheResult(userLibrary);
	}

	/**
	* Caches the user libraries in the entity cache if it is enabled.
	*
	* @param userLibraries the user libraries
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.UserLibrary> userLibraries) {
		getPersistence().cacheResult(userLibraries);
	}

	/**
	* Creates a new user library with the primary key. Does not add the user library to the database.
	*
	* @param userLibraryId the primary key for the new user library
	* @return the new user library
	*/
	public static com.idetronic.eis.model.UserLibrary create(long userLibraryId) {
		return getPersistence().create(userLibraryId);
	}

	/**
	* Removes the user library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library that was removed
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary remove(long userLibraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userLibraryId);
	}

	public static com.idetronic.eis.model.UserLibrary updateImpl(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userLibrary);
	}

	/**
	* Returns the user library with the primary key or throws a {@link com.idetronic.eis.NoSuchUserLibraryException} if it could not be found.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library
	* @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary findByPrimaryKey(
		long userLibraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userLibraryId);
	}

	/**
	* Returns the user library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library, or <code>null</code> if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary fetchByPrimaryKey(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userLibraryId);
	}

	/**
	* Returns all the user libraries.
	*
	* @return the user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user libraries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user libraries.
	*
	* @return the number of user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserLibraryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserLibraryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					UserLibraryPersistence.class.getName());

			ReferenceRegistry.registerReference(UserLibraryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserLibraryPersistence persistence) {
	}

	private static UserLibraryPersistence _persistence;
}
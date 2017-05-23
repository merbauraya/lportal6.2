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

import com.idetronic.eis.model.UserData;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user data service. This utility wraps {@link UserDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserDataPersistence
 * @see UserDataPersistenceImpl
 * @generated
 */
public class UserDataUtil {
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
	public static void clearCache(UserData userData) {
		getPersistence().clearCache(userData);
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
	public static List<UserData> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserData update(UserData userData) throws SystemException {
		return getPersistence().update(userData);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserData update(UserData userData,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userData, serviceContext);
	}

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; and dataId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserDataException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByUserDataLibrary(
		long userId, long libraryId, long dataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserDataLibrary(userId, libraryId, dataId);
	}

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; and dataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByUserDataLibrary(
		long userId, long libraryId, long dataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserDataLibrary(userId, libraryId, dataId);
	}

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; and dataId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByUserDataLibrary(
		long userId, long libraryId, long dataId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserDataLibrary(userId, libraryId, dataId,
			retrieveFromCache);
	}

	/**
	* Removes the user data where userId = &#63; and libraryId = &#63; and dataId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the user data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData removeByUserDataLibrary(
		long userId, long libraryId, long dataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByUserDataLibrary(userId, libraryId, dataId);
	}

	/**
	* Returns the number of user datas where userId = &#63; and libraryId = &#63; and dataId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserDataLibrary(long userId, long libraryId,
		long dataId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserDataLibrary(userId, libraryId, dataId);
	}

	/**
	* Returns all the user datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the user datas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user datas
	* @param end the upper bound of the range of user datas (not inclusive)
	* @return the range of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the user datas where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user datas
	* @param end the upper bound of the range of user datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the user datas before and after the current user data in the ordered set where userId = &#63;.
	*
	* @param userDataId the primary key of the current user data
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData[] findByUser_PrevAndNext(
		long userDataId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUser_PrevAndNext(userDataId, userId, orderByComparator);
	}

	/**
	* Removes all the user datas where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of user datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the user datas where dataId = &#63;.
	*
	* @param dataId the data ID
	* @return the matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findByData(
		long dataId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByData(dataId);
	}

	/**
	* Returns a range of all the user datas where dataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataId the data ID
	* @param start the lower bound of the range of user datas
	* @param end the upper bound of the range of user datas (not inclusive)
	* @return the range of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findByData(
		long dataId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByData(dataId, start, end);
	}

	/**
	* Returns an ordered range of all the user datas where dataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dataId the data ID
	* @param start the lower bound of the range of user datas
	* @param end the upper bound of the range of user datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findByData(
		long dataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByData(dataId, start, end, orderByComparator);
	}

	/**
	* Returns the first user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByData_First(
		long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByData_First(dataId, orderByComparator);
	}

	/**
	* Returns the first user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByData_First(
		long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByData_First(dataId, orderByComparator);
	}

	/**
	* Returns the last user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByData_Last(
		long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByData_Last(dataId, orderByComparator);
	}

	/**
	* Returns the last user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByData_Last(
		long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByData_Last(dataId, orderByComparator);
	}

	/**
	* Returns the user datas before and after the current user data in the ordered set where dataId = &#63;.
	*
	* @param userDataId the primary key of the current user data
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData[] findByData_PrevAndNext(
		long userDataId, long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByData_PrevAndNext(userDataId, dataId, orderByComparator);
	}

	/**
	* Removes all the user datas where dataId = &#63; from the database.
	*
	* @param dataId the data ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByData(long dataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByData(dataId);
	}

	/**
	* Returns the number of user datas where dataId = &#63;.
	*
	* @param dataId the data ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByData(long dataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByData(dataId);
	}

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserDataException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByUserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserLibrary(userId, libraryId);
	}

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByUserLibrary(
		long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserLibrary(userId, libraryId);
	}

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByUserLibrary(
		long userId, long libraryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserLibrary(userId, libraryId, retrieveFromCache);
	}

	/**
	* Removes the user data where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the user data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData removeByUserLibrary(
		long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUserLibrary(userId, libraryId);
	}

	/**
	* Returns the number of user datas where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserLibrary(userId, libraryId);
	}

	/**
	* Caches the user data in the entity cache if it is enabled.
	*
	* @param userData the user data
	*/
	public static void cacheResult(com.idetronic.eis.model.UserData userData) {
		getPersistence().cacheResult(userData);
	}

	/**
	* Caches the user datas in the entity cache if it is enabled.
	*
	* @param userDatas the user datas
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.UserData> userDatas) {
		getPersistence().cacheResult(userDatas);
	}

	/**
	* Creates a new user data with the primary key. Does not add the user data to the database.
	*
	* @param userDataId the primary key for the new user data
	* @return the new user data
	*/
	public static com.idetronic.eis.model.UserData create(long userDataId) {
		return getPersistence().create(userDataId);
	}

	/**
	* Removes the user data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDataId the primary key of the user data
	* @return the user data that was removed
	* @throws com.idetronic.eis.NoSuchUserDataException if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData remove(long userDataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userDataId);
	}

	public static com.idetronic.eis.model.UserData updateImpl(
		com.idetronic.eis.model.UserData userData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userData);
	}

	/**
	* Returns the user data with the primary key or throws a {@link com.idetronic.eis.NoSuchUserDataException} if it could not be found.
	*
	* @param userDataId the primary key of the user data
	* @return the user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData findByPrimaryKey(
		long userDataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userDataId);
	}

	/**
	* Returns the user data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userDataId the primary key of the user data
	* @return the user data, or <code>null</code> if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserData fetchByPrimaryKey(
		long userDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userDataId);
	}

	/**
	* Returns all the user datas.
	*
	* @return the user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user datas
	* @param end the upper bound of the range of user datas (not inclusive)
	* @return the range of user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user datas
	* @param end the upper bound of the range of user datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user datas.
	*
	* @return the number of user datas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserDataPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserDataPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					UserDataPersistence.class.getName());

			ReferenceRegistry.registerReference(UserDataUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserDataPersistence persistence) {
	}

	private static UserDataPersistence _persistence;
}
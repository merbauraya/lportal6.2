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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserDataPersistenceImpl
 * @see UserDataUtil
 * @generated
 */
public interface UserDataPersistence extends BasePersistence<UserData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserDataUtil} to access the user data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

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
	public com.idetronic.eis.model.UserData findByUserDataLibrary(long userId,
		long libraryId, long dataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; and dataId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByUserDataLibrary(
		long userId, long libraryId, long dataId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.UserData fetchByUserDataLibrary(
		long userId, long libraryId, long dataId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user data where userId = &#63; and libraryId = &#63; and dataId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the user data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData removeByUserDataLibrary(
		long userId, long libraryId, long dataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user datas where userId = &#63; and libraryId = &#63; and dataId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param dataId the data ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserDataLibrary(long userId, long libraryId, long dataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserData> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.UserData> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.UserData> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user data in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.UserData[] findByUser_PrevAndNext(
		long userDataId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user datas where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user datas where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user datas where dataId = &#63;.
	*
	* @param dataId the data ID
	* @return the matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserData> findByData(
		long dataId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.UserData> findByData(
		long dataId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.UserData> findByData(
		long dataId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData findByData_First(long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByData_First(long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData findByData_Last(long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user data in the ordered set where dataId = &#63;.
	*
	* @param dataId the data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByData_Last(long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.UserData[] findByData_PrevAndNext(
		long userDataId, long dataId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user datas where dataId = &#63; from the database.
	*
	* @param dataId the data ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByData(long dataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user datas where dataId = &#63;.
	*
	* @param dataId the data ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByData(long dataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserDataException} if it could not be found.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData findByUserLibrary(long userId,
		long libraryId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByUserLibrary(long userId,
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user data where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user data, or <code>null</code> if a matching user data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByUserLibrary(long userId,
		long libraryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user data where userId = &#63; and libraryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the user data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData removeByUserLibrary(long userId,
		long libraryId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user datas where userId = &#63; and libraryId = &#63;.
	*
	* @param userId the user ID
	* @param libraryId the library ID
	* @return the number of matching user datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserLibrary(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user data in the entity cache if it is enabled.
	*
	* @param userData the user data
	*/
	public void cacheResult(com.idetronic.eis.model.UserData userData);

	/**
	* Caches the user datas in the entity cache if it is enabled.
	*
	* @param userDatas the user datas
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.UserData> userDatas);

	/**
	* Creates a new user data with the primary key. Does not add the user data to the database.
	*
	* @param userDataId the primary key for the new user data
	* @return the new user data
	*/
	public com.idetronic.eis.model.UserData create(long userDataId);

	/**
	* Removes the user data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDataId the primary key of the user data
	* @return the user data that was removed
	* @throws com.idetronic.eis.NoSuchUserDataException if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData remove(long userDataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.UserData updateImpl(
		com.idetronic.eis.model.UserData userData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user data with the primary key or throws a {@link com.idetronic.eis.NoSuchUserDataException} if it could not be found.
	*
	* @param userDataId the primary key of the user data
	* @return the user data
	* @throws com.idetronic.eis.NoSuchUserDataException if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData findByPrimaryKey(long userDataId)
		throws com.idetronic.eis.NoSuchUserDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userDataId the primary key of the user data
	* @return the user data, or <code>null</code> if a user data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.UserData fetchByPrimaryKey(long userDataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user datas.
	*
	* @return the user datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.UserData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.UserData> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.UserData> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user datas.
	*
	* @return the number of user datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
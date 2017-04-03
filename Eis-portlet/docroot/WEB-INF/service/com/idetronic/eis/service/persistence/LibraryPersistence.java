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

import com.idetronic.eis.model.Library;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibraryPersistenceImpl
 * @see LibraryUtil
 * @generated
 */
public interface LibraryPersistence extends BasePersistence<Library> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibraryUtil} to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the library where libraryCode = &#63; or throws a {@link com.idetronic.eis.NoSuchLibraryException} if it could not be found.
	*
	* @param libraryCode the library code
	* @return the matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library findBylibraryCode(
		java.lang.String libraryCode)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library where libraryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param libraryCode the library code
	* @return the matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchBylibraryCode(
		java.lang.String libraryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library where libraryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param libraryCode the library code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchBylibraryCode(
		java.lang.String libraryCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the library where libraryCode = &#63; from the database.
	*
	* @param libraryCode the library code
	* @return the library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library removeBylibraryCode(
		java.lang.String libraryCode)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of libraries where libraryCode = &#63;.
	*
	* @param libraryCode the library code
	* @return the number of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countBylibraryCode(java.lang.String libraryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library where libraryName = &#63; or throws a {@link com.idetronic.eis.NoSuchLibraryException} if it could not be found.
	*
	* @param libraryName the library name
	* @return the matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library findBylibraryName(
		java.lang.String libraryName)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library where libraryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param libraryName the library name
	* @return the matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchBylibraryName(
		java.lang.String libraryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library where libraryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param libraryName the library name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchBylibraryName(
		java.lang.String libraryName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the library where libraryName = &#63; from the database.
	*
	* @param libraryName the library name
	* @return the library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library removeBylibraryName(
		java.lang.String libraryName)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of libraries where libraryName = &#63;.
	*
	* @param libraryName the library name
	* @return the number of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countBylibraryName(java.lang.String libraryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the libraries where stateId = &#63;.
	*
	* @param stateId the state ID
	* @return the matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the libraries where stateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stateId the state ID
	* @param start the lower bound of the range of libraries
	* @param end the upper bound of the range of libraries (not inclusive)
	* @return the range of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the libraries where stateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stateId the state ID
	* @param start the lower bound of the range of libraries
	* @param end the upper bound of the range of libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library findByState_First(long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchByState_First(long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library findByState_Last(long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchByState_Last(long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the libraries before and after the current library in the ordered set where stateId = &#63;.
	*
	* @param libraryId the primary key of the current library
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next library
	* @throws com.idetronic.eis.NoSuchLibraryException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library[] findByState_PrevAndNext(
		long libraryId, long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the libraries where stateId = &#63; from the database.
	*
	* @param stateId the state ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByState(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of libraries where stateId = &#63;.
	*
	* @param stateId the state ID
	* @return the number of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countByState(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the library in the entity cache if it is enabled.
	*
	* @param library the library
	*/
	public void cacheResult(com.idetronic.eis.model.Library library);

	/**
	* Caches the libraries in the entity cache if it is enabled.
	*
	* @param libraries the libraries
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.Library> libraries);

	/**
	* Creates a new library with the primary key. Does not add the library to the database.
	*
	* @param libraryId the primary key for the new library
	* @return the new library
	*/
	public com.idetronic.eis.model.Library create(long libraryId);

	/**
	* Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryId the primary key of the library
	* @return the library that was removed
	* @throws com.idetronic.eis.NoSuchLibraryException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library remove(long libraryId)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.Library updateImpl(
		com.idetronic.eis.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library with the primary key or throws a {@link com.idetronic.eis.NoSuchLibraryException} if it could not be found.
	*
	* @param libraryId the primary key of the library
	* @return the library
	* @throws com.idetronic.eis.NoSuchLibraryException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library findByPrimaryKey(long libraryId)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryId the primary key of the library
	* @return the library, or <code>null</code> if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.Library fetchByPrimaryKey(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the libraries.
	*
	* @return the libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Library> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of libraries
	* @param end the upper bound of the range of libraries (not inclusive)
	* @return the range of libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Library> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of libraries
	* @param end the upper bound of the range of libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of libraries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.Library> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the libraries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of libraries.
	*
	* @return the number of libraries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
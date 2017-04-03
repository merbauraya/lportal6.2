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

import com.idetronic.eis.model.LibraryType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the library type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibraryTypePersistenceImpl
 * @see LibraryTypeUtil
 * @generated
 */
public interface LibraryTypePersistence extends BasePersistence<LibraryType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibraryTypeUtil} to access the library type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the library type where libraryTypeCode = &#63; or throws a {@link com.idetronic.eis.NoSuchLibraryTypeException} if it could not be found.
	*
	* @param libraryTypeCode the library type code
	* @return the matching library type
	* @throws com.idetronic.eis.NoSuchLibraryTypeException if a matching library type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType findByCode(
		java.lang.String libraryTypeCode)
		throws com.idetronic.eis.NoSuchLibraryTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library type where libraryTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param libraryTypeCode the library type code
	* @return the matching library type, or <code>null</code> if a matching library type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType fetchByCode(
		java.lang.String libraryTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library type where libraryTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param libraryTypeCode the library type code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching library type, or <code>null</code> if a matching library type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType fetchByCode(
		java.lang.String libraryTypeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the library type where libraryTypeCode = &#63; from the database.
	*
	* @param libraryTypeCode the library type code
	* @return the library type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType removeByCode(
		java.lang.String libraryTypeCode)
		throws com.idetronic.eis.NoSuchLibraryTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of library types where libraryTypeCode = &#63;.
	*
	* @param libraryTypeCode the library type code
	* @return the number of matching library types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String libraryTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the library type in the entity cache if it is enabled.
	*
	* @param libraryType the library type
	*/
	public void cacheResult(com.idetronic.eis.model.LibraryType libraryType);

	/**
	* Caches the library types in the entity cache if it is enabled.
	*
	* @param libraryTypes the library types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.LibraryType> libraryTypes);

	/**
	* Creates a new library type with the primary key. Does not add the library type to the database.
	*
	* @param libraryTypeId the primary key for the new library type
	* @return the new library type
	*/
	public com.idetronic.eis.model.LibraryType create(long libraryTypeId);

	/**
	* Removes the library type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type that was removed
	* @throws com.idetronic.eis.NoSuchLibraryTypeException if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType remove(long libraryTypeId)
		throws com.idetronic.eis.NoSuchLibraryTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.LibraryType updateImpl(
		com.idetronic.eis.model.LibraryType libraryType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library type with the primary key or throws a {@link com.idetronic.eis.NoSuchLibraryTypeException} if it could not be found.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type
	* @throws com.idetronic.eis.NoSuchLibraryTypeException if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType findByPrimaryKey(
		long libraryTypeId)
		throws com.idetronic.eis.NoSuchLibraryTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the library type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryTypeId the primary key of the library type
	* @return the library type, or <code>null</code> if a library type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.LibraryType fetchByPrimaryKey(
		long libraryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the library types.
	*
	* @return the library types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.LibraryType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the library types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library types
	* @param end the upper bound of the range of library types (not inclusive)
	* @return the range of library types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.LibraryType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the library types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of library types
	* @param end the upper bound of the range of library types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of library types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.LibraryType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the library types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of library types.
	*
	* @return the number of library types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
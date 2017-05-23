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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the library service. This utility wraps {@link LibraryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibraryPersistence
 * @see LibraryPersistenceImpl
 * @generated
 */
public class LibraryUtil {
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
	public static void clearCache(Library library) {
		getPersistence().clearCache(library);
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
	public static List<Library> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Library> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Library> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Library update(Library library) throws SystemException {
		return getPersistence().update(library);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Library update(Library library, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(library, serviceContext);
	}

	/**
	* Returns the library where libraryName = &#63; or throws a {@link com.idetronic.eis.NoSuchLibraryException} if it could not be found.
	*
	* @param libraryName the library name
	* @return the matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library findBylibraryName(
		java.lang.String libraryName)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylibraryName(libraryName);
	}

	/**
	* Returns the library where libraryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param libraryName the library name
	* @return the matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library fetchBylibraryName(
		java.lang.String libraryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylibraryName(libraryName);
	}

	/**
	* Returns the library where libraryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param libraryName the library name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library fetchBylibraryName(
		java.lang.String libraryName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylibraryName(libraryName, retrieveFromCache);
	}

	/**
	* Removes the library where libraryName = &#63; from the database.
	*
	* @param libraryName the library name
	* @return the library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library removeBylibraryName(
		java.lang.String libraryName)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBylibraryName(libraryName);
	}

	/**
	* Returns the number of libraries where libraryName = &#63;.
	*
	* @param libraryName the library name
	* @return the number of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylibraryName(java.lang.String libraryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylibraryName(libraryName);
	}

	/**
	* Returns all the libraries where stateId = &#63;.
	*
	* @param stateId the state ID
	* @return the matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByState(stateId);
	}

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
	public static java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByState(stateId, start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByState(stateId, start, end, orderByComparator);
	}

	/**
	* Returns the first library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library findByState_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByState_First(stateId, orderByComparator);
	}

	/**
	* Returns the first library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library fetchByState_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByState_First(stateId, orderByComparator);
	}

	/**
	* Returns the last library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching library
	* @throws com.idetronic.eis.NoSuchLibraryException if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library findByState_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByState_Last(stateId, orderByComparator);
	}

	/**
	* Returns the last library in the ordered set where stateId = &#63;.
	*
	* @param stateId the state ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching library, or <code>null</code> if a matching library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library fetchByState_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByState_Last(stateId, orderByComparator);
	}

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
	public static com.idetronic.eis.model.Library[] findByState_PrevAndNext(
		long libraryId, long stateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByState_PrevAndNext(libraryId, stateId,
			orderByComparator);
	}

	/**
	* Removes all the libraries where stateId = &#63; from the database.
	*
	* @param stateId the state ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByState(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByState(stateId);
	}

	/**
	* Returns the number of libraries where stateId = &#63;.
	*
	* @param stateId the state ID
	* @return the number of matching libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByState(long stateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByState(stateId);
	}

	/**
	* Caches the library in the entity cache if it is enabled.
	*
	* @param library the library
	*/
	public static void cacheResult(com.idetronic.eis.model.Library library) {
		getPersistence().cacheResult(library);
	}

	/**
	* Caches the libraries in the entity cache if it is enabled.
	*
	* @param libraries the libraries
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.Library> libraries) {
		getPersistence().cacheResult(libraries);
	}

	/**
	* Creates a new library with the primary key. Does not add the library to the database.
	*
	* @param libraryId the primary key for the new library
	* @return the new library
	*/
	public static com.idetronic.eis.model.Library create(long libraryId) {
		return getPersistence().create(libraryId);
	}

	/**
	* Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryId the primary key of the library
	* @return the library that was removed
	* @throws com.idetronic.eis.NoSuchLibraryException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library remove(long libraryId)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(libraryId);
	}

	public static com.idetronic.eis.model.Library updateImpl(
		com.idetronic.eis.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(library);
	}

	/**
	* Returns the library with the primary key or throws a {@link com.idetronic.eis.NoSuchLibraryException} if it could not be found.
	*
	* @param libraryId the primary key of the library
	* @return the library
	* @throws com.idetronic.eis.NoSuchLibraryException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library findByPrimaryKey(
		long libraryId)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(libraryId);
	}

	/**
	* Returns the library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param libraryId the primary key of the library
	* @return the library, or <code>null</code> if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library fetchByPrimaryKey(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(libraryId);
	}

	/**
	* Returns all the libraries.
	*
	* @return the libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Library> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eis.model.Library> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.Library> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the libraries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of libraries.
	*
	* @return the number of libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LibraryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LibraryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					LibraryPersistence.class.getName());

			ReferenceRegistry.registerReference(LibraryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LibraryPersistence persistence) {
	}

	private static LibraryPersistence _persistence;
}
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

import com.idetronic.eis.model.FactPrintedMaterial;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact printed material service. This utility wraps {@link FactPrintedMaterialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPrintedMaterialPersistence
 * @see FactPrintedMaterialPersistenceImpl
 * @generated
 */
public class FactPrintedMaterialUtil {
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
	public static void clearCache(FactPrintedMaterial factPrintedMaterial) {
		getPersistence().clearCache(factPrintedMaterial);
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
	public static List<FactPrintedMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactPrintedMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactPrintedMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactPrintedMaterial update(
		FactPrintedMaterial factPrintedMaterial) throws SystemException {
		return getPersistence().update(factPrintedMaterial);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactPrintedMaterial update(
		FactPrintedMaterial factPrintedMaterial, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(factPrintedMaterial, serviceContext);
	}

	/**
	* Returns all the fact printed materials where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary(libraryId);
	}

	/**
	* Returns a range of all the fact printed materials where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact printed materials
	* @param end the upper bound of the range of fact printed materials (not inclusive)
	* @return the range of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary(libraryId, start, end);
	}

	/**
	* Returns an ordered range of all the fact printed materials where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact printed materials
	* @param end the upper bound of the range of fact printed materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibrary(libraryId, start, end, orderByComparator);
	}

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibrary_First(libraryId, orderByComparator);
	}

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibrary_Last(libraryId, orderByComparator);
	}

	/**
	* Returns the fact printed materials before and after the current fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param factPrintedMaterialId the primary key of the current fact printed material
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial[] findByLibrary_PrevAndNext(
		long factPrintedMaterialId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibrary_PrevAndNext(factPrintedMaterialId, libraryId,
			orderByComparator);
	}

	/**
	* Removes all the fact printed materials where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibrary(libraryId);
	}

	/**
	* Returns the number of fact printed materials where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibrary(libraryId);
	}

	/**
	* Returns all the fact printed materials where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns a range of all the fact printed materials where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact printed materials
	* @param end the upper bound of the range of fact printed materials (not inclusive)
	* @return the range of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod(libraryId, period, start, end);
	}

	/**
	* Returns an ordered range of all the fact printed materials where libraryId = &#63; and period = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param period the period
	* @param start the lower bound of the range of fact printed materials
	* @param end the upper bound of the range of fact printed materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod(libraryId, period, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_First(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibraryPeriod_First(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_Last(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLibraryPeriod_Last(libraryId, period,
			orderByComparator);
	}

	/**
	* Returns the fact printed materials before and after the current fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param factPrintedMaterialId the primary key of the current fact printed material
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial[] findByLibraryPeriod_PrevAndNext(
		long factPrintedMaterialId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibraryPeriod_PrevAndNext(factPrintedMaterialId,
			libraryId, period, orderByComparator);
	}

	/**
	* Removes all the fact printed materials where libraryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibraryPeriod(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibraryPeriod(libraryId, period);
	}

	/**
	* Returns the number of fact printed materials where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibraryPeriod(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibraryPeriod(libraryId, period);
	}

	/**
	* Caches the fact printed material in the entity cache if it is enabled.
	*
	* @param factPrintedMaterial the fact printed material
	*/
	public static void cacheResult(
		com.idetronic.eis.model.FactPrintedMaterial factPrintedMaterial) {
		getPersistence().cacheResult(factPrintedMaterial);
	}

	/**
	* Caches the fact printed materials in the entity cache if it is enabled.
	*
	* @param factPrintedMaterials the fact printed materials
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactPrintedMaterial> factPrintedMaterials) {
		getPersistence().cacheResult(factPrintedMaterials);
	}

	/**
	* Creates a new fact printed material with the primary key. Does not add the fact printed material to the database.
	*
	* @param factPrintedMaterialId the primary key for the new fact printed material
	* @return the new fact printed material
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial create(
		long factPrintedMaterialId) {
		return getPersistence().create(factPrintedMaterialId);
	}

	/**
	* Removes the fact printed material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factPrintedMaterialId the primary key of the fact printed material
	* @return the fact printed material that was removed
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial remove(
		long factPrintedMaterialId)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(factPrintedMaterialId);
	}

	public static com.idetronic.eis.model.FactPrintedMaterial updateImpl(
		com.idetronic.eis.model.FactPrintedMaterial factPrintedMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factPrintedMaterial);
	}

	/**
	* Returns the fact printed material with the primary key or throws a {@link com.idetronic.eis.NoSuchFactPrintedMaterialException} if it could not be found.
	*
	* @param factPrintedMaterialId the primary key of the fact printed material
	* @return the fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial findByPrimaryKey(
		long factPrintedMaterialId)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(factPrintedMaterialId);
	}

	/**
	* Returns the fact printed material with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factPrintedMaterialId the primary key of the fact printed material
	* @return the fact printed material, or <code>null</code> if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactPrintedMaterial fetchByPrimaryKey(
		long factPrintedMaterialId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(factPrintedMaterialId);
	}

	/**
	* Returns all the fact printed materials.
	*
	* @return the fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact printed materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact printed materials
	* @param end the upper bound of the range of fact printed materials (not inclusive)
	* @return the range of fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact printed materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact printed materials
	* @param end the upper bound of the range of fact printed materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact printed materials from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact printed materials.
	*
	* @return the number of fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactPrintedMaterialPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactPrintedMaterialPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactPrintedMaterialPersistence.class.getName());

			ReferenceRegistry.registerReference(FactPrintedMaterialUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactPrintedMaterialPersistence persistence) {
	}

	private static FactPrintedMaterialPersistence _persistence;
}
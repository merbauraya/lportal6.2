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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact printed material service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPrintedMaterialPersistenceImpl
 * @see FactPrintedMaterialUtil
 * @generated
 */
public interface FactPrintedMaterialPersistence extends BasePersistence<FactPrintedMaterial> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactPrintedMaterialUtil} to access the fact printed material persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact printed materials where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactPrintedMaterial[] findByLibrary_PrevAndNext(
		long factPrintedMaterialId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact printed materials where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact printed materials where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact printed materials where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findByLibraryPeriod(
		long libraryId, java.lang.String period, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactPrintedMaterial findByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial fetchByLibraryPeriod_First(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactPrintedMaterial findByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial fetchByLibraryPeriod_Last(
		long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.FactPrintedMaterial[] findByLibraryPeriod_PrevAndNext(
		long factPrintedMaterialId, long libraryId, java.lang.String period,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact printed materials where libraryId = &#63; and period = &#63; from the database.
	*
	* @param libraryId the library ID
	* @param period the period
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact printed materials where libraryId = &#63; and period = &#63;.
	*
	* @param libraryId the library ID
	* @param period the period
	* @return the number of matching fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibraryPeriod(long libraryId, java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact printed material in the entity cache if it is enabled.
	*
	* @param factPrintedMaterial the fact printed material
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactPrintedMaterial factPrintedMaterial);

	/**
	* Caches the fact printed materials in the entity cache if it is enabled.
	*
	* @param factPrintedMaterials the fact printed materials
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactPrintedMaterial> factPrintedMaterials);

	/**
	* Creates a new fact printed material with the primary key. Does not add the fact printed material to the database.
	*
	* @param factPrintedMaterialId the primary key for the new fact printed material
	* @return the new fact printed material
	*/
	public com.idetronic.eis.model.FactPrintedMaterial create(
		long factPrintedMaterialId);

	/**
	* Removes the fact printed material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factPrintedMaterialId the primary key of the fact printed material
	* @return the fact printed material that was removed
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial remove(
		long factPrintedMaterialId)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactPrintedMaterial updateImpl(
		com.idetronic.eis.model.FactPrintedMaterial factPrintedMaterial)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact printed material with the primary key or throws a {@link com.idetronic.eis.NoSuchFactPrintedMaterialException} if it could not be found.
	*
	* @param factPrintedMaterialId the primary key of the fact printed material
	* @return the fact printed material
	* @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial findByPrimaryKey(
		long factPrintedMaterialId)
		throws com.idetronic.eis.NoSuchFactPrintedMaterialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact printed material with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factPrintedMaterialId the primary key of the fact printed material
	* @return the fact printed material, or <code>null</code> if a fact printed material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactPrintedMaterial fetchByPrimaryKey(
		long factPrintedMaterialId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact printed materials.
	*
	* @return the fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.FactPrintedMaterial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact printed materials from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact printed materials.
	*
	* @return the number of fact printed materials
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
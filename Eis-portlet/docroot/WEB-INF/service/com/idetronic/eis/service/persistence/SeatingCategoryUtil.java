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

import com.idetronic.eis.model.SeatingCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the seating category service. This utility wraps {@link SeatingCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingCategoryPersistence
 * @see SeatingCategoryPersistenceImpl
 * @generated
 */
public class SeatingCategoryUtil {
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
	public static void clearCache(SeatingCategory seatingCategory) {
		getPersistence().clearCache(seatingCategory);
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
	public static List<SeatingCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SeatingCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SeatingCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SeatingCategory update(SeatingCategory seatingCategory)
		throws SystemException {
		return getPersistence().update(seatingCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SeatingCategory update(SeatingCategory seatingCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(seatingCategory, serviceContext);
	}

	/**
	* Returns all the seating categories where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @return the matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> findByDepartment(
		long seatingDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartment(seatingDepartmentId);
	}

	/**
	* Returns a range of all the seating categories where seatingDepartmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param seatingDepartmentId the seating department ID
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @return the range of matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> findByDepartment(
		long seatingDepartmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartment(seatingDepartmentId, start, end);
	}

	/**
	* Returns an ordered range of all the seating categories where seatingDepartmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param seatingDepartmentId the seating department ID
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> findByDepartment(
		long seatingDepartmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartment(seatingDepartmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory findByDepartment_First(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartment_First(seatingDepartmentId,
			orderByComparator);
	}

	/**
	* Returns the first seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching seating category, or <code>null</code> if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory fetchByDepartment_First(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_First(seatingDepartmentId,
			orderByComparator);
	}

	/**
	* Returns the last seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory findByDepartment_Last(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartment_Last(seatingDepartmentId, orderByComparator);
	}

	/**
	* Returns the last seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching seating category, or <code>null</code> if a matching seating category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory fetchByDepartment_Last(
		long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_Last(seatingDepartmentId,
			orderByComparator);
	}

	/**
	* Returns the seating categories before and after the current seating category in the ordered set where seatingDepartmentId = &#63;.
	*
	* @param seatingCategoryId the primary key of the current seating category
	* @param seatingDepartmentId the seating department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory[] findByDepartment_PrevAndNext(
		long seatingCategoryId, long seatingDepartmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartment_PrevAndNext(seatingCategoryId,
			seatingDepartmentId, orderByComparator);
	}

	/**
	* Removes all the seating categories where seatingDepartmentId = &#63; from the database.
	*
	* @param seatingDepartmentId the seating department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartment(long seatingDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartment(seatingDepartmentId);
	}

	/**
	* Returns the number of seating categories where seatingDepartmentId = &#63;.
	*
	* @param seatingDepartmentId the seating department ID
	* @return the number of matching seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartment(long seatingDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartment(seatingDepartmentId);
	}

	/**
	* Caches the seating category in the entity cache if it is enabled.
	*
	* @param seatingCategory the seating category
	*/
	public static void cacheResult(
		com.idetronic.eis.model.SeatingCategory seatingCategory) {
		getPersistence().cacheResult(seatingCategory);
	}

	/**
	* Caches the seating categories in the entity cache if it is enabled.
	*
	* @param seatingCategories the seating categories
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.SeatingCategory> seatingCategories) {
		getPersistence().cacheResult(seatingCategories);
	}

	/**
	* Creates a new seating category with the primary key. Does not add the seating category to the database.
	*
	* @param seatingCategoryId the primary key for the new seating category
	* @return the new seating category
	*/
	public static com.idetronic.eis.model.SeatingCategory create(
		long seatingCategoryId) {
		return getPersistence().create(seatingCategoryId);
	}

	/**
	* Removes the seating category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category that was removed
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory remove(
		long seatingCategoryId)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(seatingCategoryId);
	}

	public static com.idetronic.eis.model.SeatingCategory updateImpl(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(seatingCategory);
	}

	/**
	* Returns the seating category with the primary key or throws a {@link com.idetronic.eis.NoSuchSeatingCategoryException} if it could not be found.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category
	* @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory findByPrimaryKey(
		long seatingCategoryId)
		throws com.idetronic.eis.NoSuchSeatingCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(seatingCategoryId);
	}

	/**
	* Returns the seating category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category, or <code>null</code> if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory fetchByPrimaryKey(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(seatingCategoryId);
	}

	/**
	* Returns all the seating categories.
	*
	* @return the seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the seating categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @return the range of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the seating categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the seating categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of seating categories.
	*
	* @return the number of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SeatingCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SeatingCategoryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					SeatingCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(SeatingCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SeatingCategoryPersistence persistence) {
	}

	private static SeatingCategoryPersistence _persistence;
}
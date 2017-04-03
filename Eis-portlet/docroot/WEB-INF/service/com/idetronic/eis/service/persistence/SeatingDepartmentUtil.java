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

import com.idetronic.eis.model.SeatingDepartment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the seating department service. This utility wraps {@link SeatingDepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingDepartmentPersistence
 * @see SeatingDepartmentPersistenceImpl
 * @generated
 */
public class SeatingDepartmentUtil {
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
	public static void clearCache(SeatingDepartment seatingDepartment) {
		getPersistence().clearCache(seatingDepartment);
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
	public static List<SeatingDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SeatingDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SeatingDepartment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SeatingDepartment update(SeatingDepartment seatingDepartment)
		throws SystemException {
		return getPersistence().update(seatingDepartment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SeatingDepartment update(
		SeatingDepartment seatingDepartment, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(seatingDepartment, serviceContext);
	}

	/**
	* Caches the seating department in the entity cache if it is enabled.
	*
	* @param seatingDepartment the seating department
	*/
	public static void cacheResult(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment) {
		getPersistence().cacheResult(seatingDepartment);
	}

	/**
	* Caches the seating departments in the entity cache if it is enabled.
	*
	* @param seatingDepartments the seating departments
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.SeatingDepartment> seatingDepartments) {
		getPersistence().cacheResult(seatingDepartments);
	}

	/**
	* Creates a new seating department with the primary key. Does not add the seating department to the database.
	*
	* @param departmentId the primary key for the new seating department
	* @return the new seating department
	*/
	public static com.idetronic.eis.model.SeatingDepartment create(
		long departmentId) {
		return getPersistence().create(departmentId);
	}

	/**
	* Removes the seating department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department that was removed
	* @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingDepartment remove(
		long departmentId)
		throws com.idetronic.eis.NoSuchSeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(departmentId);
	}

	public static com.idetronic.eis.model.SeatingDepartment updateImpl(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(seatingDepartment);
	}

	/**
	* Returns the seating department with the primary key or throws a {@link com.idetronic.eis.NoSuchSeatingDepartmentException} if it could not be found.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department
	* @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingDepartment findByPrimaryKey(
		long departmentId)
		throws com.idetronic.eis.NoSuchSeatingDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(departmentId);
	}

	/**
	* Returns the seating department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentId the primary key of the seating department
	* @return the seating department, or <code>null</code> if a seating department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingDepartment fetchByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(departmentId);
	}

	/**
	* Returns all the seating departments.
	*
	* @return the seating departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingDepartment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the seating departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating departments
	* @param end the upper bound of the range of seating departments (not inclusive)
	* @return the range of seating departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingDepartment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the seating departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating departments
	* @param end the upper bound of the range of seating departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of seating departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingDepartment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the seating departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of seating departments.
	*
	* @return the number of seating departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SeatingDepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SeatingDepartmentPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					SeatingDepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(SeatingDepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SeatingDepartmentPersistence persistence) {
	}

	private static SeatingDepartmentPersistence _persistence;
}
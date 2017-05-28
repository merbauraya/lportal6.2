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

import com.idetronic.eis.model.FactAcquisition;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fact acquisition service. This utility wraps {@link FactAcquisitionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactAcquisitionPersistence
 * @see FactAcquisitionPersistenceImpl
 * @generated
 */
public class FactAcquisitionUtil {
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
	public static void clearCache(FactAcquisition factAcquisition) {
		getPersistence().clearCache(factAcquisition);
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
	public static List<FactAcquisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FactAcquisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FactAcquisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FactAcquisition update(FactAcquisition factAcquisition)
		throws SystemException {
		return getPersistence().update(factAcquisition);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FactAcquisition update(FactAcquisition factAcquisition,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(factAcquisition, serviceContext);
	}

	/**
	* Returns all the fact acquisitions where facultyId = &#63;.
	*
	* @param facultyId the faculty ID
	* @return the matching fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> findByPTJ(
		long facultyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPTJ(facultyId);
	}

	/**
	* Returns a range of all the fact acquisitions where facultyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facultyId the faculty ID
	* @param start the lower bound of the range of fact acquisitions
	* @param end the upper bound of the range of fact acquisitions (not inclusive)
	* @return the range of matching fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> findByPTJ(
		long facultyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPTJ(facultyId, start, end);
	}

	/**
	* Returns an ordered range of all the fact acquisitions where facultyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param facultyId the faculty ID
	* @param start the lower bound of the range of fact acquisitions
	* @param end the upper bound of the range of fact acquisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> findByPTJ(
		long facultyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPTJ(facultyId, start, end, orderByComparator);
	}

	/**
	* Returns the first fact acquisition in the ordered set where facultyId = &#63;.
	*
	* @param facultyId the faculty ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact acquisition
	* @throws com.idetronic.eis.NoSuchFactAcquisitionException if a matching fact acquisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition findByPTJ_First(
		long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactAcquisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPTJ_First(facultyId, orderByComparator);
	}

	/**
	* Returns the first fact acquisition in the ordered set where facultyId = &#63;.
	*
	* @param facultyId the faculty ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact acquisition, or <code>null</code> if a matching fact acquisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition fetchByPTJ_First(
		long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPTJ_First(facultyId, orderByComparator);
	}

	/**
	* Returns the last fact acquisition in the ordered set where facultyId = &#63;.
	*
	* @param facultyId the faculty ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact acquisition
	* @throws com.idetronic.eis.NoSuchFactAcquisitionException if a matching fact acquisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition findByPTJ_Last(
		long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactAcquisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPTJ_Last(facultyId, orderByComparator);
	}

	/**
	* Returns the last fact acquisition in the ordered set where facultyId = &#63;.
	*
	* @param facultyId the faculty ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact acquisition, or <code>null</code> if a matching fact acquisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition fetchByPTJ_Last(
		long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPTJ_Last(facultyId, orderByComparator);
	}

	/**
	* Returns the fact acquisitions before and after the current fact acquisition in the ordered set where facultyId = &#63;.
	*
	* @param factAcquisitionId the primary key of the current fact acquisition
	* @param facultyId the faculty ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact acquisition
	* @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition[] findByPTJ_PrevAndNext(
		long factAcquisitionId, long facultyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactAcquisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPTJ_PrevAndNext(factAcquisitionId, facultyId,
			orderByComparator);
	}

	/**
	* Removes all the fact acquisitions where facultyId = &#63; from the database.
	*
	* @param facultyId the faculty ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPTJ(long facultyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPTJ(facultyId);
	}

	/**
	* Returns the number of fact acquisitions where facultyId = &#63;.
	*
	* @param facultyId the faculty ID
	* @return the number of matching fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPTJ(long facultyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPTJ(facultyId);
	}

	/**
	* Caches the fact acquisition in the entity cache if it is enabled.
	*
	* @param factAcquisition the fact acquisition
	*/
	public static void cacheResult(
		com.idetronic.eis.model.FactAcquisition factAcquisition) {
		getPersistence().cacheResult(factAcquisition);
	}

	/**
	* Caches the fact acquisitions in the entity cache if it is enabled.
	*
	* @param factAcquisitions the fact acquisitions
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.FactAcquisition> factAcquisitions) {
		getPersistence().cacheResult(factAcquisitions);
	}

	/**
	* Creates a new fact acquisition with the primary key. Does not add the fact acquisition to the database.
	*
	* @param factAcquisitionId the primary key for the new fact acquisition
	* @return the new fact acquisition
	*/
	public static com.idetronic.eis.model.FactAcquisition create(
		long factAcquisitionId) {
		return getPersistence().create(factAcquisitionId);
	}

	/**
	* Removes the fact acquisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factAcquisitionId the primary key of the fact acquisition
	* @return the fact acquisition that was removed
	* @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition remove(
		long factAcquisitionId)
		throws com.idetronic.eis.NoSuchFactAcquisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(factAcquisitionId);
	}

	public static com.idetronic.eis.model.FactAcquisition updateImpl(
		com.idetronic.eis.model.FactAcquisition factAcquisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(factAcquisition);
	}

	/**
	* Returns the fact acquisition with the primary key or throws a {@link com.idetronic.eis.NoSuchFactAcquisitionException} if it could not be found.
	*
	* @param factAcquisitionId the primary key of the fact acquisition
	* @return the fact acquisition
	* @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition findByPrimaryKey(
		long factAcquisitionId)
		throws com.idetronic.eis.NoSuchFactAcquisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(factAcquisitionId);
	}

	/**
	* Returns the fact acquisition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factAcquisitionId the primary key of the fact acquisition
	* @return the fact acquisition, or <code>null</code> if a fact acquisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactAcquisition fetchByPrimaryKey(
		long factAcquisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(factAcquisitionId);
	}

	/**
	* Returns all the fact acquisitions.
	*
	* @return the fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fact acquisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact acquisitions
	* @param end the upper bound of the range of fact acquisitions (not inclusive)
	* @return the range of fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fact acquisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact acquisitions
	* @param end the upper bound of the range of fact acquisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fact acquisitions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fact acquisitions.
	*
	* @return the number of fact acquisitions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FactAcquisitionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FactAcquisitionPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactAcquisitionPersistence.class.getName());

			ReferenceRegistry.registerReference(FactAcquisitionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FactAcquisitionPersistence persistence) {
	}

	private static FactAcquisitionPersistence _persistence;
}
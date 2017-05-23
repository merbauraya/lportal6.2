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

import com.idetronic.eis.model.MasterType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the master type service. This utility wraps {@link MasterTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterTypePersistence
 * @see MasterTypePersistenceImpl
 * @generated
 */
public class MasterTypeUtil {
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
	public static void clearCache(MasterType masterType) {
		getPersistence().clearCache(masterType);
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
	public static List<MasterType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MasterType update(MasterType masterType)
		throws SystemException {
		return getPersistence().update(masterType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MasterType update(MasterType masterType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(masterType, serviceContext);
	}

	/**
	* Returns all the master types where parentType = &#63;.
	*
	* @param parentType the parent type
	* @return the matching master types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterType> findByParentType(
		boolean parentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentType(parentType);
	}

	/**
	* Returns a range of all the master types where parentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentType the parent type
	* @param start the lower bound of the range of master types
	* @param end the upper bound of the range of master types (not inclusive)
	* @return the range of matching master types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterType> findByParentType(
		boolean parentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentType(parentType, start, end);
	}

	/**
	* Returns an ordered range of all the master types where parentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentType the parent type
	* @param start the lower bound of the range of master types
	* @param end the upper bound of the range of master types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterType> findByParentType(
		boolean parentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentType(parentType, start, end, orderByComparator);
	}

	/**
	* Returns the first master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType findByParentType_First(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentType_First(parentType, orderByComparator);
	}

	/**
	* Returns the first master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master type, or <code>null</code> if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType fetchByParentType_First(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentType_First(parentType, orderByComparator);
	}

	/**
	* Returns the last master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType findByParentType_Last(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentType_Last(parentType, orderByComparator);
	}

	/**
	* Returns the last master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master type, or <code>null</code> if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType fetchByParentType_Last(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentType_Last(parentType, orderByComparator);
	}

	/**
	* Returns the master types before and after the current master type in the ordered set where parentType = &#63;.
	*
	* @param masterTypeId the primary key of the current master type
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType[] findByParentType_PrevAndNext(
		long masterTypeId, boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentType_PrevAndNext(masterTypeId, parentType,
			orderByComparator);
	}

	/**
	* Removes all the master types where parentType = &#63; from the database.
	*
	* @param parentType the parent type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentType(boolean parentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentType(parentType);
	}

	/**
	* Returns the number of master types where parentType = &#63;.
	*
	* @param parentType the parent type
	* @return the number of matching master types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentType(boolean parentType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentType(parentType);
	}

	/**
	* Caches the master type in the entity cache if it is enabled.
	*
	* @param masterType the master type
	*/
	public static void cacheResult(
		com.idetronic.eis.model.MasterType masterType) {
		getPersistence().cacheResult(masterType);
	}

	/**
	* Caches the master types in the entity cache if it is enabled.
	*
	* @param masterTypes the master types
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.MasterType> masterTypes) {
		getPersistence().cacheResult(masterTypes);
	}

	/**
	* Creates a new master type with the primary key. Does not add the master type to the database.
	*
	* @param masterTypeId the primary key for the new master type
	* @return the new master type
	*/
	public static com.idetronic.eis.model.MasterType create(long masterTypeId) {
		return getPersistence().create(masterTypeId);
	}

	/**
	* Removes the master type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param masterTypeId the primary key of the master type
	* @return the master type that was removed
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType remove(long masterTypeId)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(masterTypeId);
	}

	public static com.idetronic.eis.model.MasterType updateImpl(
		com.idetronic.eis.model.MasterType masterType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(masterType);
	}

	/**
	* Returns the master type with the primary key or throws a {@link com.idetronic.eis.NoSuchMasterTypeException} if it could not be found.
	*
	* @param masterTypeId the primary key of the master type
	* @return the master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType findByPrimaryKey(
		long masterTypeId)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(masterTypeId);
	}

	/**
	* Returns the master type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param masterTypeId the primary key of the master type
	* @return the master type, or <code>null</code> if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterType fetchByPrimaryKey(
		long masterTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(masterTypeId);
	}

	/**
	* Returns all the master types.
	*
	* @return the master types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the master types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master types
	* @param end the upper bound of the range of master types (not inclusive)
	* @return the range of master types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the master types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master types
	* @param end the upper bound of the range of master types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of master types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the master types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of master types.
	*
	* @return the number of master types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MasterTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MasterTypePersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					MasterTypePersistence.class.getName());

			ReferenceRegistry.registerReference(MasterTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MasterTypePersistence persistence) {
	}

	private static MasterTypePersistence _persistence;
}
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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the master type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterTypePersistenceImpl
 * @see MasterTypeUtil
 * @generated
 */
public interface MasterTypePersistence extends BasePersistence<MasterType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterTypeUtil} to access the master type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the master types where parentType = &#63;.
	*
	* @param parentType the parent type
	* @return the matching master types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterType> findByParentType(
		boolean parentType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterType> findByParentType(
		boolean parentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterType> findByParentType(
		boolean parentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType findByParentType_First(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master type, or <code>null</code> if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType fetchByParentType_First(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType findByParentType_Last(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master type in the ordered set where parentType = &#63;.
	*
	* @param parentType the parent type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master type, or <code>null</code> if a matching master type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType fetchByParentType_Last(
		boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterType[] findByParentType_PrevAndNext(
		long masterTypeId, boolean parentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master types where parentType = &#63; from the database.
	*
	* @param parentType the parent type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentType(boolean parentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master types where parentType = &#63;.
	*
	* @param parentType the parent type
	* @return the number of matching master types
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentType(boolean parentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the master type in the entity cache if it is enabled.
	*
	* @param masterType the master type
	*/
	public void cacheResult(com.idetronic.eis.model.MasterType masterType);

	/**
	* Caches the master types in the entity cache if it is enabled.
	*
	* @param masterTypes the master types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.MasterType> masterTypes);

	/**
	* Creates a new master type with the primary key. Does not add the master type to the database.
	*
	* @param masterTypeId the primary key for the new master type
	* @return the new master type
	*/
	public com.idetronic.eis.model.MasterType create(long masterTypeId);

	/**
	* Removes the master type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param masterTypeId the primary key of the master type
	* @return the master type that was removed
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType remove(long masterTypeId)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.MasterType updateImpl(
		com.idetronic.eis.model.MasterType masterType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master type with the primary key or throws a {@link com.idetronic.eis.NoSuchMasterTypeException} if it could not be found.
	*
	* @param masterTypeId the primary key of the master type
	* @return the master type
	* @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType findByPrimaryKey(
		long masterTypeId)
		throws com.idetronic.eis.NoSuchMasterTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param masterTypeId the primary key of the master type
	* @return the master type, or <code>null</code> if a master type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterType fetchByPrimaryKey(
		long masterTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master types.
	*
	* @return the master types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master types.
	*
	* @return the number of master types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
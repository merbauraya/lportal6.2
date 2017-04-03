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

import com.idetronic.eis.model.MemberCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the member category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MemberCategoryPersistenceImpl
 * @see MemberCategoryUtil
 * @generated
 */
public interface MemberCategoryPersistence extends BasePersistence<MemberCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberCategoryUtil} to access the member category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the member category in the entity cache if it is enabled.
	*
	* @param memberCategory the member category
	*/
	public void cacheResult(
		com.idetronic.eis.model.MemberCategory memberCategory);

	/**
	* Caches the member categories in the entity cache if it is enabled.
	*
	* @param memberCategories the member categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.MemberCategory> memberCategories);

	/**
	* Creates a new member category with the primary key. Does not add the member category to the database.
	*
	* @param memberCategoryId the primary key for the new member category
	* @return the new member category
	*/
	public com.idetronic.eis.model.MemberCategory create(long memberCategoryId);

	/**
	* Removes the member category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param memberCategoryId the primary key of the member category
	* @return the member category that was removed
	* @throws com.idetronic.eis.NoSuchMemberCategoryException if a member category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MemberCategory remove(long memberCategoryId)
		throws com.idetronic.eis.NoSuchMemberCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.MemberCategory updateImpl(
		com.idetronic.eis.model.MemberCategory memberCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member category with the primary key or throws a {@link com.idetronic.eis.NoSuchMemberCategoryException} if it could not be found.
	*
	* @param memberCategoryId the primary key of the member category
	* @return the member category
	* @throws com.idetronic.eis.NoSuchMemberCategoryException if a member category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MemberCategory findByPrimaryKey(
		long memberCategoryId)
		throws com.idetronic.eis.NoSuchMemberCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the member category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param memberCategoryId the primary key of the member category
	* @return the member category, or <code>null</code> if a member category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MemberCategory fetchByPrimaryKey(
		long memberCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the member categories.
	*
	* @return the member categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MemberCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the member categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MemberCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member categories
	* @param end the upper bound of the range of member categories (not inclusive)
	* @return the range of member categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MemberCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the member categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MemberCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of member categories
	* @param end the upper bound of the range of member categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of member categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MemberCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the member categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of member categories.
	*
	* @return the number of member categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
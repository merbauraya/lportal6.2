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

import com.idetronic.eis.model.PostCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the post category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostCategoryPersistenceImpl
 * @see PostCategoryUtil
 * @generated
 */
public interface PostCategoryPersistence extends BasePersistence<PostCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostCategoryUtil} to access the post category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the post category where postCategoryCode = &#63; or throws a {@link com.idetronic.eis.NoSuchPostCategoryException} if it could not be found.
	*
	* @param postCategoryCode the post category code
	* @return the matching post category
	* @throws com.idetronic.eis.NoSuchPostCategoryException if a matching post category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory findByPostCategoryCode(
		java.lang.String postCategoryCode)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the post category where postCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param postCategoryCode the post category code
	* @return the matching post category, or <code>null</code> if a matching post category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory fetchByPostCategoryCode(
		java.lang.String postCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the post category where postCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param postCategoryCode the post category code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching post category, or <code>null</code> if a matching post category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory fetchByPostCategoryCode(
		java.lang.String postCategoryCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the post category where postCategoryCode = &#63; from the database.
	*
	* @param postCategoryCode the post category code
	* @return the post category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory removeByPostCategoryCode(
		java.lang.String postCategoryCode)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of post categories where postCategoryCode = &#63;.
	*
	* @param postCategoryCode the post category code
	* @return the number of matching post categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByPostCategoryCode(java.lang.String postCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the post category in the entity cache if it is enabled.
	*
	* @param postCategory the post category
	*/
	public void cacheResult(com.idetronic.eis.model.PostCategory postCategory);

	/**
	* Caches the post categories in the entity cache if it is enabled.
	*
	* @param postCategories the post categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.PostCategory> postCategories);

	/**
	* Creates a new post category with the primary key. Does not add the post category to the database.
	*
	* @param postCategoryId the primary key for the new post category
	* @return the new post category
	*/
	public com.idetronic.eis.model.PostCategory create(long postCategoryId);

	/**
	* Removes the post category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category that was removed
	* @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory remove(long postCategoryId)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.PostCategory updateImpl(
		com.idetronic.eis.model.PostCategory postCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the post category with the primary key or throws a {@link com.idetronic.eis.NoSuchPostCategoryException} if it could not be found.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category
	* @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory findByPrimaryKey(
		long postCategoryId)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the post category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category, or <code>null</code> if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.PostCategory fetchByPrimaryKey(
		long postCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the post categories.
	*
	* @return the post categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.PostCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the post categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of post categories
	* @param end the upper bound of the range of post categories (not inclusive)
	* @return the range of post categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.PostCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the post categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of post categories
	* @param end the upper bound of the range of post categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of post categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.PostCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the post categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of post categories.
	*
	* @return the number of post categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the post category service. This utility wraps {@link PostCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostCategoryPersistence
 * @see PostCategoryPersistenceImpl
 * @generated
 */
public class PostCategoryUtil {
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
	public static void clearCache(PostCategory postCategory) {
		getPersistence().clearCache(postCategory);
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
	public static List<PostCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PostCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PostCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PostCategory update(PostCategory postCategory)
		throws SystemException {
		return getPersistence().update(postCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PostCategory update(PostCategory postCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(postCategory, serviceContext);
	}

	/**
	* Returns the post category where postCategoryCode = &#63; or throws a {@link com.idetronic.eis.NoSuchPostCategoryException} if it could not be found.
	*
	* @param postCategoryCode the post category code
	* @return the matching post category
	* @throws com.idetronic.eis.NoSuchPostCategoryException if a matching post category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory findByPostCategoryCode(
		java.lang.String postCategoryCode)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPostCategoryCode(postCategoryCode);
	}

	/**
	* Returns the post category where postCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param postCategoryCode the post category code
	* @return the matching post category, or <code>null</code> if a matching post category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory fetchByPostCategoryCode(
		java.lang.String postCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPostCategoryCode(postCategoryCode);
	}

	/**
	* Returns the post category where postCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param postCategoryCode the post category code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching post category, or <code>null</code> if a matching post category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory fetchByPostCategoryCode(
		java.lang.String postCategoryCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPostCategoryCode(postCategoryCode, retrieveFromCache);
	}

	/**
	* Removes the post category where postCategoryCode = &#63; from the database.
	*
	* @param postCategoryCode the post category code
	* @return the post category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory removeByPostCategoryCode(
		java.lang.String postCategoryCode)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPostCategoryCode(postCategoryCode);
	}

	/**
	* Returns the number of post categories where postCategoryCode = &#63;.
	*
	* @param postCategoryCode the post category code
	* @return the number of matching post categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPostCategoryCode(java.lang.String postCategoryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPostCategoryCode(postCategoryCode);
	}

	/**
	* Caches the post category in the entity cache if it is enabled.
	*
	* @param postCategory the post category
	*/
	public static void cacheResult(
		com.idetronic.eis.model.PostCategory postCategory) {
		getPersistence().cacheResult(postCategory);
	}

	/**
	* Caches the post categories in the entity cache if it is enabled.
	*
	* @param postCategories the post categories
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.PostCategory> postCategories) {
		getPersistence().cacheResult(postCategories);
	}

	/**
	* Creates a new post category with the primary key. Does not add the post category to the database.
	*
	* @param postCategoryId the primary key for the new post category
	* @return the new post category
	*/
	public static com.idetronic.eis.model.PostCategory create(
		long postCategoryId) {
		return getPersistence().create(postCategoryId);
	}

	/**
	* Removes the post category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category that was removed
	* @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory remove(
		long postCategoryId)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(postCategoryId);
	}

	public static com.idetronic.eis.model.PostCategory updateImpl(
		com.idetronic.eis.model.PostCategory postCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(postCategory);
	}

	/**
	* Returns the post category with the primary key or throws a {@link com.idetronic.eis.NoSuchPostCategoryException} if it could not be found.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category
	* @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory findByPrimaryKey(
		long postCategoryId)
		throws com.idetronic.eis.NoSuchPostCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(postCategoryId);
	}

	/**
	* Returns the post category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category, or <code>null</code> if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostCategory fetchByPrimaryKey(
		long postCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(postCategoryId);
	}

	/**
	* Returns all the post categories.
	*
	* @return the post categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.PostCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.idetronic.eis.model.PostCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.idetronic.eis.model.PostCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the post categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of post categories.
	*
	* @return the number of post categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PostCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PostCategoryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					PostCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(PostCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PostCategoryPersistence persistence) {
	}

	private static PostCategoryPersistence _persistence;
}
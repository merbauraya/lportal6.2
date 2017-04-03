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

import com.idetronic.eis.model.Post;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the post service. This utility wraps {@link PostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostPersistence
 * @see PostPersistenceImpl
 * @generated
 */
public class PostUtil {
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
	public static void clearCache(Post post) {
		getPersistence().clearCache(post);
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
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Post update(Post post) throws SystemException {
		return getPersistence().update(post);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Post update(Post post, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(post, serviceContext);
	}

	/**
	* Returns all the posts where postCategoryId = &#63;.
	*
	* @param postCategoryId the post category ID
	* @return the matching posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Post> findByPostCategory(
		long postCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPostCategory(postCategoryId);
	}

	/**
	* Returns a range of all the posts where postCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param postCategoryId the post category ID
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @return the range of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Post> findByPostCategory(
		long postCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPostCategory(postCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the posts where postCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param postCategoryId the post category ID
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Post> findByPostCategory(
		long postCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostCategory(postCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first post in the ordered set where postCategoryId = &#63;.
	*
	* @param postCategoryId the post category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching post
	* @throws com.idetronic.eis.NoSuchPostException if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post findByPostCategory_First(
		long postCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostCategory_First(postCategoryId, orderByComparator);
	}

	/**
	* Returns the first post in the ordered set where postCategoryId = &#63;.
	*
	* @param postCategoryId the post category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching post, or <code>null</code> if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post fetchByPostCategory_First(
		long postCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPostCategory_First(postCategoryId, orderByComparator);
	}

	/**
	* Returns the last post in the ordered set where postCategoryId = &#63;.
	*
	* @param postCategoryId the post category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching post
	* @throws com.idetronic.eis.NoSuchPostException if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post findByPostCategory_Last(
		long postCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostCategory_Last(postCategoryId, orderByComparator);
	}

	/**
	* Returns the last post in the ordered set where postCategoryId = &#63;.
	*
	* @param postCategoryId the post category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching post, or <code>null</code> if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post fetchByPostCategory_Last(
		long postCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPostCategory_Last(postCategoryId, orderByComparator);
	}

	/**
	* Returns the posts before and after the current post in the ordered set where postCategoryId = &#63;.
	*
	* @param postId the primary key of the current post
	* @param postCategoryId the post category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next post
	* @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post[] findByPostCategory_PrevAndNext(
		long postId, long postCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPostCategory_PrevAndNext(postId, postCategoryId,
			orderByComparator);
	}

	/**
	* Removes all the posts where postCategoryId = &#63; from the database.
	*
	* @param postCategoryId the post category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPostCategory(long postCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPostCategory(postCategoryId);
	}

	/**
	* Returns the number of posts where postCategoryId = &#63;.
	*
	* @param postCategoryId the post category ID
	* @return the number of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPostCategory(long postCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPostCategory(postCategoryId);
	}

	/**
	* Caches the post in the entity cache if it is enabled.
	*
	* @param post the post
	*/
	public static void cacheResult(com.idetronic.eis.model.Post post) {
		getPersistence().cacheResult(post);
	}

	/**
	* Caches the posts in the entity cache if it is enabled.
	*
	* @param posts the posts
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.Post> posts) {
		getPersistence().cacheResult(posts);
	}

	/**
	* Creates a new post with the primary key. Does not add the post to the database.
	*
	* @param postId the primary key for the new post
	* @return the new post
	*/
	public static com.idetronic.eis.model.Post create(long postId) {
		return getPersistence().create(postId);
	}

	/**
	* Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postId the primary key of the post
	* @return the post that was removed
	* @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post remove(long postId)
		throws com.idetronic.eis.NoSuchPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(postId);
	}

	public static com.idetronic.eis.model.Post updateImpl(
		com.idetronic.eis.model.Post post)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(post);
	}

	/**
	* Returns the post with the primary key or throws a {@link com.idetronic.eis.NoSuchPostException} if it could not be found.
	*
	* @param postId the primary key of the post
	* @return the post
	* @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post findByPrimaryKey(long postId)
		throws com.idetronic.eis.NoSuchPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(postId);
	}

	/**
	* Returns the post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postId the primary key of the post
	* @return the post, or <code>null</code> if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Post fetchByPrimaryKey(long postId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(postId);
	}

	/**
	* Returns all the posts.
	*
	* @return the posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Post> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @return the range of posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Post> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Post> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of posts.
	*
	* @return the number of posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PostPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					PostPersistence.class.getName());

			ReferenceRegistry.registerReference(PostUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PostPersistence persistence) {
	}

	private static PostPersistence _persistence;
}
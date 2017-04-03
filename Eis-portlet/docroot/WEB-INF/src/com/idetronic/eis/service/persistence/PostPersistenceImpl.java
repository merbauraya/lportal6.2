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

import com.idetronic.eis.NoSuchPostException;
import com.idetronic.eis.model.Post;
import com.idetronic.eis.model.impl.PostImpl;
import com.idetronic.eis.model.impl.PostModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostPersistence
 * @see PostUtil
 * @generated
 */
public class PostPersistenceImpl extends BasePersistenceImpl<Post>
	implements PostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PostUtil} to access the post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostModelImpl.FINDER_CACHE_ENABLED, PostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostModelImpl.FINDER_CACHE_ENABLED, PostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSTCATEGORY =
		new FinderPath(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostModelImpl.FINDER_CACHE_ENABLED, PostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPostCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTCATEGORY =
		new FinderPath(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostModelImpl.FINDER_CACHE_ENABLED, PostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPostCategory",
			new String[] { Long.class.getName() },
			PostModelImpl.POSTCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSTCATEGORY = new FinderPath(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPostCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the posts where postCategoryId = &#63;.
	 *
	 * @param postCategoryId the post category ID
	 * @return the matching posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Post> findByPostCategory(long postCategoryId)
		throws SystemException {
		return findByPostCategory(postCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Post> findByPostCategory(long postCategoryId, int start, int end)
		throws SystemException {
		return findByPostCategory(postCategoryId, start, end, null);
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
	@Override
	public List<Post> findByPostCategory(long postCategoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTCATEGORY;
			finderArgs = new Object[] { postCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSTCATEGORY;
			finderArgs = new Object[] {
					postCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<Post> list = (List<Post>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Post post : list) {
				if ((postCategoryId != post.getPostCategoryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_POST_WHERE);

			query.append(_FINDER_COLUMN_POSTCATEGORY_POSTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(postCategoryId);

				if (!pagination) {
					list = (List<Post>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Post>(list);
				}
				else {
					list = (List<Post>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Post findByPostCategory_First(long postCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchPostException, SystemException {
		Post post = fetchByPostCategory_First(postCategoryId, orderByComparator);

		if (post != null) {
			return post;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("postCategoryId=");
		msg.append(postCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPostException(msg.toString());
	}

	/**
	 * Returns the first post in the ordered set where postCategoryId = &#63;.
	 *
	 * @param postCategoryId the post category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post, or <code>null</code> if a matching post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post fetchByPostCategory_First(long postCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Post> list = findByPostCategory(postCategoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Post findByPostCategory_Last(long postCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchPostException, SystemException {
		Post post = fetchByPostCategory_Last(postCategoryId, orderByComparator);

		if (post != null) {
			return post;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("postCategoryId=");
		msg.append(postCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPostException(msg.toString());
	}

	/**
	 * Returns the last post in the ordered set where postCategoryId = &#63;.
	 *
	 * @param postCategoryId the post category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post, or <code>null</code> if a matching post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post fetchByPostCategory_Last(long postCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPostCategory(postCategoryId);

		if (count == 0) {
			return null;
		}

		List<Post> list = findByPostCategory(postCategoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Post[] findByPostCategory_PrevAndNext(long postId,
		long postCategoryId, OrderByComparator orderByComparator)
		throws NoSuchPostException, SystemException {
		Post post = findByPrimaryKey(postId);

		Session session = null;

		try {
			session = openSession();

			Post[] array = new PostImpl[3];

			array[0] = getByPostCategory_PrevAndNext(session, post,
					postCategoryId, orderByComparator, true);

			array[1] = post;

			array[2] = getByPostCategory_PrevAndNext(session, post,
					postCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Post getByPostCategory_PrevAndNext(Session session, Post post,
		long postCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POST_WHERE);

		query.append(_FINDER_COLUMN_POSTCATEGORY_POSTCATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(postCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(post);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Post> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the posts where postCategoryId = &#63; from the database.
	 *
	 * @param postCategoryId the post category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPostCategory(long postCategoryId)
		throws SystemException {
		for (Post post : findByPostCategory(postCategoryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(post);
		}
	}

	/**
	 * Returns the number of posts where postCategoryId = &#63;.
	 *
	 * @param postCategoryId the post category ID
	 * @return the number of matching posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPostCategory(long postCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSTCATEGORY;

		Object[] finderArgs = new Object[] { postCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POST_WHERE);

			query.append(_FINDER_COLUMN_POSTCATEGORY_POSTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(postCategoryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_POSTCATEGORY_POSTCATEGORYID_2 = "post.postCategoryId = ?";

	public PostPersistenceImpl() {
		setModelClass(Post.class);
	}

	/**
	 * Caches the post in the entity cache if it is enabled.
	 *
	 * @param post the post
	 */
	@Override
	public void cacheResult(Post post) {
		EntityCacheUtil.putResult(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostImpl.class, post.getPrimaryKey(), post);

		post.resetOriginalValues();
	}

	/**
	 * Caches the posts in the entity cache if it is enabled.
	 *
	 * @param posts the posts
	 */
	@Override
	public void cacheResult(List<Post> posts) {
		for (Post post : posts) {
			if (EntityCacheUtil.getResult(PostModelImpl.ENTITY_CACHE_ENABLED,
						PostImpl.class, post.getPrimaryKey()) == null) {
				cacheResult(post);
			}
			else {
				post.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all posts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Post post) {
		EntityCacheUtil.removeResult(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostImpl.class, post.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Post> posts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Post post : posts) {
			EntityCacheUtil.removeResult(PostModelImpl.ENTITY_CACHE_ENABLED,
				PostImpl.class, post.getPrimaryKey());
		}
	}

	/**
	 * Creates a new post with the primary key. Does not add the post to the database.
	 *
	 * @param postId the primary key for the new post
	 * @return the new post
	 */
	@Override
	public Post create(long postId) {
		Post post = new PostImpl();

		post.setNew(true);
		post.setPrimaryKey(postId);

		return post;
	}

	/**
	 * Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postId the primary key of the post
	 * @return the post that was removed
	 * @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post remove(long postId) throws NoSuchPostException, SystemException {
		return remove((Serializable)postId);
	}

	/**
	 * Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post
	 * @return the post that was removed
	 * @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post remove(Serializable primaryKey)
		throws NoSuchPostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Post post = (Post)session.get(PostImpl.class, primaryKey);

			if (post == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(post);
		}
		catch (NoSuchPostException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Post removeImpl(Post post) throws SystemException {
		post = toUnwrappedModel(post);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(post)) {
				post = (Post)session.get(PostImpl.class, post.getPrimaryKeyObj());
			}

			if (post != null) {
				session.delete(post);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (post != null) {
			clearCache(post);
		}

		return post;
	}

	@Override
	public Post updateImpl(com.idetronic.eis.model.Post post)
		throws SystemException {
		post = toUnwrappedModel(post);

		boolean isNew = post.isNew();

		PostModelImpl postModelImpl = (PostModelImpl)post;

		Session session = null;

		try {
			session = openSession();

			if (post.isNew()) {
				session.save(post);

				post.setNew(false);
			}
			else {
				session.merge(post);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PostModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((postModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						postModelImpl.getOriginalPostCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTCATEGORY,
					args);

				args = new Object[] { postModelImpl.getPostCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTCATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(PostModelImpl.ENTITY_CACHE_ENABLED,
			PostImpl.class, post.getPrimaryKey(), post);

		return post;
	}

	protected Post toUnwrappedModel(Post post) {
		if (post instanceof PostImpl) {
			return post;
		}

		PostImpl postImpl = new PostImpl();

		postImpl.setNew(post.isNew());
		postImpl.setPrimaryKey(post.getPrimaryKey());

		postImpl.setPostId(post.getPostId());
		postImpl.setPostCategoryId(post.getPostCategoryId());
		postImpl.setPostName(post.getPostName());

		return postImpl;
	}

	/**
	 * Returns the post with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the post
	 * @return the post
	 * @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostException, SystemException {
		Post post = fetchByPrimaryKey(primaryKey);

		if (post == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return post;
	}

	/**
	 * Returns the post with the primary key or throws a {@link com.idetronic.eis.NoSuchPostException} if it could not be found.
	 *
	 * @param postId the primary key of the post
	 * @return the post
	 * @throws com.idetronic.eis.NoSuchPostException if a post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post findByPrimaryKey(long postId)
		throws NoSuchPostException, SystemException {
		return findByPrimaryKey((Serializable)postId);
	}

	/**
	 * Returns the post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post
	 * @return the post, or <code>null</code> if a post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Post post = (Post)EntityCacheUtil.getResult(PostModelImpl.ENTITY_CACHE_ENABLED,
				PostImpl.class, primaryKey);

		if (post == _nullPost) {
			return null;
		}

		if (post == null) {
			Session session = null;

			try {
				session = openSession();

				post = (Post)session.get(PostImpl.class, primaryKey);

				if (post != null) {
					cacheResult(post);
				}
				else {
					EntityCacheUtil.putResult(PostModelImpl.ENTITY_CACHE_ENABLED,
						PostImpl.class, primaryKey, _nullPost);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PostModelImpl.ENTITY_CACHE_ENABLED,
					PostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return post;
	}

	/**
	 * Returns the post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postId the primary key of the post
	 * @return the post, or <code>null</code> if a post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Post fetchByPrimaryKey(long postId) throws SystemException {
		return fetchByPrimaryKey((Serializable)postId);
	}

	/**
	 * Returns all the posts.
	 *
	 * @return the posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Post> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Post> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Post> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Post> list = (List<Post>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_POST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POST;

				if (pagination) {
					sql = sql.concat(PostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Post>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Post>(list);
				}
				else {
					list = (List<Post>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the posts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Post post : findAll()) {
			remove(post);
		}
	}

	/**
	 * Returns the number of posts.
	 *
	 * @return the number of posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_POST);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the post persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.Post")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Post>> listenersList = new ArrayList<ModelListener<Post>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Post>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_POST = "SELECT post FROM Post post";
	private static final String _SQL_SELECT_POST_WHERE = "SELECT post FROM Post post WHERE ";
	private static final String _SQL_COUNT_POST = "SELECT COUNT(post) FROM Post post";
	private static final String _SQL_COUNT_POST_WHERE = "SELECT COUNT(post) FROM Post post WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "post.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Post exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Post exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PostPersistenceImpl.class);
	private static Post _nullPost = new PostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Post> toCacheModel() {
				return _nullPostCacheModel;
			}
		};

	private static CacheModel<Post> _nullPostCacheModel = new CacheModel<Post>() {
			@Override
			public Post toEntityModel() {
				return _nullPost;
			}
		};
}
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

import com.idetronic.eis.NoSuchPostCategoryException;
import com.idetronic.eis.model.PostCategory;
import com.idetronic.eis.model.impl.PostCategoryImpl;
import com.idetronic.eis.model.impl.PostCategoryModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the post category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostCategoryPersistence
 * @see PostCategoryUtil
 * @generated
 */
public class PostCategoryPersistenceImpl extends BasePersistenceImpl<PostCategory>
	implements PostCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PostCategoryUtil} to access the post category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PostCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryModelImpl.FINDER_CACHE_ENABLED, PostCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryModelImpl.FINDER_CACHE_ENABLED, PostCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_POSTCATEGORYCODE = new FinderPath(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryModelImpl.FINDER_CACHE_ENABLED, PostCategoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPostCategoryCode",
			new String[] { String.class.getName() },
			PostCategoryModelImpl.POSTCATEGORYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSTCATEGORYCODE = new FinderPath(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPostCategoryCode", new String[] { String.class.getName() });

	/**
	 * Returns the post category where postCategoryCode = &#63; or throws a {@link com.idetronic.eis.NoSuchPostCategoryException} if it could not be found.
	 *
	 * @param postCategoryCode the post category code
	 * @return the matching post category
	 * @throws com.idetronic.eis.NoSuchPostCategoryException if a matching post category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory findByPostCategoryCode(String postCategoryCode)
		throws NoSuchPostCategoryException, SystemException {
		PostCategory postCategory = fetchByPostCategoryCode(postCategoryCode);

		if (postCategory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("postCategoryCode=");
			msg.append(postCategoryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPostCategoryException(msg.toString());
		}

		return postCategory;
	}

	/**
	 * Returns the post category where postCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param postCategoryCode the post category code
	 * @return the matching post category, or <code>null</code> if a matching post category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory fetchByPostCategoryCode(String postCategoryCode)
		throws SystemException {
		return fetchByPostCategoryCode(postCategoryCode, true);
	}

	/**
	 * Returns the post category where postCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param postCategoryCode the post category code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching post category, or <code>null</code> if a matching post category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory fetchByPostCategoryCode(String postCategoryCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { postCategoryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
					finderArgs, this);
		}

		if (result instanceof PostCategory) {
			PostCategory postCategory = (PostCategory)result;

			if (!Validator.equals(postCategoryCode,
						postCategory.getPostCategoryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_POSTCATEGORY_WHERE);

			boolean bindPostCategoryCode = false;

			if (postCategoryCode == null) {
				query.append(_FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_1);
			}
			else if (postCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_3);
			}
			else {
				bindPostCategoryCode = true;

				query.append(_FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPostCategoryCode) {
					qPos.add(postCategoryCode);
				}

				List<PostCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
						finderArgs, list);
				}
				else {
					PostCategory postCategory = list.get(0);

					result = postCategory;

					cacheResult(postCategory);

					if ((postCategory.getPostCategoryCode() == null) ||
							!postCategory.getPostCategoryCode()
											 .equals(postCategoryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
							finderArgs, postCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PostCategory)result;
		}
	}

	/**
	 * Removes the post category where postCategoryCode = &#63; from the database.
	 *
	 * @param postCategoryCode the post category code
	 * @return the post category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory removeByPostCategoryCode(String postCategoryCode)
		throws NoSuchPostCategoryException, SystemException {
		PostCategory postCategory = findByPostCategoryCode(postCategoryCode);

		return remove(postCategory);
	}

	/**
	 * Returns the number of post categories where postCategoryCode = &#63;.
	 *
	 * @param postCategoryCode the post category code
	 * @return the number of matching post categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPostCategoryCode(String postCategoryCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSTCATEGORYCODE;

		Object[] finderArgs = new Object[] { postCategoryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSTCATEGORY_WHERE);

			boolean bindPostCategoryCode = false;

			if (postCategoryCode == null) {
				query.append(_FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_1);
			}
			else if (postCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_3);
			}
			else {
				bindPostCategoryCode = true;

				query.append(_FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPostCategoryCode) {
					qPos.add(postCategoryCode);
				}

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

	private static final String _FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_1 =
		"postCategory.postCategoryCode IS NULL";
	private static final String _FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_2 =
		"postCategory.postCategoryCode = ?";
	private static final String _FINDER_COLUMN_POSTCATEGORYCODE_POSTCATEGORYCODE_3 =
		"(postCategory.postCategoryCode IS NULL OR postCategory.postCategoryCode = '')";

	public PostCategoryPersistenceImpl() {
		setModelClass(PostCategory.class);
	}

	/**
	 * Caches the post category in the entity cache if it is enabled.
	 *
	 * @param postCategory the post category
	 */
	@Override
	public void cacheResult(PostCategory postCategory) {
		EntityCacheUtil.putResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryImpl.class, postCategory.getPrimaryKey(), postCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
			new Object[] { postCategory.getPostCategoryCode() }, postCategory);

		postCategory.resetOriginalValues();
	}

	/**
	 * Caches the post categories in the entity cache if it is enabled.
	 *
	 * @param postCategories the post categories
	 */
	@Override
	public void cacheResult(List<PostCategory> postCategories) {
		for (PostCategory postCategory : postCategories) {
			if (EntityCacheUtil.getResult(
						PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PostCategoryImpl.class, postCategory.getPrimaryKey()) == null) {
				cacheResult(postCategory);
			}
			else {
				postCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all post categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PostCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PostCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostCategory postCategory) {
		EntityCacheUtil.removeResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryImpl.class, postCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(postCategory);
	}

	@Override
	public void clearCache(List<PostCategory> postCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PostCategory postCategory : postCategories) {
			EntityCacheUtil.removeResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PostCategoryImpl.class, postCategory.getPrimaryKey());

			clearUniqueFindersCache(postCategory);
		}
	}

	protected void cacheUniqueFindersCache(PostCategory postCategory) {
		if (postCategory.isNew()) {
			Object[] args = new Object[] { postCategory.getPostCategoryCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSTCATEGORYCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
				args, postCategory);
		}
		else {
			PostCategoryModelImpl postCategoryModelImpl = (PostCategoryModelImpl)postCategory;

			if ((postCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_POSTCATEGORYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { postCategory.getPostCategoryCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSTCATEGORYCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
					args, postCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(PostCategory postCategory) {
		PostCategoryModelImpl postCategoryModelImpl = (PostCategoryModelImpl)postCategory;

		Object[] args = new Object[] { postCategory.getPostCategoryCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTCATEGORYCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE, args);

		if ((postCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSTCATEGORYCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					postCategoryModelImpl.getOriginalPostCategoryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTCATEGORYCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSTCATEGORYCODE,
				args);
		}
	}

	/**
	 * Creates a new post category with the primary key. Does not add the post category to the database.
	 *
	 * @param postCategoryId the primary key for the new post category
	 * @return the new post category
	 */
	@Override
	public PostCategory create(long postCategoryId) {
		PostCategory postCategory = new PostCategoryImpl();

		postCategory.setNew(true);
		postCategory.setPrimaryKey(postCategoryId);

		return postCategory;
	}

	/**
	 * Removes the post category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postCategoryId the primary key of the post category
	 * @return the post category that was removed
	 * @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory remove(long postCategoryId)
		throws NoSuchPostCategoryException, SystemException {
		return remove((Serializable)postCategoryId);
	}

	/**
	 * Removes the post category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post category
	 * @return the post category that was removed
	 * @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory remove(Serializable primaryKey)
		throws NoSuchPostCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PostCategory postCategory = (PostCategory)session.get(PostCategoryImpl.class,
					primaryKey);

			if (postCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(postCategory);
		}
		catch (NoSuchPostCategoryException nsee) {
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
	protected PostCategory removeImpl(PostCategory postCategory)
		throws SystemException {
		postCategory = toUnwrappedModel(postCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postCategory)) {
				postCategory = (PostCategory)session.get(PostCategoryImpl.class,
						postCategory.getPrimaryKeyObj());
			}

			if (postCategory != null) {
				session.delete(postCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (postCategory != null) {
			clearCache(postCategory);
		}

		return postCategory;
	}

	@Override
	public PostCategory updateImpl(
		com.idetronic.eis.model.PostCategory postCategory)
		throws SystemException {
		postCategory = toUnwrappedModel(postCategory);

		boolean isNew = postCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (postCategory.isNew()) {
				session.save(postCategory);

				postCategory.setNew(false);
			}
			else {
				session.merge(postCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PostCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
			PostCategoryImpl.class, postCategory.getPrimaryKey(), postCategory);

		clearUniqueFindersCache(postCategory);
		cacheUniqueFindersCache(postCategory);

		return postCategory;
	}

	protected PostCategory toUnwrappedModel(PostCategory postCategory) {
		if (postCategory instanceof PostCategoryImpl) {
			return postCategory;
		}

		PostCategoryImpl postCategoryImpl = new PostCategoryImpl();

		postCategoryImpl.setNew(postCategory.isNew());
		postCategoryImpl.setPrimaryKey(postCategory.getPrimaryKey());

		postCategoryImpl.setPostCategoryId(postCategory.getPostCategoryId());
		postCategoryImpl.setPostCategoryCode(postCategory.getPostCategoryCode());
		postCategoryImpl.setPostCategoryName(postCategory.getPostCategoryName());

		return postCategoryImpl;
	}

	/**
	 * Returns the post category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the post category
	 * @return the post category
	 * @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostCategoryException, SystemException {
		PostCategory postCategory = fetchByPrimaryKey(primaryKey);

		if (postCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return postCategory;
	}

	/**
	 * Returns the post category with the primary key or throws a {@link com.idetronic.eis.NoSuchPostCategoryException} if it could not be found.
	 *
	 * @param postCategoryId the primary key of the post category
	 * @return the post category
	 * @throws com.idetronic.eis.NoSuchPostCategoryException if a post category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory findByPrimaryKey(long postCategoryId)
		throws NoSuchPostCategoryException, SystemException {
		return findByPrimaryKey((Serializable)postCategoryId);
	}

	/**
	 * Returns the post category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post category
	 * @return the post category, or <code>null</code> if a post category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PostCategory postCategory = (PostCategory)EntityCacheUtil.getResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
				PostCategoryImpl.class, primaryKey);

		if (postCategory == _nullPostCategory) {
			return null;
		}

		if (postCategory == null) {
			Session session = null;

			try {
				session = openSession();

				postCategory = (PostCategory)session.get(PostCategoryImpl.class,
						primaryKey);

				if (postCategory != null) {
					cacheResult(postCategory);
				}
				else {
					EntityCacheUtil.putResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
						PostCategoryImpl.class, primaryKey, _nullPostCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PostCategoryModelImpl.ENTITY_CACHE_ENABLED,
					PostCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return postCategory;
	}

	/**
	 * Returns the post category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postCategoryId the primary key of the post category
	 * @return the post category, or <code>null</code> if a post category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostCategory fetchByPrimaryKey(long postCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)postCategoryId);
	}

	/**
	 * Returns all the post categories.
	 *
	 * @return the post categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PostCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PostCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<PostCategory> findAll(int start, int end,
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

		List<PostCategory> list = (List<PostCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_POSTCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POSTCATEGORY;

				if (pagination) {
					sql = sql.concat(PostCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PostCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PostCategory>(list);
				}
				else {
					list = (List<PostCategory>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the post categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PostCategory postCategory : findAll()) {
			remove(postCategory);
		}
	}

	/**
	 * Returns the number of post categories.
	 *
	 * @return the number of post categories
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

				Query q = session.createQuery(_SQL_COUNT_POSTCATEGORY);

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
	 * Initializes the post category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.PostCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PostCategory>> listenersList = new ArrayList<ModelListener<PostCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PostCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PostCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_POSTCATEGORY = "SELECT postCategory FROM PostCategory postCategory";
	private static final String _SQL_SELECT_POSTCATEGORY_WHERE = "SELECT postCategory FROM PostCategory postCategory WHERE ";
	private static final String _SQL_COUNT_POSTCATEGORY = "SELECT COUNT(postCategory) FROM PostCategory postCategory";
	private static final String _SQL_COUNT_POSTCATEGORY_WHERE = "SELECT COUNT(postCategory) FROM PostCategory postCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "postCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PostCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PostCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PostCategoryPersistenceImpl.class);
	private static PostCategory _nullPostCategory = new PostCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PostCategory> toCacheModel() {
				return _nullPostCategoryCacheModel;
			}
		};

	private static CacheModel<PostCategory> _nullPostCategoryCacheModel = new CacheModel<PostCategory>() {
			@Override
			public PostCategory toEntityModel() {
				return _nullPostCategory;
			}
		};
}
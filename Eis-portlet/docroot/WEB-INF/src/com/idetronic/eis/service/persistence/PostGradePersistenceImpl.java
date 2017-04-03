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

import com.idetronic.eis.NoSuchPostGradeException;
import com.idetronic.eis.model.PostGrade;
import com.idetronic.eis.model.impl.PostGradeImpl;
import com.idetronic.eis.model.impl.PostGradeModelImpl;

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
 * The persistence implementation for the post grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostGradePersistence
 * @see PostGradeUtil
 * @generated
 */
public class PostGradePersistenceImpl extends BasePersistenceImpl<PostGrade>
	implements PostGradePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PostGradeUtil} to access the post grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PostGradeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeModelImpl.FINDER_CACHE_ENABLED, PostGradeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeModelImpl.FINDER_CACHE_ENABLED, PostGradeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GRADECODE = new FinderPath(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeModelImpl.FINDER_CACHE_ENABLED, PostGradeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGradeCode",
			new String[] { String.class.getName() },
			PostGradeModelImpl.POSTGRADECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GRADECODE = new FinderPath(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGradeCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the post grade where postGradeCode = &#63; or throws a {@link com.idetronic.eis.NoSuchPostGradeException} if it could not be found.
	 *
	 * @param postGradeCode the post grade code
	 * @return the matching post grade
	 * @throws com.idetronic.eis.NoSuchPostGradeException if a matching post grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade findByGradeCode(String postGradeCode)
		throws NoSuchPostGradeException, SystemException {
		PostGrade postGrade = fetchByGradeCode(postGradeCode);

		if (postGrade == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("postGradeCode=");
			msg.append(postGradeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPostGradeException(msg.toString());
		}

		return postGrade;
	}

	/**
	 * Returns the post grade where postGradeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param postGradeCode the post grade code
	 * @return the matching post grade, or <code>null</code> if a matching post grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade fetchByGradeCode(String postGradeCode)
		throws SystemException {
		return fetchByGradeCode(postGradeCode, true);
	}

	/**
	 * Returns the post grade where postGradeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param postGradeCode the post grade code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching post grade, or <code>null</code> if a matching post grade could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade fetchByGradeCode(String postGradeCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { postGradeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GRADECODE,
					finderArgs, this);
		}

		if (result instanceof PostGrade) {
			PostGrade postGrade = (PostGrade)result;

			if (!Validator.equals(postGradeCode, postGrade.getPostGradeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_POSTGRADE_WHERE);

			boolean bindPostGradeCode = false;

			if (postGradeCode == null) {
				query.append(_FINDER_COLUMN_GRADECODE_POSTGRADECODE_1);
			}
			else if (postGradeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GRADECODE_POSTGRADECODE_3);
			}
			else {
				bindPostGradeCode = true;

				query.append(_FINDER_COLUMN_GRADECODE_POSTGRADECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPostGradeCode) {
					qPos.add(postGradeCode);
				}

				List<PostGrade> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADECODE,
						finderArgs, list);
				}
				else {
					PostGrade postGrade = list.get(0);

					result = postGrade;

					cacheResult(postGrade);

					if ((postGrade.getPostGradeCode() == null) ||
							!postGrade.getPostGradeCode().equals(postGradeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADECODE,
							finderArgs, postGrade);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADECODE,
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
			return (PostGrade)result;
		}
	}

	/**
	 * Removes the post grade where postGradeCode = &#63; from the database.
	 *
	 * @param postGradeCode the post grade code
	 * @return the post grade that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade removeByGradeCode(String postGradeCode)
		throws NoSuchPostGradeException, SystemException {
		PostGrade postGrade = findByGradeCode(postGradeCode);

		return remove(postGrade);
	}

	/**
	 * Returns the number of post grades where postGradeCode = &#63;.
	 *
	 * @param postGradeCode the post grade code
	 * @return the number of matching post grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGradeCode(String postGradeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GRADECODE;

		Object[] finderArgs = new Object[] { postGradeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSTGRADE_WHERE);

			boolean bindPostGradeCode = false;

			if (postGradeCode == null) {
				query.append(_FINDER_COLUMN_GRADECODE_POSTGRADECODE_1);
			}
			else if (postGradeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GRADECODE_POSTGRADECODE_3);
			}
			else {
				bindPostGradeCode = true;

				query.append(_FINDER_COLUMN_GRADECODE_POSTGRADECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPostGradeCode) {
					qPos.add(postGradeCode);
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

	private static final String _FINDER_COLUMN_GRADECODE_POSTGRADECODE_1 = "postGrade.postGradeCode IS NULL";
	private static final String _FINDER_COLUMN_GRADECODE_POSTGRADECODE_2 = "postGrade.postGradeCode = ?";
	private static final String _FINDER_COLUMN_GRADECODE_POSTGRADECODE_3 = "(postGrade.postGradeCode IS NULL OR postGrade.postGradeCode = '')";

	public PostGradePersistenceImpl() {
		setModelClass(PostGrade.class);
	}

	/**
	 * Caches the post grade in the entity cache if it is enabled.
	 *
	 * @param postGrade the post grade
	 */
	@Override
	public void cacheResult(PostGrade postGrade) {
		EntityCacheUtil.putResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeImpl.class, postGrade.getPrimaryKey(), postGrade);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADECODE,
			new Object[] { postGrade.getPostGradeCode() }, postGrade);

		postGrade.resetOriginalValues();
	}

	/**
	 * Caches the post grades in the entity cache if it is enabled.
	 *
	 * @param postGrades the post grades
	 */
	@Override
	public void cacheResult(List<PostGrade> postGrades) {
		for (PostGrade postGrade : postGrades) {
			if (EntityCacheUtil.getResult(
						PostGradeModelImpl.ENTITY_CACHE_ENABLED,
						PostGradeImpl.class, postGrade.getPrimaryKey()) == null) {
				cacheResult(postGrade);
			}
			else {
				postGrade.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all post grades.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PostGradeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PostGradeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the post grade.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostGrade postGrade) {
		EntityCacheUtil.removeResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeImpl.class, postGrade.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(postGrade);
	}

	@Override
	public void clearCache(List<PostGrade> postGrades) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PostGrade postGrade : postGrades) {
			EntityCacheUtil.removeResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
				PostGradeImpl.class, postGrade.getPrimaryKey());

			clearUniqueFindersCache(postGrade);
		}
	}

	protected void cacheUniqueFindersCache(PostGrade postGrade) {
		if (postGrade.isNew()) {
			Object[] args = new Object[] { postGrade.getPostGradeCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GRADECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADECODE, args,
				postGrade);
		}
		else {
			PostGradeModelImpl postGradeModelImpl = (PostGradeModelImpl)postGrade;

			if ((postGradeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GRADECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { postGrade.getPostGradeCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GRADECODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GRADECODE, args,
					postGrade);
			}
		}
	}

	protected void clearUniqueFindersCache(PostGrade postGrade) {
		PostGradeModelImpl postGradeModelImpl = (PostGradeModelImpl)postGrade;

		Object[] args = new Object[] { postGrade.getPostGradeCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GRADECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADECODE, args);

		if ((postGradeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GRADECODE.getColumnBitmask()) != 0) {
			args = new Object[] { postGradeModelImpl.getOriginalPostGradeCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GRADECODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GRADECODE, args);
		}
	}

	/**
	 * Creates a new post grade with the primary key. Does not add the post grade to the database.
	 *
	 * @param postGradeId the primary key for the new post grade
	 * @return the new post grade
	 */
	@Override
	public PostGrade create(long postGradeId) {
		PostGrade postGrade = new PostGradeImpl();

		postGrade.setNew(true);
		postGrade.setPrimaryKey(postGradeId);

		return postGrade;
	}

	/**
	 * Removes the post grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postGradeId the primary key of the post grade
	 * @return the post grade that was removed
	 * @throws com.idetronic.eis.NoSuchPostGradeException if a post grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade remove(long postGradeId)
		throws NoSuchPostGradeException, SystemException {
		return remove((Serializable)postGradeId);
	}

	/**
	 * Removes the post grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the post grade
	 * @return the post grade that was removed
	 * @throws com.idetronic.eis.NoSuchPostGradeException if a post grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade remove(Serializable primaryKey)
		throws NoSuchPostGradeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PostGrade postGrade = (PostGrade)session.get(PostGradeImpl.class,
					primaryKey);

			if (postGrade == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostGradeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(postGrade);
		}
		catch (NoSuchPostGradeException nsee) {
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
	protected PostGrade removeImpl(PostGrade postGrade)
		throws SystemException {
		postGrade = toUnwrappedModel(postGrade);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postGrade)) {
				postGrade = (PostGrade)session.get(PostGradeImpl.class,
						postGrade.getPrimaryKeyObj());
			}

			if (postGrade != null) {
				session.delete(postGrade);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (postGrade != null) {
			clearCache(postGrade);
		}

		return postGrade;
	}

	@Override
	public PostGrade updateImpl(com.idetronic.eis.model.PostGrade postGrade)
		throws SystemException {
		postGrade = toUnwrappedModel(postGrade);

		boolean isNew = postGrade.isNew();

		Session session = null;

		try {
			session = openSession();

			if (postGrade.isNew()) {
				session.save(postGrade);

				postGrade.setNew(false);
			}
			else {
				session.merge(postGrade);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PostGradeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
			PostGradeImpl.class, postGrade.getPrimaryKey(), postGrade);

		clearUniqueFindersCache(postGrade);
		cacheUniqueFindersCache(postGrade);

		return postGrade;
	}

	protected PostGrade toUnwrappedModel(PostGrade postGrade) {
		if (postGrade instanceof PostGradeImpl) {
			return postGrade;
		}

		PostGradeImpl postGradeImpl = new PostGradeImpl();

		postGradeImpl.setNew(postGrade.isNew());
		postGradeImpl.setPrimaryKey(postGrade.getPrimaryKey());

		postGradeImpl.setPostGradeId(postGrade.getPostGradeId());
		postGradeImpl.setPostCategoryId(postGrade.getPostCategoryId());
		postGradeImpl.setPostGradeCode(postGrade.getPostGradeCode());
		postGradeImpl.setPostGradeScheme(postGrade.getPostGradeScheme());
		postGradeImpl.setPostGradeName(postGrade.getPostGradeName());
		postGradeImpl.setPostGradeDesc(postGrade.getPostGradeDesc());
		postGradeImpl.setCompanyId(postGrade.getCompanyId());
		postGradeImpl.setGroupId(postGrade.getGroupId());
		postGradeImpl.setUserId(postGrade.getUserId());
		postGradeImpl.setUserName(postGrade.getUserName());
		postGradeImpl.setCreateDate(postGrade.getCreateDate());
		postGradeImpl.setModifiedDate(postGrade.getModifiedDate());

		return postGradeImpl;
	}

	/**
	 * Returns the post grade with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the post grade
	 * @return the post grade
	 * @throws com.idetronic.eis.NoSuchPostGradeException if a post grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostGradeException, SystemException {
		PostGrade postGrade = fetchByPrimaryKey(primaryKey);

		if (postGrade == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostGradeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return postGrade;
	}

	/**
	 * Returns the post grade with the primary key or throws a {@link com.idetronic.eis.NoSuchPostGradeException} if it could not be found.
	 *
	 * @param postGradeId the primary key of the post grade
	 * @return the post grade
	 * @throws com.idetronic.eis.NoSuchPostGradeException if a post grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade findByPrimaryKey(long postGradeId)
		throws NoSuchPostGradeException, SystemException {
		return findByPrimaryKey((Serializable)postGradeId);
	}

	/**
	 * Returns the post grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the post grade
	 * @return the post grade, or <code>null</code> if a post grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PostGrade postGrade = (PostGrade)EntityCacheUtil.getResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
				PostGradeImpl.class, primaryKey);

		if (postGrade == _nullPostGrade) {
			return null;
		}

		if (postGrade == null) {
			Session session = null;

			try {
				session = openSession();

				postGrade = (PostGrade)session.get(PostGradeImpl.class,
						primaryKey);

				if (postGrade != null) {
					cacheResult(postGrade);
				}
				else {
					EntityCacheUtil.putResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
						PostGradeImpl.class, primaryKey, _nullPostGrade);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PostGradeModelImpl.ENTITY_CACHE_ENABLED,
					PostGradeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return postGrade;
	}

	/**
	 * Returns the post grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postGradeId the primary key of the post grade
	 * @return the post grade, or <code>null</code> if a post grade with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PostGrade fetchByPrimaryKey(long postGradeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)postGradeId);
	}

	/**
	 * Returns all the post grades.
	 *
	 * @return the post grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PostGrade> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the post grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of post grades
	 * @param end the upper bound of the range of post grades (not inclusive)
	 * @return the range of post grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PostGrade> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the post grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of post grades
	 * @param end the upper bound of the range of post grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post grades
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PostGrade> findAll(int start, int end,
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

		List<PostGrade> list = (List<PostGrade>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_POSTGRADE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POSTGRADE;

				if (pagination) {
					sql = sql.concat(PostGradeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PostGrade>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PostGrade>(list);
				}
				else {
					list = (List<PostGrade>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the post grades from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PostGrade postGrade : findAll()) {
			remove(postGrade);
		}
	}

	/**
	 * Returns the number of post grades.
	 *
	 * @return the number of post grades
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

				Query q = session.createQuery(_SQL_COUNT_POSTGRADE);

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
	 * Initializes the post grade persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.PostGrade")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PostGrade>> listenersList = new ArrayList<ModelListener<PostGrade>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PostGrade>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PostGradeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_POSTGRADE = "SELECT postGrade FROM PostGrade postGrade";
	private static final String _SQL_SELECT_POSTGRADE_WHERE = "SELECT postGrade FROM PostGrade postGrade WHERE ";
	private static final String _SQL_COUNT_POSTGRADE = "SELECT COUNT(postGrade) FROM PostGrade postGrade";
	private static final String _SQL_COUNT_POSTGRADE_WHERE = "SELECT COUNT(postGrade) FROM PostGrade postGrade WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "postGrade.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PostGrade exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PostGrade exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PostGradePersistenceImpl.class);
	private static PostGrade _nullPostGrade = new PostGradeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PostGrade> toCacheModel() {
				return _nullPostGradeCacheModel;
			}
		};

	private static CacheModel<PostGrade> _nullPostGradeCacheModel = new CacheModel<PostGrade>() {
			@Override
			public PostGrade toEntityModel() {
				return _nullPostGrade;
			}
		};
}
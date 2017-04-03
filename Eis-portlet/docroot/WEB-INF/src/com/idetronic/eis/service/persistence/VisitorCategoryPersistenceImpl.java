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

import com.idetronic.eis.NoSuchVisitorCategoryException;
import com.idetronic.eis.model.VisitorCategory;
import com.idetronic.eis.model.impl.VisitorCategoryImpl;
import com.idetronic.eis.model.impl.VisitorCategoryModelImpl;

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
 * The persistence implementation for the visitor category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see VisitorCategoryPersistence
 * @see VisitorCategoryUtil
 * @generated
 */
public class VisitorCategoryPersistenceImpl extends BasePersistenceImpl<VisitorCategory>
	implements VisitorCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VisitorCategoryUtil} to access the visitor category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VisitorCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryModelImpl.FINDER_CACHE_ENABLED,
			VisitorCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryModelImpl.FINDER_CACHE_ENABLED,
			VisitorCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORY = new FinderPath(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryModelImpl.FINDER_CACHE_ENABLED,
			VisitorCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCategory", new String[] { String.class.getName() },
			VisitorCategoryModelImpl.VISITORCATEGORYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns the visitor category where visitorCategoryCode = &#63; or throws a {@link com.idetronic.eis.NoSuchVisitorCategoryException} if it could not be found.
	 *
	 * @param visitorCategoryCode the visitor category code
	 * @return the matching visitor category
	 * @throws com.idetronic.eis.NoSuchVisitorCategoryException if a matching visitor category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory findByCategory(String visitorCategoryCode)
		throws NoSuchVisitorCategoryException, SystemException {
		VisitorCategory visitorCategory = fetchByCategory(visitorCategoryCode);

		if (visitorCategory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("visitorCategoryCode=");
			msg.append(visitorCategoryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVisitorCategoryException(msg.toString());
		}

		return visitorCategory;
	}

	/**
	 * Returns the visitor category where visitorCategoryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param visitorCategoryCode the visitor category code
	 * @return the matching visitor category, or <code>null</code> if a matching visitor category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory fetchByCategory(String visitorCategoryCode)
		throws SystemException {
		return fetchByCategory(visitorCategoryCode, true);
	}

	/**
	 * Returns the visitor category where visitorCategoryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param visitorCategoryCode the visitor category code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching visitor category, or <code>null</code> if a matching visitor category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory fetchByCategory(String visitorCategoryCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { visitorCategoryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATEGORY,
					finderArgs, this);
		}

		if (result instanceof VisitorCategory) {
			VisitorCategory visitorCategory = (VisitorCategory)result;

			if (!Validator.equals(visitorCategoryCode,
						visitorCategory.getVisitorCategoryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_VISITORCATEGORY_WHERE);

			boolean bindVisitorCategoryCode = false;

			if (visitorCategoryCode == null) {
				query.append(_FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_1);
			}
			else if (visitorCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_3);
			}
			else {
				bindVisitorCategoryCode = true;

				query.append(_FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVisitorCategoryCode) {
					qPos.add(visitorCategoryCode);
				}

				List<VisitorCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORY,
						finderArgs, list);
				}
				else {
					VisitorCategory visitorCategory = list.get(0);

					result = visitorCategory;

					cacheResult(visitorCategory);

					if ((visitorCategory.getVisitorCategoryCode() == null) ||
							!visitorCategory.getVisitorCategoryCode()
												.equals(visitorCategoryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORY,
							finderArgs, visitorCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORY,
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
			return (VisitorCategory)result;
		}
	}

	/**
	 * Removes the visitor category where visitorCategoryCode = &#63; from the database.
	 *
	 * @param visitorCategoryCode the visitor category code
	 * @return the visitor category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory removeByCategory(String visitorCategoryCode)
		throws NoSuchVisitorCategoryException, SystemException {
		VisitorCategory visitorCategory = findByCategory(visitorCategoryCode);

		return remove(visitorCategory);
	}

	/**
	 * Returns the number of visitor categories where visitorCategoryCode = &#63;.
	 *
	 * @param visitorCategoryCode the visitor category code
	 * @return the number of matching visitor categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategory(String visitorCategoryCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { visitorCategoryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VISITORCATEGORY_WHERE);

			boolean bindVisitorCategoryCode = false;

			if (visitorCategoryCode == null) {
				query.append(_FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_1);
			}
			else if (visitorCategoryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_3);
			}
			else {
				bindVisitorCategoryCode = true;

				query.append(_FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVisitorCategoryCode) {
					qPos.add(visitorCategoryCode);
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

	private static final String _FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_1 = "visitorCategory.visitorCategoryCode IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_2 = "visitorCategory.visitorCategoryCode = ?";
	private static final String _FINDER_COLUMN_CATEGORY_VISITORCATEGORYCODE_3 = "(visitorCategory.visitorCategoryCode IS NULL OR visitorCategory.visitorCategoryCode = '')";

	public VisitorCategoryPersistenceImpl() {
		setModelClass(VisitorCategory.class);
	}

	/**
	 * Caches the visitor category in the entity cache if it is enabled.
	 *
	 * @param visitorCategory the visitor category
	 */
	@Override
	public void cacheResult(VisitorCategory visitorCategory) {
		EntityCacheUtil.putResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryImpl.class, visitorCategory.getPrimaryKey(),
			visitorCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORY,
			new Object[] { visitorCategory.getVisitorCategoryCode() },
			visitorCategory);

		visitorCategory.resetOriginalValues();
	}

	/**
	 * Caches the visitor categories in the entity cache if it is enabled.
	 *
	 * @param visitorCategories the visitor categories
	 */
	@Override
	public void cacheResult(List<VisitorCategory> visitorCategories) {
		for (VisitorCategory visitorCategory : visitorCategories) {
			if (EntityCacheUtil.getResult(
						VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VisitorCategoryImpl.class,
						visitorCategory.getPrimaryKey()) == null) {
				cacheResult(visitorCategory);
			}
			else {
				visitorCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all visitor categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VisitorCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VisitorCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the visitor category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisitorCategory visitorCategory) {
		EntityCacheUtil.removeResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryImpl.class, visitorCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(visitorCategory);
	}

	@Override
	public void clearCache(List<VisitorCategory> visitorCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VisitorCategory visitorCategory : visitorCategories) {
			EntityCacheUtil.removeResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VisitorCategoryImpl.class, visitorCategory.getPrimaryKey());

			clearUniqueFindersCache(visitorCategory);
		}
	}

	protected void cacheUniqueFindersCache(VisitorCategory visitorCategory) {
		if (visitorCategory.isNew()) {
			Object[] args = new Object[] {
					visitorCategory.getVisitorCategoryCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORY, args,
				visitorCategory);
		}
		else {
			VisitorCategoryModelImpl visitorCategoryModelImpl = (VisitorCategoryModelImpl)visitorCategory;

			if ((visitorCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						visitorCategory.getVisitorCategoryCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORY, args,
					visitorCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(VisitorCategory visitorCategory) {
		VisitorCategoryModelImpl visitorCategoryModelImpl = (VisitorCategoryModelImpl)visitorCategory;

		Object[] args = new Object[] { visitorCategory.getVisitorCategoryCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORY, args);

		if ((visitorCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATEGORY.getColumnBitmask()) != 0) {
			args = new Object[] {
					visitorCategoryModelImpl.getOriginalVisitorCategoryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORY, args);
		}
	}

	/**
	 * Creates a new visitor category with the primary key. Does not add the visitor category to the database.
	 *
	 * @param visitorCategoryId the primary key for the new visitor category
	 * @return the new visitor category
	 */
	@Override
	public VisitorCategory create(long visitorCategoryId) {
		VisitorCategory visitorCategory = new VisitorCategoryImpl();

		visitorCategory.setNew(true);
		visitorCategory.setPrimaryKey(visitorCategoryId);

		return visitorCategory;
	}

	/**
	 * Removes the visitor category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param visitorCategoryId the primary key of the visitor category
	 * @return the visitor category that was removed
	 * @throws com.idetronic.eis.NoSuchVisitorCategoryException if a visitor category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory remove(long visitorCategoryId)
		throws NoSuchVisitorCategoryException, SystemException {
		return remove((Serializable)visitorCategoryId);
	}

	/**
	 * Removes the visitor category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visitor category
	 * @return the visitor category that was removed
	 * @throws com.idetronic.eis.NoSuchVisitorCategoryException if a visitor category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory remove(Serializable primaryKey)
		throws NoSuchVisitorCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VisitorCategory visitorCategory = (VisitorCategory)session.get(VisitorCategoryImpl.class,
					primaryKey);

			if (visitorCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisitorCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(visitorCategory);
		}
		catch (NoSuchVisitorCategoryException nsee) {
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
	protected VisitorCategory removeImpl(VisitorCategory visitorCategory)
		throws SystemException {
		visitorCategory = toUnwrappedModel(visitorCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visitorCategory)) {
				visitorCategory = (VisitorCategory)session.get(VisitorCategoryImpl.class,
						visitorCategory.getPrimaryKeyObj());
			}

			if (visitorCategory != null) {
				session.delete(visitorCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (visitorCategory != null) {
			clearCache(visitorCategory);
		}

		return visitorCategory;
	}

	@Override
	public VisitorCategory updateImpl(
		com.idetronic.eis.model.VisitorCategory visitorCategory)
		throws SystemException {
		visitorCategory = toUnwrappedModel(visitorCategory);

		boolean isNew = visitorCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (visitorCategory.isNew()) {
				session.save(visitorCategory);

				visitorCategory.setNew(false);
			}
			else {
				session.merge(visitorCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VisitorCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
			VisitorCategoryImpl.class, visitorCategory.getPrimaryKey(),
			visitorCategory);

		clearUniqueFindersCache(visitorCategory);
		cacheUniqueFindersCache(visitorCategory);

		return visitorCategory;
	}

	protected VisitorCategory toUnwrappedModel(VisitorCategory visitorCategory) {
		if (visitorCategory instanceof VisitorCategoryImpl) {
			return visitorCategory;
		}

		VisitorCategoryImpl visitorCategoryImpl = new VisitorCategoryImpl();

		visitorCategoryImpl.setNew(visitorCategory.isNew());
		visitorCategoryImpl.setPrimaryKey(visitorCategory.getPrimaryKey());

		visitorCategoryImpl.setVisitorCategoryId(visitorCategory.getVisitorCategoryId());
		visitorCategoryImpl.setVisitorCategoryCode(visitorCategory.getVisitorCategoryCode());
		visitorCategoryImpl.setVisitorCategoryName(visitorCategory.getVisitorCategoryName());

		return visitorCategoryImpl;
	}

	/**
	 * Returns the visitor category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the visitor category
	 * @return the visitor category
	 * @throws com.idetronic.eis.NoSuchVisitorCategoryException if a visitor category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisitorCategoryException, SystemException {
		VisitorCategory visitorCategory = fetchByPrimaryKey(primaryKey);

		if (visitorCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisitorCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return visitorCategory;
	}

	/**
	 * Returns the visitor category with the primary key or throws a {@link com.idetronic.eis.NoSuchVisitorCategoryException} if it could not be found.
	 *
	 * @param visitorCategoryId the primary key of the visitor category
	 * @return the visitor category
	 * @throws com.idetronic.eis.NoSuchVisitorCategoryException if a visitor category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory findByPrimaryKey(long visitorCategoryId)
		throws NoSuchVisitorCategoryException, SystemException {
		return findByPrimaryKey((Serializable)visitorCategoryId);
	}

	/**
	 * Returns the visitor category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visitor category
	 * @return the visitor category, or <code>null</code> if a visitor category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VisitorCategory visitorCategory = (VisitorCategory)EntityCacheUtil.getResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
				VisitorCategoryImpl.class, primaryKey);

		if (visitorCategory == _nullVisitorCategory) {
			return null;
		}

		if (visitorCategory == null) {
			Session session = null;

			try {
				session = openSession();

				visitorCategory = (VisitorCategory)session.get(VisitorCategoryImpl.class,
						primaryKey);

				if (visitorCategory != null) {
					cacheResult(visitorCategory);
				}
				else {
					EntityCacheUtil.putResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
						VisitorCategoryImpl.class, primaryKey,
						_nullVisitorCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VisitorCategoryModelImpl.ENTITY_CACHE_ENABLED,
					VisitorCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return visitorCategory;
	}

	/**
	 * Returns the visitor category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param visitorCategoryId the primary key of the visitor category
	 * @return the visitor category, or <code>null</code> if a visitor category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VisitorCategory fetchByPrimaryKey(long visitorCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)visitorCategoryId);
	}

	/**
	 * Returns all the visitor categories.
	 *
	 * @return the visitor categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitorCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visitor categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.VisitorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of visitor categories
	 * @param end the upper bound of the range of visitor categories (not inclusive)
	 * @return the range of visitor categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitorCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visitor categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.VisitorCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of visitor categories
	 * @param end the upper bound of the range of visitor categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visitor categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VisitorCategory> findAll(int start, int end,
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

		List<VisitorCategory> list = (List<VisitorCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VISITORCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VISITORCATEGORY;

				if (pagination) {
					sql = sql.concat(VisitorCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VisitorCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VisitorCategory>(list);
				}
				else {
					list = (List<VisitorCategory>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the visitor categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VisitorCategory visitorCategory : findAll()) {
			remove(visitorCategory);
		}
	}

	/**
	 * Returns the number of visitor categories.
	 *
	 * @return the number of visitor categories
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

				Query q = session.createQuery(_SQL_COUNT_VISITORCATEGORY);

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
	 * Initializes the visitor category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.VisitorCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VisitorCategory>> listenersList = new ArrayList<ModelListener<VisitorCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VisitorCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VisitorCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VISITORCATEGORY = "SELECT visitorCategory FROM VisitorCategory visitorCategory";
	private static final String _SQL_SELECT_VISITORCATEGORY_WHERE = "SELECT visitorCategory FROM VisitorCategory visitorCategory WHERE ";
	private static final String _SQL_COUNT_VISITORCATEGORY = "SELECT COUNT(visitorCategory) FROM VisitorCategory visitorCategory";
	private static final String _SQL_COUNT_VISITORCATEGORY_WHERE = "SELECT COUNT(visitorCategory) FROM VisitorCategory visitorCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "visitorCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VisitorCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VisitorCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VisitorCategoryPersistenceImpl.class);
	private static VisitorCategory _nullVisitorCategory = new VisitorCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VisitorCategory> toCacheModel() {
				return _nullVisitorCategoryCacheModel;
			}
		};

	private static CacheModel<VisitorCategory> _nullVisitorCategoryCacheModel = new CacheModel<VisitorCategory>() {
			@Override
			public VisitorCategory toEntityModel() {
				return _nullVisitorCategory;
			}
		};
}
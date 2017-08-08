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

import com.idetronic.eis.NoSuchFactArticleIndexingException;
import com.idetronic.eis.model.FactArticleIndexing;
import com.idetronic.eis.model.impl.FactArticleIndexingImpl;
import com.idetronic.eis.model.impl.FactArticleIndexingModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the fact article indexing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactArticleIndexingPersistence
 * @see FactArticleIndexingUtil
 * @generated
 */
public class FactArticleIndexingPersistenceImpl extends BasePersistenceImpl<FactArticleIndexing>
	implements FactArticleIndexingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactArticleIndexingUtil} to access the fact article indexing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactArticleIndexingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
			FactArticleIndexingModelImpl.FINDER_CACHE_ENABLED,
			FactArticleIndexingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
			FactArticleIndexingModelImpl.FINDER_CACHE_ENABLED,
			FactArticleIndexingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
			FactArticleIndexingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactArticleIndexingPersistenceImpl() {
		setModelClass(FactArticleIndexing.class);
	}

	/**
	 * Caches the fact article indexing in the entity cache if it is enabled.
	 *
	 * @param factArticleIndexing the fact article indexing
	 */
	@Override
	public void cacheResult(FactArticleIndexing factArticleIndexing) {
		EntityCacheUtil.putResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
			FactArticleIndexingImpl.class, factArticleIndexing.getPrimaryKey(),
			factArticleIndexing);

		factArticleIndexing.resetOriginalValues();
	}

	/**
	 * Caches the fact article indexings in the entity cache if it is enabled.
	 *
	 * @param factArticleIndexings the fact article indexings
	 */
	@Override
	public void cacheResult(List<FactArticleIndexing> factArticleIndexings) {
		for (FactArticleIndexing factArticleIndexing : factArticleIndexings) {
			if (EntityCacheUtil.getResult(
						FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
						FactArticleIndexingImpl.class,
						factArticleIndexing.getPrimaryKey()) == null) {
				cacheResult(factArticleIndexing);
			}
			else {
				factArticleIndexing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact article indexings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactArticleIndexingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactArticleIndexingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact article indexing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactArticleIndexing factArticleIndexing) {
		EntityCacheUtil.removeResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
			FactArticleIndexingImpl.class, factArticleIndexing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactArticleIndexing> factArticleIndexings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactArticleIndexing factArticleIndexing : factArticleIndexings) {
			EntityCacheUtil.removeResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
				FactArticleIndexingImpl.class,
				factArticleIndexing.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact article indexing with the primary key. Does not add the fact article indexing to the database.
	 *
	 * @param factId the primary key for the new fact article indexing
	 * @return the new fact article indexing
	 */
	@Override
	public FactArticleIndexing create(long factId) {
		FactArticleIndexing factArticleIndexing = new FactArticleIndexingImpl();

		factArticleIndexing.setNew(true);
		factArticleIndexing.setPrimaryKey(factId);

		return factArticleIndexing;
	}

	/**
	 * Removes the fact article indexing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact article indexing
	 * @return the fact article indexing that was removed
	 * @throws com.idetronic.eis.NoSuchFactArticleIndexingException if a fact article indexing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactArticleIndexing remove(long factId)
		throws NoSuchFactArticleIndexingException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact article indexing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact article indexing
	 * @return the fact article indexing that was removed
	 * @throws com.idetronic.eis.NoSuchFactArticleIndexingException if a fact article indexing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactArticleIndexing remove(Serializable primaryKey)
		throws NoSuchFactArticleIndexingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactArticleIndexing factArticleIndexing = (FactArticleIndexing)session.get(FactArticleIndexingImpl.class,
					primaryKey);

			if (factArticleIndexing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactArticleIndexingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factArticleIndexing);
		}
		catch (NoSuchFactArticleIndexingException nsee) {
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
	protected FactArticleIndexing removeImpl(
		FactArticleIndexing factArticleIndexing) throws SystemException {
		factArticleIndexing = toUnwrappedModel(factArticleIndexing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factArticleIndexing)) {
				factArticleIndexing = (FactArticleIndexing)session.get(FactArticleIndexingImpl.class,
						factArticleIndexing.getPrimaryKeyObj());
			}

			if (factArticleIndexing != null) {
				session.delete(factArticleIndexing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factArticleIndexing != null) {
			clearCache(factArticleIndexing);
		}

		return factArticleIndexing;
	}

	@Override
	public FactArticleIndexing updateImpl(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing)
		throws SystemException {
		factArticleIndexing = toUnwrappedModel(factArticleIndexing);

		boolean isNew = factArticleIndexing.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factArticleIndexing.isNew()) {
				session.save(factArticleIndexing);

				factArticleIndexing.setNew(false);
			}
			else {
				session.merge(factArticleIndexing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
			FactArticleIndexingImpl.class, factArticleIndexing.getPrimaryKey(),
			factArticleIndexing);

		return factArticleIndexing;
	}

	protected FactArticleIndexing toUnwrappedModel(
		FactArticleIndexing factArticleIndexing) {
		if (factArticleIndexing instanceof FactArticleIndexingImpl) {
			return factArticleIndexing;
		}

		FactArticleIndexingImpl factArticleIndexingImpl = new FactArticleIndexingImpl();

		factArticleIndexingImpl.setNew(factArticleIndexing.isNew());
		factArticleIndexingImpl.setPrimaryKey(factArticleIndexing.getPrimaryKey());

		factArticleIndexingImpl.setFactId(factArticleIndexing.getFactId());
		factArticleIndexingImpl.setLibraryId(factArticleIndexing.getLibraryId());
		factArticleIndexingImpl.setPeriod(factArticleIndexing.getPeriod());
		factArticleIndexingImpl.setItemId(factArticleIndexing.getItemId());
		factArticleIndexingImpl.setIndexTotal(factArticleIndexing.getIndexTotal());
		factArticleIndexingImpl.setCompanyId(factArticleIndexing.getCompanyId());
		factArticleIndexingImpl.setGroupId(factArticleIndexing.getGroupId());
		factArticleIndexingImpl.setUserId(factArticleIndexing.getUserId());
		factArticleIndexingImpl.setUserName(factArticleIndexing.getUserName());
		factArticleIndexingImpl.setCreateDate(factArticleIndexing.getCreateDate());

		return factArticleIndexingImpl;
	}

	/**
	 * Returns the fact article indexing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact article indexing
	 * @return the fact article indexing
	 * @throws com.idetronic.eis.NoSuchFactArticleIndexingException if a fact article indexing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactArticleIndexing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactArticleIndexingException, SystemException {
		FactArticleIndexing factArticleIndexing = fetchByPrimaryKey(primaryKey);

		if (factArticleIndexing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactArticleIndexingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factArticleIndexing;
	}

	/**
	 * Returns the fact article indexing with the primary key or throws a {@link com.idetronic.eis.NoSuchFactArticleIndexingException} if it could not be found.
	 *
	 * @param factId the primary key of the fact article indexing
	 * @return the fact article indexing
	 * @throws com.idetronic.eis.NoSuchFactArticleIndexingException if a fact article indexing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactArticleIndexing findByPrimaryKey(long factId)
		throws NoSuchFactArticleIndexingException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact article indexing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact article indexing
	 * @return the fact article indexing, or <code>null</code> if a fact article indexing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactArticleIndexing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactArticleIndexing factArticleIndexing = (FactArticleIndexing)EntityCacheUtil.getResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
				FactArticleIndexingImpl.class, primaryKey);

		if (factArticleIndexing == _nullFactArticleIndexing) {
			return null;
		}

		if (factArticleIndexing == null) {
			Session session = null;

			try {
				session = openSession();

				factArticleIndexing = (FactArticleIndexing)session.get(FactArticleIndexingImpl.class,
						primaryKey);

				if (factArticleIndexing != null) {
					cacheResult(factArticleIndexing);
				}
				else {
					EntityCacheUtil.putResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
						FactArticleIndexingImpl.class, primaryKey,
						_nullFactArticleIndexing);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactArticleIndexingModelImpl.ENTITY_CACHE_ENABLED,
					FactArticleIndexingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factArticleIndexing;
	}

	/**
	 * Returns the fact article indexing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact article indexing
	 * @return the fact article indexing, or <code>null</code> if a fact article indexing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactArticleIndexing fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact article indexings.
	 *
	 * @return the fact article indexings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactArticleIndexing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact article indexings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact article indexings
	 * @param end the upper bound of the range of fact article indexings (not inclusive)
	 * @return the range of fact article indexings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactArticleIndexing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact article indexings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact article indexings
	 * @param end the upper bound of the range of fact article indexings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact article indexings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactArticleIndexing> findAll(int start, int end,
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

		List<FactArticleIndexing> list = (List<FactArticleIndexing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTARTICLEINDEXING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTARTICLEINDEXING;

				if (pagination) {
					sql = sql.concat(FactArticleIndexingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactArticleIndexing>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactArticleIndexing>(list);
				}
				else {
					list = (List<FactArticleIndexing>)QueryUtil.list(q,
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
	 * Removes all the fact article indexings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactArticleIndexing factArticleIndexing : findAll()) {
			remove(factArticleIndexing);
		}
	}

	/**
	 * Returns the number of fact article indexings.
	 *
	 * @return the number of fact article indexings
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

				Query q = session.createQuery(_SQL_COUNT_FACTARTICLEINDEXING);

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
	 * Initializes the fact article indexing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactArticleIndexing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactArticleIndexing>> listenersList = new ArrayList<ModelListener<FactArticleIndexing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactArticleIndexing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactArticleIndexingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTARTICLEINDEXING = "SELECT factArticleIndexing FROM FactArticleIndexing factArticleIndexing";
	private static final String _SQL_COUNT_FACTARTICLEINDEXING = "SELECT COUNT(factArticleIndexing) FROM FactArticleIndexing factArticleIndexing";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factArticleIndexing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactArticleIndexing exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactArticleIndexingPersistenceImpl.class);
	private static FactArticleIndexing _nullFactArticleIndexing = new FactArticleIndexingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactArticleIndexing> toCacheModel() {
				return _nullFactArticleIndexingCacheModel;
			}
		};

	private static CacheModel<FactArticleIndexing> _nullFactArticleIndexingCacheModel =
		new CacheModel<FactArticleIndexing>() {
			@Override
			public FactArticleIndexing toEntityModel() {
				return _nullFactArticleIndexing;
			}
		};
}
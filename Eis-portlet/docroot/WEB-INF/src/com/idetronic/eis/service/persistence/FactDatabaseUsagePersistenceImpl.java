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

import com.idetronic.eis.NoSuchFactDatabaseUsageException;
import com.idetronic.eis.model.FactDatabaseUsage;
import com.idetronic.eis.model.impl.FactDatabaseUsageImpl;
import com.idetronic.eis.model.impl.FactDatabaseUsageModelImpl;

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
 * The persistence implementation for the fact database usage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDatabaseUsagePersistence
 * @see FactDatabaseUsageUtil
 * @generated
 */
public class FactDatabaseUsagePersistenceImpl extends BasePersistenceImpl<FactDatabaseUsage>
	implements FactDatabaseUsagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactDatabaseUsageUtil} to access the fact database usage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactDatabaseUsageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactDatabaseUsageModelImpl.FINDER_CACHE_ENABLED,
			FactDatabaseUsageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactDatabaseUsageModelImpl.FINDER_CACHE_ENABLED,
			FactDatabaseUsageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactDatabaseUsageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactDatabaseUsagePersistenceImpl() {
		setModelClass(FactDatabaseUsage.class);
	}

	/**
	 * Caches the fact database usage in the entity cache if it is enabled.
	 *
	 * @param factDatabaseUsage the fact database usage
	 */
	@Override
	public void cacheResult(FactDatabaseUsage factDatabaseUsage) {
		EntityCacheUtil.putResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactDatabaseUsageImpl.class, factDatabaseUsage.getPrimaryKey(),
			factDatabaseUsage);

		factDatabaseUsage.resetOriginalValues();
	}

	/**
	 * Caches the fact database usages in the entity cache if it is enabled.
	 *
	 * @param factDatabaseUsages the fact database usages
	 */
	@Override
	public void cacheResult(List<FactDatabaseUsage> factDatabaseUsages) {
		for (FactDatabaseUsage factDatabaseUsage : factDatabaseUsages) {
			if (EntityCacheUtil.getResult(
						FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
						FactDatabaseUsageImpl.class,
						factDatabaseUsage.getPrimaryKey()) == null) {
				cacheResult(factDatabaseUsage);
			}
			else {
				factDatabaseUsage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact database usages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactDatabaseUsageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactDatabaseUsageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact database usage.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactDatabaseUsage factDatabaseUsage) {
		EntityCacheUtil.removeResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactDatabaseUsageImpl.class, factDatabaseUsage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactDatabaseUsage> factDatabaseUsages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactDatabaseUsage factDatabaseUsage : factDatabaseUsages) {
			EntityCacheUtil.removeResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
				FactDatabaseUsageImpl.class, factDatabaseUsage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact database usage with the primary key. Does not add the fact database usage to the database.
	 *
	 * @param factId the primary key for the new fact database usage
	 * @return the new fact database usage
	 */
	@Override
	public FactDatabaseUsage create(long factId) {
		FactDatabaseUsage factDatabaseUsage = new FactDatabaseUsageImpl();

		factDatabaseUsage.setNew(true);
		factDatabaseUsage.setPrimaryKey(factId);

		return factDatabaseUsage;
	}

	/**
	 * Removes the fact database usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact database usage
	 * @return the fact database usage that was removed
	 * @throws com.idetronic.eis.NoSuchFactDatabaseUsageException if a fact database usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDatabaseUsage remove(long factId)
		throws NoSuchFactDatabaseUsageException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact database usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact database usage
	 * @return the fact database usage that was removed
	 * @throws com.idetronic.eis.NoSuchFactDatabaseUsageException if a fact database usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDatabaseUsage remove(Serializable primaryKey)
		throws NoSuchFactDatabaseUsageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactDatabaseUsage factDatabaseUsage = (FactDatabaseUsage)session.get(FactDatabaseUsageImpl.class,
					primaryKey);

			if (factDatabaseUsage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactDatabaseUsageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factDatabaseUsage);
		}
		catch (NoSuchFactDatabaseUsageException nsee) {
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
	protected FactDatabaseUsage removeImpl(FactDatabaseUsage factDatabaseUsage)
		throws SystemException {
		factDatabaseUsage = toUnwrappedModel(factDatabaseUsage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factDatabaseUsage)) {
				factDatabaseUsage = (FactDatabaseUsage)session.get(FactDatabaseUsageImpl.class,
						factDatabaseUsage.getPrimaryKeyObj());
			}

			if (factDatabaseUsage != null) {
				session.delete(factDatabaseUsage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factDatabaseUsage != null) {
			clearCache(factDatabaseUsage);
		}

		return factDatabaseUsage;
	}

	@Override
	public FactDatabaseUsage updateImpl(
		com.idetronic.eis.model.FactDatabaseUsage factDatabaseUsage)
		throws SystemException {
		factDatabaseUsage = toUnwrappedModel(factDatabaseUsage);

		boolean isNew = factDatabaseUsage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factDatabaseUsage.isNew()) {
				session.save(factDatabaseUsage);

				factDatabaseUsage.setNew(false);
			}
			else {
				session.merge(factDatabaseUsage);
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

		EntityCacheUtil.putResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactDatabaseUsageImpl.class, factDatabaseUsage.getPrimaryKey(),
			factDatabaseUsage);

		return factDatabaseUsage;
	}

	protected FactDatabaseUsage toUnwrappedModel(
		FactDatabaseUsage factDatabaseUsage) {
		if (factDatabaseUsage instanceof FactDatabaseUsageImpl) {
			return factDatabaseUsage;
		}

		FactDatabaseUsageImpl factDatabaseUsageImpl = new FactDatabaseUsageImpl();

		factDatabaseUsageImpl.setNew(factDatabaseUsage.isNew());
		factDatabaseUsageImpl.setPrimaryKey(factDatabaseUsage.getPrimaryKey());

		factDatabaseUsageImpl.setFactId(factDatabaseUsage.getFactId());
		factDatabaseUsageImpl.setLibraryId(factDatabaseUsage.getLibraryId());
		factDatabaseUsageImpl.setPeriod(factDatabaseUsage.getPeriod());
		factDatabaseUsageImpl.setItemId(factDatabaseUsage.getItemId());
		factDatabaseUsageImpl.setDownloadTotal(factDatabaseUsage.getDownloadTotal());
		factDatabaseUsageImpl.setSessionTotal(factDatabaseUsage.getSessionTotal());
		factDatabaseUsageImpl.setSearchTotal(factDatabaseUsage.getSearchTotal());
		factDatabaseUsageImpl.setCompanyId(factDatabaseUsage.getCompanyId());
		factDatabaseUsageImpl.setGroupId(factDatabaseUsage.getGroupId());
		factDatabaseUsageImpl.setUserId(factDatabaseUsage.getUserId());
		factDatabaseUsageImpl.setUserName(factDatabaseUsage.getUserName());
		factDatabaseUsageImpl.setCreateDate(factDatabaseUsage.getCreateDate());

		return factDatabaseUsageImpl;
	}

	/**
	 * Returns the fact database usage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact database usage
	 * @return the fact database usage
	 * @throws com.idetronic.eis.NoSuchFactDatabaseUsageException if a fact database usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDatabaseUsage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactDatabaseUsageException, SystemException {
		FactDatabaseUsage factDatabaseUsage = fetchByPrimaryKey(primaryKey);

		if (factDatabaseUsage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactDatabaseUsageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factDatabaseUsage;
	}

	/**
	 * Returns the fact database usage with the primary key or throws a {@link com.idetronic.eis.NoSuchFactDatabaseUsageException} if it could not be found.
	 *
	 * @param factId the primary key of the fact database usage
	 * @return the fact database usage
	 * @throws com.idetronic.eis.NoSuchFactDatabaseUsageException if a fact database usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDatabaseUsage findByPrimaryKey(long factId)
		throws NoSuchFactDatabaseUsageException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact database usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact database usage
	 * @return the fact database usage, or <code>null</code> if a fact database usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDatabaseUsage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactDatabaseUsage factDatabaseUsage = (FactDatabaseUsage)EntityCacheUtil.getResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
				FactDatabaseUsageImpl.class, primaryKey);

		if (factDatabaseUsage == _nullFactDatabaseUsage) {
			return null;
		}

		if (factDatabaseUsage == null) {
			Session session = null;

			try {
				session = openSession();

				factDatabaseUsage = (FactDatabaseUsage)session.get(FactDatabaseUsageImpl.class,
						primaryKey);

				if (factDatabaseUsage != null) {
					cacheResult(factDatabaseUsage);
				}
				else {
					EntityCacheUtil.putResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
						FactDatabaseUsageImpl.class, primaryKey,
						_nullFactDatabaseUsage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactDatabaseUsageModelImpl.ENTITY_CACHE_ENABLED,
					FactDatabaseUsageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factDatabaseUsage;
	}

	/**
	 * Returns the fact database usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact database usage
	 * @return the fact database usage, or <code>null</code> if a fact database usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDatabaseUsage fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact database usages.
	 *
	 * @return the fact database usages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactDatabaseUsage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact database usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDatabaseUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact database usages
	 * @param end the upper bound of the range of fact database usages (not inclusive)
	 * @return the range of fact database usages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactDatabaseUsage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact database usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDatabaseUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact database usages
	 * @param end the upper bound of the range of fact database usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact database usages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactDatabaseUsage> findAll(int start, int end,
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

		List<FactDatabaseUsage> list = (List<FactDatabaseUsage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTDATABASEUSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTDATABASEUSAGE;

				if (pagination) {
					sql = sql.concat(FactDatabaseUsageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactDatabaseUsage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactDatabaseUsage>(list);
				}
				else {
					list = (List<FactDatabaseUsage>)QueryUtil.list(q,
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
	 * Removes all the fact database usages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactDatabaseUsage factDatabaseUsage : findAll()) {
			remove(factDatabaseUsage);
		}
	}

	/**
	 * Returns the number of fact database usages.
	 *
	 * @return the number of fact database usages
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

				Query q = session.createQuery(_SQL_COUNT_FACTDATABASEUSAGE);

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
	 * Initializes the fact database usage persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactDatabaseUsage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactDatabaseUsage>> listenersList = new ArrayList<ModelListener<FactDatabaseUsage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactDatabaseUsage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactDatabaseUsageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTDATABASEUSAGE = "SELECT factDatabaseUsage FROM FactDatabaseUsage factDatabaseUsage";
	private static final String _SQL_COUNT_FACTDATABASEUSAGE = "SELECT COUNT(factDatabaseUsage) FROM FactDatabaseUsage factDatabaseUsage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factDatabaseUsage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactDatabaseUsage exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactDatabaseUsagePersistenceImpl.class);
	private static FactDatabaseUsage _nullFactDatabaseUsage = new FactDatabaseUsageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactDatabaseUsage> toCacheModel() {
				return _nullFactDatabaseUsageCacheModel;
			}
		};

	private static CacheModel<FactDatabaseUsage> _nullFactDatabaseUsageCacheModel =
		new CacheModel<FactDatabaseUsage>() {
			@Override
			public FactDatabaseUsage toEntityModel() {
				return _nullFactDatabaseUsage;
			}
		};
}
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

import com.idetronic.eis.NoSuchFactInternationalPortalUsageException;
import com.idetronic.eis.model.FactInternationalPortalUsage;
import com.idetronic.eis.model.impl.FactInternationalPortalUsageImpl;
import com.idetronic.eis.model.impl.FactInternationalPortalUsageModelImpl;

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
 * The persistence implementation for the fact international portal usage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactInternationalPortalUsagePersistence
 * @see FactInternationalPortalUsageUtil
 * @generated
 */
public class FactInternationalPortalUsagePersistenceImpl
	extends BasePersistenceImpl<FactInternationalPortalUsage>
	implements FactInternationalPortalUsagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactInternationalPortalUsageUtil} to access the fact international portal usage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactInternationalPortalUsageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactInternationalPortalUsageModelImpl.FINDER_CACHE_ENABLED,
			FactInternationalPortalUsageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactInternationalPortalUsageModelImpl.FINDER_CACHE_ENABLED,
			FactInternationalPortalUsageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactInternationalPortalUsageModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public FactInternationalPortalUsagePersistenceImpl() {
		setModelClass(FactInternationalPortalUsage.class);
	}

	/**
	 * Caches the fact international portal usage in the entity cache if it is enabled.
	 *
	 * @param factInternationalPortalUsage the fact international portal usage
	 */
	@Override
	public void cacheResult(
		FactInternationalPortalUsage factInternationalPortalUsage) {
		EntityCacheUtil.putResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactInternationalPortalUsageImpl.class,
			factInternationalPortalUsage.getPrimaryKey(),
			factInternationalPortalUsage);

		factInternationalPortalUsage.resetOriginalValues();
	}

	/**
	 * Caches the fact international portal usages in the entity cache if it is enabled.
	 *
	 * @param factInternationalPortalUsages the fact international portal usages
	 */
	@Override
	public void cacheResult(
		List<FactInternationalPortalUsage> factInternationalPortalUsages) {
		for (FactInternationalPortalUsage factInternationalPortalUsage : factInternationalPortalUsages) {
			if (EntityCacheUtil.getResult(
						FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
						FactInternationalPortalUsageImpl.class,
						factInternationalPortalUsage.getPrimaryKey()) == null) {
				cacheResult(factInternationalPortalUsage);
			}
			else {
				factInternationalPortalUsage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact international portal usages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactInternationalPortalUsageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactInternationalPortalUsageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact international portal usage.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		FactInternationalPortalUsage factInternationalPortalUsage) {
		EntityCacheUtil.removeResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactInternationalPortalUsageImpl.class,
			factInternationalPortalUsage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<FactInternationalPortalUsage> factInternationalPortalUsages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactInternationalPortalUsage factInternationalPortalUsage : factInternationalPortalUsages) {
			EntityCacheUtil.removeResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
				FactInternationalPortalUsageImpl.class,
				factInternationalPortalUsage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact international portal usage with the primary key. Does not add the fact international portal usage to the database.
	 *
	 * @param factId the primary key for the new fact international portal usage
	 * @return the new fact international portal usage
	 */
	@Override
	public FactInternationalPortalUsage create(long factId) {
		FactInternationalPortalUsage factInternationalPortalUsage = new FactInternationalPortalUsageImpl();

		factInternationalPortalUsage.setNew(true);
		factInternationalPortalUsage.setPrimaryKey(factId);

		return factInternationalPortalUsage;
	}

	/**
	 * Removes the fact international portal usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact international portal usage
	 * @return the fact international portal usage that was removed
	 * @throws com.idetronic.eis.NoSuchFactInternationalPortalUsageException if a fact international portal usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInternationalPortalUsage remove(long factId)
		throws NoSuchFactInternationalPortalUsageException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact international portal usage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact international portal usage
	 * @return the fact international portal usage that was removed
	 * @throws com.idetronic.eis.NoSuchFactInternationalPortalUsageException if a fact international portal usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInternationalPortalUsage remove(Serializable primaryKey)
		throws NoSuchFactInternationalPortalUsageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactInternationalPortalUsage factInternationalPortalUsage = (FactInternationalPortalUsage)session.get(FactInternationalPortalUsageImpl.class,
					primaryKey);

			if (factInternationalPortalUsage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactInternationalPortalUsageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factInternationalPortalUsage);
		}
		catch (NoSuchFactInternationalPortalUsageException nsee) {
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
	protected FactInternationalPortalUsage removeImpl(
		FactInternationalPortalUsage factInternationalPortalUsage)
		throws SystemException {
		factInternationalPortalUsage = toUnwrappedModel(factInternationalPortalUsage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factInternationalPortalUsage)) {
				factInternationalPortalUsage = (FactInternationalPortalUsage)session.get(FactInternationalPortalUsageImpl.class,
						factInternationalPortalUsage.getPrimaryKeyObj());
			}

			if (factInternationalPortalUsage != null) {
				session.delete(factInternationalPortalUsage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factInternationalPortalUsage != null) {
			clearCache(factInternationalPortalUsage);
		}

		return factInternationalPortalUsage;
	}

	@Override
	public FactInternationalPortalUsage updateImpl(
		com.idetronic.eis.model.FactInternationalPortalUsage factInternationalPortalUsage)
		throws SystemException {
		factInternationalPortalUsage = toUnwrappedModel(factInternationalPortalUsage);

		boolean isNew = factInternationalPortalUsage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factInternationalPortalUsage.isNew()) {
				session.save(factInternationalPortalUsage);

				factInternationalPortalUsage.setNew(false);
			}
			else {
				session.merge(factInternationalPortalUsage);
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

		EntityCacheUtil.putResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
			FactInternationalPortalUsageImpl.class,
			factInternationalPortalUsage.getPrimaryKey(),
			factInternationalPortalUsage);

		return factInternationalPortalUsage;
	}

	protected FactInternationalPortalUsage toUnwrappedModel(
		FactInternationalPortalUsage factInternationalPortalUsage) {
		if (factInternationalPortalUsage instanceof FactInternationalPortalUsageImpl) {
			return factInternationalPortalUsage;
		}

		FactInternationalPortalUsageImpl factInternationalPortalUsageImpl = new FactInternationalPortalUsageImpl();

		factInternationalPortalUsageImpl.setNew(factInternationalPortalUsage.isNew());
		factInternationalPortalUsageImpl.setPrimaryKey(factInternationalPortalUsage.getPrimaryKey());

		factInternationalPortalUsageImpl.setFactId(factInternationalPortalUsage.getFactId());
		factInternationalPortalUsageImpl.setPeriod(factInternationalPortalUsage.getPeriod());
		factInternationalPortalUsageImpl.setCountryId(factInternationalPortalUsage.getCountryId());
		factInternationalPortalUsageImpl.setPagesTotal(factInternationalPortalUsage.getPagesTotal());
		factInternationalPortalUsageImpl.setCompanyId(factInternationalPortalUsage.getCompanyId());
		factInternationalPortalUsageImpl.setGroupId(factInternationalPortalUsage.getGroupId());
		factInternationalPortalUsageImpl.setUserId(factInternationalPortalUsage.getUserId());
		factInternationalPortalUsageImpl.setUserName(factInternationalPortalUsage.getUserName());
		factInternationalPortalUsageImpl.setCreateDate(factInternationalPortalUsage.getCreateDate());

		return factInternationalPortalUsageImpl;
	}

	/**
	 * Returns the fact international portal usage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact international portal usage
	 * @return the fact international portal usage
	 * @throws com.idetronic.eis.NoSuchFactInternationalPortalUsageException if a fact international portal usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInternationalPortalUsage findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchFactInternationalPortalUsageException, SystemException {
		FactInternationalPortalUsage factInternationalPortalUsage = fetchByPrimaryKey(primaryKey);

		if (factInternationalPortalUsage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactInternationalPortalUsageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factInternationalPortalUsage;
	}

	/**
	 * Returns the fact international portal usage with the primary key or throws a {@link com.idetronic.eis.NoSuchFactInternationalPortalUsageException} if it could not be found.
	 *
	 * @param factId the primary key of the fact international portal usage
	 * @return the fact international portal usage
	 * @throws com.idetronic.eis.NoSuchFactInternationalPortalUsageException if a fact international portal usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInternationalPortalUsage findByPrimaryKey(long factId)
		throws NoSuchFactInternationalPortalUsageException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact international portal usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact international portal usage
	 * @return the fact international portal usage, or <code>null</code> if a fact international portal usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInternationalPortalUsage fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		FactInternationalPortalUsage factInternationalPortalUsage = (FactInternationalPortalUsage)EntityCacheUtil.getResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
				FactInternationalPortalUsageImpl.class, primaryKey);

		if (factInternationalPortalUsage == _nullFactInternationalPortalUsage) {
			return null;
		}

		if (factInternationalPortalUsage == null) {
			Session session = null;

			try {
				session = openSession();

				factInternationalPortalUsage = (FactInternationalPortalUsage)session.get(FactInternationalPortalUsageImpl.class,
						primaryKey);

				if (factInternationalPortalUsage != null) {
					cacheResult(factInternationalPortalUsage);
				}
				else {
					EntityCacheUtil.putResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
						FactInternationalPortalUsageImpl.class, primaryKey,
						_nullFactInternationalPortalUsage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactInternationalPortalUsageModelImpl.ENTITY_CACHE_ENABLED,
					FactInternationalPortalUsageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factInternationalPortalUsage;
	}

	/**
	 * Returns the fact international portal usage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact international portal usage
	 * @return the fact international portal usage, or <code>null</code> if a fact international portal usage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInternationalPortalUsage fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact international portal usages.
	 *
	 * @return the fact international portal usages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactInternationalPortalUsage> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact international portal usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInternationalPortalUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact international portal usages
	 * @param end the upper bound of the range of fact international portal usages (not inclusive)
	 * @return the range of fact international portal usages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactInternationalPortalUsage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact international portal usages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInternationalPortalUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact international portal usages
	 * @param end the upper bound of the range of fact international portal usages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact international portal usages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactInternationalPortalUsage> findAll(int start, int end,
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

		List<FactInternationalPortalUsage> list = (List<FactInternationalPortalUsage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTINTERNATIONALPORTALUSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTINTERNATIONALPORTALUSAGE;

				if (pagination) {
					sql = sql.concat(FactInternationalPortalUsageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactInternationalPortalUsage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactInternationalPortalUsage>(list);
				}
				else {
					list = (List<FactInternationalPortalUsage>)QueryUtil.list(q,
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
	 * Removes all the fact international portal usages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactInternationalPortalUsage factInternationalPortalUsage : findAll()) {
			remove(factInternationalPortalUsage);
		}
	}

	/**
	 * Returns the number of fact international portal usages.
	 *
	 * @return the number of fact international portal usages
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

				Query q = session.createQuery(_SQL_COUNT_FACTINTERNATIONALPORTALUSAGE);

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
	 * Initializes the fact international portal usage persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactInternationalPortalUsage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactInternationalPortalUsage>> listenersList = new ArrayList<ModelListener<FactInternationalPortalUsage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactInternationalPortalUsage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactInternationalPortalUsageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTINTERNATIONALPORTALUSAGE = "SELECT factInternationalPortalUsage FROM FactInternationalPortalUsage factInternationalPortalUsage";
	private static final String _SQL_COUNT_FACTINTERNATIONALPORTALUSAGE = "SELECT COUNT(factInternationalPortalUsage) FROM FactInternationalPortalUsage factInternationalPortalUsage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factInternationalPortalUsage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactInternationalPortalUsage exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactInternationalPortalUsagePersistenceImpl.class);
	private static FactInternationalPortalUsage _nullFactInternationalPortalUsage =
		new FactInternationalPortalUsageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactInternationalPortalUsage> toCacheModel() {
				return _nullFactInternationalPortalUsageCacheModel;
			}
		};

	private static CacheModel<FactInternationalPortalUsage> _nullFactInternationalPortalUsageCacheModel =
		new CacheModel<FactInternationalPortalUsage>() {
			@Override
			public FactInternationalPortalUsage toEntityModel() {
				return _nullFactInternationalPortalUsage;
			}
		};
}
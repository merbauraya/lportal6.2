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

import com.idetronic.eis.NoSuchFactIncomeException;
import com.idetronic.eis.model.FactIncome;
import com.idetronic.eis.model.impl.FactIncomeImpl;
import com.idetronic.eis.model.impl.FactIncomeModelImpl;

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
 * The persistence implementation for the fact income service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIncomePersistence
 * @see FactIncomeUtil
 * @generated
 */
public class FactIncomePersistenceImpl extends BasePersistenceImpl<FactIncome>
	implements FactIncomePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactIncomeUtil} to access the fact income persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactIncomeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
			FactIncomeModelImpl.FINDER_CACHE_ENABLED, FactIncomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
			FactIncomeModelImpl.FINDER_CACHE_ENABLED, FactIncomeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
			FactIncomeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactIncomePersistenceImpl() {
		setModelClass(FactIncome.class);
	}

	/**
	 * Caches the fact income in the entity cache if it is enabled.
	 *
	 * @param factIncome the fact income
	 */
	@Override
	public void cacheResult(FactIncome factIncome) {
		EntityCacheUtil.putResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
			FactIncomeImpl.class, factIncome.getPrimaryKey(), factIncome);

		factIncome.resetOriginalValues();
	}

	/**
	 * Caches the fact incomes in the entity cache if it is enabled.
	 *
	 * @param factIncomes the fact incomes
	 */
	@Override
	public void cacheResult(List<FactIncome> factIncomes) {
		for (FactIncome factIncome : factIncomes) {
			if (EntityCacheUtil.getResult(
						FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
						FactIncomeImpl.class, factIncome.getPrimaryKey()) == null) {
				cacheResult(factIncome);
			}
			else {
				factIncome.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact incomes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactIncomeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactIncomeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact income.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactIncome factIncome) {
		EntityCacheUtil.removeResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
			FactIncomeImpl.class, factIncome.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactIncome> factIncomes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactIncome factIncome : factIncomes) {
			EntityCacheUtil.removeResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
				FactIncomeImpl.class, factIncome.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact income with the primary key. Does not add the fact income to the database.
	 *
	 * @param factIncomeId the primary key for the new fact income
	 * @return the new fact income
	 */
	@Override
	public FactIncome create(long factIncomeId) {
		FactIncome factIncome = new FactIncomeImpl();

		factIncome.setNew(true);
		factIncome.setPrimaryKey(factIncomeId);

		return factIncome;
	}

	/**
	 * Removes the fact income with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factIncomeId the primary key of the fact income
	 * @return the fact income that was removed
	 * @throws com.idetronic.eis.NoSuchFactIncomeException if a fact income with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIncome remove(long factIncomeId)
		throws NoSuchFactIncomeException, SystemException {
		return remove((Serializable)factIncomeId);
	}

	/**
	 * Removes the fact income with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact income
	 * @return the fact income that was removed
	 * @throws com.idetronic.eis.NoSuchFactIncomeException if a fact income with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIncome remove(Serializable primaryKey)
		throws NoSuchFactIncomeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactIncome factIncome = (FactIncome)session.get(FactIncomeImpl.class,
					primaryKey);

			if (factIncome == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactIncomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factIncome);
		}
		catch (NoSuchFactIncomeException nsee) {
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
	protected FactIncome removeImpl(FactIncome factIncome)
		throws SystemException {
		factIncome = toUnwrappedModel(factIncome);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factIncome)) {
				factIncome = (FactIncome)session.get(FactIncomeImpl.class,
						factIncome.getPrimaryKeyObj());
			}

			if (factIncome != null) {
				session.delete(factIncome);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factIncome != null) {
			clearCache(factIncome);
		}

		return factIncome;
	}

	@Override
	public FactIncome updateImpl(com.idetronic.eis.model.FactIncome factIncome)
		throws SystemException {
		factIncome = toUnwrappedModel(factIncome);

		boolean isNew = factIncome.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factIncome.isNew()) {
				session.save(factIncome);

				factIncome.setNew(false);
			}
			else {
				session.merge(factIncome);
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

		EntityCacheUtil.putResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
			FactIncomeImpl.class, factIncome.getPrimaryKey(), factIncome);

		return factIncome;
	}

	protected FactIncome toUnwrappedModel(FactIncome factIncome) {
		if (factIncome instanceof FactIncomeImpl) {
			return factIncome;
		}

		FactIncomeImpl factIncomeImpl = new FactIncomeImpl();

		factIncomeImpl.setNew(factIncome.isNew());
		factIncomeImpl.setPrimaryKey(factIncome.getPrimaryKey());

		factIncomeImpl.setFactIncomeId(factIncome.getFactIncomeId());
		factIncomeImpl.setLibraryId(factIncome.getLibraryId());
		factIncomeImpl.setPeriod(factIncome.getPeriod());
		factIncomeImpl.setItemId(factIncome.getItemId());
		factIncomeImpl.setTotal(factIncome.getTotal());
		factIncomeImpl.setCompanyId(factIncome.getCompanyId());
		factIncomeImpl.setGroupId(factIncome.getGroupId());
		factIncomeImpl.setUserId(factIncome.getUserId());
		factIncomeImpl.setUserName(factIncome.getUserName());
		factIncomeImpl.setCreateDate(factIncome.getCreateDate());

		return factIncomeImpl;
	}

	/**
	 * Returns the fact income with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact income
	 * @return the fact income
	 * @throws com.idetronic.eis.NoSuchFactIncomeException if a fact income with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIncome findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactIncomeException, SystemException {
		FactIncome factIncome = fetchByPrimaryKey(primaryKey);

		if (factIncome == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactIncomeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factIncome;
	}

	/**
	 * Returns the fact income with the primary key or throws a {@link com.idetronic.eis.NoSuchFactIncomeException} if it could not be found.
	 *
	 * @param factIncomeId the primary key of the fact income
	 * @return the fact income
	 * @throws com.idetronic.eis.NoSuchFactIncomeException if a fact income with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIncome findByPrimaryKey(long factIncomeId)
		throws NoSuchFactIncomeException, SystemException {
		return findByPrimaryKey((Serializable)factIncomeId);
	}

	/**
	 * Returns the fact income with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact income
	 * @return the fact income, or <code>null</code> if a fact income with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIncome fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactIncome factIncome = (FactIncome)EntityCacheUtil.getResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
				FactIncomeImpl.class, primaryKey);

		if (factIncome == _nullFactIncome) {
			return null;
		}

		if (factIncome == null) {
			Session session = null;

			try {
				session = openSession();

				factIncome = (FactIncome)session.get(FactIncomeImpl.class,
						primaryKey);

				if (factIncome != null) {
					cacheResult(factIncome);
				}
				else {
					EntityCacheUtil.putResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
						FactIncomeImpl.class, primaryKey, _nullFactIncome);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactIncomeModelImpl.ENTITY_CACHE_ENABLED,
					FactIncomeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factIncome;
	}

	/**
	 * Returns the fact income with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factIncomeId the primary key of the fact income
	 * @return the fact income, or <code>null</code> if a fact income with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIncome fetchByPrimaryKey(long factIncomeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factIncomeId);
	}

	/**
	 * Returns all the fact incomes.
	 *
	 * @return the fact incomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIncome> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact incomes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIncomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact incomes
	 * @param end the upper bound of the range of fact incomes (not inclusive)
	 * @return the range of fact incomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIncome> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact incomes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIncomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact incomes
	 * @param end the upper bound of the range of fact incomes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact incomes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIncome> findAll(int start, int end,
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

		List<FactIncome> list = (List<FactIncome>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTINCOME);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTINCOME;

				if (pagination) {
					sql = sql.concat(FactIncomeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactIncome>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIncome>(list);
				}
				else {
					list = (List<FactIncome>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact incomes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactIncome factIncome : findAll()) {
			remove(factIncome);
		}
	}

	/**
	 * Returns the number of fact incomes.
	 *
	 * @return the number of fact incomes
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

				Query q = session.createQuery(_SQL_COUNT_FACTINCOME);

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
	 * Initializes the fact income persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactIncome")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactIncome>> listenersList = new ArrayList<ModelListener<FactIncome>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactIncome>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactIncomeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTINCOME = "SELECT factIncome FROM FactIncome factIncome";
	private static final String _SQL_COUNT_FACTINCOME = "SELECT COUNT(factIncome) FROM FactIncome factIncome";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factIncome.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactIncome exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactIncomePersistenceImpl.class);
	private static FactIncome _nullFactIncome = new FactIncomeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactIncome> toCacheModel() {
				return _nullFactIncomeCacheModel;
			}
		};

	private static CacheModel<FactIncome> _nullFactIncomeCacheModel = new CacheModel<FactIncome>() {
			@Override
			public FactIncome toEntityModel() {
				return _nullFactIncome;
			}
		};
}
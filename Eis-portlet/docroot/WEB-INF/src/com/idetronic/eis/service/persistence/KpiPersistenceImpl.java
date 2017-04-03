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

import com.idetronic.eis.NoSuchKpiException;
import com.idetronic.eis.model.Kpi;
import com.idetronic.eis.model.impl.KpiImpl;
import com.idetronic.eis.model.impl.KpiModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the kpi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiPersistence
 * @see KpiUtil
 * @generated
 */
public class KpiPersistenceImpl extends BasePersistenceImpl<Kpi>
	implements KpiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KpiUtil} to access the kpi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KpiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiModelImpl.FINDER_CACHE_ENABLED, KpiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiModelImpl.FINDER_CACHE_ENABLED, KpiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiModelImpl.FINDER_CACHE_ENABLED, KpiImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] { String.class.getName() },
			KpiModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the kpi where key = &#63; or throws a {@link com.idetronic.eis.NoSuchKpiException} if it could not be found.
	 *
	 * @param key the key
	 * @return the matching kpi
	 * @throws com.idetronic.eis.NoSuchKpiException if a matching kpi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi findByKey(String key) throws NoSuchKpiException, SystemException {
		Kpi kpi = fetchByKey(key);

		if (kpi == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKpiException(msg.toString());
		}

		return kpi;
	}

	/**
	 * Returns the kpi where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching kpi, or <code>null</code> if a matching kpi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi fetchByKey(String key) throws SystemException {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the kpi where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching kpi, or <code>null</code> if a matching kpi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi fetchByKey(String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
					finderArgs, this);
		}

		if (result instanceof Kpi) {
			Kpi kpi = (Kpi)result;

			if (!Validator.equals(key, kpi.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KPI_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<Kpi> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
						finderArgs, list);
				}
				else {
					Kpi kpi = list.get(0);

					result = kpi;

					cacheResult(kpi);

					if ((kpi.getKey() == null) || !kpi.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
							finderArgs, kpi);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
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
			return (Kpi)result;
		}
	}

	/**
	 * Removes the kpi where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the kpi that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi removeByKey(String key)
		throws NoSuchKpiException, SystemException {
		Kpi kpi = findByKey(key);

		return remove(kpi);
	}

	/**
	 * Returns the number of kpis where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching kpis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKey(String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEY;

		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KPI_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_KEY_KEY_1 = "kpi.key IS NULL";
	private static final String _FINDER_COLUMN_KEY_KEY_2 = "kpi.key = ?";
	private static final String _FINDER_COLUMN_KEY_KEY_3 = "(kpi.key IS NULL OR kpi.key = '')";

	public KpiPersistenceImpl() {
		setModelClass(Kpi.class);
	}

	/**
	 * Caches the kpi in the entity cache if it is enabled.
	 *
	 * @param kpi the kpi
	 */
	@Override
	public void cacheResult(Kpi kpi) {
		EntityCacheUtil.putResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiImpl.class, kpi.getPrimaryKey(), kpi);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
			new Object[] { kpi.getKey() }, kpi);

		kpi.resetOriginalValues();
	}

	/**
	 * Caches the kpis in the entity cache if it is enabled.
	 *
	 * @param kpis the kpis
	 */
	@Override
	public void cacheResult(List<Kpi> kpis) {
		for (Kpi kpi : kpis) {
			if (EntityCacheUtil.getResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
						KpiImpl.class, kpi.getPrimaryKey()) == null) {
				cacheResult(kpi);
			}
			else {
				kpi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kpis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KpiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KpiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kpi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Kpi kpi) {
		EntityCacheUtil.removeResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiImpl.class, kpi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(kpi);
	}

	@Override
	public void clearCache(List<Kpi> kpis) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Kpi kpi : kpis) {
			EntityCacheUtil.removeResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
				KpiImpl.class, kpi.getPrimaryKey());

			clearUniqueFindersCache(kpi);
		}
	}

	protected void cacheUniqueFindersCache(Kpi kpi) {
		if (kpi.isNew()) {
			Object[] args = new Object[] { kpi.getKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args, kpi);
		}
		else {
			KpiModelImpl kpiModelImpl = (KpiModelImpl)kpi;

			if ((kpiModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { kpi.getKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args, kpi);
			}
		}
	}

	protected void clearUniqueFindersCache(Kpi kpi) {
		KpiModelImpl kpiModelImpl = (KpiModelImpl)kpi;

		Object[] args = new Object[] { kpi.getKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

		if ((kpiModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
			args = new Object[] { kpiModelImpl.getOriginalKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);
		}
	}

	/**
	 * Creates a new kpi with the primary key. Does not add the kpi to the database.
	 *
	 * @param id the primary key for the new kpi
	 * @return the new kpi
	 */
	@Override
	public Kpi create(long id) {
		Kpi kpi = new KpiImpl();

		kpi.setNew(true);
		kpi.setPrimaryKey(id);

		return kpi;
	}

	/**
	 * Removes the kpi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the kpi
	 * @return the kpi that was removed
	 * @throws com.idetronic.eis.NoSuchKpiException if a kpi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi remove(long id) throws NoSuchKpiException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the kpi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kpi
	 * @return the kpi that was removed
	 * @throws com.idetronic.eis.NoSuchKpiException if a kpi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi remove(Serializable primaryKey)
		throws NoSuchKpiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Kpi kpi = (Kpi)session.get(KpiImpl.class, primaryKey);

			if (kpi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKpiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kpi);
		}
		catch (NoSuchKpiException nsee) {
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
	protected Kpi removeImpl(Kpi kpi) throws SystemException {
		kpi = toUnwrappedModel(kpi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kpi)) {
				kpi = (Kpi)session.get(KpiImpl.class, kpi.getPrimaryKeyObj());
			}

			if (kpi != null) {
				session.delete(kpi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kpi != null) {
			clearCache(kpi);
		}

		return kpi;
	}

	@Override
	public Kpi updateImpl(com.idetronic.eis.model.Kpi kpi)
		throws SystemException {
		kpi = toUnwrappedModel(kpi);

		boolean isNew = kpi.isNew();

		Session session = null;

		try {
			session = openSession();

			if (kpi.isNew()) {
				session.save(kpi);

				kpi.setNew(false);
			}
			else {
				session.merge(kpi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KpiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
			KpiImpl.class, kpi.getPrimaryKey(), kpi);

		clearUniqueFindersCache(kpi);
		cacheUniqueFindersCache(kpi);

		return kpi;
	}

	protected Kpi toUnwrappedModel(Kpi kpi) {
		if (kpi instanceof KpiImpl) {
			return kpi;
		}

		KpiImpl kpiImpl = new KpiImpl();

		kpiImpl.setNew(kpi.isNew());
		kpiImpl.setPrimaryKey(kpi.getPrimaryKey());

		kpiImpl.setId(kpi.getId());
		kpiImpl.setKey(kpi.getKey());
		kpiImpl.setKpiType(kpi.getKpiType());
		kpiImpl.setValue(kpi.getValue());
		kpiImpl.setDescription(kpi.getDescription());

		return kpiImpl;
	}

	/**
	 * Returns the kpi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kpi
	 * @return the kpi
	 * @throws com.idetronic.eis.NoSuchKpiException if a kpi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKpiException, SystemException {
		Kpi kpi = fetchByPrimaryKey(primaryKey);

		if (kpi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKpiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kpi;
	}

	/**
	 * Returns the kpi with the primary key or throws a {@link com.idetronic.eis.NoSuchKpiException} if it could not be found.
	 *
	 * @param id the primary key of the kpi
	 * @return the kpi
	 * @throws com.idetronic.eis.NoSuchKpiException if a kpi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi findByPrimaryKey(long id)
		throws NoSuchKpiException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the kpi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kpi
	 * @return the kpi, or <code>null</code> if a kpi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Kpi kpi = (Kpi)EntityCacheUtil.getResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
				KpiImpl.class, primaryKey);

		if (kpi == _nullKpi) {
			return null;
		}

		if (kpi == null) {
			Session session = null;

			try {
				session = openSession();

				kpi = (Kpi)session.get(KpiImpl.class, primaryKey);

				if (kpi != null) {
					cacheResult(kpi);
				}
				else {
					EntityCacheUtil.putResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
						KpiImpl.class, primaryKey, _nullKpi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KpiModelImpl.ENTITY_CACHE_ENABLED,
					KpiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kpi;
	}

	/**
	 * Returns the kpi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the kpi
	 * @return the kpi, or <code>null</code> if a kpi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Kpi fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the kpis.
	 *
	 * @return the kpis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Kpi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kpis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kpis
	 * @param end the upper bound of the range of kpis (not inclusive)
	 * @return the range of kpis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Kpi> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kpis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kpis
	 * @param end the upper bound of the range of kpis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kpis
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Kpi> findAll(int start, int end,
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

		List<Kpi> list = (List<Kpi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KPI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KPI;

				if (pagination) {
					sql = sql.concat(KpiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Kpi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Kpi>(list);
				}
				else {
					list = (List<Kpi>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the kpis from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Kpi kpi : findAll()) {
			remove(kpi);
		}
	}

	/**
	 * Returns the number of kpis.
	 *
	 * @return the number of kpis
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

				Query q = session.createQuery(_SQL_COUNT_KPI);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the kpi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.Kpi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Kpi>> listenersList = new ArrayList<ModelListener<Kpi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Kpi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KpiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KPI = "SELECT kpi FROM Kpi kpi";
	private static final String _SQL_SELECT_KPI_WHERE = "SELECT kpi FROM Kpi kpi WHERE ";
	private static final String _SQL_COUNT_KPI = "SELECT COUNT(kpi) FROM Kpi kpi";
	private static final String _SQL_COUNT_KPI_WHERE = "SELECT COUNT(kpi) FROM Kpi kpi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kpi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Kpi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Kpi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KpiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "key"
			});
	private static Kpi _nullKpi = new KpiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Kpi> toCacheModel() {
				return _nullKpiCacheModel;
			}
		};

	private static CacheModel<Kpi> _nullKpiCacheModel = new CacheModel<Kpi>() {
			@Override
			public Kpi toEntityModel() {
				return _nullKpi;
			}
		};
}
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

import com.idetronic.eis.NoSuchKpiTypeException;
import com.idetronic.eis.model.KpiType;
import com.idetronic.eis.model.impl.KpiTypeImpl;
import com.idetronic.eis.model.impl.KpiTypeModelImpl;

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
 * The persistence implementation for the kpi type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiTypePersistence
 * @see KpiTypeUtil
 * @generated
 */
public class KpiTypePersistenceImpl extends BasePersistenceImpl<KpiType>
	implements KpiTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KpiTypeUtil} to access the kpi type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KpiTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeModelImpl.FINDER_CACHE_ENABLED, KpiTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeModelImpl.FINDER_CACHE_ENABLED, KpiTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeModelImpl.FINDER_CACHE_ENABLED, KpiTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] { String.class.getName() },
			KpiTypeModelImpl.KPITYPEKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the kpi type where kpiTypeKey = &#63; or throws a {@link com.idetronic.eis.NoSuchKpiTypeException} if it could not be found.
	 *
	 * @param kpiTypeKey the kpi type key
	 * @return the matching kpi type
	 * @throws com.idetronic.eis.NoSuchKpiTypeException if a matching kpi type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType findByKey(String kpiTypeKey)
		throws NoSuchKpiTypeException, SystemException {
		KpiType kpiType = fetchByKey(kpiTypeKey);

		if (kpiType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kpiTypeKey=");
			msg.append(kpiTypeKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKpiTypeException(msg.toString());
		}

		return kpiType;
	}

	/**
	 * Returns the kpi type where kpiTypeKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param kpiTypeKey the kpi type key
	 * @return the matching kpi type, or <code>null</code> if a matching kpi type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType fetchByKey(String kpiTypeKey) throws SystemException {
		return fetchByKey(kpiTypeKey, true);
	}

	/**
	 * Returns the kpi type where kpiTypeKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param kpiTypeKey the kpi type key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching kpi type, or <code>null</code> if a matching kpi type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType fetchByKey(String kpiTypeKey, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { kpiTypeKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
					finderArgs, this);
		}

		if (result instanceof KpiType) {
			KpiType kpiType = (KpiType)result;

			if (!Validator.equals(kpiTypeKey, kpiType.getKpiTypeKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KPITYPE_WHERE);

			boolean bindKpiTypeKey = false;

			if (kpiTypeKey == null) {
				query.append(_FINDER_COLUMN_KEY_KPITYPEKEY_1);
			}
			else if (kpiTypeKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KPITYPEKEY_3);
			}
			else {
				bindKpiTypeKey = true;

				query.append(_FINDER_COLUMN_KEY_KPITYPEKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKpiTypeKey) {
					qPos.add(kpiTypeKey);
				}

				List<KpiType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
						finderArgs, list);
				}
				else {
					KpiType kpiType = list.get(0);

					result = kpiType;

					cacheResult(kpiType);

					if ((kpiType.getKpiTypeKey() == null) ||
							!kpiType.getKpiTypeKey().equals(kpiTypeKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
							finderArgs, kpiType);
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
			return (KpiType)result;
		}
	}

	/**
	 * Removes the kpi type where kpiTypeKey = &#63; from the database.
	 *
	 * @param kpiTypeKey the kpi type key
	 * @return the kpi type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType removeByKey(String kpiTypeKey)
		throws NoSuchKpiTypeException, SystemException {
		KpiType kpiType = findByKey(kpiTypeKey);

		return remove(kpiType);
	}

	/**
	 * Returns the number of kpi types where kpiTypeKey = &#63;.
	 *
	 * @param kpiTypeKey the kpi type key
	 * @return the number of matching kpi types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKey(String kpiTypeKey) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEY;

		Object[] finderArgs = new Object[] { kpiTypeKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KPITYPE_WHERE);

			boolean bindKpiTypeKey = false;

			if (kpiTypeKey == null) {
				query.append(_FINDER_COLUMN_KEY_KPITYPEKEY_1);
			}
			else if (kpiTypeKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KPITYPEKEY_3);
			}
			else {
				bindKpiTypeKey = true;

				query.append(_FINDER_COLUMN_KEY_KPITYPEKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKpiTypeKey) {
					qPos.add(kpiTypeKey);
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

	private static final String _FINDER_COLUMN_KEY_KPITYPEKEY_1 = "kpiType.kpiTypeKey IS NULL";
	private static final String _FINDER_COLUMN_KEY_KPITYPEKEY_2 = "kpiType.kpiTypeKey = ?";
	private static final String _FINDER_COLUMN_KEY_KPITYPEKEY_3 = "(kpiType.kpiTypeKey IS NULL OR kpiType.kpiTypeKey = '')";

	public KpiTypePersistenceImpl() {
		setModelClass(KpiType.class);
	}

	/**
	 * Caches the kpi type in the entity cache if it is enabled.
	 *
	 * @param kpiType the kpi type
	 */
	@Override
	public void cacheResult(KpiType kpiType) {
		EntityCacheUtil.putResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeImpl.class, kpiType.getPrimaryKey(), kpiType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
			new Object[] { kpiType.getKpiTypeKey() }, kpiType);

		kpiType.resetOriginalValues();
	}

	/**
	 * Caches the kpi types in the entity cache if it is enabled.
	 *
	 * @param kpiTypes the kpi types
	 */
	@Override
	public void cacheResult(List<KpiType> kpiTypes) {
		for (KpiType kpiType : kpiTypes) {
			if (EntityCacheUtil.getResult(
						KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
						KpiTypeImpl.class, kpiType.getPrimaryKey()) == null) {
				cacheResult(kpiType);
			}
			else {
				kpiType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kpi types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KpiTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KpiTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kpi type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KpiType kpiType) {
		EntityCacheUtil.removeResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeImpl.class, kpiType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(kpiType);
	}

	@Override
	public void clearCache(List<KpiType> kpiTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KpiType kpiType : kpiTypes) {
			EntityCacheUtil.removeResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
				KpiTypeImpl.class, kpiType.getPrimaryKey());

			clearUniqueFindersCache(kpiType);
		}
	}

	protected void cacheUniqueFindersCache(KpiType kpiType) {
		if (kpiType.isNew()) {
			Object[] args = new Object[] { kpiType.getKpiTypeKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args, kpiType);
		}
		else {
			KpiTypeModelImpl kpiTypeModelImpl = (KpiTypeModelImpl)kpiType;

			if ((kpiTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { kpiType.getKpiTypeKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
					kpiType);
			}
		}
	}

	protected void clearUniqueFindersCache(KpiType kpiType) {
		KpiTypeModelImpl kpiTypeModelImpl = (KpiTypeModelImpl)kpiType;

		Object[] args = new Object[] { kpiType.getKpiTypeKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

		if ((kpiTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
			args = new Object[] { kpiTypeModelImpl.getOriginalKpiTypeKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);
		}
	}

	/**
	 * Creates a new kpi type with the primary key. Does not add the kpi type to the database.
	 *
	 * @param kpiTypeId the primary key for the new kpi type
	 * @return the new kpi type
	 */
	@Override
	public KpiType create(long kpiTypeId) {
		KpiType kpiType = new KpiTypeImpl();

		kpiType.setNew(true);
		kpiType.setPrimaryKey(kpiTypeId);

		return kpiType;
	}

	/**
	 * Removes the kpi type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kpiTypeId the primary key of the kpi type
	 * @return the kpi type that was removed
	 * @throws com.idetronic.eis.NoSuchKpiTypeException if a kpi type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType remove(long kpiTypeId)
		throws NoSuchKpiTypeException, SystemException {
		return remove((Serializable)kpiTypeId);
	}

	/**
	 * Removes the kpi type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kpi type
	 * @return the kpi type that was removed
	 * @throws com.idetronic.eis.NoSuchKpiTypeException if a kpi type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType remove(Serializable primaryKey)
		throws NoSuchKpiTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KpiType kpiType = (KpiType)session.get(KpiTypeImpl.class, primaryKey);

			if (kpiType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKpiTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kpiType);
		}
		catch (NoSuchKpiTypeException nsee) {
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
	protected KpiType removeImpl(KpiType kpiType) throws SystemException {
		kpiType = toUnwrappedModel(kpiType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kpiType)) {
				kpiType = (KpiType)session.get(KpiTypeImpl.class,
						kpiType.getPrimaryKeyObj());
			}

			if (kpiType != null) {
				session.delete(kpiType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kpiType != null) {
			clearCache(kpiType);
		}

		return kpiType;
	}

	@Override
	public KpiType updateImpl(com.idetronic.eis.model.KpiType kpiType)
		throws SystemException {
		kpiType = toUnwrappedModel(kpiType);

		boolean isNew = kpiType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (kpiType.isNew()) {
				session.save(kpiType);

				kpiType.setNew(false);
			}
			else {
				session.merge(kpiType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KpiTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
			KpiTypeImpl.class, kpiType.getPrimaryKey(), kpiType);

		clearUniqueFindersCache(kpiType);
		cacheUniqueFindersCache(kpiType);

		return kpiType;
	}

	protected KpiType toUnwrappedModel(KpiType kpiType) {
		if (kpiType instanceof KpiTypeImpl) {
			return kpiType;
		}

		KpiTypeImpl kpiTypeImpl = new KpiTypeImpl();

		kpiTypeImpl.setNew(kpiType.isNew());
		kpiTypeImpl.setPrimaryKey(kpiType.getPrimaryKey());

		kpiTypeImpl.setKpiTypeId(kpiType.getKpiTypeId());
		kpiTypeImpl.setKpiTypeKey(kpiType.getKpiTypeKey());
		kpiTypeImpl.setKpiName(kpiType.getKpiName());
		kpiTypeImpl.setPeriodMonth(kpiType.isPeriodMonth());
		kpiTypeImpl.setPeriodQuarter(kpiType.isPeriodQuarter());
		kpiTypeImpl.setPeriodSemiAnnual(kpiType.isPeriodSemiAnnual());
		kpiTypeImpl.setPeriodYear(kpiType.isPeriodYear());
		kpiTypeImpl.setIsDecimal(kpiType.isIsDecimal());
		kpiTypeImpl.setManualValue(kpiType.isManualValue());

		return kpiTypeImpl;
	}

	/**
	 * Returns the kpi type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kpi type
	 * @return the kpi type
	 * @throws com.idetronic.eis.NoSuchKpiTypeException if a kpi type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKpiTypeException, SystemException {
		KpiType kpiType = fetchByPrimaryKey(primaryKey);

		if (kpiType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKpiTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kpiType;
	}

	/**
	 * Returns the kpi type with the primary key or throws a {@link com.idetronic.eis.NoSuchKpiTypeException} if it could not be found.
	 *
	 * @param kpiTypeId the primary key of the kpi type
	 * @return the kpi type
	 * @throws com.idetronic.eis.NoSuchKpiTypeException if a kpi type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType findByPrimaryKey(long kpiTypeId)
		throws NoSuchKpiTypeException, SystemException {
		return findByPrimaryKey((Serializable)kpiTypeId);
	}

	/**
	 * Returns the kpi type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kpi type
	 * @return the kpi type, or <code>null</code> if a kpi type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		KpiType kpiType = (KpiType)EntityCacheUtil.getResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
				KpiTypeImpl.class, primaryKey);

		if (kpiType == _nullKpiType) {
			return null;
		}

		if (kpiType == null) {
			Session session = null;

			try {
				session = openSession();

				kpiType = (KpiType)session.get(KpiTypeImpl.class, primaryKey);

				if (kpiType != null) {
					cacheResult(kpiType);
				}
				else {
					EntityCacheUtil.putResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
						KpiTypeImpl.class, primaryKey, _nullKpiType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KpiTypeModelImpl.ENTITY_CACHE_ENABLED,
					KpiTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kpiType;
	}

	/**
	 * Returns the kpi type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kpiTypeId the primary key of the kpi type
	 * @return the kpi type, or <code>null</code> if a kpi type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiType fetchByPrimaryKey(long kpiTypeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)kpiTypeId);
	}

	/**
	 * Returns all the kpi types.
	 *
	 * @return the kpi types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kpi types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kpi types
	 * @param end the upper bound of the range of kpi types (not inclusive)
	 * @return the range of kpi types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kpi types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kpi types
	 * @param end the upper bound of the range of kpi types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kpi types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiType> findAll(int start, int end,
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

		List<KpiType> list = (List<KpiType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KPITYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KPITYPE;

				if (pagination) {
					sql = sql.concat(KpiTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KpiType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KpiType>(list);
				}
				else {
					list = (List<KpiType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the kpi types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KpiType kpiType : findAll()) {
			remove(kpiType);
		}
	}

	/**
	 * Returns the number of kpi types.
	 *
	 * @return the number of kpi types
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

				Query q = session.createQuery(_SQL_COUNT_KPITYPE);

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
	 * Initializes the kpi type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.KpiType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KpiType>> listenersList = new ArrayList<ModelListener<KpiType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KpiType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KpiTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KPITYPE = "SELECT kpiType FROM KpiType kpiType";
	private static final String _SQL_SELECT_KPITYPE_WHERE = "SELECT kpiType FROM KpiType kpiType WHERE ";
	private static final String _SQL_COUNT_KPITYPE = "SELECT COUNT(kpiType) FROM KpiType kpiType";
	private static final String _SQL_COUNT_KPITYPE_WHERE = "SELECT COUNT(kpiType) FROM KpiType kpiType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kpiType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KpiType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KpiType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KpiTypePersistenceImpl.class);
	private static KpiType _nullKpiType = new KpiTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KpiType> toCacheModel() {
				return _nullKpiTypeCacheModel;
			}
		};

	private static CacheModel<KpiType> _nullKpiTypeCacheModel = new CacheModel<KpiType>() {
			@Override
			public KpiType toEntityModel() {
				return _nullKpiType;
			}
		};
}
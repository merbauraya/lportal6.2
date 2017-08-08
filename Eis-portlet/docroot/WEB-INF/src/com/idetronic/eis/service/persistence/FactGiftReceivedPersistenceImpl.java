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

import com.idetronic.eis.NoSuchFactGiftReceivedException;
import com.idetronic.eis.model.FactGiftReceived;
import com.idetronic.eis.model.impl.FactGiftReceivedImpl;
import com.idetronic.eis.model.impl.FactGiftReceivedModelImpl;

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
 * The persistence implementation for the fact gift received service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactGiftReceivedPersistence
 * @see FactGiftReceivedUtil
 * @generated
 */
public class FactGiftReceivedPersistenceImpl extends BasePersistenceImpl<FactGiftReceived>
	implements FactGiftReceivedPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactGiftReceivedUtil} to access the fact gift received persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactGiftReceivedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
			FactGiftReceivedModelImpl.FINDER_CACHE_ENABLED,
			FactGiftReceivedImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
			FactGiftReceivedModelImpl.FINDER_CACHE_ENABLED,
			FactGiftReceivedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
			FactGiftReceivedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactGiftReceivedPersistenceImpl() {
		setModelClass(FactGiftReceived.class);
	}

	/**
	 * Caches the fact gift received in the entity cache if it is enabled.
	 *
	 * @param factGiftReceived the fact gift received
	 */
	@Override
	public void cacheResult(FactGiftReceived factGiftReceived) {
		EntityCacheUtil.putResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
			FactGiftReceivedImpl.class, factGiftReceived.getPrimaryKey(),
			factGiftReceived);

		factGiftReceived.resetOriginalValues();
	}

	/**
	 * Caches the fact gift receiveds in the entity cache if it is enabled.
	 *
	 * @param factGiftReceiveds the fact gift receiveds
	 */
	@Override
	public void cacheResult(List<FactGiftReceived> factGiftReceiveds) {
		for (FactGiftReceived factGiftReceived : factGiftReceiveds) {
			if (EntityCacheUtil.getResult(
						FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
						FactGiftReceivedImpl.class,
						factGiftReceived.getPrimaryKey()) == null) {
				cacheResult(factGiftReceived);
			}
			else {
				factGiftReceived.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact gift receiveds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactGiftReceivedImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactGiftReceivedImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact gift received.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactGiftReceived factGiftReceived) {
		EntityCacheUtil.removeResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
			FactGiftReceivedImpl.class, factGiftReceived.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactGiftReceived> factGiftReceiveds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactGiftReceived factGiftReceived : factGiftReceiveds) {
			EntityCacheUtil.removeResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
				FactGiftReceivedImpl.class, factGiftReceived.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact gift received with the primary key. Does not add the fact gift received to the database.
	 *
	 * @param factId the primary key for the new fact gift received
	 * @return the new fact gift received
	 */
	@Override
	public FactGiftReceived create(long factId) {
		FactGiftReceived factGiftReceived = new FactGiftReceivedImpl();

		factGiftReceived.setNew(true);
		factGiftReceived.setPrimaryKey(factId);

		return factGiftReceived;
	}

	/**
	 * Removes the fact gift received with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact gift received
	 * @return the fact gift received that was removed
	 * @throws com.idetronic.eis.NoSuchFactGiftReceivedException if a fact gift received with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactGiftReceived remove(long factId)
		throws NoSuchFactGiftReceivedException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact gift received with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact gift received
	 * @return the fact gift received that was removed
	 * @throws com.idetronic.eis.NoSuchFactGiftReceivedException if a fact gift received with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactGiftReceived remove(Serializable primaryKey)
		throws NoSuchFactGiftReceivedException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactGiftReceived factGiftReceived = (FactGiftReceived)session.get(FactGiftReceivedImpl.class,
					primaryKey);

			if (factGiftReceived == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactGiftReceivedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factGiftReceived);
		}
		catch (NoSuchFactGiftReceivedException nsee) {
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
	protected FactGiftReceived removeImpl(FactGiftReceived factGiftReceived)
		throws SystemException {
		factGiftReceived = toUnwrappedModel(factGiftReceived);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factGiftReceived)) {
				factGiftReceived = (FactGiftReceived)session.get(FactGiftReceivedImpl.class,
						factGiftReceived.getPrimaryKeyObj());
			}

			if (factGiftReceived != null) {
				session.delete(factGiftReceived);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factGiftReceived != null) {
			clearCache(factGiftReceived);
		}

		return factGiftReceived;
	}

	@Override
	public FactGiftReceived updateImpl(
		com.idetronic.eis.model.FactGiftReceived factGiftReceived)
		throws SystemException {
		factGiftReceived = toUnwrappedModel(factGiftReceived);

		boolean isNew = factGiftReceived.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factGiftReceived.isNew()) {
				session.save(factGiftReceived);

				factGiftReceived.setNew(false);
			}
			else {
				session.merge(factGiftReceived);
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

		EntityCacheUtil.putResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
			FactGiftReceivedImpl.class, factGiftReceived.getPrimaryKey(),
			factGiftReceived);

		return factGiftReceived;
	}

	protected FactGiftReceived toUnwrappedModel(
		FactGiftReceived factGiftReceived) {
		if (factGiftReceived instanceof FactGiftReceivedImpl) {
			return factGiftReceived;
		}

		FactGiftReceivedImpl factGiftReceivedImpl = new FactGiftReceivedImpl();

		factGiftReceivedImpl.setNew(factGiftReceived.isNew());
		factGiftReceivedImpl.setPrimaryKey(factGiftReceived.getPrimaryKey());

		factGiftReceivedImpl.setFactId(factGiftReceived.getFactId());
		factGiftReceivedImpl.setLibraryId(factGiftReceived.getLibraryId());
		factGiftReceivedImpl.setPeriod(factGiftReceived.getPeriod());
		factGiftReceivedImpl.setItemId(factGiftReceived.getItemId());
		factGiftReceivedImpl.setTitleTotal(factGiftReceived.getTitleTotal());
		factGiftReceivedImpl.setVolumeTotal(factGiftReceived.getVolumeTotal());
		factGiftReceivedImpl.setCompanyId(factGiftReceived.getCompanyId());
		factGiftReceivedImpl.setGroupId(factGiftReceived.getGroupId());
		factGiftReceivedImpl.setUserId(factGiftReceived.getUserId());
		factGiftReceivedImpl.setUserName(factGiftReceived.getUserName());
		factGiftReceivedImpl.setCreateDate(factGiftReceived.getCreateDate());

		return factGiftReceivedImpl;
	}

	/**
	 * Returns the fact gift received with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact gift received
	 * @return the fact gift received
	 * @throws com.idetronic.eis.NoSuchFactGiftReceivedException if a fact gift received with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactGiftReceived findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactGiftReceivedException, SystemException {
		FactGiftReceived factGiftReceived = fetchByPrimaryKey(primaryKey);

		if (factGiftReceived == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactGiftReceivedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factGiftReceived;
	}

	/**
	 * Returns the fact gift received with the primary key or throws a {@link com.idetronic.eis.NoSuchFactGiftReceivedException} if it could not be found.
	 *
	 * @param factId the primary key of the fact gift received
	 * @return the fact gift received
	 * @throws com.idetronic.eis.NoSuchFactGiftReceivedException if a fact gift received with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactGiftReceived findByPrimaryKey(long factId)
		throws NoSuchFactGiftReceivedException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact gift received with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact gift received
	 * @return the fact gift received, or <code>null</code> if a fact gift received with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactGiftReceived fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactGiftReceived factGiftReceived = (FactGiftReceived)EntityCacheUtil.getResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
				FactGiftReceivedImpl.class, primaryKey);

		if (factGiftReceived == _nullFactGiftReceived) {
			return null;
		}

		if (factGiftReceived == null) {
			Session session = null;

			try {
				session = openSession();

				factGiftReceived = (FactGiftReceived)session.get(FactGiftReceivedImpl.class,
						primaryKey);

				if (factGiftReceived != null) {
					cacheResult(factGiftReceived);
				}
				else {
					EntityCacheUtil.putResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
						FactGiftReceivedImpl.class, primaryKey,
						_nullFactGiftReceived);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactGiftReceivedModelImpl.ENTITY_CACHE_ENABLED,
					FactGiftReceivedImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factGiftReceived;
	}

	/**
	 * Returns the fact gift received with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact gift received
	 * @return the fact gift received, or <code>null</code> if a fact gift received with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactGiftReceived fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact gift receiveds.
	 *
	 * @return the fact gift receiveds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactGiftReceived> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact gift receiveds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactGiftReceivedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact gift receiveds
	 * @param end the upper bound of the range of fact gift receiveds (not inclusive)
	 * @return the range of fact gift receiveds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactGiftReceived> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact gift receiveds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactGiftReceivedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact gift receiveds
	 * @param end the upper bound of the range of fact gift receiveds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact gift receiveds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactGiftReceived> findAll(int start, int end,
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

		List<FactGiftReceived> list = (List<FactGiftReceived>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTGIFTRECEIVED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTGIFTRECEIVED;

				if (pagination) {
					sql = sql.concat(FactGiftReceivedModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactGiftReceived>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactGiftReceived>(list);
				}
				else {
					list = (List<FactGiftReceived>)QueryUtil.list(q,
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
	 * Removes all the fact gift receiveds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactGiftReceived factGiftReceived : findAll()) {
			remove(factGiftReceived);
		}
	}

	/**
	 * Returns the number of fact gift receiveds.
	 *
	 * @return the number of fact gift receiveds
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

				Query q = session.createQuery(_SQL_COUNT_FACTGIFTRECEIVED);

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
	 * Initializes the fact gift received persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactGiftReceived")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactGiftReceived>> listenersList = new ArrayList<ModelListener<FactGiftReceived>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactGiftReceived>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactGiftReceivedImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTGIFTRECEIVED = "SELECT factGiftReceived FROM FactGiftReceived factGiftReceived";
	private static final String _SQL_COUNT_FACTGIFTRECEIVED = "SELECT COUNT(factGiftReceived) FROM FactGiftReceived factGiftReceived";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factGiftReceived.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactGiftReceived exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactGiftReceivedPersistenceImpl.class);
	private static FactGiftReceived _nullFactGiftReceived = new FactGiftReceivedImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactGiftReceived> toCacheModel() {
				return _nullFactGiftReceivedCacheModel;
			}
		};

	private static CacheModel<FactGiftReceived> _nullFactGiftReceivedCacheModel = new CacheModel<FactGiftReceived>() {
			@Override
			public FactGiftReceived toEntityModel() {
				return _nullFactGiftReceived;
			}
		};
}
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

import com.idetronic.eis.NoSuchFactReleaseCatalogingException;
import com.idetronic.eis.model.FactReleaseCataloging;
import com.idetronic.eis.model.impl.FactReleaseCatalogingImpl;
import com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl;

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
 * The persistence implementation for the fact release cataloging service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactReleaseCatalogingPersistence
 * @see FactReleaseCatalogingUtil
 * @generated
 */
public class FactReleaseCatalogingPersistenceImpl extends BasePersistenceImpl<FactReleaseCataloging>
	implements FactReleaseCatalogingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactReleaseCatalogingUtil} to access the fact release cataloging persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactReleaseCatalogingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
			FactReleaseCatalogingModelImpl.FINDER_CACHE_ENABLED,
			FactReleaseCatalogingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
			FactReleaseCatalogingModelImpl.FINDER_CACHE_ENABLED,
			FactReleaseCatalogingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
			FactReleaseCatalogingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactReleaseCatalogingPersistenceImpl() {
		setModelClass(FactReleaseCataloging.class);
	}

	/**
	 * Caches the fact release cataloging in the entity cache if it is enabled.
	 *
	 * @param factReleaseCataloging the fact release cataloging
	 */
	@Override
	public void cacheResult(FactReleaseCataloging factReleaseCataloging) {
		EntityCacheUtil.putResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
			FactReleaseCatalogingImpl.class,
			factReleaseCataloging.getPrimaryKey(), factReleaseCataloging);

		factReleaseCataloging.resetOriginalValues();
	}

	/**
	 * Caches the fact release catalogings in the entity cache if it is enabled.
	 *
	 * @param factReleaseCatalogings the fact release catalogings
	 */
	@Override
	public void cacheResult(List<FactReleaseCataloging> factReleaseCatalogings) {
		for (FactReleaseCataloging factReleaseCataloging : factReleaseCatalogings) {
			if (EntityCacheUtil.getResult(
						FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
						FactReleaseCatalogingImpl.class,
						factReleaseCataloging.getPrimaryKey()) == null) {
				cacheResult(factReleaseCataloging);
			}
			else {
				factReleaseCataloging.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact release catalogings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactReleaseCatalogingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactReleaseCatalogingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact release cataloging.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactReleaseCataloging factReleaseCataloging) {
		EntityCacheUtil.removeResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
			FactReleaseCatalogingImpl.class,
			factReleaseCataloging.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactReleaseCataloging> factReleaseCatalogings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactReleaseCataloging factReleaseCataloging : factReleaseCatalogings) {
			EntityCacheUtil.removeResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
				FactReleaseCatalogingImpl.class,
				factReleaseCataloging.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact release cataloging with the primary key. Does not add the fact release cataloging to the database.
	 *
	 * @param factId the primary key for the new fact release cataloging
	 * @return the new fact release cataloging
	 */
	@Override
	public FactReleaseCataloging create(long factId) {
		FactReleaseCataloging factReleaseCataloging = new FactReleaseCatalogingImpl();

		factReleaseCataloging.setNew(true);
		factReleaseCataloging.setPrimaryKey(factId);

		return factReleaseCataloging;
	}

	/**
	 * Removes the fact release cataloging with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact release cataloging
	 * @return the fact release cataloging that was removed
	 * @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactReleaseCataloging remove(long factId)
		throws NoSuchFactReleaseCatalogingException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact release cataloging with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact release cataloging
	 * @return the fact release cataloging that was removed
	 * @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactReleaseCataloging remove(Serializable primaryKey)
		throws NoSuchFactReleaseCatalogingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactReleaseCataloging factReleaseCataloging = (FactReleaseCataloging)session.get(FactReleaseCatalogingImpl.class,
					primaryKey);

			if (factReleaseCataloging == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactReleaseCatalogingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factReleaseCataloging);
		}
		catch (NoSuchFactReleaseCatalogingException nsee) {
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
	protected FactReleaseCataloging removeImpl(
		FactReleaseCataloging factReleaseCataloging) throws SystemException {
		factReleaseCataloging = toUnwrappedModel(factReleaseCataloging);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factReleaseCataloging)) {
				factReleaseCataloging = (FactReleaseCataloging)session.get(FactReleaseCatalogingImpl.class,
						factReleaseCataloging.getPrimaryKeyObj());
			}

			if (factReleaseCataloging != null) {
				session.delete(factReleaseCataloging);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factReleaseCataloging != null) {
			clearCache(factReleaseCataloging);
		}

		return factReleaseCataloging;
	}

	@Override
	public FactReleaseCataloging updateImpl(
		com.idetronic.eis.model.FactReleaseCataloging factReleaseCataloging)
		throws SystemException {
		factReleaseCataloging = toUnwrappedModel(factReleaseCataloging);

		boolean isNew = factReleaseCataloging.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factReleaseCataloging.isNew()) {
				session.save(factReleaseCataloging);

				factReleaseCataloging.setNew(false);
			}
			else {
				session.merge(factReleaseCataloging);
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

		EntityCacheUtil.putResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
			FactReleaseCatalogingImpl.class,
			factReleaseCataloging.getPrimaryKey(), factReleaseCataloging);

		return factReleaseCataloging;
	}

	protected FactReleaseCataloging toUnwrappedModel(
		FactReleaseCataloging factReleaseCataloging) {
		if (factReleaseCataloging instanceof FactReleaseCatalogingImpl) {
			return factReleaseCataloging;
		}

		FactReleaseCatalogingImpl factReleaseCatalogingImpl = new FactReleaseCatalogingImpl();

		factReleaseCatalogingImpl.setNew(factReleaseCataloging.isNew());
		factReleaseCatalogingImpl.setPrimaryKey(factReleaseCataloging.getPrimaryKey());

		factReleaseCatalogingImpl.setFactId(factReleaseCataloging.getFactId());
		factReleaseCatalogingImpl.setLibraryId(factReleaseCataloging.getLibraryId());
		factReleaseCatalogingImpl.setPeriod(factReleaseCataloging.getPeriod());
		factReleaseCatalogingImpl.setItemId(factReleaseCataloging.getItemId());
		factReleaseCatalogingImpl.setTitleTotal(factReleaseCataloging.getTitleTotal());
		factReleaseCatalogingImpl.setVolumeTotal(factReleaseCataloging.getVolumeTotal());
		factReleaseCatalogingImpl.setCompanyId(factReleaseCataloging.getCompanyId());
		factReleaseCatalogingImpl.setGroupId(factReleaseCataloging.getGroupId());
		factReleaseCatalogingImpl.setUserId(factReleaseCataloging.getUserId());
		factReleaseCatalogingImpl.setUserName(factReleaseCataloging.getUserName());
		factReleaseCatalogingImpl.setCreateDate(factReleaseCataloging.getCreateDate());

		return factReleaseCatalogingImpl;
	}

	/**
	 * Returns the fact release cataloging with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact release cataloging
	 * @return the fact release cataloging
	 * @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactReleaseCataloging findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactReleaseCatalogingException, SystemException {
		FactReleaseCataloging factReleaseCataloging = fetchByPrimaryKey(primaryKey);

		if (factReleaseCataloging == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactReleaseCatalogingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factReleaseCataloging;
	}

	/**
	 * Returns the fact release cataloging with the primary key or throws a {@link com.idetronic.eis.NoSuchFactReleaseCatalogingException} if it could not be found.
	 *
	 * @param factId the primary key of the fact release cataloging
	 * @return the fact release cataloging
	 * @throws com.idetronic.eis.NoSuchFactReleaseCatalogingException if a fact release cataloging with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactReleaseCataloging findByPrimaryKey(long factId)
		throws NoSuchFactReleaseCatalogingException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact release cataloging with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact release cataloging
	 * @return the fact release cataloging, or <code>null</code> if a fact release cataloging with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactReleaseCataloging fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactReleaseCataloging factReleaseCataloging = (FactReleaseCataloging)EntityCacheUtil.getResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
				FactReleaseCatalogingImpl.class, primaryKey);

		if (factReleaseCataloging == _nullFactReleaseCataloging) {
			return null;
		}

		if (factReleaseCataloging == null) {
			Session session = null;

			try {
				session = openSession();

				factReleaseCataloging = (FactReleaseCataloging)session.get(FactReleaseCatalogingImpl.class,
						primaryKey);

				if (factReleaseCataloging != null) {
					cacheResult(factReleaseCataloging);
				}
				else {
					EntityCacheUtil.putResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
						FactReleaseCatalogingImpl.class, primaryKey,
						_nullFactReleaseCataloging);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactReleaseCatalogingModelImpl.ENTITY_CACHE_ENABLED,
					FactReleaseCatalogingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factReleaseCataloging;
	}

	/**
	 * Returns the fact release cataloging with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact release cataloging
	 * @return the fact release cataloging, or <code>null</code> if a fact release cataloging with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactReleaseCataloging fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact release catalogings.
	 *
	 * @return the fact release catalogings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactReleaseCataloging> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact release catalogings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact release catalogings
	 * @param end the upper bound of the range of fact release catalogings (not inclusive)
	 * @return the range of fact release catalogings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactReleaseCataloging> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact release catalogings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactReleaseCatalogingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact release catalogings
	 * @param end the upper bound of the range of fact release catalogings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact release catalogings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactReleaseCataloging> findAll(int start, int end,
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

		List<FactReleaseCataloging> list = (List<FactReleaseCataloging>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTRELEASECATALOGING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTRELEASECATALOGING;

				if (pagination) {
					sql = sql.concat(FactReleaseCatalogingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactReleaseCataloging>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactReleaseCataloging>(list);
				}
				else {
					list = (List<FactReleaseCataloging>)QueryUtil.list(q,
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
	 * Removes all the fact release catalogings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactReleaseCataloging factReleaseCataloging : findAll()) {
			remove(factReleaseCataloging);
		}
	}

	/**
	 * Returns the number of fact release catalogings.
	 *
	 * @return the number of fact release catalogings
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

				Query q = session.createQuery(_SQL_COUNT_FACTRELEASECATALOGING);

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
	 * Initializes the fact release cataloging persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactReleaseCataloging")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactReleaseCataloging>> listenersList = new ArrayList<ModelListener<FactReleaseCataloging>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactReleaseCataloging>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactReleaseCatalogingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTRELEASECATALOGING = "SELECT factReleaseCataloging FROM FactReleaseCataloging factReleaseCataloging";
	private static final String _SQL_COUNT_FACTRELEASECATALOGING = "SELECT COUNT(factReleaseCataloging) FROM FactReleaseCataloging factReleaseCataloging";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factReleaseCataloging.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactReleaseCataloging exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactReleaseCatalogingPersistenceImpl.class);
	private static FactReleaseCataloging _nullFactReleaseCataloging = new FactReleaseCatalogingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactReleaseCataloging> toCacheModel() {
				return _nullFactReleaseCatalogingCacheModel;
			}
		};

	private static CacheModel<FactReleaseCataloging> _nullFactReleaseCatalogingCacheModel =
		new CacheModel<FactReleaseCataloging>() {
			@Override
			public FactReleaseCataloging toEntityModel() {
				return _nullFactReleaseCataloging;
			}
		};
}
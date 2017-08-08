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

import com.idetronic.eis.NoSuchFactItManagementException;
import com.idetronic.eis.model.FactItManagement;
import com.idetronic.eis.model.impl.FactItManagementImpl;
import com.idetronic.eis.model.impl.FactItManagementModelImpl;

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
 * The persistence implementation for the fact it management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactItManagementPersistence
 * @see FactItManagementUtil
 * @generated
 */
public class FactItManagementPersistenceImpl extends BasePersistenceImpl<FactItManagement>
	implements FactItManagementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactItManagementUtil} to access the fact it management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactItManagementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
			FactItManagementModelImpl.FINDER_CACHE_ENABLED,
			FactItManagementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
			FactItManagementModelImpl.FINDER_CACHE_ENABLED,
			FactItManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
			FactItManagementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactItManagementPersistenceImpl() {
		setModelClass(FactItManagement.class);
	}

	/**
	 * Caches the fact it management in the entity cache if it is enabled.
	 *
	 * @param factItManagement the fact it management
	 */
	@Override
	public void cacheResult(FactItManagement factItManagement) {
		EntityCacheUtil.putResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
			FactItManagementImpl.class, factItManagement.getPrimaryKey(),
			factItManagement);

		factItManagement.resetOriginalValues();
	}

	/**
	 * Caches the fact it managements in the entity cache if it is enabled.
	 *
	 * @param factItManagements the fact it managements
	 */
	@Override
	public void cacheResult(List<FactItManagement> factItManagements) {
		for (FactItManagement factItManagement : factItManagements) {
			if (EntityCacheUtil.getResult(
						FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
						FactItManagementImpl.class,
						factItManagement.getPrimaryKey()) == null) {
				cacheResult(factItManagement);
			}
			else {
				factItManagement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact it managements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactItManagementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactItManagementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact it management.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactItManagement factItManagement) {
		EntityCacheUtil.removeResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
			FactItManagementImpl.class, factItManagement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactItManagement> factItManagements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactItManagement factItManagement : factItManagements) {
			EntityCacheUtil.removeResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
				FactItManagementImpl.class, factItManagement.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact it management with the primary key. Does not add the fact it management to the database.
	 *
	 * @param factId the primary key for the new fact it management
	 * @return the new fact it management
	 */
	@Override
	public FactItManagement create(long factId) {
		FactItManagement factItManagement = new FactItManagementImpl();

		factItManagement.setNew(true);
		factItManagement.setPrimaryKey(factId);

		return factItManagement;
	}

	/**
	 * Removes the fact it management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact it management
	 * @return the fact it management that was removed
	 * @throws com.idetronic.eis.NoSuchFactItManagementException if a fact it management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactItManagement remove(long factId)
		throws NoSuchFactItManagementException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact it management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact it management
	 * @return the fact it management that was removed
	 * @throws com.idetronic.eis.NoSuchFactItManagementException if a fact it management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactItManagement remove(Serializable primaryKey)
		throws NoSuchFactItManagementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactItManagement factItManagement = (FactItManagement)session.get(FactItManagementImpl.class,
					primaryKey);

			if (factItManagement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactItManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factItManagement);
		}
		catch (NoSuchFactItManagementException nsee) {
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
	protected FactItManagement removeImpl(FactItManagement factItManagement)
		throws SystemException {
		factItManagement = toUnwrappedModel(factItManagement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factItManagement)) {
				factItManagement = (FactItManagement)session.get(FactItManagementImpl.class,
						factItManagement.getPrimaryKeyObj());
			}

			if (factItManagement != null) {
				session.delete(factItManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factItManagement != null) {
			clearCache(factItManagement);
		}

		return factItManagement;
	}

	@Override
	public FactItManagement updateImpl(
		com.idetronic.eis.model.FactItManagement factItManagement)
		throws SystemException {
		factItManagement = toUnwrappedModel(factItManagement);

		boolean isNew = factItManagement.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factItManagement.isNew()) {
				session.save(factItManagement);

				factItManagement.setNew(false);
			}
			else {
				session.merge(factItManagement);
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

		EntityCacheUtil.putResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
			FactItManagementImpl.class, factItManagement.getPrimaryKey(),
			factItManagement);

		return factItManagement;
	}

	protected FactItManagement toUnwrappedModel(
		FactItManagement factItManagement) {
		if (factItManagement instanceof FactItManagementImpl) {
			return factItManagement;
		}

		FactItManagementImpl factItManagementImpl = new FactItManagementImpl();

		factItManagementImpl.setNew(factItManagement.isNew());
		factItManagementImpl.setPrimaryKey(factItManagement.getPrimaryKey());

		factItManagementImpl.setFactId(factItManagement.getFactId());
		factItManagementImpl.setLibraryId(factItManagement.getLibraryId());
		factItManagementImpl.setPeriod(factItManagement.getPeriod());
		factItManagementImpl.setItemId(factItManagement.getItemId());
		factItManagementImpl.setItemTotal(factItManagement.getItemTotal());
		factItManagementImpl.setCompanyId(factItManagement.getCompanyId());
		factItManagementImpl.setGroupId(factItManagement.getGroupId());
		factItManagementImpl.setUserId(factItManagement.getUserId());
		factItManagementImpl.setUserName(factItManagement.getUserName());
		factItManagementImpl.setCreateDate(factItManagement.getCreateDate());

		return factItManagementImpl;
	}

	/**
	 * Returns the fact it management with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact it management
	 * @return the fact it management
	 * @throws com.idetronic.eis.NoSuchFactItManagementException if a fact it management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactItManagement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactItManagementException, SystemException {
		FactItManagement factItManagement = fetchByPrimaryKey(primaryKey);

		if (factItManagement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactItManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factItManagement;
	}

	/**
	 * Returns the fact it management with the primary key or throws a {@link com.idetronic.eis.NoSuchFactItManagementException} if it could not be found.
	 *
	 * @param factId the primary key of the fact it management
	 * @return the fact it management
	 * @throws com.idetronic.eis.NoSuchFactItManagementException if a fact it management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactItManagement findByPrimaryKey(long factId)
		throws NoSuchFactItManagementException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact it management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact it management
	 * @return the fact it management, or <code>null</code> if a fact it management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactItManagement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactItManagement factItManagement = (FactItManagement)EntityCacheUtil.getResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
				FactItManagementImpl.class, primaryKey);

		if (factItManagement == _nullFactItManagement) {
			return null;
		}

		if (factItManagement == null) {
			Session session = null;

			try {
				session = openSession();

				factItManagement = (FactItManagement)session.get(FactItManagementImpl.class,
						primaryKey);

				if (factItManagement != null) {
					cacheResult(factItManagement);
				}
				else {
					EntityCacheUtil.putResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
						FactItManagementImpl.class, primaryKey,
						_nullFactItManagement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactItManagementModelImpl.ENTITY_CACHE_ENABLED,
					FactItManagementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factItManagement;
	}

	/**
	 * Returns the fact it management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact it management
	 * @return the fact it management, or <code>null</code> if a fact it management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactItManagement fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact it managements.
	 *
	 * @return the fact it managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactItManagement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact it managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact it managements
	 * @param end the upper bound of the range of fact it managements (not inclusive)
	 * @return the range of fact it managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactItManagement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact it managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactItManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact it managements
	 * @param end the upper bound of the range of fact it managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact it managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactItManagement> findAll(int start, int end,
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

		List<FactItManagement> list = (List<FactItManagement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTITMANAGEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTITMANAGEMENT;

				if (pagination) {
					sql = sql.concat(FactItManagementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactItManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactItManagement>(list);
				}
				else {
					list = (List<FactItManagement>)QueryUtil.list(q,
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
	 * Removes all the fact it managements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactItManagement factItManagement : findAll()) {
			remove(factItManagement);
		}
	}

	/**
	 * Returns the number of fact it managements.
	 *
	 * @return the number of fact it managements
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

				Query q = session.createQuery(_SQL_COUNT_FACTITMANAGEMENT);

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
	 * Initializes the fact it management persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactItManagement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactItManagement>> listenersList = new ArrayList<ModelListener<FactItManagement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactItManagement>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactItManagementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTITMANAGEMENT = "SELECT factItManagement FROM FactItManagement factItManagement";
	private static final String _SQL_COUNT_FACTITMANAGEMENT = "SELECT COUNT(factItManagement) FROM FactItManagement factItManagement";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factItManagement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactItManagement exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactItManagementPersistenceImpl.class);
	private static FactItManagement _nullFactItManagement = new FactItManagementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactItManagement> toCacheModel() {
				return _nullFactItManagementCacheModel;
			}
		};

	private static CacheModel<FactItManagement> _nullFactItManagementCacheModel = new CacheModel<FactItManagement>() {
			@Override
			public FactItManagement toEntityModel() {
				return _nullFactItManagement;
			}
		};
}
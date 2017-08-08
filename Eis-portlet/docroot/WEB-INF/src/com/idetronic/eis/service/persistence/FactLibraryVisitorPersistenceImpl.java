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

import com.idetronic.eis.NoSuchFactLibraryVisitorException;
import com.idetronic.eis.model.FactLibraryVisitor;
import com.idetronic.eis.model.impl.FactLibraryVisitorImpl;
import com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl;

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
 * The persistence implementation for the fact library visitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactLibraryVisitorPersistence
 * @see FactLibraryVisitorUtil
 * @generated
 */
public class FactLibraryVisitorPersistenceImpl extends BasePersistenceImpl<FactLibraryVisitor>
	implements FactLibraryVisitorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactLibraryVisitorUtil} to access the fact library visitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactLibraryVisitorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactLibraryVisitorModelImpl.FINDER_CACHE_ENABLED,
			FactLibraryVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactLibraryVisitorModelImpl.FINDER_CACHE_ENABLED,
			FactLibraryVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactLibraryVisitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactLibraryVisitorPersistenceImpl() {
		setModelClass(FactLibraryVisitor.class);
	}

	/**
	 * Caches the fact library visitor in the entity cache if it is enabled.
	 *
	 * @param factLibraryVisitor the fact library visitor
	 */
	@Override
	public void cacheResult(FactLibraryVisitor factLibraryVisitor) {
		EntityCacheUtil.putResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactLibraryVisitorImpl.class, factLibraryVisitor.getPrimaryKey(),
			factLibraryVisitor);

		factLibraryVisitor.resetOriginalValues();
	}

	/**
	 * Caches the fact library visitors in the entity cache if it is enabled.
	 *
	 * @param factLibraryVisitors the fact library visitors
	 */
	@Override
	public void cacheResult(List<FactLibraryVisitor> factLibraryVisitors) {
		for (FactLibraryVisitor factLibraryVisitor : factLibraryVisitors) {
			if (EntityCacheUtil.getResult(
						FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
						FactLibraryVisitorImpl.class,
						factLibraryVisitor.getPrimaryKey()) == null) {
				cacheResult(factLibraryVisitor);
			}
			else {
				factLibraryVisitor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact library visitors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactLibraryVisitorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactLibraryVisitorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact library visitor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactLibraryVisitor factLibraryVisitor) {
		EntityCacheUtil.removeResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactLibraryVisitorImpl.class, factLibraryVisitor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactLibraryVisitor> factLibraryVisitors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactLibraryVisitor factLibraryVisitor : factLibraryVisitors) {
			EntityCacheUtil.removeResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
				FactLibraryVisitorImpl.class, factLibraryVisitor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact library visitor with the primary key. Does not add the fact library visitor to the database.
	 *
	 * @param factId the primary key for the new fact library visitor
	 * @return the new fact library visitor
	 */
	@Override
	public FactLibraryVisitor create(long factId) {
		FactLibraryVisitor factLibraryVisitor = new FactLibraryVisitorImpl();

		factLibraryVisitor.setNew(true);
		factLibraryVisitor.setPrimaryKey(factId);

		return factLibraryVisitor;
	}

	/**
	 * Removes the fact library visitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact library visitor
	 * @return the fact library visitor that was removed
	 * @throws com.idetronic.eis.NoSuchFactLibraryVisitorException if a fact library visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactLibraryVisitor remove(long factId)
		throws NoSuchFactLibraryVisitorException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact library visitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact library visitor
	 * @return the fact library visitor that was removed
	 * @throws com.idetronic.eis.NoSuchFactLibraryVisitorException if a fact library visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactLibraryVisitor remove(Serializable primaryKey)
		throws NoSuchFactLibraryVisitorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactLibraryVisitor factLibraryVisitor = (FactLibraryVisitor)session.get(FactLibraryVisitorImpl.class,
					primaryKey);

			if (factLibraryVisitor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactLibraryVisitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factLibraryVisitor);
		}
		catch (NoSuchFactLibraryVisitorException nsee) {
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
	protected FactLibraryVisitor removeImpl(
		FactLibraryVisitor factLibraryVisitor) throws SystemException {
		factLibraryVisitor = toUnwrappedModel(factLibraryVisitor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factLibraryVisitor)) {
				factLibraryVisitor = (FactLibraryVisitor)session.get(FactLibraryVisitorImpl.class,
						factLibraryVisitor.getPrimaryKeyObj());
			}

			if (factLibraryVisitor != null) {
				session.delete(factLibraryVisitor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factLibraryVisitor != null) {
			clearCache(factLibraryVisitor);
		}

		return factLibraryVisitor;
	}

	@Override
	public FactLibraryVisitor updateImpl(
		com.idetronic.eis.model.FactLibraryVisitor factLibraryVisitor)
		throws SystemException {
		factLibraryVisitor = toUnwrappedModel(factLibraryVisitor);

		boolean isNew = factLibraryVisitor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factLibraryVisitor.isNew()) {
				session.save(factLibraryVisitor);

				factLibraryVisitor.setNew(false);
			}
			else {
				session.merge(factLibraryVisitor);
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

		EntityCacheUtil.putResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactLibraryVisitorImpl.class, factLibraryVisitor.getPrimaryKey(),
			factLibraryVisitor);

		return factLibraryVisitor;
	}

	protected FactLibraryVisitor toUnwrappedModel(
		FactLibraryVisitor factLibraryVisitor) {
		if (factLibraryVisitor instanceof FactLibraryVisitorImpl) {
			return factLibraryVisitor;
		}

		FactLibraryVisitorImpl factLibraryVisitorImpl = new FactLibraryVisitorImpl();

		factLibraryVisitorImpl.setNew(factLibraryVisitor.isNew());
		factLibraryVisitorImpl.setPrimaryKey(factLibraryVisitor.getPrimaryKey());

		factLibraryVisitorImpl.setFactId(factLibraryVisitor.getFactId());
		factLibraryVisitorImpl.setLibraryId(factLibraryVisitor.getLibraryId());
		factLibraryVisitorImpl.setPeriod(factLibraryVisitor.getPeriod());
		factLibraryVisitorImpl.setVisitorCategoryId(factLibraryVisitor.getVisitorCategoryId());
		factLibraryVisitorImpl.setSessionTotal(factLibraryVisitor.getSessionTotal());
		factLibraryVisitorImpl.setVisitorTotal(factLibraryVisitor.getVisitorTotal());
		factLibraryVisitorImpl.setCompanyId(factLibraryVisitor.getCompanyId());
		factLibraryVisitorImpl.setGroupId(factLibraryVisitor.getGroupId());
		factLibraryVisitorImpl.setUserId(factLibraryVisitor.getUserId());
		factLibraryVisitorImpl.setUserName(factLibraryVisitor.getUserName());
		factLibraryVisitorImpl.setCreateDate(factLibraryVisitor.getCreateDate());

		return factLibraryVisitorImpl;
	}

	/**
	 * Returns the fact library visitor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact library visitor
	 * @return the fact library visitor
	 * @throws com.idetronic.eis.NoSuchFactLibraryVisitorException if a fact library visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactLibraryVisitor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactLibraryVisitorException, SystemException {
		FactLibraryVisitor factLibraryVisitor = fetchByPrimaryKey(primaryKey);

		if (factLibraryVisitor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactLibraryVisitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factLibraryVisitor;
	}

	/**
	 * Returns the fact library visitor with the primary key or throws a {@link com.idetronic.eis.NoSuchFactLibraryVisitorException} if it could not be found.
	 *
	 * @param factId the primary key of the fact library visitor
	 * @return the fact library visitor
	 * @throws com.idetronic.eis.NoSuchFactLibraryVisitorException if a fact library visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactLibraryVisitor findByPrimaryKey(long factId)
		throws NoSuchFactLibraryVisitorException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact library visitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact library visitor
	 * @return the fact library visitor, or <code>null</code> if a fact library visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactLibraryVisitor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactLibraryVisitor factLibraryVisitor = (FactLibraryVisitor)EntityCacheUtil.getResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
				FactLibraryVisitorImpl.class, primaryKey);

		if (factLibraryVisitor == _nullFactLibraryVisitor) {
			return null;
		}

		if (factLibraryVisitor == null) {
			Session session = null;

			try {
				session = openSession();

				factLibraryVisitor = (FactLibraryVisitor)session.get(FactLibraryVisitorImpl.class,
						primaryKey);

				if (factLibraryVisitor != null) {
					cacheResult(factLibraryVisitor);
				}
				else {
					EntityCacheUtil.putResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
						FactLibraryVisitorImpl.class, primaryKey,
						_nullFactLibraryVisitor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactLibraryVisitorModelImpl.ENTITY_CACHE_ENABLED,
					FactLibraryVisitorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factLibraryVisitor;
	}

	/**
	 * Returns the fact library visitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact library visitor
	 * @return the fact library visitor, or <code>null</code> if a fact library visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactLibraryVisitor fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact library visitors.
	 *
	 * @return the fact library visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactLibraryVisitor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact library visitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact library visitors
	 * @param end the upper bound of the range of fact library visitors (not inclusive)
	 * @return the range of fact library visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactLibraryVisitor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact library visitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact library visitors
	 * @param end the upper bound of the range of fact library visitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact library visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactLibraryVisitor> findAll(int start, int end,
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

		List<FactLibraryVisitor> list = (List<FactLibraryVisitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTLIBRARYVISITOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTLIBRARYVISITOR;

				if (pagination) {
					sql = sql.concat(FactLibraryVisitorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactLibraryVisitor>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactLibraryVisitor>(list);
				}
				else {
					list = (List<FactLibraryVisitor>)QueryUtil.list(q,
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
	 * Removes all the fact library visitors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactLibraryVisitor factLibraryVisitor : findAll()) {
			remove(factLibraryVisitor);
		}
	}

	/**
	 * Returns the number of fact library visitors.
	 *
	 * @return the number of fact library visitors
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

				Query q = session.createQuery(_SQL_COUNT_FACTLIBRARYVISITOR);

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
	 * Initializes the fact library visitor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactLibraryVisitor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactLibraryVisitor>> listenersList = new ArrayList<ModelListener<FactLibraryVisitor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactLibraryVisitor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactLibraryVisitorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTLIBRARYVISITOR = "SELECT factLibraryVisitor FROM FactLibraryVisitor factLibraryVisitor";
	private static final String _SQL_COUNT_FACTLIBRARYVISITOR = "SELECT COUNT(factLibraryVisitor) FROM FactLibraryVisitor factLibraryVisitor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factLibraryVisitor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactLibraryVisitor exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactLibraryVisitorPersistenceImpl.class);
	private static FactLibraryVisitor _nullFactLibraryVisitor = new FactLibraryVisitorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactLibraryVisitor> toCacheModel() {
				return _nullFactLibraryVisitorCacheModel;
			}
		};

	private static CacheModel<FactLibraryVisitor> _nullFactLibraryVisitorCacheModel =
		new CacheModel<FactLibraryVisitor>() {
			@Override
			public FactLibraryVisitor toEntityModel() {
				return _nullFactLibraryVisitor;
			}
		};
}
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

import com.idetronic.eis.NoSuchFactDigitalCollectionException;
import com.idetronic.eis.model.FactDigitalCollection;
import com.idetronic.eis.model.impl.FactDigitalCollectionImpl;
import com.idetronic.eis.model.impl.FactDigitalCollectionModelImpl;

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
 * The persistence implementation for the fact digital collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDigitalCollectionPersistence
 * @see FactDigitalCollectionUtil
 * @generated
 */
public class FactDigitalCollectionPersistenceImpl extends BasePersistenceImpl<FactDigitalCollection>
	implements FactDigitalCollectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactDigitalCollectionUtil} to access the fact digital collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactDigitalCollectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
			FactDigitalCollectionModelImpl.FINDER_CACHE_ENABLED,
			FactDigitalCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
			FactDigitalCollectionModelImpl.FINDER_CACHE_ENABLED,
			FactDigitalCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
			FactDigitalCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactDigitalCollectionPersistenceImpl() {
		setModelClass(FactDigitalCollection.class);
	}

	/**
	 * Caches the fact digital collection in the entity cache if it is enabled.
	 *
	 * @param factDigitalCollection the fact digital collection
	 */
	@Override
	public void cacheResult(FactDigitalCollection factDigitalCollection) {
		EntityCacheUtil.putResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
			FactDigitalCollectionImpl.class,
			factDigitalCollection.getPrimaryKey(), factDigitalCollection);

		factDigitalCollection.resetOriginalValues();
	}

	/**
	 * Caches the fact digital collections in the entity cache if it is enabled.
	 *
	 * @param factDigitalCollections the fact digital collections
	 */
	@Override
	public void cacheResult(List<FactDigitalCollection> factDigitalCollections) {
		for (FactDigitalCollection factDigitalCollection : factDigitalCollections) {
			if (EntityCacheUtil.getResult(
						FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
						FactDigitalCollectionImpl.class,
						factDigitalCollection.getPrimaryKey()) == null) {
				cacheResult(factDigitalCollection);
			}
			else {
				factDigitalCollection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact digital collections.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactDigitalCollectionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactDigitalCollectionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact digital collection.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactDigitalCollection factDigitalCollection) {
		EntityCacheUtil.removeResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
			FactDigitalCollectionImpl.class,
			factDigitalCollection.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactDigitalCollection> factDigitalCollections) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactDigitalCollection factDigitalCollection : factDigitalCollections) {
			EntityCacheUtil.removeResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
				FactDigitalCollectionImpl.class,
				factDigitalCollection.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact digital collection with the primary key. Does not add the fact digital collection to the database.
	 *
	 * @param factId the primary key for the new fact digital collection
	 * @return the new fact digital collection
	 */
	@Override
	public FactDigitalCollection create(long factId) {
		FactDigitalCollection factDigitalCollection = new FactDigitalCollectionImpl();

		factDigitalCollection.setNew(true);
		factDigitalCollection.setPrimaryKey(factId);

		return factDigitalCollection;
	}

	/**
	 * Removes the fact digital collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact digital collection
	 * @return the fact digital collection that was removed
	 * @throws com.idetronic.eis.NoSuchFactDigitalCollectionException if a fact digital collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDigitalCollection remove(long factId)
		throws NoSuchFactDigitalCollectionException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact digital collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact digital collection
	 * @return the fact digital collection that was removed
	 * @throws com.idetronic.eis.NoSuchFactDigitalCollectionException if a fact digital collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDigitalCollection remove(Serializable primaryKey)
		throws NoSuchFactDigitalCollectionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactDigitalCollection factDigitalCollection = (FactDigitalCollection)session.get(FactDigitalCollectionImpl.class,
					primaryKey);

			if (factDigitalCollection == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactDigitalCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factDigitalCollection);
		}
		catch (NoSuchFactDigitalCollectionException nsee) {
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
	protected FactDigitalCollection removeImpl(
		FactDigitalCollection factDigitalCollection) throws SystemException {
		factDigitalCollection = toUnwrappedModel(factDigitalCollection);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factDigitalCollection)) {
				factDigitalCollection = (FactDigitalCollection)session.get(FactDigitalCollectionImpl.class,
						factDigitalCollection.getPrimaryKeyObj());
			}

			if (factDigitalCollection != null) {
				session.delete(factDigitalCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factDigitalCollection != null) {
			clearCache(factDigitalCollection);
		}

		return factDigitalCollection;
	}

	@Override
	public FactDigitalCollection updateImpl(
		com.idetronic.eis.model.FactDigitalCollection factDigitalCollection)
		throws SystemException {
		factDigitalCollection = toUnwrappedModel(factDigitalCollection);

		boolean isNew = factDigitalCollection.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factDigitalCollection.isNew()) {
				session.save(factDigitalCollection);

				factDigitalCollection.setNew(false);
			}
			else {
				session.merge(factDigitalCollection);
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

		EntityCacheUtil.putResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
			FactDigitalCollectionImpl.class,
			factDigitalCollection.getPrimaryKey(), factDigitalCollection);

		return factDigitalCollection;
	}

	protected FactDigitalCollection toUnwrappedModel(
		FactDigitalCollection factDigitalCollection) {
		if (factDigitalCollection instanceof FactDigitalCollectionImpl) {
			return factDigitalCollection;
		}

		FactDigitalCollectionImpl factDigitalCollectionImpl = new FactDigitalCollectionImpl();

		factDigitalCollectionImpl.setNew(factDigitalCollection.isNew());
		factDigitalCollectionImpl.setPrimaryKey(factDigitalCollection.getPrimaryKey());

		factDigitalCollectionImpl.setFactId(factDigitalCollection.getFactId());
		factDigitalCollectionImpl.setLibraryId(factDigitalCollection.getLibraryId());
		factDigitalCollectionImpl.setPeriod(factDigitalCollection.getPeriod());
		factDigitalCollectionImpl.setItemId(factDigitalCollection.getItemId());
		factDigitalCollectionImpl.setTitleTotal(factDigitalCollection.getTitleTotal());
		factDigitalCollectionImpl.setVolumeTotal(factDigitalCollection.getVolumeTotal());
		factDigitalCollectionImpl.setImageTotal(factDigitalCollection.getImageTotal());
		factDigitalCollectionImpl.setCompanyId(factDigitalCollection.getCompanyId());
		factDigitalCollectionImpl.setGroupId(factDigitalCollection.getGroupId());
		factDigitalCollectionImpl.setUserId(factDigitalCollection.getUserId());
		factDigitalCollectionImpl.setUserName(factDigitalCollection.getUserName());
		factDigitalCollectionImpl.setCreateDate(factDigitalCollection.getCreateDate());

		return factDigitalCollectionImpl;
	}

	/**
	 * Returns the fact digital collection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact digital collection
	 * @return the fact digital collection
	 * @throws com.idetronic.eis.NoSuchFactDigitalCollectionException if a fact digital collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDigitalCollection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactDigitalCollectionException, SystemException {
		FactDigitalCollection factDigitalCollection = fetchByPrimaryKey(primaryKey);

		if (factDigitalCollection == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactDigitalCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factDigitalCollection;
	}

	/**
	 * Returns the fact digital collection with the primary key or throws a {@link com.idetronic.eis.NoSuchFactDigitalCollectionException} if it could not be found.
	 *
	 * @param factId the primary key of the fact digital collection
	 * @return the fact digital collection
	 * @throws com.idetronic.eis.NoSuchFactDigitalCollectionException if a fact digital collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDigitalCollection findByPrimaryKey(long factId)
		throws NoSuchFactDigitalCollectionException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact digital collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact digital collection
	 * @return the fact digital collection, or <code>null</code> if a fact digital collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDigitalCollection fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactDigitalCollection factDigitalCollection = (FactDigitalCollection)EntityCacheUtil.getResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
				FactDigitalCollectionImpl.class, primaryKey);

		if (factDigitalCollection == _nullFactDigitalCollection) {
			return null;
		}

		if (factDigitalCollection == null) {
			Session session = null;

			try {
				session = openSession();

				factDigitalCollection = (FactDigitalCollection)session.get(FactDigitalCollectionImpl.class,
						primaryKey);

				if (factDigitalCollection != null) {
					cacheResult(factDigitalCollection);
				}
				else {
					EntityCacheUtil.putResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
						FactDigitalCollectionImpl.class, primaryKey,
						_nullFactDigitalCollection);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactDigitalCollectionModelImpl.ENTITY_CACHE_ENABLED,
					FactDigitalCollectionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factDigitalCollection;
	}

	/**
	 * Returns the fact digital collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact digital collection
	 * @return the fact digital collection, or <code>null</code> if a fact digital collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactDigitalCollection fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact digital collections.
	 *
	 * @return the fact digital collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactDigitalCollection> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact digital collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDigitalCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact digital collections
	 * @param end the upper bound of the range of fact digital collections (not inclusive)
	 * @return the range of fact digital collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactDigitalCollection> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact digital collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDigitalCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact digital collections
	 * @param end the upper bound of the range of fact digital collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact digital collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactDigitalCollection> findAll(int start, int end,
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

		List<FactDigitalCollection> list = (List<FactDigitalCollection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTDIGITALCOLLECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTDIGITALCOLLECTION;

				if (pagination) {
					sql = sql.concat(FactDigitalCollectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactDigitalCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactDigitalCollection>(list);
				}
				else {
					list = (List<FactDigitalCollection>)QueryUtil.list(q,
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
	 * Removes all the fact digital collections from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactDigitalCollection factDigitalCollection : findAll()) {
			remove(factDigitalCollection);
		}
	}

	/**
	 * Returns the number of fact digital collections.
	 *
	 * @return the number of fact digital collections
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

				Query q = session.createQuery(_SQL_COUNT_FACTDIGITALCOLLECTION);

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
	 * Initializes the fact digital collection persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactDigitalCollection")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactDigitalCollection>> listenersList = new ArrayList<ModelListener<FactDigitalCollection>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactDigitalCollection>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactDigitalCollectionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTDIGITALCOLLECTION = "SELECT factDigitalCollection FROM FactDigitalCollection factDigitalCollection";
	private static final String _SQL_COUNT_FACTDIGITALCOLLECTION = "SELECT COUNT(factDigitalCollection) FROM FactDigitalCollection factDigitalCollection";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factDigitalCollection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactDigitalCollection exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactDigitalCollectionPersistenceImpl.class);
	private static FactDigitalCollection _nullFactDigitalCollection = new FactDigitalCollectionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactDigitalCollection> toCacheModel() {
				return _nullFactDigitalCollectionCacheModel;
			}
		};

	private static CacheModel<FactDigitalCollection> _nullFactDigitalCollectionCacheModel =
		new CacheModel<FactDigitalCollection>() {
			@Override
			public FactDigitalCollection toEntityModel() {
				return _nullFactDigitalCollection;
			}
		};
}
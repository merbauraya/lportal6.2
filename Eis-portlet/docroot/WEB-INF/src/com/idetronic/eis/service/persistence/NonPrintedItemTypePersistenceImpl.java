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

import com.idetronic.eis.NoSuchNonPrintedItemTypeException;
import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.impl.NonPrintedItemTypeImpl;
import com.idetronic.eis.model.impl.NonPrintedItemTypeModelImpl;

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
 * The persistence implementation for the non printed item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see NonPrintedItemTypePersistence
 * @see NonPrintedItemTypeUtil
 * @generated
 */
public class NonPrintedItemTypePersistenceImpl extends BasePersistenceImpl<NonPrintedItemType>
	implements NonPrintedItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NonPrintedItemTypeUtil} to access the non printed item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NonPrintedItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			NonPrintedItemTypeModelImpl.FINDER_CACHE_ENABLED,
			NonPrintedItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			NonPrintedItemTypeModelImpl.FINDER_CACHE_ENABLED,
			NonPrintedItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			NonPrintedItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NonPrintedItemTypePersistenceImpl() {
		setModelClass(NonPrintedItemType.class);
	}

	/**
	 * Caches the non printed item type in the entity cache if it is enabled.
	 *
	 * @param nonPrintedItemType the non printed item type
	 */
	@Override
	public void cacheResult(NonPrintedItemType nonPrintedItemType) {
		EntityCacheUtil.putResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			NonPrintedItemTypeImpl.class, nonPrintedItemType.getPrimaryKey(),
			nonPrintedItemType);

		nonPrintedItemType.resetOriginalValues();
	}

	/**
	 * Caches the non printed item types in the entity cache if it is enabled.
	 *
	 * @param nonPrintedItemTypes the non printed item types
	 */
	@Override
	public void cacheResult(List<NonPrintedItemType> nonPrintedItemTypes) {
		for (NonPrintedItemType nonPrintedItemType : nonPrintedItemTypes) {
			if (EntityCacheUtil.getResult(
						NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						NonPrintedItemTypeImpl.class,
						nonPrintedItemType.getPrimaryKey()) == null) {
				cacheResult(nonPrintedItemType);
			}
			else {
				nonPrintedItemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all non printed item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NonPrintedItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NonPrintedItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the non printed item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NonPrintedItemType nonPrintedItemType) {
		EntityCacheUtil.removeResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			NonPrintedItemTypeImpl.class, nonPrintedItemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NonPrintedItemType> nonPrintedItemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NonPrintedItemType nonPrintedItemType : nonPrintedItemTypes) {
			EntityCacheUtil.removeResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				NonPrintedItemTypeImpl.class, nonPrintedItemType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new non printed item type with the primary key. Does not add the non printed item type to the database.
	 *
	 * @param itemTypeId the primary key for the new non printed item type
	 * @return the new non printed item type
	 */
	@Override
	public NonPrintedItemType create(long itemTypeId) {
		NonPrintedItemType nonPrintedItemType = new NonPrintedItemTypeImpl();

		nonPrintedItemType.setNew(true);
		nonPrintedItemType.setPrimaryKey(itemTypeId);

		return nonPrintedItemType;
	}

	/**
	 * Removes the non printed item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemTypeId the primary key of the non printed item type
	 * @return the non printed item type that was removed
	 * @throws com.idetronic.eis.NoSuchNonPrintedItemTypeException if a non printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonPrintedItemType remove(long itemTypeId)
		throws NoSuchNonPrintedItemTypeException, SystemException {
		return remove((Serializable)itemTypeId);
	}

	/**
	 * Removes the non printed item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the non printed item type
	 * @return the non printed item type that was removed
	 * @throws com.idetronic.eis.NoSuchNonPrintedItemTypeException if a non printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonPrintedItemType remove(Serializable primaryKey)
		throws NoSuchNonPrintedItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NonPrintedItemType nonPrintedItemType = (NonPrintedItemType)session.get(NonPrintedItemTypeImpl.class,
					primaryKey);

			if (nonPrintedItemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNonPrintedItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nonPrintedItemType);
		}
		catch (NoSuchNonPrintedItemTypeException nsee) {
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
	protected NonPrintedItemType removeImpl(
		NonPrintedItemType nonPrintedItemType) throws SystemException {
		nonPrintedItemType = toUnwrappedModel(nonPrintedItemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nonPrintedItemType)) {
				nonPrintedItemType = (NonPrintedItemType)session.get(NonPrintedItemTypeImpl.class,
						nonPrintedItemType.getPrimaryKeyObj());
			}

			if (nonPrintedItemType != null) {
				session.delete(nonPrintedItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nonPrintedItemType != null) {
			clearCache(nonPrintedItemType);
		}

		return nonPrintedItemType;
	}

	@Override
	public NonPrintedItemType updateImpl(
		com.idetronic.eis.model.NonPrintedItemType nonPrintedItemType)
		throws SystemException {
		nonPrintedItemType = toUnwrappedModel(nonPrintedItemType);

		boolean isNew = nonPrintedItemType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (nonPrintedItemType.isNew()) {
				session.save(nonPrintedItemType);

				nonPrintedItemType.setNew(false);
			}
			else {
				session.merge(nonPrintedItemType);
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

		EntityCacheUtil.putResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			NonPrintedItemTypeImpl.class, nonPrintedItemType.getPrimaryKey(),
			nonPrintedItemType);

		return nonPrintedItemType;
	}

	protected NonPrintedItemType toUnwrappedModel(
		NonPrintedItemType nonPrintedItemType) {
		if (nonPrintedItemType instanceof NonPrintedItemTypeImpl) {
			return nonPrintedItemType;
		}

		NonPrintedItemTypeImpl nonPrintedItemTypeImpl = new NonPrintedItemTypeImpl();

		nonPrintedItemTypeImpl.setNew(nonPrintedItemType.isNew());
		nonPrintedItemTypeImpl.setPrimaryKey(nonPrintedItemType.getPrimaryKey());

		nonPrintedItemTypeImpl.setItemTypeId(nonPrintedItemType.getItemTypeId());
		nonPrintedItemTypeImpl.setItemTypeName(nonPrintedItemType.getItemTypeName());

		return nonPrintedItemTypeImpl;
	}

	/**
	 * Returns the non printed item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the non printed item type
	 * @return the non printed item type
	 * @throws com.idetronic.eis.NoSuchNonPrintedItemTypeException if a non printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonPrintedItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNonPrintedItemTypeException, SystemException {
		NonPrintedItemType nonPrintedItemType = fetchByPrimaryKey(primaryKey);

		if (nonPrintedItemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNonPrintedItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return nonPrintedItemType;
	}

	/**
	 * Returns the non printed item type with the primary key or throws a {@link com.idetronic.eis.NoSuchNonPrintedItemTypeException} if it could not be found.
	 *
	 * @param itemTypeId the primary key of the non printed item type
	 * @return the non printed item type
	 * @throws com.idetronic.eis.NoSuchNonPrintedItemTypeException if a non printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonPrintedItemType findByPrimaryKey(long itemTypeId)
		throws NoSuchNonPrintedItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)itemTypeId);
	}

	/**
	 * Returns the non printed item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the non printed item type
	 * @return the non printed item type, or <code>null</code> if a non printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonPrintedItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NonPrintedItemType nonPrintedItemType = (NonPrintedItemType)EntityCacheUtil.getResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				NonPrintedItemTypeImpl.class, primaryKey);

		if (nonPrintedItemType == _nullNonPrintedItemType) {
			return null;
		}

		if (nonPrintedItemType == null) {
			Session session = null;

			try {
				session = openSession();

				nonPrintedItemType = (NonPrintedItemType)session.get(NonPrintedItemTypeImpl.class,
						primaryKey);

				if (nonPrintedItemType != null) {
					cacheResult(nonPrintedItemType);
				}
				else {
					EntityCacheUtil.putResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						NonPrintedItemTypeImpl.class, primaryKey,
						_nullNonPrintedItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NonPrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					NonPrintedItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nonPrintedItemType;
	}

	/**
	 * Returns the non printed item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemTypeId the primary key of the non printed item type
	 * @return the non printed item type, or <code>null</code> if a non printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NonPrintedItemType fetchByPrimaryKey(long itemTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemTypeId);
	}

	/**
	 * Returns all the non printed item types.
	 *
	 * @return the non printed item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NonPrintedItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the non printed item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.NonPrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of non printed item types
	 * @param end the upper bound of the range of non printed item types (not inclusive)
	 * @return the range of non printed item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NonPrintedItemType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the non printed item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.NonPrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of non printed item types
	 * @param end the upper bound of the range of non printed item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of non printed item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NonPrintedItemType> findAll(int start, int end,
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

		List<NonPrintedItemType> list = (List<NonPrintedItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NONPRINTEDITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NONPRINTEDITEMTYPE;

				if (pagination) {
					sql = sql.concat(NonPrintedItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NonPrintedItemType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NonPrintedItemType>(list);
				}
				else {
					list = (List<NonPrintedItemType>)QueryUtil.list(q,
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
	 * Removes all the non printed item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NonPrintedItemType nonPrintedItemType : findAll()) {
			remove(nonPrintedItemType);
		}
	}

	/**
	 * Returns the number of non printed item types.
	 *
	 * @return the number of non printed item types
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

				Query q = session.createQuery(_SQL_COUNT_NONPRINTEDITEMTYPE);

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
	 * Initializes the non printed item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.NonPrintedItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NonPrintedItemType>> listenersList = new ArrayList<ModelListener<NonPrintedItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NonPrintedItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NonPrintedItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NONPRINTEDITEMTYPE = "SELECT nonPrintedItemType FROM NonPrintedItemType nonPrintedItemType";
	private static final String _SQL_COUNT_NONPRINTEDITEMTYPE = "SELECT COUNT(nonPrintedItemType) FROM NonPrintedItemType nonPrintedItemType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nonPrintedItemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NonPrintedItemType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NonPrintedItemTypePersistenceImpl.class);
	private static NonPrintedItemType _nullNonPrintedItemType = new NonPrintedItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NonPrintedItemType> toCacheModel() {
				return _nullNonPrintedItemTypeCacheModel;
			}
		};

	private static CacheModel<NonPrintedItemType> _nullNonPrintedItemTypeCacheModel =
		new CacheModel<NonPrintedItemType>() {
			@Override
			public NonPrintedItemType toEntityModel() {
				return _nullNonPrintedItemType;
			}
		};
}
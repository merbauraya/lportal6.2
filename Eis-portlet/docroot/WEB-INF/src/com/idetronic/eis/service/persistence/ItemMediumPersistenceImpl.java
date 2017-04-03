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

import com.idetronic.eis.NoSuchItemMediumException;
import com.idetronic.eis.model.ItemMedium;
import com.idetronic.eis.model.impl.ItemMediumImpl;
import com.idetronic.eis.model.impl.ItemMediumModelImpl;

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
 * The persistence implementation for the item medium service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemMediumPersistence
 * @see ItemMediumUtil
 * @generated
 */
public class ItemMediumPersistenceImpl extends BasePersistenceImpl<ItemMedium>
	implements ItemMediumPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemMediumUtil} to access the item medium persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemMediumImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
			ItemMediumModelImpl.FINDER_CACHE_ENABLED, ItemMediumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
			ItemMediumModelImpl.FINDER_CACHE_ENABLED, ItemMediumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
			ItemMediumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ItemMediumPersistenceImpl() {
		setModelClass(ItemMedium.class);
	}

	/**
	 * Caches the item medium in the entity cache if it is enabled.
	 *
	 * @param itemMedium the item medium
	 */
	@Override
	public void cacheResult(ItemMedium itemMedium) {
		EntityCacheUtil.putResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
			ItemMediumImpl.class, itemMedium.getPrimaryKey(), itemMedium);

		itemMedium.resetOriginalValues();
	}

	/**
	 * Caches the item mediums in the entity cache if it is enabled.
	 *
	 * @param itemMediums the item mediums
	 */
	@Override
	public void cacheResult(List<ItemMedium> itemMediums) {
		for (ItemMedium itemMedium : itemMediums) {
			if (EntityCacheUtil.getResult(
						ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
						ItemMediumImpl.class, itemMedium.getPrimaryKey()) == null) {
				cacheResult(itemMedium);
			}
			else {
				itemMedium.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item mediums.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemMediumImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemMediumImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item medium.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemMedium itemMedium) {
		EntityCacheUtil.removeResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
			ItemMediumImpl.class, itemMedium.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemMedium> itemMediums) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemMedium itemMedium : itemMediums) {
			EntityCacheUtil.removeResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
				ItemMediumImpl.class, itemMedium.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item medium with the primary key. Does not add the item medium to the database.
	 *
	 * @param itemMediumId the primary key for the new item medium
	 * @return the new item medium
	 */
	@Override
	public ItemMedium create(long itemMediumId) {
		ItemMedium itemMedium = new ItemMediumImpl();

		itemMedium.setNew(true);
		itemMedium.setPrimaryKey(itemMediumId);

		return itemMedium;
	}

	/**
	 * Removes the item medium with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemMediumId the primary key of the item medium
	 * @return the item medium that was removed
	 * @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemMedium remove(long itemMediumId)
		throws NoSuchItemMediumException, SystemException {
		return remove((Serializable)itemMediumId);
	}

	/**
	 * Removes the item medium with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item medium
	 * @return the item medium that was removed
	 * @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemMedium remove(Serializable primaryKey)
		throws NoSuchItemMediumException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemMedium itemMedium = (ItemMedium)session.get(ItemMediumImpl.class,
					primaryKey);

			if (itemMedium == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemMediumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemMedium);
		}
		catch (NoSuchItemMediumException nsee) {
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
	protected ItemMedium removeImpl(ItemMedium itemMedium)
		throws SystemException {
		itemMedium = toUnwrappedModel(itemMedium);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemMedium)) {
				itemMedium = (ItemMedium)session.get(ItemMediumImpl.class,
						itemMedium.getPrimaryKeyObj());
			}

			if (itemMedium != null) {
				session.delete(itemMedium);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemMedium != null) {
			clearCache(itemMedium);
		}

		return itemMedium;
	}

	@Override
	public ItemMedium updateImpl(com.idetronic.eis.model.ItemMedium itemMedium)
		throws SystemException {
		itemMedium = toUnwrappedModel(itemMedium);

		boolean isNew = itemMedium.isNew();

		Session session = null;

		try {
			session = openSession();

			if (itemMedium.isNew()) {
				session.save(itemMedium);

				itemMedium.setNew(false);
			}
			else {
				session.merge(itemMedium);
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

		EntityCacheUtil.putResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
			ItemMediumImpl.class, itemMedium.getPrimaryKey(), itemMedium);

		return itemMedium;
	}

	protected ItemMedium toUnwrappedModel(ItemMedium itemMedium) {
		if (itemMedium instanceof ItemMediumImpl) {
			return itemMedium;
		}

		ItemMediumImpl itemMediumImpl = new ItemMediumImpl();

		itemMediumImpl.setNew(itemMedium.isNew());
		itemMediumImpl.setPrimaryKey(itemMedium.getPrimaryKey());

		itemMediumImpl.setItemMediumId(itemMedium.getItemMediumId());
		itemMediumImpl.setItemMediumName(itemMedium.getItemMediumName());

		return itemMediumImpl;
	}

	/**
	 * Returns the item medium with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item medium
	 * @return the item medium
	 * @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemMedium findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemMediumException, SystemException {
		ItemMedium itemMedium = fetchByPrimaryKey(primaryKey);

		if (itemMedium == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemMediumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemMedium;
	}

	/**
	 * Returns the item medium with the primary key or throws a {@link com.idetronic.eis.NoSuchItemMediumException} if it could not be found.
	 *
	 * @param itemMediumId the primary key of the item medium
	 * @return the item medium
	 * @throws com.idetronic.eis.NoSuchItemMediumException if a item medium with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemMedium findByPrimaryKey(long itemMediumId)
		throws NoSuchItemMediumException, SystemException {
		return findByPrimaryKey((Serializable)itemMediumId);
	}

	/**
	 * Returns the item medium with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item medium
	 * @return the item medium, or <code>null</code> if a item medium with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemMedium fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemMedium itemMedium = (ItemMedium)EntityCacheUtil.getResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
				ItemMediumImpl.class, primaryKey);

		if (itemMedium == _nullItemMedium) {
			return null;
		}

		if (itemMedium == null) {
			Session session = null;

			try {
				session = openSession();

				itemMedium = (ItemMedium)session.get(ItemMediumImpl.class,
						primaryKey);

				if (itemMedium != null) {
					cacheResult(itemMedium);
				}
				else {
					EntityCacheUtil.putResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
						ItemMediumImpl.class, primaryKey, _nullItemMedium);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemMediumModelImpl.ENTITY_CACHE_ENABLED,
					ItemMediumImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemMedium;
	}

	/**
	 * Returns the item medium with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemMediumId the primary key of the item medium
	 * @return the item medium, or <code>null</code> if a item medium with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemMedium fetchByPrimaryKey(long itemMediumId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemMediumId);
	}

	/**
	 * Returns all the item mediums.
	 *
	 * @return the item mediums
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemMedium> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item mediums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemMediumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item mediums
	 * @param end the upper bound of the range of item mediums (not inclusive)
	 * @return the range of item mediums
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemMedium> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item mediums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemMediumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item mediums
	 * @param end the upper bound of the range of item mediums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item mediums
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemMedium> findAll(int start, int end,
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

		List<ItemMedium> list = (List<ItemMedium>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMMEDIUM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMMEDIUM;

				if (pagination) {
					sql = sql.concat(ItemMediumModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemMedium>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemMedium>(list);
				}
				else {
					list = (List<ItemMedium>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item mediums from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemMedium itemMedium : findAll()) {
			remove(itemMedium);
		}
	}

	/**
	 * Returns the number of item mediums.
	 *
	 * @return the number of item mediums
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

				Query q = session.createQuery(_SQL_COUNT_ITEMMEDIUM);

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
	 * Initializes the item medium persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.ItemMedium")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemMedium>> listenersList = new ArrayList<ModelListener<ItemMedium>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemMedium>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemMediumImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMMEDIUM = "SELECT itemMedium FROM ItemMedium itemMedium";
	private static final String _SQL_COUNT_ITEMMEDIUM = "SELECT COUNT(itemMedium) FROM ItemMedium itemMedium";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemMedium.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemMedium exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemMediumPersistenceImpl.class);
	private static ItemMedium _nullItemMedium = new ItemMediumImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemMedium> toCacheModel() {
				return _nullItemMediumCacheModel;
			}
		};

	private static CacheModel<ItemMedium> _nullItemMediumCacheModel = new CacheModel<ItemMedium>() {
			@Override
			public ItemMedium toEntityModel() {
				return _nullItemMedium;
			}
		};
}
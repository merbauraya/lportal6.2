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

import com.idetronic.eis.NoSuchPrintedItemTypeException;
import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.model.impl.PrintedItemTypeImpl;
import com.idetronic.eis.model.impl.PrintedItemTypeModelImpl;

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
 * The persistence implementation for the printed item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PrintedItemTypePersistence
 * @see PrintedItemTypeUtil
 * @generated
 */
public class PrintedItemTypePersistenceImpl extends BasePersistenceImpl<PrintedItemType>
	implements PrintedItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrintedItemTypeUtil} to access the printed item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrintedItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			PrintedItemTypeModelImpl.FINDER_CACHE_ENABLED,
			PrintedItemTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			PrintedItemTypeModelImpl.FINDER_CACHE_ENABLED,
			PrintedItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			PrintedItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PrintedItemTypePersistenceImpl() {
		setModelClass(PrintedItemType.class);
	}

	/**
	 * Caches the printed item type in the entity cache if it is enabled.
	 *
	 * @param printedItemType the printed item type
	 */
	@Override
	public void cacheResult(PrintedItemType printedItemType) {
		EntityCacheUtil.putResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			PrintedItemTypeImpl.class, printedItemType.getPrimaryKey(),
			printedItemType);

		printedItemType.resetOriginalValues();
	}

	/**
	 * Caches the printed item types in the entity cache if it is enabled.
	 *
	 * @param printedItemTypes the printed item types
	 */
	@Override
	public void cacheResult(List<PrintedItemType> printedItemTypes) {
		for (PrintedItemType printedItemType : printedItemTypes) {
			if (EntityCacheUtil.getResult(
						PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						PrintedItemTypeImpl.class,
						printedItemType.getPrimaryKey()) == null) {
				cacheResult(printedItemType);
			}
			else {
				printedItemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all printed item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrintedItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrintedItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the printed item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PrintedItemType printedItemType) {
		EntityCacheUtil.removeResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			PrintedItemTypeImpl.class, printedItemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PrintedItemType> printedItemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PrintedItemType printedItemType : printedItemTypes) {
			EntityCacheUtil.removeResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				PrintedItemTypeImpl.class, printedItemType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new printed item type with the primary key. Does not add the printed item type to the database.
	 *
	 * @param itemTypeId the primary key for the new printed item type
	 * @return the new printed item type
	 */
	@Override
	public PrintedItemType create(long itemTypeId) {
		PrintedItemType printedItemType = new PrintedItemTypeImpl();

		printedItemType.setNew(true);
		printedItemType.setPrimaryKey(itemTypeId);

		return printedItemType;
	}

	/**
	 * Removes the printed item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemTypeId the primary key of the printed item type
	 * @return the printed item type that was removed
	 * @throws com.idetronic.eis.NoSuchPrintedItemTypeException if a printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrintedItemType remove(long itemTypeId)
		throws NoSuchPrintedItemTypeException, SystemException {
		return remove((Serializable)itemTypeId);
	}

	/**
	 * Removes the printed item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the printed item type
	 * @return the printed item type that was removed
	 * @throws com.idetronic.eis.NoSuchPrintedItemTypeException if a printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrintedItemType remove(Serializable primaryKey)
		throws NoSuchPrintedItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PrintedItemType printedItemType = (PrintedItemType)session.get(PrintedItemTypeImpl.class,
					primaryKey);

			if (printedItemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrintedItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(printedItemType);
		}
		catch (NoSuchPrintedItemTypeException nsee) {
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
	protected PrintedItemType removeImpl(PrintedItemType printedItemType)
		throws SystemException {
		printedItemType = toUnwrappedModel(printedItemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(printedItemType)) {
				printedItemType = (PrintedItemType)session.get(PrintedItemTypeImpl.class,
						printedItemType.getPrimaryKeyObj());
			}

			if (printedItemType != null) {
				session.delete(printedItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (printedItemType != null) {
			clearCache(printedItemType);
		}

		return printedItemType;
	}

	@Override
	public PrintedItemType updateImpl(
		com.idetronic.eis.model.PrintedItemType printedItemType)
		throws SystemException {
		printedItemType = toUnwrappedModel(printedItemType);

		boolean isNew = printedItemType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (printedItemType.isNew()) {
				session.save(printedItemType);

				printedItemType.setNew(false);
			}
			else {
				session.merge(printedItemType);
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

		EntityCacheUtil.putResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			PrintedItemTypeImpl.class, printedItemType.getPrimaryKey(),
			printedItemType);

		return printedItemType;
	}

	protected PrintedItemType toUnwrappedModel(PrintedItemType printedItemType) {
		if (printedItemType instanceof PrintedItemTypeImpl) {
			return printedItemType;
		}

		PrintedItemTypeImpl printedItemTypeImpl = new PrintedItemTypeImpl();

		printedItemTypeImpl.setNew(printedItemType.isNew());
		printedItemTypeImpl.setPrimaryKey(printedItemType.getPrimaryKey());

		printedItemTypeImpl.setItemTypeId(printedItemType.getItemTypeId());
		printedItemTypeImpl.setItemTypeName(printedItemType.getItemTypeName());

		return printedItemTypeImpl;
	}

	/**
	 * Returns the printed item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the printed item type
	 * @return the printed item type
	 * @throws com.idetronic.eis.NoSuchPrintedItemTypeException if a printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrintedItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrintedItemTypeException, SystemException {
		PrintedItemType printedItemType = fetchByPrimaryKey(primaryKey);

		if (printedItemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrintedItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return printedItemType;
	}

	/**
	 * Returns the printed item type with the primary key or throws a {@link com.idetronic.eis.NoSuchPrintedItemTypeException} if it could not be found.
	 *
	 * @param itemTypeId the primary key of the printed item type
	 * @return the printed item type
	 * @throws com.idetronic.eis.NoSuchPrintedItemTypeException if a printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrintedItemType findByPrimaryKey(long itemTypeId)
		throws NoSuchPrintedItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)itemTypeId);
	}

	/**
	 * Returns the printed item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the printed item type
	 * @return the printed item type, or <code>null</code> if a printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrintedItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PrintedItemType printedItemType = (PrintedItemType)EntityCacheUtil.getResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				PrintedItemTypeImpl.class, primaryKey);

		if (printedItemType == _nullPrintedItemType) {
			return null;
		}

		if (printedItemType == null) {
			Session session = null;

			try {
				session = openSession();

				printedItemType = (PrintedItemType)session.get(PrintedItemTypeImpl.class,
						primaryKey);

				if (printedItemType != null) {
					cacheResult(printedItemType);
				}
				else {
					EntityCacheUtil.putResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						PrintedItemTypeImpl.class, primaryKey,
						_nullPrintedItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PrintedItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					PrintedItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return printedItemType;
	}

	/**
	 * Returns the printed item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemTypeId the primary key of the printed item type
	 * @return the printed item type, or <code>null</code> if a printed item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrintedItemType fetchByPrimaryKey(long itemTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemTypeId);
	}

	/**
	 * Returns all the printed item types.
	 *
	 * @return the printed item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrintedItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the printed item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of printed item types
	 * @param end the upper bound of the range of printed item types (not inclusive)
	 * @return the range of printed item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrintedItemType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the printed item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PrintedItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of printed item types
	 * @param end the upper bound of the range of printed item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of printed item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrintedItemType> findAll(int start, int end,
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

		List<PrintedItemType> list = (List<PrintedItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRINTEDITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRINTEDITEMTYPE;

				if (pagination) {
					sql = sql.concat(PrintedItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PrintedItemType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PrintedItemType>(list);
				}
				else {
					list = (List<PrintedItemType>)QueryUtil.list(q,
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
	 * Removes all the printed item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PrintedItemType printedItemType : findAll()) {
			remove(printedItemType);
		}
	}

	/**
	 * Returns the number of printed item types.
	 *
	 * @return the number of printed item types
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

				Query q = session.createQuery(_SQL_COUNT_PRINTEDITEMTYPE);

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
	 * Initializes the printed item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.PrintedItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PrintedItemType>> listenersList = new ArrayList<ModelListener<PrintedItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PrintedItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrintedItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRINTEDITEMTYPE = "SELECT printedItemType FROM PrintedItemType printedItemType";
	private static final String _SQL_COUNT_PRINTEDITEMTYPE = "SELECT COUNT(printedItemType) FROM PrintedItemType printedItemType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "printedItemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PrintedItemType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrintedItemTypePersistenceImpl.class);
	private static PrintedItemType _nullPrintedItemType = new PrintedItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PrintedItemType> toCacheModel() {
				return _nullPrintedItemTypeCacheModel;
			}
		};

	private static CacheModel<PrintedItemType> _nullPrintedItemTypeCacheModel = new CacheModel<PrintedItemType>() {
			@Override
			public PrintedItemType toEntityModel() {
				return _nullPrintedItemType;
			}
		};
}
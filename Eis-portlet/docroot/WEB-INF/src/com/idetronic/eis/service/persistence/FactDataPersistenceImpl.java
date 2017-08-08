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

import com.idetronic.eis.NoSuchFactDataException;
import com.idetronic.eis.model.FactData;
import com.idetronic.eis.model.impl.FactDataImpl;
import com.idetronic.eis.model.impl.FactDataModelImpl;

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
 * The persistence implementation for the fact data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactDataPersistence
 * @see FactDataUtil
 * @generated
 */
public class FactDataPersistenceImpl extends BasePersistenceImpl<FactData>
	implements FactDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactDataUtil} to access the fact data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactDataModelImpl.ENTITY_CACHE_ENABLED,
			FactDataModelImpl.FINDER_CACHE_ENABLED, FactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactDataModelImpl.ENTITY_CACHE_ENABLED,
			FactDataModelImpl.FINDER_CACHE_ENABLED, FactDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactDataModelImpl.ENTITY_CACHE_ENABLED,
			FactDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactDataPersistenceImpl() {
		setModelClass(FactData.class);
	}

	/**
	 * Caches the fact data in the entity cache if it is enabled.
	 *
	 * @param factData the fact data
	 */
	@Override
	public void cacheResult(FactData factData) {
		EntityCacheUtil.putResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
			FactDataImpl.class, factData.getPrimaryKey(), factData);

		factData.resetOriginalValues();
	}

	/**
	 * Caches the fact datas in the entity cache if it is enabled.
	 *
	 * @param factDatas the fact datas
	 */
	@Override
	public void cacheResult(List<FactData> factDatas) {
		for (FactData factData : factDatas) {
			if (EntityCacheUtil.getResult(
						FactDataModelImpl.ENTITY_CACHE_ENABLED,
						FactDataImpl.class, factData.getPrimaryKey()) == null) {
				cacheResult(factData);
			}
			else {
				factData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactData factData) {
		EntityCacheUtil.removeResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
			FactDataImpl.class, factData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactData> factDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactData factData : factDatas) {
			EntityCacheUtil.removeResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
				FactDataImpl.class, factData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact data with the primary key. Does not add the fact data to the database.
	 *
	 * @param factId the primary key for the new fact data
	 * @return the new fact data
	 */
	@Override
	public FactData create(long factId) {
		FactData factData = new FactDataImpl();

		factData.setNew(true);
		factData.setPrimaryKey(factId);

		return factData;
	}

	/**
	 * Removes the fact data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact data
	 * @return the fact data that was removed
	 * @throws com.idetronic.eis.NoSuchFactDataException if a fact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactData remove(long factId)
		throws NoSuchFactDataException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact data
	 * @return the fact data that was removed
	 * @throws com.idetronic.eis.NoSuchFactDataException if a fact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactData remove(Serializable primaryKey)
		throws NoSuchFactDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactData factData = (FactData)session.get(FactDataImpl.class,
					primaryKey);

			if (factData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factData);
		}
		catch (NoSuchFactDataException nsee) {
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
	protected FactData removeImpl(FactData factData) throws SystemException {
		factData = toUnwrappedModel(factData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factData)) {
				factData = (FactData)session.get(FactDataImpl.class,
						factData.getPrimaryKeyObj());
			}

			if (factData != null) {
				session.delete(factData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factData != null) {
			clearCache(factData);
		}

		return factData;
	}

	@Override
	public FactData updateImpl(com.idetronic.eis.model.FactData factData)
		throws SystemException {
		factData = toUnwrappedModel(factData);

		boolean isNew = factData.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factData.isNew()) {
				session.save(factData);

				factData.setNew(false);
			}
			else {
				session.merge(factData);
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

		EntityCacheUtil.putResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
			FactDataImpl.class, factData.getPrimaryKey(), factData);

		return factData;
	}

	protected FactData toUnwrappedModel(FactData factData) {
		if (factData instanceof FactDataImpl) {
			return factData;
		}

		FactDataImpl factDataImpl = new FactDataImpl();

		factDataImpl.setNew(factData.isNew());
		factDataImpl.setPrimaryKey(factData.getPrimaryKey());

		factDataImpl.setFactId(factData.getFactId());
		factDataImpl.setReportId(factData.getReportId());
		factDataImpl.setLibraryId(factData.getLibraryId());
		factDataImpl.setPeriod(factData.getPeriod());
		factDataImpl.setDimensionId(factData.getDimensionId());
		factDataImpl.setMeasure1(factData.getMeasure1());
		factDataImpl.setMeasure2(factData.getMeasure2());
		factDataImpl.setMeasure3(factData.getMeasure3());
		factDataImpl.setMeasure4(factData.getMeasure4());
		factDataImpl.setCompanyId(factData.getCompanyId());
		factDataImpl.setGroupId(factData.getGroupId());
		factDataImpl.setUserId(factData.getUserId());
		factDataImpl.setUserName(factData.getUserName());
		factDataImpl.setCreateDate(factData.getCreateDate());

		return factDataImpl;
	}

	/**
	 * Returns the fact data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact data
	 * @return the fact data
	 * @throws com.idetronic.eis.NoSuchFactDataException if a fact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactDataException, SystemException {
		FactData factData = fetchByPrimaryKey(primaryKey);

		if (factData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factData;
	}

	/**
	 * Returns the fact data with the primary key or throws a {@link com.idetronic.eis.NoSuchFactDataException} if it could not be found.
	 *
	 * @param factId the primary key of the fact data
	 * @return the fact data
	 * @throws com.idetronic.eis.NoSuchFactDataException if a fact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactData findByPrimaryKey(long factId)
		throws NoSuchFactDataException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact data
	 * @return the fact data, or <code>null</code> if a fact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactData factData = (FactData)EntityCacheUtil.getResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
				FactDataImpl.class, primaryKey);

		if (factData == _nullFactData) {
			return null;
		}

		if (factData == null) {
			Session session = null;

			try {
				session = openSession();

				factData = (FactData)session.get(FactDataImpl.class, primaryKey);

				if (factData != null) {
					cacheResult(factData);
				}
				else {
					EntityCacheUtil.putResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
						FactDataImpl.class, primaryKey, _nullFactData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactDataModelImpl.ENTITY_CACHE_ENABLED,
					FactDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factData;
	}

	/**
	 * Returns the fact data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact data
	 * @return the fact data, or <code>null</code> if a fact data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactData fetchByPrimaryKey(long factId) throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact datas.
	 *
	 * @return the fact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact datas
	 * @param end the upper bound of the range of fact datas (not inclusive)
	 * @return the range of fact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactData> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact datas
	 * @param end the upper bound of the range of fact datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactData> findAll(int start, int end,
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

		List<FactData> list = (List<FactData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTDATA;

				if (pagination) {
					sql = sql.concat(FactDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactData>(list);
				}
				else {
					list = (List<FactData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactData factData : findAll()) {
			remove(factData);
		}
	}

	/**
	 * Returns the number of fact datas.
	 *
	 * @return the number of fact datas
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

				Query q = session.createQuery(_SQL_COUNT_FACTDATA);

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
	 * Initializes the fact data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactData>> listenersList = new ArrayList<ModelListener<FactData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTDATA = "SELECT factData FROM FactData factData";
	private static final String _SQL_COUNT_FACTDATA = "SELECT COUNT(factData) FROM FactData factData";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactData exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactDataPersistenceImpl.class);
	private static FactData _nullFactData = new FactDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactData> toCacheModel() {
				return _nullFactDataCacheModel;
			}
		};

	private static CacheModel<FactData> _nullFactDataCacheModel = new CacheModel<FactData>() {
			@Override
			public FactData toEntityModel() {
				return _nullFactData;
			}
		};
}
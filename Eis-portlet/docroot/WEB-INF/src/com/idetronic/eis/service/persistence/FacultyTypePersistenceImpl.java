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

import com.idetronic.eis.NoSuchFacultyTypeException;
import com.idetronic.eis.model.FacultyType;
import com.idetronic.eis.model.impl.FacultyTypeImpl;
import com.idetronic.eis.model.impl.FacultyTypeModelImpl;

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
 * The persistence implementation for the faculty type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FacultyTypePersistence
 * @see FacultyTypeUtil
 * @generated
 */
public class FacultyTypePersistenceImpl extends BasePersistenceImpl<FacultyType>
	implements FacultyTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FacultyTypeUtil} to access the faculty type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FacultyTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
			FacultyTypeModelImpl.FINDER_CACHE_ENABLED, FacultyTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
			FacultyTypeModelImpl.FINDER_CACHE_ENABLED, FacultyTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
			FacultyTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FacultyTypePersistenceImpl() {
		setModelClass(FacultyType.class);
	}

	/**
	 * Caches the faculty type in the entity cache if it is enabled.
	 *
	 * @param facultyType the faculty type
	 */
	@Override
	public void cacheResult(FacultyType facultyType) {
		EntityCacheUtil.putResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
			FacultyTypeImpl.class, facultyType.getPrimaryKey(), facultyType);

		facultyType.resetOriginalValues();
	}

	/**
	 * Caches the faculty types in the entity cache if it is enabled.
	 *
	 * @param facultyTypes the faculty types
	 */
	@Override
	public void cacheResult(List<FacultyType> facultyTypes) {
		for (FacultyType facultyType : facultyTypes) {
			if (EntityCacheUtil.getResult(
						FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
						FacultyTypeImpl.class, facultyType.getPrimaryKey()) == null) {
				cacheResult(facultyType);
			}
			else {
				facultyType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all faculty types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FacultyTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FacultyTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the faculty type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyType facultyType) {
		EntityCacheUtil.removeResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
			FacultyTypeImpl.class, facultyType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FacultyType> facultyTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FacultyType facultyType : facultyTypes) {
			EntityCacheUtil.removeResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
				FacultyTypeImpl.class, facultyType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new faculty type with the primary key. Does not add the faculty type to the database.
	 *
	 * @param facultyTypeId the primary key for the new faculty type
	 * @return the new faculty type
	 */
	@Override
	public FacultyType create(long facultyTypeId) {
		FacultyType facultyType = new FacultyTypeImpl();

		facultyType.setNew(true);
		facultyType.setPrimaryKey(facultyTypeId);

		return facultyType;
	}

	/**
	 * Removes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws com.idetronic.eis.NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacultyType remove(long facultyTypeId)
		throws NoSuchFacultyTypeException, SystemException {
		return remove((Serializable)facultyTypeId);
	}

	/**
	 * Removes the faculty type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty type
	 * @return the faculty type that was removed
	 * @throws com.idetronic.eis.NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacultyType remove(Serializable primaryKey)
		throws NoSuchFacultyTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FacultyType facultyType = (FacultyType)session.get(FacultyTypeImpl.class,
					primaryKey);

			if (facultyType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(facultyType);
		}
		catch (NoSuchFacultyTypeException nsee) {
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
	protected FacultyType removeImpl(FacultyType facultyType)
		throws SystemException {
		facultyType = toUnwrappedModel(facultyType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyType)) {
				facultyType = (FacultyType)session.get(FacultyTypeImpl.class,
						facultyType.getPrimaryKeyObj());
			}

			if (facultyType != null) {
				session.delete(facultyType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (facultyType != null) {
			clearCache(facultyType);
		}

		return facultyType;
	}

	@Override
	public FacultyType updateImpl(
		com.idetronic.eis.model.FacultyType facultyType)
		throws SystemException {
		facultyType = toUnwrappedModel(facultyType);

		boolean isNew = facultyType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (facultyType.isNew()) {
				session.save(facultyType);

				facultyType.setNew(false);
			}
			else {
				session.merge(facultyType);
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

		EntityCacheUtil.putResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
			FacultyTypeImpl.class, facultyType.getPrimaryKey(), facultyType);

		return facultyType;
	}

	protected FacultyType toUnwrappedModel(FacultyType facultyType) {
		if (facultyType instanceof FacultyTypeImpl) {
			return facultyType;
		}

		FacultyTypeImpl facultyTypeImpl = new FacultyTypeImpl();

		facultyTypeImpl.setNew(facultyType.isNew());
		facultyTypeImpl.setPrimaryKey(facultyType.getPrimaryKey());

		facultyTypeImpl.setFacultyTypeId(facultyType.getFacultyTypeId());
		facultyTypeImpl.setFacultyTypeName(facultyType.getFacultyTypeName());

		return facultyTypeImpl;
	}

	/**
	 * Returns the faculty type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty type
	 * @return the faculty type
	 * @throws com.idetronic.eis.NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacultyType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyTypeException, SystemException {
		FacultyType facultyType = fetchByPrimaryKey(primaryKey);

		if (facultyType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return facultyType;
	}

	/**
	 * Returns the faculty type with the primary key or throws a {@link com.idetronic.eis.NoSuchFacultyTypeException} if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type
	 * @throws com.idetronic.eis.NoSuchFacultyTypeException if a faculty type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacultyType findByPrimaryKey(long facultyTypeId)
		throws NoSuchFacultyTypeException, SystemException {
		return findByPrimaryKey((Serializable)facultyTypeId);
	}

	/**
	 * Returns the faculty type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty type
	 * @return the faculty type, or <code>null</code> if a faculty type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacultyType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FacultyType facultyType = (FacultyType)EntityCacheUtil.getResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
				FacultyTypeImpl.class, primaryKey);

		if (facultyType == _nullFacultyType) {
			return null;
		}

		if (facultyType == null) {
			Session session = null;

			try {
				session = openSession();

				facultyType = (FacultyType)session.get(FacultyTypeImpl.class,
						primaryKey);

				if (facultyType != null) {
					cacheResult(facultyType);
				}
				else {
					EntityCacheUtil.putResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
						FacultyTypeImpl.class, primaryKey, _nullFacultyType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FacultyTypeModelImpl.ENTITY_CACHE_ENABLED,
					FacultyTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return facultyType;
	}

	/**
	 * Returns the faculty type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyTypeId the primary key of the faculty type
	 * @return the faculty type, or <code>null</code> if a faculty type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FacultyType fetchByPrimaryKey(long facultyTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)facultyTypeId);
	}

	/**
	 * Returns all the faculty types.
	 *
	 * @return the faculty types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FacultyType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @return the range of faculty types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FacultyType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty types
	 * @param end the upper bound of the range of faculty types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FacultyType> findAll(int start, int end,
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

		List<FacultyType> list = (List<FacultyType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACULTYTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYTYPE;

				if (pagination) {
					sql = sql.concat(FacultyTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FacultyType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FacultyType>(list);
				}
				else {
					list = (List<FacultyType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the faculty types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FacultyType facultyType : findAll()) {
			remove(facultyType);
		}
	}

	/**
	 * Returns the number of faculty types.
	 *
	 * @return the number of faculty types
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

				Query q = session.createQuery(_SQL_COUNT_FACULTYTYPE);

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
	 * Initializes the faculty type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FacultyType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FacultyType>> listenersList = new ArrayList<ModelListener<FacultyType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FacultyType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FacultyTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACULTYTYPE = "SELECT facultyType FROM FacultyType facultyType";
	private static final String _SQL_COUNT_FACULTYTYPE = "SELECT COUNT(facultyType) FROM FacultyType facultyType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "facultyType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FacultyType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FacultyTypePersistenceImpl.class);
	private static FacultyType _nullFacultyType = new FacultyTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FacultyType> toCacheModel() {
				return _nullFacultyTypeCacheModel;
			}
		};

	private static CacheModel<FacultyType> _nullFacultyTypeCacheModel = new CacheModel<FacultyType>() {
			@Override
			public FacultyType toEntityModel() {
				return _nullFacultyType;
			}
		};
}
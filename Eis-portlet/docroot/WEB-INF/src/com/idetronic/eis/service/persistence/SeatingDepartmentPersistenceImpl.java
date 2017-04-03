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

import com.idetronic.eis.NoSuchSeatingDepartmentException;
import com.idetronic.eis.model.SeatingDepartment;
import com.idetronic.eis.model.impl.SeatingDepartmentImpl;
import com.idetronic.eis.model.impl.SeatingDepartmentModelImpl;

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
 * The persistence implementation for the seating department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingDepartmentPersistence
 * @see SeatingDepartmentUtil
 * @generated
 */
public class SeatingDepartmentPersistenceImpl extends BasePersistenceImpl<SeatingDepartment>
	implements SeatingDepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SeatingDepartmentUtil} to access the seating department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SeatingDepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			SeatingDepartmentModelImpl.FINDER_CACHE_ENABLED,
			SeatingDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			SeatingDepartmentModelImpl.FINDER_CACHE_ENABLED,
			SeatingDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			SeatingDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SeatingDepartmentPersistenceImpl() {
		setModelClass(SeatingDepartment.class);
	}

	/**
	 * Caches the seating department in the entity cache if it is enabled.
	 *
	 * @param seatingDepartment the seating department
	 */
	@Override
	public void cacheResult(SeatingDepartment seatingDepartment) {
		EntityCacheUtil.putResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			SeatingDepartmentImpl.class, seatingDepartment.getPrimaryKey(),
			seatingDepartment);

		seatingDepartment.resetOriginalValues();
	}

	/**
	 * Caches the seating departments in the entity cache if it is enabled.
	 *
	 * @param seatingDepartments the seating departments
	 */
	@Override
	public void cacheResult(List<SeatingDepartment> seatingDepartments) {
		for (SeatingDepartment seatingDepartment : seatingDepartments) {
			if (EntityCacheUtil.getResult(
						SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						SeatingDepartmentImpl.class,
						seatingDepartment.getPrimaryKey()) == null) {
				cacheResult(seatingDepartment);
			}
			else {
				seatingDepartment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all seating departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SeatingDepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SeatingDepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the seating department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SeatingDepartment seatingDepartment) {
		EntityCacheUtil.removeResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			SeatingDepartmentImpl.class, seatingDepartment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SeatingDepartment> seatingDepartments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SeatingDepartment seatingDepartment : seatingDepartments) {
			EntityCacheUtil.removeResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				SeatingDepartmentImpl.class, seatingDepartment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new seating department with the primary key. Does not add the seating department to the database.
	 *
	 * @param departmentId the primary key for the new seating department
	 * @return the new seating department
	 */
	@Override
	public SeatingDepartment create(long departmentId) {
		SeatingDepartment seatingDepartment = new SeatingDepartmentImpl();

		seatingDepartment.setNew(true);
		seatingDepartment.setPrimaryKey(departmentId);

		return seatingDepartment;
	}

	/**
	 * Removes the seating department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the seating department
	 * @return the seating department that was removed
	 * @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment remove(long departmentId)
		throws NoSuchSeatingDepartmentException, SystemException {
		return remove((Serializable)departmentId);
	}

	/**
	 * Removes the seating department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the seating department
	 * @return the seating department that was removed
	 * @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment remove(Serializable primaryKey)
		throws NoSuchSeatingDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SeatingDepartment seatingDepartment = (SeatingDepartment)session.get(SeatingDepartmentImpl.class,
					primaryKey);

			if (seatingDepartment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSeatingDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(seatingDepartment);
		}
		catch (NoSuchSeatingDepartmentException nsee) {
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
	protected SeatingDepartment removeImpl(SeatingDepartment seatingDepartment)
		throws SystemException {
		seatingDepartment = toUnwrappedModel(seatingDepartment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(seatingDepartment)) {
				seatingDepartment = (SeatingDepartment)session.get(SeatingDepartmentImpl.class,
						seatingDepartment.getPrimaryKeyObj());
			}

			if (seatingDepartment != null) {
				session.delete(seatingDepartment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (seatingDepartment != null) {
			clearCache(seatingDepartment);
		}

		return seatingDepartment;
	}

	@Override
	public SeatingDepartment updateImpl(
		com.idetronic.eis.model.SeatingDepartment seatingDepartment)
		throws SystemException {
		seatingDepartment = toUnwrappedModel(seatingDepartment);

		boolean isNew = seatingDepartment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (seatingDepartment.isNew()) {
				session.save(seatingDepartment);

				seatingDepartment.setNew(false);
			}
			else {
				session.merge(seatingDepartment);
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

		EntityCacheUtil.putResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			SeatingDepartmentImpl.class, seatingDepartment.getPrimaryKey(),
			seatingDepartment);

		return seatingDepartment;
	}

	protected SeatingDepartment toUnwrappedModel(
		SeatingDepartment seatingDepartment) {
		if (seatingDepartment instanceof SeatingDepartmentImpl) {
			return seatingDepartment;
		}

		SeatingDepartmentImpl seatingDepartmentImpl = new SeatingDepartmentImpl();

		seatingDepartmentImpl.setNew(seatingDepartment.isNew());
		seatingDepartmentImpl.setPrimaryKey(seatingDepartment.getPrimaryKey());

		seatingDepartmentImpl.setDepartmentId(seatingDepartment.getDepartmentId());
		seatingDepartmentImpl.setDepartmentName(seatingDepartment.getDepartmentName());
		seatingDepartmentImpl.setCompanyId(seatingDepartment.getCompanyId());
		seatingDepartmentImpl.setGroupId(seatingDepartment.getGroupId());
		seatingDepartmentImpl.setUserId(seatingDepartment.getUserId());
		seatingDepartmentImpl.setUserName(seatingDepartment.getUserName());
		seatingDepartmentImpl.setCreateDate(seatingDepartment.getCreateDate());
		seatingDepartmentImpl.setModifiedDate(seatingDepartment.getModifiedDate());

		return seatingDepartmentImpl;
	}

	/**
	 * Returns the seating department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the seating department
	 * @return the seating department
	 * @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSeatingDepartmentException, SystemException {
		SeatingDepartment seatingDepartment = fetchByPrimaryKey(primaryKey);

		if (seatingDepartment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSeatingDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return seatingDepartment;
	}

	/**
	 * Returns the seating department with the primary key or throws a {@link com.idetronic.eis.NoSuchSeatingDepartmentException} if it could not be found.
	 *
	 * @param departmentId the primary key of the seating department
	 * @return the seating department
	 * @throws com.idetronic.eis.NoSuchSeatingDepartmentException if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment findByPrimaryKey(long departmentId)
		throws NoSuchSeatingDepartmentException, SystemException {
		return findByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns the seating department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the seating department
	 * @return the seating department, or <code>null</code> if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SeatingDepartment seatingDepartment = (SeatingDepartment)EntityCacheUtil.getResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				SeatingDepartmentImpl.class, primaryKey);

		if (seatingDepartment == _nullSeatingDepartment) {
			return null;
		}

		if (seatingDepartment == null) {
			Session session = null;

			try {
				session = openSession();

				seatingDepartment = (SeatingDepartment)session.get(SeatingDepartmentImpl.class,
						primaryKey);

				if (seatingDepartment != null) {
					cacheResult(seatingDepartment);
				}
				else {
					EntityCacheUtil.putResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						SeatingDepartmentImpl.class, primaryKey,
						_nullSeatingDepartment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
					SeatingDepartmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return seatingDepartment;
	}

	/**
	 * Returns the seating department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the seating department
	 * @return the seating department, or <code>null</code> if a seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingDepartment fetchByPrimaryKey(long departmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns all the seating departments.
	 *
	 * @return the seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingDepartment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seating departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seating departments
	 * @param end the upper bound of the range of seating departments (not inclusive)
	 * @return the range of seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingDepartment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the seating departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seating departments
	 * @param end the upper bound of the range of seating departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingDepartment> findAll(int start, int end,
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

		List<SeatingDepartment> list = (List<SeatingDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEATINGDEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEATINGDEPARTMENT;

				if (pagination) {
					sql = sql.concat(SeatingDepartmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SeatingDepartment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SeatingDepartment>(list);
				}
				else {
					list = (List<SeatingDepartment>)QueryUtil.list(q,
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
	 * Removes all the seating departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SeatingDepartment seatingDepartment : findAll()) {
			remove(seatingDepartment);
		}
	}

	/**
	 * Returns the number of seating departments.
	 *
	 * @return the number of seating departments
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

				Query q = session.createQuery(_SQL_COUNT_SEATINGDEPARTMENT);

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
	 * Initializes the seating department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.SeatingDepartment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SeatingDepartment>> listenersList = new ArrayList<ModelListener<SeatingDepartment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SeatingDepartment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SeatingDepartmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEATINGDEPARTMENT = "SELECT seatingDepartment FROM SeatingDepartment seatingDepartment";
	private static final String _SQL_COUNT_SEATINGDEPARTMENT = "SELECT COUNT(seatingDepartment) FROM SeatingDepartment seatingDepartment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "seatingDepartment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SeatingDepartment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SeatingDepartmentPersistenceImpl.class);
	private static SeatingDepartment _nullSeatingDepartment = new SeatingDepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SeatingDepartment> toCacheModel() {
				return _nullSeatingDepartmentCacheModel;
			}
		};

	private static CacheModel<SeatingDepartment> _nullSeatingDepartmentCacheModel =
		new CacheModel<SeatingDepartment>() {
			@Override
			public SeatingDepartment toEntityModel() {
				return _nullSeatingDepartment;
			}
		};
}
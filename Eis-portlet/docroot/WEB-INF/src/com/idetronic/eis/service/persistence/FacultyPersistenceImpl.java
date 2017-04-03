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

import com.idetronic.eis.NoSuchFacultyException;
import com.idetronic.eis.model.Faculty;
import com.idetronic.eis.model.impl.FacultyImpl;
import com.idetronic.eis.model.impl.FacultyModelImpl;

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
 * The persistence implementation for the faculty service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FacultyPersistence
 * @see FacultyUtil
 * @generated
 */
public class FacultyPersistenceImpl extends BasePersistenceImpl<Faculty>
	implements FacultyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FacultyUtil} to access the faculty persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FacultyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FacultyModelImpl.ENTITY_CACHE_ENABLED,
			FacultyModelImpl.FINDER_CACHE_ENABLED, FacultyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FacultyModelImpl.ENTITY_CACHE_ENABLED,
			FacultyModelImpl.FINDER_CACHE_ENABLED, FacultyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FacultyModelImpl.ENTITY_CACHE_ENABLED,
			FacultyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FacultyPersistenceImpl() {
		setModelClass(Faculty.class);
	}

	/**
	 * Caches the faculty in the entity cache if it is enabled.
	 *
	 * @param faculty the faculty
	 */
	@Override
	public void cacheResult(Faculty faculty) {
		EntityCacheUtil.putResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
			FacultyImpl.class, faculty.getPrimaryKey(), faculty);

		faculty.resetOriginalValues();
	}

	/**
	 * Caches the faculties in the entity cache if it is enabled.
	 *
	 * @param faculties the faculties
	 */
	@Override
	public void cacheResult(List<Faculty> faculties) {
		for (Faculty faculty : faculties) {
			if (EntityCacheUtil.getResult(
						FacultyModelImpl.ENTITY_CACHE_ENABLED,
						FacultyImpl.class, faculty.getPrimaryKey()) == null) {
				cacheResult(faculty);
			}
			else {
				faculty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all faculties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FacultyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FacultyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the faculty.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Faculty faculty) {
		EntityCacheUtil.removeResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
			FacultyImpl.class, faculty.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Faculty> faculties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Faculty faculty : faculties) {
			EntityCacheUtil.removeResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
				FacultyImpl.class, faculty.getPrimaryKey());
		}
	}

	/**
	 * Creates a new faculty with the primary key. Does not add the faculty to the database.
	 *
	 * @param facultyId the primary key for the new faculty
	 * @return the new faculty
	 */
	@Override
	public Faculty create(long facultyId) {
		Faculty faculty = new FacultyImpl();

		faculty.setNew(true);
		faculty.setPrimaryKey(facultyId);

		return faculty;
	}

	/**
	 * Removes the faculty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyId the primary key of the faculty
	 * @return the faculty that was removed
	 * @throws com.idetronic.eis.NoSuchFacultyException if a faculty with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Faculty remove(long facultyId)
		throws NoSuchFacultyException, SystemException {
		return remove((Serializable)facultyId);
	}

	/**
	 * Removes the faculty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty
	 * @return the faculty that was removed
	 * @throws com.idetronic.eis.NoSuchFacultyException if a faculty with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Faculty remove(Serializable primaryKey)
		throws NoSuchFacultyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Faculty faculty = (Faculty)session.get(FacultyImpl.class, primaryKey);

			if (faculty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faculty);
		}
		catch (NoSuchFacultyException nsee) {
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
	protected Faculty removeImpl(Faculty faculty) throws SystemException {
		faculty = toUnwrappedModel(faculty);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(faculty)) {
				faculty = (Faculty)session.get(FacultyImpl.class,
						faculty.getPrimaryKeyObj());
			}

			if (faculty != null) {
				session.delete(faculty);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (faculty != null) {
			clearCache(faculty);
		}

		return faculty;
	}

	@Override
	public Faculty updateImpl(com.idetronic.eis.model.Faculty faculty)
		throws SystemException {
		faculty = toUnwrappedModel(faculty);

		boolean isNew = faculty.isNew();

		Session session = null;

		try {
			session = openSession();

			if (faculty.isNew()) {
				session.save(faculty);

				faculty.setNew(false);
			}
			else {
				session.merge(faculty);
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

		EntityCacheUtil.putResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
			FacultyImpl.class, faculty.getPrimaryKey(), faculty);

		return faculty;
	}

	protected Faculty toUnwrappedModel(Faculty faculty) {
		if (faculty instanceof FacultyImpl) {
			return faculty;
		}

		FacultyImpl facultyImpl = new FacultyImpl();

		facultyImpl.setNew(faculty.isNew());
		facultyImpl.setPrimaryKey(faculty.getPrimaryKey());

		facultyImpl.setFacultyId(faculty.getFacultyId());
		facultyImpl.setFacultyTypeId(faculty.getFacultyTypeId());
		facultyImpl.setFacultyName(faculty.getFacultyName());

		return facultyImpl;
	}

	/**
	 * Returns the faculty with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty
	 * @return the faculty
	 * @throws com.idetronic.eis.NoSuchFacultyException if a faculty with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Faculty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyException, SystemException {
		Faculty faculty = fetchByPrimaryKey(primaryKey);

		if (faculty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return faculty;
	}

	/**
	 * Returns the faculty with the primary key or throws a {@link com.idetronic.eis.NoSuchFacultyException} if it could not be found.
	 *
	 * @param facultyId the primary key of the faculty
	 * @return the faculty
	 * @throws com.idetronic.eis.NoSuchFacultyException if a faculty with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Faculty findByPrimaryKey(long facultyId)
		throws NoSuchFacultyException, SystemException {
		return findByPrimaryKey((Serializable)facultyId);
	}

	/**
	 * Returns the faculty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty
	 * @return the faculty, or <code>null</code> if a faculty with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Faculty fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Faculty faculty = (Faculty)EntityCacheUtil.getResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
				FacultyImpl.class, primaryKey);

		if (faculty == _nullFaculty) {
			return null;
		}

		if (faculty == null) {
			Session session = null;

			try {
				session = openSession();

				faculty = (Faculty)session.get(FacultyImpl.class, primaryKey);

				if (faculty != null) {
					cacheResult(faculty);
				}
				else {
					EntityCacheUtil.putResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
						FacultyImpl.class, primaryKey, _nullFaculty);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FacultyModelImpl.ENTITY_CACHE_ENABLED,
					FacultyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return faculty;
	}

	/**
	 * Returns the faculty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyId the primary key of the faculty
	 * @return the faculty, or <code>null</code> if a faculty with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Faculty fetchByPrimaryKey(long facultyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)facultyId);
	}

	/**
	 * Returns all the faculties.
	 *
	 * @return the faculties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Faculty> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculties
	 * @param end the upper bound of the range of faculties (not inclusive)
	 * @return the range of faculties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Faculty> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FacultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculties
	 * @param end the upper bound of the range of faculties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Faculty> findAll(int start, int end,
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

		List<Faculty> list = (List<Faculty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACULTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTY;

				if (pagination) {
					sql = sql.concat(FacultyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Faculty>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Faculty>(list);
				}
				else {
					list = (List<Faculty>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the faculties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Faculty faculty : findAll()) {
			remove(faculty);
		}
	}

	/**
	 * Returns the number of faculties.
	 *
	 * @return the number of faculties
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

				Query q = session.createQuery(_SQL_COUNT_FACULTY);

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
	 * Initializes the faculty persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.Faculty")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Faculty>> listenersList = new ArrayList<ModelListener<Faculty>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Faculty>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FacultyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACULTY = "SELECT faculty FROM Faculty faculty";
	private static final String _SQL_COUNT_FACULTY = "SELECT COUNT(faculty) FROM Faculty faculty";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faculty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Faculty exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FacultyPersistenceImpl.class);
	private static Faculty _nullFaculty = new FacultyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Faculty> toCacheModel() {
				return _nullFacultyCacheModel;
			}
		};

	private static CacheModel<Faculty> _nullFacultyCacheModel = new CacheModel<Faculty>() {
			@Override
			public Faculty toEntityModel() {
				return _nullFaculty;
			}
		};
}
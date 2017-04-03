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

import com.idetronic.eis.NoSuchLibrarySeatingDepartmentException;
import com.idetronic.eis.model.LibrarySeatingDepartment;
import com.idetronic.eis.model.impl.LibrarySeatingDepartmentImpl;
import com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the library seating department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibrarySeatingDepartmentPersistence
 * @see LibrarySeatingDepartmentUtil
 * @generated
 */
public class LibrarySeatingDepartmentPersistenceImpl extends BasePersistenceImpl<LibrarySeatingDepartment>
	implements LibrarySeatingDepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LibrarySeatingDepartmentUtil} to access the library seating department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LibrarySeatingDepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentModelImpl.FINDER_CACHE_ENABLED,
			LibrarySeatingDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentModelImpl.FINDER_CACHE_ENABLED,
			LibrarySeatingDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT = new FinderPath(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentModelImpl.FINDER_CACHE_ENABLED,
			LibrarySeatingDepartmentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLibraryDepartment",
			new String[] { Long.class.getName(), Long.class.getName() },
			LibrarySeatingDepartmentModelImpl.LIBRARYID_COLUMN_BITMASK |
			LibrarySeatingDepartmentModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT = new FinderPath(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLibraryDepartment",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the library seating department where libraryId = &#63; and departmentId = &#63; or throws a {@link com.idetronic.eis.NoSuchLibrarySeatingDepartmentException} if it could not be found.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @return the matching library seating department
	 * @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a matching library seating department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment findByLibraryDepartment(long libraryId,
		long departmentId)
		throws NoSuchLibrarySeatingDepartmentException, SystemException {
		LibrarySeatingDepartment librarySeatingDepartment = fetchByLibraryDepartment(libraryId,
				departmentId);

		if (librarySeatingDepartment == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("libraryId=");
			msg.append(libraryId);

			msg.append(", departmentId=");
			msg.append(departmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLibrarySeatingDepartmentException(msg.toString());
		}

		return librarySeatingDepartment;
	}

	/**
	 * Returns the library seating department where libraryId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @return the matching library seating department, or <code>null</code> if a matching library seating department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment fetchByLibraryDepartment(long libraryId,
		long departmentId) throws SystemException {
		return fetchByLibraryDepartment(libraryId, departmentId, true);
	}

	/**
	 * Returns the library seating department where libraryId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching library seating department, or <code>null</code> if a matching library seating department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment fetchByLibraryDepartment(long libraryId,
		long departmentId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { libraryId, departmentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
					finderArgs, this);
		}

		if (result instanceof LibrarySeatingDepartment) {
			LibrarySeatingDepartment librarySeatingDepartment = (LibrarySeatingDepartment)result;

			if ((libraryId != librarySeatingDepartment.getLibraryId()) ||
					(departmentId != librarySeatingDepartment.getDepartmentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LIBRARYSEATINGDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(departmentId);

				List<LibrarySeatingDepartment> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
						finderArgs, list);
				}
				else {
					LibrarySeatingDepartment librarySeatingDepartment = list.get(0);

					result = librarySeatingDepartment;

					cacheResult(librarySeatingDepartment);

					if ((librarySeatingDepartment.getLibraryId() != libraryId) ||
							(librarySeatingDepartment.getDepartmentId() != departmentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
							finderArgs, librarySeatingDepartment);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LibrarySeatingDepartment)result;
		}
	}

	/**
	 * Removes the library seating department where libraryId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @return the library seating department that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment removeByLibraryDepartment(long libraryId,
		long departmentId)
		throws NoSuchLibrarySeatingDepartmentException, SystemException {
		LibrarySeatingDepartment librarySeatingDepartment = findByLibraryDepartment(libraryId,
				departmentId);

		return remove(librarySeatingDepartment);
	}

	/**
	 * Returns the number of library seating departments where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @return the number of matching library seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibraryDepartment(long libraryId, long departmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT;

		Object[] finderArgs = new Object[] { libraryId, departmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LIBRARYSEATINGDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(departmentId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2 = "librarySeatingDepartment.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2 = "librarySeatingDepartment.departmentId = ?";

	public LibrarySeatingDepartmentPersistenceImpl() {
		setModelClass(LibrarySeatingDepartment.class);
	}

	/**
	 * Caches the library seating department in the entity cache if it is enabled.
	 *
	 * @param librarySeatingDepartment the library seating department
	 */
	@Override
	public void cacheResult(LibrarySeatingDepartment librarySeatingDepartment) {
		EntityCacheUtil.putResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentImpl.class,
			librarySeatingDepartment.getPrimaryKey(), librarySeatingDepartment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
			new Object[] {
				librarySeatingDepartment.getLibraryId(),
				librarySeatingDepartment.getDepartmentId()
			}, librarySeatingDepartment);

		librarySeatingDepartment.resetOriginalValues();
	}

	/**
	 * Caches the library seating departments in the entity cache if it is enabled.
	 *
	 * @param librarySeatingDepartments the library seating departments
	 */
	@Override
	public void cacheResult(
		List<LibrarySeatingDepartment> librarySeatingDepartments) {
		for (LibrarySeatingDepartment librarySeatingDepartment : librarySeatingDepartments) {
			if (EntityCacheUtil.getResult(
						LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						LibrarySeatingDepartmentImpl.class,
						librarySeatingDepartment.getPrimaryKey()) == null) {
				cacheResult(librarySeatingDepartment);
			}
			else {
				librarySeatingDepartment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all library seating departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LibrarySeatingDepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LibrarySeatingDepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library seating department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LibrarySeatingDepartment librarySeatingDepartment) {
		EntityCacheUtil.removeResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentImpl.class,
			librarySeatingDepartment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(librarySeatingDepartment);
	}

	@Override
	public void clearCache(
		List<LibrarySeatingDepartment> librarySeatingDepartments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LibrarySeatingDepartment librarySeatingDepartment : librarySeatingDepartments) {
			EntityCacheUtil.removeResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				LibrarySeatingDepartmentImpl.class,
				librarySeatingDepartment.getPrimaryKey());

			clearUniqueFindersCache(librarySeatingDepartment);
		}
	}

	protected void cacheUniqueFindersCache(
		LibrarySeatingDepartment librarySeatingDepartment) {
		if (librarySeatingDepartment.isNew()) {
			Object[] args = new Object[] {
					librarySeatingDepartment.getLibraryId(),
					librarySeatingDepartment.getDepartmentId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
				args, librarySeatingDepartment);
		}
		else {
			LibrarySeatingDepartmentModelImpl librarySeatingDepartmentModelImpl = (LibrarySeatingDepartmentModelImpl)librarySeatingDepartment;

			if ((librarySeatingDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						librarySeatingDepartment.getLibraryId(),
						librarySeatingDepartment.getDepartmentId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
					args, librarySeatingDepartment);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LibrarySeatingDepartment librarySeatingDepartment) {
		LibrarySeatingDepartmentModelImpl librarySeatingDepartmentModelImpl = (LibrarySeatingDepartmentModelImpl)librarySeatingDepartment;

		Object[] args = new Object[] {
				librarySeatingDepartment.getLibraryId(),
				librarySeatingDepartment.getDepartmentId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
			args);

		if ((librarySeatingDepartmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT.getColumnBitmask()) != 0) {
			args = new Object[] {
					librarySeatingDepartmentModelImpl.getOriginalLibraryId(),
					librarySeatingDepartmentModelImpl.getOriginalDepartmentId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIBRARYDEPARTMENT,
				args);
		}
	}

	/**
	 * Creates a new library seating department with the primary key. Does not add the library seating department to the database.
	 *
	 * @param libraryDepartmentId the primary key for the new library seating department
	 * @return the new library seating department
	 */
	@Override
	public LibrarySeatingDepartment create(long libraryDepartmentId) {
		LibrarySeatingDepartment librarySeatingDepartment = new LibrarySeatingDepartmentImpl();

		librarySeatingDepartment.setNew(true);
		librarySeatingDepartment.setPrimaryKey(libraryDepartmentId);

		return librarySeatingDepartment;
	}

	/**
	 * Removes the library seating department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libraryDepartmentId the primary key of the library seating department
	 * @return the library seating department that was removed
	 * @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a library seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment remove(long libraryDepartmentId)
		throws NoSuchLibrarySeatingDepartmentException, SystemException {
		return remove((Serializable)libraryDepartmentId);
	}

	/**
	 * Removes the library seating department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library seating department
	 * @return the library seating department that was removed
	 * @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a library seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment remove(Serializable primaryKey)
		throws NoSuchLibrarySeatingDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LibrarySeatingDepartment librarySeatingDepartment = (LibrarySeatingDepartment)session.get(LibrarySeatingDepartmentImpl.class,
					primaryKey);

			if (librarySeatingDepartment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibrarySeatingDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(librarySeatingDepartment);
		}
		catch (NoSuchLibrarySeatingDepartmentException nsee) {
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
	protected LibrarySeatingDepartment removeImpl(
		LibrarySeatingDepartment librarySeatingDepartment)
		throws SystemException {
		librarySeatingDepartment = toUnwrappedModel(librarySeatingDepartment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(librarySeatingDepartment)) {
				librarySeatingDepartment = (LibrarySeatingDepartment)session.get(LibrarySeatingDepartmentImpl.class,
						librarySeatingDepartment.getPrimaryKeyObj());
			}

			if (librarySeatingDepartment != null) {
				session.delete(librarySeatingDepartment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (librarySeatingDepartment != null) {
			clearCache(librarySeatingDepartment);
		}

		return librarySeatingDepartment;
	}

	@Override
	public LibrarySeatingDepartment updateImpl(
		com.idetronic.eis.model.LibrarySeatingDepartment librarySeatingDepartment)
		throws SystemException {
		librarySeatingDepartment = toUnwrappedModel(librarySeatingDepartment);

		boolean isNew = librarySeatingDepartment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (librarySeatingDepartment.isNew()) {
				session.save(librarySeatingDepartment);

				librarySeatingDepartment.setNew(false);
			}
			else {
				session.merge(librarySeatingDepartment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LibrarySeatingDepartmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			LibrarySeatingDepartmentImpl.class,
			librarySeatingDepartment.getPrimaryKey(), librarySeatingDepartment);

		clearUniqueFindersCache(librarySeatingDepartment);
		cacheUniqueFindersCache(librarySeatingDepartment);

		return librarySeatingDepartment;
	}

	protected LibrarySeatingDepartment toUnwrappedModel(
		LibrarySeatingDepartment librarySeatingDepartment) {
		if (librarySeatingDepartment instanceof LibrarySeatingDepartmentImpl) {
			return librarySeatingDepartment;
		}

		LibrarySeatingDepartmentImpl librarySeatingDepartmentImpl = new LibrarySeatingDepartmentImpl();

		librarySeatingDepartmentImpl.setNew(librarySeatingDepartment.isNew());
		librarySeatingDepartmentImpl.setPrimaryKey(librarySeatingDepartment.getPrimaryKey());

		librarySeatingDepartmentImpl.setLibraryDepartmentId(librarySeatingDepartment.getLibraryDepartmentId());
		librarySeatingDepartmentImpl.setLibraryId(librarySeatingDepartment.getLibraryId());
		librarySeatingDepartmentImpl.setDepartmentId(librarySeatingDepartment.getDepartmentId());
		librarySeatingDepartmentImpl.setCompanyId(librarySeatingDepartment.getCompanyId());
		librarySeatingDepartmentImpl.setGroupId(librarySeatingDepartment.getGroupId());
		librarySeatingDepartmentImpl.setUserId(librarySeatingDepartment.getUserId());
		librarySeatingDepartmentImpl.setUserName(librarySeatingDepartment.getUserName());
		librarySeatingDepartmentImpl.setCreateDate(librarySeatingDepartment.getCreateDate());
		librarySeatingDepartmentImpl.setModifiedDate(librarySeatingDepartment.getModifiedDate());

		return librarySeatingDepartmentImpl;
	}

	/**
	 * Returns the library seating department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the library seating department
	 * @return the library seating department
	 * @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a library seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLibrarySeatingDepartmentException, SystemException {
		LibrarySeatingDepartment librarySeatingDepartment = fetchByPrimaryKey(primaryKey);

		if (librarySeatingDepartment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLibrarySeatingDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return librarySeatingDepartment;
	}

	/**
	 * Returns the library seating department with the primary key or throws a {@link com.idetronic.eis.NoSuchLibrarySeatingDepartmentException} if it could not be found.
	 *
	 * @param libraryDepartmentId the primary key of the library seating department
	 * @return the library seating department
	 * @throws com.idetronic.eis.NoSuchLibrarySeatingDepartmentException if a library seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment findByPrimaryKey(long libraryDepartmentId)
		throws NoSuchLibrarySeatingDepartmentException, SystemException {
		return findByPrimaryKey((Serializable)libraryDepartmentId);
	}

	/**
	 * Returns the library seating department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library seating department
	 * @return the library seating department, or <code>null</code> if a library seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LibrarySeatingDepartment librarySeatingDepartment = (LibrarySeatingDepartment)EntityCacheUtil.getResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				LibrarySeatingDepartmentImpl.class, primaryKey);

		if (librarySeatingDepartment == _nullLibrarySeatingDepartment) {
			return null;
		}

		if (librarySeatingDepartment == null) {
			Session session = null;

			try {
				session = openSession();

				librarySeatingDepartment = (LibrarySeatingDepartment)session.get(LibrarySeatingDepartmentImpl.class,
						primaryKey);

				if (librarySeatingDepartment != null) {
					cacheResult(librarySeatingDepartment);
				}
				else {
					EntityCacheUtil.putResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						LibrarySeatingDepartmentImpl.class, primaryKey,
						_nullLibrarySeatingDepartment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LibrarySeatingDepartmentModelImpl.ENTITY_CACHE_ENABLED,
					LibrarySeatingDepartmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return librarySeatingDepartment;
	}

	/**
	 * Returns the library seating department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libraryDepartmentId the primary key of the library seating department
	 * @return the library seating department, or <code>null</code> if a library seating department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibrarySeatingDepartment fetchByPrimaryKey(long libraryDepartmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)libraryDepartmentId);
	}

	/**
	 * Returns all the library seating departments.
	 *
	 * @return the library seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LibrarySeatingDepartment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the library seating departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of library seating departments
	 * @param end the upper bound of the range of library seating departments (not inclusive)
	 * @return the range of library seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LibrarySeatingDepartment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the library seating departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibrarySeatingDepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of library seating departments
	 * @param end the upper bound of the range of library seating departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of library seating departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LibrarySeatingDepartment> findAll(int start, int end,
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

		List<LibrarySeatingDepartment> list = (List<LibrarySeatingDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LIBRARYSEATINGDEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARYSEATINGDEPARTMENT;

				if (pagination) {
					sql = sql.concat(LibrarySeatingDepartmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LibrarySeatingDepartment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LibrarySeatingDepartment>(list);
				}
				else {
					list = (List<LibrarySeatingDepartment>)QueryUtil.list(q,
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
	 * Removes all the library seating departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LibrarySeatingDepartment librarySeatingDepartment : findAll()) {
			remove(librarySeatingDepartment);
		}
	}

	/**
	 * Returns the number of library seating departments.
	 *
	 * @return the number of library seating departments
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

				Query q = session.createQuery(_SQL_COUNT_LIBRARYSEATINGDEPARTMENT);

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
	 * Initializes the library seating department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.LibrarySeatingDepartment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LibrarySeatingDepartment>> listenersList = new ArrayList<ModelListener<LibrarySeatingDepartment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LibrarySeatingDepartment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LibrarySeatingDepartmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LIBRARYSEATINGDEPARTMENT = "SELECT librarySeatingDepartment FROM LibrarySeatingDepartment librarySeatingDepartment";
	private static final String _SQL_SELECT_LIBRARYSEATINGDEPARTMENT_WHERE = "SELECT librarySeatingDepartment FROM LibrarySeatingDepartment librarySeatingDepartment WHERE ";
	private static final String _SQL_COUNT_LIBRARYSEATINGDEPARTMENT = "SELECT COUNT(librarySeatingDepartment) FROM LibrarySeatingDepartment librarySeatingDepartment";
	private static final String _SQL_COUNT_LIBRARYSEATINGDEPARTMENT_WHERE = "SELECT COUNT(librarySeatingDepartment) FROM LibrarySeatingDepartment librarySeatingDepartment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "librarySeatingDepartment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LibrarySeatingDepartment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LibrarySeatingDepartment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LibrarySeatingDepartmentPersistenceImpl.class);
	private static LibrarySeatingDepartment _nullLibrarySeatingDepartment = new LibrarySeatingDepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LibrarySeatingDepartment> toCacheModel() {
				return _nullLibrarySeatingDepartmentCacheModel;
			}
		};

	private static CacheModel<LibrarySeatingDepartment> _nullLibrarySeatingDepartmentCacheModel =
		new CacheModel<LibrarySeatingDepartment>() {
			@Override
			public LibrarySeatingDepartment toEntityModel() {
				return _nullLibrarySeatingDepartment;
			}
		};
}
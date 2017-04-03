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

import com.idetronic.eis.NoSuchLibraryTypeException;
import com.idetronic.eis.model.LibraryType;
import com.idetronic.eis.model.impl.LibraryTypeImpl;
import com.idetronic.eis.model.impl.LibraryTypeModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the library type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LibraryTypePersistence
 * @see LibraryTypeUtil
 * @generated
 */
public class LibraryTypePersistenceImpl extends BasePersistenceImpl<LibraryType>
	implements LibraryTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LibraryTypeUtil} to access the library type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LibraryTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeModelImpl.FINDER_CACHE_ENABLED, LibraryTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeModelImpl.FINDER_CACHE_ENABLED, LibraryTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeModelImpl.FINDER_CACHE_ENABLED, LibraryTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			LibraryTypeModelImpl.LIBRARYTYPECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the library type where libraryTypeCode = &#63; or throws a {@link com.idetronic.eis.NoSuchLibraryTypeException} if it could not be found.
	 *
	 * @param libraryTypeCode the library type code
	 * @return the matching library type
	 * @throws com.idetronic.eis.NoSuchLibraryTypeException if a matching library type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType findByCode(String libraryTypeCode)
		throws NoSuchLibraryTypeException, SystemException {
		LibraryType libraryType = fetchByCode(libraryTypeCode);

		if (libraryType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("libraryTypeCode=");
			msg.append(libraryTypeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLibraryTypeException(msg.toString());
		}

		return libraryType;
	}

	/**
	 * Returns the library type where libraryTypeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param libraryTypeCode the library type code
	 * @return the matching library type, or <code>null</code> if a matching library type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType fetchByCode(String libraryTypeCode)
		throws SystemException {
		return fetchByCode(libraryTypeCode, true);
	}

	/**
	 * Returns the library type where libraryTypeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param libraryTypeCode the library type code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching library type, or <code>null</code> if a matching library type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType fetchByCode(String libraryTypeCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { libraryTypeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof LibraryType) {
			LibraryType libraryType = (LibraryType)result;

			if (!Validator.equals(libraryTypeCode,
						libraryType.getLibraryTypeCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LIBRARYTYPE_WHERE);

			boolean bindLibraryTypeCode = false;

			if (libraryTypeCode == null) {
				query.append(_FINDER_COLUMN_CODE_LIBRARYTYPECODE_1);
			}
			else if (libraryTypeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_LIBRARYTYPECODE_3);
			}
			else {
				bindLibraryTypeCode = true;

				query.append(_FINDER_COLUMN_CODE_LIBRARYTYPECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLibraryTypeCode) {
					qPos.add(libraryTypeCode);
				}

				List<LibraryType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					LibraryType libraryType = list.get(0);

					result = libraryType;

					cacheResult(libraryType);

					if ((libraryType.getLibraryTypeCode() == null) ||
							!libraryType.getLibraryTypeCode()
											.equals(libraryTypeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, libraryType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
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
			return (LibraryType)result;
		}
	}

	/**
	 * Removes the library type where libraryTypeCode = &#63; from the database.
	 *
	 * @param libraryTypeCode the library type code
	 * @return the library type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType removeByCode(String libraryTypeCode)
		throws NoSuchLibraryTypeException, SystemException {
		LibraryType libraryType = findByCode(libraryTypeCode);

		return remove(libraryType);
	}

	/**
	 * Returns the number of library types where libraryTypeCode = &#63;.
	 *
	 * @param libraryTypeCode the library type code
	 * @return the number of matching library types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String libraryTypeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { libraryTypeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LIBRARYTYPE_WHERE);

			boolean bindLibraryTypeCode = false;

			if (libraryTypeCode == null) {
				query.append(_FINDER_COLUMN_CODE_LIBRARYTYPECODE_1);
			}
			else if (libraryTypeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_LIBRARYTYPECODE_3);
			}
			else {
				bindLibraryTypeCode = true;

				query.append(_FINDER_COLUMN_CODE_LIBRARYTYPECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLibraryTypeCode) {
					qPos.add(libraryTypeCode);
				}

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

	private static final String _FINDER_COLUMN_CODE_LIBRARYTYPECODE_1 = "libraryType.libraryTypeCode IS NULL";
	private static final String _FINDER_COLUMN_CODE_LIBRARYTYPECODE_2 = "libraryType.libraryTypeCode = ?";
	private static final String _FINDER_COLUMN_CODE_LIBRARYTYPECODE_3 = "(libraryType.libraryTypeCode IS NULL OR libraryType.libraryTypeCode = '')";

	public LibraryTypePersistenceImpl() {
		setModelClass(LibraryType.class);
	}

	/**
	 * Caches the library type in the entity cache if it is enabled.
	 *
	 * @param libraryType the library type
	 */
	@Override
	public void cacheResult(LibraryType libraryType) {
		EntityCacheUtil.putResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeImpl.class, libraryType.getPrimaryKey(), libraryType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { libraryType.getLibraryTypeCode() }, libraryType);

		libraryType.resetOriginalValues();
	}

	/**
	 * Caches the library types in the entity cache if it is enabled.
	 *
	 * @param libraryTypes the library types
	 */
	@Override
	public void cacheResult(List<LibraryType> libraryTypes) {
		for (LibraryType libraryType : libraryTypes) {
			if (EntityCacheUtil.getResult(
						LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
						LibraryTypeImpl.class, libraryType.getPrimaryKey()) == null) {
				cacheResult(libraryType);
			}
			else {
				libraryType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all library types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LibraryTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LibraryTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LibraryType libraryType) {
		EntityCacheUtil.removeResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeImpl.class, libraryType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(libraryType);
	}

	@Override
	public void clearCache(List<LibraryType> libraryTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LibraryType libraryType : libraryTypes) {
			EntityCacheUtil.removeResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
				LibraryTypeImpl.class, libraryType.getPrimaryKey());

			clearUniqueFindersCache(libraryType);
		}
	}

	protected void cacheUniqueFindersCache(LibraryType libraryType) {
		if (libraryType.isNew()) {
			Object[] args = new Object[] { libraryType.getLibraryTypeCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				libraryType);
		}
		else {
			LibraryTypeModelImpl libraryTypeModelImpl = (LibraryTypeModelImpl)libraryType;

			if ((libraryTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { libraryType.getLibraryTypeCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					libraryType);
			}
		}
	}

	protected void clearUniqueFindersCache(LibraryType libraryType) {
		LibraryTypeModelImpl libraryTypeModelImpl = (LibraryTypeModelImpl)libraryType;

		Object[] args = new Object[] { libraryType.getLibraryTypeCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((libraryTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					libraryTypeModelImpl.getOriginalLibraryTypeCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new library type with the primary key. Does not add the library type to the database.
	 *
	 * @param libraryTypeId the primary key for the new library type
	 * @return the new library type
	 */
	@Override
	public LibraryType create(long libraryTypeId) {
		LibraryType libraryType = new LibraryTypeImpl();

		libraryType.setNew(true);
		libraryType.setPrimaryKey(libraryTypeId);

		return libraryType;
	}

	/**
	 * Removes the library type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libraryTypeId the primary key of the library type
	 * @return the library type that was removed
	 * @throws com.idetronic.eis.NoSuchLibraryTypeException if a library type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType remove(long libraryTypeId)
		throws NoSuchLibraryTypeException, SystemException {
		return remove((Serializable)libraryTypeId);
	}

	/**
	 * Removes the library type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library type
	 * @return the library type that was removed
	 * @throws com.idetronic.eis.NoSuchLibraryTypeException if a library type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType remove(Serializable primaryKey)
		throws NoSuchLibraryTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LibraryType libraryType = (LibraryType)session.get(LibraryTypeImpl.class,
					primaryKey);

			if (libraryType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibraryTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(libraryType);
		}
		catch (NoSuchLibraryTypeException nsee) {
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
	protected LibraryType removeImpl(LibraryType libraryType)
		throws SystemException {
		libraryType = toUnwrappedModel(libraryType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(libraryType)) {
				libraryType = (LibraryType)session.get(LibraryTypeImpl.class,
						libraryType.getPrimaryKeyObj());
			}

			if (libraryType != null) {
				session.delete(libraryType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (libraryType != null) {
			clearCache(libraryType);
		}

		return libraryType;
	}

	@Override
	public LibraryType updateImpl(
		com.idetronic.eis.model.LibraryType libraryType)
		throws SystemException {
		libraryType = toUnwrappedModel(libraryType);

		boolean isNew = libraryType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (libraryType.isNew()) {
				session.save(libraryType);

				libraryType.setNew(false);
			}
			else {
				session.merge(libraryType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LibraryTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
			LibraryTypeImpl.class, libraryType.getPrimaryKey(), libraryType);

		clearUniqueFindersCache(libraryType);
		cacheUniqueFindersCache(libraryType);

		return libraryType;
	}

	protected LibraryType toUnwrappedModel(LibraryType libraryType) {
		if (libraryType instanceof LibraryTypeImpl) {
			return libraryType;
		}

		LibraryTypeImpl libraryTypeImpl = new LibraryTypeImpl();

		libraryTypeImpl.setNew(libraryType.isNew());
		libraryTypeImpl.setPrimaryKey(libraryType.getPrimaryKey());

		libraryTypeImpl.setLibraryTypeId(libraryType.getLibraryTypeId());
		libraryTypeImpl.setLibraryTypeCode(libraryType.getLibraryTypeCode());
		libraryTypeImpl.setLibraryTypeName(libraryType.getLibraryTypeName());

		return libraryTypeImpl;
	}

	/**
	 * Returns the library type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the library type
	 * @return the library type
	 * @throws com.idetronic.eis.NoSuchLibraryTypeException if a library type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLibraryTypeException, SystemException {
		LibraryType libraryType = fetchByPrimaryKey(primaryKey);

		if (libraryType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLibraryTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return libraryType;
	}

	/**
	 * Returns the library type with the primary key or throws a {@link com.idetronic.eis.NoSuchLibraryTypeException} if it could not be found.
	 *
	 * @param libraryTypeId the primary key of the library type
	 * @return the library type
	 * @throws com.idetronic.eis.NoSuchLibraryTypeException if a library type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType findByPrimaryKey(long libraryTypeId)
		throws NoSuchLibraryTypeException, SystemException {
		return findByPrimaryKey((Serializable)libraryTypeId);
	}

	/**
	 * Returns the library type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library type
	 * @return the library type, or <code>null</code> if a library type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LibraryType libraryType = (LibraryType)EntityCacheUtil.getResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
				LibraryTypeImpl.class, primaryKey);

		if (libraryType == _nullLibraryType) {
			return null;
		}

		if (libraryType == null) {
			Session session = null;

			try {
				session = openSession();

				libraryType = (LibraryType)session.get(LibraryTypeImpl.class,
						primaryKey);

				if (libraryType != null) {
					cacheResult(libraryType);
				}
				else {
					EntityCacheUtil.putResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
						LibraryTypeImpl.class, primaryKey, _nullLibraryType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LibraryTypeModelImpl.ENTITY_CACHE_ENABLED,
					LibraryTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return libraryType;
	}

	/**
	 * Returns the library type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libraryTypeId the primary key of the library type
	 * @return the library type, or <code>null</code> if a library type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LibraryType fetchByPrimaryKey(long libraryTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)libraryTypeId);
	}

	/**
	 * Returns all the library types.
	 *
	 * @return the library types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LibraryType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the library types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of library types
	 * @param end the upper bound of the range of library types (not inclusive)
	 * @return the range of library types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LibraryType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the library types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of library types
	 * @param end the upper bound of the range of library types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of library types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LibraryType> findAll(int start, int end,
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

		List<LibraryType> list = (List<LibraryType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LIBRARYTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARYTYPE;

				if (pagination) {
					sql = sql.concat(LibraryTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LibraryType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LibraryType>(list);
				}
				else {
					list = (List<LibraryType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the library types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LibraryType libraryType : findAll()) {
			remove(libraryType);
		}
	}

	/**
	 * Returns the number of library types.
	 *
	 * @return the number of library types
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

				Query q = session.createQuery(_SQL_COUNT_LIBRARYTYPE);

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
	 * Initializes the library type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.LibraryType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LibraryType>> listenersList = new ArrayList<ModelListener<LibraryType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LibraryType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LibraryTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LIBRARYTYPE = "SELECT libraryType FROM LibraryType libraryType";
	private static final String _SQL_SELECT_LIBRARYTYPE_WHERE = "SELECT libraryType FROM LibraryType libraryType WHERE ";
	private static final String _SQL_COUNT_LIBRARYTYPE = "SELECT COUNT(libraryType) FROM LibraryType libraryType";
	private static final String _SQL_COUNT_LIBRARYTYPE_WHERE = "SELECT COUNT(libraryType) FROM LibraryType libraryType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "libraryType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LibraryType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LibraryType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LibraryTypePersistenceImpl.class);
	private static LibraryType _nullLibraryType = new LibraryTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LibraryType> toCacheModel() {
				return _nullLibraryTypeCacheModel;
			}
		};

	private static CacheModel<LibraryType> _nullLibraryTypeCacheModel = new CacheModel<LibraryType>() {
			@Override
			public LibraryType toEntityModel() {
				return _nullLibraryType;
			}
		};
}
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

package com.idetronic.portlet.service.persistence;

import com.idetronic.portlet.NoSuchUserImportLogException;
import com.idetronic.portlet.model.UserImportLog;
import com.idetronic.portlet.model.impl.UserImportLogImpl;
import com.idetronic.portlet.model.impl.UserImportLogModelImpl;

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
 * The persistence implementation for the user import log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserImportLogPersistence
 * @see UserImportLogUtil
 * @generated
 */
public class UserImportLogPersistenceImpl extends BasePersistenceImpl<UserImportLog>
	implements UserImportLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserImportLogUtil} to access the user import log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserImportLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
			UserImportLogModelImpl.FINDER_CACHE_ENABLED,
			UserImportLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
			UserImportLogModelImpl.FINDER_CACHE_ENABLED,
			UserImportLogImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
			UserImportLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UserImportLogPersistenceImpl() {
		setModelClass(UserImportLog.class);
	}

	/**
	 * Caches the user import log in the entity cache if it is enabled.
	 *
	 * @param userImportLog the user import log
	 */
	@Override
	public void cacheResult(UserImportLog userImportLog) {
		EntityCacheUtil.putResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
			UserImportLogImpl.class, userImportLog.getPrimaryKey(),
			userImportLog);

		userImportLog.resetOriginalValues();
	}

	/**
	 * Caches the user import logs in the entity cache if it is enabled.
	 *
	 * @param userImportLogs the user import logs
	 */
	@Override
	public void cacheResult(List<UserImportLog> userImportLogs) {
		for (UserImportLog userImportLog : userImportLogs) {
			if (EntityCacheUtil.getResult(
						UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
						UserImportLogImpl.class, userImportLog.getPrimaryKey()) == null) {
				cacheResult(userImportLog);
			}
			else {
				userImportLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user import logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserImportLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserImportLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user import log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserImportLog userImportLog) {
		EntityCacheUtil.removeResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
			UserImportLogImpl.class, userImportLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserImportLog> userImportLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserImportLog userImportLog : userImportLogs) {
			EntityCacheUtil.removeResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
				UserImportLogImpl.class, userImportLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user import log with the primary key. Does not add the user import log to the database.
	 *
	 * @param entryId the primary key for the new user import log
	 * @return the new user import log
	 */
	@Override
	public UserImportLog create(long entryId) {
		UserImportLog userImportLog = new UserImportLogImpl();

		userImportLog.setNew(true);
		userImportLog.setPrimaryKey(entryId);

		return userImportLog;
	}

	/**
	 * Removes the user import log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the user import log
	 * @return the user import log that was removed
	 * @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserImportLog remove(long entryId)
		throws NoSuchUserImportLogException, SystemException {
		return remove((Serializable)entryId);
	}

	/**
	 * Removes the user import log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user import log
	 * @return the user import log that was removed
	 * @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserImportLog remove(Serializable primaryKey)
		throws NoSuchUserImportLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserImportLog userImportLog = (UserImportLog)session.get(UserImportLogImpl.class,
					primaryKey);

			if (userImportLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserImportLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userImportLog);
		}
		catch (NoSuchUserImportLogException nsee) {
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
	protected UserImportLog removeImpl(UserImportLog userImportLog)
		throws SystemException {
		userImportLog = toUnwrappedModel(userImportLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userImportLog)) {
				userImportLog = (UserImportLog)session.get(UserImportLogImpl.class,
						userImportLog.getPrimaryKeyObj());
			}

			if (userImportLog != null) {
				session.delete(userImportLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userImportLog != null) {
			clearCache(userImportLog);
		}

		return userImportLog;
	}

	@Override
	public UserImportLog updateImpl(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws SystemException {
		userImportLog = toUnwrappedModel(userImportLog);

		boolean isNew = userImportLog.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userImportLog.isNew()) {
				session.save(userImportLog);

				userImportLog.setNew(false);
			}
			else {
				session.merge(userImportLog);
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

		EntityCacheUtil.putResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
			UserImportLogImpl.class, userImportLog.getPrimaryKey(),
			userImportLog);

		return userImportLog;
	}

	protected UserImportLog toUnwrappedModel(UserImportLog userImportLog) {
		if (userImportLog instanceof UserImportLogImpl) {
			return userImportLog;
		}

		UserImportLogImpl userImportLogImpl = new UserImportLogImpl();

		userImportLogImpl.setNew(userImportLog.isNew());
		userImportLogImpl.setPrimaryKey(userImportLog.getPrimaryKey());

		userImportLogImpl.setEntryId(userImportLog.getEntryId());
		userImportLogImpl.setStartTime(userImportLog.getStartTime());
		userImportLogImpl.setEndTime(userImportLog.getEndTime());
		userImportLogImpl.setTotalProcess(userImportLog.getTotalProcess());
		userImportLogImpl.setTotalImport(userImportLog.getTotalImport());
		userImportLogImpl.setTotalError(userImportLog.getTotalError());
		userImportLogImpl.setSummary(userImportLog.getSummary());
		userImportLogImpl.setCreateDate(userImportLog.getCreateDate());
		userImportLogImpl.setTotalExisting(userImportLog.getTotalExisting());

		return userImportLogImpl;
	}

	/**
	 * Returns the user import log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user import log
	 * @return the user import log
	 * @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserImportLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserImportLogException, SystemException {
		UserImportLog userImportLog = fetchByPrimaryKey(primaryKey);

		if (userImportLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserImportLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userImportLog;
	}

	/**
	 * Returns the user import log with the primary key or throws a {@link com.idetronic.portlet.NoSuchUserImportLogException} if it could not be found.
	 *
	 * @param entryId the primary key of the user import log
	 * @return the user import log
	 * @throws com.idetronic.portlet.NoSuchUserImportLogException if a user import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserImportLog findByPrimaryKey(long entryId)
		throws NoSuchUserImportLogException, SystemException {
		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the user import log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user import log
	 * @return the user import log, or <code>null</code> if a user import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserImportLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserImportLog userImportLog = (UserImportLog)EntityCacheUtil.getResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
				UserImportLogImpl.class, primaryKey);

		if (userImportLog == _nullUserImportLog) {
			return null;
		}

		if (userImportLog == null) {
			Session session = null;

			try {
				session = openSession();

				userImportLog = (UserImportLog)session.get(UserImportLogImpl.class,
						primaryKey);

				if (userImportLog != null) {
					cacheResult(userImportLog);
				}
				else {
					EntityCacheUtil.putResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
						UserImportLogImpl.class, primaryKey, _nullUserImportLog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserImportLogModelImpl.ENTITY_CACHE_ENABLED,
					UserImportLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userImportLog;
	}

	/**
	 * Returns the user import log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the user import log
	 * @return the user import log, or <code>null</code> if a user import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserImportLog fetchByPrimaryKey(long entryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the user import logs.
	 *
	 * @return the user import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserImportLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user import logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user import logs
	 * @param end the upper bound of the range of user import logs (not inclusive)
	 * @return the range of user import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserImportLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user import logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user import logs
	 * @param end the upper bound of the range of user import logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserImportLog> findAll(int start, int end,
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

		List<UserImportLog> list = (List<UserImportLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERIMPORTLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERIMPORTLOG;

				if (pagination) {
					sql = sql.concat(UserImportLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserImportLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserImportLog>(list);
				}
				else {
					list = (List<UserImportLog>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user import logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserImportLog userImportLog : findAll()) {
			remove(userImportLog);
		}
	}

	/**
	 * Returns the number of user import logs.
	 *
	 * @return the number of user import logs
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

				Query q = session.createQuery(_SQL_COUNT_USERIMPORTLOG);

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
	 * Initializes the user import log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.portlet.model.UserImportLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserImportLog>> listenersList = new ArrayList<ModelListener<UserImportLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserImportLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserImportLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERIMPORTLOG = "SELECT userImportLog FROM UserImportLog userImportLog";
	private static final String _SQL_COUNT_USERIMPORTLOG = "SELECT COUNT(userImportLog) FROM UserImportLog userImportLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userImportLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserImportLog exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserImportLogPersistenceImpl.class);
	private static UserImportLog _nullUserImportLog = new UserImportLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserImportLog> toCacheModel() {
				return _nullUserImportLogCacheModel;
			}
		};

	private static CacheModel<UserImportLog> _nullUserImportLogCacheModel = new CacheModel<UserImportLog>() {
			@Override
			public UserImportLog toEntityModel() {
				return _nullUserImportLog;
			}
		};
}
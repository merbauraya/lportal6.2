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

import com.idetronic.eis.NoSuchFactCustomerComplaintException;
import com.idetronic.eis.model.FactCustomerComplaint;
import com.idetronic.eis.model.impl.FactCustomerComplaintImpl;
import com.idetronic.eis.model.impl.FactCustomerComplaintModelImpl;

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
 * The persistence implementation for the fact customer complaint service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactCustomerComplaintPersistence
 * @see FactCustomerComplaintUtil
 * @generated
 */
public class FactCustomerComplaintPersistenceImpl extends BasePersistenceImpl<FactCustomerComplaint>
	implements FactCustomerComplaintPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactCustomerComplaintUtil} to access the fact customer complaint persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactCustomerComplaintImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
			FactCustomerComplaintModelImpl.FINDER_CACHE_ENABLED,
			FactCustomerComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
			FactCustomerComplaintModelImpl.FINDER_CACHE_ENABLED,
			FactCustomerComplaintImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
			FactCustomerComplaintModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactCustomerComplaintPersistenceImpl() {
		setModelClass(FactCustomerComplaint.class);
	}

	/**
	 * Caches the fact customer complaint in the entity cache if it is enabled.
	 *
	 * @param factCustomerComplaint the fact customer complaint
	 */
	@Override
	public void cacheResult(FactCustomerComplaint factCustomerComplaint) {
		EntityCacheUtil.putResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
			FactCustomerComplaintImpl.class,
			factCustomerComplaint.getPrimaryKey(), factCustomerComplaint);

		factCustomerComplaint.resetOriginalValues();
	}

	/**
	 * Caches the fact customer complaints in the entity cache if it is enabled.
	 *
	 * @param factCustomerComplaints the fact customer complaints
	 */
	@Override
	public void cacheResult(List<FactCustomerComplaint> factCustomerComplaints) {
		for (FactCustomerComplaint factCustomerComplaint : factCustomerComplaints) {
			if (EntityCacheUtil.getResult(
						FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
						FactCustomerComplaintImpl.class,
						factCustomerComplaint.getPrimaryKey()) == null) {
				cacheResult(factCustomerComplaint);
			}
			else {
				factCustomerComplaint.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact customer complaints.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactCustomerComplaintImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactCustomerComplaintImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact customer complaint.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactCustomerComplaint factCustomerComplaint) {
		EntityCacheUtil.removeResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
			FactCustomerComplaintImpl.class,
			factCustomerComplaint.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactCustomerComplaint> factCustomerComplaints) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactCustomerComplaint factCustomerComplaint : factCustomerComplaints) {
			EntityCacheUtil.removeResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
				FactCustomerComplaintImpl.class,
				factCustomerComplaint.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact customer complaint with the primary key. Does not add the fact customer complaint to the database.
	 *
	 * @param factId the primary key for the new fact customer complaint
	 * @return the new fact customer complaint
	 */
	@Override
	public FactCustomerComplaint create(long factId) {
		FactCustomerComplaint factCustomerComplaint = new FactCustomerComplaintImpl();

		factCustomerComplaint.setNew(true);
		factCustomerComplaint.setPrimaryKey(factId);

		return factCustomerComplaint;
	}

	/**
	 * Removes the fact customer complaint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact customer complaint
	 * @return the fact customer complaint that was removed
	 * @throws com.idetronic.eis.NoSuchFactCustomerComplaintException if a fact customer complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactCustomerComplaint remove(long factId)
		throws NoSuchFactCustomerComplaintException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact customer complaint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact customer complaint
	 * @return the fact customer complaint that was removed
	 * @throws com.idetronic.eis.NoSuchFactCustomerComplaintException if a fact customer complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactCustomerComplaint remove(Serializable primaryKey)
		throws NoSuchFactCustomerComplaintException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactCustomerComplaint factCustomerComplaint = (FactCustomerComplaint)session.get(FactCustomerComplaintImpl.class,
					primaryKey);

			if (factCustomerComplaint == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactCustomerComplaintException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factCustomerComplaint);
		}
		catch (NoSuchFactCustomerComplaintException nsee) {
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
	protected FactCustomerComplaint removeImpl(
		FactCustomerComplaint factCustomerComplaint) throws SystemException {
		factCustomerComplaint = toUnwrappedModel(factCustomerComplaint);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factCustomerComplaint)) {
				factCustomerComplaint = (FactCustomerComplaint)session.get(FactCustomerComplaintImpl.class,
						factCustomerComplaint.getPrimaryKeyObj());
			}

			if (factCustomerComplaint != null) {
				session.delete(factCustomerComplaint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factCustomerComplaint != null) {
			clearCache(factCustomerComplaint);
		}

		return factCustomerComplaint;
	}

	@Override
	public FactCustomerComplaint updateImpl(
		com.idetronic.eis.model.FactCustomerComplaint factCustomerComplaint)
		throws SystemException {
		factCustomerComplaint = toUnwrappedModel(factCustomerComplaint);

		boolean isNew = factCustomerComplaint.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factCustomerComplaint.isNew()) {
				session.save(factCustomerComplaint);

				factCustomerComplaint.setNew(false);
			}
			else {
				session.merge(factCustomerComplaint);
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

		EntityCacheUtil.putResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
			FactCustomerComplaintImpl.class,
			factCustomerComplaint.getPrimaryKey(), factCustomerComplaint);

		return factCustomerComplaint;
	}

	protected FactCustomerComplaint toUnwrappedModel(
		FactCustomerComplaint factCustomerComplaint) {
		if (factCustomerComplaint instanceof FactCustomerComplaintImpl) {
			return factCustomerComplaint;
		}

		FactCustomerComplaintImpl factCustomerComplaintImpl = new FactCustomerComplaintImpl();

		factCustomerComplaintImpl.setNew(factCustomerComplaint.isNew());
		factCustomerComplaintImpl.setPrimaryKey(factCustomerComplaint.getPrimaryKey());

		factCustomerComplaintImpl.setFactId(factCustomerComplaint.getFactId());
		factCustomerComplaintImpl.setLibraryId(factCustomerComplaint.getLibraryId());
		factCustomerComplaintImpl.setPeriod(factCustomerComplaint.getPeriod());
		factCustomerComplaintImpl.setComplaintTotal(factCustomerComplaint.getComplaintTotal());
		factCustomerComplaintImpl.setUnsettledTotal(factCustomerComplaint.getUnsettledTotal());
		factCustomerComplaintImpl.setCompanyId(factCustomerComplaint.getCompanyId());
		factCustomerComplaintImpl.setGroupId(factCustomerComplaint.getGroupId());
		factCustomerComplaintImpl.setUserId(factCustomerComplaint.getUserId());
		factCustomerComplaintImpl.setUserName(factCustomerComplaint.getUserName());
		factCustomerComplaintImpl.setCreateDate(factCustomerComplaint.getCreateDate());

		return factCustomerComplaintImpl;
	}

	/**
	 * Returns the fact customer complaint with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact customer complaint
	 * @return the fact customer complaint
	 * @throws com.idetronic.eis.NoSuchFactCustomerComplaintException if a fact customer complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactCustomerComplaint findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactCustomerComplaintException, SystemException {
		FactCustomerComplaint factCustomerComplaint = fetchByPrimaryKey(primaryKey);

		if (factCustomerComplaint == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactCustomerComplaintException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factCustomerComplaint;
	}

	/**
	 * Returns the fact customer complaint with the primary key or throws a {@link com.idetronic.eis.NoSuchFactCustomerComplaintException} if it could not be found.
	 *
	 * @param factId the primary key of the fact customer complaint
	 * @return the fact customer complaint
	 * @throws com.idetronic.eis.NoSuchFactCustomerComplaintException if a fact customer complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactCustomerComplaint findByPrimaryKey(long factId)
		throws NoSuchFactCustomerComplaintException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact customer complaint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact customer complaint
	 * @return the fact customer complaint, or <code>null</code> if a fact customer complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactCustomerComplaint fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactCustomerComplaint factCustomerComplaint = (FactCustomerComplaint)EntityCacheUtil.getResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
				FactCustomerComplaintImpl.class, primaryKey);

		if (factCustomerComplaint == _nullFactCustomerComplaint) {
			return null;
		}

		if (factCustomerComplaint == null) {
			Session session = null;

			try {
				session = openSession();

				factCustomerComplaint = (FactCustomerComplaint)session.get(FactCustomerComplaintImpl.class,
						primaryKey);

				if (factCustomerComplaint != null) {
					cacheResult(factCustomerComplaint);
				}
				else {
					EntityCacheUtil.putResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
						FactCustomerComplaintImpl.class, primaryKey,
						_nullFactCustomerComplaint);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactCustomerComplaintModelImpl.ENTITY_CACHE_ENABLED,
					FactCustomerComplaintImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factCustomerComplaint;
	}

	/**
	 * Returns the fact customer complaint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact customer complaint
	 * @return the fact customer complaint, or <code>null</code> if a fact customer complaint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactCustomerComplaint fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact customer complaints.
	 *
	 * @return the fact customer complaints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactCustomerComplaint> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact customer complaints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactCustomerComplaintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact customer complaints
	 * @param end the upper bound of the range of fact customer complaints (not inclusive)
	 * @return the range of fact customer complaints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactCustomerComplaint> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact customer complaints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactCustomerComplaintModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact customer complaints
	 * @param end the upper bound of the range of fact customer complaints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact customer complaints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactCustomerComplaint> findAll(int start, int end,
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

		List<FactCustomerComplaint> list = (List<FactCustomerComplaint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTCUSTOMERCOMPLAINT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTCUSTOMERCOMPLAINT;

				if (pagination) {
					sql = sql.concat(FactCustomerComplaintModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactCustomerComplaint>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactCustomerComplaint>(list);
				}
				else {
					list = (List<FactCustomerComplaint>)QueryUtil.list(q,
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
	 * Removes all the fact customer complaints from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactCustomerComplaint factCustomerComplaint : findAll()) {
			remove(factCustomerComplaint);
		}
	}

	/**
	 * Returns the number of fact customer complaints.
	 *
	 * @return the number of fact customer complaints
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

				Query q = session.createQuery(_SQL_COUNT_FACTCUSTOMERCOMPLAINT);

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
	 * Initializes the fact customer complaint persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactCustomerComplaint")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactCustomerComplaint>> listenersList = new ArrayList<ModelListener<FactCustomerComplaint>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactCustomerComplaint>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactCustomerComplaintImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTCUSTOMERCOMPLAINT = "SELECT factCustomerComplaint FROM FactCustomerComplaint factCustomerComplaint";
	private static final String _SQL_COUNT_FACTCUSTOMERCOMPLAINT = "SELECT COUNT(factCustomerComplaint) FROM FactCustomerComplaint factCustomerComplaint";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factCustomerComplaint.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactCustomerComplaint exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactCustomerComplaintPersistenceImpl.class);
	private static FactCustomerComplaint _nullFactCustomerComplaint = new FactCustomerComplaintImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactCustomerComplaint> toCacheModel() {
				return _nullFactCustomerComplaintCacheModel;
			}
		};

	private static CacheModel<FactCustomerComplaint> _nullFactCustomerComplaintCacheModel =
		new CacheModel<FactCustomerComplaint>() {
			@Override
			public FactCustomerComplaint toEntityModel() {
				return _nullFactCustomerComplaint;
			}
		};
}
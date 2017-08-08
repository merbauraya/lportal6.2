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

import com.idetronic.eis.NoSuchFactInterLibLoanException;
import com.idetronic.eis.model.FactInterLibLoan;
import com.idetronic.eis.model.impl.FactInterLibLoanImpl;
import com.idetronic.eis.model.impl.FactInterLibLoanModelImpl;

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
 * The persistence implementation for the fact inter lib loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactInterLibLoanPersistence
 * @see FactInterLibLoanUtil
 * @generated
 */
public class FactInterLibLoanPersistenceImpl extends BasePersistenceImpl<FactInterLibLoan>
	implements FactInterLibLoanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactInterLibLoanUtil} to access the fact inter lib loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactInterLibLoanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
			FactInterLibLoanModelImpl.FINDER_CACHE_ENABLED,
			FactInterLibLoanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
			FactInterLibLoanModelImpl.FINDER_CACHE_ENABLED,
			FactInterLibLoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
			FactInterLibLoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FactInterLibLoanPersistenceImpl() {
		setModelClass(FactInterLibLoan.class);
	}

	/**
	 * Caches the fact inter lib loan in the entity cache if it is enabled.
	 *
	 * @param factInterLibLoan the fact inter lib loan
	 */
	@Override
	public void cacheResult(FactInterLibLoan factInterLibLoan) {
		EntityCacheUtil.putResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
			FactInterLibLoanImpl.class, factInterLibLoan.getPrimaryKey(),
			factInterLibLoan);

		factInterLibLoan.resetOriginalValues();
	}

	/**
	 * Caches the fact inter lib loans in the entity cache if it is enabled.
	 *
	 * @param factInterLibLoans the fact inter lib loans
	 */
	@Override
	public void cacheResult(List<FactInterLibLoan> factInterLibLoans) {
		for (FactInterLibLoan factInterLibLoan : factInterLibLoans) {
			if (EntityCacheUtil.getResult(
						FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
						FactInterLibLoanImpl.class,
						factInterLibLoan.getPrimaryKey()) == null) {
				cacheResult(factInterLibLoan);
			}
			else {
				factInterLibLoan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact inter lib loans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactInterLibLoanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactInterLibLoanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact inter lib loan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactInterLibLoan factInterLibLoan) {
		EntityCacheUtil.removeResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
			FactInterLibLoanImpl.class, factInterLibLoan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactInterLibLoan> factInterLibLoans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactInterLibLoan factInterLibLoan : factInterLibLoans) {
			EntityCacheUtil.removeResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
				FactInterLibLoanImpl.class, factInterLibLoan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact inter lib loan with the primary key. Does not add the fact inter lib loan to the database.
	 *
	 * @param factId the primary key for the new fact inter lib loan
	 * @return the new fact inter lib loan
	 */
	@Override
	public FactInterLibLoan create(long factId) {
		FactInterLibLoan factInterLibLoan = new FactInterLibLoanImpl();

		factInterLibLoan.setNew(true);
		factInterLibLoan.setPrimaryKey(factId);

		return factInterLibLoan;
	}

	/**
	 * Removes the fact inter lib loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factId the primary key of the fact inter lib loan
	 * @return the fact inter lib loan that was removed
	 * @throws com.idetronic.eis.NoSuchFactInterLibLoanException if a fact inter lib loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInterLibLoan remove(long factId)
		throws NoSuchFactInterLibLoanException, SystemException {
		return remove((Serializable)factId);
	}

	/**
	 * Removes the fact inter lib loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact inter lib loan
	 * @return the fact inter lib loan that was removed
	 * @throws com.idetronic.eis.NoSuchFactInterLibLoanException if a fact inter lib loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInterLibLoan remove(Serializable primaryKey)
		throws NoSuchFactInterLibLoanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactInterLibLoan factInterLibLoan = (FactInterLibLoan)session.get(FactInterLibLoanImpl.class,
					primaryKey);

			if (factInterLibLoan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactInterLibLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factInterLibLoan);
		}
		catch (NoSuchFactInterLibLoanException nsee) {
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
	protected FactInterLibLoan removeImpl(FactInterLibLoan factInterLibLoan)
		throws SystemException {
		factInterLibLoan = toUnwrappedModel(factInterLibLoan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factInterLibLoan)) {
				factInterLibLoan = (FactInterLibLoan)session.get(FactInterLibLoanImpl.class,
						factInterLibLoan.getPrimaryKeyObj());
			}

			if (factInterLibLoan != null) {
				session.delete(factInterLibLoan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factInterLibLoan != null) {
			clearCache(factInterLibLoan);
		}

		return factInterLibLoan;
	}

	@Override
	public FactInterLibLoan updateImpl(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan)
		throws SystemException {
		factInterLibLoan = toUnwrappedModel(factInterLibLoan);

		boolean isNew = factInterLibLoan.isNew();

		Session session = null;

		try {
			session = openSession();

			if (factInterLibLoan.isNew()) {
				session.save(factInterLibLoan);

				factInterLibLoan.setNew(false);
			}
			else {
				session.merge(factInterLibLoan);
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

		EntityCacheUtil.putResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
			FactInterLibLoanImpl.class, factInterLibLoan.getPrimaryKey(),
			factInterLibLoan);

		return factInterLibLoan;
	}

	protected FactInterLibLoan toUnwrappedModel(
		FactInterLibLoan factInterLibLoan) {
		if (factInterLibLoan instanceof FactInterLibLoanImpl) {
			return factInterLibLoan;
		}

		FactInterLibLoanImpl factInterLibLoanImpl = new FactInterLibLoanImpl();

		factInterLibLoanImpl.setNew(factInterLibLoan.isNew());
		factInterLibLoanImpl.setPrimaryKey(factInterLibLoan.getPrimaryKey());

		factInterLibLoanImpl.setFactId(factInterLibLoan.getFactId());
		factInterLibLoanImpl.setLibraryId(factInterLibLoan.getLibraryId());
		factInterLibLoanImpl.setPeriod(factInterLibLoan.getPeriod());
		factInterLibLoanImpl.setPtjId(factInterLibLoan.getPtjId());
		factInterLibLoanImpl.setApplyTotal(factInterLibLoan.getApplyTotal());
		factInterLibLoanImpl.setApprovedTotal(factInterLibLoan.getApprovedTotal());
		factInterLibLoanImpl.setCompanyId(factInterLibLoan.getCompanyId());
		factInterLibLoanImpl.setGroupId(factInterLibLoan.getGroupId());
		factInterLibLoanImpl.setUserId(factInterLibLoan.getUserId());
		factInterLibLoanImpl.setUserName(factInterLibLoan.getUserName());
		factInterLibLoanImpl.setCreateDate(factInterLibLoan.getCreateDate());

		return factInterLibLoanImpl;
	}

	/**
	 * Returns the fact inter lib loan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact inter lib loan
	 * @return the fact inter lib loan
	 * @throws com.idetronic.eis.NoSuchFactInterLibLoanException if a fact inter lib loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInterLibLoan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactInterLibLoanException, SystemException {
		FactInterLibLoan factInterLibLoan = fetchByPrimaryKey(primaryKey);

		if (factInterLibLoan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactInterLibLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factInterLibLoan;
	}

	/**
	 * Returns the fact inter lib loan with the primary key or throws a {@link com.idetronic.eis.NoSuchFactInterLibLoanException} if it could not be found.
	 *
	 * @param factId the primary key of the fact inter lib loan
	 * @return the fact inter lib loan
	 * @throws com.idetronic.eis.NoSuchFactInterLibLoanException if a fact inter lib loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInterLibLoan findByPrimaryKey(long factId)
		throws NoSuchFactInterLibLoanException, SystemException {
		return findByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns the fact inter lib loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact inter lib loan
	 * @return the fact inter lib loan, or <code>null</code> if a fact inter lib loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInterLibLoan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactInterLibLoan factInterLibLoan = (FactInterLibLoan)EntityCacheUtil.getResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
				FactInterLibLoanImpl.class, primaryKey);

		if (factInterLibLoan == _nullFactInterLibLoan) {
			return null;
		}

		if (factInterLibLoan == null) {
			Session session = null;

			try {
				session = openSession();

				factInterLibLoan = (FactInterLibLoan)session.get(FactInterLibLoanImpl.class,
						primaryKey);

				if (factInterLibLoan != null) {
					cacheResult(factInterLibLoan);
				}
				else {
					EntityCacheUtil.putResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
						FactInterLibLoanImpl.class, primaryKey,
						_nullFactInterLibLoan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactInterLibLoanModelImpl.ENTITY_CACHE_ENABLED,
					FactInterLibLoanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factInterLibLoan;
	}

	/**
	 * Returns the fact inter lib loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factId the primary key of the fact inter lib loan
	 * @return the fact inter lib loan, or <code>null</code> if a fact inter lib loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactInterLibLoan fetchByPrimaryKey(long factId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factId);
	}

	/**
	 * Returns all the fact inter lib loans.
	 *
	 * @return the fact inter lib loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactInterLibLoan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact inter lib loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact inter lib loans
	 * @param end the upper bound of the range of fact inter lib loans (not inclusive)
	 * @return the range of fact inter lib loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactInterLibLoan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact inter lib loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact inter lib loans
	 * @param end the upper bound of the range of fact inter lib loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact inter lib loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactInterLibLoan> findAll(int start, int end,
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

		List<FactInterLibLoan> list = (List<FactInterLibLoan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTINTERLIBLOAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTINTERLIBLOAN;

				if (pagination) {
					sql = sql.concat(FactInterLibLoanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactInterLibLoan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactInterLibLoan>(list);
				}
				else {
					list = (List<FactInterLibLoan>)QueryUtil.list(q,
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
	 * Removes all the fact inter lib loans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactInterLibLoan factInterLibLoan : findAll()) {
			remove(factInterLibLoan);
		}
	}

	/**
	 * Returns the number of fact inter lib loans.
	 *
	 * @return the number of fact inter lib loans
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

				Query q = session.createQuery(_SQL_COUNT_FACTINTERLIBLOAN);

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
	 * Initializes the fact inter lib loan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactInterLibLoan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactInterLibLoan>> listenersList = new ArrayList<ModelListener<FactInterLibLoan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactInterLibLoan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactInterLibLoanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTINTERLIBLOAN = "SELECT factInterLibLoan FROM FactInterLibLoan factInterLibLoan";
	private static final String _SQL_COUNT_FACTINTERLIBLOAN = "SELECT COUNT(factInterLibLoan) FROM FactInterLibLoan factInterLibLoan";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factInterLibLoan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactInterLibLoan exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactInterLibLoanPersistenceImpl.class);
	private static FactInterLibLoan _nullFactInterLibLoan = new FactInterLibLoanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactInterLibLoan> toCacheModel() {
				return _nullFactInterLibLoanCacheModel;
			}
		};

	private static CacheModel<FactInterLibLoan> _nullFactInterLibLoanCacheModel = new CacheModel<FactInterLibLoan>() {
			@Override
			public FactInterLibLoan toEntityModel() {
				return _nullFactInterLibLoan;
			}
		};
}
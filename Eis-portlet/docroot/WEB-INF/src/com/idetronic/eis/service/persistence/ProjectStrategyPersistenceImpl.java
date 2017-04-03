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

import com.idetronic.eis.NoSuchProjectStrategyException;
import com.idetronic.eis.model.ProjectStrategy;
import com.idetronic.eis.model.impl.ProjectStrategyImpl;
import com.idetronic.eis.model.impl.ProjectStrategyModelImpl;

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
 * The persistence implementation for the project strategy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectStrategyPersistence
 * @see ProjectStrategyUtil
 * @generated
 */
public class ProjectStrategyPersistenceImpl extends BasePersistenceImpl<ProjectStrategy>
	implements ProjectStrategyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectStrategyUtil} to access the project strategy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectStrategyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyModelImpl.FINDER_CACHE_ENABLED,
			ProjectStrategyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyModelImpl.FINDER_CACHE_ENABLED,
			ProjectStrategyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT = new FinderPath(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyModelImpl.FINDER_CACHE_ENABLED,
			ProjectStrategyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProject",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT =
		new FinderPath(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyModelImpl.FINDER_CACHE_ENABLED,
			ProjectStrategyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProject",
			new String[] { Long.class.getName() },
			ProjectStrategyModelImpl.PROJECTID_COLUMN_BITMASK |
			ProjectStrategyModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT = new FinderPath(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProject",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project strategies where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectStrategy> findByProject(long projectId)
		throws SystemException {
		return findByProject(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project strategies where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project strategies
	 * @param end the upper bound of the range of project strategies (not inclusive)
	 * @return the range of matching project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectStrategy> findByProject(long projectId, int start,
		int end) throws SystemException {
		return findByProject(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project strategies where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project strategies
	 * @param end the upper bound of the range of project strategies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectStrategy> findByProject(long projectId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT;
			finderArgs = new Object[] { projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT;
			finderArgs = new Object[] { projectId, start, end, orderByComparator };
		}

		List<ProjectStrategy> list = (List<ProjectStrategy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProjectStrategy projectStrategy : list) {
				if ((projectId != projectStrategy.getProjectId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROJECTSTRATEGY_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectStrategyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<ProjectStrategy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectStrategy>(list);
				}
				else {
					list = (List<ProjectStrategy>)QueryUtil.list(q,
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
	 * Returns the first project strategy in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project strategy
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a matching project strategy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy findByProject_First(long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectStrategyException, SystemException {
		ProjectStrategy projectStrategy = fetchByProject_First(projectId,
				orderByComparator);

		if (projectStrategy != null) {
			return projectStrategy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectStrategyException(msg.toString());
	}

	/**
	 * Returns the first project strategy in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project strategy, or <code>null</code> if a matching project strategy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy fetchByProject_First(long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProjectStrategy> list = findByProject(projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project strategy in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project strategy
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a matching project strategy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy findByProject_Last(long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectStrategyException, SystemException {
		ProjectStrategy projectStrategy = fetchByProject_Last(projectId,
				orderByComparator);

		if (projectStrategy != null) {
			return projectStrategy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectStrategyException(msg.toString());
	}

	/**
	 * Returns the last project strategy in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project strategy, or <code>null</code> if a matching project strategy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy fetchByProject_Last(long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProject(projectId);

		if (count == 0) {
			return null;
		}

		List<ProjectStrategy> list = findByProject(projectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project strategies before and after the current project strategy in the ordered set where projectId = &#63;.
	 *
	 * @param projectStrategyId the primary key of the current project strategy
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project strategy
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy[] findByProject_PrevAndNext(long projectStrategyId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchProjectStrategyException, SystemException {
		ProjectStrategy projectStrategy = findByPrimaryKey(projectStrategyId);

		Session session = null;

		try {
			session = openSession();

			ProjectStrategy[] array = new ProjectStrategyImpl[3];

			array[0] = getByProject_PrevAndNext(session, projectStrategy,
					projectId, orderByComparator, true);

			array[1] = projectStrategy;

			array[2] = getByProject_PrevAndNext(session, projectStrategy,
					projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectStrategy getByProject_PrevAndNext(Session session,
		ProjectStrategy projectStrategy, long projectId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTSTRATEGY_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProjectStrategyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectStrategy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectStrategy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project strategies where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProject(long projectId) throws SystemException {
		for (ProjectStrategy projectStrategy : findByProject(projectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectStrategy);
		}
	}

	/**
	 * Returns the number of project strategies where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProject(long projectId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT;

		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTSTRATEGY_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

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

	private static final String _FINDER_COLUMN_PROJECT_PROJECTID_2 = "projectStrategy.projectId = ?";

	public ProjectStrategyPersistenceImpl() {
		setModelClass(ProjectStrategy.class);
	}

	/**
	 * Caches the project strategy in the entity cache if it is enabled.
	 *
	 * @param projectStrategy the project strategy
	 */
	@Override
	public void cacheResult(ProjectStrategy projectStrategy) {
		EntityCacheUtil.putResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyImpl.class, projectStrategy.getPrimaryKey(),
			projectStrategy);

		projectStrategy.resetOriginalValues();
	}

	/**
	 * Caches the project strategies in the entity cache if it is enabled.
	 *
	 * @param projectStrategies the project strategies
	 */
	@Override
	public void cacheResult(List<ProjectStrategy> projectStrategies) {
		for (ProjectStrategy projectStrategy : projectStrategies) {
			if (EntityCacheUtil.getResult(
						ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
						ProjectStrategyImpl.class,
						projectStrategy.getPrimaryKey()) == null) {
				cacheResult(projectStrategy);
			}
			else {
				projectStrategy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project strategies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProjectStrategyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProjectStrategyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project strategy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectStrategy projectStrategy) {
		EntityCacheUtil.removeResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyImpl.class, projectStrategy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectStrategy> projectStrategies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectStrategy projectStrategy : projectStrategies) {
			EntityCacheUtil.removeResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
				ProjectStrategyImpl.class, projectStrategy.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project strategy with the primary key. Does not add the project strategy to the database.
	 *
	 * @param projectStrategyId the primary key for the new project strategy
	 * @return the new project strategy
	 */
	@Override
	public ProjectStrategy create(long projectStrategyId) {
		ProjectStrategy projectStrategy = new ProjectStrategyImpl();

		projectStrategy.setNew(true);
		projectStrategy.setPrimaryKey(projectStrategyId);

		return projectStrategy;
	}

	/**
	 * Removes the project strategy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectStrategyId the primary key of the project strategy
	 * @return the project strategy that was removed
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy remove(long projectStrategyId)
		throws NoSuchProjectStrategyException, SystemException {
		return remove((Serializable)projectStrategyId);
	}

	/**
	 * Removes the project strategy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project strategy
	 * @return the project strategy that was removed
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy remove(Serializable primaryKey)
		throws NoSuchProjectStrategyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProjectStrategy projectStrategy = (ProjectStrategy)session.get(ProjectStrategyImpl.class,
					primaryKey);

			if (projectStrategy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectStrategyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectStrategy);
		}
		catch (NoSuchProjectStrategyException nsee) {
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
	protected ProjectStrategy removeImpl(ProjectStrategy projectStrategy)
		throws SystemException {
		projectStrategy = toUnwrappedModel(projectStrategy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectStrategy)) {
				projectStrategy = (ProjectStrategy)session.get(ProjectStrategyImpl.class,
						projectStrategy.getPrimaryKeyObj());
			}

			if (projectStrategy != null) {
				session.delete(projectStrategy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectStrategy != null) {
			clearCache(projectStrategy);
		}

		return projectStrategy;
	}

	@Override
	public ProjectStrategy updateImpl(
		com.idetronic.eis.model.ProjectStrategy projectStrategy)
		throws SystemException {
		projectStrategy = toUnwrappedModel(projectStrategy);

		boolean isNew = projectStrategy.isNew();

		ProjectStrategyModelImpl projectStrategyModelImpl = (ProjectStrategyModelImpl)projectStrategy;

		Session session = null;

		try {
			session = openSession();

			if (projectStrategy.isNew()) {
				session.save(projectStrategy);

				projectStrategy.setNew(false);
			}
			else {
				session.merge(projectStrategy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProjectStrategyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((projectStrategyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectStrategyModelImpl.getOriginalProjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT,
					args);

				args = new Object[] { projectStrategyModelImpl.getProjectId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT,
					args);
			}
		}

		EntityCacheUtil.putResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
			ProjectStrategyImpl.class, projectStrategy.getPrimaryKey(),
			projectStrategy);

		return projectStrategy;
	}

	protected ProjectStrategy toUnwrappedModel(ProjectStrategy projectStrategy) {
		if (projectStrategy instanceof ProjectStrategyImpl) {
			return projectStrategy;
		}

		ProjectStrategyImpl projectStrategyImpl = new ProjectStrategyImpl();

		projectStrategyImpl.setNew(projectStrategy.isNew());
		projectStrategyImpl.setPrimaryKey(projectStrategy.getPrimaryKey());

		projectStrategyImpl.setProjectStrategyId(projectStrategy.getProjectStrategyId());
		projectStrategyImpl.setStrategyName(projectStrategy.getStrategyName());
		projectStrategyImpl.setProjectId(projectStrategy.getProjectId());
		projectStrategyImpl.setUserName(projectStrategy.getUserName());
		projectStrategyImpl.setStartDate(projectStrategy.getStartDate());
		projectStrategyImpl.setEndDate(projectStrategy.getEndDate());
		projectStrategyImpl.setStartMonth(projectStrategy.getStartMonth());
		projectStrategyImpl.setStartYear(projectStrategy.getStartYear());
		projectStrategyImpl.setStartMonthName(projectStrategy.getStartMonthName());
		projectStrategyImpl.setEndMonth(projectStrategy.getEndMonth());
		projectStrategyImpl.setEndYear(projectStrategy.getEndYear());
		projectStrategyImpl.setEndMonthName(projectStrategy.getEndMonthName());
		projectStrategyImpl.setCompletionDate(projectStrategy.getCompletionDate());
		projectStrategyImpl.setProjectStrategyStatus(projectStrategy.getProjectStrategyStatus());
		projectStrategyImpl.setUserId(projectStrategy.getUserId());
		projectStrategyImpl.setProgress(projectStrategy.getProgress());
		projectStrategyImpl.setStatus(projectStrategy.getStatus());
		projectStrategyImpl.setProgressStatus(projectStrategy.getProgressStatus());
		projectStrategyImpl.setGroupId(projectStrategy.getGroupId());
		projectStrategyImpl.setCompanyId(projectStrategy.getCompanyId());
		projectStrategyImpl.setCreateDate(projectStrategy.getCreateDate());
		projectStrategyImpl.setModifiedDate(projectStrategy.getModifiedDate());
		projectStrategyImpl.setResourceName(projectStrategy.getResourceName());
		projectStrategyImpl.setResourceType(projectStrategy.getResourceType());
		projectStrategyImpl.setRemark(projectStrategy.getRemark());

		return projectStrategyImpl;
	}

	/**
	 * Returns the project strategy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project strategy
	 * @return the project strategy
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectStrategyException, SystemException {
		ProjectStrategy projectStrategy = fetchByPrimaryKey(primaryKey);

		if (projectStrategy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectStrategyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectStrategy;
	}

	/**
	 * Returns the project strategy with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectStrategyException} if it could not be found.
	 *
	 * @param projectStrategyId the primary key of the project strategy
	 * @return the project strategy
	 * @throws com.idetronic.eis.NoSuchProjectStrategyException if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy findByPrimaryKey(long projectStrategyId)
		throws NoSuchProjectStrategyException, SystemException {
		return findByPrimaryKey((Serializable)projectStrategyId);
	}

	/**
	 * Returns the project strategy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project strategy
	 * @return the project strategy, or <code>null</code> if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProjectStrategy projectStrategy = (ProjectStrategy)EntityCacheUtil.getResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
				ProjectStrategyImpl.class, primaryKey);

		if (projectStrategy == _nullProjectStrategy) {
			return null;
		}

		if (projectStrategy == null) {
			Session session = null;

			try {
				session = openSession();

				projectStrategy = (ProjectStrategy)session.get(ProjectStrategyImpl.class,
						primaryKey);

				if (projectStrategy != null) {
					cacheResult(projectStrategy);
				}
				else {
					EntityCacheUtil.putResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
						ProjectStrategyImpl.class, primaryKey,
						_nullProjectStrategy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProjectStrategyModelImpl.ENTITY_CACHE_ENABLED,
					ProjectStrategyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectStrategy;
	}

	/**
	 * Returns the project strategy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectStrategyId the primary key of the project strategy
	 * @return the project strategy, or <code>null</code> if a project strategy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectStrategy fetchByPrimaryKey(long projectStrategyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)projectStrategyId);
	}

	/**
	 * Returns all the project strategies.
	 *
	 * @return the project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectStrategy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project strategies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project strategies
	 * @param end the upper bound of the range of project strategies (not inclusive)
	 * @return the range of project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectStrategy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project strategies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project strategies
	 * @param end the upper bound of the range of project strategies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project strategies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectStrategy> findAll(int start, int end,
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

		List<ProjectStrategy> list = (List<ProjectStrategy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECTSTRATEGY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTSTRATEGY;

				if (pagination) {
					sql = sql.concat(ProjectStrategyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectStrategy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectStrategy>(list);
				}
				else {
					list = (List<ProjectStrategy>)QueryUtil.list(q,
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
	 * Removes all the project strategies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProjectStrategy projectStrategy : findAll()) {
			remove(projectStrategy);
		}
	}

	/**
	 * Returns the number of project strategies.
	 *
	 * @return the number of project strategies
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

				Query q = session.createQuery(_SQL_COUNT_PROJECTSTRATEGY);

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
	 * Initializes the project strategy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.ProjectStrategy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProjectStrategy>> listenersList = new ArrayList<ModelListener<ProjectStrategy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProjectStrategy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProjectStrategyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECTSTRATEGY = "SELECT projectStrategy FROM ProjectStrategy projectStrategy";
	private static final String _SQL_SELECT_PROJECTSTRATEGY_WHERE = "SELECT projectStrategy FROM ProjectStrategy projectStrategy WHERE ";
	private static final String _SQL_COUNT_PROJECTSTRATEGY = "SELECT COUNT(projectStrategy) FROM ProjectStrategy projectStrategy";
	private static final String _SQL_COUNT_PROJECTSTRATEGY_WHERE = "SELECT COUNT(projectStrategy) FROM ProjectStrategy projectStrategy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectStrategy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectStrategy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectStrategy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProjectStrategyPersistenceImpl.class);
	private static ProjectStrategy _nullProjectStrategy = new ProjectStrategyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProjectStrategy> toCacheModel() {
				return _nullProjectStrategyCacheModel;
			}
		};

	private static CacheModel<ProjectStrategy> _nullProjectStrategyCacheModel = new CacheModel<ProjectStrategy>() {
			@Override
			public ProjectStrategy toEntityModel() {
				return _nullProjectStrategy;
			}
		};
}
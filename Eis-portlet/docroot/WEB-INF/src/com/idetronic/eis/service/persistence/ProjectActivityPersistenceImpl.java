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

import com.idetronic.eis.NoSuchProjectActivityException;
import com.idetronic.eis.model.ProjectActivity;
import com.idetronic.eis.model.impl.ProjectActivityImpl;
import com.idetronic.eis.model.impl.ProjectActivityModelImpl;

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
 * The persistence implementation for the project activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectActivityPersistence
 * @see ProjectActivityUtil
 * @generated
 */
public class ProjectActivityPersistenceImpl extends BasePersistenceImpl<ProjectActivity>
	implements ProjectActivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectActivityUtil} to access the project activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectActivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityModelImpl.FINDER_CACHE_ENABLED,
			ProjectActivityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityModelImpl.FINDER_CACHE_ENABLED,
			ProjectActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STRATEGY = new FinderPath(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityModelImpl.FINDER_CACHE_ENABLED,
			ProjectActivityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStrategy",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRATEGY =
		new FinderPath(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityModelImpl.FINDER_CACHE_ENABLED,
			ProjectActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStrategy",
			new String[] { Long.class.getName() },
			ProjectActivityModelImpl.STRATEGYID_COLUMN_BITMASK |
			ProjectActivityModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STRATEGY = new FinderPath(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStrategy",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project activities where strategyId = &#63;.
	 *
	 * @param strategyId the strategy ID
	 * @return the matching project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectActivity> findByStrategy(long strategyId)
		throws SystemException {
		return findByStrategy(strategyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project activities where strategyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param strategyId the strategy ID
	 * @param start the lower bound of the range of project activities
	 * @param end the upper bound of the range of project activities (not inclusive)
	 * @return the range of matching project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectActivity> findByStrategy(long strategyId, int start,
		int end) throws SystemException {
		return findByStrategy(strategyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project activities where strategyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param strategyId the strategy ID
	 * @param start the lower bound of the range of project activities
	 * @param end the upper bound of the range of project activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectActivity> findByStrategy(long strategyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRATEGY;
			finderArgs = new Object[] { strategyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STRATEGY;
			finderArgs = new Object[] { strategyId, start, end, orderByComparator };
		}

		List<ProjectActivity> list = (List<ProjectActivity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProjectActivity projectActivity : list) {
				if ((strategyId != projectActivity.getStrategyId())) {
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

			query.append(_SQL_SELECT_PROJECTACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_STRATEGY_STRATEGYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(strategyId);

				if (!pagination) {
					list = (List<ProjectActivity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectActivity>(list);
				}
				else {
					list = (List<ProjectActivity>)QueryUtil.list(q,
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
	 * Returns the first project activity in the ordered set where strategyId = &#63;.
	 *
	 * @param strategyId the strategy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project activity
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a matching project activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity findByStrategy_First(long strategyId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectActivityException, SystemException {
		ProjectActivity projectActivity = fetchByStrategy_First(strategyId,
				orderByComparator);

		if (projectActivity != null) {
			return projectActivity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("strategyId=");
		msg.append(strategyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectActivityException(msg.toString());
	}

	/**
	 * Returns the first project activity in the ordered set where strategyId = &#63;.
	 *
	 * @param strategyId the strategy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project activity, or <code>null</code> if a matching project activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity fetchByStrategy_First(long strategyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProjectActivity> list = findByStrategy(strategyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project activity in the ordered set where strategyId = &#63;.
	 *
	 * @param strategyId the strategy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project activity
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a matching project activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity findByStrategy_Last(long strategyId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectActivityException, SystemException {
		ProjectActivity projectActivity = fetchByStrategy_Last(strategyId,
				orderByComparator);

		if (projectActivity != null) {
			return projectActivity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("strategyId=");
		msg.append(strategyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectActivityException(msg.toString());
	}

	/**
	 * Returns the last project activity in the ordered set where strategyId = &#63;.
	 *
	 * @param strategyId the strategy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project activity, or <code>null</code> if a matching project activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity fetchByStrategy_Last(long strategyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStrategy(strategyId);

		if (count == 0) {
			return null;
		}

		List<ProjectActivity> list = findByStrategy(strategyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project activities before and after the current project activity in the ordered set where strategyId = &#63;.
	 *
	 * @param projectActivityId the primary key of the current project activity
	 * @param strategyId the strategy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project activity
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity[] findByStrategy_PrevAndNext(
		long projectActivityId, long strategyId,
		OrderByComparator orderByComparator)
		throws NoSuchProjectActivityException, SystemException {
		ProjectActivity projectActivity = findByPrimaryKey(projectActivityId);

		Session session = null;

		try {
			session = openSession();

			ProjectActivity[] array = new ProjectActivityImpl[3];

			array[0] = getByStrategy_PrevAndNext(session, projectActivity,
					strategyId, orderByComparator, true);

			array[1] = projectActivity;

			array[2] = getByStrategy_PrevAndNext(session, projectActivity,
					strategyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectActivity getByStrategy_PrevAndNext(Session session,
		ProjectActivity projectActivity, long strategyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTACTIVITY_WHERE);

		query.append(_FINDER_COLUMN_STRATEGY_STRATEGYID_2);

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
			query.append(ProjectActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(strategyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectActivity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectActivity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project activities where strategyId = &#63; from the database.
	 *
	 * @param strategyId the strategy ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStrategy(long strategyId) throws SystemException {
		for (ProjectActivity projectActivity : findByStrategy(strategyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectActivity);
		}
	}

	/**
	 * Returns the number of project activities where strategyId = &#63;.
	 *
	 * @param strategyId the strategy ID
	 * @return the number of matching project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStrategy(long strategyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STRATEGY;

		Object[] finderArgs = new Object[] { strategyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_STRATEGY_STRATEGYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(strategyId);

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

	private static final String _FINDER_COLUMN_STRATEGY_STRATEGYID_2 = "projectActivity.strategyId = ?";

	public ProjectActivityPersistenceImpl() {
		setModelClass(ProjectActivity.class);
	}

	/**
	 * Caches the project activity in the entity cache if it is enabled.
	 *
	 * @param projectActivity the project activity
	 */
	@Override
	public void cacheResult(ProjectActivity projectActivity) {
		EntityCacheUtil.putResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityImpl.class, projectActivity.getPrimaryKey(),
			projectActivity);

		projectActivity.resetOriginalValues();
	}

	/**
	 * Caches the project activities in the entity cache if it is enabled.
	 *
	 * @param projectActivities the project activities
	 */
	@Override
	public void cacheResult(List<ProjectActivity> projectActivities) {
		for (ProjectActivity projectActivity : projectActivities) {
			if (EntityCacheUtil.getResult(
						ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
						ProjectActivityImpl.class,
						projectActivity.getPrimaryKey()) == null) {
				cacheResult(projectActivity);
			}
			else {
				projectActivity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project activities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProjectActivityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProjectActivityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project activity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectActivity projectActivity) {
		EntityCacheUtil.removeResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityImpl.class, projectActivity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectActivity> projectActivities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectActivity projectActivity : projectActivities) {
			EntityCacheUtil.removeResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
				ProjectActivityImpl.class, projectActivity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project activity with the primary key. Does not add the project activity to the database.
	 *
	 * @param projectActivityId the primary key for the new project activity
	 * @return the new project activity
	 */
	@Override
	public ProjectActivity create(long projectActivityId) {
		ProjectActivity projectActivity = new ProjectActivityImpl();

		projectActivity.setNew(true);
		projectActivity.setPrimaryKey(projectActivityId);

		return projectActivity;
	}

	/**
	 * Removes the project activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectActivityId the primary key of the project activity
	 * @return the project activity that was removed
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity remove(long projectActivityId)
		throws NoSuchProjectActivityException, SystemException {
		return remove((Serializable)projectActivityId);
	}

	/**
	 * Removes the project activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project activity
	 * @return the project activity that was removed
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity remove(Serializable primaryKey)
		throws NoSuchProjectActivityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProjectActivity projectActivity = (ProjectActivity)session.get(ProjectActivityImpl.class,
					primaryKey);

			if (projectActivity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectActivity);
		}
		catch (NoSuchProjectActivityException nsee) {
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
	protected ProjectActivity removeImpl(ProjectActivity projectActivity)
		throws SystemException {
		projectActivity = toUnwrappedModel(projectActivity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectActivity)) {
				projectActivity = (ProjectActivity)session.get(ProjectActivityImpl.class,
						projectActivity.getPrimaryKeyObj());
			}

			if (projectActivity != null) {
				session.delete(projectActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectActivity != null) {
			clearCache(projectActivity);
		}

		return projectActivity;
	}

	@Override
	public ProjectActivity updateImpl(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws SystemException {
		projectActivity = toUnwrappedModel(projectActivity);

		boolean isNew = projectActivity.isNew();

		ProjectActivityModelImpl projectActivityModelImpl = (ProjectActivityModelImpl)projectActivity;

		Session session = null;

		try {
			session = openSession();

			if (projectActivity.isNew()) {
				session.save(projectActivity);

				projectActivity.setNew(false);
			}
			else {
				session.merge(projectActivity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProjectActivityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((projectActivityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRATEGY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectActivityModelImpl.getOriginalStrategyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STRATEGY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRATEGY,
					args);

				args = new Object[] { projectActivityModelImpl.getStrategyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STRATEGY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STRATEGY,
					args);
			}
		}

		EntityCacheUtil.putResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
			ProjectActivityImpl.class, projectActivity.getPrimaryKey(),
			projectActivity);

		return projectActivity;
	}

	protected ProjectActivity toUnwrappedModel(ProjectActivity projectActivity) {
		if (projectActivity instanceof ProjectActivityImpl) {
			return projectActivity;
		}

		ProjectActivityImpl projectActivityImpl = new ProjectActivityImpl();

		projectActivityImpl.setNew(projectActivity.isNew());
		projectActivityImpl.setPrimaryKey(projectActivity.getPrimaryKey());

		projectActivityImpl.setProjectActivityId(projectActivity.getProjectActivityId());
		projectActivityImpl.setStrategyId(projectActivity.getStrategyId());
		projectActivityImpl.setActivityName(projectActivity.getActivityName());
		projectActivityImpl.setGroupId(projectActivity.getGroupId());
		projectActivityImpl.setCompanyId(projectActivity.getCompanyId());
		projectActivityImpl.setUserId(projectActivity.getUserId());
		projectActivityImpl.setUserName(projectActivity.getUserName());
		projectActivityImpl.setStartDate(projectActivity.getStartDate());
		projectActivityImpl.setEndDate(projectActivity.getEndDate());
		projectActivityImpl.setCreateDate(projectActivity.getCreateDate());
		projectActivityImpl.setModifiedDate(projectActivity.getModifiedDate());
		projectActivityImpl.setStartMonth(projectActivity.getStartMonth());
		projectActivityImpl.setStartYear(projectActivity.getStartYear());
		projectActivityImpl.setStartMonthName(projectActivity.getStartMonthName());
		projectActivityImpl.setEndMonth(projectActivity.getEndMonth());
		projectActivityImpl.setEndYear(projectActivity.getEndYear());
		projectActivityImpl.setEndMonthName(projectActivity.getEndMonthName());
		projectActivityImpl.setProgress(projectActivity.getProgress());
		projectActivityImpl.setStatus(projectActivity.getStatus());
		projectActivityImpl.setProgressStatus(projectActivity.getProgressStatus());
		projectActivityImpl.setCompletionDate(projectActivity.getCompletionDate());
		projectActivityImpl.setResourceName(projectActivity.getResourceName());
		projectActivityImpl.setResourceType(projectActivity.getResourceType());
		projectActivityImpl.setRemark(projectActivity.getRemark());

		return projectActivityImpl;
	}

	/**
	 * Returns the project activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project activity
	 * @return the project activity
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectActivityException, SystemException {
		ProjectActivity projectActivity = fetchByPrimaryKey(primaryKey);

		if (projectActivity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectActivity;
	}

	/**
	 * Returns the project activity with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectActivityException} if it could not be found.
	 *
	 * @param projectActivityId the primary key of the project activity
	 * @return the project activity
	 * @throws com.idetronic.eis.NoSuchProjectActivityException if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity findByPrimaryKey(long projectActivityId)
		throws NoSuchProjectActivityException, SystemException {
		return findByPrimaryKey((Serializable)projectActivityId);
	}

	/**
	 * Returns the project activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project activity
	 * @return the project activity, or <code>null</code> if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProjectActivity projectActivity = (ProjectActivity)EntityCacheUtil.getResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
				ProjectActivityImpl.class, primaryKey);

		if (projectActivity == _nullProjectActivity) {
			return null;
		}

		if (projectActivity == null) {
			Session session = null;

			try {
				session = openSession();

				projectActivity = (ProjectActivity)session.get(ProjectActivityImpl.class,
						primaryKey);

				if (projectActivity != null) {
					cacheResult(projectActivity);
				}
				else {
					EntityCacheUtil.putResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
						ProjectActivityImpl.class, primaryKey,
						_nullProjectActivity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProjectActivityModelImpl.ENTITY_CACHE_ENABLED,
					ProjectActivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectActivity;
	}

	/**
	 * Returns the project activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectActivityId the primary key of the project activity
	 * @return the project activity, or <code>null</code> if a project activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectActivity fetchByPrimaryKey(long projectActivityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)projectActivityId);
	}

	/**
	 * Returns all the project activities.
	 *
	 * @return the project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectActivity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project activities
	 * @param end the upper bound of the range of project activities (not inclusive)
	 * @return the range of project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectActivity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project activities
	 * @param end the upper bound of the range of project activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectActivity> findAll(int start, int end,
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

		List<ProjectActivity> list = (List<ProjectActivity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECTACTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTACTIVITY;

				if (pagination) {
					sql = sql.concat(ProjectActivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectActivity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectActivity>(list);
				}
				else {
					list = (List<ProjectActivity>)QueryUtil.list(q,
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
	 * Removes all the project activities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProjectActivity projectActivity : findAll()) {
			remove(projectActivity);
		}
	}

	/**
	 * Returns the number of project activities.
	 *
	 * @return the number of project activities
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

				Query q = session.createQuery(_SQL_COUNT_PROJECTACTIVITY);

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
	 * Initializes the project activity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.ProjectActivity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProjectActivity>> listenersList = new ArrayList<ModelListener<ProjectActivity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProjectActivity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProjectActivityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECTACTIVITY = "SELECT projectActivity FROM ProjectActivity projectActivity";
	private static final String _SQL_SELECT_PROJECTACTIVITY_WHERE = "SELECT projectActivity FROM ProjectActivity projectActivity WHERE ";
	private static final String _SQL_COUNT_PROJECTACTIVITY = "SELECT COUNT(projectActivity) FROM ProjectActivity projectActivity";
	private static final String _SQL_COUNT_PROJECTACTIVITY_WHERE = "SELECT COUNT(projectActivity) FROM ProjectActivity projectActivity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectActivity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectActivity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectActivity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProjectActivityPersistenceImpl.class);
	private static ProjectActivity _nullProjectActivity = new ProjectActivityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProjectActivity> toCacheModel() {
				return _nullProjectActivityCacheModel;
			}
		};

	private static CacheModel<ProjectActivity> _nullProjectActivityCacheModel = new CacheModel<ProjectActivity>() {
			@Override
			public ProjectActivity toEntityModel() {
				return _nullProjectActivity;
			}
		};
}
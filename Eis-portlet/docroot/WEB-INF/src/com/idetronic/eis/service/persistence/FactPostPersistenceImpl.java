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

import com.idetronic.eis.NoSuchFactPostException;
import com.idetronic.eis.model.FactPost;
import com.idetronic.eis.model.impl.FactPostImpl;
import com.idetronic.eis.model.impl.FactPostModelImpl;

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
 * The persistence implementation for the fact post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPostPersistence
 * @see FactPostUtil
 * @generated
 */
public class FactPostPersistenceImpl extends BasePersistenceImpl<FactPost>
	implements FactPostPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactPostUtil} to access the fact post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactPostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactPostModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactPostModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact posts where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact posts where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @return the range of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByLibraryPeriod(long libraryId, String period,
		int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact posts where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByLibraryPeriod(long libraryId, String period,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD;
			finderArgs = new Object[] { libraryId, period };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD;
			finderArgs = new Object[] {
					libraryId, period,
					
					start, end, orderByComparator
				};
		}

		List<FactPost> list = (List<FactPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactPost factPost : list) {
				if ((libraryId != factPost.getLibraryId()) ||
						!Validator.equals(period, factPost.getPeriod())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FACTPOST_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (bindPeriod) {
					qPos.add(period);
				}

				if (!pagination) {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPost>(list);
				}
				else {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact post in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByLibraryPeriod_First(libraryId, period,
				orderByComparator);

		if (factPost != null) {
			return factPost;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPostException(msg.toString());
	}

	/**
	 * Returns the first fact post in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactPost> list = findByLibraryPeriod(libraryId, period, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact post in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByLibraryPeriod_Last(libraryId, period,
				orderByComparator);

		if (factPost != null) {
			return factPost;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPostException(msg.toString());
	}

	/**
	 * Returns the last fact post in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<FactPost> list = findByLibraryPeriod(libraryId, period, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact posts before and after the current fact post in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param factPostId the primary key of the current fact post
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost[] findByLibraryPeriod_PrevAndNext(long factPostId,
		long libraryId, String period, OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = findByPrimaryKey(factPostId);

		Session session = null;

		try {
			session = openSession();

			FactPost[] array = new FactPostImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session, factPost,
					libraryId, period, orderByComparator, true);

			array[1] = factPost;

			array[2] = getByLibraryPeriod_PrevAndNext(session, factPost,
					libraryId, period, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactPost getByLibraryPeriod_PrevAndNext(Session session,
		FactPost factPost, long libraryId, String period,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTPOST_WHERE);

		query.append(_FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2);

		boolean bindPeriod = false;

		if (period == null) {
			query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1);
		}
		else if (period.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3);
		}
		else {
			bindPeriod = true;

			query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2);
		}

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
			query.append(FactPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (bindPeriod) {
			qPos.add(period);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact posts where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (FactPost factPost : findByLibraryPeriod(libraryId, period,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factPost);
		}
	}

	/**
	 * Returns the number of fact posts where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARYPERIOD;

		Object[] finderArgs = new Object[] { libraryId, period };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FACTPOST_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (bindPeriod) {
					qPos.add(period);
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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "factPost.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "factPost.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "factPost.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(factPost.period IS NULL OR factPost.period = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSTGRADE =
		new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPostGrade",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTGRADE =
		new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPostGrade",
			new String[] { Long.class.getName() },
			FactPostModelImpl.POSTGRADEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSTGRADE = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPostGrade",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact posts where postGradeId = &#63;.
	 *
	 * @param postGradeId the post grade ID
	 * @return the matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByPostGrade(long postGradeId)
		throws SystemException {
		return findByPostGrade(postGradeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact posts where postGradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param postGradeId the post grade ID
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @return the range of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByPostGrade(long postGradeId, int start, int end)
		throws SystemException {
		return findByPostGrade(postGradeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact posts where postGradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param postGradeId the post grade ID
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByPostGrade(long postGradeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTGRADE;
			finderArgs = new Object[] { postGradeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSTGRADE;
			finderArgs = new Object[] { postGradeId, start, end, orderByComparator };
		}

		List<FactPost> list = (List<FactPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactPost factPost : list) {
				if ((postGradeId != factPost.getPostGradeId())) {
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

			query.append(_SQL_SELECT_FACTPOST_WHERE);

			query.append(_FINDER_COLUMN_POSTGRADE_POSTGRADEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(postGradeId);

				if (!pagination) {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPost>(list);
				}
				else {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact post in the ordered set where postGradeId = &#63;.
	 *
	 * @param postGradeId the post grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByPostGrade_First(long postGradeId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByPostGrade_First(postGradeId,
				orderByComparator);

		if (factPost != null) {
			return factPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("postGradeId=");
		msg.append(postGradeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPostException(msg.toString());
	}

	/**
	 * Returns the first fact post in the ordered set where postGradeId = &#63;.
	 *
	 * @param postGradeId the post grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByPostGrade_First(long postGradeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactPost> list = findByPostGrade(postGradeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact post in the ordered set where postGradeId = &#63;.
	 *
	 * @param postGradeId the post grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByPostGrade_Last(long postGradeId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByPostGrade_Last(postGradeId, orderByComparator);

		if (factPost != null) {
			return factPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("postGradeId=");
		msg.append(postGradeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPostException(msg.toString());
	}

	/**
	 * Returns the last fact post in the ordered set where postGradeId = &#63;.
	 *
	 * @param postGradeId the post grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByPostGrade_Last(long postGradeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPostGrade(postGradeId);

		if (count == 0) {
			return null;
		}

		List<FactPost> list = findByPostGrade(postGradeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact posts before and after the current fact post in the ordered set where postGradeId = &#63;.
	 *
	 * @param factPostId the primary key of the current fact post
	 * @param postGradeId the post grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost[] findByPostGrade_PrevAndNext(long factPostId,
		long postGradeId, OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = findByPrimaryKey(factPostId);

		Session session = null;

		try {
			session = openSession();

			FactPost[] array = new FactPostImpl[3];

			array[0] = getByPostGrade_PrevAndNext(session, factPost,
					postGradeId, orderByComparator, true);

			array[1] = factPost;

			array[2] = getByPostGrade_PrevAndNext(session, factPost,
					postGradeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactPost getByPostGrade_PrevAndNext(Session session,
		FactPost factPost, long postGradeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTPOST_WHERE);

		query.append(_FINDER_COLUMN_POSTGRADE_POSTGRADEID_2);

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
			query.append(FactPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(postGradeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact posts where postGradeId = &#63; from the database.
	 *
	 * @param postGradeId the post grade ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPostGrade(long postGradeId) throws SystemException {
		for (FactPost factPost : findByPostGrade(postGradeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factPost);
		}
	}

	/**
	 * Returns the number of fact posts where postGradeId = &#63;.
	 *
	 * @param postGradeId the post grade ID
	 * @return the number of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPostGrade(long postGradeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSTGRADE;

		Object[] finderArgs = new Object[] { postGradeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACTPOST_WHERE);

			query.append(_FINDER_COLUMN_POSTGRADE_POSTGRADEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(postGradeId);

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

	private static final String _FINDER_COLUMN_POSTGRADE_POSTGRADEID_2 = "factPost.postGradeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, FactPostImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactPostModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact posts where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact posts where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @return the range of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByLibrary(long libraryId, int start, int end)
		throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact posts where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findByLibrary(long libraryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY;
			finderArgs = new Object[] { libraryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY;
			finderArgs = new Object[] { libraryId, start, end, orderByComparator };
		}

		List<FactPost> list = (List<FactPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactPost factPost : list) {
				if ((libraryId != factPost.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTPOST_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactPostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPost>(list);
				}
				else {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact post in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByLibrary_First(libraryId, orderByComparator);

		if (factPost != null) {
			return factPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPostException(msg.toString());
	}

	/**
	 * Returns the first fact post in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact post, or <code>null</code> if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactPost> list = findByLibrary(libraryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact post in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByLibrary_Last(libraryId, orderByComparator);

		if (factPost != null) {
			return factPost;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPostException(msg.toString());
	}

	/**
	 * Returns the last fact post in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact post, or <code>null</code> if a matching fact post could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactPost> list = findByLibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact posts before and after the current fact post in the ordered set where libraryId = &#63;.
	 *
	 * @param factPostId the primary key of the current fact post
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost[] findByLibrary_PrevAndNext(long factPostId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = findByPrimaryKey(factPostId);

		Session session = null;

		try {
			session = openSession();

			FactPost[] array = new FactPostImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, factPost, libraryId,
					orderByComparator, true);

			array[1] = factPost;

			array[2] = getByLibrary_PrevAndNext(session, factPost, libraryId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactPost getByLibrary_PrevAndNext(Session session,
		FactPost factPost, long libraryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTPOST_WHERE);

		query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

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
			query.append(FactPostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factPost);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactPost> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact posts where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactPost factPost : findByLibrary(libraryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(factPost);
		}
	}

	/**
	 * Returns the number of fact posts where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibrary(long libraryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARY;

		Object[] finderArgs = new Object[] { libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACTPOST_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factPost.libraryId = ?";

	public FactPostPersistenceImpl() {
		setModelClass(FactPost.class);
	}

	/**
	 * Caches the fact post in the entity cache if it is enabled.
	 *
	 * @param factPost the fact post
	 */
	@Override
	public void cacheResult(FactPost factPost) {
		EntityCacheUtil.putResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostImpl.class, factPost.getPrimaryKey(), factPost);

		factPost.resetOriginalValues();
	}

	/**
	 * Caches the fact posts in the entity cache if it is enabled.
	 *
	 * @param factPosts the fact posts
	 */
	@Override
	public void cacheResult(List<FactPost> factPosts) {
		for (FactPost factPost : factPosts) {
			if (EntityCacheUtil.getResult(
						FactPostModelImpl.ENTITY_CACHE_ENABLED,
						FactPostImpl.class, factPost.getPrimaryKey()) == null) {
				cacheResult(factPost);
			}
			else {
				factPost.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact posts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactPostImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactPostImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact post.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactPost factPost) {
		EntityCacheUtil.removeResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostImpl.class, factPost.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactPost> factPosts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactPost factPost : factPosts) {
			EntityCacheUtil.removeResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
				FactPostImpl.class, factPost.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact post with the primary key. Does not add the fact post to the database.
	 *
	 * @param factPostId the primary key for the new fact post
	 * @return the new fact post
	 */
	@Override
	public FactPost create(long factPostId) {
		FactPost factPost = new FactPostImpl();

		factPost.setNew(true);
		factPost.setPrimaryKey(factPostId);

		return factPost;
	}

	/**
	 * Removes the fact post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factPostId the primary key of the fact post
	 * @return the fact post that was removed
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost remove(long factPostId)
		throws NoSuchFactPostException, SystemException {
		return remove((Serializable)factPostId);
	}

	/**
	 * Removes the fact post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact post
	 * @return the fact post that was removed
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost remove(Serializable primaryKey)
		throws NoSuchFactPostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactPost factPost = (FactPost)session.get(FactPostImpl.class,
					primaryKey);

			if (factPost == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factPost);
		}
		catch (NoSuchFactPostException nsee) {
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
	protected FactPost removeImpl(FactPost factPost) throws SystemException {
		factPost = toUnwrappedModel(factPost);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factPost)) {
				factPost = (FactPost)session.get(FactPostImpl.class,
						factPost.getPrimaryKeyObj());
			}

			if (factPost != null) {
				session.delete(factPost);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factPost != null) {
			clearCache(factPost);
		}

		return factPost;
	}

	@Override
	public FactPost updateImpl(com.idetronic.eis.model.FactPost factPost)
		throws SystemException {
		factPost = toUnwrappedModel(factPost);

		boolean isNew = factPost.isNew();

		FactPostModelImpl factPostModelImpl = (FactPostModelImpl)factPost;

		Session session = null;

		try {
			session = openSession();

			if (factPost.isNew()) {
				session.save(factPost);

				factPost.setNew(false);
			}
			else {
				session.merge(factPost);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactPostModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factPostModelImpl.getOriginalLibraryId(),
						factPostModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						factPostModelImpl.getLibraryId(),
						factPostModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}

			if ((factPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTGRADE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factPostModelImpl.getOriginalPostGradeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTGRADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTGRADE,
					args);

				args = new Object[] { factPostModelImpl.getPostGradeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSTGRADE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSTGRADE,
					args);
			}

			if ((factPostModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factPostModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { factPostModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
			FactPostImpl.class, factPost.getPrimaryKey(), factPost);

		return factPost;
	}

	protected FactPost toUnwrappedModel(FactPost factPost) {
		if (factPost instanceof FactPostImpl) {
			return factPost;
		}

		FactPostImpl factPostImpl = new FactPostImpl();

		factPostImpl.setNew(factPost.isNew());
		factPostImpl.setPrimaryKey(factPost.getPrimaryKey());

		factPostImpl.setFactPostId(factPost.getFactPostId());
		factPostImpl.setLibraryId(factPost.getLibraryId());
		factPostImpl.setPeriod(factPost.getPeriod());
		factPostImpl.setPostGradeId(factPost.getPostGradeId());
		factPostImpl.setStateId(factPost.getStateId());
		factPostImpl.setValue(factPost.getValue());
		factPostImpl.setCreatedByUserId(factPost.getCreatedByUserId());
		factPostImpl.setCreatedByUserName(factPost.getCreatedByUserName());
		factPostImpl.setCreatedDate(factPost.getCreatedDate());

		return factPostImpl;
	}

	/**
	 * Returns the fact post with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact post
	 * @return the fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactPostException, SystemException {
		FactPost factPost = fetchByPrimaryKey(primaryKey);

		if (factPost == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactPostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factPost;
	}

	/**
	 * Returns the fact post with the primary key or throws a {@link com.idetronic.eis.NoSuchFactPostException} if it could not be found.
	 *
	 * @param factPostId the primary key of the fact post
	 * @return the fact post
	 * @throws com.idetronic.eis.NoSuchFactPostException if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost findByPrimaryKey(long factPostId)
		throws NoSuchFactPostException, SystemException {
		return findByPrimaryKey((Serializable)factPostId);
	}

	/**
	 * Returns the fact post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact post
	 * @return the fact post, or <code>null</code> if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactPost factPost = (FactPost)EntityCacheUtil.getResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
				FactPostImpl.class, primaryKey);

		if (factPost == _nullFactPost) {
			return null;
		}

		if (factPost == null) {
			Session session = null;

			try {
				session = openSession();

				factPost = (FactPost)session.get(FactPostImpl.class, primaryKey);

				if (factPost != null) {
					cacheResult(factPost);
				}
				else {
					EntityCacheUtil.putResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
						FactPostImpl.class, primaryKey, _nullFactPost);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactPostModelImpl.ENTITY_CACHE_ENABLED,
					FactPostImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factPost;
	}

	/**
	 * Returns the fact post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factPostId the primary key of the fact post
	 * @return the fact post, or <code>null</code> if a fact post with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPost fetchByPrimaryKey(long factPostId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factPostId);
	}

	/**
	 * Returns all the fact posts.
	 *
	 * @return the fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @return the range of fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact posts
	 * @param end the upper bound of the range of fact posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact posts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPost> findAll(int start, int end,
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

		List<FactPost> list = (List<FactPost>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTPOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTPOST;

				if (pagination) {
					sql = sql.concat(FactPostModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPost>(list);
				}
				else {
					list = (List<FactPost>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact posts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactPost factPost : findAll()) {
			remove(factPost);
		}
	}

	/**
	 * Returns the number of fact posts.
	 *
	 * @return the number of fact posts
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

				Query q = session.createQuery(_SQL_COUNT_FACTPOST);

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
	 * Initializes the fact post persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactPost")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactPost>> listenersList = new ArrayList<ModelListener<FactPost>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactPost>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactPostImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTPOST = "SELECT factPost FROM FactPost factPost";
	private static final String _SQL_SELECT_FACTPOST_WHERE = "SELECT factPost FROM FactPost factPost WHERE ";
	private static final String _SQL_COUNT_FACTPOST = "SELECT COUNT(factPost) FROM FactPost factPost";
	private static final String _SQL_COUNT_FACTPOST_WHERE = "SELECT COUNT(factPost) FROM FactPost factPost WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factPost.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactPost exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactPost exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactPostPersistenceImpl.class);
	private static FactPost _nullFactPost = new FactPostImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactPost> toCacheModel() {
				return _nullFactPostCacheModel;
			}
		};

	private static CacheModel<FactPost> _nullFactPostCacheModel = new CacheModel<FactPost>() {
			@Override
			public FactPost toEntityModel() {
				return _nullFactPost;
			}
		};
}
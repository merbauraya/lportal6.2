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

import com.idetronic.eis.NoSuchFactVisitorException;
import com.idetronic.eis.model.FactVisitor;
import com.idetronic.eis.model.impl.FactVisitorImpl;
import com.idetronic.eis.model.impl.FactVisitorModelImpl;

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
 * The persistence implementation for the fact visitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactVisitorPersistence
 * @see FactVisitorUtil
 * @generated
 */
public class FactVisitorPersistenceImpl extends BasePersistenceImpl<FactVisitor>
	implements FactVisitorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactVisitorUtil} to access the fact visitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactVisitorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactVisitorModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactVisitorModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact visitors where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact visitors where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @return the range of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByLibraryPeriod(long libraryId, String period,
		int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact visitors where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByLibraryPeriod(long libraryId, String period,
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

		List<FactVisitor> list = (List<FactVisitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactVisitor factVisitor : list) {
				if ((libraryId != factVisitor.getLibraryId()) ||
						!Validator.equals(period, factVisitor.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTVISITOR_WHERE);

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
				query.append(FactVisitorModelImpl.ORDER_BY_JPQL);
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
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactVisitor>(list);
				}
				else {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByLibraryPeriod_First(libraryId, period,
				orderByComparator);

		if (factVisitor != null) {
			return factVisitor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactVisitorException(msg.toString());
	}

	/**
	 * Returns the first fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactVisitor> list = findByLibraryPeriod(libraryId, period, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByLibraryPeriod_Last(libraryId, period,
				orderByComparator);

		if (factVisitor != null) {
			return factVisitor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactVisitorException(msg.toString());
	}

	/**
	 * Returns the last fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<FactVisitor> list = findByLibraryPeriod(libraryId, period,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact visitors before and after the current fact visitor in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param factVisitorId the primary key of the current fact visitor
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor[] findByLibraryPeriod_PrevAndNext(long factVisitorId,
		long libraryId, String period, OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = findByPrimaryKey(factVisitorId);

		Session session = null;

		try {
			session = openSession();

			FactVisitor[] array = new FactVisitorImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session, factVisitor,
					libraryId, period, orderByComparator, true);

			array[1] = factVisitor;

			array[2] = getByLibraryPeriod_PrevAndNext(session, factVisitor,
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

	protected FactVisitor getByLibraryPeriod_PrevAndNext(Session session,
		FactVisitor factVisitor, long libraryId, String period,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTVISITOR_WHERE);

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
			query.append(FactVisitorModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(factVisitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactVisitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact visitors where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (FactVisitor factVisitor : findByLibraryPeriod(libraryId, period,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factVisitor);
		}
	}

	/**
	 * Returns the number of fact visitors where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching fact visitors
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

			query.append(_SQL_COUNT_FACTVISITOR_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "factVisitor.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "factVisitor.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "factVisitor.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(factVisitor.period IS NULL OR factVisitor.period = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VISITORCATEGORY =
		new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisitorCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORCATEGORY =
		new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisitorCategory",
			new String[] { Long.class.getName() },
			FactVisitorModelImpl.VISITORCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VISITORCATEGORY = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVisitorCategory", new String[] { Long.class.getName() });

	/**
	 * Returns all the fact visitors where visitorCategoryId = &#63;.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @return the matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByVisitorCategory(long visitorCategoryId)
		throws SystemException {
		return findByVisitorCategory(visitorCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact visitors where visitorCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @return the range of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByVisitorCategory(long visitorCategoryId,
		int start, int end) throws SystemException {
		return findByVisitorCategory(visitorCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact visitors where visitorCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByVisitorCategory(long visitorCategoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORCATEGORY;
			finderArgs = new Object[] { visitorCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VISITORCATEGORY;
			finderArgs = new Object[] {
					visitorCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<FactVisitor> list = (List<FactVisitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactVisitor factVisitor : list) {
				if ((visitorCategoryId != factVisitor.getVisitorCategoryId())) {
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

			query.append(_SQL_SELECT_FACTVISITOR_WHERE);

			query.append(_FINDER_COLUMN_VISITORCATEGORY_VISITORCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactVisitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(visitorCategoryId);

				if (!pagination) {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactVisitor>(list);
				}
				else {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact visitor in the ordered set where visitorCategoryId = &#63;.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByVisitorCategory_First(long visitorCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByVisitorCategory_First(visitorCategoryId,
				orderByComparator);

		if (factVisitor != null) {
			return factVisitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("visitorCategoryId=");
		msg.append(visitorCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactVisitorException(msg.toString());
	}

	/**
	 * Returns the first fact visitor in the ordered set where visitorCategoryId = &#63;.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByVisitorCategory_First(long visitorCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactVisitor> list = findByVisitorCategory(visitorCategoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact visitor in the ordered set where visitorCategoryId = &#63;.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByVisitorCategory_Last(long visitorCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByVisitorCategory_Last(visitorCategoryId,
				orderByComparator);

		if (factVisitor != null) {
			return factVisitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("visitorCategoryId=");
		msg.append(visitorCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactVisitorException(msg.toString());
	}

	/**
	 * Returns the last fact visitor in the ordered set where visitorCategoryId = &#63;.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByVisitorCategory_Last(long visitorCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVisitorCategory(visitorCategoryId);

		if (count == 0) {
			return null;
		}

		List<FactVisitor> list = findByVisitorCategory(visitorCategoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact visitors before and after the current fact visitor in the ordered set where visitorCategoryId = &#63;.
	 *
	 * @param factVisitorId the primary key of the current fact visitor
	 * @param visitorCategoryId the visitor category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor[] findByVisitorCategory_PrevAndNext(long factVisitorId,
		long visitorCategoryId, OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = findByPrimaryKey(factVisitorId);

		Session session = null;

		try {
			session = openSession();

			FactVisitor[] array = new FactVisitorImpl[3];

			array[0] = getByVisitorCategory_PrevAndNext(session, factVisitor,
					visitorCategoryId, orderByComparator, true);

			array[1] = factVisitor;

			array[2] = getByVisitorCategory_PrevAndNext(session, factVisitor,
					visitorCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactVisitor getByVisitorCategory_PrevAndNext(Session session,
		FactVisitor factVisitor, long visitorCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTVISITOR_WHERE);

		query.append(_FINDER_COLUMN_VISITORCATEGORY_VISITORCATEGORYID_2);

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
			query.append(FactVisitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(visitorCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factVisitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactVisitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact visitors where visitorCategoryId = &#63; from the database.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVisitorCategory(long visitorCategoryId)
		throws SystemException {
		for (FactVisitor factVisitor : findByVisitorCategory(
				visitorCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factVisitor);
		}
	}

	/**
	 * Returns the number of fact visitors where visitorCategoryId = &#63;.
	 *
	 * @param visitorCategoryId the visitor category ID
	 * @return the number of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVisitorCategory(long visitorCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VISITORCATEGORY;

		Object[] finderArgs = new Object[] { visitorCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACTVISITOR_WHERE);

			query.append(_FINDER_COLUMN_VISITORCATEGORY_VISITORCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(visitorCategoryId);

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

	private static final String _FINDER_COLUMN_VISITORCATEGORY_VISITORCATEGORYID_2 =
		"factVisitor.visitorCategoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, FactVisitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactVisitorModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact visitors where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact visitors where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @return the range of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByLibrary(long libraryId, int start, int end)
		throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact visitors where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findByLibrary(long libraryId, int start, int end,
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

		List<FactVisitor> list = (List<FactVisitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactVisitor factVisitor : list) {
				if ((libraryId != factVisitor.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTVISITOR_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactVisitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactVisitor>(list);
				}
				else {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact visitor in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByLibrary_First(libraryId,
				orderByComparator);

		if (factVisitor != null) {
			return factVisitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactVisitorException(msg.toString());
	}

	/**
	 * Returns the first fact visitor in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactVisitor> list = findByLibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact visitor in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByLibrary_Last(libraryId,
				orderByComparator);

		if (factVisitor != null) {
			return factVisitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactVisitorException(msg.toString());
	}

	/**
	 * Returns the last fact visitor in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact visitor, or <code>null</code> if a matching fact visitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactVisitor> list = findByLibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact visitors before and after the current fact visitor in the ordered set where libraryId = &#63;.
	 *
	 * @param factVisitorId the primary key of the current fact visitor
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor[] findByLibrary_PrevAndNext(long factVisitorId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = findByPrimaryKey(factVisitorId);

		Session session = null;

		try {
			session = openSession();

			FactVisitor[] array = new FactVisitorImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, factVisitor,
					libraryId, orderByComparator, true);

			array[1] = factVisitor;

			array[2] = getByLibrary_PrevAndNext(session, factVisitor,
					libraryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactVisitor getByLibrary_PrevAndNext(Session session,
		FactVisitor factVisitor, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTVISITOR_WHERE);

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
			query.append(FactVisitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factVisitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactVisitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact visitors where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactVisitor factVisitor : findByLibrary(libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factVisitor);
		}
	}

	/**
	 * Returns the number of fact visitors where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact visitors
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

			query.append(_SQL_COUNT_FACTVISITOR_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factVisitor.libraryId = ?";

	public FactVisitorPersistenceImpl() {
		setModelClass(FactVisitor.class);
	}

	/**
	 * Caches the fact visitor in the entity cache if it is enabled.
	 *
	 * @param factVisitor the fact visitor
	 */
	@Override
	public void cacheResult(FactVisitor factVisitor) {
		EntityCacheUtil.putResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorImpl.class, factVisitor.getPrimaryKey(), factVisitor);

		factVisitor.resetOriginalValues();
	}

	/**
	 * Caches the fact visitors in the entity cache if it is enabled.
	 *
	 * @param factVisitors the fact visitors
	 */
	@Override
	public void cacheResult(List<FactVisitor> factVisitors) {
		for (FactVisitor factVisitor : factVisitors) {
			if (EntityCacheUtil.getResult(
						FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
						FactVisitorImpl.class, factVisitor.getPrimaryKey()) == null) {
				cacheResult(factVisitor);
			}
			else {
				factVisitor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact visitors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactVisitorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactVisitorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact visitor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactVisitor factVisitor) {
		EntityCacheUtil.removeResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorImpl.class, factVisitor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactVisitor> factVisitors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactVisitor factVisitor : factVisitors) {
			EntityCacheUtil.removeResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
				FactVisitorImpl.class, factVisitor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact visitor with the primary key. Does not add the fact visitor to the database.
	 *
	 * @param factVisitorId the primary key for the new fact visitor
	 * @return the new fact visitor
	 */
	@Override
	public FactVisitor create(long factVisitorId) {
		FactVisitor factVisitor = new FactVisitorImpl();

		factVisitor.setNew(true);
		factVisitor.setPrimaryKey(factVisitorId);

		return factVisitor;
	}

	/**
	 * Removes the fact visitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factVisitorId the primary key of the fact visitor
	 * @return the fact visitor that was removed
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor remove(long factVisitorId)
		throws NoSuchFactVisitorException, SystemException {
		return remove((Serializable)factVisitorId);
	}

	/**
	 * Removes the fact visitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact visitor
	 * @return the fact visitor that was removed
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor remove(Serializable primaryKey)
		throws NoSuchFactVisitorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactVisitor factVisitor = (FactVisitor)session.get(FactVisitorImpl.class,
					primaryKey);

			if (factVisitor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactVisitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factVisitor);
		}
		catch (NoSuchFactVisitorException nsee) {
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
	protected FactVisitor removeImpl(FactVisitor factVisitor)
		throws SystemException {
		factVisitor = toUnwrappedModel(factVisitor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factVisitor)) {
				factVisitor = (FactVisitor)session.get(FactVisitorImpl.class,
						factVisitor.getPrimaryKeyObj());
			}

			if (factVisitor != null) {
				session.delete(factVisitor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factVisitor != null) {
			clearCache(factVisitor);
		}

		return factVisitor;
	}

	@Override
	public FactVisitor updateImpl(
		com.idetronic.eis.model.FactVisitor factVisitor)
		throws SystemException {
		factVisitor = toUnwrappedModel(factVisitor);

		boolean isNew = factVisitor.isNew();

		FactVisitorModelImpl factVisitorModelImpl = (FactVisitorModelImpl)factVisitor;

		Session session = null;

		try {
			session = openSession();

			if (factVisitor.isNew()) {
				session.save(factVisitor);

				factVisitor.setNew(false);
			}
			else {
				session.merge(factVisitor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactVisitorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factVisitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factVisitorModelImpl.getOriginalLibraryId(),
						factVisitorModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						factVisitorModelImpl.getLibraryId(),
						factVisitorModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}

			if ((factVisitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factVisitorModelImpl.getOriginalVisitorCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VISITORCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORCATEGORY,
					args);

				args = new Object[] { factVisitorModelImpl.getVisitorCategoryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VISITORCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VISITORCATEGORY,
					args);
			}

			if ((factVisitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factVisitorModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { factVisitorModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
			FactVisitorImpl.class, factVisitor.getPrimaryKey(), factVisitor);

		return factVisitor;
	}

	protected FactVisitor toUnwrappedModel(FactVisitor factVisitor) {
		if (factVisitor instanceof FactVisitorImpl) {
			return factVisitor;
		}

		FactVisitorImpl factVisitorImpl = new FactVisitorImpl();

		factVisitorImpl.setNew(factVisitor.isNew());
		factVisitorImpl.setPrimaryKey(factVisitor.getPrimaryKey());

		factVisitorImpl.setFactVisitorId(factVisitor.getFactVisitorId());
		factVisitorImpl.setLibraryId(factVisitor.getLibraryId());
		factVisitorImpl.setPeriod(factVisitor.getPeriod());
		factVisitorImpl.setVisitorCategoryId(factVisitor.getVisitorCategoryId());
		factVisitorImpl.setStateId(factVisitor.getStateId());
		factVisitorImpl.setLibraryTypeId(factVisitor.getLibraryTypeId());
		factVisitorImpl.setValue(factVisitor.getValue());
		factVisitorImpl.setCreatedByUserId(factVisitor.getCreatedByUserId());
		factVisitorImpl.setCreatedByUserName(factVisitor.getCreatedByUserName());
		factVisitorImpl.setCreatedDate(factVisitor.getCreatedDate());

		return factVisitorImpl;
	}

	/**
	 * Returns the fact visitor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact visitor
	 * @return the fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactVisitorException, SystemException {
		FactVisitor factVisitor = fetchByPrimaryKey(primaryKey);

		if (factVisitor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactVisitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factVisitor;
	}

	/**
	 * Returns the fact visitor with the primary key or throws a {@link com.idetronic.eis.NoSuchFactVisitorException} if it could not be found.
	 *
	 * @param factVisitorId the primary key of the fact visitor
	 * @return the fact visitor
	 * @throws com.idetronic.eis.NoSuchFactVisitorException if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor findByPrimaryKey(long factVisitorId)
		throws NoSuchFactVisitorException, SystemException {
		return findByPrimaryKey((Serializable)factVisitorId);
	}

	/**
	 * Returns the fact visitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact visitor
	 * @return the fact visitor, or <code>null</code> if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactVisitor factVisitor = (FactVisitor)EntityCacheUtil.getResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
				FactVisitorImpl.class, primaryKey);

		if (factVisitor == _nullFactVisitor) {
			return null;
		}

		if (factVisitor == null) {
			Session session = null;

			try {
				session = openSession();

				factVisitor = (FactVisitor)session.get(FactVisitorImpl.class,
						primaryKey);

				if (factVisitor != null) {
					cacheResult(factVisitor);
				}
				else {
					EntityCacheUtil.putResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
						FactVisitorImpl.class, primaryKey, _nullFactVisitor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactVisitorModelImpl.ENTITY_CACHE_ENABLED,
					FactVisitorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factVisitor;
	}

	/**
	 * Returns the fact visitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factVisitorId the primary key of the fact visitor
	 * @return the fact visitor, or <code>null</code> if a fact visitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactVisitor fetchByPrimaryKey(long factVisitorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factVisitorId);
	}

	/**
	 * Returns all the fact visitors.
	 *
	 * @return the fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact visitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @return the range of fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact visitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactVisitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact visitors
	 * @param end the upper bound of the range of fact visitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact visitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactVisitor> findAll(int start, int end,
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

		List<FactVisitor> list = (List<FactVisitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTVISITOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTVISITOR;

				if (pagination) {
					sql = sql.concat(FactVisitorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactVisitor>(list);
				}
				else {
					list = (List<FactVisitor>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact visitors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactVisitor factVisitor : findAll()) {
			remove(factVisitor);
		}
	}

	/**
	 * Returns the number of fact visitors.
	 *
	 * @return the number of fact visitors
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

				Query q = session.createQuery(_SQL_COUNT_FACTVISITOR);

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
	 * Initializes the fact visitor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactVisitor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactVisitor>> listenersList = new ArrayList<ModelListener<FactVisitor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactVisitor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactVisitorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTVISITOR = "SELECT factVisitor FROM FactVisitor factVisitor";
	private static final String _SQL_SELECT_FACTVISITOR_WHERE = "SELECT factVisitor FROM FactVisitor factVisitor WHERE ";
	private static final String _SQL_COUNT_FACTVISITOR = "SELECT COUNT(factVisitor) FROM FactVisitor factVisitor";
	private static final String _SQL_COUNT_FACTVISITOR_WHERE = "SELECT COUNT(factVisitor) FROM FactVisitor factVisitor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factVisitor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactVisitor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactVisitor exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactVisitorPersistenceImpl.class);
	private static FactVisitor _nullFactVisitor = new FactVisitorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactVisitor> toCacheModel() {
				return _nullFactVisitorCacheModel;
			}
		};

	private static CacheModel<FactVisitor> _nullFactVisitorCacheModel = new CacheModel<FactVisitor>() {
			@Override
			public FactVisitor toEntityModel() {
				return _nullFactVisitor;
			}
		};
}
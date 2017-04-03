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

import com.idetronic.eis.NoSuchFactIrSubmissionException;
import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.impl.FactIrSubmissionImpl;
import com.idetronic.eis.model.impl.FactIrSubmissionModelImpl;

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
 * The persistence implementation for the fact ir submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrSubmissionPersistence
 * @see FactIrSubmissionUtil
 * @generated
 */
public class FactIrSubmissionPersistenceImpl extends BasePersistenceImpl<FactIrSubmission>
	implements FactIrSubmissionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactIrSubmissionUtil} to access the fact ir submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactIrSubmissionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionModelImpl.FINDER_CACHE_ENABLED,
			FactIrSubmissionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionModelImpl.FINDER_CACHE_ENABLED,
			FactIrSubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACULTYPERIOD =
		new FinderPath(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionModelImpl.FINDER_CACHE_ENABLED,
			FactIrSubmissionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFacultyPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTYPERIOD =
		new FinderPath(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionModelImpl.FINDER_CACHE_ENABLED,
			FactIrSubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFacultyPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactIrSubmissionModelImpl.FACULTYID_COLUMN_BITMASK |
			FactIrSubmissionModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FACULTYPERIOD = new FinderPath(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacultyPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact ir submissions where facultyId = &#63; and period = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @return the matching fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrSubmission> findByFacultyPeriod(long facultyId,
		String period) throws SystemException {
		return findByFacultyPeriod(facultyId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact ir submissions where facultyId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param start the lower bound of the range of fact ir submissions
	 * @param end the upper bound of the range of fact ir submissions (not inclusive)
	 * @return the range of matching fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrSubmission> findByFacultyPeriod(long facultyId,
		String period, int start, int end) throws SystemException {
		return findByFacultyPeriod(facultyId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact ir submissions where facultyId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param start the lower bound of the range of fact ir submissions
	 * @param end the upper bound of the range of fact ir submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrSubmission> findByFacultyPeriod(long facultyId,
		String period, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTYPERIOD;
			finderArgs = new Object[] { facultyId, period };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FACULTYPERIOD;
			finderArgs = new Object[] {
					facultyId, period,
					
					start, end, orderByComparator
				};
		}

		List<FactIrSubmission> list = (List<FactIrSubmission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactIrSubmission factIrSubmission : list) {
				if ((facultyId != factIrSubmission.getFacultyId()) ||
						!Validator.equals(period, factIrSubmission.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTIRSUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_FACULTYPERIOD_FACULTYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactIrSubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facultyId);

				if (bindPeriod) {
					qPos.add(period);
				}

				if (!pagination) {
					list = (List<FactIrSubmission>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIrSubmission>(list);
				}
				else {
					list = (List<FactIrSubmission>)QueryUtil.list(q,
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
	 * Returns the first fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir submission
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a matching fact ir submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission findByFacultyPeriod_First(long facultyId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactIrSubmissionException, SystemException {
		FactIrSubmission factIrSubmission = fetchByFacultyPeriod_First(facultyId,
				period, orderByComparator);

		if (factIrSubmission != null) {
			return factIrSubmission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facultyId=");
		msg.append(facultyId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrSubmissionException(msg.toString());
	}

	/**
	 * Returns the first fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir submission, or <code>null</code> if a matching fact ir submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission fetchByFacultyPeriod_First(long facultyId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactIrSubmission> list = findByFacultyPeriod(facultyId, period, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir submission
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a matching fact ir submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission findByFacultyPeriod_Last(long facultyId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactIrSubmissionException, SystemException {
		FactIrSubmission factIrSubmission = fetchByFacultyPeriod_Last(facultyId,
				period, orderByComparator);

		if (factIrSubmission != null) {
			return factIrSubmission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facultyId=");
		msg.append(facultyId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrSubmissionException(msg.toString());
	}

	/**
	 * Returns the last fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir submission, or <code>null</code> if a matching fact ir submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission fetchByFacultyPeriod_Last(long facultyId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFacultyPeriod(facultyId, period);

		if (count == 0) {
			return null;
		}

		List<FactIrSubmission> list = findByFacultyPeriod(facultyId, period,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact ir submissions before and after the current fact ir submission in the ordered set where facultyId = &#63; and period = &#63;.
	 *
	 * @param submissionId the primary key of the current fact ir submission
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact ir submission
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission[] findByFacultyPeriod_PrevAndNext(
		long submissionId, long facultyId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactIrSubmissionException, SystemException {
		FactIrSubmission factIrSubmission = findByPrimaryKey(submissionId);

		Session session = null;

		try {
			session = openSession();

			FactIrSubmission[] array = new FactIrSubmissionImpl[3];

			array[0] = getByFacultyPeriod_PrevAndNext(session,
					factIrSubmission, facultyId, period, orderByComparator, true);

			array[1] = factIrSubmission;

			array[2] = getByFacultyPeriod_PrevAndNext(session,
					factIrSubmission, facultyId, period, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactIrSubmission getByFacultyPeriod_PrevAndNext(Session session,
		FactIrSubmission factIrSubmission, long facultyId, String period,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTIRSUBMISSION_WHERE);

		query.append(_FINDER_COLUMN_FACULTYPERIOD_FACULTYID_2);

		boolean bindPeriod = false;

		if (period == null) {
			query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_1);
		}
		else if (period.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_3);
		}
		else {
			bindPeriod = true;

			query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_2);
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
			query.append(FactIrSubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(facultyId);

		if (bindPeriod) {
			qPos.add(period);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factIrSubmission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactIrSubmission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact ir submissions where facultyId = &#63; and period = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFacultyPeriod(long facultyId, String period)
		throws SystemException {
		for (FactIrSubmission factIrSubmission : findByFacultyPeriod(
				facultyId, period, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factIrSubmission);
		}
	}

	/**
	 * Returns the number of fact ir submissions where facultyId = &#63; and period = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @return the number of matching fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFacultyPeriod(long facultyId, String period)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FACULTYPERIOD;

		Object[] finderArgs = new Object[] { facultyId, period };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FACTIRSUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_FACULTYPERIOD_FACULTYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_FACULTYPERIOD_PERIOD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facultyId);

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

	private static final String _FINDER_COLUMN_FACULTYPERIOD_FACULTYID_2 = "factIrSubmission.facultyId = ? AND ";
	private static final String _FINDER_COLUMN_FACULTYPERIOD_PERIOD_1 = "factIrSubmission.period IS NULL";
	private static final String _FINDER_COLUMN_FACULTYPERIOD_PERIOD_2 = "factIrSubmission.period = ?";
	private static final String _FINDER_COLUMN_FACULTYPERIOD_PERIOD_3 = "(factIrSubmission.period IS NULL OR factIrSubmission.period = '')";

	public FactIrSubmissionPersistenceImpl() {
		setModelClass(FactIrSubmission.class);
	}

	/**
	 * Caches the fact ir submission in the entity cache if it is enabled.
	 *
	 * @param factIrSubmission the fact ir submission
	 */
	@Override
	public void cacheResult(FactIrSubmission factIrSubmission) {
		EntityCacheUtil.putResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionImpl.class, factIrSubmission.getPrimaryKey(),
			factIrSubmission);

		factIrSubmission.resetOriginalValues();
	}

	/**
	 * Caches the fact ir submissions in the entity cache if it is enabled.
	 *
	 * @param factIrSubmissions the fact ir submissions
	 */
	@Override
	public void cacheResult(List<FactIrSubmission> factIrSubmissions) {
		for (FactIrSubmission factIrSubmission : factIrSubmissions) {
			if (EntityCacheUtil.getResult(
						FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
						FactIrSubmissionImpl.class,
						factIrSubmission.getPrimaryKey()) == null) {
				cacheResult(factIrSubmission);
			}
			else {
				factIrSubmission.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact ir submissions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactIrSubmissionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactIrSubmissionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact ir submission.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactIrSubmission factIrSubmission) {
		EntityCacheUtil.removeResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionImpl.class, factIrSubmission.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactIrSubmission> factIrSubmissions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactIrSubmission factIrSubmission : factIrSubmissions) {
			EntityCacheUtil.removeResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
				FactIrSubmissionImpl.class, factIrSubmission.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact ir submission with the primary key. Does not add the fact ir submission to the database.
	 *
	 * @param submissionId the primary key for the new fact ir submission
	 * @return the new fact ir submission
	 */
	@Override
	public FactIrSubmission create(long submissionId) {
		FactIrSubmission factIrSubmission = new FactIrSubmissionImpl();

		factIrSubmission.setNew(true);
		factIrSubmission.setPrimaryKey(submissionId);

		return factIrSubmission;
	}

	/**
	 * Removes the fact ir submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submissionId the primary key of the fact ir submission
	 * @return the fact ir submission that was removed
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission remove(long submissionId)
		throws NoSuchFactIrSubmissionException, SystemException {
		return remove((Serializable)submissionId);
	}

	/**
	 * Removes the fact ir submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact ir submission
	 * @return the fact ir submission that was removed
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission remove(Serializable primaryKey)
		throws NoSuchFactIrSubmissionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactIrSubmission factIrSubmission = (FactIrSubmission)session.get(FactIrSubmissionImpl.class,
					primaryKey);

			if (factIrSubmission == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactIrSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factIrSubmission);
		}
		catch (NoSuchFactIrSubmissionException nsee) {
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
	protected FactIrSubmission removeImpl(FactIrSubmission factIrSubmission)
		throws SystemException {
		factIrSubmission = toUnwrappedModel(factIrSubmission);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factIrSubmission)) {
				factIrSubmission = (FactIrSubmission)session.get(FactIrSubmissionImpl.class,
						factIrSubmission.getPrimaryKeyObj());
			}

			if (factIrSubmission != null) {
				session.delete(factIrSubmission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factIrSubmission != null) {
			clearCache(factIrSubmission);
		}

		return factIrSubmission;
	}

	@Override
	public FactIrSubmission updateImpl(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission)
		throws SystemException {
		factIrSubmission = toUnwrappedModel(factIrSubmission);

		boolean isNew = factIrSubmission.isNew();

		FactIrSubmissionModelImpl factIrSubmissionModelImpl = (FactIrSubmissionModelImpl)factIrSubmission;

		Session session = null;

		try {
			session = openSession();

			if (factIrSubmission.isNew()) {
				session.save(factIrSubmission);

				factIrSubmission.setNew(false);
			}
			else {
				session.merge(factIrSubmission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactIrSubmissionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factIrSubmissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factIrSubmissionModelImpl.getOriginalFacultyId(),
						factIrSubmissionModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACULTYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTYPERIOD,
					args);

				args = new Object[] {
						factIrSubmissionModelImpl.getFacultyId(),
						factIrSubmissionModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACULTYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACULTYPERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
			FactIrSubmissionImpl.class, factIrSubmission.getPrimaryKey(),
			factIrSubmission);

		return factIrSubmission;
	}

	protected FactIrSubmission toUnwrappedModel(
		FactIrSubmission factIrSubmission) {
		if (factIrSubmission instanceof FactIrSubmissionImpl) {
			return factIrSubmission;
		}

		FactIrSubmissionImpl factIrSubmissionImpl = new FactIrSubmissionImpl();

		factIrSubmissionImpl.setNew(factIrSubmission.isNew());
		factIrSubmissionImpl.setPrimaryKey(factIrSubmission.getPrimaryKey());

		factIrSubmissionImpl.setSubmissionId(factIrSubmission.getSubmissionId());
		factIrSubmissionImpl.setLibraryId(factIrSubmission.getLibraryId());
		factIrSubmissionImpl.setFacultyId(factIrSubmission.getFacultyId());
		factIrSubmissionImpl.setPeriod(factIrSubmission.getPeriod());
		factIrSubmissionImpl.setItemMediumId(factIrSubmission.getItemMediumId());
		factIrSubmissionImpl.setTitleTotal(factIrSubmission.getTitleTotal());
		factIrSubmissionImpl.setVolumeTotal(factIrSubmission.getVolumeTotal());
		factIrSubmissionImpl.setCreatedByUserId(factIrSubmission.getCreatedByUserId());
		factIrSubmissionImpl.setCreatedByUserName(factIrSubmission.getCreatedByUserName());
		factIrSubmissionImpl.setCreatedDate(factIrSubmission.getCreatedDate());

		return factIrSubmissionImpl;
	}

	/**
	 * Returns the fact ir submission with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact ir submission
	 * @return the fact ir submission
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactIrSubmissionException, SystemException {
		FactIrSubmission factIrSubmission = fetchByPrimaryKey(primaryKey);

		if (factIrSubmission == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactIrSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factIrSubmission;
	}

	/**
	 * Returns the fact ir submission with the primary key or throws a {@link com.idetronic.eis.NoSuchFactIrSubmissionException} if it could not be found.
	 *
	 * @param submissionId the primary key of the fact ir submission
	 * @return the fact ir submission
	 * @throws com.idetronic.eis.NoSuchFactIrSubmissionException if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission findByPrimaryKey(long submissionId)
		throws NoSuchFactIrSubmissionException, SystemException {
		return findByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns the fact ir submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact ir submission
	 * @return the fact ir submission, or <code>null</code> if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactIrSubmission factIrSubmission = (FactIrSubmission)EntityCacheUtil.getResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
				FactIrSubmissionImpl.class, primaryKey);

		if (factIrSubmission == _nullFactIrSubmission) {
			return null;
		}

		if (factIrSubmission == null) {
			Session session = null;

			try {
				session = openSession();

				factIrSubmission = (FactIrSubmission)session.get(FactIrSubmissionImpl.class,
						primaryKey);

				if (factIrSubmission != null) {
					cacheResult(factIrSubmission);
				}
				else {
					EntityCacheUtil.putResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
						FactIrSubmissionImpl.class, primaryKey,
						_nullFactIrSubmission);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactIrSubmissionModelImpl.ENTITY_CACHE_ENABLED,
					FactIrSubmissionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factIrSubmission;
	}

	/**
	 * Returns the fact ir submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submissionId the primary key of the fact ir submission
	 * @return the fact ir submission, or <code>null</code> if a fact ir submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrSubmission fetchByPrimaryKey(long submissionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)submissionId);
	}

	/**
	 * Returns all the fact ir submissions.
	 *
	 * @return the fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrSubmission> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact ir submissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact ir submissions
	 * @param end the upper bound of the range of fact ir submissions (not inclusive)
	 * @return the range of fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrSubmission> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact ir submissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact ir submissions
	 * @param end the upper bound of the range of fact ir submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact ir submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrSubmission> findAll(int start, int end,
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

		List<FactIrSubmission> list = (List<FactIrSubmission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTIRSUBMISSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTIRSUBMISSION;

				if (pagination) {
					sql = sql.concat(FactIrSubmissionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactIrSubmission>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIrSubmission>(list);
				}
				else {
					list = (List<FactIrSubmission>)QueryUtil.list(q,
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
	 * Removes all the fact ir submissions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactIrSubmission factIrSubmission : findAll()) {
			remove(factIrSubmission);
		}
	}

	/**
	 * Returns the number of fact ir submissions.
	 *
	 * @return the number of fact ir submissions
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

				Query q = session.createQuery(_SQL_COUNT_FACTIRSUBMISSION);

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
	 * Initializes the fact ir submission persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactIrSubmission")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactIrSubmission>> listenersList = new ArrayList<ModelListener<FactIrSubmission>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactIrSubmission>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactIrSubmissionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTIRSUBMISSION = "SELECT factIrSubmission FROM FactIrSubmission factIrSubmission";
	private static final String _SQL_SELECT_FACTIRSUBMISSION_WHERE = "SELECT factIrSubmission FROM FactIrSubmission factIrSubmission WHERE ";
	private static final String _SQL_COUNT_FACTIRSUBMISSION = "SELECT COUNT(factIrSubmission) FROM FactIrSubmission factIrSubmission";
	private static final String _SQL_COUNT_FACTIRSUBMISSION_WHERE = "SELECT COUNT(factIrSubmission) FROM FactIrSubmission factIrSubmission WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factIrSubmission.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactIrSubmission exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactIrSubmission exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactIrSubmissionPersistenceImpl.class);
	private static FactIrSubmission _nullFactIrSubmission = new FactIrSubmissionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactIrSubmission> toCacheModel() {
				return _nullFactIrSubmissionCacheModel;
			}
		};

	private static CacheModel<FactIrSubmission> _nullFactIrSubmissionCacheModel = new CacheModel<FactIrSubmission>() {
			@Override
			public FactIrSubmission toEntityModel() {
				return _nullFactIrSubmission;
			}
		};
}
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

import com.idetronic.eis.NoSuchUserReportException;
import com.idetronic.eis.model.UserReport;
import com.idetronic.eis.model.impl.UserReportImpl;
import com.idetronic.eis.model.impl.UserReportModelImpl;

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
 * The persistence implementation for the user report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserReportPersistence
 * @see UserReportUtil
 * @generated
 */
public class UserReportPersistenceImpl extends BasePersistenceImpl<UserReport>
	implements UserReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserReportUtil} to access the user report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERDATALIBRARY = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserDataLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			UserReportModelImpl.USERID_COLUMN_BITMASK |
			UserReportModelImpl.LIBRARYID_COLUMN_BITMASK |
			UserReportModelImpl.REPORTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERDATALIBRARY = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserDataLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param reportId the report ID
	 * @return the matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByUserDataLibrary(long userId, long libraryId,
		long reportId) throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByUserDataLibrary(userId, libraryId,
				reportId);

		if (userReport == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", libraryId=");
			msg.append(libraryId);

			msg.append(", reportId=");
			msg.append(reportId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserReportException(msg.toString());
		}

		return userReport;
	}

	/**
	 * Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param reportId the report ID
	 * @return the matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUserDataLibrary(long userId, long libraryId,
		long reportId) throws SystemException {
		return fetchByUserDataLibrary(userId, libraryId, reportId, true);
	}

	/**
	 * Returns the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param reportId the report ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUserDataLibrary(long userId, long libraryId,
		long reportId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, libraryId, reportId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
					finderArgs, this);
		}

		if (result instanceof UserReport) {
			UserReport userReport = (UserReport)result;

			if ((userId != userReport.getUserId()) ||
					(libraryId != userReport.getLibraryId()) ||
					(reportId != userReport.getReportId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USERDATALIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERDATALIBRARY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_USERDATALIBRARY_REPORTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(libraryId);

				qPos.add(reportId);

				List<UserReport> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
						finderArgs, list);
				}
				else {
					UserReport userReport = list.get(0);

					result = userReport;

					cacheResult(userReport);

					if ((userReport.getUserId() != userId) ||
							(userReport.getLibraryId() != libraryId) ||
							(userReport.getReportId() != reportId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
							finderArgs, userReport);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
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
			return (UserReport)result;
		}
	}

	/**
	 * Removes the user report where userId = &#63; and libraryId = &#63; and reportId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param reportId the report ID
	 * @return the user report that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport removeByUserDataLibrary(long userId, long libraryId,
		long reportId) throws NoSuchUserReportException, SystemException {
		UserReport userReport = findByUserDataLibrary(userId, libraryId,
				reportId);

		return remove(userReport);
	}

	/**
	 * Returns the number of user reports where userId = &#63; and libraryId = &#63; and reportId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param reportId the report ID
	 * @return the number of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserDataLibrary(long userId, long libraryId, long reportId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERDATALIBRARY;

		Object[] finderArgs = new Object[] { userId, libraryId, reportId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USERDATALIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERDATALIBRARY_LIBRARYID_2);

			query.append(_FINDER_COLUMN_USERDATALIBRARY_REPORTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(libraryId);

				qPos.add(reportId);

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

	private static final String _FINDER_COLUMN_USERDATALIBRARY_USERID_2 = "userReport.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERDATALIBRARY_LIBRARYID_2 = "userReport.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_USERDATALIBRARY_REPORTID_2 = "userReport.reportId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			UserReportModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user reports where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByUser(long userId) throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user reports where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @return the range of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user reports where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UserReport> list = (List<UserReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserReport userReport : list) {
				if ((userId != userReport.getUserId())) {
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

			query.append(_SQL_SELECT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserReport>(list);
				}
				else {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByUser_First(userId, orderByComparator);

		if (userReport != null) {
			return userReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserReportException(msg.toString());
	}

	/**
	 * Returns the first user report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserReport> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByUser_Last(userId, orderByComparator);

		if (userReport != null) {
			return userReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserReportException(msg.toString());
	}

	/**
	 * Returns the last user report in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<UserReport> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user reports before and after the current user report in the ordered set where userId = &#63;.
	 *
	 * @param userReportId the primary key of the current user report
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport[] findByUser_PrevAndNext(long userReportId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = findByPrimaryKey(userReportId);

		Session session = null;

		try {
			session = openSession();

			UserReport[] array = new UserReportImpl[3];

			array[0] = getByUser_PrevAndNext(session, userReport, userId,
					orderByComparator, true);

			array[1] = userReport;

			array[2] = getByUser_PrevAndNext(session, userReport, userId,
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

	protected UserReport getByUser_PrevAndNext(Session session,
		UserReport userReport, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERREPORT_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(UserReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user reports where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (UserReport userReport : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userReport);
		}
	}

	/**
	 * Returns the number of user reports where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "userReport.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORT = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReport",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT =
		new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReport",
			new String[] { Long.class.getName() },
			UserReportModelImpl.REPORTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORT = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReport",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user reports where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByReport(long reportId)
		throws SystemException {
		return findByReport(reportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user reports where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @return the range of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByReport(long reportId, int start, int end)
		throws SystemException {
		return findByReport(reportId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user reports where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByReport(long reportId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT;
			finderArgs = new Object[] { reportId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORT;
			finderArgs = new Object[] { reportId, start, end, orderByComparator };
		}

		List<UserReport> list = (List<UserReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserReport userReport : list) {
				if ((reportId != userReport.getReportId())) {
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

			query.append(_SQL_SELECT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_REPORT_REPORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				if (!pagination) {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserReport>(list);
				}
				else {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user report in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByReport_First(long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByReport_First(reportId, orderByComparator);

		if (userReport != null) {
			return userReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserReportException(msg.toString());
	}

	/**
	 * Returns the first user report in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByReport_First(long reportId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserReport> list = findByReport(reportId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user report in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByReport_Last(long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByReport_Last(reportId, orderByComparator);

		if (userReport != null) {
			return userReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserReportException(msg.toString());
	}

	/**
	 * Returns the last user report in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByReport_Last(long reportId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReport(reportId);

		if (count == 0) {
			return null;
		}

		List<UserReport> list = findByReport(reportId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user reports before and after the current user report in the ordered set where reportId = &#63;.
	 *
	 * @param userReportId the primary key of the current user report
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport[] findByReport_PrevAndNext(long userReportId,
		long reportId, OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = findByPrimaryKey(userReportId);

		Session session = null;

		try {
			session = openSession();

			UserReport[] array = new UserReportImpl[3];

			array[0] = getByReport_PrevAndNext(session, userReport, reportId,
					orderByComparator, true);

			array[1] = userReport;

			array[2] = getByReport_PrevAndNext(session, userReport, reportId,
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

	protected UserReport getByReport_PrevAndNext(Session session,
		UserReport userReport, long reportId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERREPORT_WHERE);

		query.append(_FINDER_COLUMN_REPORT_REPORTID_2);

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
			query.append(UserReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user reports where reportId = &#63; from the database.
	 *
	 * @param reportId the report ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReport(long reportId) throws SystemException {
		for (UserReport userReport : findByReport(reportId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userReport);
		}
	}

	/**
	 * Returns the number of user reports where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the number of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReport(long reportId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORT;

		Object[] finderArgs = new Object[] { reportId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_REPORT_REPORTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

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

	private static final String _FINDER_COLUMN_REPORT_REPORTID_2 = "userReport.reportId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDLIBRARY =
		new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserAndLibrary",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDLIBRARY =
		new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserAndLibrary",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserReportModelImpl.USERID_COLUMN_BITMASK |
			UserReportModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERANDLIBRARY = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserAndLibrary",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user reports where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByUserAndLibrary(long userId, long libraryId)
		throws SystemException {
		return findByUserAndLibrary(userId, libraryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user reports where userId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @return the range of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByUserAndLibrary(long userId, long libraryId,
		int start, int end) throws SystemException {
		return findByUserAndLibrary(userId, libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user reports where userId = &#63; and libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findByUserAndLibrary(long userId, long libraryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDLIBRARY;
			finderArgs = new Object[] { userId, libraryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDLIBRARY;
			finderArgs = new Object[] {
					userId, libraryId,
					
					start, end, orderByComparator
				};
		}

		List<UserReport> list = (List<UserReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserReport userReport : list) {
				if ((userId != userReport.getUserId()) ||
						(libraryId != userReport.getLibraryId())) {
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

			query.append(_SQL_SELECT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USERANDLIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERANDLIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserReport>(list);
				}
				else {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user report in the ordered set where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByUserAndLibrary_First(long userId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByUserAndLibrary_First(userId, libraryId,
				orderByComparator);

		if (userReport != null) {
			return userReport;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserReportException(msg.toString());
	}

	/**
	 * Returns the first user report in the ordered set where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUserAndLibrary_First(long userId, long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserReport> list = findByUserAndLibrary(userId, libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user report in the ordered set where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByUserAndLibrary_Last(long userId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByUserAndLibrary_Last(userId, libraryId,
				orderByComparator);

		if (userReport != null) {
			return userReport;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserReportException(msg.toString());
	}

	/**
	 * Returns the last user report in the ordered set where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUserAndLibrary_Last(long userId, long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserAndLibrary(userId, libraryId);

		if (count == 0) {
			return null;
		}

		List<UserReport> list = findByUserAndLibrary(userId, libraryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user reports before and after the current user report in the ordered set where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userReportId the primary key of the current user report
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport[] findByUserAndLibrary_PrevAndNext(long userReportId,
		long userId, long libraryId, OrderByComparator orderByComparator)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = findByPrimaryKey(userReportId);

		Session session = null;

		try {
			session = openSession();

			UserReport[] array = new UserReportImpl[3];

			array[0] = getByUserAndLibrary_PrevAndNext(session, userReport,
					userId, libraryId, orderByComparator, true);

			array[1] = userReport;

			array[2] = getByUserAndLibrary_PrevAndNext(session, userReport,
					userId, libraryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserReport getByUserAndLibrary_PrevAndNext(Session session,
		UserReport userReport, long userId, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERREPORT_WHERE);

		query.append(_FINDER_COLUMN_USERANDLIBRARY_USERID_2);

		query.append(_FINDER_COLUMN_USERANDLIBRARY_LIBRARYID_2);

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
			query.append(UserReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user reports where userId = &#63; and libraryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserAndLibrary(long userId, long libraryId)
		throws SystemException {
		for (UserReport userReport : findByUserAndLibrary(userId, libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userReport);
		}
	}

	/**
	 * Returns the number of user reports where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the number of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserAndLibrary(long userId, long libraryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERANDLIBRARY;

		Object[] finderArgs = new Object[] { userId, libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USERANDLIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERANDLIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERANDLIBRARY_USERID_2 = "userReport.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERANDLIBRARY_LIBRARYID_2 = "userReport.libraryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERLIBRARY = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, UserReportImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserLibrary",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserReportModelImpl.USERID_COLUMN_BITMASK |
			UserReportModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERLIBRARY = new FinderPath(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserLibrary",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the user report where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the matching user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByUserLibrary(long userId, long libraryId)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByUserLibrary(userId, libraryId);

		if (userReport == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", libraryId=");
			msg.append(libraryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserReportException(msg.toString());
		}

		return userReport;
	}

	/**
	 * Returns the user report where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUserLibrary(long userId, long libraryId)
		throws SystemException {
		return fetchByUserLibrary(userId, libraryId, true);
	}

	/**
	 * Returns the user report where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user report, or <code>null</code> if a matching user report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByUserLibrary(long userId, long libraryId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, libraryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
					finderArgs, this);
		}

		if (result instanceof UserReport) {
			UserReport userReport = (UserReport)result;

			if ((userId != userReport.getUserId()) ||
					(libraryId != userReport.getLibraryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USERLIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERLIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(libraryId);

				List<UserReport> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserReportPersistenceImpl.fetchByUserLibrary(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserReport userReport = list.get(0);

					result = userReport;

					cacheResult(userReport);

					if ((userReport.getUserId() != userId) ||
							(userReport.getLibraryId() != libraryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
							finderArgs, userReport);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
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
			return (UserReport)result;
		}
	}

	/**
	 * Removes the user report where userId = &#63; and libraryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the user report that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport removeByUserLibrary(long userId, long libraryId)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = findByUserLibrary(userId, libraryId);

		return remove(userReport);
	}

	/**
	 * Returns the number of user reports where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the number of matching user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserLibrary(long userId, long libraryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERLIBRARY;

		Object[] finderArgs = new Object[] { userId, libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERREPORT_WHERE);

			query.append(_FINDER_COLUMN_USERLIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERLIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERLIBRARY_USERID_2 = "userReport.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERLIBRARY_LIBRARYID_2 = "userReport.libraryId = ?";

	public UserReportPersistenceImpl() {
		setModelClass(UserReport.class);
	}

	/**
	 * Caches the user report in the entity cache if it is enabled.
	 *
	 * @param userReport the user report
	 */
	@Override
	public void cacheResult(UserReport userReport) {
		EntityCacheUtil.putResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportImpl.class, userReport.getPrimaryKey(), userReport);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
			new Object[] {
				userReport.getUserId(), userReport.getLibraryId(),
				userReport.getReportId()
			}, userReport);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
			new Object[] { userReport.getUserId(), userReport.getLibraryId() },
			userReport);

		userReport.resetOriginalValues();
	}

	/**
	 * Caches the user reports in the entity cache if it is enabled.
	 *
	 * @param userReports the user reports
	 */
	@Override
	public void cacheResult(List<UserReport> userReports) {
		for (UserReport userReport : userReports) {
			if (EntityCacheUtil.getResult(
						UserReportModelImpl.ENTITY_CACHE_ENABLED,
						UserReportImpl.class, userReport.getPrimaryKey()) == null) {
				cacheResult(userReport);
			}
			else {
				userReport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user reports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserReportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserReportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user report.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserReport userReport) {
		EntityCacheUtil.removeResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportImpl.class, userReport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userReport);
	}

	@Override
	public void clearCache(List<UserReport> userReports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserReport userReport : userReports) {
			EntityCacheUtil.removeResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
				UserReportImpl.class, userReport.getPrimaryKey());

			clearUniqueFindersCache(userReport);
		}
	}

	protected void cacheUniqueFindersCache(UserReport userReport) {
		if (userReport.isNew()) {
			Object[] args = new Object[] {
					userReport.getUserId(), userReport.getLibraryId(),
					userReport.getReportId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERDATALIBRARY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
				args, userReport);

			args = new Object[] {
					userReport.getUserId(), userReport.getLibraryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERLIBRARY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY, args,
				userReport);
		}
		else {
			UserReportModelImpl userReportModelImpl = (UserReportModelImpl)userReport;

			if ((userReportModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERDATALIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userReport.getUserId(), userReport.getLibraryId(),
						userReport.getReportId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERDATALIBRARY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
					args, userReport);
			}

			if ((userReportModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERLIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userReport.getUserId(), userReport.getLibraryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERLIBRARY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
					args, userReport);
			}
		}
	}

	protected void clearUniqueFindersCache(UserReport userReport) {
		UserReportModelImpl userReportModelImpl = (UserReportModelImpl)userReport;

		Object[] args = new Object[] {
				userReport.getUserId(), userReport.getLibraryId(),
				userReport.getReportId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERDATALIBRARY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY, args);

		if ((userReportModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERDATALIBRARY.getColumnBitmask()) != 0) {
			args = new Object[] {
					userReportModelImpl.getOriginalUserId(),
					userReportModelImpl.getOriginalLibraryId(),
					userReportModelImpl.getOriginalReportId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERDATALIBRARY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERDATALIBRARY,
				args);
		}

		args = new Object[] { userReport.getUserId(), userReport.getLibraryId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLIBRARY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERLIBRARY, args);

		if ((userReportModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERLIBRARY.getColumnBitmask()) != 0) {
			args = new Object[] {
					userReportModelImpl.getOriginalUserId(),
					userReportModelImpl.getOriginalLibraryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLIBRARY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERLIBRARY, args);
		}
	}

	/**
	 * Creates a new user report with the primary key. Does not add the user report to the database.
	 *
	 * @param userReportId the primary key for the new user report
	 * @return the new user report
	 */
	@Override
	public UserReport create(long userReportId) {
		UserReport userReport = new UserReportImpl();

		userReport.setNew(true);
		userReport.setPrimaryKey(userReportId);

		return userReport;
	}

	/**
	 * Removes the user report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userReportId the primary key of the user report
	 * @return the user report that was removed
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport remove(long userReportId)
		throws NoSuchUserReportException, SystemException {
		return remove((Serializable)userReportId);
	}

	/**
	 * Removes the user report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user report
	 * @return the user report that was removed
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport remove(Serializable primaryKey)
		throws NoSuchUserReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserReport userReport = (UserReport)session.get(UserReportImpl.class,
					primaryKey);

			if (userReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userReport);
		}
		catch (NoSuchUserReportException nsee) {
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
	protected UserReport removeImpl(UserReport userReport)
		throws SystemException {
		userReport = toUnwrappedModel(userReport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userReport)) {
				userReport = (UserReport)session.get(UserReportImpl.class,
						userReport.getPrimaryKeyObj());
			}

			if (userReport != null) {
				session.delete(userReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userReport != null) {
			clearCache(userReport);
		}

		return userReport;
	}

	@Override
	public UserReport updateImpl(com.idetronic.eis.model.UserReport userReport)
		throws SystemException {
		userReport = toUnwrappedModel(userReport);

		boolean isNew = userReport.isNew();

		UserReportModelImpl userReportModelImpl = (UserReportModelImpl)userReport;

		Session session = null;

		try {
			session = openSession();

			if (userReport.isNew()) {
				session.save(userReport);

				userReport.setNew(false);
			}
			else {
				session.merge(userReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserReportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userReportModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { userReportModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((userReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userReportModelImpl.getOriginalReportId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT,
					args);

				args = new Object[] { userReportModelImpl.getReportId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORT,
					args);
			}

			if ((userReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDLIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userReportModelImpl.getOriginalUserId(),
						userReportModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDLIBRARY,
					args);

				args = new Object[] {
						userReportModelImpl.getUserId(),
						userReportModelImpl.getLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDLIBRARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDLIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
			UserReportImpl.class, userReport.getPrimaryKey(), userReport);

		clearUniqueFindersCache(userReport);
		cacheUniqueFindersCache(userReport);

		return userReport;
	}

	protected UserReport toUnwrappedModel(UserReport userReport) {
		if (userReport instanceof UserReportImpl) {
			return userReport;
		}

		UserReportImpl userReportImpl = new UserReportImpl();

		userReportImpl.setNew(userReport.isNew());
		userReportImpl.setPrimaryKey(userReport.getPrimaryKey());

		userReportImpl.setUserReportId(userReport.getUserReportId());
		userReportImpl.setUserId(userReport.getUserId());
		userReportImpl.setLibraryId(userReport.getLibraryId());
		userReportImpl.setReportId(userReport.getReportId());
		userReportImpl.setCreatedByUserId(userReport.getCreatedByUserId());
		userReportImpl.setUserName(userReport.getUserName());
		userReportImpl.setCreateDate(userReport.getCreateDate());

		return userReportImpl;
	}

	/**
	 * Returns the user report with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user report
	 * @return the user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserReportException, SystemException {
		UserReport userReport = fetchByPrimaryKey(primaryKey);

		if (userReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userReport;
	}

	/**
	 * Returns the user report with the primary key or throws a {@link com.idetronic.eis.NoSuchUserReportException} if it could not be found.
	 *
	 * @param userReportId the primary key of the user report
	 * @return the user report
	 * @throws com.idetronic.eis.NoSuchUserReportException if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport findByPrimaryKey(long userReportId)
		throws NoSuchUserReportException, SystemException {
		return findByPrimaryKey((Serializable)userReportId);
	}

	/**
	 * Returns the user report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user report
	 * @return the user report, or <code>null</code> if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserReport userReport = (UserReport)EntityCacheUtil.getResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
				UserReportImpl.class, primaryKey);

		if (userReport == _nullUserReport) {
			return null;
		}

		if (userReport == null) {
			Session session = null;

			try {
				session = openSession();

				userReport = (UserReport)session.get(UserReportImpl.class,
						primaryKey);

				if (userReport != null) {
					cacheResult(userReport);
				}
				else {
					EntityCacheUtil.putResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
						UserReportImpl.class, primaryKey, _nullUserReport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserReportModelImpl.ENTITY_CACHE_ENABLED,
					UserReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userReport;
	}

	/**
	 * Returns the user report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userReportId the primary key of the user report
	 * @return the user report, or <code>null</code> if a user report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserReport fetchByPrimaryKey(long userReportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userReportId);
	}

	/**
	 * Returns all the user reports.
	 *
	 * @return the user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @return the range of user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user reports
	 * @param end the upper bound of the range of user reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserReport> findAll(int start, int end,
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

		List<UserReport> list = (List<UserReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERREPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERREPORT;

				if (pagination) {
					sql = sql.concat(UserReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserReport>(list);
				}
				else {
					list = (List<UserReport>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user reports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserReport userReport : findAll()) {
			remove(userReport);
		}
	}

	/**
	 * Returns the number of user reports.
	 *
	 * @return the number of user reports
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

				Query q = session.createQuery(_SQL_COUNT_USERREPORT);

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
	 * Initializes the user report persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.UserReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserReport>> listenersList = new ArrayList<ModelListener<UserReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserReport>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserReportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERREPORT = "SELECT userReport FROM UserReport userReport";
	private static final String _SQL_SELECT_USERREPORT_WHERE = "SELECT userReport FROM UserReport userReport WHERE ";
	private static final String _SQL_COUNT_USERREPORT = "SELECT COUNT(userReport) FROM UserReport userReport";
	private static final String _SQL_COUNT_USERREPORT_WHERE = "SELECT COUNT(userReport) FROM UserReport userReport WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userReport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserReport exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserReport exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserReportPersistenceImpl.class);
	private static UserReport _nullUserReport = new UserReportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserReport> toCacheModel() {
				return _nullUserReportCacheModel;
			}
		};

	private static CacheModel<UserReport> _nullUserReportCacheModel = new CacheModel<UserReport>() {
			@Override
			public UserReport toEntityModel() {
				return _nullUserReport;
			}
		};
}
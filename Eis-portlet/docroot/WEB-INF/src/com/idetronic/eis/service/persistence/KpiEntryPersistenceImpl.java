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

import com.idetronic.eis.NoSuchKpiEntryException;
import com.idetronic.eis.model.KpiEntry;
import com.idetronic.eis.model.impl.KpiEntryImpl;
import com.idetronic.eis.model.impl.KpiEntryModelImpl;

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
 * The persistence implementation for the kpi entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see KpiEntryPersistence
 * @see KpiEntryUtil
 * @generated
 */
public class KpiEntryPersistenceImpl extends BasePersistenceImpl<KpiEntry>
	implements KpiEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KpiEntryUtil} to access the kpi entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KpiEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, KpiEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, KpiEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPEPERIOD = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, KpiEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTypePeriod",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			KpiEntryModelImpl.KPITYPEID_COLUMN_BITMASK |
			KpiEntryModelImpl.PERIODTYPE_COLUMN_BITMASK |
			KpiEntryModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEPERIOD = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypePeriod",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or throws a {@link com.idetronic.eis.NoSuchKpiEntryException} if it could not be found.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodType the period type
	 * @param period the period
	 * @return the matching kpi entry
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry findByTypePeriod(long kpiTypeId, int periodType,
		String period) throws NoSuchKpiEntryException, SystemException {
		KpiEntry kpiEntry = fetchByTypePeriod(kpiTypeId, periodType, period);

		if (kpiEntry == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kpiTypeId=");
			msg.append(kpiTypeId);

			msg.append(", periodType=");
			msg.append(periodType);

			msg.append(", period=");
			msg.append(period);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKpiEntryException(msg.toString());
		}

		return kpiEntry;
	}

	/**
	 * Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodType the period type
	 * @param period the period
	 * @return the matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry fetchByTypePeriod(long kpiTypeId, int periodType,
		String period) throws SystemException {
		return fetchByTypePeriod(kpiTypeId, periodType, period, true);
	}

	/**
	 * Returns the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodType the period type
	 * @param period the period
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry fetchByTypePeriod(long kpiTypeId, int periodType,
		String period, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { kpiTypeId, periodType, period };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TYPEPERIOD,
					finderArgs, this);
		}

		if (result instanceof KpiEntry) {
			KpiEntry kpiEntry = (KpiEntry)result;

			if ((kpiTypeId != kpiEntry.getKpiTypeId()) ||
					(periodType != kpiEntry.getPeriodType()) ||
					!Validator.equals(period, kpiEntry.getPeriod())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_KPIENTRY_WHERE);

			query.append(_FINDER_COLUMN_TYPEPERIOD_KPITYPEID_2);

			query.append(_FINDER_COLUMN_TYPEPERIOD_PERIODTYPE_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_TYPEPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_TYPEPERIOD_PERIOD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kpiTypeId);

				qPos.add(periodType);

				if (bindPeriod) {
					qPos.add(period);
				}

				List<KpiEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEPERIOD,
						finderArgs, list);
				}
				else {
					KpiEntry kpiEntry = list.get(0);

					result = kpiEntry;

					cacheResult(kpiEntry);

					if ((kpiEntry.getKpiTypeId() != kpiTypeId) ||
							(kpiEntry.getPeriodType() != periodType) ||
							(kpiEntry.getPeriod() == null) ||
							!kpiEntry.getPeriod().equals(period)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEPERIOD,
							finderArgs, kpiEntry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEPERIOD,
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
			return (KpiEntry)result;
		}
	}

	/**
	 * Removes the kpi entry where kpiTypeId = &#63; and periodType = &#63; and period = &#63; from the database.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodType the period type
	 * @param period the period
	 * @return the kpi entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry removeByTypePeriod(long kpiTypeId, int periodType,
		String period) throws NoSuchKpiEntryException, SystemException {
		KpiEntry kpiEntry = findByTypePeriod(kpiTypeId, periodType, period);

		return remove(kpiEntry);
	}

	/**
	 * Returns the number of kpi entries where kpiTypeId = &#63; and periodType = &#63; and period = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodType the period type
	 * @param period the period
	 * @return the number of matching kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypePeriod(long kpiTypeId, int periodType, String period)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEPERIOD;

		Object[] finderArgs = new Object[] { kpiTypeId, periodType, period };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_KPIENTRY_WHERE);

			query.append(_FINDER_COLUMN_TYPEPERIOD_KPITYPEID_2);

			query.append(_FINDER_COLUMN_TYPEPERIOD_PERIODTYPE_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_TYPEPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_TYPEPERIOD_PERIOD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kpiTypeId);

				qPos.add(periodType);

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

	private static final String _FINDER_COLUMN_TYPEPERIOD_KPITYPEID_2 = "kpiEntry.kpiTypeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEPERIOD_PERIODTYPE_2 = "kpiEntry.periodType = ? AND ";
	private static final String _FINDER_COLUMN_TYPEPERIOD_PERIOD_1 = "kpiEntry.period IS NULL";
	private static final String _FINDER_COLUMN_TYPEPERIOD_PERIOD_2 = "kpiEntry.period = ?";
	private static final String _FINDER_COLUMN_TYPEPERIOD_PERIOD_3 = "(kpiEntry.period IS NULL OR kpiEntry.period = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARTYPE = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, KpiEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYearType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARTYPE =
		new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, KpiEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYearType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			KpiEntryModelImpl.KPITYPEID_COLUMN_BITMASK |
			KpiEntryModelImpl.PERIODYEAR_COLUMN_BITMASK |
			KpiEntryModelImpl.PERIODTYPE_COLUMN_BITMASK |
			KpiEntryModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEARTYPE = new FinderPath(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYearType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @return the matching kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiEntry> findByYearType(long kpiTypeId, String periodYear,
		int periodType) throws SystemException {
		return findByYearType(kpiTypeId, periodYear, periodType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param start the lower bound of the range of kpi entries
	 * @param end the upper bound of the range of kpi entries (not inclusive)
	 * @return the range of matching kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiEntry> findByYearType(long kpiTypeId, String periodYear,
		int periodType, int start, int end) throws SystemException {
		return findByYearType(kpiTypeId, periodYear, periodType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param start the lower bound of the range of kpi entries
	 * @param end the upper bound of the range of kpi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiEntry> findByYearType(long kpiTypeId, String periodYear,
		int periodType, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARTYPE;
			finderArgs = new Object[] { kpiTypeId, periodYear, periodType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEARTYPE;
			finderArgs = new Object[] {
					kpiTypeId, periodYear, periodType,
					
					start, end, orderByComparator
				};
		}

		List<KpiEntry> list = (List<KpiEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (KpiEntry kpiEntry : list) {
				if ((kpiTypeId != kpiEntry.getKpiTypeId()) ||
						!Validator.equals(periodYear, kpiEntry.getPeriodYear()) ||
						(periodType != kpiEntry.getPeriodType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_KPIENTRY_WHERE);

			query.append(_FINDER_COLUMN_YEARTYPE_KPITYPEID_2);

			boolean bindPeriodYear = false;

			if (periodYear == null) {
				query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_1);
			}
			else if (periodYear.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_3);
			}
			else {
				bindPeriodYear = true;

				query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_2);
			}

			query.append(_FINDER_COLUMN_YEARTYPE_PERIODTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KpiEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kpiTypeId);

				if (bindPeriodYear) {
					qPos.add(periodYear);
				}

				qPos.add(periodType);

				if (!pagination) {
					list = (List<KpiEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KpiEntry>(list);
				}
				else {
					list = (List<KpiEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kpi entry
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry findByYearType_First(long kpiTypeId, String periodYear,
		int periodType, OrderByComparator orderByComparator)
		throws NoSuchKpiEntryException, SystemException {
		KpiEntry kpiEntry = fetchByYearType_First(kpiTypeId, periodYear,
				periodType, orderByComparator);

		if (kpiEntry != null) {
			return kpiEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("kpiTypeId=");
		msg.append(kpiTypeId);

		msg.append(", periodYear=");
		msg.append(periodYear);

		msg.append(", periodType=");
		msg.append(periodType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKpiEntryException(msg.toString());
	}

	/**
	 * Returns the first kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry fetchByYearType_First(long kpiTypeId, String periodYear,
		int periodType, OrderByComparator orderByComparator)
		throws SystemException {
		List<KpiEntry> list = findByYearType(kpiTypeId, periodYear, periodType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kpi entry
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry findByYearType_Last(long kpiTypeId, String periodYear,
		int periodType, OrderByComparator orderByComparator)
		throws NoSuchKpiEntryException, SystemException {
		KpiEntry kpiEntry = fetchByYearType_Last(kpiTypeId, periodYear,
				periodType, orderByComparator);

		if (kpiEntry != null) {
			return kpiEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("kpiTypeId=");
		msg.append(kpiTypeId);

		msg.append(", periodYear=");
		msg.append(periodYear);

		msg.append(", periodType=");
		msg.append(periodType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKpiEntryException(msg.toString());
	}

	/**
	 * Returns the last kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kpi entry, or <code>null</code> if a matching kpi entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry fetchByYearType_Last(long kpiTypeId, String periodYear,
		int periodType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByYearType(kpiTypeId, periodYear, periodType);

		if (count == 0) {
			return null;
		}

		List<KpiEntry> list = findByYearType(kpiTypeId, periodYear, periodType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kpi entries before and after the current kpi entry in the ordered set where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiEntryId the primary key of the current kpi entry
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kpi entry
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry[] findByYearType_PrevAndNext(long kpiEntryId,
		long kpiTypeId, String periodYear, int periodType,
		OrderByComparator orderByComparator)
		throws NoSuchKpiEntryException, SystemException {
		KpiEntry kpiEntry = findByPrimaryKey(kpiEntryId);

		Session session = null;

		try {
			session = openSession();

			KpiEntry[] array = new KpiEntryImpl[3];

			array[0] = getByYearType_PrevAndNext(session, kpiEntry, kpiTypeId,
					periodYear, periodType, orderByComparator, true);

			array[1] = kpiEntry;

			array[2] = getByYearType_PrevAndNext(session, kpiEntry, kpiTypeId,
					periodYear, periodType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KpiEntry getByYearType_PrevAndNext(Session session,
		KpiEntry kpiEntry, long kpiTypeId, String periodYear, int periodType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KPIENTRY_WHERE);

		query.append(_FINDER_COLUMN_YEARTYPE_KPITYPEID_2);

		boolean bindPeriodYear = false;

		if (periodYear == null) {
			query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_1);
		}
		else if (periodYear.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_3);
		}
		else {
			bindPeriodYear = true;

			query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_2);
		}

		query.append(_FINDER_COLUMN_YEARTYPE_PERIODTYPE_2);

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
			query.append(KpiEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(kpiTypeId);

		if (bindPeriodYear) {
			qPos.add(periodYear);
		}

		qPos.add(periodType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kpiEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KpiEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63; from the database.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYearType(long kpiTypeId, String periodYear,
		int periodType) throws SystemException {
		for (KpiEntry kpiEntry : findByYearType(kpiTypeId, periodYear,
				periodType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kpiEntry);
		}
	}

	/**
	 * Returns the number of kpi entries where kpiTypeId = &#63; and periodYear = &#63; and periodType = &#63;.
	 *
	 * @param kpiTypeId the kpi type ID
	 * @param periodYear the period year
	 * @param periodType the period type
	 * @return the number of matching kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYearType(long kpiTypeId, String periodYear, int periodType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEARTYPE;

		Object[] finderArgs = new Object[] { kpiTypeId, periodYear, periodType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_KPIENTRY_WHERE);

			query.append(_FINDER_COLUMN_YEARTYPE_KPITYPEID_2);

			boolean bindPeriodYear = false;

			if (periodYear == null) {
				query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_1);
			}
			else if (periodYear.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_3);
			}
			else {
				bindPeriodYear = true;

				query.append(_FINDER_COLUMN_YEARTYPE_PERIODYEAR_2);
			}

			query.append(_FINDER_COLUMN_YEARTYPE_PERIODTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(kpiTypeId);

				if (bindPeriodYear) {
					qPos.add(periodYear);
				}

				qPos.add(periodType);

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

	private static final String _FINDER_COLUMN_YEARTYPE_KPITYPEID_2 = "kpiEntry.kpiTypeId = ? AND ";
	private static final String _FINDER_COLUMN_YEARTYPE_PERIODYEAR_1 = "kpiEntry.periodYear IS NULL AND ";
	private static final String _FINDER_COLUMN_YEARTYPE_PERIODYEAR_2 = "kpiEntry.periodYear = ? AND ";
	private static final String _FINDER_COLUMN_YEARTYPE_PERIODYEAR_3 = "(kpiEntry.periodYear IS NULL OR kpiEntry.periodYear = '') AND ";
	private static final String _FINDER_COLUMN_YEARTYPE_PERIODTYPE_2 = "kpiEntry.periodType = ?";

	public KpiEntryPersistenceImpl() {
		setModelClass(KpiEntry.class);
	}

	/**
	 * Caches the kpi entry in the entity cache if it is enabled.
	 *
	 * @param kpiEntry the kpi entry
	 */
	@Override
	public void cacheResult(KpiEntry kpiEntry) {
		EntityCacheUtil.putResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryImpl.class, kpiEntry.getPrimaryKey(), kpiEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEPERIOD,
			new Object[] {
				kpiEntry.getKpiTypeId(), kpiEntry.getPeriodType(),
				kpiEntry.getPeriod()
			}, kpiEntry);

		kpiEntry.resetOriginalValues();
	}

	/**
	 * Caches the kpi entries in the entity cache if it is enabled.
	 *
	 * @param kpiEntries the kpi entries
	 */
	@Override
	public void cacheResult(List<KpiEntry> kpiEntries) {
		for (KpiEntry kpiEntry : kpiEntries) {
			if (EntityCacheUtil.getResult(
						KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
						KpiEntryImpl.class, kpiEntry.getPrimaryKey()) == null) {
				cacheResult(kpiEntry);
			}
			else {
				kpiEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kpi entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KpiEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KpiEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kpi entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KpiEntry kpiEntry) {
		EntityCacheUtil.removeResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryImpl.class, kpiEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(kpiEntry);
	}

	@Override
	public void clearCache(List<KpiEntry> kpiEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KpiEntry kpiEntry : kpiEntries) {
			EntityCacheUtil.removeResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
				KpiEntryImpl.class, kpiEntry.getPrimaryKey());

			clearUniqueFindersCache(kpiEntry);
		}
	}

	protected void cacheUniqueFindersCache(KpiEntry kpiEntry) {
		if (kpiEntry.isNew()) {
			Object[] args = new Object[] {
					kpiEntry.getKpiTypeId(), kpiEntry.getPeriodType(),
					kpiEntry.getPeriod()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEPERIOD, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEPERIOD, args,
				kpiEntry);
		}
		else {
			KpiEntryModelImpl kpiEntryModelImpl = (KpiEntryModelImpl)kpiEntry;

			if ((kpiEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TYPEPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kpiEntry.getKpiTypeId(), kpiEntry.getPeriodType(),
						kpiEntry.getPeriod()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPEPERIOD,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPEPERIOD,
					args, kpiEntry);
			}
		}
	}

	protected void clearUniqueFindersCache(KpiEntry kpiEntry) {
		KpiEntryModelImpl kpiEntryModelImpl = (KpiEntryModelImpl)kpiEntry;

		Object[] args = new Object[] {
				kpiEntry.getKpiTypeId(), kpiEntry.getPeriodType(),
				kpiEntry.getPeriod()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEPERIOD, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEPERIOD, args);

		if ((kpiEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPEPERIOD.getColumnBitmask()) != 0) {
			args = new Object[] {
					kpiEntryModelImpl.getOriginalKpiTypeId(),
					kpiEntryModelImpl.getOriginalPeriodType(),
					kpiEntryModelImpl.getOriginalPeriod()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEPERIOD, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPEPERIOD, args);
		}
	}

	/**
	 * Creates a new kpi entry with the primary key. Does not add the kpi entry to the database.
	 *
	 * @param kpiEntryId the primary key for the new kpi entry
	 * @return the new kpi entry
	 */
	@Override
	public KpiEntry create(long kpiEntryId) {
		KpiEntry kpiEntry = new KpiEntryImpl();

		kpiEntry.setNew(true);
		kpiEntry.setPrimaryKey(kpiEntryId);

		return kpiEntry;
	}

	/**
	 * Removes the kpi entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kpiEntryId the primary key of the kpi entry
	 * @return the kpi entry that was removed
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry remove(long kpiEntryId)
		throws NoSuchKpiEntryException, SystemException {
		return remove((Serializable)kpiEntryId);
	}

	/**
	 * Removes the kpi entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kpi entry
	 * @return the kpi entry that was removed
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry remove(Serializable primaryKey)
		throws NoSuchKpiEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KpiEntry kpiEntry = (KpiEntry)session.get(KpiEntryImpl.class,
					primaryKey);

			if (kpiEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKpiEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kpiEntry);
		}
		catch (NoSuchKpiEntryException nsee) {
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
	protected KpiEntry removeImpl(KpiEntry kpiEntry) throws SystemException {
		kpiEntry = toUnwrappedModel(kpiEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kpiEntry)) {
				kpiEntry = (KpiEntry)session.get(KpiEntryImpl.class,
						kpiEntry.getPrimaryKeyObj());
			}

			if (kpiEntry != null) {
				session.delete(kpiEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kpiEntry != null) {
			clearCache(kpiEntry);
		}

		return kpiEntry;
	}

	@Override
	public KpiEntry updateImpl(com.idetronic.eis.model.KpiEntry kpiEntry)
		throws SystemException {
		kpiEntry = toUnwrappedModel(kpiEntry);

		boolean isNew = kpiEntry.isNew();

		KpiEntryModelImpl kpiEntryModelImpl = (KpiEntryModelImpl)kpiEntry;

		Session session = null;

		try {
			session = openSession();

			if (kpiEntry.isNew()) {
				session.save(kpiEntry);

				kpiEntry.setNew(false);
			}
			else {
				session.merge(kpiEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KpiEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((kpiEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kpiEntryModelImpl.getOriginalKpiTypeId(),
						kpiEntryModelImpl.getOriginalPeriodYear(),
						kpiEntryModelImpl.getOriginalPeriodType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARTYPE,
					args);

				args = new Object[] {
						kpiEntryModelImpl.getKpiTypeId(),
						kpiEntryModelImpl.getPeriodYear(),
						kpiEntryModelImpl.getPeriodType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEARTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEARTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
			KpiEntryImpl.class, kpiEntry.getPrimaryKey(), kpiEntry);

		clearUniqueFindersCache(kpiEntry);
		cacheUniqueFindersCache(kpiEntry);

		return kpiEntry;
	}

	protected KpiEntry toUnwrappedModel(KpiEntry kpiEntry) {
		if (kpiEntry instanceof KpiEntryImpl) {
			return kpiEntry;
		}

		KpiEntryImpl kpiEntryImpl = new KpiEntryImpl();

		kpiEntryImpl.setNew(kpiEntry.isNew());
		kpiEntryImpl.setPrimaryKey(kpiEntry.getPrimaryKey());

		kpiEntryImpl.setKpiEntryId(kpiEntry.getKpiEntryId());
		kpiEntryImpl.setKpiTypeId(kpiEntry.getKpiTypeId());
		kpiEntryImpl.setPeriodYear(kpiEntry.getPeriodYear());
		kpiEntryImpl.setPeriodType(kpiEntry.getPeriodType());
		kpiEntryImpl.setPeriod(kpiEntry.getPeriod());
		kpiEntryImpl.setValue(kpiEntry.getValue());
		kpiEntryImpl.setActual(kpiEntry.getActual());

		return kpiEntryImpl;
	}

	/**
	 * Returns the kpi entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kpi entry
	 * @return the kpi entry
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKpiEntryException, SystemException {
		KpiEntry kpiEntry = fetchByPrimaryKey(primaryKey);

		if (kpiEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKpiEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kpiEntry;
	}

	/**
	 * Returns the kpi entry with the primary key or throws a {@link com.idetronic.eis.NoSuchKpiEntryException} if it could not be found.
	 *
	 * @param kpiEntryId the primary key of the kpi entry
	 * @return the kpi entry
	 * @throws com.idetronic.eis.NoSuchKpiEntryException if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry findByPrimaryKey(long kpiEntryId)
		throws NoSuchKpiEntryException, SystemException {
		return findByPrimaryKey((Serializable)kpiEntryId);
	}

	/**
	 * Returns the kpi entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kpi entry
	 * @return the kpi entry, or <code>null</code> if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		KpiEntry kpiEntry = (KpiEntry)EntityCacheUtil.getResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
				KpiEntryImpl.class, primaryKey);

		if (kpiEntry == _nullKpiEntry) {
			return null;
		}

		if (kpiEntry == null) {
			Session session = null;

			try {
				session = openSession();

				kpiEntry = (KpiEntry)session.get(KpiEntryImpl.class, primaryKey);

				if (kpiEntry != null) {
					cacheResult(kpiEntry);
				}
				else {
					EntityCacheUtil.putResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
						KpiEntryImpl.class, primaryKey, _nullKpiEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KpiEntryModelImpl.ENTITY_CACHE_ENABLED,
					KpiEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kpiEntry;
	}

	/**
	 * Returns the kpi entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kpiEntryId the primary key of the kpi entry
	 * @return the kpi entry, or <code>null</code> if a kpi entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KpiEntry fetchByPrimaryKey(long kpiEntryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)kpiEntryId);
	}

	/**
	 * Returns all the kpi entries.
	 *
	 * @return the kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kpi entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kpi entries
	 * @param end the upper bound of the range of kpi entries (not inclusive)
	 * @return the range of kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiEntry> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kpi entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kpi entries
	 * @param end the upper bound of the range of kpi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kpi entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KpiEntry> findAll(int start, int end,
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

		List<KpiEntry> list = (List<KpiEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KPIENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KPIENTRY;

				if (pagination) {
					sql = sql.concat(KpiEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KpiEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KpiEntry>(list);
				}
				else {
					list = (List<KpiEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the kpi entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KpiEntry kpiEntry : findAll()) {
			remove(kpiEntry);
		}
	}

	/**
	 * Returns the number of kpi entries.
	 *
	 * @return the number of kpi entries
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

				Query q = session.createQuery(_SQL_COUNT_KPIENTRY);

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
	 * Initializes the kpi entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.KpiEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KpiEntry>> listenersList = new ArrayList<ModelListener<KpiEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KpiEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KpiEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KPIENTRY = "SELECT kpiEntry FROM KpiEntry kpiEntry";
	private static final String _SQL_SELECT_KPIENTRY_WHERE = "SELECT kpiEntry FROM KpiEntry kpiEntry WHERE ";
	private static final String _SQL_COUNT_KPIENTRY = "SELECT COUNT(kpiEntry) FROM KpiEntry kpiEntry";
	private static final String _SQL_COUNT_KPIENTRY_WHERE = "SELECT COUNT(kpiEntry) FROM KpiEntry kpiEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kpiEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KpiEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KpiEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KpiEntryPersistenceImpl.class);
	private static KpiEntry _nullKpiEntry = new KpiEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KpiEntry> toCacheModel() {
				return _nullKpiEntryCacheModel;
			}
		};

	private static CacheModel<KpiEntry> _nullKpiEntryCacheModel = new CacheModel<KpiEntry>() {
			@Override
			public KpiEntry toEntityModel() {
				return _nullKpiEntry;
			}
		};
}
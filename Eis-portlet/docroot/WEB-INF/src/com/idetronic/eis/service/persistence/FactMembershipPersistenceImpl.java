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

import com.idetronic.eis.NoSuchFactMembershipException;
import com.idetronic.eis.model.FactMembership;
import com.idetronic.eis.model.impl.FactMembershipImpl;
import com.idetronic.eis.model.impl.FactMembershipModelImpl;

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
 * The persistence implementation for the fact membership service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactMembershipPersistence
 * @see FactMembershipUtil
 * @generated
 */
public class FactMembershipPersistenceImpl extends BasePersistenceImpl<FactMembership>
	implements FactMembershipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactMembershipUtil} to access the fact membership persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactMembershipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED,
			FactMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED,
			FactMembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED,
			FactMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED,
			FactMembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactMembershipModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact memberships where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact memberships where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact memberships
	 * @param end the upper bound of the range of fact memberships (not inclusive)
	 * @return the range of matching fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findByLibrary(long libraryId, int start, int end)
		throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact memberships where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact memberships
	 * @param end the upper bound of the range of fact memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findByLibrary(long libraryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<FactMembership> list = (List<FactMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactMembership factMembership : list) {
				if ((libraryId != factMembership.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTMEMBERSHIP_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactMembershipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactMembership>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactMembership>(list);
				}
				else {
					list = (List<FactMembership>)QueryUtil.list(q,
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
	 * Returns the first fact membership in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = fetchByLibrary_First(libraryId,
				orderByComparator);

		if (factMembership != null) {
			return factMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactMembershipException(msg.toString());
	}

	/**
	 * Returns the first fact membership in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact membership, or <code>null</code> if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactMembership> list = findByLibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact membership in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = fetchByLibrary_Last(libraryId,
				orderByComparator);

		if (factMembership != null) {
			return factMembership;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactMembershipException(msg.toString());
	}

	/**
	 * Returns the last fact membership in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact membership, or <code>null</code> if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactMembership> list = findByLibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact memberships before and after the current fact membership in the ordered set where libraryId = &#63;.
	 *
	 * @param factMembershipId the primary key of the current fact membership
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership[] findByLibrary_PrevAndNext(long factMembershipId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = findByPrimaryKey(factMembershipId);

		Session session = null;

		try {
			session = openSession();

			FactMembership[] array = new FactMembershipImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, factMembership,
					libraryId, orderByComparator, true);

			array[1] = factMembership;

			array[2] = getByLibrary_PrevAndNext(session, factMembership,
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

	protected FactMembership getByLibrary_PrevAndNext(Session session,
		FactMembership factMembership, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTMEMBERSHIP_WHERE);

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
			query.append(FactMembershipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factMembership);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactMembership> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact memberships where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactMembership factMembership : findByLibrary(libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factMembership);
		}
	}

	/**
	 * Returns the number of fact memberships where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact memberships
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

			query.append(_SQL_COUNT_FACTMEMBERSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factMembership.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED,
			FactMembershipImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED,
			FactMembershipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactMembershipModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactMembershipModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact memberships where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findByLibraryPeriod(long libraryId,
		String period) throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact memberships where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact memberships
	 * @param end the upper bound of the range of fact memberships (not inclusive)
	 * @return the range of matching fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findByLibraryPeriod(long libraryId,
		String period, int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact memberships where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact memberships
	 * @param end the upper bound of the range of fact memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findByLibraryPeriod(long libraryId,
		String period, int start, int end, OrderByComparator orderByComparator)
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

		List<FactMembership> list = (List<FactMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactMembership factMembership : list) {
				if ((libraryId != factMembership.getLibraryId()) ||
						!Validator.equals(period, factMembership.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTMEMBERSHIP_WHERE);

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
				query.append(FactMembershipModelImpl.ORDER_BY_JPQL);
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
					list = (List<FactMembership>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactMembership>(list);
				}
				else {
					list = (List<FactMembership>)QueryUtil.list(q,
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
	 * Returns the first fact membership in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership findByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = fetchByLibraryPeriod_First(libraryId,
				period, orderByComparator);

		if (factMembership != null) {
			return factMembership;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactMembershipException(msg.toString());
	}

	/**
	 * Returns the first fact membership in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact membership, or <code>null</code> if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership fetchByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactMembership> list = findByLibraryPeriod(libraryId, period, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact membership in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership findByLibraryPeriod_Last(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = fetchByLibraryPeriod_Last(libraryId,
				period, orderByComparator);

		if (factMembership != null) {
			return factMembership;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactMembershipException(msg.toString());
	}

	/**
	 * Returns the last fact membership in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact membership, or <code>null</code> if a matching fact membership could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership fetchByLibraryPeriod_Last(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<FactMembership> list = findByLibraryPeriod(libraryId, period,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact memberships before and after the current fact membership in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param factMembershipId the primary key of the current fact membership
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership[] findByLibraryPeriod_PrevAndNext(
		long factMembershipId, long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = findByPrimaryKey(factMembershipId);

		Session session = null;

		try {
			session = openSession();

			FactMembership[] array = new FactMembershipImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session, factMembership,
					libraryId, period, orderByComparator, true);

			array[1] = factMembership;

			array[2] = getByLibraryPeriod_PrevAndNext(session, factMembership,
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

	protected FactMembership getByLibraryPeriod_PrevAndNext(Session session,
		FactMembership factMembership, long libraryId, String period,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTMEMBERSHIP_WHERE);

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
			query.append(FactMembershipModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(factMembership);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactMembership> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact memberships where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (FactMembership factMembership : findByLibraryPeriod(libraryId,
				period, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factMembership);
		}
	}

	/**
	 * Returns the number of fact memberships where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching fact memberships
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

			query.append(_SQL_COUNT_FACTMEMBERSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "factMembership.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "factMembership.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "factMembership.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(factMembership.period IS NULL OR factMembership.period = '')";

	public FactMembershipPersistenceImpl() {
		setModelClass(FactMembership.class);
	}

	/**
	 * Caches the fact membership in the entity cache if it is enabled.
	 *
	 * @param factMembership the fact membership
	 */
	@Override
	public void cacheResult(FactMembership factMembership) {
		EntityCacheUtil.putResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipImpl.class, factMembership.getPrimaryKey(),
			factMembership);

		factMembership.resetOriginalValues();
	}

	/**
	 * Caches the fact memberships in the entity cache if it is enabled.
	 *
	 * @param factMemberships the fact memberships
	 */
	@Override
	public void cacheResult(List<FactMembership> factMemberships) {
		for (FactMembership factMembership : factMemberships) {
			if (EntityCacheUtil.getResult(
						FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
						FactMembershipImpl.class, factMembership.getPrimaryKey()) == null) {
				cacheResult(factMembership);
			}
			else {
				factMembership.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact memberships.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactMembershipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactMembershipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact membership.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactMembership factMembership) {
		EntityCacheUtil.removeResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipImpl.class, factMembership.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactMembership> factMemberships) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactMembership factMembership : factMemberships) {
			EntityCacheUtil.removeResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
				FactMembershipImpl.class, factMembership.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact membership with the primary key. Does not add the fact membership to the database.
	 *
	 * @param factMembershipId the primary key for the new fact membership
	 * @return the new fact membership
	 */
	@Override
	public FactMembership create(long factMembershipId) {
		FactMembership factMembership = new FactMembershipImpl();

		factMembership.setNew(true);
		factMembership.setPrimaryKey(factMembershipId);

		return factMembership;
	}

	/**
	 * Removes the fact membership with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factMembershipId the primary key of the fact membership
	 * @return the fact membership that was removed
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership remove(long factMembershipId)
		throws NoSuchFactMembershipException, SystemException {
		return remove((Serializable)factMembershipId);
	}

	/**
	 * Removes the fact membership with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact membership
	 * @return the fact membership that was removed
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership remove(Serializable primaryKey)
		throws NoSuchFactMembershipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactMembership factMembership = (FactMembership)session.get(FactMembershipImpl.class,
					primaryKey);

			if (factMembership == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactMembershipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factMembership);
		}
		catch (NoSuchFactMembershipException nsee) {
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
	protected FactMembership removeImpl(FactMembership factMembership)
		throws SystemException {
		factMembership = toUnwrappedModel(factMembership);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factMembership)) {
				factMembership = (FactMembership)session.get(FactMembershipImpl.class,
						factMembership.getPrimaryKeyObj());
			}

			if (factMembership != null) {
				session.delete(factMembership);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factMembership != null) {
			clearCache(factMembership);
		}

		return factMembership;
	}

	@Override
	public FactMembership updateImpl(
		com.idetronic.eis.model.FactMembership factMembership)
		throws SystemException {
		factMembership = toUnwrappedModel(factMembership);

		boolean isNew = factMembership.isNew();

		FactMembershipModelImpl factMembershipModelImpl = (FactMembershipModelImpl)factMembership;

		Session session = null;

		try {
			session = openSession();

			if (factMembership.isNew()) {
				session.save(factMembership);

				factMembership.setNew(false);
			}
			else {
				session.merge(factMembership);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactMembershipModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factMembershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factMembershipModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { factMembershipModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}

			if ((factMembershipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factMembershipModelImpl.getOriginalLibraryId(),
						factMembershipModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						factMembershipModelImpl.getLibraryId(),
						factMembershipModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
			FactMembershipImpl.class, factMembership.getPrimaryKey(),
			factMembership);

		return factMembership;
	}

	protected FactMembership toUnwrappedModel(FactMembership factMembership) {
		if (factMembership instanceof FactMembershipImpl) {
			return factMembership;
		}

		FactMembershipImpl factMembershipImpl = new FactMembershipImpl();

		factMembershipImpl.setNew(factMembership.isNew());
		factMembershipImpl.setPrimaryKey(factMembership.getPrimaryKey());

		factMembershipImpl.setFactMembershipId(factMembership.getFactMembershipId());
		factMembershipImpl.setLibraryId(factMembership.getLibraryId());
		factMembershipImpl.setPeriod(factMembership.getPeriod());
		factMembershipImpl.setStateId(factMembership.getStateId());
		factMembershipImpl.setLibraryTypeId(factMembership.getLibraryTypeId());
		factMembershipImpl.setMembershipCategoryId(factMembership.getMembershipCategoryId());
		factMembershipImpl.setActiveCount(factMembership.getActiveCount());
		factMembershipImpl.setCompanyId(factMembership.getCompanyId());
		factMembershipImpl.setGroupId(factMembership.getGroupId());
		factMembershipImpl.setUserId(factMembership.getUserId());
		factMembershipImpl.setUserName(factMembership.getUserName());
		factMembershipImpl.setCreateDate(factMembership.getCreateDate());

		return factMembershipImpl;
	}

	/**
	 * Returns the fact membership with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact membership
	 * @return the fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactMembershipException, SystemException {
		FactMembership factMembership = fetchByPrimaryKey(primaryKey);

		if (factMembership == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactMembershipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factMembership;
	}

	/**
	 * Returns the fact membership with the primary key or throws a {@link com.idetronic.eis.NoSuchFactMembershipException} if it could not be found.
	 *
	 * @param factMembershipId the primary key of the fact membership
	 * @return the fact membership
	 * @throws com.idetronic.eis.NoSuchFactMembershipException if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership findByPrimaryKey(long factMembershipId)
		throws NoSuchFactMembershipException, SystemException {
		return findByPrimaryKey((Serializable)factMembershipId);
	}

	/**
	 * Returns the fact membership with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact membership
	 * @return the fact membership, or <code>null</code> if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactMembership factMembership = (FactMembership)EntityCacheUtil.getResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
				FactMembershipImpl.class, primaryKey);

		if (factMembership == _nullFactMembership) {
			return null;
		}

		if (factMembership == null) {
			Session session = null;

			try {
				session = openSession();

				factMembership = (FactMembership)session.get(FactMembershipImpl.class,
						primaryKey);

				if (factMembership != null) {
					cacheResult(factMembership);
				}
				else {
					EntityCacheUtil.putResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
						FactMembershipImpl.class, primaryKey,
						_nullFactMembership);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactMembershipModelImpl.ENTITY_CACHE_ENABLED,
					FactMembershipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factMembership;
	}

	/**
	 * Returns the fact membership with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factMembershipId the primary key of the fact membership
	 * @return the fact membership, or <code>null</code> if a fact membership with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactMembership fetchByPrimaryKey(long factMembershipId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factMembershipId);
	}

	/**
	 * Returns all the fact memberships.
	 *
	 * @return the fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact memberships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact memberships
	 * @param end the upper bound of the range of fact memberships (not inclusive)
	 * @return the range of fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact memberships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactMembershipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact memberships
	 * @param end the upper bound of the range of fact memberships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact memberships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactMembership> findAll(int start, int end,
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

		List<FactMembership> list = (List<FactMembership>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTMEMBERSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTMEMBERSHIP;

				if (pagination) {
					sql = sql.concat(FactMembershipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactMembership>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactMembership>(list);
				}
				else {
					list = (List<FactMembership>)QueryUtil.list(q,
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
	 * Removes all the fact memberships from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactMembership factMembership : findAll()) {
			remove(factMembership);
		}
	}

	/**
	 * Returns the number of fact memberships.
	 *
	 * @return the number of fact memberships
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

				Query q = session.createQuery(_SQL_COUNT_FACTMEMBERSHIP);

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
	 * Initializes the fact membership persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactMembership")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactMembership>> listenersList = new ArrayList<ModelListener<FactMembership>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactMembership>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactMembershipImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTMEMBERSHIP = "SELECT factMembership FROM FactMembership factMembership";
	private static final String _SQL_SELECT_FACTMEMBERSHIP_WHERE = "SELECT factMembership FROM FactMembership factMembership WHERE ";
	private static final String _SQL_COUNT_FACTMEMBERSHIP = "SELECT COUNT(factMembership) FROM FactMembership factMembership";
	private static final String _SQL_COUNT_FACTMEMBERSHIP_WHERE = "SELECT COUNT(factMembership) FROM FactMembership factMembership WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factMembership.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactMembership exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactMembership exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactMembershipPersistenceImpl.class);
	private static FactMembership _nullFactMembership = new FactMembershipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactMembership> toCacheModel() {
				return _nullFactMembershipCacheModel;
			}
		};

	private static CacheModel<FactMembership> _nullFactMembershipCacheModel = new CacheModel<FactMembership>() {
			@Override
			public FactMembership toEntityModel() {
				return _nullFactMembership;
			}
		};
}
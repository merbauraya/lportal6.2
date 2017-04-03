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

import com.idetronic.eis.NoSuchFactSeatingException;
import com.idetronic.eis.model.FactSeating;
import com.idetronic.eis.model.impl.FactSeatingImpl;
import com.idetronic.eis.model.impl.FactSeatingModelImpl;

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
 * The persistence implementation for the fact seating service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactSeatingPersistence
 * @see FactSeatingUtil
 * @generated
 */
public class FactSeatingPersistenceImpl extends BasePersistenceImpl<FactSeating>
	implements FactSeatingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactSeatingUtil} to access the fact seating persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactSeatingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYDEPARTMENT =
		new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryDepartment",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYDEPARTMENT =
		new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLibraryDepartment",
			new String[] { Long.class.getName(), Long.class.getName() },
			FactSeatingModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactSeatingModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLibraryDepartment",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fact seatings where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @return the matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibraryDepartment(long libraryId,
		long departmentId) throws SystemException {
		return findByLibraryDepartment(libraryId, departmentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact seatings where libraryId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @return the range of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibraryDepartment(long libraryId,
		long departmentId, int start, int end) throws SystemException {
		return findByLibraryDepartment(libraryId, departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact seatings where libraryId = &#63; and departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibraryDepartment(long libraryId,
		long departmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYDEPARTMENT;
			finderArgs = new Object[] { libraryId, departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYDEPARTMENT;
			finderArgs = new Object[] {
					libraryId, departmentId,
					
					start, end, orderByComparator
				};
		}

		List<FactSeating> list = (List<FactSeating>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactSeating factSeating : list) {
				if ((libraryId != factSeating.getLibraryId()) ||
						(departmentId != factSeating.getDepartmentId())) {
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

			query.append(_SQL_SELECT_FACTSEATING_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactSeatingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(departmentId);

				if (!pagination) {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactSeating>(list);
				}
				else {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByLibraryDepartment_First(long libraryId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByLibraryDepartment_First(libraryId,
				departmentId, orderByComparator);

		if (factSeating != null) {
			return factSeating;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactSeatingException(msg.toString());
	}

	/**
	 * Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact seating, or <code>null</code> if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByLibraryDepartment_First(long libraryId,
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactSeating> list = findByLibraryDepartment(libraryId,
				departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByLibraryDepartment_Last(long libraryId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByLibraryDepartment_Last(libraryId,
				departmentId, orderByComparator);

		if (factSeating != null) {
			return factSeating;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactSeatingException(msg.toString());
	}

	/**
	 * Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact seating, or <code>null</code> if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByLibraryDepartment_Last(long libraryId,
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLibraryDepartment(libraryId, departmentId);

		if (count == 0) {
			return null;
		}

		List<FactSeating> list = findByLibraryDepartment(libraryId,
				departmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact seatings before and after the current fact seating in the ordered set where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param factSeatingId the primary key of the current fact seating
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating[] findByLibraryDepartment_PrevAndNext(
		long factSeatingId, long libraryId, long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = findByPrimaryKey(factSeatingId);

		Session session = null;

		try {
			session = openSession();

			FactSeating[] array = new FactSeatingImpl[3];

			array[0] = getByLibraryDepartment_PrevAndNext(session, factSeating,
					libraryId, departmentId, orderByComparator, true);

			array[1] = factSeating;

			array[2] = getByLibraryDepartment_PrevAndNext(session, factSeating,
					libraryId, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactSeating getByLibraryDepartment_PrevAndNext(Session session,
		FactSeating factSeating, long libraryId, long departmentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTSEATING_WHERE);

		query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2);

		query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2);

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
			query.append(FactSeatingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factSeating);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactSeating> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact seatings where libraryId = &#63; and departmentId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryDepartment(long libraryId, long departmentId)
		throws SystemException {
		for (FactSeating factSeating : findByLibraryDepartment(libraryId,
				departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factSeating);
		}
	}

	/**
	 * Returns the number of fact seatings where libraryId = &#63; and departmentId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @return the number of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibraryDepartment(long libraryId, long departmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT;

		Object[] finderArgs = new Object[] { libraryId, departmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FACTSEATING_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_LIBRARYDEPARTMENT_LIBRARYID_2 = "factSeating.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYDEPARTMENT_DEPARTMENTID_2 = "factSeating.departmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBDEPTCATPERIOD =
		new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibDeptCatPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBDEPTCATPERIOD =
		new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLibDeptCatPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			FactSeatingModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactSeatingModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			FactSeatingModelImpl.SEATINGCATEGORYID_COLUMN_BITMASK |
			FactSeatingModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBDEPTCATPERIOD = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLibDeptCatPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @return the matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibDeptCatPeriod(long libraryId,
		long departmentId, long seatingCategoryId, String period)
		throws SystemException {
		return findByLibDeptCatPeriod(libraryId, departmentId,
			seatingCategoryId, period, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @return the range of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibDeptCatPeriod(long libraryId,
		long departmentId, long seatingCategoryId, String period, int start,
		int end) throws SystemException {
		return findByLibDeptCatPeriod(libraryId, departmentId,
			seatingCategoryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibDeptCatPeriod(long libraryId,
		long departmentId, long seatingCategoryId, String period, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBDEPTCATPERIOD;
			finderArgs = new Object[] {
					libraryId, departmentId, seatingCategoryId, period
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBDEPTCATPERIOD;
			finderArgs = new Object[] {
					libraryId, departmentId, seatingCategoryId, period,
					
					start, end, orderByComparator
				};
		}

		List<FactSeating> list = (List<FactSeating>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactSeating factSeating : list) {
				if ((libraryId != factSeating.getLibraryId()) ||
						(departmentId != factSeating.getDepartmentId()) ||
						(seatingCategoryId != factSeating.getSeatingCategoryId()) ||
						!Validator.equals(period, factSeating.getPeriod())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_FACTSEATING_WHERE);

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_SEATINGCATEGORYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactSeatingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(departmentId);

				qPos.add(seatingCategoryId);

				if (bindPeriod) {
					qPos.add(period);
				}

				if (!pagination) {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactSeating>(list);
				}
				else {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByLibDeptCatPeriod_First(long libraryId,
		long departmentId, long seatingCategoryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByLibDeptCatPeriod_First(libraryId,
				departmentId, seatingCategoryId, period, orderByComparator);

		if (factSeating != null) {
			return factSeating;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", seatingCategoryId=");
		msg.append(seatingCategoryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactSeatingException(msg.toString());
	}

	/**
	 * Returns the first fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact seating, or <code>null</code> if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByLibDeptCatPeriod_First(long libraryId,
		long departmentId, long seatingCategoryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactSeating> list = findByLibDeptCatPeriod(libraryId,
				departmentId, seatingCategoryId, period, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByLibDeptCatPeriod_Last(long libraryId,
		long departmentId, long seatingCategoryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByLibDeptCatPeriod_Last(libraryId,
				departmentId, seatingCategoryId, period, orderByComparator);

		if (factSeating != null) {
			return factSeating;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", seatingCategoryId=");
		msg.append(seatingCategoryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactSeatingException(msg.toString());
	}

	/**
	 * Returns the last fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact seating, or <code>null</code> if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByLibDeptCatPeriod_Last(long libraryId,
		long departmentId, long seatingCategoryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibDeptCatPeriod(libraryId, departmentId,
				seatingCategoryId, period);

		if (count == 0) {
			return null;
		}

		List<FactSeating> list = findByLibDeptCatPeriod(libraryId,
				departmentId, seatingCategoryId, period, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact seatings before and after the current fact seating in the ordered set where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param factSeatingId the primary key of the current fact seating
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating[] findByLibDeptCatPeriod_PrevAndNext(
		long factSeatingId, long libraryId, long departmentId,
		long seatingCategoryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = findByPrimaryKey(factSeatingId);

		Session session = null;

		try {
			session = openSession();

			FactSeating[] array = new FactSeatingImpl[3];

			array[0] = getByLibDeptCatPeriod_PrevAndNext(session, factSeating,
					libraryId, departmentId, seatingCategoryId, period,
					orderByComparator, true);

			array[1] = factSeating;

			array[2] = getByLibDeptCatPeriod_PrevAndNext(session, factSeating,
					libraryId, departmentId, seatingCategoryId, period,
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

	protected FactSeating getByLibDeptCatPeriod_PrevAndNext(Session session,
		FactSeating factSeating, long libraryId, long departmentId,
		long seatingCategoryId, String period,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTSEATING_WHERE);

		query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_LIBRARYID_2);

		query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_SEATINGCATEGORYID_2);

		boolean bindPeriod = false;

		if (period == null) {
			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_1);
		}
		else if (period.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_3);
		}
		else {
			bindPeriod = true;

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_2);
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
			query.append(FactSeatingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		qPos.add(departmentId);

		qPos.add(seatingCategoryId);

		if (bindPeriod) {
			qPos.add(period);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factSeating);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactSeating> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibDeptCatPeriod(long libraryId, long departmentId,
		long seatingCategoryId, String period) throws SystemException {
		for (FactSeating factSeating : findByLibDeptCatPeriod(libraryId,
				departmentId, seatingCategoryId, period, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(factSeating);
		}
	}

	/**
	 * Returns the number of fact seatings where libraryId = &#63; and departmentId = &#63; and seatingCategoryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param departmentId the department ID
	 * @param seatingCategoryId the seating category ID
	 * @param period the period
	 * @return the number of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibDeptCatPeriod(long libraryId, long departmentId,
		long seatingCategoryId, String period) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBDEPTCATPERIOD;

		Object[] finderArgs = new Object[] {
				libraryId, departmentId, seatingCategoryId, period
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_FACTSEATING_WHERE);

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_SEATINGCATEGORYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(departmentId);

				qPos.add(seatingCategoryId);

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

	private static final String _FINDER_COLUMN_LIBDEPTCATPERIOD_LIBRARYID_2 = "factSeating.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBDEPTCATPERIOD_DEPARTMENTID_2 = "factSeating.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_LIBDEPTCATPERIOD_SEATINGCATEGORYID_2 =
		"factSeating.seatingCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_1 = "factSeating.period IS NULL";
	private static final String _FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_2 = "factSeating.period = ?";
	private static final String _FINDER_COLUMN_LIBDEPTCATPERIOD_PERIOD_3 = "(factSeating.period IS NULL OR factSeating.period = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, FactSeatingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactSeatingModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact seatings where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact seatings where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @return the range of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibrary(long libraryId, int start, int end)
		throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact seatings where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findByLibrary(long libraryId, int start, int end,
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

		List<FactSeating> list = (List<FactSeating>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactSeating factSeating : list) {
				if ((libraryId != factSeating.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTSEATING_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactSeatingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactSeating>(list);
				}
				else {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact seating in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByLibrary_First(libraryId,
				orderByComparator);

		if (factSeating != null) {
			return factSeating;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactSeatingException(msg.toString());
	}

	/**
	 * Returns the first fact seating in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact seating, or <code>null</code> if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactSeating> list = findByLibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact seating in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByLibrary_Last(libraryId,
				orderByComparator);

		if (factSeating != null) {
			return factSeating;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactSeatingException(msg.toString());
	}

	/**
	 * Returns the last fact seating in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact seating, or <code>null</code> if a matching fact seating could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactSeating> list = findByLibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact seatings before and after the current fact seating in the ordered set where libraryId = &#63;.
	 *
	 * @param factSeatingId the primary key of the current fact seating
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating[] findByLibrary_PrevAndNext(long factSeatingId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = findByPrimaryKey(factSeatingId);

		Session session = null;

		try {
			session = openSession();

			FactSeating[] array = new FactSeatingImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, factSeating,
					libraryId, orderByComparator, true);

			array[1] = factSeating;

			array[2] = getByLibrary_PrevAndNext(session, factSeating,
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

	protected FactSeating getByLibrary_PrevAndNext(Session session,
		FactSeating factSeating, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTSEATING_WHERE);

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
			query.append(FactSeatingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factSeating);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactSeating> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact seatings where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactSeating factSeating : findByLibrary(libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factSeating);
		}
	}

	/**
	 * Returns the number of fact seatings where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact seatings
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

			query.append(_SQL_COUNT_FACTSEATING_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factSeating.libraryId = ?";

	public FactSeatingPersistenceImpl() {
		setModelClass(FactSeating.class);
	}

	/**
	 * Caches the fact seating in the entity cache if it is enabled.
	 *
	 * @param factSeating the fact seating
	 */
	@Override
	public void cacheResult(FactSeating factSeating) {
		EntityCacheUtil.putResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingImpl.class, factSeating.getPrimaryKey(), factSeating);

		factSeating.resetOriginalValues();
	}

	/**
	 * Caches the fact seatings in the entity cache if it is enabled.
	 *
	 * @param factSeatings the fact seatings
	 */
	@Override
	public void cacheResult(List<FactSeating> factSeatings) {
		for (FactSeating factSeating : factSeatings) {
			if (EntityCacheUtil.getResult(
						FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
						FactSeatingImpl.class, factSeating.getPrimaryKey()) == null) {
				cacheResult(factSeating);
			}
			else {
				factSeating.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact seatings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactSeatingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactSeatingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact seating.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactSeating factSeating) {
		EntityCacheUtil.removeResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingImpl.class, factSeating.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactSeating> factSeatings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactSeating factSeating : factSeatings) {
			EntityCacheUtil.removeResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
				FactSeatingImpl.class, factSeating.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact seating with the primary key. Does not add the fact seating to the database.
	 *
	 * @param factSeatingId the primary key for the new fact seating
	 * @return the new fact seating
	 */
	@Override
	public FactSeating create(long factSeatingId) {
		FactSeating factSeating = new FactSeatingImpl();

		factSeating.setNew(true);
		factSeating.setPrimaryKey(factSeatingId);

		return factSeating;
	}

	/**
	 * Removes the fact seating with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factSeatingId the primary key of the fact seating
	 * @return the fact seating that was removed
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating remove(long factSeatingId)
		throws NoSuchFactSeatingException, SystemException {
		return remove((Serializable)factSeatingId);
	}

	/**
	 * Removes the fact seating with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact seating
	 * @return the fact seating that was removed
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating remove(Serializable primaryKey)
		throws NoSuchFactSeatingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactSeating factSeating = (FactSeating)session.get(FactSeatingImpl.class,
					primaryKey);

			if (factSeating == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactSeatingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factSeating);
		}
		catch (NoSuchFactSeatingException nsee) {
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
	protected FactSeating removeImpl(FactSeating factSeating)
		throws SystemException {
		factSeating = toUnwrappedModel(factSeating);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factSeating)) {
				factSeating = (FactSeating)session.get(FactSeatingImpl.class,
						factSeating.getPrimaryKeyObj());
			}

			if (factSeating != null) {
				session.delete(factSeating);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factSeating != null) {
			clearCache(factSeating);
		}

		return factSeating;
	}

	@Override
	public FactSeating updateImpl(
		com.idetronic.eis.model.FactSeating factSeating)
		throws SystemException {
		factSeating = toUnwrappedModel(factSeating);

		boolean isNew = factSeating.isNew();

		FactSeatingModelImpl factSeatingModelImpl = (FactSeatingModelImpl)factSeating;

		Session session = null;

		try {
			session = openSession();

			if (factSeating.isNew()) {
				session.save(factSeating);

				factSeating.setNew(false);
			}
			else {
				session.merge(factSeating);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactSeatingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factSeatingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYDEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factSeatingModelImpl.getOriginalLibraryId(),
						factSeatingModelImpl.getOriginalDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYDEPARTMENT,
					args);

				args = new Object[] {
						factSeatingModelImpl.getLibraryId(),
						factSeatingModelImpl.getDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYDEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYDEPARTMENT,
					args);
			}

			if ((factSeatingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBDEPTCATPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factSeatingModelImpl.getOriginalLibraryId(),
						factSeatingModelImpl.getOriginalDepartmentId(),
						factSeatingModelImpl.getOriginalSeatingCategoryId(),
						factSeatingModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBDEPTCATPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBDEPTCATPERIOD,
					args);

				args = new Object[] {
						factSeatingModelImpl.getLibraryId(),
						factSeatingModelImpl.getDepartmentId(),
						factSeatingModelImpl.getSeatingCategoryId(),
						factSeatingModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBDEPTCATPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBDEPTCATPERIOD,
					args);
			}

			if ((factSeatingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factSeatingModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { factSeatingModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
			FactSeatingImpl.class, factSeating.getPrimaryKey(), factSeating);

		return factSeating;
	}

	protected FactSeating toUnwrappedModel(FactSeating factSeating) {
		if (factSeating instanceof FactSeatingImpl) {
			return factSeating;
		}

		FactSeatingImpl factSeatingImpl = new FactSeatingImpl();

		factSeatingImpl.setNew(factSeating.isNew());
		factSeatingImpl.setPrimaryKey(factSeating.getPrimaryKey());

		factSeatingImpl.setFactSeatingId(factSeating.getFactSeatingId());
		factSeatingImpl.setLibraryId(factSeating.getLibraryId());
		factSeatingImpl.setDepartmentId(factSeating.getDepartmentId());
		factSeatingImpl.setSeatingCategoryId(factSeating.getSeatingCategoryId());
		factSeatingImpl.setStateId(factSeating.getStateId());
		factSeatingImpl.setLibraryTypeId(factSeating.getLibraryTypeId());
		factSeatingImpl.setPeriod(factSeating.getPeriod());
		factSeatingImpl.setCapacity(factSeating.getCapacity());
		factSeatingImpl.setCompanyId(factSeating.getCompanyId());
		factSeatingImpl.setGroupId(factSeating.getGroupId());
		factSeatingImpl.setUserId(factSeating.getUserId());
		factSeatingImpl.setUserName(factSeating.getUserName());
		factSeatingImpl.setCreateDate(factSeating.getCreateDate());

		return factSeatingImpl;
	}

	/**
	 * Returns the fact seating with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact seating
	 * @return the fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactSeatingException, SystemException {
		FactSeating factSeating = fetchByPrimaryKey(primaryKey);

		if (factSeating == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactSeatingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factSeating;
	}

	/**
	 * Returns the fact seating with the primary key or throws a {@link com.idetronic.eis.NoSuchFactSeatingException} if it could not be found.
	 *
	 * @param factSeatingId the primary key of the fact seating
	 * @return the fact seating
	 * @throws com.idetronic.eis.NoSuchFactSeatingException if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating findByPrimaryKey(long factSeatingId)
		throws NoSuchFactSeatingException, SystemException {
		return findByPrimaryKey((Serializable)factSeatingId);
	}

	/**
	 * Returns the fact seating with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact seating
	 * @return the fact seating, or <code>null</code> if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactSeating factSeating = (FactSeating)EntityCacheUtil.getResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
				FactSeatingImpl.class, primaryKey);

		if (factSeating == _nullFactSeating) {
			return null;
		}

		if (factSeating == null) {
			Session session = null;

			try {
				session = openSession();

				factSeating = (FactSeating)session.get(FactSeatingImpl.class,
						primaryKey);

				if (factSeating != null) {
					cacheResult(factSeating);
				}
				else {
					EntityCacheUtil.putResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
						FactSeatingImpl.class, primaryKey, _nullFactSeating);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactSeatingModelImpl.ENTITY_CACHE_ENABLED,
					FactSeatingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factSeating;
	}

	/**
	 * Returns the fact seating with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factSeatingId the primary key of the fact seating
	 * @return the fact seating, or <code>null</code> if a fact seating with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactSeating fetchByPrimaryKey(long factSeatingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factSeatingId);
	}

	/**
	 * Returns all the fact seatings.
	 *
	 * @return the fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact seatings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @return the range of fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact seatings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactSeatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact seatings
	 * @param end the upper bound of the range of fact seatings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact seatings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactSeating> findAll(int start, int end,
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

		List<FactSeating> list = (List<FactSeating>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTSEATING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTSEATING;

				if (pagination) {
					sql = sql.concat(FactSeatingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactSeating>(list);
				}
				else {
					list = (List<FactSeating>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact seatings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactSeating factSeating : findAll()) {
			remove(factSeating);
		}
	}

	/**
	 * Returns the number of fact seatings.
	 *
	 * @return the number of fact seatings
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

				Query q = session.createQuery(_SQL_COUNT_FACTSEATING);

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
	 * Initializes the fact seating persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactSeating")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactSeating>> listenersList = new ArrayList<ModelListener<FactSeating>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactSeating>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactSeatingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTSEATING = "SELECT factSeating FROM FactSeating factSeating";
	private static final String _SQL_SELECT_FACTSEATING_WHERE = "SELECT factSeating FROM FactSeating factSeating WHERE ";
	private static final String _SQL_COUNT_FACTSEATING = "SELECT COUNT(factSeating) FROM FactSeating factSeating";
	private static final String _SQL_COUNT_FACTSEATING_WHERE = "SELECT COUNT(factSeating) FROM FactSeating factSeating WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factSeating.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactSeating exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactSeating exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactSeatingPersistenceImpl.class);
	private static FactSeating _nullFactSeating = new FactSeatingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactSeating> toCacheModel() {
				return _nullFactSeatingCacheModel;
			}
		};

	private static CacheModel<FactSeating> _nullFactSeatingCacheModel = new CacheModel<FactSeating>() {
			@Override
			public FactSeating toEntityModel() {
				return _nullFactSeating;
			}
		};
}
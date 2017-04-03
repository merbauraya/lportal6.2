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

import com.idetronic.eis.NoSuchLoanException;
import com.idetronic.eis.model.Loan;
import com.idetronic.eis.model.impl.LoanImpl;
import com.idetronic.eis.model.impl.LoanModelImpl;

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
 * The persistence implementation for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see LoanPersistence
 * @see LoanUtil
 * @generated
 */
public class LoanPersistenceImpl extends BasePersistenceImpl<Loan>
	implements LoanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			LoanModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loans where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByLibrary(long libraryId) throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the loans where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByLibrary(long libraryId, int start, int end)
		throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByLibrary(long libraryId, int start, int end,
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

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if ((libraryId != loan.getLibraryId())) {
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

			query.append(_SQL_SELECT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first loan in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByLibrary_First(libraryId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByLibrary(libraryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByLibrary_Last(libraryId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByLibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loans before and after the current loan in the ordered set where libraryId = &#63;.
	 *
	 * @param loanEntryId the primary key of the current loan
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan[] findByLibrary_PrevAndNext(long loanEntryId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanEntryId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, loan, libraryId,
					orderByComparator, true);

			array[1] = loan;

			array[2] = getByLibrary_PrevAndNext(session, loan, libraryId,
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

	protected Loan getByLibrary_PrevAndNext(Session session, Loan loan,
		long libraryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

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
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (Loan loan : findByLibrary(libraryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching loans
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

			query.append(_SQL_COUNT_LOAN_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "loan.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			LoanModelImpl.LIBRARYID_COLUMN_BITMASK |
			LoanModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the loans where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByLibraryPeriod(long libraryId, String period,
		int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByLibraryPeriod(long libraryId, String period,
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

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if ((libraryId != loan.getLibraryId()) ||
						!Validator.equals(period, loan.getPeriod())) {
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

			query.append(_SQL_SELECT_LOAN_WHERE);

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
				query.append(LoanModelImpl.ORDER_BY_JPQL);
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
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first loan in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByLibraryPeriod_First(libraryId, period,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByLibraryPeriod(libraryId, period, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last loan in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByLibraryPeriod_Last(libraryId, period,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByLibraryPeriod(libraryId, period, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loans before and after the current loan in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param loanEntryId the primary key of the current loan
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan[] findByLibraryPeriod_PrevAndNext(long loanEntryId,
		long libraryId, String period, OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanEntryId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session, loan, libraryId,
					period, orderByComparator, true);

			array[1] = loan;

			array[2] = getByLibraryPeriod_PrevAndNext(session, loan, libraryId,
					period, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByLibraryPeriod_PrevAndNext(Session session, Loan loan,
		long libraryId, String period, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

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
			query.append(LoanModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (Loan loan : findByLibraryPeriod(libraryId, period,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching loans
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

			query.append(_SQL_COUNT_LOAN_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "loan.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "loan.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "loan.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(loan.period IS NULL OR loan.period = '')";

	public LoanPersistenceImpl() {
		setModelClass(Loan.class);
	}

	/**
	 * Caches the loan in the entity cache if it is enabled.
	 *
	 * @param loan the loan
	 */
	@Override
	public void cacheResult(Loan loan) {
		EntityCacheUtil.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey(), loan);

		loan.resetOriginalValues();
	}

	/**
	 * Caches the loans in the entity cache if it is enabled.
	 *
	 * @param loans the loans
	 */
	@Override
	public void cacheResult(List<Loan> loans) {
		for (Loan loan : loans) {
			if (EntityCacheUtil.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
						LoanImpl.class, loan.getPrimaryKey()) == null) {
				cacheResult(loan);
			}
			else {
				loan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LoanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LoanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Loan loan) {
		EntityCacheUtil.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Loan> loans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Loan loan : loans) {
			EntityCacheUtil.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
				LoanImpl.class, loan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new loan with the primary key. Does not add the loan to the database.
	 *
	 * @param loanEntryId the primary key for the new loan
	 * @return the new loan
	 */
	@Override
	public Loan create(long loanEntryId) {
		Loan loan = new LoanImpl();

		loan.setNew(true);
		loan.setPrimaryKey(loanEntryId);

		return loan;
	}

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loanEntryId the primary key of the loan
	 * @return the loan that was removed
	 * @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan remove(long loanEntryId)
		throws NoSuchLoanException, SystemException {
		return remove((Serializable)loanEntryId);
	}

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan that was removed
	 * @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan remove(Serializable primaryKey)
		throws NoSuchLoanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Loan loan = (Loan)session.get(LoanImpl.class, primaryKey);

			if (loan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loan);
		}
		catch (NoSuchLoanException nsee) {
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
	protected Loan removeImpl(Loan loan) throws SystemException {
		loan = toUnwrappedModel(loan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loan)) {
				loan = (Loan)session.get(LoanImpl.class, loan.getPrimaryKeyObj());
			}

			if (loan != null) {
				session.delete(loan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loan != null) {
			clearCache(loan);
		}

		return loan;
	}

	@Override
	public Loan updateImpl(com.idetronic.eis.model.Loan loan)
		throws SystemException {
		loan = toUnwrappedModel(loan);

		boolean isNew = loan.isNew();

		LoanModelImpl loanModelImpl = (LoanModelImpl)loan;

		Session session = null;

		try {
			session = openSession();

			if (loan.isNew()) {
				session.save(loan);

				loan.setNew(false);
			}
			else {
				session.merge(loan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LoanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { loanModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalLibraryId(),
						loanModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						loanModelImpl.getLibraryId(), loanModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey(), loan);

		return loan;
	}

	protected Loan toUnwrappedModel(Loan loan) {
		if (loan instanceof LoanImpl) {
			return loan;
		}

		LoanImpl loanImpl = new LoanImpl();

		loanImpl.setNew(loan.isNew());
		loanImpl.setPrimaryKey(loan.getPrimaryKey());

		loanImpl.setLoanEntryId(loan.getLoanEntryId());
		loanImpl.setLibraryId(loan.getLibraryId());
		loanImpl.setUserId(loan.getUserId());
		loanImpl.setUserName(loan.getUserName());
		loanImpl.setPeriod(loan.getPeriod());
		loanImpl.setStateId(loan.getStateId());
		loanImpl.setLibraryTypeId(loan.getLibraryTypeId());
		loanImpl.setPeriodYear(loan.getPeriodYear());
		loanImpl.setPeriodMonth(loan.getPeriodMonth());
		loanImpl.setCreateDate(loan.getCreateDate());
		loanImpl.setMemberCategoryId(loan.getMemberCategoryId());
		loanImpl.setValue(loan.getValue());

		return loanImpl;
	}

	/**
	 * Returns the loan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByPrimaryKey(primaryKey);

		if (loan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loan;
	}

	/**
	 * Returns the loan with the primary key or throws a {@link com.idetronic.eis.NoSuchLoanException} if it could not be found.
	 *
	 * @param loanEntryId the primary key of the loan
	 * @return the loan
	 * @throws com.idetronic.eis.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByPrimaryKey(long loanEntryId)
		throws NoSuchLoanException, SystemException {
		return findByPrimaryKey((Serializable)loanEntryId);
	}

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Loan loan = (Loan)EntityCacheUtil.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
				LoanImpl.class, primaryKey);

		if (loan == _nullLoan) {
			return null;
		}

		if (loan == null) {
			Session session = null;

			try {
				session = openSession();

				loan = (Loan)session.get(LoanImpl.class, primaryKey);

				if (loan != null) {
					cacheResult(loan);
				}
				else {
					EntityCacheUtil.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
						LoanImpl.class, primaryKey, _nullLoan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
					LoanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loan;
	}

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loanEntryId the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByPrimaryKey(long loanEntryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)loanEntryId);
	}

	/**
	 * Returns all the loans.
	 *
	 * @return the loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @return the range of loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loans
	 * @param end the upper bound of the range of loans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findAll(int start, int end,
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

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOAN;

				if (pagination) {
					sql = sql.concat(LoanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the loans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Loan loan : findAll()) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans.
	 *
	 * @return the number of loans
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

				Query q = session.createQuery(_SQL_COUNT_LOAN);

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
	 * Initializes the loan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.Loan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Loan>> listenersList = new ArrayList<ModelListener<Loan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Loan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LoanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOAN = "SELECT loan FROM Loan loan";
	private static final String _SQL_SELECT_LOAN_WHERE = "SELECT loan FROM Loan loan WHERE ";
	private static final String _SQL_COUNT_LOAN = "SELECT COUNT(loan) FROM Loan loan";
	private static final String _SQL_COUNT_LOAN_WHERE = "SELECT COUNT(loan) FROM Loan loan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Loan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Loan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LoanPersistenceImpl.class);
	private static Loan _nullLoan = new LoanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Loan> toCacheModel() {
				return _nullLoanCacheModel;
			}
		};

	private static CacheModel<Loan> _nullLoanCacheModel = new CacheModel<Loan>() {
			@Override
			public Loan toEntityModel() {
				return _nullLoan;
			}
		};
}
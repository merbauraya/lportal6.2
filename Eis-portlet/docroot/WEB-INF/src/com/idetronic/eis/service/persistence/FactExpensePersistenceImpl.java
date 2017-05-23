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

import com.idetronic.eis.NoSuchFactExpenseException;
import com.idetronic.eis.model.FactExpense;
import com.idetronic.eis.model.impl.FactExpenseImpl;
import com.idetronic.eis.model.impl.FactExpenseModelImpl;

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
 * The persistence implementation for the fact expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactExpensePersistence
 * @see FactExpenseUtil
 * @generated
 */
public class FactExpensePersistenceImpl extends BasePersistenceImpl<FactExpense>
	implements FactExpensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactExpenseUtil} to access the fact expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactExpenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseModelImpl.FINDER_CACHE_ENABLED, FactExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseModelImpl.FINDER_CACHE_ENABLED, FactExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseModelImpl.FINDER_CACHE_ENABLED, FactExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseModelImpl.FINDER_CACHE_ENABLED, FactExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactExpenseModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact expenses where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactExpense> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact expenses where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact expenses
	 * @param end the upper bound of the range of fact expenses (not inclusive)
	 * @return the range of matching fact expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactExpense> findByLibrary(long libraryId, int start, int end)
		throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact expenses where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact expenses
	 * @param end the upper bound of the range of fact expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactExpense> findByLibrary(long libraryId, int start, int end,
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

		List<FactExpense> list = (List<FactExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactExpense factExpense : list) {
				if ((libraryId != factExpense.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactExpenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactExpense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactExpense>(list);
				}
				else {
					list = (List<FactExpense>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact expense in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact expense
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a matching fact expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactExpenseException, SystemException {
		FactExpense factExpense = fetchByLibrary_First(libraryId,
				orderByComparator);

		if (factExpense != null) {
			return factExpense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactExpenseException(msg.toString());
	}

	/**
	 * Returns the first fact expense in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact expense, or <code>null</code> if a matching fact expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactExpense> list = findByLibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact expense in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact expense
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a matching fact expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactExpenseException, SystemException {
		FactExpense factExpense = fetchByLibrary_Last(libraryId,
				orderByComparator);

		if (factExpense != null) {
			return factExpense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactExpenseException(msg.toString());
	}

	/**
	 * Returns the last fact expense in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact expense, or <code>null</code> if a matching fact expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactExpense> list = findByLibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact expenses before and after the current fact expense in the ordered set where libraryId = &#63;.
	 *
	 * @param factExpenseId the primary key of the current fact expense
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact expense
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense[] findByLibrary_PrevAndNext(long factExpenseId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchFactExpenseException, SystemException {
		FactExpense factExpense = findByPrimaryKey(factExpenseId);

		Session session = null;

		try {
			session = openSession();

			FactExpense[] array = new FactExpenseImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, factExpense,
					libraryId, orderByComparator, true);

			array[1] = factExpense;

			array[2] = getByLibrary_PrevAndNext(session, factExpense,
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

	protected FactExpense getByLibrary_PrevAndNext(Session session,
		FactExpense factExpense, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTEXPENSE_WHERE);

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
			query.append(FactExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factExpense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactExpense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact expenses where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactExpense factExpense : findByLibrary(libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factExpense);
		}
	}

	/**
	 * Returns the number of fact expenses where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact expenses
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

			query.append(_SQL_COUNT_FACTEXPENSE_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factExpense.libraryId = ?";

	public FactExpensePersistenceImpl() {
		setModelClass(FactExpense.class);
	}

	/**
	 * Caches the fact expense in the entity cache if it is enabled.
	 *
	 * @param factExpense the fact expense
	 */
	@Override
	public void cacheResult(FactExpense factExpense) {
		EntityCacheUtil.putResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseImpl.class, factExpense.getPrimaryKey(), factExpense);

		factExpense.resetOriginalValues();
	}

	/**
	 * Caches the fact expenses in the entity cache if it is enabled.
	 *
	 * @param factExpenses the fact expenses
	 */
	@Override
	public void cacheResult(List<FactExpense> factExpenses) {
		for (FactExpense factExpense : factExpenses) {
			if (EntityCacheUtil.getResult(
						FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
						FactExpenseImpl.class, factExpense.getPrimaryKey()) == null) {
				cacheResult(factExpense);
			}
			else {
				factExpense.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact expenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactExpenseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactExpenseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact expense.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactExpense factExpense) {
		EntityCacheUtil.removeResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseImpl.class, factExpense.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactExpense> factExpenses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactExpense factExpense : factExpenses) {
			EntityCacheUtil.removeResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
				FactExpenseImpl.class, factExpense.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact expense with the primary key. Does not add the fact expense to the database.
	 *
	 * @param factExpenseId the primary key for the new fact expense
	 * @return the new fact expense
	 */
	@Override
	public FactExpense create(long factExpenseId) {
		FactExpense factExpense = new FactExpenseImpl();

		factExpense.setNew(true);
		factExpense.setPrimaryKey(factExpenseId);

		return factExpense;
	}

	/**
	 * Removes the fact expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factExpenseId the primary key of the fact expense
	 * @return the fact expense that was removed
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense remove(long factExpenseId)
		throws NoSuchFactExpenseException, SystemException {
		return remove((Serializable)factExpenseId);
	}

	/**
	 * Removes the fact expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact expense
	 * @return the fact expense that was removed
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense remove(Serializable primaryKey)
		throws NoSuchFactExpenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactExpense factExpense = (FactExpense)session.get(FactExpenseImpl.class,
					primaryKey);

			if (factExpense == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factExpense);
		}
		catch (NoSuchFactExpenseException nsee) {
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
	protected FactExpense removeImpl(FactExpense factExpense)
		throws SystemException {
		factExpense = toUnwrappedModel(factExpense);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factExpense)) {
				factExpense = (FactExpense)session.get(FactExpenseImpl.class,
						factExpense.getPrimaryKeyObj());
			}

			if (factExpense != null) {
				session.delete(factExpense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factExpense != null) {
			clearCache(factExpense);
		}

		return factExpense;
	}

	@Override
	public FactExpense updateImpl(
		com.idetronic.eis.model.FactExpense factExpense)
		throws SystemException {
		factExpense = toUnwrappedModel(factExpense);

		boolean isNew = factExpense.isNew();

		FactExpenseModelImpl factExpenseModelImpl = (FactExpenseModelImpl)factExpense;

		Session session = null;

		try {
			session = openSession();

			if (factExpense.isNew()) {
				session.save(factExpense);

				factExpense.setNew(false);
			}
			else {
				session.merge(factExpense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactExpenseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factExpenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factExpenseModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { factExpenseModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
			FactExpenseImpl.class, factExpense.getPrimaryKey(), factExpense);

		return factExpense;
	}

	protected FactExpense toUnwrappedModel(FactExpense factExpense) {
		if (factExpense instanceof FactExpenseImpl) {
			return factExpense;
		}

		FactExpenseImpl factExpenseImpl = new FactExpenseImpl();

		factExpenseImpl.setNew(factExpense.isNew());
		factExpenseImpl.setPrimaryKey(factExpense.getPrimaryKey());

		factExpenseImpl.setFactExpenseId(factExpense.getFactExpenseId());
		factExpenseImpl.setLibraryId(factExpense.getLibraryId());
		factExpenseImpl.setPeriod(factExpense.getPeriod());
		factExpenseImpl.setEntryType(factExpense.getEntryType());
		factExpenseImpl.setMasterFileId(factExpense.getMasterFileId());
		factExpenseImpl.setAmount(factExpense.getAmount());
		factExpenseImpl.setCompanyId(factExpense.getCompanyId());
		factExpenseImpl.setGroupId(factExpense.getGroupId());
		factExpenseImpl.setUserId(factExpense.getUserId());
		factExpenseImpl.setUserName(factExpense.getUserName());
		factExpenseImpl.setCreateDate(factExpense.getCreateDate());

		return factExpenseImpl;
	}

	/**
	 * Returns the fact expense with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact expense
	 * @return the fact expense
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactExpenseException, SystemException {
		FactExpense factExpense = fetchByPrimaryKey(primaryKey);

		if (factExpense == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factExpense;
	}

	/**
	 * Returns the fact expense with the primary key or throws a {@link com.idetronic.eis.NoSuchFactExpenseException} if it could not be found.
	 *
	 * @param factExpenseId the primary key of the fact expense
	 * @return the fact expense
	 * @throws com.idetronic.eis.NoSuchFactExpenseException if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense findByPrimaryKey(long factExpenseId)
		throws NoSuchFactExpenseException, SystemException {
		return findByPrimaryKey((Serializable)factExpenseId);
	}

	/**
	 * Returns the fact expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact expense
	 * @return the fact expense, or <code>null</code> if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactExpense factExpense = (FactExpense)EntityCacheUtil.getResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
				FactExpenseImpl.class, primaryKey);

		if (factExpense == _nullFactExpense) {
			return null;
		}

		if (factExpense == null) {
			Session session = null;

			try {
				session = openSession();

				factExpense = (FactExpense)session.get(FactExpenseImpl.class,
						primaryKey);

				if (factExpense != null) {
					cacheResult(factExpense);
				}
				else {
					EntityCacheUtil.putResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
						FactExpenseImpl.class, primaryKey, _nullFactExpense);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactExpenseModelImpl.ENTITY_CACHE_ENABLED,
					FactExpenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factExpense;
	}

	/**
	 * Returns the fact expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factExpenseId the primary key of the fact expense
	 * @return the fact expense, or <code>null</code> if a fact expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactExpense fetchByPrimaryKey(long factExpenseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factExpenseId);
	}

	/**
	 * Returns all the fact expenses.
	 *
	 * @return the fact expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactExpense> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact expenses
	 * @param end the upper bound of the range of fact expenses (not inclusive)
	 * @return the range of fact expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactExpense> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact expenses
	 * @param end the upper bound of the range of fact expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactExpense> findAll(int start, int end,
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

		List<FactExpense> list = (List<FactExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTEXPENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTEXPENSE;

				if (pagination) {
					sql = sql.concat(FactExpenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactExpense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactExpense>(list);
				}
				else {
					list = (List<FactExpense>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact expenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactExpense factExpense : findAll()) {
			remove(factExpense);
		}
	}

	/**
	 * Returns the number of fact expenses.
	 *
	 * @return the number of fact expenses
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

				Query q = session.createQuery(_SQL_COUNT_FACTEXPENSE);

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
	 * Initializes the fact expense persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactExpense")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactExpense>> listenersList = new ArrayList<ModelListener<FactExpense>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactExpense>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactExpenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTEXPENSE = "SELECT factExpense FROM FactExpense factExpense";
	private static final String _SQL_SELECT_FACTEXPENSE_WHERE = "SELECT factExpense FROM FactExpense factExpense WHERE ";
	private static final String _SQL_COUNT_FACTEXPENSE = "SELECT COUNT(factExpense) FROM FactExpense factExpense";
	private static final String _SQL_COUNT_FACTEXPENSE_WHERE = "SELECT COUNT(factExpense) FROM FactExpense factExpense WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factExpense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactExpense exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactExpense exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactExpensePersistenceImpl.class);
	private static FactExpense _nullFactExpense = new FactExpenseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactExpense> toCacheModel() {
				return _nullFactExpenseCacheModel;
			}
		};

	private static CacheModel<FactExpense> _nullFactExpenseCacheModel = new CacheModel<FactExpense>() {
			@Override
			public FactExpense toEntityModel() {
				return _nullFactExpense;
			}
		};
}
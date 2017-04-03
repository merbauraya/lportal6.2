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

import com.idetronic.eis.NoSuchFactIrItemException;
import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.impl.FactIrItemImpl;
import com.idetronic.eis.model.impl.FactIrItemModelImpl;

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
 * The persistence implementation for the fact ir item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIrItemPersistence
 * @see FactIrItemUtil
 * @generated
 */
public class FactIrItemPersistenceImpl extends BasePersistenceImpl<FactIrItem>
	implements FactIrItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactIrItemUtil} to access the fact ir item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactIrItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM =
		new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPeriodItemTypeMedium",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM =
		new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPeriodItemTypeMedium",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			FactIrItemModelImpl.PERIOD_COLUMN_BITMASK |
			FactIrItemModelImpl.ITEMTYPEID_COLUMN_BITMASK |
			FactIrItemModelImpl.ITEMMEDIUMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERIODITEMTYPEMEDIUM = new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPeriodItemTypeMedium",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @return the matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByPeriodItemTypeMedium(String period,
		long itemTypeId, long itemMediumId) throws SystemException {
		return findByPeriodItemTypeMedium(period, itemTypeId, itemMediumId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @return the range of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByPeriodItemTypeMedium(String period,
		long itemTypeId, long itemMediumId, int start, int end)
		throws SystemException {
		return findByPeriodItemTypeMedium(period, itemTypeId, itemMediumId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByPeriodItemTypeMedium(String period,
		long itemTypeId, long itemMediumId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM;
			finderArgs = new Object[] { period, itemTypeId, itemMediumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM;
			finderArgs = new Object[] {
					period, itemTypeId, itemMediumId,
					
					start, end, orderByComparator
				};
		}

		List<FactIrItem> list = (List<FactIrItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactIrItem factIrItem : list) {
				if (!Validator.equals(period, factIrItem.getPeriod()) ||
						(itemTypeId != factIrItem.getItemTypeId()) ||
						(itemMediumId != factIrItem.getItemMediumId())) {
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

			query.append(_SQL_SELECT_FACTIRITEM_WHERE);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_2);
			}

			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMTYPEID_2);

			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMMEDIUMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactIrItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPeriod) {
					qPos.add(period);
				}

				qPos.add(itemTypeId);

				qPos.add(itemMediumId);

				if (!pagination) {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIrItem>(list);
				}
				else {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByPeriodItemTypeMedium_First(String period,
		long itemTypeId, long itemMediumId, OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByPeriodItemTypeMedium_First(period,
				itemTypeId, itemMediumId, orderByComparator);

		if (factIrItem != null) {
			return factIrItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("period=");
		msg.append(period);

		msg.append(", itemTypeId=");
		msg.append(itemTypeId);

		msg.append(", itemMediumId=");
		msg.append(itemMediumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrItemException(msg.toString());
	}

	/**
	 * Returns the first fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByPeriodItemTypeMedium_First(String period,
		long itemTypeId, long itemMediumId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactIrItem> list = findByPeriodItemTypeMedium(period, itemTypeId,
				itemMediumId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByPeriodItemTypeMedium_Last(String period,
		long itemTypeId, long itemMediumId, OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByPeriodItemTypeMedium_Last(period,
				itemTypeId, itemMediumId, orderByComparator);

		if (factIrItem != null) {
			return factIrItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("period=");
		msg.append(period);

		msg.append(", itemTypeId=");
		msg.append(itemTypeId);

		msg.append(", itemMediumId=");
		msg.append(itemMediumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrItemException(msg.toString());
	}

	/**
	 * Returns the last fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByPeriodItemTypeMedium_Last(String period,
		long itemTypeId, long itemMediumId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPeriodItemTypeMedium(period, itemTypeId, itemMediumId);

		if (count == 0) {
			return null;
		}

		List<FactIrItem> list = findByPeriodItemTypeMedium(period, itemTypeId,
				itemMediumId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact ir items before and after the current fact ir item in the ordered set where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param factIrItemId the primary key of the current fact ir item
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem[] findByPeriodItemTypeMedium_PrevAndNext(
		long factIrItemId, String period, long itemTypeId, long itemMediumId,
		OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = findByPrimaryKey(factIrItemId);

		Session session = null;

		try {
			session = openSession();

			FactIrItem[] array = new FactIrItemImpl[3];

			array[0] = getByPeriodItemTypeMedium_PrevAndNext(session,
					factIrItem, period, itemTypeId, itemMediumId,
					orderByComparator, true);

			array[1] = factIrItem;

			array[2] = getByPeriodItemTypeMedium_PrevAndNext(session,
					factIrItem, period, itemTypeId, itemMediumId,
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

	protected FactIrItem getByPeriodItemTypeMedium_PrevAndNext(
		Session session, FactIrItem factIrItem, String period, long itemTypeId,
		long itemMediumId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTIRITEM_WHERE);

		boolean bindPeriod = false;

		if (period == null) {
			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_1);
		}
		else if (period.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_3);
		}
		else {
			bindPeriod = true;

			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_2);
		}

		query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMTYPEID_2);

		query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMMEDIUMID_2);

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
			query.append(FactIrItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPeriod) {
			qPos.add(period);
		}

		qPos.add(itemTypeId);

		qPos.add(itemMediumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factIrItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactIrItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63; from the database.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPeriodItemTypeMedium(String period, long itemTypeId,
		long itemMediumId) throws SystemException {
		for (FactIrItem factIrItem : findByPeriodItemTypeMedium(period,
				itemTypeId, itemMediumId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(factIrItem);
		}
	}

	/**
	 * Returns the number of fact ir items where period = &#63; and itemTypeId = &#63; and itemMediumId = &#63;.
	 *
	 * @param period the period
	 * @param itemTypeId the item type ID
	 * @param itemMediumId the item medium ID
	 * @return the number of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPeriodItemTypeMedium(String period, long itemTypeId,
		long itemMediumId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERIODITEMTYPEMEDIUM;

		Object[] finderArgs = new Object[] { period, itemTypeId, itemMediumId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FACTIRITEM_WHERE);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_2);
			}

			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMTYPEID_2);

			query.append(_FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMMEDIUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPeriod) {
					qPos.add(period);
				}

				qPos.add(itemTypeId);

				qPos.add(itemMediumId);

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

	private static final String _FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_1 = "factIrItem.period IS NULL AND ";
	private static final String _FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_2 = "factIrItem.period = ? AND ";
	private static final String _FINDER_COLUMN_PERIODITEMTYPEMEDIUM_PERIOD_3 = "(factIrItem.period IS NULL OR factIrItem.period = '') AND ";
	private static final String _FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMTYPEID_2 =
		"factIrItem.itemTypeId = ? AND ";
	private static final String _FINDER_COLUMN_PERIODITEMTYPEMEDIUM_ITEMMEDIUMID_2 =
		"factIrItem.itemMediumId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD =
		new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLibraryFacultyPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD =
		new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLibraryFacultyPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			FactIrItemModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactIrItemModelImpl.FACULTYID_COLUMN_BITMASK |
			FactIrItemModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYFACULTYPERIOD = new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLibraryFacultyPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @return the matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByLibraryFacultyPeriod(long libraryId,
		long facultyId, String period) throws SystemException {
		return findByLibraryFacultyPeriod(libraryId, facultyId, period,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @return the range of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByLibraryFacultyPeriod(long libraryId,
		long facultyId, String period, int start, int end)
		throws SystemException {
		return findByLibraryFacultyPeriod(libraryId, facultyId, period, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByLibraryFacultyPeriod(long libraryId,
		long facultyId, String period, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD;
			finderArgs = new Object[] { libraryId, facultyId, period };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD;
			finderArgs = new Object[] {
					libraryId, facultyId, period,
					
					start, end, orderByComparator
				};
		}

		List<FactIrItem> list = (List<FactIrItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactIrItem factIrItem : list) {
				if ((libraryId != factIrItem.getLibraryId()) ||
						(facultyId != factIrItem.getFacultyId()) ||
						!Validator.equals(period, factIrItem.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTIRITEM_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_FACULTYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactIrItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				qPos.add(facultyId);

				if (bindPeriod) {
					qPos.add(period);
				}

				if (!pagination) {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIrItem>(list);
				}
				else {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByLibraryFacultyPeriod_First(long libraryId,
		long facultyId, String period, OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByLibraryFacultyPeriod_First(libraryId,
				facultyId, period, orderByComparator);

		if (factIrItem != null) {
			return factIrItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", facultyId=");
		msg.append(facultyId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrItemException(msg.toString());
	}

	/**
	 * Returns the first fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByLibraryFacultyPeriod_First(long libraryId,
		long facultyId, String period, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactIrItem> list = findByLibraryFacultyPeriod(libraryId,
				facultyId, period, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByLibraryFacultyPeriod_Last(long libraryId,
		long facultyId, String period, OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByLibraryFacultyPeriod_Last(libraryId,
				facultyId, period, orderByComparator);

		if (factIrItem != null) {
			return factIrItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", facultyId=");
		msg.append(facultyId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrItemException(msg.toString());
	}

	/**
	 * Returns the last fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByLibraryFacultyPeriod_Last(long libraryId,
		long facultyId, String period, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLibraryFacultyPeriod(libraryId, facultyId, period);

		if (count == 0) {
			return null;
		}

		List<FactIrItem> list = findByLibraryFacultyPeriod(libraryId,
				facultyId, period, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact ir items before and after the current fact ir item in the ordered set where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param factIrItemId the primary key of the current fact ir item
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem[] findByLibraryFacultyPeriod_PrevAndNext(
		long factIrItemId, long libraryId, long facultyId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = findByPrimaryKey(factIrItemId);

		Session session = null;

		try {
			session = openSession();

			FactIrItem[] array = new FactIrItemImpl[3];

			array[0] = getByLibraryFacultyPeriod_PrevAndNext(session,
					factIrItem, libraryId, facultyId, period,
					orderByComparator, true);

			array[1] = factIrItem;

			array[2] = getByLibraryFacultyPeriod_PrevAndNext(session,
					factIrItem, libraryId, facultyId, period,
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

	protected FactIrItem getByLibraryFacultyPeriod_PrevAndNext(
		Session session, FactIrItem factIrItem, long libraryId, long facultyId,
		String period, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTIRITEM_WHERE);

		query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_LIBRARYID_2);

		query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_FACULTYID_2);

		boolean bindPeriod = false;

		if (period == null) {
			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_1);
		}
		else if (period.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_3);
		}
		else {
			bindPeriod = true;

			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_2);
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
			query.append(FactIrItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		qPos.add(facultyId);

		if (bindPeriod) {
			qPos.add(period);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factIrItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactIrItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryFacultyPeriod(long libraryId, long facultyId,
		String period) throws SystemException {
		for (FactIrItem factIrItem : findByLibraryFacultyPeriod(libraryId,
				facultyId, period, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factIrItem);
		}
	}

	/**
	 * Returns the number of fact ir items where libraryId = &#63; and facultyId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param facultyId the faculty ID
	 * @param period the period
	 * @return the number of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibraryFacultyPeriod(long libraryId, long facultyId,
		String period) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARYFACULTYPERIOD;

		Object[] finderArgs = new Object[] { libraryId, facultyId, period };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FACTIRITEM_WHERE);

			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_LIBRARYID_2);

			query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_FACULTYID_2);

			boolean bindPeriod = false;

			if (period == null) {
				query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_1);
			}
			else if (period.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_3);
			}
			else {
				bindPeriod = true;

				query.append(_FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

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

	private static final String _FINDER_COLUMN_LIBRARYFACULTYPERIOD_LIBRARYID_2 = "factIrItem.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYFACULTYPERIOD_FACULTYID_2 = "factIrItem.facultyId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_1 = "factIrItem.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_2 = "factIrItem.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYFACULTYPERIOD_PERIOD_3 = "(factIrItem.period IS NULL OR factIrItem.period = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, FactIrItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactIrItemModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactIrItemModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact ir items where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact ir items where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @return the range of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByLibraryPeriod(long libraryId, String period,
		int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact ir items where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findByLibraryPeriod(long libraryId, String period,
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

		List<FactIrItem> list = (List<FactIrItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactIrItem factIrItem : list) {
				if ((libraryId != factIrItem.getLibraryId()) ||
						!Validator.equals(period, factIrItem.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTIRITEM_WHERE);

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
				query.append(FactIrItemModelImpl.ORDER_BY_JPQL);
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
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIrItem>(list);
				}
				else {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByLibraryPeriod_First(libraryId, period,
				orderByComparator);

		if (factIrItem != null) {
			return factIrItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrItemException(msg.toString());
	}

	/**
	 * Returns the first fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByLibraryPeriod_First(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactIrItem> list = findByLibraryPeriod(libraryId, period, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByLibraryPeriod_Last(libraryId, period,
				orderByComparator);

		if (factIrItem != null) {
			return factIrItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactIrItemException(msg.toString());
	}

	/**
	 * Returns the last fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact ir item, or <code>null</code> if a matching fact ir item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByLibraryPeriod_Last(long libraryId, String period,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<FactIrItem> list = findByLibraryPeriod(libraryId, period,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact ir items before and after the current fact ir item in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param factIrItemId the primary key of the current fact ir item
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem[] findByLibraryPeriod_PrevAndNext(long factIrItemId,
		long libraryId, String period, OrderByComparator orderByComparator)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = findByPrimaryKey(factIrItemId);

		Session session = null;

		try {
			session = openSession();

			FactIrItem[] array = new FactIrItemImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session, factIrItem,
					libraryId, period, orderByComparator, true);

			array[1] = factIrItem;

			array[2] = getByLibraryPeriod_PrevAndNext(session, factIrItem,
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

	protected FactIrItem getByLibraryPeriod_PrevAndNext(Session session,
		FactIrItem factIrItem, long libraryId, String period,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTIRITEM_WHERE);

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
			query.append(FactIrItemModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(factIrItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactIrItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact ir items where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (FactIrItem factIrItem : findByLibraryPeriod(libraryId, period,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factIrItem);
		}
	}

	/**
	 * Returns the number of fact ir items where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching fact ir items
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

			query.append(_SQL_COUNT_FACTIRITEM_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "factIrItem.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "factIrItem.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "factIrItem.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(factIrItem.period IS NULL OR factIrItem.period = '')";

	public FactIrItemPersistenceImpl() {
		setModelClass(FactIrItem.class);
	}

	/**
	 * Caches the fact ir item in the entity cache if it is enabled.
	 *
	 * @param factIrItem the fact ir item
	 */
	@Override
	public void cacheResult(FactIrItem factIrItem) {
		EntityCacheUtil.putResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemImpl.class, factIrItem.getPrimaryKey(), factIrItem);

		factIrItem.resetOriginalValues();
	}

	/**
	 * Caches the fact ir items in the entity cache if it is enabled.
	 *
	 * @param factIrItems the fact ir items
	 */
	@Override
	public void cacheResult(List<FactIrItem> factIrItems) {
		for (FactIrItem factIrItem : factIrItems) {
			if (EntityCacheUtil.getResult(
						FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
						FactIrItemImpl.class, factIrItem.getPrimaryKey()) == null) {
				cacheResult(factIrItem);
			}
			else {
				factIrItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact ir items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactIrItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactIrItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact ir item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactIrItem factIrItem) {
		EntityCacheUtil.removeResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemImpl.class, factIrItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactIrItem> factIrItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactIrItem factIrItem : factIrItems) {
			EntityCacheUtil.removeResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
				FactIrItemImpl.class, factIrItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact ir item with the primary key. Does not add the fact ir item to the database.
	 *
	 * @param factIrItemId the primary key for the new fact ir item
	 * @return the new fact ir item
	 */
	@Override
	public FactIrItem create(long factIrItemId) {
		FactIrItem factIrItem = new FactIrItemImpl();

		factIrItem.setNew(true);
		factIrItem.setPrimaryKey(factIrItemId);

		return factIrItem;
	}

	/**
	 * Removes the fact ir item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factIrItemId the primary key of the fact ir item
	 * @return the fact ir item that was removed
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem remove(long factIrItemId)
		throws NoSuchFactIrItemException, SystemException {
		return remove((Serializable)factIrItemId);
	}

	/**
	 * Removes the fact ir item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact ir item
	 * @return the fact ir item that was removed
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem remove(Serializable primaryKey)
		throws NoSuchFactIrItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactIrItem factIrItem = (FactIrItem)session.get(FactIrItemImpl.class,
					primaryKey);

			if (factIrItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactIrItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factIrItem);
		}
		catch (NoSuchFactIrItemException nsee) {
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
	protected FactIrItem removeImpl(FactIrItem factIrItem)
		throws SystemException {
		factIrItem = toUnwrappedModel(factIrItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factIrItem)) {
				factIrItem = (FactIrItem)session.get(FactIrItemImpl.class,
						factIrItem.getPrimaryKeyObj());
			}

			if (factIrItem != null) {
				session.delete(factIrItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factIrItem != null) {
			clearCache(factIrItem);
		}

		return factIrItem;
	}

	@Override
	public FactIrItem updateImpl(com.idetronic.eis.model.FactIrItem factIrItem)
		throws SystemException {
		factIrItem = toUnwrappedModel(factIrItem);

		boolean isNew = factIrItem.isNew();

		FactIrItemModelImpl factIrItemModelImpl = (FactIrItemModelImpl)factIrItem;

		Session session = null;

		try {
			session = openSession();

			if (factIrItem.isNew()) {
				session.save(factIrItem);

				factIrItem.setNew(false);
			}
			else {
				session.merge(factIrItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactIrItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factIrItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factIrItemModelImpl.getOriginalPeriod(),
						factIrItemModelImpl.getOriginalItemTypeId(),
						factIrItemModelImpl.getOriginalItemMediumId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIODITEMTYPEMEDIUM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM,
					args);

				args = new Object[] {
						factIrItemModelImpl.getPeriod(),
						factIrItemModelImpl.getItemTypeId(),
						factIrItemModelImpl.getItemMediumId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERIODITEMTYPEMEDIUM,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERIODITEMTYPEMEDIUM,
					args);
			}

			if ((factIrItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factIrItemModelImpl.getOriginalLibraryId(),
						factIrItemModelImpl.getOriginalFacultyId(),
						factIrItemModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYFACULTYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD,
					args);

				args = new Object[] {
						factIrItemModelImpl.getLibraryId(),
						factIrItemModelImpl.getFacultyId(),
						factIrItemModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYFACULTYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYFACULTYPERIOD,
					args);
			}

			if ((factIrItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factIrItemModelImpl.getOriginalLibraryId(),
						factIrItemModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						factIrItemModelImpl.getLibraryId(),
						factIrItemModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
			FactIrItemImpl.class, factIrItem.getPrimaryKey(), factIrItem);

		return factIrItem;
	}

	protected FactIrItem toUnwrappedModel(FactIrItem factIrItem) {
		if (factIrItem instanceof FactIrItemImpl) {
			return factIrItem;
		}

		FactIrItemImpl factIrItemImpl = new FactIrItemImpl();

		factIrItemImpl.setNew(factIrItem.isNew());
		factIrItemImpl.setPrimaryKey(factIrItem.getPrimaryKey());

		factIrItemImpl.setFactIrItemId(factIrItem.getFactIrItemId());
		factIrItemImpl.setLibraryId(factIrItem.getLibraryId());
		factIrItemImpl.setFacultyId(factIrItem.getFacultyId());
		factIrItemImpl.setPeriod(factIrItem.getPeriod());
		factIrItemImpl.setItemTypeId(factIrItem.getItemTypeId());
		factIrItemImpl.setItemMediumId(factIrItem.getItemMediumId());
		factIrItemImpl.setTitleTotal(factIrItem.getTitleTotal());
		factIrItemImpl.setVolumeTotal(factIrItem.getVolumeTotal());
		factIrItemImpl.setCreatedByUserId(factIrItem.getCreatedByUserId());
		factIrItemImpl.setCreatedByUserName(factIrItem.getCreatedByUserName());
		factIrItemImpl.setCreatedDate(factIrItem.getCreatedDate());

		return factIrItemImpl;
	}

	/**
	 * Returns the fact ir item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact ir item
	 * @return the fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactIrItemException, SystemException {
		FactIrItem factIrItem = fetchByPrimaryKey(primaryKey);

		if (factIrItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactIrItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factIrItem;
	}

	/**
	 * Returns the fact ir item with the primary key or throws a {@link com.idetronic.eis.NoSuchFactIrItemException} if it could not be found.
	 *
	 * @param factIrItemId the primary key of the fact ir item
	 * @return the fact ir item
	 * @throws com.idetronic.eis.NoSuchFactIrItemException if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem findByPrimaryKey(long factIrItemId)
		throws NoSuchFactIrItemException, SystemException {
		return findByPrimaryKey((Serializable)factIrItemId);
	}

	/**
	 * Returns the fact ir item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact ir item
	 * @return the fact ir item, or <code>null</code> if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactIrItem factIrItem = (FactIrItem)EntityCacheUtil.getResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
				FactIrItemImpl.class, primaryKey);

		if (factIrItem == _nullFactIrItem) {
			return null;
		}

		if (factIrItem == null) {
			Session session = null;

			try {
				session = openSession();

				factIrItem = (FactIrItem)session.get(FactIrItemImpl.class,
						primaryKey);

				if (factIrItem != null) {
					cacheResult(factIrItem);
				}
				else {
					EntityCacheUtil.putResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
						FactIrItemImpl.class, primaryKey, _nullFactIrItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactIrItemModelImpl.ENTITY_CACHE_ENABLED,
					FactIrItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factIrItem;
	}

	/**
	 * Returns the fact ir item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factIrItemId the primary key of the fact ir item
	 * @return the fact ir item, or <code>null</code> if a fact ir item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactIrItem fetchByPrimaryKey(long factIrItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factIrItemId);
	}

	/**
	 * Returns all the fact ir items.
	 *
	 * @return the fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact ir items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @return the range of fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact ir items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact ir items
	 * @param end the upper bound of the range of fact ir items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact ir items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactIrItem> findAll(int start, int end,
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

		List<FactIrItem> list = (List<FactIrItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTIRITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTIRITEM;

				if (pagination) {
					sql = sql.concat(FactIrItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactIrItem>(list);
				}
				else {
					list = (List<FactIrItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fact ir items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactIrItem factIrItem : findAll()) {
			remove(factIrItem);
		}
	}

	/**
	 * Returns the number of fact ir items.
	 *
	 * @return the number of fact ir items
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

				Query q = session.createQuery(_SQL_COUNT_FACTIRITEM);

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
	 * Initializes the fact ir item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactIrItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactIrItem>> listenersList = new ArrayList<ModelListener<FactIrItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactIrItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactIrItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTIRITEM = "SELECT factIrItem FROM FactIrItem factIrItem";
	private static final String _SQL_SELECT_FACTIRITEM_WHERE = "SELECT factIrItem FROM FactIrItem factIrItem WHERE ";
	private static final String _SQL_COUNT_FACTIRITEM = "SELECT COUNT(factIrItem) FROM FactIrItem factIrItem";
	private static final String _SQL_COUNT_FACTIRITEM_WHERE = "SELECT COUNT(factIrItem) FROM FactIrItem factIrItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factIrItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactIrItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactIrItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactIrItemPersistenceImpl.class);
	private static FactIrItem _nullFactIrItem = new FactIrItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactIrItem> toCacheModel() {
				return _nullFactIrItemCacheModel;
			}
		};

	private static CacheModel<FactIrItem> _nullFactIrItemCacheModel = new CacheModel<FactIrItem>() {
			@Override
			public FactIrItem toEntityModel() {
				return _nullFactIrItem;
			}
		};
}
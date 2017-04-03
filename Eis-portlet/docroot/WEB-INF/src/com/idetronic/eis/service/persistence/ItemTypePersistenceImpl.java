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

import com.idetronic.eis.NoSuchItemTypeException;
import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.model.impl.ItemTypeImpl;
import com.idetronic.eis.model.impl.ItemTypeModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypePersistence
 * @see ItemTypeUtil
 * @generated
 */
public class ItemTypePersistenceImpl extends BasePersistenceImpl<ItemType>
	implements ItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemTypeUtil} to access the item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRINTEDTYPE =
		new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrintedType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINTEDTYPE =
		new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrintedType",
			new String[] { Integer.class.getName() },
			ItemTypeModelImpl.PRINTEDTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRINTEDTYPE = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrintedType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the item types where printedType = &#63;.
	 *
	 * @param printedType the printed type
	 * @return the matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findByPrintedType(int printedType)
		throws SystemException {
		return findByPrintedType(printedType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item types where printedType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param printedType the printed type
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @return the range of matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findByPrintedType(int printedType, int start, int end)
		throws SystemException {
		return findByPrintedType(printedType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item types where printedType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param printedType the printed type
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findByPrintedType(int printedType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINTEDTYPE;
			finderArgs = new Object[] { printedType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRINTEDTYPE;
			finderArgs = new Object[] { printedType, start, end, orderByComparator };
		}

		List<ItemType> list = (List<ItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemType itemType : list) {
				if ((printedType != itemType.getPrintedType())) {
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

			query.append(_SQL_SELECT_ITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_PRINTEDTYPE_PRINTEDTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(printedType);

				if (!pagination) {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemType>(list);
				}
				else {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item type in the ordered set where printedType = &#63;.
	 *
	 * @param printedType the printed type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByPrintedType_First(int printedType,
		OrderByComparator orderByComparator)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = fetchByPrintedType_First(printedType,
				orderByComparator);

		if (itemType != null) {
			return itemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("printedType=");
		msg.append(printedType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemTypeException(msg.toString());
	}

	/**
	 * Returns the first item type in the ordered set where printedType = &#63;.
	 *
	 * @param printedType the printed type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item type, or <code>null</code> if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByPrintedType_First(int printedType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemType> list = findByPrintedType(printedType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item type in the ordered set where printedType = &#63;.
	 *
	 * @param printedType the printed type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByPrintedType_Last(int printedType,
		OrderByComparator orderByComparator)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = fetchByPrintedType_Last(printedType,
				orderByComparator);

		if (itemType != null) {
			return itemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("printedType=");
		msg.append(printedType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemTypeException(msg.toString());
	}

	/**
	 * Returns the last item type in the ordered set where printedType = &#63;.
	 *
	 * @param printedType the printed type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item type, or <code>null</code> if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByPrintedType_Last(int printedType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPrintedType(printedType);

		if (count == 0) {
			return null;
		}

		List<ItemType> list = findByPrintedType(printedType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item types before and after the current item type in the ordered set where printedType = &#63;.
	 *
	 * @param itemTypeId the primary key of the current item type
	 * @param printedType the printed type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType[] findByPrintedType_PrevAndNext(long itemTypeId,
		int printedType, OrderByComparator orderByComparator)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = findByPrimaryKey(itemTypeId);

		Session session = null;

		try {
			session = openSession();

			ItemType[] array = new ItemTypeImpl[3];

			array[0] = getByPrintedType_PrevAndNext(session, itemType,
					printedType, orderByComparator, true);

			array[1] = itemType;

			array[2] = getByPrintedType_PrevAndNext(session, itemType,
					printedType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ItemType getByPrintedType_PrevAndNext(Session session,
		ItemType itemType, int printedType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMTYPE_WHERE);

		query.append(_FINDER_COLUMN_PRINTEDTYPE_PRINTEDTYPE_2);

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
			query.append(ItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(printedType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item types where printedType = &#63; from the database.
	 *
	 * @param printedType the printed type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrintedType(int printedType) throws SystemException {
		for (ItemType itemType : findByPrintedType(printedType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemType);
		}
	}

	/**
	 * Returns the number of item types where printedType = &#63;.
	 *
	 * @param printedType the printed type
	 * @return the number of matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrintedType(int printedType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRINTEDTYPE;

		Object[] finderArgs = new Object[] { printedType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_PRINTEDTYPE_PRINTEDTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(printedType);

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

	private static final String _FINDER_COLUMN_PRINTEDTYPE_PRINTEDTYPE_2 = "itemType.printedType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IRTYPE = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIRType",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IRTYPE =
		new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, ItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIRType",
			new String[] { Boolean.class.getName() },
			ItemTypeModelImpl.IRTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IRTYPE = new FinderPath(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIRType",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the item types where IRType = &#63;.
	 *
	 * @param IRType the i r type
	 * @return the matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findByIRType(boolean IRType)
		throws SystemException {
		return findByIRType(IRType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item types where IRType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param IRType the i r type
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @return the range of matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findByIRType(boolean IRType, int start, int end)
		throws SystemException {
		return findByIRType(IRType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item types where IRType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param IRType the i r type
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findByIRType(boolean IRType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IRTYPE;
			finderArgs = new Object[] { IRType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IRTYPE;
			finderArgs = new Object[] { IRType, start, end, orderByComparator };
		}

		List<ItemType> list = (List<ItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ItemType itemType : list) {
				if ((IRType != itemType.getIRType())) {
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

			query.append(_SQL_SELECT_ITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_IRTYPE_IRTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(IRType);

				if (!pagination) {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemType>(list);
				}
				else {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first item type in the ordered set where IRType = &#63;.
	 *
	 * @param IRType the i r type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByIRType_First(boolean IRType,
		OrderByComparator orderByComparator)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = fetchByIRType_First(IRType, orderByComparator);

		if (itemType != null) {
			return itemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("IRType=");
		msg.append(IRType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemTypeException(msg.toString());
	}

	/**
	 * Returns the first item type in the ordered set where IRType = &#63;.
	 *
	 * @param IRType the i r type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item type, or <code>null</code> if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByIRType_First(boolean IRType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ItemType> list = findByIRType(IRType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item type in the ordered set where IRType = &#63;.
	 *
	 * @param IRType the i r type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByIRType_Last(boolean IRType,
		OrderByComparator orderByComparator)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = fetchByIRType_Last(IRType, orderByComparator);

		if (itemType != null) {
			return itemType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("IRType=");
		msg.append(IRType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemTypeException(msg.toString());
	}

	/**
	 * Returns the last item type in the ordered set where IRType = &#63;.
	 *
	 * @param IRType the i r type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item type, or <code>null</code> if a matching item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByIRType_Last(boolean IRType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIRType(IRType);

		if (count == 0) {
			return null;
		}

		List<ItemType> list = findByIRType(IRType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item types before and after the current item type in the ordered set where IRType = &#63;.
	 *
	 * @param itemTypeId the primary key of the current item type
	 * @param IRType the i r type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType[] findByIRType_PrevAndNext(long itemTypeId, boolean IRType,
		OrderByComparator orderByComparator)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = findByPrimaryKey(itemTypeId);

		Session session = null;

		try {
			session = openSession();

			ItemType[] array = new ItemTypeImpl[3];

			array[0] = getByIRType_PrevAndNext(session, itemType, IRType,
					orderByComparator, true);

			array[1] = itemType;

			array[2] = getByIRType_PrevAndNext(session, itemType, IRType,
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

	protected ItemType getByIRType_PrevAndNext(Session session,
		ItemType itemType, boolean IRType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMTYPE_WHERE);

		query.append(_FINDER_COLUMN_IRTYPE_IRTYPE_2);

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
			query.append(ItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(IRType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(itemType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ItemType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item types where IRType = &#63; from the database.
	 *
	 * @param IRType the i r type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIRType(boolean IRType) throws SystemException {
		for (ItemType itemType : findByIRType(IRType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(itemType);
		}
	}

	/**
	 * Returns the number of item types where IRType = &#63;.
	 *
	 * @param IRType the i r type
	 * @return the number of matching item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIRType(boolean IRType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IRTYPE;

		Object[] finderArgs = new Object[] { IRType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_IRTYPE_IRTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(IRType);

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

	private static final String _FINDER_COLUMN_IRTYPE_IRTYPE_2 = "itemType.IRType = ?";

	public ItemTypePersistenceImpl() {
		setModelClass(ItemType.class);
	}

	/**
	 * Caches the item type in the entity cache if it is enabled.
	 *
	 * @param itemType the item type
	 */
	@Override
	public void cacheResult(ItemType itemType) {
		EntityCacheUtil.putResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeImpl.class, itemType.getPrimaryKey(), itemType);

		itemType.resetOriginalValues();
	}

	/**
	 * Caches the item types in the entity cache if it is enabled.
	 *
	 * @param itemTypes the item types
	 */
	@Override
	public void cacheResult(List<ItemType> itemTypes) {
		for (ItemType itemType : itemTypes) {
			if (EntityCacheUtil.getResult(
						ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						ItemTypeImpl.class, itemType.getPrimaryKey()) == null) {
				cacheResult(itemType);
			}
			else {
				itemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ItemType itemType) {
		EntityCacheUtil.removeResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeImpl.class, itemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ItemType> itemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ItemType itemType : itemTypes) {
			EntityCacheUtil.removeResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				ItemTypeImpl.class, itemType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item type with the primary key. Does not add the item type to the database.
	 *
	 * @param itemTypeId the primary key for the new item type
	 * @return the new item type
	 */
	@Override
	public ItemType create(long itemTypeId) {
		ItemType itemType = new ItemTypeImpl();

		itemType.setNew(true);
		itemType.setPrimaryKey(itemTypeId);

		return itemType;
	}

	/**
	 * Removes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemTypeId the primary key of the item type
	 * @return the item type that was removed
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType remove(long itemTypeId)
		throws NoSuchItemTypeException, SystemException {
		return remove((Serializable)itemTypeId);
	}

	/**
	 * Removes the item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item type
	 * @return the item type that was removed
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType remove(Serializable primaryKey)
		throws NoSuchItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ItemType itemType = (ItemType)session.get(ItemTypeImpl.class,
					primaryKey);

			if (itemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemType);
		}
		catch (NoSuchItemTypeException nsee) {
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
	protected ItemType removeImpl(ItemType itemType) throws SystemException {
		itemType = toUnwrappedModel(itemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemType)) {
				itemType = (ItemType)session.get(ItemTypeImpl.class,
						itemType.getPrimaryKeyObj());
			}

			if (itemType != null) {
				session.delete(itemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemType != null) {
			clearCache(itemType);
		}

		return itemType;
	}

	@Override
	public ItemType updateImpl(com.idetronic.eis.model.ItemType itemType)
		throws SystemException {
		itemType = toUnwrappedModel(itemType);

		boolean isNew = itemType.isNew();

		ItemTypeModelImpl itemTypeModelImpl = (ItemTypeModelImpl)itemType;

		Session session = null;

		try {
			session = openSession();

			if (itemType.isNew()) {
				session.save(itemType);

				itemType.setNew(false);
			}
			else {
				session.merge(itemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ItemTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((itemTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINTEDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemTypeModelImpl.getOriginalPrintedType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRINTEDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINTEDTYPE,
					args);

				args = new Object[] { itemTypeModelImpl.getPrintedType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRINTEDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINTEDTYPE,
					args);
			}

			if ((itemTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IRTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemTypeModelImpl.getOriginalIRType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IRTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IRTYPE,
					args);

				args = new Object[] { itemTypeModelImpl.getIRType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IRTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IRTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			ItemTypeImpl.class, itemType.getPrimaryKey(), itemType);

		return itemType;
	}

	protected ItemType toUnwrappedModel(ItemType itemType) {
		if (itemType instanceof ItemTypeImpl) {
			return itemType;
		}

		ItemTypeImpl itemTypeImpl = new ItemTypeImpl();

		itemTypeImpl.setNew(itemType.isNew());
		itemTypeImpl.setPrimaryKey(itemType.getPrimaryKey());

		itemTypeImpl.setItemTypeId(itemType.getItemTypeId());
		itemTypeImpl.setItemTypeName(itemType.getItemTypeName());
		itemTypeImpl.setPrintedType(itemType.getPrintedType());
		itemTypeImpl.setIRType(itemType.isIRType());
		itemTypeImpl.setActive(itemType.isActive());

		return itemTypeImpl;
	}

	/**
	 * Returns the item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item type
	 * @return the item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemTypeException, SystemException {
		ItemType itemType = fetchByPrimaryKey(primaryKey);

		if (itemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemType;
	}

	/**
	 * Returns the item type with the primary key or throws a {@link com.idetronic.eis.NoSuchItemTypeException} if it could not be found.
	 *
	 * @param itemTypeId the primary key of the item type
	 * @return the item type
	 * @throws com.idetronic.eis.NoSuchItemTypeException if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType findByPrimaryKey(long itemTypeId)
		throws NoSuchItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)itemTypeId);
	}

	/**
	 * Returns the item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item type
	 * @return the item type, or <code>null</code> if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ItemType itemType = (ItemType)EntityCacheUtil.getResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				ItemTypeImpl.class, primaryKey);

		if (itemType == _nullItemType) {
			return null;
		}

		if (itemType == null) {
			Session session = null;

			try {
				session = openSession();

				itemType = (ItemType)session.get(ItemTypeImpl.class, primaryKey);

				if (itemType != null) {
					cacheResult(itemType);
				}
				else {
					EntityCacheUtil.putResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						ItemTypeImpl.class, primaryKey, _nullItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					ItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemType;
	}

	/**
	 * Returns the item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemTypeId the primary key of the item type
	 * @return the item type, or <code>null</code> if a item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ItemType fetchByPrimaryKey(long itemTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)itemTypeId);
	}

	/**
	 * Returns all the item types.
	 *
	 * @return the item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @return the range of item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item types
	 * @param end the upper bound of the range of item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ItemType> findAll(int start, int end,
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

		List<ItemType> list = (List<ItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMTYPE;

				if (pagination) {
					sql = sql.concat(ItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ItemType>(list);
				}
				else {
					list = (List<ItemType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ItemType itemType : findAll()) {
			remove(itemType);
		}
	}

	/**
	 * Returns the number of item types.
	 *
	 * @return the number of item types
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

				Query q = session.createQuery(_SQL_COUNT_ITEMTYPE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.ItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ItemType>> listenersList = new ArrayList<ModelListener<ItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ITEMTYPE = "SELECT itemType FROM ItemType itemType";
	private static final String _SQL_SELECT_ITEMTYPE_WHERE = "SELECT itemType FROM ItemType itemType WHERE ";
	private static final String _SQL_COUNT_ITEMTYPE = "SELECT COUNT(itemType) FROM ItemType itemType";
	private static final String _SQL_COUNT_ITEMTYPE_WHERE = "SELECT COUNT(itemType) FROM ItemType itemType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ItemType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ItemType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ItemTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static ItemType _nullItemType = new ItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ItemType> toCacheModel() {
				return _nullItemTypeCacheModel;
			}
		};

	private static CacheModel<ItemType> _nullItemTypeCacheModel = new CacheModel<ItemType>() {
			@Override
			public ItemType toEntityModel() {
				return _nullItemType;
			}
		};
}
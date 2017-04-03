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

import com.idetronic.eis.NoSuchFactPrintedMaterialException;
import com.idetronic.eis.model.FactPrintedMaterial;
import com.idetronic.eis.model.impl.FactPrintedMaterialImpl;
import com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl;

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
 * The persistence implementation for the fact printed material service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPrintedMaterialPersistence
 * @see FactPrintedMaterialUtil
 * @generated
 */
public class FactPrintedMaterialPersistenceImpl extends BasePersistenceImpl<FactPrintedMaterial>
	implements FactPrintedMaterialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactPrintedMaterialUtil} to access the fact printed material persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactPrintedMaterialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactPrintedMaterialModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact printed materials where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact printed materials where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact printed materials
	 * @param end the upper bound of the range of fact printed materials (not inclusive)
	 * @return the range of matching fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findByLibrary(long libraryId, int start,
		int end) throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact printed materials where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact printed materials
	 * @param end the upper bound of the range of fact printed materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findByLibrary(long libraryId, int start,
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

		List<FactPrintedMaterial> list = (List<FactPrintedMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactPrintedMaterial factPrintedMaterial : list) {
				if ((libraryId != factPrintedMaterial.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTPRINTEDMATERIAL_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactPrintedMaterialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactPrintedMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPrintedMaterial>(list);
				}
				else {
					list = (List<FactPrintedMaterial>)QueryUtil.list(q,
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
	 * Returns the first fact printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = fetchByLibrary_First(libraryId,
				orderByComparator);

		if (factPrintedMaterial != null) {
			return factPrintedMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the first fact printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactPrintedMaterial> list = findByLibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = fetchByLibrary_Last(libraryId,
				orderByComparator);

		if (factPrintedMaterial != null) {
			return factPrintedMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the last fact printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactPrintedMaterial> list = findByLibrary(libraryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact printed materials before and after the current fact printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param factPrintedMaterialId the primary key of the current fact printed material
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial[] findByLibrary_PrevAndNext(
		long factPrintedMaterialId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = findByPrimaryKey(factPrintedMaterialId);

		Session session = null;

		try {
			session = openSession();

			FactPrintedMaterial[] array = new FactPrintedMaterialImpl[3];

			array[0] = getByLibrary_PrevAndNext(session, factPrintedMaterial,
					libraryId, orderByComparator, true);

			array[1] = factPrintedMaterial;

			array[2] = getByLibrary_PrevAndNext(session, factPrintedMaterial,
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

	protected FactPrintedMaterial getByLibrary_PrevAndNext(Session session,
		FactPrintedMaterial factPrintedMaterial, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTPRINTEDMATERIAL_WHERE);

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
			query.append(FactPrintedMaterialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factPrintedMaterial);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactPrintedMaterial> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact printed materials where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactPrintedMaterial factPrintedMaterial : findByLibrary(
				libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factPrintedMaterial);
		}
	}

	/**
	 * Returns the number of fact printed materials where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact printed materials
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

			query.append(_SQL_COUNT_FACTPRINTEDMATERIAL_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factPrintedMaterial.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactPrintedMaterialModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactPrintedMaterialModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findByLibraryPeriod(long libraryId,
		String period) throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact printed materials
	 * @param end the upper bound of the range of fact printed materials (not inclusive)
	 * @return the range of matching fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findByLibraryPeriod(long libraryId,
		String period, int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact printed materials
	 * @param end the upper bound of the range of fact printed materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findByLibraryPeriod(long libraryId,
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

		List<FactPrintedMaterial> list = (List<FactPrintedMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactPrintedMaterial factPrintedMaterial : list) {
				if ((libraryId != factPrintedMaterial.getLibraryId()) ||
						!Validator.equals(period,
							factPrintedMaterial.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTPRINTEDMATERIAL_WHERE);

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
				query.append(FactPrintedMaterialModelImpl.ORDER_BY_JPQL);
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
					list = (List<FactPrintedMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPrintedMaterial>(list);
				}
				else {
					list = (List<FactPrintedMaterial>)QueryUtil.list(q,
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
	 * Returns the first fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial findByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = fetchByLibraryPeriod_First(libraryId,
				period, orderByComparator);

		if (factPrintedMaterial != null) {
			return factPrintedMaterial;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the first fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial fetchByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactPrintedMaterial> list = findByLibraryPeriod(libraryId, period,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial findByLibraryPeriod_Last(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = fetchByLibraryPeriod_Last(libraryId,
				period, orderByComparator);

		if (factPrintedMaterial != null) {
			return factPrintedMaterial;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the last fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact printed material, or <code>null</code> if a matching fact printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial fetchByLibraryPeriod_Last(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<FactPrintedMaterial> list = findByLibraryPeriod(libraryId, period,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact printed materials before and after the current fact printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param factPrintedMaterialId the primary key of the current fact printed material
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial[] findByLibraryPeriod_PrevAndNext(
		long factPrintedMaterialId, long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = findByPrimaryKey(factPrintedMaterialId);

		Session session = null;

		try {
			session = openSession();

			FactPrintedMaterial[] array = new FactPrintedMaterialImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session,
					factPrintedMaterial, libraryId, period, orderByComparator,
					true);

			array[1] = factPrintedMaterial;

			array[2] = getByLibraryPeriod_PrevAndNext(session,
					factPrintedMaterial, libraryId, period, orderByComparator,
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

	protected FactPrintedMaterial getByLibraryPeriod_PrevAndNext(
		Session session, FactPrintedMaterial factPrintedMaterial,
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

		query.append(_SQL_SELECT_FACTPRINTEDMATERIAL_WHERE);

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
			query.append(FactPrintedMaterialModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(factPrintedMaterial);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactPrintedMaterial> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact printed materials where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (FactPrintedMaterial factPrintedMaterial : findByLibraryPeriod(
				libraryId, period, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factPrintedMaterial);
		}
	}

	/**
	 * Returns the number of fact printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching fact printed materials
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

			query.append(_SQL_COUNT_FACTPRINTEDMATERIAL_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "factPrintedMaterial.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "factPrintedMaterial.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "factPrintedMaterial.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(factPrintedMaterial.period IS NULL OR factPrintedMaterial.period = '')";

	public FactPrintedMaterialPersistenceImpl() {
		setModelClass(FactPrintedMaterial.class);
	}

	/**
	 * Caches the fact printed material in the entity cache if it is enabled.
	 *
	 * @param factPrintedMaterial the fact printed material
	 */
	@Override
	public void cacheResult(FactPrintedMaterial factPrintedMaterial) {
		EntityCacheUtil.putResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialImpl.class, factPrintedMaterial.getPrimaryKey(),
			factPrintedMaterial);

		factPrintedMaterial.resetOriginalValues();
	}

	/**
	 * Caches the fact printed materials in the entity cache if it is enabled.
	 *
	 * @param factPrintedMaterials the fact printed materials
	 */
	@Override
	public void cacheResult(List<FactPrintedMaterial> factPrintedMaterials) {
		for (FactPrintedMaterial factPrintedMaterial : factPrintedMaterials) {
			if (EntityCacheUtil.getResult(
						FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
						FactPrintedMaterialImpl.class,
						factPrintedMaterial.getPrimaryKey()) == null) {
				cacheResult(factPrintedMaterial);
			}
			else {
				factPrintedMaterial.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact printed materials.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactPrintedMaterialImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactPrintedMaterialImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact printed material.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactPrintedMaterial factPrintedMaterial) {
		EntityCacheUtil.removeResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialImpl.class, factPrintedMaterial.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactPrintedMaterial> factPrintedMaterials) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactPrintedMaterial factPrintedMaterial : factPrintedMaterials) {
			EntityCacheUtil.removeResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
				FactPrintedMaterialImpl.class,
				factPrintedMaterial.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact printed material with the primary key. Does not add the fact printed material to the database.
	 *
	 * @param factPrintedMaterialId the primary key for the new fact printed material
	 * @return the new fact printed material
	 */
	@Override
	public FactPrintedMaterial create(long factPrintedMaterialId) {
		FactPrintedMaterial factPrintedMaterial = new FactPrintedMaterialImpl();

		factPrintedMaterial.setNew(true);
		factPrintedMaterial.setPrimaryKey(factPrintedMaterialId);

		return factPrintedMaterial;
	}

	/**
	 * Removes the fact printed material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factPrintedMaterialId the primary key of the fact printed material
	 * @return the fact printed material that was removed
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial remove(long factPrintedMaterialId)
		throws NoSuchFactPrintedMaterialException, SystemException {
		return remove((Serializable)factPrintedMaterialId);
	}

	/**
	 * Removes the fact printed material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact printed material
	 * @return the fact printed material that was removed
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial remove(Serializable primaryKey)
		throws NoSuchFactPrintedMaterialException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactPrintedMaterial factPrintedMaterial = (FactPrintedMaterial)session.get(FactPrintedMaterialImpl.class,
					primaryKey);

			if (factPrintedMaterial == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactPrintedMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factPrintedMaterial);
		}
		catch (NoSuchFactPrintedMaterialException nsee) {
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
	protected FactPrintedMaterial removeImpl(
		FactPrintedMaterial factPrintedMaterial) throws SystemException {
		factPrintedMaterial = toUnwrappedModel(factPrintedMaterial);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factPrintedMaterial)) {
				factPrintedMaterial = (FactPrintedMaterial)session.get(FactPrintedMaterialImpl.class,
						factPrintedMaterial.getPrimaryKeyObj());
			}

			if (factPrintedMaterial != null) {
				session.delete(factPrintedMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factPrintedMaterial != null) {
			clearCache(factPrintedMaterial);
		}

		return factPrintedMaterial;
	}

	@Override
	public FactPrintedMaterial updateImpl(
		com.idetronic.eis.model.FactPrintedMaterial factPrintedMaterial)
		throws SystemException {
		factPrintedMaterial = toUnwrappedModel(factPrintedMaterial);

		boolean isNew = factPrintedMaterial.isNew();

		FactPrintedMaterialModelImpl factPrintedMaterialModelImpl = (FactPrintedMaterialModelImpl)factPrintedMaterial;

		Session session = null;

		try {
			session = openSession();

			if (factPrintedMaterial.isNew()) {
				session.save(factPrintedMaterial);

				factPrintedMaterial.setNew(false);
			}
			else {
				session.merge(factPrintedMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactPrintedMaterialModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factPrintedMaterialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factPrintedMaterialModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { factPrintedMaterialModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}

			if ((factPrintedMaterialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factPrintedMaterialModelImpl.getOriginalLibraryId(),
						factPrintedMaterialModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						factPrintedMaterialModelImpl.getLibraryId(),
						factPrintedMaterialModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactPrintedMaterialImpl.class, factPrintedMaterial.getPrimaryKey(),
			factPrintedMaterial);

		return factPrintedMaterial;
	}

	protected FactPrintedMaterial toUnwrappedModel(
		FactPrintedMaterial factPrintedMaterial) {
		if (factPrintedMaterial instanceof FactPrintedMaterialImpl) {
			return factPrintedMaterial;
		}

		FactPrintedMaterialImpl factPrintedMaterialImpl = new FactPrintedMaterialImpl();

		factPrintedMaterialImpl.setNew(factPrintedMaterial.isNew());
		factPrintedMaterialImpl.setPrimaryKey(factPrintedMaterial.getPrimaryKey());

		factPrintedMaterialImpl.setFactPrintedMaterialId(factPrintedMaterial.getFactPrintedMaterialId());
		factPrintedMaterialImpl.setLibraryId(factPrintedMaterial.getLibraryId());
		factPrintedMaterialImpl.setLibraryCode(factPrintedMaterial.getLibraryCode());
		factPrintedMaterialImpl.setStateId(factPrintedMaterial.getStateId());
		factPrintedMaterialImpl.setStateCode(factPrintedMaterial.getStateCode());
		factPrintedMaterialImpl.setItemTypeId(factPrintedMaterial.getItemTypeId());
		factPrintedMaterialImpl.setPeriod(factPrintedMaterial.getPeriod());
		factPrintedMaterialImpl.setLibraryTypeId(factPrintedMaterial.getLibraryTypeId());
		factPrintedMaterialImpl.setMonthVal(factPrintedMaterial.getMonthVal());
		factPrintedMaterialImpl.setYearVal(factPrintedMaterial.getYearVal());
		factPrintedMaterialImpl.setTitleTotal(factPrintedMaterial.getTitleTotal());
		factPrintedMaterialImpl.setVolumeTotal(factPrintedMaterial.getVolumeTotal());
		factPrintedMaterialImpl.setDateCreated(factPrintedMaterial.getDateCreated());
		factPrintedMaterialImpl.setCreatedByUserName(factPrintedMaterial.getCreatedByUserName());
		factPrintedMaterialImpl.setCreatedByUserId(factPrintedMaterial.getCreatedByUserId());

		return factPrintedMaterialImpl;
	}

	/**
	 * Returns the fact printed material with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact printed material
	 * @return the fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactPrintedMaterialException, SystemException {
		FactPrintedMaterial factPrintedMaterial = fetchByPrimaryKey(primaryKey);

		if (factPrintedMaterial == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactPrintedMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factPrintedMaterial;
	}

	/**
	 * Returns the fact printed material with the primary key or throws a {@link com.idetronic.eis.NoSuchFactPrintedMaterialException} if it could not be found.
	 *
	 * @param factPrintedMaterialId the primary key of the fact printed material
	 * @return the fact printed material
	 * @throws com.idetronic.eis.NoSuchFactPrintedMaterialException if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial findByPrimaryKey(long factPrintedMaterialId)
		throws NoSuchFactPrintedMaterialException, SystemException {
		return findByPrimaryKey((Serializable)factPrintedMaterialId);
	}

	/**
	 * Returns the fact printed material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact printed material
	 * @return the fact printed material, or <code>null</code> if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactPrintedMaterial factPrintedMaterial = (FactPrintedMaterial)EntityCacheUtil.getResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
				FactPrintedMaterialImpl.class, primaryKey);

		if (factPrintedMaterial == _nullFactPrintedMaterial) {
			return null;
		}

		if (factPrintedMaterial == null) {
			Session session = null;

			try {
				session = openSession();

				factPrintedMaterial = (FactPrintedMaterial)session.get(FactPrintedMaterialImpl.class,
						primaryKey);

				if (factPrintedMaterial != null) {
					cacheResult(factPrintedMaterial);
				}
				else {
					EntityCacheUtil.putResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
						FactPrintedMaterialImpl.class, primaryKey,
						_nullFactPrintedMaterial);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
					FactPrintedMaterialImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factPrintedMaterial;
	}

	/**
	 * Returns the fact printed material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factPrintedMaterialId the primary key of the fact printed material
	 * @return the fact printed material, or <code>null</code> if a fact printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactPrintedMaterial fetchByPrimaryKey(long factPrintedMaterialId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factPrintedMaterialId);
	}

	/**
	 * Returns all the fact printed materials.
	 *
	 * @return the fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact printed materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact printed materials
	 * @param end the upper bound of the range of fact printed materials (not inclusive)
	 * @return the range of fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact printed materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact printed materials
	 * @param end the upper bound of the range of fact printed materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactPrintedMaterial> findAll(int start, int end,
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

		List<FactPrintedMaterial> list = (List<FactPrintedMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTPRINTEDMATERIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTPRINTEDMATERIAL;

				if (pagination) {
					sql = sql.concat(FactPrintedMaterialModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactPrintedMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactPrintedMaterial>(list);
				}
				else {
					list = (List<FactPrintedMaterial>)QueryUtil.list(q,
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
	 * Removes all the fact printed materials from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactPrintedMaterial factPrintedMaterial : findAll()) {
			remove(factPrintedMaterial);
		}
	}

	/**
	 * Returns the number of fact printed materials.
	 *
	 * @return the number of fact printed materials
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

				Query q = session.createQuery(_SQL_COUNT_FACTPRINTEDMATERIAL);

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
	 * Initializes the fact printed material persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactPrintedMaterial")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactPrintedMaterial>> listenersList = new ArrayList<ModelListener<FactPrintedMaterial>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactPrintedMaterial>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactPrintedMaterialImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTPRINTEDMATERIAL = "SELECT factPrintedMaterial FROM FactPrintedMaterial factPrintedMaterial";
	private static final String _SQL_SELECT_FACTPRINTEDMATERIAL_WHERE = "SELECT factPrintedMaterial FROM FactPrintedMaterial factPrintedMaterial WHERE ";
	private static final String _SQL_COUNT_FACTPRINTEDMATERIAL = "SELECT COUNT(factPrintedMaterial) FROM FactPrintedMaterial factPrintedMaterial";
	private static final String _SQL_COUNT_FACTPRINTEDMATERIAL_WHERE = "SELECT COUNT(factPrintedMaterial) FROM FactPrintedMaterial factPrintedMaterial WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factPrintedMaterial.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactPrintedMaterial exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactPrintedMaterial exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactPrintedMaterialPersistenceImpl.class);
	private static FactPrintedMaterial _nullFactPrintedMaterial = new FactPrintedMaterialImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactPrintedMaterial> toCacheModel() {
				return _nullFactPrintedMaterialCacheModel;
			}
		};

	private static CacheModel<FactPrintedMaterial> _nullFactPrintedMaterialCacheModel =
		new CacheModel<FactPrintedMaterial>() {
			@Override
			public FactPrintedMaterial toEntityModel() {
				return _nullFactPrintedMaterial;
			}
		};
}
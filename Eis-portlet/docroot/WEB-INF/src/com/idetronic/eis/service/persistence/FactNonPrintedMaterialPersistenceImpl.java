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

import com.idetronic.eis.NoSuchFactNonPrintedMaterialException;
import com.idetronic.eis.model.FactNonPrintedMaterial;
import com.idetronic.eis.model.impl.FactNonPrintedMaterialImpl;
import com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl;

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
 * The persistence implementation for the fact non printed material service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactNonPrintedMaterialPersistence
 * @see FactNonPrintedMaterialUtil
 * @generated
 */
public class FactNonPrintedMaterialPersistenceImpl extends BasePersistenceImpl<FactNonPrintedMaterial>
	implements FactNonPrintedMaterialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactNonPrintedMaterialUtil} to access the fact non printed material persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactNonPrintedMaterialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibrary",
			new String[] { Long.class.getName() },
			FactNonPrintedMaterialModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact non printed materials where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findByLibrary(long libraryId)
		throws SystemException {
		return findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the fact non printed materials where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact non printed materials
	 * @param end the upper bound of the range of fact non printed materials (not inclusive)
	 * @return the range of matching fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findByLibrary(long libraryId,
		int start, int end) throws SystemException {
		return findByLibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact non printed materials where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of fact non printed materials
	 * @param end the upper bound of the range of fact non printed materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findByLibrary(long libraryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<FactNonPrintedMaterial> list = (List<FactNonPrintedMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactNonPrintedMaterial factNonPrintedMaterial : list) {
				if ((libraryId != factNonPrintedMaterial.getLibraryId())) {
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

			query.append(_SQL_SELECT_FACTNONPRINTEDMATERIAL_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactNonPrintedMaterialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<FactNonPrintedMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactNonPrintedMaterial>(list);
				}
				else {
					list = (List<FactNonPrintedMaterial>)QueryUtil.list(q,
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
	 * Returns the first fact non printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial findByLibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = fetchByLibrary_First(libraryId,
				orderByComparator);

		if (factNonPrintedMaterial != null) {
			return factNonPrintedMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactNonPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the first fact non printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact non printed material, or <code>null</code> if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial fetchByLibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactNonPrintedMaterial> list = findByLibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact non printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial findByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = fetchByLibrary_Last(libraryId,
				orderByComparator);

		if (factNonPrintedMaterial != null) {
			return factNonPrintedMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactNonPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the last fact non printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact non printed material, or <code>null</code> if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial fetchByLibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<FactNonPrintedMaterial> list = findByLibrary(libraryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact non printed materials before and after the current fact non printed material in the ordered set where libraryId = &#63;.
	 *
	 * @param factNonPrintedMaterialId the primary key of the current fact non printed material
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial[] findByLibrary_PrevAndNext(
		long factNonPrintedMaterialId, long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = findByPrimaryKey(factNonPrintedMaterialId);

		Session session = null;

		try {
			session = openSession();

			FactNonPrintedMaterial[] array = new FactNonPrintedMaterialImpl[3];

			array[0] = getByLibrary_PrevAndNext(session,
					factNonPrintedMaterial, libraryId, orderByComparator, true);

			array[1] = factNonPrintedMaterial;

			array[2] = getByLibrary_PrevAndNext(session,
					factNonPrintedMaterial, libraryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactNonPrintedMaterial getByLibrary_PrevAndNext(Session session,
		FactNonPrintedMaterial factNonPrintedMaterial, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTNONPRINTEDMATERIAL_WHERE);

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
			query.append(FactNonPrintedMaterialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factNonPrintedMaterial);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactNonPrintedMaterial> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact non printed materials where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibrary(long libraryId) throws SystemException {
		for (FactNonPrintedMaterial factNonPrintedMaterial : findByLibrary(
				libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factNonPrintedMaterial);
		}
	}

	/**
	 * Returns the number of fact non printed materials where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching fact non printed materials
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

			query.append(_SQL_COUNT_FACTNONPRINTEDMATERIAL_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "factNonPrintedMaterial.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibraryPeriod",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD =
		new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() },
			FactNonPrintedMaterialModelImpl.LIBRARYID_COLUMN_BITMASK |
			FactNonPrintedMaterialModelImpl.PERIOD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARYPERIOD = new FinderPath(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibraryPeriod",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the fact non printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the matching fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findByLibraryPeriod(long libraryId,
		String period) throws SystemException {
		return findByLibraryPeriod(libraryId, period, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact non printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact non printed materials
	 * @param end the upper bound of the range of fact non printed materials (not inclusive)
	 * @return the range of matching fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findByLibraryPeriod(long libraryId,
		String period, int start, int end) throws SystemException {
		return findByLibraryPeriod(libraryId, period, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact non printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param start the lower bound of the range of fact non printed materials
	 * @param end the upper bound of the range of fact non printed materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findByLibraryPeriod(long libraryId,
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

		List<FactNonPrintedMaterial> list = (List<FactNonPrintedMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactNonPrintedMaterial factNonPrintedMaterial : list) {
				if ((libraryId != factNonPrintedMaterial.getLibraryId()) ||
						!Validator.equals(period,
							factNonPrintedMaterial.getPeriod())) {
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

			query.append(_SQL_SELECT_FACTNONPRINTEDMATERIAL_WHERE);

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
				query.append(FactNonPrintedMaterialModelImpl.ORDER_BY_JPQL);
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
					list = (List<FactNonPrintedMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactNonPrintedMaterial>(list);
				}
				else {
					list = (List<FactNonPrintedMaterial>)QueryUtil.list(q,
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
	 * Returns the first fact non printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial findByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = fetchByLibraryPeriod_First(libraryId,
				period, orderByComparator);

		if (factNonPrintedMaterial != null) {
			return factNonPrintedMaterial;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactNonPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the first fact non printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact non printed material, or <code>null</code> if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial fetchByLibraryPeriod_First(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		List<FactNonPrintedMaterial> list = findByLibraryPeriod(libraryId,
				period, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact non printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial findByLibraryPeriod_Last(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = fetchByLibraryPeriod_Last(libraryId,
				period, orderByComparator);

		if (factNonPrintedMaterial != null) {
			return factNonPrintedMaterial;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(", period=");
		msg.append(period);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactNonPrintedMaterialException(msg.toString());
	}

	/**
	 * Returns the last fact non printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact non printed material, or <code>null</code> if a matching fact non printed material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial fetchByLibraryPeriod_Last(long libraryId,
		String period, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLibraryPeriod(libraryId, period);

		if (count == 0) {
			return null;
		}

		List<FactNonPrintedMaterial> list = findByLibraryPeriod(libraryId,
				period, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact non printed materials before and after the current fact non printed material in the ordered set where libraryId = &#63; and period = &#63;.
	 *
	 * @param factNonPrintedMaterialId the primary key of the current fact non printed material
	 * @param libraryId the library ID
	 * @param period the period
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial[] findByLibraryPeriod_PrevAndNext(
		long factNonPrintedMaterialId, long libraryId, String period,
		OrderByComparator orderByComparator)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = findByPrimaryKey(factNonPrintedMaterialId);

		Session session = null;

		try {
			session = openSession();

			FactNonPrintedMaterial[] array = new FactNonPrintedMaterialImpl[3];

			array[0] = getByLibraryPeriod_PrevAndNext(session,
					factNonPrintedMaterial, libraryId, period,
					orderByComparator, true);

			array[1] = factNonPrintedMaterial;

			array[2] = getByLibraryPeriod_PrevAndNext(session,
					factNonPrintedMaterial, libraryId, period,
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

	protected FactNonPrintedMaterial getByLibraryPeriod_PrevAndNext(
		Session session, FactNonPrintedMaterial factNonPrintedMaterial,
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

		query.append(_SQL_SELECT_FACTNONPRINTEDMATERIAL_WHERE);

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
			query.append(FactNonPrintedMaterialModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(factNonPrintedMaterial);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactNonPrintedMaterial> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact non printed materials where libraryId = &#63; and period = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibraryPeriod(long libraryId, String period)
		throws SystemException {
		for (FactNonPrintedMaterial factNonPrintedMaterial : findByLibraryPeriod(
				libraryId, period, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factNonPrintedMaterial);
		}
	}

	/**
	 * Returns the number of fact non printed materials where libraryId = &#63; and period = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param period the period
	 * @return the number of matching fact non printed materials
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

			query.append(_SQL_COUNT_FACTNONPRINTEDMATERIAL_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARYPERIOD_LIBRARYID_2 = "factNonPrintedMaterial.libraryId = ? AND ";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_1 = "factNonPrintedMaterial.period IS NULL";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_2 = "factNonPrintedMaterial.period = ?";
	private static final String _FINDER_COLUMN_LIBRARYPERIOD_PERIOD_3 = "(factNonPrintedMaterial.period IS NULL OR factNonPrintedMaterial.period = '')";

	public FactNonPrintedMaterialPersistenceImpl() {
		setModelClass(FactNonPrintedMaterial.class);
	}

	/**
	 * Caches the fact non printed material in the entity cache if it is enabled.
	 *
	 * @param factNonPrintedMaterial the fact non printed material
	 */
	@Override
	public void cacheResult(FactNonPrintedMaterial factNonPrintedMaterial) {
		EntityCacheUtil.putResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			factNonPrintedMaterial.getPrimaryKey(), factNonPrintedMaterial);

		factNonPrintedMaterial.resetOriginalValues();
	}

	/**
	 * Caches the fact non printed materials in the entity cache if it is enabled.
	 *
	 * @param factNonPrintedMaterials the fact non printed materials
	 */
	@Override
	public void cacheResult(
		List<FactNonPrintedMaterial> factNonPrintedMaterials) {
		for (FactNonPrintedMaterial factNonPrintedMaterial : factNonPrintedMaterials) {
			if (EntityCacheUtil.getResult(
						FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
						FactNonPrintedMaterialImpl.class,
						factNonPrintedMaterial.getPrimaryKey()) == null) {
				cacheResult(factNonPrintedMaterial);
			}
			else {
				factNonPrintedMaterial.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact non printed materials.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactNonPrintedMaterialImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactNonPrintedMaterialImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact non printed material.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactNonPrintedMaterial factNonPrintedMaterial) {
		EntityCacheUtil.removeResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			factNonPrintedMaterial.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactNonPrintedMaterial> factNonPrintedMaterials) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactNonPrintedMaterial factNonPrintedMaterial : factNonPrintedMaterials) {
			EntityCacheUtil.removeResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
				FactNonPrintedMaterialImpl.class,
				factNonPrintedMaterial.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact non printed material with the primary key. Does not add the fact non printed material to the database.
	 *
	 * @param factNonPrintedMaterialId the primary key for the new fact non printed material
	 * @return the new fact non printed material
	 */
	@Override
	public FactNonPrintedMaterial create(long factNonPrintedMaterialId) {
		FactNonPrintedMaterial factNonPrintedMaterial = new FactNonPrintedMaterialImpl();

		factNonPrintedMaterial.setNew(true);
		factNonPrintedMaterial.setPrimaryKey(factNonPrintedMaterialId);

		return factNonPrintedMaterial;
	}

	/**
	 * Removes the fact non printed material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factNonPrintedMaterialId the primary key of the fact non printed material
	 * @return the fact non printed material that was removed
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial remove(long factNonPrintedMaterialId)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		return remove((Serializable)factNonPrintedMaterialId);
	}

	/**
	 * Removes the fact non printed material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact non printed material
	 * @return the fact non printed material that was removed
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial remove(Serializable primaryKey)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactNonPrintedMaterial factNonPrintedMaterial = (FactNonPrintedMaterial)session.get(FactNonPrintedMaterialImpl.class,
					primaryKey);

			if (factNonPrintedMaterial == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactNonPrintedMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factNonPrintedMaterial);
		}
		catch (NoSuchFactNonPrintedMaterialException nsee) {
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
	protected FactNonPrintedMaterial removeImpl(
		FactNonPrintedMaterial factNonPrintedMaterial)
		throws SystemException {
		factNonPrintedMaterial = toUnwrappedModel(factNonPrintedMaterial);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factNonPrintedMaterial)) {
				factNonPrintedMaterial = (FactNonPrintedMaterial)session.get(FactNonPrintedMaterialImpl.class,
						factNonPrintedMaterial.getPrimaryKeyObj());
			}

			if (factNonPrintedMaterial != null) {
				session.delete(factNonPrintedMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factNonPrintedMaterial != null) {
			clearCache(factNonPrintedMaterial);
		}

		return factNonPrintedMaterial;
	}

	@Override
	public FactNonPrintedMaterial updateImpl(
		com.idetronic.eis.model.FactNonPrintedMaterial factNonPrintedMaterial)
		throws SystemException {
		factNonPrintedMaterial = toUnwrappedModel(factNonPrintedMaterial);

		boolean isNew = factNonPrintedMaterial.isNew();

		FactNonPrintedMaterialModelImpl factNonPrintedMaterialModelImpl = (FactNonPrintedMaterialModelImpl)factNonPrintedMaterial;

		Session session = null;

		try {
			session = openSession();

			if (factNonPrintedMaterial.isNew()) {
				session.save(factNonPrintedMaterial);

				factNonPrintedMaterial.setNew(false);
			}
			else {
				session.merge(factNonPrintedMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactNonPrintedMaterialModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factNonPrintedMaterialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factNonPrintedMaterialModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] {
						factNonPrintedMaterialModelImpl.getLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}

			if ((factNonPrintedMaterialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factNonPrintedMaterialModelImpl.getOriginalLibraryId(),
						factNonPrintedMaterialModelImpl.getOriginalPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);

				args = new Object[] {
						factNonPrintedMaterialModelImpl.getLibraryId(),
						factNonPrintedMaterialModelImpl.getPeriod()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARYPERIOD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARYPERIOD,
					args);
			}
		}

		EntityCacheUtil.putResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
			FactNonPrintedMaterialImpl.class,
			factNonPrintedMaterial.getPrimaryKey(), factNonPrintedMaterial);

		return factNonPrintedMaterial;
	}

	protected FactNonPrintedMaterial toUnwrappedModel(
		FactNonPrintedMaterial factNonPrintedMaterial) {
		if (factNonPrintedMaterial instanceof FactNonPrintedMaterialImpl) {
			return factNonPrintedMaterial;
		}

		FactNonPrintedMaterialImpl factNonPrintedMaterialImpl = new FactNonPrintedMaterialImpl();

		factNonPrintedMaterialImpl.setNew(factNonPrintedMaterial.isNew());
		factNonPrintedMaterialImpl.setPrimaryKey(factNonPrintedMaterial.getPrimaryKey());

		factNonPrintedMaterialImpl.setFactNonPrintedMaterialId(factNonPrintedMaterial.getFactNonPrintedMaterialId());
		factNonPrintedMaterialImpl.setLibraryId(factNonPrintedMaterial.getLibraryId());
		factNonPrintedMaterialImpl.setLibraryCode(factNonPrintedMaterial.getLibraryCode());
		factNonPrintedMaterialImpl.setStateId(factNonPrintedMaterial.getStateId());
		factNonPrintedMaterialImpl.setStateCode(factNonPrintedMaterial.getStateCode());
		factNonPrintedMaterialImpl.setLibraryTypeId(factNonPrintedMaterial.getLibraryTypeId());
		factNonPrintedMaterialImpl.setItemTypeId(factNonPrintedMaterial.getItemTypeId());
		factNonPrintedMaterialImpl.setPeriod(factNonPrintedMaterial.getPeriod());
		factNonPrintedMaterialImpl.setMonthVal(factNonPrintedMaterial.getMonthVal());
		factNonPrintedMaterialImpl.setYearVal(factNonPrintedMaterial.getYearVal());
		factNonPrintedMaterialImpl.setTitleTotal(factNonPrintedMaterial.getTitleTotal());
		factNonPrintedMaterialImpl.setVolumeTotal(factNonPrintedMaterial.getVolumeTotal());
		factNonPrintedMaterialImpl.setDateCreated(factNonPrintedMaterial.getDateCreated());
		factNonPrintedMaterialImpl.setCreatedByUserName(factNonPrintedMaterial.getCreatedByUserName());
		factNonPrintedMaterialImpl.setCreatedByUserId(factNonPrintedMaterial.getCreatedByUserId());

		return factNonPrintedMaterialImpl;
	}

	/**
	 * Returns the fact non printed material with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact non printed material
	 * @return the fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = fetchByPrimaryKey(primaryKey);

		if (factNonPrintedMaterial == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactNonPrintedMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factNonPrintedMaterial;
	}

	/**
	 * Returns the fact non printed material with the primary key or throws a {@link com.idetronic.eis.NoSuchFactNonPrintedMaterialException} if it could not be found.
	 *
	 * @param factNonPrintedMaterialId the primary key of the fact non printed material
	 * @return the fact non printed material
	 * @throws com.idetronic.eis.NoSuchFactNonPrintedMaterialException if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial findByPrimaryKey(
		long factNonPrintedMaterialId)
		throws NoSuchFactNonPrintedMaterialException, SystemException {
		return findByPrimaryKey((Serializable)factNonPrintedMaterialId);
	}

	/**
	 * Returns the fact non printed material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact non printed material
	 * @return the fact non printed material, or <code>null</code> if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactNonPrintedMaterial factNonPrintedMaterial = (FactNonPrintedMaterial)EntityCacheUtil.getResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
				FactNonPrintedMaterialImpl.class, primaryKey);

		if (factNonPrintedMaterial == _nullFactNonPrintedMaterial) {
			return null;
		}

		if (factNonPrintedMaterial == null) {
			Session session = null;

			try {
				session = openSession();

				factNonPrintedMaterial = (FactNonPrintedMaterial)session.get(FactNonPrintedMaterialImpl.class,
						primaryKey);

				if (factNonPrintedMaterial != null) {
					cacheResult(factNonPrintedMaterial);
				}
				else {
					EntityCacheUtil.putResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
						FactNonPrintedMaterialImpl.class, primaryKey,
						_nullFactNonPrintedMaterial);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactNonPrintedMaterialModelImpl.ENTITY_CACHE_ENABLED,
					FactNonPrintedMaterialImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factNonPrintedMaterial;
	}

	/**
	 * Returns the fact non printed material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factNonPrintedMaterialId the primary key of the fact non printed material
	 * @return the fact non printed material, or <code>null</code> if a fact non printed material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactNonPrintedMaterial fetchByPrimaryKey(
		long factNonPrintedMaterialId) throws SystemException {
		return fetchByPrimaryKey((Serializable)factNonPrintedMaterialId);
	}

	/**
	 * Returns all the fact non printed materials.
	 *
	 * @return the fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact non printed materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact non printed materials
	 * @param end the upper bound of the range of fact non printed materials (not inclusive)
	 * @return the range of fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact non printed materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactNonPrintedMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact non printed materials
	 * @param end the upper bound of the range of fact non printed materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact non printed materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactNonPrintedMaterial> findAll(int start, int end,
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

		List<FactNonPrintedMaterial> list = (List<FactNonPrintedMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTNONPRINTEDMATERIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTNONPRINTEDMATERIAL;

				if (pagination) {
					sql = sql.concat(FactNonPrintedMaterialModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactNonPrintedMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactNonPrintedMaterial>(list);
				}
				else {
					list = (List<FactNonPrintedMaterial>)QueryUtil.list(q,
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
	 * Removes all the fact non printed materials from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactNonPrintedMaterial factNonPrintedMaterial : findAll()) {
			remove(factNonPrintedMaterial);
		}
	}

	/**
	 * Returns the number of fact non printed materials.
	 *
	 * @return the number of fact non printed materials
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

				Query q = session.createQuery(_SQL_COUNT_FACTNONPRINTEDMATERIAL);

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
	 * Initializes the fact non printed material persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactNonPrintedMaterial")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactNonPrintedMaterial>> listenersList = new ArrayList<ModelListener<FactNonPrintedMaterial>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactNonPrintedMaterial>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactNonPrintedMaterialImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTNONPRINTEDMATERIAL = "SELECT factNonPrintedMaterial FROM FactNonPrintedMaterial factNonPrintedMaterial";
	private static final String _SQL_SELECT_FACTNONPRINTEDMATERIAL_WHERE = "SELECT factNonPrintedMaterial FROM FactNonPrintedMaterial factNonPrintedMaterial WHERE ";
	private static final String _SQL_COUNT_FACTNONPRINTEDMATERIAL = "SELECT COUNT(factNonPrintedMaterial) FROM FactNonPrintedMaterial factNonPrintedMaterial";
	private static final String _SQL_COUNT_FACTNONPRINTEDMATERIAL_WHERE = "SELECT COUNT(factNonPrintedMaterial) FROM FactNonPrintedMaterial factNonPrintedMaterial WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factNonPrintedMaterial.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactNonPrintedMaterial exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactNonPrintedMaterial exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactNonPrintedMaterialPersistenceImpl.class);
	private static FactNonPrintedMaterial _nullFactNonPrintedMaterial = new FactNonPrintedMaterialImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactNonPrintedMaterial> toCacheModel() {
				return _nullFactNonPrintedMaterialCacheModel;
			}
		};

	private static CacheModel<FactNonPrintedMaterial> _nullFactNonPrintedMaterialCacheModel =
		new CacheModel<FactNonPrintedMaterial>() {
			@Override
			public FactNonPrintedMaterial toEntityModel() {
				return _nullFactNonPrintedMaterial;
			}
		};
}
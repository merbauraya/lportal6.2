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

import com.idetronic.eis.NoSuchSeatingCategoryException;
import com.idetronic.eis.model.SeatingCategory;
import com.idetronic.eis.model.impl.SeatingCategoryImpl;
import com.idetronic.eis.model.impl.SeatingCategoryModelImpl;

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
 * The persistence implementation for the seating category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SeatingCategoryPersistence
 * @see SeatingCategoryUtil
 * @generated
 */
public class SeatingCategoryPersistenceImpl extends BasePersistenceImpl<SeatingCategory>
	implements SeatingCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SeatingCategoryUtil} to access the seating category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SeatingCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryModelImpl.FINDER_CACHE_ENABLED,
			SeatingCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryModelImpl.FINDER_CACHE_ENABLED,
			SeatingCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryModelImpl.FINDER_CACHE_ENABLED,
			SeatingCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartment",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryModelImpl.FINDER_CACHE_ENABLED,
			SeatingCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartment",
			new String[] { Long.class.getName() },
			SeatingCategoryModelImpl.SEATINGDEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENT = new FinderPath(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartment",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the seating categories where seatingDepartmentId = &#63;.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @return the matching seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingCategory> findByDepartment(long seatingDepartmentId)
		throws SystemException {
		return findByDepartment(seatingDepartmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seating categories where seatingDepartmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @param start the lower bound of the range of seating categories
	 * @param end the upper bound of the range of seating categories (not inclusive)
	 * @return the range of matching seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingCategory> findByDepartment(long seatingDepartmentId,
		int start, int end) throws SystemException {
		return findByDepartment(seatingDepartmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the seating categories where seatingDepartmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @param start the lower bound of the range of seating categories
	 * @param end the upper bound of the range of seating categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingCategory> findByDepartment(long seatingDepartmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT;
			finderArgs = new Object[] { seatingDepartmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT;
			finderArgs = new Object[] {
					seatingDepartmentId,
					
					start, end, orderByComparator
				};
		}

		List<SeatingCategory> list = (List<SeatingCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SeatingCategory seatingCategory : list) {
				if ((seatingDepartmentId != seatingCategory.getSeatingDepartmentId())) {
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

			query.append(_SQL_SELECT_SEATINGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_SEATINGDEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SeatingCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(seatingDepartmentId);

				if (!pagination) {
					list = (List<SeatingCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SeatingCategory>(list);
				}
				else {
					list = (List<SeatingCategory>)QueryUtil.list(q,
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
	 * Returns the first seating category in the ordered set where seatingDepartmentId = &#63;.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seating category
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a matching seating category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory findByDepartment_First(long seatingDepartmentId,
		OrderByComparator orderByComparator)
		throws NoSuchSeatingCategoryException, SystemException {
		SeatingCategory seatingCategory = fetchByDepartment_First(seatingDepartmentId,
				orderByComparator);

		if (seatingCategory != null) {
			return seatingCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("seatingDepartmentId=");
		msg.append(seatingDepartmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeatingCategoryException(msg.toString());
	}

	/**
	 * Returns the first seating category in the ordered set where seatingDepartmentId = &#63;.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seating category, or <code>null</code> if a matching seating category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory fetchByDepartment_First(long seatingDepartmentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SeatingCategory> list = findByDepartment(seatingDepartmentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last seating category in the ordered set where seatingDepartmentId = &#63;.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seating category
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a matching seating category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory findByDepartment_Last(long seatingDepartmentId,
		OrderByComparator orderByComparator)
		throws NoSuchSeatingCategoryException, SystemException {
		SeatingCategory seatingCategory = fetchByDepartment_Last(seatingDepartmentId,
				orderByComparator);

		if (seatingCategory != null) {
			return seatingCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("seatingDepartmentId=");
		msg.append(seatingDepartmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeatingCategoryException(msg.toString());
	}

	/**
	 * Returns the last seating category in the ordered set where seatingDepartmentId = &#63;.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seating category, or <code>null</code> if a matching seating category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory fetchByDepartment_Last(long seatingDepartmentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDepartment(seatingDepartmentId);

		if (count == 0) {
			return null;
		}

		List<SeatingCategory> list = findByDepartment(seatingDepartmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the seating categories before and after the current seating category in the ordered set where seatingDepartmentId = &#63;.
	 *
	 * @param seatingCategoryId the primary key of the current seating category
	 * @param seatingDepartmentId the seating department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next seating category
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory[] findByDepartment_PrevAndNext(
		long seatingCategoryId, long seatingDepartmentId,
		OrderByComparator orderByComparator)
		throws NoSuchSeatingCategoryException, SystemException {
		SeatingCategory seatingCategory = findByPrimaryKey(seatingCategoryId);

		Session session = null;

		try {
			session = openSession();

			SeatingCategory[] array = new SeatingCategoryImpl[3];

			array[0] = getByDepartment_PrevAndNext(session, seatingCategory,
					seatingDepartmentId, orderByComparator, true);

			array[1] = seatingCategory;

			array[2] = getByDepartment_PrevAndNext(session, seatingCategory,
					seatingDepartmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SeatingCategory getByDepartment_PrevAndNext(Session session,
		SeatingCategory seatingCategory, long seatingDepartmentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEATINGCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENT_SEATINGDEPARTMENTID_2);

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
			query.append(SeatingCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(seatingDepartmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(seatingCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SeatingCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seating categories where seatingDepartmentId = &#63; from the database.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartment(long seatingDepartmentId)
		throws SystemException {
		for (SeatingCategory seatingCategory : findByDepartment(
				seatingDepartmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(seatingCategory);
		}
	}

	/**
	 * Returns the number of seating categories where seatingDepartmentId = &#63;.
	 *
	 * @param seatingDepartmentId the seating department ID
	 * @return the number of matching seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDepartment(long seatingDepartmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENT;

		Object[] finderArgs = new Object[] { seatingDepartmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEATINGCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_SEATINGDEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(seatingDepartmentId);

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

	private static final String _FINDER_COLUMN_DEPARTMENT_SEATINGDEPARTMENTID_2 = "seatingCategory.seatingDepartmentId = ?";

	public SeatingCategoryPersistenceImpl() {
		setModelClass(SeatingCategory.class);
	}

	/**
	 * Caches the seating category in the entity cache if it is enabled.
	 *
	 * @param seatingCategory the seating category
	 */
	@Override
	public void cacheResult(SeatingCategory seatingCategory) {
		EntityCacheUtil.putResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryImpl.class, seatingCategory.getPrimaryKey(),
			seatingCategory);

		seatingCategory.resetOriginalValues();
	}

	/**
	 * Caches the seating categories in the entity cache if it is enabled.
	 *
	 * @param seatingCategories the seating categories
	 */
	@Override
	public void cacheResult(List<SeatingCategory> seatingCategories) {
		for (SeatingCategory seatingCategory : seatingCategories) {
			if (EntityCacheUtil.getResult(
						SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
						SeatingCategoryImpl.class,
						seatingCategory.getPrimaryKey()) == null) {
				cacheResult(seatingCategory);
			}
			else {
				seatingCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all seating categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SeatingCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SeatingCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the seating category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SeatingCategory seatingCategory) {
		EntityCacheUtil.removeResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryImpl.class, seatingCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SeatingCategory> seatingCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SeatingCategory seatingCategory : seatingCategories) {
			EntityCacheUtil.removeResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
				SeatingCategoryImpl.class, seatingCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new seating category with the primary key. Does not add the seating category to the database.
	 *
	 * @param seatingCategoryId the primary key for the new seating category
	 * @return the new seating category
	 */
	@Override
	public SeatingCategory create(long seatingCategoryId) {
		SeatingCategory seatingCategory = new SeatingCategoryImpl();

		seatingCategory.setNew(true);
		seatingCategory.setPrimaryKey(seatingCategoryId);

		return seatingCategory;
	}

	/**
	 * Removes the seating category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatingCategoryId the primary key of the seating category
	 * @return the seating category that was removed
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory remove(long seatingCategoryId)
		throws NoSuchSeatingCategoryException, SystemException {
		return remove((Serializable)seatingCategoryId);
	}

	/**
	 * Removes the seating category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the seating category
	 * @return the seating category that was removed
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory remove(Serializable primaryKey)
		throws NoSuchSeatingCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SeatingCategory seatingCategory = (SeatingCategory)session.get(SeatingCategoryImpl.class,
					primaryKey);

			if (seatingCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSeatingCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(seatingCategory);
		}
		catch (NoSuchSeatingCategoryException nsee) {
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
	protected SeatingCategory removeImpl(SeatingCategory seatingCategory)
		throws SystemException {
		seatingCategory = toUnwrappedModel(seatingCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(seatingCategory)) {
				seatingCategory = (SeatingCategory)session.get(SeatingCategoryImpl.class,
						seatingCategory.getPrimaryKeyObj());
			}

			if (seatingCategory != null) {
				session.delete(seatingCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (seatingCategory != null) {
			clearCache(seatingCategory);
		}

		return seatingCategory;
	}

	@Override
	public SeatingCategory updateImpl(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws SystemException {
		seatingCategory = toUnwrappedModel(seatingCategory);

		boolean isNew = seatingCategory.isNew();

		SeatingCategoryModelImpl seatingCategoryModelImpl = (SeatingCategoryModelImpl)seatingCategory;

		Session session = null;

		try {
			session = openSession();

			if (seatingCategory.isNew()) {
				session.save(seatingCategory);

				seatingCategory.setNew(false);
			}
			else {
				session.merge(seatingCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SeatingCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((seatingCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						seatingCategoryModelImpl.getOriginalSeatingDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);

				args = new Object[] {
						seatingCategoryModelImpl.getSeatingDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
			SeatingCategoryImpl.class, seatingCategory.getPrimaryKey(),
			seatingCategory);

		return seatingCategory;
	}

	protected SeatingCategory toUnwrappedModel(SeatingCategory seatingCategory) {
		if (seatingCategory instanceof SeatingCategoryImpl) {
			return seatingCategory;
		}

		SeatingCategoryImpl seatingCategoryImpl = new SeatingCategoryImpl();

		seatingCategoryImpl.setNew(seatingCategory.isNew());
		seatingCategoryImpl.setPrimaryKey(seatingCategory.getPrimaryKey());

		seatingCategoryImpl.setSeatingCategoryId(seatingCategory.getSeatingCategoryId());
		seatingCategoryImpl.setSeatingCategoryName(seatingCategory.getSeatingCategoryName());
		seatingCategoryImpl.setSeatingDepartmentId(seatingCategory.getSeatingDepartmentId());
		seatingCategoryImpl.setCompanyId(seatingCategory.getCompanyId());
		seatingCategoryImpl.setGroupId(seatingCategory.getGroupId());
		seatingCategoryImpl.setUserId(seatingCategory.getUserId());
		seatingCategoryImpl.setUserName(seatingCategory.getUserName());
		seatingCategoryImpl.setCreateDate(seatingCategory.getCreateDate());
		seatingCategoryImpl.setModifiedDate(seatingCategory.getModifiedDate());

		return seatingCategoryImpl;
	}

	/**
	 * Returns the seating category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the seating category
	 * @return the seating category
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSeatingCategoryException, SystemException {
		SeatingCategory seatingCategory = fetchByPrimaryKey(primaryKey);

		if (seatingCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSeatingCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return seatingCategory;
	}

	/**
	 * Returns the seating category with the primary key or throws a {@link com.idetronic.eis.NoSuchSeatingCategoryException} if it could not be found.
	 *
	 * @param seatingCategoryId the primary key of the seating category
	 * @return the seating category
	 * @throws com.idetronic.eis.NoSuchSeatingCategoryException if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory findByPrimaryKey(long seatingCategoryId)
		throws NoSuchSeatingCategoryException, SystemException {
		return findByPrimaryKey((Serializable)seatingCategoryId);
	}

	/**
	 * Returns the seating category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the seating category
	 * @return the seating category, or <code>null</code> if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SeatingCategory seatingCategory = (SeatingCategory)EntityCacheUtil.getResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
				SeatingCategoryImpl.class, primaryKey);

		if (seatingCategory == _nullSeatingCategory) {
			return null;
		}

		if (seatingCategory == null) {
			Session session = null;

			try {
				session = openSession();

				seatingCategory = (SeatingCategory)session.get(SeatingCategoryImpl.class,
						primaryKey);

				if (seatingCategory != null) {
					cacheResult(seatingCategory);
				}
				else {
					EntityCacheUtil.putResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
						SeatingCategoryImpl.class, primaryKey,
						_nullSeatingCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SeatingCategoryModelImpl.ENTITY_CACHE_ENABLED,
					SeatingCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return seatingCategory;
	}

	/**
	 * Returns the seating category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seatingCategoryId the primary key of the seating category
	 * @return the seating category, or <code>null</code> if a seating category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatingCategory fetchByPrimaryKey(long seatingCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)seatingCategoryId);
	}

	/**
	 * Returns all the seating categories.
	 *
	 * @return the seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seating categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seating categories
	 * @param end the upper bound of the range of seating categories (not inclusive)
	 * @return the range of seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the seating categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seating categories
	 * @param end the upper bound of the range of seating categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of seating categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatingCategory> findAll(int start, int end,
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

		List<SeatingCategory> list = (List<SeatingCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEATINGCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEATINGCATEGORY;

				if (pagination) {
					sql = sql.concat(SeatingCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SeatingCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SeatingCategory>(list);
				}
				else {
					list = (List<SeatingCategory>)QueryUtil.list(q,
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
	 * Removes all the seating categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SeatingCategory seatingCategory : findAll()) {
			remove(seatingCategory);
		}
	}

	/**
	 * Returns the number of seating categories.
	 *
	 * @return the number of seating categories
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

				Query q = session.createQuery(_SQL_COUNT_SEATINGCATEGORY);

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
	 * Initializes the seating category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.SeatingCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SeatingCategory>> listenersList = new ArrayList<ModelListener<SeatingCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SeatingCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SeatingCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEATINGCATEGORY = "SELECT seatingCategory FROM SeatingCategory seatingCategory";
	private static final String _SQL_SELECT_SEATINGCATEGORY_WHERE = "SELECT seatingCategory FROM SeatingCategory seatingCategory WHERE ";
	private static final String _SQL_COUNT_SEATINGCATEGORY = "SELECT COUNT(seatingCategory) FROM SeatingCategory seatingCategory";
	private static final String _SQL_COUNT_SEATINGCATEGORY_WHERE = "SELECT COUNT(seatingCategory) FROM SeatingCategory seatingCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "seatingCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SeatingCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SeatingCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SeatingCategoryPersistenceImpl.class);
	private static SeatingCategory _nullSeatingCategory = new SeatingCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SeatingCategory> toCacheModel() {
				return _nullSeatingCategoryCacheModel;
			}
		};

	private static CacheModel<SeatingCategory> _nullSeatingCategoryCacheModel = new CacheModel<SeatingCategory>() {
			@Override
			public SeatingCategory toEntityModel() {
				return _nullSeatingCategory;
			}
		};
}
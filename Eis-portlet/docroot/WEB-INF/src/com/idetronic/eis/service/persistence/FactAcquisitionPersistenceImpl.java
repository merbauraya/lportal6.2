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

import com.idetronic.eis.NoSuchFactAcquisitionException;
import com.idetronic.eis.model.FactAcquisition;
import com.idetronic.eis.model.impl.FactAcquisitionImpl;
import com.idetronic.eis.model.impl.FactAcquisitionModelImpl;

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
 * The persistence implementation for the fact acquisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactAcquisitionPersistence
 * @see FactAcquisitionUtil
 * @generated
 */
public class FactAcquisitionPersistenceImpl extends BasePersistenceImpl<FactAcquisition>
	implements FactAcquisitionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FactAcquisitionUtil} to access the fact acquisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FactAcquisitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionModelImpl.FINDER_CACHE_ENABLED,
			FactAcquisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionModelImpl.FINDER_CACHE_ENABLED,
			FactAcquisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PTJ = new FinderPath(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionModelImpl.FINDER_CACHE_ENABLED,
			FactAcquisitionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPTJ",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PTJ = new FinderPath(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionModelImpl.FINDER_CACHE_ENABLED,
			FactAcquisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPTJ",
			new String[] { Long.class.getName() },
			FactAcquisitionModelImpl.FACULTYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PTJ = new FinderPath(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPTJ",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fact acquisitions where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the matching fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactAcquisition> findByPTJ(long facultyId)
		throws SystemException {
		return findByPTJ(facultyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact acquisitions where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of fact acquisitions
	 * @param end the upper bound of the range of fact acquisitions (not inclusive)
	 * @return the range of matching fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactAcquisition> findByPTJ(long facultyId, int start, int end)
		throws SystemException {
		return findByPTJ(facultyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact acquisitions where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of fact acquisitions
	 * @param end the upper bound of the range of fact acquisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactAcquisition> findByPTJ(long facultyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PTJ;
			finderArgs = new Object[] { facultyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PTJ;
			finderArgs = new Object[] { facultyId, start, end, orderByComparator };
		}

		List<FactAcquisition> list = (List<FactAcquisition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FactAcquisition factAcquisition : list) {
				if ((facultyId != factAcquisition.getFacultyId())) {
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

			query.append(_SQL_SELECT_FACTACQUISITION_WHERE);

			query.append(_FINDER_COLUMN_PTJ_FACULTYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FactAcquisitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facultyId);

				if (!pagination) {
					list = (List<FactAcquisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactAcquisition>(list);
				}
				else {
					list = (List<FactAcquisition>)QueryUtil.list(q,
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
	 * Returns the first fact acquisition in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact acquisition
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a matching fact acquisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition findByPTJ_First(long facultyId,
		OrderByComparator orderByComparator)
		throws NoSuchFactAcquisitionException, SystemException {
		FactAcquisition factAcquisition = fetchByPTJ_First(facultyId,
				orderByComparator);

		if (factAcquisition != null) {
			return factAcquisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facultyId=");
		msg.append(facultyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactAcquisitionException(msg.toString());
	}

	/**
	 * Returns the first fact acquisition in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fact acquisition, or <code>null</code> if a matching fact acquisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition fetchByPTJ_First(long facultyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FactAcquisition> list = findByPTJ(facultyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fact acquisition in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact acquisition
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a matching fact acquisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition findByPTJ_Last(long facultyId,
		OrderByComparator orderByComparator)
		throws NoSuchFactAcquisitionException, SystemException {
		FactAcquisition factAcquisition = fetchByPTJ_Last(facultyId,
				orderByComparator);

		if (factAcquisition != null) {
			return factAcquisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("facultyId=");
		msg.append(facultyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFactAcquisitionException(msg.toString());
	}

	/**
	 * Returns the last fact acquisition in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fact acquisition, or <code>null</code> if a matching fact acquisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition fetchByPTJ_Last(long facultyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPTJ(facultyId);

		if (count == 0) {
			return null;
		}

		List<FactAcquisition> list = findByPTJ(facultyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fact acquisitions before and after the current fact acquisition in the ordered set where facultyId = &#63;.
	 *
	 * @param factAcquisitionId the primary key of the current fact acquisition
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fact acquisition
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition[] findByPTJ_PrevAndNext(long factAcquisitionId,
		long facultyId, OrderByComparator orderByComparator)
		throws NoSuchFactAcquisitionException, SystemException {
		FactAcquisition factAcquisition = findByPrimaryKey(factAcquisitionId);

		Session session = null;

		try {
			session = openSession();

			FactAcquisition[] array = new FactAcquisitionImpl[3];

			array[0] = getByPTJ_PrevAndNext(session, factAcquisition,
					facultyId, orderByComparator, true);

			array[1] = factAcquisition;

			array[2] = getByPTJ_PrevAndNext(session, factAcquisition,
					facultyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FactAcquisition getByPTJ_PrevAndNext(Session session,
		FactAcquisition factAcquisition, long facultyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FACTACQUISITION_WHERE);

		query.append(_FINDER_COLUMN_PTJ_FACULTYID_2);

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
			query.append(FactAcquisitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(facultyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(factAcquisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FactAcquisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fact acquisitions where facultyId = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPTJ(long facultyId) throws SystemException {
		for (FactAcquisition factAcquisition : findByPTJ(facultyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(factAcquisition);
		}
	}

	/**
	 * Returns the number of fact acquisitions where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the number of matching fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPTJ(long facultyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PTJ;

		Object[] finderArgs = new Object[] { facultyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FACTACQUISITION_WHERE);

			query.append(_FINDER_COLUMN_PTJ_FACULTYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(facultyId);

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

	private static final String _FINDER_COLUMN_PTJ_FACULTYID_2 = "factAcquisition.facultyId = ?";

	public FactAcquisitionPersistenceImpl() {
		setModelClass(FactAcquisition.class);
	}

	/**
	 * Caches the fact acquisition in the entity cache if it is enabled.
	 *
	 * @param factAcquisition the fact acquisition
	 */
	@Override
	public void cacheResult(FactAcquisition factAcquisition) {
		EntityCacheUtil.putResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionImpl.class, factAcquisition.getPrimaryKey(),
			factAcquisition);

		factAcquisition.resetOriginalValues();
	}

	/**
	 * Caches the fact acquisitions in the entity cache if it is enabled.
	 *
	 * @param factAcquisitions the fact acquisitions
	 */
	@Override
	public void cacheResult(List<FactAcquisition> factAcquisitions) {
		for (FactAcquisition factAcquisition : factAcquisitions) {
			if (EntityCacheUtil.getResult(
						FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
						FactAcquisitionImpl.class,
						factAcquisition.getPrimaryKey()) == null) {
				cacheResult(factAcquisition);
			}
			else {
				factAcquisition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fact acquisitions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FactAcquisitionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FactAcquisitionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fact acquisition.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FactAcquisition factAcquisition) {
		EntityCacheUtil.removeResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionImpl.class, factAcquisition.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FactAcquisition> factAcquisitions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FactAcquisition factAcquisition : factAcquisitions) {
			EntityCacheUtil.removeResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
				FactAcquisitionImpl.class, factAcquisition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fact acquisition with the primary key. Does not add the fact acquisition to the database.
	 *
	 * @param factAcquisitionId the primary key for the new fact acquisition
	 * @return the new fact acquisition
	 */
	@Override
	public FactAcquisition create(long factAcquisitionId) {
		FactAcquisition factAcquisition = new FactAcquisitionImpl();

		factAcquisition.setNew(true);
		factAcquisition.setPrimaryKey(factAcquisitionId);

		return factAcquisition;
	}

	/**
	 * Removes the fact acquisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param factAcquisitionId the primary key of the fact acquisition
	 * @return the fact acquisition that was removed
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition remove(long factAcquisitionId)
		throws NoSuchFactAcquisitionException, SystemException {
		return remove((Serializable)factAcquisitionId);
	}

	/**
	 * Removes the fact acquisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fact acquisition
	 * @return the fact acquisition that was removed
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition remove(Serializable primaryKey)
		throws NoSuchFactAcquisitionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FactAcquisition factAcquisition = (FactAcquisition)session.get(FactAcquisitionImpl.class,
					primaryKey);

			if (factAcquisition == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFactAcquisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(factAcquisition);
		}
		catch (NoSuchFactAcquisitionException nsee) {
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
	protected FactAcquisition removeImpl(FactAcquisition factAcquisition)
		throws SystemException {
		factAcquisition = toUnwrappedModel(factAcquisition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(factAcquisition)) {
				factAcquisition = (FactAcquisition)session.get(FactAcquisitionImpl.class,
						factAcquisition.getPrimaryKeyObj());
			}

			if (factAcquisition != null) {
				session.delete(factAcquisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (factAcquisition != null) {
			clearCache(factAcquisition);
		}

		return factAcquisition;
	}

	@Override
	public FactAcquisition updateImpl(
		com.idetronic.eis.model.FactAcquisition factAcquisition)
		throws SystemException {
		factAcquisition = toUnwrappedModel(factAcquisition);

		boolean isNew = factAcquisition.isNew();

		FactAcquisitionModelImpl factAcquisitionModelImpl = (FactAcquisitionModelImpl)factAcquisition;

		Session session = null;

		try {
			session = openSession();

			if (factAcquisition.isNew()) {
				session.save(factAcquisition);

				factAcquisition.setNew(false);
			}
			else {
				session.merge(factAcquisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FactAcquisitionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((factAcquisitionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PTJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						factAcquisitionModelImpl.getOriginalFacultyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PTJ, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PTJ,
					args);

				args = new Object[] { factAcquisitionModelImpl.getFacultyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PTJ, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PTJ,
					args);
			}
		}

		EntityCacheUtil.putResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
			FactAcquisitionImpl.class, factAcquisition.getPrimaryKey(),
			factAcquisition);

		return factAcquisition;
	}

	protected FactAcquisition toUnwrappedModel(FactAcquisition factAcquisition) {
		if (factAcquisition instanceof FactAcquisitionImpl) {
			return factAcquisition;
		}

		FactAcquisitionImpl factAcquisitionImpl = new FactAcquisitionImpl();

		factAcquisitionImpl.setNew(factAcquisition.isNew());
		factAcquisitionImpl.setPrimaryKey(factAcquisition.getPrimaryKey());

		factAcquisitionImpl.setFactAcquisitionId(factAcquisition.getFactAcquisitionId());
		factAcquisitionImpl.setLibraryId(factAcquisition.getLibraryId());
		factAcquisitionImpl.setFacultyId(factAcquisition.getFacultyId());
		factAcquisitionImpl.setPeriod(factAcquisition.getPeriod());
		factAcquisitionImpl.setItemId(factAcquisition.getItemId());
		factAcquisitionImpl.setApprovedTitleTotal(factAcquisition.getApprovedTitleTotal());
		factAcquisitionImpl.setApprovedVolumeTotal(factAcquisition.getApprovedVolumeTotal());
		factAcquisitionImpl.setApprovedAmountTotal(factAcquisition.getApprovedAmountTotal());
		factAcquisitionImpl.setOrderTitleTotal(factAcquisition.getOrderTitleTotal());
		factAcquisitionImpl.setOrderVolumeTotal(factAcquisition.getOrderVolumeTotal());
		factAcquisitionImpl.setOrderAmountTotal(factAcquisition.getOrderAmountTotal());
		factAcquisitionImpl.setVolumeTotal(factAcquisition.getVolumeTotal());
		factAcquisitionImpl.setTitleTotal(factAcquisition.getTitleTotal());
		factAcquisitionImpl.setAmountTotal(factAcquisition.getAmountTotal());
		factAcquisitionImpl.setCompanyId(factAcquisition.getCompanyId());
		factAcquisitionImpl.setGroupId(factAcquisition.getGroupId());
		factAcquisitionImpl.setUserId(factAcquisition.getUserId());
		factAcquisitionImpl.setUserName(factAcquisition.getUserName());
		factAcquisitionImpl.setCreateDate(factAcquisition.getCreateDate());

		return factAcquisitionImpl;
	}

	/**
	 * Returns the fact acquisition with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact acquisition
	 * @return the fact acquisition
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFactAcquisitionException, SystemException {
		FactAcquisition factAcquisition = fetchByPrimaryKey(primaryKey);

		if (factAcquisition == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFactAcquisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return factAcquisition;
	}

	/**
	 * Returns the fact acquisition with the primary key or throws a {@link com.idetronic.eis.NoSuchFactAcquisitionException} if it could not be found.
	 *
	 * @param factAcquisitionId the primary key of the fact acquisition
	 * @return the fact acquisition
	 * @throws com.idetronic.eis.NoSuchFactAcquisitionException if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition findByPrimaryKey(long factAcquisitionId)
		throws NoSuchFactAcquisitionException, SystemException {
		return findByPrimaryKey((Serializable)factAcquisitionId);
	}

	/**
	 * Returns the fact acquisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fact acquisition
	 * @return the fact acquisition, or <code>null</code> if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FactAcquisition factAcquisition = (FactAcquisition)EntityCacheUtil.getResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
				FactAcquisitionImpl.class, primaryKey);

		if (factAcquisition == _nullFactAcquisition) {
			return null;
		}

		if (factAcquisition == null) {
			Session session = null;

			try {
				session = openSession();

				factAcquisition = (FactAcquisition)session.get(FactAcquisitionImpl.class,
						primaryKey);

				if (factAcquisition != null) {
					cacheResult(factAcquisition);
				}
				else {
					EntityCacheUtil.putResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
						FactAcquisitionImpl.class, primaryKey,
						_nullFactAcquisition);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FactAcquisitionModelImpl.ENTITY_CACHE_ENABLED,
					FactAcquisitionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return factAcquisition;
	}

	/**
	 * Returns the fact acquisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param factAcquisitionId the primary key of the fact acquisition
	 * @return the fact acquisition, or <code>null</code> if a fact acquisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FactAcquisition fetchByPrimaryKey(long factAcquisitionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)factAcquisitionId);
	}

	/**
	 * Returns all the fact acquisitions.
	 *
	 * @return the fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactAcquisition> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fact acquisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact acquisitions
	 * @param end the upper bound of the range of fact acquisitions (not inclusive)
	 * @return the range of fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactAcquisition> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fact acquisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactAcquisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fact acquisitions
	 * @param end the upper bound of the range of fact acquisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fact acquisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FactAcquisition> findAll(int start, int end,
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

		List<FactAcquisition> list = (List<FactAcquisition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FACTACQUISITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FACTACQUISITION;

				if (pagination) {
					sql = sql.concat(FactAcquisitionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FactAcquisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FactAcquisition>(list);
				}
				else {
					list = (List<FactAcquisition>)QueryUtil.list(q,
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
	 * Removes all the fact acquisitions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FactAcquisition factAcquisition : findAll()) {
			remove(factAcquisition);
		}
	}

	/**
	 * Returns the number of fact acquisitions.
	 *
	 * @return the number of fact acquisitions
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

				Query q = session.createQuery(_SQL_COUNT_FACTACQUISITION);

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
	 * Initializes the fact acquisition persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.FactAcquisition")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FactAcquisition>> listenersList = new ArrayList<ModelListener<FactAcquisition>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FactAcquisition>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FactAcquisitionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FACTACQUISITION = "SELECT factAcquisition FROM FactAcquisition factAcquisition";
	private static final String _SQL_SELECT_FACTACQUISITION_WHERE = "SELECT factAcquisition FROM FactAcquisition factAcquisition WHERE ";
	private static final String _SQL_COUNT_FACTACQUISITION = "SELECT COUNT(factAcquisition) FROM FactAcquisition factAcquisition";
	private static final String _SQL_COUNT_FACTACQUISITION_WHERE = "SELECT COUNT(factAcquisition) FROM FactAcquisition factAcquisition WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "factAcquisition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FactAcquisition exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FactAcquisition exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FactAcquisitionPersistenceImpl.class);
	private static FactAcquisition _nullFactAcquisition = new FactAcquisitionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FactAcquisition> toCacheModel() {
				return _nullFactAcquisitionCacheModel;
			}
		};

	private static CacheModel<FactAcquisition> _nullFactAcquisitionCacheModel = new CacheModel<FactAcquisition>() {
			@Override
			public FactAcquisition toEntityModel() {
				return _nullFactAcquisition;
			}
		};
}
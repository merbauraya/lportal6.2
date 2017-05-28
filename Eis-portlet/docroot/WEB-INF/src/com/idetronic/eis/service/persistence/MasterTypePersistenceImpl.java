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

import com.idetronic.eis.NoSuchMasterTypeException;
import com.idetronic.eis.model.MasterType;
import com.idetronic.eis.model.impl.MasterTypeImpl;
import com.idetronic.eis.model.impl.MasterTypeModelImpl;

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
 * The persistence implementation for the master type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterTypePersistence
 * @see MasterTypeUtil
 * @generated
 */
public class MasterTypePersistenceImpl extends BasePersistenceImpl<MasterType>
	implements MasterTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MasterTypeUtil} to access the master type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MasterTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeModelImpl.FINDER_CACHE_ENABLED, MasterTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeModelImpl.FINDER_CACHE_ENABLED, MasterTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTYPE =
		new FinderPath(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeModelImpl.FINDER_CACHE_ENABLED, MasterTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentType",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTYPE =
		new FinderPath(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeModelImpl.FINDER_CACHE_ENABLED, MasterTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentType",
			new String[] { Boolean.class.getName() },
			MasterTypeModelImpl.PARENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTYPE = new FinderPath(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentType",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the master types where parentType = &#63;.
	 *
	 * @param parentType the parent type
	 * @return the matching master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterType> findByParentType(boolean parentType)
		throws SystemException {
		return findByParentType(parentType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master types where parentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentType the parent type
	 * @param start the lower bound of the range of master types
	 * @param end the upper bound of the range of master types (not inclusive)
	 * @return the range of matching master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterType> findByParentType(boolean parentType, int start,
		int end) throws SystemException {
		return findByParentType(parentType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master types where parentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentType the parent type
	 * @param start the lower bound of the range of master types
	 * @param end the upper bound of the range of master types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterType> findByParentType(boolean parentType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTYPE;
			finderArgs = new Object[] { parentType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTYPE;
			finderArgs = new Object[] { parentType, start, end, orderByComparator };
		}

		List<MasterType> list = (List<MasterType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterType masterType : list) {
				if ((parentType != masterType.getParentType())) {
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

			query.append(_SQL_SELECT_MASTERTYPE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTYPE_PARENTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentType);

				if (!pagination) {
					list = (List<MasterType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterType>(list);
				}
				else {
					list = (List<MasterType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master type in the ordered set where parentType = &#63;.
	 *
	 * @param parentType the parent type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master type
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a matching master type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType findByParentType_First(boolean parentType,
		OrderByComparator orderByComparator)
		throws NoSuchMasterTypeException, SystemException {
		MasterType masterType = fetchByParentType_First(parentType,
				orderByComparator);

		if (masterType != null) {
			return masterType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentType=");
		msg.append(parentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterTypeException(msg.toString());
	}

	/**
	 * Returns the first master type in the ordered set where parentType = &#63;.
	 *
	 * @param parentType the parent type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master type, or <code>null</code> if a matching master type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType fetchByParentType_First(boolean parentType,
		OrderByComparator orderByComparator) throws SystemException {
		List<MasterType> list = findByParentType(parentType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master type in the ordered set where parentType = &#63;.
	 *
	 * @param parentType the parent type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master type
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a matching master type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType findByParentType_Last(boolean parentType,
		OrderByComparator orderByComparator)
		throws NoSuchMasterTypeException, SystemException {
		MasterType masterType = fetchByParentType_Last(parentType,
				orderByComparator);

		if (masterType != null) {
			return masterType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentType=");
		msg.append(parentType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterTypeException(msg.toString());
	}

	/**
	 * Returns the last master type in the ordered set where parentType = &#63;.
	 *
	 * @param parentType the parent type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master type, or <code>null</code> if a matching master type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType fetchByParentType_Last(boolean parentType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentType(parentType);

		if (count == 0) {
			return null;
		}

		List<MasterType> list = findByParentType(parentType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master types before and after the current master type in the ordered set where parentType = &#63;.
	 *
	 * @param masterTypeId the primary key of the current master type
	 * @param parentType the parent type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master type
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType[] findByParentType_PrevAndNext(long masterTypeId,
		boolean parentType, OrderByComparator orderByComparator)
		throws NoSuchMasterTypeException, SystemException {
		MasterType masterType = findByPrimaryKey(masterTypeId);

		Session session = null;

		try {
			session = openSession();

			MasterType[] array = new MasterTypeImpl[3];

			array[0] = getByParentType_PrevAndNext(session, masterType,
					parentType, orderByComparator, true);

			array[1] = masterType;

			array[2] = getByParentType_PrevAndNext(session, masterType,
					parentType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterType getByParentType_PrevAndNext(Session session,
		MasterType masterType, boolean parentType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERTYPE_WHERE);

		query.append(_FINDER_COLUMN_PARENTTYPE_PARENTTYPE_2);

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
			query.append(MasterTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master types where parentType = &#63; from the database.
	 *
	 * @param parentType the parent type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentType(boolean parentType)
		throws SystemException {
		for (MasterType masterType : findByParentType(parentType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterType);
		}
	}

	/**
	 * Returns the number of master types where parentType = &#63;.
	 *
	 * @param parentType the parent type
	 * @return the number of matching master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentType(boolean parentType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTTYPE;

		Object[] finderArgs = new Object[] { parentType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MASTERTYPE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTYPE_PARENTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentType);

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

	private static final String _FINDER_COLUMN_PARENTTYPE_PARENTTYPE_2 = "masterType.parentType = ?";

	public MasterTypePersistenceImpl() {
		setModelClass(MasterType.class);
	}

	/**
	 * Caches the master type in the entity cache if it is enabled.
	 *
	 * @param masterType the master type
	 */
	@Override
	public void cacheResult(MasterType masterType) {
		EntityCacheUtil.putResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeImpl.class, masterType.getPrimaryKey(), masterType);

		masterType.resetOriginalValues();
	}

	/**
	 * Caches the master types in the entity cache if it is enabled.
	 *
	 * @param masterTypes the master types
	 */
	@Override
	public void cacheResult(List<MasterType> masterTypes) {
		for (MasterType masterType : masterTypes) {
			if (EntityCacheUtil.getResult(
						MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
						MasterTypeImpl.class, masterType.getPrimaryKey()) == null) {
				cacheResult(masterType);
			}
			else {
				masterType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all master types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MasterTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MasterTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterType masterType) {
		EntityCacheUtil.removeResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeImpl.class, masterType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MasterType> masterTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MasterType masterType : masterTypes) {
			EntityCacheUtil.removeResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
				MasterTypeImpl.class, masterType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new master type with the primary key. Does not add the master type to the database.
	 *
	 * @param masterTypeId the primary key for the new master type
	 * @return the new master type
	 */
	@Override
	public MasterType create(long masterTypeId) {
		MasterType masterType = new MasterTypeImpl();

		masterType.setNew(true);
		masterType.setPrimaryKey(masterTypeId);

		return masterType;
	}

	/**
	 * Removes the master type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterTypeId the primary key of the master type
	 * @return the master type that was removed
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType remove(long masterTypeId)
		throws NoSuchMasterTypeException, SystemException {
		return remove((Serializable)masterTypeId);
	}

	/**
	 * Removes the master type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master type
	 * @return the master type that was removed
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType remove(Serializable primaryKey)
		throws NoSuchMasterTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MasterType masterType = (MasterType)session.get(MasterTypeImpl.class,
					primaryKey);

			if (masterType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(masterType);
		}
		catch (NoSuchMasterTypeException nsee) {
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
	protected MasterType removeImpl(MasterType masterType)
		throws SystemException {
		masterType = toUnwrappedModel(masterType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterType)) {
				masterType = (MasterType)session.get(MasterTypeImpl.class,
						masterType.getPrimaryKeyObj());
			}

			if (masterType != null) {
				session.delete(masterType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (masterType != null) {
			clearCache(masterType);
		}

		return masterType;
	}

	@Override
	public MasterType updateImpl(com.idetronic.eis.model.MasterType masterType)
		throws SystemException {
		masterType = toUnwrappedModel(masterType);

		boolean isNew = masterType.isNew();

		MasterTypeModelImpl masterTypeModelImpl = (MasterTypeModelImpl)masterType;

		Session session = null;

		try {
			session = openSession();

			if (masterType.isNew()) {
				session.save(masterType);

				masterType.setNew(false);
			}
			else {
				session.merge(masterType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MasterTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((masterTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterTypeModelImpl.getOriginalParentType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTYPE,
					args);

				args = new Object[] { masterTypeModelImpl.getParentType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
			MasterTypeImpl.class, masterType.getPrimaryKey(), masterType);

		return masterType;
	}

	protected MasterType toUnwrappedModel(MasterType masterType) {
		if (masterType instanceof MasterTypeImpl) {
			return masterType;
		}

		MasterTypeImpl masterTypeImpl = new MasterTypeImpl();

		masterTypeImpl.setNew(masterType.isNew());
		masterTypeImpl.setPrimaryKey(masterType.getPrimaryKey());

		masterTypeImpl.setMasterTypeId(masterType.getMasterTypeId());
		masterTypeImpl.setMasterTypeName(masterType.getMasterTypeName());
		masterTypeImpl.setStatus(masterType.getStatus());
		masterTypeImpl.setParentType(masterType.isParentType());
		masterTypeImpl.setPageLabel(masterType.getPageLabel());
		masterTypeImpl.setNameLabel(masterType.getNameLabel());
		masterTypeImpl.setHasParent1(masterType.isHasParent1());
		masterTypeImpl.setParentId1(masterType.getParentId1());
		masterTypeImpl.setParentId2(masterType.getParentId2());
		masterTypeImpl.setHasParent2(masterType.isHasParent2());
		masterTypeImpl.setParent1Label(masterType.getParent1Label());
		masterTypeImpl.setParent2Label(masterType.getParent2Label());
		masterTypeImpl.setHasStatus1(masterType.isHasStatus1());
		masterTypeImpl.setHasStatus2(masterType.isHasStatus2());
		masterTypeImpl.setHasStatus3(masterType.isHasStatus3());
		masterTypeImpl.setHasStatus4(masterType.isHasStatus4());
		masterTypeImpl.setHasStatus5(masterType.isHasStatus5());
		masterTypeImpl.setStatus1Label(masterType.getStatus1Label());
		masterTypeImpl.setStatus2Label(masterType.getStatus2Label());
		masterTypeImpl.setStatus3Label(masterType.getStatus3Label());
		masterTypeImpl.setStatus4Label(masterType.getStatus4Label());
		masterTypeImpl.setStatus5Label(masterType.getStatus5Label());
		masterTypeImpl.setHasCode(masterType.isHasCode());
		masterTypeImpl.setCodeLabel(masterType.getCodeLabel());

		return masterTypeImpl;
	}

	/**
	 * Returns the master type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the master type
	 * @return the master type
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterTypeException, SystemException {
		MasterType masterType = fetchByPrimaryKey(primaryKey);

		if (masterType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return masterType;
	}

	/**
	 * Returns the master type with the primary key or throws a {@link com.idetronic.eis.NoSuchMasterTypeException} if it could not be found.
	 *
	 * @param masterTypeId the primary key of the master type
	 * @return the master type
	 * @throws com.idetronic.eis.NoSuchMasterTypeException if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType findByPrimaryKey(long masterTypeId)
		throws NoSuchMasterTypeException, SystemException {
		return findByPrimaryKey((Serializable)masterTypeId);
	}

	/**
	 * Returns the master type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master type
	 * @return the master type, or <code>null</code> if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MasterType masterType = (MasterType)EntityCacheUtil.getResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
				MasterTypeImpl.class, primaryKey);

		if (masterType == _nullMasterType) {
			return null;
		}

		if (masterType == null) {
			Session session = null;

			try {
				session = openSession();

				masterType = (MasterType)session.get(MasterTypeImpl.class,
						primaryKey);

				if (masterType != null) {
					cacheResult(masterType);
				}
				else {
					EntityCacheUtil.putResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
						MasterTypeImpl.class, primaryKey, _nullMasterType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MasterTypeModelImpl.ENTITY_CACHE_ENABLED,
					MasterTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return masterType;
	}

	/**
	 * Returns the master type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterTypeId the primary key of the master type
	 * @return the master type, or <code>null</code> if a master type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterType fetchByPrimaryKey(long masterTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)masterTypeId);
	}

	/**
	 * Returns all the master types.
	 *
	 * @return the master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master types
	 * @param end the upper bound of the range of master types (not inclusive)
	 * @return the range of master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master types
	 * @param end the upper bound of the range of master types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterType> findAll(int start, int end,
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

		List<MasterType> list = (List<MasterType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MASTERTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERTYPE;

				if (pagination) {
					sql = sql.concat(MasterTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MasterType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterType>(list);
				}
				else {
					list = (List<MasterType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the master types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MasterType masterType : findAll()) {
			remove(masterType);
		}
	}

	/**
	 * Returns the number of master types.
	 *
	 * @return the number of master types
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

				Query q = session.createQuery(_SQL_COUNT_MASTERTYPE);

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
	 * Initializes the master type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.MasterType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MasterType>> listenersList = new ArrayList<ModelListener<MasterType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MasterType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MasterTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MASTERTYPE = "SELECT masterType FROM MasterType masterType";
	private static final String _SQL_SELECT_MASTERTYPE_WHERE = "SELECT masterType FROM MasterType masterType WHERE ";
	private static final String _SQL_COUNT_MASTERTYPE = "SELECT COUNT(masterType) FROM MasterType masterType";
	private static final String _SQL_COUNT_MASTERTYPE_WHERE = "SELECT COUNT(masterType) FROM MasterType masterType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "masterType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MasterType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MasterType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MasterTypePersistenceImpl.class);
	private static MasterType _nullMasterType = new MasterTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MasterType> toCacheModel() {
				return _nullMasterTypeCacheModel;
			}
		};

	private static CacheModel<MasterType> _nullMasterTypeCacheModel = new CacheModel<MasterType>() {
			@Override
			public MasterType toEntityModel() {
				return _nullMasterType;
			}
		};
}
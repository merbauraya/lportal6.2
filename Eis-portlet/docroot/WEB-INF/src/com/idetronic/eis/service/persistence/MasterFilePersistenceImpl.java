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

import com.idetronic.eis.NoSuchMasterFileException;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.model.impl.MasterFileImpl;
import com.idetronic.eis.model.impl.MasterFileModelImpl;

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
 * The persistence implementation for the master file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterFilePersistence
 * @see MasterFileUtil
 * @generated
 */
public class MasterFilePersistenceImpl extends BasePersistenceImpl<MasterFile>
	implements MasterFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MasterFileUtil} to access the master file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MasterFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPE =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMasterType",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPE =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMasterType",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.INACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPE = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMasterType",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterType(long masterTypeId, boolean inActive)
		throws SystemException {
		return findByMasterType(masterTypeId, inActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterType(long masterTypeId,
		boolean inActive, int start, int end) throws SystemException {
		return findByMasterType(masterTypeId, inActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterType(long masterTypeId,
		boolean inActive, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPE;
			finderArgs = new Object[] { masterTypeId, inActive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPE;
			finderArgs = new Object[] {
					masterTypeId, inActive,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(inActive != masterFile.getInActive())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPE_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPE_INACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(inActive);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterType_First(long masterTypeId,
		boolean inActive, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterType_First(masterTypeId, inActive,
				orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", inActive=");
		msg.append(inActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterType_First(long masterTypeId,
		boolean inActive, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByMasterType(masterTypeId, inActive, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterType_Last(long masterTypeId,
		boolean inActive, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterType_Last(masterTypeId, inActive,
				orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", inActive=");
		msg.append(inActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterType_Last(long masterTypeId,
		boolean inActive, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMasterType(masterTypeId, inActive);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterType(masterTypeId, inActive,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterType_PrevAndNext(long masterFileId,
		long masterTypeId, boolean inActive, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterType_PrevAndNext(session, masterFile,
					masterTypeId, inActive, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterType_PrevAndNext(session, masterFile,
					masterTypeId, inActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterType_PrevAndNext(Session session,
		MasterFile masterFile, long masterTypeId, boolean inActive,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPE_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPE_INACTIVE_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(inActive);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and inActive = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterType(long masterTypeId, boolean inActive)
		throws SystemException {
		for (MasterFile masterFile : findByMasterType(masterTypeId, inActive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and inActive = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param inActive the in active
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterType(long masterTypeId, boolean inActive)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPE;

		Object[] finderArgs = new Object[] { masterTypeId, inActive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPE_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPE_INACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(inActive);

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

	private static final String _FINDER_COLUMN_MASTERTYPE_MASTERTYPEID_2 = "masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPE_INACTIVE_2 = "masterFile.inActive = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDPARENT1 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypeAndParent1",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT1 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeAndParent1",
			new String[] { Long.class.getName(), Long.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.PARENTID1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDPARENT1 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndParent1",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByTypeAndParent1(long masterTypeId,
		long parentId1) throws SystemException {
		return findByTypeAndParent1(masterTypeId, parentId1, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByTypeAndParent1(long masterTypeId,
		long parentId1, int start, int end) throws SystemException {
		return findByTypeAndParent1(masterTypeId, parentId1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByTypeAndParent1(long masterTypeId,
		long parentId1, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT1;
			finderArgs = new Object[] { masterTypeId, parentId1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDPARENT1;
			finderArgs = new Object[] {
					masterTypeId, parentId1,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(parentId1 != masterFile.getParentId1())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDPARENT1_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDPARENT1_PARENTID1_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(parentId1);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByTypeAndParent1_First(long masterTypeId,
		long parentId1, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByTypeAndParent1_First(masterTypeId,
				parentId1, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", parentId1=");
		msg.append(parentId1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByTypeAndParent1_First(long masterTypeId,
		long parentId1, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByTypeAndParent1(masterTypeId, parentId1,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByTypeAndParent1_Last(long masterTypeId,
		long parentId1, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByTypeAndParent1_Last(masterTypeId,
				parentId1, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", parentId1=");
		msg.append(parentId1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByTypeAndParent1_Last(long masterTypeId,
		long parentId1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeAndParent1(masterTypeId, parentId1);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByTypeAndParent1(masterTypeId, parentId1,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByTypeAndParent1_PrevAndNext(long masterFileId,
		long masterTypeId, long parentId1, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByTypeAndParent1_PrevAndNext(session, masterFile,
					masterTypeId, parentId1, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByTypeAndParent1_PrevAndNext(session, masterFile,
					masterTypeId, parentId1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByTypeAndParent1_PrevAndNext(Session session,
		MasterFile masterFile, long masterTypeId, long parentId1,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDPARENT1_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDPARENT1_PARENTID1_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(parentId1);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and parentId1 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeAndParent1(long masterTypeId, long parentId1)
		throws SystemException {
		for (MasterFile masterFile : findByTypeAndParent1(masterTypeId,
				parentId1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and parentId1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId1 the parent id1
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeAndParent1(long masterTypeId, long parentId1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEANDPARENT1;

		Object[] finderArgs = new Object[] { masterTypeId, parentId1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDPARENT1_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDPARENT1_PARENTID1_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(parentId1);

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

	private static final String _FINDER_COLUMN_TYPEANDPARENT1_MASTERTYPEID_2 = "masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDPARENT1_PARENTID1_2 = "masterFile.parentId1 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDPARENT2 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTypeAndParent2",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT2 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTypeAndParent2",
			new String[] { Long.class.getName(), Long.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.PARENTID2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEANDPARENT2 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeAndParent2",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByTypeAndParent2(long masterTypeId,
		long parentId2) throws SystemException {
		return findByTypeAndParent2(masterTypeId, parentId2, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByTypeAndParent2(long masterTypeId,
		long parentId2, int start, int end) throws SystemException {
		return findByTypeAndParent2(masterTypeId, parentId2, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByTypeAndParent2(long masterTypeId,
		long parentId2, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT2;
			finderArgs = new Object[] { masterTypeId, parentId2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEANDPARENT2;
			finderArgs = new Object[] {
					masterTypeId, parentId2,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(parentId2 != masterFile.getParentId2())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDPARENT2_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDPARENT2_PARENTID2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(parentId2);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByTypeAndParent2_First(long masterTypeId,
		long parentId2, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByTypeAndParent2_First(masterTypeId,
				parentId2, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", parentId2=");
		msg.append(parentId2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByTypeAndParent2_First(long masterTypeId,
		long parentId2, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByTypeAndParent2(masterTypeId, parentId2,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByTypeAndParent2_Last(long masterTypeId,
		long parentId2, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByTypeAndParent2_Last(masterTypeId,
				parentId2, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", parentId2=");
		msg.append(parentId2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByTypeAndParent2_Last(long masterTypeId,
		long parentId2, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypeAndParent2(masterTypeId, parentId2);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByTypeAndParent2(masterTypeId, parentId2,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByTypeAndParent2_PrevAndNext(long masterFileId,
		long masterTypeId, long parentId2, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByTypeAndParent2_PrevAndNext(session, masterFile,
					masterTypeId, parentId2, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByTypeAndParent2_PrevAndNext(session, masterFile,
					masterTypeId, parentId2, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByTypeAndParent2_PrevAndNext(Session session,
		MasterFile masterFile, long masterTypeId, long parentId2,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_TYPEANDPARENT2_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_TYPEANDPARENT2_PARENTID2_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(parentId2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and parentId2 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeAndParent2(long masterTypeId, long parentId2)
		throws SystemException {
		for (MasterFile masterFile : findByTypeAndParent2(masterTypeId,
				parentId2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and parentId2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param parentId2 the parent id2
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeAndParent2(long masterTypeId, long parentId2)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEANDPARENT2;

		Object[] finderArgs = new Object[] { masterTypeId, parentId2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_TYPEANDPARENT2_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_TYPEANDPARENT2_PARENTID2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(parentId2);

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

	private static final String _FINDER_COLUMN_TYPEANDPARENT2_MASTERTYPEID_2 = "masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_TYPEANDPARENT2_PARENTID2_2 = "masterFile.parentId2 = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMasterTypeAndName",
			new String[] { Long.class.getName(), String.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.MASTERFILENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDNAME = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	 *
	 * @param masterTypeId the master type ID
	 * @param masterFileName the master file name
	 * @return the matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndName(long masterTypeId,
		String masterFileName)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndName(masterTypeId,
				masterFileName);

		if (masterFile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("masterTypeId=");
			msg.append(masterTypeId);

			msg.append(", masterFileName=");
			msg.append(masterFileName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMasterFileException(msg.toString());
		}

		return masterFile;
	}

	/**
	 * Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param masterTypeId the master type ID
	 * @param masterFileName the master file name
	 * @return the matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndName(long masterTypeId,
		String masterFileName) throws SystemException {
		return fetchByMasterTypeAndName(masterTypeId, masterFileName, true);
	}

	/**
	 * Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param masterTypeId the master type ID
	 * @param masterFileName the master file name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndName(long masterTypeId,
		String masterFileName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { masterTypeId, masterFileName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
					finderArgs, this);
		}

		if (result instanceof MasterFile) {
			MasterFile masterFile = (MasterFile)result;

			if ((masterTypeId != masterFile.getMasterTypeId()) ||
					!Validator.equals(masterFileName,
						masterFile.getMasterFileName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERTYPEID_2);

			boolean bindMasterFileName = false;

			if (masterFileName == null) {
				query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_1);
			}
			else if (masterFileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_3);
			}
			else {
				bindMasterFileName = true;

				query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				if (bindMasterFileName) {
					qPos.add(masterFileName);
				}

				List<MasterFile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MasterFilePersistenceImpl.fetchByMasterTypeAndName(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					MasterFile masterFile = list.get(0);

					result = masterFile;

					cacheResult(masterFile);

					if ((masterFile.getMasterTypeId() != masterTypeId) ||
							(masterFile.getMasterFileName() == null) ||
							!masterFile.getMasterFileName()
										   .equals(masterFileName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
							finderArgs, masterFile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MasterFile)result;
		}
	}

	/**
	 * Removes the master file where masterTypeId = &#63; and masterFileName = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param masterFileName the master file name
	 * @return the master file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile removeByMasterTypeAndName(long masterTypeId,
		String masterFileName)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByMasterTypeAndName(masterTypeId,
				masterFileName);

		return remove(masterFile);
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and masterFileName = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param masterFileName the master file name
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndName(long masterTypeId, String masterFileName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDNAME;

		Object[] finderArgs = new Object[] { masterTypeId, masterFileName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERTYPEID_2);

			boolean bindMasterFileName = false;

			if (masterFileName == null) {
				query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_1);
			}
			else if (masterFileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_3);
			}
			else {
				bindMasterFileName = true;

				query.append(_FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				if (bindMasterFileName) {
					qPos.add(masterFileName);
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

	private static final String _FINDER_COLUMN_MASTERTYPEANDNAME_MASTERTYPEID_2 = "masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_1 =
		"masterFile.masterFileName IS NULL";
	private static final String _FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_2 =
		"masterFile.masterFileName = ?";
	private static final String _FINDER_COLUMN_MASTERTYPEANDNAME_MASTERFILENAME_3 =
		"(masterFile.masterFileName IS NULL OR masterFile.masterFileName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_OLDID = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByOldId",
			new String[] { Long.class.getName(), Long.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.OLDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OLDID = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOldId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the master file where masterTypeId = &#63; and oldId = &#63; or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	 *
	 * @param masterTypeId the master type ID
	 * @param oldId the old ID
	 * @return the matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByOldId(long masterTypeId, long oldId)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByOldId(masterTypeId, oldId);

		if (masterFile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("masterTypeId=");
			msg.append(masterTypeId);

			msg.append(", oldId=");
			msg.append(oldId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMasterFileException(msg.toString());
		}

		return masterFile;
	}

	/**
	 * Returns the master file where masterTypeId = &#63; and oldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param masterTypeId the master type ID
	 * @param oldId the old ID
	 * @return the matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByOldId(long masterTypeId, long oldId)
		throws SystemException {
		return fetchByOldId(masterTypeId, oldId, true);
	}

	/**
	 * Returns the master file where masterTypeId = &#63; and oldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param masterTypeId the master type ID
	 * @param oldId the old ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByOldId(long masterTypeId, long oldId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { masterTypeId, oldId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_OLDID,
					finderArgs, this);
		}

		if (result instanceof MasterFile) {
			MasterFile masterFile = (MasterFile)result;

			if ((masterTypeId != masterFile.getMasterTypeId()) ||
					(oldId != masterFile.getOldId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_OLDID_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_OLDID_OLDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(oldId);

				List<MasterFile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OLDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"MasterFilePersistenceImpl.fetchByOldId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					MasterFile masterFile = list.get(0);

					result = masterFile;

					cacheResult(masterFile);

					if ((masterFile.getMasterTypeId() != masterTypeId) ||
							(masterFile.getOldId() != oldId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OLDID,
							finderArgs, masterFile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OLDID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MasterFile)result;
		}
	}

	/**
	 * Removes the master file where masterTypeId = &#63; and oldId = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param oldId the old ID
	 * @return the master file that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile removeByOldId(long masterTypeId, long oldId)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByOldId(masterTypeId, oldId);

		return remove(masterFile);
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and oldId = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param oldId the old ID
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOldId(long masterTypeId, long oldId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OLDID;

		Object[] finderArgs = new Object[] { masterTypeId, oldId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_OLDID_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_OLDID_OLDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(oldId);

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

	private static final String _FINDER_COLUMN_OLDID_MASTERTYPEID_2 = "masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_OLDID_OLDID_2 = "masterFile.oldId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMasterTypeAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMasterTypeAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS1_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS2_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS3_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS4_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndStatus",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4)
		throws SystemException {
		return findByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4,
		int start, int end) throws SystemException {
		return findByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS;
			finderArgs = new Object[] {
					masterTypeId, status1, status2, status3, status4
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS;
			finderArgs = new Object[] {
					masterTypeId, status1, status2, status3, status4,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(status1 != masterFile.getStatus1()) ||
						(status2 != masterFile.getStatus2()) ||
						(status3 != masterFile.getStatus3()) ||
						(status4 != masterFile.getStatus4())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS1_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS2_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS3_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS4_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status1);

				qPos.add(status2);

				qPos.add(status3);

				qPos.add(status4);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus_First(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus_First(masterTypeId,
				status1, status2, status3, status4, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status1=");
		msg.append(status1);

		msg.append(", status2=");
		msg.append(status2);

		msg.append(", status3=");
		msg.append(status3);

		msg.append(", status4=");
		msg.append(status4);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus_First(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4,
		OrderByComparator orderByComparator) throws SystemException {
		List<MasterFile> list = findByMasterTypeAndStatus(masterTypeId,
				status1, status2, status3, status4, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus_Last(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus_Last(masterTypeId,
				status1, status2, status3, status4, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status1=");
		msg.append(status1);

		msg.append(", status2=");
		msg.append(status2);

		msg.append(", status3=");
		msg.append(status3);

		msg.append(", status4=");
		msg.append(status4);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus_Last(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMasterTypeAndStatus(masterTypeId, status1, status2,
				status3, status4);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterTypeAndStatus(masterTypeId,
				status1, status2, status3, status4, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterTypeAndStatus_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status1, boolean status2,
		boolean status3, boolean status4, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterTypeAndStatus_PrevAndNext(session,
					masterFile, masterTypeId, status1, status2, status3,
					status4, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterTypeAndStatus_PrevAndNext(session,
					masterFile, masterTypeId, status1, status2, status3,
					status4, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterTypeAndStatus_PrevAndNext(Session session,
		MasterFile masterFile, long masterTypeId, boolean status1,
		boolean status2, boolean status3, boolean status4,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS1_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS2_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS3_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS4_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(status1);

		qPos.add(status2);

		qPos.add(status3);

		qPos.add(status4);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterTypeAndStatus(long masterTypeId, boolean status1,
		boolean status2, boolean status3, boolean status4)
		throws SystemException {
		for (MasterFile masterFile : findByMasterTypeAndStatus(masterTypeId,
				status1, status2, status3, status4, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param status2 the status2
	 * @param status3 the status3
	 * @param status4 the status4
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndStatus(long masterTypeId, boolean status1,
		boolean status2, boolean status3, boolean status4)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS;

		Object[] finderArgs = new Object[] {
				masterTypeId, status1, status2, status3, status4
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS1_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS2_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS3_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS4_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status1);

				qPos.add(status2);

				qPos.add(status3);

				qPos.add(status4);

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

	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS_MASTERTYPEID_2 =
		"masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS1_2 = "masterFile.status1 = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS2_2 = "masterFile.status2 = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS3_2 = "masterFile.status3 = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS_STATUS4_2 = "masterFile.status4 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMasterTypeAndStatus1",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMasterTypeAndStatus1",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS1 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndStatus1",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus1(long masterTypeId,
		boolean status1) throws SystemException {
		return findByMasterTypeAndStatus1(masterTypeId, status1,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus1(long masterTypeId,
		boolean status1, int start, int end) throws SystemException {
		return findByMasterTypeAndStatus1(masterTypeId, status1, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus1(long masterTypeId,
		boolean status1, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1;
			finderArgs = new Object[] { masterTypeId, status1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1;
			finderArgs = new Object[] {
					masterTypeId, status1,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(status1 != masterFile.getStatus1())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS1_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS1_STATUS1_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status1);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus1_First(long masterTypeId,
		boolean status1, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus1_First(masterTypeId,
				status1, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status1=");
		msg.append(status1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus1_First(long masterTypeId,
		boolean status1, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByMasterTypeAndStatus1(masterTypeId,
				status1, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus1_Last(long masterTypeId,
		boolean status1, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus1_Last(masterTypeId,
				status1, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status1=");
		msg.append(status1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus1_Last(long masterTypeId,
		boolean status1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMasterTypeAndStatus1(masterTypeId, status1);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterTypeAndStatus1(masterTypeId,
				status1, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterTypeAndStatus1_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status1,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterTypeAndStatus1_PrevAndNext(session,
					masterFile, masterTypeId, status1, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterTypeAndStatus1_PrevAndNext(session,
					masterFile, masterTypeId, status1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterTypeAndStatus1_PrevAndNext(
		Session session, MasterFile masterFile, long masterTypeId,
		boolean status1, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS1_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS1_STATUS1_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(status1);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and status1 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterTypeAndStatus1(long masterTypeId, boolean status1)
		throws SystemException {
		for (MasterFile masterFile : findByMasterTypeAndStatus1(masterTypeId,
				status1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and status1 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status1 the status1
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndStatus1(long masterTypeId, boolean status1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS1;

		Object[] finderArgs = new Object[] { masterTypeId, status1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS1_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS1_STATUS1_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status1);

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

	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS1_MASTERTYPEID_2 =
		"masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS1_STATUS1_2 = "masterFile.status1 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMasterTypeAndStatus2",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMasterTypeAndStatus2",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS2 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndStatus2",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus2(long masterTypeId,
		boolean status2) throws SystemException {
		return findByMasterTypeAndStatus2(masterTypeId, status2,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus2(long masterTypeId,
		boolean status2, int start, int end) throws SystemException {
		return findByMasterTypeAndStatus2(masterTypeId, status2, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus2(long masterTypeId,
		boolean status2, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2;
			finderArgs = new Object[] { masterTypeId, status2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2;
			finderArgs = new Object[] {
					masterTypeId, status2,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(status2 != masterFile.getStatus2())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS2_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS2_STATUS2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status2);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus2_First(long masterTypeId,
		boolean status2, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus2_First(masterTypeId,
				status2, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status2=");
		msg.append(status2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus2_First(long masterTypeId,
		boolean status2, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByMasterTypeAndStatus2(masterTypeId,
				status2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus2_Last(long masterTypeId,
		boolean status2, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus2_Last(masterTypeId,
				status2, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status2=");
		msg.append(status2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus2_Last(long masterTypeId,
		boolean status2, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMasterTypeAndStatus2(masterTypeId, status2);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterTypeAndStatus2(masterTypeId,
				status2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterTypeAndStatus2_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status2,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterTypeAndStatus2_PrevAndNext(session,
					masterFile, masterTypeId, status2, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterTypeAndStatus2_PrevAndNext(session,
					masterFile, masterTypeId, status2, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterTypeAndStatus2_PrevAndNext(
		Session session, MasterFile masterFile, long masterTypeId,
		boolean status2, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS2_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS2_STATUS2_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(status2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and status2 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterTypeAndStatus2(long masterTypeId, boolean status2)
		throws SystemException {
		for (MasterFile masterFile : findByMasterTypeAndStatus2(masterTypeId,
				status2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and status2 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status2 the status2
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndStatus2(long masterTypeId, boolean status2)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS2;

		Object[] finderArgs = new Object[] { masterTypeId, status2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS2_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS2_STATUS2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status2);

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

	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS2_MASTERTYPEID_2 =
		"masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS2_STATUS2_2 = "masterFile.status2 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMasterTypeAndStatus3",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMasterTypeAndStatus3",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS3_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS3 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndStatus3",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus3(long masterTypeId,
		boolean status3) throws SystemException {
		return findByMasterTypeAndStatus3(masterTypeId, status3,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus3(long masterTypeId,
		boolean status3, int start, int end) throws SystemException {
		return findByMasterTypeAndStatus3(masterTypeId, status3, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus3(long masterTypeId,
		boolean status3, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3;
			finderArgs = new Object[] { masterTypeId, status3 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3;
			finderArgs = new Object[] {
					masterTypeId, status3,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(status3 != masterFile.getStatus3())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS3_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS3_STATUS3_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status3);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus3_First(long masterTypeId,
		boolean status3, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus3_First(masterTypeId,
				status3, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status3=");
		msg.append(status3);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus3_First(long masterTypeId,
		boolean status3, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByMasterTypeAndStatus3(masterTypeId,
				status3, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus3_Last(long masterTypeId,
		boolean status3, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus3_Last(masterTypeId,
				status3, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status3=");
		msg.append(status3);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus3_Last(long masterTypeId,
		boolean status3, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMasterTypeAndStatus3(masterTypeId, status3);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterTypeAndStatus3(masterTypeId,
				status3, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterTypeAndStatus3_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status3,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterTypeAndStatus3_PrevAndNext(session,
					masterFile, masterTypeId, status3, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterTypeAndStatus3_PrevAndNext(session,
					masterFile, masterTypeId, status3, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterTypeAndStatus3_PrevAndNext(
		Session session, MasterFile masterFile, long masterTypeId,
		boolean status3, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS3_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS3_STATUS3_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(status3);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and status3 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterTypeAndStatus3(long masterTypeId, boolean status3)
		throws SystemException {
		for (MasterFile masterFile : findByMasterTypeAndStatus3(masterTypeId,
				status3, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and status3 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status3 the status3
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndStatus3(long masterTypeId, boolean status3)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS3;

		Object[] finderArgs = new Object[] { masterTypeId, status3 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS3_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS3_STATUS3_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status3);

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

	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS3_MASTERTYPEID_2 =
		"masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS3_STATUS3_2 = "masterFile.status3 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMasterTypeAndStatus4",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMasterTypeAndStatus4",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS4_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS4 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndStatus4",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus4(long masterTypeId,
		boolean status4) throws SystemException {
		return findByMasterTypeAndStatus4(masterTypeId, status4,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus4(long masterTypeId,
		boolean status4, int start, int end) throws SystemException {
		return findByMasterTypeAndStatus4(masterTypeId, status4, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus4(long masterTypeId,
		boolean status4, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4;
			finderArgs = new Object[] { masterTypeId, status4 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4;
			finderArgs = new Object[] {
					masterTypeId, status4,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(status4 != masterFile.getStatus4())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS4_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS4_STATUS4_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status4);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus4_First(long masterTypeId,
		boolean status4, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus4_First(masterTypeId,
				status4, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status4=");
		msg.append(status4);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus4_First(long masterTypeId,
		boolean status4, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByMasterTypeAndStatus4(masterTypeId,
				status4, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus4_Last(long masterTypeId,
		boolean status4, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus4_Last(masterTypeId,
				status4, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status4=");
		msg.append(status4);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus4_Last(long masterTypeId,
		boolean status4, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMasterTypeAndStatus4(masterTypeId, status4);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterTypeAndStatus4(masterTypeId,
				status4, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterTypeAndStatus4_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status4,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterTypeAndStatus4_PrevAndNext(session,
					masterFile, masterTypeId, status4, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterTypeAndStatus4_PrevAndNext(session,
					masterFile, masterTypeId, status4, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterTypeAndStatus4_PrevAndNext(
		Session session, MasterFile masterFile, long masterTypeId,
		boolean status4, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS4_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS4_STATUS4_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(status4);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and status4 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterTypeAndStatus4(long masterTypeId, boolean status4)
		throws SystemException {
		for (MasterFile masterFile : findByMasterTypeAndStatus4(masterTypeId,
				status4, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and status4 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status4 the status4
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndStatus4(long masterTypeId, boolean status4)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS4;

		Object[] finderArgs = new Object[] { masterTypeId, status4 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS4_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS4_STATUS4_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status4);

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

	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS4_MASTERTYPEID_2 =
		"masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS4_STATUS4_2 = "masterFile.status4 = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMasterTypeAndStatus5",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5 =
		new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, MasterFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMasterTypeAndStatus5",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MasterFileModelImpl.MASTERTYPEID_COLUMN_BITMASK |
			MasterFileModelImpl.STATUS5_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS5 = new FinderPath(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMasterTypeAndStatus5",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the master files where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @return the matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus5(long masterTypeId,
		boolean status5) throws SystemException {
		return findByMasterTypeAndStatus5(masterTypeId, status5,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus5(long masterTypeId,
		boolean status5, int start, int end) throws SystemException {
		return findByMasterTypeAndStatus5(masterTypeId, status5, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the master files where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findByMasterTypeAndStatus5(long masterTypeId,
		boolean status5, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5;
			finderArgs = new Object[] { masterTypeId, status5 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5;
			finderArgs = new Object[] {
					masterTypeId, status5,
					
					start, end, orderByComparator
				};
		}

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MasterFile masterFile : list) {
				if ((masterTypeId != masterFile.getMasterTypeId()) ||
						(status5 != masterFile.getStatus5())) {
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

			query.append(_SQL_SELECT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS5_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS5_STATUS5_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MasterFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status5);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus5_First(long masterTypeId,
		boolean status5, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus5_First(masterTypeId,
				status5, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status5=");
		msg.append(status5);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the first master file in the ordered set where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus5_First(long masterTypeId,
		boolean status5, OrderByComparator orderByComparator)
		throws SystemException {
		List<MasterFile> list = findByMasterTypeAndStatus5(masterTypeId,
				status5, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByMasterTypeAndStatus5_Last(long masterTypeId,
		boolean status5, OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByMasterTypeAndStatus5_Last(masterTypeId,
				status5, orderByComparator);

		if (masterFile != null) {
			return masterFile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("masterTypeId=");
		msg.append(masterTypeId);

		msg.append(", status5=");
		msg.append(status5);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMasterFileException(msg.toString());
	}

	/**
	 * Returns the last master file in the ordered set where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master file, or <code>null</code> if a matching master file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByMasterTypeAndStatus5_Last(long masterTypeId,
		boolean status5, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMasterTypeAndStatus5(masterTypeId, status5);

		if (count == 0) {
			return null;
		}

		List<MasterFile> list = findByMasterTypeAndStatus5(masterTypeId,
				status5, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterFileId the primary key of the current master file
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile[] findByMasterTypeAndStatus5_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status5,
		OrderByComparator orderByComparator)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = findByPrimaryKey(masterFileId);

		Session session = null;

		try {
			session = openSession();

			MasterFile[] array = new MasterFileImpl[3];

			array[0] = getByMasterTypeAndStatus5_PrevAndNext(session,
					masterFile, masterTypeId, status5, orderByComparator, true);

			array[1] = masterFile;

			array[2] = getByMasterTypeAndStatus5_PrevAndNext(session,
					masterFile, masterTypeId, status5, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterFile getByMasterTypeAndStatus5_PrevAndNext(
		Session session, MasterFile masterFile, long masterTypeId,
		boolean status5, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MASTERFILE_WHERE);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS5_MASTERTYPEID_2);

		query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS5_STATUS5_2);

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
			query.append(MasterFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(masterTypeId);

		qPos.add(status5);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(masterFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MasterFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master files where masterTypeId = &#63; and status5 = &#63; from the database.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMasterTypeAndStatus5(long masterTypeId, boolean status5)
		throws SystemException {
		for (MasterFile masterFile : findByMasterTypeAndStatus5(masterTypeId,
				status5, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files where masterTypeId = &#63; and status5 = &#63;.
	 *
	 * @param masterTypeId the master type ID
	 * @param status5 the status5
	 * @return the number of matching master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMasterTypeAndStatus5(long masterTypeId, boolean status5)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS5;

		Object[] finderArgs = new Object[] { masterTypeId, status5 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASTERFILE_WHERE);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS5_MASTERTYPEID_2);

			query.append(_FINDER_COLUMN_MASTERTYPEANDSTATUS5_STATUS5_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(masterTypeId);

				qPos.add(status5);

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

	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS5_MASTERTYPEID_2 =
		"masterFile.masterTypeId = ? AND ";
	private static final String _FINDER_COLUMN_MASTERTYPEANDSTATUS5_STATUS5_2 = "masterFile.status5 = ?";

	public MasterFilePersistenceImpl() {
		setModelClass(MasterFile.class);
	}

	/**
	 * Caches the master file in the entity cache if it is enabled.
	 *
	 * @param masterFile the master file
	 */
	@Override
	public void cacheResult(MasterFile masterFile) {
		EntityCacheUtil.putResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileImpl.class, masterFile.getPrimaryKey(), masterFile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
			new Object[] {
				masterFile.getMasterTypeId(), masterFile.getMasterFileName()
			}, masterFile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OLDID,
			new Object[] { masterFile.getMasterTypeId(), masterFile.getOldId() },
			masterFile);

		masterFile.resetOriginalValues();
	}

	/**
	 * Caches the master files in the entity cache if it is enabled.
	 *
	 * @param masterFiles the master files
	 */
	@Override
	public void cacheResult(List<MasterFile> masterFiles) {
		for (MasterFile masterFile : masterFiles) {
			if (EntityCacheUtil.getResult(
						MasterFileModelImpl.ENTITY_CACHE_ENABLED,
						MasterFileImpl.class, masterFile.getPrimaryKey()) == null) {
				cacheResult(masterFile);
			}
			else {
				masterFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all master files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MasterFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MasterFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterFile masterFile) {
		EntityCacheUtil.removeResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileImpl.class, masterFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(masterFile);
	}

	@Override
	public void clearCache(List<MasterFile> masterFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MasterFile masterFile : masterFiles) {
			EntityCacheUtil.removeResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
				MasterFileImpl.class, masterFile.getPrimaryKey());

			clearUniqueFindersCache(masterFile);
		}
	}

	protected void cacheUniqueFindersCache(MasterFile masterFile) {
		if (masterFile.isNew()) {
			Object[] args = new Object[] {
					masterFile.getMasterTypeId(), masterFile.getMasterFileName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
				args, masterFile);

			args = new Object[] {
					masterFile.getMasterTypeId(), masterFile.getOldId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OLDID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OLDID, args,
				masterFile);
		}
		else {
			MasterFileModelImpl masterFileModelImpl = (MasterFileModelImpl)masterFile;

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFile.getMasterTypeId(),
						masterFile.getMasterFileName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
					args, masterFile);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_OLDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFile.getMasterTypeId(), masterFile.getOldId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OLDID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_OLDID, args,
					masterFile);
			}
		}
	}

	protected void clearUniqueFindersCache(MasterFile masterFile) {
		MasterFileModelImpl masterFileModelImpl = (MasterFileModelImpl)masterFile;

		Object[] args = new Object[] {
				masterFile.getMasterTypeId(), masterFile.getMasterFileName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
			args);

		if ((masterFileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					masterFileModelImpl.getOriginalMasterTypeId(),
					masterFileModelImpl.getOriginalMasterFileName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MASTERTYPEANDNAME,
				args);
		}

		args = new Object[] { masterFile.getMasterTypeId(), masterFile.getOldId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OLDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OLDID, args);

		if ((masterFileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_OLDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					masterFileModelImpl.getOriginalMasterTypeId(),
					masterFileModelImpl.getOriginalOldId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OLDID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_OLDID, args);
		}
	}

	/**
	 * Creates a new master file with the primary key. Does not add the master file to the database.
	 *
	 * @param masterFileId the primary key for the new master file
	 * @return the new master file
	 */
	@Override
	public MasterFile create(long masterFileId) {
		MasterFile masterFile = new MasterFileImpl();

		masterFile.setNew(true);
		masterFile.setPrimaryKey(masterFileId);

		return masterFile;
	}

	/**
	 * Removes the master file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterFileId the primary key of the master file
	 * @return the master file that was removed
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile remove(long masterFileId)
		throws NoSuchMasterFileException, SystemException {
		return remove((Serializable)masterFileId);
	}

	/**
	 * Removes the master file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master file
	 * @return the master file that was removed
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile remove(Serializable primaryKey)
		throws NoSuchMasterFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MasterFile masterFile = (MasterFile)session.get(MasterFileImpl.class,
					primaryKey);

			if (masterFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(masterFile);
		}
		catch (NoSuchMasterFileException nsee) {
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
	protected MasterFile removeImpl(MasterFile masterFile)
		throws SystemException {
		masterFile = toUnwrappedModel(masterFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterFile)) {
				masterFile = (MasterFile)session.get(MasterFileImpl.class,
						masterFile.getPrimaryKeyObj());
			}

			if (masterFile != null) {
				session.delete(masterFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (masterFile != null) {
			clearCache(masterFile);
		}

		return masterFile;
	}

	@Override
	public MasterFile updateImpl(com.idetronic.eis.model.MasterFile masterFile)
		throws SystemException {
		masterFile = toUnwrappedModel(masterFile);

		boolean isNew = masterFile.isNew();

		MasterFileModelImpl masterFileModelImpl = (MasterFileModelImpl)masterFile;

		Session session = null;

		try {
			session = openSession();

			if (masterFile.isNew()) {
				session.save(masterFile);

				masterFile.setNew(false);
			}
			else {
				session.merge(masterFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MasterFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalInActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPE,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getInActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPE,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT1.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalParentId1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDPARENT1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT1,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getParentId1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDPARENT1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT1,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalParentId2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDPARENT2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT2,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getParentId2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEANDPARENT2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEANDPARENT2,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalStatus1(),
						masterFileModelImpl.getOriginalStatus2(),
						masterFileModelImpl.getOriginalStatus3(),
						masterFileModelImpl.getOriginalStatus4()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getStatus1(),
						masterFileModelImpl.getStatus2(),
						masterFileModelImpl.getStatus3(),
						masterFileModelImpl.getStatus4()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalStatus1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getStatus1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS1,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalStatus2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getStatus2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS2,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalStatus3()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS3,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getStatus3()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS3,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS3,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalStatus4()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS4,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getStatus4()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS4,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS4,
					args);
			}

			if ((masterFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						masterFileModelImpl.getOriginalMasterTypeId(),
						masterFileModelImpl.getOriginalStatus5()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS5,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5,
					args);

				args = new Object[] {
						masterFileModelImpl.getMasterTypeId(),
						masterFileModelImpl.getStatus5()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MASTERTYPEANDSTATUS5,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MASTERTYPEANDSTATUS5,
					args);
			}
		}

		EntityCacheUtil.putResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
			MasterFileImpl.class, masterFile.getPrimaryKey(), masterFile);

		clearUniqueFindersCache(masterFile);
		cacheUniqueFindersCache(masterFile);

		return masterFile;
	}

	protected MasterFile toUnwrappedModel(MasterFile masterFile) {
		if (masterFile instanceof MasterFileImpl) {
			return masterFile;
		}

		MasterFileImpl masterFileImpl = new MasterFileImpl();

		masterFileImpl.setNew(masterFile.isNew());
		masterFileImpl.setPrimaryKey(masterFile.getPrimaryKey());

		masterFileImpl.setMasterFileId(masterFile.getMasterFileId());
		masterFileImpl.setMasterTypeId(masterFile.getMasterTypeId());
		masterFileImpl.setParentId1(masterFile.getParentId1());
		masterFileImpl.setParentId2(masterFile.getParentId2());
		masterFileImpl.setMasterFileName(masterFile.getMasterFileName());
		masterFileImpl.setStatus1(masterFile.isStatus1());
		masterFileImpl.setStatus2(masterFile.isStatus2());
		masterFileImpl.setStatus3(masterFile.isStatus3());
		masterFileImpl.setStatus4(masterFile.isStatus4());
		masterFileImpl.setStatus5(masterFile.isStatus5());
		masterFileImpl.setMasterCode(masterFile.getMasterCode());
		masterFileImpl.setOldId(masterFile.getOldId());
		masterFileImpl.setNote(masterFile.getNote());
		masterFileImpl.setInActive(masterFile.isInActive());

		return masterFileImpl;
	}

	/**
	 * Returns the master file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the master file
	 * @return the master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterFileException, SystemException {
		MasterFile masterFile = fetchByPrimaryKey(primaryKey);

		if (masterFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return masterFile;
	}

	/**
	 * Returns the master file with the primary key or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	 *
	 * @param masterFileId the primary key of the master file
	 * @return the master file
	 * @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile findByPrimaryKey(long masterFileId)
		throws NoSuchMasterFileException, SystemException {
		return findByPrimaryKey((Serializable)masterFileId);
	}

	/**
	 * Returns the master file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master file
	 * @return the master file, or <code>null</code> if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MasterFile masterFile = (MasterFile)EntityCacheUtil.getResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
				MasterFileImpl.class, primaryKey);

		if (masterFile == _nullMasterFile) {
			return null;
		}

		if (masterFile == null) {
			Session session = null;

			try {
				session = openSession();

				masterFile = (MasterFile)session.get(MasterFileImpl.class,
						primaryKey);

				if (masterFile != null) {
					cacheResult(masterFile);
				}
				else {
					EntityCacheUtil.putResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
						MasterFileImpl.class, primaryKey, _nullMasterFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MasterFileModelImpl.ENTITY_CACHE_ENABLED,
					MasterFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return masterFile;
	}

	/**
	 * Returns the master file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterFileId the primary key of the master file
	 * @return the master file, or <code>null</code> if a master file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MasterFile fetchByPrimaryKey(long masterFileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)masterFileId);
	}

	/**
	 * Returns all the master files.
	 *
	 * @return the master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @return the range of master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of master files
	 * @param end the upper bound of the range of master files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MasterFile> findAll(int start, int end,
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

		List<MasterFile> list = (List<MasterFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MASTERFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERFILE;

				if (pagination) {
					sql = sql.concat(MasterFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MasterFile>(list);
				}
				else {
					list = (List<MasterFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the master files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MasterFile masterFile : findAll()) {
			remove(masterFile);
		}
	}

	/**
	 * Returns the number of master files.
	 *
	 * @return the number of master files
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

				Query q = session.createQuery(_SQL_COUNT_MASTERFILE);

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
	 * Initializes the master file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.MasterFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MasterFile>> listenersList = new ArrayList<ModelListener<MasterFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MasterFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MasterFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MASTERFILE = "SELECT masterFile FROM MasterFile masterFile";
	private static final String _SQL_SELECT_MASTERFILE_WHERE = "SELECT masterFile FROM MasterFile masterFile WHERE ";
	private static final String _SQL_COUNT_MASTERFILE = "SELECT COUNT(masterFile) FROM MasterFile masterFile";
	private static final String _SQL_COUNT_MASTERFILE_WHERE = "SELECT COUNT(masterFile) FROM MasterFile masterFile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "masterFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MasterFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MasterFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MasterFilePersistenceImpl.class);
	private static MasterFile _nullMasterFile = new MasterFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MasterFile> toCacheModel() {
				return _nullMasterFileCacheModel;
			}
		};

	private static CacheModel<MasterFile> _nullMasterFileCacheModel = new CacheModel<MasterFile>() {
			@Override
			public MasterFile toEntityModel() {
				return _nullMasterFile;
			}
		};
}
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

import com.idetronic.eis.NoSuchUserLibraryException;
import com.idetronic.eis.model.UserLibrary;
import com.idetronic.eis.model.impl.UserLibraryImpl;
import com.idetronic.eis.model.impl.UserLibraryModelImpl;

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
 * The persistence implementation for the user library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see UserLibraryPersistence
 * @see UserLibraryUtil
 * @generated
 */
public class UserLibraryPersistenceImpl extends BasePersistenceImpl<UserLibrary>
	implements UserLibraryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserLibraryUtil} to access the user library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserLibraryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERLIBRARY = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserLibrary",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserLibraryModelImpl.USERID_COLUMN_BITMASK |
			UserLibraryModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERLIBRARY = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserLibrary",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the user library where userId = &#63; and libraryId = &#63; or throws a {@link com.idetronic.eis.NoSuchUserLibraryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the matching user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findByuserLibrary(long userId, long libraryId)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = fetchByuserLibrary(userId, libraryId);

		if (userLibrary == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", libraryId=");
			msg.append(libraryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserLibraryException(msg.toString());
		}

		return userLibrary;
	}

	/**
	 * Returns the user library where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the matching user library, or <code>null</code> if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchByuserLibrary(long userId, long libraryId)
		throws SystemException {
		return fetchByuserLibrary(userId, libraryId, true);
	}

	/**
	 * Returns the user library where userId = &#63; and libraryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user library, or <code>null</code> if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchByuserLibrary(long userId, long libraryId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, libraryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
					finderArgs, this);
		}

		if (result instanceof UserLibrary) {
			UserLibrary userLibrary = (UserLibrary)result;

			if ((userId != userLibrary.getUserId()) ||
					(libraryId != userLibrary.getLibraryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERLIBRARY_WHERE);

			query.append(_FINDER_COLUMN_USERLIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERLIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(libraryId);

				List<UserLibrary> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
						finderArgs, list);
				}
				else {
					UserLibrary userLibrary = list.get(0);

					result = userLibrary;

					cacheResult(userLibrary);

					if ((userLibrary.getUserId() != userId) ||
							(userLibrary.getLibraryId() != libraryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
							finderArgs, userLibrary);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
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
			return (UserLibrary)result;
		}
	}

	/**
	 * Removes the user library where userId = &#63; and libraryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the user library that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary removeByuserLibrary(long userId, long libraryId)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = findByuserLibrary(userId, libraryId);

		return remove(userLibrary);
	}

	/**
	 * Returns the number of user libraries where userId = &#63; and libraryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param libraryId the library ID
	 * @return the number of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserLibrary(long userId, long libraryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERLIBRARY;

		Object[] finderArgs = new Object[] { userId, libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERLIBRARY_WHERE);

			query.append(_FINDER_COLUMN_USERLIBRARY_USERID_2);

			query.append(_FINDER_COLUMN_USERLIBRARY_LIBRARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERLIBRARY_USERID_2 = "userLibrary.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERLIBRARY_LIBRARYID_2 = "userLibrary.libraryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuser",
			new String[] { Long.class.getName() },
			UserLibraryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user libraries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findByuser(long userId) throws SystemException {
		return findByuser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user libraries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user libraries
	 * @param end the upper bound of the range of user libraries (not inclusive)
	 * @return the range of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findByuser(long userId, int start, int end)
		throws SystemException {
		return findByuser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user libraries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user libraries
	 * @param end the upper bound of the range of user libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findByuser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<UserLibrary> list = (List<UserLibrary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserLibrary userLibrary : list) {
				if ((userId != userLibrary.getUserId())) {
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

			query.append(_SQL_SELECT_USERLIBRARY_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserLibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserLibrary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserLibrary>(list);
				}
				else {
					list = (List<UserLibrary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user library in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findByuser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = fetchByuser_First(userId, orderByComparator);

		if (userLibrary != null) {
			return userLibrary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserLibraryException(msg.toString());
	}

	/**
	 * Returns the first user library in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user library, or <code>null</code> if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchByuser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserLibrary> list = findByuser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user library in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findByuser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = fetchByuser_Last(userId, orderByComparator);

		if (userLibrary != null) {
			return userLibrary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserLibraryException(msg.toString());
	}

	/**
	 * Returns the last user library in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user library, or <code>null</code> if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchByuser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuser(userId);

		if (count == 0) {
			return null;
		}

		List<UserLibrary> list = findByuser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user libraries before and after the current user library in the ordered set where userId = &#63;.
	 *
	 * @param userLibraryId the primary key of the current user library
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary[] findByuser_PrevAndNext(long userLibraryId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = findByPrimaryKey(userLibraryId);

		Session session = null;

		try {
			session = openSession();

			UserLibrary[] array = new UserLibraryImpl[3];

			array[0] = getByuser_PrevAndNext(session, userLibrary, userId,
					orderByComparator, true);

			array[1] = userLibrary;

			array[2] = getByuser_PrevAndNext(session, userLibrary, userId,
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

	protected UserLibrary getByuser_PrevAndNext(Session session,
		UserLibrary userLibrary, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLIBRARY_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(UserLibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userLibrary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserLibrary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user libraries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuser(long userId) throws SystemException {
		for (UserLibrary userLibrary : findByuser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userLibrary);
		}
	}

	/**
	 * Returns the number of user libraries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERLIBRARY_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "userLibrary.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBRARY = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylibrary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY =
		new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, UserLibraryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylibrary",
			new String[] { Long.class.getName() },
			UserLibraryModelImpl.LIBRARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIBRARY = new FinderPath(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylibrary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user libraries where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findBylibrary(long libraryId)
		throws SystemException {
		return findBylibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user libraries where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of user libraries
	 * @param end the upper bound of the range of user libraries (not inclusive)
	 * @return the range of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findBylibrary(long libraryId, int start, int end)
		throws SystemException {
		return findBylibrary(libraryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user libraries where libraryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libraryId the library ID
	 * @param start the lower bound of the range of user libraries
	 * @param end the upper bound of the range of user libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findBylibrary(long libraryId, int start, int end,
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

		List<UserLibrary> list = (List<UserLibrary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserLibrary userLibrary : list) {
				if ((libraryId != userLibrary.getLibraryId())) {
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

			query.append(_SQL_SELECT_USERLIBRARY_WHERE);

			query.append(_FINDER_COLUMN_LIBRARY_LIBRARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserLibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(libraryId);

				if (!pagination) {
					list = (List<UserLibrary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserLibrary>(list);
				}
				else {
					list = (List<UserLibrary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user library in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findBylibrary_First(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = fetchBylibrary_First(libraryId,
				orderByComparator);

		if (userLibrary != null) {
			return userLibrary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserLibraryException(msg.toString());
	}

	/**
	 * Returns the first user library in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user library, or <code>null</code> if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchBylibrary_First(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserLibrary> list = findBylibrary(libraryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user library in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findBylibrary_Last(long libraryId,
		OrderByComparator orderByComparator)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = fetchBylibrary_Last(libraryId,
				orderByComparator);

		if (userLibrary != null) {
			return userLibrary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libraryId=");
		msg.append(libraryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserLibraryException(msg.toString());
	}

	/**
	 * Returns the last user library in the ordered set where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user library, or <code>null</code> if a matching user library could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchBylibrary_Last(long libraryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylibrary(libraryId);

		if (count == 0) {
			return null;
		}

		List<UserLibrary> list = findBylibrary(libraryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user libraries before and after the current user library in the ordered set where libraryId = &#63;.
	 *
	 * @param userLibraryId the primary key of the current user library
	 * @param libraryId the library ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary[] findBylibrary_PrevAndNext(long userLibraryId,
		long libraryId, OrderByComparator orderByComparator)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = findByPrimaryKey(userLibraryId);

		Session session = null;

		try {
			session = openSession();

			UserLibrary[] array = new UserLibraryImpl[3];

			array[0] = getBylibrary_PrevAndNext(session, userLibrary,
					libraryId, orderByComparator, true);

			array[1] = userLibrary;

			array[2] = getBylibrary_PrevAndNext(session, userLibrary,
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

	protected UserLibrary getBylibrary_PrevAndNext(Session session,
		UserLibrary userLibrary, long libraryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERLIBRARY_WHERE);

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
			query.append(UserLibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(libraryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userLibrary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserLibrary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user libraries where libraryId = &#63; from the database.
	 *
	 * @param libraryId the library ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylibrary(long libraryId) throws SystemException {
		for (UserLibrary userLibrary : findBylibrary(libraryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userLibrary);
		}
	}

	/**
	 * Returns the number of user libraries where libraryId = &#63;.
	 *
	 * @param libraryId the library ID
	 * @return the number of matching user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylibrary(long libraryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIBRARY;

		Object[] finderArgs = new Object[] { libraryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERLIBRARY_WHERE);

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

	private static final String _FINDER_COLUMN_LIBRARY_LIBRARYID_2 = "userLibrary.libraryId = ?";

	public UserLibraryPersistenceImpl() {
		setModelClass(UserLibrary.class);
	}

	/**
	 * Caches the user library in the entity cache if it is enabled.
	 *
	 * @param userLibrary the user library
	 */
	@Override
	public void cacheResult(UserLibrary userLibrary) {
		EntityCacheUtil.putResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryImpl.class, userLibrary.getPrimaryKey(), userLibrary);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
			new Object[] { userLibrary.getUserId(), userLibrary.getLibraryId() },
			userLibrary);

		userLibrary.resetOriginalValues();
	}

	/**
	 * Caches the user libraries in the entity cache if it is enabled.
	 *
	 * @param userLibraries the user libraries
	 */
	@Override
	public void cacheResult(List<UserLibrary> userLibraries) {
		for (UserLibrary userLibrary : userLibraries) {
			if (EntityCacheUtil.getResult(
						UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
						UserLibraryImpl.class, userLibrary.getPrimaryKey()) == null) {
				cacheResult(userLibrary);
			}
			else {
				userLibrary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user libraries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserLibraryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserLibraryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user library.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserLibrary userLibrary) {
		EntityCacheUtil.removeResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryImpl.class, userLibrary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userLibrary);
	}

	@Override
	public void clearCache(List<UserLibrary> userLibraries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserLibrary userLibrary : userLibraries) {
			EntityCacheUtil.removeResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
				UserLibraryImpl.class, userLibrary.getPrimaryKey());

			clearUniqueFindersCache(userLibrary);
		}
	}

	protected void cacheUniqueFindersCache(UserLibrary userLibrary) {
		if (userLibrary.isNew()) {
			Object[] args = new Object[] {
					userLibrary.getUserId(), userLibrary.getLibraryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERLIBRARY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY, args,
				userLibrary);
		}
		else {
			UserLibraryModelImpl userLibraryModelImpl = (UserLibraryModelImpl)userLibrary;

			if ((userLibraryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERLIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userLibrary.getUserId(), userLibrary.getLibraryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERLIBRARY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERLIBRARY,
					args, userLibrary);
			}
		}
	}

	protected void clearUniqueFindersCache(UserLibrary userLibrary) {
		UserLibraryModelImpl userLibraryModelImpl = (UserLibraryModelImpl)userLibrary;

		Object[] args = new Object[] {
				userLibrary.getUserId(), userLibrary.getLibraryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLIBRARY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERLIBRARY, args);

		if ((userLibraryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERLIBRARY.getColumnBitmask()) != 0) {
			args = new Object[] {
					userLibraryModelImpl.getOriginalUserId(),
					userLibraryModelImpl.getOriginalLibraryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERLIBRARY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERLIBRARY, args);
		}
	}

	/**
	 * Creates a new user library with the primary key. Does not add the user library to the database.
	 *
	 * @param userLibraryId the primary key for the new user library
	 * @return the new user library
	 */
	@Override
	public UserLibrary create(long userLibraryId) {
		UserLibrary userLibrary = new UserLibraryImpl();

		userLibrary.setNew(true);
		userLibrary.setPrimaryKey(userLibraryId);

		return userLibrary;
	}

	/**
	 * Removes the user library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userLibraryId the primary key of the user library
	 * @return the user library that was removed
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary remove(long userLibraryId)
		throws NoSuchUserLibraryException, SystemException {
		return remove((Serializable)userLibraryId);
	}

	/**
	 * Removes the user library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user library
	 * @return the user library that was removed
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary remove(Serializable primaryKey)
		throws NoSuchUserLibraryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserLibrary userLibrary = (UserLibrary)session.get(UserLibraryImpl.class,
					primaryKey);

			if (userLibrary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userLibrary);
		}
		catch (NoSuchUserLibraryException nsee) {
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
	protected UserLibrary removeImpl(UserLibrary userLibrary)
		throws SystemException {
		userLibrary = toUnwrappedModel(userLibrary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userLibrary)) {
				userLibrary = (UserLibrary)session.get(UserLibraryImpl.class,
						userLibrary.getPrimaryKeyObj());
			}

			if (userLibrary != null) {
				session.delete(userLibrary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userLibrary != null) {
			clearCache(userLibrary);
		}

		return userLibrary;
	}

	@Override
	public UserLibrary updateImpl(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws SystemException {
		userLibrary = toUnwrappedModel(userLibrary);

		boolean isNew = userLibrary.isNew();

		UserLibraryModelImpl userLibraryModelImpl = (UserLibraryModelImpl)userLibrary;

		Session session = null;

		try {
			session = openSession();

			if (userLibrary.isNew()) {
				session.save(userLibrary);

				userLibrary.setNew(false);
			}
			else {
				session.merge(userLibrary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserLibraryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userLibraryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userLibraryModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { userLibraryModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((userLibraryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userLibraryModelImpl.getOriginalLibraryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);

				args = new Object[] { userLibraryModelImpl.getLibraryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIBRARY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIBRARY,
					args);
			}
		}

		EntityCacheUtil.putResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
			UserLibraryImpl.class, userLibrary.getPrimaryKey(), userLibrary);

		clearUniqueFindersCache(userLibrary);
		cacheUniqueFindersCache(userLibrary);

		return userLibrary;
	}

	protected UserLibrary toUnwrappedModel(UserLibrary userLibrary) {
		if (userLibrary instanceof UserLibraryImpl) {
			return userLibrary;
		}

		UserLibraryImpl userLibraryImpl = new UserLibraryImpl();

		userLibraryImpl.setNew(userLibrary.isNew());
		userLibraryImpl.setPrimaryKey(userLibrary.getPrimaryKey());

		userLibraryImpl.setUserLibraryId(userLibrary.getUserLibraryId());
		userLibraryImpl.setUserId(userLibrary.getUserId());
		userLibraryImpl.setLibraryId(userLibrary.getLibraryId());
		userLibraryImpl.setCompanyId(userLibrary.getCompanyId());
		userLibraryImpl.setGroupId(userLibrary.getGroupId());
		userLibraryImpl.setCreatedByUserId(userLibrary.getCreatedByUserId());
		userLibraryImpl.setUserName(userLibrary.getUserName());
		userLibraryImpl.setCreateDate(userLibrary.getCreateDate());
		userLibraryImpl.setModifiedDate(userLibrary.getModifiedDate());

		return userLibraryImpl;
	}

	/**
	 * Returns the user library with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user library
	 * @return the user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserLibraryException, SystemException {
		UserLibrary userLibrary = fetchByPrimaryKey(primaryKey);

		if (userLibrary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserLibraryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userLibrary;
	}

	/**
	 * Returns the user library with the primary key or throws a {@link com.idetronic.eis.NoSuchUserLibraryException} if it could not be found.
	 *
	 * @param userLibraryId the primary key of the user library
	 * @return the user library
	 * @throws com.idetronic.eis.NoSuchUserLibraryException if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary findByPrimaryKey(long userLibraryId)
		throws NoSuchUserLibraryException, SystemException {
		return findByPrimaryKey((Serializable)userLibraryId);
	}

	/**
	 * Returns the user library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user library
	 * @return the user library, or <code>null</code> if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserLibrary userLibrary = (UserLibrary)EntityCacheUtil.getResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
				UserLibraryImpl.class, primaryKey);

		if (userLibrary == _nullUserLibrary) {
			return null;
		}

		if (userLibrary == null) {
			Session session = null;

			try {
				session = openSession();

				userLibrary = (UserLibrary)session.get(UserLibraryImpl.class,
						primaryKey);

				if (userLibrary != null) {
					cacheResult(userLibrary);
				}
				else {
					EntityCacheUtil.putResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
						UserLibraryImpl.class, primaryKey, _nullUserLibrary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserLibraryModelImpl.ENTITY_CACHE_ENABLED,
					UserLibraryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userLibrary;
	}

	/**
	 * Returns the user library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userLibraryId the primary key of the user library
	 * @return the user library, or <code>null</code> if a user library with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserLibrary fetchByPrimaryKey(long userLibraryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userLibraryId);
	}

	/**
	 * Returns all the user libraries.
	 *
	 * @return the user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user libraries
	 * @param end the upper bound of the range of user libraries (not inclusive)
	 * @return the range of user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user libraries
	 * @param end the upper bound of the range of user libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user libraries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserLibrary> findAll(int start, int end,
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

		List<UserLibrary> list = (List<UserLibrary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERLIBRARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERLIBRARY;

				if (pagination) {
					sql = sql.concat(UserLibraryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserLibrary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserLibrary>(list);
				}
				else {
					list = (List<UserLibrary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user libraries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserLibrary userLibrary : findAll()) {
			remove(userLibrary);
		}
	}

	/**
	 * Returns the number of user libraries.
	 *
	 * @return the number of user libraries
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

				Query q = session.createQuery(_SQL_COUNT_USERLIBRARY);

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
	 * Initializes the user library persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.UserLibrary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserLibrary>> listenersList = new ArrayList<ModelListener<UserLibrary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserLibrary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserLibraryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERLIBRARY = "SELECT userLibrary FROM UserLibrary userLibrary";
	private static final String _SQL_SELECT_USERLIBRARY_WHERE = "SELECT userLibrary FROM UserLibrary userLibrary WHERE ";
	private static final String _SQL_COUNT_USERLIBRARY = "SELECT COUNT(userLibrary) FROM UserLibrary userLibrary";
	private static final String _SQL_COUNT_USERLIBRARY_WHERE = "SELECT COUNT(userLibrary) FROM UserLibrary userLibrary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userLibrary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserLibrary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserLibrary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserLibraryPersistenceImpl.class);
	private static UserLibrary _nullUserLibrary = new UserLibraryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserLibrary> toCacheModel() {
				return _nullUserLibraryCacheModel;
			}
		};

	private static CacheModel<UserLibrary> _nullUserLibraryCacheModel = new CacheModel<UserLibrary>() {
			@Override
			public UserLibrary toEntityModel() {
				return _nullUserLibrary;
			}
		};
}
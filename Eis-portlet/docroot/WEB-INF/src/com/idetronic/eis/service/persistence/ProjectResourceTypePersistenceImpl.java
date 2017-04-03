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

import com.idetronic.eis.NoSuchProjectResourceTypeException;
import com.idetronic.eis.model.ProjectResourceType;
import com.idetronic.eis.model.impl.ProjectResourceTypeImpl;
import com.idetronic.eis.model.impl.ProjectResourceTypeModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the project resource type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResourceTypePersistence
 * @see ProjectResourceTypeUtil
 * @generated
 */
public class ProjectResourceTypePersistenceImpl extends BasePersistenceImpl<ProjectResourceType>
	implements ProjectResourceTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectResourceTypeUtil} to access the project resource type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectResourceTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceTypeModelImpl.FINDER_CACHE_ENABLED,
			ProjectResourceTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceTypeModelImpl.FINDER_CACHE_ENABLED,
			ProjectResourceTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectResourceTypePersistenceImpl() {
		setModelClass(ProjectResourceType.class);
	}

	/**
	 * Caches the project resource type in the entity cache if it is enabled.
	 *
	 * @param projectResourceType the project resource type
	 */
	@Override
	public void cacheResult(ProjectResourceType projectResourceType) {
		EntityCacheUtil.putResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceTypeImpl.class, projectResourceType.getPrimaryKey(),
			projectResourceType);

		projectResourceType.resetOriginalValues();
	}

	/**
	 * Caches the project resource types in the entity cache if it is enabled.
	 *
	 * @param projectResourceTypes the project resource types
	 */
	@Override
	public void cacheResult(List<ProjectResourceType> projectResourceTypes) {
		for (ProjectResourceType projectResourceType : projectResourceTypes) {
			if (EntityCacheUtil.getResult(
						ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
						ProjectResourceTypeImpl.class,
						projectResourceType.getPrimaryKey()) == null) {
				cacheResult(projectResourceType);
			}
			else {
				projectResourceType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project resource types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProjectResourceTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProjectResourceTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project resource type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectResourceType projectResourceType) {
		EntityCacheUtil.removeResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceTypeImpl.class, projectResourceType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectResourceType> projectResourceTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectResourceType projectResourceType : projectResourceTypes) {
			EntityCacheUtil.removeResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
				ProjectResourceTypeImpl.class,
				projectResourceType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project resource type with the primary key. Does not add the project resource type to the database.
	 *
	 * @param projectResourceTypeId the primary key for the new project resource type
	 * @return the new project resource type
	 */
	@Override
	public ProjectResourceType create(long projectResourceTypeId) {
		ProjectResourceType projectResourceType = new ProjectResourceTypeImpl();

		projectResourceType.setNew(true);
		projectResourceType.setPrimaryKey(projectResourceTypeId);

		return projectResourceType;
	}

	/**
	 * Removes the project resource type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectResourceTypeId the primary key of the project resource type
	 * @return the project resource type that was removed
	 * @throws com.idetronic.eis.NoSuchProjectResourceTypeException if a project resource type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResourceType remove(long projectResourceTypeId)
		throws NoSuchProjectResourceTypeException, SystemException {
		return remove((Serializable)projectResourceTypeId);
	}

	/**
	 * Removes the project resource type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project resource type
	 * @return the project resource type that was removed
	 * @throws com.idetronic.eis.NoSuchProjectResourceTypeException if a project resource type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResourceType remove(Serializable primaryKey)
		throws NoSuchProjectResourceTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProjectResourceType projectResourceType = (ProjectResourceType)session.get(ProjectResourceTypeImpl.class,
					primaryKey);

			if (projectResourceType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectResourceTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectResourceType);
		}
		catch (NoSuchProjectResourceTypeException nsee) {
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
	protected ProjectResourceType removeImpl(
		ProjectResourceType projectResourceType) throws SystemException {
		projectResourceType = toUnwrappedModel(projectResourceType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectResourceType)) {
				projectResourceType = (ProjectResourceType)session.get(ProjectResourceTypeImpl.class,
						projectResourceType.getPrimaryKeyObj());
			}

			if (projectResourceType != null) {
				session.delete(projectResourceType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectResourceType != null) {
			clearCache(projectResourceType);
		}

		return projectResourceType;
	}

	@Override
	public ProjectResourceType updateImpl(
		com.idetronic.eis.model.ProjectResourceType projectResourceType)
		throws SystemException {
		projectResourceType = toUnwrappedModel(projectResourceType);

		boolean isNew = projectResourceType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectResourceType.isNew()) {
				session.save(projectResourceType);

				projectResourceType.setNew(false);
			}
			else {
				session.merge(projectResourceType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceTypeImpl.class, projectResourceType.getPrimaryKey(),
			projectResourceType);

		return projectResourceType;
	}

	protected ProjectResourceType toUnwrappedModel(
		ProjectResourceType projectResourceType) {
		if (projectResourceType instanceof ProjectResourceTypeImpl) {
			return projectResourceType;
		}

		ProjectResourceTypeImpl projectResourceTypeImpl = new ProjectResourceTypeImpl();

		projectResourceTypeImpl.setNew(projectResourceType.isNew());
		projectResourceTypeImpl.setPrimaryKey(projectResourceType.getPrimaryKey());

		projectResourceTypeImpl.setProjectResourceTypeId(projectResourceType.getProjectResourceTypeId());
		projectResourceTypeImpl.setResourceTypeName(projectResourceType.getResourceTypeName());
		projectResourceTypeImpl.setGroupId(projectResourceType.getGroupId());
		projectResourceTypeImpl.setCompanyId(projectResourceType.getCompanyId());
		projectResourceTypeImpl.setUserId(projectResourceType.getUserId());
		projectResourceTypeImpl.setUserName(projectResourceType.getUserName());
		projectResourceTypeImpl.setCreateDate(projectResourceType.getCreateDate());
		projectResourceTypeImpl.setModifiedDate(projectResourceType.getModifiedDate());

		return projectResourceTypeImpl;
	}

	/**
	 * Returns the project resource type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project resource type
	 * @return the project resource type
	 * @throws com.idetronic.eis.NoSuchProjectResourceTypeException if a project resource type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResourceType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectResourceTypeException, SystemException {
		ProjectResourceType projectResourceType = fetchByPrimaryKey(primaryKey);

		if (projectResourceType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectResourceTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectResourceType;
	}

	/**
	 * Returns the project resource type with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectResourceTypeException} if it could not be found.
	 *
	 * @param projectResourceTypeId the primary key of the project resource type
	 * @return the project resource type
	 * @throws com.idetronic.eis.NoSuchProjectResourceTypeException if a project resource type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResourceType findByPrimaryKey(long projectResourceTypeId)
		throws NoSuchProjectResourceTypeException, SystemException {
		return findByPrimaryKey((Serializable)projectResourceTypeId);
	}

	/**
	 * Returns the project resource type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project resource type
	 * @return the project resource type, or <code>null</code> if a project resource type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResourceType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProjectResourceType projectResourceType = (ProjectResourceType)EntityCacheUtil.getResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
				ProjectResourceTypeImpl.class, primaryKey);

		if (projectResourceType == _nullProjectResourceType) {
			return null;
		}

		if (projectResourceType == null) {
			Session session = null;

			try {
				session = openSession();

				projectResourceType = (ProjectResourceType)session.get(ProjectResourceTypeImpl.class,
						primaryKey);

				if (projectResourceType != null) {
					cacheResult(projectResourceType);
				}
				else {
					EntityCacheUtil.putResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
						ProjectResourceTypeImpl.class, primaryKey,
						_nullProjectResourceType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProjectResourceTypeModelImpl.ENTITY_CACHE_ENABLED,
					ProjectResourceTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectResourceType;
	}

	/**
	 * Returns the project resource type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectResourceTypeId the primary key of the project resource type
	 * @return the project resource type, or <code>null</code> if a project resource type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResourceType fetchByPrimaryKey(long projectResourceTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)projectResourceTypeId);
	}

	/**
	 * Returns all the project resource types.
	 *
	 * @return the project resource types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectResourceType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project resource types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resource types
	 * @param end the upper bound of the range of project resource types (not inclusive)
	 * @return the range of project resource types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectResourceType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project resource types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resource types
	 * @param end the upper bound of the range of project resource types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project resource types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectResourceType> findAll(int start, int end,
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

		List<ProjectResourceType> list = (List<ProjectResourceType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECTRESOURCETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTRESOURCETYPE;

				if (pagination) {
					sql = sql.concat(ProjectResourceTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectResourceType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectResourceType>(list);
				}
				else {
					list = (List<ProjectResourceType>)QueryUtil.list(q,
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
	 * Removes all the project resource types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProjectResourceType projectResourceType : findAll()) {
			remove(projectResourceType);
		}
	}

	/**
	 * Returns the number of project resource types.
	 *
	 * @return the number of project resource types
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

				Query q = session.createQuery(_SQL_COUNT_PROJECTRESOURCETYPE);

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
	 * Initializes the project resource type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.ProjectResourceType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProjectResourceType>> listenersList = new ArrayList<ModelListener<ProjectResourceType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProjectResourceType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProjectResourceTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECTRESOURCETYPE = "SELECT projectResourceType FROM ProjectResourceType projectResourceType";
	private static final String _SQL_COUNT_PROJECTRESOURCETYPE = "SELECT COUNT(projectResourceType) FROM ProjectResourceType projectResourceType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectResourceType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectResourceType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProjectResourceTypePersistenceImpl.class);
	private static ProjectResourceType _nullProjectResourceType = new ProjectResourceTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProjectResourceType> toCacheModel() {
				return _nullProjectResourceTypeCacheModel;
			}
		};

	private static CacheModel<ProjectResourceType> _nullProjectResourceTypeCacheModel =
		new CacheModel<ProjectResourceType>() {
			@Override
			public ProjectResourceType toEntityModel() {
				return _nullProjectResourceType;
			}
		};
}
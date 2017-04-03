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

import com.idetronic.eis.NoSuchProjectResourceException;
import com.idetronic.eis.model.ProjectResource;
import com.idetronic.eis.model.impl.ProjectResourceImpl;
import com.idetronic.eis.model.impl.ProjectResourceModelImpl;

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
 * The persistence implementation for the project resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ProjectResourcePersistence
 * @see ProjectResourceUtil
 * @generated
 */
public class ProjectResourcePersistenceImpl extends BasePersistenceImpl<ProjectResource>
	implements ProjectResourcePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectResourceUtil} to access the project resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectResourceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceModelImpl.FINDER_CACHE_ENABLED,
			ProjectResourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceModelImpl.FINDER_CACHE_ENABLED,
			ProjectResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectResourcePersistenceImpl() {
		setModelClass(ProjectResource.class);
	}

	/**
	 * Caches the project resource in the entity cache if it is enabled.
	 *
	 * @param projectResource the project resource
	 */
	@Override
	public void cacheResult(ProjectResource projectResource) {
		EntityCacheUtil.putResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceImpl.class, projectResource.getPrimaryKey(),
			projectResource);

		projectResource.resetOriginalValues();
	}

	/**
	 * Caches the project resources in the entity cache if it is enabled.
	 *
	 * @param projectResources the project resources
	 */
	@Override
	public void cacheResult(List<ProjectResource> projectResources) {
		for (ProjectResource projectResource : projectResources) {
			if (EntityCacheUtil.getResult(
						ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
						ProjectResourceImpl.class,
						projectResource.getPrimaryKey()) == null) {
				cacheResult(projectResource);
			}
			else {
				projectResource.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project resources.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProjectResourceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProjectResourceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project resource.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectResource projectResource) {
		EntityCacheUtil.removeResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceImpl.class, projectResource.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectResource> projectResources) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectResource projectResource : projectResources) {
			EntityCacheUtil.removeResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
				ProjectResourceImpl.class, projectResource.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project resource with the primary key. Does not add the project resource to the database.
	 *
	 * @param projectResourceId the primary key for the new project resource
	 * @return the new project resource
	 */
	@Override
	public ProjectResource create(long projectResourceId) {
		ProjectResource projectResource = new ProjectResourceImpl();

		projectResource.setNew(true);
		projectResource.setPrimaryKey(projectResourceId);

		return projectResource;
	}

	/**
	 * Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws com.idetronic.eis.NoSuchProjectResourceException if a project resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResource remove(long projectResourceId)
		throws NoSuchProjectResourceException, SystemException {
		return remove((Serializable)projectResourceId);
	}

	/**
	 * Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws com.idetronic.eis.NoSuchProjectResourceException if a project resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResource remove(Serializable primaryKey)
		throws NoSuchProjectResourceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProjectResource projectResource = (ProjectResource)session.get(ProjectResourceImpl.class,
					primaryKey);

			if (projectResource == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectResource);
		}
		catch (NoSuchProjectResourceException nsee) {
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
	protected ProjectResource removeImpl(ProjectResource projectResource)
		throws SystemException {
		projectResource = toUnwrappedModel(projectResource);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectResource)) {
				projectResource = (ProjectResource)session.get(ProjectResourceImpl.class,
						projectResource.getPrimaryKeyObj());
			}

			if (projectResource != null) {
				session.delete(projectResource);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectResource != null) {
			clearCache(projectResource);
		}

		return projectResource;
	}

	@Override
	public ProjectResource updateImpl(
		com.idetronic.eis.model.ProjectResource projectResource)
		throws SystemException {
		projectResource = toUnwrappedModel(projectResource);

		boolean isNew = projectResource.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectResource.isNew()) {
				session.save(projectResource);

				projectResource.setNew(false);
			}
			else {
				session.merge(projectResource);
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

		EntityCacheUtil.putResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
			ProjectResourceImpl.class, projectResource.getPrimaryKey(),
			projectResource);

		return projectResource;
	}

	protected ProjectResource toUnwrappedModel(ProjectResource projectResource) {
		if (projectResource instanceof ProjectResourceImpl) {
			return projectResource;
		}

		ProjectResourceImpl projectResourceImpl = new ProjectResourceImpl();

		projectResourceImpl.setNew(projectResource.isNew());
		projectResourceImpl.setPrimaryKey(projectResource.getPrimaryKey());

		projectResourceImpl.setProjectResourceId(projectResource.getProjectResourceId());
		projectResourceImpl.setGroupId(projectResource.getGroupId());
		projectResourceImpl.setCompanyId(projectResource.getCompanyId());
		projectResourceImpl.setUserId(projectResource.getUserId());
		projectResourceImpl.setUserName(projectResource.getUserName());
		projectResourceImpl.setCreateDate(projectResource.getCreateDate());
		projectResourceImpl.setModifiedDate(projectResource.getModifiedDate());
		projectResourceImpl.setResourceName(projectResource.getResourceName());

		return projectResourceImpl;
	}

	/**
	 * Returns the project resource with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project resource
	 * @return the project resource
	 * @throws com.idetronic.eis.NoSuchProjectResourceException if a project resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectResourceException, SystemException {
		ProjectResource projectResource = fetchByPrimaryKey(primaryKey);

		if (projectResource == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectResource;
	}

	/**
	 * Returns the project resource with the primary key or throws a {@link com.idetronic.eis.NoSuchProjectResourceException} if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource
	 * @throws com.idetronic.eis.NoSuchProjectResourceException if a project resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResource findByPrimaryKey(long projectResourceId)
		throws NoSuchProjectResourceException, SystemException {
		return findByPrimaryKey((Serializable)projectResourceId);
	}

	/**
	 * Returns the project resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project resource
	 * @return the project resource, or <code>null</code> if a project resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResource fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProjectResource projectResource = (ProjectResource)EntityCacheUtil.getResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
				ProjectResourceImpl.class, primaryKey);

		if (projectResource == _nullProjectResource) {
			return null;
		}

		if (projectResource == null) {
			Session session = null;

			try {
				session = openSession();

				projectResource = (ProjectResource)session.get(ProjectResourceImpl.class,
						primaryKey);

				if (projectResource != null) {
					cacheResult(projectResource);
				}
				else {
					EntityCacheUtil.putResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
						ProjectResourceImpl.class, primaryKey,
						_nullProjectResource);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProjectResourceModelImpl.ENTITY_CACHE_ENABLED,
					ProjectResourceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectResource;
	}

	/**
	 * Returns the project resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource, or <code>null</code> if a project resource with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectResource fetchByPrimaryKey(long projectResourceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)projectResourceId);
	}

	/**
	 * Returns all the project resources.
	 *
	 * @return the project resources
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectResource> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @return the range of project resources
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectResource> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project resources
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectResource> findAll(int start, int end,
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

		List<ProjectResource> list = (List<ProjectResource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECTRESOURCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTRESOURCE;

				if (pagination) {
					sql = sql.concat(ProjectResourceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectResource>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectResource>(list);
				}
				else {
					list = (List<ProjectResource>)QueryUtil.list(q,
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
	 * Removes all the project resources from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProjectResource projectResource : findAll()) {
			remove(projectResource);
		}
	}

	/**
	 * Returns the number of project resources.
	 *
	 * @return the number of project resources
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

				Query q = session.createQuery(_SQL_COUNT_PROJECTRESOURCE);

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
	 * Initializes the project resource persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.eis.model.ProjectResource")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProjectResource>> listenersList = new ArrayList<ModelListener<ProjectResource>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProjectResource>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProjectResourceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECTRESOURCE = "SELECT projectResource FROM ProjectResource projectResource";
	private static final String _SQL_COUNT_PROJECTRESOURCE = "SELECT COUNT(projectResource) FROM ProjectResource projectResource";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectResource.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectResource exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProjectResourcePersistenceImpl.class);
	private static ProjectResource _nullProjectResource = new ProjectResourceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProjectResource> toCacheModel() {
				return _nullProjectResourceCacheModel;
			}
		};

	private static CacheModel<ProjectResource> _nullProjectResourceCacheModel = new CacheModel<ProjectResource>() {
			@Override
			public ProjectResource toEntityModel() {
				return _nullProjectResource;
			}
		};
}
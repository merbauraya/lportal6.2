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

package com.idetronic.eis.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectStrategyLocalService}.
 *
 * @author Mazlan Mat
 * @see ProjectStrategyLocalService
 * @generated
 */
public class ProjectStrategyLocalServiceWrapper
	implements ProjectStrategyLocalService,
		ServiceWrapper<ProjectStrategyLocalService> {
	public ProjectStrategyLocalServiceWrapper(
		ProjectStrategyLocalService projectStrategyLocalService) {
		_projectStrategyLocalService = projectStrategyLocalService;
	}

	/**
	* Adds the project strategy to the database. Also notifies the appropriate model listeners.
	*
	* @param projectStrategy the project strategy
	* @return the project strategy that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectStrategy addProjectStrategy(
		com.idetronic.eis.model.ProjectStrategy projectStrategy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.addProjectStrategy(projectStrategy);
	}

	/**
	* Creates a new project strategy with the primary key. Does not add the project strategy to the database.
	*
	* @param projectStrategyId the primary key for the new project strategy
	* @return the new project strategy
	*/
	@Override
	public com.idetronic.eis.model.ProjectStrategy createProjectStrategy(
		long projectStrategyId) {
		return _projectStrategyLocalService.createProjectStrategy(projectStrategyId);
	}

	/**
	* Deletes the project strategy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectStrategyId the primary key of the project strategy
	* @return the project strategy that was removed
	* @throws PortalException if a project strategy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectStrategy deleteProjectStrategy(
		long projectStrategyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.deleteProjectStrategy(projectStrategyId);
	}

	/**
	* Deletes the project strategy from the database. Also notifies the appropriate model listeners.
	*
	* @param projectStrategy the project strategy
	* @return the project strategy that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectStrategy deleteProjectStrategy(
		com.idetronic.eis.model.ProjectStrategy projectStrategy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.deleteProjectStrategy(projectStrategy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectStrategyLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.ProjectStrategy fetchProjectStrategy(
		long projectStrategyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.fetchProjectStrategy(projectStrategyId);
	}

	/**
	* Returns the project strategy with the primary key.
	*
	* @param projectStrategyId the primary key of the project strategy
	* @return the project strategy
	* @throws PortalException if a project strategy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectStrategy getProjectStrategy(
		long projectStrategyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.getProjectStrategy(projectStrategyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the project strategies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectStrategyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project strategies
	* @param end the upper bound of the range of project strategies (not inclusive)
	* @return the range of project strategies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> getProjectStrategies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.getProjectStrategies(start, end);
	}

	/**
	* Returns the number of project strategies.
	*
	* @return the number of project strategies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProjectStrategiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.getProjectStrategiesCount();
	}

	/**
	* Updates the project strategy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectStrategy the project strategy
	* @return the project strategy that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectStrategy updateProjectStrategy(
		com.idetronic.eis.model.ProjectStrategy projectStrategy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.updateProjectStrategy(projectStrategy);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _projectStrategyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_projectStrategyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _projectStrategyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.ProjectStrategy> getByProject(
		long projectId, int start, int end) {
		return _projectStrategyLocalService.getByProject(projectId, start, end);
	}

	@Override
	public com.idetronic.eis.model.ProjectStrategy add(long projectId,
		java.lang.String strategyName, java.util.Date startDate,
		java.util.Date endDate, int progressStatus, int status, int progress,
		java.lang.String resourceName, java.lang.String resourceType,
		java.util.Date completionDate, java.lang.String remark,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectStrategyLocalService.add(projectId, strategyName,
			startDate, endDate, progressStatus, status, progress, resourceName,
			resourceType, completionDate, remark, serviceContext);
	}

	/**
	* Delete strategy and all activities under it
	*
	* @param strategyId
	*/
	@Override
	public void deleteStrategyAll(long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectStrategyLocalService.deleteStrategyAll(strategyId);
	}

	/**
	* Remove all strategy by project
	*
	* @param projectId
	* @throws SystemException
	*/
	@Override
	public void deleteByProject(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectStrategyLocalService.deleteByProject(projectId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProjectStrategyLocalService getWrappedProjectStrategyLocalService() {
		return _projectStrategyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProjectStrategyLocalService(
		ProjectStrategyLocalService projectStrategyLocalService) {
		_projectStrategyLocalService = projectStrategyLocalService;
	}

	@Override
	public ProjectStrategyLocalService getWrappedService() {
		return _projectStrategyLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectStrategyLocalService projectStrategyLocalService) {
		_projectStrategyLocalService = projectStrategyLocalService;
	}

	private ProjectStrategyLocalService _projectStrategyLocalService;
}
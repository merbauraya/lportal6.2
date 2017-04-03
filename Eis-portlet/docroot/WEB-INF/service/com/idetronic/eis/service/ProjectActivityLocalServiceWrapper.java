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
 * Provides a wrapper for {@link ProjectActivityLocalService}.
 *
 * @author Mazlan Mat
 * @see ProjectActivityLocalService
 * @generated
 */
public class ProjectActivityLocalServiceWrapper
	implements ProjectActivityLocalService,
		ServiceWrapper<ProjectActivityLocalService> {
	public ProjectActivityLocalServiceWrapper(
		ProjectActivityLocalService projectActivityLocalService) {
		_projectActivityLocalService = projectActivityLocalService;
	}

	/**
	* Adds the project activity to the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivity the project activity
	* @return the project activity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectActivity addProjectActivity(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.addProjectActivity(projectActivity);
	}

	/**
	* Creates a new project activity with the primary key. Does not add the project activity to the database.
	*
	* @param projectActivityId the primary key for the new project activity
	* @return the new project activity
	*/
	@Override
	public com.idetronic.eis.model.ProjectActivity createProjectActivity(
		long projectActivityId) {
		return _projectActivityLocalService.createProjectActivity(projectActivityId);
	}

	/**
	* Deletes the project activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity that was removed
	* @throws PortalException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectActivity deleteProjectActivity(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.deleteProjectActivity(projectActivityId);
	}

	/**
	* Deletes the project activity from the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivity the project activity
	* @return the project activity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectActivity deleteProjectActivity(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.deleteProjectActivity(projectActivity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectActivityLocalService.dynamicQuery();
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
		return _projectActivityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectActivityLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectActivityLocalService.dynamicQuery(dynamicQuery, start,
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
		return _projectActivityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectActivityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.ProjectActivity fetchProjectActivity(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.fetchProjectActivity(projectActivityId);
	}

	/**
	* Returns the project activity with the primary key.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity
	* @throws PortalException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectActivity getProjectActivity(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.getProjectActivity(projectActivityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the project activities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ProjectActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project activities
	* @param end the upper bound of the range of project activities (not inclusive)
	* @return the range of project activities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.ProjectActivity> getProjectActivities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.getProjectActivities(start, end);
	}

	/**
	* Returns the number of project activities.
	*
	* @return the number of project activities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProjectActivitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.getProjectActivitiesCount();
	}

	/**
	* Updates the project activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectActivity the project activity
	* @return the project activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.ProjectActivity updateProjectActivity(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.updateProjectActivity(projectActivity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _projectActivityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_projectActivityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _projectActivityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.ProjectActivity add(long strategyId,
		java.lang.String activityName, java.util.Date startDate,
		java.util.Date endDate, int progressStatus, int status, int progress,
		java.lang.String resourceName, java.lang.String resourceType,
		java.util.Date completionDate, java.lang.String remark,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.add(strategyId, activityName,
			startDate, endDate, progressStatus, status, progress, resourceName,
			resourceType, completionDate, remark, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.ProjectActivity> getByStrategy(
		long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectActivityLocalService.getByStrategy(strategyId);
	}

	@Override
	public void deleteByStrategy(long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectActivityLocalService.deleteByStrategy(strategyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProjectActivityLocalService getWrappedProjectActivityLocalService() {
		return _projectActivityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProjectActivityLocalService(
		ProjectActivityLocalService projectActivityLocalService) {
		_projectActivityLocalService = projectActivityLocalService;
	}

	@Override
	public ProjectActivityLocalService getWrappedService() {
		return _projectActivityLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectActivityLocalService projectActivityLocalService) {
		_projectActivityLocalService = projectActivityLocalService;
	}

	private ProjectActivityLocalService _projectActivityLocalService;
}
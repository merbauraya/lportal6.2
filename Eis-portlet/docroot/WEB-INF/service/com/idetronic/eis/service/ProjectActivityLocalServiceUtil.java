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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ProjectActivity. This utility wraps
 * {@link com.idetronic.eis.service.impl.ProjectActivityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see ProjectActivityLocalService
 * @see com.idetronic.eis.service.base.ProjectActivityLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.ProjectActivityLocalServiceImpl
 * @generated
 */
public class ProjectActivityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.ProjectActivityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project activity to the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivity the project activity
	* @return the project activity that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ProjectActivity addProjectActivity(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProjectActivity(projectActivity);
	}

	/**
	* Creates a new project activity with the primary key. Does not add the project activity to the database.
	*
	* @param projectActivityId the primary key for the new project activity
	* @return the new project activity
	*/
	public static com.idetronic.eis.model.ProjectActivity createProjectActivity(
		long projectActivityId) {
		return getService().createProjectActivity(projectActivityId);
	}

	/**
	* Deletes the project activity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity that was removed
	* @throws PortalException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ProjectActivity deleteProjectActivity(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProjectActivity(projectActivityId);
	}

	/**
	* Deletes the project activity from the database. Also notifies the appropriate model listeners.
	*
	* @param projectActivity the project activity
	* @return the project activity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ProjectActivity deleteProjectActivity(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProjectActivity(projectActivity);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.eis.model.ProjectActivity fetchProjectActivity(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProjectActivity(projectActivityId);
	}

	/**
	* Returns the project activity with the primary key.
	*
	* @param projectActivityId the primary key of the project activity
	* @return the project activity
	* @throws PortalException if a project activity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ProjectActivity getProjectActivity(
		long projectActivityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectActivity(projectActivityId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.eis.model.ProjectActivity> getProjectActivities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectActivities(start, end);
	}

	/**
	* Returns the number of project activities.
	*
	* @return the number of project activities
	* @throws SystemException if a system exception occurred
	*/
	public static int getProjectActivitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectActivitiesCount();
	}

	/**
	* Updates the project activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectActivity the project activity
	* @return the project activity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.ProjectActivity updateProjectActivity(
		com.idetronic.eis.model.ProjectActivity projectActivity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProjectActivity(projectActivity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.idetronic.eis.model.ProjectActivity add(long strategyId,
		java.lang.String activityName, java.util.Date startDate,
		java.util.Date endDate, int progressStatus, int status, int progress,
		java.lang.String resourceName, java.lang.String resourceType,
		java.util.Date completionDate, java.lang.String remark,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .add(strategyId, activityName, startDate, endDate,
			progressStatus, status, progress, resourceName, resourceType,
			completionDate, remark, serviceContext);
	}

	public static java.util.List<com.idetronic.eis.model.ProjectActivity> getByStrategy(
		long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByStrategy(strategyId);
	}

	public static void deleteByStrategy(long strategyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByStrategy(strategyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProjectActivityLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProjectActivityLocalService.class.getName());

			if (invokableLocalService instanceof ProjectActivityLocalService) {
				_service = (ProjectActivityLocalService)invokableLocalService;
			}
			else {
				_service = new ProjectActivityLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProjectActivityLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ProjectActivityLocalService service) {
	}

	private static ProjectActivityLocalService _service;
}
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
 * Provides the local service utility for UserReport. This utility wraps
 * {@link com.idetronic.eis.service.impl.UserReportLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see UserReportLocalService
 * @see com.idetronic.eis.service.base.UserReportLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.UserReportLocalServiceImpl
 * @generated
 */
public class UserReportLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.UserReportLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user report to the database. Also notifies the appropriate model listeners.
	*
	* @param userReport the user report
	* @return the user report that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport addUserReport(
		com.idetronic.eis.model.UserReport userReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserReport(userReport);
	}

	/**
	* Creates a new user report with the primary key. Does not add the user report to the database.
	*
	* @param userReportId the primary key for the new user report
	* @return the new user report
	*/
	public static com.idetronic.eis.model.UserReport createUserReport(
		long userReportId) {
		return getService().createUserReport(userReportId);
	}

	/**
	* Deletes the user report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userReportId the primary key of the user report
	* @return the user report that was removed
	* @throws PortalException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport deleteUserReport(
		long userReportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserReport(userReportId);
	}

	/**
	* Deletes the user report from the database. Also notifies the appropriate model listeners.
	*
	* @param userReport the user report
	* @return the user report that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport deleteUserReport(
		com.idetronic.eis.model.UserReport userReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserReport(userReport);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.UserReport fetchUserReport(
		long userReportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserReport(userReportId);
	}

	/**
	* Returns the user report with the primary key.
	*
	* @param userReportId the primary key of the user report
	* @return the user report
	* @throws PortalException if a user report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport getUserReport(
		long userReportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserReport(userReportId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user reports
	* @param end the upper bound of the range of user reports (not inclusive)
	* @return the range of user reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.UserReport> getUserReports(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserReports(start, end);
	}

	/**
	* Returns the number of user reports.
	*
	* @return the number of user reports
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserReportsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserReportsCount();
	}

	/**
	* Updates the user report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userReport the user report
	* @return the user report that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserReport updateUserReport(
		com.idetronic.eis.model.UserReport userReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserReport(userReport);
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

	public static com.idetronic.eis.model.UserReport add(long userId,
		long libraryId, long dataId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().add(userId, libraryId, dataId, serviceContext);
	}

	public static void add(long userId, long libraryId, long[] dataIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().add(userId, libraryId, dataIds, serviceContext);
	}

	public static com.idetronic.eis.model.UserReport findyUserData(
		long userId, long libraryId, long dataId)
		throws com.idetronic.eis.NoSuchUserReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findyUserData(userId, libraryId, dataId);
	}

	public static void updateAssociationByUser(long userId, long libraryId,
		long[] addDataIds, long[] removeDataIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.updateAssociationByUser(userId, libraryId, addDataIds,
			removeDataIds, serviceContext);
	}

	public static java.util.List<com.idetronic.eis.model.UserReport> findByUserLibrary(
		long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserLibrary(userId, libraryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserReportLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserReportLocalService.class.getName());

			if (invokableLocalService instanceof UserReportLocalService) {
				_service = (UserReportLocalService)invokableLocalService;
			}
			else {
				_service = new UserReportLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserReportLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserReportLocalService service) {
	}

	private static UserReportLocalService _service;
}
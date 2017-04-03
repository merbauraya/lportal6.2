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

package com.idetronic.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserImportLog. This utility wraps
 * {@link com.idetronic.portlet.service.impl.UserImportLogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see UserImportLogLocalService
 * @see com.idetronic.portlet.service.base.UserImportLogLocalServiceBaseImpl
 * @see com.idetronic.portlet.service.impl.UserImportLogLocalServiceImpl
 * @generated
 */
public class UserImportLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.portlet.service.impl.UserImportLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user import log to the database. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @return the user import log that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog addUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserImportLog(userImportLog);
	}

	/**
	* Creates a new user import log with the primary key. Does not add the user import log to the database.
	*
	* @param entryId the primary key for the new user import log
	* @return the new user import log
	*/
	public static com.idetronic.portlet.model.UserImportLog createUserImportLog(
		long entryId) {
		return getService().createUserImportLog(entryId);
	}

	/**
	* Deletes the user import log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log that was removed
	* @throws PortalException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog deleteUserImportLog(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserImportLog(entryId);
	}

	/**
	* Deletes the user import log from the database. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @return the user import log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog deleteUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserImportLog(userImportLog);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.portlet.model.UserImportLog fetchUserImportLog(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserImportLog(entryId);
	}

	/**
	* Returns the user import log with the primary key.
	*
	* @param entryId the primary key of the user import log
	* @return the user import log
	* @throws PortalException if a user import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog getUserImportLog(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserImportLog(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user import logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.portlet.model.impl.UserImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user import logs
	* @param end the upper bound of the range of user import logs (not inclusive)
	* @return the range of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.portlet.model.UserImportLog> getUserImportLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserImportLogs(start, end);
	}

	/**
	* Returns the number of user import logs.
	*
	* @return the number of user import logs
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserImportLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserImportLogsCount();
	}

	/**
	* Updates the user import log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userImportLog the user import log
	* @return the user import log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.portlet.model.UserImportLog updateUserImportLog(
		com.idetronic.portlet.model.UserImportLog userImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserImportLog(userImportLog);
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

	public static void clearService() {
		_service = null;
	}

	public static UserImportLogLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserImportLogLocalService.class.getName());

			if (invokableLocalService instanceof UserImportLogLocalService) {
				_service = (UserImportLogLocalService)invokableLocalService;
			}
			else {
				_service = new UserImportLogLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserImportLogLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserImportLogLocalService service) {
	}

	private static UserImportLogLocalService _service;
}
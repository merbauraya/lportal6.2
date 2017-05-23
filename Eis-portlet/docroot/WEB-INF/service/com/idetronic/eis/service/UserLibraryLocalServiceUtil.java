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
 * Provides the local service utility for UserLibrary. This utility wraps
 * {@link com.idetronic.eis.service.impl.UserLibraryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see UserLibraryLocalService
 * @see com.idetronic.eis.service.base.UserLibraryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.UserLibraryLocalServiceImpl
 * @generated
 */
public class UserLibraryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.UserLibraryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user library to the database. Also notifies the appropriate model listeners.
	*
	* @param userLibrary the user library
	* @return the user library that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary addUserLibrary(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserLibrary(userLibrary);
	}

	/**
	* Creates a new user library with the primary key. Does not add the user library to the database.
	*
	* @param userLibraryId the primary key for the new user library
	* @return the new user library
	*/
	public static com.idetronic.eis.model.UserLibrary createUserLibrary(
		long userLibraryId) {
		return getService().createUserLibrary(userLibraryId);
	}

	/**
	* Deletes the user library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library that was removed
	* @throws PortalException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary deleteUserLibrary(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserLibrary(userLibraryId);
	}

	/**
	* Deletes the user library from the database. Also notifies the appropriate model listeners.
	*
	* @param userLibrary the user library
	* @return the user library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary deleteUserLibrary(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserLibrary(userLibrary);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.UserLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.UserLibrary fetchUserLibrary(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserLibrary(userLibraryId);
	}

	/**
	* Returns the user library with the primary key.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library
	* @throws PortalException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary getUserLibrary(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserLibrary(userLibraryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.eis.model.UserLibrary> getUserLibraries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserLibraries(start, end);
	}

	/**
	* Returns the number of user libraries.
	*
	* @return the number of user libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserLibrariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserLibrariesCount();
	}

	/**
	* Updates the user library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userLibrary the user library
	* @return the user library that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.UserLibrary updateUserLibrary(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserLibrary(userLibrary);
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

	public static com.idetronic.eis.model.UserLibrary add(long userId,
		long libraryId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().add(userId, libraryId, serviceContext);
	}

	public static void add(long libraryId, long[] userIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().add(libraryId, userIds, serviceContext);
	}

	public static void remove(long userId, long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().remove(userId, libraryId);
	}

	public static java.util.List<com.idetronic.eis.model.UserLibrary> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLibrary(libraryId, start, end);
	}

	public static java.util.List<com.idetronic.eis.model.UserLibrary> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUser(userId, start, end);
	}

	public static boolean hasAssociation(long libraryId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasAssociation(libraryId, userId);
	}

	public static void updateAssociationByUser(long userId,
		long[] addLibraryIds, long[] removeLibraryIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.updateAssociationByUser(userId, addLibraryIds, removeLibraryIds,
			serviceContext);
	}

	public static void updateAssociation(long libraryId, long[] addUserIds,
		long[] removeUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.updateAssociation(libraryId, addUserIds, removeUserId,
			serviceContext);
	}

	public static int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByLibrary(libraryId);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getLibraryByUser2(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLibraryByUser2(userId);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getLibraryByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLibraryByUser(userId);
	}

	public static java.util.List<com.liferay.portal.model.User> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLibrary(libraryId);
	}

	public static java.util.List<java.lang.Object> getDistinctUser()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDistinctUser();
	}

	public static void clearService() {
		_service = null;
	}

	public static UserLibraryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserLibraryLocalService.class.getName());

			if (invokableLocalService instanceof UserLibraryLocalService) {
				_service = (UserLibraryLocalService)invokableLocalService;
			}
			else {
				_service = new UserLibraryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserLibraryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserLibraryLocalService service) {
	}

	private static UserLibraryLocalService _service;
}
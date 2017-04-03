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
 * Provides a wrapper for {@link UserLibraryLocalService}.
 *
 * @author Mazlan Mat
 * @see UserLibraryLocalService
 * @generated
 */
public class UserLibraryLocalServiceWrapper implements UserLibraryLocalService,
	ServiceWrapper<UserLibraryLocalService> {
	public UserLibraryLocalServiceWrapper(
		UserLibraryLocalService userLibraryLocalService) {
		_userLibraryLocalService = userLibraryLocalService;
	}

	/**
	* Adds the user library to the database. Also notifies the appropriate model listeners.
	*
	* @param userLibrary the user library
	* @return the user library that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.UserLibrary addUserLibrary(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.addUserLibrary(userLibrary);
	}

	/**
	* Creates a new user library with the primary key. Does not add the user library to the database.
	*
	* @param userLibraryId the primary key for the new user library
	* @return the new user library
	*/
	@Override
	public com.idetronic.eis.model.UserLibrary createUserLibrary(
		long userLibraryId) {
		return _userLibraryLocalService.createUserLibrary(userLibraryId);
	}

	/**
	* Deletes the user library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library that was removed
	* @throws PortalException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.UserLibrary deleteUserLibrary(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.deleteUserLibrary(userLibraryId);
	}

	/**
	* Deletes the user library from the database. Also notifies the appropriate model listeners.
	*
	* @param userLibrary the user library
	* @return the user library that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.UserLibrary deleteUserLibrary(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.deleteUserLibrary(userLibrary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userLibraryLocalService.dynamicQuery();
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
		return _userLibraryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _userLibraryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userLibraryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.UserLibrary fetchUserLibrary(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.fetchUserLibrary(userLibraryId);
	}

	/**
	* Returns the user library with the primary key.
	*
	* @param userLibraryId the primary key of the user library
	* @return the user library
	* @throws PortalException if a user library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.UserLibrary getUserLibrary(
		long userLibraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.getUserLibrary(userLibraryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.idetronic.eis.model.UserLibrary> getUserLibraries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.getUserLibraries(start, end);
	}

	/**
	* Returns the number of user libraries.
	*
	* @return the number of user libraries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserLibrariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.getUserLibrariesCount();
	}

	/**
	* Updates the user library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userLibrary the user library
	* @return the user library that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.UserLibrary updateUserLibrary(
		com.idetronic.eis.model.UserLibrary userLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.updateUserLibrary(userLibrary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userLibraryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userLibraryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userLibraryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.UserLibrary add(long userId, long libraryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.add(userId, libraryId, serviceContext);
	}

	@Override
	public void add(long libraryId, long[] userIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userLibraryLocalService.add(libraryId, userIds, serviceContext);
	}

	@Override
	public void remove(long userId, long libraryId)
		throws com.idetronic.eis.NoSuchUserLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		_userLibraryLocalService.remove(userId, libraryId);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.UserLibrary> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.findByLibrary(libraryId, start, end);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.UserLibrary> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.findByUser(userId, start, end);
	}

	@Override
	public boolean hasAssociation(long libraryId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.hasAssociation(libraryId, userId);
	}

	@Override
	public void updateAssociation(long libraryId, long[] addUserIds,
		long[] removeUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userLibraryLocalService.updateAssociation(libraryId, addUserIds,
			removeUserId, serviceContext);
	}

	@Override
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.countByLibrary(libraryId);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.Library> getLibraryByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.getLibraryByUser(userId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userLibraryLocalService.findByLibrary(libraryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserLibraryLocalService getWrappedUserLibraryLocalService() {
		return _userLibraryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserLibraryLocalService(
		UserLibraryLocalService userLibraryLocalService) {
		_userLibraryLocalService = userLibraryLocalService;
	}

	@Override
	public UserLibraryLocalService getWrappedService() {
		return _userLibraryLocalService;
	}

	@Override
	public void setWrappedService(
		UserLibraryLocalService userLibraryLocalService) {
		_userLibraryLocalService = userLibraryLocalService;
	}

	private UserLibraryLocalService _userLibraryLocalService;
}
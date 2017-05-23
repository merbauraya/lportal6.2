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
 * Provides the local service utility for Library. This utility wraps
 * {@link com.idetronic.eis.service.impl.LibraryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see LibraryLocalService
 * @see com.idetronic.eis.service.base.LibraryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.LibraryLocalServiceImpl
 * @generated
 */
public class LibraryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.LibraryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the library to the database. Also notifies the appropriate model listeners.
	*
	* @param library the library
	* @return the library that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library addLibrary(
		com.idetronic.eis.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLibrary(library);
	}

	/**
	* Creates a new library with the primary key. Does not add the library to the database.
	*
	* @param libraryId the primary key for the new library
	* @return the new library
	*/
	public static com.idetronic.eis.model.Library createLibrary(long libraryId) {
		return getService().createLibrary(libraryId);
	}

	/**
	* Deletes the library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param libraryId the primary key of the library
	* @return the library that was removed
	* @throws PortalException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library deleteLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLibrary(libraryId);
	}

	/**
	* Deletes the library from the database. Also notifies the appropriate model listeners.
	*
	* @param library the library
	* @return the library that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library deleteLibrary(
		com.idetronic.eis.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLibrary(library);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.Library fetchLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLibrary(libraryId);
	}

	/**
	* Returns the library with the primary key.
	*
	* @param libraryId the primary key of the library
	* @return the library
	* @throws PortalException if a library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library getLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLibrary(libraryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.LibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of libraries
	* @param end the upper bound of the range of libraries (not inclusive)
	* @return the range of libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Library> getLibraries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLibraries(start, end);
	}

	/**
	* Returns the number of libraries.
	*
	* @return the number of libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int getLibrariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLibrariesCount();
	}

	/**
	* Updates the library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param library the library
	* @return the library that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Library updateLibrary(
		com.idetronic.eis.model.Library library)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLibrary(library);
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

	public static com.idetronic.eis.model.Library add(long libraryTypeId,
		java.lang.String libraryCode, java.lang.String name, long stateId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .add(libraryTypeId, libraryCode, name, stateId,
			serviceContext);
	}

	public static java.util.List<com.idetronic.eis.model.Library> findByState(
		long stateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByState(stateId, start, end);
	}

	public static com.idetronic.eis.model.Library findByName(
		java.lang.String name)
		throws com.idetronic.eis.NoSuchLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByName(name);
	}

	public static boolean isMissingIRItemData(long libraryId,
		java.lang.String period) {
		return getService().isMissingIRItemData(libraryId, period);
	}

	public static boolean isMissingPrintedItemData(long libraryId,
		java.lang.String period) {
		return getService().isMissingPrintedItemData(libraryId, period);
	}

	public static boolean isMissingPositionData(long libraryId,
		java.lang.String period) {
		return getService().isMissingPositionData(libraryId, period);
	}

	public static boolean isMissingVisitorData(long libraryId,
		java.lang.String period) {
		return getService().isMissingVisitorData(libraryId, period);
	}

	public static boolean isMissingSeatingData(long libraryId,
		java.lang.String period) {
		return getService().isMissingSeatingData(libraryId, period);
	}

	public static boolean isMissingMembershipData(long libraryId,
		java.lang.String period) {
		return getService().isMissingMembershipData(libraryId, period);
	}

	public static boolean isMissingNonPrintedItemData(long libraryId,
		java.lang.String period) {
		return getService().isMissingNonPrintedItemData(libraryId, period);
	}

	public static boolean isMissingLoanData(long libraryId,
		java.lang.String period) {
		return getService().isMissingLoanData(libraryId, period);
	}

	public static boolean isMissingExpenseData(long libraryId,
		java.lang.String period) {
		return getService().isMissingExpenseData(libraryId, period);
	}

	public static boolean isMissingConsultationData(long libraryId,
		java.lang.String period) {
		return getService().isMissingConsultationData(libraryId, period);
	}

	public static void clearService() {
		_service = null;
	}

	public static LibraryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LibraryLocalService.class.getName());

			if (invokableLocalService instanceof LibraryLocalService) {
				_service = (LibraryLocalService)invokableLocalService;
			}
			else {
				_service = new LibraryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LibraryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LibraryLocalService service) {
	}

	private static LibraryLocalService _service;
}
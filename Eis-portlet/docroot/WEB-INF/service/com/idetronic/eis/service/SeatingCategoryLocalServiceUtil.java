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
 * Provides the local service utility for SeatingCategory. This utility wraps
 * {@link com.idetronic.eis.service.impl.SeatingCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see SeatingCategoryLocalService
 * @see com.idetronic.eis.service.base.SeatingCategoryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.SeatingCategoryLocalServiceImpl
 * @generated
 */
public class SeatingCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.SeatingCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the seating category to the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategory the seating category
	* @return the seating category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory addSeatingCategory(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSeatingCategory(seatingCategory);
	}

	/**
	* Creates a new seating category with the primary key. Does not add the seating category to the database.
	*
	* @param seatingCategoryId the primary key for the new seating category
	* @return the new seating category
	*/
	public static com.idetronic.eis.model.SeatingCategory createSeatingCategory(
		long seatingCategoryId) {
		return getService().createSeatingCategory(seatingCategoryId);
	}

	/**
	* Deletes the seating category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category that was removed
	* @throws PortalException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory deleteSeatingCategory(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeatingCategory(seatingCategoryId);
	}

	/**
	* Deletes the seating category from the database. Also notifies the appropriate model listeners.
	*
	* @param seatingCategory the seating category
	* @return the seating category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory deleteSeatingCategory(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeatingCategory(seatingCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.SeatingCategory fetchSeatingCategory(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSeatingCategory(seatingCategoryId);
	}

	/**
	* Returns the seating category with the primary key.
	*
	* @param seatingCategoryId the primary key of the seating category
	* @return the seating category
	* @throws PortalException if a seating category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory getSeatingCategory(
		long seatingCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeatingCategory(seatingCategoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the seating categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.SeatingCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seating categories
	* @param end the upper bound of the range of seating categories (not inclusive)
	* @return the range of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.SeatingCategory> getSeatingCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeatingCategories(start, end);
	}

	/**
	* Returns the number of seating categories.
	*
	* @return the number of seating categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getSeatingCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeatingCategoriesCount();
	}

	/**
	* Updates the seating category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param seatingCategory the seating category
	* @return the seating category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.SeatingCategory updateSeatingCategory(
		com.idetronic.eis.model.SeatingCategory seatingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSeatingCategory(seatingCategory);
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

	public static com.idetronic.eis.model.SeatingCategory add(
		long departmentId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().add(departmentId, name, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SeatingCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SeatingCategoryLocalService.class.getName());

			if (invokableLocalService instanceof SeatingCategoryLocalService) {
				_service = (SeatingCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new SeatingCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SeatingCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SeatingCategoryLocalService service) {
	}

	private static SeatingCategoryLocalService _service;
}
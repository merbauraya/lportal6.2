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
 * Provides the local service utility for FactInternationalPortalUsage. This utility wraps
 * {@link com.idetronic.eis.service.impl.FactInternationalPortalUsageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see FactInternationalPortalUsageLocalService
 * @see com.idetronic.eis.service.base.FactInternationalPortalUsageLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.FactInternationalPortalUsageLocalServiceImpl
 * @generated
 */
public class FactInternationalPortalUsageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.FactInternationalPortalUsageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fact international portal usage to the database. Also notifies the appropriate model listeners.
	*
	* @param factInternationalPortalUsage the fact international portal usage
	* @return the fact international portal usage that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactInternationalPortalUsage addFactInternationalPortalUsage(
		com.idetronic.eis.model.FactInternationalPortalUsage factInternationalPortalUsage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFactInternationalPortalUsage(factInternationalPortalUsage);
	}

	/**
	* Creates a new fact international portal usage with the primary key. Does not add the fact international portal usage to the database.
	*
	* @param factId the primary key for the new fact international portal usage
	* @return the new fact international portal usage
	*/
	public static com.idetronic.eis.model.FactInternationalPortalUsage createFactInternationalPortalUsage(
		long factId) {
		return getService().createFactInternationalPortalUsage(factId);
	}

	/**
	* Deletes the fact international portal usage with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact international portal usage
	* @return the fact international portal usage that was removed
	* @throws PortalException if a fact international portal usage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactInternationalPortalUsage deleteFactInternationalPortalUsage(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFactInternationalPortalUsage(factId);
	}

	/**
	* Deletes the fact international portal usage from the database. Also notifies the appropriate model listeners.
	*
	* @param factInternationalPortalUsage the fact international portal usage
	* @return the fact international portal usage that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactInternationalPortalUsage deleteFactInternationalPortalUsage(
		com.idetronic.eis.model.FactInternationalPortalUsage factInternationalPortalUsage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteFactInternationalPortalUsage(factInternationalPortalUsage);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInternationalPortalUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInternationalPortalUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.FactInternationalPortalUsage fetchFactInternationalPortalUsage(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFactInternationalPortalUsage(factId);
	}

	/**
	* Returns the fact international portal usage with the primary key.
	*
	* @param factId the primary key of the fact international portal usage
	* @return the fact international portal usage
	* @throws PortalException if a fact international portal usage with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactInternationalPortalUsage getFactInternationalPortalUsage(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactInternationalPortalUsage(factId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact international portal usages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInternationalPortalUsageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact international portal usages
	* @param end the upper bound of the range of fact international portal usages (not inclusive)
	* @return the range of fact international portal usages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactInternationalPortalUsage> getFactInternationalPortalUsages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactInternationalPortalUsages(start, end);
	}

	/**
	* Returns the number of fact international portal usages.
	*
	* @return the number of fact international portal usages
	* @throws SystemException if a system exception occurred
	*/
	public static int getFactInternationalPortalUsagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactInternationalPortalUsagesCount();
	}

	/**
	* Updates the fact international portal usage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factInternationalPortalUsage the fact international portal usage
	* @return the fact international portal usage that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactInternationalPortalUsage updateFactInternationalPortalUsage(
		com.idetronic.eis.model.FactInternationalPortalUsage factInternationalPortalUsage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFactInternationalPortalUsage(factInternationalPortalUsage);
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

	public static FactInternationalPortalUsageLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FactInternationalPortalUsageLocalService.class.getName());

			if (invokableLocalService instanceof FactInternationalPortalUsageLocalService) {
				_service = (FactInternationalPortalUsageLocalService)invokableLocalService;
			}
			else {
				_service = new FactInternationalPortalUsageLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FactInternationalPortalUsageLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FactInternationalPortalUsageLocalService service) {
	}

	private static FactInternationalPortalUsageLocalService _service;
}
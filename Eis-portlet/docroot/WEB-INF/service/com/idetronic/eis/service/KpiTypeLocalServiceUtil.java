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
 * Provides the local service utility for KpiType. This utility wraps
 * {@link com.idetronic.eis.service.impl.KpiTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see KpiTypeLocalService
 * @see com.idetronic.eis.service.base.KpiTypeLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.KpiTypeLocalServiceImpl
 * @generated
 */
public class KpiTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.KpiTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the kpi type to the database. Also notifies the appropriate model listeners.
	*
	* @param kpiType the kpi type
	* @return the kpi type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiType addKpiType(
		com.idetronic.eis.model.KpiType kpiType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addKpiType(kpiType);
	}

	/**
	* Creates a new kpi type with the primary key. Does not add the kpi type to the database.
	*
	* @param kpiTypeId the primary key for the new kpi type
	* @return the new kpi type
	*/
	public static com.idetronic.eis.model.KpiType createKpiType(long kpiTypeId) {
		return getService().createKpiType(kpiTypeId);
	}

	/**
	* Deletes the kpi type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiTypeId the primary key of the kpi type
	* @return the kpi type that was removed
	* @throws PortalException if a kpi type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiType deleteKpiType(long kpiTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKpiType(kpiTypeId);
	}

	/**
	* Deletes the kpi type from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiType the kpi type
	* @return the kpi type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiType deleteKpiType(
		com.idetronic.eis.model.KpiType kpiType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteKpiType(kpiType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.KpiType fetchKpiType(long kpiTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchKpiType(kpiTypeId);
	}

	/**
	* Returns the kpi type with the primary key.
	*
	* @param kpiTypeId the primary key of the kpi type
	* @return the kpi type
	* @throws PortalException if a kpi type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiType getKpiType(long kpiTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getKpiType(kpiTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the kpi types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpi types
	* @param end the upper bound of the range of kpi types (not inclusive)
	* @return the range of kpi types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.KpiType> getKpiTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKpiTypes(start, end);
	}

	/**
	* Returns the number of kpi types.
	*
	* @return the number of kpi types
	* @throws SystemException if a system exception occurred
	*/
	public static int getKpiTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getKpiTypesCount();
	}

	/**
	* Updates the kpi type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kpiType the kpi type
	* @return the kpi type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.KpiType updateKpiType(
		com.idetronic.eis.model.KpiType kpiType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateKpiType(kpiType);
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

	public static com.idetronic.eis.model.KpiType add(java.lang.String key,
		java.lang.String name, boolean monthly, boolean quarterly,
		boolean semiAnually, boolean yearly, boolean isDecimal,
		boolean manualValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .add(key, name, monthly, quarterly, semiAnually, yearly,
			isDecimal, manualValue);
	}

	public static void clearService() {
		_service = null;
	}

	public static KpiTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					KpiTypeLocalService.class.getName());

			if (invokableLocalService instanceof KpiTypeLocalService) {
				_service = (KpiTypeLocalService)invokableLocalService;
			}
			else {
				_service = new KpiTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(KpiTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(KpiTypeLocalService service) {
	}

	private static KpiTypeLocalService _service;
}
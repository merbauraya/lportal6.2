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
 * Provides the local service utility for FactIncome. This utility wraps
 * {@link com.idetronic.eis.service.impl.FactIncomeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see FactIncomeLocalService
 * @see com.idetronic.eis.service.base.FactIncomeLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.FactIncomeLocalServiceImpl
 * @generated
 */
public class FactIncomeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.FactIncomeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fact income to the database. Also notifies the appropriate model listeners.
	*
	* @param factIncome the fact income
	* @return the fact income that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIncome addFactIncome(
		com.idetronic.eis.model.FactIncome factIncome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFactIncome(factIncome);
	}

	/**
	* Creates a new fact income with the primary key. Does not add the fact income to the database.
	*
	* @param factIncomeId the primary key for the new fact income
	* @return the new fact income
	*/
	public static com.idetronic.eis.model.FactIncome createFactIncome(
		long factIncomeId) {
		return getService().createFactIncome(factIncomeId);
	}

	/**
	* Deletes the fact income with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factIncomeId the primary key of the fact income
	* @return the fact income that was removed
	* @throws PortalException if a fact income with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIncome deleteFactIncome(
		long factIncomeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFactIncome(factIncomeId);
	}

	/**
	* Deletes the fact income from the database. Also notifies the appropriate model listeners.
	*
	* @param factIncome the fact income
	* @return the fact income that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIncome deleteFactIncome(
		com.idetronic.eis.model.FactIncome factIncome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFactIncome(factIncome);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIncomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIncomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.FactIncome fetchFactIncome(
		long factIncomeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFactIncome(factIncomeId);
	}

	/**
	* Returns the fact income with the primary key.
	*
	* @param factIncomeId the primary key of the fact income
	* @return the fact income
	* @throws PortalException if a fact income with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIncome getFactIncome(
		long factIncomeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactIncome(factIncomeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact incomes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIncomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact incomes
	* @param end the upper bound of the range of fact incomes (not inclusive)
	* @return the range of fact incomes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIncome> getFactIncomes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactIncomes(start, end);
	}

	/**
	* Returns the number of fact incomes.
	*
	* @return the number of fact incomes
	* @throws SystemException if a system exception occurred
	*/
	public static int getFactIncomesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactIncomesCount();
	}

	/**
	* Updates the fact income in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factIncome the fact income
	* @return the fact income that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIncome updateFactIncome(
		com.idetronic.eis.model.FactIncome factIncome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFactIncome(factIncome);
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

	public static void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().batchInsert(libraryId, period, datas, serviceContext);
	}

	public static com.idetronic.eis.model.FactIncome add(long libraryId,
		java.lang.String period, long incomeTypeId, double amount,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .add(libraryId, period, incomeTypeId, amount, serviceContext);
	}

	public static java.util.List<com.idetronic.eis.model.FactIncome> getLatestEntry(
		long libraryId, java.lang.String period) {
		return getService().getLatestEntry(libraryId, period);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEntries(
		long libraryId, java.lang.String period) {
		return getService().getEntries(libraryId, period);
	}

	public static boolean isMissingData(long libraryId, java.lang.String period) {
		return getService().isMissingData(libraryId, period);
	}

	public static void clearService() {
		_service = null;
	}

	public static FactIncomeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FactIncomeLocalService.class.getName());

			if (invokableLocalService instanceof FactIncomeLocalService) {
				_service = (FactIncomeLocalService)invokableLocalService;
			}
			else {
				_service = new FactIncomeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FactIncomeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FactIncomeLocalService service) {
	}

	private static FactIncomeLocalService _service;
}
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
 * Provides a wrapper for {@link FactExpenseLocalService}.
 *
 * @author Mazlan Mat
 * @see FactExpenseLocalService
 * @generated
 */
public class FactExpenseLocalServiceWrapper implements FactExpenseLocalService,
	ServiceWrapper<FactExpenseLocalService> {
	public FactExpenseLocalServiceWrapper(
		FactExpenseLocalService factExpenseLocalService) {
		_factExpenseLocalService = factExpenseLocalService;
	}

	/**
	* Adds the fact expense to the database. Also notifies the appropriate model listeners.
	*
	* @param factExpense the fact expense
	* @return the fact expense that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactExpense addFactExpense(
		com.idetronic.eis.model.FactExpense factExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.addFactExpense(factExpense);
	}

	/**
	* Creates a new fact expense with the primary key. Does not add the fact expense to the database.
	*
	* @param factExpenseId the primary key for the new fact expense
	* @return the new fact expense
	*/
	@Override
	public com.idetronic.eis.model.FactExpense createFactExpense(
		long factExpenseId) {
		return _factExpenseLocalService.createFactExpense(factExpenseId);
	}

	/**
	* Deletes the fact expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factExpenseId the primary key of the fact expense
	* @return the fact expense that was removed
	* @throws PortalException if a fact expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactExpense deleteFactExpense(
		long factExpenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.deleteFactExpense(factExpenseId);
	}

	/**
	* Deletes the fact expense from the database. Also notifies the appropriate model listeners.
	*
	* @param factExpense the fact expense
	* @return the fact expense that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactExpense deleteFactExpense(
		com.idetronic.eis.model.FactExpense factExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.deleteFactExpense(factExpense);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factExpenseLocalService.dynamicQuery();
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
		return _factExpenseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factExpenseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factExpenseLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _factExpenseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factExpenseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactExpense fetchFactExpense(
		long factExpenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.fetchFactExpense(factExpenseId);
	}

	/**
	* Returns the fact expense with the primary key.
	*
	* @param factExpenseId the primary key of the fact expense
	* @return the fact expense
	* @throws PortalException if a fact expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactExpense getFactExpense(
		long factExpenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.getFactExpense(factExpenseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact expenses
	* @param end the upper bound of the range of fact expenses (not inclusive)
	* @return the range of fact expenses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactExpense> getFactExpenses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.getFactExpenses(start, end);
	}

	/**
	* Returns the number of fact expenses.
	*
	* @return the number of fact expenses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactExpensesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.getFactExpensesCount();
	}

	/**
	* Updates the fact expense in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factExpense the fact expense
	* @return the fact expense that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactExpense updateFactExpense(
		com.idetronic.eis.model.FactExpense factExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.updateFactExpense(factExpense);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factExpenseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factExpenseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factExpenseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray allocationArray,
		com.liferay.portal.kernel.json.JSONArray expenseArray,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factExpenseLocalService.batchInsert(libraryId, period,
			allocationArray, expenseArray, serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactExpense add(long libraryId,
		java.lang.String period, int expenseType, long masterFileId,
		double amount, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factExpenseLocalService.add(libraryId, period, expenseType,
			masterFileId, amount, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactExpense> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factExpenseLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period) {
		return _factExpenseLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactExpenseLocalService getWrappedFactExpenseLocalService() {
		return _factExpenseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactExpenseLocalService(
		FactExpenseLocalService factExpenseLocalService) {
		_factExpenseLocalService = factExpenseLocalService;
	}

	@Override
	public FactExpenseLocalService getWrappedService() {
		return _factExpenseLocalService;
	}

	@Override
	public void setWrappedService(
		FactExpenseLocalService factExpenseLocalService) {
		_factExpenseLocalService = factExpenseLocalService;
	}

	private FactExpenseLocalService _factExpenseLocalService;
}
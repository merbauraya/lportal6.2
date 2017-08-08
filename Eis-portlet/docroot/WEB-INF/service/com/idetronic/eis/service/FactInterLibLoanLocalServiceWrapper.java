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
 * Provides a wrapper for {@link FactInterLibLoanLocalService}.
 *
 * @author Mazlan Mat
 * @see FactInterLibLoanLocalService
 * @generated
 */
public class FactInterLibLoanLocalServiceWrapper
	implements FactInterLibLoanLocalService,
		ServiceWrapper<FactInterLibLoanLocalService> {
	public FactInterLibLoanLocalServiceWrapper(
		FactInterLibLoanLocalService factInterLibLoanLocalService) {
		_factInterLibLoanLocalService = factInterLibLoanLocalService;
	}

	/**
	* Adds the fact inter lib loan to the database. Also notifies the appropriate model listeners.
	*
	* @param factInterLibLoan the fact inter lib loan
	* @return the fact inter lib loan that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactInterLibLoan addFactInterLibLoan(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.addFactInterLibLoan(factInterLibLoan);
	}

	/**
	* Creates a new fact inter lib loan with the primary key. Does not add the fact inter lib loan to the database.
	*
	* @param factId the primary key for the new fact inter lib loan
	* @return the new fact inter lib loan
	*/
	@Override
	public com.idetronic.eis.model.FactInterLibLoan createFactInterLibLoan(
		long factId) {
		return _factInterLibLoanLocalService.createFactInterLibLoan(factId);
	}

	/**
	* Deletes the fact inter lib loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact inter lib loan
	* @return the fact inter lib loan that was removed
	* @throws PortalException if a fact inter lib loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactInterLibLoan deleteFactInterLibLoan(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.deleteFactInterLibLoan(factId);
	}

	/**
	* Deletes the fact inter lib loan from the database. Also notifies the appropriate model listeners.
	*
	* @param factInterLibLoan the fact inter lib loan
	* @return the fact inter lib loan that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactInterLibLoan deleteFactInterLibLoan(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.deleteFactInterLibLoan(factInterLibLoan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factInterLibLoanLocalService.dynamicQuery();
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
		return _factInterLibLoanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factInterLibLoanLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factInterLibLoanLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _factInterLibLoanLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factInterLibLoanLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactInterLibLoan fetchFactInterLibLoan(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.fetchFactInterLibLoan(factId);
	}

	/**
	* Returns the fact inter lib loan with the primary key.
	*
	* @param factId the primary key of the fact inter lib loan
	* @return the fact inter lib loan
	* @throws PortalException if a fact inter lib loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactInterLibLoan getFactInterLibLoan(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.getFactInterLibLoan(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact inter lib loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactInterLibLoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact inter lib loans
	* @param end the upper bound of the range of fact inter lib loans (not inclusive)
	* @return the range of fact inter lib loans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactInterLibLoan> getFactInterLibLoans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.getFactInterLibLoans(start, end);
	}

	/**
	* Returns the number of fact inter lib loans.
	*
	* @return the number of fact inter lib loans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactInterLibLoansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.getFactInterLibLoansCount();
	}

	/**
	* Updates the fact inter lib loan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factInterLibLoan the fact inter lib loan
	* @return the fact inter lib loan that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactInterLibLoan updateFactInterLibLoan(
		com.idetronic.eis.model.FactInterLibLoan factInterLibLoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.updateFactInterLibLoan(factInterLibLoan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factInterLibLoanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factInterLibLoanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factInterLibLoanLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.FactInterLibLoan> getLatestEntry(
		long libraryId, java.lang.String period) {
		return _factInterLibLoanLocalService.getLatestEntry(libraryId, period);
	}

	@Override
	public void batchInsert(long libraryId, java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_factInterLibLoanLocalService.batchInsert(libraryId, period, datas,
			serviceContext);
	}

	@Override
	public com.idetronic.eis.model.FactInterLibLoan add(long libraryId,
		java.lang.String period, long ptjId, long applyTotal,
		long approvedTotal,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.add(libraryId, period, ptjId,
			applyTotal, approvedTotal, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntries(long libraryId,
		java.lang.String period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factInterLibLoanLocalService.getEntries(libraryId, period);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactInterLibLoanLocalService getWrappedFactInterLibLoanLocalService() {
		return _factInterLibLoanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactInterLibLoanLocalService(
		FactInterLibLoanLocalService factInterLibLoanLocalService) {
		_factInterLibLoanLocalService = factInterLibLoanLocalService;
	}

	@Override
	public FactInterLibLoanLocalService getWrappedService() {
		return _factInterLibLoanLocalService;
	}

	@Override
	public void setWrappedService(
		FactInterLibLoanLocalService factInterLibLoanLocalService) {
		_factInterLibLoanLocalService = factInterLibLoanLocalService;
	}

	private FactInterLibLoanLocalService _factInterLibLoanLocalService;
}
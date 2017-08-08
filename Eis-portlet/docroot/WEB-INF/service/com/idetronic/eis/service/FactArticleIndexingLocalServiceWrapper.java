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
 * Provides a wrapper for {@link FactArticleIndexingLocalService}.
 *
 * @author Mazlan Mat
 * @see FactArticleIndexingLocalService
 * @generated
 */
public class FactArticleIndexingLocalServiceWrapper
	implements FactArticleIndexingLocalService,
		ServiceWrapper<FactArticleIndexingLocalService> {
	public FactArticleIndexingLocalServiceWrapper(
		FactArticleIndexingLocalService factArticleIndexingLocalService) {
		_factArticleIndexingLocalService = factArticleIndexingLocalService;
	}

	/**
	* Adds the fact article indexing to the database. Also notifies the appropriate model listeners.
	*
	* @param factArticleIndexing the fact article indexing
	* @return the fact article indexing that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactArticleIndexing addFactArticleIndexing(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.addFactArticleIndexing(factArticleIndexing);
	}

	/**
	* Creates a new fact article indexing with the primary key. Does not add the fact article indexing to the database.
	*
	* @param factId the primary key for the new fact article indexing
	* @return the new fact article indexing
	*/
	@Override
	public com.idetronic.eis.model.FactArticleIndexing createFactArticleIndexing(
		long factId) {
		return _factArticleIndexingLocalService.createFactArticleIndexing(factId);
	}

	/**
	* Deletes the fact article indexing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factId the primary key of the fact article indexing
	* @return the fact article indexing that was removed
	* @throws PortalException if a fact article indexing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactArticleIndexing deleteFactArticleIndexing(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.deleteFactArticleIndexing(factId);
	}

	/**
	* Deletes the fact article indexing from the database. Also notifies the appropriate model listeners.
	*
	* @param factArticleIndexing the fact article indexing
	* @return the fact article indexing that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactArticleIndexing deleteFactArticleIndexing(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.deleteFactArticleIndexing(factArticleIndexing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _factArticleIndexingLocalService.dynamicQuery();
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
		return _factArticleIndexingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factArticleIndexingLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _factArticleIndexingLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _factArticleIndexingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _factArticleIndexingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.FactArticleIndexing fetchFactArticleIndexing(
		long factId) throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.fetchFactArticleIndexing(factId);
	}

	/**
	* Returns the fact article indexing with the primary key.
	*
	* @param factId the primary key of the fact article indexing
	* @return the fact article indexing
	* @throws PortalException if a fact article indexing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactArticleIndexing getFactArticleIndexing(
		long factId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.getFactArticleIndexing(factId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact article indexings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact article indexings
	* @param end the upper bound of the range of fact article indexings (not inclusive)
	* @return the range of fact article indexings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.FactArticleIndexing> getFactArticleIndexings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.getFactArticleIndexings(start,
			end);
	}

	/**
	* Returns the number of fact article indexings.
	*
	* @return the number of fact article indexings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFactArticleIndexingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.getFactArticleIndexingsCount();
	}

	/**
	* Updates the fact article indexing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factArticleIndexing the fact article indexing
	* @return the fact article indexing that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.FactArticleIndexing updateFactArticleIndexing(
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _factArticleIndexingLocalService.updateFactArticleIndexing(factArticleIndexing);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _factArticleIndexingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_factArticleIndexingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _factArticleIndexingLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FactArticleIndexingLocalService getWrappedFactArticleIndexingLocalService() {
		return _factArticleIndexingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFactArticleIndexingLocalService(
		FactArticleIndexingLocalService factArticleIndexingLocalService) {
		_factArticleIndexingLocalService = factArticleIndexingLocalService;
	}

	@Override
	public FactArticleIndexingLocalService getWrappedService() {
		return _factArticleIndexingLocalService;
	}

	@Override
	public void setWrappedService(
		FactArticleIndexingLocalService factArticleIndexingLocalService) {
		_factArticleIndexingLocalService = factArticleIndexingLocalService;
	}

	private FactArticleIndexingLocalService _factArticleIndexingLocalService;
}
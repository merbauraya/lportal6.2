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
 * Provides a wrapper for {@link KpiEntryLocalService}.
 *
 * @author Mazlan Mat
 * @see KpiEntryLocalService
 * @generated
 */
public class KpiEntryLocalServiceWrapper implements KpiEntryLocalService,
	ServiceWrapper<KpiEntryLocalService> {
	public KpiEntryLocalServiceWrapper(
		KpiEntryLocalService kpiEntryLocalService) {
		_kpiEntryLocalService = kpiEntryLocalService;
	}

	/**
	* Adds the kpi entry to the database. Also notifies the appropriate model listeners.
	*
	* @param kpiEntry the kpi entry
	* @return the kpi entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.KpiEntry addKpiEntry(
		com.idetronic.eis.model.KpiEntry kpiEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.addKpiEntry(kpiEntry);
	}

	/**
	* Creates a new kpi entry with the primary key. Does not add the kpi entry to the database.
	*
	* @param kpiEntryId the primary key for the new kpi entry
	* @return the new kpi entry
	*/
	@Override
	public com.idetronic.eis.model.KpiEntry createKpiEntry(long kpiEntryId) {
		return _kpiEntryLocalService.createKpiEntry(kpiEntryId);
	}

	/**
	* Deletes the kpi entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry that was removed
	* @throws PortalException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.KpiEntry deleteKpiEntry(long kpiEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.deleteKpiEntry(kpiEntryId);
	}

	/**
	* Deletes the kpi entry from the database. Also notifies the appropriate model listeners.
	*
	* @param kpiEntry the kpi entry
	* @return the kpi entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.KpiEntry deleteKpiEntry(
		com.idetronic.eis.model.KpiEntry kpiEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.deleteKpiEntry(kpiEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kpiEntryLocalService.dynamicQuery();
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
		return _kpiEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kpiEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kpiEntryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _kpiEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kpiEntryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.eis.model.KpiEntry fetchKpiEntry(long kpiEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.fetchKpiEntry(kpiEntryId);
	}

	/**
	* Returns the kpi entry with the primary key.
	*
	* @param kpiEntryId the primary key of the kpi entry
	* @return the kpi entry
	* @throws PortalException if a kpi entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.KpiEntry getKpiEntry(long kpiEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.getKpiEntry(kpiEntryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the kpi entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.KpiEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kpi entries
	* @param end the upper bound of the range of kpi entries (not inclusive)
	* @return the range of kpi entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.KpiEntry> getKpiEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.getKpiEntries(start, end);
	}

	/**
	* Returns the number of kpi entries.
	*
	* @return the number of kpi entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getKpiEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.getKpiEntriesCount();
	}

	/**
	* Updates the kpi entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kpiEntry the kpi entry
	* @return the kpi entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.KpiEntry updateKpiEntry(
		com.idetronic.eis.model.KpiEntry kpiEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.updateKpiEntry(kpiEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _kpiEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kpiEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kpiEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.KpiEntry add(long kpiTypeId,
		java.lang.String year, int periodType, java.lang.String period,
		double value, double actual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.add(kpiTypeId, year, periodType, period,
			value, actual);
	}

	@Override
	public void batchInsert(long kpiTypeId, java.lang.String year,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_kpiEntryLocalService.batchInsert(kpiTypeId, year, datas, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.KpiEntry> findByYearPeriodType(
		long kpiTypeId, java.lang.String year, int periodType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kpiEntryLocalService.findByYearPeriodType(kpiTypeId, year,
			periodType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KpiEntryLocalService getWrappedKpiEntryLocalService() {
		return _kpiEntryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKpiEntryLocalService(
		KpiEntryLocalService kpiEntryLocalService) {
		_kpiEntryLocalService = kpiEntryLocalService;
	}

	@Override
	public KpiEntryLocalService getWrappedService() {
		return _kpiEntryLocalService;
	}

	@Override
	public void setWrappedService(KpiEntryLocalService kpiEntryLocalService) {
		_kpiEntryLocalService = kpiEntryLocalService;
	}

	private KpiEntryLocalService _kpiEntryLocalService;
}
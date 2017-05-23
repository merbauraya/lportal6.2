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
 * Provides a wrapper for {@link MasterFileLocalService}.
 *
 * @author Mazlan Mat
 * @see MasterFileLocalService
 * @generated
 */
public class MasterFileLocalServiceWrapper implements MasterFileLocalService,
	ServiceWrapper<MasterFileLocalService> {
	public MasterFileLocalServiceWrapper(
		MasterFileLocalService masterFileLocalService) {
		_masterFileLocalService = masterFileLocalService;
	}

	/**
	* Adds the master file to the database. Also notifies the appropriate model listeners.
	*
	* @param masterFile the master file
	* @return the master file that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.MasterFile addMasterFile(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.addMasterFile(masterFile);
	}

	/**
	* Creates a new master file with the primary key. Does not add the master file to the database.
	*
	* @param masterFileId the primary key for the new master file
	* @return the new master file
	*/
	@Override
	public com.idetronic.eis.model.MasterFile createMasterFile(
		long masterFileId) {
		return _masterFileLocalService.createMasterFile(masterFileId);
	}

	/**
	* Deletes the master file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file that was removed
	* @throws PortalException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.MasterFile deleteMasterFile(
		long masterFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.deleteMasterFile(masterFileId);
	}

	/**
	* Deletes the master file from the database. Also notifies the appropriate model listeners.
	*
	* @param masterFile the master file
	* @return the master file that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.MasterFile deleteMasterFile(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.deleteMasterFile(masterFile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterFileLocalService.dynamicQuery();
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
		return _masterFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _masterFileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _masterFileLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _masterFileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _masterFileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.MasterFile fetchMasterFile(long masterFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.fetchMasterFile(masterFileId);
	}

	/**
	* Returns the master file with the primary key.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file
	* @throws PortalException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.MasterFile getMasterFile(long masterFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getMasterFile(masterFileId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the master files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of master files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getMasterFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getMasterFiles(start, end);
	}

	/**
	* Returns the number of master files.
	*
	* @return the number of master files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMasterFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getMasterFilesCount();
	}

	/**
	* Updates the master file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param masterFile the master file
	* @return the master file that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.MasterFile updateMasterFile(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.updateMasterFile(masterFile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _masterFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_masterFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _masterFileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByMasterType(masterTypeId, start, end);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterFile(
		long masterTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator ord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByMasterFile(masterTypeId, start,
			end, ord);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getAllLibraries()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getAllLibraries();
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getAllPrintedMaterial()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getAllPrintedMaterial();
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getAllIrItem()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getAllIrItem();
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getAllNonPrintedMaterial()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getAllNonPrintedMaterial();
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getAllFaculties()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getAllFaculties();
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> getAllItemMediums()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getAllItemMediums();
	}

	@Override
	public int getCountByMasterType(long masterTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.getCountByMasterType(masterTypeId);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByParent1(
		long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByParent1(masterTypeId, parentId1);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByParent2(
		long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByParent2(masterTypeId, parentId2);
	}

	@Override
	public com.idetronic.eis.model.MasterFile findByTypeAndName(
		long masterTypeId, java.lang.String name)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeAndName(masterTypeId, name);
	}

	@Override
	public com.idetronic.eis.model.MasterFile findByTypeOldId(
		long masterTypeId, long oldId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeOldId(masterTypeId, oldId);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeAndStatus(masterTypeId,
			status1, status2, status3, status4);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus1(
		long masterTypeId, boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeAndStatus1(masterTypeId,
			status1);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus2(
		long masterTypeId, boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeAndStatus2(masterTypeId,
			status2);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus3(
		long masterTypeId, boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeAndStatus3(masterTypeId,
			status3);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus4(
		long masterTypeId, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterFileLocalService.findByTypeAndStatus4(masterTypeId,
			status4);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MasterFileLocalService getWrappedMasterFileLocalService() {
		return _masterFileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMasterFileLocalService(
		MasterFileLocalService masterFileLocalService) {
		_masterFileLocalService = masterFileLocalService;
	}

	@Override
	public MasterFileLocalService getWrappedService() {
		return _masterFileLocalService;
	}

	@Override
	public void setWrappedService(MasterFileLocalService masterFileLocalService) {
		_masterFileLocalService = masterFileLocalService;
	}

	private MasterFileLocalService _masterFileLocalService;
}
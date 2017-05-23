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
 * Provides the local service utility for MasterFile. This utility wraps
 * {@link com.idetronic.eis.service.impl.MasterFileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see MasterFileLocalService
 * @see com.idetronic.eis.service.base.MasterFileLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.MasterFileLocalServiceImpl
 * @generated
 */
public class MasterFileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.MasterFileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the master file to the database. Also notifies the appropriate model listeners.
	*
	* @param masterFile the master file
	* @return the master file that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile addMasterFile(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMasterFile(masterFile);
	}

	/**
	* Creates a new master file with the primary key. Does not add the master file to the database.
	*
	* @param masterFileId the primary key for the new master file
	* @return the new master file
	*/
	public static com.idetronic.eis.model.MasterFile createMasterFile(
		long masterFileId) {
		return getService().createMasterFile(masterFileId);
	}

	/**
	* Deletes the master file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file that was removed
	* @throws PortalException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile deleteMasterFile(
		long masterFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMasterFile(masterFileId);
	}

	/**
	* Deletes the master file from the database. Also notifies the appropriate model listeners.
	*
	* @param masterFile the master file
	* @return the master file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile deleteMasterFile(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMasterFile(masterFile);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.eis.model.MasterFile fetchMasterFile(
		long masterFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMasterFile(masterFileId);
	}

	/**
	* Returns the master file with the primary key.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file
	* @throws PortalException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile getMasterFile(
		long masterFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMasterFile(masterFileId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.eis.model.MasterFile> getMasterFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMasterFiles(start, end);
	}

	/**
	* Returns the number of master files.
	*
	* @return the number of master files
	* @throws SystemException if a system exception occurred
	*/
	public static int getMasterFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMasterFilesCount();
	}

	/**
	* Updates the master file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param masterFile the master file
	* @return the master file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile updateMasterFile(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMasterFile(masterFile);
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

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMasterType(masterTypeId, start, end);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterFile(
		long masterTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator ord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMasterFile(masterTypeId, start, end, ord);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getAllLibraries()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllLibraries();
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getAllPrintedMaterial()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllPrintedMaterial();
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getAllIrItem()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllIrItem();
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getAllNonPrintedMaterial()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllNonPrintedMaterial();
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getAllFaculties()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllFaculties();
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> getAllItemMediums()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllItemMediums();
	}

	public static int getCountByMasterType(long masterTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountByMasterType(masterTypeId);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByParent1(
		long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParent1(masterTypeId, parentId1);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByParent2(
		long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParent2(masterTypeId, parentId2);
	}

	public static com.idetronic.eis.model.MasterFile findByTypeAndName(
		long masterTypeId, java.lang.String name)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndName(masterTypeId, name);
	}

	public static com.idetronic.eis.model.MasterFile findByTypeOldId(
		long masterTypeId, long oldId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeOldId(masterTypeId, oldId);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByTypeAndStatus(masterTypeId, status1, status2,
			status3, status4);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus1(
		long masterTypeId, boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndStatus1(masterTypeId, status1);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus2(
		long masterTypeId, boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndStatus2(masterTypeId, status2);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus3(
		long masterTypeId, boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndStatus3(masterTypeId, status3);
	}

	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndStatus4(
		long masterTypeId, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTypeAndStatus4(masterTypeId, status4);
	}

	public static void clearService() {
		_service = null;
	}

	public static MasterFileLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MasterFileLocalService.class.getName());

			if (invokableLocalService instanceof MasterFileLocalService) {
				_service = (MasterFileLocalService)invokableLocalService;
			}
			else {
				_service = new MasterFileLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MasterFileLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MasterFileLocalService service) {
	}

	private static MasterFileLocalService _service;
}
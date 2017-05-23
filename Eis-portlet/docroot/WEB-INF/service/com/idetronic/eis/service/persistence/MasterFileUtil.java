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

package com.idetronic.eis.service.persistence;

import com.idetronic.eis.model.MasterFile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the master file service. This utility wraps {@link MasterFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterFilePersistence
 * @see MasterFilePersistenceImpl
 * @generated
 */
public class MasterFileUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MasterFile masterFile) {
		getPersistence().clearCache(masterFile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MasterFile update(MasterFile masterFile)
		throws SystemException {
		return getPersistence().update(masterFile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MasterFile update(MasterFile masterFile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(masterFile, serviceContext);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, boolean inActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMasterType(masterTypeId, inActive);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and inActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, boolean inActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterType(masterTypeId, inActive, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and inActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, boolean inActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterType(masterTypeId, inActive, start, end,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterType_First(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterType_First(masterTypeId, inActive,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterType_First(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterType_First(masterTypeId, inActive,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterType_Last(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterType_Last(masterTypeId, inActive,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterType_Last(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterType_Last(masterTypeId, inActive,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByMasterType_PrevAndNext(
		long masterFileId, long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterType_PrevAndNext(masterFileId, masterTypeId,
			inActive, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and inActive = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMasterType(long masterTypeId, boolean inActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMasterType(masterTypeId, inActive);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterType(long masterTypeId, boolean inActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMasterType(masterTypeId, inActive);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent1(
		long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndParent1(masterTypeId, parentId1);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent1(
		long masterTypeId, long parentId1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent1(masterTypeId, parentId1, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent1(
		long masterTypeId, long parentId1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent1(masterTypeId, parentId1, start, end,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByTypeAndParent1_First(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent1_First(masterTypeId, parentId1,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByTypeAndParent1_First(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndParent1_First(masterTypeId, parentId1,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByTypeAndParent1_Last(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent1_Last(masterTypeId, parentId1,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByTypeAndParent1_Last(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndParent1_Last(masterTypeId, parentId1,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByTypeAndParent1_PrevAndNext(
		long masterFileId, long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent1_PrevAndNext(masterFileId,
			masterTypeId, parentId1, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and parentId1 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndParent1(long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeAndParent1(masterTypeId, parentId1);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndParent1(long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeAndParent1(masterTypeId, parentId1);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent2(
		long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndParent2(masterTypeId, parentId2);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent2(
		long masterTypeId, long parentId2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent2(masterTypeId, parentId2, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent2(
		long masterTypeId, long parentId2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent2(masterTypeId, parentId2, start, end,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByTypeAndParent2_First(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent2_First(masterTypeId, parentId2,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByTypeAndParent2_First(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndParent2_First(masterTypeId, parentId2,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByTypeAndParent2_Last(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent2_Last(masterTypeId, parentId2,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByTypeAndParent2_Last(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndParent2_Last(masterTypeId, parentId2,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByTypeAndParent2_PrevAndNext(
		long masterFileId, long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndParent2_PrevAndNext(masterFileId,
			masterTypeId, parentId2, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and parentId2 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndParent2(long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeAndParent2(masterTypeId, parentId2);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndParent2(long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeAndParent2(masterTypeId, parentId2);
	}

	/**
	* Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndName(masterTypeId, masterFileName);
	}

	/**
	* Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndName(masterTypeId, masterFileName);
	}

	/**
	* Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndName(masterTypeId, masterFileName,
			retrieveFromCache);
	}

	/**
	* Removes the master file where masterTypeId = &#63; and masterFileName = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the master file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile removeByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByMasterTypeAndName(masterTypeId, masterFileName);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and masterFileName = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterTypeAndName(long masterTypeId,
		java.lang.String masterFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMasterTypeAndName(masterTypeId, masterFileName);
	}

	/**
	* Returns the master file where masterTypeId = &#63; and oldId = &#63; or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByOldId(
		long masterTypeId, long oldId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOldId(masterTypeId, oldId);
	}

	/**
	* Returns the master file where masterTypeId = &#63; and oldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByOldId(
		long masterTypeId, long oldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOldId(masterTypeId, oldId);
	}

	/**
	* Returns the master file where masterTypeId = &#63; and oldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByOldId(
		long masterTypeId, long oldId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOldId(masterTypeId, oldId, retrieveFromCache);
	}

	/**
	* Removes the master file where masterTypeId = &#63; and oldId = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the master file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile removeByOldId(
		long masterTypeId, long oldId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByOldId(masterTypeId, oldId);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and oldId = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOldId(long masterTypeId, long oldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOldId(masterTypeId, oldId);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4, start, end, orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus_First(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus_First(masterTypeId, status1,
			status2, status3, status4, orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus_First(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus_First(masterTypeId, status1,
			status2, status3, status4, orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus_Last(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus_Last(masterTypeId, status1,
			status2, status3, status4, orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus_Last(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus_Last(masterTypeId, status1,
			status2, status3, status4, orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status1, boolean status2,
		boolean status3, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus_PrevAndNext(masterFileId,
			masterTypeId, status1, status2, status3, status4, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMasterTypeAndStatus(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and status1 = &#63; and status2 = &#63; and status3 = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param status2 the status2
	* @param status3 the status3
	* @param status4 the status4
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterTypeAndStatus(long masterTypeId,
		boolean status1, boolean status2, boolean status3, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMasterTypeAndStatus(masterTypeId, status1, status2,
			status3, status4);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus1(
		long masterTypeId, boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMasterTypeAndStatus1(masterTypeId, status1);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and status1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus1(
		long masterTypeId, boolean status1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus1(masterTypeId, status1, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and status1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus1(
		long masterTypeId, boolean status1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus1(masterTypeId, status1, start,
			end, orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus1_First(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus1_First(masterTypeId, status1,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus1_First(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus1_First(masterTypeId, status1,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus1_Last(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus1_Last(masterTypeId, status1,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus1_Last(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus1_Last(masterTypeId, status1,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus1_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus1_PrevAndNext(masterFileId,
			masterTypeId, status1, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and status1 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMasterTypeAndStatus1(long masterTypeId,
		boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMasterTypeAndStatus1(masterTypeId, status1);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterTypeAndStatus1(long masterTypeId,
		boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMasterTypeAndStatus1(masterTypeId, status1);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus2(
		long masterTypeId, boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMasterTypeAndStatus2(masterTypeId, status2);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and status2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus2(
		long masterTypeId, boolean status2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus2(masterTypeId, status2, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and status2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus2(
		long masterTypeId, boolean status2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus2(masterTypeId, status2, start,
			end, orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus2_First(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus2_First(masterTypeId, status2,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus2_First(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus2_First(masterTypeId, status2,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus2_Last(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus2_Last(masterTypeId, status2,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus2_Last(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus2_Last(masterTypeId, status2,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus2_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus2_PrevAndNext(masterFileId,
			masterTypeId, status2, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and status2 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMasterTypeAndStatus2(long masterTypeId,
		boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMasterTypeAndStatus2(masterTypeId, status2);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterTypeAndStatus2(long masterTypeId,
		boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMasterTypeAndStatus2(masterTypeId, status2);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus3(
		long masterTypeId, boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMasterTypeAndStatus3(masterTypeId, status3);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and status3 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus3(
		long masterTypeId, boolean status3, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus3(masterTypeId, status3, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and status3 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus3(
		long masterTypeId, boolean status3, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus3(masterTypeId, status3, start,
			end, orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus3_First(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus3_First(masterTypeId, status3,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus3_First(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus3_First(masterTypeId, status3,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus3_Last(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus3_Last(masterTypeId, status3,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus3_Last(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus3_Last(masterTypeId, status3,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus3_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus3_PrevAndNext(masterFileId,
			masterTypeId, status3, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and status3 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMasterTypeAndStatus3(long masterTypeId,
		boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMasterTypeAndStatus3(masterTypeId, status3);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterTypeAndStatus3(long masterTypeId,
		boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMasterTypeAndStatus3(masterTypeId, status3);
	}

	/**
	* Returns all the master files where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus4(
		long masterTypeId, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMasterTypeAndStatus4(masterTypeId, status4);
	}

	/**
	* Returns a range of all the master files where masterTypeId = &#63; and status4 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @return the range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus4(
		long masterTypeId, boolean status4, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus4(masterTypeId, status4, start, end);
	}

	/**
	* Returns an ordered range of all the master files where masterTypeId = &#63; and status4 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus4(
		long masterTypeId, boolean status4, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus4(masterTypeId, status4, start,
			end, orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus4_First(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus4_First(masterTypeId, status4,
			orderByComparator);
	}

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus4_First(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus4_First(masterTypeId, status4,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus4_Last(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus4_Last(masterTypeId, status4,
			orderByComparator);
	}

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus4_Last(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMasterTypeAndStatus4_Last(masterTypeId, status4,
			orderByComparator);
	}

	/**
	* Returns the master files before and after the current master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterFileId the primary key of the current master file
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus4_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMasterTypeAndStatus4_PrevAndNext(masterFileId,
			masterTypeId, status4, orderByComparator);
	}

	/**
	* Removes all the master files where masterTypeId = &#63; and status4 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMasterTypeAndStatus4(long masterTypeId,
		boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMasterTypeAndStatus4(masterTypeId, status4);
	}

	/**
	* Returns the number of master files where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMasterTypeAndStatus4(long masterTypeId,
		boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMasterTypeAndStatus4(masterTypeId, status4);
	}

	/**
	* Caches the master file in the entity cache if it is enabled.
	*
	* @param masterFile the master file
	*/
	public static void cacheResult(
		com.idetronic.eis.model.MasterFile masterFile) {
		getPersistence().cacheResult(masterFile);
	}

	/**
	* Caches the master files in the entity cache if it is enabled.
	*
	* @param masterFiles the master files
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.MasterFile> masterFiles) {
		getPersistence().cacheResult(masterFiles);
	}

	/**
	* Creates a new master file with the primary key. Does not add the master file to the database.
	*
	* @param masterFileId the primary key for the new master file
	* @return the new master file
	*/
	public static com.idetronic.eis.model.MasterFile create(long masterFileId) {
		return getPersistence().create(masterFileId);
	}

	/**
	* Removes the master file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file that was removed
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile remove(long masterFileId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(masterFileId);
	}

	public static com.idetronic.eis.model.MasterFile updateImpl(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(masterFile);
	}

	/**
	* Returns the master file with the primary key or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile findByPrimaryKey(
		long masterFileId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(masterFileId);
	}

	/**
	* Returns the master file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file, or <code>null</code> if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.MasterFile fetchByPrimaryKey(
		long masterFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(masterFileId);
	}

	/**
	* Returns all the master files.
	*
	* @return the master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.idetronic.eis.model.MasterFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the master files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.MasterFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master files
	* @param end the upper bound of the range of master files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of master files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.MasterFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the master files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of master files.
	*
	* @return the number of master files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MasterFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MasterFilePersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					MasterFilePersistence.class.getName());

			ReferenceRegistry.registerReference(MasterFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MasterFilePersistence persistence) {
	}

	private static MasterFilePersistence _persistence;
}
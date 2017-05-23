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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the master file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterFilePersistenceImpl
 * @see MasterFileUtil
 * @generated
 */
public interface MasterFilePersistence extends BasePersistence<MasterFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterFileUtil} to access the master file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the master files where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, boolean inActive)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, boolean inActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterType(
		long masterTypeId, boolean inActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterType_First(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterType_First(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterType_Last(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterType_Last(
		long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByMasterType_PrevAndNext(
		long masterFileId, long masterTypeId, boolean inActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and inActive = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMasterType(long masterTypeId, boolean inActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and inActive = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param inActive the in active
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByMasterType(long masterTypeId, boolean inActive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent1(
		long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent1(
		long masterTypeId, long parentId1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent1(
		long masterTypeId, long parentId1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByTypeAndParent1_First(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByTypeAndParent1_First(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByTypeAndParent1_Last(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByTypeAndParent1_Last(
		long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByTypeAndParent1_PrevAndNext(
		long masterFileId, long masterTypeId, long parentId1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and parentId1 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndParent1(long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and parentId1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId1 the parent id1
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndParent1(long masterTypeId, long parentId1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent2(
		long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent2(
		long masterTypeId, long parentId2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByTypeAndParent2(
		long masterTypeId, long parentId2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByTypeAndParent2_First(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByTypeAndParent2_First(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByTypeAndParent2_Last(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByTypeAndParent2_Last(
		long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByTypeAndParent2_PrevAndNext(
		long masterFileId, long masterTypeId, long parentId2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and parentId2 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndParent2(long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and parentId2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param parentId2 the parent id2
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndParent2(long masterTypeId, long parentId2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file where masterTypeId = &#63; and masterFileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the master file where masterTypeId = &#63; and masterFileName = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the master file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile removeByMasterTypeAndName(
		long masterTypeId, java.lang.String masterFileName)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and masterFileName = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param masterFileName the master file name
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByMasterTypeAndName(long masterTypeId,
		java.lang.String masterFileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file where masterTypeId = &#63; and oldId = &#63; or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the matching master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile findByOldId(long masterTypeId,
		long oldId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file where masterTypeId = &#63; and oldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByOldId(long masterTypeId,
		long oldId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file where masterTypeId = &#63; and oldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByOldId(long masterTypeId,
		long oldId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the master file where masterTypeId = &#63; and oldId = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the master file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile removeByOldId(long masterTypeId,
		long oldId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and oldId = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param oldId the old ID
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByOldId(long masterTypeId, long oldId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus_First(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus_First(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus_Last(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus_Last(
		long masterTypeId, boolean status1, boolean status2, boolean status3,
		boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status1, boolean status2,
		boolean status3, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByMasterTypeAndStatus(long masterTypeId, boolean status1,
		boolean status2, boolean status3, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByMasterTypeAndStatus(long masterTypeId, boolean status1,
		boolean status2, boolean status3, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus1(
		long masterTypeId, boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus1(
		long masterTypeId, boolean status1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus1(
		long masterTypeId, boolean status1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus1_First(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus1_First(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus1_Last(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus1_Last(
		long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus1_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and status1 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMasterTypeAndStatus1(long masterTypeId, boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and status1 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status1 the status1
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByMasterTypeAndStatus1(long masterTypeId, boolean status1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus2(
		long masterTypeId, boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus2(
		long masterTypeId, boolean status2, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus2(
		long masterTypeId, boolean status2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus2_First(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus2_First(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus2_Last(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus2_Last(
		long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus2_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status2,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and status2 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMasterTypeAndStatus2(long masterTypeId, boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and status2 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status2 the status2
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByMasterTypeAndStatus2(long masterTypeId, boolean status2)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus3(
		long masterTypeId, boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus3(
		long masterTypeId, boolean status3, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus3(
		long masterTypeId, boolean status3, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus3_First(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus3_First(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus3_Last(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus3_Last(
		long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus3_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status3,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and status3 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMasterTypeAndStatus3(long masterTypeId, boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and status3 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status3 the status3
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByMasterTypeAndStatus3(long masterTypeId, boolean status3)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @return the matching master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus4(
		long masterTypeId, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus4(
		long masterTypeId, boolean status4, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findByMasterTypeAndStatus4(
		long masterTypeId, boolean status4, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus4_First(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus4_First(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile findByMasterTypeAndStatus4_Last(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last master file in the ordered set where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching master file, or <code>null</code> if a matching master file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByMasterTypeAndStatus4_Last(
		long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.eis.model.MasterFile[] findByMasterTypeAndStatus4_PrevAndNext(
		long masterFileId, long masterTypeId, boolean status4,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files where masterTypeId = &#63; and status4 = &#63; from the database.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMasterTypeAndStatus4(long masterTypeId, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files where masterTypeId = &#63; and status4 = &#63;.
	*
	* @param masterTypeId the master type ID
	* @param status4 the status4
	* @return the number of matching master files
	* @throws SystemException if a system exception occurred
	*/
	public int countByMasterTypeAndStatus4(long masterTypeId, boolean status4)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the master file in the entity cache if it is enabled.
	*
	* @param masterFile the master file
	*/
	public void cacheResult(com.idetronic.eis.model.MasterFile masterFile);

	/**
	* Caches the master files in the entity cache if it is enabled.
	*
	* @param masterFiles the master files
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.MasterFile> masterFiles);

	/**
	* Creates a new master file with the primary key. Does not add the master file to the database.
	*
	* @param masterFileId the primary key for the new master file
	* @return the new master file
	*/
	public com.idetronic.eis.model.MasterFile create(long masterFileId);

	/**
	* Removes the master file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file that was removed
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile remove(long masterFileId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.MasterFile updateImpl(
		com.idetronic.eis.model.MasterFile masterFile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file with the primary key or throws a {@link com.idetronic.eis.NoSuchMasterFileException} if it could not be found.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file
	* @throws com.idetronic.eis.NoSuchMasterFileException if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile findByPrimaryKey(
		long masterFileId)
		throws com.idetronic.eis.NoSuchMasterFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the master file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param masterFileId the primary key of the master file
	* @return the master file, or <code>null</code> if a master file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.MasterFile fetchByPrimaryKey(
		long masterFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the master files.
	*
	* @return the master files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.MasterFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.eis.model.MasterFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the master files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of master files.
	*
	* @return the number of master files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
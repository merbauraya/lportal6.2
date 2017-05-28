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

package com.idetronic.eis.service.impl;

import java.util.List;

import com.idetronic.eis.NoSuchMasterFileException;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.base.MasterFileLocalServiceBaseImpl;
import com.idetronic.eis.util.EisUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the master file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.MasterFileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.MasterFileLocalServiceBaseImpl
 * @see com.idetronic.eis.service.MasterFileLocalServiceUtil
 */
public class MasterFileLocalServiceImpl extends MasterFileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.MasterFileLocalServiceUtil} to access the master file local service.
	 */
	
	public List<MasterFile> findByMasterType(long masterTypeId,int start,int end) throws SystemException
	{
		return masterFilePersistence.findByMasterType(masterTypeId,false,start,end);
		
	}
	public List<MasterFile> findByMasterFile(long masterTypeId,int start,int end,OrderByComparator ord) throws SystemException
	{
		return masterFilePersistence.findByMasterType(masterTypeId, false,start, end, ord);
	}
	
	
	public List<MasterFile> getAllLibraries() throws SystemException
	{
		long libraryType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_LIBRARY);
		
		return findByMasterType(libraryType,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	}
	
	
	public List<MasterFile> getAllPrintedMaterial() throws SystemException
	{
		long itemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		return findByTypeAndStatus1(itemType,true);

	}
	public List<MasterFile> getAllIrItem() throws SystemException
	{
		long itemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		return findByTypeAndStatus3(itemType,true);

	}
	
	public List<MasterFile> getAllNonPrintedMaterial() throws SystemException
	{
		long itemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
		return findByTypeAndStatus2(itemType,true);

	}
	
	public List<MasterFile> getAllFaculties() throws SystemException
	{
		long itemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ);
		return findByMasterType(itemType,QueryUtil.ALL_POS,QueryUtil.ALL_POS);

	}
	public List<MasterFile> getAllItemMediums() throws SystemException
	{
		long itemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_MEDIUM_TYPE);
		return findByMasterType(itemType,QueryUtil.ALL_POS,QueryUtil.ALL_POS);

	}
	
	public int getCountByMasterType(long masterTypeId) throws SystemException
	{
		return masterFilePersistence.countByMasterType(masterTypeId,false);
		
	}
	
	public List<MasterFile> findByParent1(long masterTypeId,long parentId1) throws SystemException
	{
		return masterFilePersistence.findByTypeAndParent1(masterTypeId,parentId1);
	}
	
	public List<MasterFile> findByParent2(long masterTypeId,long parentId2) throws SystemException
	{
		return masterFilePersistence.findByTypeAndParent2(masterTypeId,parentId2);
	}
	
	public MasterFile findByTypeAndName(long masterTypeId,String name) throws NoSuchMasterFileException, SystemException
	{
		return masterFilePersistence.findByMasterTypeAndName(masterTypeId, name);
	}
	public MasterFile findByTypeOldId(long masterTypeId,long oldId) throws NoSuchMasterFileException, SystemException
	{
		return masterFilePersistence.findByOldId(masterTypeId, oldId);
	}
	
	public List<MasterFile> findByTypeAndStatus(long masterTypeId,boolean status1,boolean status2,boolean status3,boolean status4) throws SystemException
	{
		return masterFilePersistence.findByMasterTypeAndStatus(masterTypeId, status1, status2, status3, status4);
		
	}
	public List<MasterFile> findByTypeAndStatus1(long masterTypeId,boolean status1) throws SystemException
	{
		return masterFilePersistence.findByMasterTypeAndStatus1(masterTypeId, status1);
	}
	public List<MasterFile> findByTypeAndStatus2(long masterTypeId,boolean status2) throws SystemException
	{
		return masterFilePersistence.findByMasterTypeAndStatus2(masterTypeId, status2);
	}
	public List<MasterFile> findByTypeAndStatus3(long masterTypeId,boolean status3) throws SystemException
	{
		return masterFilePersistence.findByMasterTypeAndStatus3(masterTypeId, status3);
	}
	
	public List<MasterFile> findByTypeAndStatus4(long masterTypeId,boolean status4) throws SystemException
	{
		return masterFilePersistence.findByMasterTypeAndStatus4(masterTypeId, status4);
	}
	public List<MasterFile> findByTypeAndStatus5(long masterTypeId,boolean status) throws SystemException
	{
		return masterFilePersistence.findByMasterTypeAndStatus5(masterTypeId, status);
	}
}
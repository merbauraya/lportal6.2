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

import com.idetronic.eis.model.ItemType;
import com.idetronic.eis.service.base.ItemTypeLocalServiceBaseImpl;
import com.idetronic.eis.util.EisUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the item type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.ItemTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.ItemTypeLocalServiceBaseImpl
 * @see com.idetronic.eis.service.ItemTypeLocalServiceUtil
 */
public class ItemTypeLocalServiceImpl extends ItemTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.ItemTypeLocalServiceUtil} to access the item type local service.
	 */
	
	public ItemType add(String itemTypeName,int printedType,
			boolean isIRType,boolean isActive,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(ItemType.class.getName());
		
		ItemType itemType = itemTypePersistence.create(id);
		
		itemType.setItemTypeName(itemTypeName);
		itemType.setPrintedType(printedType);
		itemType.setIRType(isIRType);
		itemType.setActive(isActive);
		
		
		return itemTypePersistence.update(itemType);
		
		
	}
	
	public List<ItemType> getPrintedType(int start,int end) throws SystemException
	{
		
		return itemTypePersistence.findByPrintedType(EisUtil.ITEM_TYPE_PRINTED, start, end);
	}
	
	public List<ItemType> getNonPrintedType(int start,int end) throws SystemException
	{
		
		return itemTypePersistence.findByPrintedType(EisUtil.ITEM_TYPE_NON_PRINTED, start, end);
	}
	
	
	
	public List<ItemType> getIRType(boolean isIRType,int start, int end) throws SystemException
	{
		return itemTypePersistence.findByIRType(isIRType, start, end);
	}
	
	
	
}
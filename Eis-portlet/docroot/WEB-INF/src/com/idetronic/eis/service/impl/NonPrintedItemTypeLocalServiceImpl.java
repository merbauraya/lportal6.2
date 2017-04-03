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

import com.idetronic.eis.model.NonPrintedItemType;
import com.idetronic.eis.model.PrintedItemType;
import com.idetronic.eis.service.base.NonPrintedItemTypeLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the non printed item type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.NonPrintedItemTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.NonPrintedItemTypeLocalServiceBaseImpl
 * @see com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil
 */
public class NonPrintedItemTypeLocalServiceImpl
	extends NonPrintedItemTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil} to access the non printed item type local service.
	 */
	public NonPrintedItemType add(String name) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(PrintedItemType.class.getName());
		
		NonPrintedItemType itemType = nonPrintedItemTypePersistence.create(id);
		itemType.setItemTypeName(name);
		
		return nonPrintedItemTypePersistence.update(itemType);
		
	}
}
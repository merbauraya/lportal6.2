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

import java.util.Date;
import java.util.List;

import com.idetronic.eis.NoSuchLibraryException;
import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.State;
import com.idetronic.eis.service.stateLocalServiceUtil;
import com.idetronic.eis.service.base.LibraryLocalServiceBaseImpl;
import com.idetronic.eis.service.persistence.LibraryFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the library local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.LibraryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.LibraryLocalServiceBaseImpl
 * @see com.idetronic.eis.service.LibraryLocalServiceUtil
 */
public class LibraryLocalServiceImpl extends LibraryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.LibraryLocalServiceUtil} to access the library local service.
	 */
	
	public Library add(long libraryTypeId,String libraryCode,String name,long stateId,ServiceContext serviceContext) throws SystemException
	{
		long id = CounterLocalServiceUtil.increment(Library.class.getName());
		
		Library library = libraryPersistence.create(id);
		
		library.setLibraryTypeId(libraryTypeId);
		library.setLibraryName(name);
		library.setLibraryCode(libraryCode);
		library.setStateId(stateId);
		
		library.setCompanyId(serviceContext.getCompanyId());
		library.setCreateDate(new Date());
		library.setGroupId(serviceContext.getScopeGroupId());
		
		
		
		
		
		
		return libraryPersistence.update(library);
		
		
	}
	public List<Library> findByState(long stateId,int start, int end) throws SystemException
	{
		return libraryPersistence.findByState(stateId, start,end);
	}
	public Library findByName(String name) throws NoSuchLibraryException, SystemException
	{
		return libraryPersistence.findBylibraryName(name);
	}
	public boolean isMissingIRItemData(long libraryId,String period)
	{
		return LibraryFinderUtil.getIrItemCountByLibraryPeriod(libraryId, period) == 0;
	}
	
	public boolean isMissingPrintedItemData(long libraryId,String period)
	{
		return LibraryFinderUtil.getPrintedItemCountByLibraryPeriod(libraryId,period) == 0;
	}
	public boolean isMissingPositionData(long libraryId,String period)
	{
		return LibraryFinderUtil.getPositionCountByLibraryPeriod(libraryId,period) ==0;
	}
	public boolean isMissingVisitorData(long libraryId,String period)
	{
		return LibraryFinderUtil.getVisitorCountByLibraryPeriod(libraryId, period) == 0;
	}
	public boolean isMissingSeatingData(long libraryId,String period)
	{
		return LibraryFinderUtil.getSeatingCountByLibraryPeriod(libraryId, period) == 0;
	}
	public boolean isMissingMembershipData(long libraryId,String period)
	{
		return LibraryFinderUtil.getMembershipCountByLibraryPeriod(libraryId, period) == 0;
	}
	public boolean isMissingNonPrintedItemData(long libraryId,String period)
	{
		return LibraryFinderUtil.getNonPrintedItemCountByLibraryPeriod(libraryId, period) == 0;
	}
	public boolean isMissingLoanData(long libraryId,String period)
	{
		return LibraryFinderUtil.getLoanCountByLibraryPeriod(libraryId,period) == 0;
	}
	
	
}
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
 * Provides a wrapper for {@link SeatingDepartmentService}.
 *
 * @author Mazlan Mat
 * @see SeatingDepartmentService
 * @generated
 */
public class SeatingDepartmentServiceWrapper implements SeatingDepartmentService,
	ServiceWrapper<SeatingDepartmentService> {
	public SeatingDepartmentServiceWrapper(
		SeatingDepartmentService seatingDepartmentService) {
		_seatingDepartmentService = seatingDepartmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _seatingDepartmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_seatingDepartmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _seatingDepartmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SeatingDepartmentService getWrappedSeatingDepartmentService() {
		return _seatingDepartmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSeatingDepartmentService(
		SeatingDepartmentService seatingDepartmentService) {
		_seatingDepartmentService = seatingDepartmentService;
	}

	@Override
	public SeatingDepartmentService getWrappedService() {
		return _seatingDepartmentService;
	}

	@Override
	public void setWrappedService(
		SeatingDepartmentService seatingDepartmentService) {
		_seatingDepartmentService = seatingDepartmentService;
	}

	private SeatingDepartmentService _seatingDepartmentService;
}
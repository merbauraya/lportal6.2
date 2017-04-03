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
 * Provides a wrapper for {@link VisitorCategoryService}.
 *
 * @author Mazlan Mat
 * @see VisitorCategoryService
 * @generated
 */
public class VisitorCategoryServiceWrapper implements VisitorCategoryService,
	ServiceWrapper<VisitorCategoryService> {
	public VisitorCategoryServiceWrapper(
		VisitorCategoryService visitorCategoryService) {
		_visitorCategoryService = visitorCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _visitorCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_visitorCategoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _visitorCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VisitorCategoryService getWrappedVisitorCategoryService() {
		return _visitorCategoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVisitorCategoryService(
		VisitorCategoryService visitorCategoryService) {
		_visitorCategoryService = visitorCategoryService;
	}

	@Override
	public VisitorCategoryService getWrappedService() {
		return _visitorCategoryService;
	}

	@Override
	public void setWrappedService(VisitorCategoryService visitorCategoryService) {
		_visitorCategoryService = visitorCategoryService;
	}

	private VisitorCategoryService _visitorCategoryService;
}
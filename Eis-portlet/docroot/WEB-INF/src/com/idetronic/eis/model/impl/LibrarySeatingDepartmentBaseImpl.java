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

package com.idetronic.eis.model.impl;

import com.idetronic.eis.model.LibrarySeatingDepartment;
import com.idetronic.eis.service.LibrarySeatingDepartmentLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the LibrarySeatingDepartment service. Represents a row in the &quot;eis_LibrarySeatingDepartment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LibrarySeatingDepartmentImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see LibrarySeatingDepartmentImpl
 * @see com.idetronic.eis.model.LibrarySeatingDepartment
 * @generated
 */
public abstract class LibrarySeatingDepartmentBaseImpl
	extends LibrarySeatingDepartmentModelImpl
	implements LibrarySeatingDepartment {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a library seating department model instance should use the {@link LibrarySeatingDepartment} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LibrarySeatingDepartmentLocalServiceUtil.addLibrarySeatingDepartment(this);
		}
		else {
			LibrarySeatingDepartmentLocalServiceUtil.updateLibrarySeatingDepartment(this);
		}
	}
}
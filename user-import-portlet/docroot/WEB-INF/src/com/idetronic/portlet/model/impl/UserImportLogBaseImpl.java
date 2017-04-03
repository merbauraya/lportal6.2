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

package com.idetronic.portlet.model.impl;

import com.idetronic.portlet.model.UserImportLog;
import com.idetronic.portlet.service.UserImportLogLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the UserImportLog service. Represents a row in the &quot;sims_UserImportLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserImportLogImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserImportLogImpl
 * @see com.idetronic.portlet.model.UserImportLog
 * @generated
 */
public abstract class UserImportLogBaseImpl extends UserImportLogModelImpl
	implements UserImportLog {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user import log model instance should use the {@link UserImportLog} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserImportLogLocalServiceUtil.addUserImportLog(this);
		}
		else {
			UserImportLogLocalServiceUtil.updateUserImportLog(this);
		}
	}
}
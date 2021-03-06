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

import com.idetronic.eis.model.FactExpense;
import com.idetronic.eis.service.FactExpenseLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Mazlan Mat
 * @generated
 */
public abstract class FactExpenseActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public FactExpenseActionableDynamicQuery() throws SystemException {
		setBaseLocalService(FactExpenseLocalServiceUtil.getService());
		setClass(FactExpense.class);

		setClassLoader(com.idetronic.eis.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("factExpenseId");
	}
}
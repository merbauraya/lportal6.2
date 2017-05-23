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

import com.idetronic.eis.model.FactExpense;
import com.idetronic.eis.service.FactExpenseLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the FactExpense service. Represents a row in the &quot;eis_FactExpense&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FactExpenseImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactExpenseImpl
 * @see com.idetronic.eis.model.FactExpense
 * @generated
 */
public abstract class FactExpenseBaseImpl extends FactExpenseModelImpl
	implements FactExpense {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fact expense model instance should use the {@link FactExpense} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactExpenseLocalServiceUtil.addFactExpense(this);
		}
		else {
			FactExpenseLocalServiceUtil.updateFactExpense(this);
		}
	}
}
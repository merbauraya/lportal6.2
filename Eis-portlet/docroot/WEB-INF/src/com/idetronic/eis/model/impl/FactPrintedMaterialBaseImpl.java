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

import com.idetronic.eis.model.FactPrintedMaterial;
import com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the FactPrintedMaterial service. Represents a row in the &quot;eis_FactPrintedMaterial&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FactPrintedMaterialImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPrintedMaterialImpl
 * @see com.idetronic.eis.model.FactPrintedMaterial
 * @generated
 */
public abstract class FactPrintedMaterialBaseImpl
	extends FactPrintedMaterialModelImpl implements FactPrintedMaterial {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fact printed material model instance should use the {@link FactPrintedMaterial} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FactPrintedMaterialLocalServiceUtil.addFactPrintedMaterial(this);
		}
		else {
			FactPrintedMaterialLocalServiceUtil.updateFactPrintedMaterial(this);
		}
	}
}
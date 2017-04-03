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

import com.idetronic.eis.model.Config;
import com.idetronic.eis.service.ConfigLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Config service. Represents a row in the &quot;eis_Config&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConfigImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ConfigImpl
 * @see com.idetronic.eis.model.Config
 * @generated
 */
public abstract class ConfigBaseImpl extends ConfigModelImpl implements Config {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a config model instance should use the {@link Config} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConfigLocalServiceUtil.addConfig(this);
		}
		else {
			ConfigLocalServiceUtil.updateConfig(this);
		}
	}
}
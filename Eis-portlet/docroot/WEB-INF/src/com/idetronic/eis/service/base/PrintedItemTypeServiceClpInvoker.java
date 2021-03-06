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

package com.idetronic.eis.service.base;

import com.idetronic.eis.service.PrintedItemTypeServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class PrintedItemTypeServiceClpInvoker {
	public PrintedItemTypeServiceClpInvoker() {
		_methodName216 = "getBeanIdentifier";

		_methodParameterTypes216 = new String[] {  };

		_methodName217 = "setBeanIdentifier";

		_methodParameterTypes217 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return PrintedItemTypeServiceUtil.getBeanIdentifier();
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			PrintedItemTypeServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName216;
	private String[] _methodParameterTypes216;
	private String _methodName217;
	private String[] _methodParameterTypes217;
}
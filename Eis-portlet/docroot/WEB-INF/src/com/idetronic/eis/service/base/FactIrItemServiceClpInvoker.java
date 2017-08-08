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

import com.idetronic.eis.service.FactIrItemServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class FactIrItemServiceClpInvoker {
	public FactIrItemServiceClpInvoker() {
		_methodName350 = "getBeanIdentifier";

		_methodParameterTypes350 = new String[] {  };

		_methodName351 = "setBeanIdentifier";

		_methodParameterTypes351 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName350.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes350, parameterTypes)) {
			return FactIrItemServiceUtil.getBeanIdentifier();
		}

		if (_methodName351.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes351, parameterTypes)) {
			FactIrItemServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName350;
	private String[] _methodParameterTypes350;
	private String _methodName351;
	private String[] _methodParameterTypes351;
}
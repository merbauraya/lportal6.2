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

import com.idetronic.eis.service.PostServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class PostServiceClpInvoker {
	public PostServiceClpInvoker() {
		_methodName112 = "getBeanIdentifier";

		_methodParameterTypes112 = new String[] {  };

		_methodName113 = "setBeanIdentifier";

		_methodParameterTypes113 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return PostServiceUtil.getBeanIdentifier();
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			PostServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
}
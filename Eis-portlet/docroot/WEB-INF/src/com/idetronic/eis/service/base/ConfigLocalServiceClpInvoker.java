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

import com.idetronic.eis.service.ConfigLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class ConfigLocalServiceClpInvoker {
	public ConfigLocalServiceClpInvoker() {
		_methodName0 = "addConfig";

		_methodParameterTypes0 = new String[] { "com.idetronic.eis.model.Config" };

		_methodName1 = "createConfig";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteConfig";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteConfig";

		_methodParameterTypes3 = new String[] { "com.idetronic.eis.model.Config" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchConfig";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getConfig";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getConfigs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getConfigsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateConfig";

		_methodParameterTypes15 = new String[] { "com.idetronic.eis.model.Config" };

		_methodName272 = "getBeanIdentifier";

		_methodParameterTypes272 = new String[] {  };

		_methodName273 = "setBeanIdentifier";

		_methodParameterTypes273 = new String[] { "java.lang.String" };

		_methodName278 = "add";

		_methodParameterTypes278 = new String[] {
				"java.lang.String", "java.util.Properties"
			};

		_methodName279 = "addByStringValue";

		_methodParameterTypes279 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName280 = "getKeyAsLong";

		_methodParameterTypes280 = new String[] { "java.lang.String" };

		_methodName281 = "getByKeyAsString";

		_methodParameterTypes281 = new String[] { "java.lang.String" };

		_methodName282 = "getByKey";

		_methodParameterTypes282 = new String[] { "java.lang.String" };

		_methodName283 = "deleteByKeyWildcard";

		_methodParameterTypes283 = new String[] { "java.lang.String" };

		_methodName284 = "findWithKeyWildcard";

		_methodParameterTypes284 = new String[] { "java.lang.String", "int", "int" };

		_methodName285 = "countByKeyWildCard";

		_methodParameterTypes285 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ConfigLocalServiceUtil.addConfig((com.idetronic.eis.model.Config)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ConfigLocalServiceUtil.createConfig(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ConfigLocalServiceUtil.deleteConfig(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ConfigLocalServiceUtil.deleteConfig((com.idetronic.eis.model.Config)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ConfigLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ConfigLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ConfigLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ConfigLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ConfigLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ConfigLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ConfigLocalServiceUtil.fetchConfig(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ConfigLocalServiceUtil.getConfig(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ConfigLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ConfigLocalServiceUtil.getConfigs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ConfigLocalServiceUtil.getConfigsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ConfigLocalServiceUtil.updateConfig((com.idetronic.eis.model.Config)arguments[0]);
		}

		if (_methodName272.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes272, parameterTypes)) {
			return ConfigLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName273.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes273, parameterTypes)) {
			ConfigLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName278.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes278, parameterTypes)) {
			return ConfigLocalServiceUtil.add((java.lang.String)arguments[0],
				(java.util.Properties)arguments[1]);
		}

		if (_methodName279.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes279, parameterTypes)) {
			return ConfigLocalServiceUtil.addByStringValue((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName280.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
			return ConfigLocalServiceUtil.getKeyAsLong((java.lang.String)arguments[0]);
		}

		if (_methodName281.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
			return ConfigLocalServiceUtil.getByKeyAsString((java.lang.String)arguments[0]);
		}

		if (_methodName282.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes282, parameterTypes)) {
			return ConfigLocalServiceUtil.getByKey((java.lang.String)arguments[0]);
		}

		if (_methodName283.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes283, parameterTypes)) {
			ConfigLocalServiceUtil.deleteByKeyWildcard((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName284.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes284, parameterTypes)) {
			return ConfigLocalServiceUtil.findWithKeyWildcard((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName285.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes285, parameterTypes)) {
			return ConfigLocalServiceUtil.countByKeyWildCard((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName272;
	private String[] _methodParameterTypes272;
	private String _methodName273;
	private String[] _methodParameterTypes273;
	private String _methodName278;
	private String[] _methodParameterTypes278;
	private String _methodName279;
	private String[] _methodParameterTypes279;
	private String _methodName280;
	private String[] _methodParameterTypes280;
	private String _methodName281;
	private String[] _methodParameterTypes281;
	private String _methodName282;
	private String[] _methodParameterTypes282;
	private String _methodName283;
	private String[] _methodParameterTypes283;
	private String _methodName284;
	private String[] _methodParameterTypes284;
	private String _methodName285;
	private String[] _methodParameterTypes285;
}
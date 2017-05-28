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

import com.idetronic.eis.service.KpiEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class KpiEntryLocalServiceClpInvoker {
	public KpiEntryLocalServiceClpInvoker() {
		_methodName0 = "addKpiEntry";

		_methodParameterTypes0 = new String[] { "com.idetronic.eis.model.KpiEntry" };

		_methodName1 = "createKpiEntry";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteKpiEntry";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteKpiEntry";

		_methodParameterTypes3 = new String[] { "com.idetronic.eis.model.KpiEntry" };

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

		_methodName10 = "fetchKpiEntry";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getKpiEntry";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getKpiEntries";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getKpiEntriesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateKpiEntry";

		_methodParameterTypes15 = new String[] {
				"com.idetronic.eis.model.KpiEntry"
			};

		_methodName280 = "getBeanIdentifier";

		_methodParameterTypes280 = new String[] {  };

		_methodName281 = "setBeanIdentifier";

		_methodParameterTypes281 = new String[] { "java.lang.String" };

		_methodName286 = "add";

		_methodParameterTypes286 = new String[] {
				"long", "java.lang.String", "int", "java.lang.String", "double",
				"double"
			};

		_methodName287 = "batchInsert";

		_methodParameterTypes287 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.kernel.json.JSONArray",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName288 = "findByYearPeriodType";

		_methodParameterTypes288 = new String[] {
				"long", "java.lang.String", "int"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return KpiEntryLocalServiceUtil.addKpiEntry((com.idetronic.eis.model.KpiEntry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return KpiEntryLocalServiceUtil.createKpiEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return KpiEntryLocalServiceUtil.deleteKpiEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return KpiEntryLocalServiceUtil.deleteKpiEntry((com.idetronic.eis.model.KpiEntry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return KpiEntryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return KpiEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return KpiEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return KpiEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return KpiEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return KpiEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return KpiEntryLocalServiceUtil.fetchKpiEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return KpiEntryLocalServiceUtil.getKpiEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return KpiEntryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return KpiEntryLocalServiceUtil.getKpiEntries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return KpiEntryLocalServiceUtil.getKpiEntriesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return KpiEntryLocalServiceUtil.updateKpiEntry((com.idetronic.eis.model.KpiEntry)arguments[0]);
		}

		if (_methodName280.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
			return KpiEntryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName281.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
			KpiEntryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName286.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
			return KpiEntryLocalServiceUtil.add(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3],
				((Double)arguments[4]).doubleValue(),
				((Double)arguments[5]).doubleValue());
		}

		if (_methodName287.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes287, parameterTypes)) {
			KpiEntryLocalServiceUtil.batchInsert(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(com.liferay.portal.kernel.json.JSONArray)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);

			return null;
		}

		if (_methodName288.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes288, parameterTypes)) {
			return KpiEntryLocalServiceUtil.findByYearPeriodType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
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
	private String _methodName280;
	private String[] _methodParameterTypes280;
	private String _methodName281;
	private String[] _methodParameterTypes281;
	private String _methodName286;
	private String[] _methodParameterTypes286;
	private String _methodName287;
	private String[] _methodParameterTypes287;
	private String _methodName288;
	private String[] _methodParameterTypes288;
}
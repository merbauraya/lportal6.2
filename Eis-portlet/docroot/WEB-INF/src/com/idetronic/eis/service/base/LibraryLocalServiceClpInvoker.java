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

import com.idetronic.eis.service.LibraryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class LibraryLocalServiceClpInvoker {
	public LibraryLocalServiceClpInvoker() {
		_methodName0 = "addLibrary";

		_methodParameterTypes0 = new String[] { "com.idetronic.eis.model.Library" };

		_methodName1 = "createLibrary";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLibrary";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLibrary";

		_methodParameterTypes3 = new String[] { "com.idetronic.eis.model.Library" };

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

		_methodName10 = "fetchLibrary";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLibrary";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLibraries";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLibrariesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLibrary";

		_methodParameterTypes15 = new String[] { "com.idetronic.eis.model.Library" };

		_methodName280 = "getBeanIdentifier";

		_methodParameterTypes280 = new String[] {  };

		_methodName281 = "setBeanIdentifier";

		_methodParameterTypes281 = new String[] { "java.lang.String" };

		_methodName286 = "add";

		_methodParameterTypes286 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName287 = "findByState";

		_methodParameterTypes287 = new String[] { "long", "int", "int" };

		_methodName288 = "findByName";

		_methodParameterTypes288 = new String[] { "java.lang.String" };

		_methodName289 = "isMissingIRItemData";

		_methodParameterTypes289 = new String[] { "long", "java.lang.String" };

		_methodName290 = "isMissingPrintedItemData";

		_methodParameterTypes290 = new String[] { "long", "java.lang.String" };

		_methodName291 = "isMissingPositionData";

		_methodParameterTypes291 = new String[] { "long", "java.lang.String" };

		_methodName292 = "isMissingVisitorData";

		_methodParameterTypes292 = new String[] { "long", "java.lang.String" };

		_methodName293 = "isMissingSeatingData";

		_methodParameterTypes293 = new String[] { "long", "java.lang.String" };

		_methodName294 = "isMissingMembershipData";

		_methodParameterTypes294 = new String[] { "long", "java.lang.String" };

		_methodName295 = "isMissingNonPrintedItemData";

		_methodParameterTypes295 = new String[] { "long", "java.lang.String" };

		_methodName296 = "isMissingLoanData";

		_methodParameterTypes296 = new String[] { "long", "java.lang.String" };

		_methodName297 = "isMissingExpenseData";

		_methodParameterTypes297 = new String[] { "long", "java.lang.String" };

		_methodName298 = "isMissingConsultationData";

		_methodParameterTypes298 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LibraryLocalServiceUtil.addLibrary((com.idetronic.eis.model.Library)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LibraryLocalServiceUtil.createLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LibraryLocalServiceUtil.deleteLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LibraryLocalServiceUtil.deleteLibrary((com.idetronic.eis.model.Library)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LibraryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LibraryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LibraryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LibraryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LibraryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LibraryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LibraryLocalServiceUtil.fetchLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LibraryLocalServiceUtil.getLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LibraryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LibraryLocalServiceUtil.getLibraries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LibraryLocalServiceUtil.getLibrariesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LibraryLocalServiceUtil.updateLibrary((com.idetronic.eis.model.Library)arguments[0]);
		}

		if (_methodName280.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
			return LibraryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName281.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
			LibraryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName286.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
			return LibraryLocalServiceUtil.add(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName287.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes287, parameterTypes)) {
			return LibraryLocalServiceUtil.findByState(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName288.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes288, parameterTypes)) {
			return LibraryLocalServiceUtil.findByName((java.lang.String)arguments[0]);
		}

		if (_methodName289.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes289, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingIRItemData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName290.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes290, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingPrintedItemData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName291.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes291, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingPositionData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName292.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes292, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingVisitorData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName293.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes293, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingSeatingData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName294.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes294, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingMembershipData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName295.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes295, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingNonPrintedItemData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName296.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes296, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingLoanData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName297.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes297, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingExpenseData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName298.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes298, parameterTypes)) {
			return LibraryLocalServiceUtil.isMissingConsultationData(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
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
	private String _methodName289;
	private String[] _methodParameterTypes289;
	private String _methodName290;
	private String[] _methodParameterTypes290;
	private String _methodName291;
	private String[] _methodParameterTypes291;
	private String _methodName292;
	private String[] _methodParameterTypes292;
	private String _methodName293;
	private String[] _methodParameterTypes293;
	private String _methodName294;
	private String[] _methodParameterTypes294;
	private String _methodName295;
	private String[] _methodParameterTypes295;
	private String _methodName296;
	private String[] _methodParameterTypes296;
	private String _methodName297;
	private String[] _methodParameterTypes297;
	private String _methodName298;
	private String[] _methodParameterTypes298;
}
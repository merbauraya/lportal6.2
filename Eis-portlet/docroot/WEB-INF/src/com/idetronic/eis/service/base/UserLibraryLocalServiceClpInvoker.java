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

import com.idetronic.eis.service.UserLibraryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mazlan Mat
 * @generated
 */
public class UserLibraryLocalServiceClpInvoker {
	public UserLibraryLocalServiceClpInvoker() {
		_methodName0 = "addUserLibrary";

		_methodParameterTypes0 = new String[] {
				"com.idetronic.eis.model.UserLibrary"
			};

		_methodName1 = "createUserLibrary";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteUserLibrary";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteUserLibrary";

		_methodParameterTypes3 = new String[] {
				"com.idetronic.eis.model.UserLibrary"
			};

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

		_methodName10 = "fetchUserLibrary";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getUserLibrary";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getUserLibraries";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getUserLibrariesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateUserLibrary";

		_methodParameterTypes15 = new String[] {
				"com.idetronic.eis.model.UserLibrary"
			};

		_methodName280 = "getBeanIdentifier";

		_methodParameterTypes280 = new String[] {  };

		_methodName281 = "setBeanIdentifier";

		_methodParameterTypes281 = new String[] { "java.lang.String" };

		_methodName286 = "add";

		_methodParameterTypes286 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName287 = "add";

		_methodParameterTypes287 = new String[] {
				"long", "long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName288 = "remove";

		_methodParameterTypes288 = new String[] { "long", "long" };

		_methodName289 = "findByLibrary";

		_methodParameterTypes289 = new String[] { "long", "int", "int" };

		_methodName290 = "findByUser";

		_methodParameterTypes290 = new String[] { "long", "int", "int" };

		_methodName291 = "hasAssociation";

		_methodParameterTypes291 = new String[] { "long", "long" };

		_methodName292 = "updateAssociationByUser";

		_methodParameterTypes292 = new String[] {
				"long", "long[][]", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName293 = "updateAssociation";

		_methodParameterTypes293 = new String[] {
				"long", "long[][]", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName294 = "countByLibrary";

		_methodParameterTypes294 = new String[] { "long" };

		_methodName295 = "getLibraryByUser2";

		_methodParameterTypes295 = new String[] { "long" };

		_methodName296 = "getLibraryByUser";

		_methodParameterTypes296 = new String[] { "long" };

		_methodName297 = "findByLibrary";

		_methodParameterTypes297 = new String[] { "long" };

		_methodName298 = "getDistinctUser";

		_methodParameterTypes298 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return UserLibraryLocalServiceUtil.addUserLibrary((com.idetronic.eis.model.UserLibrary)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return UserLibraryLocalServiceUtil.createUserLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return UserLibraryLocalServiceUtil.deleteUserLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return UserLibraryLocalServiceUtil.deleteUserLibrary((com.idetronic.eis.model.UserLibrary)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return UserLibraryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return UserLibraryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return UserLibraryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return UserLibraryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return UserLibraryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return UserLibraryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return UserLibraryLocalServiceUtil.fetchUserLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getUserLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getUserLibraries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getUserLibrariesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return UserLibraryLocalServiceUtil.updateUserLibrary((com.idetronic.eis.model.UserLibrary)arguments[0]);
		}

		if (_methodName280.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes280, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName281.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes281, parameterTypes)) {
			UserLibraryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName286.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes286, parameterTypes)) {
			return UserLibraryLocalServiceUtil.add(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName287.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes287, parameterTypes)) {
			UserLibraryLocalServiceUtil.add(((Long)arguments[0]).longValue(),
				(long[])arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName288.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes288, parameterTypes)) {
			UserLibraryLocalServiceUtil.remove(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName289.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes289, parameterTypes)) {
			return UserLibraryLocalServiceUtil.findByLibrary(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName290.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes290, parameterTypes)) {
			return UserLibraryLocalServiceUtil.findByUser(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName291.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes291, parameterTypes)) {
			return UserLibraryLocalServiceUtil.hasAssociation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName292.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes292, parameterTypes)) {
			UserLibraryLocalServiceUtil.updateAssociationByUser(((Long)arguments[0]).longValue(),
				(long[])arguments[1], (long[])arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);

			return null;
		}

		if (_methodName293.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes293, parameterTypes)) {
			UserLibraryLocalServiceUtil.updateAssociation(((Long)arguments[0]).longValue(),
				(long[])arguments[1], (long[])arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);

			return null;
		}

		if (_methodName294.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes294, parameterTypes)) {
			return UserLibraryLocalServiceUtil.countByLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName295.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes295, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getLibraryByUser2(((Long)arguments[0]).longValue());
		}

		if (_methodName296.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes296, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getLibraryByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName297.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes297, parameterTypes)) {
			return UserLibraryLocalServiceUtil.findByLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName298.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes298, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getDistinctUser();
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
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

		_methodName366 = "getBeanIdentifier";

		_methodParameterTypes366 = new String[] {  };

		_methodName367 = "setBeanIdentifier";

		_methodParameterTypes367 = new String[] { "java.lang.String" };

		_methodName372 = "add";

		_methodParameterTypes372 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName373 = "add";

		_methodParameterTypes373 = new String[] {
				"long", "long[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName374 = "remove";

		_methodParameterTypes374 = new String[] { "long", "long" };

		_methodName375 = "findByLibrary";

		_methodParameterTypes375 = new String[] { "long", "int", "int" };

		_methodName376 = "findByUser";

		_methodParameterTypes376 = new String[] { "long", "int", "int" };

		_methodName377 = "hasAssociation";

		_methodParameterTypes377 = new String[] { "long", "long" };

		_methodName378 = "updateAssociationByUser";

		_methodParameterTypes378 = new String[] {
				"long", "long[][]", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName379 = "updateAssociation";

		_methodParameterTypes379 = new String[] {
				"long", "long[][]", "long[][]",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName380 = "countByLibrary";

		_methodParameterTypes380 = new String[] { "long" };

		_methodName381 = "getLibraryByUser2";

		_methodParameterTypes381 = new String[] { "long" };

		_methodName382 = "getLibraryByUser";

		_methodParameterTypes382 = new String[] { "long" };

		_methodName383 = "findByLibrary";

		_methodParameterTypes383 = new String[] { "long" };

		_methodName384 = "getDistinctUser";

		_methodParameterTypes384 = new String[] {  };
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

		if (_methodName366.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes366, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName367.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes367, parameterTypes)) {
			UserLibraryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName372.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes372, parameterTypes)) {
			return UserLibraryLocalServiceUtil.add(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName373.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes373, parameterTypes)) {
			UserLibraryLocalServiceUtil.add(((Long)arguments[0]).longValue(),
				(long[])arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName374.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes374, parameterTypes)) {
			UserLibraryLocalServiceUtil.remove(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName375.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes375, parameterTypes)) {
			return UserLibraryLocalServiceUtil.findByLibrary(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName376.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes376, parameterTypes)) {
			return UserLibraryLocalServiceUtil.findByUser(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName377.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes377, parameterTypes)) {
			return UserLibraryLocalServiceUtil.hasAssociation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName378.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes378, parameterTypes)) {
			UserLibraryLocalServiceUtil.updateAssociationByUser(((Long)arguments[0]).longValue(),
				(long[])arguments[1], (long[])arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);

			return null;
		}

		if (_methodName379.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes379, parameterTypes)) {
			UserLibraryLocalServiceUtil.updateAssociation(((Long)arguments[0]).longValue(),
				(long[])arguments[1], (long[])arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);

			return null;
		}

		if (_methodName380.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes380, parameterTypes)) {
			return UserLibraryLocalServiceUtil.countByLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName381.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes381, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getLibraryByUser2(((Long)arguments[0]).longValue());
		}

		if (_methodName382.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes382, parameterTypes)) {
			return UserLibraryLocalServiceUtil.getLibraryByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName383.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes383, parameterTypes)) {
			return UserLibraryLocalServiceUtil.findByLibrary(((Long)arguments[0]).longValue());
		}

		if (_methodName384.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes384, parameterTypes)) {
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
	private String _methodName366;
	private String[] _methodParameterTypes366;
	private String _methodName367;
	private String[] _methodParameterTypes367;
	private String _methodName372;
	private String[] _methodParameterTypes372;
	private String _methodName373;
	private String[] _methodParameterTypes373;
	private String _methodName374;
	private String[] _methodParameterTypes374;
	private String _methodName375;
	private String[] _methodParameterTypes375;
	private String _methodName376;
	private String[] _methodParameterTypes376;
	private String _methodName377;
	private String[] _methodParameterTypes377;
	private String _methodName378;
	private String[] _methodParameterTypes378;
	private String _methodName379;
	private String[] _methodParameterTypes379;
	private String _methodName380;
	private String[] _methodParameterTypes380;
	private String _methodName381;
	private String[] _methodParameterTypes381;
	private String _methodName382;
	private String[] _methodParameterTypes382;
	private String _methodName383;
	private String[] _methodParameterTypes383;
	private String _methodName384;
	private String[] _methodParameterTypes384;
}
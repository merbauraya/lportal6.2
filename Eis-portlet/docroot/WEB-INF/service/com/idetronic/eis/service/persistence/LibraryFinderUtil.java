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

package com.idetronic.eis.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Mazlan Mat
 */
public class LibraryFinderUtil {
	public static java.util.List<com.idetronic.eis.model.Library> findMissingPrintedMaterialDataByPeriod(
		java.lang.String period) {
		return getFinder().findMissingPrintedMaterialDataByPeriod(period);
	}

	public static int getPrintedItemCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getPrintedItemCountByLibraryPeriod(libraryId, period);
	}

	public static int getNonPrintedItemCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder()
				   .getNonPrintedItemCountByLibraryPeriod(libraryId, period);
	}

	public static int getPositionCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getPositionCountByLibraryPeriod(libraryId, period);
	}

	public static int getMembershipCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getMembershipCountByLibraryPeriod(libraryId, period);
	}

	public static int getSeatingCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getSeatingCountByLibraryPeriod(libraryId, period);
	}

	public static int getVisitorCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getVisitorCountByLibraryPeriod(libraryId, period);
	}

	public static int getLoanCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getLoanCountByLibraryPeriod(libraryId, period);
	}

	public static int getIrItemCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getIrItemCountByLibraryPeriod(libraryId, period);
	}

	public static LibraryFinder getFinder() {
		if (_finder == null) {
			_finder = (LibraryFinder)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					LibraryFinder.class.getName());

			ReferenceRegistry.registerReference(LibraryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LibraryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LibraryFinderUtil.class, "_finder");
	}

	private static LibraryFinder _finder;
}
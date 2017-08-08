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
public class FactAcquisitionFinderUtil {
	public static java.util.List<com.idetronic.eis.model.FactAcquisition> getLatestEntry(
		long libraryId, long facultyId, java.lang.String period) {
		return getFinder().getLatestEntry(libraryId, facultyId, period);
	}

	public static java.util.List getHistory(long libraryId, long facultyId,
		java.lang.String period) {
		return getFinder().getHistory(libraryId, facultyId, period);
	}

	public static int getItemCountByLibraryPeriod(long libraryId,
		java.lang.String period) {
		return getFinder().getItemCountByLibraryPeriod(libraryId, period);
	}

	public static int getItemCountByPeriod(java.lang.String period) {
		return getFinder().getItemCountByPeriod(period);
	}

	public static FactAcquisitionFinder getFinder() {
		if (_finder == null) {
			_finder = (FactAcquisitionFinder)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactAcquisitionFinder.class.getName());

			ReferenceRegistry.registerReference(FactAcquisitionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FactAcquisitionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FactAcquisitionFinderUtil.class,
			"_finder");
	}

	private static FactAcquisitionFinder _finder;
}
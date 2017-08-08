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
public class FactDataFinderUtil {
	public static java.util.List<com.idetronic.eis.model.FactData> getLatestEntry(
		long reportId, long libraryId, java.lang.String period) {
		return getFinder().getLatestEntry(reportId, libraryId, period);
	}

	public static java.util.List getHistory(long reportId, long libraryId,
		java.lang.String period) {
		return getFinder().getHistory(reportId, libraryId, period);
	}

	public static FactDataFinder getFinder() {
		if (_finder == null) {
			_finder = (FactDataFinder)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					FactDataFinder.class.getName());

			ReferenceRegistry.registerReference(FactDataFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FactDataFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FactDataFinderUtil.class, "_finder");
	}

	private static FactDataFinder _finder;
}
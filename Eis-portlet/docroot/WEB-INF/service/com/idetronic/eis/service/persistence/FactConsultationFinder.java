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

/**
 * @author Mazlan Mat
 */
public interface FactConsultationFinder {
	public java.util.List<com.idetronic.eis.model.FactConsultation> getLatestEntry(
		long libraryId, java.lang.String period);

	public java.util.List getHistory(long libraryId, java.lang.String period);

	public int getDataCount(long libraryId, java.lang.String period);
}
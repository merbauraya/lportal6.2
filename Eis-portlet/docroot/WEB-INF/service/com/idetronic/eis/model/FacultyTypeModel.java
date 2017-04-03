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

package com.idetronic.eis.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the FacultyType service. Represents a row in the &quot;eis_FacultyType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FacultyTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FacultyTypeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FacultyType
 * @see com.idetronic.eis.model.impl.FacultyTypeImpl
 * @see com.idetronic.eis.model.impl.FacultyTypeModelImpl
 * @generated
 */
public interface FacultyTypeModel extends BaseModel<FacultyType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faculty type model instance should use the {@link FacultyType} interface instead.
	 */

	/**
	 * Returns the primary key of this faculty type.
	 *
	 * @return the primary key of this faculty type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faculty type.
	 *
	 * @param primaryKey the primary key of this faculty type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the faculty type ID of this faculty type.
	 *
	 * @return the faculty type ID of this faculty type
	 */
	public long getFacultyTypeId();

	/**
	 * Sets the faculty type ID of this faculty type.
	 *
	 * @param facultyTypeId the faculty type ID of this faculty type
	 */
	public void setFacultyTypeId(long facultyTypeId);

	/**
	 * Returns the faculty type name of this faculty type.
	 *
	 * @return the faculty type name of this faculty type
	 */
	@AutoEscape
	public String getFacultyTypeName();

	/**
	 * Sets the faculty type name of this faculty type.
	 *
	 * @param facultyTypeName the faculty type name of this faculty type
	 */
	public void setFacultyTypeName(String facultyTypeName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.idetronic.eis.model.FacultyType facultyType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FacultyType> toCacheModel();

	@Override
	public com.idetronic.eis.model.FacultyType toEscapedModel();

	@Override
	public com.idetronic.eis.model.FacultyType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FactSeating service. Represents a row in the &quot;eis_FactSeating&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FactSeatingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FactSeatingImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactSeating
 * @see com.idetronic.eis.model.impl.FactSeatingImpl
 * @see com.idetronic.eis.model.impl.FactSeatingModelImpl
 * @generated
 */
public interface FactSeatingModel extends BaseModel<FactSeating> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fact seating model instance should use the {@link FactSeating} interface instead.
	 */

	/**
	 * Returns the primary key of this fact seating.
	 *
	 * @return the primary key of this fact seating
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fact seating.
	 *
	 * @param primaryKey the primary key of this fact seating
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fact seating ID of this fact seating.
	 *
	 * @return the fact seating ID of this fact seating
	 */
	public long getFactSeatingId();

	/**
	 * Sets the fact seating ID of this fact seating.
	 *
	 * @param factSeatingId the fact seating ID of this fact seating
	 */
	public void setFactSeatingId(long factSeatingId);

	/**
	 * Returns the library ID of this fact seating.
	 *
	 * @return the library ID of this fact seating
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this fact seating.
	 *
	 * @param libraryId the library ID of this fact seating
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the department ID of this fact seating.
	 *
	 * @return the department ID of this fact seating
	 */
	public long getDepartmentId();

	/**
	 * Sets the department ID of this fact seating.
	 *
	 * @param departmentId the department ID of this fact seating
	 */
	public void setDepartmentId(long departmentId);

	/**
	 * Returns the seating category ID of this fact seating.
	 *
	 * @return the seating category ID of this fact seating
	 */
	public long getSeatingCategoryId();

	/**
	 * Sets the seating category ID of this fact seating.
	 *
	 * @param seatingCategoryId the seating category ID of this fact seating
	 */
	public void setSeatingCategoryId(long seatingCategoryId);

	/**
	 * Returns the state ID of this fact seating.
	 *
	 * @return the state ID of this fact seating
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this fact seating.
	 *
	 * @param stateId the state ID of this fact seating
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the library type ID of this fact seating.
	 *
	 * @return the library type ID of this fact seating
	 */
	public long getLibraryTypeId();

	/**
	 * Sets the library type ID of this fact seating.
	 *
	 * @param libraryTypeId the library type ID of this fact seating
	 */
	public void setLibraryTypeId(long libraryTypeId);

	/**
	 * Returns the period of this fact seating.
	 *
	 * @return the period of this fact seating
	 */
	@AutoEscape
	public String getPeriod();

	/**
	 * Sets the period of this fact seating.
	 *
	 * @param period the period of this fact seating
	 */
	public void setPeriod(String period);

	/**
	 * Returns the capacity of this fact seating.
	 *
	 * @return the capacity of this fact seating
	 */
	public int getCapacity();

	/**
	 * Sets the capacity of this fact seating.
	 *
	 * @param capacity the capacity of this fact seating
	 */
	public void setCapacity(int capacity);

	/**
	 * Returns the company ID of this fact seating.
	 *
	 * @return the company ID of this fact seating
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this fact seating.
	 *
	 * @param companyId the company ID of this fact seating
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this fact seating.
	 *
	 * @return the group ID of this fact seating
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this fact seating.
	 *
	 * @param groupId the group ID of this fact seating
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this fact seating.
	 *
	 * @return the user ID of this fact seating
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this fact seating.
	 *
	 * @param userId the user ID of this fact seating
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fact seating.
	 *
	 * @return the user uuid of this fact seating
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fact seating.
	 *
	 * @param userUuid the user uuid of this fact seating
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fact seating.
	 *
	 * @return the user name of this fact seating
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this fact seating.
	 *
	 * @param userName the user name of this fact seating
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fact seating.
	 *
	 * @return the create date of this fact seating
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this fact seating.
	 *
	 * @param createDate the create date of this fact seating
	 */
	public void setCreateDate(Date createDate);

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
	public int compareTo(com.idetronic.eis.model.FactSeating factSeating);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FactSeating> toCacheModel();

	@Override
	public com.idetronic.eis.model.FactSeating toEscapedModel();

	@Override
	public com.idetronic.eis.model.FactSeating toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
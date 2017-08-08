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
 * The base model interface for the FactData service. Represents a row in the &quot;eis_FactData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FactDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FactDataImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactData
 * @see com.idetronic.eis.model.impl.FactDataImpl
 * @see com.idetronic.eis.model.impl.FactDataModelImpl
 * @generated
 */
public interface FactDataModel extends BaseModel<FactData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fact data model instance should use the {@link FactData} interface instead.
	 */

	/**
	 * Returns the primary key of this fact data.
	 *
	 * @return the primary key of this fact data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fact data.
	 *
	 * @param primaryKey the primary key of this fact data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fact ID of this fact data.
	 *
	 * @return the fact ID of this fact data
	 */
	public long getFactId();

	/**
	 * Sets the fact ID of this fact data.
	 *
	 * @param factId the fact ID of this fact data
	 */
	public void setFactId(long factId);

	/**
	 * Returns the report ID of this fact data.
	 *
	 * @return the report ID of this fact data
	 */
	public long getReportId();

	/**
	 * Sets the report ID of this fact data.
	 *
	 * @param reportId the report ID of this fact data
	 */
	public void setReportId(long reportId);

	/**
	 * Returns the library ID of this fact data.
	 *
	 * @return the library ID of this fact data
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this fact data.
	 *
	 * @param libraryId the library ID of this fact data
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the period of this fact data.
	 *
	 * @return the period of this fact data
	 */
	@AutoEscape
	public String getPeriod();

	/**
	 * Sets the period of this fact data.
	 *
	 * @param period the period of this fact data
	 */
	public void setPeriod(String period);

	/**
	 * Returns the dimension ID of this fact data.
	 *
	 * @return the dimension ID of this fact data
	 */
	public long getDimensionId();

	/**
	 * Sets the dimension ID of this fact data.
	 *
	 * @param dimensionId the dimension ID of this fact data
	 */
	public void setDimensionId(long dimensionId);

	/**
	 * Returns the measure1 of this fact data.
	 *
	 * @return the measure1 of this fact data
	 */
	public double getMeasure1();

	/**
	 * Sets the measure1 of this fact data.
	 *
	 * @param measure1 the measure1 of this fact data
	 */
	public void setMeasure1(double measure1);

	/**
	 * Returns the measure2 of this fact data.
	 *
	 * @return the measure2 of this fact data
	 */
	public double getMeasure2();

	/**
	 * Sets the measure2 of this fact data.
	 *
	 * @param measure2 the measure2 of this fact data
	 */
	public void setMeasure2(double measure2);

	/**
	 * Returns the measure3 of this fact data.
	 *
	 * @return the measure3 of this fact data
	 */
	public double getMeasure3();

	/**
	 * Sets the measure3 of this fact data.
	 *
	 * @param measure3 the measure3 of this fact data
	 */
	public void setMeasure3(double measure3);

	/**
	 * Returns the measure4 of this fact data.
	 *
	 * @return the measure4 of this fact data
	 */
	public double getMeasure4();

	/**
	 * Sets the measure4 of this fact data.
	 *
	 * @param measure4 the measure4 of this fact data
	 */
	public void setMeasure4(double measure4);

	/**
	 * Returns the company ID of this fact data.
	 *
	 * @return the company ID of this fact data
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this fact data.
	 *
	 * @param companyId the company ID of this fact data
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this fact data.
	 *
	 * @return the group ID of this fact data
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this fact data.
	 *
	 * @param groupId the group ID of this fact data
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this fact data.
	 *
	 * @return the user ID of this fact data
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this fact data.
	 *
	 * @param userId the user ID of this fact data
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fact data.
	 *
	 * @return the user uuid of this fact data
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fact data.
	 *
	 * @param userUuid the user uuid of this fact data
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fact data.
	 *
	 * @return the user name of this fact data
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this fact data.
	 *
	 * @param userName the user name of this fact data
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fact data.
	 *
	 * @return the create date of this fact data
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this fact data.
	 *
	 * @param createDate the create date of this fact data
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
	public int compareTo(com.idetronic.eis.model.FactData factData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FactData> toCacheModel();

	@Override
	public com.idetronic.eis.model.FactData toEscapedModel();

	@Override
	public com.idetronic.eis.model.FactData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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
 * The base model interface for the FactIncome service. Represents a row in the &quot;eis_FactIncome&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FactIncomeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FactIncomeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactIncome
 * @see com.idetronic.eis.model.impl.FactIncomeImpl
 * @see com.idetronic.eis.model.impl.FactIncomeModelImpl
 * @generated
 */
public interface FactIncomeModel extends BaseModel<FactIncome> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fact income model instance should use the {@link FactIncome} interface instead.
	 */

	/**
	 * Returns the primary key of this fact income.
	 *
	 * @return the primary key of this fact income
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fact income.
	 *
	 * @param primaryKey the primary key of this fact income
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fact income ID of this fact income.
	 *
	 * @return the fact income ID of this fact income
	 */
	public long getFactIncomeId();

	/**
	 * Sets the fact income ID of this fact income.
	 *
	 * @param factIncomeId the fact income ID of this fact income
	 */
	public void setFactIncomeId(long factIncomeId);

	/**
	 * Returns the library ID of this fact income.
	 *
	 * @return the library ID of this fact income
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this fact income.
	 *
	 * @param libraryId the library ID of this fact income
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the period of this fact income.
	 *
	 * @return the period of this fact income
	 */
	@AutoEscape
	public String getPeriod();

	/**
	 * Sets the period of this fact income.
	 *
	 * @param period the period of this fact income
	 */
	public void setPeriod(String period);

	/**
	 * Returns the item ID of this fact income.
	 *
	 * @return the item ID of this fact income
	 */
	public long getItemId();

	/**
	 * Sets the item ID of this fact income.
	 *
	 * @param itemId the item ID of this fact income
	 */
	public void setItemId(long itemId);

	/**
	 * Returns the total of this fact income.
	 *
	 * @return the total of this fact income
	 */
	public double getTotal();

	/**
	 * Sets the total of this fact income.
	 *
	 * @param total the total of this fact income
	 */
	public void setTotal(double total);

	/**
	 * Returns the company ID of this fact income.
	 *
	 * @return the company ID of this fact income
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this fact income.
	 *
	 * @param companyId the company ID of this fact income
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this fact income.
	 *
	 * @return the group ID of this fact income
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this fact income.
	 *
	 * @param groupId the group ID of this fact income
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this fact income.
	 *
	 * @return the user ID of this fact income
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this fact income.
	 *
	 * @param userId the user ID of this fact income
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fact income.
	 *
	 * @return the user uuid of this fact income
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fact income.
	 *
	 * @param userUuid the user uuid of this fact income
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fact income.
	 *
	 * @return the user name of this fact income
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this fact income.
	 *
	 * @param userName the user name of this fact income
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fact income.
	 *
	 * @return the create date of this fact income
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this fact income.
	 *
	 * @param createDate the create date of this fact income
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
	public int compareTo(com.idetronic.eis.model.FactIncome factIncome);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FactIncome> toCacheModel();

	@Override
	public com.idetronic.eis.model.FactIncome toEscapedModel();

	@Override
	public com.idetronic.eis.model.FactIncome toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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
 * The base model interface for the FactLibraryVisitor service. Represents a row in the &quot;eis_FactLibraryVisitor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FactLibraryVisitorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactLibraryVisitor
 * @see com.idetronic.eis.model.impl.FactLibraryVisitorImpl
 * @see com.idetronic.eis.model.impl.FactLibraryVisitorModelImpl
 * @generated
 */
public interface FactLibraryVisitorModel extends BaseModel<FactLibraryVisitor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fact library visitor model instance should use the {@link FactLibraryVisitor} interface instead.
	 */

	/**
	 * Returns the primary key of this fact library visitor.
	 *
	 * @return the primary key of this fact library visitor
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fact library visitor.
	 *
	 * @param primaryKey the primary key of this fact library visitor
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fact ID of this fact library visitor.
	 *
	 * @return the fact ID of this fact library visitor
	 */
	public long getFactId();

	/**
	 * Sets the fact ID of this fact library visitor.
	 *
	 * @param factId the fact ID of this fact library visitor
	 */
	public void setFactId(long factId);

	/**
	 * Returns the library ID of this fact library visitor.
	 *
	 * @return the library ID of this fact library visitor
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this fact library visitor.
	 *
	 * @param libraryId the library ID of this fact library visitor
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the period of this fact library visitor.
	 *
	 * @return the period of this fact library visitor
	 */
	@AutoEscape
	public String getPeriod();

	/**
	 * Sets the period of this fact library visitor.
	 *
	 * @param period the period of this fact library visitor
	 */
	public void setPeriod(String period);

	/**
	 * Returns the visitor category ID of this fact library visitor.
	 *
	 * @return the visitor category ID of this fact library visitor
	 */
	public long getVisitorCategoryId();

	/**
	 * Sets the visitor category ID of this fact library visitor.
	 *
	 * @param visitorCategoryId the visitor category ID of this fact library visitor
	 */
	public void setVisitorCategoryId(long visitorCategoryId);

	/**
	 * Returns the session total of this fact library visitor.
	 *
	 * @return the session total of this fact library visitor
	 */
	public long getSessionTotal();

	/**
	 * Sets the session total of this fact library visitor.
	 *
	 * @param sessionTotal the session total of this fact library visitor
	 */
	public void setSessionTotal(long sessionTotal);

	/**
	 * Returns the visitor total of this fact library visitor.
	 *
	 * @return the visitor total of this fact library visitor
	 */
	public long getVisitorTotal();

	/**
	 * Sets the visitor total of this fact library visitor.
	 *
	 * @param visitorTotal the visitor total of this fact library visitor
	 */
	public void setVisitorTotal(long visitorTotal);

	/**
	 * Returns the company ID of this fact library visitor.
	 *
	 * @return the company ID of this fact library visitor
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this fact library visitor.
	 *
	 * @param companyId the company ID of this fact library visitor
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this fact library visitor.
	 *
	 * @return the group ID of this fact library visitor
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this fact library visitor.
	 *
	 * @param groupId the group ID of this fact library visitor
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this fact library visitor.
	 *
	 * @return the user ID of this fact library visitor
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this fact library visitor.
	 *
	 * @param userId the user ID of this fact library visitor
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fact library visitor.
	 *
	 * @return the user uuid of this fact library visitor
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fact library visitor.
	 *
	 * @param userUuid the user uuid of this fact library visitor
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fact library visitor.
	 *
	 * @return the user name of this fact library visitor
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this fact library visitor.
	 *
	 * @param userName the user name of this fact library visitor
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fact library visitor.
	 *
	 * @return the create date of this fact library visitor
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this fact library visitor.
	 *
	 * @param createDate the create date of this fact library visitor
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
	public int compareTo(
		com.idetronic.eis.model.FactLibraryVisitor factLibraryVisitor);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FactLibraryVisitor> toCacheModel();

	@Override
	public com.idetronic.eis.model.FactLibraryVisitor toEscapedModel();

	@Override
	public com.idetronic.eis.model.FactLibraryVisitor toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
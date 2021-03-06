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
 * The base model interface for the FactArticleIndexing service. Represents a row in the &quot;eis_FactArticleIndexing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FactArticleIndexingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FactArticleIndexingImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactArticleIndexing
 * @see com.idetronic.eis.model.impl.FactArticleIndexingImpl
 * @see com.idetronic.eis.model.impl.FactArticleIndexingModelImpl
 * @generated
 */
public interface FactArticleIndexingModel extends BaseModel<FactArticleIndexing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fact article indexing model instance should use the {@link FactArticleIndexing} interface instead.
	 */

	/**
	 * Returns the primary key of this fact article indexing.
	 *
	 * @return the primary key of this fact article indexing
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fact article indexing.
	 *
	 * @param primaryKey the primary key of this fact article indexing
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fact ID of this fact article indexing.
	 *
	 * @return the fact ID of this fact article indexing
	 */
	public long getFactId();

	/**
	 * Sets the fact ID of this fact article indexing.
	 *
	 * @param factId the fact ID of this fact article indexing
	 */
	public void setFactId(long factId);

	/**
	 * Returns the library ID of this fact article indexing.
	 *
	 * @return the library ID of this fact article indexing
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this fact article indexing.
	 *
	 * @param libraryId the library ID of this fact article indexing
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the period of this fact article indexing.
	 *
	 * @return the period of this fact article indexing
	 */
	@AutoEscape
	public String getPeriod();

	/**
	 * Sets the period of this fact article indexing.
	 *
	 * @param period the period of this fact article indexing
	 */
	public void setPeriod(String period);

	/**
	 * Returns the item ID of this fact article indexing.
	 *
	 * @return the item ID of this fact article indexing
	 */
	public long getItemId();

	/**
	 * Sets the item ID of this fact article indexing.
	 *
	 * @param itemId the item ID of this fact article indexing
	 */
	public void setItemId(long itemId);

	/**
	 * Returns the index total of this fact article indexing.
	 *
	 * @return the index total of this fact article indexing
	 */
	public long getIndexTotal();

	/**
	 * Sets the index total of this fact article indexing.
	 *
	 * @param indexTotal the index total of this fact article indexing
	 */
	public void setIndexTotal(long indexTotal);

	/**
	 * Returns the company ID of this fact article indexing.
	 *
	 * @return the company ID of this fact article indexing
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this fact article indexing.
	 *
	 * @param companyId the company ID of this fact article indexing
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this fact article indexing.
	 *
	 * @return the group ID of this fact article indexing
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this fact article indexing.
	 *
	 * @param groupId the group ID of this fact article indexing
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this fact article indexing.
	 *
	 * @return the user ID of this fact article indexing
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this fact article indexing.
	 *
	 * @param userId the user ID of this fact article indexing
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fact article indexing.
	 *
	 * @return the user uuid of this fact article indexing
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this fact article indexing.
	 *
	 * @param userUuid the user uuid of this fact article indexing
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fact article indexing.
	 *
	 * @return the user name of this fact article indexing
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this fact article indexing.
	 *
	 * @param userName the user name of this fact article indexing
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fact article indexing.
	 *
	 * @return the create date of this fact article indexing
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this fact article indexing.
	 *
	 * @param createDate the create date of this fact article indexing
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
		com.idetronic.eis.model.FactArticleIndexing factArticleIndexing);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FactArticleIndexing> toCacheModel();

	@Override
	public com.idetronic.eis.model.FactArticleIndexing toEscapedModel();

	@Override
	public com.idetronic.eis.model.FactArticleIndexing toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
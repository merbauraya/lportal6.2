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
 * The base model interface for the FactPost service. Represents a row in the &quot;eis_FactPost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.FactPostModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.FactPostImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see FactPost
 * @see com.idetronic.eis.model.impl.FactPostImpl
 * @see com.idetronic.eis.model.impl.FactPostModelImpl
 * @generated
 */
public interface FactPostModel extends BaseModel<FactPost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fact post model instance should use the {@link FactPost} interface instead.
	 */

	/**
	 * Returns the primary key of this fact post.
	 *
	 * @return the primary key of this fact post
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fact post.
	 *
	 * @param primaryKey the primary key of this fact post
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the fact post ID of this fact post.
	 *
	 * @return the fact post ID of this fact post
	 */
	public long getFactPostId();

	/**
	 * Sets the fact post ID of this fact post.
	 *
	 * @param factPostId the fact post ID of this fact post
	 */
	public void setFactPostId(long factPostId);

	/**
	 * Returns the library ID of this fact post.
	 *
	 * @return the library ID of this fact post
	 */
	public long getLibraryId();

	/**
	 * Sets the library ID of this fact post.
	 *
	 * @param libraryId the library ID of this fact post
	 */
	public void setLibraryId(long libraryId);

	/**
	 * Returns the period of this fact post.
	 *
	 * @return the period of this fact post
	 */
	@AutoEscape
	public String getPeriod();

	/**
	 * Sets the period of this fact post.
	 *
	 * @param period the period of this fact post
	 */
	public void setPeriod(String period);

	/**
	 * Returns the post grade ID of this fact post.
	 *
	 * @return the post grade ID of this fact post
	 */
	public long getPostGradeId();

	/**
	 * Sets the post grade ID of this fact post.
	 *
	 * @param postGradeId the post grade ID of this fact post
	 */
	public void setPostGradeId(long postGradeId);

	/**
	 * Returns the state ID of this fact post.
	 *
	 * @return the state ID of this fact post
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this fact post.
	 *
	 * @param stateId the state ID of this fact post
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the value of this fact post.
	 *
	 * @return the value of this fact post
	 */
	public int getValue();

	/**
	 * Sets the value of this fact post.
	 *
	 * @param value the value of this fact post
	 */
	public void setValue(int value);

	/**
	 * Returns the created by user ID of this fact post.
	 *
	 * @return the created by user ID of this fact post
	 */
	public long getCreatedByUserId();

	/**
	 * Sets the created by user ID of this fact post.
	 *
	 * @param createdByUserId the created by user ID of this fact post
	 */
	public void setCreatedByUserId(long createdByUserId);

	/**
	 * Returns the created by user uuid of this fact post.
	 *
	 * @return the created by user uuid of this fact post
	 * @throws SystemException if a system exception occurred
	 */
	public String getCreatedByUserUuid() throws SystemException;

	/**
	 * Sets the created by user uuid of this fact post.
	 *
	 * @param createdByUserUuid the created by user uuid of this fact post
	 */
	public void setCreatedByUserUuid(String createdByUserUuid);

	/**
	 * Returns the created by user name of this fact post.
	 *
	 * @return the created by user name of this fact post
	 */
	@AutoEscape
	public String getCreatedByUserName();

	/**
	 * Sets the created by user name of this fact post.
	 *
	 * @param createdByUserName the created by user name of this fact post
	 */
	public void setCreatedByUserName(String createdByUserName);

	/**
	 * Returns the created date of this fact post.
	 *
	 * @return the created date of this fact post
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this fact post.
	 *
	 * @param createdDate the created date of this fact post
	 */
	public void setCreatedDate(Date createdDate);

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
	public int compareTo(com.idetronic.eis.model.FactPost factPost);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.FactPost> toCacheModel();

	@Override
	public com.idetronic.eis.model.FactPost toEscapedModel();

	@Override
	public com.idetronic.eis.model.FactPost toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
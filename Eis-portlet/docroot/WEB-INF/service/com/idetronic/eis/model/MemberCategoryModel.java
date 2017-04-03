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
 * The base model interface for the MemberCategory service. Represents a row in the &quot;eis_MemberCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.MemberCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.MemberCategoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MemberCategory
 * @see com.idetronic.eis.model.impl.MemberCategoryImpl
 * @see com.idetronic.eis.model.impl.MemberCategoryModelImpl
 * @generated
 */
public interface MemberCategoryModel extends BaseModel<MemberCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a member category model instance should use the {@link MemberCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this member category.
	 *
	 * @return the primary key of this member category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this member category.
	 *
	 * @param primaryKey the primary key of this member category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the member category ID of this member category.
	 *
	 * @return the member category ID of this member category
	 */
	public long getMemberCategoryId();

	/**
	 * Sets the member category ID of this member category.
	 *
	 * @param memberCategoryId the member category ID of this member category
	 */
	public void setMemberCategoryId(long memberCategoryId);

	/**
	 * Returns the member category name of this member category.
	 *
	 * @return the member category name of this member category
	 */
	@AutoEscape
	public String getMemberCategoryName();

	/**
	 * Sets the member category name of this member category.
	 *
	 * @param memberCategoryName the member category name of this member category
	 */
	public void setMemberCategoryName(String memberCategoryName);

	/**
	 * Returns the member category group name of this member category.
	 *
	 * @return the member category group name of this member category
	 */
	@AutoEscape
	public String getMemberCategoryGroupName();

	/**
	 * Sets the member category group name of this member category.
	 *
	 * @param memberCategoryGroupName the member category group name of this member category
	 */
	public void setMemberCategoryGroupName(String memberCategoryGroupName);

	/**
	 * Returns the active of this member category.
	 *
	 * @return the active of this member category
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this member category is active.
	 *
	 * @return <code>true</code> if this member category is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this member category is active.
	 *
	 * @param active the active of this member category
	 */
	public void setActive(boolean active);

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
	public int compareTo(com.idetronic.eis.model.MemberCategory memberCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.MemberCategory> toCacheModel();

	@Override
	public com.idetronic.eis.model.MemberCategory toEscapedModel();

	@Override
	public com.idetronic.eis.model.MemberCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
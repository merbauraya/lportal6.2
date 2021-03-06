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
 * The base model interface for the VisitorCategory service. Represents a row in the &quot;eis_VisitorCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.VisitorCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.VisitorCategoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see VisitorCategory
 * @see com.idetronic.eis.model.impl.VisitorCategoryImpl
 * @see com.idetronic.eis.model.impl.VisitorCategoryModelImpl
 * @generated
 */
public interface VisitorCategoryModel extends BaseModel<VisitorCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a visitor category model instance should use the {@link VisitorCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this visitor category.
	 *
	 * @return the primary key of this visitor category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this visitor category.
	 *
	 * @param primaryKey the primary key of this visitor category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the visitor category ID of this visitor category.
	 *
	 * @return the visitor category ID of this visitor category
	 */
	public long getVisitorCategoryId();

	/**
	 * Sets the visitor category ID of this visitor category.
	 *
	 * @param visitorCategoryId the visitor category ID of this visitor category
	 */
	public void setVisitorCategoryId(long visitorCategoryId);

	/**
	 * Returns the visitor category code of this visitor category.
	 *
	 * @return the visitor category code of this visitor category
	 */
	@AutoEscape
	public String getVisitorCategoryCode();

	/**
	 * Sets the visitor category code of this visitor category.
	 *
	 * @param visitorCategoryCode the visitor category code of this visitor category
	 */
	public void setVisitorCategoryCode(String visitorCategoryCode);

	/**
	 * Returns the visitor category name of this visitor category.
	 *
	 * @return the visitor category name of this visitor category
	 */
	@AutoEscape
	public String getVisitorCategoryName();

	/**
	 * Sets the visitor category name of this visitor category.
	 *
	 * @param visitorCategoryName the visitor category name of this visitor category
	 */
	public void setVisitorCategoryName(String visitorCategoryName);

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
		com.idetronic.eis.model.VisitorCategory visitorCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.VisitorCategory> toCacheModel();

	@Override
	public com.idetronic.eis.model.VisitorCategory toEscapedModel();

	@Override
	public com.idetronic.eis.model.VisitorCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
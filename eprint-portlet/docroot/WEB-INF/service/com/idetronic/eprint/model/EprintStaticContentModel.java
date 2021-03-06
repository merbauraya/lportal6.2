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

package com.idetronic.eprint.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the EprintStaticContent service. Represents a row in the &quot;Eprints_EprintStaticContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eprint.model.impl.EprintStaticContentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eprint.model.impl.EprintStaticContentImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintStaticContent
 * @see com.idetronic.eprint.model.impl.EprintStaticContentImpl
 * @see com.idetronic.eprint.model.impl.EprintStaticContentModelImpl
 * @generated
 */
public interface EprintStaticContentModel extends BaseModel<EprintStaticContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a eprint static content model instance should use the {@link EprintStaticContent} interface instead.
	 */

	/**
	 * Returns the primary key of this eprint static content.
	 *
	 * @return the primary key of this eprint static content
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this eprint static content.
	 *
	 * @param primaryKey the primary key of this eprint static content
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the content ID of this eprint static content.
	 *
	 * @return the content ID of this eprint static content
	 */
	public long getContentId();

	/**
	 * Sets the content ID of this eprint static content.
	 *
	 * @param contentId the content ID of this eprint static content
	 */
	public void setContentId(long contentId);

	/**
	 * Returns the content of this eprint static content.
	 *
	 * @return the content of this eprint static content
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this eprint static content.
	 *
	 * @param content the content of this eprint static content
	 */
	public void setContent(String content);

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
		com.idetronic.eprint.model.EprintStaticContent eprintStaticContent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eprint.model.EprintStaticContent> toCacheModel();

	@Override
	public com.idetronic.eprint.model.EprintStaticContent toEscapedModel();

	@Override
	public com.idetronic.eprint.model.EprintStaticContent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
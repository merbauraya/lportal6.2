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

import com.idetronic.eprint.service.persistence.EprintSubjectPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the EprintSubject service. Represents a row in the &quot;Eprints_EprintSubject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eprint.model.impl.EprintSubjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eprint.model.impl.EprintSubjectImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see EprintSubject
 * @see com.idetronic.eprint.model.impl.EprintSubjectImpl
 * @see com.idetronic.eprint.model.impl.EprintSubjectModelImpl
 * @generated
 */
public interface EprintSubjectModel extends BaseModel<EprintSubject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a eprint subject model instance should use the {@link EprintSubject} interface instead.
	 */

	/**
	 * Returns the primary key of this eprint subject.
	 *
	 * @return the primary key of this eprint subject
	 */
	public EprintSubjectPK getPrimaryKey();

	/**
	 * Sets the primary key of this eprint subject.
	 *
	 * @param primaryKey the primary key of this eprint subject
	 */
	public void setPrimaryKey(EprintSubjectPK primaryKey);

	/**
	 * Returns the eprint ID of this eprint subject.
	 *
	 * @return the eprint ID of this eprint subject
	 */
	public long getEprintId();

	/**
	 * Sets the eprint ID of this eprint subject.
	 *
	 * @param eprintId the eprint ID of this eprint subject
	 */
	public void setEprintId(long eprintId);

	/**
	 * Returns the subject ID of this eprint subject.
	 *
	 * @return the subject ID of this eprint subject
	 */
	@AutoEscape
	public String getSubjectId();

	/**
	 * Sets the subject ID of this eprint subject.
	 *
	 * @param subjectId the subject ID of this eprint subject
	 */
	public void setSubjectId(String subjectId);

	/**
	 * Returns the subject name of this eprint subject.
	 *
	 * @return the subject name of this eprint subject
	 */
	@AutoEscape
	public String getSubjectName();

	/**
	 * Sets the subject name of this eprint subject.
	 *
	 * @param subjectName the subject name of this eprint subject
	 */
	public void setSubjectName(String subjectName);

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
	public int compareTo(com.idetronic.eprint.model.EprintSubject eprintSubject);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eprint.model.EprintSubject> toCacheModel();

	@Override
	public com.idetronic.eprint.model.EprintSubject toEscapedModel();

	@Override
	public com.idetronic.eprint.model.EprintSubject toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
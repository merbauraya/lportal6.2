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
 * The base model interface for the MasterFile service. Represents a row in the &quot;eis_MasterFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.MasterFileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.MasterFileImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MasterFile
 * @see com.idetronic.eis.model.impl.MasterFileImpl
 * @see com.idetronic.eis.model.impl.MasterFileModelImpl
 * @generated
 */
public interface MasterFileModel extends BaseModel<MasterFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a master file model instance should use the {@link MasterFile} interface instead.
	 */

	/**
	 * Returns the primary key of this master file.
	 *
	 * @return the primary key of this master file
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this master file.
	 *
	 * @param primaryKey the primary key of this master file
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the master file ID of this master file.
	 *
	 * @return the master file ID of this master file
	 */
	public long getMasterFileId();

	/**
	 * Sets the master file ID of this master file.
	 *
	 * @param masterFileId the master file ID of this master file
	 */
	public void setMasterFileId(long masterFileId);

	/**
	 * Returns the master type ID of this master file.
	 *
	 * @return the master type ID of this master file
	 */
	public long getMasterTypeId();

	/**
	 * Sets the master type ID of this master file.
	 *
	 * @param masterTypeId the master type ID of this master file
	 */
	public void setMasterTypeId(long masterTypeId);

	/**
	 * Returns the parent id1 of this master file.
	 *
	 * @return the parent id1 of this master file
	 */
	public long getParentId1();

	/**
	 * Sets the parent id1 of this master file.
	 *
	 * @param parentId1 the parent id1 of this master file
	 */
	public void setParentId1(long parentId1);

	/**
	 * Returns the parent id2 of this master file.
	 *
	 * @return the parent id2 of this master file
	 */
	public long getParentId2();

	/**
	 * Sets the parent id2 of this master file.
	 *
	 * @param parentId2 the parent id2 of this master file
	 */
	public void setParentId2(long parentId2);

	/**
	 * Returns the master file name of this master file.
	 *
	 * @return the master file name of this master file
	 */
	@AutoEscape
	public String getMasterFileName();

	/**
	 * Sets the master file name of this master file.
	 *
	 * @param masterFileName the master file name of this master file
	 */
	public void setMasterFileName(String masterFileName);

	/**
	 * Returns the status1 of this master file.
	 *
	 * @return the status1 of this master file
	 */
	public boolean getStatus1();

	/**
	 * Returns <code>true</code> if this master file is status1.
	 *
	 * @return <code>true</code> if this master file is status1; <code>false</code> otherwise
	 */
	public boolean isStatus1();

	/**
	 * Sets whether this master file is status1.
	 *
	 * @param status1 the status1 of this master file
	 */
	public void setStatus1(boolean status1);

	/**
	 * Returns the status2 of this master file.
	 *
	 * @return the status2 of this master file
	 */
	public boolean getStatus2();

	/**
	 * Returns <code>true</code> if this master file is status2.
	 *
	 * @return <code>true</code> if this master file is status2; <code>false</code> otherwise
	 */
	public boolean isStatus2();

	/**
	 * Sets whether this master file is status2.
	 *
	 * @param status2 the status2 of this master file
	 */
	public void setStatus2(boolean status2);

	/**
	 * Returns the status3 of this master file.
	 *
	 * @return the status3 of this master file
	 */
	public boolean getStatus3();

	/**
	 * Returns <code>true</code> if this master file is status3.
	 *
	 * @return <code>true</code> if this master file is status3; <code>false</code> otherwise
	 */
	public boolean isStatus3();

	/**
	 * Sets whether this master file is status3.
	 *
	 * @param status3 the status3 of this master file
	 */
	public void setStatus3(boolean status3);

	/**
	 * Returns the status4 of this master file.
	 *
	 * @return the status4 of this master file
	 */
	public boolean getStatus4();

	/**
	 * Returns <code>true</code> if this master file is status4.
	 *
	 * @return <code>true</code> if this master file is status4; <code>false</code> otherwise
	 */
	public boolean isStatus4();

	/**
	 * Sets whether this master file is status4.
	 *
	 * @param status4 the status4 of this master file
	 */
	public void setStatus4(boolean status4);

	/**
	 * Returns the status5 of this master file.
	 *
	 * @return the status5 of this master file
	 */
	public boolean getStatus5();

	/**
	 * Returns <code>true</code> if this master file is status5.
	 *
	 * @return <code>true</code> if this master file is status5; <code>false</code> otherwise
	 */
	public boolean isStatus5();

	/**
	 * Sets whether this master file is status5.
	 *
	 * @param status5 the status5 of this master file
	 */
	public void setStatus5(boolean status5);

	/**
	 * Returns the master code of this master file.
	 *
	 * @return the master code of this master file
	 */
	@AutoEscape
	public String getMasterCode();

	/**
	 * Sets the master code of this master file.
	 *
	 * @param masterCode the master code of this master file
	 */
	public void setMasterCode(String masterCode);

	/**
	 * Returns the old ID of this master file.
	 *
	 * @return the old ID of this master file
	 */
	public long getOldId();

	/**
	 * Sets the old ID of this master file.
	 *
	 * @param oldId the old ID of this master file
	 */
	public void setOldId(long oldId);

	/**
	 * Returns the note of this master file.
	 *
	 * @return the note of this master file
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this master file.
	 *
	 * @param note the note of this master file
	 */
	public void setNote(String note);

	/**
	 * Returns the in active of this master file.
	 *
	 * @return the in active of this master file
	 */
	public boolean getInActive();

	/**
	 * Returns <code>true</code> if this master file is in active.
	 *
	 * @return <code>true</code> if this master file is in active; <code>false</code> otherwise
	 */
	public boolean isInActive();

	/**
	 * Sets whether this master file is in active.
	 *
	 * @param inActive the in active of this master file
	 */
	public void setInActive(boolean inActive);

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
	public int compareTo(com.idetronic.eis.model.MasterFile masterFile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.MasterFile> toCacheModel();

	@Override
	public com.idetronic.eis.model.MasterFile toEscapedModel();

	@Override
	public com.idetronic.eis.model.MasterFile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
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

package com.idetronic.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserImportLog service. Represents a row in the &quot;sims_UserImportLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.portlet.model.impl.UserImportLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.portlet.model.impl.UserImportLogImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see UserImportLog
 * @see com.idetronic.portlet.model.impl.UserImportLogImpl
 * @see com.idetronic.portlet.model.impl.UserImportLogModelImpl
 * @generated
 */
public interface UserImportLogModel extends BaseModel<UserImportLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user import log model instance should use the {@link UserImportLog} interface instead.
	 */

	/**
	 * Returns the primary key of this user import log.
	 *
	 * @return the primary key of this user import log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user import log.
	 *
	 * @param primaryKey the primary key of this user import log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the entry ID of this user import log.
	 *
	 * @return the entry ID of this user import log
	 */
	public long getEntryId();

	/**
	 * Sets the entry ID of this user import log.
	 *
	 * @param entryId the entry ID of this user import log
	 */
	public void setEntryId(long entryId);

	/**
	 * Returns the start time of this user import log.
	 *
	 * @return the start time of this user import log
	 */
	public Date getStartTime();

	/**
	 * Sets the start time of this user import log.
	 *
	 * @param startTime the start time of this user import log
	 */
	public void setStartTime(Date startTime);

	/**
	 * Returns the end time of this user import log.
	 *
	 * @return the end time of this user import log
	 */
	public Date getEndTime();

	/**
	 * Sets the end time of this user import log.
	 *
	 * @param endTime the end time of this user import log
	 */
	public void setEndTime(Date endTime);

	/**
	 * Returns the total process of this user import log.
	 *
	 * @return the total process of this user import log
	 */
	public long getTotalProcess();

	/**
	 * Sets the total process of this user import log.
	 *
	 * @param totalProcess the total process of this user import log
	 */
	public void setTotalProcess(long totalProcess);

	/**
	 * Returns the total import of this user import log.
	 *
	 * @return the total import of this user import log
	 */
	public long getTotalImport();

	/**
	 * Sets the total import of this user import log.
	 *
	 * @param totalImport the total import of this user import log
	 */
	public void setTotalImport(long totalImport);

	/**
	 * Returns the total error of this user import log.
	 *
	 * @return the total error of this user import log
	 */
	public long getTotalError();

	/**
	 * Sets the total error of this user import log.
	 *
	 * @param totalError the total error of this user import log
	 */
	public void setTotalError(long totalError);

	/**
	 * Returns the summary of this user import log.
	 *
	 * @return the summary of this user import log
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this user import log.
	 *
	 * @param summary the summary of this user import log
	 */
	public void setSummary(String summary);

	/**
	 * Returns the create date of this user import log.
	 *
	 * @return the create date of this user import log
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this user import log.
	 *
	 * @param createDate the create date of this user import log
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the total existing of this user import log.
	 *
	 * @return the total existing of this user import log
	 */
	public Long getTotalExisting();

	/**
	 * Sets the total existing of this user import log.
	 *
	 * @param totalExisting the total existing of this user import log
	 */
	public void setTotalExisting(Long totalExisting);

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
		com.idetronic.portlet.model.UserImportLog userImportLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.portlet.model.UserImportLog> toCacheModel();

	@Override
	public com.idetronic.portlet.model.UserImportLog toEscapedModel();

	@Override
	public com.idetronic.portlet.model.UserImportLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
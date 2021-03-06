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
 * The base model interface for the State service. Represents a row in the &quot;eis_State&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.eis.model.impl.StateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.eis.model.impl.StateImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see State
 * @see com.idetronic.eis.model.impl.StateImpl
 * @see com.idetronic.eis.model.impl.StateModelImpl
 * @generated
 */
public interface StateModel extends BaseModel<State> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a state model instance should use the {@link State} interface instead.
	 */

	/**
	 * Returns the primary key of this state.
	 *
	 * @return the primary key of this state
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this state.
	 *
	 * @param primaryKey the primary key of this state
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the state ID of this state.
	 *
	 * @return the state ID of this state
	 */
	public long getStateId();

	/**
	 * Sets the state ID of this state.
	 *
	 * @param stateId the state ID of this state
	 */
	public void setStateId(long stateId);

	/**
	 * Returns the state name of this state.
	 *
	 * @return the state name of this state
	 */
	@AutoEscape
	public String getStateName();

	/**
	 * Sets the state name of this state.
	 *
	 * @param stateName the state name of this state
	 */
	public void setStateName(String stateName);

	/**
	 * Returns the state code of this state.
	 *
	 * @return the state code of this state
	 */
	@AutoEscape
	public String getStateCode();

	/**
	 * Sets the state code of this state.
	 *
	 * @param stateCode the state code of this state
	 */
	public void setStateCode(String stateCode);

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
	public int compareTo(com.idetronic.eis.model.State state);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.eis.model.State> toCacheModel();

	@Override
	public com.idetronic.eis.model.State toEscapedModel();

	@Override
	public com.idetronic.eis.model.State toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
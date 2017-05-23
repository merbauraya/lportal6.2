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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Config}.
 * </p>
 *
 * @author Mazlan Mat
 * @see Config
 * @generated
 */
public class ConfigWrapper implements Config, ModelWrapper<Config> {
	public ConfigWrapper(Config config) {
		_config = config;
	}

	@Override
	public Class<?> getModelClass() {
		return Config.class;
	}

	@Override
	public String getModelClassName() {
		return Config.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("key", getKey());
		attributes.put("value", getValue());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	/**
	* Returns the primary key of this config.
	*
	* @return the primary key of this config
	*/
	@Override
	public long getPrimaryKey() {
		return _config.getPrimaryKey();
	}

	/**
	* Sets the primary key of this config.
	*
	* @param primaryKey the primary key of this config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_config.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this config.
	*
	* @return the ID of this config
	*/
	@Override
	public long getId() {
		return _config.getId();
	}

	/**
	* Sets the ID of this config.
	*
	* @param id the ID of this config
	*/
	@Override
	public void setId(long id) {
		_config.setId(id);
	}

	/**
	* Returns the key of this config.
	*
	* @return the key of this config
	*/
	@Override
	public java.lang.String getKey() {
		return _config.getKey();
	}

	/**
	* Sets the key of this config.
	*
	* @param key the key of this config
	*/
	@Override
	public void setKey(java.lang.String key) {
		_config.setKey(key);
	}

	/**
	* Returns the value of this config.
	*
	* @return the value of this config
	*/
	@Override
	public java.lang.String getValue() {
		return _config.getValue();
	}

	/**
	* Sets the value of this config.
	*
	* @param value the value of this config
	*/
	@Override
	public void setValue(java.lang.String value) {
		_config.setValue(value);
	}

	/**
	* Returns the title of this config.
	*
	* @return the title of this config
	*/
	@Override
	public java.lang.String getTitle() {
		return _config.getTitle();
	}

	/**
	* Sets the title of this config.
	*
	* @param title the title of this config
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_config.setTitle(title);
	}

	@Override
	public boolean isNew() {
		return _config.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_config.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _config.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_config.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _config.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _config.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_config.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _config.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_config.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_config.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_config.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfigWrapper((Config)_config.clone());
	}

	@Override
	public int compareTo(com.idetronic.eis.model.Config config) {
		return _config.compareTo(config);
	}

	@Override
	public int hashCode() {
		return _config.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.eis.model.Config> toCacheModel() {
		return _config.toCacheModel();
	}

	@Override
	public com.idetronic.eis.model.Config toEscapedModel() {
		return new ConfigWrapper(_config.toEscapedModel());
	}

	@Override
	public com.idetronic.eis.model.Config toUnescapedModel() {
		return new ConfigWrapper(_config.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _config.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _config.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_config.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConfigWrapper)) {
			return false;
		}

		ConfigWrapper configWrapper = (ConfigWrapper)obj;

		if (Validator.equals(_config, configWrapper._config)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Config getWrappedConfig() {
		return _config;
	}

	@Override
	public Config getWrappedModel() {
		return _config;
	}

	@Override
	public void resetOriginalValues() {
		_config.resetOriginalValues();
	}

	private Config _config;
}
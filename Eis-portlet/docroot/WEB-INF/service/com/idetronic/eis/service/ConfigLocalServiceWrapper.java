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

package com.idetronic.eis.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConfigLocalService}.
 *
 * @author Mazlan Mat
 * @see ConfigLocalService
 * @generated
 */
public class ConfigLocalServiceWrapper implements ConfigLocalService,
	ServiceWrapper<ConfigLocalService> {
	public ConfigLocalServiceWrapper(ConfigLocalService configLocalService) {
		_configLocalService = configLocalService;
	}

	/**
	* Adds the config to the database. Also notifies the appropriate model listeners.
	*
	* @param config the config
	* @return the config that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Config addConfig(
		com.idetronic.eis.model.Config config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.addConfig(config);
	}

	/**
	* Creates a new config with the primary key. Does not add the config to the database.
	*
	* @param id the primary key for the new config
	* @return the new config
	*/
	@Override
	public com.idetronic.eis.model.Config createConfig(long id) {
		return _configLocalService.createConfig(id);
	}

	/**
	* Deletes the config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the config
	* @return the config that was removed
	* @throws PortalException if a config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Config deleteConfig(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.deleteConfig(id);
	}

	/**
	* Deletes the config from the database. Also notifies the appropriate model listeners.
	*
	* @param config the config
	* @return the config that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Config deleteConfig(
		com.idetronic.eis.model.Config config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.deleteConfig(config);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _configLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.eis.model.Config fetchConfig(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.fetchConfig(id);
	}

	/**
	* Returns the config with the primary key.
	*
	* @param id the primary key of the config
	* @return the config
	* @throws PortalException if a config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Config getConfig(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.getConfig(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configs
	* @param end the upper bound of the range of configs (not inclusive)
	* @return the range of configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.Config> getConfigs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.getConfigs(start, end);
	}

	/**
	* Returns the number of configs.
	*
	* @return the number of configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.getConfigsCount();
	}

	/**
	* Updates the config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param config the config
	* @return the config that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.Config updateConfig(
		com.idetronic.eis.model.Config config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.updateConfig(config);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _configLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_configLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _configLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.idetronic.eis.model.Config add(java.lang.String key,
		java.util.Properties prop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.add(key, prop);
	}

	@Override
	public com.idetronic.eis.model.Config addByStringValue(
		java.lang.String key, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.addByStringValue(key, value);
	}

	@Override
	public long getKeyAsLong(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.getKeyAsLong(key);
	}

	@Override
	public java.lang.String getByKeyAsString(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.getByKeyAsString(key);
	}

	@Override
	public java.util.Properties getByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _configLocalService.getByKey(key);
	}

	@Override
	public void deleteByKeyWildcard(java.lang.String keyWildCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		_configLocalService.deleteByKeyWildcard(keyWildCard);
	}

	/**
	* Return list of config based on key wildcard. It will add prefix and suffix wildcard with % for matching sql
	*
	* @param keyWildCard key to search for
	* @return list of Config
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.Config> findWithKeyWildcard(
		java.lang.String keyWildCard, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.findWithKeyWildcard(keyWildCard, start, end);
	}

	@Override
	public int countByKeyWildCard(java.lang.String keyWildCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configLocalService.countByKeyWildCard(keyWildCard);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConfigLocalService getWrappedConfigLocalService() {
		return _configLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConfigLocalService(
		ConfigLocalService configLocalService) {
		_configLocalService = configLocalService;
	}

	@Override
	public ConfigLocalService getWrappedService() {
		return _configLocalService;
	}

	@Override
	public void setWrappedService(ConfigLocalService configLocalService) {
		_configLocalService = configLocalService;
	}

	private ConfigLocalService _configLocalService;
}
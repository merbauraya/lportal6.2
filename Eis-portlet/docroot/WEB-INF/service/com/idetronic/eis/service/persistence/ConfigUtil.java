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

package com.idetronic.eis.service.persistence;

import com.idetronic.eis.model.Config;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the config service. This utility wraps {@link ConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ConfigPersistence
 * @see ConfigPersistenceImpl
 * @generated
 */
public class ConfigUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Config config) {
		getPersistence().clearCache(config);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Config> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Config> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Config> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Config update(Config config) throws SystemException {
		return getPersistence().update(config);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Config update(Config config, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(config, serviceContext);
	}

	/**
	* Returns the config where key = &#63; or throws a {@link com.idetronic.eis.NoSuchConfigException} if it could not be found.
	*
	* @param key the key
	* @return the matching config
	* @throws com.idetronic.eis.NoSuchConfigException if a matching config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config findByKey(java.lang.String key)
		throws com.idetronic.eis.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKey(key);
	}

	/**
	* Returns the config where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching config, or <code>null</code> if a matching config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config fetchByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey(key);
	}

	/**
	* Returns the config where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching config, or <code>null</code> if a matching config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config fetchByKey(
		java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey(key, retrieveFromCache);
	}

	/**
	* Removes the config where key = &#63; from the database.
	*
	* @param key the key
	* @return the config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config removeByKey(
		java.lang.String key)
		throws com.idetronic.eis.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByKey(key);
	}

	/**
	* Returns the number of configs where key = &#63;.
	*
	* @param key the key
	* @return the number of matching configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKey(key);
	}

	/**
	* Caches the config in the entity cache if it is enabled.
	*
	* @param config the config
	*/
	public static void cacheResult(com.idetronic.eis.model.Config config) {
		getPersistence().cacheResult(config);
	}

	/**
	* Caches the configs in the entity cache if it is enabled.
	*
	* @param configs the configs
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.Config> configs) {
		getPersistence().cacheResult(configs);
	}

	/**
	* Creates a new config with the primary key. Does not add the config to the database.
	*
	* @param id the primary key for the new config
	* @return the new config
	*/
	public static com.idetronic.eis.model.Config create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the config
	* @return the config that was removed
	* @throws com.idetronic.eis.NoSuchConfigException if a config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config remove(long id)
		throws com.idetronic.eis.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.idetronic.eis.model.Config updateImpl(
		com.idetronic.eis.model.Config config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(config);
	}

	/**
	* Returns the config with the primary key or throws a {@link com.idetronic.eis.NoSuchConfigException} if it could not be found.
	*
	* @param id the primary key of the config
	* @return the config
	* @throws com.idetronic.eis.NoSuchConfigException if a config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config findByPrimaryKey(long id)
		throws com.idetronic.eis.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the config
	* @return the config, or <code>null</code> if a config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.Config fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the configs.
	*
	* @return the configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Config> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.idetronic.eis.model.Config> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configs
	* @param end the upper bound of the range of configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.Config> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of configs.
	*
	* @return the number of configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConfigPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConfigPersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					ConfigPersistence.class.getName());

			ReferenceRegistry.registerReference(ConfigUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ConfigPersistence persistence) {
	}

	private static ConfigPersistence _persistence;
}
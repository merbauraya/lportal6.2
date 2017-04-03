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

package com.idetronic.eis.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.idetronic.eis.NoSuchConfigException;
import com.idetronic.eis.model.Config;
import com.idetronic.eis.service.base.ConfigLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * The implementation of the config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.eis.service.ConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.base.ConfigLocalServiceBaseImpl
 * @see com.idetronic.eis.service.ConfigLocalServiceUtil
 */
public class ConfigLocalServiceImpl extends ConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.eis.service.ConfigLocalServiceUtil} to access the config local service.
	 */
	
	public Config add(String key,Properties prop) throws SystemException
	{
		StringWriter writer = new StringWriter();
		prop.list(new PrintWriter(writer));
		
		String value = writer.getBuffer().toString();
		
		
		
		Enumeration e = prop.propertyNames();
		while (e.hasMoreElements())
		{
			String pKey = (String) e.nextElement();
			String val = prop.getProperty(pKey);
			addByStringValue (pKey,val);
			
		}
		
		Config config = null ;//configPersistence.create(id);
		try {
			config = configPersistence.findByKey(key);
		} catch (NoSuchConfigException exc) {
			long id = CounterLocalServiceUtil.increment(Config.class.getName());
			config = configPersistence.create(id);
			
		}
		
		
		
		
		config.setKey(key);
		config.setValue(value);
		
		return configPersistence.update(config);
		
	}
	public Config addByStringValue(String key,String value) throws SystemException
	{
		Config config = null ;//configPersistence.create(id);
		try {
			config = configPersistence.findByKey(key);
		} catch (NoSuchConfigException e) {
			long id = CounterLocalServiceUtil.increment(Config.class.getName());
			config = configPersistence.create(id);
		}
		
		
		
		
		config.setKey(key);
		config.setValue(value);
		
		return configPersistence.update(config);
	}
	public String getByKeyAsString(String key) throws SystemException
	{
		Config config;
		try {
			config = configPersistence.findByKey(key);
			String value = config.getValue();
			
			return value;
			
		} catch (NoSuchConfigException e) {
			return StringPool.BLANK;
		}
	}
	
	public Properties getByKey(String key) throws SystemException, IOException
	{
		Config config;
		try {
			config = configPersistence.findByKey(key);
			String value = config.getValue();
			
			Properties prop = new Properties();
			prop.load(new StringReader(value));
			return prop;
			
		} catch (NoSuchConfigException e) {
			return new Properties();
		}
		
	
		
		
		
	}
	public void deleteByKeyWildcard(String keyWildCard) throws SystemException
	{
		List<Config> configs = findWithKeyWildcard(keyWildCard);
		
		for (Config config :configs)
		{
			configPersistence.remove(config);
			
		}
	}
	/**
	 * Return list of config based on key wildcard. It will add prefix and suffix wildcard with % for matching sql
	 * @param keyWildCard key to search for
	 * @return list of Config
	 * @throws SystemException
	 */
	public List<Config> findWithKeyWildcard(String keyWildCard) throws SystemException
	{
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Config.class, PortletClassLoaderUtil.getClassLoader()); 
		String wildcard = "%" + keyWildCard + "%";
		query.add(RestrictionsFactoryUtil.like("key", wildcard));
		
		return configPersistence.findWithDynamicQuery(query);
	}
}
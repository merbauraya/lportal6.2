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

import com.idetronic.eis.model.PostGrade;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the post grade service. This utility wraps {@link PostGradePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see PostGradePersistence
 * @see PostGradePersistenceImpl
 * @generated
 */
public class PostGradeUtil {
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
	public static void clearCache(PostGrade postGrade) {
		getPersistence().clearCache(postGrade);
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
	public static List<PostGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PostGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PostGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PostGrade update(PostGrade postGrade)
		throws SystemException {
		return getPersistence().update(postGrade);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PostGrade update(PostGrade postGrade,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(postGrade, serviceContext);
	}

	/**
	* Returns the post grade where postGradeCode = &#63; or throws a {@link com.idetronic.eis.NoSuchPostGradeException} if it could not be found.
	*
	* @param postGradeCode the post grade code
	* @return the matching post grade
	* @throws com.idetronic.eis.NoSuchPostGradeException if a matching post grade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade findByGradeCode(
		java.lang.String postGradeCode)
		throws com.idetronic.eis.NoSuchPostGradeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGradeCode(postGradeCode);
	}

	/**
	* Returns the post grade where postGradeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param postGradeCode the post grade code
	* @return the matching post grade, or <code>null</code> if a matching post grade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade fetchByGradeCode(
		java.lang.String postGradeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGradeCode(postGradeCode);
	}

	/**
	* Returns the post grade where postGradeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param postGradeCode the post grade code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching post grade, or <code>null</code> if a matching post grade could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade fetchByGradeCode(
		java.lang.String postGradeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGradeCode(postGradeCode, retrieveFromCache);
	}

	/**
	* Removes the post grade where postGradeCode = &#63; from the database.
	*
	* @param postGradeCode the post grade code
	* @return the post grade that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade removeByGradeCode(
		java.lang.String postGradeCode)
		throws com.idetronic.eis.NoSuchPostGradeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByGradeCode(postGradeCode);
	}

	/**
	* Returns the number of post grades where postGradeCode = &#63;.
	*
	* @param postGradeCode the post grade code
	* @return the number of matching post grades
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGradeCode(java.lang.String postGradeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGradeCode(postGradeCode);
	}

	/**
	* Caches the post grade in the entity cache if it is enabled.
	*
	* @param postGrade the post grade
	*/
	public static void cacheResult(com.idetronic.eis.model.PostGrade postGrade) {
		getPersistence().cacheResult(postGrade);
	}

	/**
	* Caches the post grades in the entity cache if it is enabled.
	*
	* @param postGrades the post grades
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.eis.model.PostGrade> postGrades) {
		getPersistence().cacheResult(postGrades);
	}

	/**
	* Creates a new post grade with the primary key. Does not add the post grade to the database.
	*
	* @param postGradeId the primary key for the new post grade
	* @return the new post grade
	*/
	public static com.idetronic.eis.model.PostGrade create(long postGradeId) {
		return getPersistence().create(postGradeId);
	}

	/**
	* Removes the post grade with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postGradeId the primary key of the post grade
	* @return the post grade that was removed
	* @throws com.idetronic.eis.NoSuchPostGradeException if a post grade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade remove(long postGradeId)
		throws com.idetronic.eis.NoSuchPostGradeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(postGradeId);
	}

	public static com.idetronic.eis.model.PostGrade updateImpl(
		com.idetronic.eis.model.PostGrade postGrade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(postGrade);
	}

	/**
	* Returns the post grade with the primary key or throws a {@link com.idetronic.eis.NoSuchPostGradeException} if it could not be found.
	*
	* @param postGradeId the primary key of the post grade
	* @return the post grade
	* @throws com.idetronic.eis.NoSuchPostGradeException if a post grade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade findByPrimaryKey(
		long postGradeId)
		throws com.idetronic.eis.NoSuchPostGradeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(postGradeId);
	}

	/**
	* Returns the post grade with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postGradeId the primary key of the post grade
	* @return the post grade, or <code>null</code> if a post grade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.PostGrade fetchByPrimaryKey(
		long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(postGradeId);
	}

	/**
	* Returns all the post grades.
	*
	* @return the post grades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.PostGrade> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the post grades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of post grades
	* @param end the upper bound of the range of post grades (not inclusive)
	* @return the range of post grades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.PostGrade> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the post grades.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of post grades
	* @param end the upper bound of the range of post grades (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of post grades
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.PostGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the post grades from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of post grades.
	*
	* @return the number of post grades
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PostGradePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PostGradePersistence)PortletBeanLocatorUtil.locate(com.idetronic.eis.service.ClpSerializer.getServletContextName(),
					PostGradePersistence.class.getName());

			ReferenceRegistry.registerReference(PostGradeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PostGradePersistence persistence) {
	}

	private static PostGradePersistence _persistence;
}
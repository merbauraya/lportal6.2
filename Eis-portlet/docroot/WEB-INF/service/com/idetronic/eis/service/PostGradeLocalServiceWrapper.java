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
 * Provides a wrapper for {@link PostGradeLocalService}.
 *
 * @author Mazlan Mat
 * @see PostGradeLocalService
 * @generated
 */
public class PostGradeLocalServiceWrapper implements PostGradeLocalService,
	ServiceWrapper<PostGradeLocalService> {
	public PostGradeLocalServiceWrapper(
		PostGradeLocalService postGradeLocalService) {
		_postGradeLocalService = postGradeLocalService;
	}

	/**
	* Adds the post grade to the database. Also notifies the appropriate model listeners.
	*
	* @param postGrade the post grade
	* @return the post grade that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostGrade addPostGrade(
		com.idetronic.eis.model.PostGrade postGrade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.addPostGrade(postGrade);
	}

	/**
	* Creates a new post grade with the primary key. Does not add the post grade to the database.
	*
	* @param postGradeId the primary key for the new post grade
	* @return the new post grade
	*/
	@Override
	public com.idetronic.eis.model.PostGrade createPostGrade(long postGradeId) {
		return _postGradeLocalService.createPostGrade(postGradeId);
	}

	/**
	* Deletes the post grade with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postGradeId the primary key of the post grade
	* @return the post grade that was removed
	* @throws PortalException if a post grade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostGrade deletePostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.deletePostGrade(postGradeId);
	}

	/**
	* Deletes the post grade from the database. Also notifies the appropriate model listeners.
	*
	* @param postGrade the post grade
	* @return the post grade that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostGrade deletePostGrade(
		com.idetronic.eis.model.PostGrade postGrade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.deletePostGrade(postGrade);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postGradeLocalService.dynamicQuery();
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
		return _postGradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _postGradeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostGradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _postGradeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _postGradeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _postGradeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.eis.model.PostGrade fetchPostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.fetchPostGrade(postGradeId);
	}

	/**
	* Returns the post grade with the primary key.
	*
	* @param postGradeId the primary key of the post grade
	* @return the post grade
	* @throws PortalException if a post grade with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostGrade getPostGrade(long postGradeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.getPostGrade(postGradeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.idetronic.eis.model.PostGrade> getPostGrades(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.getPostGrades(start, end);
	}

	/**
	* Returns the number of post grades.
	*
	* @return the number of post grades
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPostGradesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.getPostGradesCount();
	}

	/**
	* Updates the post grade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param postGrade the post grade
	* @return the post grade that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostGrade updatePostGrade(
		com.idetronic.eis.model.PostGrade postGrade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.updatePostGrade(postGrade);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _postGradeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_postGradeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _postGradeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.PostGrade add(java.lang.String code,
		java.lang.String name, java.lang.String scheme, long postCategoryId,
		java.lang.String desc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.add(code, name, scheme, postCategoryId,
			desc, serviceContext);
	}

	@Override
	public java.util.List<com.idetronic.eis.model.PostGrade> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator ord)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postGradeLocalService.findAll(start, end, ord);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PostGradeLocalService getWrappedPostGradeLocalService() {
		return _postGradeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPostGradeLocalService(
		PostGradeLocalService postGradeLocalService) {
		_postGradeLocalService = postGradeLocalService;
	}

	@Override
	public PostGradeLocalService getWrappedService() {
		return _postGradeLocalService;
	}

	@Override
	public void setWrappedService(PostGradeLocalService postGradeLocalService) {
		_postGradeLocalService = postGradeLocalService;
	}

	private PostGradeLocalService _postGradeLocalService;
}
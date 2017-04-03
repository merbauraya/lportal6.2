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
 * Provides a wrapper for {@link PostCategoryLocalService}.
 *
 * @author Mazlan Mat
 * @see PostCategoryLocalService
 * @generated
 */
public class PostCategoryLocalServiceWrapper implements PostCategoryLocalService,
	ServiceWrapper<PostCategoryLocalService> {
	public PostCategoryLocalServiceWrapper(
		PostCategoryLocalService postCategoryLocalService) {
		_postCategoryLocalService = postCategoryLocalService;
	}

	/**
	* Adds the post category to the database. Also notifies the appropriate model listeners.
	*
	* @param postCategory the post category
	* @return the post category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostCategory addPostCategory(
		com.idetronic.eis.model.PostCategory postCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.addPostCategory(postCategory);
	}

	/**
	* Creates a new post category with the primary key. Does not add the post category to the database.
	*
	* @param postCategoryId the primary key for the new post category
	* @return the new post category
	*/
	@Override
	public com.idetronic.eis.model.PostCategory createPostCategory(
		long postCategoryId) {
		return _postCategoryLocalService.createPostCategory(postCategoryId);
	}

	/**
	* Deletes the post category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category that was removed
	* @throws PortalException if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostCategory deletePostCategory(
		long postCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.deletePostCategory(postCategoryId);
	}

	/**
	* Deletes the post category from the database. Also notifies the appropriate model listeners.
	*
	* @param postCategory the post category
	* @return the post category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostCategory deletePostCategory(
		com.idetronic.eis.model.PostCategory postCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.deletePostCategory(postCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postCategoryLocalService.dynamicQuery();
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
		return _postCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _postCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _postCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _postCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _postCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.eis.model.PostCategory fetchPostCategory(
		long postCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.fetchPostCategory(postCategoryId);
	}

	/**
	* Returns the post category with the primary key.
	*
	* @param postCategoryId the primary key of the post category
	* @return the post category
	* @throws PortalException if a post category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostCategory getPostCategory(
		long postCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.getPostCategory(postCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the post categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.PostCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of post categories
	* @param end the upper bound of the range of post categories (not inclusive)
	* @return the range of post categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.eis.model.PostCategory> getPostCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.getPostCategories(start, end);
	}

	/**
	* Returns the number of post categories.
	*
	* @return the number of post categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPostCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.getPostCategoriesCount();
	}

	/**
	* Updates the post category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param postCategory the post category
	* @return the post category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.eis.model.PostCategory updatePostCategory(
		com.idetronic.eis.model.PostCategory postCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.updatePostCategory(postCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _postCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_postCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _postCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.eis.model.PostCategory add(java.lang.String code,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postCategoryLocalService.add(code, name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PostCategoryLocalService getWrappedPostCategoryLocalService() {
		return _postCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPostCategoryLocalService(
		PostCategoryLocalService postCategoryLocalService) {
		_postCategoryLocalService = postCategoryLocalService;
	}

	@Override
	public PostCategoryLocalService getWrappedService() {
		return _postCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		PostCategoryLocalService postCategoryLocalService) {
		_postCategoryLocalService = postCategoryLocalService;
	}

	private PostCategoryLocalService _postCategoryLocalService;
}
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

import com.idetronic.eis.model.BorrowerCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the borrower category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see BorrowerCategoryPersistenceImpl
 * @see BorrowerCategoryUtil
 * @generated
 */
public interface BorrowerCategoryPersistence extends BasePersistence<BorrowerCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BorrowerCategoryUtil} to access the borrower category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the borrower category in the entity cache if it is enabled.
	*
	* @param borrowerCategory the borrower category
	*/
	public void cacheResult(
		com.idetronic.eis.model.BorrowerCategory borrowerCategory);

	/**
	* Caches the borrower categories in the entity cache if it is enabled.
	*
	* @param borrowerCategories the borrower categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.BorrowerCategory> borrowerCategories);

	/**
	* Creates a new borrower category with the primary key. Does not add the borrower category to the database.
	*
	* @param borrowerCategoryId the primary key for the new borrower category
	* @return the new borrower category
	*/
	public com.idetronic.eis.model.BorrowerCategory create(
		long borrowerCategoryId);

	/**
	* Removes the borrower category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param borrowerCategoryId the primary key of the borrower category
	* @return the borrower category that was removed
	* @throws com.idetronic.eis.NoSuchBorrowerCategoryException if a borrower category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.BorrowerCategory remove(
		long borrowerCategoryId)
		throws com.idetronic.eis.NoSuchBorrowerCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.BorrowerCategory updateImpl(
		com.idetronic.eis.model.BorrowerCategory borrowerCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower category with the primary key or throws a {@link com.idetronic.eis.NoSuchBorrowerCategoryException} if it could not be found.
	*
	* @param borrowerCategoryId the primary key of the borrower category
	* @return the borrower category
	* @throws com.idetronic.eis.NoSuchBorrowerCategoryException if a borrower category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.BorrowerCategory findByPrimaryKey(
		long borrowerCategoryId)
		throws com.idetronic.eis.NoSuchBorrowerCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param borrowerCategoryId the primary key of the borrower category
	* @return the borrower category, or <code>null</code> if a borrower category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.BorrowerCategory fetchByPrimaryKey(
		long borrowerCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the borrower categories.
	*
	* @return the borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.BorrowerCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the borrower categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.BorrowerCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of borrower categories
	* @param end the upper bound of the range of borrower categories (not inclusive)
	* @return the range of borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.BorrowerCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the borrower categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.BorrowerCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of borrower categories
	* @param end the upper bound of the range of borrower categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.BorrowerCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the borrower categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of borrower categories.
	*
	* @return the number of borrower categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
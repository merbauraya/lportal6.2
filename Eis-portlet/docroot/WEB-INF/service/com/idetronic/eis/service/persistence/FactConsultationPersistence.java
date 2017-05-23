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

import com.idetronic.eis.model.FactConsultation;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fact consultation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see FactConsultationPersistenceImpl
 * @see FactConsultationUtil
 * @generated
 */
public interface FactConsultationPersistence extends BasePersistence<FactConsultation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FactConsultationUtil} to access the fact consultation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fact consultations where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the matching fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactConsultation> findByLibrary(
		long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact consultations where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact consultations
	* @param end the upper bound of the range of fact consultations (not inclusive)
	* @return the range of matching fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactConsultation> findByLibrary(
		long libraryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact consultations where libraryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libraryId the library ID
	* @param start the lower bound of the range of fact consultations
	* @param end the upper bound of the range of fact consultations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactConsultation> findByLibrary(
		long libraryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact consultation in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact consultation
	* @throws com.idetronic.eis.NoSuchFactConsultationException if a matching fact consultation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation findByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactConsultationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fact consultation in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fact consultation, or <code>null</code> if a matching fact consultation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation fetchByLibrary_First(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact consultation in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact consultation
	* @throws com.idetronic.eis.NoSuchFactConsultationException if a matching fact consultation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation findByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactConsultationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fact consultation in the ordered set where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fact consultation, or <code>null</code> if a matching fact consultation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation fetchByLibrary_Last(
		long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact consultations before and after the current fact consultation in the ordered set where libraryId = &#63;.
	*
	* @param factConsultationId the primary key of the current fact consultation
	* @param libraryId the library ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fact consultation
	* @throws com.idetronic.eis.NoSuchFactConsultationException if a fact consultation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation[] findByLibrary_PrevAndNext(
		long factConsultationId, long libraryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.eis.NoSuchFactConsultationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact consultations where libraryId = &#63; from the database.
	*
	* @param libraryId the library ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact consultations where libraryId = &#63;.
	*
	* @param libraryId the library ID
	* @return the number of matching fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibrary(long libraryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fact consultation in the entity cache if it is enabled.
	*
	* @param factConsultation the fact consultation
	*/
	public void cacheResult(
		com.idetronic.eis.model.FactConsultation factConsultation);

	/**
	* Caches the fact consultations in the entity cache if it is enabled.
	*
	* @param factConsultations the fact consultations
	*/
	public void cacheResult(
		java.util.List<com.idetronic.eis.model.FactConsultation> factConsultations);

	/**
	* Creates a new fact consultation with the primary key. Does not add the fact consultation to the database.
	*
	* @param factConsultationId the primary key for the new fact consultation
	* @return the new fact consultation
	*/
	public com.idetronic.eis.model.FactConsultation create(
		long factConsultationId);

	/**
	* Removes the fact consultation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param factConsultationId the primary key of the fact consultation
	* @return the fact consultation that was removed
	* @throws com.idetronic.eis.NoSuchFactConsultationException if a fact consultation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation remove(
		long factConsultationId)
		throws com.idetronic.eis.NoSuchFactConsultationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.eis.model.FactConsultation updateImpl(
		com.idetronic.eis.model.FactConsultation factConsultation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact consultation with the primary key or throws a {@link com.idetronic.eis.NoSuchFactConsultationException} if it could not be found.
	*
	* @param factConsultationId the primary key of the fact consultation
	* @return the fact consultation
	* @throws com.idetronic.eis.NoSuchFactConsultationException if a fact consultation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation findByPrimaryKey(
		long factConsultationId)
		throws com.idetronic.eis.NoSuchFactConsultationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fact consultation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param factConsultationId the primary key of the fact consultation
	* @return the fact consultation, or <code>null</code> if a fact consultation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.eis.model.FactConsultation fetchByPrimaryKey(
		long factConsultationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fact consultations.
	*
	* @return the fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactConsultation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fact consultations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact consultations
	* @param end the upper bound of the range of fact consultations (not inclusive)
	* @return the range of fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactConsultation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fact consultations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactConsultationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact consultations
	* @param end the upper bound of the range of fact consultations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.eis.model.FactConsultation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fact consultations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fact consultations.
	*
	* @return the number of fact consultations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
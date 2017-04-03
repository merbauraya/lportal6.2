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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FactIrSubmission. This utility wraps
 * {@link com.idetronic.eis.service.impl.FactIrSubmissionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see FactIrSubmissionLocalService
 * @see com.idetronic.eis.service.base.FactIrSubmissionLocalServiceBaseImpl
 * @see com.idetronic.eis.service.impl.FactIrSubmissionLocalServiceImpl
 * @generated
 */
public class FactIrSubmissionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.eis.service.impl.FactIrSubmissionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fact ir submission to the database. Also notifies the appropriate model listeners.
	*
	* @param factIrSubmission the fact ir submission
	* @return the fact ir submission that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission addFactIrSubmission(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFactIrSubmission(factIrSubmission);
	}

	/**
	* Creates a new fact ir submission with the primary key. Does not add the fact ir submission to the database.
	*
	* @param submissionId the primary key for the new fact ir submission
	* @return the new fact ir submission
	*/
	public static com.idetronic.eis.model.FactIrSubmission createFactIrSubmission(
		long submissionId) {
		return getService().createFactIrSubmission(submissionId);
	}

	/**
	* Deletes the fact ir submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission that was removed
	* @throws PortalException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission deleteFactIrSubmission(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFactIrSubmission(submissionId);
	}

	/**
	* Deletes the fact ir submission from the database. Also notifies the appropriate model listeners.
	*
	* @param factIrSubmission the fact ir submission
	* @return the fact ir submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission deleteFactIrSubmission(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFactIrSubmission(factIrSubmission);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.eis.model.FactIrSubmission fetchFactIrSubmission(
		long submissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFactIrSubmission(submissionId);
	}

	/**
	* Returns the fact ir submission with the primary key.
	*
	* @param submissionId the primary key of the fact ir submission
	* @return the fact ir submission
	* @throws PortalException if a fact ir submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission getFactIrSubmission(
		long submissionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactIrSubmission(submissionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fact ir submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.eis.model.impl.FactIrSubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fact ir submissions
	* @param end the upper bound of the range of fact ir submissions (not inclusive)
	* @return the range of fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> getFactIrSubmissions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactIrSubmissions(start, end);
	}

	/**
	* Returns the number of fact ir submissions.
	*
	* @return the number of fact ir submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int getFactIrSubmissionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFactIrSubmissionsCount();
	}

	/**
	* Updates the fact ir submission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param factIrSubmission the fact ir submission
	* @return the fact ir submission that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.eis.model.FactIrSubmission updateFactIrSubmission(
		com.idetronic.eis.model.FactIrSubmission factIrSubmission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFactIrSubmission(factIrSubmission);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.idetronic.eis.model.FactIrSubmission add(long libraryId,
		long facultyId, java.lang.String period, long itemMediumId,
		int titleTotal, int volumeTotal,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .add(libraryId, facultyId, period, itemMediumId, titleTotal,
			volumeTotal, serviceContext);
	}

	public static void batchInsert(long libraryId, long facultyId,
		java.lang.String period,
		com.liferay.portal.kernel.json.JSONArray datas,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.batchInsert(libraryId, facultyId, period, datas, serviceContext);
	}

	public static java.util.List<com.idetronic.eis.model.FactIrSubmission> findLatestEntry(
		long libraryId, long facultyId, java.lang.String period) {
		return getService().findLatestEntry(libraryId, facultyId, period);
	}

	public static void clearService() {
		_service = null;
	}

	public static FactIrSubmissionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FactIrSubmissionLocalService.class.getName());

			if (invokableLocalService instanceof FactIrSubmissionLocalService) {
				_service = (FactIrSubmissionLocalService)invokableLocalService;
			}
			else {
				_service = new FactIrSubmissionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FactIrSubmissionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FactIrSubmissionLocalService service) {
	}

	private static FactIrSubmissionLocalService _service;
}
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

import com.idetronic.eis.model.ConfigClp;
import com.idetronic.eis.model.FactConsultationClp;
import com.idetronic.eis.model.FactExpenseClp;
import com.idetronic.eis.model.FactIrItemClp;
import com.idetronic.eis.model.FactIrSubmissionClp;
import com.idetronic.eis.model.FactMembershipClp;
import com.idetronic.eis.model.FactNonPrintedMaterialClp;
import com.idetronic.eis.model.FactPostClp;
import com.idetronic.eis.model.FactPrintedMaterialClp;
import com.idetronic.eis.model.FactSeatingClp;
import com.idetronic.eis.model.FactVisitorClp;
import com.idetronic.eis.model.FacultyClp;
import com.idetronic.eis.model.FacultyTypeClp;
import com.idetronic.eis.model.ItemMediumClp;
import com.idetronic.eis.model.ItemTypeCategoryClp;
import com.idetronic.eis.model.ItemTypeClp;
import com.idetronic.eis.model.KpiEntryClp;
import com.idetronic.eis.model.KpiTypeClp;
import com.idetronic.eis.model.LibraryClp;
import com.idetronic.eis.model.LibrarySeatingDepartmentClp;
import com.idetronic.eis.model.LibraryTypeClp;
import com.idetronic.eis.model.LoanClp;
import com.idetronic.eis.model.MasterFileClp;
import com.idetronic.eis.model.MasterTypeClp;
import com.idetronic.eis.model.MemberCategoryClp;
import com.idetronic.eis.model.PostCategoryClp;
import com.idetronic.eis.model.PostGradeClp;
import com.idetronic.eis.model.ProjectActivityClp;
import com.idetronic.eis.model.ProjectClp;
import com.idetronic.eis.model.ProjectResourceClp;
import com.idetronic.eis.model.ProjectResourceTypeClp;
import com.idetronic.eis.model.ProjectStrategyClp;
import com.idetronic.eis.model.ReportClp;
import com.idetronic.eis.model.SeatingCategoryClp;
import com.idetronic.eis.model.SeatingDepartmentClp;
import com.idetronic.eis.model.StateClp;
import com.idetronic.eis.model.UserLibraryClp;
import com.idetronic.eis.model.UserReportClp;
import com.idetronic.eis.model.VisitorCategoryClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mazlan Mat
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"Eis-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"Eis-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "Eis-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ConfigClp.class.getName())) {
			return translateInputConfig(oldModel);
		}

		if (oldModelClassName.equals(FactConsultationClp.class.getName())) {
			return translateInputFactConsultation(oldModel);
		}

		if (oldModelClassName.equals(FactExpenseClp.class.getName())) {
			return translateInputFactExpense(oldModel);
		}

		if (oldModelClassName.equals(FactIrItemClp.class.getName())) {
			return translateInputFactIrItem(oldModel);
		}

		if (oldModelClassName.equals(FactIrSubmissionClp.class.getName())) {
			return translateInputFactIrSubmission(oldModel);
		}

		if (oldModelClassName.equals(FactMembershipClp.class.getName())) {
			return translateInputFactMembership(oldModel);
		}

		if (oldModelClassName.equals(FactNonPrintedMaterialClp.class.getName())) {
			return translateInputFactNonPrintedMaterial(oldModel);
		}

		if (oldModelClassName.equals(FactPostClp.class.getName())) {
			return translateInputFactPost(oldModel);
		}

		if (oldModelClassName.equals(FactPrintedMaterialClp.class.getName())) {
			return translateInputFactPrintedMaterial(oldModel);
		}

		if (oldModelClassName.equals(FactSeatingClp.class.getName())) {
			return translateInputFactSeating(oldModel);
		}

		if (oldModelClassName.equals(FactVisitorClp.class.getName())) {
			return translateInputFactVisitor(oldModel);
		}

		if (oldModelClassName.equals(FacultyClp.class.getName())) {
			return translateInputFaculty(oldModel);
		}

		if (oldModelClassName.equals(FacultyTypeClp.class.getName())) {
			return translateInputFacultyType(oldModel);
		}

		if (oldModelClassName.equals(ItemMediumClp.class.getName())) {
			return translateInputItemMedium(oldModel);
		}

		if (oldModelClassName.equals(ItemTypeClp.class.getName())) {
			return translateInputItemType(oldModel);
		}

		if (oldModelClassName.equals(ItemTypeCategoryClp.class.getName())) {
			return translateInputItemTypeCategory(oldModel);
		}

		if (oldModelClassName.equals(KpiEntryClp.class.getName())) {
			return translateInputKpiEntry(oldModel);
		}

		if (oldModelClassName.equals(KpiTypeClp.class.getName())) {
			return translateInputKpiType(oldModel);
		}

		if (oldModelClassName.equals(LibraryClp.class.getName())) {
			return translateInputLibrary(oldModel);
		}

		if (oldModelClassName.equals(
					LibrarySeatingDepartmentClp.class.getName())) {
			return translateInputLibrarySeatingDepartment(oldModel);
		}

		if (oldModelClassName.equals(LibraryTypeClp.class.getName())) {
			return translateInputLibraryType(oldModel);
		}

		if (oldModelClassName.equals(LoanClp.class.getName())) {
			return translateInputLoan(oldModel);
		}

		if (oldModelClassName.equals(MasterFileClp.class.getName())) {
			return translateInputMasterFile(oldModel);
		}

		if (oldModelClassName.equals(MasterTypeClp.class.getName())) {
			return translateInputMasterType(oldModel);
		}

		if (oldModelClassName.equals(MemberCategoryClp.class.getName())) {
			return translateInputMemberCategory(oldModel);
		}

		if (oldModelClassName.equals(PostCategoryClp.class.getName())) {
			return translateInputPostCategory(oldModel);
		}

		if (oldModelClassName.equals(PostGradeClp.class.getName())) {
			return translateInputPostGrade(oldModel);
		}

		if (oldModelClassName.equals(ProjectClp.class.getName())) {
			return translateInputProject(oldModel);
		}

		if (oldModelClassName.equals(ProjectActivityClp.class.getName())) {
			return translateInputProjectActivity(oldModel);
		}

		if (oldModelClassName.equals(ProjectResourceClp.class.getName())) {
			return translateInputProjectResource(oldModel);
		}

		if (oldModelClassName.equals(ProjectResourceTypeClp.class.getName())) {
			return translateInputProjectResourceType(oldModel);
		}

		if (oldModelClassName.equals(ProjectStrategyClp.class.getName())) {
			return translateInputProjectStrategy(oldModel);
		}

		if (oldModelClassName.equals(ReportClp.class.getName())) {
			return translateInputReport(oldModel);
		}

		if (oldModelClassName.equals(SeatingCategoryClp.class.getName())) {
			return translateInputSeatingCategory(oldModel);
		}

		if (oldModelClassName.equals(SeatingDepartmentClp.class.getName())) {
			return translateInputSeatingDepartment(oldModel);
		}

		if (oldModelClassName.equals(StateClp.class.getName())) {
			return translateInputState(oldModel);
		}

		if (oldModelClassName.equals(UserLibraryClp.class.getName())) {
			return translateInputUserLibrary(oldModel);
		}

		if (oldModelClassName.equals(UserReportClp.class.getName())) {
			return translateInputUserReport(oldModel);
		}

		if (oldModelClassName.equals(VisitorCategoryClp.class.getName())) {
			return translateInputVisitorCategory(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputConfig(BaseModel<?> oldModel) {
		ConfigClp oldClpModel = (ConfigClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getConfigRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactConsultation(BaseModel<?> oldModel) {
		FactConsultationClp oldClpModel = (FactConsultationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactConsultationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactExpense(BaseModel<?> oldModel) {
		FactExpenseClp oldClpModel = (FactExpenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactExpenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactIrItem(BaseModel<?> oldModel) {
		FactIrItemClp oldClpModel = (FactIrItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactIrItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactIrSubmission(BaseModel<?> oldModel) {
		FactIrSubmissionClp oldClpModel = (FactIrSubmissionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactIrSubmissionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactMembership(BaseModel<?> oldModel) {
		FactMembershipClp oldClpModel = (FactMembershipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactMembershipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactNonPrintedMaterial(
		BaseModel<?> oldModel) {
		FactNonPrintedMaterialClp oldClpModel = (FactNonPrintedMaterialClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactNonPrintedMaterialRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactPost(BaseModel<?> oldModel) {
		FactPostClp oldClpModel = (FactPostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactPostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactPrintedMaterial(
		BaseModel<?> oldModel) {
		FactPrintedMaterialClp oldClpModel = (FactPrintedMaterialClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactPrintedMaterialRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactSeating(BaseModel<?> oldModel) {
		FactSeatingClp oldClpModel = (FactSeatingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactSeatingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFactVisitor(BaseModel<?> oldModel) {
		FactVisitorClp oldClpModel = (FactVisitorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFactVisitorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFaculty(BaseModel<?> oldModel) {
		FacultyClp oldClpModel = (FacultyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFacultyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFacultyType(BaseModel<?> oldModel) {
		FacultyTypeClp oldClpModel = (FacultyTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFacultyTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemMedium(BaseModel<?> oldModel) {
		ItemMediumClp oldClpModel = (ItemMediumClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemMediumRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemType(BaseModel<?> oldModel) {
		ItemTypeClp oldClpModel = (ItemTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItemTypeCategory(BaseModel<?> oldModel) {
		ItemTypeCategoryClp oldClpModel = (ItemTypeCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemTypeCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputKpiEntry(BaseModel<?> oldModel) {
		KpiEntryClp oldClpModel = (KpiEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getKpiEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputKpiType(BaseModel<?> oldModel) {
		KpiTypeClp oldClpModel = (KpiTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getKpiTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLibrary(BaseModel<?> oldModel) {
		LibraryClp oldClpModel = (LibraryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLibraryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLibrarySeatingDepartment(
		BaseModel<?> oldModel) {
		LibrarySeatingDepartmentClp oldClpModel = (LibrarySeatingDepartmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLibrarySeatingDepartmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLibraryType(BaseModel<?> oldModel) {
		LibraryTypeClp oldClpModel = (LibraryTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLibraryTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLoan(BaseModel<?> oldModel) {
		LoanClp oldClpModel = (LoanClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLoanRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMasterFile(BaseModel<?> oldModel) {
		MasterFileClp oldClpModel = (MasterFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMasterFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMasterType(BaseModel<?> oldModel) {
		MasterTypeClp oldClpModel = (MasterTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMasterTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMemberCategory(BaseModel<?> oldModel) {
		MemberCategoryClp oldClpModel = (MemberCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMemberCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPostCategory(BaseModel<?> oldModel) {
		PostCategoryClp oldClpModel = (PostCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPostCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPostGrade(BaseModel<?> oldModel) {
		PostGradeClp oldClpModel = (PostGradeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPostGradeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProject(BaseModel<?> oldModel) {
		ProjectClp oldClpModel = (ProjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProjectActivity(BaseModel<?> oldModel) {
		ProjectActivityClp oldClpModel = (ProjectActivityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProjectActivityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProjectResource(BaseModel<?> oldModel) {
		ProjectResourceClp oldClpModel = (ProjectResourceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProjectResourceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProjectResourceType(
		BaseModel<?> oldModel) {
		ProjectResourceTypeClp oldClpModel = (ProjectResourceTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProjectResourceTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProjectStrategy(BaseModel<?> oldModel) {
		ProjectStrategyClp oldClpModel = (ProjectStrategyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProjectStrategyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReport(BaseModel<?> oldModel) {
		ReportClp oldClpModel = (ReportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSeatingCategory(BaseModel<?> oldModel) {
		SeatingCategoryClp oldClpModel = (SeatingCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSeatingCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSeatingDepartment(BaseModel<?> oldModel) {
		SeatingDepartmentClp oldClpModel = (SeatingDepartmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSeatingDepartmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputState(BaseModel<?> oldModel) {
		StateClp oldClpModel = (StateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserLibrary(BaseModel<?> oldModel) {
		UserLibraryClp oldClpModel = (UserLibraryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserLibraryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserReport(BaseModel<?> oldModel) {
		UserReportClp oldClpModel = (UserReportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserReportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVisitorCategory(BaseModel<?> oldModel) {
		VisitorCategoryClp oldClpModel = (VisitorCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVisitorCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.ConfigImpl")) {
			return translateOutputConfig(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactConsultationImpl")) {
			return translateOutputFactConsultation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactExpenseImpl")) {
			return translateOutputFactExpense(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactIrItemImpl")) {
			return translateOutputFactIrItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactIrSubmissionImpl")) {
			return translateOutputFactIrSubmission(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactMembershipImpl")) {
			return translateOutputFactMembership(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactNonPrintedMaterialImpl")) {
			return translateOutputFactNonPrintedMaterial(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactPostImpl")) {
			return translateOutputFactPost(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactPrintedMaterialImpl")) {
			return translateOutputFactPrintedMaterial(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactSeatingImpl")) {
			return translateOutputFactSeating(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FactVisitorImpl")) {
			return translateOutputFactVisitor(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.FacultyImpl")) {
			return translateOutputFaculty(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.FacultyTypeImpl")) {
			return translateOutputFacultyType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ItemMediumImpl")) {
			return translateOutputItemMedium(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ItemTypeImpl")) {
			return translateOutputItemType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ItemTypeCategoryImpl")) {
			return translateOutputItemTypeCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.KpiEntryImpl")) {
			return translateOutputKpiEntry(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.KpiTypeImpl")) {
			return translateOutputKpiType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.LibraryImpl")) {
			return translateOutputLibrary(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.LibrarySeatingDepartmentImpl")) {
			return translateOutputLibrarySeatingDepartment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.LibraryTypeImpl")) {
			return translateOutputLibraryType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.LoanImpl")) {
			return translateOutputLoan(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.MasterFileImpl")) {
			return translateOutputMasterFile(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.MasterTypeImpl")) {
			return translateOutputMasterType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.MemberCategoryImpl")) {
			return translateOutputMemberCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.PostCategoryImpl")) {
			return translateOutputPostCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.PostGradeImpl")) {
			return translateOutputPostGrade(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.ProjectImpl")) {
			return translateOutputProject(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ProjectActivityImpl")) {
			return translateOutputProjectActivity(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ProjectResourceImpl")) {
			return translateOutputProjectResource(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ProjectResourceTypeImpl")) {
			return translateOutputProjectResourceType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.ProjectStrategyImpl")) {
			return translateOutputProjectStrategy(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.ReportImpl")) {
			return translateOutputReport(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.SeatingCategoryImpl")) {
			return translateOutputSeatingCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.SeatingDepartmentImpl")) {
			return translateOutputSeatingDepartment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.idetronic.eis.model.impl.StateImpl")) {
			return translateOutputState(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.UserLibraryImpl")) {
			return translateOutputUserLibrary(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.UserReportImpl")) {
			return translateOutputUserReport(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.idetronic.eis.model.impl.VisitorCategoryImpl")) {
			return translateOutputVisitorCategory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.idetronic.eis.NoSuchConfigException")) {
			return new com.idetronic.eis.NoSuchConfigException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchFactConsultationException")) {
			return new com.idetronic.eis.NoSuchFactConsultationException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFactExpenseException")) {
			return new com.idetronic.eis.NoSuchFactExpenseException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFactIrItemException")) {
			return new com.idetronic.eis.NoSuchFactIrItemException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchFactIrSubmissionException")) {
			return new com.idetronic.eis.NoSuchFactIrSubmissionException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFactMembershipException")) {
			return new com.idetronic.eis.NoSuchFactMembershipException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchFactNonPrintedMaterialException")) {
			return new com.idetronic.eis.NoSuchFactNonPrintedMaterialException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFactPostException")) {
			return new com.idetronic.eis.NoSuchFactPostException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchFactPrintedMaterialException")) {
			return new com.idetronic.eis.NoSuchFactPrintedMaterialException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFactSeatingException")) {
			return new com.idetronic.eis.NoSuchFactSeatingException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFactVisitorException")) {
			return new com.idetronic.eis.NoSuchFactVisitorException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFacultyException")) {
			return new com.idetronic.eis.NoSuchFacultyException();
		}

		if (className.equals("com.idetronic.eis.NoSuchFacultyTypeException")) {
			return new com.idetronic.eis.NoSuchFacultyTypeException();
		}

		if (className.equals("com.idetronic.eis.NoSuchItemMediumException")) {
			return new com.idetronic.eis.NoSuchItemMediumException();
		}

		if (className.equals("com.idetronic.eis.NoSuchItemTypeException")) {
			return new com.idetronic.eis.NoSuchItemTypeException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchItemTypeCategoryException")) {
			return new com.idetronic.eis.NoSuchItemTypeCategoryException();
		}

		if (className.equals("com.idetronic.eis.NoSuchKpiEntryException")) {
			return new com.idetronic.eis.NoSuchKpiEntryException();
		}

		if (className.equals("com.idetronic.eis.NoSuchKpiTypeException")) {
			return new com.idetronic.eis.NoSuchKpiTypeException();
		}

		if (className.equals("com.idetronic.eis.NoSuchLibraryException")) {
			return new com.idetronic.eis.NoSuchLibraryException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchLibrarySeatingDepartmentException")) {
			return new com.idetronic.eis.NoSuchLibrarySeatingDepartmentException();
		}

		if (className.equals("com.idetronic.eis.NoSuchLibraryTypeException")) {
			return new com.idetronic.eis.NoSuchLibraryTypeException();
		}

		if (className.equals("com.idetronic.eis.NoSuchLoanException")) {
			return new com.idetronic.eis.NoSuchLoanException();
		}

		if (className.equals("com.idetronic.eis.NoSuchMasterFileException")) {
			return new com.idetronic.eis.NoSuchMasterFileException();
		}

		if (className.equals("com.idetronic.eis.NoSuchMasterTypeException")) {
			return new com.idetronic.eis.NoSuchMasterTypeException();
		}

		if (className.equals("com.idetronic.eis.NoSuchMemberCategoryException")) {
			return new com.idetronic.eis.NoSuchMemberCategoryException();
		}

		if (className.equals("com.idetronic.eis.NoSuchPostCategoryException")) {
			return new com.idetronic.eis.NoSuchPostCategoryException();
		}

		if (className.equals("com.idetronic.eis.NoSuchPostGradeException")) {
			return new com.idetronic.eis.NoSuchPostGradeException();
		}

		if (className.equals("com.idetronic.eis.NoSuchProjectException")) {
			return new com.idetronic.eis.NoSuchProjectException();
		}

		if (className.equals("com.idetronic.eis.NoSuchProjectActivityException")) {
			return new com.idetronic.eis.NoSuchProjectActivityException();
		}

		if (className.equals("com.idetronic.eis.NoSuchProjectResourceException")) {
			return new com.idetronic.eis.NoSuchProjectResourceException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchProjectResourceTypeException")) {
			return new com.idetronic.eis.NoSuchProjectResourceTypeException();
		}

		if (className.equals("com.idetronic.eis.NoSuchProjectStrategyException")) {
			return new com.idetronic.eis.NoSuchProjectStrategyException();
		}

		if (className.equals("com.idetronic.eis.NoSuchReportException")) {
			return new com.idetronic.eis.NoSuchReportException();
		}

		if (className.equals("com.idetronic.eis.NoSuchSeatingCategoryException")) {
			return new com.idetronic.eis.NoSuchSeatingCategoryException();
		}

		if (className.equals(
					"com.idetronic.eis.NoSuchSeatingDepartmentException")) {
			return new com.idetronic.eis.NoSuchSeatingDepartmentException();
		}

		if (className.equals("com.idetronic.eis.NoSuchStateException")) {
			return new com.idetronic.eis.NoSuchStateException();
		}

		if (className.equals("com.idetronic.eis.NoSuchUserLibraryException")) {
			return new com.idetronic.eis.NoSuchUserLibraryException();
		}

		if (className.equals("com.idetronic.eis.NoSuchUserReportException")) {
			return new com.idetronic.eis.NoSuchUserReportException();
		}

		if (className.equals("com.idetronic.eis.NoSuchVisitorCategoryException")) {
			return new com.idetronic.eis.NoSuchVisitorCategoryException();
		}

		return throwable;
	}

	public static Object translateOutputConfig(BaseModel<?> oldModel) {
		ConfigClp newModel = new ConfigClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setConfigRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactConsultation(BaseModel<?> oldModel) {
		FactConsultationClp newModel = new FactConsultationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactConsultationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactExpense(BaseModel<?> oldModel) {
		FactExpenseClp newModel = new FactExpenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactExpenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactIrItem(BaseModel<?> oldModel) {
		FactIrItemClp newModel = new FactIrItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactIrItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactIrSubmission(BaseModel<?> oldModel) {
		FactIrSubmissionClp newModel = new FactIrSubmissionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactIrSubmissionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactMembership(BaseModel<?> oldModel) {
		FactMembershipClp newModel = new FactMembershipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactMembershipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactNonPrintedMaterial(
		BaseModel<?> oldModel) {
		FactNonPrintedMaterialClp newModel = new FactNonPrintedMaterialClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactNonPrintedMaterialRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactPost(BaseModel<?> oldModel) {
		FactPostClp newModel = new FactPostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactPostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactPrintedMaterial(
		BaseModel<?> oldModel) {
		FactPrintedMaterialClp newModel = new FactPrintedMaterialClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactPrintedMaterialRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactSeating(BaseModel<?> oldModel) {
		FactSeatingClp newModel = new FactSeatingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactSeatingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFactVisitor(BaseModel<?> oldModel) {
		FactVisitorClp newModel = new FactVisitorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFactVisitorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFaculty(BaseModel<?> oldModel) {
		FacultyClp newModel = new FacultyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFacultyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFacultyType(BaseModel<?> oldModel) {
		FacultyTypeClp newModel = new FacultyTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFacultyTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemMedium(BaseModel<?> oldModel) {
		ItemMediumClp newModel = new ItemMediumClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemMediumRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemType(BaseModel<?> oldModel) {
		ItemTypeClp newModel = new ItemTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItemTypeCategory(BaseModel<?> oldModel) {
		ItemTypeCategoryClp newModel = new ItemTypeCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemTypeCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputKpiEntry(BaseModel<?> oldModel) {
		KpiEntryClp newModel = new KpiEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setKpiEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputKpiType(BaseModel<?> oldModel) {
		KpiTypeClp newModel = new KpiTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setKpiTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLibrary(BaseModel<?> oldModel) {
		LibraryClp newModel = new LibraryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLibraryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLibrarySeatingDepartment(
		BaseModel<?> oldModel) {
		LibrarySeatingDepartmentClp newModel = new LibrarySeatingDepartmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLibrarySeatingDepartmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLibraryType(BaseModel<?> oldModel) {
		LibraryTypeClp newModel = new LibraryTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLibraryTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLoan(BaseModel<?> oldModel) {
		LoanClp newModel = new LoanClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLoanRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMasterFile(BaseModel<?> oldModel) {
		MasterFileClp newModel = new MasterFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMasterFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMasterType(BaseModel<?> oldModel) {
		MasterTypeClp newModel = new MasterTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMasterTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMemberCategory(BaseModel<?> oldModel) {
		MemberCategoryClp newModel = new MemberCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMemberCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPostCategory(BaseModel<?> oldModel) {
		PostCategoryClp newModel = new PostCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPostCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPostGrade(BaseModel<?> oldModel) {
		PostGradeClp newModel = new PostGradeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPostGradeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProject(BaseModel<?> oldModel) {
		ProjectClp newModel = new ProjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProjectActivity(BaseModel<?> oldModel) {
		ProjectActivityClp newModel = new ProjectActivityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProjectActivityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProjectResource(BaseModel<?> oldModel) {
		ProjectResourceClp newModel = new ProjectResourceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProjectResourceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProjectResourceType(
		BaseModel<?> oldModel) {
		ProjectResourceTypeClp newModel = new ProjectResourceTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProjectResourceTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProjectStrategy(BaseModel<?> oldModel) {
		ProjectStrategyClp newModel = new ProjectStrategyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProjectStrategyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReport(BaseModel<?> oldModel) {
		ReportClp newModel = new ReportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSeatingCategory(BaseModel<?> oldModel) {
		SeatingCategoryClp newModel = new SeatingCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSeatingCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSeatingDepartment(BaseModel<?> oldModel) {
		SeatingDepartmentClp newModel = new SeatingDepartmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSeatingDepartmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputState(BaseModel<?> oldModel) {
		StateClp newModel = new StateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserLibrary(BaseModel<?> oldModel) {
		UserLibraryClp newModel = new UserLibraryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserLibraryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserReport(BaseModel<?> oldModel) {
		UserReportClp newModel = new UserReportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserReportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVisitorCategory(BaseModel<?> oldModel) {
		VisitorCategoryClp newModel = new VisitorCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVisitorCategoryRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
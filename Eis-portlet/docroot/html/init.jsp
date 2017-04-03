<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://idetronic.com.my/tld/eis" prefix="eis" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.text.DateFormatSymbols" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.util.Arrays" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletRequest"%>

<%@ page import="com.liferay.portal.model.User " %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.UnicodeProperties" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys " %>
<%@ page import="com.liferay.portal.kernel.log.Log"%>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactory" %>


<%@ page import="com.idetronic.eis.model.State" %>
<%@ page import="com.idetronic.eis.model.LibraryType" %>
<%@ page import="com.idetronic.eis.model.Library" %>
<%@ page import="com.idetronic.eis.model.FacultyType" %>
<%@ page import="com.idetronic.eis.model.Faculty" %>
<%@ page import="com.idetronic.eis.model.Project" %>
<%@ page import="com.idetronic.eis.model.ProjectStrategy" %>
<%@ page import="com.idetronic.eis.model.ProjectActivity" %>
<%@ page import="com.idetronic.eis.model.PrintedItemType" %>
<%@ page import="com.idetronic.eis.model.NonPrintedItemType" %>
<%@ page import="com.idetronic.eis.model.ItemMedium" %>
<%@ page import="com.idetronic.eis.model.ItemTypeCategory" %>
<%@ page import="com.idetronic.eis.model.PostCategory" %>
<%@ page import="com.idetronic.eis.model.PostGrade" %>
<%@ page import="com.idetronic.eis.model.VisitorCategory" %>
<%@ page import="com.idetronic.eis.model.BorrowerCategory" %>
<%@ page import="com.idetronic.eis.model.UserLibrary" %>
<%@ page import="com.idetronic.eis.model.FactPrintedMaterial" %>
<%@ page import="com.idetronic.eis.model.FactNonPrintedMaterial" %>
<%@ page import="com.idetronic.eis.model.ItemType" %>
<%@ page import="com.idetronic.eis.model.Config" %>
<%@ page import="com.idetronic.eis.model.SeatingDepartment" %>
<%@ page import="com.idetronic.eis.model.SeatingCategory" %>
<%@ page import="com.idetronic.eis.model.FactSeating" %>
<%@ page import="com.idetronic.eis.model.MemberCategory" %>
<%@ page import="com.idetronic.eis.model.FactMembership" %>
<%@ page import="com.idetronic.eis.model.KpiType" %>
<%@ page import="com.idetronic.eis.model.KpiEntry" %>
<%@ page import="com.idetronic.eis.model.Report" %>

<%@ page import="com.idetronic.eis.service.ProjectLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ProjectStrategyLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ProjectActivityLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.StateLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.LibraryTypeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.LibraryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.FacultyTypeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.FacultyLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.PrintedItemTypeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.NonPrintedItemTypeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ItemMediumLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ItemTypeCategoryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.PostCategoryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.PostGradeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.VisitorCategoryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.BorrowerCategoryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.UserLibraryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.FactPrintedMaterialLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.FactNonPrintedMaterialLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ItemTypeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ConfigLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.SeatingDepartmentLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.SeatingCategoryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.FactSeatingLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.FactMembershipLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.MemberCategoryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.KpiTypeLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.KpiEntryLocalServiceUtil" %>
<%@ page import="com.idetronic.eis.service.ReportLocalServiceUtil" %>

<%@ page import="com.idetronic.eis.search.UserLibraryChecker" %>
<%@ page import="com.idetronic.eis.search.UserSearch" %>
<%@ page import="com.idetronic.eis.search.UserSearchTerms" %>
<%@ page import="com.idetronic.eis.search.UserDisplayTerms" %>

<%@ page import="com.idetronic.eis.util.EisUtil" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />
<%
	WindowState windowState = liferayPortletRequest.getWindowState();
	String currentURL = PortalUtil.getCurrentURL(request);
	Properties props = ConfigLocalServiceUtil.getByKey(EisUtil.KEY_CONFIG);
	
	boolean mPeriodAllowPreviousYear = GetterUtil.getBoolean(props.get(EisUtil.CONFIG_PERIOD_ALLOW_PREVIOUS));
	boolean mPeriodUseYearRange = GetterUtil.getBoolean(props.get(EisUtil.CONFIG_PERIOD_USE_YEAR_RANGE));
	boolean mPeriodUseMonthName = GetterUtil.getBoolean(props.get(EisUtil.CONFIG_PERIOD_USE_MONTH_NAME));
	boolean mLibraryAdminAllowAll = GetterUtil.getBoolean(props.get(EisUtil.CONFIG_LIBRARY_ADMIN_ALLOW_ALL));
	
	int mPeriodStartYear = GetterUtil.getInteger(props.get(EisUtil.CONFIG_PERIOD_MIN_YEAR));
	int mPeriodEndYear = GetterUtil.getInteger(props.get(EisUtil.CONFIG_PERIOD_MAX_YEAR));
	int mDataCountDay = GetterUtil.getInteger(props.get(EisUtil.CONFIG_MONTH_DATA_CUT_OFF_DAY));
	
	int mPeriodNumYearPrevious = GetterUtil.getInteger(props.get(EisUtil.CONFIG_PERIOD_NUM_YEAR_BACK));
	int mPeriodNumYearForward = GetterUtil.getInteger(props.get(EisUtil.CONFIG_PERIOD_NUM_YEAR_FWD));
	
	boolean isAdmin  = permissionChecker.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay.getScopeGroupId());




%>


<%@ include file="/html/init.jsp" %>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW); 

User user2 = (User)row.getObject();

Group group = (Group)row.getParameter("group");

boolean organizationUser = GetterUtil.getBoolean(row.getParameter("organizationUser"));
boolean userGroupUser = GetterUtil.getBoolean(row.getParameter("userGroupUser"));
%>

<portlet:renderURL var="assignURL">
	<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
	<portlet:param name="navigation" value="editUserLibrary" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
	<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
</portlet:renderURL>

		<liferay-ui:icon
			image="assign_user_roles"
			message="assign-site-roles"
			url="<%= assignURL %>"
		/>
	
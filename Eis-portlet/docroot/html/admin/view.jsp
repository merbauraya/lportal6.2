<%@ include file="/html/init.jsp" %>
<%
	String toolbarItem = ParamUtil.getString(renderRequest, "toolbarItem", "view-all");
	String navigation = ParamUtil.getString(request, "navigation","home");
%>



<div id="<portlet:namespace />eisAdminContainer">
	<aui:row cssClass="lfr-app-column-view">
		<aui:col cssClass="navigation-pane" width="<%= 20 %>">
			<liferay-util:include page="/html/admin/navigation.jsp" servletContext="<%=this.getServletContext()%>"/>

			<div class="folder-pagination"></div>
		</aui:col>
		
		
		<%
			String nav = "/html/admin/" + navigation + ".jsp";
		%>
		
		
			<aui:col cssClass="context-pane" width="<%= 80 %>">
				<aui:row>
					<%@ include file="/html/admin/topBar.jsp" %> 
					</aui:row>
				<aui:row>
					<%@ include file="/html/admin/view_display.jspf" %> 
			
				</aui:row>
			</aui:col>
		
	
	</aui:row>
</div>

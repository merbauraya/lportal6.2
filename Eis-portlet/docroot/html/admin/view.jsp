<%@ include file="/html/init.jsp" %> 

<%
	String toolbarItem = ParamUtil.getString(renderRequest, "toolbarItem", "view-all");
	String navigation = ParamUtil.getString(request, "navigation","home");
	long masterTypeId = ParamUtil.getLong(request, "masterTypeId");
	
%>



<div id="<portlet:namespace />eisAdminContainer">
	<aui:row cssClass="lfr-app-column-view">
	<!-- 
		<aui:col cssClass="navigation-pane" width="<%= 20 %>">
			<liferay-util:include page="/html/admin/navigation.jsp" servletContext="<%=this.getServletContext()%>"/>

			<div class="folder-pagination"></div>
		</aui:col>
	-->	
		
		<%
			String nav = "/html/admin/" + navigation + ".jsp";
			String viewPage = "/html/admin/"+ navigation +".jsp";
		%>
		
		
		
		
			<aui:col cssClass="context-pane" width="<%= 100 %>">
				<aui:row>
					<%@ include file="/html/admin/topBar.jsp" %> 
					</aui:row>
				<aui:row>
						<jsp:include page="<%= viewPage %>" >
					   		<jsp:param name="masterTypeId" value="<%= masterTypeId %>" />
						</jsp:include> 
				
					 
			
				</aui:row>
			</aui:col>
		
	
	</aui:row>
</div>

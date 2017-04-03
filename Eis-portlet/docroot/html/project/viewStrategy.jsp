<%@ include file="/html/init.jsp" %>
<%
	long projectId = ParamUtil.getLong(request, "projectId");

	Project project = ProjectLocalServiceUtil.fetchProject(projectId);
	String backURL = ParamUtil.getString(request, "backURL");
	
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= LanguageUtil.format(pageContext, "strategy-for-x", project.getProjectName(),true) %>'
/>

<portlet:renderURL var="addStrategyURL">
				
		<portlet:param name="jspPage" value="/html/project/editStrategy.jsp"/>
		<portlet:param name="projectId" value="<%= String.valueOf(projectId) %>"/>
	</portlet:renderURL>

<aui:a href="<%=addStrategyURL  %>" cssClass="btn">Add Strategy</aui:a>

<liferay-ui:search-container emptyResultsMessage="no-strategy-were-found"
	
>
	<liferay-ui:search-container-results
		results = "<%=ProjectStrategyLocalServiceUtil.getByProject(projectId,searchContainer.getStart() ,
			searchContainer.getEnd())
			%>"
	
	/>

		<liferay-ui:search-container-row
				className="com.idetronic.eis.model.ProjectStrategy"
				keyProperty="projectStrategyId"
				modelVar="strategy"  
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL(); 
			viewItemURL.setParameter("jspPage","/html/project/viewStrategy.jsp");
			viewItemURL.setParameter("projectId",String.valueOf(strategy.getProjectStrategyId()));
			
			%>
			<liferay-ui:search-container-column-text name="title">
				<a href="<%=viewItemURL.toString() %>">
					<%= strategy.getStrategyName() %>
				</a>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="start">
				<%= strategy.getStartMonthName() %>
				<%= strategy.getEndYear() %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="end">
				<%= strategy.getEndMonthName() %>
				<%= strategy.getEndYear() %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="status">
				<%
					String cl="status-green";
					if (strategy.getProjectStrategyStatus() == 1)
						cl="status-red";
					if (strategy.getProjectStrategyStatus() == 2)
						cl="status-yellow";
					
				%>
				<span class="badge <%=cl %>">&nbsp;&nbsp;&nbsp;</span>
			</liferay-ui:search-container-column-text>
			
			<portlet:renderURL var="viewActivityURL">
				<portlet:param name="strategyId" value="<%= String.valueOf(strategy.getProjectStrategyId()) %>"/>
				<portlet:param name="jspPage" value="/html/project/viewActivity.jsp"/>
			</portlet:renderURL>
			<portlet:renderURL var="editStrategyURL">
				<portlet:param name="strategyId" value="<%= String.valueOf(strategy.getProjectStrategyId()) %>"/>
				<portlet:param name="jspPage" value="/html/project/editStrategy.jsp"/>
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="action">
				<liferay-ui:icon-menu>
				  <liferay-ui:icon message="Activity" url="${viewActivityURL }" />
				  <liferay-ui:icon message="Edit" url="${editStrategyURL }" />
				</liferay-ui:icon-menu> 		
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	
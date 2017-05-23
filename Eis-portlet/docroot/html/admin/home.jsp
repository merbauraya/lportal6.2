<%@ include file="/html/init.jsp" %>

<portlet:actionURL var="runTestURL" name="runTester">  
	
</portlet:actionURL>

<%@ include file="/html/admin/admin_url.jspf" %>


<h2><%= LanguageUtil.get(themeDisplay.getLocale(),"quick-link") %></h2>
<aui:row>
<aui:col span="4">
	<h3 class="control-panel-home-category-header"><%= LanguageUtil.get(themeDisplay.getLocale(),"system-setting") %></h3>
		<ul class="unstyled">
			<li>
    		 <aui:nav-item iconCssClass="icon-edit" href="<%=configURL %>" label="configuration"  />
				
			</li>
			<li>
				<aui:nav-item href="<%=reportURL %>" iconCssClass="icon-bar-chart" label="report" />
			
			</li>
			<li>
				
			 <aui:nav-item href="<%=manageUserLibraryURL %>" iconCssClass="icon-user" label="user-library"  />
			
			</li>
			<li>
			<aui:nav-item iconCssClass="icon-envelope" href="<%=emailNotificationURL %>" label="email-notification"  />
				
			</li>
		
		</ul>
</aui:col>
<aui:col span="4">
	<h3 class="control-panel-home-category-header"><%= LanguageUtil.get(themeDisplay.getLocale(),"master") %></h3>
	<ul class="unstyled">
		<li>
			<aui:nav-item href="<%=masterTypeURL %>" label="master-type" /> 
			
			
		</li>
		<%
			for (String[] url : masterList)
			{
		%>
				<li>
					<aui:nav-item href="<%= url[0] %>" label="<%=url[1] %>" />
				</li>
		<%
			}
		%>
	</ul>
	
</aui:col>
	<aui:col span="4">
		<h3 class="control-panel-home-category-header">
			<%= LanguageUtil.get(themeDisplay.getLocale(),"kpi") %>
		</h3>
		<ul class="unstyled">
			<li>
				<aui:nav-item href="<%=KpiSettingURL %>" label="kpi-setting"  />
	       	
			</li>
			<li>
				<aui:nav-item href="<%=KpiTypeURL %>" label="kpi-type"  />
				
			</li>
			
			<li>
				<aui:nav-item href="<%=KpiEntryURL %>" label="kpi-entry"  />
				
			</li>
		
		</ul>
		
	</aui:col>
</aui:row>

<portlet:actionURL var="runTest" name="runTestURL">
	
</portlet:actionURL>

<aui:form action="<%=runTestURL %>" method="post" name="fm">
	

</aui:form>
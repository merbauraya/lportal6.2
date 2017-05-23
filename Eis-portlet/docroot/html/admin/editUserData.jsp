<%@ include file="/html/init.jsp" %> 


<%
	long userId = ParamUtil.getLong(request, "userId");
	long libraryId = ParamUtil.getLong(request, "libraryId");
	User selUser = UserLocalServiceUtil.getUser(userId);
	
	List<Report> allReports = ReportLocalServiceUtil.findByDataEntry(true);// MasterFileLocalServiceUtil.getAllLibraries();
	
	MasterFile selLibrary = MasterFileLocalServiceUtil.getMasterFile(libraryId);
	
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("navigation", "editUserData");
	portletURL.setParameter("mvcPath", "/html/admin/view.jsp");
	portletURL.setParameter("userId", String.valueOf(userId));
	portletURL.setParameter("libraryId", String.valueOf(libraryId));
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("navigation", "editUserLibrary");
	backURL.setParameter("userId", String.valueOf(userId));
	backURL.setParameter("mvcPath", "/html/admin/view.jsp");
	String title = LanguageUtil.format(pageContext,"edit-user-report-for-x-for-library-x", new String[] {selUser.getFullName(),selLibrary.getMasterFileName()}, false) ;
 	//String x;
	//String x = LanguageUtil.format(request, "edit-user-report-for-x-for-library-x", new String[] {selUser.getFullName(),selLibrary.getMasterFileName()},false);
	//x = LanguageUtil.format(pageContext, "edit-user-report-for-x-for-library-x", new String[] {selUser.getFullName(),selLibrary.getMasterFileName()});
	
	
%>
<portlet:actionURL var="editUserDataURL" name="editUserData">    
	
</portlet:actionURL>
<liferay-ui:header
	
	title="<%= title%>"
	
	backURL="<%= backURL.toString() %>"
/>


<aui:form method="post" name="fm" action="<%=editUserDataURL  %>">
	<aui:input name="userId" type="hidden" value="<%= selUser.getUserId() %>" />
	<aui:input name="libraryId" type="hidden" value="<%= libraryId %>"></aui:input>
	<aui:input name="addDataIds" type="hidden" />
	<aui:input name="removeDataIds" type="hidden" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="userSearch"/> 
	<aui:input name="assignmentsRedirect" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%=portletURL.toString() %>"></aui:input>
	
	
	  <aui:button-row>
    	<aui:button value="update" onClick='<%= renderResponse.getNamespace() + "updateUserLibrary();"  %>' />
	</aui:button-row>
	
	<liferay-ui:search-container delta="500"
           
          rowChecker="<%=new UserDataChecker(renderResponse,selUser,libraryId)%>"> 
          <liferay-ui:search-container-results
              results="<%=ListUtil.subList(allReports, searchContainer.getStart(), searchContainer.getEnd())%>"
              total="<%=allReports.size()%>" />

          <liferay-ui:search-container-row
              className="com.idetronic.eis.model.Report"
              modelVar="library" keyProperty="reportId">
              
               
               
               <liferay-ui:search-container-column-text property="reportTitle" name="report-display-title"/>
                 
              
               
              
          </liferay-ui:search-container-row>

          <liferay-ui:search-iterator paginate="<%=false %>" searchContainer="<%=searchContainer%>" />
      </liferay-ui:search-container>
      
     <aui:button-row>
    	<aui:button value="update" onClick='<%= renderResponse.getNamespace() + "updateUserLibrary();"  %>' />
	</aui:button-row>
	
	
		

</aui:form>

	
	



<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateUserLibrary', 
		function(assignmentsRedirect) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "userLibrary";
			document.<portlet:namespace />fm.<portlet:namespace />assignmentsRedirect.value = assignmentsRedirect;
			document.<portlet:namespace />fm.<portlet:namespace />addDataIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			document.<portlet:namespace />fm.<portlet:namespace />removeDataIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
		
			
			
			document.<portlet:namespace />fm.action = '<%=editUserDataURL.toString()%>';
			
			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>











<%@ include file="/html/init.jsp" %> 


<%
	long userId = ParamUtil.getLong(request, "userId");
	long libraryId = ParamUtil.getLong(request, "libraryId");
	User selUser = UserLocalServiceUtil.getUser(userId);
	//List<MasterFile> userLibraries = UserLibraryLocalServiceUtil.getLibraryByUser(userId);
	List<MasterFile> allLibraries = MasterFileLocalServiceUtil.getAllLibraries();
	//List<MasterFile> unAssignedLibraries = new ArrayList<MasterFile>(allLibraries);
	
	//unAssignedLibraries.removeAll(userLibraries);
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("navigation", "editUserLibrary");
	portletURL.setParameter("mvcPath", "/html/admin/view.jsp");
	portletURL.setParameter("userId", String.valueOf(userId));
	//portletURL.setParameter("tabs3", tabs3);
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setParameter("navigation", "userLibrary");
	backURL.setParameter("mvcPath", "/html/admin/view.jsp");
	
	
%>
<portlet:actionURL var="editUserLibraryURL" name="editUserLibrary">    
	
</portlet:actionURL>
<liferay-ui:header
	
	title='<%= LanguageUtil.format(pageContext, "edit-library-association-for-x", selUser.getFullName())%>'
	backURL="<%= backURL.toString() %>"
/>


<aui:form method="post" name="fm" action="<%=editUserLibraryURL  %>">
	<aui:input name="userId" type="hidden" value="<%= selUser.getUserId() %>" />
	<aui:input name="addLibraryIds" type="hidden" />
	<aui:input name="removeLibraryIds" type="hidden" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="userSearch"/>
	<aui:input name="assignmentsRedirect" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%=portletURL.toString() %>"></aui:input>
	
	
	 <aui:button-row>
    	<aui:button value="update" onClick='<%= renderResponse.getNamespace() + "updateUserLibrary();"  %>' />
	</aui:button-row>
	
	<liferay-ui:search-container delta="500"
           
          rowChecker="<%=new UserLibraryChecker(renderResponse,selUser)%>">
          <liferay-ui:search-container-results
              results="<%=ListUtil.subList(allLibraries, searchContainer.getStart(), searchContainer.getEnd())%>"
              total="<%=allLibraries.size()%>" />

          <liferay-ui:search-container-row
              className="com.idetronic.eis.model.MasterFile"
              modelVar="library" keyProperty="masterFileId">
              <liferay-ui:search-container-column-text property="masterFileId"
                  name="Id Perpustakaan" />
               <liferay-ui:search-container-column-text property="masterFileName"
                  name="Nama Perpustakaan" />
               <liferay-ui:search-container-column-text
					buffer="buffer"
					name="state"
				> 
   
				<%
					MasterFile state = MasterFileLocalServiceUtil.getMasterFile(library.getParentId1());
					if (Validator.isNotNull(state))
					{
						buffer.append(HtmlUtil.escape(state.getMasterFileName()));
					}
					
				
				%>

			</liferay-ui:search-container-column-text>
            <portlet:renderURL var="editUserDataURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="editUserData" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(userId) %>" />
				<portlet:param name="libraryId" value="<%= String.valueOf(library.getMasterFileId()) %>" />
			</portlet:renderURL>
			<liferay-ui:search-container-column-text> 
				
					
			
					<c:if test="<%= searchContainer.getRowChecker().isChecked(library)  %>">
						<aui:a cssClass="btn btn-default btnEdit"  href="<%= editUserDataURL %>" label="edit-user-data" />

					</c:if>
					
				
              </liferay-ui:search-container-column-text>
          </liferay-ui:search-container-row>

          <liferay-ui:search-iterator paginate="<%=false %>" searchContainer="<%=searchContainer%>" />
      </liferay-ui:search-container>
      
     <aui:button-row>
    	<aui:button value="update" onClick='<%= renderResponse.getNamespace() + "updateUserLibrary();"  %>' />
	</aui:button-row>
	
	
		

</aui:form>

	
	







<portlet:actionURL var="editAssocationURL" name="removeUserLibrary">   
	
</portlet:actionURL>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateUserLibrary', 
		function(assignmentsRedirect) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "userLibrary";
			document.<portlet:namespace />fm.<portlet:namespace />assignmentsRedirect.value = assignmentsRedirect;
			document.<portlet:namespace />fm.<portlet:namespace />addLibraryIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			document.<portlet:namespace />fm.<portlet:namespace />removeLibraryIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			console.log(document.<portlet:namespace />fm.<portlet:namespace />addLibraryIds.value );
			console.log(document.<portlet:namespace />fm.<portlet:namespace />removeLibraryIds.value );
			
			
			document.<portlet:namespace />fm.action = '<%=editUserLibraryURL.toString()%>';
			
			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>











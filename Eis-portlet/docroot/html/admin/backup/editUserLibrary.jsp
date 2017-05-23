<%@ include file="/html/init.jsp" %> 


<%
	long libraryId = ParamUtil.getLong(request, "libraryId");
	MasterFile library = null;
	List<UserLibrary> userLibraries = null; 
	if (Validator.isNotNull(libraryId))
	{
		library = MasterFileLocalServiceUtil.getMasterFile(libraryId);
		userLibraries = UserLibraryLocalServiceUtil.findByLibrary(libraryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);
	
	String tabs3 = ParamUtil.getString(request, "tabs3","current");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("navigation", "editUserLibrary");
	portletURL.setParameter("mvcPath", "/html/admin/view.jsp");
	portletURL.setParameter("libraryId", String.valueOf(libraryId));
	portletURL.setParameter("tabs3", tabs3);
	
%>
<c:if test="<%= Validator.isNotNull(library) %>">
	<h4><%= library.getMasterFileName() %></h4>
</c:if>
<portlet:actionURL var="editUserLibraryURL" name="editUserLibrary">    
	
</portlet:actionURL>

<portlet:renderURL var="userSearchURL">
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="editUserLibrary"/>
	<portlet:param name="tabs3" value="tabs3"/>
	<portlet:param name="libraryId" value="<%= String.valueOf(libraryId) %>"/>
</portlet:renderURL>

<aui:form action="<%= userSearchURL %>" method="post" name="fm"> 
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="userSearch"/>
	<aui:input name="libraryId" type="hidden" value="<%= library.getMasterFileId() %>" />
	<aui:input name="addUserIds" type="hidden" />
	<aui:input name="removeUserIds" type="hidden" />
	<aui:input name="assignmentsRedirect" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%=portletURL.toString() %>"></aui:input>
	<liferay-ui:tabs
		names="current,available"
		param="tabs3"
		url="<%= portletURL.toString() %>"
	/>

	<liferay-ui:search-container
		rowChecker="<%= new UserLibraryChecker(renderResponse, library) %>"  
		searchContainer="<%= new UserSearch(renderRequest, portletURL) %>" 
		var="userSearchContainer"
	>
	<liferay-ui:search-form
		page="/html/admin/search/user_search_form.jsp"
		servletContext="<%= this.getServletContext()%>"
		searchContainer="<%= userSearchContainer%>"
		showAddButton="<%=true %>"
	/>

	<% 
	UserSearchTerms searchTerms = (UserSearchTerms)userSearchContainer.getSearchTerms();
 	
	LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();

	if (tabs3.equals("current")) {
		userParams.put("usersGroups", new Long(0));
	}
	%>

	<liferay-ui:search-container-results>
		<%@ include file="/html/admin/search/user_search_results.jspf" %>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user2"
		rowIdProperty="screenName"
	>
		<liferay-ui:search-container-column-text
			name="name"
			property="fullName"
		/>

		<liferay-ui:search-container-column-text
			name="screen-name"
			property="screenName"
		/>
	</liferay-ui:search-container-row>
	<div class="separator"><!-- --></div>
	<%
	String taglibOnClick = renderResponse.getNamespace() + "updateUserLibrary('" + portletURL.toString() + StringPool.AMPERSAND + renderResponse.getNamespace() + "cur=" + cur + "');";
	%>
	<aui:button onClick="<%= taglibOnClick %>" value="update-associations" />
	<liferay-ui:search-iterator />

</liferay-ui:search-container>

	<!--  end lf code -->





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
			document.<portlet:namespace />fm.<portlet:namespace />addUserIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			document.<portlet:namespace />fm.<portlet:namespace />removeUserIds.value = Liferay.Util.listUncheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
			//console.log(document.<portlet:namespace />fm.<portlet:namespace />addUserIds.value );
			//console.log(document.<portlet:namespace />fm.<portlet:namespace />removeUserIds.value );
			
			
			document.<portlet:namespace />fm.action = '<%=editUserLibraryURL.toString()%>';
			
			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>


<aui:script position="inline" use="aui-base,liferay-portlet-url">
	var editButton = A.all('.btnEdit');
	var url = '<%=editAssocationURL.toString()%>'; 
	editButton.on(
		'click',
		function(e) {
			
			//var stateId = 0;
			var id = e.target.getAttribute("data-primkey");
			
			A.io.request(
		            url,
		            {
		                method: 'POST',
		                data :{
		                	userLibraryId: id,
		                },
		                
		                on: {
		                    success: function() {
		                    	console.log('todo remove row');
		                        //Liferay.Util.getOpener().refreshPortlet();
		                        //Liferay.Util.getOpener().closePopup('<portlet:namespace/>dialog');
		                    }
		                }
		            }
		        );
			
			
			editURL.setParameter('mvcPath', '/html/admin/editFaculty.jsp');
			editURL.setParameter('facultyId', id);
			editURL.setPortletId('eisadmin_WAR_Eisportlet');
			editURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
			
			
			Liferay.Util.openWindow(
				{
					dialog: {
						centered: true,
						modal:true,
						destroyOnHide: true,
						width: 450,
						
					},
					
					title: '<%= portletDisplay.getTitle() %>',
					uri: editURL.toString(),
					id: '<portlet:namespace/>dialog',
				}
			);
		}
	);
</aui:script>








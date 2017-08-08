<%@ include file="/html/init.jsp" %>

<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("mvcPath", "/html/admin/view.jsp");
	portletURL.setParameter("navigation","userLibrary");
	portletURL.setParameter("groupId", String.valueOf(themeDisplay.getScopeGroupId()));

	Group group = themeDisplay.getScopeGroup();

%>


<portlet:resourceURL var="resourceURL" id="libraryList">
	
</portlet:resourceURL>
<h4>User</h4>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submit();" %>'>
	<aui:input name="keywords" type="hidden" value="" />
<%
	
	 
	PortletURL viewUsersURL = renderResponse.createRenderURL();

	viewUsersURL.setParameter("mvcPath", "/html/admin/view.jsp");
	viewUsersURL.setParameter("navigation","userLibrary");
	
	viewUsersURL.setParameter("redirect", currentURL);
	viewUsersURL.setParameter("groupId", String.valueOf(themeDisplay.getScopeGroupId()));
	
	SearchContainer searchContainer = new UserSearch(renderRequest, viewUsersURL);
	searchContainer.setIteratorURL(portletURL);
	
	
%>

<liferay-ui:search-container
	
	searchContainer="<%= searchContainer %>"
	var="userSearchContainer"
	iteratorURL="<%= portletURL %>"
>
	

	<%
	UserSearchTerms searchTerms = (UserSearchTerms)userSearchContainer.getSearchTerms();

	LinkedHashMap<String, Object> userParams = new LinkedHashMap<String, Object>();
	
	
	
	userParams.put("inherit", Boolean.TRUE);
	userParams.put("usersGroups", new Long(themeDisplay.getScopeGroupId()));
	
	%>
	<liferay-ui:search-container-results>
	<%
		total = UserLocalServiceUtil.searchCount(company.getCompanyId(), searchTerms.getKeywords(), searchTerms.getStatus(), userParams);

		userSearchContainer.setTotal(total);

		results = UserLocalServiceUtil.search(company.getCompanyId(), searchTerms.getKeywords(), searchTerms.getStatus(), userParams, userSearchContainer.getStart(), userSearchContainer.getEnd(), userSearchContainer.getOrderByComparator());
		userSearchContainer.setResults(results);
	%>
	</liferay-ui:search-container-results>
	
	
	


	<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user2"
		rowIdProperty="screenName"
	>
		

		<liferay-ui:search-container-column-text
			buffer="buffer"
			name="name"
		>

			<%
			buffer.append(user2.getFullName());

			List<String> names = new ArrayList<String>();

			boolean organizationUser = SitesUtil.isOrganizationUser(company.getCompanyId(), group, user2, names);

			row.setParameter("organizationUser", organizationUser);

			boolean userGroupUser = SitesUtil.isUserGroupUser(company.getCompanyId(), group, user2, names);
 
			row.setParameter("userGroupUser", userGroupUser);

			String message = StringPool.BLANK;

			if (organizationUser || userGroupUser) {
				if (names.size() == 1) {
					message = LanguageUtil.format(pageContext, "this-user-is-a-member-of-x-because-he-belongs-to-x", new Object[] {HtmlUtil.escape(group.getDescriptiveName(locale)), names.get(0)});
				}
				else {
					message = LanguageUtil.format(pageContext, "this-user-is-a-member-of-x-because-he-belongs-to-x-and-x", new Object[] {HtmlUtil.escape(group.getDescriptiveName(locale)), StringUtil.merge(names.subList(0, names.size() - 1).toArray(new String[names.size() - 1]), ", "), names.get(names.size() - 1)});
				}
			%>

				<liferay-util:buffer var="iconHelp">
					<liferay-ui:icon-help message="<%= message %>" />
				</liferay-util:buffer>

			<%
				buffer.append(iconHelp);
			}
			%>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="screen-name"
			orderable="<%= true %>"
			property="screenName"
		/>

		
		<liferay-ui:search-container-column-text
			buffer="buffer"
			name="library"
		> 
   
				<%
					List<MasterFile> userLibraries = UserLibraryLocalServiceUtil.getLibraryByUser(user2.getUserId());
					for (int i = 0; i < userLibraries.size(); i++)
					{
						MasterFile library = userLibraries.get(i);
						buffer.append(HtmlUtil.escape(library.getMasterFileName()));
						if ((i + 1) < userLibraries.size()) {
							buffer.append(StringPool.COMMA_AND_SPACE);
						}
						
					}
			
				%>

			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text
			buffer="buffer"
			name="hq-report"
		> 
   
				<%
					List<UserReport> userReports = UserReportLocalServiceUtil.findByUserLibrary(user2.getUserId(), 0); 
					
					for (int i = 0; i < userReports.size(); i ++)
					{
						UserReport userReport = userReports.get(i);
						Report report = ReportLocalServiceUtil.getReport(userReport.getReportId());
						buffer.append(HtmlUtil.escape(report.getReportTitle()));
						if (i +1 < userReports.size())
						{
							buffer.append(StringPool.COMMA_AND_SPACE);

						}
						
					}
					
					
				%>
				

			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="action">
			<%
			PortletURL userActionURL = renderResponse.createRenderURL();

			viewUsersURL.setParameter("mvcPath", "/html/admin/view.jsp");
			viewUsersURL.setParameter("navigation","editUserLibrary");
			viewUsersURL.setParameter("tabs2", "");
			viewUsersURL.setParameter("redirect", currentURL);
			viewUsersURL.setParameter("userId", String.valueOf(user2.getUserId()));
			
			%>
			<portlet:renderURL var="assignURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="editUserLibrary" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
			</portlet:renderURL>
			<portlet:renderURL var="editUserDataURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="editUserData" />
				<portlet:param name="hqDataEntry" value="true"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
			</portlet:renderURL>
				
			
				<liferay-ui:icon-menu>
				  <liferay-ui:icon message="edit-user-library" url="<%= assignURL %>" />
				  <liferay-ui:icon message="edit-user-data-hq" url="<%= editUserDataURL %>" />
				</liferay-ui:icon-menu> 
				
					
			</liferay-ui:search-container-column-text>
			

			
		
	</liferay-ui:search-container-row>

	<liferay-util:buffer var="formButton">
		

		<liferay-ui:icon
			image="../aui/user"
			label="<%= true %>"
			message="assign-users"
			url="<%= viewUsersURL.toString() %>"
		/>

					<%
					viewUsersURL.setParameter("tabs2", "current");
					%>

				
	</liferay-util:buffer>

	<c:choose>
		<c:when test='<%= (total > 0) %>'>
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" persistState="<%= true %>" title='<%= LanguageUtil.format(pageContext, (total > 1) ? "x-users" : "x-user", total) %>'>
				<span class="form-search">
					<liferay-ui:input-search name='<%= DisplayTerms.KEYWORDS + "_users" %>' /> 
				</span>

				<liferay-ui:search-iterator paginate="<%= true %>" />

				<c:if test="<%= total > searchContainer.getDelta() %>">
					<a href="<%= HtmlUtil.escapeAttribute(viewUsersURL.toString()) %>"><liferay-ui:message key="view-more" /> &raquo;</a>
				</c:if>
			</liferay-ui:panel>
		</c:when>
		<c:otherwise/>
	</c:choose>
		
		
			<c:if test="<%= total > searchContainer.getDelta() %>">
				<%= formButton %>
			</c:if>
	
			

		
	
</liferay-ui:search-container>


</aui:form>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="navigation" value="userLibrary" />
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       
       
</liferay-portlet:renderURL>







<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />submit',
		function() {
			
			var userKeywords = document.<portlet:namespace />fm.<portlet:namespace /><%= DisplayTerms.KEYWORDS %>_users;

			if (userKeywords && userKeywords.value) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= DisplayTerms.KEYWORDS %>.value = userKeywords.value;

				submitForm(document.<portlet:namespace />fm, "<portlet:renderURL><portlet:param name="mvcPath" value="/html/admin/view.jsp" /><portlet:param name="navigation" value="userLibrary" /><portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" /></portlet:renderURL>");
			}

			

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>
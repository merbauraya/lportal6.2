<%@ include file="/html/init.jsp" %> 

<%
	String navigation = ParamUtil.getString(request, "navigation", "home");

%>

<div id="<portlet:namespace />listViewContainer">
	<div id="<portlet:namespace />folderContainer">
		<aui:nav cssClass="nav-list well">
			
			<li class="nav-header">
				<liferay-ui:message key="location"></liferay-ui:message>
			</li>
			
			<liferay-portlet:renderURL varImpl="viewAdminHomeURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				
			</liferay-portlet:renderURL>
			<liferay-portlet:renderURL varImpl="viewStateURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="state" />
			</liferay-portlet:renderURL>
			<%
			Map<String, Object> dataView = new HashMap<String, Object>(); 
			dataView.put("navigation", "state"); 
			
			%>
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "state") %>' 
				iconImage="icon-home"
				selected='<%= (navigation.equals("state")) %>'
				viewURL="<%= viewStateURL.toString() %>"
				cssClass="state"
			/>
			
			<liferay-portlet:renderURL varImpl="viewLibraryTypeURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="libraryType" />
			</liferay-portlet:renderURL>
			
			<%
				dataView.put("navigation", "libraryType"); 
			%>
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "library-type") %>' 
				selected='<%= (navigation.equals("libraryType")) %>'
				viewURL="<%= viewLibraryTypeURL.toString() %>"
				cssClass="state"
			/>
			
			<liferay-portlet:renderURL varImpl="viewLibraryURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="library" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "library") %>' 
				selected='<%= (navigation.equals("library")) %>'
				viewURL="<%= viewLibraryURL.toString() %>"
				cssClass="state"
			/>
			
			<li class="nav-header">
				<liferay-ui:message key="ptj"></liferay-ui:message>
			</li>
			
			<liferay-portlet:renderURL varImpl="viewFacultyTypeURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="facultyType" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "ptj-type") %>' 
				selected='<%= (navigation.equals("library")) %>'
				viewURL="<%= viewFacultyTypeURL.toString() %>"
				cssClass="state"
			/>
			
			<liferay-portlet:renderURL varImpl="viewFacultyURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="faculty" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "ptj") %>' 
				
				selected='<%= (navigation.equals("faculty")) %>'
				viewURL="<%= viewFacultyURL.toString() %>"
				cssClass="state"
			/>
			
			<li class="nav-header">
				<liferay-ui:message key="item"></liferay-ui:message>
			</li>
			<liferay-portlet:renderURL varImpl="viewItemTypeURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="itemType" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "item-type") %>' 
				
				selected='<%= (navigation.equals("itemType")) %>'
				viewURL="<%= viewItemTypeURL.toString() %>"
				
			/>
			
			
			
			
			<liferay-portlet:renderURL varImpl="viewItemMediumURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="itemMedium" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "item-medium") %>' 
				
				selected='<%= (navigation.equals("itemMedium")) %>'
				viewURL="<%= viewItemMediumURL.toString() %>"
				
			/>
			
			<li class="nav-header">
				<liferay-ui:message key="position"></liferay-ui:message>
			</li>
			
			<liferay-portlet:renderURL varImpl="viewPostCategoryURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="postCategory" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "post-category") %>' 
				
				selected='<%= (navigation.equals("postCategory")) %>'
				viewURL="<%= viewPostCategoryURL.toString() %>"
				
			/>
			<liferay-portlet:renderURL varImpl="viewPostGradeURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="postGrade" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "post-grade") %>' 
				
				selected='<%= (navigation.equals("postGrade")) %>'
				viewURL="<%= viewPostGradeURL.toString() %>"
				
			/>
			
			<li class="nav-header">
				<liferay-ui:message key="other"></liferay-ui:message>
			</li>
			<liferay-portlet:renderURL varImpl="viewVisitorCategoryURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="visitorCategory" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "visitor-category") %>' 
				
				selected='<%= (navigation.equals("visitorCategory")) %>'
				viewURL="<%= viewVisitorCategoryURL.toString() %>"
				
			/>
			<liferay-portlet:renderURL varImpl="viewMemberCategoryURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="memberCategory" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "member-category") %>' 
				
				selected='<%= (navigation.equals("borrowerCategory")) %>'
				viewURL="<%= viewMemberCategoryURL.toString() %>"
				
			/>
			
			<li class="nav-header">
				<liferay-ui:message key="seating"></liferay-ui:message>
			</li>
			<liferay-portlet:renderURL varImpl="seatingDepartmentURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="seatingDepartment" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "seating-department") %>' 
				
				selected='<%= (navigation.equals("seatingDepartment")) %>'
				viewURL="<%= seatingDepartmentURL.toString() %>"
				
			/>
			<liferay-portlet:renderURL varImpl="seatingCategoryURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
				<portlet:param name="navigation" value="seatingCategory" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:app-view-navigation-entry
				
				dataView="<%= dataView %>"
				entryTitle='<%= LanguageUtil.get(pageContext, "seating-category") %>' 
				
				selected='<%= (navigation.equals("seatingCategory")) %>'
				viewURL="<%= seatingCategoryURL.toString() %>"
				
			/>
			
		</aui:nav>
		
	</div>
</div>
			
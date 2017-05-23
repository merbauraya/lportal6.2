<portlet:renderURL var="manageUserLibraryURL">
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="userLibrary" />
</portlet:renderURL>

<portlet:renderURL var="viewLibraryTypeURL">
	
	<portlet:param name="mvcPath" value="/html/admin/libraryType.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="viewLibraryURL">
	
	<portlet:param name="mvcPath" value="/html/admin/library.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="facultyTypeURL">
	
	<portlet:param name="mvcPath" value="/html/admin/facultyType.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="facultyURL">
	
	<portlet:param name="mvcPath" value="/html/admin/faculty.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="printedItemTypeURL">
	
	<portlet:param name="mvcPath" value="/html/admin/printedItemType.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="nonPrintedItemTypeURL">
	
	<portlet:param name="mvcPath" value="/html/admin/nonPrintedItemType.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="configURL">
	
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="config" />
</portlet:renderURL>

<portlet:renderURL var="emailNotificationURL">
	
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="emailNotification" />
</portlet:renderURL>
<portlet:renderURL var="reportURL">
	
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="report" />
</portlet:renderURL>

<portlet:renderURL var="KpiTypeURL">
	
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="kpiType" />
</portlet:renderURL>
<portlet:renderURL var="KpiSettingURL">
	
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="kpiSetting" />
</portlet:renderURL>
<portlet:renderURL var="KpiEntryURL">
	
	
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="kpiEntry" />
</portlet:renderURL>
 	<portlet:renderURL var="propertyURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="navigation" value="master-file-property" />
			
		</portlet:renderURL>
       	
<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
    <aui:nav cssClass="navbar-nav">
    	<aui:nav-item dropdown="true" label="system-setting" iconCssClass="icon-cog">
    		 <aui:nav-item iconCssClass="icon-edit" href="<%=configURL %>" label="configuration" selected='<%=navigation.equals("config") %>' />
    		 <aui:nav-item href="<%=reportURL %>" iconCssClass="icon-bar-chart" label="report" selected='<%=navigation.equals("report") %>' />
    		 <aui:nav-item iconCssClass="icon-envelope" href="<%=emailNotificationURL %>" label="email-notification" selected='<%=navigation.equals("emailNotification") %>' />
    		 <aui:nav-item href="<%=manageUserLibraryURL %>" iconCssClass="icon-user" label="user-library" selected='<%=navigation.equals("userLibrary") %>' />
    		 
    		
    	
    	</aui:nav-item>
    
    	
       	
       	
      
       	
      
       	
       	
       	
       	
       	<%
       		String stateKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_STATE);
       		String allocationKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_EXPENSE_ALLOCATION_TYPE);
       		String itemTypeKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_ITEM_TYPE);
       		String libraryTypeKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_LIBRARY_TYPE);
       		String libraryKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_LIBRARY);
       		String ptjKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_PTJ);
       		String ptjTypeKey =  ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_PTJ_TYPE);
       		String itemMediumKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_MEDIUM_TYPE);
       		String postCategoryKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_POST_GRADE_CATEGORY);
       		String postGradeKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_POST_GRADE);
       		String visitorCategoryKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_VISITOR_CATEGORY);
       		String memberCategoryKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_MEMBERSHIP_CATEGORY);
       		String memberGroupKey =  ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_MEMBERSHIP_GROUP);
       		String seatingDeptKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_SEATING_DEPARTMENT);
       		String seatingCategoryKey = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_SEATING_CATEGORY);
       		
       		
       	%>
       	
       	<%
       		PortletURL masterURL = renderResponse.createRenderURL();
       		masterURL.setParameter("mvcPath","/html/admin/view.jsp");
       		masterURL.setParameter("navigation","masterFile");

       	
       	%>
       	
      
       	
       	
       	
       	<portlet:renderURL var="masterTypeURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="navigation" value="masterType" />
			
		</portlet:renderURL>
		<portlet:renderURL var="itemTypeURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="masterTypeId" value="<%=  itemTypeKey %>" />
			<portlet:param name="navigation" value="masterFile" />
		</portlet:renderURL>
		<portlet:renderURL var="stateURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="navigation" value="masterFile" />
			<portlet:param name="masterTypeId" value="<%=  stateKey	 %>" />
		</portlet:renderURL>
		
		<portlet:renderURL var="libraryTypeURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="navigation" value="masterFile" />
			<portlet:param name="masterTypeId" value="<%=  libraryTypeKey	 %>" />
		</portlet:renderURL>
		<portlet:renderURL var="libraryURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="navigation" value="masterFile" />
			<portlet:param name="masterTypeId" value="<%=  libraryKey	 %>" />
		</portlet:renderURL>
		
		
		
       	 <portlet:renderURL var="expenseAllocationTypeURL">
	
	
			<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
			<portlet:param name="navigation" value="masterFile" />
			<portlet:param name="masterTypeId" value="<%=  allocationKey %>" />
		</portlet:renderURL>
       	
       	<portlet:actionURL name="importMaster" var="importMasterURL">
       	
       	</portlet:actionURL>
       	
       	
       	
       	
       	
       	
       		<aui:nav-item dropdown="true" label="master" iconCssClass="icon-edit">
       		    <aui:nav-item href="<%=masterTypeURL %>" label="master-type" /> 
       		    <aui:nav-item href="<%=propertyURL %>" iconCssClass="icon-reorder" label="master-property" selected='<%=navigation.equals("property") %>' />
       			
       <%
       		List<MasterType> masterTypes = MasterTypeLocalServiceUtil.getMasterTypes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
       		List<PortletURL> masterList = new ArrayList();
       		for (MasterType masterType : masterTypes)
       		{
       
       %>
       		<portlet:renderURL var="masterFileURL">
	
	
				<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
				<portlet:param name="navigation" value="masterFile" />
				<portlet:param name="masterTypeId" value="<%=  String.valueOf(masterType.getMasterTypeId())	 %>" />
			
			
			
		</portlet:renderURL>
			<aui:nav-item href="<%=masterFileURL %>" label="<%= masterType.getPageLabel() %>" /> 
		
       	<%
       		}
       	%>
       		
       		
       		
       			
       		
       			
       			
       			
       			
       			
       		</aui:nav-item>
       		
       		 <aui:nav-item dropdown="true" label="kpi" iconCssClass="icon-edit">
	       		<aui:nav-item href="<%=KpiSettingURL %>" label="kpi-setting" selected='<%=navigation.equals("userLibrary") %>' />
	    		<aui:nav-item href="<%=KpiTypeURL %>" label="kpi-type" selected='<%=navigation.equals("userLibrary") %>' />
	    		<aui:nav-item href="<%=KpiEntryURL %>" label="kpi-entry" selected='<%=navigation.equals("userLibrary") %>' />
	       			
	       	 
	       	</aui:nav-item>
      		
      		<portlet:renderURL var="dashboardDesignURL">
	
	
				<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
				<portlet:param name="navigation" value="dashboard_design" />
				
			
			</portlet:renderURL>
			<portlet:renderURL var="infoBoxURL">
				<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
				<portlet:param name="navigation" value="infoBox" />
			</portlet:renderURL>
		<c:if test="<%= devMode %>">
      		
      		
      		<aui:nav-item dropdown="true" label="dashboard" iconCssClass="icon-edit">
      			<aui:nav-item href="<%=dashboardDesignURL %>" label="design-dashboard" />
      			<aui:nav-item href="<%=infoBoxURL %>" label="info-box" />
      		
      		</aui:nav-item>
            
            
        </c:if>    
        
      
    </aui:nav>
</aui:nav-bar>
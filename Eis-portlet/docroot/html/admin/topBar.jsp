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

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
    <aui:nav cssClass="navbar-nav">
    	 <aui:nav-item iconCssClass="icon-cog" href="<%=configURL %>" label="configuration" selected='<%=navigation.equals("config") %>' />
    	<aui:nav-item href="<%=reportURL %>" label="report" selected='<%=navigation.equals("report") %>' />
    	  <aui:nav-item iconCssClass="icon-envelope" href="<%=emailNotificationURL %>" label="email-notification" selected='<%=navigation.equals("emailNotification") %>' />
    	
        <aui:nav-item href="<%=manageUserLibraryURL %>" label="user-library" selected='<%=navigation.equals("userLibrary") %>' />
       	
       	
       	<aui:nav-item dropdown="true" label="kpi" iconCssClass="icon-edit">
       		<aui:nav-item href="<%=KpiSettingURL %>" label="kpi-setting" selected='<%=navigation.equals("userLibrary") %>' />
    		<aui:nav-item href="<%=KpiTypeURL %>" label="kpi-type" selected='<%=navigation.equals("userLibrary") %>' />
    		<aui:nav-item href="<%=KpiEntryURL %>" label="kpi-entry" selected='<%=navigation.equals("userLibrary") %>' />
       			
       	 
       	</aui:nav-item>
       	
            
            
            
        
      
    </aui:nav>
</aui:nav-bar>
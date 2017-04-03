<%@ include file="/html/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	
	
	long projectId = ParamUtil.getLong(request,"projectId"); 
	Project project = null;
	String title = LanguageUtil.format(pageContext, "add-project", StringPool.BLANK) ;
	if (Validator.isNotNull(projectId))
	{
		project = ProjectLocalServiceUtil.fetchProject(projectId);
		title = project.getProjectName();
		
	}
	String backURL = ParamUtil.getString(request, "backURL");
	
%>

<portlet:actionURL var="editProjectURL" name="editProject">
	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>


<aui:form action="<%=editProjectURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= project %>" model="<%= Project.class %>" />
	<aui:input name="projectId" type="hidden" value="<%= projectId %>" />
	
	<aui:input name="projectName" cssClass="fullwidth" label="nama-projek"/>
	<%
		int progressStatus = 1;
		if (Validator.isNotNull(project))
		{
			progressStatus = project.getProgressStatus();
		}
	
	%>
	<eis:progress-selector progressStatus="<%= progressStatus %>"/>
	
	<aui:layout>
		<%
			
			int yearValue=0,monthValue=0,dayValue = 0;
			if (Validator.isNotNull(project))
			{
				if (Validator.isNotNull(project.getStartDate()))
				{
					//Calendar cal = Calendar.getInstance();
					Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
				    cal.setTime(project.getStartDate());
				    yearValue = cal.get(Calendar.YEAR);
				    monthValue = cal.get(Calendar.MONTH);
				    dayValue = cal.get(Calendar.DATE);
				}
			}
		%>
		
		<aui:field-wrapper label="p-start-date">
			<eis:input-date
				dayParam="dateStartDay"
				monthParam="dateStartMonth"
				yearParam="dateStartYear"
				cssClass="form-group form-group-inline"
				nullable="<%= true %>"
				dayValue="<%= dayValue %>"
				monthValue="<%= monthValue %>"
				yearValue="<%= yearValue %>"
				name="startDate"
			/>
		
			
		</aui:field-wrapper>
	
	
	</aui:layout>
	<aui:layout>
		<%
			
			int yearValue=0,monthValue=0,dayValue = 0;
			if (Validator.isNotNull(project))
			{
				if (Validator.isNotNull(project.getEndDate()))
				{
					//Calendar cal = Calendar.getInstance();
					Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
				    cal.setTime(project.getEndDate());
				    yearValue = cal.get(Calendar.YEAR);
				    monthValue = cal.get(Calendar.MONTH);
				    dayValue = cal.get(Calendar.DATE);
				}
			}
		%>
		
		<aui:field-wrapper label="p-end-date">
			<eis:input-date
				dayParam="dateEndDay"
				monthParam="dateEndMonth"
				yearParam="dateEndYear"
				cssClass="form-group form-group-inline"
				nullable="<%= true %>"
				dayValue="<%= dayValue %>"
				monthValue="<%= monthValue %>"
				yearValue="<%= yearValue %>"
				name="endDate"
			/>
		
			
		</aui:field-wrapper>
	
	
	</aui:layout>
	
	<%
			int status = 3;
			if (Validator.isNotNull(project))
			{
				status = project.getProjectStatus();
			}
		%>
	<eis:status-selector controlName="projectStatus" status="<%= status %>"/>
	<aui:input name="progress" label="progress-percentage">
		<aui:validator name="digits"></aui:validator>
		<aui:validator name="max">100</aui:validator>
	</aui:input>
	
	<aui:layout>
		<aui:column columnWidth="25" first="true">
			<aui:input name="resourceId"  type="hidden" />
			<aui:input name="resourceName" label="project-manager" />
		</aui:column>
		<aui:column columnWidth="25" >
			<aui:input name="resourceType" label="bahagian"/>
		</aui:column>
		
	</aui:layout>
	<div id="completionDatePicker" class="aui-datepicker aui-datepicker-display aui-helper-clearfix">
</div>
	
	<%
		
		int yearValue=0,monthValue=0,dayValue = 0;
		if (Validator.isNotNull(project))
		{
			if (Validator.isNotNull(project.getCompletionDate()))
			{
				//Calendar cal = Calendar.getInstance();
				Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
			    cal.setTime(project.getCompletionDate());
			    yearValue = cal.get(Calendar.YEAR);
			    monthValue = cal.get(Calendar.MONTH);
			    dayValue = cal.get(Calendar.DATE);
			}
		}
	%>
	
	<aui:field-wrapper label="p-completion-date">
		<eis:input-date
			dayParam="completionDay"
			monthParam="completionMonth"
			yearParam="completionYear"
			cssClass="form-group form-group-inline"
			nullable="<%= true %>"
			dayValue="<%= dayValue %>"
			monthValue="<%= monthValue %>"
			yearValue="<%= yearValue %>"
			name="completionDate"
		/>
	
		
	</aui:field-wrapper>
	
	<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
	</aui:button-row>
	
	

</aui:form>


<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var url = '<%=editProjectURL.toString()%>'; 
        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>fm'},
                on: {
                    success: function() {
                        Liferay.Util.getOpener().refreshPortlet();
                        Liferay.Util.getOpener().closePopup('<portlet:namespace/>dialog');
                    }
                }
            }
        );
    });
    
   
</aui:script>


<%@ include file="/html/init.jsp" %>

<%
	long projectId = ParamUtil.getLong(request, "projectId");
	long strategyId = ParamUtil.getLong(request,"strategyId");
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	
	ProjectStrategy strategy = null;
	
	if (Validator.isNotNull(strategyId))
	{
		strategy = ProjectStrategyLocalServiceUtil.fetchProjectStrategy(strategyId);
	}
	Project project = null;
	if (Validator.isNotNull(projectId))
	{
		project = ProjectLocalServiceUtil.fetchProject(projectId);
	}else
	{
		if (Validator.isNotNull(strategyId))
		{
			project = ProjectLocalServiceUtil.fetchProject(strategy.getProjectId());
		}
	}

%>
<portlet:actionURL var="editStrategyURL" name="editStrategy">
	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>


<aui:form action="<%=editStrategyURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= strategy %>" model="<%= ProjectStrategy.class %>" />
	<aui:input name="projectId" type="hidden" value="<%= projectId %>" />
	<aui:input name="projectStrategyId" type="hidden" />
	<aui:input name="strategyName" cssClass="fullwidth"/>
	
	<%
		int progressStatus = 1;
		if (Validator.isNotNull(strategy))
		{
			progressStatus = strategy.getProgressStatus();
		}
	
	%>
	<eis:progress-selector progressStatus="<%= progressStatus %>"/>
	<aui:layout>
		<%
			
			int yearValue=0,monthValue=0,dayValue = 0;
			if (Validator.isNotNull(strategy))
			{
				if (Validator.isNotNull(strategy.getStartDate()))
				{
					//Calendar cal = Calendar.getInstance();
					Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
				    cal.setTime(strategy.getStartDate());
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
			if (Validator.isNotNull(strategy))
			{
				if (Validator.isNotNull(strategy.getEndDate()))
				{
					//Calendar cal = Calendar.getInstance();
					Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
				    cal.setTime(strategy.getEndDate());
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
			if (Validator.isNotNull(strategy))
			{
				status = strategy.getStatus();
			}
		%>
	<eis:status-selector controlName="strategyStatus" status="<%= status %>"/>
	<aui:input name="progress" label="progress-percentage">
		<aui:validator name="digits"></aui:validator>
		<aui:validator name="max">100</aui:validator>
	</aui:input>
	
	<div id="completionDatePicker" class="aui-datepicker aui-datepicker-display aui-helper-clearfix">
</div>
	
	<%
		int yearValue=0,monthValue=0,dayValue = 0;
		
		if (Validator.isNotNull(strategy))
		{
			if (Validator.isNotNull(strategy.getCompletionDate()))
			{
				//Calendar cal = Calendar.getInstance();
				Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
			    cal.setTime(strategy.getCompletionDate());
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
	
	<aui:input name="remark" label="nota" type="textarea" rows="6" style="width:100%;"></aui:input>
	
	<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
	</aui:button-row>
	
	

</aui:form>



<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var url = '<%=editStrategyURL.toString()%>'; 
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

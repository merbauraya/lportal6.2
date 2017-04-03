<%@ include file="/html/init.jsp" %>

<%
	
	long strategyId = ParamUtil.getLong(request,"strategyId");
	long activityId = ParamUtil.getLong(request,"activityId");
	
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	
	ProjectActivity activity = null;
	
	if (Validator.isNotNull(activityId))
	{
		activity = ProjectActivityLocalServiceUtil.fetchProjectActivity(activityId);
	}
	

%>
<portlet:actionURL var="editActivityURL" name="editActivity">
	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>



<aui:form action="<%=editActivityURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= activity %>" model="<%= ProjectActivity.class %>" />
	<aui:input name="activityId" type="hidden" value="<%= activityId %>" />
	<aui:input name="strategyId" type="hidden"  value="<%= strategyId %>"/>
	<aui:input name="activityName" style="width:100%;"/>
	
	<%
		int progressStatus = 1;
		if (Validator.isNotNull(activity))
		{
			progressStatus = activity.getProgressStatus();
		}
	
	%>
	<eis:progress-selector progressStatus="<%= progressStatus %>"/>
	
	<aui:layout>
		<%
			
			int yearValue=0,monthValue=0,dayValue = 0;
			if (Validator.isNotNull(activity))
			{
				if (Validator.isNotNull(activity.getStartDate()))
				{
					//Calendar cal = Calendar.getInstance();
					Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
				    cal.setTime(activity.getStartDate());
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
			if (Validator.isNotNull(activity))
			{
				if (Validator.isNotNull(activity.getEndDate()))
				{
					//Calendar cal = Calendar.getInstance();
					Calendar cal = CalendarFactoryUtil.getCalendar(timeZone, locale); 
				    cal.setTime(activity.getEndDate());
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
			if (Validator.isNotNull(activity))
			{
				status = activity.getStatus();
			}
		%>
	<eis:status-selector controlName="strategyStatus" status="<%= status %>"/>
	<aui:input name="progress" label="progress-percentage">
		<aui:validator name="max">100</aui:validator>
		<aui:validator name="digits"></aui:validator>
	</aui:input>
	
	
	<div id="completionDatePicker" class="aui-datepicker aui-datepicker-display aui-helper-clearfix">
	
</div>
	
	<%
	int yearValue=0,monthValue=0,dayValue = 0;
		if (Validator.isNotNull(activity))
		{
			if (Validator.isNotNull(activity.getCompletionDate()))
			{
				//Calendar cal = Calendar.getInstance();
				//Calendar x = CalendarFactoryUtil.getc
				Calendar cal = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone(),themeDisplay.getLocale());//, locale); 
			    cal.setTime(activity.getCompletionDate());
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
			nullable="<%= false %>"
			dayValue="<%= dayValue %>"
			monthValue="<%= monthValue %>"
			yearValue="<%= yearValue %>"
			name="completionDate"
			disabled="<%= false %>"
			
		/>
	
		
	</aui:field-wrapper>
	<aui:input name="remark" style="width:100%;" type="textarea" rows="6" label="nota"></aui:input>
	<aui:button-row>
		<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
	</aui:button-row>
	
	

</aui:form>



<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var url = '<%=editActivityURL.toString()%>'; 
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
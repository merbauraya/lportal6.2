<%@ include file="/html/init.jsp" %>

<%
	String adminEmailFromName = LanguageUtil.get(locale,"sender-name");//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
	String adminEmailFromAddress = LanguageUtil.get(locale,"sender-address");//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

	String firstNotificationSubject = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_SUBJECT);
	
	String firstNotificationBody = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_BODY);
	String secondNotificationSubject = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_SUBJECT);

	String secondNotificationBody = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_BODY);
	String fromAddress = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_ADDRESS);
	String fromName = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_NAME);
	String firstReminderSendContinuous = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_REMINDER_1ST_SEND_CONTINUOUSLY);
	String secondReminderSendContinuous = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_REMINDER_2ND_SEND_CONTINUOUSLY);
	String enableEmailNotification = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_ENABLE_EMAIL_NOTIFICATION);

	String firstReminderDay = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_1ST);
	String firstReminderDayUntil = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_1ST_UNTIL);
	
	String secondReminderDay = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_2ND);
	String secondReminderDayUntil = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_2ND_UNTIL);
	
%>
<portlet:actionURL var="emailNotificationURL" name="editEmailNotification">

	
</portlet:actionURL>
<aui:form name="fm" method="post" action="<%=emailNotificationURL %>" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
	
	<aui:input type="checkbox" name="enableEmailNotification" value="<%= enableEmailNotification %>"/>
	
	
	<aui:input name="fromAddress" label="from-address" value="<%= fromAddress %>">
		<aui:validator name="email" ></aui:validator>
	</aui:input>
	<aui:input name="fromName" label="from-name" value="<%= fromName %>"></aui:input>
	
	
	<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="first-notification">
	
		<aui:input label="first-reminder-day" name="firstReminderDay" value="<%= firstReminderDay %>">
			<aui:validator name="required" errorMessage="required-field"></aui:validator>
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="max">30</aui:validator>
		</aui:input>
		<!-- 
		<aui:input type="checkbox" name="firstReminderSendContinuous" value="<%= firstReminderSendContinuous %>"/>
		
		-->
		<aui:input label="first-reminder-day-until" name="firstReminderDayUntil" value="<%= firstReminderDayUntil %>">
			<aui:validator name="required" errorMessage="required-field"></aui:validator>
			<aui:validator name="digits"></aui:validator>
			
			<aui:validator name="max">30</aui:validator>
			<aui:validator name="custom" errorMessage="must-greater-than-first-reminder-day">
            function (val, fieldNode, ruleValue)
                { 
                	if (val <= A.one("#<portlet:namespace />firstReminderDay").val())
                	{
                		
                   		
                   		return false;
                   	}else
                   	{
                   		return true;
                   	}
                   	
                }
        </aui:validator>
		</aui:input>
		
		<aui:input name="firstNotificationSubject" value="<%=firstNotificationSubject %>"></aui:input>
		
		<aui:field-wrapper helpMessage="template-for-first-submission-notification" label="first-notification">
			<liferay-ui:input-editor initMethod='<%= "initFirstNotificationBodyEditor" %>' name="firstNotificationBody" toolbarSet="email" width="470" />
			<aui:input name='firstNotificationTemplate' type="hidden" value="<%= firstNotificationBody %>" />
			
		</aui:field-wrapper>
		<div class="terms email-user-add definition-of-terms">
				<%@ include file="/html/admin/definition_of_terms.jspf" %>
		</div>
		
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="second-notification">
		<aui:input label="second-reminder-day" name="secondReminderDay" value="<%= secondReminderDay %>">
			<aui:validator name="required" errorMessage="required-field"></aui:validator>
			<aui:validator name="digits"></aui:validator>
			<aui:validator name="max">30</aui:validator>
		</aui:input>
		<aui:input label="second-reminder-day-until" name="secondReminderDayUntil" value="<%= secondReminderDayUntil %>">
			<aui:validator name="required" errorMessage="required-field"></aui:validator>
			<aui:validator name="digits"></aui:validator>
			
			<aui:validator name="max">30</aui:validator>
			<aui:validator name="custom" errorMessage="must-greater-than-second-reminder-day">
            function (val, fieldNode, ruleValue)
                { 
                	if (val <= A.one("#<portlet:namespace />secondReminderDay").val())
                	{
                		
                   		
                   		return false;
                   	}else
                   	{
                   		return true;
                   	}
                   	
                }
        </aui:validator>
		</aui:input>
		<!-- 
		<aui:input type="checkbox" name="secondReminderSendContinuous" value="<%= secondReminderSendContinuous %>"/>
		-->
		<aui:input name="secondNotificationSubject" value="<%=secondNotificationSubject %>"></aui:input>
		<aui:field-wrapper helpMessage="template-for-second-submission-notification" label="second-notification">
			
			<liferay-ui:input-editor initMethod='<%= "initSecondNotificationBodyEditor" %>' name="secondNotificationBody" toolbarSet="email" width="470" />
			<aui:input name='secondNotificationTemplate' type="hidden" value="<%= secondNotificationBody %>" />
			
		</aui:field-wrapper>
		<div class="terms email-user-add definition-of-terms">
				<%@ include file="/html/admin/definition_of_terms.jspf" %>
		</div>
	</liferay-ui:panel>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>


</aui:form>
<aui:script>
	
	
	
	function <portlet:namespace />initFirstNotificationBodyEditor() {
		
		return "<%= UnicodeFormatter.toString(firstNotificationBody) %>";
	}
	function <portlet:namespace />initSecondNotificationBodyEditor() {
		
		return "<%= UnicodeFormatter.toString(secondNotificationBody) %>";
	}
	function <portlet:namespace />saveEmails()
	{
		
		//document.<portlet:namespace />+'firstNotificationTemplate'.value = window.<portlet:namespace />firstNotificationBody.getHTML();

		//alert(A.one('#<portlet:namespace />firstNotificationTemplate').value);
	}
</aui:script>

<aui:script>
	var A = AUI();
	
	
	
	function <portlet:namespace />submitForm()
	{
		
		
		//A.one('#<portlet:namespace />firstNotificationTemplate').value = window.<portlet:namespace />firstNotificationBody.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />firstNotificationTemplate.value = window.<portlet:namespace />firstNotificationBody.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />secondNotificationTemplate.value = window.<portlet:namespace />secondNotificationBody.getHTML();
	
		
		submitForm(document.<portlet:namespace />fm);
		
	}
</aui:script>


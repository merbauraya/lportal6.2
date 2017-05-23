<%@ include file="/html/init.jsp" %>


<portlet:actionURL var="editURL" name="editConfig"> 
	
</portlet:actionURL>
<%
	
	Properties prop = ConfigLocalServiceUtil.getByKey(EisUtil.KEY_CONFIG);
	
	boolean enablePreviousYear = GetterUtil.getBoolean(prop.get(EisUtil.CONFIG_PERIOD_ALLOW_PREVIOUS),true);
	boolean useYearRange = GetterUtil.getBoolean(prop.get(EisUtil.CONFIG_PERIOD_USE_YEAR_RANGE),false);
	int minYear = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_PERIOD_MIN_YEAR),0);
	int maxYear = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_PERIOD_MAX_YEAR),0);
	
	int minYearPrevious = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_PERIOD_NUM_YEAR_BACK),1);
	int maxYearForward = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_PERIOD_NUM_YEAR_FWD),1);
	
	int dataDueDay = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_DATA_DUE_DAY),3);
	int firstReminder = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_REMINDER_DAY_1ST),5);
	int secondReminder = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_REMINDER_DAY_2ND),10);
	int reminderOption = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_REMINDER_OPTION),1);
	int dataCutOffDay = GetterUtil.getInteger(prop.get(EisUtil.CONFIG_MONTH_DATA_CUT_OFF_DAY),10);
	
	boolean useMonthName = GetterUtil.getBoolean(prop.get(EisUtil.CONFIG_PERIOD_USE_MONTH_NAME),true);
	boolean libraryAdminAllowAll = GetterUtil.getBoolean(prop.get(EisUtil.CONFIG_LIBRARY_ADMIN_ALLOW_ALL),false);
	boolean allowFuturePeriod = GetterUtil.getBoolean(prop.get(EisUtil.CONFIG_ALLOW_FUTURE_PERIOD),false);
	String membershipGroup = GetterUtil.getString(prop.get(EisUtil.CONFIG_MEMBERSHIP_GROUP)) ;
	


%>
<h2>Settings</h2>
<aui:form name="fm" action="<%= editURL %>">
	
	<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="library">
		<aui:input checked="<%= libraryAdminAllowAll %>" name="libraryAdminAllowAll" label="allow-admin-all-library" type="checkbox"></aui:input>
		<aui:input name="membershipGroup" value="<%= membershipGroup%>" label="library-membership-group"></aui:input>
		
		
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="period">
	
	<aui:input checked="<%= useMonthName %>" name="useMonthName" label="show-month-as-name" type="checkbox"></aui:input>
	<aui:input checked="<%= enablePreviousYear%>" cssClass="toggler-header-collapsed header " name="allowPreviousYear" label="allow-previous-year" type="checkbox"></aui:input>
	
	<div id="togglePreviousYear">
		<aui:input checked="<%= useYearRange %>" id="periodYearRange" label="use-year-range" name="periodYearRange" type="radio" value="<%= true %>" />
	
		<aui:input checked="<%= !useYearRange %>" id="periodCustomYear" label="use-custom-year" name="periodYearRange" type="radio" value="<%= false %>" />
		
		
		<aui:fieldset id="periodYearRangeFieldSet">
			<aui:input label="from-year" name="minYear" value="<%= minYear %>"></aui:input>
			<aui:input label="to-year" name="maxYear" value="<%= maxYear %>"></aui:input>
		</aui:fieldset>
		
		<aui:fieldset id="periodUseCustomFieldSet">
			<aui:input name="minYearPrevious" value="<%=minYearPrevious %>"></aui:input>
			
			<aui:input name="maxYearForward" value="<%= maxYearForward %>"></aui:input>
			
			
		</aui:fieldset>
		<aui:input checked="<%= allowFuturePeriod %>" cssClass="toggler-header-collapsed header " name="allowFuturePeriod" label="allow-future-period" type="checkbox"></aui:input>
		
		
	</div>
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="reminder-and-data">
	<aui:fieldset>
		<aui:input label="data-due-day" name="dataDueDay" value="<%= dataDueDay %>"/>
		
		
		<aui:select name="reminderOption">
			<aui:option selected="<%= reminderOption==1 %>" value="1">Email </aui:option>
			<aui:option selected="<%= reminderOption==2 %>" value="2">Site Notification </aui:option>
			<aui:option selected="<%= reminderOption==3 %>" value="3">Both </aui:option>
			
		</aui:select>
		
		<aui:input label="data-cut-off-day" name="dataCutOffDay" value="<%= dataCutOffDay %>"/>
	</aui:fieldset>
	
	</liferay-ui:panel>
	
	
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>


<aui:script position="inline" use="aui-toggler">
	Liferay.Util.toggleRadio('<portlet:namespace />periodYearRange', '<portlet:namespace />periodYearRangeFieldSet', '<portlet:namespace />periodUseCustomFieldSet');
	Liferay.Util.toggleRadio('<portlet:namespace />periodCustomYear', '<portlet:namespace />periodUseCustomFieldSet', '<portlet:namespace />periodYearRangeFieldSet');
	
	A.one('#<portlet:namespace/>allowPreviousYearCheckbox').on('click', function(){
		
		var checked = this.attr('checked');
		
		if (checked)
		{
			A.one('#togglePreviousYear').removeClass('hide');
		
		}else
		{
			A.one('#togglePreviousYear').addClass('hide');
		}
		
	});
	
	
	
	</aui:script>
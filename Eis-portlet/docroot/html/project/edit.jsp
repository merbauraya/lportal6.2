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
<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= LanguageUtil.format(pageContext, "edit-x", title) %>'
/>
<portlet:actionURL var="editProjectURL" name="editProject">
	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>


<aui:form action="<%=editProjectURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= project %>" model="<%= Project.class %>" />
	<aui:input name="projectId" type="hidden" value="<%= projectId %>" />
	
	<aui:input name="projectName" cssClass="fullwidth"/>
	<aui:layout>
		<aui:column columnWidth="25" first="true">
			<eis:month-selector controlName="startMonth" value="2"/>
		
		
		
			
		</aui:column>
		<aui:column columnWidth="25" first="true">
			<aui:select name="startYear">
			<%
				int start=2013;
				for (int i = 2014; i < 2030; i++)
				{	
			%>
				<aui:option value="<%= i %>"><%= i %></aui:option>
			<%
				}
			%>
			</aui:select>
		</aui:column>
		
	</aui:layout>
	<aui:layout>
		<aui:column columnWidth="25" first="true">
			<eis:month-selector controlName="endMonth" value="2"/>
		</aui:column>
		<aui:column columnWidth="25" first="true">
		
			<aui:select name="endYear">
			<%
				int start=2013;
				for (int i = 2014; i < 2030; i++)
				{	
			%>
				<aui:option value="<%= i %>"><%= i %></aui:option>
			<%
				}
			%>
			</aui:select>
			 
		</aui:column>
		
	</aui:layout>
	<%
			int status = 3;
			if (Validator.isNotNull(project))
			{
				status = project.getProjectStatus();
			}
		%>
	<eis:status-selector controlName="projectStatus" status="<%= status %>"/>
	<aui:input name="progress"></aui:input>
	
	<aui:layout>
		<aui:column columnWidth="25" first="true">
			<aui:input name="resourceId"  type="hidden" />
			<aui:input name="resourceName" />
		</aui:column>
		<aui:column columnWidth="25" >
			<aui:input name="resourceType" />
		</aui:column>
		
	</aui:layout>
	<div id="completionDatePicker" class="aui-datepicker aui-datepicker-display aui-helper-clearfix">
</div>
	
	
	<aui:field-wrapper label="completion-date">
		<liferay-ui:input-date
			dayParam="completionDay"
			monthParam="completionMonth"
			yearParam="completionYear"
			name="completionDate"
			cssClass="form-group form-group-inline"
			nullable="<%= true %>"
		>
	
		</liferay-ui:input-date>
	</aui:field-wrapper>
	
	<aui:button-row>
		<aui:button name="submitBtn" type="submit" value="Save" last="true" />
	</aui:button-row>
	
	

</aui:form>



<aui:script  use="aui-base">
	var A = AUI();
	/*
	A.all(".htmlStatus  td").on('click',function(e){
	 console.log(e);
	 var statusId= e.currentTarget.attr("statusId")
	 console.log(statusId);
	 
	 //A.all('.htmlStatus  td').removeClass('disabled');
	 A.all('.htmlStatus  td').addClass('disabled');
	 e.currentTarget.removeClass('disabled');
	})
	*/
	
	function <portlet:namespace/>submitForm()
	{
		console.log('X');
		submitForm(document.<portlet:namespace />fm);
		
	}
</aui:script>


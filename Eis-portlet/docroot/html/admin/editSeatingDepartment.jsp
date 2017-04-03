<%@ include file="/html/init.jsp" %>
 

<%
	long departmentId = ParamUtil.getLong(request, "departmentId");
	SeatingDepartment department = null; 
	
	if (Validator.isNotNull(departmentId))
	{
		department = SeatingDepartmentLocalServiceUtil.fetchSeatingDepartment(departmentId);
	}
	
%>

<portlet:actionURL var="editURL" name="editSeatingDepartment"> 
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(department) %>">
		<h4>
		<%= LanguageUtil.get(locale, "add-department") %>
		</h4>
	</c:when>
	
	<c:otherwise>
		<h4>
		<%= LanguageUtil.get(locale, "edit-department") %>
		 </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= department %>" model="<%= SeatingDepartment.class %>" />
	
	<aui:fieldset>
		<aui:input name="departmentId" type="hidden" value="<%= departmentId %>" />
		
		<aui:input name="departmentName"  />
		
		
	</aui:fieldset>
</aui:form>
	<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
			<aui:button name="closeDialog" type="cancel"/>
		</aui:button-row>

<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var url = '<%=editURL.toString()%>'; 
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

<aui:script use="aui-base" >
	var A = AUI();
	A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
    	Liferay.Util.getOpener().closePopup('<portlet:namespace/>dialog');
});

</aui:script>


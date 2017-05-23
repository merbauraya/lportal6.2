<%@ include file="/html/init.jsp" %>
 

<%
	long id = ParamUtil.getLong(request, "id");
	Config property = null; 
	
	if (Validator.isNotNull(id))
	{
		property = ConfigLocalServiceUtil.fetchConfig(id);
	}
	
%>

<portlet:actionURL var="editURL" name="editProperty"> 
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(property) %>">
		<h4>Add Property</h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit Property </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= property %>" model="<%= Config.class %>" />
	
	<aui:fieldset>
		<aui:input name="propertyId" type="hidden" value="<%= id %>" />
		
		<aui:input name="key"  />
		<aui:input name="value"  />
		
		
		
		
		
		
	
	
	
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


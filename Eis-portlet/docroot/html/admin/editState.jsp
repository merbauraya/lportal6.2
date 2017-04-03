<%@ include file="/html/init.jsp" %>


<%
	long stateId = ParamUtil.getLong(request, "stateId");
	State state = null; 
	
	if (Validator.isNotNull(stateId))
	{
		state = StateLocalServiceUtil.fetchState(stateId);
	}
	
%>

<portlet:actionURL var="editStateURL" name="editState">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(state) %>">
		<h4>Add State</h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit State</h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editStateURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= state %>" model="<%= State.class %>" />
	
	<aui:fieldset>
		<aui:input name="stateId" type="hidden" value="<%= stateId %>" />
		<aui:input name="stateCode"  />
		<aui:input name="stateName" cssClass="fullwidth"/>
		
		
	
	
	
	</aui:fieldset>
</aui:form>
	<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
			<aui:button name="closeDialog" type="cancel"/>
		</aui:button-row>

<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var url = '<%=editStateURL.toString()%>'; 
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


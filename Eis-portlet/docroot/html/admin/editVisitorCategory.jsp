<%@ include file="/html/init.jsp" %>


<%
	long visitorCategoryId = ParamUtil.getLong(request, "visitorCategoryId");
	VisitorCategory visitorCategory = null; 
	
	if (Validator.isNotNull(visitorCategoryId))
	{
		visitorCategory = VisitorCategoryLocalServiceUtil.fetchVisitorCategory(visitorCategoryId);
	}
	
%>

<portlet:actionURL var="editURL" name="editVisitorCategory"> 
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(visitorCategory) %>"> 
		<h4>Add Visitor Category </h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit Visitor Category </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= visitorCategory %>" model="<%= VisitorCategory.class %>" />
	
	<aui:fieldset>
		<aui:input name="visitorCategoryId" type="hidden" value="<%= visitorCategoryId %>" />
		<aui:input name="visitorCategoryCode" />
		<aui:input name="visitorCategoryName"  />
		
		
		
		
		
		
		
	
	
	
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


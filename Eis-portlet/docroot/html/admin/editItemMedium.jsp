<%@ include file="/html/init.jsp" %>


<%
	long itemMediumId = ParamUtil.getLong(request, "itemMediumId");
	ItemMedium itemMedium = null; 
	
	if (Validator.isNotNull(itemMediumId))
	{
		itemMedium = ItemMediumLocalServiceUtil.fetchItemMedium(itemMediumId);
	}
	
%>

<portlet:actionURL var="editURL" name="editItemMedium">  
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(itemMedium) %>">
		<h4>Add Item Medium</h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit Medium</h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= itemMedium %>" model="<%= ItemMedium.class %>" />
	
	<aui:fieldset>
		<aui:input name="itemMediumId" type="hidden" value="<%= itemMediumId %>" />
		
		<aui:input name="itemMediumName"  />
		
		
		
		
		
		
		
	
	
	
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


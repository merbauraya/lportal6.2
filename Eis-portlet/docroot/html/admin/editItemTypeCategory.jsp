<%@ include file="/html/init.jsp" %>


<%
	long itemTypeCategoryId = ParamUtil.getLong(request, "itemTypeCategoryId");
	ItemTypeCategory itemTypeCategory = null; 
	
	if (Validator.isNotNull(itemTypeCategoryId))
	{
		itemTypeCategory = ItemTypeCategoryLocalServiceUtil.fetchItemTypeCategory(itemTypeCategoryId);
	}
	
%>

<portlet:actionURL var="editURL" name="editItemTypeCategory">  
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(itemTypeCategory) %>">
		<h4>Add Item Type Category </h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit Item Type Category</h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= itemTypeCategory %>" model="<%= ItemTypeCategory.class %>" />
	
	<aui:fieldset>
		<aui:input name="itemTypeCategoryId" type="hidden" value="<%= itemTypeCategoryId %>" />
		
		<aui:input name="itemTypeCategoryName"  />
		
		
		
		
		
		
		
	
	
	
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


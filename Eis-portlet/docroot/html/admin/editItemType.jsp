<%@ include file="/html/init.jsp" %>


<%
	long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
	ItemType itemType = null; 
	
	boolean typeNotAppliable = false;
	boolean typePrinted = false;
	boolean typeNonPrinted = false;
	if (Validator.isNotNull(itemTypeId))
	{
		itemType = ItemTypeLocalServiceUtil.fetchItemType(itemTypeId) ;
		typeNotAppliable = itemType.getPrintedType() == EisUtil.ITEM_TYPE_NOT_APPLICABLE;
		typePrinted = itemType.getPrintedType() == EisUtil.ITEM_TYPE_PRINTED;
		typeNonPrinted = itemType.getPrintedType() == EisUtil.ITEM_TYPE_NON_PRINTED ;
	}else
	{
		
	}
	
%>

<portlet:actionURL var="editURL" name="editItemType">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(itemType) %>">
		<h4><%= LanguageUtil.get(pageContext, "add") %>
		</h4>
	</c:when>
	
	<c:otherwise>
		<h4>
			<%= LanguageUtil.get(pageContext, "edit") %>
		
		</h4>
		
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= itemType %>" model="<%= ItemType.class %>" />
	
	<aui:fieldset>
		<aui:input name="itemTypeId" type="hidden" value="<%= itemTypeId %>" />
		<aui:input name="itemTypeName"  label="itemTypeName" />
		
		
		
		 <aui:field-wrapper name="item-type">
            <aui:input checked="<%= typeNotAppliable %>" inlineLabel="right" name="printedType" type="radio" value="<%= EisUtil.ITEM_TYPE_NOT_APPLICABLE %>" label="not-applicable" />
            <aui:input checked="<%= typePrinted %>" inlineLabel="right" name="printedType" type="radio" value="<%= EisUtil.ITEM_TYPE_PRINTED %>" label="printed-type" />
   		 	<aui:input checked="<%= typeNonPrinted %>" inlineLabel="right" name="printedType" type="radio" value="<%= EisUtil.ITEM_TYPE_NON_PRINTED %>" label="non-printed-type" />
   		 </aui:field-wrapper>
		
		
		<aui:input name="IRType"  />
		
		<aui:input name="active"  />
	
	
	
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


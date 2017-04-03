<%@ include file="/html/init.jsp" %> 
<%
	long id = ParamUtil.getLong(request, "kpiId");
	KpiType kpiType = null;
	if (Validator.isNotNull(id))
	{
		kpiType = KpiTypeLocalServiceUtil.fetchKpiType(id);
	}
	
%>
<portlet:actionURL var="editURL" name="editKpiType">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(kpiType) %>">
		<h4><%= LanguageUtil.get(locale, "add-kpi-type") %> </h4>
	</c:when>
	
	<c:otherwise>
		<h4><%= LanguageUtil.get(locale, "edit-kpi-type") %> </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= kpiType %>" model="<%= KpiType.class %>" />
	
	<aui:fieldset>
		<aui:input name="kpiTypeId" type="hidden" value="<%= id %>" />
		
		<aui:input name="kpiTypeKey">
			<aui:validator name="required"/>
		</aui:input>
		<aui:input name="kpiName">
			<aui:validator name="required"/>
		</aui:input>
		<aui:input name="periodMonth"/>
		<aui:input name="periodQuarter"/>
		<aui:input name="periodSemiAnnual"/>
		<aui:input name="periodYear"/>
		<aui:input name="isDecimal"/>
		<aui:input name="manualValue"/>
		
		
		
		
	
	
	
	</aui:fieldset>
</aui:form>
	<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
			<aui:button name="closeDialog" type="cancel"/>
		</aui:button-row>

<aui:script use="aui-base,aui-io-request,liferay-form">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var validator =  Liferay.Form.get('<portlet:namespace />fm').formValidator;

        if (validator.hasErrors())
        	{
        	return ;
        	}
        
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

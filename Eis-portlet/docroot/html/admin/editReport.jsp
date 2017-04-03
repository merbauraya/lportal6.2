<%@ include file="/html/init.jsp" %>
 

<%
	long reportId = ParamUtil.getLong(request, "reportId");
	Report report = null; 
	
	if (Validator.isNotNull(reportId))
	{
		report = ReportLocalServiceUtil.fetchReport(reportId);
	}
	
%>

<portlet:actionURL var="editURL" name="editReport">  
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(report) %>">
		<h4>Tambah Laporan </h4>
	</c:when>
	
	<c:otherwise>
		<h4>Pinda Laporan </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= report %>" model="<%= Report.class %>" />
	
	<aui:fieldset>
		<aui:input name="reportId" type="hidden" value="<%= reportId %>" />
		
		<aui:input name="reportKey"  />
		<aui:input name="reportTitle" label="report-display-title" cssClass="fullWidth"/>
		
		
		
		
		
		
		
	
	
	
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


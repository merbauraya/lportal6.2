<%@ include file="/html/init.jsp" %>


<%
	long facultyTypeId = ParamUtil.getLong(request, "facultyTypeId");
	FacultyType facultyType = null;  
	
	if (Validator.isNotNull(facultyTypeId))
	{
		facultyType = FacultyTypeLocalServiceUtil.fetchFacultyType(facultyTypeId) ;
	}
	
%>

<portlet:actionURL var="editURL" name="editFacultyType">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(facultyType) %>">
		<h4>Tambah Jenis PTJ</h4>
	</c:when>
	
	<c:otherwise>
		<h4>Pinda Jenis PTJ</h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= facultyType %>" model="<%= FacultyType.class %>" />
	
	<aui:fieldset>
		<aui:input name="facultyTypeId" type="hidden" value="<%= facultyTypeId %>" />
		<aui:input name="facultyTypeName"  />
		
		
		
		
		
	
	
	
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


<%@ include file="/html/init.jsp" %>


<%
	long facultyId = ParamUtil.getLong(request, "facultyId");
	Faculty faculty = null; 
	
	if (Validator.isNotNull(facultyId))
	{
		faculty = FacultyLocalServiceUtil.fetchFaculty(facultyId);
	}
	
%>

<portlet:actionURL var="editURL" name="editFaculty">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(faculty) %>">
		<h4><%= LanguageUtil.get(locale, "add-ptj") %></h4>
	</c:when>
	
	<c:otherwise>
		<h4><%= LanguageUtil.get(locale, "edit-ptj") %> </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= faculty %>" model="<%= Faculty.class %>" />
	
	<aui:fieldset>
		<aui:input name="facultyId" type="hidden" value="<%= facultyId %>" />
		
		<aui:input name="facultyName"  />
		
		<aui:select name="facultyTypeId" label="faculty-type">
			<%
				for (FacultyType facultyType : FacultyTypeLocalServiceUtil.getFacultyTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS) ) {
				%>
 
					<aui:option label="<%= facultyType.getFacultyTypeName() %>" value="<%= facultyType.getFacultyTypeId() %>" />

				<%
				}
			%>
		
		</aui:select>
		
		
		
		
		
		
	
	
	
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


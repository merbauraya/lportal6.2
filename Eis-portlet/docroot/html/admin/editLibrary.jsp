<%@ include file="/html/init.jsp" %>


<%
	long libraryId = ParamUtil.getLong(request, "libraryId");
	Library library = null; 
	
	if (Validator.isNotNull(libraryId))
	{
		library = LibraryLocalServiceUtil.fetchLibrary(libraryId) ;
	}
	
%>

<portlet:actionURL var="editURL" name="editLibrary">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(library) %>">
		<h4><%= LanguageUtil.get(locale, "add-library") %> </h4>
	</c:when>
	
	<c:otherwise>
		<h4><%= LanguageUtil.get(locale, "edit-library") %> </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= library %>" model="<%= Library.class %>" />
	
	<aui:fieldset>
		<aui:input name="libraryId" type="hidden" value="<%= libraryId %>" />
		
		<aui:input name="libraryName"  />
		<aui:input name="libraryCode"></aui:input>
		<aui:select name="stateId" label="state">
			<%
				for (State state : StateLocalServiceUtil.getStates(QueryUtil.ALL_POS, QueryUtil.ALL_POS) ) {
				%>
 
					<aui:option label="<%= state.getStateName() %>" value="<%= state.getStateId() %>" />

				<%
				}
			%>
		
		</aui:select>
		
		<aui:select name="libraryTypeId" >
		<%
			for (LibraryType libraryType : LibraryTypeLocalServiceUtil.getLibraryTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS) ) {
			%>

				<aui:option label="<%= libraryType.getLibraryTypeName() %>" value="<%= libraryType.getLibraryTypeId() %>" />

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


<%@ include file="/html/init.jsp" %>
 

<%
	long categoryId = ParamUtil.getLong(request, "categoryId");
	SeatingCategory category = null; 
	
	if (Validator.isNotNull(categoryId))
	{
		category = SeatingCategoryLocalServiceUtil.fetchSeatingCategory(categoryId);
	}
	
%>

<portlet:actionURL var="editURL" name="editSeatingCategory"> 
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(category) %>">
		<h4>
		<%= LanguageUtil.get(locale, "add-seating-category") %>
		</h4>
	</c:when>
	
	<c:otherwise>
		<h4>
		<%= LanguageUtil.get(locale, "edit-seating-category") %>
		 </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= category %>" model="<%= SeatingCategory.class %>" />
	
	<aui:fieldset>
		
		<aui:select name="departmentId">
			<%
				List<SeatingDepartment> depts = SeatingDepartmentLocalServiceUtil.getSeatingDepartments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				boolean selected = false;
				for (SeatingDepartment dept: depts)
				{
					if (Validator.isNotNull(category))
					{
						selected = category.getSeatingDepartmentId() == dept.getDepartmentId();
					}
			%>
					<aui:option selected="<%= selected %>" label="<%= dept.getDepartmentName() %>" value="<%= dept.getDepartmentId() %>" />

			<%
				}
			%>
		</aui:select>
		<aui:input name="categoryId" type="hidden" value="<%= categoryId %>" />
		
		<aui:input name="seatingCategoryName"  />
		
		
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


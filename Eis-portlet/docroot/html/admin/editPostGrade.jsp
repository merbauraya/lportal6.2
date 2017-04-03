<%@ include file="/html/init.jsp" %>


<%
	long postGradeId = ParamUtil.getLong(request, "postGradeId");

	PostGrade postGrade = null; 
	
	if (Validator.isNotNull(postGradeId))
	{
		postGrade = PostGradeLocalServiceUtil.fetchPostGrade(postGradeId) ;
	}
	
%>

<portlet:actionURL var="editURL" name="editPostGrade">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(postGrade) %>">
		<h4>Add Post Grade </h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit Post Grade </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= postGrade %>" model="<%= PostGrade.class %>" />
	
	<aui:fieldset>
		<aui:input name="postGradeId" type="hidden" value="<%= postGradeId %>" />
		<aui:input name="postGradeCode" label="grade-code" />
		<aui:input name="postGradeName"  label="name"/>
		<aui:input name="postGradeScheme" lael="scheme" />
		
		<aui:select name="postCategoryId" label="grade-category">
			<%
				for (PostCategory postCategory : PostCategoryLocalServiceUtil.getPostCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS) ) {
				%>
 
					<aui:option label="<%= postCategory.getPostCategoryName() %>" value="<%= postCategory.getPostCategoryId() %>" />

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


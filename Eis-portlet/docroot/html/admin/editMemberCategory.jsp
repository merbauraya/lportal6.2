<%@ include file="/html/init.jsp" %>


<%
	
	Properties prop = ConfigLocalServiceUtil.getByKey(EisUtil.KEY_CONFIG);
	
	String[] memberGroupArray = StringUtil.split(GetterUtil.getString(prop.get(EisUtil.CONFIG_MEMBERSHIP_GROUP)));
	long memberCategoryId = ParamUtil.getLong(request, "memberCategoryId");
	MemberCategory memberCategory = null; 
	
	if (Validator.isNotNull(memberCategoryId))
	{
		memberCategory = MemberCategoryLocalServiceUtil.fetchMemberCategory(memberCategoryId);
	}
	
	
%>

<portlet:actionURL var="editURL" name="editMemberCategory"> 
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(memberCategory) %>"> 
		<h4><%= LanguageUtil.get(locale, "add-member-category") %></h4>
	</c:when>
	
	<c:otherwise>
		<h4><%= LanguageUtil.get(locale, "edit-member-category") %></h4>
	</c:otherwise>

</c:choose>


 
<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= memberCategory %>" model="<%= MemberCategory.class %>" />
	
	<aui:fieldset>
		<aui:input name="memberCategoryId" type="hidden" value="<%= memberCategoryId %>" />
			

		<aui:select name="group">
		<%
			for (String group : memberGroupArray)
			{
				boolean selected = false;
				if (Validator.isNotNull(memberCategory))
				{	
					selected = memberCategory.getMemberCategoryGroupName().equals(group);
				}
				
				
				
		%>
			<aui:option selected="<%= selected %>" label="<%= group %>" value="<%= group %>" />
			
		
		<%
			}
		%>
		</aui:select>
		
		<aui:input name="memberCategoryName"  />

		
		
		
		
		
	
	
	
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

<%!
private static Log LOGGER = LogFactoryUtil.getLog("eisPortlet.docroot.html.admin.editMemberCategory_jsp");
%>
<%@ include file="/html/init.jsp" %>

<%
	long id = ParamUtil.getLong(request, "id");
	
	String boxBody = StringPool.BLANK;
	String title = StringPool.BLANK;
	Config infoBox = null;
	
	if (Validator.isNotNull(id))
	{
		infoBox = ConfigLocalServiceUtil.getConfig(id);
		title = infoBox.getTitle();
		boxBody = infoBox.getValue();
	}
		

%>
<portlet:actionURL var="editURL" name="editInfoBox">
	
</portlet:actionURL>

<aui:form name="fm" method="post" action="<%=editURL %>" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
		<aui:input name="title" label="title" value="<%= title %>"></aui:input>
		<aui:input name="id" type="hidden" value="<%= id %>" />
		<%
			List<Config> infoStyles = ConfigLocalServiceUtil.findWithKeyWildcard(EisUtil.EIS_INFO_BOX_TEMPLATE,QueryUtil.ALL_POS,QueryUtil.ALL_POS);

		
		%>
		<aui:select name="infoStyle" onChange='<%= renderResponse.getNamespace() + "applyTemplate();"%>'>
			<aui:option value="0">Blank Template</aui:option>
			<%
			for (Config infoStyle : infoStyles)
			{
			%>
				<aui:option value="<%= infoStyle.getId() %>"><%= infoStyle.getTitle() %></aui:option>
			
			<%
			}
			%>
		</aui:select>
		
		
		<aui:field-wrapper helpMessage="info-box-body-help" label="info-box-body">
			<liferay-ui:input-editor initMethod='<%= "initBoxBody" %>' name="boxBody" width="50%"/>
				<aui:input name='boxBodyTemplate' type="hidden" value="<%= boxBody %>" />
			
		</aui:field-wrapper>
		
		<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>

</aui:form>


<aui:script>
	
	
	
	function <portlet:namespace />initBoxBody() {
		
		return "<%= UnicodeFormatter.toString(boxBody) %>";
	}
	
	
</aui:script>
<portlet:resourceURL var="fetchInfoBoxTemplateURL" id="<%= EisUtil.RESOURCE_EIS_INFO_BOX_TEMPLATE %>"/>

<aui:script>
	var A = AUI();
	
	Liferay.provide(
		    window,
		    '<portlet:namespace />applyTemplate',
		    function() {

		        

		        var fetchTemplateURL = '<%= fetchInfoBoxTemplateURL.toString() %>';

		        // selecting the sourceSelect drop-down to get the current value
		        var sourceElement = A.one("#<portlet:namespace />infoStyle");

		     

		        A.io.request (
		            // the resource URL to fetch words
		            fetchTemplateURL, {
		            data: {
		                // request parameters to be sent to the Server
		                <portlet:namespace />templateId: sourceElement.val()
		            },
		            dataType: 'json',
		            on: {
		                    failure: function() {
		                        // if there was some error at the server
		                        alert("Ajax failed! There was some error at the server");
		                    },
		                    success: function(event, id, obj) {

		                        // JSON Data recieved from Server

		                        var templateHTML = this.get('responseData');
								console.log(templateHTML);
								console.log(window.<portlet:namespace />boxBody);
								window.<portlet:namespace />boxBody.setHTML(templateHTML);
								
		                        

		                       
		                    }
		                }
		            }
		        ); 
		    },
		    ['aui-io']
		);
	
	function <portlet:namespace />submitForm()
	{
		
		
		//A.one('#<portlet:namespace />firstNotificationTemplate').value = window.<portlet:namespace />firstNotificationBody.getHTML();
		document.<portlet:namespace />fm.<portlet:namespace />boxBodyTemplate.value = window.<portlet:namespace />boxBody.getHTML();
		//document.<portlet:namespace />fm.<portlet:namespace />secondNotificationTemplate.value = window.<portlet:namespace />secondNotificationBody.getHTML();
	
		
		submitForm(document.<portlet:namespace />fm);
		
	}
</aui:script>

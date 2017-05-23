<%@ include file="/html/init.jsp" %>

<%
	long masterTypeId = ParamUtil.getLong(request, "masterTypeId");
%>


<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="navigation" value="masterType" />
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="masterTypeId" value="<%= String.valueOf(masterTypeId) %>"/>
       
</liferay-portlet:renderURL>



<h4><%= LanguageUtil.get(locale, "master-file") %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add-master-file" />




<liferay-ui:search-container emptyResultsMessage="no-master-file-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= MasterTypeLocalServiceUtil.getMasterTypes(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= MasterTypeLocalServiceUtil.getMasterTypesCount() %>" />

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.MasterType"
				keyProperty="masterTypeId"
				modelVar="masterType"
				 
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL(); 
			viewItemURL.setParameter("jspPage","/html/project/viewProject.jsp");
			
			
			%>
			<liferay-ui:search-container-column-text property="masterTypeId" name="id"/>
			
			<liferay-ui:search-container-column-text property="masterTypeName" name="master-type-name"/>
				
				
			
			
			
			<liferay-ui:search-container-column-text name="action">
				<%
				String deleteMasterURL = "javascript:deleteMaster(" + masterType.getMasterTypeId() +")";
				%>
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= masterType.getMasterTypeId() %>" href="javascript:;" label="pinda" />
				<aui:a cssClass="btn btn-default" href="<%= deleteMasterURL %>" label="padam" />
				
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	



<portlet:renderURL var="addEditStateURL">
	
</portlet:renderURL>

<aui:script position="inline" use="aui-base,liferay-portlet-url">
			var editStateButton = A.all('.btnEdit');
			
			editStateButton.on(
				'click',
				function(e) {
					var editStateURL =Liferay.PortletURL.createRenderURL();
					//var stateId = 0;
					var id = e.target.getAttribute("data-primkey");
					
					
					editStateURL.setParameter('mvcPath', '/html/admin/editMasterType.jsp');
					editStateURL.setParameter('masterTypeId', id);
					editStateURL.setPortletId('eisadmin_WAR_Eisportlet');
					editStateURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					
					
					Liferay.Util.openWindow(
						{
							dialog: {
								centered: true,
								modal:true,
								destroyOnHide: true,
								width: 450,
								
							},
							
							title: '<%= portletDisplay.getTitle() %>',
							uri: editStateURL.toString(),
							id: '<portlet:namespace/>dialog',
						}
					);
				}
			);
		</aui:script>





<aui:script use="liferay-util-window">
     Liferay.provide(window, 'editState', function(action) {
         page = '<%=addEditStateURL%>'
         Liferay.Util.openWindow({
             dialog: {
                 cache: false,
                 centered: true,
                 height: 400,
                modal: true,
                resizable: false,
                width: 500
            },
            id: '<portlet:namespace/>dialog',
            title: "Edit Master Type",
            uri: page
        });
    });
     
     Liferay.provide(window, 'closePopup', function(dialogId) {
         var A = AUI();
         var dialog = Liferay.Util.getWindow(dialogId);
        
         dialog.destroy();
     });
     
</aui:script>
<portlet:actionURL var="deleteMasterURL" name="deleteMasterType" /> 
<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
    Liferay.provide(
    		window,
    		'deleteMaster',
    		function(masterId) {
    			var A = AUI();
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-master-type')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterId : masterId,
    		                	<portlet:namespace/>masterType : 'library-type',
    		                	
    		                },
    		                on: {
    		                    success: function() {
    		                        refreshPortlet();
    		                        
    		                    }
    		                }
    		            }
    		        )
    			}
    			
    			
    			
    			
    			
    	
    		}
    		
    	);
</aui:script>



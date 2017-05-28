<%@ include file="/html/init.jsp" %>


<%
	List<Config> infoBoxes = ConfigLocalServiceUtil.findWithKeyWildcard(EisUtil.EIS_INFO_BOX,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	int totalBoxes = infoBoxes.size();


String rowIndexesParam = ParamUtil.getString(request, "rowIndexes");


%>
<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="navigation" value="infoBox" />
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       
       
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="addInfoBoxURL">
	<portlet:param name="id" value="0"/>
	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
	<portlet:param name="navigation" value="editInfoBox"/>
</liferay-portlet:renderURL>

<aui:a cssClass="btn btn-default btnEdit" href="<%=addInfoBoxURL.toString()  %>" label="add-info-box" />
<liferay-ui:search-container emptyResultsMessage="no-info-box-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= ConfigLocalServiceUtil.findWithKeyWildcard(EisUtil.EIS_INFO_BOX,searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= totalBoxes %>" />

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.Config"
				keyProperty="id"
				modelVar="infoBox"
				 
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL(); 
			viewItemURL.setParameter("jspPage","/html/project/viewProject.jsp");
			
			
			%>
			<liferay-ui:search-container-column-text property="title" name="id"/>
			
			
				
				
			
			
			
			<liferay-ui:search-container-column-text name="action">
				<%
				String deleteMasterURL = "javascript:deleteMaster(" + infoBox.getId() +")";
				%>
				<liferay-portlet:renderURL varImpl="editInfoBoxURL">
					<portlet:param name="id" value="<%= String.valueOf(infoBox.getId()) %>"/>
					<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
					<portlet:param name="navigation" value="editInfoBox"/>
				</liferay-portlet:renderURL>
				
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= infoBox.getId() %>" href="<%= editInfoBoxURL.toString() %>" label="pinda" />
				<aui:a cssClass="btn btn-default" href="<%= deleteMasterURL %>" label="padam" />
				
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	
<portlet:renderURL var="addEditStateURL">
	
</portlet:renderURL>

<aui:script position="inline" use="aui-base,liferay-portlet-url">
			var editStateButton = A.all('.btnEditx');
			
			editStateButton.on(
				'click',
				function(e) {
					var editStateURL = Liferay.PortletURL.createRenderURL();
					//var stateId = 0;
					var id = e.target.getAttribute("data-primkey");
					
					
					editStateURL.setParameter('mvcPath', '/html/admin/editInfoBox.jsp');
					editStateURL.setParameter('id', id);
					editStateURL.setPortletId('eisadmin_WAR_Eisportlet');
					editStateURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					
					
					Liferay.Util.openWindow(
						{
							dialog: {
								centered: true,
								modal:true,
								destroyOnHide: true,
								width: 850,
								
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
<portlet:actionURL var="deleteConfigURL" name="deleteConfig" /> 
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
    		function(configId) {
    			var A = AUI();
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-info-box')))
    			{
    				
    				var url = '<%= deleteConfigURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>configId : configId
    		                	
    		                	
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
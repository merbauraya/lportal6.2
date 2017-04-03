<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="state"/>
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(locale, "state") %></h4>

<aui:a cssClass="btn btn-default btnEditState" href="javascript:;" label="add-state" />




<liferay-ui:search-container emptyResultsMessage="no-state-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		
		results="<%= StateLocalServiceUtil.getStates(searchContainer.getStart(), searchContainer.getEnd()) %>" 
		total = "<%= StateLocalServiceUtil.getStatesCount() %>"
		
		
	
	/>

		<liferay-ui:search-container-row
				className="com.idetronic.eis.model.State"
				keyProperty="stateId"
				modelVar="state"
				 
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL(); 
			viewItemURL.setParameter("jspPage","/html/project/viewProject.jsp");
			
			
			%>
			
			
			<liferay-ui:search-container-column-text name="state-name">
				<span class="hidden" id="stateId"><%= state.getStateId()%></span>
				<%= state.getStateName() %>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="stateCode">
				
				
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="action">
			<%
				String deleteMasterURL = "javascript:deleteMaster(" +state.getStateId() +")";
			%>
				<aui:a cssClass="btn btn-default btnEditState" data-stateId="<%= state.getStateId() %>" href="javascript:;" label="pinda" />
				
				<aui:a cssClass="btn btn-default" data-stateId="<%= state.getStateId() %>" href="<%= deleteMasterURL %>" label="padam" />
				
				
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	

<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
			<aui:button name="closeDialog" type="cancel"/>
		</aui:button-row>

<portlet:renderURL var="addEditStateURL">
	
</portlet:renderURL>

<aui:script position="inline" use="aui-base,liferay-portlet-url">
	var editStateButton = A.all('.btnEditState');
	
	editStateButton.on(
		'click',
		function(e) {
			var editStateURL =Liferay.PortletURL.createRenderURL();
			//var stateId = 0;
			var stateId = e.target.getAttribute("data-stateId");
			
			
			editStateURL.setParameter('mvcPath', '/html/admin/editState.jsp');
			editStateURL.setParameter('stateId', stateId);
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
            title: "Edit State",
            uri: page
        });
    });
     
     Liferay.provide(window, 'closePopup', function(dialogId) {
         var A = AUI();
         var dialog = Liferay.Util.getWindow(dialogId);
         console.log(dialogId);
         console.log(dialog);
         dialog.destroy();
     });
     
</aui:script>

<portlet:actionURL var="deleteMasterURL" name="deleteMaster" /> 

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
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-state')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterId : masterId,
    		                	<portlet:namespace/>masterType : 'state',
    		                	
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



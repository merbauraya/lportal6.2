<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/admin.jsp" />
       <portlet:param name="navigation" value="visitorCategory"/>
</liferay-portlet:renderURL>


<h4>Visitor Category</h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add" />




<liferay-ui:search-container emptyResultsMessage="no-visitor-category-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= VisitorCategoryLocalServiceUtil.getVisitorCategories(searchContainer.getStart(), searchContainer.getEnd()) %>"
 		total="<%= VisitorCategoryLocalServiceUtil.getVisitorCategoriesCount() %>" />

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.VisitorCategory"
				keyProperty="visitorCategoryId"
				modelVar="visitorCategory"
				 
		>
			
			
			
			<liferay-ui:search-container-column-text property="visitorCategoryName" />
				
				
			
			
			
			<liferay-ui:search-container-column-text name="action">
				<%
				String deleteMasterURL = "javascript:deleteMaster(" + visitorCategory.getVisitorCategoryId() +")";
				%>
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= visitorCategory.getVisitorCategoryId()%>" href="javascript:;" label="pinda" />
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
					
					
					editStateURL.setParameter('mvcPath', '/html/admin/editVisitorCategory.jsp');
					editStateURL.setParameter('visitorCategoryId', id);
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
            title: "Edit LibraryType",
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
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-visitor-category')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterId : masterId,
    		                	<portlet:namespace/>masterType : 'visitor-category',
    		                	
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



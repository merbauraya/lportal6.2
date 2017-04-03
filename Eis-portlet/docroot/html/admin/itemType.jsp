<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="itemType"/>
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(pageContext, "item-type")%></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add" />




<liferay-ui:search-container emptyResultsMessage="no-faculty-type-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= ItemTypeLocalServiceUtil.getItemTypes(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ItemTypeLocalServiceUtil.getItemTypesCount() %>" />

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.ItemType"
				keyProperty="itemTypeId"
				modelVar="itemType"
				 
		>
			
			<liferay-ui:search-container-column-text property="itemTypeName" />
			
			<liferay-ui:search-container-column-text  name="printed-type">
				<c:if test="<%= itemType.getPrintedType() ==EisUtil.ITEM_TYPE_PRINTED %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text  name="non-printed-type">
				<c:if test="<%= itemType.getPrintedType() ==EisUtil.ITEM_TYPE_NON_PRINTED %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			
			<liferay-ui:search-container-column-text  name="is-ir-type">
				<c:if test="<%= itemType.isIRType() %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>	
			
			<liferay-ui:search-container-column-text  name="active">
				<c:if test="<%= itemType.isActive() %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>	
				
			
			
			
			<liferay-ui:search-container-column-text>
				<%
				String deleteMasterURL = "javascript:deleteMaster(" + itemType.getItemTypeId() +")";
				%>
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= itemType.getItemTypeId() %>" href="javascript:;" label="pinda" />
				<aui:a cssClass="btn btn-default" href="<%= deleteMasterURL %>" label="padam" />
				
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	


<%
	String title =  portletDisplay.getTitle() + " - " + LanguageUtil.get(pageContext, "item-type");
%>
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
					console.log(id);
					
					editStateURL.setParameter('mvcPath', '/html/admin/editItemType.jsp');
					editStateURL.setParameter('itemTypeId', id);
					editStateURL.setPortletId('eisadmin_WAR_Eisportlet');
					editStateURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					
					
					Liferay.Util.openWindow(
						{
							dialog: {
								centered: true,
								modal:true,
								destroyOnHide: true,
								width: 450,
								height:500,
								
								
							},
							
							title: '<%= title %>',
							uri: editStateURL.toString(),
							id: '<portlet:namespace/>dialog',
						}
					);
				}
			);
		</aui:script>





<aui:script use="liferay-util-window">
     
     
     Liferay.provide(window, 'closePopup', function(dialogId) {
         var A = AUI();
         var dialog = Liferay.Util.getWindow(dialogId);
     
         dialog.destroy();
     });
     
</aui:script>
<portlet:actionURL var="deleteMasterURL" name="deleteMaster" /> 

<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
    	 var A = AUI();
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
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-item-type')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterId : masterId,
    		                	<portlet:namespace/>masterType : 'item-type',
    		                	
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



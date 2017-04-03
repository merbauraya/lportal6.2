<%@ include file="/html/init.jsp"%> 
<%
	SearchContainer libraryListSearchContainer = (SearchContainer)request.getAttribute("libraryListSearchContainer");
 
%>
<liferay-ui:search-container searchContainer="<%=libraryListSearchContainer %>">
     <liferay-ui:search-container-results />
           <liferay-ui:search-container-row className="com.idetronic.eis.model.Library" modelVar="library">
           		<liferay-ui:search-container-column-text name="code" value="<%=library.getLibraryCode() %>"></liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Name" value="<%=library.getLibraryName() %>"></liferay-ui:search-container-column-text>
          		 <liferay-ui:search-container-column-text>
          		 <liferay-portlet:renderURL var="editAssociationURL">
          		 	<portlet:param name="libraryId" value="<%= String.valueOf(library.getLibraryId()) %>"/>
          		 	<portlet:param name="mvcPath" value="/html/admin/view.jsp"/>
          		 	<portlet:param name="navigation" value="editUserLibrary"/>
          		 </liferay-portlet:renderURL>
          		 
          		 
           		<aui:a cssClass="btn btn-default" href="<%=editAssociationURL  %>" data-primkey="<%=library.getLibraryId() %>"  label="edit-association" />
           		
           
           </liferay-ui:search-container-column-text>
           </liferay-ui:search-container-row>
          
     <liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>

<aui:script position="inline" use="aui-base,liferay-portlet-url">
			var editStateButton = A.all('.btnEdit');
			
			editStateButton.on(
				'click',
				function(e) {
					var editStateURL =Liferay.PortletURL.createRenderURL();
					//var stateId = 0;
					var id = e.target.getAttribute("data-primkey");
					
					
					editStateURL.setParameter('mvcPath', '/html/admin/editUserLibrary.jsp');
					editStateURL.setParameter('libraryId', id);
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
    
     
     Liferay.provide(window, 'closePopup', function(dialogId) {
         var A = AUI();
         var dialog = Liferay.Util.getWindow(dialogId);
         console.log(dialogId);
         console.log(dialog);
         dialog.destroy();
     });
     
</aui:script>
<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
</aui:script>
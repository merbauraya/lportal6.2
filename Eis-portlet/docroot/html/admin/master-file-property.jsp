<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="master-file-property" />
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(locale, "property-setting") %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add" />




<liferay-ui:search-container emptyResultsMessage="no-property-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	 
>
	<liferay-ui:search-container-results
		results="<%= ConfigLocalServiceUtil.findWithKeyWildcard(\"master\",searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ConfigLocalServiceUtil.countByKeyWildCard(\"master\") %>" />
 
	<liferay-ui:search-container-row 
				className="com.idetronic.eis.model.Config"
				keyProperty="id"
				modelVar="configuration"
				 
		>
			
			
			
			
			<liferay-ui:search-container-column-text name="key-name" property="key" />
			<liferay-ui:search-container-column-text name="key-value" property="value" />
			
			
			
			
			
			<liferay-ui:search-container-column-text name="action">
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= configuration.getId() %>" href="javascript:;" label="edit" />
				
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	





<aui:script position="inline" use="aui-base,liferay-portlet-url">
			var editButton = A.all('.btnEdit');
			
			editButton.on(
				'click',
				function(e) {
					var editURL =Liferay.PortletURL.createRenderURL();
					//var stateId = 0;
					var id = e.target.getAttribute("data-primkey");
					
					
					editURL.setParameter('mvcPath', '/html/admin/editProperty.jsp');
					editURL.setParameter('id', id);
					editURL.setPortletId('eisadmin_WAR_Eisportlet');
					editURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					
					
					Liferay.Util.openWindow(
						{
							dialog: {
								centered: true,
								modal:true,
								destroyOnHide: true,
								width: 450,
								
							},
							
							title: '<%= portletDisplay.getTitle() %>',
							uri: editURL.toString(),
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



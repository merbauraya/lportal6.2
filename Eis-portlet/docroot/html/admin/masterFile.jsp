<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.eis.model.impl.MasterFileImpl" %>
<%
	long masterTypeId = ParamUtil.getLong(request, "masterTypeId");
	MasterType masterType = MasterTypeLocalServiceUtil.fetchMasterType(masterTypeId);
	String nameLabel = masterType.getNameLabel();
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="navigation" value="masterFile" />
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="masterTypeId" value="<%= String.valueOf(masterTypeId) %>"/>
</liferay-portlet:renderURL>

 
<h4><%= masterType.getPageLabel() %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add" />




<liferay-ui:search-container emptyResultsMessage="no-master-type-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= MasterFileLocalServiceUtil.findByMasterType(masterTypeId,searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= MasterFileLocalServiceUtil.getCountByMasterType(masterTypeId) %>" />

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.MasterFile"
				keyProperty="masterFileId"
				modelVar="masterFile"
				 
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL(); 
			viewItemURL.setParameter("jspPage","/html/project/viewProject.jsp");
			
			
			%>
			<liferay-ui:search-container-column-text property="masterFileId" name="id" title="id"/>
			
			<liferay-ui:search-container-column-text property="masterFileName" name="<%= nameLabel %>"/>
			
			
			
			
			<c:if test="<%= masterType.getHasParent1() %>">
				<%
					MasterFile parent1 = MasterFileLocalServiceUtil.fetchMasterFile(masterFile.getParentId1());
					if (Validator.isNull(parent1))
					{
						parent1 = new MasterFileImpl();
					}
				%>
				<liferay-ui:search-container-column-text value="<%= parent1.getMasterFileName() %>" name="<%= masterType.getParent1Label() %>" title="id"/>
			
			
			</c:if>
			
			<c:if test="<%= masterType.getHasParent2() %>">
				<%
					MasterFile parent2 = MasterFileLocalServiceUtil.fetchMasterFile(masterFile.getParentId2());
					if (Validator.isNull(parent2))
					{
						parent2 = new MasterFileImpl();
					}
				%>
				<liferay-ui:search-container-column-text value="<%= parent2.getMasterFileName() %>" name="<%= masterType.getParent2Label() %>" title="id"/>
			
			
			</c:if>
			
			<c:if test="<%= masterType.getHasCode() %>">
				<liferay-ui:search-container-column-text property="masterCode" name="kod"/>
			
			</c:if>
				
				
			
			
			
			<liferay-ui:search-container-column-text name="action">
				<%
				String deleteMasterURL = "javascript:deleteMaster(" + masterFile.getMasterFileId() +")";
				%>
				<aui:a cssClass="btn btn-default btnEdit" data-type="<%= masterFile.getMasterTypeId() %>" data-primkey="<%= masterFile.getMasterFileId() %>" href="javascript:;" label="pinda" />
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
					
					
					editStateURL.setParameter('mvcPath', '/html/admin/editMasterFile.jsp');
					editStateURL.setParameter('masterFileId', id);
					editStateURL.setParameter('masterTypeId', <%= masterTypeId %>);
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
            title: "Edit Master File",
            uri: page
        });
    });
     
     Liferay.provide(window, 'closePopup', function(dialogId) {
         var A = AUI();
         var dialog = Liferay.Util.getWindow(dialogId);
        
         dialog.destroy();
     });
     
</aui:script>
<portlet:actionURL var="deleteMasterURL" name="deleteMasterFile" /> 
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
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-master-file')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterFileId : masterId,
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



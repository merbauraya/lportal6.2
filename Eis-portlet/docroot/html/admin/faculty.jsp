<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/faculty.jsp" />
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(locale, "ptj") %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add-ptj" />




<liferay-ui:search-container emptyResultsMessage="no-faculty-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= FacultyLocalServiceUtil.getFaculties(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= FacultyLocalServiceUtil.getFacultiesCount() %>" />

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.Faculty"
				keyProperty="facultyId"
				modelVar="faculty"
				 
		>
			
			
			
			
			<liferay-ui:search-container-column-text name="ptj-name" property="facultyName" />
			<% 
				FacultyType facultyType = FacultyTypeLocalServiceUtil.fetchFacultyType(faculty.getFacultyTypeId()); 
				
			%>
			
			<liferay-ui:search-container-column-text name="faculty-type" >
				<%= facultyType.getFacultyTypeName() %>
			</liferay-ui:search-container-column-text>
			
				
				
			
			
			
			<liferay-ui:search-container-column-text name="action">
			<%
				String deleteMasterURL = "javascript:deleteMaster(" + faculty.getFacultyId() +")";
				%>
			
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= faculty.getFacultyId() %>" href="javascript:;" label="pinda" />
				<aui:a cssClass="btn btn-default" href="<%= deleteMasterURL %>" label="padam" />
				
			
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
					
					
					editURL.setParameter('mvcPath', '/html/admin/editFaculty.jsp');
					editURL.setParameter('facultyId', id);
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
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-ptj')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterId : masterId,
    		                	<portlet:namespace/>masterType : 'ptj',
    		                	
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



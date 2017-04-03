<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="seatingDepartment"/>
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(locale, "seating-department") %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add" />




<liferay-ui:search-container emptyResultsMessage="no-seating-department-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	 
>
	<liferay-ui:search-container-results
		results="<%= SeatingDepartmentLocalServiceUtil.getSeatingDepartments(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= SeatingDepartmentLocalServiceUtil.getSeatingDepartmentsCount() %>" />
 
	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.SeatingDepartment"
				keyProperty="departmentId"
				modelVar="department"
				 
		>
			
			
			
			
			<liferay-ui:search-container-column-text name="department-name" property="departmentName" />
			
			
			
			
			
			
			<liferay-ui:search-container-column-text name="action">
			<%
				String deleteMasterURL = "javascript:deleteMaster(" + department.getDepartmentId() +")";
				%>
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= department.getDepartmentId() %>" href="javascript:;" label="pinda">
					<i class="icon-edit"></i>
				</aui:a>
				<aui:a cssClass="btn btn-default" href="<%= deleteMasterURL %>" label="padam" >
					<i class="icon-trash"></i>
				</aui:a>	
				
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	



<portlet:actionURL var="deleteDepartmentURL" name="deleteSeatingDepartment"></portlet:actionURL>

<aui:script position="inline" use="aui-base,liferay-portlet-url">
	var editButton = A.all('.btnEdit');
	
	editButton.on(
		'click',
		function(e) {
			var editURL =Liferay.PortletURL.createRenderURL();
			//var stateId = 0;
			var id = e.target.getAttribute("data-primkey");
			
			
			editURL.setParameter('mvcPath', '/html/admin/editSeatingDepartment.jsp');
			editURL.setParameter('departmentId', id);
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
	
var deleteButton = A.all('.btnDelete');
	
	deleteButton.on(
		'click',
		function(e) {
			var editURL =Liferay.PortletURL.createRenderURL();
			//var stateId = 0;
			var id = e.target.getAttribute("data-primkey");
			if (confirm(Liferay.Language.get('confirm-delete-department')))
			{
				
				var url = '<%= deleteDepartmentURL.toString()%>';
			    
		        A.io.request(
		        url,
		            {
		                method: 'POST',
		                data : {
		                	<portlet:namespace/>departmentId : id
		                	
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





<aui:script use="liferay-util-window">
     
     
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
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-seating-department')))
    			{
    				
    				var url = '<%= deleteMasterURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>masterId : masterId,
    		                	<portlet:namespace/>masterType : 'seating-department',
    		                	
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



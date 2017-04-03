<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="report"/>
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(locale, "report") %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:;" label="add" />




<liferay-ui:search-container emptyResultsMessage="no-report-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	 
>
	<liferay-ui:search-container-results 
		results="<%= ReportLocalServiceUtil.getReports(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ReportLocalServiceUtil.getReportsCount() %>" />
 
	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.Report"
				keyProperty="reportId"
				modelVar="report"
				 
		>
			
			
			
			
			<liferay-ui:search-container-column-text name="report-key" property="reportKey" />
			<liferay-ui:search-container-column-text name="report-display-title" property="reportTitle" />
			
			
			
			
			
			<liferay-ui:search-container-column-text name="action">
				<aui:a cssClass="btn btn-default btnEdit" data-primkey="<%= report.getReportId() %>" href="javascript:;" label="edit">
					<i class="icon-edit"></i>
				</aui:a>
				<aui:a cssClass="btn btn-default btnDelete" data-primkey="<%= report.getReportId() %>" href="javascript:;" label="delete">
					<i class="icon-trash"></i>
				</aui:a>	
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	

<portlet:actionURL var="deleteReportURL" name="deleteReport"></portlet:actionURL>



<aui:script position="inline" use="aui-base,liferay-portlet-url">
	var editButton = A.all('.btnEdit');
	
	editButton.on(
		'click',
		function(e) {
			var editURL =Liferay.PortletURL.createRenderURL();
			//var stateId = 0;
			var id = e.target.getAttribute("data-primkey");
			
			
			editURL.setParameter('mvcPath', '/html/admin/editReport.jsp');
			editURL.setParameter('reportId', id);
			editURL.setPortletId('eisadmin_WAR_Eisportlet');
			editURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
			
			
			Liferay.Util.openWindow(
				{
					dialog: {
						centered: true,
						modal:true,
						destroyOnHide: true,
						width: 450,
						height: 500,
						
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
			
			//var stateId = 0;
			var id = e.target.getAttribute("data-primkey");
			if (confirm(Liferay.Language.get('confirm-delete-category')))
			{
				
				var url = '<%= deleteReportURL.toString()%>';
			    
		        A.io.request(
		        url,
		            {
		                method: 'POST',
		                data : {
		                	<portlet:namespace/>categoryId : id
		                	
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
<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
</aui:script>



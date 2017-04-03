<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="kpiType" />
</liferay-portlet:renderURL>


<h4><%= LanguageUtil.get(locale, "kpi") %></h4>

<aui:a cssClass="btn btn-default btnEdit" href="javascript:editKPI(0)" label="add-kpi-type" />




<liferay-ui:search-container emptyResultsMessage="no-kpi-type-were-found"
	delta="10"
	iteratorURL="<%= iteratorURL %>"
	
>
	<liferay-ui:search-container-results
		results="<%= KpiTypeLocalServiceUtil.getKpiTypes(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= KpiTypeLocalServiceUtil.getKpiTypesCount() %>" />  

	<liferay-ui:search-container-row
				className="com.idetronic.eis.model.KpiType"
				keyProperty="kpiTypeId"
				modelVar="kpiType"
				 
		>
			
			
			<liferay-ui:search-container-column-text name="kpi-type" property="kpiName" />
			
			
			<liferay-ui:search-container-column-text name="key" property="kpiTypeKey" />
			
			<liferay-ui:search-container-column-text  name="period-month">
				<c:if test="<%= kpiType.getPeriodMonth() %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  name="period-quarter">
				<c:if test="<%= kpiType.getPeriodQuarter() %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  name="period-semi-annual">
				<c:if test="<%= kpiType.getPeriodSemiAnnual() %>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  name="period-year">
				<c:if test="<%= kpiType.getPeriodYear()%>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text  name="manual-value">
				<c:if test="<%= kpiType.getManualValue()%>">
					<span class="checked"></span>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			
			
			
			
			
				
				
			
			
			
			<liferay-ui:search-container-column-text name="action">
			<%
				String deleteKpiURL = "javascript:deleteKPI(" +kpiType.getKpiTypeId() +")";
				String editKpiURL = "javascript:editKPI(" +kpiType.getKpiTypeId() +")";
			
			%>
				
				<liferay-ui:icon cssClass="editKPI" iconCssClass="icon-edit" message="edit-kpi"  url="<%= editKpiURL %>"/>
				
				<liferay-ui:icon cssClass="deleteKPI" iconCssClass="icon-trash" message="delete-kpi" url="<%= deleteKpiURL %>" />
				
			
			</liferay-ui:search-container-column-text>
			
		
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	











<aui:script use="liferay-util-window">
     
     
     Liferay.provide(window, 'closePopup', function(dialogId) {
         var A = AUI();
         var dialog = Liferay.Util.getWindow(dialogId);
       
         dialog.destroy();
     });
     
</aui:script>
<portlet:actionURL var="deleteKpiTypeURL" name="deleteKpiType" /> 

<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
    
    Liferay.provide(
    		window,
    		'deleteKPI',
    		function(kpiTypeId) {
    			var A = AUI();
    			
    			
    			if (confirm(Liferay.Language.get('confirm-delete-kpitype')))
    			{
    				
    				var url = '<%= deleteKpiTypeURL.toString()%>'; 
    			    
    		        A.io.request(
    		        url,
    		            {
    		                method: 'POST',
    		                data : {
    		                	<portlet:namespace/>kpiTypeId : kpiTypeId
    		                	
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
    Liferay.provide(
    		window,
    		'editKPI',
    		function(kpiTypeId) {
    			var editURL =Liferay.PortletURL.createRenderURL();
				//var stateId = 0;
				
				
				
				editURL.setParameter('mvcPath', '/html/admin/editKpiType.jsp');
				editURL.setParameter('kpiId', kpiTypeId);
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



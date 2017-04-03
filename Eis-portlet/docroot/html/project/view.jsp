<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>


<%
	
	List<Project> projects = ProjectLocalServiceUtil.getProjects(QueryUtil.ALL_POS, QueryUtil.ALL_POS);  
	
	
%>


	<portlet:renderURL var="addProjectURL">
				
		<portlet:param name="jspPage" value="/html/project/edit.jsp"/>
	</portlet:renderURL>
	<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		localizeTitle="<%= true %>"
		title="project"
	/>


<aui:button-row>
	
	<%
	String editProjectUrl="javascript:editProject(0)";

	%>
	<aui:a href="<%=editProjectUrl  %>" cssClass="btn">Add Project</aui:a>
	
</aui:button-row>




<div id="projectList">
	<table id="tableProject" class="tableProject table table-bordered table-striped">
		<thead class="table-columns">
			<tr>
				<th ></th>
				<th>Projek</th>
				<th>Status Projek</th>
				<th>Tarikh Mula</th>
				<th>Tarikh Tamat</th>
				
				<th>% Kemajuan</th>
				<th>Siap</th>
				<th>Pengurus Projek</th>
				<th>Bahagian</th>
				<th></th>
				
			</tr>
		</thead>
		<tbody class="table-data">
			<%for (Project project : projects) 
			{
			%>
			<tr>
				<td class="details-control">
					<span id="<%= project.getProjectId() %>"></span>
				</td>
				<td><%= project.getProjectName() %>
				<td><%= EisUtil.getProgressStatusText(project.getProgressStatus()) %></td>
				<td><%= EisUtil.dateDisplay(project.getStartDate()) %> </td>
				<td><%= EisUtil.dateDisplay(project.getEndDate()) %> </td>
				
				<td>
				
					<eis:status-display 
						status="<%=project.getProjectStatus() %>" 
						progress="<%= project.getProgress() %>"
						
					/>
					
				</td>
				<td><%= EisUtil.dateDisplay(project.getCompletionDate()) %></td>
				<td><%= project.getResourceName() %></td>
				<td><%= project.getResourceType() %></td>
				<td>
					 <liferay-ui:icon-menu icon="../aui/cog" message="" showArrow="<%= false %>">
				        <%
				        	String editProjectUrl="javascript:editProject(" + project.getProjectId() + ")";
				        	String addStrategyUrl = "javascript:editStrategy(" + project.getProjectId() + ",0)";
				        	String deleteProjectUrl = "javascript:deleteProject(" + project.getProjectId() +")";
				        %>
				        <liferay-ui:icon cssClass="projectEdit" iconCssClass="icon-edit" message="edit-project" url="<%= editProjectUrl %>" />
				        <liferay-ui:icon cssClass="deleteProject" iconCssClass="icon-trash" message="delete-project" url="<%= deleteProjectUrl %>" />
				        
				        <liferay-ui:icon iconCssClass="icon-plus" message="add-strategy" url="<%= addStrategyUrl %>" />
				        
				    </liferay-ui:icon-menu>
					
				</td>
			</tr>
			
				<% request.setAttribute("projectId", project.getProjectId()) ; %>
				<jsp:include page="strategyList.jsp">
					<jsp:param value="<%= project.getProjectId() %>" name="projectId"/>
				</jsp:include>
				
			<%
			}
			%>
		</tbody>
	
	</table>

</div>
<portlet:resourceURL var="strategyURL" id="<%= EisUtil.RESOURCE_STRATEGY_LIST_JSON %>"></portlet:resourceURL>

<aui:script use="aui-base,aui-node">
	var A = AUI();
	
	
	
	
	var strategy = A.all('.tableStrategy tr td.details-control');
	strategy.on('click',function(e){
		
		
		e.stopPropagation();
		e.preventDefault();
		
		var currentTarget = e.currentTarget;
		var currentTr = currentTarget.ancestor('tr');
		var tr = currentTarget.ancestor('tr').next('tr');
		
		if (tr)
		{
			if (tr.hasClass('hide'))
			{
				currentTr.addClass('shown');
				tr.removeClass('hide');
			} else
			{
				currentTr.removeClass('shown');
				tr.addClass('hide');
			}
		
		}
		
		
		
	});
	
	
	
	var project = A.all('.tableProject tr td.details-control');
	
	project.on('click',function(e)
	{
		e.stopPropagation();
		e.preventDefault();

		var currentTarget = e.currentTarget;
		
		var projectTr =  currentTarget.ancestor('tr');
		var strategyTr = currentTarget.ancestor('tr').next('tr');// currentTarget.nextSibling();
		//console.log(tr);
		
		
		var projectSpan = currentTarget.one('span');
		if (projectSpan)
		{
			var projectId = currentTarget.one('span').getAttribute('id');
		
			
			if (strategyTr.hasClass('hide'))
			{
				projectTr.addClass('shown');
				strategyTr.removeClass('hide');
			}else
			{
				projectTr.removeClass('shown');
				strategyTr.addClass('hide');
			}
		}
	
		
	});
	
	
	
	
	

</aui:script>
<aui:script>

Liferay.provide(
	window,
	'editProject',
	function(projectId) {
		var A = AUI(); 	
		var editURL =Liferay.PortletURL.createRenderURL();
		//var stateId = 0;
		//var id = e.target.getAttribute("data-primkey");
		
		console.log(projectId);
		
		editURL.setParameter('mvcPath', '/html/project/editProject.jsp');
		editURL.setParameter('projectId', projectId);
		editURL.setPortletId('Eis_WAR_Eisportlet');
		editURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
		
		
		Liferay.Util.openWindow(
			{
				dialog: {
					centered: true,
					modal:true,
					destroyOnHide: true,
					cssClass: 'popup-form',
					width: 650,
					height:650,
					
				},
				
				title: Liferay.Language.get('edit-project'),
				uri: editURL.toString(),
				id: '<portlet:namespace/>dialog',
			}
		);
	},
	['aui-dialog']
); 
</aui:script>

<portlet:actionURL var="deleteProjectURL" name="deleteProject" />
	

<portlet:actionURL var="deleteStrategyURL" name="deleteStrategy" />
	

<portlet:actionURL var="deleteActivityURL" name="deleteActivity" />
<aui:script>

Liferay.provide(
	window,
	'editStrategy',
	function(projectId,strategyId) {
		var A = AUI(); 	
		var editURL =Liferay.PortletURL.createRenderURL();
		//var stateId = 0;
		//var id = e.target.getAttribute("data-primkey");
		
		
		editURL.setParameter('mvcPath', '/html/project/editStrategy.jsp');
		editURL.setParameter('projectId', projectId);
		editURL.setParameter('strategyId', strategyId);
		editURL.setPortletId('Eis_WAR_Eisportlet');
		editURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
		
		
		
		
		
		Liferay.Util.openWindow(
			{
				dialog: {
					centered: true,
					modal:true,
					destroyOnHide: true,
					cssClass: 'popup-form',
					width: 450,
					height: 500
					
				},
				
				title: Liferay.Language.get('edit-strategy'),
				uri: editURL.toString(),
				id: '<portlet:namespace/>dialog',
			}
		);
	},
	['aui-dialog']
); 

Liferay.provide(
		window,
		'deleteProject',
		function(projectId) {
			var A = AUI();
			console.log(projectId);
			
			if (confirm(Liferay.Language.get('confirm-delete-project')))
			{
				
				var url = '<%= deleteProjectURL.toString()%>';
			    
		        A.io.request(
		        url,
		            {
		                method: 'POST',
		                data : {
		                	<portlet:namespace/>projectId : projectId
		                	
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
		'deleteStrategy',
		function(strategyId) {
			var A = AUI();
			
			
			if (confirm(Liferay.Language.get('confirm-delete-strategy')))
			{
				
				var url = '<%= deleteStrategyURL.toString()%>';
			    
		        A.io.request(
		        url,
		            {
		                method: 'POST',
		                data : {
		                	<portlet:namespace/>strategyId : strategyId
		                	
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
		'deleteActivity',
		function(activityId) {
			var A = AUI();
			
			
			if (confirm(Liferay.Language.get('confirm-delete-activity')))
			{
				
				var url = '<%= deleteActivityURL.toString()%>';
			    
		        A.io.request(
		        url,
		            {
		                method: 'POST',
		                data : {
		                	<portlet:namespace/>activityId : activityId
		                	
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
		'editActivity',
		function(strategyId,activityId) {
			var A = AUI(); 	
			var editURL =Liferay.PortletURL.createRenderURL();
			//var stateId = 0;
			//var id = e.target.getAttribute("data-primkey");
			
			
			editURL.setParameter('mvcPath', '/html/project/editActivity.jsp');
			editURL.setParameter('activityId', activityId);
			editURL.setParameter('strategyId', strategyId);
			editURL.setPortletId('Eis_WAR_Eisportlet');
			editURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
			
			
			
			
			
			Liferay.Util.openWindow(
				{
					dialog: {
						centered: true,
						modal:true,
						destroyOnHide: true,
						cssClass: 'popup-form',
						width: 500,
						height: 500
						
					},
					
					title: Liferay.Language.get('edit-activity'),
					uri: editURL.toString(),
					id: '<portlet:namespace/>dialog',
				}
			);
		},
		['aui-dialog']
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
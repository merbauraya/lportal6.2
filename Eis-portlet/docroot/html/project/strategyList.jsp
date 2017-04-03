<%@ include file="/html/init.jsp" %>

<%
	long projectId = (Long) request.getAttribute("projectId");
	//long xx = ParamUtil.getLong(request, "projectId");
	
	List<ProjectStrategy> strategies = ProjectStrategyLocalServiceUtil.getByProject(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
<c:choose> 
	<c:when test="<%= strategies.size() == 0 %>"> 
		<tr class="hide">
			<td colspan="9" class="dataTables_empty">
				<span class="badge">Tiada Strategi</span>
			</td>
		</tr>
	</c:when>
	<c:otherwise>
	
	
	
		<tr class="hide">
			<td class="expandCol"></td>
			<td colspan="9" style="padding:0px" class="childTbCont">
			<table style="width:100%;" class="tableStrategy dataTable childTable" id="tableStrategy">
				<thead>
					<tr>
						<th class="details-control"></th>
						<th>Strategi</th>
						<th>Status</th>
						<th>Tarikh Mula</th>
						<th>Tarikh Tamat</th>
						<th>% Kemajuan</th>
						<th>Siap</th>
						<th>Nota</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<%
				for (ProjectStrategy strategy : strategies) {
				%>
					<tr>
						<td class="details-control activity" strategyid="<%= strategy.getProjectStrategyId()%>"></td>
						<td><%= strategy.getStrategyName() %></td>
						<td> <%= EisUtil.getProgressStatusText(strategy.getProgressStatus()) %></td>
						<td><%= EisUtil.dateDisplay(strategy.getStartDate()) %></td>
						<td><%= EisUtil.dateDisplay(strategy.getEndDate()) %></td>
						<td>
							<eis:status-display 
								status="<%=strategy.getStatus() %>" 
								progress="<%= strategy.getProgress() %>"
						
							/>
						
						
						<td><%= EisUtil.dateDisplay(strategy.getCompletionDate()) %></td>
						<%
							String remark;
							boolean showTip = false;
							if (Validator.isNull(strategy.getRemark()))
							{
								remark = StringPool.BLANK;
							}else
							{
								if (strategy.getRemark().length()< 30)
								{
									remark = strategy.getRemark();
								}else
								{
									remark = strategy.getRemark().substring(0, 30) + "...";
									showTip = true;
								}
							}
						%>
						
						<td><%= remark  %>
							<c:if test="<%= showTip %>">
								<liferay-ui:icon-help message="<%= strategy.getRemark()%>"/>
							</c:if>
						</td>
						
						<td>
							<liferay-ui:icon-menu icon="../aui/cog" message="" showArrow="<%= false %>">
						         <%
						        	String editStrategyUrl="javascript:editStrategy(0," + strategy.getProjectStrategyId() + ")";
						        	String deleteStrategyUrl="javascript:deleteStrategy(" + strategy.getProjectStrategyId() + ")";
	
						         	String addActivityUrl = "javascript:editActivity(" + strategy.getProjectStrategyId() + ",0)";
						        	
						        %>
								        
						        <liferay-ui:icon iconCssClass="icon-edit" message="edit-strategy" url="<%=editStrategyUrl %>" />
						     	<liferay-ui:icon iconCssClass="icon-trash" message="delete-strategy" url="<%= deleteStrategyUrl %>" />
						        
						        
						        <liferay-ui:icon iconCssClass="icon-plus" message="add-activity" url="<%= addActivityUrl %>" />
						        
				   			 </liferay-ui:icon-menu>
						
						</td>
					</tr>
					
					<% request.setAttribute("strategyId", strategy.getProjectStrategyId()) ; %>
					<jsp:include page="activityList.jsp">
						<jsp:param value="0" name="projectId"/>
					</jsp:include>
				<%
				}
				%>
				</tbody>
			</table>
		</td></tr>

</c:otherwise>

</c:choose>




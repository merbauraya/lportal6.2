<%@ include file="/html/init.jsp" %>

<%
	long strategyId = (Long) request.getAttribute("strategyId");
	//long xx = ParamUtil.getLong(request, "projectId");
	
	List<ProjectActivity> activities = ProjectActivityLocalServiceUtil.getByStrategy(strategyId);
%>
<c:choose> 
	<c:when test="<%= activities.size() == 0 %>"> 
		<tr class="hide">
			<td colspan="9" class="dataTables_empty">
				<span class="badge"><%= LanguageUtil.get(locale,"no-activity") %></span>
			</td>
		</tr>
	</c:when>
	<c:otherwise>
	
	
	
		<tr class="hide"><td class="expandCol"></td><td colspan="9" style="padding:0px" class="childTbCont">
			<table style="width:100%;" class="tableActivity dataTable childTable" >
				<thead>
					<tr>
						
						<th>Aktiviti</th>
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
				for (ProjectActivity activity : activities) {
				%>
					<tr>
						
						<td><%= activity.getActivityName() %></td>
						<td> <%= EisUtil.getProgressStatusText(activity.getProgressStatus()) %></td>
						<td><%= EisUtil.dateDisplay(activity.getStartDate()) %></td>
						<td><%= EisUtil.dateDisplay(activity.getEndDate()) %></td>
						<td>
							<eis:status-display 
								status="<%=activity.getStatus()%>" 
								progress="<%= activity.getProgress() %>"
						
							/>
							
						</td>
						<td><%= EisUtil.dateDisplay(activity.getCompletionDate()) %></td>
						<%
							String remark;
							boolean showTip = false;
							if (Validator.isNull(activity.getRemark()))
							{
								remark = StringPool.BLANK;
							}else
							{
								if (activity.getRemark().length()< 30)
								{
									remark = activity.getRemark();
								}else
								{
									remark = activity.getRemark().substring(0, 29) + "...";
									showTip = true;
								}
							}
						%>
						
						<td>
							<%= remark %>
							<c:if test="<%= showTip %>">
								<liferay-ui:icon-help message="<%= activity.getRemark()%>"/>
							</c:if>
						</td>
						<td>
							<liferay-ui:icon-menu icon="../aui/cog" message="" showArrow="<%= false %>">
						         <%
						        	String addActivityUrl = "javascript:editActivity(" + strategyId + ",0)";

						         	String deleteActivityUrl="javascript:deleteActivity(" + activity.getProjectActivityId() + ")";
						        	String editActivityUrl = "javascript:editActivity(0," + activity.getProjectActivityId() +")";
						        %>
								<liferay-ui:icon iconCssClass="icon-plus" message="add-activity" url="<%=addActivityUrl %>" />
								        		
						        <liferay-ui:icon iconCssClass="icon-edit" message="edit-activity" url="<%=editActivityUrl %>" />
						        <liferay-ui:icon cssClass="danger " iconCssClass="icon-trash" message="delete-activity" url="<%= deleteActivityUrl %>" />
						        
				   			 </liferay-ui:icon-menu>
						
						</td>
					</tr>
					
					
				<%
				}
				%>
					<tr>
						<td colSpan="8"/>
					</tr>
				</tbody>
			</table>
		</td></tr>

</c:otherwise>

</c:choose>



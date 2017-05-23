<%
	int groupSize = groupTypes.size();
	
    int spanSize = 12/groupSize;
%>

<aui:row>
	<%
		for (int i = 0 ; i< groupTypes.size(); i++)
		{
			MasterFile group = groupTypes.get(i);
			
	%>
		<aui:col span="<%=spanSize %>">
			<h4><%= group.getMasterFileName() %></h4>
		
		<%
			
			List<MasterFile> categories = MasterFileLocalServiceUtil.findByParent1(categoryTypeId, group.getMasterFileId());
			
			for (MasterFile category : categories)
			{
				String valueTitle = category.getMasterFileId() +"-value";
				String sessionTitle = category.getMasterFileId() +"-sessionTotal";

		%>
			<aui:layout cssClass="item-data-cont">
				<aui:row cssClass="item-title-cont">
					<span class="item-title"><%= category.getMasterFileName() %></span>
				</aui:row>
				<aui:row>
					<aui:col span="6">
						<div class="col-separator multiColInput data-cont ">
							<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="consultation-total-user" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</div>
					</aui:col>
					<aui:col span="6">
						<div class="col-separator multiColInput data-cont ">
							<aui:input cssClass="dataInput" name="<%= sessionTitle %>" label="consultation-total-session" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</div>
					</aui:col>
				</aui:row>
			</aui:layout>
		<%		
			}
					
		%>
			</aui:col>
	<%
		}
	%>

</aui:row>
<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
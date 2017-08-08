<%
	//int rowSize = databaseUsages.size();

	int rowCount = databaseUsages.size();
	int rowSize = (int)Math.floor(rowCount/2);

	int extra = rowCount % 2;
	int cur = 0;

%>

<aui:row>
	<aui:layout>
		<aui:col span="6" cssClass="col-separator multiColInput ">
		<%

		
		
			for (cur = 0; cur < rowSize + extra; cur++)
			{
				MasterFile databaseType = databaseUsages.get(cur); 
				String title = databaseType.getMasterFileName();
				String downloadTotal = databaseType.getMasterFileId() + "-download";
				String sessionTotal = databaseType.getMasterFileId() + "-session";
				String searchTotal = databaseType.getMasterFileId() + "-search";
		%>	
			<aui:layout cssClass="item-data-cont">
				<aui:row cssClass="item-title-cont">
					<span class="item-title"><%= title %> </span> 
				</aui:row>
		
				
				<aui:row>
					<div class="data-cont">
						
						
						<aui:col span="4">
							<aui:input cssClass="dataInput" name="<%= sessionTotal %>" label="p-session" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
						<aui:col span="4">
							<aui:input cssClass="dataInput" name="<%= downloadTotal %>" label="p-download" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
						<aui:col span="4">
							<aui:input cssClass="dataInput" name="<%= searchTotal %>" label="p-search" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
					</div>
				</aui:row>
			</aui:layout>
		<%
	
			}
		%>
		</aui:col>
		<c:if test="<%= cur < rowCount %>">
				
			<aui:col span="6" cssClass="col-separator multiColInput">
				<%
					for (int i = 0; i < rowSize; cur++)
					{
						MasterFile databaseType = databaseUsages.get(cur); 
						String title = databaseType.getMasterFileName();
						String downloadTotal = databaseType.getMasterFileId() + "-download";
						String sessionTotal = databaseType.getMasterFileId() + "-session";
						String searchTotal = databaseType.getMasterFileId() + "-search";
						i++;
				%>
					<aui:layout cssClass="item-data-cont ">
						<aui:row cssClass="item-title-cont">
							<span class="item-title"><%= title %></span>
						</aui:row>
						<aui:row>
							<div class="data-cont">
								
								
								<aui:col span="4">
									<aui:input cssClass="dataInput" name="<%= sessionTotal %>" label="p-session">
										<aui:validator name="digits"></aui:validator>
									</aui:input>
								</aui:col>
								<aui:col span="4">
									<aui:input cssClass="dataInput" name="<%= downloadTotal %>" label="p-download" >
										<aui:validator name="digits"></aui:validator>
									</aui:input>
								</aui:col>
								<aui:col span="4">
									<aui:input cssClass="dataInput" name="<%= searchTotal %>" label="p-search">
										<aui:validator name="digits"></aui:validator>
									</aui:input>
								</aui:col>
							</div>
						</aui:row>
					</aui:layout>
				
				<%
				}
				%>
			</aui:col>
		
		</c:if>
	</aui:layout> 
</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
<%
int rowCount = digitalCollections.size();
int rowSize = (int)Math.floor(rowCount/2);

int extra = rowCount % 2;
int cur = 0;

%>

<aui:row>	
		<aui:layout>
			<aui:col span="6" cssClass="col-separator multiColInput data-cont ">
	<%
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			MasterFile masterFile = digitalCollections.get(cur);
		
			String titleTotal = masterFile.getMasterFileId() +"-title";
			String volumeTotal = masterFile.getMasterFileId() +"-volume";
			String imageTotal = masterFile.getMasterFileId() +"-image";
			String title = masterFile.getMasterFileName();
	%> 
		
		
		<aui:layout cssClass="item-data-cont ">
			<aui:row cssClass="item-title-cont">
				<span class="item-title"><%= title %></span>
			</aui:row>
			<%
						
			%>
				
			<aui:row>
				<div class="data-cont">
					
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= titleTotal %>" label="p-title" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= volumeTotal %>" label="p-volume" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= imageTotal %>" label="p-image" >
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
			<aui:col span="6" cssClass="col-separator multiColInput ">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							MasterFile masterFile = digitalCollections.get(cur);
							String titleTotal = masterFile.getMasterFileId() +"-title";
							String volumeTotal = masterFile.getMasterFileId() +"-volume";
							String imageTotal = masterFile.getMasterFileId() +"-image";
							String title = masterFile.getMasterFileName();

							
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= title %></span>
							</aui:row>
							<aui:row>
								<div class="data-cont">
					
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= titleTotal %>" label="p-title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= volumeTotal %>" label="p-volume" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= imageTotal %>" label="p-image" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
								</div>
							</aui:row>
						</aui:layout>
					
					<%
						
							i++;
						}
					
					%>
				</aui:col>
			
			</c:if>
			
		</aui:layout>
	</aui:row>
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
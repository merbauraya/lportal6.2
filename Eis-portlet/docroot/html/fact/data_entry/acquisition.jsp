<%
int rowCount = acquisitionItems.size();
int rowSize = (int)Math.floor(rowCount/2);

int extra = rowCount % 2;
int cur = 0;

%>

<aui:row>	
		<aui:layout>
			<aui:col span="6" cssClass="col-separator multiColInput">
	<%
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			MasterFile item = acquisitionItems.get(cur);
			
			String approvedTitleTotal = item.getMasterFileId() + "-approvedTitleTotal";
			String approvedVolumeTotal = item.getMasterFileId() +"-approvedVolumeTotal";
			String approvedAmountTotal = item.getMasterFileId() + "-approvedAmountTotal";
			
			String orderTitleTotal = item.getMasterFileId() + "-orderTitleTotal";
			String orderVolumeTotal = item.getMasterFileId() +"-orderVolumeTotal";
			String orderAmountTotal = item.getMasterFileId() + "-orderAmountTotal";
			
			
			
			String volumeName = item.getMasterFileId() + "-volume"; 
			String titleName = item.getMasterFileId() + "-title"; 
			String amountName = item.getMasterFileId() + "-amount"; 
			
	 
	%> 
		
		
		<aui:layout cssClass="item-data-cont ">
			<aui:row cssClass="item-title-cont">
				<h4 class="item-title text-center"><%= item.getMasterFileName() %></h4>
			</aui:row>
			<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="Kelulusan Cadangan">
				<aui:row>
					<aui:col span="4">
							<aui:input cssClass="dataInput" name="<%= approvedTitleTotal %>" label="p-title" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
						<aui:col span="4">
							<aui:input cssClass="dataInput" name="<%= approvedVolumeTotal %>" label="p-volume" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
						<aui:col span="4">
							<aui:input cssClass="dataInput" name="<%= approvedAmountTotal %>" label="p-amount" >
								<aui:validator name="number"></aui:validator>
							</aui:input>
						</aui:col>
					</aui:row>
			</liferay-ui:panel>
			<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" defaultState ="close" title="Pesanan Pembelian">
				<aui:row>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= orderTitleTotal %>" label="p-title" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= orderVolumeTotal %>" label="p-volume" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= orderAmountTotal %>" label="p-amount" >
							<aui:validator name="number"></aui:validator>
						</aui:input>
					</aui:col>
				</aui:row>
			</liferay-ui:panel>
			<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" defaultState="close" title="Penerimaan Pembelian">
				<aui:row>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= titleName %>" label="p-title" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= volumeName %>" label="p-volume" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col span="4">
						<aui:input cssClass="dataInput" name="<%= amountName %>" label="p-amount" >
							<aui:validator name="number"></aui:validator>
						</aui:input>
					</aui:col>
				</aui:row>
			</liferay-ui:panel>
			
			
			
		</aui:layout>
	<%
		}
	%>
			
	
			</aui:col>
			<c:if test="<%= cur < rowCount %>">
				
				<aui:col span="6" cssClass="col-separator multiColInput">
					<%
					
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							MasterFile item = acquisitionItems.get(cur);
							String volumeName = item.getMasterFileId() + "-volume"; 
							String titleName = item.getMasterFileId() + "-title"; 
							String amountName = item.getMasterFileId() + "-amount"; 
							
							String approvedTitleTotal = item.getMasterFileId() + "-approvedTitleTotal";
							String approvedVolumeTotal = item.getMasterFileId() +"-approvedVolumeTotal";
							String approvedAmountTotal = item.getMasterFileId() + "-approvedAmountTotal";
							
							String orderTitleTotal = item.getMasterFileId() + "-orderTitleTotal";
							String orderVolumeTotal = item.getMasterFileId() +"-orderVolumeTotal";
							String orderAmountTotal = item.getMasterFileId() + "-orderAmountTotal";


							i++;
					%>
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont">
								<h4 class="item-title text-center"><%= item.getMasterFileName() %></h4>
							</aui:row>
							<aui:row>
								<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="Kelulusan Cadangan">
								<aui:row>
									<aui:col span="4">
											<aui:input cssClass="dataInput" name="<%= approvedTitleTotal %>" label="p-title" >
												<aui:validator name="digits"></aui:validator>
											</aui:input>
										</aui:col>
										<aui:col span="4">
											<aui:input cssClass="dataInput" name="<%= approvedVolumeTotal %>" label="p-volume" >
												<aui:validator name="digits"></aui:validator>
											</aui:input>
										</aui:col>
										<aui:col span="4">
											<aui:input cssClass="dataInput" name="<%= approvedAmountTotal %>" label="p-amount" >
												<aui:validator name="number"></aui:validator>
											</aui:input>
										</aui:col>
									</aui:row>
							</liferay-ui:panel>
							<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" defaultState ="close" title="Pesanan Pembelian">
								<aui:row>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= orderTitleTotal %>" label="p-title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= orderVolumeTotal %>" label="p-volume" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= orderAmountTotal %>" label="p-amount" >
											<aui:validator name="number"></aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>
							</liferay-ui:panel>
							<liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" defaultState="close" title="Penerimaan Pembelian">
								<aui:row>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= titleName %>" label="p-title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= volumeName %>" label="p-volume" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col span="4">
										<aui:input cssClass="dataInput" name="<%= amountName %>" label="p-amount" >
											<aui:validator name="number"></aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>
							</liferay-ui:panel>
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
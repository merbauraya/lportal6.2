<aui:row>	
		<aui:layout>
			<aui:col width="33" cssClass="col-separator multiColInput">
	<%
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			ItemType item = items.get(cur);
			String volumeName = item.getItemTypeId() + "-volume"; 
			String titleName = item.getItemTypeId() + "-title"; 
			
			
	 
	%> 
		
		
		<aui:layout cssClass="item-data-cont">
			<aui:row cssClass="item-title-cont">
				<span class="item-title"><%= item.getItemTypeName() %></span>
			</aui:row>
			<aui:row>
				<div class="data-cont">
					<aui:col width="50">
						<aui:input cssClass="dataInput" name="<%= titleName %>" label="p-title" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input cssClass="dataInput" name="<%= volumeName %>" label="p-volume" >
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
			<c:if test="<%= cur < rowCount-1 %>">
				<aui:col width="33" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							ItemType item = items.get(cur);
							String volumeName = item.getItemTypeId() + "-volume"; 
							String titleName = item.getItemTypeId() + "-title"; 

							i++;
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= item.getItemTypeName() %></span>
							</aui:row>
							<aui:row>
								<div class="data-cont">
									<aui:col width="50">
										<aui:input cssClass="dataInput" name="<%= titleName %>" label="p-title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input cssClass="dataInput" name="<%= volumeName %>" label="p-volume">
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
			<c:if test="<%= cur < rowCount %>">
			<aui:col width="33" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							ItemType item = items.get(cur);
							String volumeName = item.getItemTypeId() + "-volume"; 
							String titleName = item.getItemTypeId() + "-title"; 

							i++;
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= item.getItemTypeName() %></span>
							</aui:row>
						
							<aui:row>
								<div class="data-cont">
									<aui:col width="50">
										<aui:input cssClass="dataInput" name="<%= titleName %>" label="p-title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input cssClass="dataInput" name="<%= volumeName %>" label="p-volume">
											<aui:validator name="number"></aui:validator>
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
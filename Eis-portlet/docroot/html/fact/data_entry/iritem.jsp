<aui:row>
		<aui:layout>
			<aui:col span="4" cssClass="col-separator multiColInput ">
		<%

		
		
			for (cur = 0; cur < rowSize + extra; cur++)
			{
				ItemType itemType = irTypes.get(cur); 
				for (int i = 0; i < mediums.size(); i++)
				{
					ItemMedium medium = mediums.get(i);
					String volumeName = itemType.getItemTypeId()+"-" +medium.getItemMediumId() + "-volume"; 
					String titleName = itemType.getItemTypeId()+"-" +medium.getItemMediumId() + "-title"; 
					String title = itemType.getItemTypeName() + " / " + medium.getItemMediumName();
				
						%>
		<aui:layout cssClass="item-data-cont ">
			<aui:row cssClass="item-title-cont">
				<span class="item-title"><%= title %></span>
			</aui:row>
			<%
						
			%>
				
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
			}
		%>
			</aui:col>
			<c:if test="<%= cur < rowCount-1 %>">
				
				<aui:col span="4" cssClass="col-separator multiColInput">
					<%
						for (int i = 0; i < rowSize; cur++)
						{
							ItemType itemType = irTypes.get(cur);
							for (ItemMedium medium : mediums)
							{
								 
								String volumeName = itemType.getItemTypeId()+"-" +medium.getItemMediumId() + "-volume"; 
								String titleName = itemType.getItemTypeId()+"-" +medium.getItemMediumId() + "-title"; 
								String title = itemType.getItemTypeName() + " / " + medium.getItemMediumName();
								
							
					%>
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont">
								<span class="item-title"><%= title %></span>
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
							i++;
						}
					%>
				</aui:col>
			
			</c:if>
			<c:if test="<%= cur < rowCount %>">
			<aui:col span="4" cssClass="col-separator multiColInput ">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							ItemType itemType = irTypes.get(cur);
							for (ItemMedium medium : mediums)
								{
									String volumeName = itemType.getItemTypeId()+"-" +medium.getItemMediumId() + "-volume"; 
									String titleName = itemType.getItemTypeId()+"-" +medium.getItemMediumId() + "-title"; 
									String title = itemType.getItemTypeName() + " / " + medium.getItemMediumName();


							
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= title %></span>
							</aui:row>
							<aui:row>
								<div class="data-cont">
									
									<aui:col width="50">
										<aui:input cssClass="dataInput " name="<%= titleName %>" label="p-title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input cssClass="dataInput " name="<%= volumeName %>" label="p-volume">
											<aui:validator name="number"></aui:validator>
										</aui:input>
									</aui:col>
								</div>
							</aui:row>
						</aui:layout>
					
					<%
						
							}
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
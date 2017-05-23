<%

	for (SeatingDepartment department : departments)
	{
		String title =  department.getDepartmentName() ;//itemType.getItemTypeName() + " / " + medium.getItemMediumName();

%>
			<aui:row>
				<aui:layout>	
				
					
					<aui:col span="4" cssClass="col-separator multiColInput">
						<span class="item-title"><%= title %></span>	
			
			
		<%		
				for (cur = 0; cur < rowSize + extra; cur++)
				{
					SeatingCategory category = categories.get(cur);
					String inputName = department.getDepartmentId() +"-"+ category.getSeatingCategoryId();
					String label = category.getSeatingCategoryName();
		%>
			
			<aui:row>
				<aui:col>
					<aui:input cssClass="dataInput" name="<%= inputName %>" label="<%= label %>" >
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</aui:col>
			
			</aui:row>
		<%			
					
				}
		%>
				</aui:col>
			
			
			
				<c:if test="<%= cur < rowCount-1 %>">
					<aui:col span="4" cssClass="col-separator multiColInput">
						<span class="item-title"><%= title %></span>
				<%
					for (int i = 0; i < rowSize; cur++)
					{
						i++; 
						SeatingCategory category = categories.get(cur);
						String inputName = department.getDepartmentId() +"-"+ category.getSeatingCategoryId();
						String label = category.getSeatingCategoryName();
				%>
					<aui:row>
							<aui:col>
								<aui:input cssClass="dataInput" name="<%= inputName %>" label="<%= label %>" >
									<aui:validator name="digits"></aui:validator>
								</aui:input>
							</aui:col>
						
						</aui:row>	
				<%
					}
				%>
					</aui:col>
				</c:if>
				
				<c:if test="<%= cur < rowCount-1 %>">
					<aui:col span="4" cssClass="col-separator multiColInput">
						<span class="item-title"><%= title %></span>
				<%
					for (int i = 0; i < rowSize; cur++)
					{
						i++; 
						SeatingCategory category = categories.get(cur);
						String inputName = department.getDepartmentId() +"-"+ category.getSeatingCategoryId();
						String label = category.getSeatingCategoryName();
				%>
					<aui:row>
							<aui:col>
								<aui:input cssClass="dataInput" name="<%= inputName %>" label="<%= label %>" >
									<aui:validator name="digits"></aui:validator>
								</aui:input>
							</aui:col>
						
						</aui:row>	
				<%
					}
				%>
					</aui:col>
				</c:if>
				
			
			
			</aui:layout>
		</aui:row>
		
		
		<hr/>
		<%
			}
				
		%>
			
		
		
			
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
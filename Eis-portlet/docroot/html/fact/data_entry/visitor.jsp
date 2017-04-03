

<aui:row>	
		<aui:layout>
			<aui:col width="33" cssClass="col-separator multiColInput">
	<%
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			VisitorCategory category = categories.get(cur); 
		
			String valueTitle = category.getVisitorCategoryId() +"-value";
			String label = category.getVisitorCategoryName();
	 
	%> 
		
		
		<aui:layout cssClass="item-data-cont">
			
			<aui:row>
			<aui:col>
				<div class="data-cont">
					<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=label%>" >
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
			<c:if test="<%= cur < rowCount %>">
				<aui:col width="33" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							VisitorCategory category = categories.get(cur);
							String valueTitle = category.getVisitorCategoryId() +"-value";
							String label = category.getVisitorCategoryName();

							i++;
					%>
						<aui:layout>
							<aui:col width="50">
								<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=label%>" >
									<aui:validator name="digits"></aui:validator>
								</aui:input>
							</aui:col>
							
							
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
							VisitorCategory category = categories.get(cur);
							String valueTitle = category.getVisitorCategoryId() +"-value";
							String label = category.getVisitorCategoryName();


							i++;
					%>
						<aui:layout>
							<aui:col width="50">
								<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%= label%>" >
									<aui:validator name="digits"></aui:validator>
								</aui:input>
							</aui:col>
							
						
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
	
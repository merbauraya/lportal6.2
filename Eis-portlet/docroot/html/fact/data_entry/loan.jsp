<aui:row>	
		<aui:layout>
			<aui:col width="33" cssClass="col-separator multiColInput data-cont ">
	<%
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			MasterFile category = categories.get(cur);
		
			String valueTitle = category.getMasterFileId() +"-value";
			
	 
	%> 
		
		
		<aui:layout cssClass="item-data-cont">
			
			<aui:row>
				
			<aui:col width="50">
				<div class="data-cont">
				<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=category.getMasterFileName()  %>" >
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
							MasterFile category = categories.get(cur); 
							String valueTitle = category.getMasterFileId() +"-value";

							i++;
					%>
						<aui:layout cssClass="item-data-cont ">
							<aui:col width="50">
								<div class="data-cont">
								<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=category.getMasterFileName()%>" >
									<aui:validator name="digits"></aui:validator>
								</aui:input>
								</div>
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
							MasterFile category = categories.get(cur);
							String valueTitle = category.getMasterFileId() +"-value";

							i++;
					%>
						<aui:layout cssClass="item-data-cont ">
							<aui:col width="50">
								<div class="data-cont">
								<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=category.getMasterFileName() %>" >
									<aui:validator name="digits"></aui:validator>
								</aui:input>
								</div>
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
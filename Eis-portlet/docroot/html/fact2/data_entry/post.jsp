<aui:row>	
		<aui:layout>
			<aui:col span="3" cssClass="col-separator multiColInput">
	<%
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			PostGrade postGrade = postGrades.get(cur);
		
			String valueTitle = postGrade.getPostGradeId() +"-value";
			String label = postGrade.getPostGradeName() +" ("+ postGrade.getPostGradeCode() + ")";
			
	 
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
			<c:if test="<%= cur < rowCount-1 %>">
				<aui:col span="3" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							PostGrade postGrade = postGrades.get(cur);
							String valueTitle = postGrade.getPostGradeId() +"-value";
							String label = postGrade.getPostGradeName() +" ("+ postGrade.getPostGradeCode() + ")";

							i++;
					%>
						<aui:layout cssClass="item-data-cont">
							<aui:col>
								<div class="data-cont">
									<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=label%>" >
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
			<aui:col span="3" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							PostGrade postGrade = postGrades.get(cur);
							String valueTitle = postGrade.getPostGradeId() +"-value";
							String label = postGrade.getPostGradeName() +" ("+ postGrade.getPostGradeCode() + ")";

							i++;
					%>
						<aui:layout cssClass="item-data-cont">
							<aui:col>
								<div class="data-cont">
									<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=label%>" >
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
			<aui:col span="3" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							PostGrade postGrade = postGrades.get(cur);
							String valueTitle = postGrade.getPostGradeId() +"-value";
							String label = postGrade.getPostGradeName() +" ("+ postGrade.getPostGradeCode() + ")";

							i++;
					%>
						<aui:layout cssClass="item-data-cont">
							<aui:col>
								<div class="data-cont">
									<aui:input cssClass="dataInput" name="<%= valueTitle %>" label="<%=label%>" >
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
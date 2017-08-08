<%
	String measure1Name = StringPool.BLANK;
	String measure2Name = StringPool.BLANK;
	String measure3Name = StringPool.BLANK;
	String measure4Name = StringPool.BLANK;
	int colWidth = 100;
	
	if (dataReport.getHasMeasure2())
	{
		if (dataReport.getHasMeasure3())
		{
			if (dataReport.getHasMeasure4())
			{
				colWidth = 25;
			}else
			{
				colWidth=33;
			}
		}else
		{
			colWidth=50;
		}
	}



%>


<aui:row>	
		<aui:layout>
			<aui:col width="33" cssClass="col-separator multiColInput">
	<%
		
		
		for (cur = 0; cur < rowSize + extra; cur++)
		{
			MasterFile item = items.get(cur);
			measure1Name = item.getMasterFileId() + "-measure1"; 
			measure2Name = item.getMasterFileId() + "-measure2"; 
			measure3Name = item.getMasterFileId() + "-measure3"; 
			measure4Name = item.getMasterFileId() + "-measure4"; 
			
	 
	%> 
		
		
		<aui:layout cssClass="item-data-cont">
			<aui:row cssClass="item-title-cont">
				<span class="item-title"><%= item.getMasterFileName() %></span>
			</aui:row>
			<aui:row>
				<div class="data-cont">
					<aui:col width="<%= colWidth %>">
						<aui:input cssClass="dataInput" name="<%= measure1Name %>" label="<%= dataReport.getMeasure1Name()%>" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<c:if test = "<%= dataReport.getHasMeasure2() %>">
					
						<aui:col width="<%= colWidth %>">
							<aui:input cssClass="dataInput" name="<%= measure2Name %>" label="<%= dataReport.getMeasure2Name() %>" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
					</c:if>
					<c:if test = "<%= dataReport.getHasMeasure3() %>">
					
						<aui:col width="<%= colWidth %>">
							<aui:input cssClass="dataInput" name="<%= measure3Name %>" label="<%= dataReport.getMeasure3Name() %>" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
					</c:if>
					
					<c:if test = "<%= dataReport.getHasMeasure4() %>">
					
						<aui:col width="<%= colWidth %>">
							<aui:input cssClass="dataInput" name="<%= measure4Name %>" label="<%= dataReport.getMeasure4Name() %>" >
								<aui:validator name="digits"></aui:validator>
							</aui:input>
						</aui:col>
					</c:if>
					
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
							MasterFile item = items.get(cur);
							measure1Name = item.getMasterFileId() + "-measure1"; 
							measure2Name = item.getMasterFileId() + "-measure2"; 
							measure3Name = item.getMasterFileId() + "-measure3"; 
							measure4Name = item.getMasterFileId() + "-measure4"; 
							

							i++;
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= item.getMasterFileName() %></span>
							</aui:row>
							<aui:row>
								<div class="data-cont">
									<aui:col width="<%= colWidth %>">
										<aui:input cssClass="dataInput" name="<%= measure1Name %>" label="<%= dataReport.getMeasure1Name()%>" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<c:if test = "<%= dataReport.getHasMeasure2() %>">
									
										<aui:col width="<%= colWidth %>">
											<aui:input cssClass="dataInput" name="<%= measure2Name %>" label="<%= dataReport.getMeasure2Name() %>" >
												<aui:validator name="digits"></aui:validator>
											</aui:input>
										</aui:col>
									</c:if>
									<c:if test = "<%= dataReport.getHasMeasure3() %>">
									
										<aui:col width="<%= colWidth %>">
											<aui:input cssClass="dataInput" name="<%= measure3Name %>" label="<%= dataReport.getMeasure3Name() %>" >
												<aui:validator name="digits"></aui:validator>
											</aui:input>
										</aui:col>
									</c:if>
									
									<c:if test = "<%= dataReport.getHasMeasure4() %>">
									
										<aui:col width="<%= colWidth %>">
											<aui:input cssClass="dataInput" name="<%= measure4Name %>" label="<%= dataReport.getMeasure4Name() %>" >
												<aui:validator name="digits"></aui:validator>
											</aui:input>
										</aui:col>
									</c:if>
									
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
							MasterFile item = items.get(cur);
							measure1Name = item.getMasterFileId() + "-measure1"; 
							measure2Name = item.getMasterFileId() + "-measure2"; 
							measure3Name = item.getMasterFileId() + "-measure3"; 
							measure4Name = item.getMasterFileId() + "-measure4"; 
							

							i++;
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= item.getMasterFileName() %></span>
							</aui:row>
						
							<aui:row>
								<div class="data-cont">
									<div class="data-cont">
										<aui:col width="<%= colWidth %>">
											<aui:input cssClass="dataInput" name="<%= measure1Name %>" label="<%= dataReport.getMeasure1Name()%>" >												<aui:validator name="digits"></aui:validator>
											</aui:input>
										</aui:col>
										<c:if test = "<%= dataReport.getHasMeasure2() %>">
										
											<aui:col width="<%= colWidth %>">
												<aui:input cssClass="dataInput" name="<%= measure2Name %>" label="<%= dataReport.getMeasure2Name() %>" >
													<aui:validator name="digits"></aui:validator>
												</aui:input>
											</aui:col>
										</c:if>
										<c:if test = "<%= dataReport.getHasMeasure3() %>">
										
											<aui:col width="<%= colWidth %>">
												<aui:input cssClass="dataInput" name="<%= measure3Name %>" label="<%= dataReport.getMeasure3Name() %>" >
													<aui:validator name="digits"></aui:validator>
												</aui:input>
											</aui:col>
										</c:if>
										
										<c:if test = "<%= dataReport.getHasMeasure4() %>">
										
											<aui:col width="<%= colWidth %>">
												<aui:input cssClass="dataInput" name="<%= measure4Name %>" label="<%= dataReport.getMeasure4Name() %>" >
													<aui:validator name="digits"></aui:validator>
												</aui:input>
											</aui:col>
										</c:if>
										
									</div>
									
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
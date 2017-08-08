

<portlet:renderURL var="visitorURL">
				<portlet:param name="mvcPath" value="/html/fact/visitor.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
</portlet:renderURL>
<portlet:renderURL var="seatingURL">
				<portlet:param name="mvcPath" value="/html/fact/seating.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
</portlet:renderURL>
<portlet:renderURL var="loanURL">
					<portlet:param name="mvcPath" value="/html/fact/loan.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
</portlet:renderURL>
				
	<portlet:renderURL var="membershipURL">
				<portlet:param name="mvcPath" value="/html/fact/member.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				
<portlet:renderURL var="printedMaterialURL">
					<portlet:param name="mvcPath" value="/html/fact/printedMaterial.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				
				<portlet:renderURL var="nonPrintedMaterialURL">
					<portlet:param name="mvcPath" value="/html/fact/nonPrintedMaterial.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				<%
					Report report = ReportLocalServiceUtil.findByKey(EisUtil.REPORT_IT_MANAGEMENT);
				%>
				
				<portlet:renderURL var="itManagementURLx">
					<portlet:param name="mvcPath" value="/html/fact/data.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="reportId" value="<%= String.valueOf(report.getReportId()) %>" /> 
				</portlet:renderURL>
				
				<portlet:renderURL var="itManagementURL">
					<portlet:param name="mvcPath" value="/html/fact/itManagement.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				
				<%
					report = ReportLocalServiceUtil.findByKey(EisUtil.REPORT_INTERLIB_LOAN);
				%>
				
				<portlet:renderURL var="interLibLoanURL">
					<portlet:param name="mvcPath" value="/html/fact/data.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="reportId" value="<%= String.valueOf(report.getReportId()) %>" /> 
					 
				</portlet:renderURL>

				<portlet:renderURL var="IrItemURL">
					<portlet:param name="mvcPath" value="/html/fact/irItem.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				<portlet:renderURL var="digitalCollectionURL">
					<portlet:param name="mvcPath" value="/html/fact/digitalCollection.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				
			<portlet:renderURL var="postURL">
					<portlet:param name="mvcPath" value="/html/fact/post.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
			<portlet:renderURL var="expenseURL">
				<portlet:param name="mvcPath" value="/html/fact/expense.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
			</portlet:renderURL>
			
			<portlet:renderURL var="consultationURL">
				<portlet:param name="mvcPath" value="/html/fact/consultation.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
			</portlet:renderURL>
			
			<portlet:renderURL var="acquisitionURL">
				<portlet:param name="mvcPath" value="/html/fact/acquisition.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
			</portlet:renderURL>
			<portlet:renderURL var="incomeURL">
				<portlet:param name="mvcPath" value="/html/fact/income.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
			</portlet:renderURL>	
			<portlet:renderURL var="databaseUsageURL">
				<portlet:param name="mvcPath" value="/html/fact/databaseUsage.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
			</portlet:renderURL>
			<%
				report = ReportLocalServiceUtil.findByKey(EisUtil.REPORT_GIFT_RECEIVED);
			%>
					
			<portlet:renderURL var="giftReceivedURL">
				<portlet:param name="mvcPath" value="/html/fact/data.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="reportId" value="<%= String.valueOf(report.getReportId()) %>" />	 
			</portlet:renderURL>	
																

<aui:nav-bar>
	
		<aui:nav>
			
				<portlet:renderURL var="projectURL">
					<portlet:param name="mvcPath" value="/html/project/view.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				
				<aui:nav-item dropdown="true" label="Perkhidmatan">
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= visitorURL %>" label="visitor" 
					name="addItemButton" /> 
					
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= seatingURL %>" label="seating" 
					name="addItemButton" /> 
					
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= loanURL %>" label="loan" 
					name="addItemButton" />
					
					
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= membershipURL %>" label="membership" 
					name="addItemButton" /> 
					
					<aui:nav-item iconCssClass="icon-edit"
						href="<%= consultationURL %>" label="consultation" />
					
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= printedMaterialURL %>" label="printed-material" 
					name="addItemButton" />		
					
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= nonPrintedMaterialURL %>" label="non-printed-material" 
					name="addItemButton" />	
					
					<aui:nav-item iconCssClass="icon-edit"  
						href="<%= itManagementURLx %>" label="it-management" 
						name="addItemButton" />	
					
					<aui:nav-item iconCssClass="icon-edit"  
						href="<%= interLibLoanURL %>" label="interlib-loan" 
						name="addItemButton" />		
						
						
						
						
				</aui:nav-item>	
					
					
				
				<aui:nav-item dropdown="true" label="Pembangunan">
					
						
					
					<aui:nav-item iconCssClass="icon-edit"  
						href="<%= acquisitionURL %>" label="acquisition" 
						name="addItemButton" /> 
					<aui:nav-item iconCssClass="icon-edit"  
						href="<%= databaseUsageURL %>" label="database-usage" 
						name="addItemButton" /> 	
				<aui:nav-item iconCssClass="icon-edit"  
						href="<%= giftReceivedURL %>" label="gift-received" 
						name="addItemButton" />			
						
						
				</aui:nav-item>
				
				
				
				<aui:nav-item dropdown="true" label="irtype-item">
				
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= IrItemURL %>" label="intellect-property" 
					name="addItemButton" /> 
					
					<aui:nav-item iconCssClass="icon-edit"  
					href="<%= digitalCollectionURL %>" label="digital-collection" 
					name="addItemButton" /> 		
				
				
				
				</aui:nav-item>
				
				<aui:nav-item dropdown="true" label="Pengurusan">
					
					<aui:nav-item iconCssClass="icon-edit"  
						href="<%= postURL %>" label="job-post" 
						name="addItemButton" />			
					
					<aui:nav-item iconCssClass="icon-edit"  
						href="<%= expenseURL %>" label="expenses" 
						name="addItemButton" /> 	
						<aui:nav-item iconCssClass="icon-edit"  
						href="<%= incomeURL %>" label="income" 
						name="addItemButton" /> 	
					
				</aui:nav-item>
				
				<aui:nav-item dropdown="true" label="Perancangan Strategik">
				
					<aui:nav-item iconCssClass="icon-plus"  
					href="<%= projectURL %>" label="project" 
					name="addItemButton" />
					
				</aui:nav-item>
				
			
				
			
				
				
					
				
					
				
					 
				
				
					
					
				
					
				
				
				
					
					
				
					
			
					
					
				<portlet:renderURL var="testURL">
				<portlet:param name="mvcPath" value="/html/fact/test.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				<!-- 
				<aui:nav-item iconCssClass="icon-edit"  
					href="<%= testURL %>" label="test" 
					name="addItemButton" /> 
			
			--->
			
			
		</aui:nav>
		
	
	
		
	
	
   
	
</aui:nav-bar>


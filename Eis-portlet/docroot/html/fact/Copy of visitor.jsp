<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	List<Library> libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());
	List<VisitorCategory> categories = VisitorCategoryLocalServiceUtil.getVisitorCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	int rowCount = categories.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	int extra = rowCount % 3;
	int cur = 0;
	String headerTitle = LanguageUtil.get(pageContext, "visitor");

%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>

<portlet:renderURL var="dataLoanlURL">
	<portlet:param name="mvcPath" value="/html/fact/visitor.jsp"/>

</portlet:renderURL>


	
<portlet:actionURL name="editVisitor" var="editVisitorURL">  
	
</portlet:actionURL>






<aui:form name="fm" action="<%= editVisitorURL %>">
		<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:row>
	<aui:col span="6">
		<eis:library-selector
					adminAllowAll="<%= mLibraryAdminAllowAll %>"
				
				/>
	</aui:col>
	
	<aui:col span="3">
		
		<eis:period-selector 
					allowPreviousYear="<%=mPeriodAllowPreviousYear %>"
					useYearRange="<%= mPeriodUseYearRange %>" 
					numberPreviousYear="<%= mPeriodNumYearPrevious %>"
					numberFutureYear="<%= mPeriodNumYearForward %>"
					useMonthName="<%= mPeriodUseMonthName %>"
					startYear="<%= mPeriodStartYear %>"
					endYear="<%= mPeriodEndYear %>"
					
				/>
		
		
	</aui:col>
	<aui:col span="3">
		<label class="control-label">&nbsp;</label>
		<aui:button type="button" 
			name="loadList" 
			label="load" 
			icon="icon-refresh"
		/>
	
	</aui:col>
	
	
</aui:row>


<hr/>
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

</aui:form>

<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_VISITOR_DATA %>">

</portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node">
	var A = AUI();
	
	
	A.all('select').on('change',function(){
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	
	var librarySelect = A.one('#<portlet:namespace/>library');
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	
	
	btnLoad.on('click',function(){
		
		
		var libraryId = librarySelect.get('value');
		var period =  A.one('#<portlet:namespace/>period').get('value');
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val('');
			
		});
		
		A.io.request('<%=dataURL.toString()%>', { 
            method: 'get',
            dataType: 'json',
            data: {
		    	<portlet:namespace/>libraryId : libraryId,
		    	<portlet:namespace/>period : period,
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData');
                	A.Array.each(data, function(obj, idx){
                		 var valueInput = A.one('#<portlet:namespace/>'+ obj.id +'-value');
                		
                		 if (valueInput)
                		{
                			 valueInput.val(obj.value);
                		}
                		
                			 
                	 });
                	 
                 }
            }
         });
		
		
		return;
	
	});
	

	</aui:script>

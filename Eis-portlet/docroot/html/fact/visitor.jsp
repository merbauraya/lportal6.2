<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	//List<Library> libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());
   // List<Library> libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());
    long visitorCategoryTypeId = ConfigLocalServiceUtil.getKeyAsLong("master.visitor.category");
	List<MasterFile> categories =  MasterFileLocalServiceUtil.findByMasterType(visitorCategoryTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	int rowCount = categories.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	int extra = rowCount % 3;
	int cur = 0;
	String headerTitle = LanguageUtil.get(pageContext, "visitor");
	String tab = ParamUtil.getString(request, "tabs1", "data-entry");


%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>
<portlet:renderURL var="pageURL">
	<portlet:param name="mvcPath" value="/html/fact/visitor.jsp" />
	
</portlet:renderURL>

	
<portlet:actionURL name="editVisitor" var="editVisitorURL">  
	
</portlet:actionURL>






<aui:form name="fm" action="<%= editVisitorURL %>">
	<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:row>
	<aui:col span="6">
		<eis:library-selector2
					adminAllowAll="<%= mLibraryAdminAllowAll %>"
					cssClass="selectInput"
				
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
					allowFuturePeriod= "<%= false%>"
					dataCountDay = "<%= mDataCountDay %>"
					cssClass="selectInput"
					
				/>
		
		
	</aui:col>
	<aui:col span="3">
		<label class="control-label">&nbsp;</label>
		<!-- 
		<aui:button type="button" 
			name="loadList" 
			label="load" 
			icon="icon-refresh"
		/>
		-->
	</aui:col>
	
	
</aui:row>




<%
	String tabNames = "Data";
	if (isAdmin)
	{
		tabNames = tabNames + ",Sejarah";
	}

%>
<liferay-ui:tabs
   names="<%= tabNames %>"
   url="<%= pageURL %>"
   refresh = "<%= false %>"
>

	<liferay-ui:section>
		<%@include file="/html/fact/data_entry/visitor.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="visitorHistory">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>




	
	
</aui:form>


	



<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_VISITOR_DATA %>">

</portlet:resourceURL>
<portlet:resourceURL var="dataHistoryURL" id="<%= EisUtil.RESOURCE_VISITOR_DATA_HISTORY %>">

</portlet:resourceURL>

<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-datatable,datatype-number">
	var A = AUI();
	
	
	A.all('select').on('change',function(){
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	
	var librarySelect = A.one('#<portlet:namespace/>library');
	
	
	
	var selectInput = A.all(".selectInput");
	
	selectInput.on('change', function() {
		
		var libraryId = librarySelect.get('value');
		var period =  A.one('#<portlet:namespace/>period').get('value');
		
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val('');
			
		});
		//dataHistoryURL
			//latest Data Entry
			A.io.request('<%=dataURL.toString()%>', { 
	            method: 'get',
	            dataType: 'json',
	            data: {
			    	<portlet:namespace/>libraryId : libraryId,
			    	<portlet:namespace/>period : period,
			    },
	            
	            on: {
	                 success: function() {
	                	var data=this.get('responseData').data;
	                	 
	                	A.Array.each(data, function(obj, idx){
	                		 var valueInput = A.one('#<portlet:namespace/>'+ obj.id +'-value');
	                		
	                		 if (valueInput)
	                		{
	                			 valueInput.val(obj.value);
	                		}
	                		
	                			 
	                	 });
	                	
	                	<%
	                		if (isAdmin) {
	                	%>
	                	var history = this.get('responseData').history;
	                	A.one('#visitorHistory').html('');
	                	var columns = [
	                	               {key: 'Bil',className:'numeric'},
	                	               {key:'Pengguna'},
	                	               {key:'Tarikh'},
	                	               {key:'Kategori'},
	                	               {
	                	            	   key:'Nilai',
	                	            	   className:'numeric',
	 		            	        	  formatter: function(o){
	 		            	        		  
	 		            	        		  return A.Number.format(o.data.Nilai,
	 		            	        		  {
	 		            	        			  thousandsSeparator: "," 
	 		            	        		  })
	 		            	        		  
	 		            	        	  }
	                	               }
	                	               ];
	                	new A.DataTable(
	                		      {
	                		        columnset: columns,
	                		        recordset: history
	                		      }
	                		    ).render('#visitorHistory');
		            	A.one('#visitorHistory table').addClass('table-bordered table-hover table-striped');

	                	 
	                 
			    	<%
	                 }
			    	%>
	            }
	         }
			
			
			
			
			
			
		
		});
		


	});
	
AUI().ready('event', 'node','node-event-simulate', function(A){
		
		
		librarySelect.selectedIndex = 0;
		librarySelect.simulate('change');
	
		});
		
	

	</aui:script>

<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	
	List<SeatingDepartment> departments = SeatingDepartmentLocalServiceUtil.getSeatingDepartments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<SeatingCategory> categories = SeatingCategoryLocalServiceUtil.getSeatingCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	int rowCount = categories.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	int extra = rowCount % 3;
	int cur = 0;
	
	String headerTitle = LanguageUtil.get(pageContext, "seating");
	
%> 


<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>



<portlet:actionURL name="editSeating" var="librarySeatingURL">
	
</portlet:actionURL>



<aui:form name="fm" action="<%= librarySeatingURL %>">
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
					allowFuturePeriod= "<%= false%>"
					dataCountDay = "<%= mDataCountDay %>"
					
				/>
		</aui:col>
		<aui:col span="3">
		<label class="control-label">&nbsp;</label>
			<aui:button type="button" 
			name="loadList" 
			
			icon="icon-refresh"
		/>
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
   refresh = "<%= false %>"
>

	<liferay-ui:section>
		<%@include file="/html/fact/data_entry/seating.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>

	
			


</aui:form>


<portlet:resourceURL var="loadItemURL" id="<%= EisUtil.RESOURCE_SEATING_DATA_LIST %>"> 
	
</portlet:resourceURL>



	
	<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-datatable,datatype-number">
	var A = AUI();
	
	
	A.all('select').on('change',function(){
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	var entryList = A.one('#<portlet:namespace/>entryList');
	var librarySelect = A.one('#<portlet:namespace/>library');
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	
	
	btnLoad.on('click',function(){
		
		
		var libraryId = librarySelect.get('value');
		var period =  A.one('#<portlet:namespace/>period').get('value');
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val('');
			
		});
		
		
		
		A.io.request('<%=loadItemURL.toString()%>', { 
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
                 		var inputId = obj.departmentId + '-' + obj.categoryId;
                 		var capacity = A.one('#<portlet:namespace/>'+ inputId );
                 		 
                 		 if (capacity)
                 		{
                 			capacity.val(obj.capacity);
                 		}
                 		
                 			 
                 	 });
                 	
                 	<%
            		if (isAdmin) {
		            %>
		            	var history = this.get('responseData').history;
		            	A.one('#history').html('');
		            	var columns = [
		            	               {key:'Bil'},
		            	               {key:'Pengguna'},
		            	               {key:'Tarikh'},
		            	               {key:'Kategori'},
		            	               {
		            	            	   key:'Kapasiti',
		            	            	   className:'numeric',
		 		            	        	  formatter: function(o){
		 		            	        		  
		 		            	        		  return A.Number.format(o.data.Kapasiti,
		 		            	        		  {
		 		            	        			  thousandsSeparator: "," 
		 		            	        		  })
		 		            	        		  
		 		            	        	  }
		            	            	   
		            	            	}
		            	               ];
		            	new A.DataTable(
		            		      {
		            		        columnset: columns,
		            		        recordset: history,
		            		     //   rowsPerPage: 10,
		            	          //  paginatorLocation: ['header', 'footer']
		            		      }
		            		    ).render('#history');
		            	A.one('#history table').addClass('table-bordered table-hover table-striped');

		            	 
		             
			    	<%
		             }
			    	%>
                 	
                 	 
                  }
            }
         });
		
		
		return;
	
	});
	

	</aui:script>

<%!
	private static Log LOGGER = LogFactoryUtil.getLog("html.fact.seating"); 
%>

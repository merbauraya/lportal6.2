<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	long itemTypeId = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ_INTER_LIB_LOAN);
	List<MasterFile> items = MasterFileLocalServiceUtil.findByTypeAndStatus1(itemTypeId, false);// .findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	int rowCount = items.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	int extra = rowCount % 3;
	int cur = 0;
	
	String headerTitle = LanguageUtil.get(pageContext, "interlib-loan");
	
%> 


<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>



<portlet:actionURL name="editInterLibLoan" var="actionURL">
	
</portlet:actionURL>



<aui:form name="fm" action="<%= actionURL %>">
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
		<%@include file="/html/fact/data_entry/interLibLoan.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>

	

</aui:form>


<portlet:resourceURL var="loadItemURL" id="<%= EisUtil.RESOURCE_INTER_LIB_LOAN %>">
	
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
	var selectInput = A.all(".selectInput");
	
	
	
	selectInput.on('change', function() {
		
		
		
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
                 		 var applyTotal = A.one('#<portlet:namespace/>'+ obj.ptjId +'-applyTotal');
                 		 var approvedTotal = A.one('#<portlet:namespace/>'+ obj.ptjId +'-approvedTotal');
                 		 
                 		 if (applyTotal)
                 		{
                 			applyTotal.val(obj.applyTotal);
                 		}
                 		 if (approvedTotal)
               			 {
                 			approvedTotal.val(obj.approvedTotal);
               			 }
                 		
                 			 
                 	 });
                 	
                 	<%
            		if (isAdmin) {
		            %>
		            	var history = this.get('responseData').history;
		            	
		            	A.one('#history').html('');
		            	
		            	//var columns = ['Bil','Pengguna','Tarikh','Kategori',
		            	              
		            	               
		            	             //  'Nilai'];
		            	var columns = [
		            	          {key: 'Bil',className:'numeric'},
		            	          {key:'Pengguna',width:'30%'},
		            	          {key:'Tarikh'},
		            	          {key:'PTJ',width:'30%'},
		            	          {
		            	        	  key:'Mohon',
		            	        	  
		            	        	  className:'numeric',
		            	        	  formatter: function(o){
		            	        		  
		            	        		  return A.Number.format(o.data.Mohon,
		            	        		  {
		            	        			  thousandsSeparator: "," 
		            	        		  })
		            	        		  
		            	        	  }
		            	        	},
		            	        	 {
			            	        	  key:'Status Berjaya',
			            	        	  
			            	        	  className:'numeric',
			            	        	  formatter: function(o){
			            	        		  
			            	        		  return A.Number.format(o.data['Status Berjaya'],
			            	        		  {
			            	        			  thousandsSeparator: "," 
			            	        		  })
			            	        		  
			            	        	  }
			            	        	},
		            	        
		            	          ];
		            	new A.DataTable(
		            		      {
		            		        columns: columns,
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
	
	
AUI().ready('event', 'node','node-event-simulate', function(A){
		
		console.log('zz');
		librarySelect.selectedIndex = 0;
		librarySelect.simulate('change');
	
		});

	</aui:script>

<%!
	private static Log LOGGER = LogFactoryUtil.getLog("html.fact.printedMaterial"); 
%>

<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	long reportId = ParamUtil.getLong(request, "reportId");
	Report dataReport = ReportLocalServiceUtil.fetchReport(reportId);  
	
	long itemTypeId =  dataReport.getDimensionId();//ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_IT_MANAGEMENT);
	List<MasterFile> items = MasterFileLocalServiceUtil.findByTypeAndStatus1(itemTypeId, false);// .findByMasterType(itemTypeId,QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	int rowCount = items.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	int extra = rowCount % 3;
	int cur = 0;
	
	String headerTitle = dataReport.getReportTitle();// .getReportName();//  LanguageUtil.get(pageContext, "it-management");
	
%> 




<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>



<portlet:actionURL name="editFactData" var="actionURL">
	
</portlet:actionURL> 



<aui:form name="fm" action="<%= actionURL %>">
	<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:input type="hidden" name="reportId" value="<%= reportId %>"/>
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
		<%@include file="/html/fact/data_entry/data.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>

	

</aui:form>


<portlet:resourceURL var="loadItemURL" id="<%= EisUtil.RESOURCE_FACT_DATA %>">
	
</portlet:resourceURL>



	
	<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-datatable,datatype-number">
	var A = AUI();
	var measure1Name = '<%= dataReport.getMeasure1Name()%>';
	
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
		var reportId =  A.one('#<portlet:namespace/>reportId').get('value');
		
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
		    	<portlet:namespace/>reportId : reportId
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData').data;
                	 
                	 
                 	A.Array.each(data, function(obj, idx){
                 		var measure1 = A.one('#<portlet:namespace/>'+ obj.dimensionId +'-measure1');
                 		var measure2 = A.one('#<portlet:namespace/>'+ obj.dimensionId +'-measure2');
                 		var measure3 = A.one('#<portlet:namespace/>'+ obj.dimensionId +'-measure3');
                 		var measure4 = A.one('#<portlet:namespace/>'+ obj.dimensionId +'-measure4');
                 		 if (measure1)
                 		{
                 			measure1.val(obj.measure1);
                 		}
                 		 if (measure2)
                  		{
                  			measure2.val(obj.measure2);
                  		}
                 		 if (measure3)
                  		{
                  			measure3.val(obj.measure3);
                  		}
                 		 if (measure4)
                  		{
                  			measure4.val(obj.measure4);
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
		            	          {key:'Dimension',label:'Kategori',width:'30%'},
		            	          {
		            	        	  key:'measure1',
		            	        	  label:'<%= dataReport.getMeasure1Name()%>',
		            	        	  className:'numeric',
		            	        	  formatter: function(o){
		            	        		  
		            	        		  return A.Number.format(o.data.measure1,
		            	        		  {
		            	        			  thousandsSeparator: "," 
		            	        		  })
		            	        		  
		            	        	  }
		            	        	},
		            	        	<c:if test="<%= dataReport.getHasMeasure2()%>">
		            	        	{
		            	        		key:'measure2',
			            	        	  label:'<%= dataReport.getMeasure2Name()%>',
			            	        	  className:'numeric',
			            	        	  formatter: function(o){
			            	        		  
			            	        		  return A.Number.format(o.data.measure2,
			            	        		  {
			            	        			  thousandsSeparator: "," 
			            	        		  })
			            	        		  
			            	        	  }
		            	        	},
		            	        	
		            	        	</c:if>
		            	        	<c:if test="<%= dataReport.getHasMeasure3()%>">
		            	        	{
		            	        		key:'measure2',
			            	        	  label:'<%= dataReport.getMeasure3Name()%>',
			            	        	  className:'numeric',
			            	        	  formatter: function(o){
			            	        		  
			            	        		  return A.Number.format(o.data.measure3,
			            	        		  {
			            	        			  thousandsSeparator: "," 
			            	        		  })
			            	        		  
			            	        	  }
		            	        	},
		            	        	
		            	        	</c:if>
		            	        	<c:if test="<%= dataReport.getHasMeasure4()%>">
		            	        	{
		            	        		key:'measure2',
			            	        	  label:'<%= dataReport.getMeasure4Name()%>',
			            	        	  className:'numeric',
			            	        	  formatter: function(o){
			            	        		  
			            	        		  return A.Number.format(o.data.measure4,
			            	        		  {
			            	        			  thousandsSeparator: "," 
			            	        		  })
			            	        		  
			            	        	  }
		            	        	},
		            	        	
		            	        	</c:if>
		            	        
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

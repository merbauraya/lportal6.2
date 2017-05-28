<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	
	List<MasterFile> faculties = MasterFileLocalServiceUtil.getAllFaculties();


	long acquistionItemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
	List<MasterFile> acquisitionItems = MasterFileLocalServiceUtil.findByTypeAndStatus5(acquistionItemType, true);
	
	
	int rowCount = acquisitionItems.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	
	int extra = rowCount % 3;
	int cur = 0;	
	String headerTitle = LanguageUtil.get(pageContext, "acquisition");

%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>
<portlet:actionURL name="editItemAcquisition" var="actionURL"> 
	
</portlet:actionURL>

<aui:form name="fm" action="<%= actionURL %>">
	<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:row>
		<aui:layout>
			
			<aui:col span="4">
				<aui:select name="faculty">
					<%
						for (MasterFile faculty : faculties)
						{
					%>
						<aui:option label="<%= faculty.getMasterFileName() %>" value="<%= faculty.getMasterFileId() %>" />
							
					<%
						}
					%>
				</aui:select>
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
					label="load" 
					icon="icon-refresh"
				/>
	
			</aui:col>
		</aui:layout>
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
		<%@include file="/html/fact/data_entry/acquisition.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>	

	
</aui:form>


<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_ACQUISTION_DATA %>">

</portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-datatable,datatype-number">
	var A = AUI();
	var facultySelect = A.one('#<portlet:namespace/>faculty');
	A.all('select').on('change',function(){
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	
	
	btnLoad.on('click',function(){
		
		
		
		
		
		var period =  A.one('#<portlet:namespace/>period').get('value');
		var facultyId = A.one('#<portlet:namespace/>faculty').get('value');
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val('');
			
		});
		
		
		A.io.request('<%=dataURL.toString()%>', { 
            method: 'get',
            dataType: 'json',
            data: {
		    	
            	
		    	<portlet:namespace/>period : period,
		    	<portlet:namespace/>facultyId : facultyId,
		    	
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData').data;
                	A.Array.each(data, function(obj, idx){
                		var inputId = obj.itemId ;
                		var volumeTotal = A.one('#<portlet:namespace/>'+ inputId +'-volume');
                		 var titleTotal = A.one('#<portlet:namespace/>'+ inputId +'-title');
                		 if (volumeTotal)
                		{
                			 volumeTotal.val(obj.volumeTotal);
                		}
                		 if (titleTotal)
                		{
                			titleTotal.val(obj.titleTotal);	 
                		}
                		
                			 
                	 });
                	
                	<%
            		if (isAdmin) {
		            %>
		            	var history = this.get('responseData').history;
		            	A.one('#history').html('');
		       
		            	var columns = [
		            	          {key: 'Bil',className:'numeric'},
		            	          {key:'Pengguna',width:'20%'},
		            	          {key:'Tarikh'},
		            	          {key:'Jenis Bahan',width:'20%'},
		            	          {key:'Medium',width:'10%'},
		            	          {
		            	        	  key:'Judul',
		            	        	  
		            	        	  className:'numeric',
		            	        	  formatter: function(o){
		            	        		  
		            	        		  return A.Number.format(o.data.Judul,
		            	        		  {
		            	        			  thousandsSeparator: "," 
		            	        		  })
		            	        		  
		            	        	  }
		            	        	},
		            	          {
		            	        	  key:'Naskah',
		            	        	  
		            	        	  className:'numeric',
		            	        	  formatter: function(o){
		            	        		  
		            	        		  return A.Number.format(o.data.Naskah,
		            	        		  {
		            	        			  thousandsSeparator: "," 
		            	        		  })
		            	        		  
		            	        	  }
		            	        	}
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
	

	</aui:script>
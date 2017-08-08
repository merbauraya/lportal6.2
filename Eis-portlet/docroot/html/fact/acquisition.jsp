<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	
	List<MasterFile> faculties = MasterFileLocalServiceUtil.getAllFaculties();


	long acquistionItemType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_ITEM_TYPE);
	List<MasterFile> acquisitionItems = MasterFileLocalServiceUtil.findByTypeAndStatus5(acquistionItemType, true);
	
	
	
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
			<eis:library-selector2
						adminAllowAll="<%= mLibraryAdminAllowAll %>"
					
					/> 
		</aui:col> 
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
			
			<aui:col span="2">
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
			<aui:col span="2">
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
		var libraryId = A.one('#<portlet:namespace/>library').get('value');
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
		    	<portlet:namespace/>libraryId : libraryId,
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData').data;
                	A.Array.each(data, function(obj, idx){
                		var inputId = obj.itemId ;
                		var volumeTotal = A.one('#<portlet:namespace/>' + inputId + '-volume');
                		var titleTotal = A.one('#<portlet:namespace/>' + inputId + '-title');
                		var amountTotal = A.one('#<portlet:namespace/>' + inputId + '-amount');

                		var approvedTitleTotal = A.one('#<portlet:namespace/>' + inputId + '-approvedTitleTotal');
                		var approvedVolumeTotal = A.one('#<portlet:namespace/>' + inputId + '-approvedVolumeTotal');
                		var approvedAmountTotal = A.one('#<portlet:namespace/>' + inputId + '-approvedAmountTotal');

                		var orderTitleTotal = A.one('#<portlet:namespace/>' + inputId + '-orderTitleTotal');
                		var orderVolumeTotal = A.one('#<portlet:namespace/>' + inputId + '-orderVolumeTotal');
                		var orderAmountTotal = A.one('#<portlet:namespace/>' + inputId + '-orderAmountTotal');
						//order
                		if (orderTitleTotal) {
                		    orderTitleTotal.val(obj.orderTitleTotal);
                		}
                		if (orderVolumeTotal) {
                		    orderVolumeTotal.val(obj.orderVolumeTotal);
                		}
                		if (orderAmountTotal) {
                			orderAmountTotal.val(obj.orderAmountTotal);
                		}
                		//approved
                		if (approvedTitleTotal) {
                		    approvedTitleTotal.val(obj.approvedTitleTotal);
                		}

                		if (approvedVolumeTotal) {
                		    approvedVolumeTotal.val(obj.approvedVolumeTotal);
                		}
                		if (approvedAmountTotal) {
                		    approvedAmountTotal.val(obj.approvedAmountTotal);
                		}
						//received
                		if (volumeTotal) {
                		    volumeTotal.val(obj.volumeTotal);
                		}
                		if (titleTotal) {
                		    titleTotal.val(obj.titleTotal);
                		}
                		if (amountTotal) {
                		    amountTotal.val(obj.amountTotal);
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
		            	          
		            	          {label:'Kelulusan Cadangan',
		            	        	children:[
									{
										  key:'Kelulusan Cadangan Judul',
										  label:'Judul',
										  className:'numeric',
										  formatter: function(o){
											  
											  return A.Number.format(o.data['Kelulusan Cadangan Judul'],
											  {
												  thousandsSeparator: "," 
											  })
											  
										  }
										},
									{
										  key:'Kelulusan Cadangan Naskah',
										  label:'Naskah',
										  className:'numeric',
										  formatter: function(o){
											  
											  return A.Number.format(o.data['Kelulusan Cadangan Naskah'],
											  {
												  thousandsSeparator: "," 
											  })
											  
										  }
										},
										{
									  	  key:'Kelulusan Cadangan Amaun',
									  	  label:'Amaun',
									  	  className:'numeric',
									  	  formatter: function(o){
									  		  
									  		  return A.Number.format(o.data['Kelulusan Cadangan Amaun'],
									  		  {
									  			  thousandsSeparator: ",",
									  			  decimalPlaces: 2
									  		  })
									  		  
									  	  }
									  	}
		            	        	          
		            	        	]  
		            	          },
		            	          {label:'Pesanan Pembelian',
			            	        	children:[
										{
											  key:'Pesanan Pembelian Judul',
											  label:'Judul',
											  className:'numeric',
											  formatter: function(o){
												  
												  return A.Number.format(o.data['Pesanan Pembelian Judul'],
												  {
													  thousandsSeparator: "," 
												  })
												  
											  }
											},
										{
											  key:'Pesanan Pembelian Naskah',
											  label:'Naskah',
											  className:'numeric',
											  formatter: function(o){
												  
												  return A.Number.format(o.data['Pesanan Pembelian Naskah'],
												  {
													  thousandsSeparator: "," 
												  })
												  
											  }
											},
											{
										  	  key:'Pesanan Pembelian Amaun',
										  	  label:'Amaun',
										  	  className:'numeric',
										  	  formatter: function(o){
										  		  
										  		  return A.Number.format(o.data['Pesanan Pembelian Amaun'],
										  		  {
										  			  thousandsSeparator: ",",
										  			  decimalPlaces: 2
										  		  })
										  		  
										  	  }
										  	}
			            	        	          
			            	        	]  
			            	          },
			            	          {label:'Penerimaan Pembelian',
				            	        	children:[
											{
												  key:'Penerimaan Judul',
												  label:'Judul',
												  className:'numeric',
												  formatter: function(o){
													  
													  return A.Number.format(o.data['Penerimaan Judul'],
													  {
														  thousandsSeparator: "," 
													  })
													  
												  }
												},
											{
												  key:'Penerimaan Naskah',
												  label:'Naskah',
												  className:'numeric',
												  formatter: function(o){
													  
													  return A.Number.format(o.data['Penerimaan Naskah'],
													  {
														  thousandsSeparator: "," 
													  })
													  
												  }
												},
												{
											  	  key:'Penerimaan Amaun',
											  	  label:'Amaun',
											  	  className:'numeric',
											  	  formatter: function(o){
											  		  
											  		  return A.Number.format(o.data['Penerimaan Amaun'],
											  		  {
											  			  thousandsSeparator: ",",
											  			  decimalPlaces: 2
											  		  })
											  		  
											  	  }
											  	}
				            	        	          
				            	        	]  
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
<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	//List<Library> libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());
	//long allocationTypeId = Long.parseLong(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_EXPENSE_ALLOCATION_TYPE));
	long itemTypeId = Long.parseLong(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.MASTER_DIGITAL_COLLECTION));
	
	//List<MasterFile> allocationTypes = MasterFileLocalServiceUtil.findByMasterType(allocationTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<MasterFile> digitalCollections =  MasterFileLocalServiceUtil.findByMasterType(itemTypeId,  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	String headerTitle = LanguageUtil.get(pageContext, "digital-collection");

%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>



<portlet:renderURL var="dataLoanlURL">
	<portlet:param name="mvcPath" value="/html/fact/digitalCollection.jsp"/>

</portlet:renderURL>



	
<portlet:actionURL name="editDigitalCollection" var="digitalCollectionURL"> 
	
</portlet:actionURL> 




 

<aui:form name="fm" action="<%= digitalCollectionURL %>">
		<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:row>
	<!-- 
	<aui:col span="6">
		<eis:library-selector2
					adminAllowAll="<%= mLibraryAdminAllowAll %>"
				
				/> 
	</aui:col> 
	-->
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
		<%@include file="/html/fact/data_entry/digitalCollection.jsp"%>
	
	</liferay-ui:section>
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>


	

</aui:form>

<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_DIGITAL_COLLECTION %>">

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
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	
	
	btnLoad.on('click',function(){
		
		
		var libraryId = 0;//librarySelect.get('value');
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
                	 var data=this.get('responseData').data;
                	A.Array.each(data, function(obj, idx){
                		
                		 var titleInput = A.one('#<portlet:namespace/>'+ obj.itemId +'-title');
                		 var volumeInput = A.one('#<portlet:namespace/>'+ obj.itemId +'-volume');
                		 var imageInput = A.one('#<portlet:namespace/>'+ obj.itemId +'-image');
                		 
                		 if (titleInput)
                		{
                			 titleInput.val(obj.title);
                		}
                		 if (volumeInput)
                 		{
                			 volumeInput.val(obj.volume);
                 		}
                		 if (imageInput)
                  		{
                			 imageInput.val(obj.image);
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
		            	          
		            	          {key:'Jenis'},
		            	          
		            	          {
		            	        	  key:'Judul',
		            	        	  
		            	        	  className:'numeric',
		            	        	  formatter: function(o){
		            	        		  
		            	        		  return A.Number.format(o.value,
		            	        		  {
		            	        			  thousandsSeparator: "," ,
		            	        			  decimalPlaces: 0
		            	        		  })
		            	        		  
		            	        	  }
		            	        	},
		            	        	{
			            	        	  key:'Naskah',
			            	        	  
			            	        	  className:'numeric',
			            	        	  formatter: function(o){
			            	        		  
			            	        		  return A.Number.format(o.value,
			            	        		  {
			            	        			  thousandsSeparator: "," ,
			            	        			  decimalPlaces: 0
			            	        		  })
			            	        		  
			            	        	  }
			            	        	},
			            	        	{
				            	        	  key:'Imej',
				            	        	  
				            	        	  className:'numeric',
				            	        	  formatter: function(o){
				            	        		  
				            	        		  return A.Number.format(o.value,
				            	        		  {
				            	        			  thousandsSeparator: "," ,
				            	        			  decimalPlaces: 0
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
	

	</aui:script>

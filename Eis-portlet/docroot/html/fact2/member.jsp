<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	List<Library> libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());
	List<MemberCategory> categories = MemberCategoryLocalServiceUtil.getMemberCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	int rowCount = categories.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	int extra = rowCount % 3;
	int cur = 0;
	String headerTitle = LanguageUtil.get(pageContext, "library-member");

%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
	
<liferay-ui:header
	backURL="<%= homeURL %>"
	
	title="<%= headerTitle %>"
/>



<portlet:renderURL var="dataLoanlURL">
	<portlet:param name="mvcPath" value="/html/fact/loan.jsp"/>

</portlet:renderURL>



	
<portlet:actionURL name="editMembership" var="editMembershipURL"> 
	
</portlet:actionURL>



 


<aui:form name="fm" action="<%= editMembershipURL %>">
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
		<%@include file="/html/fact/data_entry/member.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>

	

</aui:form>
 
<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_MEMBERSHIP_DATA %>">

</portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-datatable,datatype-number">
	var A = AUI();
	
	var librarySelect = A.one('#<portlet:namespace/>library');
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	
	
	
	A.all('select').on('change',function(){
			
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	
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
		            	A.one('#history').html('');
		            	
		            	//var columns = ['Bil','Pengguna','Tarikh','Kategori',
		            	              
		            	               
		            	             //  'Nilai'];
		            	var columns = [
		            	          {key: 'Bil',className:'numeric'},
		            	          {key:'Pengguna',width:'30%'},
		            	          {key:'Tarikh'},
		            	          {key:'Kategori',width:'30%'},
		            	          {
		            	        	  key:'Nilai',
		            	        	  
		            	        	  className:'numeric',
		            	        	  formatter: function(o){
		            	        		  console.log(o);
		            	        		  return A.Number.format(o.data.Nilai,
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

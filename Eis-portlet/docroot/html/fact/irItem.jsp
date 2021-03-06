<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	//List<Library> libraries  = null;
	List<MasterFile> libraries  = null;
	//PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker(); 
	/*
	if (permissionChecker.isOmniadmin() || permissionChecker.isCompanyAdmin())
	{
		//libraries = LibraryLocalServiceUtil.getLibraries(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		libraries = MasterFileLocalServiceUtil.getAllLibraries();
	}else
	{
		//libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());
		libraries = UserLibraryLocalServiceUtil.getLibraryByUser2(themeDisplay.getUserId());
	
	}
	*/
	long ptjTypeId  = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_PTJ_TYPE);
	List<MasterFile> ptjTypes = MasterFileLocalServiceUtil.findByMasterType(ptjTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	//List<Faculty> faculties = FacultyLocalServiceUtil.getFaculties(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	//List<MasterFile> faculties = MasterFileLocalServiceUtil.getAllFaculties();

	//List<ItemType> irTypes = ItemTypeLocalServiceUtil.getIRType(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
	List<MasterFile> irTypes = MasterFileLocalServiceUtil.getAllIrItem();
	//List<ItemMedium> mediums = ItemMediumLocalServiceUtil.getItemMediums(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<MasterFile> mediums = MasterFileLocalServiceUtil.getAllItemMediums();
	
	
	int rowCount = irTypes.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	
	int extra = rowCount % 3;
	int cur = 0;	
	String headerTitle = LanguageUtil.get(pageContext, "ir-item");
	long defaultPtjType = 0;

%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>
<portlet:actionURL name="editIrItem" var="actionURL"> 
	
</portlet:actionURL>

<aui:form name="fm" action="<%= actionURL %>">
	<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:row>
		<aui:layout>
			<aui:col span="3">
				<aui:select name="ptjType">
				<%
					
					for (MasterFile ptjType : ptjTypes)
					{
				%>
						<aui:option label="<%= ptjType.getMasterFileName() %>" value="<%= ptjType.getMasterFileId() %>" />
				<%		
					}
				%>
				</aui:select>
			</aui:col>
			<aui:col span="3">
				<aui:select name="faculty" cssClass="selectInput">
					
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
		<%@include file="/html/fact/data_entry/iritem.jsp"%>
	
	</liferay-ui:section>
	
	<c:if test="<%= isAdmin %>">
		<liferay-ui:section>
			 
			<div id="history">
			
			</div>
		
		</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>	

	
</aui:form>


<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_IR_ITEM %>">



</portlet:resourceURL>
<portlet:resourceURL var="ptjListURL" id="<%= EisUtil.RESOURCE_PTJ_BY_TYPE %>"/>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-datatable,datatype-number,node-event-simulate">
	var A = AUI();
	
	
	A.all('select').on('change',function(){
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	facultySelect = A.one('#<portlet:namespace/>faculty');
	var selectInput = A.all(".selectInput");
	
	selectInput.on('change', function() {
		
		

		
		var period =  A.one('#<portlet:namespace/>period').get('value');
		var facultyId = A.one('#<portlet:namespace/>faculty').get('value');
		//console.log("facultyId="+facultyId + " period="+ period);
		var libraryId = 0;
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val('');
			
		});
		
		
		A.io.request('<%=dataURL.toString()%>', { 
            method: 'get',
            dataType: 'json',
            data: {
		    	
            	<portlet:namespace/>library : libraryId,
		    	<portlet:namespace/>period : period,
		    	<portlet:namespace/>faculty : facultyId,
		    	
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData').data;
                	A.Array.each(data, function(obj, idx){
                		var inputId = obj.itemTypeId + '-' + obj.itemMediumId;
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
		            	          {key:'Jenis Bahan',width:'30%'},
		            	          
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
	
	
	
	var ptjTypeSelect = A.one("#<portlet:namespace/>ptjType");
	ptjTypeSelect.on('change', function() 
	{
    	A.io.request('<%= ptjListURL.toString()%>', 
          {

              method: 'POST',
              data: {
                  "<portlet:namespace/>ptjTypeId": ptjTypeSelect.val()
                      

                  },

                  dataType: 'json',
                  on: {
                      success: function() {
                          var ptjList = this.get('responseData'); 

                          A.one('#<portlet:namespace />faculty').empty();
                          var selectedValue = '';
                          //using for loop we iterating the list
                          for (var i in ptjList) {
							 //set default to first item
							 var selected = '';
							 selectedValue = '';
							 if (i == 0)
							 {
							 	selected = 'selected';
							 	selectedValue = ptjList[i].masterFileId;
							 	
							 }
                              A.one('#<portlet:namespace />faculty').append("<option  value='" + ptjList[i].masterFileId + "' " + selected + ">" + ptjList[i].masterFileName + "</option> ");
                          }
                          //A.one('#<portlet:namespace />faculty').val(selectedValue);
                          facultySelect.simulate('change');

                      }
                  }

              });
                    
	});
	
	var selectPeriod = A.one('#<portlet:namespace />period');
	
	AUI().ready('event', 'node','node-event-simulate', function(A){
		
		ptjTypeSelect.selectedIndex = 0;
		ptjTypeSelect.simulate('change');
		//selectFaculty.prop("selectedIndex", 0);
		//selectFaculty.selectedIndex = 0;
		//console.log(selectFaculty);
		//selectPeriod.simulate('change');
		});
	
	

	</aui:script>
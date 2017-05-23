<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	List<Library> libraries  = null;
	
	//PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker(); 
	
	if (permissionChecker.isOmniadmin() || permissionChecker.isCompanyAdmin())
	{
		libraries = LibraryLocalServiceUtil.getLibraries(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	}else
	{
		libraries = UserLibraryLocalServiceUtil.getLibraryByUser(themeDisplay.getUserId());

	}
	
	List<Faculty> faculties = FacultyLocalServiceUtil.getFaculties(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	List<ItemMedium> mediums = ItemMediumLocalServiceUtil.getItemMediums(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	int rowCount = mediums.size();
	int rowSize = (int)Math.floor(rowCount/3);
	
	
	int extra = rowCount % 3;
	int cur = 0;	
	String headerTitle = LanguageUtil.get(pageContext, "ir-submission");

%> 

<portlet:renderURL var="homeURL">
		<portlet:param name="jspPage" value="/html/view.jsp"/>
	</portlet:renderURL>
<liferay-ui:header
		backURL="<%= homeURL %>"
		
		title="<%= headerTitle %>"
	/>
<portlet:actionURL name="editIrSubmission" var="actionURL"> 
	
</portlet:actionURL>

<aui:form name="fm" action="<%= actionURL %>">
	<aui:input name="redirect" value="<%= currentURL %>" type="hidden"></aui:input>
	<aui:row>
		<aui:layout>
			<aui:col span="4">
				<eis:library-selector
					adminAllowAll="<%= mLibraryAdminAllowAll %>"
				
				/>
			</aui:col>
			<aui:col span="4">
				<aui:select name="faculty">
					<%
						for (Faculty faculty : faculties)
						{
					%>
						<aui:option label="<%= faculty.getFacultyName() %>" value="<%= faculty.getFacultyId() %>" />
							
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col span="4">
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
		</aui:layout>
	</aui:row>
	<aui:button type="button" 
			name="loadList" 
			label="load" 
			icon="icon-refresh"
/>
<hr/>
	<aui:row>
		<aui:layout>
			<aui:col span="4" cssClass="col-separator multiColInput ">
		<%

		
		
			for (cur = 0; cur < rowSize + extra; cur++)
			{
				ItemMedium medium = mediums.get(cur); 
				String volumeName = medium.getItemMediumId() + "-volume"; 
				String titleName =  medium.getItemMediumId() + "-title"; 
		%>
		<aui:layout cssClass="item-data-cont ">
			<aui:row cssClass="item-title-cont">
				<span class="item-title"><%= medium.getItemMediumName() %></span>
			</aui:row>
			<aui:row>
				<div class="data-cont">
					<aui:col width="50">
						<aui:input cssClass="dataInput" name="<%= titleName %>" label="p-title" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input cssClass="dataInput" name="<%= volumeName %>" label="p-volume" >
							<aui:validator name="digits"></aui:validator>
						</aui:input>
					</aui:col>
				</div>
			</aui:row>
		</aui:layout>
		<%
			}
		%>
			</aui:col>
			<c:if test="<%= cur < rowCount-1 %>">
				
				<aui:col span="4" cssClass="col-separator multiColInput">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							ItemMedium medium = mediums.get(cur); 
							String volumeName = medium.getItemMediumId() + "-volume"; 
							String titleName =  medium.getItemMediumId() + "-title"; 

							i++;
					%>
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont">
								<span class="item-title"><%= medium.getItemMediumName() %></span>
							</aui:row>
							<aui:row>
								<div class="data-cont">
									<aui:col width="50">
										<aui:input cssClass="dataInput" name="<%= titleName %>" label="title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input cssClass="dataInput" name="<%= volumeName %>" label="volume">
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
								</div>
							</aui:row>
						</aui:layout>
					
					<%
						}
					
					%>
				</aui:col>
			
			</c:if>
			<c:if test="<%= cur < rowCount %>">
			<aui:col span="4" cssClass="col-separator multiColInput ">
					<%
						
						for (int i = 0 ; i < rowSize  ; cur++)
						{
							ItemMedium medium = mediums.get(cur); 
							String volumeName = medium.getItemMediumId() + "-volume"; 
							String titleName =  medium.getItemMediumId() + "-title"; 

							i++;
					%>
						
						<aui:layout cssClass="item-data-cont ">
							<aui:row cssClass="item-title-cont ">
								<span class="item-title"><%= medium.getItemMediumName() %></span>
							</aui:row>
							<aui:row>
								<div class="data-cont">
								
									<aui:col width="50">
										<aui:input cssClass="dataInput " name="<%= titleName %>" label="title" >
											<aui:validator name="digits"></aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input cssClass="dataInput " name="<%= volumeName %>" label="volume">
											<aui:validator name="number"></aui:validator>
										</aui:input>
									</aui:col>
								</div>
							</aui:row>
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


<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_IR_SUBMISSION_DATA %>">

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
		var facultyId = A.one('#<portlet:namespace/>faculty').get('value');
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
		    	<portlet:namespace/>facultyId : facultyId,
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData');
                	A.Array.each(data, function(obj, idx){
                		var volumeTotal = A.one('#<portlet:namespace/>'+ obj.id +'-volume');
                		 var titleTotal = A.one('#<portlet:namespace/>'+ obj.id +'-title');
                		 if (volumeTotal)
                		{
                			 volumeTotal.val(obj.volumeTotal);
                		}
                		 if (titleTotal)
                		{
                			titleTotal.val(obj.titleTotal);	 
                		}
                		
                			 
                	 });
                	 
                 }
            }
         });
		
		
		return;
	
	});
	

	</aui:script>
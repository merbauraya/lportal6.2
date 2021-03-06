<%@ include file="/html/init.jsp" %>


<portlet:resourceURL var="resourceURL" id="libraryList">
	
</portlet:resourceURL>

<%

	List<User> users =   UserLocalServiceUtil.getUserGroupUsers(themeDisplay.getScopeGroupId(), , int end);


%>

<aui:select name="state">
	<aui:option value="0" selected="<%= true %>">Select State</aui:option>
	<%
		long stateType = ConfigLocalServiceUtil.getKeyAsLong(EisUtil.MASTER_STATE);
		for (MasterFile state : MasterFileLocalServiceUtil.findByMasterType(stateType,QueryUtil.ALL_POS, QueryUtil.ALL_POS))
		{
	%>
			<aui:option label="<%= state.getMasterFileName() %>" value="<%= state.getMasterFileId() %>" />

	<%
		}
	%>
	
</aui:select>


<div id="<portlet:namespace/>libraryList">
</div>





<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node">
	var A = AUI();
	var stateSelect = A.one('#<portlet:namespace/>state');
	var librarySelect = A.one('#<portlet:namespace/>library');
	var libraryList = A.one('#<portlet:namespace/>libraryList');
	
	
	
	
	
	stateSelect.on('change', function() {
		var stateId = stateSelect.get('value');
		
		libraryList.unplug(A.Plugin.IO); 
		
		if(libraryList) {
			
			libraryList.plug(
				A.Plugin.IO,
				{
				    //autoLoad: false,
				    uri: "<%=resourceURL%>",
				    method: 'GET',
				    data: {
				    	<portlet:namespace/>stateId : stateId,
				    }
				    
				}
			);
			        //console.log("calling resource..");
			        //console.log(libraryList);
		            //libraryList.io.set('uri', "<%=resourceURL%>"); 
		            //libraryList.io.start();
		            
			       
		}          
		
		return;
		
        
    });



</aui:script>
<%@ include file="/html/init.jsp" %>


<%
	long masterFileId = ParamUtil.getLong(request, "masterFileId");
	long masterTypeId = ParamUtil.getLong(request, "masterTypeId");
	MasterType masterType = MasterTypeLocalServiceUtil.fetchMasterType(masterTypeId);
	String masterTypeName = StringPool.BLANK;
	MasterFile masterFile = null;
	if (Validator.isNotNull(masterFileId))
	{
		masterFile = MasterFileLocalServiceUtil.fetchMasterFile(masterFileId);
		
	}
	
	
%>

<portlet:actionURL var="editURL" name="editMasterFile">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(masterFile) %>">
		<h4>Add <%= masterType.getPageLabel() %></h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit <%= masterType.getPageLabel() %></h4>
	</c:otherwise>

</c:choose>
<%
	List<MasterFile> parent1 = null;
	List<MasterFile> parent2 = null;
	if (masterType.getHasParent1())
	{
		 parent1 = MasterFileLocalServiceUtil.findByMasterType(masterType.getParentId1(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	if (masterType.getHasParent2())
	{
		 parent2 = MasterFileLocalServiceUtil.findByMasterType(masterType.getParentId2(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	
	boolean status1 = false;
	boolean status2 = false;
	boolean status3 = false;
	boolean status4 = false;
	boolean status5 = false;
	long parent1Id = 0;
	long parent2Id = 0;
	
	if (Validator.isNotNull(masterFile))
	{
		status1 = masterFile.getStatus1();
		status2 = masterFile.getStatus2();
		status3 = masterFile.getStatus3();
		status4 = masterFile.getStatus4();
		status5 = masterFile.getStatus5();
		parent1Id = masterFile.getParentId1();
		parent2Id = masterFile.getParentId2();
	}

	

%>


<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= masterFile %>" model="<%= MasterFile.class %>" />
	
	<aui:fieldset>
		<aui:input name="masterTypeId" type="hidden" value="<%= masterTypeId %>" />
		<aui:input name="masterFileId" type="hidden" />
		
		<aui:input name="masterFileName" label="<%= masterType.getNameLabel() %>">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		
		<aui:input name="inActive" type="checkbox" label="not-active"/>
		<c:if test="<%= masterType.getHasParent1() %>">
			<aui:select name="parent1" label="<%= masterType.getParent1Label() %>">
				<%
					for (MasterFile fParent : parent1)
					{
						boolean selected = fParent.getMasterFileId() == parent1Id;
				%>
						<aui:option value="<%= fParent.getMasterFileId() %>"
							selected="<%= selected %>"
						>
							
						
						<%= fParent.getMasterFileName() %> 
						
						</aui:option>
				<%						
					}
				%>
			</aui:select>
		
			
		</c:if>
		
		<c:if test="<%= masterType.getHasParent2() %>">
			<aui:select name="parent2" label="<%= masterType.getParent2Label() %>">
				<%
					for (MasterFile fParent : parent2)
					{
						boolean selected = fParent.getMasterFileId() == parent2Id;

				%>
						<aui:option value="<%= fParent.getMasterFileId() %>"
							selected="<%= selected %>"
						
						><%= fParent.getMasterFileName() %> 
						
						</aui:option>
				<%						
					}
				%>
			</aui:select>
		
			
		</c:if>
		
		<c:if test="<%= masterType.getHasStatus1() %>">
			
			<aui:input value="<%= status1 %>" 
				type="checkbox" 
				name="status1" 
				label="<%= masterType.getStatus1Label() %>"> 
			</aui:input>
		
		
		</c:if>
		<c:if test="<%= masterType.getHasStatus2() %>">
			
			<aui:input value="<%= status2 %>" 
				type="checkbox" 
				name="status2" 
				label="<%= masterType.getStatus2Label() %>"> 
			</aui:input>
		
		
		</c:if>
		<c:if test="<%= masterType.getHasStatus3() %>">
			
			<aui:input value="<%= status3 %>" 
				type="checkbox" 
				name="status3" 
				label="<%= masterType.getStatus3Label() %>"> 
			</aui:input>
		
		
		</c:if>
		<c:if test="<%= masterType.getHasStatus4() %>">
			
			<aui:input value="<%= status4 %>" 
				type="checkbox" 
				name="status4" 
				label="<%= masterType.getStatus4Label() %>"> 
			</aui:input>
		
		
		</c:if>
		<c:if test="<%= masterType.getHasStatus5() %>">
			
			<aui:input value="<%= status5 %>" 
				type="checkbox" 
				name="status5" 
				label="<%= masterType.getStatus5Label() %>"> 
			</aui:input>
		
		
		</c:if>
		
		<c:if test="<%= masterType.getHasCode() %>">
			
			<aui:input 
				
				name="masterCode" 
				label="<%= masterType.getCodeLabel() %>"> 
			</aui:input>
		
		
		</c:if>
		
		
	
	
	
	</aui:fieldset>
</aui:form>
	<aui:button-row>
			<aui:button primary="<%= true %>" name="saveForm" type="button" value="Save"  />
			<aui:button name="closeDialog" type="cancel"/>
		</aui:button-row>

<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>saveForm').on('click', function(event) {
        var A = AUI();
        var url = '<%=editURL.toString()%>'; 
        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>fm'},
                on: {
                    success: function() {
                        Liferay.Util.getOpener().refreshPortlet();
                        Liferay.Util.getOpener().closePopup('<portlet:namespace/>dialog');
                    }
                }
            }
        );
    });
    
   
</aui:script>

<aui:script use="aui-base" >
	var A = AUI();
	A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
    	Liferay.Util.getOpener().closePopup('<portlet:namespace/>dialog');
});

</aui:script>


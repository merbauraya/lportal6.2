<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.eis.model.impl.MasterTypeImpl" %>


<%
	long masterTypeId = ParamUtil.getLong(request, "masterTypeId");
	String masterTypeName = StringPool.BLANK;
	MasterType masterType = null; 
	
	if (Validator.isNotNull(masterTypeId))
	{
		masterType = MasterTypeLocalServiceUtil.fetchMasterType(masterTypeId) ;
		
	}else
	{
		masterType = new MasterTypeImpl();
	}
	
%>

<portlet:actionURL var="editURL" name="editMasterType">
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(masterType) %>">
		<h4>Add Master Type</h4>
	</c:when>
	
	<c:otherwise>
		<h4>Edit Master Type</h4>
	</c:otherwise>

</c:choose>

<%
	List<MasterType> parentTypes = MasterTypeLocalServiceUtil.getAllParentType(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= masterType %>" model="<%= MasterType.class %>" />
	
	<aui:fieldset>
		<aui:input name="masterTypeId" type="hidden" value="<%= masterTypeId %>" />
		
		
		<aui:input name="masterTypeName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:input name="pageLabel">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:input name="nameLabel">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:input name="parentType" type="checkbox" value="<%= masterType.getParentType() %>"/>
		
		<aui:fieldset>
			<aui:input name="hasParent1" type="checkbox" value="<%= masterType.getHasParent1() %>"/>
			<div class="" id="<portlet:namespace />parent1Config">
				<aui:input name="parent1Label"/>
				
				<aui:select name="parent1">
				<%
					for (MasterType parent : parentTypes)
					{
						boolean selected = false;
						if (Validator.isNotNull(masterType))
						{
							if (masterType.getParentId1() == parent.getMasterTypeId())
								selected = true;
						}
				%>
						<aui:option selected ="<%= selected %>" value="<%= parent.getMasterTypeId() %>"><%= parent.getMasterTypeName() %></aui:option>
				
				<%						
					}
				%>
				
				</aui:select>
			
			</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasParent2" type="checkbox" value="<%= masterType.getHasParent2() %>" />
			<div class="" id="<portlet:namespace />parent2Config">
				<aui:input name="parent2Label"/>
				
				<aui:select name="parent2">
				<%
					for (MasterType parent : parentTypes)
					{
						boolean selected = false;
						if (Validator.isNotNull(masterType))
						{
							if (masterType.getParentId2() == parent.getMasterTypeId())
								selected = true;
						}
				%>
						<aui:option selected ="<%= selected %>" value="<%= parent.getMasterTypeId() %>"><%= parent.getMasterTypeName() %></aui:option>
				
				<%						
					}
				%>
				
				</aui:select>
			
			</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasStatus1" type="checkbox" value="<%= masterType.getHasStatus1() %>"/>
			<div class="" id="<portlet:namespace />hasStatus1Config">
				<aui:input name="status1Label"/>
				
				
				
				
			
			</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasStatus2" type="checkbox" value="<%= masterType.getHasStatus2() %>"/>
			<div class="" id="<portlet:namespace />hasStatus2Config">
				<aui:input name="status2Label"/>
				
				
				
				
			
			</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasStatus3" type="checkbox" value="<%= masterType.getHasStatus3() %>"/>
			<div class="" id="<portlet:namespace />hasStatus3Config">
				<aui:input name="status3Label"/>
				
				
				
				
			
			</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasStatus4" type="checkbox" value="<%= masterType.getHasStatus4() %>"/>
			<div class="" id="<portlet:namespace />hasStatus4Config">
				<aui:input name="status4Label"/>
				
				
				
				
			
			</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasCode" type="checkbox" value="<%= masterType.getHasCode() %>"/>
			<div class="" id="<portlet:namespace />hasCodeConfig">
				<aui:input name="codeLabel"/>
				
				
				
				
			
			</div>
		
		</aui:fieldset>
	
		
	
	
	
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
	
	Liferay.Util.toggleBoxes('<portlet:namespace />hasParent1Checkbox','<portlet:namespace />parent1Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasParent2Checkbox','<portlet:namespace />parent2Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasStatus1Checkbox','<portlet:namespace />hasStatus1Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasStatus2Checkbox','<portlet:namespace />hasStatus2Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasStatus3Checkbox','<portlet:namespace />hasStatus3Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasStatus4Checkbox','<portlet:namespace />hasStatus4Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasCodeCheckbox','<portlet:namespace />hasCodeConfig');
</aui:script>


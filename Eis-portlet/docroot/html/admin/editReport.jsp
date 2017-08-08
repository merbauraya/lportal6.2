<%@ include file="/html/init.jsp" %>
 <%@ page import="com.idetronic.eis.model.impl.ReportImpl" %>

<%
	long reportId = ParamUtil.getLong(request, "reportId");
	Report report = null; 
	
	if (Validator.isNotNull(reportId))
	{
		report = ReportLocalServiceUtil.fetchReport(reportId);
	} else
	{
		report = new ReportImpl();
	}
	
%>

<portlet:actionURL var="editURL" name="editReport">  
	
</portlet:actionURL>
<c:choose>
	<c:when test="<%= Validator.isNull(report) %>">
		<h4>Tambah Laporan </h4>
	</c:when>
	
	<c:otherwise>
		<h4>Pinda Laporan </h4>
	</c:otherwise>

</c:choose>



<aui:form action="<%=editURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "submitForm(); event.preventDefault();" %>'>
	<aui:model-context bean="<%= report %>" model="<%= Report.class %>" />
	
	<aui:fieldset>
		<aui:input name="reportId" type="hidden" value="<%= reportId %>" />
		
		<aui:input name="reportKey"  />
		<aui:input name="reportTitle" label="report-display-title" cssClass="fullWidth"/>
		
		<aui:input name="dataEntry" label='has-data-entry'/>
		<aui:input name="hqDataEntry" label="hq-data-entry"></aui:input>
		
		
		<%
			List<MasterType> masterTypes = MasterTypeLocalServiceUtil.getMasterTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		%>
		<aui:select name="dimensionId" label="p-dimension">
			<%
				for (MasterType masterType : masterTypes)
				{
					boolean selected = (report.getDimensionId() == masterType.getMasterTypeId());
					
			%>
				 
				 <aui:option selected="<%= selected %>" label="<%= masterType.getMasterTypeName() %>" value="<%= masterType.getMasterTypeId() %>" />
				 
			<%
				}
			%>
		</aui:select>
		
		
			<aui:input name="hasMeasure1" type="checkbox" value="<%= report.getHasMeasure1() %>"/>
			<div class="" id="<portlet:namespace />hasMeasure1Config">
				<aui:input name="measure1Name"/>
		</div>
		
		
		<aui:fieldset>
			<aui:input name="hasMeasure2" type="checkbox" value="<%= report.getHasMeasure2() %>"/>
			<div class="" id="<portlet:namespace />hasMeasure2Config">
				<aui:input name="measure2Name"/>
		</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasMeasure3" type="checkbox" value="<%= report.getHasMeasure3() %>"/>
			<div class="" id="<portlet:namespace />hasMeasure3Config">
				<aui:input name="measure3Name"/>
		</div>
		
		</aui:fieldset>
		<aui:fieldset>
			<aui:input name="hasMeasure4" type="checkbox" value="<%= report.getHasMeasure4() %>"/>
			<div class="" id="<portlet:namespace />hasMeasure4Config">
				<aui:input name="measure4Name"/>
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
	
	Liferay.Util.toggleBoxes('<portlet:namespace />hasMeasure1Checkbox','<portlet:namespace />hasMeasure1Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasMeasure2Checkbox','<portlet:namespace />hasMeasure2Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasMeasure3Checkbox','<portlet:namespace />hasMeasure3Config');
	Liferay.Util.toggleBoxes('<portlet:namespace />hasMeasure4Checkbox','<portlet:namespace />hasMeasure4Config');
</aui:script>


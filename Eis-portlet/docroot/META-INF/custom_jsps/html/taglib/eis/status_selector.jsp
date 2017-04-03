<%@ include file="/html/taglib/eis/init.jsp" %>


<%
	
	int status = ((Integer)request.getAttribute("eis:status-selector:status"));
	
	

	String controlName =(String)request.getAttribute("eis:status-selector:controlName");
	if (Validator.isNull(controlName))
	{
		controlName = "status";
	}
	
	
	


%>
<aui:input type="hidden" name="<%= controlName %>" value="<%= status %>"/>
<div class="control-group htmlStatus" >
	<label class="control-label">Petunjuk Status</label>
	<table>
		<tr>
			<td class="status status-blue <%= status==0 ? "" : "disabled" %>" statusId="0"></td>
			<td class="status status-red <%= status==1 ? "" : "disabled" %>" statusId="1"></td>
			<td class="status status-yellow <%= status == 2 ? "" : "disabled" %>" statusId="2"></td>
			<td class="status status-green <%= status == 3 ? "" : "disabled" %>" statusId="3"></td>
		</tr>
	</table>
</div>
<aui:script  use="aui-base">
	var A = AUI();
	
	A.all(".htmlStatus  td").on('click',function(e){
	 
	 var statusId= e.currentTarget.attr("statusId")
	 
	 A.one('#<portlet:namespace/><%=controlName%>').set('value',statusId);
	 
	 //A.all('.htmlStatus  td').removeClass('disabled');
	 A.all('.htmlStatus  td').addClass('disabled');
	 e.currentTarget.removeClass('disabled');
	})


</aui:script>
